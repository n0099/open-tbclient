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
/* loaded from: classes4.dex */
public class c implements View.OnClickListener {
    private TextView aFh;
    private a bLG;
    private ImageView bLH;
    private TextView bLI;
    private TextView bLJ;
    private AnimatorSet bLK;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void PI();

        void PJ();
    }

    public c(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.bLG = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void dg(boolean z) {
        if (this.bLH != null) {
            this.bLH.setVisibility(z ? 0 : 8);
        }
    }

    public void dh(boolean z) {
        if (this.aFh != null) {
            this.aFh.setVisibility(z ? 0 : 8);
        }
    }

    public void o(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.aFh.setText(str2);
        this.bLI.setText(str3);
        this.bLJ.setText(str4);
    }

    public void gs(int i) {
        this.aFh.setTextColor(i);
    }

    public void di(boolean z) {
        this.mTitleTextView.setSingleLine(z);
    }

    public void dj(boolean z) {
        this.mTitleTextView.setTypeface(Typeface.defaultFromStyle(z ? 1 : 0));
    }

    public void C(float f) {
        this.mTitleTextView.setLineSpacing(f, 1.0f);
    }

    public void setTitleTextSize(float f) {
        this.mTitleTextView.setTextSize(0, f);
    }

    public void D(float f) {
        this.aFh.setTextSize(0, f);
    }

    public void gt(int i) {
        this.bLI.setTextColor(i);
    }

    public void gu(int i) {
        this.bLJ.setTextColor(i);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            MR();
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
        if (view == this.mRootView || view == this.bLH || view == this.bLI || view == this.bLJ) {
            dismiss();
        }
        if (this.bLG != null) {
            if (view == this.bLI) {
                this.bLG.PI();
            } else if (view == this.bLJ) {
                this.bLG.PJ();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new d(this.mContext);
        Pe();
        initView();
        GB();
    }

    private void Pe() {
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
        this.bLH = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.aFh = (TextView) this.mRootView.findViewById(a.f.tv_content);
        this.bLI = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bLJ = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.mRootView.setOnClickListener(this);
        this.bLH.setOnClickListener(this);
        this.bLI.setOnClickListener(this);
        this.bLJ.setOnClickListener(this);
    }

    private void GB() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.c.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.bLK != null) {
                    c.this.bLK.cancel();
                }
            }
        });
    }

    private void MR() {
        if (this.bLK == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bLK = new AnimatorSet();
            this.bLK.playTogether(ofFloat, ofFloat2);
            this.bLK.setDuration(300L);
            this.bLK.setInterpolator(new LinearInterpolator());
        }
        this.bLK.start();
    }
}
