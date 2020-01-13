package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes10.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private FrameLayout bkl;
    private a blm;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.blm = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bkl = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        ML();
        return inflate;
    }

    private void ML() {
        if (this.blm == null) {
            return;
        }
        this.bkl.addView(this.blm.contentView);
    }

    /* loaded from: classes10.dex */
    public static class a extends b.C0272b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0272b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bT(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eo */
        public a en(int i) {
            super.en(i);
            return this;
        }

        public a aj(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0272b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g MM() {
            d dVar = (d) super.MM();
            dVar.a(this);
            return dVar;
        }
    }
}
