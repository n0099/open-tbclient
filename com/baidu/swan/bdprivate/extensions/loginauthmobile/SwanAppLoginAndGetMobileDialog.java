package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public abstract class SwanAppLoginAndGetMobileDialog extends DialogFragment {
    protected QuickLoginInfo dGY;
    protected String dGZ;
    protected a dHf;
    protected FragmentActivity dHg;
    protected String mAppId;
    protected LinearLayout mRootView;
    protected boolean dnE = false;
    protected String dGW = "";
    private boolean dHh = true;

    /* loaded from: classes7.dex */
    public interface a {
        void he(boolean z);

        void lz(int i);
    }

    protected abstract void a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    protected abstract void aNI();

    protected abstract void updateUI();

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    public void d(FragmentActivity fragmentActivity) {
        this.dHg = fragmentActivity;
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        anX();
        getDialog().requestWindowFeature(1);
        getDialog().setCanceledOnTouchOutside(true);
        Window window = getDialog().getWindow();
        if (window == null) {
            return null;
        }
        a(window);
        a(layoutInflater, viewGroup);
        updateUI();
        aNI();
        return this.mRootView;
    }

    private void a(Window window) {
        window.setBackgroundDrawable(getContext().getResources().getDrawable(this.dnE ? b.d.aiapps_login_getmobile_dark_bg : b.d.aiapps_login_getmobile_bg));
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setFlags(32, 32);
        window.setFlags(262144, 262144);
        window.getDecorView().setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 4) {
                    SwanAppLoginAndGetMobileDialog.this.hf(true);
                    SwanAppLoginAndGetMobileDialog.this.aNJ();
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

    public void hf(boolean z) {
        this.dHh = z;
    }

    private void anX() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dGW = arguments.getString("auth_tip");
            this.dnE = arguments.getBoolean("is_night");
            this.dGY = (QuickLoginInfo) arguments.getParcelable("quick_login_info");
            this.dGZ = arguments.getString("launch_from");
            this.mAppId = arguments.getString("app_id");
        }
    }

    public void hg(boolean z) {
        this.dnE = z;
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(getContext().getResources().getDrawable(this.dnE ? b.d.aiapps_login_getmobile_dark_bg : b.d.aiapps_login_getmobile_bg));
        }
        updateUI();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState();
        if (nightModeSwitcherState != this.dnE) {
            hg(nightModeSwitcherState);
        }
    }

    public void a(a aVar) {
        this.dHf = aVar;
    }

    @Override // android.support.v4.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aNJ() {
        if (this.dHf != null) {
            this.dHf.he(this.dHh);
        }
        dismissAllowingStateLoss();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        aNJ();
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dHf != null) {
            this.dHf.he(this.dHh);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.dHf != null) {
            this.dHf.he(this.dHh);
        }
        super.onDestroyView();
    }

    public void a(SpannableStringBuilder spannableStringBuilder, int i, String str, String str2) {
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new b(str2, this.dHg), i, spannableStringBuilder.length(), 33);
    }

    /* loaded from: classes7.dex */
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
