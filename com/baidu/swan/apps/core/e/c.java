package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.s;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView aMf;
    private SelectorTextView aMg;
    private a aMh;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.aMh = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View i(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.aMf = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.aMf.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.aMg = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.aMg.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        FV();
        return this.mView;
    }

    private void FV() {
        if (this.aMh == null) {
            return;
        }
        this.aMf.setText(this.mContext.getText(this.aMh.aDI));
        this.aMf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aMh.aMm != null) {
                    c.this.aMh.aMm.ac(view);
                }
            }
        });
        if (this.aMh.aMj > 0) {
            this.aMg.setVisibility(0);
            this.aMg.setText(this.mContext.getText(this.aMh.aMj));
            this.aMg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aMh.aMl != null) {
                        c.this.aMh.aMl.ac(view);
                    }
                }
            });
        } else {
            this.aMg.setVisibility(8);
        }
        if (this.aMh.aMk <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.aMh.aMk);
        s.a(getContext(), drawable);
        drawable.setBounds(0, 0, z.dip2px(this.mContext, 12.0f), z.dip2px(this.mContext, 12.0f));
        this.aMg.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes2.dex */
    public static class a extends b.C0212b {
        private int aDI;
        private int aMj;
        private int aMk;
        public b.c aMl;
        public b.c aMm;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0212b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aW(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: dg */
        public a dj(int i) {
            super.dj(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: dh */
        public a di(int i) {
            this.aDI = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.aDI = i;
            this.aMm = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0212b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g FW() {
            c cVar = (c) super.FW();
            cVar.a(this);
            return cVar;
        }
    }
}
