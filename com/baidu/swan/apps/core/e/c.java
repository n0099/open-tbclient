package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.x;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView bWU;
    private SelectorTextView bWV;
    private a bWW;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bWW = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.bWU = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.bWU.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.bWV = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.bWV.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        ZE();
        return this.mView;
    }

    private void ZE() {
        if (this.bWW == null) {
            return;
        }
        this.bWU.setText(this.mContext.getText(this.bWW.mMessageId));
        this.bWU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bWW.bXb != null) {
                    c.this.bWW.bXb.onItemClick(view);
                }
            }
        });
        if (this.bWW.bWY > 0) {
            this.bWV.setVisibility(0);
            this.bWV.setText(this.mContext.getText(this.bWW.bWY));
            this.bWV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bWW.bXa != null) {
                        c.this.bWW.bXa.onItemClick(view);
                    }
                }
            });
        } else {
            this.bWV.setVisibility(8);
        }
        if (this.bWW.bWZ <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.bWW.bWZ);
        x.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, ag.dip2px(this.mContext, 12.0f), ag.dip2px(this.mContext, 12.0f));
        this.bWV.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0376b {
        private int bWY;
        private int bWZ;
        public b.c bXa;
        public b.c bXb;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0376b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bH(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eQ */
        public a eT(int i) {
            super.eT(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eR */
        public a eS(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.bXb = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0376b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g ZF() {
            c cVar = (c) super.ZF();
            cVar.a(this);
            return cVar;
        }
    }
}
