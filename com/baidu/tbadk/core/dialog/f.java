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
    private Activity beD;
    private TextView eNF;
    private int eNG;
    private View.OnClickListener eNH;
    private View ehl;
    private Drawable mBackgroundDrawable;
    private ViewGroup mContainer;
    private int mCornerRadius;
    private int mHeight;
    private WindowManager.LayoutParams mLayoutParams;
    private View mRootView;
    private WindowManager mWindowManager;
    private int offsetX;
    private int offsetY;
    private float bcD = 1.0f;
    private int duration = 5000;
    private final Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tbadk.core.dialog.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.hide();
        }
    };

    private f(Activity activity) {
        if (activity != null) {
            this.beD = activity;
            this.mHeight = com.baidu.adp.lib.util.l.getDimens(this.beD, R.dimen.tbds114);
            this.mCornerRadius = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds84);
            this.eNG = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds44);
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds222);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds29);
            View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
            this.mContainer = (ViewGroup) inflate.findViewById(R.id.layout_container);
            this.ehl = inflate.findViewById(R.id.background);
            this.eNF = (TextView) inflate.findViewById(R.id.toast_tv);
            this.mRootView = inflate;
            this.ehl.setBackgroundDrawable(brE());
            this.eNF.setMaxLines(1);
            this.eNF.setGravity(17);
            this.eNF.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbfontsize40));
            this.eNF.setTextColor(this.beD.getResources().getColor(R.color.CAM_X0101));
            this.eNF.setPadding(this.eNG, 0, this.eNG, 0);
            this.mWindowManager = (WindowManager) this.beD.getSystemService("window");
            this.mLayoutParams = new WindowManager.LayoutParams();
            this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.beD) - (this.offsetX * 2);
            this.mLayoutParams.height = this.mHeight;
            this.mLayoutParams.type = 1000;
            this.mLayoutParams.format = -3;
            this.mLayoutParams.windowAnimations = R.style.ToastAnimation;
            this.mLayoutParams.flags = 262152;
            this.mLayoutParams.gravity = 81;
            this.mLayoutParams.y = brC();
            this.mLayoutParams.alpha = this.bcD;
        }
    }

    private int brC() {
        return this.offsetY + UtilHelper.getNavigationBarHeight(this.beD);
    }

    private GradientDrawable brD() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{com.baidu.tieba.lego.card.d.b.sI("#FF722B"), com.baidu.tieba.lego.card.d.b.sI("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.mCornerRadius);
        return gradientDrawable;
    }

    private Drawable brE() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = brD();
        }
        return this.mBackgroundDrawable;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eNH = onClickListener;
    }

    public static f c(Activity activity, String str) {
        return new f(activity).Bt(str);
    }

    private f Bt(String str) {
        if (this.beD != null && !TextUtils.isEmpty(str)) {
            String interceptString = ae.interceptString(str, 34);
            int textWidth = com.baidu.adp.lib.util.l.getTextWidth(this.eNF.getPaint(), interceptString);
            ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
            layoutParams.width = textWidth + (this.eNG * 2);
            this.mContainer.setLayoutParams(layoutParams);
            this.eNF.setText(interceptString);
        }
        return this;
    }

    public f brF() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHideRunnable);
        if (this.mRootView != null && this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
        this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mHideRunnable, this.duration);
        return this;
    }

    public void hide() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHideRunnable);
        if (this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
    }

    public f pc(int i) {
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
        if (this.eNH != null) {
            this.eNH.onClick(view);
        }
        hide();
    }
}
