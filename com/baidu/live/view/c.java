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
    private TextView aGc;
    private a bPd;
    private TextView bPe;
    private TextView bPf;
    private AnimatorSet bPg;
    private ImageView beA;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void Rt();

        void Ru();
    }

    public c(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.bPd = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void dw(boolean z) {
        if (this.beA != null) {
            this.beA.setVisibility(z ? 0 : 8);
        }
    }

    public void dx(boolean z) {
        if (this.aGc != null) {
            this.aGc.setVisibility(z ? 0 : 8);
        }
    }

    public void o(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.aGc.setText(str2);
        this.bPe.setText(str3);
        this.bPf.setText(str4);
    }

    public void gM(int i) {
        this.aGc.setTextColor(i);
    }

    public void dy(boolean z) {
        this.mTitleTextView.setSingleLine(z);
    }

    public void dz(boolean z) {
        this.mTitleTextView.setTypeface(Typeface.defaultFromStyle(z ? 1 : 0));
    }

    public void A(float f) {
        this.mTitleTextView.setLineSpacing(f, 1.0f);
    }

    public void setTitleTextSize(float f) {
        this.mTitleTextView.setTextSize(0, f);
    }

    public void B(float f) {
        this.aGc.setTextSize(0, f);
    }

    public void gN(int i) {
        this.bPe.setTextColor(i);
    }

    public void gO(int i) {
        this.bPf.setTextColor(i);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            OD();
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
        if (view == this.mRootView || view == this.beA || view == this.bPe || view == this.bPf) {
            dismiss();
        }
        if (this.bPd != null) {
            if (view == this.bPe) {
                this.bPd.Rt();
            } else if (view == this.bPf) {
                this.bPd.Ru();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new d(this.mContext);
        Ki();
        initView();
        HH();
    }

    private void Ki() {
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
        this.beA = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.aGc = (TextView) this.mRootView.findViewById(a.f.tv_content);
        this.bPe = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bPf = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.mRootView.setOnClickListener(this);
        this.beA.setOnClickListener(this);
        this.bPe.setOnClickListener(this);
        this.bPf.setOnClickListener(this);
    }

    private void HH() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.c.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.bPg != null) {
                    c.this.bPg.cancel();
                }
            }
        });
    }

    private void OD() {
        if (this.bPg == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bPg = new AnimatorSet();
            this.bPg.playTogether(ofFloat, ofFloat2);
            this.bPg.setDuration(300L);
            this.bPg.setInterpolator(new LinearInterpolator());
        }
        this.bPg.start();
    }
}
