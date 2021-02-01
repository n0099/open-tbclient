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
    private a dCB;

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

    public a aIb() {
        return this.dCB;
    }

    void a(a aVar) {
        this.dCB = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a {
        protected final b dCC;
        protected final h dCD;
        private boolean dCj = false;
        private Context mContext;

        public a(Context context) {
            this.dCD = di(context);
            this.dCD.a(this);
            this.dCC = new b((ViewGroup) this.dCD.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h di(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a aH(View view) {
            this.dCC.dBv.removeAllViews();
            this.dCC.dBv.addView(view);
            return this;
        }

        public h aHP() {
            this.dCD.setOnCancelListener(this.dCC.mOnCancelListener);
            this.dCD.setOnDismissListener(this.dCC.mOnDismissListener);
            this.dCD.setOnShowListener(this.dCC.dCo);
            this.dCD.a(this);
            return this.dCD;
        }

        public h aIc() {
            h aHP = aHP();
            if (this.dCj) {
                aHP.getWindow().setType(2003);
            }
            try {
                aHP.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aHP;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dCC.dBp.setText(charSequence);
            this.dCC.dBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dCD.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dCD, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dCC.dBq.setText(charSequence);
            this.dCC.dBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dCD.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dCD, -2);
                    }
                }
            });
            return this;
        }

        public a c(DialogInterface.OnCancelListener onCancelListener) {
            this.dCC.mOnCancelListener = onCancelListener;
            return this;
        }

        public a gZ(boolean z) {
            this.dCD.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public ViewGroup bbd;
        public TextView dBp;
        public TextView dBq;
        public FrameLayout dBv;
        public RelativeLayout dBw;
        public LinearLayout dBy;
        public DialogInterface.OnShowListener dCo;
        public View dCp;
        public View dCq;
        public FrameLayout dCv;
        public FrameLayout dCw;
        public View dCx;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.bbd = viewGroup;
            this.dCw = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dBp = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.dBq = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.dCp = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dBv = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.dBw = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.dBy = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.dCq = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dCv = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dCx = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
