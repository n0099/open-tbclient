package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class t<T> extends p<T> {
    public t(String str, n<T> nVar) {
        super(str, nVar);
    }

    @Override // com.baidu.adp.lib.cache.p, com.baidu.adp.lib.cache.o
    public T get(String str) {
        try {
            return (T) super.get(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.p, com.baidu.adp.lib.cache.o
    public o.b<T> Z(String str) {
        try {
            return super.Z(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.p, com.baidu.adp.lib.cache.o
    public void a(String str, T t, long j) {
        try {
            super.a(str, t, j);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
        }
    }

    @Override // com.baidu.adp.lib.cache.p, com.baidu.adp.lib.cache.o
    public void remove(String str) {
        try {
            super.remove(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
        }
    }
}
