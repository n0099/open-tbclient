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
    private TextView bNO;
    private SelectorTextView bNP;
    private a bNQ;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bNQ = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.bNO = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.bNO.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.bNP = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.bNP.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        WS();
        return this.mView;
    }

    private void WS() {
        if (this.bNQ == null) {
            return;
        }
        this.bNO.setText(this.mContext.getText(this.bNQ.mMessageId));
        this.bNO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bNQ.bNV != null) {
                    c.this.bNQ.bNV.onItemClick(view);
                }
            }
        });
        if (this.bNQ.bNS > 0) {
            this.bNP.setVisibility(0);
            this.bNP.setText(this.mContext.getText(this.bNQ.bNS));
            this.bNP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bNQ.bNU != null) {
                        c.this.bNQ.bNU.onItemClick(view);
                    }
                }
            });
        } else {
            this.bNP.setVisibility(8);
        }
        if (this.bNQ.bNT <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.bNQ.bNT);
        w.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, af.dip2px(this.mContext, 12.0f), af.dip2px(this.mContext, 12.0f));
        this.bNP.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0333b {
        private int bNS;
        private int bNT;
        public b.c bNU;
        public b.c bNV;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0333b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g by(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eF */
        public a eI(int i) {
            super.eI(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eG */
        public a eH(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.bNV = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0333b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g WT() {
            c cVar = (c) super.WT();
            cVar.a(this);
            return cVar;
        }
    }
}
