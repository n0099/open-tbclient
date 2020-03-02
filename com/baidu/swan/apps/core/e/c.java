package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.w;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView bpp;
    private SelectorTextView bpq;
    private a bpr;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bpr = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.bpp = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.bpp.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.bpq = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.bpq.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        Pb();
        return this.mView;
    }

    private void Pb() {
        if (this.bpr == null) {
            return;
        }
        this.bpp.setText(this.mContext.getText(this.bpr.mMessageId));
        this.bpp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bpr.bpw != null) {
                    c.this.bpr.bpw.onItemClick(view);
                }
            }
        });
        if (this.bpr.bpt > 0) {
            this.bpq.setVisibility(0);
            this.bpq.setText(this.mContext.getText(this.bpr.bpt));
            this.bpq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bpr.bpv != null) {
                        c.this.bpr.bpv.onItemClick(view);
                    }
                }
            });
        } else {
            this.bpq.setVisibility(8);
        }
        if (this.bpr.bpu <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.bpr.bpu);
        w.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, af.dip2px(this.mContext, 12.0f), af.dip2px(this.mContext, 12.0f));
        this.bpq.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0282b {
        private int bpt;
        private int bpu;
        public b.c bpv;
        public b.c bpw;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0282b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bX(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eA */
        public a eD(int i) {
            super.eD(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eB */
        public a eC(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.bpw = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0282b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g Pc() {
            c cVar = (c) super.Pc();
            cVar.a(this);
            return cVar;
        }
    }
}
