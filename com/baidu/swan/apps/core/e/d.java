package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes25.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private FrameLayout bNl;
    private a cRn;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cRn = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bNl = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        aso();
        return inflate;
    }

    private void aso() {
        if (this.cRn == null) {
            return;
        }
        this.bNl.addView(this.cRn.contentView);
    }

    /* loaded from: classes25.dex */
    public static class a extends b.C0479b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0479b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cD(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: iA */
        public a iz(int i) {
            super.iz(i);
            return this;
        }

        public a ay(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0479b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g asp() {
            d dVar = (d) super.asp();
            dVar.a(this);
            return dVar;
        }
    }
}
