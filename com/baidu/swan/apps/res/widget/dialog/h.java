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
    private a dAw;

    public h(Context context, int i) {
        super(context, i);
        init();
    }

    protected void init() {
        setContentView(a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        gL(false);
    }

    public a aHI() {
        return this.dAw;
    }

    void a(a aVar) {
        this.dAw = aVar;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private boolean dAe = false;
        protected final b dAx;
        protected final h dAy;
        private Context mContext;

        public a(Context context) {
            this.dAy = dj(context);
            this.dAy.a(this);
            this.dAx = new b((ViewGroup) this.dAy.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h dj(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a aL(View view) {
            this.dAx.dzq.removeAllViews();
            this.dAx.dzq.addView(view);
            return this;
        }

        public h aHw() {
            this.dAy.setOnCancelListener(this.dAx.mOnCancelListener);
            this.dAy.setOnDismissListener(this.dAx.mOnDismissListener);
            this.dAy.setOnShowListener(this.dAx.dAj);
            this.dAy.a(this);
            return this.dAy;
        }

        public h aHJ() {
            h aHw = aHw();
            if (this.dAe) {
                aHw.getWindow().setType(2003);
            }
            try {
                aHw.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aHw;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dAx.dzk.setText(charSequence);
            this.dAx.dzk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dAy.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dAy, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dAx.dzl.setText(charSequence);
            this.dAx.dzl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dAy.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dAy, -2);
                    }
                }
            });
            return this;
        }

        public a c(DialogInterface.OnCancelListener onCancelListener) {
            this.dAx.mOnCancelListener = onCancelListener;
            return this;
        }

        public a gX(boolean z) {
            this.dAy.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public ViewGroup aXW;
        public DialogInterface.OnShowListener dAj;
        public View dAk;
        public View dAl;
        public FrameLayout dAq;
        public FrameLayout dAr;
        public View dAs;
        public TextView dzk;
        public TextView dzl;
        public FrameLayout dzq;
        public RelativeLayout dzr;
        public LinearLayout dzt;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.aXW = viewGroup;
            this.dAr = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dzk = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.dzl = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.dAk = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dzq = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.dzr = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.dzt = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.dAl = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dAq = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dAs = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
