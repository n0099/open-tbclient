package com.baidu.swan.apps.b;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.b.a.b;
import com.baidu.swan.apps.b.b.d;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = c.DEBUG;
    private d ajH;

    @NonNull
    public d uP() {
        if (this.ajH == null) {
            this.ajH = uQ();
        }
        return this.ajH;
    }

    public d uQ() {
        return new b();
    }

    /* renamed from: com.baidu.swan.apps.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0085a implements com.baidu.swan.apps.an.c.b<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.c.b
        /* renamed from: uR */
        public a uS() {
            return new a();
        }
    }
}
