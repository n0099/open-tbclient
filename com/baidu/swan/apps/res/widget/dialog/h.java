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
/* loaded from: classes10.dex */
public class h extends c {
    private a dmb;

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

    public a aEC() {
        return this.dmb;
    }

    void a(a aVar) {
        this.dmb = aVar;
    }

    /* loaded from: classes10.dex */
    public static class a {
        protected final b dmc;
        protected final h dmd;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.dmd = cs(context);
            this.dmd.a(this);
            this.dmc = new b((ViewGroup) this.dmd.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cs(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a ax(View view) {
            this.dmc.mDialogContent.removeAllViews();
            this.dmc.mDialogContent.addView(view);
            return this;
        }

        public h aEu() {
            this.dmd.setOnCancelListener(this.dmc.mOnCancelListener);
            this.dmd.setOnDismissListener(this.dmc.mOnDismissListener);
            this.dmd.setOnShowListener(this.dmc.mOnShowListener);
            this.dmd.a(this);
            return this.dmd;
        }

        public h aED() {
            h aEu = aEu();
            if (this.mSystemDialog) {
                aEu.getWindow().setType(2003);
            }
            try {
                aEu.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aEu;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dmc.mPositiveButton.setText(charSequence);
            this.dmc.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dmd.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dmd, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dmc.mNegativeButton.setText(charSequence);
            this.dmc.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dmd.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dmd, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.dmc.mOnCancelListener = onCancelListener;
            return this;
        }

        public a go(boolean z) {
            this.dmd.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public FrameLayout dlV;
        public FrameLayout dlW;
        public View dlX;
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
            this.dlW = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dlV = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dlX = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
