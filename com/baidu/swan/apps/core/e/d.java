package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private FrameLayout bWe;
    private a bXc;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bXc = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bWe = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        ZE();
        return inflate;
    }

    private void ZE() {
        if (this.bXc == null) {
            return;
        }
        this.bWe.addView(this.bXc.contentView);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0376b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0376b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bH(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eU */
        public a eT(int i) {
            super.eT(i);
            return this;
        }

        public a ak(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0376b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g ZF() {
            d dVar = (d) super.ZF();
            dVar.a(this);
            return dVar;
        }
    }
}
