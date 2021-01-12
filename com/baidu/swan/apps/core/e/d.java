package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes8.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private FrameLayout bNm;
    private a cRy;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cRy = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View F(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bNm = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        apL();
        return inflate;
    }

    private void apL() {
        if (this.cRy == null) {
            return;
        }
        this.bNm.addView(this.cRy.contentView);
    }

    /* loaded from: classes8.dex */
    public static class a extends b.C0455b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0455b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cK(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: gP */
        public a gO(int i) {
            super.gO(i);
            return this;
        }

        public a aE(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0455b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g apM() {
            d dVar = (d) super.apM();
            dVar.a(this);
            return dVar;
        }
    }
}
