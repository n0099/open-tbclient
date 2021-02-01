package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.z;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView cTD;
    private SelectorTextView cTE;
    private a cTF;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cTF = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View D(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cTD = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cTD.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cTE = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cTE.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        aqj();
        return this.mView;
    }

    private void aqj() {
        if (this.cTF == null) {
            return;
        }
        this.cTD.setText(this.mContext.getText(this.cTF.mMessageId));
        this.cTD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cTF.cTK != null) {
                    c.this.cTF.cTK.az(view);
                }
            }
        });
        if (this.cTF.cTH > 0) {
            this.cTE.setVisibility(0);
            this.cTE.setText(this.mContext.getText(this.cTF.cTH));
            this.cTE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cTF.cTJ != null) {
                        c.this.cTF.cTJ.az(view);
                    }
                }
            });
        } else {
            this.cTE.setVisibility(8);
        }
        if (this.cTF.cTI <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cTF.cTI);
        z.a(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.cTE.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes9.dex */
    public static class a extends b.C0452b {
        private int cTH;
        private int cTI;
        public b.c cTJ;
        public b.c cTK;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0452b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cJ(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: gO */
        public a gR(int i) {
            super.gR(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: gP */
        public a gQ(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cTK = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0452b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g aqk() {
            c cVar = (c) super.aqk();
            cVar.a(this);
            return cVar;
        }
    }
}
