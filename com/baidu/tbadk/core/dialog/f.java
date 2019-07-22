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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private int Mn;
    private Drawable Mp;
    private View bNM;
    private TextView bNN;
    private int bNO;
    private View.OnClickListener bNP;
    private ViewGroup mContainer;
    private Activity mContext;
    private int mHeight;
    private WindowManager.LayoutParams mLayoutParams;
    private View mRootView;
    private WindowManager mWindowManager;
    private int zQ;
    private int zR;
    private float alb = 1.0f;
    private int duration = UIMsg.m_AppUI.MSG_APP_GPS;
    private final Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tbadk.core.dialog.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.hide();
        }
    };

    private f(Activity activity) {
        if (activity != null) {
            this.mContext = activity;
            this.mHeight = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds114);
            this.Mn = com.baidu.adp.lib.util.l.g(activity, R.dimen.tbds84);
            this.bNO = com.baidu.adp.lib.util.l.g(activity, R.dimen.tbds44);
            this.zR = com.baidu.adp.lib.util.l.g(activity, R.dimen.tbds222);
            this.zQ = com.baidu.adp.lib.util.l.g(activity, R.dimen.tbds29);
            View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
            this.mContainer = (ViewGroup) inflate.findViewById(R.id.layout_container);
            this.bNM = inflate.findViewById(R.id.background);
            this.bNN = (TextView) inflate.findViewById(R.id.toast_tv);
            this.mRootView = inflate;
            this.bNM.setBackgroundDrawable(agT());
            this.bNN.setMaxLines(1);
            this.bNN.setGravity(17);
            this.bNN.setTextSize(0, com.baidu.adp.lib.util.l.g(activity, R.dimen.tbfontsize40));
            this.bNN.setTextColor(this.mContext.getResources().getColor(R.color.cp_btn_a));
            this.bNN.setPadding(this.bNO, 0, this.bNO, 0);
            this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
            this.mLayoutParams = new WindowManager.LayoutParams();
            this.mLayoutParams.width = com.baidu.adp.lib.util.l.af(this.mContext) - (this.zQ * 2);
            this.mLayoutParams.height = this.mHeight;
            this.mLayoutParams.type = 1000;
            this.mLayoutParams.format = -3;
            this.mLayoutParams.windowAnimations = R.style.ToastAnimation;
            this.mLayoutParams.flags = 262152;
            this.mLayoutParams.gravity = 81;
            this.mLayoutParams.y = agR();
            this.mLayoutParams.alpha = this.alb;
        }
    }

    private int agR() {
        return this.zR + UtilHelper.getNavigationBarHeight(this.mContext);
    }

    private GradientDrawable agS() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{com.baidu.tieba.lego.card.d.a.cE("#FF722B"), com.baidu.tieba.lego.card.d.a.cE("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.Mn);
        return gradientDrawable;
    }

    private Drawable agT() {
        if (this.Mp == null) {
            this.Mp = agS();
        }
        return this.Mp;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bNP = onClickListener;
    }

    public static f d(Activity activity, String str) {
        return new f(activity).mR(str);
    }

    private f mR(String str) {
        if (this.mContext != null && !TextUtils.isEmpty(str)) {
            String ac = ab.ac(str, 34);
            int c = com.baidu.adp.lib.util.l.c(this.bNN.getPaint(), ac);
            ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
            layoutParams.width = c + (this.bNO * 2);
            this.mContainer.setLayoutParams(layoutParams);
            this.bNN.setText(ac);
        }
        return this;
    }

    public f agU() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideRunnable);
        if (this.mRootView != null && this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
        this.mWindowManager.addView(this.mRootView, this.mLayoutParams);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.mHideRunnable, this.duration);
        return this;
    }

    public void hide() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideRunnable);
        if (this.mRootView.getWindowToken() != null) {
            this.mWindowManager.removeView(this.mRootView);
        }
    }

    public f hK(int i) {
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
        if (this.bNP != null) {
            this.bNP.onClick(view);
        }
        hide();
    }
}
