package com.baidu.poly;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.a.d;
import com.baidu.poly.a.e;
import com.baidu.poly.widget.ChannelListView;
import com.sina.weibo.sdk.statistic.LogBuilder;
/* loaded from: classes2.dex */
public class a {
    private ChannelListView agR;
    private Context context;

    /* loaded from: classes2.dex */
    public static class b {
        public static int agX = 1;
        public static int agY = 2;
        public static int agZ = 3;
    }

    public a(Context context, d dVar, com.baidu.poly.b.c cVar, com.baidu.poly.d.a aVar, int i) {
        if (aVar == null) {
            throw new IllegalStateException("wallet can not be null");
        }
        this.context = context;
        dVar = dVar == null ? new e() : dVar;
        cVar = cVar == null ? com.baidu.poly.b.a.aA(context) : cVar;
        com.baidu.poly.a.a.a.a(dVar, i);
        com.baidu.poly.b.b.a(cVar);
        com.baidu.poly.d.b.b(aVar);
        if (i == b.agX) {
            com.baidu.poly.util.b.enable(false);
        }
    }

    public void a(Bundle bundle, c cVar) {
        if (bundle == null) {
            throw new NullPointerException("arguments can not be null");
        }
        if (this.agR == null || !this.agR.uZ()) {
            this.agR = new ChannelListView(this.context).j(i(bundle)).a(cVar).a(new ChannelListView.a() { // from class: com.baidu.poly.a.1
                @Override // com.baidu.poly.widget.ChannelListView.a
                public void onClose() {
                    a.this.agR = null;
                }
            }).uY();
        }
    }

    private Bundle i(Bundle bundle) {
        bundle.putString("deviceType", "ANDROID");
        bundle.putString(LogBuilder.KEY_CHANNEL, "cashiersdk");
        return bundle;
    }

    public boolean uE() {
        if (this.agR != null) {
            this.agR.detach();
            this.agR = null;
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
    public static class C0080a {
        private d agT;
        private com.baidu.poly.b.c agU;
        private com.baidu.poly.d.a agV;
        private int agW = b.agX;

        public C0080a a(com.baidu.poly.d.a aVar) {
            this.agV = aVar;
            return this;
        }

        public C0080a bD(int i) {
            this.agW = i;
            return this;
        }

        public a az(Context context) {
            return new a(context, this.agT, this.agU, this.agV, this.agW);
        }
    }
}
