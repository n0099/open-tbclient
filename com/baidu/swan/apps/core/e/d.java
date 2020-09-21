package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes3.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private FrameLayout cjn;
    private a clx;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.clx = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.cjn = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        aiI();
        return inflate;
    }

    private void aiI() {
        if (this.clx == null) {
            return;
        }
        this.cjn.addView(this.clx.contentView);
    }

    /* loaded from: classes3.dex */
    public static class a extends b.C0426b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0426b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bR(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ho */
        public a hn(int i) {
            super.hn(i);
            return this;
        }

        public a aq(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0426b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g aiJ() {
            d dVar = (d) super.aiJ();
            dVar.a(this);
            return dVar;
        }
    }
}
