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
    private TextView bNJ;
    private SelectorTextView bNK;
    private a bNL;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bNL = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.bNJ = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.bNJ.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.bNK = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.bNK.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        WT();
        return this.mView;
    }

    private void WT() {
        if (this.bNL == null) {
            return;
        }
        this.bNJ.setText(this.mContext.getText(this.bNL.mMessageId));
        this.bNJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bNL.bNQ != null) {
                    c.this.bNL.bNQ.onItemClick(view);
                }
            }
        });
        if (this.bNL.bNN > 0) {
            this.bNK.setVisibility(0);
            this.bNK.setText(this.mContext.getText(this.bNL.bNN));
            this.bNK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bNL.bNP != null) {
                        c.this.bNL.bNP.onItemClick(view);
                    }
                }
            });
        } else {
            this.bNK.setVisibility(8);
        }
        if (this.bNL.bNO <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.bNL.bNO);
        w.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, af.dip2px(this.mContext, 12.0f), af.dip2px(this.mContext, 12.0f));
        this.bNK.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0312b {
        private int bNN;
        private int bNO;
        public b.c bNP;
        public b.c bNQ;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0312b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bK(Context context) {
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
            this.bNQ = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0312b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g WU() {
            c cVar = (c) super.WU();
            cVar.a(this);
            return cVar;
        }
    }
}
