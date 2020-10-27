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
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView cGd;
    private SelectorTextView cGe;
    private a cGf;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cGf = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cGd = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cGd.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cGe = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cGe.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        ann();
        return this.mView;
    }

    private void ann() {
        if (this.cGf == null) {
            return;
        }
        this.cGd.setText(this.mContext.getText(this.cGf.mMessageId));
        this.cGd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cGf.cGk != null) {
                    c.this.cGf.cGk.onItemClick(view);
                }
            }
        });
        if (this.cGf.cGh > 0) {
            this.cGe.setVisibility(0);
            this.cGe.setText(this.mContext.getText(this.cGf.cGh));
            this.cGe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cGf.cGj != null) {
                        c.this.cGf.cGj.onItemClick(view);
                    }
                }
            });
        } else {
            this.cGe.setVisibility(8);
        }
        if (this.cGf.cGi <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cGf.cGi);
        z.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.cGe.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes10.dex */
    public static class a extends b.C0457b {
        private int cGh;
        private int cGi;
        public b.c cGj;
        public b.c cGk;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0457b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bX(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hS */
        public a hV(int i) {
            super.hV(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hT */
        public a hU(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cGk = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0457b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g ano() {
            c cVar = (c) super.ano();
            cVar.a(this);
            return cVar;
        }
    }
}
