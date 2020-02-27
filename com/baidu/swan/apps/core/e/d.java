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
    private FrameLayout bov;
    private a bpw;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bpw = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bov = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        OZ();
        return inflate;
    }

    private void OZ() {
        if (this.bpw == null) {
            return;
        }
        this.bov.addView(this.bpw.contentView);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0282b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0282b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bX(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eE */
        public a eD(int i) {
            super.eD(i);
            return this;
        }

        public a aj(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0282b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g Pa() {
            d dVar = (d) super.Pa();
            dVar.a(this);
            return dVar;
        }
    }
}
