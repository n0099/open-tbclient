package com.baidu.ar.bus;

import com.baidu.searchbox.ugc.model.UgcConstant;
import java.lang.reflect.Method;
/* loaded from: classes11.dex */
public class e {
    final Method kt;
    final ThreadMode ku;
    final Class<?> kv;
    String kw;

    public e(Method method, Class<?> cls, ThreadMode threadMode) {
        this.kt = method;
        this.ku = threadMode;
        this.kv = cls;
    }

    private synchronized void cJ() {
        if (this.kw == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.kt.getDeclaringClass().getName());
            sb.append(UgcConstant.TOPIC_PATTERN_TAG).append(this.kt.getName());
            sb.append('(').append(this.kv.getName());
            this.kw = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            cJ();
            e eVar = (e) obj;
            eVar.cJ();
            return this.kw.equals(eVar.kw);
        }
        return false;
    }

    public int hashCode() {
        return this.kt.hashCode();
    }
}
