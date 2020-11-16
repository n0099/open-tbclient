package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes7.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private FrameLayout bId;
    private a cKu;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cKu = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bId = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        apf();
        return inflate;
    }

    private void apf() {
        if (this.cKu == null) {
            return;
        }
        this.bId.addView(this.cKu.contentView);
    }

    /* loaded from: classes7.dex */
    public static class a extends b.C0467b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0467b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bX(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ic */
        public a ib(int i) {
            super.ib(i);
            return this;
        }

        public a aw(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0467b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g apg() {
            d dVar = (d) super.apg();
            dVar.a(this);
            return dVar;
        }
    }
}
