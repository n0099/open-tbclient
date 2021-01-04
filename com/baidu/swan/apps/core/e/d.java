package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes9.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private FrameLayout bRY;
    private a cWk;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cWk = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View F(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bRY = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        atF();
        return inflate;
    }

    private void atF() {
        if (this.cWk == null) {
            return;
        }
        this.bRY.addView(this.cWk.contentView);
    }

    /* loaded from: classes9.dex */
    public static class a extends b.C0472b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0472b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cL(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: iv */
        public a iu(int i) {
            super.iu(i);
            return this;
        }

        public a aE(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0472b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g atG() {
            d dVar = (d) super.atG();
            dVar.a(this);
            return dVar;
        }
    }
}
