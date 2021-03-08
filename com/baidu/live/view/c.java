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
    private TextView aET;
    private a bUL;
    private TextView bUM;
    private TextView bUN;
    private View bUO;
    private AnimatorSet bUP;
    private ImageView bge;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes10.dex */
    public interface a {
        void Qd();

        void Qe();
    }

    public c(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.bUL = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void dD(boolean z) {
        if (this.bge != null) {
            this.bge.setVisibility(z ? 0 : 8);
        }
    }

    public void setTitleVisible(boolean z) {
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setVisibility(z ? 0 : 8);
        }
    }

    public void dE(boolean z) {
        if (this.aET != null) {
            this.aET.setVisibility(z ? 0 : 8);
        }
    }

    public void o(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.aET.setText(str2);
        this.bUM.setText(str3);
        this.bUN.setText(str4);
    }

    public void fl(int i) {
        this.aET.setTextColor(i);
    }

    public void dF(boolean z) {
        this.mTitleTextView.setSingleLine(z);
    }

    public void dG(boolean z) {
        this.mTitleTextView.setTypeface(Typeface.defaultFromStyle(z ? 1 : 0));
    }

    public void E(float f) {
        this.mTitleTextView.setLineSpacing(f, 1.0f);
    }

    public void setTitleTextSize(float f) {
        this.mTitleTextView.setTextSize(0, f);
    }

    public void F(float f) {
        this.aET.setTextSize(0, f);
    }

    public void fm(int i) {
        this.bUM.setTextColor(i);
    }

    public void fn(int i) {
        this.bUN.setTextColor(i);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            LQ();
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
        if (view == this.mRootView || view == this.bge || view == this.bUM || view == this.bUN) {
            dismiss();
        }
        if (this.bUL != null) {
            if (view == this.bUM) {
                this.bUL.Qd();
            } else if (view == this.bUN) {
                this.bUL.Qe();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new d(this.mContext);
        Hi();
        initView();
        EG();
    }

    private void Hi() {
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
        this.bge = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.aET = (TextView) this.mRootView.findViewById(a.f.tv_content);
        this.bUM = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bUN = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.bUO = this.mRootView.findViewById(a.f.divider);
        this.mRootView.setOnClickListener(this);
        this.bge.setOnClickListener(this);
        this.bUM.setOnClickListener(this);
        this.bUN.setOnClickListener(this);
    }

    private void EG() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.c.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.bUP != null) {
                    c.this.bUP.cancel();
                }
            }
        });
    }

    private void LQ() {
        if (this.bUP == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bUP = new AnimatorSet();
            this.bUP.playTogether(ofFloat, ofFloat2);
            this.bUP.setDuration(300L);
            this.bUP.setInterpolator(new LinearInterpolator());
        }
        this.bUP.start();
    }

    public void Xx() {
        this.bge.setVisibility(8);
        this.bUO.setVisibility(8);
        this.bUN.setVisibility(8);
    }
}
