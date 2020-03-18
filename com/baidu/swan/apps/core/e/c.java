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
    private TextView bpC;
    private SelectorTextView bpD;
    private a bpE;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bpE = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.bpC = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.bpC.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.bpD = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.bpD.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        Pe();
        return this.mView;
    }

    private void Pe() {
        if (this.bpE == null) {
            return;
        }
        this.bpC.setText(this.mContext.getText(this.bpE.mMessageId));
        this.bpC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bpE.bpJ != null) {
                    c.this.bpE.bpJ.onItemClick(view);
                }
            }
        });
        if (this.bpE.bpG > 0) {
            this.bpD.setVisibility(0);
            this.bpD.setText(this.mContext.getText(this.bpE.bpG));
            this.bpD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bpE.bpI != null) {
                        c.this.bpE.bpI.onItemClick(view);
                    }
                }
            });
        } else {
            this.bpD.setVisibility(8);
        }
        if (this.bpE.bpH <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.bpE.bpH);
        w.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, af.dip2px(this.mContext, 12.0f), af.dip2px(this.mContext, 12.0f));
        this.bpD.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0282b {
        private int bpG;
        private int bpH;
        public b.c bpI;
        public b.c bpJ;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0282b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bW(Context context) {
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
            this.bpJ = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0282b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g Pf() {
            c cVar = (c) super.Pf();
            cVar.a(this);
            return cVar;
        }
    }
}
