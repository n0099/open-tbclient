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
    private TextView aLN;
    private SelectorTextView aLO;
    private a aLP;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.aLP = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View i(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.aLN = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.aLN.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.aLO = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.aLO.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        FW();
        return this.mView;
    }

    private void FW() {
        if (this.aLP == null) {
            return;
        }
        this.aLN.setText(this.mContext.getText(this.aLP.aDq));
        this.aLN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aLP.aLU != null) {
                    c.this.aLP.aLU.ac(view);
                }
            }
        });
        if (this.aLP.aLR > 0) {
            this.aLO.setVisibility(0);
            this.aLO.setText(this.mContext.getText(this.aLP.aLR));
            this.aLO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aLP.aLT != null) {
                        c.this.aLP.aLT.ac(view);
                    }
                }
            });
        } else {
            this.aLO.setVisibility(8);
        }
        if (this.aLP.aLS <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.aLP.aLS);
        s.a(getContext(), drawable);
        drawable.setBounds(0, 0, z.dip2px(this.mContext, 12.0f), z.dip2px(this.mContext, 12.0f));
        this.aLO.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes2.dex */
    public static class a extends b.C0207b {
        private int aDq;
        private int aLR;
        private int aLS;
        public b.c aLT;
        public b.c aLU;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0207b, com.baidu.swan.apps.res.widget.dialog.g.a
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
            this.aDq = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.aDq = i;
            this.aLU = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0207b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g FX() {
            c cVar = (c) super.FX();
            cVar.a(this);
            return cVar;
        }
    }
}
