package com.baidu.tbadk.core.sharedPref;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.m0.r.d0.a;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class MainSharedPrefProvider extends ContentProvider {
    public SoftReference<Map<String, String>> sCacheMap;

    private void cleanCachedValued() {
        Map<String, String> map;
        SoftReference<Map<String, String>> softReference = this.sCacheMap;
        if (softReference == null || (map = softReference.get()) == null) {
            return;
        }
        map.clear();
    }

    private boolean containsKey(String str) {
        Map<String, String> map;
        SoftReference<Map<String, String>> softReference = this.sCacheMap;
        if (softReference == null || (map = softReference.get()) == null) {
            return false;
        }
        return map.containsKey(str);
    }

    private String getCachedValue(String str) {
        Map<String, String> map;
        SoftReference<Map<String, String>> softReference = this.sCacheMap;
        if (softReference == null || (map = softReference.get()) == null) {
            return null;
        }
        return map.get(str);
    }

    private SharedPreferences getSharedPreferences() {
        try {
            return getContext().getSharedPreferences("common_settings", 0);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean needBroadcast(String str) {
        if (str != null && str.length() != 0) {
            int length = a.k.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equals(a.k[i2])) {
                    return true;
                }
            }
        }
        return false;
    }

    private void removeValueToCached(String str) {
        Map<String, String> map;
        SoftReference<Map<String, String>> softReference = this.sCacheMap;
        if (softReference == null || (map = softReference.get()) == null) {
            return;
        }
        map.remove(str);
    }

    private void sendBroadcast(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.getBroadcastActionChangeSharedPref());
        intent.putExtra("intent_key", str);
        intent.putExtra("intent_value", str2);
        TbadkCoreApplication.getInst().getApp().sendBroadcast(intent);
    }

    private void setValueToCached(String str, String str2) {
        Map<String, String> map;
        SoftReference<Map<String, String>> softReference = this.sCacheMap;
        if (softReference == null) {
            map = new HashMap<>();
            this.sCacheMap = new SoftReference<>(map);
        } else {
            map = softReference.get();
            if (map == null) {
                map = new HashMap<>();
                this.sCacheMap = new SoftReference<>(map);
            }
        }
        map.put(str, str2);
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
        removeValueToCached(lastPathSegment);
        if (needBroadcast(lastPathSegment)) {
            sendBroadcast(lastPathSegment, null);
            return 0;
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null && lastPathSegment.length() > 0) {
            if (containsKey(lastPathSegment)) {
                return getCachedValue(lastPathSegment);
            }
            SharedPreferences sharedPreferences = getSharedPreferences();
            if (sharedPreferences != null) {
                return sharedPreferences.getString(lastPathSegment, null);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        SharedPreferences sharedPreferences;
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null && contentValues != null && contentValues.size() > 0) {
            String asString = contentValues.getAsString(lastPathSegment);
            if ((!containsKey(lastPathSegment) || !TextUtils.equals(asString, getCachedValue(lastPathSegment))) && (sharedPreferences = getSharedPreferences()) != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(lastPathSegment, asString);
                edit.commit();
                setValueToCached(lastPathSegment, asString);
                if (needBroadcast(lastPathSegment)) {
                    sendBroadcast(lastPathSegment, asString);
                }
            }
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
