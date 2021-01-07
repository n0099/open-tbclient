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
/* loaded from: classes11.dex */
public class c implements View.OnClickListener {
    private TextView aGt;
    private a bUh;
    private TextView bUi;
    private TextView bUj;
    private View bUk;
    private AnimatorSet bUl;
    private ImageView bgl;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes11.dex */
    public interface a {
        void Sw();

        void Sx();
    }

    public c(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.bUh = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void dz(boolean z) {
        if (this.bgl != null) {
            this.bgl.setVisibility(z ? 0 : 8);
        }
    }

    public void setTitleVisible(boolean z) {
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setVisibility(z ? 0 : 8);
        }
    }

    public void dA(boolean z) {
        if (this.aGt != null) {
            this.aGt.setVisibility(z ? 0 : 8);
        }
    }

    public void o(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.aGt.setText(str2);
        this.bUi.setText(str3);
        this.bUj.setText(str4);
    }

    public void gN(int i) {
        this.aGt.setTextColor(i);
    }

    public void dB(boolean z) {
        this.mTitleTextView.setSingleLine(z);
    }

    public void dC(boolean z) {
        this.mTitleTextView.setTypeface(Typeface.defaultFromStyle(z ? 1 : 0));
    }

    public void A(float f) {
        this.mTitleTextView.setLineSpacing(f, 1.0f);
    }

    public void setTitleTextSize(float f) {
        this.mTitleTextView.setTextSize(0, f);
    }

    public void B(float f) {
        this.aGt.setTextSize(0, f);
    }

    public void gO(int i) {
        this.bUi.setTextColor(i);
    }

    public void gP(int i) {
        this.bUj.setTextColor(i);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            Oj();
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
        if (view == this.mRootView || view == this.bgl || view == this.bUi || view == this.bUj) {
            dismiss();
        }
        if (this.bUh != null) {
            if (view == this.bUi) {
                this.bUh.Sw();
            } else if (view == this.bUj) {
                this.bUh.Sx();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new d(this.mContext);
        JK();
        initView();
        Hi();
    }

    private void JK() {
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
        this.bgl = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.aGt = (TextView) this.mRootView.findViewById(a.f.tv_content);
        this.bUi = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bUj = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.bUk = this.mRootView.findViewById(a.f.divider);
        this.mRootView.setOnClickListener(this);
        this.bgl.setOnClickListener(this);
        this.bUi.setOnClickListener(this);
        this.bUj.setOnClickListener(this);
    }

    private void Hi() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.c.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.bUl != null) {
                    c.this.bUl.cancel();
                }
            }
        });
    }

    private void Oj() {
        if (this.bUl == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bUl = new AnimatorSet();
            this.bUl.playTogether(ofFloat, ofFloat2);
            this.bUl.setDuration(300L);
            this.bUl.setInterpolator(new LinearInterpolator());
        }
        this.bUl.start();
    }

    public void ZE() {
        this.bgl.setVisibility(8);
        this.bUk.setVisibility(8);
        this.bUj.setVisibility(8);
    }
}
