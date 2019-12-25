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
/* loaded from: classes9.dex */
public class h extends c {
    private a bJw;

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

    public a ZD() {
        return this.bJw;
    }

    void a(a aVar) {
        this.bJw = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a {
        protected final b bJx;
        protected final h bJy;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bJy = cn(context);
            this.bJy.a(this);
            this.bJx = new b((ViewGroup) this.bJy.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cn(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a ak(View view) {
            this.bJx.mDialogContent.removeAllViews();
            this.bJx.mDialogContent.addView(view);
            return this;
        }

        public h Zv() {
            this.bJy.setOnCancelListener(this.bJx.mOnCancelListener);
            this.bJy.setOnDismissListener(this.bJx.mOnDismissListener);
            this.bJy.setOnShowListener(this.bJx.mOnShowListener);
            this.bJy.a(this);
            return this.bJy;
        }

        public h ZE() {
            h Zv = Zv();
            if (this.mSystemDialog) {
                Zv.getWindow().setType(2003);
            }
            try {
                Zv.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return Zv;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bJx.mPositiveButton.setText(charSequence);
            this.bJx.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bJy.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bJy, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bJx.mNegativeButton.setText(charSequence);
            this.bJx.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bJy.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bJy, -2);
                    }
                }
            });
            return this;
        }

        public a c(DialogInterface.OnCancelListener onCancelListener) {
            this.bJx.mOnCancelListener = onCancelListener;
            return this;
        }

        public a dx(boolean z) {
            this.bJy.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public FrameLayout bJq;
        public FrameLayout bJr;
        public View bJs;
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
            this.bJr = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bJq = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bJs = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
