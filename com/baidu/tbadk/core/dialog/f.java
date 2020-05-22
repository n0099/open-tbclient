package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private Activity clq;
    private TextView dIN;
    private int dIO;
    private View.OnClickListener dIP;
    private View deP;
    private Drawable mBackgroundDrawable;
    private ViewGroup mContainer;
    private int mCornerRadius;
    private int mHeight;
    private WindowManager.LayoutParams mLayoutParams;
    private View mRootView;
    private WindowManager mWindowManager;
    private int offsetX;
    private int offsetY;
    private float alpha = 1.0f;
    private int duration = 5000;
    private final Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tbadk.core.dialog.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.hide();
        }
    };

    private f(Activity activity) {
        if (activity != null) {
            this.clq = activity;
            this.mHeight = com.baidu.adp.lib.util.l.getDimens(this.clq, R.dimen.tbds114);
            this.mCornerRadius = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds84);
            this.dIO = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds44);
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds222);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds29);
            View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
            this.mContainer = (ViewGroup) inflate.findViewById(R.id.layout_container);
            this.deP = inflate.findViewById(R.id.background);
            this.dIN = (TextView) inflate.findViewById(R.id.toast_tv);
            this.mRootView = inflate;
            this.deP.setBackgroundDrawable(aTb());
            this.dIN.setMaxLines(1);
            this.dIN.setGravity(17);
            this.dIN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbfontsize40));
            this.dIN.setTextColor(this.clq.getResources().getColor(R.color.cp_cont_a));
            this.dIN.setPadding(this.dIO, 0, this.dIO, 0);
            this.mWindowManager = (WindowManager) this.clq.getSystemService("window");
            this.mLayoutParams = new WindowManager.LayoutParams();
            this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.clq) - (this.offsetX * 2);
            this.mLayoutParams.height = this.mHeight;
            this.mLayoutParams.type = 1000;
            this.mLayoutParams.format = -3;
            this.mLayoutParams.windowAnimations = R.style.ToastAnimation;
            this.mLayoutParams.flags = 262152;
            this.mLayoutParams.gravity = 81;
            this.mLayoutParams.y = aSZ();
            this.mLayoutParams.alpha = this.alpha;
        }
    }

    private int aSZ() {
        return this.offsetY + UtilHelper.getNavigationBarHeight(this.clq);
    }

    private GradientDrawable aTa() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{com.baidu.tieba.lego.card.d.a.dT("#FF722B"), com.baidu.tieba.lego.card.d.a.dT("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.mCornerRadius);
        return gradientDrawable;
    }

    private Drawable aTb() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = aTa();
        }
        return this.mBackgroundDrawable;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dIP = onClickListener;
    }

    public static f d(Activity activity, String str) {
        return new f(activity).vR(str);
    }

    private f vR(String str) {
        if (this.clq != null && !TextUtils.isEmpty(str)) {
            String interceptString = ae.interceptString(str, 34);
            int textWidth = com.baidu.adp.lib.util.l.getTextWidth(this.dIN.getPaint(), interceptString);
            ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
            layoutParams.width = textWidth + (this.dIO * 2);
            this.mContainer.setLayoutParams(layoutParams);
            this.dIN.setText(interceptString);
        }
        return this;
    }

    public f aTc() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.mHideRunnable);
        if (this.mRootView != null && this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
        this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.mHideRunnable, this.duration);
        return this;
    }

    public void hide() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.mHideRunnable);
        if (this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
    }

    public f kO(int i) {
        if (i > 0) {
            this.duration = i * 1000;
        }
        return this;
    }

    public void setTag(Object obj) {
        this.mContainer.setTag(obj);
        this.mContainer.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dIP != null) {
            this.dIP.onClick(view);
        }
        hide();
    }
}
