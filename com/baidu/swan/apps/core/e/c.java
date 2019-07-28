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
    private SelectorTextView asr;
    private a ass;
    private TextView mContentView;
    private View mView;

    protected c(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.ass = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View f(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_safe_dialog, viewGroup, false);
        this.mContentView = (TextView) this.mView.findViewById(a.f.safe_dialog_content);
        this.mContentView.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        this.asr = (SelectorTextView) this.mView.findViewById(a.f.safe_dialog_sub_content);
        this.asr.setTextColor(getContext().getResources().getColor(a.c.aiapps_safe_dialog_btn_blue));
        AW();
        return this.mView;
    }

    private void AW() {
        if (this.ass == null) {
            return;
        }
        this.mContentView.setText(this.mContext.getText(this.ass.ajO));
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ass.asx != null) {
                    c.this.ass.asx.W(view);
                }
            }
        });
        if (this.ass.asu > 0) {
            this.asr.setVisibility(0);
            this.asr.setText(this.mContext.getText(this.ass.asu));
            this.asr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.e.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.ass.asw != null) {
                        c.this.ass.asw.W(view);
                    }
                }
            });
        } else {
            this.asr.setVisibility(8);
        }
        if (this.ass.asv <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.ass.asv);
        s.a(getContext(), drawable);
        drawable.setBounds(0, 0, z.dip2px(this.mContext, 12.0f), z.dip2px(this.mContext, 12.0f));
        this.asr.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes2.dex */
    public static class a extends b.C0171b {
        private int ajO;
        private int asu;
        private int asv;
        public b.c asw;
        public b.c asx;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0171b, com.baidu.swan.apps.res.widget.dialog.g.a
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
            this.ajO = i;
            return this;
        }

        public a a(int i, b.c cVar) {
            this.ajO = i;
            this.asx = cVar;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0171b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g AX() {
            c cVar = (c) super.AX();
            cVar.a(this);
            return cVar;
        }
    }
}
