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
    private FrameLayout cbm;
    private a cdu;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cdu = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.cbm = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        abM();
        return inflate;
    }

    private void abM() {
        if (this.cdu == null) {
            return;
        }
        this.cbm.addView(this.cdu.contentView);
    }

    /* loaded from: classes7.dex */
    public static class a extends b.C0385b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0385b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bL(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: fj */
        public a fi(int i) {
            super.fi(i);
            return this;
        }

        public a an(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0385b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g abN() {
            d dVar = (d) super.abN();
            dVar.a(this);
            return dVar;
        }
    }
}
