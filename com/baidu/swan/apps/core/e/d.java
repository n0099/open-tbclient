package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private a aLV;
    private FrameLayout aLf;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.aLV = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View i(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.aLf = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        FW();
        return inflate;
    }

    private void FW() {
        if (this.aLV == null) {
            return;
        }
        this.aLf.addView(this.aLV.contentView);
    }

    /* loaded from: classes2.dex */
    public static class a extends b.C0212b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0212b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aW(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: dk */
        public a dj(int i) {
            super.dj(i);
            return this;
        }

        public a ad(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0212b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g FX() {
            d dVar = (d) super.FX();
            dVar.a(this);
            return dVar;
        }
    }
}
