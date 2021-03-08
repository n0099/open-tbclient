package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.z;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView cVd;
    private SelectorTextView cVe;
    private a cVf;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cVf = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View D(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cVd = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cVd.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cVe = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cVe.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        aqm();
        return this.mView;
    }

    private void aqm() {
        if (this.cVf == null) {
            return;
        }
        this.cVd.setText(this.mContext.getText(this.cVf.mMessageId));
        this.cVd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cVf.cVk != null) {
                    c.this.cVf.cVk.az(view);
                }
            }
        });
        if (this.cVf.cVh > 0) {
            this.cVe.setVisibility(0);
            this.cVe.setText(this.mContext.getText(this.cVf.cVh));
            this.cVe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cVf.cVj != null) {
                        c.this.cVf.cVj.az(view);
                    }
                }
            });
        } else {
            this.cVe.setVisibility(8);
        }
        if (this.cVf.cVi <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cVf.cVi);
        z.a(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.cVe.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes8.dex */
    public static class a extends b.C0458b {
        private int cVh;
        private int cVi;
        public b.c cVj;
        public b.c cVk;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0458b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cI(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: gP */
        public a gS(int i) {
            super.gS(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: gQ */
        public a gR(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cVk = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0458b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g aqn() {
            c cVar = (c) super.aqn();
            cVar.a(this);
            return cVar;
        }
    }
}
