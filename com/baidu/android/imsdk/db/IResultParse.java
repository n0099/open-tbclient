package com.baidu.android.imsdk.db;

import android.database.Cursor;
/* loaded from: classes6.dex */
public interface IResultParse<T> {
    T onParse(Cursor cursor);
}
