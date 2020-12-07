package com.baidu.ar.bus;

import com.baidu.searchbox.ugc.model.UgcConstant;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class e {
    final Method kI;
    final ThreadMode kJ;
    final Class<?> kK;
    String kL;

    public e(Method method, Class<?> cls, ThreadMode threadMode) {
        this.kI = method;
        this.kJ = threadMode;
        this.kK = cls;
    }

    private synchronized void cI() {
        if (this.kL == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.kI.getDeclaringClass().getName());
            sb.append(UgcConstant.TOPIC_PATTERN_TAG).append(this.kI.getName());
            sb.append('(').append(this.kK.getName());
            this.kL = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            cI();
            e eVar = (e) obj;
            eVar.cI();
            return this.kL.equals(eVar.kL);
        }
        return false;
    }

    public int hashCode() {
        return this.kI.hashCode();
    }
}
