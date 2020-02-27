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
    private TextView bpo;
    private SelectorTextView bpp;
    private a bpq;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bpq = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.bpo = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.bpo.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.bpp = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.bpp.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        OZ();
        return this.mView;
    }

    private void OZ() {
        if (this.bpq == null) {
            return;
        }
        this.bpo.setText(this.mContext.getText(this.bpq.mMessageId));
        this.bpo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bpq.bpv != null) {
                    c.this.bpq.bpv.onItemClick(view);
                }
            }
        });
        if (this.bpq.bps > 0) {
            this.bpp.setVisibility(0);
            this.bpp.setText(this.mContext.getText(this.bpq.bps));
            this.bpp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bpq.bpu != null) {
                        c.this.bpq.bpu.onItemClick(view);
                    }
                }
            });
        } else {
            this.bpp.setVisibility(8);
        }
        if (this.bpq.bpt <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.bpq.bpt);
        w.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, af.dip2px(this.mContext, 12.0f), af.dip2px(this.mContext, 12.0f));
        this.bpp.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0282b {
        private int bps;
        private int bpt;
        public b.c bpu;
        public b.c bpv;
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
            this.bpv = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0282b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g Pa() {
            c cVar = (c) super.Pa();
            cVar.a(this);
            return cVar;
        }
    }
}
