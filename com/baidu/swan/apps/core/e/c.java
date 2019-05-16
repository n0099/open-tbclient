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
    private SelectorTextView arO;
    private a arP;
    private TextView mContentView;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.arP = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View f(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.mContentView = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.mContentView.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.arO = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.arO.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        Ap();
        return this.mView;
    }

    private void Ap() {
        if (this.arP == null) {
            return;
        }
        this.mContentView.setText(this.mContext.getText(this.arP.ajm));
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.arP.arU != null) {
                    c.this.arP.arU.U(view);
                }
            }
        });
        if (this.arP.arR > 0) {
            this.arO.setVisibility(0);
            this.arO.setText(this.mContext.getText(this.arP.arR));
            this.arO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.arP.arT != null) {
                        c.this.arP.arT.U(view);
                    }
                }
            });
        } else {
            this.arO.setVisibility(8);
        }
        if (this.arP.arS <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.arP.arS);
        s.a(getContext(), drawable);
        drawable.setBounds(0, 0, z.dip2px(this.mContext, 12.0f), z.dip2px(this.mContext, 12.0f));
        this.arO.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes2.dex */
    public static class a extends b.C0169b {
        private int ajm;
        private int arR;
        private int arS;
        public b.c arT;
        public b.c arU;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0169b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: cj */
        public a cm(int i) {
            super.cm(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ck */
        public a cl(int i) {
            this.ajm = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.ajm = i;
            this.arU = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0169b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g Aq() {
            c cVar = (c) super.Aq();
            cVar.a(this);
            return cVar;
        }
    }
}
