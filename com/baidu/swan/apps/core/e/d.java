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
    private FrameLayout bMV;
    private a bNW;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bNW = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bMV = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        WS();
        return inflate;
    }

    private void WS() {
        if (this.bNW == null) {
            return;
        }
        this.bMV.addView(this.bNW.contentView);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0333b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0333b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g by(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eJ */
        public a eI(int i) {
            super.eI(i);
            return this;
        }

        public a ak(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0333b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g WT() {
            d dVar = (d) super.WT();
            dVar.a(this);
            return dVar;
        }
    }
}
