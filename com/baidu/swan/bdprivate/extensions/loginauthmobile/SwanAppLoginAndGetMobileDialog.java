package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
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
import com.xiaomi.mipush.sdk.Constants;
import d.b.g0.b.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public abstract class SwanAppLoginAndGetMobileDialog extends DialogFragment {

    /* renamed from: e  reason: collision with root package name */
    public b f12714e;

    /* renamed from: f  reason: collision with root package name */
    public FragmentActivity f12715f;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f12717h;
    public QuickLoginInfo j;
    public String l;
    public String m;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12716g = false;
    public String i = "";
    public boolean k = true;

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 4) {
                SwanAppLoginAndGetMobileDialog.this.L0(true);
                SwanAppLoginAndGetMobileDialog.this.F0();
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onDialogDismiss(boolean z);

        void onLoginResult(int i);
    }

    /* loaded from: classes3.dex */
    public static class c extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f12719e;

        /* renamed from: f  reason: collision with root package name */
        public String f12720f;

        public c(String str, Activity activity) {
            this.f12720f = str;
            this.f12719e = new WeakReference<>(activity);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activity = this.f12719e.get();
            if (activity == null) {
                return;
            }
            Intent intent = new Intent(activity, LoginServiceAgreementActivity.class);
            intent.putExtra("url", this.f12720f);
            activity.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor("#3388FF"));
        }
    }

    public void E0(SpannableStringBuilder spannableStringBuilder, int i, String str, String str2) {
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new c(str2, this.f12715f), i, spannableStringBuilder.length(), 33);
    }

    public void F0() {
        b bVar = this.f12714e;
        if (bVar != null) {
            bVar.onDialogDismiss(this.k);
        }
        dismissAllowingStateLoss();
    }

    public abstract void G0();

    public abstract void H0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    public void I0(boolean z) {
        this.f12716g = z;
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(getContext().getResources().getDrawable(this.f12716g ? d.aiapps_login_getmobile_dark_bg : d.aiapps_login_getmobile_bg));
        }
        O0();
    }

    public final void J0() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.i = arguments.getString("auth_tip");
            this.f12716g = arguments.getBoolean("is_night");
            this.j = (QuickLoginInfo) arguments.getParcelable("quick_login_info");
            this.l = arguments.getString("launch_from");
            this.m = arguments.getString(Constants.APP_ID);
        }
    }

    public void K0(FragmentActivity fragmentActivity) {
        this.f12715f = fragmentActivity;
    }

    public void L0(boolean z) {
        this.k = z;
    }

    public void M0(b bVar) {
        this.f12714e = bVar;
    }

    public final void N0(Window window) {
        window.setBackgroundDrawable(getContext().getResources().getDrawable(this.f12716g ? d.aiapps_login_getmobile_dark_bg : d.aiapps_login_getmobile_bg));
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

    public abstract void O0();

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        F0();
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        J0();
        getDialog().requestWindowFeature(1);
        getDialog().setCanceledOnTouchOutside(true);
        Window window = getDialog().getWindow();
        if (window == null) {
            return null;
        }
        N0(window);
        H0(layoutInflater, viewGroup);
        O0();
        G0();
        return this.f12717h;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        b bVar = this.f12714e;
        if (bVar != null) {
            bVar.onDialogDismiss(this.k);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        b bVar = this.f12714e;
        if (bVar != null) {
            bVar.onDialogDismiss(this.k);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        boolean a2 = d.b.g0.a.w0.a.z().a();
        if (a2 != this.f12716g) {
            I0(a2);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException unused) {
        }
    }
}
