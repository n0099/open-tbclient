package com.baidu.ar.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ar.util.Res;
/* loaded from: classes3.dex */
public class a extends Dialog {
    private C0050a a;

    /* renamed from: com.baidu.ar.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0050a {
        private final b a;
        private final a b;
        private Context c;
        private boolean d = false;

        public C0050a(Context context) {
            this.b = a(context);
            this.b.a(this);
            this.a = new b((ViewGroup) this.b.getWindow().getDecorView());
            this.c = context;
        }

        public C0050a a(CharSequence charSequence) {
            if (charSequence != null) {
                this.a.a.setText(charSequence);
            }
            return this;
        }

        public C0050a a(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.a.d.setVisibility(8);
                if (this.a.e.getVisibility() == 0) {
                    this.a.h.setVisibility(8);
                }
            } else {
                this.a.d.setVisibility(0);
                if (this.a.e.getVisibility() == 0) {
                    this.a.h.setVisibility(0);
                }
                this.a.d.setText(charSequence);
                this.a.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C0050a.this.b.a(-1);
                        C0050a.this.b.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(C0050a.this.b, -1);
                        }
                    }
                });
            }
            return this;
        }

        public C0050a a(String str) {
            if (this.a.c.getVisibility() != 0) {
                this.a.c.setVisibility(0);
            }
            if (str != null) {
                this.a.b.setText(str);
            }
            return this;
        }

        public a a() {
            this.b.setCancelable(this.a.j.booleanValue());
            if (this.a.j.booleanValue()) {
                this.b.setCanceledOnTouchOutside(false);
            }
            this.b.setOnCancelListener(this.a.k);
            this.b.setOnDismissListener(this.a.l);
            if (this.a.n != null) {
                this.b.setOnKeyListener(this.a.n);
            }
            this.b.a(this);
            return this.b;
        }

        protected a a(Context context) {
            return new a(context, Res.getStyle("NoTitleDialog"));
        }

        public C0050a b(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            if (TextUtils.isEmpty(charSequence)) {
                this.a.e.setVisibility(8);
                if (this.a.d.getVisibility() == 0) {
                    this.a.h.setVisibility(8);
                }
            } else {
                this.a.e.setVisibility(0);
                if (this.a.d.getVisibility() == 0) {
                    this.a.h.setVisibility(0);
                }
                this.a.e.setText(charSequence);
                this.a.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.ui.a.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C0050a.this.b.a(-2);
                        C0050a.this.b.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(C0050a.this.b, -2);
                        }
                    }
                });
            }
            return this;
        }
    }

    /* loaded from: classes3.dex */
    private static class b {
        private TextView a;
        private TextView b;
        private LinearLayout c;
        private TextView d;
        private TextView e;
        private TextView f;
        private View g;
        private View h;
        private View i;
        private Boolean j = true;
        private DialogInterface.OnCancelListener k;
        private DialogInterface.OnDismissListener l;
        private FrameLayout m;
        private DialogInterface.OnKeyListener n;
        private ImageView o;
        private LinearLayout p;

        public b(ViewGroup viewGroup) {
            viewGroup.getContext();
            this.a = (TextView) viewGroup.findViewById(Res.id("dialog_title"));
            this.b = (TextView) viewGroup.findViewById(Res.id("dialog_message"));
            this.c = (LinearLayout) viewGroup.findViewById(Res.id("dialog_message_content"));
            this.d = (TextView) viewGroup.findViewById(Res.id("positive_button"));
            this.e = (TextView) viewGroup.findViewById(Res.id("negative_button"));
            this.f = (TextView) viewGroup.findViewById(Res.id("neutral_button"));
            this.h = viewGroup.findViewById(Res.id("divider3"));
            this.i = viewGroup.findViewById(Res.id("divider4"));
            this.m = (FrameLayout) viewGroup.findViewById(Res.id("dialog_custom_content"));
            this.o = (ImageView) viewGroup.findViewById(Res.id("dialog_icon"));
            this.p = (LinearLayout) viewGroup.findViewById(Res.id("searchbox_alert_dialog"));
            this.g = viewGroup.findViewById(Res.id("divider2"));
        }
    }

    protected a(Context context, int i) {
        super(context, i);
        a(context);
    }

    private void a(Context context) {
        setContentView(Res.inflate("bdar_layout_alert_dialog"));
        getWindow().setLayout(-1, -1);
        Res.addResource(context);
    }

    protected void a(int i) {
    }

    void a(C0050a c0050a) {
        this.a = c0050a;
    }
}
