package com.baidu.browser.core.database;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.browser.core.INoProGuard;
/* loaded from: classes.dex */
public interface BdDbDataModel extends INoProGuard {
    void loadFromCursor(Cursor cursor);

    ContentValues toContentValues();
}
