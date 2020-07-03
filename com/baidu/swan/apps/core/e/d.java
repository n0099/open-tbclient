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
    private FrameLayout caS;
    private a cbQ;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cbQ = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.caS = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        aaK();
        return inflate;
    }

    private void aaK() {
        if (this.cbQ == null) {
            return;
        }
        this.caS.addView(this.cbQ.contentView);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0382b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0382b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bI(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ff */
        public a fe(int i) {
            super.fe(i);
            return this;
        }

        public a ak(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0382b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g aaL() {
            d dVar = (d) super.aaL();
            dVar.a(this);
            return dVar;
        }
    }
}
