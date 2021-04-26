package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.r.a.a;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class TiebaStaticHelper {
    public static final HashMap<String, String> mActivityNames = new HashMap<>();
    public static String mCurrentActivityAllName;
    public static String mCurrentActivityName;

    public static void addYYParam(StatisticItem statisticItem, YyExtData yyExtData) {
        if (yyExtData != null) {
            statisticItem.param(TiebaStatic.YYParams.HDID, a.a(TbadkCoreApplication.getInst().getContext()));
            statisticItem.param(TiebaStatic.YYParams.YYSID, yyExtData.mSid);
            statisticItem.param(TiebaStatic.YYParams.YYSSID, yyExtData.mSsid);
            statisticItem.param(TiebaStatic.YYParams.YYUID, yyExtData.mYyUid);
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        }
    }

    public static String getCurrentActivity() {
        return mCurrentActivityName;
    }

    public static String getCurrentActivityAllName() {
        return mCurrentActivityAllName;
    }

    public static String getShortName(String str) {
        int length;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && (length = str.length() + (-8)) >= 0) ? str.substring(0, length) : str;
    }

    public static void setCurrentActivity(String str) {
        int i2;
        mCurrentActivityAllName = str;
        if (TextUtils.isEmpty(str)) {
            mCurrentActivityName = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && (i2 = lastIndexOf + 1) < str.length()) {
            str = str.substring(i2, str.length());
        }
        HashMap<String, String> hashMap = mActivityNames;
        String str2 = hashMap != null ? hashMap.get(str) : "";
        if (str2 == null) {
            str2 = getShortName(str);
            HashMap<String, String> hashMap2 = mActivityNames;
            if (hashMap2 != null) {
                hashMap2.put(str, str2);
            }
        }
        if (str2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            mCurrentActivityName = str2 + currentTimeMillis;
        }
    }

    public static void addYYParam(StatisticItem statisticItem) {
        if (TbSingleton.getInstance().isYYSwitchStatusIsOn()) {
            statisticItem.param(TiebaStatic.YYParams.HDID, a.a(TbadkCoreApplication.getInst().getContext()));
        }
    }
}
