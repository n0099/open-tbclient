package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes9.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private FrameLayout bRc;
    private a cTL;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cTL = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View D(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bRc = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        aqj();
        return inflate;
    }

    private void aqj() {
        if (this.cTL == null) {
            return;
        }
        this.bRc.addView(this.cTL.contentView);
    }

    /* loaded from: classes9.dex */
    public static class a extends b.C0452b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0452b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cJ(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: gS */
        public a gR(int i) {
            super.gR(i);
            return this;
        }

        public a aA(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0452b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g aqk() {
            d dVar = (d) super.aqk();
            dVar.a(this);
            return dVar;
        }
    }
}
