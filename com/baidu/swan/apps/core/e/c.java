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
    private SelectorTextView asP;
    private a asQ;
    private TextView mContentView;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.asQ = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View f(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.mContentView = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.mContentView.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.asP = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.asP.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        Ba();
        return this.mView;
    }

    private void Ba() {
        if (this.asQ == null) {
            return;
        }
        this.mContentView.setText(this.mContext.getText(this.asQ.akm));
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.asQ.asV != null) {
                    c.this.asQ.asV.W(view);
                }
            }
        });
        if (this.asQ.asS > 0) {
            this.asP.setVisibility(0);
            this.asP.setText(this.mContext.getText(this.asQ.asS));
            this.asP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.asQ.asU != null) {
                        c.this.asQ.asU.W(view);
                    }
                }
            });
        } else {
            this.asP.setVisibility(8);
        }
        if (this.asQ.asT <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.asQ.asT);
        s.a(getContext(), drawable);
        drawable.setBounds(0, 0, z.dip2px(this.mContext, 12.0f), z.dip2px(this.mContext, 12.0f));
        this.asP.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes2.dex */
    public static class a extends b.C0180b {
        private int akm;
        private int asS;
        private int asT;
        public b.c asU;
        public b.c asV;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0180b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ck */
        public a cn(int i) {
            super.cn(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: cl */
        public a cm(int i) {
            this.akm = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.akm = i;
            this.asV = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0180b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g Bb() {
            c cVar = (c) super.Bb();
            cVar.a(this);
            return cVar;
        }
    }
}
