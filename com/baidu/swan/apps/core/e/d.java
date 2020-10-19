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
    private FrameLayout bBl;
    private a cxP;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cxP = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bBl = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        alt();
        return inflate;
    }

    private void alt() {
        if (this.cxP == null) {
            return;
        }
        this.bBl.addView(this.cxP.contentView);
    }

    /* loaded from: classes10.dex */
    public static class a extends b.C0443b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0443b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bX(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hL */
        public a hK(int i) {
            super.hK(i);
            return this;
        }

        public a ar(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0443b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g alu() {
            d dVar = (d) super.alu();
            dVar.a(this);
            return dVar;
        }
    }
}
