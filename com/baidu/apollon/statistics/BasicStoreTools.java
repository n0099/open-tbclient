package com.baidu.apollon.statistics;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class BasicStoreTools {
    public static final String STAT_LAST_SENDDATA = "stat__lastdata";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3920b = "stat_strategy";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3921c = "last_evt_id";

    /* renamed from: a  reason: collision with root package name */
    public final String f3922a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final BasicStoreTools f3923a = new BasicStoreTools();
    }

    public static BasicStoreTools getInstance() {
        return a.f3923a;
    }

    public String getLastData(Context context) {
        return context.getSharedPreferences("Stat_SDK_SendRem", 0).getString(STAT_LAST_SENDDATA, "");
    }

    public long getLastEvtId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Stat_SDK_SendRem", 0);
        try {
            return sharedPreferences.getLong(f3921c, 0L);
        } catch (ClassCastException unused) {
            return sharedPreferences.getInt(f3921c, 0);
        }
    }

    public String getStrategy(Context context) {
        return context.getSharedPreferences("Stat_SDK_SendRem", 0).getString(f3920b, "");
    }

    public void setLastData(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
        edit.putString(STAT_LAST_SENDDATA, str);
        edit.commit();
    }

    public void setLastEvtId(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
        edit.putLong(f3921c, j);
        edit.commit();
    }

    public void setStrategy(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
        edit.putString(f3920b, str);
        edit.commit();
    }

    public BasicStoreTools() {
        this.f3922a = "Stat_SDK_SendRem";
    }
}
