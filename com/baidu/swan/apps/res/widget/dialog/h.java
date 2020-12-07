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
/* loaded from: classes25.dex */
public class h extends c {
    private a dxq;

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

    public a aJC() {
        return this.dxq;
    }

    void a(a aVar) {
        this.dxq = aVar;
    }

    /* loaded from: classes25.dex */
    public static class a {
        protected final b dxr;
        protected final h dxs;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.dxs = cY(context);
            this.dxs.a(this);
            this.dxr = new b((ViewGroup) this.dxs.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cY(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a aD(View view) {
            this.dxr.mDialogContent.removeAllViews();
            this.dxr.mDialogContent.addView(view);
            return this;
        }

        public h aJu() {
            this.dxs.setOnCancelListener(this.dxr.mOnCancelListener);
            this.dxs.setOnDismissListener(this.dxr.mOnDismissListener);
            this.dxs.setOnShowListener(this.dxr.mOnShowListener);
            this.dxs.a(this);
            return this.dxs;
        }

        public h aJD() {
            h aJu = aJu();
            if (this.mSystemDialog) {
                aJu.getWindow().setType(2003);
            }
            try {
                aJu.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aJu;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dxr.mPositiveButton.setText(charSequence);
            this.dxr.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dxs.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dxs, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dxr.mNegativeButton.setText(charSequence);
            this.dxr.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dxs.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dxs, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.dxr.mOnCancelListener = onCancelListener;
            return this;
        }

        public a gP(boolean z) {
            this.dxs.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes25.dex */
    public static class b {
        public FrameLayout dxk;
        public FrameLayout dxl;
        public View dxm;
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
            this.dxl = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dxk = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dxm = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
