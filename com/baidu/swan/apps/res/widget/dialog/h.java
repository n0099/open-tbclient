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
/* loaded from: classes3.dex */
public class h extends c {
    private a cRu;

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

    public a azZ() {
        return this.cRu;
    }

    void a(a aVar) {
        this.cRu = aVar;
    }

    /* loaded from: classes3.dex */
    public static class a {
        protected final b cRv;
        protected final h cRw;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cRw = cm(context);
            this.cRw.a(this);
            this.cRv = new b((ViewGroup) this.cRw.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cm(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a av(View view) {
            this.cRv.mDialogContent.removeAllViews();
            this.cRv.mDialogContent.addView(view);
            return this;
        }

        public h azR() {
            this.cRw.setOnCancelListener(this.cRv.mOnCancelListener);
            this.cRw.setOnDismissListener(this.cRv.mOnDismissListener);
            this.cRw.setOnShowListener(this.cRv.mOnShowListener);
            this.cRw.a(this);
            return this.cRw;
        }

        public h aAa() {
            h azR = azR();
            if (this.mSystemDialog) {
                azR.getWindow().setType(2003);
            }
            try {
                azR.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return azR;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cRv.mPositiveButton.setText(charSequence);
            this.cRv.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cRw.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cRw, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cRv.mNegativeButton.setText(charSequence);
            this.cRv.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cRw.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cRw, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.cRv.mOnCancelListener = onCancelListener;
            return this;
        }

        public a fF(boolean z) {
            this.cRw.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public FrameLayout cRo;
        public FrameLayout cRp;
        public View cRq;
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
            this.cRp = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cRo = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cRq = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
