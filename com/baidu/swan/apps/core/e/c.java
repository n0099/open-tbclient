package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.z;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes3.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView clp;
    private SelectorTextView clq;
    private a clr;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.clr = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.clp = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.clp.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.clq = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.clq.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        aiI();
        return this.mView;
    }

    private void aiI() {
        if (this.clr == null) {
            return;
        }
        this.clp.setText(this.mContext.getText(this.clr.mMessageId));
        this.clp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.clr.clw != null) {
                    c.this.clr.clw.onItemClick(view);
                }
            }
        });
        if (this.clr.clt > 0) {
            this.clq.setVisibility(0);
            this.clq.setText(this.mContext.getText(this.clr.clt));
            this.clq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.clr.clv != null) {
                        c.this.clr.clv.onItemClick(view);
                    }
                }
            });
        } else {
            this.clq.setVisibility(8);
        }
        if (this.clr.clu <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.clr.clu);
        z.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.clq.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes3.dex */
    public static class a extends b.C0426b {
        private int clt;
        private int clu;
        public b.c clv;
        public b.c clw;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0426b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bR(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hk */
        public a hn(int i) {
            super.hn(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hl */
        public a hm(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.clw = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0426b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g aiJ() {
            c cVar = (c) super.aiJ();
            cVar.a(this);
            return cVar;
        }
    }
}
