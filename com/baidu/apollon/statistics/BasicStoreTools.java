package com.baidu.apollon.statistics;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class BasicStoreTools {
    public static final String STAT_LAST_SENDDATA = "stat__lastdata";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3810b = "stat_strategy";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3811c = "last_evt_id";

    /* renamed from: a  reason: collision with root package name */
    public final String f3812a;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final BasicStoreTools f3813a = new BasicStoreTools();
    }

    public static BasicStoreTools getInstance() {
        return a.f3813a;
    }

    public String getLastData(Context context) {
        return context.getSharedPreferences("Stat_SDK_SendRem", 0).getString(STAT_LAST_SENDDATA, "");
    }

    public long getLastEvtId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Stat_SDK_SendRem", 0);
        try {
            return sharedPreferences.getLong(f3811c, 0L);
        } catch (ClassCastException unused) {
            return sharedPreferences.getInt(f3811c, 0);
        }
    }

    public String getStrategy(Context context) {
        return context.getSharedPreferences("Stat_SDK_SendRem", 0).getString(f3810b, "");
    }

    public void setLastData(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
        edit.putString(STAT_LAST_SENDDATA, str);
        edit.commit();
    }

    public void setLastEvtId(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
        edit.putLong(f3811c, j);
        edit.commit();
    }

    public void setStrategy(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
        edit.putString(f3810b, str);
        edit.commit();
    }

    public BasicStoreTools() {
        this.f3812a = "Stat_SDK_SendRem";
    }
}
