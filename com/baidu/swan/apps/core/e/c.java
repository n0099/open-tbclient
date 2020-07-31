package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.y;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView cdm;
    private SelectorTextView cdn;
    private a cdo;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cdo = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cdm = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cdm.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cdn = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cdn.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        abM();
        return this.mView;
    }

    private void abM() {
        if (this.cdo == null) {
            return;
        }
        this.cdm.setText(this.mContext.getText(this.cdo.mMessageId));
        this.cdm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cdo.cdt != null) {
                    c.this.cdo.cdt.onItemClick(view);
                }
            }
        });
        if (this.cdo.cdq > 0) {
            this.cdn.setVisibility(0);
            this.cdn.setText(this.mContext.getText(this.cdo.cdq));
            this.cdn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cdo.cds != null) {
                        c.this.cdo.cds.onItemClick(view);
                    }
                }
            });
        } else {
            this.cdn.setVisibility(8);
        }
        if (this.cdo.cdr <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cdo.cdr);
        y.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, ai.dip2px(this.mContext, 12.0f), ai.dip2px(this.mContext, 12.0f));
        this.cdn.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes7.dex */
    public static class a extends b.C0385b {
        private int cdq;
        private int cdr;
        public b.c cds;
        public b.c cdt;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0385b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bL(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ff */
        public a fi(int i) {
            super.fi(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: fg */
        public a fh(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cdt = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0385b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g abN() {
            c cVar = (c) super.abN();
            cVar.a(this);
            return cVar;
        }
    }
}
