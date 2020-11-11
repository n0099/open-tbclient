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
    private a drX;

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

    public a aHc() {
        return this.drX;
    }

    void a(a aVar) {
        this.drX = aVar;
    }

    /* loaded from: classes10.dex */
    public static class a {
        protected final b drY;
        protected final h drZ;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.drZ = cs(context);
            this.drZ.a(this);
            this.drY = new b((ViewGroup) this.drZ.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cs(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a aB(View view) {
            this.drY.mDialogContent.removeAllViews();
            this.drY.mDialogContent.addView(view);
            return this;
        }

        public h aGU() {
            this.drZ.setOnCancelListener(this.drY.mOnCancelListener);
            this.drZ.setOnDismissListener(this.drY.mOnDismissListener);
            this.drZ.setOnShowListener(this.drY.mOnShowListener);
            this.drZ.a(this);
            return this.drZ;
        }

        public h aHd() {
            h aGU = aGU();
            if (this.mSystemDialog) {
                aGU.getWindow().setType(2003);
            }
            try {
                aGU.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aGU;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.drY.mPositiveButton.setText(charSequence);
            this.drY.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.drZ.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.drZ, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.drY.mNegativeButton.setText(charSequence);
            this.drY.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.drZ.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.drZ, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.drY.mOnCancelListener = onCancelListener;
            return this;
        }

        public a gx(boolean z) {
            this.drZ.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public FrameLayout drR;
        public FrameLayout drS;
        public View drT;
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
            this.drS = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.drR = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.drT = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
