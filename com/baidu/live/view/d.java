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
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private a aEE;
    private ImageView aEF;
    private TextView aEG;
    private TextView aEH;
    private AnimatorSet aEI;
    private TextView atX;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes3.dex */
    public interface a {
        void Bl();

        void Bm();
    }

    public d(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.aEE = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void by(boolean z) {
        if (this.aEF != null) {
            this.aEF.setVisibility(z ? 0 : 8);
        }
    }

    public void n(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.atX.setText(str2);
        this.aEG.setText(str3);
        this.aEH.setText(str4);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            xG();
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
        if (view == this.mRootView || view == this.aEF || view == this.aEG || view == this.aEH) {
            dismiss();
        }
        if (this.aEE != null) {
            if (view == this.aEG) {
                this.aEE.Bl();
            } else if (view == this.aEH) {
                this.aEE.Bm();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        initWindow();
        initView();
        sf();
    }

    private void initWindow() {
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
        this.aEF = (ImageView) this.mRootView.findViewById(a.g.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.atX = (TextView) this.mRootView.findViewById(a.g.tv_content);
        this.aEG = (TextView) this.mRootView.findViewById(a.g.tv_confirm);
        this.aEH = (TextView) this.mRootView.findViewById(a.g.tv_cancel);
        this.mRootView.setOnClickListener(this);
        this.aEF.setOnClickListener(this);
        this.aEG.setOnClickListener(this);
        this.aEH.setOnClickListener(this);
    }

    private void sf() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.aEI != null) {
                    d.this.aEI.cancel();
                }
            }
        });
    }

    private void xG() {
        if (this.aEI == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.aEI = new AnimatorSet();
            this.aEI.playTogether(ofFloat, ofFloat2);
            this.aEI.setDuration(300L);
            this.aEI.setInterpolator(new LinearInterpolator());
        }
        this.aEI.start();
    }
}
