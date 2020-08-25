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
/* loaded from: classes7.dex */
public class d implements View.OnClickListener {
    private TextView aAw;
    private a bti;
    private ImageView btj;
    private TextView btk;
    private TextView btl;
    private AnimatorSet btm;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes7.dex */
    public interface a {
        void Nb();

        void Nc();
    }

    public d(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.bti = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void cK(boolean z) {
        if (this.btj != null) {
            this.btj.setVisibility(z ? 0 : 8);
        }
    }

    public void o(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.aAw.setText(str2);
        this.btk.setText(str3);
        this.btl.setText(str4);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            Kl();
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
        if (view == this.mRootView || view == this.btj || view == this.btk || view == this.btl) {
            dismiss();
        }
        if (this.bti != null) {
            if (view == this.btk) {
                this.bti.Nb();
            } else if (view == this.btl) {
                this.bti.Nc();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        Mt();
        initView();
        Ey();
    }

    private void Mt() {
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
        this.btj = (ImageView) this.mRootView.findViewById(a.g.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.aAw = (TextView) this.mRootView.findViewById(a.g.tv_content);
        this.btk = (TextView) this.mRootView.findViewById(a.g.tv_confirm);
        this.btl = (TextView) this.mRootView.findViewById(a.g.tv_cancel);
        this.mRootView.setOnClickListener(this);
        this.btj.setOnClickListener(this);
        this.btk.setOnClickListener(this);
        this.btl.setOnClickListener(this);
    }

    private void Ey() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.btm != null) {
                    d.this.btm.cancel();
                }
            }
        });
    }

    private void Kl() {
        if (this.btm == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.btm = new AnimatorSet();
            this.btm.playTogether(ofFloat, ofFloat2);
            this.btm.setDuration(300L);
            this.btm.setInterpolator(new LinearInterpolator());
        }
        this.btm.start();
    }
}
