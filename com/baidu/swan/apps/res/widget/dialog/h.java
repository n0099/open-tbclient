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
/* loaded from: classes8.dex */
public class h extends c {
    private a dEc;

    public h(Context context, int i) {
        super(context, i);
        init();
    }

    protected void init() {
        setContentView(a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        gN(false);
    }

    public a aIe() {
        return this.dEc;
    }

    void a(a aVar) {
        this.dEc = aVar;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private boolean dDK = false;
        protected final b dEd;
        protected final h dEe;
        private Context mContext;

        public a(Context context) {
            this.dEe = dh(context);
            this.dEe.a(this);
            this.dEd = new b((ViewGroup) this.dEe.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h dh(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a aH(View view) {
            this.dEd.dCW.removeAllViews();
            this.dEd.dCW.addView(view);
            return this;
        }

        public h aHS() {
            this.dEe.setOnCancelListener(this.dEd.mOnCancelListener);
            this.dEe.setOnDismissListener(this.dEd.mOnDismissListener);
            this.dEe.setOnShowListener(this.dEd.dDP);
            this.dEe.a(this);
            return this.dEe;
        }

        public h aIf() {
            h aHS = aHS();
            if (this.dDK) {
                aHS.getWindow().setType(2003);
            }
            try {
                aHS.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aHS;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dEd.dCQ.setText(charSequence);
            this.dEd.dCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dEe.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dEe, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dEd.dCR.setText(charSequence);
            this.dEd.dCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dEe.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dEe, -2);
                    }
                }
            });
            return this;
        }

        public a c(DialogInterface.OnCancelListener onCancelListener) {
            this.dEd.mOnCancelListener = onCancelListener;
            return this;
        }

        public a gZ(boolean z) {
            this.dEe.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public ViewGroup bcD;
        public TextView dCQ;
        public TextView dCR;
        public FrameLayout dCW;
        public RelativeLayout dCX;
        public LinearLayout dCZ;
        public DialogInterface.OnShowListener dDP;
        public View dDQ;
        public View dDR;
        public FrameLayout dDW;
        public FrameLayout dDX;
        public View dDY;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.bcD = viewGroup;
            this.dDX = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dCQ = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.dCR = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.dDQ = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dCW = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.dCX = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.dCZ = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.dDR = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dDW = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dDY = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
