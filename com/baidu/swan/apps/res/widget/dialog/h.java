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
    private a dFi;

    public h(Context context, int i) {
        super(context, i);
        init();
    }

    protected void init() {
        setContentView(a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        gP(false);
    }

    public a aLC() {
        return this.dFi;
    }

    void a(a aVar) {
        this.dFi = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a {
        private boolean dEQ = false;
        protected final b dFj;
        protected final h dFk;
        private Context mContext;

        public a(Context context) {
            this.dFk = dk(context);
            this.dFk.a(this);
            this.dFj = new b((ViewGroup) this.dFk.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h dk(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a aL(View view) {
            this.dFj.dEc.removeAllViews();
            this.dFj.dEc.addView(view);
            return this;
        }

        public h aLq() {
            this.dFk.setOnCancelListener(this.dFj.mOnCancelListener);
            this.dFk.setOnDismissListener(this.dFj.mOnDismissListener);
            this.dFk.setOnShowListener(this.dFj.dEV);
            this.dFk.a(this);
            return this.dFk;
        }

        public h aLD() {
            h aLq = aLq();
            if (this.dEQ) {
                aLq.getWindow().setType(2003);
            }
            try {
                aLq.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aLq;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dFj.dDW.setText(charSequence);
            this.dFj.dDW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dFk.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dFk, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dFj.dDX.setText(charSequence);
            this.dFj.dDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dFk.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dFk, -2);
                    }
                }
            });
            return this;
        }

        public a c(DialogInterface.OnCancelListener onCancelListener) {
            this.dFj.mOnCancelListener = onCancelListener;
            return this;
        }

        public a hb(boolean z) {
            this.dFk.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public ViewGroup bcK;
        public TextView dDW;
        public TextView dDX;
        public DialogInterface.OnShowListener dEV;
        public View dEW;
        public View dEX;
        public FrameLayout dEc;
        public RelativeLayout dEd;
        public LinearLayout dEf;
        public FrameLayout dFc;
        public FrameLayout dFd;
        public View dFe;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.bcK = viewGroup;
            this.dFd = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dDW = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.dDX = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.dEW = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dEc = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.dEd = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.dEf = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.dEX = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dFc = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dFe = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
