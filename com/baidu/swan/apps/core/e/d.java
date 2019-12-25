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
    private FrameLayout bjw;
    private a bkx;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bkx = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bjw = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        Mp();
        return inflate;
    }

    private void Mp() {
        if (this.bkx == null) {
            return;
        }
        this.bjw.addView(this.bkx.contentView);
    }

    /* loaded from: classes9.dex */
    public static class a extends b.C0270b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0270b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bT(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: en */
        public a em(int i) {
            super.em(i);
            return this;
        }

        public a af(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0270b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g Mq() {
            d dVar = (d) super.Mq();
            dVar.a(this);
            return dVar;
        }
    }
}
