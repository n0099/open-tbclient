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
    private Activity ceC;
    private View ceD;
    private TextView ceE;
    private int ceF;
    private View.OnClickListener ceG;
    private Drawable mBackgroundDrawable;
    private ViewGroup mContainer;
    private int mCornerRadius;
    private int mHeight;
    private WindowManager.LayoutParams mLayoutParams;
    private View mRootView;
    private WindowManager mWindowManager;
    private int offsetX;
    private int offsetY;
    private float aED = 1.0f;
    private int duration = 5000;
    private final Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tbadk.core.dialog.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.hide();
        }
    };

    private f(Activity activity) {
        if (activity != null) {
            this.ceC = activity;
            this.mHeight = com.baidu.adp.lib.util.l.getDimens(this.ceC, R.dimen.tbds114);
            this.mCornerRadius = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds84);
            this.ceF = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds44);
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds222);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds29);
            View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
            this.mContainer = (ViewGroup) inflate.findViewById(R.id.layout_container);
            this.ceD = inflate.findViewById(R.id.background);
            this.ceE = (TextView) inflate.findViewById(R.id.toast_tv);
            this.mRootView = inflate;
            this.ceD.setBackgroundDrawable(akU());
            this.ceE.setMaxLines(1);
            this.ceE.setGravity(17);
            this.ceE.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbfontsize40));
            this.ceE.setTextColor(this.ceC.getResources().getColor(R.color.cp_cont_a));
            this.ceE.setPadding(this.ceF, 0, this.ceF, 0);
            this.mWindowManager = (WindowManager) this.ceC.getSystemService("window");
            this.mLayoutParams = new WindowManager.LayoutParams();
            this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ceC) - (this.offsetX * 2);
            this.mLayoutParams.height = this.mHeight;
            this.mLayoutParams.type = 1000;
            this.mLayoutParams.format = -3;
            this.mLayoutParams.windowAnimations = R.style.ToastAnimation;
            this.mLayoutParams.flags = 262152;
            this.mLayoutParams.gravity = 81;
            this.mLayoutParams.y = akS();
            this.mLayoutParams.alpha = this.aED;
        }
    }

    private int akS() {
        return this.offsetY + UtilHelper.getNavigationBarHeight(this.ceC);
    }

    private GradientDrawable akT() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{com.baidu.tieba.lego.card.d.a.bR("#FF722B"), com.baidu.tieba.lego.card.d.a.bR("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.mCornerRadius);
        return gradientDrawable;
    }

    private Drawable akU() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = akT();
        }
        return this.mBackgroundDrawable;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ceG = onClickListener;
    }

    public static f d(Activity activity, String str) {
        return new f(activity).nq(str);
    }

    private f nq(String str) {
        if (this.ceC != null && !TextUtils.isEmpty(str)) {
            String interceptString = aa.interceptString(str, 34);
            int textWidth = com.baidu.adp.lib.util.l.getTextWidth(this.ceE.getPaint(), interceptString);
            ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
            layoutParams.width = textWidth + (this.ceF * 2);
            this.mContainer.setLayoutParams(layoutParams);
            this.ceE.setText(interceptString);
        }
        return this;
    }

    public f akV() {
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

    public f ie(int i) {
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
        if (this.ceG != null) {
            this.ceG.onClick(view);
        }
        hide();
    }
}
