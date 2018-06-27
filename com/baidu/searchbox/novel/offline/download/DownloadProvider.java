package com.baidu.searchbox.novel.offline.download;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.plugins.a;
/* loaded from: classes2.dex */
public class DownloadProvider extends ContentProvider {
    private boolean isPluginSetted = false;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        setPlugin();
        if (a.KW() != null) {
            return a.KW().query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        setPlugin();
        if (a.KW() != null) {
            return a.KW().getType(uri);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        setPlugin();
        if (a.KW() != null) {
            return a.KW().insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        setPlugin();
        if (a.KW() != null) {
            return a.KW().delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        setPlugin();
        if (a.KW() != null) {
            return a.KW().update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private void setPlugin() {
        if (!this.isPluginSetted) {
            MessageManager.getInstance().runTask(new CustomMessage<>(2921337, this), (Class) null);
            if (a.KW() != null) {
                a.KW().onCreate();
                this.isPluginSetted = true;
            }
        }
    }
}
