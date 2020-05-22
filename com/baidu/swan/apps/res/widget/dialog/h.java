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
    private a cyV;

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

    public a aoo() {
        return this.cyV;
    }

    void a(a aVar) {
        this.cyV = aVar;
    }

    /* loaded from: classes11.dex */
    public static class a {
        protected final b cyW;
        protected final h cyX;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cyX = cd(context);
            this.cyX.a(this);
            this.cyW = new b((ViewGroup) this.cyX.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cd(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a ap(View view) {
            this.cyW.mDialogContent.removeAllViews();
            this.cyW.mDialogContent.addView(view);
            return this;
        }

        public h aog() {
            this.cyX.setOnCancelListener(this.cyW.mOnCancelListener);
            this.cyX.setOnDismissListener(this.cyW.mOnDismissListener);
            this.cyX.setOnShowListener(this.cyW.mOnShowListener);
            this.cyX.a(this);
            return this.cyX;
        }

        public h aop() {
            h aog = aog();
            if (this.mSystemDialog) {
                aog.getWindow().setType(2003);
            }
            try {
                aog.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aog;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cyW.mPositiveButton.setText(charSequence);
            this.cyW.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cyX.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cyX, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cyW.mNegativeButton.setText(charSequence);
            this.cyW.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cyX.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cyX, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.cyW.mOnCancelListener = onCancelListener;
            return this;
        }

        public a eZ(boolean z) {
            this.cyX.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public FrameLayout cyP;
        public FrameLayout cyQ;
        public View cyR;
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
            this.cyQ = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cyP = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cyR = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
