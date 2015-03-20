package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class ab<T> extends x<T> {
    public ab(String str, s<T> sVar) {
        super(str, sVar);
    }

    @Override // com.baidu.adp.lib.cache.x, com.baidu.adp.lib.cache.t
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

    @Override // com.baidu.adp.lib.cache.x, com.baidu.adp.lib.cache.t
    public v<T> ab(String str) {
        try {
            return super.ab(str);
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
