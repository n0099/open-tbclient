package com.baidu.prologue.a.c;

import android.util.Log;
/* loaded from: classes10.dex */
class a implements g {
    @Override // com.baidu.prologue.a.c.g
    public int d(String str, String str2) {
        return Log.d(str, str2);
    }

    @Override // com.baidu.prologue.a.c.g
    public int e(String str, String str2) {
        return Log.e(str, str2);
    }

    @Override // com.baidu.prologue.a.c.g
    public int e(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }
}
