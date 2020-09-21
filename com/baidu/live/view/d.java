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
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private TextView aBe;
    private a bwC;
    private ImageView bwD;
    private TextView bwE;
    private TextView bwF;
    private AnimatorSet bwG;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void NF();

        void NG();
    }

    public d(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.bwC = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void cM(boolean z) {
        if (this.bwD != null) {
            this.bwD.setVisibility(z ? 0 : 8);
        }
    }

    public void o(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.aBe.setText(str2);
        this.bwE.setText(str3);
        this.bwF.setText(str4);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            KS();
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
        if (view == this.mRootView || view == this.bwD || view == this.bwE || view == this.bwF) {
            dismiss();
        }
        if (this.bwC != null) {
            if (view == this.bwE) {
                this.bwC.NF();
            } else if (view == this.bwF) {
                this.bwC.NG();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        Nb();
        initView();
        EP();
    }

    private void Nb() {
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
        this.bwD = (ImageView) this.mRootView.findViewById(a.g.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.aBe = (TextView) this.mRootView.findViewById(a.g.tv_content);
        this.bwE = (TextView) this.mRootView.findViewById(a.g.tv_confirm);
        this.bwF = (TextView) this.mRootView.findViewById(a.g.tv_cancel);
        this.mRootView.setOnClickListener(this);
        this.bwD.setOnClickListener(this);
        this.bwE.setOnClickListener(this);
        this.bwF.setOnClickListener(this);
    }

    private void EP() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.bwG != null) {
                    d.this.bwG.cancel();
                }
            }
        });
    }

    private void KS() {
        if (this.bwG == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bwG = new AnimatorSet();
            this.bwG.playTogether(ofFloat, ofFloat2);
            this.bwG.setDuration(300L);
            this.bwG.setInterpolator(new LinearInterpolator());
        }
        this.bwG.start();
    }
}
