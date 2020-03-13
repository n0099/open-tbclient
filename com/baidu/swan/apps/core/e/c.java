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
    private TextView bpq;
    private SelectorTextView bpr;
    private a bps;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bps = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.bpq = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.bpq.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.bpr = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.bpr.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        Pb();
        return this.mView;
    }

    private void Pb() {
        if (this.bps == null) {
            return;
        }
        this.bpq.setText(this.mContext.getText(this.bps.mMessageId));
        this.bpq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bps.bpx != null) {
                    c.this.bps.bpx.onItemClick(view);
                }
            }
        });
        if (this.bps.bpu > 0) {
            this.bpr.setVisibility(0);
            this.bpr.setText(this.mContext.getText(this.bps.bpu));
            this.bpr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bps.bpw != null) {
                        c.this.bps.bpw.onItemClick(view);
                    }
                }
            });
        } else {
            this.bpr.setVisibility(8);
        }
        if (this.bps.bpv <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.bps.bpv);
        w.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, af.dip2px(this.mContext, 12.0f), af.dip2px(this.mContext, 12.0f));
        this.bpr.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0282b {
        private int bpu;
        private int bpv;
        public b.c bpw;
        public b.c bpx;
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
            this.bpx = cVar;
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
