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
    private Activity bdo;
    private TextView dPD;
    private int dPE;
    private View.OnClickListener dPF;
    private View djB;
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
            this.bdo = activity;
            this.mHeight = com.baidu.adp.lib.util.l.getDimens(this.bdo, R.dimen.tbds114);
            this.mCornerRadius = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds84);
            this.dPE = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds44);
            this.offsetY = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds222);
            this.offsetX = com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbds29);
            View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
            this.mContainer = (ViewGroup) inflate.findViewById(R.id.layout_container);
            this.djB = inflate.findViewById(R.id.background);
            this.dPD = (TextView) inflate.findViewById(R.id.toast_tv);
            this.mRootView = inflate;
            this.djB.setBackgroundDrawable(aUV());
            this.dPD.setMaxLines(1);
            this.dPD.setGravity(17);
            this.dPD.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(activity, R.dimen.tbfontsize40));
            this.dPD.setTextColor(this.bdo.getResources().getColor(R.color.cp_cont_a));
            this.dPD.setPadding(this.dPE, 0, this.dPE, 0);
            this.mWindowManager = (WindowManager) this.bdo.getSystemService("window");
            this.mLayoutParams = new WindowManager.LayoutParams();
            this.mLayoutParams.width = com.baidu.adp.lib.util.l.getEquipmentWidth(this.bdo) - (this.offsetX * 2);
            this.mLayoutParams.height = this.mHeight;
            this.mLayoutParams.type = 1000;
            this.mLayoutParams.format = -3;
            this.mLayoutParams.windowAnimations = R.style.ToastAnimation;
            this.mLayoutParams.flags = 262152;
            this.mLayoutParams.gravity = 81;
            this.mLayoutParams.y = aUT();
            this.mLayoutParams.alpha = this.alpha;
        }
    }

    private int aUT() {
        return this.offsetY + UtilHelper.getNavigationBarHeight(this.bdo);
    }

    private GradientDrawable aUU() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{com.baidu.tieba.lego.card.d.a.dV("#FF722B"), com.baidu.tieba.lego.card.d.a.dV("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.mCornerRadius);
        return gradientDrawable;
    }

    private Drawable aUV() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = aUU();
        }
        return this.mBackgroundDrawable;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dPF = onClickListener;
    }

    public static f d(Activity activity, String str) {
        return new f(activity).wh(str);
    }

    private f wh(String str) {
        if (this.bdo != null && !TextUtils.isEmpty(str)) {
            String interceptString = ae.interceptString(str, 34);
            int textWidth = com.baidu.adp.lib.util.l.getTextWidth(this.dPD.getPaint(), interceptString);
            ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
            layoutParams.width = textWidth + (this.dPE * 2);
            this.mContainer.setLayoutParams(layoutParams);
            this.dPD.setText(interceptString);
        }
        return this;
    }

    public f aUW() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
        if (this.mRootView != null && this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
        this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.mHideRunnable, this.duration);
        return this;
    }

    public void hide() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mHideRunnable);
        if (this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
    }

    public f le(int i) {
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
        if (this.dPF != null) {
            this.dPF.onClick(view);
        }
        hide();
    }
}
