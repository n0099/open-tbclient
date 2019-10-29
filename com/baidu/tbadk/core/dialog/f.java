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
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private Activity cft;
    private View cfu;
    private TextView cfv;
    private int cfw;
    private View.OnClickListener cfx;
    private Drawable mBackgroundDrawable;
    private ViewGroup mContainer;
    private int mCornerRadius;
    private int mHeight;
    private WindowManager.LayoutParams mLayoutParams;
    private View mRootView;
    private WindowManager mWindowManager;
    private int offsetX;
    private int offsetY;
    private float aEV = 1.0f;
    private int duration = 5000;
    private final Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tbadk.core.dialog.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.hide();
        }
    };

    private f(Activity activity) {
        if (activity != null) {
            this.cft = activity;
            this.mHeight = com.baidu.adp.lib.util.l.getDimens(this.cft, R.dimen.tbds114);
            this.mCornerRadius = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds84);
            this.cfw = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds44);
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds222);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds29);
            View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
            this.mContainer = (ViewGroup) inflate.findViewById(R.id.layout_container);
            this.cfu = inflate.findViewById(R.id.background);
            this.cfv = (TextView) inflate.findViewById(R.id.toast_tv);
            this.mRootView = inflate;
            this.cfu.setBackgroundDrawable(akW());
            this.cfv.setMaxLines(1);
            this.cfv.setGravity(17);
            this.cfv.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbfontsize40));
            this.cfv.setTextColor(this.cft.getResources().getColor(R.color.cp_cont_a));
            this.cfv.setPadding(this.cfw, 0, this.cfw, 0);
            this.mWindowManager = (WindowManager) this.cft.getSystemService("window");
            this.mLayoutParams = new WindowManager.LayoutParams();
            this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.cft) - (this.offsetX * 2);
            this.mLayoutParams.height = this.mHeight;
            this.mLayoutParams.type = 1000;
            this.mLayoutParams.format = -3;
            this.mLayoutParams.windowAnimations = R.style.ToastAnimation;
            this.mLayoutParams.flags = 262152;
            this.mLayoutParams.gravity = 81;
            this.mLayoutParams.y = akU();
            this.mLayoutParams.alpha = this.aEV;
        }
    }

    private int akU() {
        return this.offsetY + UtilHelper.getNavigationBarHeight(this.cft);
    }

    private GradientDrawable akV() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{com.baidu.tieba.lego.card.d.a.bR("#FF722B"), com.baidu.tieba.lego.card.d.a.bR("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.mCornerRadius);
        return gradientDrawable;
    }

    private Drawable akW() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = akV();
        }
        return this.mBackgroundDrawable;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cfx = onClickListener;
    }

    public static f d(Activity activity, String str) {
        return new f(activity).nq(str);
    }

    private f nq(String str) {
        if (this.cft != null && !TextUtils.isEmpty(str)) {
            String interceptString = aa.interceptString(str, 34);
            int textWidth = com.baidu.adp.lib.util.l.getTextWidth(this.cfv.getPaint(), interceptString);
            ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
            layoutParams.width = textWidth + (this.cfw * 2);
            this.mContainer.setLayoutParams(layoutParams);
            this.cfv.setText(interceptString);
        }
        return this;
    }

    public f akX() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.mHideRunnable);
        if (this.mRootView != null && this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
        this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.mHideRunnable, this.duration);
        return this;
    }

    public void hide() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.mHideRunnable);
        if (this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public f m22if(int i) {
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
        if (this.cfx != null) {
            this.cfx.onClick(view);
        }
        hide();
    }
}
