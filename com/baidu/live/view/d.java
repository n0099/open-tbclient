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
public class d implements View.OnClickListener {
    private TextView aEr;
    private a bGb;
    private ImageView bGc;
    private TextView bGd;
    private TextView bGe;
    private AnimatorSet bGf;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void Pi();

        void Pj();
    }

    public d(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.bGb = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void cZ(boolean z) {
        if (this.bGc != null) {
            this.bGc.setVisibility(z ? 0 : 8);
        }
    }

    public void da(boolean z) {
        if (this.aEr != null) {
            this.aEr.setVisibility(z ? 0 : 8);
        }
    }

    public void o(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.aEr.setText(str2);
        this.bGd.setText(str3);
        this.bGe.setText(str4);
    }

    public void gh(int i) {
        this.aEr.setTextColor(i);
    }

    public void db(boolean z) {
        this.mTitleTextView.setSingleLine(z);
    }

    public void dc(boolean z) {
        this.mTitleTextView.setTypeface(Typeface.defaultFromStyle(z ? 1 : 0));
    }

    public void B(float f) {
        this.mTitleTextView.setLineSpacing(f, 1.0f);
    }

    public void setTitleTextSize(float f) {
        this.mTitleTextView.setTextSize(0, f);
    }

    public void C(float f) {
        this.aEr.setTextSize(0, f);
    }

    public void gi(int i) {
        this.bGd.setTextColor(i);
    }

    public void gj(int i) {
        this.bGe.setTextColor(i);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            Mr();
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
        if (view == this.mRootView || view == this.bGc || view == this.bGd || view == this.bGe) {
            dismiss();
        }
        if (this.bGb != null) {
            if (view == this.bGd) {
                this.bGb.Pi();
            } else if (view == this.bGe) {
                this.bGb.Pj();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        OE();
        initView();
        Ga();
    }

    private void OE() {
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
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.h.sdk_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.bGc = (ImageView) this.mRootView.findViewById(a.g.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.aEr = (TextView) this.mRootView.findViewById(a.g.tv_content);
        this.bGd = (TextView) this.mRootView.findViewById(a.g.tv_confirm);
        this.bGe = (TextView) this.mRootView.findViewById(a.g.tv_cancel);
        this.mRootView.setOnClickListener(this);
        this.bGc.setOnClickListener(this);
        this.bGd.setOnClickListener(this);
        this.bGe.setOnClickListener(this);
    }

    private void Ga() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.bGf != null) {
                    d.this.bGf.cancel();
                }
            }
        });
    }

    private void Mr() {
        if (this.bGf == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bGf = new AnimatorSet();
            this.bGf.playTogether(ofFloat, ofFloat2);
            this.bGf.setDuration(300L);
            this.bGf.setInterpolator(new LinearInterpolator());
        }
        this.bGf.start();
    }
}
