package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.a.d;
import com.baidu.poly.a.e;
import com.baidu.poly.widget.ChannelListView;
import com.sina.weibo.sdk.statistic.LogBuilder;
/* loaded from: classes2.dex */
public class a {
    private ChannelListView agl;
    private Context context;

    /* loaded from: classes2.dex */
    public static class b {
        public static int agr = 1;
        public static int ags = 2;
        public static int PREVIEW = 3;
    }

    public a(Context context, d dVar, com.baidu.poly.b.c cVar, com.baidu.poly.d.a aVar, int i) {
        if (aVar == null) {
            throw new IllegalStateException("wallet can not be null");
        }
        this.context = context;
        dVar = dVar == null ? new e() : dVar;
        cVar = cVar == null ? com.baidu.poly.b.a.bg(context) : cVar;
        com.baidu.poly.a.a.a.a(dVar, i);
        com.baidu.poly.b.b.a(cVar);
        com.baidu.poly.d.b.b(aVar);
    }

    public void a(Bundle bundle, c cVar) {
        if (bundle == null) {
            throw new NullPointerException("arguments can not be null");
        }
        if (this.agl == null || !this.agl.tO()) {
            this.agl = new ChannelListView(this.context).j(i(bundle)).a(cVar).a(new ChannelListView.a() { // from class: com.baidu.poly.a.1
                @Override // com.baidu.poly.widget.ChannelListView.a
                public void onClose() {
                    a.this.agl = null;
                }
            }).tN();
        }
    }

    private Bundle i(Bundle bundle) {
        bundle.putString("deviceType", "ANDROID");
        bundle.putString(LogBuilder.KEY_CHANNEL, "cashiersdk");
        return bundle;
    }

    public boolean tt() {
        if (this.agl != null) {
            this.agl.detach();
            this.agl = null;
            return true;
        }
        return false;
    }

    /* loaded from: classes2.dex */
    public static class c {
        public void onResult(int i, String str) {
        }

        public void onFail(String str) {
        }

        public void onCancel(String str) {
        }
    }

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0078a {
        private d agn;
        private com.baidu.poly.b.c ago;
        private com.baidu.poly.d.a agp;
        private int agq = b.agr;

        public C0078a a(com.baidu.poly.d.a aVar) {
            this.agp = aVar;
            return this;
        }

        public C0078a bD(int i) {
            this.agq = i;
            return this;
        }

        public a bf(Context context) {
            return new a(context, this.agn, this.ago, this.agp, this.agq);
        }
    }
}
