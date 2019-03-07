package com.baidu.swan.apps.core.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.dialog.a;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.a {
    private FrameLayout aqU;
    private a arJ;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.arJ = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.a
    protected View f(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(b.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.aqU = (FrameLayout) inflate.findViewById(b.f.ssl_certificate_container);
        zq();
        return inflate;
    }

    private void zq() {
        if (this.arJ == null) {
            return;
        }
        this.aqU.addView(this.arJ.contentView);
    }

    /* loaded from: classes2.dex */
    public static class a extends a.b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.a.b, com.baidu.swan.apps.res.widget.dialog.e.a
        protected com.baidu.swan.apps.res.widget.dialog.e bB(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.e.a
        /* renamed from: co */
        public a cn(int i) {
            super.cn(i);
            return this;
        }

        public a V(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.a.b, com.baidu.swan.apps.res.widget.dialog.e.a
        public com.baidu.swan.apps.res.widget.dialog.e zr() {
            d dVar = (d) super.zr();
            dVar.a(this);
            return dVar;
        }
    }
}
