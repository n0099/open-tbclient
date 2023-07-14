package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.cv2;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public abstract class SwanAppLoginAndGetMobileDialog extends DialogFragment {
    public b a;
    public FragmentActivity b;
    public LinearLayout d;
    public QuickLoginInfo f;
    public String h;
    public String i;
    public boolean c = false;
    public String e = "";
    public boolean g = true;

    /* loaded from: classes4.dex */
    public interface b {
        void onLoginResult(int i);

        void x0(boolean z);
    }

    public abstract void J1();

    public abstract void K1(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    public abstract void R1();

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 4) {
                SwanAppLoginAndGetMobileDialog.this.O1(true);
                SwanAppLoginAndGetMobileDialog.this.I1();
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends ClickableSpan {
        public WeakReference<Activity> a;
        public String b;

        public c(String str, Activity activity) {
            this.b = str;
            this.a = new WeakReference<>(activity);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Activity activity = this.a.get();
            if (activity == null) {
                return;
            }
            Intent intent = new Intent(activity, LoginServiceAgreementActivity.class);
            intent.putExtra("url", this.b);
            activity.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor("#3388FF"));
        }
    }

    public void I1() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.x0(this.g);
        }
        dismissAllowingStateLoss();
    }

    public final void M1() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.e = arguments.getString("auth_tip");
            this.c = arguments.getBoolean("is_night");
            this.f = (QuickLoginInfo) arguments.getParcelable("quick_login_info");
            this.h = arguments.getString("launch_from");
            this.i = arguments.getString("app_id");
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        b bVar = this.a;
        if (bVar != null) {
            bVar.x0(this.g);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        boolean a2 = cv2.M().a();
        if (a2 != this.c) {
            L1(a2);
        }
    }

    public void H1(SpannableStringBuilder spannableStringBuilder, int i, String str, String str2) {
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new c(str2, this.b), i, spannableStringBuilder.length(), 33);
    }

    public void L1(boolean z) {
        int i;
        this.c = z;
        Window window = getDialog().getWindow();
        if (window != null) {
            Resources resources = getContext().getResources();
            if (this.c) {
                i = R.drawable.obfuscated_res_0x7f0801b4;
            } else {
                i = R.drawable.obfuscated_res_0x7f0801b3;
            }
            window.setBackgroundDrawable(resources.getDrawable(i));
        }
        R1();
    }

    public void N1(FragmentActivity fragmentActivity) {
        this.b = fragmentActivity;
    }

    public void O1(boolean z) {
        this.g = z;
    }

    public void P1(b bVar) {
        this.a = bVar;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        I1();
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.x0(this.g);
        }
        super.onDismiss(dialogInterface);
    }

    public final void Q1(Window window) {
        int i;
        Resources resources = getContext().getResources();
        if (this.c) {
            i = R.drawable.obfuscated_res_0x7f0801b4;
        } else {
            i = R.drawable.obfuscated_res_0x7f0801b3;
        }
        window.setBackgroundDrawable(resources.getDrawable(i));
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setFlags(32, 32);
        window.setFlags(262144, 262144);
        window.getDecorView().setOnTouchListener(new a());
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        M1();
        getDialog().requestWindowFeature(1);
        getDialog().setCanceledOnTouchOutside(true);
        Window window = getDialog().getWindow();
        if (window == null) {
            return null;
        }
        Q1(window);
        K1(layoutInflater, viewGroup);
        R1();
        J1();
        return this.d;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException unused) {
        }
    }
}
