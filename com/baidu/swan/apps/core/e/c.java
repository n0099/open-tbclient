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
    private TextView cLW;
    private SelectorTextView cLX;
    private a cLY;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cLY = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cLW = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cLW.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cLX = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cLX.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        apO();
        return this.mView;
    }

    private void apO() {
        if (this.cLY == null) {
            return;
        }
        this.cLW.setText(this.mContext.getText(this.cLY.mMessageId));
        this.cLW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cLY.cMd != null) {
                    c.this.cLY.cMd.onItemClick(view);
                }
            }
        });
        if (this.cLY.cMa > 0) {
            this.cLX.setVisibility(0);
            this.cLX.setText(this.mContext.getText(this.cLY.cMa));
            this.cLX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cLY.cMc != null) {
                        c.this.cLY.cMc.onItemClick(view);
                    }
                }
            });
        } else {
            this.cLX.setVisibility(8);
        }
        if (this.cLY.cMb <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cLY.cMb);
        z.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, ah.dip2px(this.mContext, 12.0f), ah.dip2px(this.mContext, 12.0f));
        this.cLX.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes10.dex */
    public static class a extends b.C0469b {
        private int cMa;
        private int cMb;
        public b.c cMc;
        public b.c cMd;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0469b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bX(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ic */
        public a mo33if(int i) {
            super.mo33if(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: id */
        public a ie(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cMd = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0469b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g apP() {
            c cVar = (c) super.apP();
            cVar.a(this);
            return cVar;
        }
    }
}
