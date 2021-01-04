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
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public abstract class SwanAppLoginAndGetMobileDialog extends DialogFragment {
    protected QuickLoginInfo dWP;
    protected String dWQ;
    protected a dWW;
    protected FragmentActivity dWX;
    protected String mAppId;
    protected LinearLayout mRootView;
    protected boolean dAP = false;
    protected String dWN = "";
    private boolean dWY = true;

    /* loaded from: classes9.dex */
    public interface a {
        void hL(boolean z);

        void me(int i);
    }

    protected abstract void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    protected abstract void aTj();

    protected abstract void updateUI();

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    public void a(FragmentActivity fragmentActivity) {
        this.dWX = fragmentActivity;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        asx();
        getDialog().requestWindowFeature(1);
        getDialog().setCanceledOnTouchOutside(true);
        Window window = getDialog().getWindow();
        if (window == null) {
            return null;
        }
        c(window);
        a(layoutInflater, viewGroup);
        updateUI();
        aTj();
        return this.mRootView;
    }

    private void c(Window window) {
        window.setBackgroundDrawable(getContext().getResources().getDrawable(this.dAP ? b.d.aiapps_login_getmobile_dark_bg : b.d.aiapps_login_getmobile_bg));
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setFlags(32, 32);
        window.setFlags(262144, 262144);
        window.getDecorView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 4) {
                    SwanAppLoginAndGetMobileDialog.this.hM(true);
                    SwanAppLoginAndGetMobileDialog.this.aTk();
                }
                return true;
            }
        });
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    public void hM(boolean z) {
        this.dWY = z;
    }

    private void asx() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dWN = arguments.getString("auth_tip");
            this.dAP = arguments.getBoolean("is_night");
            this.dWP = (QuickLoginInfo) arguments.getParcelable("quick_login_info");
            this.dWQ = arguments.getString("launch_from");
            this.mAppId = arguments.getString("app_id");
        }
    }

    public void hN(boolean z) {
        this.dAP = z;
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(getContext().getResources().getDrawable(this.dAP ? b.d.aiapps_login_getmobile_dark_bg : b.d.aiapps_login_getmobile_bg));
        }
        updateUI();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        boolean alD = com.baidu.swan.apps.t.a.aAN().alD();
        if (alD != this.dAP) {
            hN(alD);
        }
    }

    public void a(a aVar) {
        this.dWW = aVar;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aTk() {
        if (this.dWW != null) {
            this.dWW.hL(this.dWY);
        }
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        aTk();
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dWW != null) {
            this.dWW.hL(this.dWY);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.dWW != null) {
            this.dWW.hL(this.dWY);
        }
        super.onDestroyView();
    }

    public void a(SpannableStringBuilder spannableStringBuilder, int i, String str, String str2) {
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new b(str2, this.dWX), i, spannableStringBuilder.length(), 33);
    }

    /* loaded from: classes9.dex */
    static class b extends ClickableSpan {
        private WeakReference<Activity> mActivityRef;
        private String mUrl;

        public b(String str, Activity activity) {
            this.mUrl = str;
            this.mActivityRef = new WeakReference<>(activity);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor("#3388FF"));
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Activity activity = this.mActivityRef.get();
            if (activity != null) {
                Intent intent = new Intent(activity, LoginServiceAgreementActivity.class);
                intent.putExtra("url", this.mUrl);
                activity.startActivity(intent);
            }
        }
    }
}
