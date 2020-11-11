package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes10.dex */
public class d extends com.baidu.swan.apps.res.widget.dialog.b {
    private FrameLayout bJO;
    private a cMe;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.cMe = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.bJO = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        apO();
        return inflate;
    }

    private void apO() {
        if (this.cMe == null) {
            return;
        }
        this.bJO.addView(this.cMe.contentView);
    }

    /* loaded from: classes10.dex */
    public static class a extends b.C0469b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0469b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bX(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: ig */
        public a mo33if(int i) {
            super.mo33if(i);
            return this;
        }

        public a aw(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0469b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g apP() {
            d dVar = (d) super.apP();
            dVar.a(this);
            return dVar;
        }
    }
}
