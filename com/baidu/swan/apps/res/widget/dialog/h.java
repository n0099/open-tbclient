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
    private a cDF;

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

    public a apv() {
        return this.cDF;
    }

    void a(a aVar) {
        this.cDF = aVar;
    }

    /* loaded from: classes11.dex */
    public static class a {
        protected final b cDG;
        protected final h cDH;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cDH = ce(context);
            this.cDH.a(this);
            this.cDG = new b((ViewGroup) this.cDH.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h ce(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a ap(View view) {
            this.cDG.mDialogContent.removeAllViews();
            this.cDG.mDialogContent.addView(view);
            return this;
        }

        public h apn() {
            this.cDH.setOnCancelListener(this.cDG.mOnCancelListener);
            this.cDH.setOnDismissListener(this.cDG.mOnDismissListener);
            this.cDH.setOnShowListener(this.cDG.mOnShowListener);
            this.cDH.a(this);
            return this.cDH;
        }

        public h apw() {
            h apn = apn();
            if (this.mSystemDialog) {
                apn.getWindow().setType(2003);
            }
            try {
                apn.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return apn;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cDG.mPositiveButton.setText(charSequence);
            this.cDG.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cDH.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cDH, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cDG.mNegativeButton.setText(charSequence);
            this.cDG.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cDH.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cDH, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.cDG.mOnCancelListener = onCancelListener;
            return this;
        }

        public a fe(boolean z) {
            this.cDH.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public FrameLayout cDA;
        public View cDB;
        public FrameLayout cDz;
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
            this.cDA = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cDz = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cDB = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
