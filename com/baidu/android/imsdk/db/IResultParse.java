package com.baidu.android.imsdk.db;

import android.database.Cursor;
/* loaded from: classes3.dex */
public interface IResultParse<T> {
    T onParse(Cursor cursor);
}
