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
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView cWc;
    private SelectorTextView cWd;
    private a cWe;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cWe = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View F(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cWc = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cWc.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cWd = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cWd.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        atG();
        return this.mView;
    }

    private void atG() {
        if (this.cWe == null) {
            return;
        }
        this.cWc.setText(this.mContext.getText(this.cWe.mMessageId));
        this.cWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cWe.cWj != null) {
                    c.this.cWe.cWj.aD(view);
                }
            }
        });
        if (this.cWe.cWg > 0) {
            this.cWd.setVisibility(0);
            this.cWd.setText(this.mContext.getText(this.cWe.cWg));
            this.cWd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cWe.cWi != null) {
                        c.this.cWe.cWi.aD(view);
                    }
                }
            });
        } else {
            this.cWd.setVisibility(8);
        }
        if (this.cWe.cWh <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cWe.cWh);
        z.a(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.cWd.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes9.dex */
    public static class a extends b.C0472b {
        private int cWg;
        private int cWh;
        public b.c cWi;
        public b.c cWj;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0472b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cL(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ir */
        public a iu(int i) {
            super.iu(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: is */
        public a it(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cWj = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0472b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g atH() {
            c cVar = (c) super.atH();
            cVar.a(this);
            return cVar;
        }
    }
}
