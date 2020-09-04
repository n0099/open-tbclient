package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes8.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private FrameLayout chl;
    private a cjw;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cjw = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.chl = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        ahY();
        return inflate;
    }

    private void ahY() {
        if (this.cjw == null) {
            return;
        }
        this.chl.addView(this.cjw.contentView);
    }

    /* loaded from: classes8.dex */
    public static class a extends b.C0431b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0431b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bS(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: hf */
        public a he(int i) {
            super.he(i);
            return this;
        }

        public a ao(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0431b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g ahZ() {
            d dVar = (d) super.ahZ();
            dVar.a(this);
            return dVar;
        }
    }
}
