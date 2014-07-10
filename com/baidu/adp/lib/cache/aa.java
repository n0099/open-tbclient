package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class aa<T> extends w<T> {
    public aa(String str, r<T> rVar) {
        super(str, rVar);
    }

    @Override // com.baidu.adp.lib.cache.w, com.baidu.adp.lib.cache.s
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

    @Override // com.baidu.adp.lib.cache.w, com.baidu.adp.lib.cache.s
    public u<T> b(String str) {
        try {
            return super.b(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.w, com.baidu.adp.lib.cache.s
    public void a(String str, T t, long j) {
        try {
            super.a(str, t, j);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
        }
    }

    @Override // com.baidu.adp.lib.cache.w, com.baidu.adp.lib.cache.s
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
