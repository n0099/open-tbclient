package com.baidu.android.imsdk.db;

import android.database.Cursor;
/* loaded from: classes10.dex */
public interface IResultParse<T> {
    T onParse(Cursor cursor);
}
