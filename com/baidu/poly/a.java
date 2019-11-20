package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.a.d;
import com.baidu.poly.a.e;
import com.baidu.poly.widget.ChannelListView;
/* loaded from: classes2.dex */
public class a {
    private ChannelListView aAt;
    private Context context;

    /* loaded from: classes2.dex */
    public static class b {
        public static int aAz = 1;
        public static int aAA = 2;
        public static int aAB = 3;
    }

    public a(Context context, d dVar, com.baidu.poly.b.c cVar, com.baidu.poly.d.a aVar, int i) {
        if (aVar == null) {
            throw new IllegalStateException("wallet can not be null");
        }
        this.context = context;
        dVar = dVar == null ? new e() : dVar;
        cVar = cVar == null ? com.baidu.poly.b.a.aE(context) : cVar;
        com.baidu.poly.a.a.a.a(dVar, i);
        com.baidu.poly.b.b.a(cVar);
        com.baidu.poly.d.b.b(aVar);
        if (i == b.aAz) {
            com.baidu.poly.util.b.enable(false);
        }
    }

    public void a(Bundle bundle, c cVar) {
        if (bundle == null) {
            throw new NullPointerException("arguments can not be null");
        }
        if (this.aAt == null || !this.aAt.zY()) {
            this.aAt = new ChannelListView(this.context).j(i(bundle)).a(cVar).a(new ChannelListView.a() { // from class: com.baidu.poly.a.1
                @Override // com.baidu.poly.widget.ChannelListView.a
                public void onClose() {
                    a.this.aAt = null;
                }
            }).zX();
        }
    }

    private Bundle i(Bundle bundle) {
        bundle.putString("deviceType", "ANDROID");
        bundle.putString("channel", "cashiersdk");
        return bundle;
    }

    public boolean zD() {
        if (this.aAt != null) {
            this.aAt.detach();
            this.aAt = null;
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
    public static class C0126a {
        private d aAv;
        private com.baidu.poly.b.c aAw;
        private com.baidu.poly.d.a aAx;
        private int aAy = b.aAz;

        public C0126a a(com.baidu.poly.d.a aVar) {
            this.aAx = aVar;
            return this;
        }

        public C0126a cA(int i) {
            this.aAy = i;
            return this;
        }

        public a aD(Context context) {
            return new a(context, this.aAv, this.aAw, this.aAx, this.aAy);
        }
    }
}
