package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.a.d;
import com.baidu.poly.a.e;
import com.baidu.poly.widget.ChannelListView;
/* loaded from: classes2.dex */
public class a {
    private ChannelListView ahq;
    private Context context;

    /* loaded from: classes2.dex */
    public static class b {
        public static int ONLINE = 1;
        public static int ahw = 2;
        public static int PREVIEW = 3;
    }

    public a(Context context, d dVar, com.baidu.poly.b.c cVar, com.baidu.poly.d.a aVar, int i) {
        if (aVar == null) {
            throw new IllegalStateException("wallet can not be null");
        }
        this.context = context;
        dVar = dVar == null ? new e() : dVar;
        cVar = cVar == null ? com.baidu.poly.b.a.bo(context) : cVar;
        com.baidu.poly.a.a.a.a(dVar, i);
        com.baidu.poly.b.b.a(cVar);
        com.baidu.poly.d.b.b(aVar);
    }

    public void a(Bundle bundle, c cVar) {
        if (bundle == null) {
            throw new NullPointerException("arguments can not be null");
        }
        if (this.ahq == null || !this.ahq.uJ()) {
            this.ahq = new ChannelListView(this.context).j(i(bundle)).a(cVar).a(new ChannelListView.a() { // from class: com.baidu.poly.a.1
                @Override // com.baidu.poly.widget.ChannelListView.a
                public void onClose() {
                    a.this.ahq = null;
                }
            }).uI();
        }
    }

    private Bundle i(Bundle bundle) {
        bundle.putString("deviceType", "ANDROID");
        bundle.putString("channel", "cashiersdk");
        return bundle;
    }

    public boolean finish() {
        if (this.ahq != null) {
            this.ahq.detach();
            this.ahq = null;
            return true;
        }
        return false;
    }

    /* loaded from: classes2.dex */
    public static class c {
        public void onResult(int i, String str) {
        }

        public void dj(String str) {
        }

        public void onCancel(String str) {
        }
    }

    /* renamed from: com.baidu.poly.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0110a {
        private d ahs;
        private com.baidu.poly.b.c aht;
        private com.baidu.poly.d.a ahu;
        private int ahv = b.ONLINE;

        public C0110a a(com.baidu.poly.d.a aVar) {
            this.ahu = aVar;
            return this;
        }

        public C0110a bK(int i) {
            this.ahv = i;
            return this;
        }

        public a bn(Context context) {
            return new a(context, this.ahs, this.aht, this.ahu, this.ahv);
        }
    }
}
