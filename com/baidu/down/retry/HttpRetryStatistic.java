package com.baidu.down.retry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class HttpRetryStatistic {
    public static final String DATA = "DATA:";
    public static final boolean DEBUG = false;
    public static final String RETRY_DOWNLOAD_FLOW_TIME = "dft:";
    public static final String RETRY_EXCEPTION_NAME = "expn:";
    public static final String RETRY_HOST = "h:";
    public static final String RETRY_REQUEST_ID = "qid:";
    public static final String RETRY_RESULT = "rs:";
    public static final String RETRY_RESULT_FAIL = "f";
    public static final String RETRY_RESULT_SUCCESS = "s";
    public static final String RETRY_URL = "url:";
    public static final String RETYR_MODE = "md:";
    public static final String TAG = "HttpRetryStatistic";
    public static final String THREAD = "THREAD:";

    public static String buidTaskRetryStatistic(ConcurrentHashMap<Integer, String> concurrentHashMap, int i, long j, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : concurrentHashMap.entrySet()) {
            sb.append(THREAD + entry.getKey() + "\n");
            sb.append(DATA + entry.getValue() + "\n");
        }
        sb.append(RETYR_MODE + i + "\n");
        sb.append(RETRY_DOWNLOAD_FLOW_TIME + j + "\n");
        sb.append(RETRY_EXCEPTION_NAME + str + "\n");
        sb.append(RETRY_REQUEST_ID + str2 + "\n");
        sb.append("buid task time:" + System.currentTimeMillis() + "\n");
        return sb.toString();
    }

    public static String buildRetryStatistic(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n retrytag: \n");
        sb.append(RETRY_URL + str + "\n");
        sb.append(RETRY_RESULT + str2 + "\n");
        sb.append(RETRY_HOST + str3 + "\n");
        return sb.toString();
    }
}
