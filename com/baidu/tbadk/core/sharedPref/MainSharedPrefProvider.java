package com.baidu.tbadk.core.sharedPref;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class MainSharedPrefProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
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
        if (contentValues != null && contentValues.size() > 0) {
            String lastPathSegment = uri.getLastPathSegment();
            String asString = contentValues.getAsString(lastPathSegment);
            SharedPreferences sharedPreferences = getSharedPreferences();
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(lastPathSegment, asString);
                edit.commit();
                if (cP(lastPathSegment)) {
                    T(lastPathSegment, asString);
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        SharedPreferences sharedPreferences;
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null && lastPathSegment.length() > 0 && (sharedPreferences = getSharedPreferences()) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(lastPathSegment);
            edit.commit();
            if (cP(lastPathSegment)) {
                T(lastPathSegment, null);
                return 0;
            }
            return 0;
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private void T(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.getBroadcastActionChangeSharedPref());
        intent.putExtra("intent_key", str);
        intent.putExtra("intent_value", str2);
        TbadkCoreApplication.m9getInst().getApp().sendBroadcast(intent);
    }

    private boolean cP(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = a.Yr.length;
        for (int i = 0; i < length; i++) {
            if (a.Yr[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    private SharedPreferences getSharedPreferences() {
        try {
            if (TbadkCoreApplication.m9getInst().getApp() != null) {
                return TbadkCoreApplication.m9getInst().getApp().getSharedPreferences("common_settings", 0);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
