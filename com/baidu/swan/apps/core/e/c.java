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
    private TextView cRq;
    private SelectorTextView cRr;
    private a cRs;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cRs = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View F(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cRq = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cRq.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cRr = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cRr.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        apL();
        return this.mView;
    }

    private void apL() {
        if (this.cRs == null) {
            return;
        }
        this.cRq.setText(this.mContext.getText(this.cRs.mMessageId));
        this.cRq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cRs.cRx != null) {
                    c.this.cRs.cRx.aD(view);
                }
            }
        });
        if (this.cRs.cRu > 0) {
            this.cRr.setVisibility(0);
            this.cRr.setText(this.mContext.getText(this.cRs.cRu));
            this.cRr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cRs.cRw != null) {
                        c.this.cRs.cRw.aD(view);
                    }
                }
            });
        } else {
            this.cRr.setVisibility(8);
        }
        if (this.cRs.cRv <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cRs.cRv);
        z.a(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.cRr.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes8.dex */
    public static class a extends b.C0455b {
        private int cRu;
        private int cRv;
        public b.c cRw;
        public b.c cRx;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0455b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cK(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: gL */
        public a gO(int i) {
            super.gO(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: gM */
        public a gN(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cRx = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0455b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g apM() {
            c cVar = (c) super.apM();
            cVar.a(this);
            return cVar;
        }
    }
}
