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
    private a arV;
    private FrameLayout arf;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.arV = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View f(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.arf = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        Ap();
        return inflate;
    }

    private void Ap() {
        if (this.arV == null) {
            return;
        }
        this.arf.addView(this.arV.contentView);
    }

    /* loaded from: classes2.dex */
    public static class a extends b.C0169b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0169b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g aU(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: cn */
        public a cm(int i) {
            super.cm(i);
            return this;
        }

        public a V(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0169b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g Aq() {
            d dVar = (d) super.Aq();
            dVar.a(this);
            return dVar;
        }
    }
}
