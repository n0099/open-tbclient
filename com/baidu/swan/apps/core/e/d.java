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
    private FrameLayout bSC;
    private a cVl;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cVl = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View D(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bSC = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        aqm();
        return inflate;
    }

    private void aqm() {
        if (this.cVl == null) {
            return;
        }
        this.bSC.addView(this.cVl.contentView);
    }

    /* loaded from: classes8.dex */
    public static class a extends b.C0458b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0458b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g cI(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: gT */
        public a gS(int i) {
            super.gS(i);
            return this;
        }

        public a aA(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0458b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g aqn() {
            d dVar = (d) super.aqn();
            dVar.a(this);
            return dVar;
        }
    }
}
