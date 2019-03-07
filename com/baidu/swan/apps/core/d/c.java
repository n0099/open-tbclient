package com.baidu.swan.apps.core.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.an.q;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.a;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.a {
    private SelectorTextView arC;
    private a arD;
    private TextView mContentView;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.arD = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.a
    protected View f(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(b.g.aiapps_safe_dialog, viewGroup, false);
        this.mContentView = (TextView) this.mView.findViewById(b.f.safe_dialog_content);
        this.mContentView.setTextColor(getContext().getResources().getColor(b.c.aiapps_safe_dialog_message));
        this.arC = (SelectorTextView) this.mView.findViewById(b.f.safe_dialog_sub_content);
        this.arC.setTextColor(getContext().getResources().getColor(b.c.aiapps_safe_dialog_btn_blue));
        zq();
        return this.mView;
    }

    private void zq() {
        if (this.arD == null) {
            return;
        }
        this.mContentView.setText(this.mContext.getText(this.arD.aiT));
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.arD.arI != null) {
                    c.this.arD.arI.U(view);
                }
            }
        });
        if (this.arD.arF > 0) {
            this.arC.setVisibility(0);
            this.arC.setText(this.mContext.getText(this.arD.arF));
            this.arC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.arD.arH != null) {
                        c.this.arD.arH.U(view);
                    }
                }
            });
        } else {
            this.arC.setVisibility(8);
        }
        if (this.arD.arG <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.arD.arG);
        q.a(getContext(), drawable);
        drawable.setBounds(0, 0, x.dip2px(this.mContext, 12.0f), x.dip2px(this.mContext, 12.0f));
        this.arC.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes2.dex */
    public static class a extends a.b {
        private int aiT;
        private int arF;
        private int arG;
        public a.c arH;
        public a.c arI;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.a.b, com.baidu.swan.apps.res.widget.dialog.e.a
        protected com.baidu.swan.apps.res.widget.dialog.e bB(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        /* renamed from: ck */
        public a cn(int i) {
            super.cn(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        /* renamed from: cl */
        public a cm(int i) {
            this.aiT = i;
            return this;
        }

        public a a(int i, a.c cVar) {
            this.aiT = i;
            this.arI = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.a.b, com.baidu.swan.apps.res.widget.dialog.e.a
        public com.baidu.swan.apps.res.widget.dialog.e zr() {
            c cVar = (c) super.zr();
            cVar.a(this);
            return cVar;
        }
    }
}
