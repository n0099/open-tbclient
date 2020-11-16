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
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView cKm;
    private SelectorTextView cKn;
    private a cKo;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cKo = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cKm = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cKm.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cKn = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cKn.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        apf();
        return this.mView;
    }

    private void apf() {
        if (this.cKo == null) {
            return;
        }
        this.cKm.setText(this.mContext.getText(this.cKo.mMessageId));
        this.cKm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cKo.cKt != null) {
                    c.this.cKo.cKt.onItemClick(view);
                }
            }
        });
        if (this.cKo.cKq > 0) {
            this.cKn.setVisibility(0);
            this.cKn.setText(this.mContext.getText(this.cKo.cKq));
            this.cKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cKo.cKs != null) {
                        c.this.cKo.cKs.onItemClick(view);
                    }
                }
            });
        } else {
            this.cKn.setVisibility(8);
        }
        if (this.cKo.cKr <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cKo.cKr);
        z.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.cKn.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes7.dex */
    public static class a extends b.C0467b {
        private int cKq;
        private int cKr;
        public b.c cKs;
        public b.c cKt;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0467b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bX(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hY */
        public a ib(int i) {
            super.ib(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hZ */
        public a ia(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cKt = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0467b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g apg() {
            c cVar = (c) super.apg();
            cVar.a(this);
            return cVar;
        }
    }
}
