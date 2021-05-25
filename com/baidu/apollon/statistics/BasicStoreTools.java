package com.baidu.apollon.statistics;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class BasicStoreTools {
    public static final String STAT_LAST_SENDDATA = "stat__lastdata";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3901b = "stat_strategy";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3902c = "last_evt_id";

    /* renamed from: a  reason: collision with root package name */
    public final String f3903a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final BasicStoreTools f3904a = new BasicStoreTools();
    }

    public static BasicStoreTools getInstance() {
        return a.f3904a;
    }

    public String getLastData(Context context) {
        return context.getSharedPreferences("Stat_SDK_SendRem", 0).getString(STAT_LAST_SENDDATA, "");
    }

    public long getLastEvtId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Stat_SDK_SendRem", 0);
        try {
            return sharedPreferences.getLong(f3902c, 0L);
        } catch (ClassCastException unused) {
            return sharedPreferences.getInt(f3902c, 0);
        }
    }

    public String getStrategy(Context context) {
        return context.getSharedPreferences("Stat_SDK_SendRem", 0).getString(f3901b, "");
    }

    public void setLastData(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
        edit.putString(STAT_LAST_SENDDATA, str);
        edit.commit();
    }

    public void setLastEvtId(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
        edit.putLong(f3902c, j);
        edit.commit();
    }

    public void setStrategy(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
        edit.putString(f3901b, str);
        edit.commit();
    }

    public BasicStoreTools() {
        this.f3903a = "Stat_SDK_SendRem";
    }
}
