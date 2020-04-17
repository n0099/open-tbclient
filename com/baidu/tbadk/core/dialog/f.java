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
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private View cTH;
    private Activity caH;
    private TextView duO;
    private int duP;
    private View.OnClickListener duQ;
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
            this.caH = activity;
            this.mHeight = com.baidu.adp.lib.util.l.getDimens(this.caH, R.dimen.tbds114);
            this.mCornerRadius = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds84);
            this.duP = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds44);
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds222);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds29);
            View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
            this.mContainer = (ViewGroup) inflate.findViewById(R.id.layout_container);
            this.cTH = inflate.findViewById(R.id.background);
            this.duO = (TextView) inflate.findViewById(R.id.toast_tv);
            this.mRootView = inflate;
            this.cTH.setBackgroundDrawable(aNc());
            this.duO.setMaxLines(1);
            this.duO.setGravity(17);
            this.duO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbfontsize40));
            this.duO.setTextColor(this.caH.getResources().getColor(R.color.cp_cont_a));
            this.duO.setPadding(this.duP, 0, this.duP, 0);
            this.mWindowManager = (WindowManager) this.caH.getSystemService("window");
            this.mLayoutParams = new WindowManager.LayoutParams();
            this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.caH) - (this.offsetX * 2);
            this.mLayoutParams.height = this.mHeight;
            this.mLayoutParams.type = 1000;
            this.mLayoutParams.format = -3;
            this.mLayoutParams.windowAnimations = R.style.ToastAnimation;
            this.mLayoutParams.flags = 262152;
            this.mLayoutParams.gravity = 81;
            this.mLayoutParams.y = aNa();
            this.mLayoutParams.alpha = this.alpha;
        }
    }

    private int aNa() {
        return this.offsetY + UtilHelper.getNavigationBarHeight(this.caH);
    }

    private GradientDrawable aNb() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{com.baidu.tieba.lego.card.d.a.dA("#FF722B"), com.baidu.tieba.lego.card.d.a.dA("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.mCornerRadius);
        return gradientDrawable;
    }

    private Drawable aNc() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = aNb();
        }
        return this.mBackgroundDrawable;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.duQ = onClickListener;
    }

    public static f d(Activity activity, String str) {
        return new f(activity).ui(str);
    }

    private f ui(String str) {
        if (this.caH != null && !TextUtils.isEmpty(str)) {
            String interceptString = ad.interceptString(str, 34);
            int textWidth = com.baidu.adp.lib.util.l.getTextWidth(this.duO.getPaint(), interceptString);
            ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
            layoutParams.width = textWidth + (this.duP * 2);
            this.mContainer.setLayoutParams(layoutParams);
            this.duO.setText(interceptString);
        }
        return this;
    }

    public f aNd() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.mHideRunnable);
        if (this.mRootView != null && this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
        this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.mHideRunnable, this.duration);
        return this;
    }

    public void hide() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.mHideRunnable);
        if (this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
    }

    public f ko(int i) {
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
        if (this.duQ != null) {
            this.duQ.onClick(view);
        }
        hide();
    }
}
