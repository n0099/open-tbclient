package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.x;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.res.widget.dialog.b {
    private TextView cbI;
    private SelectorTextView cbJ;
    private a cbK;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cbK = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.cbI = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.cbI.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.cbJ = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.cbJ.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        aaK();
        return this.mView;
    }

    private void aaK() {
        if (this.cbK == null) {
            return;
        }
        this.cbI.setText(this.mContext.getText(this.cbK.mMessageId));
        this.cbI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cbK.cbP != null) {
                    c.this.cbK.cbP.onItemClick(view);
                }
            }
        });
        if (this.cbK.cbM > 0) {
            this.cbJ.setVisibility(0);
            this.cbJ.setText(this.mContext.getText(this.cbK.cbM));
            this.cbJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cbK.cbO != null) {
                        c.this.cbK.cbO.onItemClick(view);
                    }
                }
            });
        } else {
            this.cbJ.setVisibility(8);
        }
        if (this.cbK.cbN <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.cbK.cbN);
        x.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, ag.dip2px(this.mContext, 12.0f), ag.dip2px(this.mContext, 12.0f));
        this.cbJ.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0382b {
        private int cbM;
        private int cbN;
        public b.c cbO;
        public b.c cbP;
        private int mMessageId;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0382b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bI(Context context) {
            return new c(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: fb */
        public a fe(int i) {
            super.fe(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: fc */
        public a fd(int i) {
            this.mMessageId = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.mMessageId = i;
            this.cbP = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0382b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g aaL() {
            c cVar = (c) super.aaL();
            cVar.a(this);
            return cVar;
        }
    }
}
