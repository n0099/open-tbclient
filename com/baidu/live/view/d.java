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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes2.dex */
public class d implements View.OnClickListener {
    private a aAo;
    private ImageView aAp;
    private TextView aAq;
    private TextView aAr;
    private AnimatorSet aAs;
    private TextView aqn;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes2.dex */
    public interface a {
        void yV();

        void yW();
    }

    public d(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.aAo = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void bq(boolean z) {
        if (this.aAp != null) {
            this.aAp.setVisibility(z ? 0 : 8);
        }
    }

    public void k(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.aqn.setText(str2);
        this.aAq.setText(str3);
        this.aAr.setText(str4);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            vI();
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
        if (view == this.mRootView || view == this.aAp || view == this.aAq || view == this.aAr) {
            dismiss();
        }
        if (this.aAo != null) {
            if (view == this.aAq) {
                this.aAo.yV();
            } else if (view == this.aAr) {
                this.aAo.yW();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        initWindow();
        initView();
        re();
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
        this.aAp = (ImageView) this.mRootView.findViewById(a.g.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.aqn = (TextView) this.mRootView.findViewById(a.g.tv_content);
        this.aAq = (TextView) this.mRootView.findViewById(a.g.tv_confirm);
        this.aAr = (TextView) this.mRootView.findViewById(a.g.tv_cancel);
        this.mRootView.setOnClickListener(this);
        this.aAp.setOnClickListener(this);
        this.aAq.setOnClickListener(this);
        this.aAr.setOnClickListener(this);
    }

    private void re() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.aAs != null) {
                    d.this.aAs.cancel();
                }
            }
        });
    }

    private void vI() {
        if (this.aAs == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.aAs = new AnimatorSet();
            this.aAs.playTogether(ofFloat, ofFloat2);
            this.aAs.setDuration(300L);
            this.aAs.setInterpolator(new LinearInterpolator());
        }
        this.aAs.start();
    }
}
