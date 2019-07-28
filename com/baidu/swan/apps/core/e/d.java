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
    private FrameLayout arI;
    private a asy;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.asy = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View f(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.arI = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        AW();
        return inflate;
    }

    private void AW() {
        if (this.asy == null) {
            return;
        }
        this.arI.addView(this.asy.contentView);
    }

    /* loaded from: classes2.dex */
    public static class a extends b.C0171b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0171b, com.baidu.swan.apps.res.widget.dialog.g.a
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

        public a X(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0171b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g AX() {
            d dVar = (d) super.AX();
            dVar.a(this);
            return dVar;
        }
    }
}
