package com.baidu.tbadk.core.sharedPref;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.h0.r.d0.a;
/* loaded from: classes3.dex */
public class MainSharedPrefProvider extends ContentProvider {
    private SharedPreferences getSharedPreferences() {
        try {
            if (TbadkCoreApplication.getInst().getApp() != null) {
                return TbadkCoreApplication.getInst().getApp().getSharedPreferences("common_settings", 0);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private boolean needBroadcast(String str) {
        if (str != null && str.length() != 0) {
            int length = a.k.length;
            for (int i = 0; i < length; i++) {
                if (a.k[i].equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void sendBroadcast(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.getBroadcastActionChangeSharedPref());
        intent.putExtra("intent_key", str);
        intent.putExtra("intent_value", str2);
        TbadkCoreApplication.getInst().getApp().sendBroadcast(intent);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        SharedPreferences sharedPreferences;
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || lastPathSegment.length() <= 0 || (sharedPreferences = getSharedPreferences()) == null) {
            return 0;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(lastPathSegment);
        edit.commit();
        if (needBroadcast(lastPathSegment)) {
            sendBroadcast(lastPathSegment, null);
            return 0;
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        SharedPreferences sharedPreferences;
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || lastPathSegment.length() <= 0 || (sharedPreferences = getSharedPreferences()) == null) {
            return null;
        }
        return sharedPreferences.getString(lastPathSegment, null);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues == null || contentValues.size() <= 0) {
            return null;
        }
        String lastPathSegment = uri.getLastPathSegment();
        String asString = contentValues.getAsString(lastPathSegment);
        SharedPreferences sharedPreferences = getSharedPreferences();
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(lastPathSegment, asString);
            edit.commit();
            if (needBroadcast(lastPathSegment)) {
                sendBroadcast(lastPathSegment, asString);
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
