package com.baidu.live.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes10.dex */
public class c implements View.OnClickListener {
    private TextView aBG;
    private a bPv;
    private TextView bPw;
    private TextView bPx;
    private View bPy;
    private AnimatorSet bPz;
    private ImageView bbv;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes10.dex */
    public interface a {
        void OB();

        void OC();
    }

    public c(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.bPv = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void dv(boolean z) {
        if (this.bbv != null) {
            this.bbv.setVisibility(z ? 0 : 8);
        }
    }

    public void setTitleVisible(boolean z) {
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setVisibility(z ? 0 : 8);
        }
    }

    public void dw(boolean z) {
        if (this.aBG != null) {
            this.aBG.setVisibility(z ? 0 : 8);
        }
    }

    public void o(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.aBG.setText(str2);
        this.bPw.setText(str3);
        this.bPx.setText(str4);
    }

    public void fg(int i) {
        this.aBG.setTextColor(i);
    }

    public void dx(boolean z) {
        this.mTitleTextView.setSingleLine(z);
    }

    public void dy(boolean z) {
        this.mTitleTextView.setTypeface(Typeface.defaultFromStyle(z ? 1 : 0));
    }

    public void A(float f) {
        this.mTitleTextView.setLineSpacing(f, 1.0f);
    }

    public void setTitleTextSize(float f) {
        this.mTitleTextView.setTextSize(0, f);
    }

    public void B(float f) {
        this.aBG.setTextSize(0, f);
    }

    public void fh(int i) {
        this.bPw.setTextColor(i);
    }

    public void fi(int i) {
        this.bPx.setTextColor(i);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            Ko();
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.bbv || view == this.bPw || view == this.bPx) {
            dismiss();
        }
        if (this.bPv != null) {
            if (view == this.bPw) {
                this.bPv.OB();
            } else if (view == this.bPx) {
                this.bPv.OC();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new d(this.mContext);
        FP();
        initView();
        Dn();
    }

    private void FP() {
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(true);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) this.mDialog.getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = ScreenHelper.getRealScreenHeight(this.mContext);
                    attributes.height = -1;
                } else {
                    attributes.width = -1;
                    attributes.height = ScreenHelper.getRealScreenHeight(this.mContext) - UtilHelper.getStatusBarHeight();
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.sdk_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.bbv = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.aBG = (TextView) this.mRootView.findViewById(a.f.tv_content);
        this.bPw = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bPx = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.bPy = this.mRootView.findViewById(a.f.divider);
        this.mRootView.setOnClickListener(this);
        this.bbv.setOnClickListener(this);
        this.bPw.setOnClickListener(this);
        this.bPx.setOnClickListener(this);
    }

    private void Dn() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.c.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.bPz != null) {
                    c.this.bPz.cancel();
                }
            }
        });
    }

    private void Ko() {
        if (this.bPz == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bPz = new AnimatorSet();
            this.bPz.playTogether(ofFloat, ofFloat2);
            this.bPz.setDuration(300L);
            this.bPz.setInterpolator(new LinearInterpolator());
        }
        this.bPz.start();
    }

    public void VL() {
        this.bbv.setVisibility(8);
        this.bPy.setVisibility(8);
        this.bPx.setVisibility(8);
    }
}
