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
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private TextView eWF;
    private int eWG;
    private View.OnClickListener eWH;
    private View epj;
    private Drawable mBackgroundDrawable;
    private ViewGroup mContainer;
    private Activity mContext;
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
            this.mContext = activity;
            this.mHeight = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds114);
            this.mCornerRadius = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds84);
            this.eWG = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds44);
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds222);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds29);
            View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
            this.mContainer = (ViewGroup) inflate.findViewById(R.id.layout_container);
            this.epj = inflate.findViewById(R.id.background);
            this.eWF = (TextView) inflate.findViewById(R.id.toast_tv);
            this.mRootView = inflate;
            this.epj.setBackgroundDrawable(getBackgroundDrawable());
            this.eWF.setMaxLines(1);
            this.eWF.setGravity(17);
            this.eWF.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbfontsize40));
            this.eWF.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0101));
            this.eWF.setPadding(this.eWG, 0, this.eWG, 0);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            this.mLayoutParams = new WindowManager.LayoutParams();
            this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (this.offsetX * 2);
            this.mLayoutParams.height = this.mHeight;
            this.mLayoutParams.type = 1000;
            this.mLayoutParams.format = -3;
            this.mLayoutParams.windowAnimations = R.style.ToastAnimation;
            this.mLayoutParams.flags = 262152;
            this.mLayoutParams.gravity = 81;
            this.mLayoutParams.y = bqG();
            this.mLayoutParams.alpha = this.alpha;
        }
    }

    private int bqG() {
        return this.offsetY + UtilHelper.getNavigationBarHeight(this.mContext);
    }

    private GradientDrawable bqH() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{com.baidu.tieba.lego.card.c.b.rT("#FF722B"), com.baidu.tieba.lego.card.c.b.rT("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.mCornerRadius);
        return gradientDrawable;
    }

    private Drawable getBackgroundDrawable() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = bqH();
        }
        return this.mBackgroundDrawable;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eWH = onClickListener;
    }

    public static f c(Activity activity, String str) {
        return new f(activity).AE(str);
    }

    private f AE(String str) {
        if (this.mContext != null && !TextUtils.isEmpty(str)) {
            String interceptString = ag.interceptString(str, 34);
            int textWidth = com.baidu.adp.lib.util.l.getTextWidth(this.eWF.getPaint(), interceptString);
            ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
            layoutParams.width = textWidth + (this.eWG * 2);
            this.mContainer.setLayoutParams(layoutParams);
            this.eWF.setText(interceptString);
        }
        return this;
    }

    public f bqI() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHideRunnable);
        if (this.mRootView != null && this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
        this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mHideRunnable, this.duration);
        return this;
    }

    public void hide() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHideRunnable);
        if (this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
    }

    public f nK(int i) {
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
        if (this.eWH != null) {
            this.eWH.onClick(view);
        }
        hide();
    }
}
