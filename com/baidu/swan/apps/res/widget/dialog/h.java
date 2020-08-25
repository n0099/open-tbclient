package com.baidu.swan.apps.res.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
/* loaded from: classes8.dex */
public class h extends c {
    private a cPq;

    public h(Context context, int i) {
        super(context, i);
        init();
    }

    protected void init() {
        setContentView(a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        setEnableImmersion(false);
    }

    public a azq() {
        return this.cPq;
    }

    void a(a aVar) {
        this.cPq = aVar;
    }

    /* loaded from: classes8.dex */
    public static class a {
        protected final b cPr;
        protected final h cPs;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cPs = cn(context);
            this.cPs.a(this);
            this.cPr = new b((ViewGroup) this.cPs.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cn(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a at(View view) {
            this.cPr.mDialogContent.removeAllViews();
            this.cPr.mDialogContent.addView(view);
            return this;
        }

        public h azi() {
            this.cPs.setOnCancelListener(this.cPr.mOnCancelListener);
            this.cPs.setOnDismissListener(this.cPr.mOnDismissListener);
            this.cPs.setOnShowListener(this.cPr.mOnShowListener);
            this.cPs.a(this);
            return this.cPs;
        }

        public h azr() {
            h azi = azi();
            if (this.mSystemDialog) {
                azi.getWindow().setType(2003);
            }
            try {
                azi.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return azi;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cPr.mPositiveButton.setText(charSequence);
            this.cPr.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cPs.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cPs, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cPr.mNegativeButton.setText(charSequence);
            this.cPr.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cPs.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cPs, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.cPr.mOnCancelListener = onCancelListener;
            return this;
        }

        public a fG(boolean z) {
            this.cPs.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public FrameLayout cPk;
        public FrameLayout cPl;
        public View cPm;
        public LinearLayout mBtnPanelLayout;
        public View mCustomPanel;
        public FrameLayout mDialogContent;
        public View mDialogContentPanel;
        public RelativeLayout mDialogLayout;
        public TextView mNegativeButton;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnShowListener mOnShowListener;
        public TextView mPositiveButton;
        public ViewGroup mRoot;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.cPl = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cPk = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cPm = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
