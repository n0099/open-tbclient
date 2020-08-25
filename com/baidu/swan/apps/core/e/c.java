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
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView cjk;
    private SelectorTextView cjl;
    private a cjm;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cjm = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cjk = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cjk.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cjl = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cjl.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        ahY();
        return this.mView;
    }

    private void ahY() {
        if (this.cjm == null) {
            return;
        }
        this.cjk.setText(this.mContext.getText(this.cjm.mMessageId));
        this.cjk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cjm.cjr != null) {
                    c.this.cjm.cjr.onItemClick(view);
                }
            }
        });
        if (this.cjm.cjo > 0) {
            this.cjl.setVisibility(0);
            this.cjl.setText(this.mContext.getText(this.cjm.cjo));
            this.cjl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cjm.cjq != null) {
                        c.this.cjm.cjq.onItemClick(view);
                    }
                }
            });
        } else {
            this.cjl.setVisibility(8);
        }
        if (this.cjm.cjp <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cjm.cjp);
        z.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.cjl.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes8.dex */
    public static class a extends b.C0431b {
        private int cjo;
        private int cjp;
        public b.c cjq;
        public b.c cjr;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0431b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bS(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hb */
        public a he(int i) {
            super.he(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hc */
        public a hd(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cjr = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0431b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g ahZ() {
            c cVar = (c) super.ahZ();
            cVar.a(this);
            return cVar;
        }
    }
}
