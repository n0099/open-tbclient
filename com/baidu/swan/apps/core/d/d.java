package com.baidu.swan.apps.core.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.a;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.a {
    private a arP;
    private FrameLayout ara;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.arP = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.a
    protected View f(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.ara = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        zp();
        return inflate;
    }

    private void zp() {
        if (this.arP == null) {
            return;
        }
        this.ara.addView(this.arP.contentView);
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
        /* renamed from: cn */
        public a cm(int i) {
            super.cm(i);
            return this;
        }

        public a V(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.a.b, com.baidu.swan.apps.res.widget.dialog.e.a
        public com.baidu.swan.apps.res.widget.dialog.e zq() {
            d dVar = (d) super.zq();
            dVar.a(this);
            return dVar;
        }
    }
}
