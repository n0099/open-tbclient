package com.baidu.swan.apps.core.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.q;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.a;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.a {
    private SelectorTextView arI;
    private a arJ;
    private TextView mContentView;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.arJ = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.a
    protected View f(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.mContentView = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.mContentView.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.arI = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.arI.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        zp();
        return this.mView;
    }

    private void zp() {
        if (this.arJ == null) {
            return;
        }
        this.mContentView.setText(this.mContext.getText(this.arJ.aiZ));
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.arJ.arO != null) {
                    c.this.arJ.arO.U(view);
                }
            }
        });
        if (this.arJ.arL > 0) {
            this.arI.setVisibility(0);
            this.arI.setText(this.mContext.getText(this.arJ.arL));
            this.arI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.arJ.arN != null) {
                        c.this.arJ.arN.U(view);
                    }
                }
            });
        } else {
            this.arI.setVisibility(8);
        }
        if (this.arJ.arM <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.arJ.arM);
        q.a(getContext(), drawable);
        drawable.setBounds(0, 0, x.dip2px(this.mContext, 12.0f), x.dip2px(this.mContext, 12.0f));
        this.arI.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes2.dex */
    public static class a extends a.b {
        private int aiZ;
        private int arL;
        private int arM;
        public a.c arN;
        public a.c arO;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.a.b, com.baidu.swan.apps.res.widget.dialog.e.a
        protected com.baidu.swan.apps.res.widget.dialog.e bB(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        /* renamed from: cj */
        public a cm(int i) {
            super.cm(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        /* renamed from: ck */
        public a cl(int i) {
            this.aiZ = i;
            return this;
        }

        public a a(int i, a.c cVar) {
            this.aiZ = i;
            this.arO = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.a.b, com.baidu.swan.apps.res.widget.dialog.e.a
        public com.baidu.swan.apps.res.widget.dialog.e zq() {
            c cVar = (c) super.zq();
            cVar.a(this);
            return cVar;
        }
    }
}
