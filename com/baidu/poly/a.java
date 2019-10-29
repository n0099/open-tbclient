package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.a.d;
import com.baidu.poly.a.e;
import com.baidu.poly.widget.ChannelListView;
/* loaded from: classes2.dex */
public class a {
    private ChannelListView aAL;
    private Context context;

    /* loaded from: classes2.dex */
    public static class b {
        public static int aAR = 1;
        public static int aAS = 2;
        public static int aAT = 3;
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
        if (i == b.aAR) {
            com.baidu.poly.util.b.enable(false);
        }
    }

    public void a(Bundle bundle, c cVar) {
        if (bundle == null) {
            throw new NullPointerException("arguments can not be null");
        }
        if (this.aAL == null || !this.aAL.zX()) {
            this.aAL = new ChannelListView(this.context).j(i(bundle)).a(cVar).a(new ChannelListView.a() { // from class: com.baidu.poly.a.1
                @Override // com.baidu.poly.widget.ChannelListView.a
                public void onClose() {
                    a.this.aAL = null;
                }
            }).zW();
        }
    }

    private Bundle i(Bundle bundle) {
        bundle.putString("deviceType", "ANDROID");
        bundle.putString("channel", "cashiersdk");
        return bundle;
    }

    public boolean zC() {
        if (this.aAL != null) {
            this.aAL.detach();
            this.aAL = null;
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
        private d aAN;
        private com.baidu.poly.b.c aAO;
        private com.baidu.poly.d.a aAP;
        private int aAQ = b.aAR;

        public C0126a a(com.baidu.poly.d.a aVar) {
            this.aAP = aVar;
            return this;
        }

        public C0126a cA(int i) {
            this.aAQ = i;
            return this;
        }

        public a aD(Context context) {
            return new a(context, this.aAN, this.aAO, this.aAP, this.aAQ);
        }
    }
}
