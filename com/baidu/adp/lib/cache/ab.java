package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class ab<T> extends x<T> {
    public ab(String str, s<T> sVar) {
        super(str, sVar);
    }

    @Override // com.baidu.adp.lib.cache.x, com.baidu.adp.lib.cache.t
    public T a(String str) {
        try {
            return (T) super.a(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.x, com.baidu.adp.lib.cache.t
    public v<T> b(String str) {
        try {
            return super.b(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.x, com.baidu.adp.lib.cache.t
    public void a(String str, T t, long j) {
        try {
            super.a(str, t, j);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
        }
    }

    @Override // com.baidu.adp.lib.cache.x, com.baidu.adp.lib.cache.t
    public void c(String str) {
        try {
            super.c(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
        }
    }
}
