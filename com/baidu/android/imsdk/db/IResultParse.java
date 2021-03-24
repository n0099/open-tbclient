package com.baidu.android.imsdk.db;

import android.database.Cursor;
/* loaded from: classes2.dex */
public interface IResultParse<T> {
    T onParse(Cursor cursor);
}
