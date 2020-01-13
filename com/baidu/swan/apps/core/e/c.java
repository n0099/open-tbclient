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
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView ble;
    private SelectorTextView blf;
    private a blg;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.blg = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.ble = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.ble.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.blf = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.blf.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        ML();
        return this.mView;
    }

    private void ML() {
        if (this.blg == null) {
            return;
        }
        this.ble.setText(this.mContext.getText(this.blg.mMessageId));
        this.ble.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.blg.bll != null) {
                    c.this.blg.bll.onItemClick(view);
                }
            }
        });
        if (this.blg.bli > 0) {
            this.blf.setVisibility(0);
            this.blf.setText(this.mContext.getText(this.blg.bli));
            this.blf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.blg.blk != null) {
                        c.this.blg.blk.onItemClick(view);
                    }
                }
            });
        } else {
            this.blf.setVisibility(8);
        }
        if (this.blg.blj <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.blg.blj);
        w.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, af.dip2px(this.mContext, 12.0f), af.dip2px(this.mContext, 12.0f));
        this.blf.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes10.dex */
    public static class a extends b.C0272b {
        private int bli;
        private int blj;
        public b.c blk;
        public b.c bll;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0272b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bT(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ek */
        public a en(int i) {
            super.en(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: el */
        public a em(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.bll = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0272b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g MM() {
            c cVar = (c) super.MM();
            cVar.a(this);
            return cVar;
        }
    }
}
