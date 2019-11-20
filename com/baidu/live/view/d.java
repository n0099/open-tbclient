package com.baidu.live.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes6.dex */
public class d implements View.OnClickListener {
    private TextView ahx;
    private a arQ;
    private ImageView arR;
    private TextView arS;
    private TextView arT;
    private AnimatorSet arU;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes6.dex */
    public interface a {
        void qy();

        void qz();
    }

    public d(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.arQ = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void aU(boolean z) {
        if (this.arR != null) {
            this.arR.setVisibility(z ? 0 : 8);
        }
    }

    public void setTitleVisible(boolean z) {
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setVisibility(z ? 0 : 8);
        }
    }

    public void co(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahx.getLayoutParams();
        layoutParams.topMargin = i;
        this.ahx.setLayoutParams(layoutParams);
    }

    public void k(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.ahx.setText(str2);
        this.arS.setText(str3);
        this.arT.setText(str4);
    }

    public void setTitleTextColor(int i) {
        this.mTitleTextView.setTextColor(i);
    }

    public void cp(int i) {
        this.ahx.setTextColor(i);
    }

    public void cq(int i) {
        this.arT.setTextColor(i);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            tx();
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }

    public void release() {
        dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.arR || view == this.arS || view == this.arT) {
            dismiss();
        }
        if (this.arQ != null) {
            if (view == this.arS) {
                this.arQ.qy();
            } else if (view == this.arT) {
                this.arQ.qz();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        wD();
        initView();
        pv();
    }

    private void wD() {
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
        this.arR = (ImageView) this.mRootView.findViewById(a.g.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.ahx = (TextView) this.mRootView.findViewById(a.g.tv_content);
        this.arS = (TextView) this.mRootView.findViewById(a.g.tv_confirm);
        this.arT = (TextView) this.mRootView.findViewById(a.g.tv_cancel);
        this.mRootView.setOnClickListener(this);
        this.arR.setOnClickListener(this);
        this.arS.setOnClickListener(this);
        this.arT.setOnClickListener(this);
    }

    private void pv() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.arU != null) {
                    d.this.arU.cancel();
                }
            }
        });
    }

    private void tx() {
        if (this.arU == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.arU = new AnimatorSet();
            this.arU.playTogether(ofFloat, ofFloat2);
            this.arU.setDuration(300L);
            this.arU.setInterpolator(new LinearInterpolator());
        }
        this.arU.start();
    }
}
