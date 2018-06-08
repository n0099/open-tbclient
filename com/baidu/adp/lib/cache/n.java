package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class n<T> extends m<T> {
    public n(String str, k<T> kVar) {
        super(str, kVar);
    }

    @Override // com.baidu.adp.lib.cache.m, com.baidu.adp.lib.cache.l
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

    @Override // com.baidu.adp.lib.cache.m, com.baidu.adp.lib.cache.l
    public l.b<T> an(String str) {
        try {
            return super.an(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.m, com.baidu.adp.lib.cache.l
    public void a(String str, T t, long j) {
        try {
            super.a(str, t, j);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
        }
    }

    @Override // com.baidu.adp.lib.cache.m, com.baidu.adp.lib.cache.l
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
