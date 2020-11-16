package com.baidu.ar.statistic;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public interface g {
    boolean isAllowPerformanceEvent(String str);

    void onEvent(String str, String str2);

    void onEvent(String str, Map<String, String> map);

    void onEventDebounce(String str, long j, String str2);

    void onEventDebounce(String str, long j, Map<String, String> map);

    void onEventEnd(String str);

    void onEventStart(String str);

    void onEventStatus(String str, String str2, boolean z);

    void onPerformance(String str, Map<String, String> map);

    void onPerformance(String str, JSONObject jSONObject);

    void pause();

    void release();

    void resume();

    void setPubParam(String str, String str2);

    void setPubParams(Map<String, String> map);
}
