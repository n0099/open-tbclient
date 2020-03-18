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
    private FrameLayout boJ;
    private a bpK;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bpK = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.boJ = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        Pe();
        return inflate;
    }

    private void Pe() {
        if (this.bpK == null) {
            return;
        }
        this.boJ.addView(this.bpK.contentView);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0282b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0282b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bW(Context context) {
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
        public g Pf() {
            d dVar = (d) super.Pf();
            dVar.a(this);
            return dVar;
        }
    }
}
