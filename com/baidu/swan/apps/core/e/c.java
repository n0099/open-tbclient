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
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView bkp;
    private SelectorTextView bkq;
    private a bkr;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bkr = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.bkp = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.bkp.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.bkq = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.bkq.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        Mp();
        return this.mView;
    }

    private void Mp() {
        if (this.bkr == null) {
            return;
        }
        this.bkp.setText(this.mContext.getText(this.bkr.mMessageId));
        this.bkp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bkr.bkw != null) {
                    c.this.bkr.bkw.onItemClick(view);
                }
            }
        });
        if (this.bkr.bkt > 0) {
            this.bkq.setVisibility(0);
            this.bkq.setText(this.mContext.getText(this.bkr.bkt));
            this.bkq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bkr.bkv != null) {
                        c.this.bkr.bkv.onItemClick(view);
                    }
                }
            });
        } else {
            this.bkq.setVisibility(8);
        }
        if (this.bkr.bku <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.bkr.bku);
        w.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, af.dip2px(this.mContext, 12.0f), af.dip2px(this.mContext, 12.0f));
        this.bkq.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes9.dex */
    public static class a extends b.C0270b {
        private int bkt;
        private int bku;
        public b.c bkv;
        public b.c bkw;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0270b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bT(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ej */
        public a em(int i) {
            super.em(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ek */
        public a el(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.bkw = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0270b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g Mq() {
            c cVar = (c) super.Mq();
            cVar.a(this);
            return cVar;
        }
    }
}
