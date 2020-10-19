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
    private TextView cxH;
    private SelectorTextView cxI;
    private a cxJ;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cxJ = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cxH = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cxH.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cxI = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cxI.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        alt();
        return this.mView;
    }

    private void alt() {
        if (this.cxJ == null) {
            return;
        }
        this.cxH.setText(this.mContext.getText(this.cxJ.mMessageId));
        this.cxH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cxJ.cxO != null) {
                    c.this.cxJ.cxO.onItemClick(view);
                }
            }
        });
        if (this.cxJ.cxL > 0) {
            this.cxI.setVisibility(0);
            this.cxI.setText(this.mContext.getText(this.cxJ.cxL));
            this.cxI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cxJ.cxN != null) {
                        c.this.cxJ.cxN.onItemClick(view);
                    }
                }
            });
        } else {
            this.cxI.setVisibility(8);
        }
        if (this.cxJ.cxM <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cxJ.cxM);
        z.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.cxI.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes10.dex */
    public static class a extends b.C0443b {
        private int cxL;
        private int cxM;
        public b.c cxN;
        public b.c cxO;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0443b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bX(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hH */
        public a hK(int i) {
            super.hK(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hI */
        public a hJ(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cxO = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0443b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g alu() {
            c cVar = (c) super.alu();
            cVar.a(this);
            return cVar;
        }
    }
}
