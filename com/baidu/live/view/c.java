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
    private TextView aDw;
    private a bJV;
    private ImageView bJW;
    private TextView bJX;
    private TextView bJY;
    private AnimatorSet bJZ;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private TextView mTitleTextView;

    /* loaded from: classes4.dex */
    public interface a {
        void OZ();

        void Pa();
    }

    public c(Context context) {
        this.mContext = context;
        initDialog();
    }

    public void a(a aVar) {
        this.bJV = aVar;
    }

    public void setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        this.mRootView.setOnClickListener(null);
    }

    public void di(boolean z) {
        if (this.bJW != null) {
            this.bJW.setVisibility(z ? 0 : 8);
        }
    }

    public void dj(boolean z) {
        if (this.aDw != null) {
            this.aDw.setVisibility(z ? 0 : 8);
        }
    }

    public void o(String str, String str2, String str3, String str4) {
        this.mTitleTextView.setText(str);
        this.aDw.setText(str2);
        this.bJX.setText(str3);
        this.bJY.setText(str4);
    }

    public void gn(int i) {
        this.aDw.setTextColor(i);
    }

    public void dk(boolean z) {
        this.mTitleTextView.setSingleLine(z);
    }

    public void dl(boolean z) {
        this.mTitleTextView.setTypeface(Typeface.defaultFromStyle(z ? 1 : 0));
    }

    public void B(float f) {
        this.mTitleTextView.setLineSpacing(f, 1.0f);
    }

    public void setTitleTextSize(float f) {
        this.mTitleTextView.setTextSize(0, f);
    }

    public void C(float f) {
        this.aDw.setTextSize(0, f);
    }

    public void gp(int i) {
        this.bJX.setTextColor(i);
    }

    public void gq(int i) {
        this.bJY.setTextColor(i);
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            Mi();
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
        if (view == this.mRootView || view == this.bJW || view == this.bJX || view == this.bJY) {
            dismiss();
        }
        if (this.bJV != null) {
            if (view == this.bJX) {
                this.bJV.OZ();
            } else if (view == this.bJY) {
                this.bJV.Pa();
            }
        }
    }

    private void initDialog() {
        this.mDialog = new d(this.mContext);
        Ov();
        initView();
        FS();
    }

    private void Ov() {
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
        this.bJW = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.aDw = (TextView) this.mRootView.findViewById(a.f.tv_content);
        this.bJX = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.bJY = (TextView) this.mRootView.findViewById(a.f.tv_cancel);
        this.mRootView.setOnClickListener(this);
        this.bJW.setOnClickListener(this);
        this.bJX.setOnClickListener(this);
        this.bJY.setOnClickListener(this);
    }

    private void FS() {
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.view.c.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.bJZ != null) {
                    c.this.bJZ.cancel();
                }
            }
        });
    }

    private void Mi() {
        if (this.bJZ == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bJZ = new AnimatorSet();
            this.bJZ.playTogether(ofFloat, ofFloat2);
            this.bJZ.setDuration(300L);
            this.bJZ.setInterpolator(new LinearInterpolator());
        }
        this.bJZ.start();
    }
}
