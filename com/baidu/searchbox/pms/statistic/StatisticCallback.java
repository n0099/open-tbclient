package com.baidu.searchbox.pms.statistic;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface StatisticCallback {
    boolean addDownloadStatistic2(int i2, String str, String str2, String str3, long j2, String str4, String str5, int i3, int i4);

    boolean addFetchStatistic2InHost(int i2, String str, String str2, JSONObject jSONObject);
}
