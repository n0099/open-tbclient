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
/* loaded from: classes25.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView cRf;
    private SelectorTextView cRg;
    private a cRh;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cRh = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cRf = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cRf.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cRg = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cRg.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        aso();
        return this.mView;
    }

    private void aso() {
        if (this.cRh == null) {
            return;
        }
        this.cRf.setText(this.mContext.getText(this.cRh.mMessageId));
        this.cRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cRh.cRm != null) {
                    c.this.cRh.cRm.onItemClick(view);
                }
            }
        });
        if (this.cRh.cRj > 0) {
            this.cRg.setVisibility(0);
            this.cRg.setText(this.mContext.getText(this.cRh.cRj));
            this.cRg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cRh.cRl != null) {
                        c.this.cRh.cRl.onItemClick(view);
                    }
                }
            });
        } else {
            this.cRg.setVisibility(8);
        }
        if (this.cRh.cRk <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cRh.cRk);
        z.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.cRg.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes25.dex */
    public static class a extends b.C0479b {
        private int cRj;
        private int cRk;
        public b.c cRl;
        public b.c cRm;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0479b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cD(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: iw */
        public a iz(int i) {
            super.iz(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ix */
        public a iy(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cRm = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0479b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g asp() {
            c cVar = (c) super.asp();
            cVar.a(this);
            return cVar;
        }
    }
}
