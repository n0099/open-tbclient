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
    private FrameLayout box;
    private a bpy;

    protected d(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.bpy = aVar;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.b
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.box = (FrameLayout) inflate.findViewById(a.f.ssl_certificate_container);
        Pb();
        return inflate;
    }

    private void Pb() {
        if (this.bpy == null) {
            return;
        }
        this.box.addView(this.bpy.contentView);
    }

    /* loaded from: classes11.dex */
    public static class a extends b.C0282b {
        private View contentView;

        public a(Context context) {
            super(context);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0282b, com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bX(Context context) {
            return new d(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        /* renamed from: eE */
        public a eD(int i) {
            super.eD(i);
            return this;
        }

        public a aj(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.b.C0282b, com.baidu.swan.apps.res.widget.dialog.g.a
        public g Pc() {
            d dVar = (d) super.Pc();
            dVar.a(this);
            return dVar;
        }
    }
}
