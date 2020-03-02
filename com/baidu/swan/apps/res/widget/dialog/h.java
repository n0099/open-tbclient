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
/* loaded from: classes11.dex */
public class h extends c {
    private a bOm;

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

    public a acq() {
        return this.bOm;
    }

    void a(a aVar) {
        this.bOm = aVar;
    }

    /* loaded from: classes11.dex */
    public static class a {
        protected final b bOn;
        protected final h bOo;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bOo = cr(context);
            this.bOo.a(this);
            this.bOn = new b((ViewGroup) this.bOo.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cr(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a ao(View view) {
            this.bOn.mDialogContent.removeAllViews();
            this.bOn.mDialogContent.addView(view);
            return this;
        }

        public h aci() {
            this.bOo.setOnCancelListener(this.bOn.mOnCancelListener);
            this.bOo.setOnDismissListener(this.bOn.mOnDismissListener);
            this.bOo.setOnShowListener(this.bOn.mOnShowListener);
            this.bOo.a(this);
            return this.bOo;
        }

        public h acr() {
            h aci = aci();
            if (this.mSystemDialog) {
                aci.getWindow().setType(2003);
            }
            try {
                aci.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aci;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bOn.mPositiveButton.setText(charSequence);
            this.bOn.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bOo.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bOo, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bOn.mNegativeButton.setText(charSequence);
            this.bOn.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bOo.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bOo, -2);
                    }
                }
            });
            return this;
        }

        public a c(DialogInterface.OnCancelListener onCancelListener) {
            this.bOn.mOnCancelListener = onCancelListener;
            return this;
        }

        public a dJ(boolean z) {
            this.bOo.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public FrameLayout bOg;
        public FrameLayout bOh;
        public View bOi;
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
            this.bOh = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bOg = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bOi = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
