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
    private a ddB;

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

    public a aCI() {
        return this.ddB;
    }

    void a(a aVar) {
        this.ddB = aVar;
    }

    /* loaded from: classes10.dex */
    public static class a {
        protected final b ddC;
        protected final h ddD;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.ddD = cs(context);
            this.ddD.a(this);
            this.ddC = new b((ViewGroup) this.ddD.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cs(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a aw(View view) {
            this.ddC.mDialogContent.removeAllViews();
            this.ddC.mDialogContent.addView(view);
            return this;
        }

        public h aCA() {
            this.ddD.setOnCancelListener(this.ddC.mOnCancelListener);
            this.ddD.setOnDismissListener(this.ddC.mOnDismissListener);
            this.ddD.setOnShowListener(this.ddC.mOnShowListener);
            this.ddD.a(this);
            return this.ddD;
        }

        public h aCJ() {
            h aCA = aCA();
            if (this.mSystemDialog) {
                aCA.getWindow().setType(2003);
            }
            try {
                aCA.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aCA;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.ddC.mPositiveButton.setText(charSequence);
            this.ddC.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ddD.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.ddD, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.ddC.mNegativeButton.setText(charSequence);
            this.ddC.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ddD.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.ddD, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.ddC.mOnCancelListener = onCancelListener;
            return this;
        }

        public a gb(boolean z) {
            this.ddD.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public FrameLayout ddv;
        public FrameLayout ddw;
        public View ddx;
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
            this.ddw = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.ddv = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.ddx = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
