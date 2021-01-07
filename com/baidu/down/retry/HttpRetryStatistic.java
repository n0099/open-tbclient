package com.baidu.down.retry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class HttpRetryStatistic {
    private static final String DATA = "DATA:";
    private static final boolean DEBUG = false;
    private static final String RETRY_DOWNLOAD_FLOW_TIME = "dft:";
    private static final String RETRY_EXCEPTION_NAME = "expn:";
    private static final String RETRY_HOST = "h:";
    public static final String RETRY_REQUEST_ID = "qid:";
    private static final String RETRY_RESULT = "rs:";
    public static final String RETRY_RESULT_FAIL = "f";
    public static final String RETRY_RESULT_SUCCESS = "s";
    private static final String RETRY_URL = "url:";
    private static final String RETYR_MODE = "md:";
    private static final String TAG = "HttpRetryStatistic";
    private static final String THREAD = "THREAD:";

    public static String buildRetryStatistic(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n retrytag: \n");
        sb.append(RETRY_URL + str + "\n");
        sb.append(RETRY_RESULT + str2 + "\n");
        sb.append(RETRY_HOST + str3 + "\n");
        return sb.toString();
    }

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
}
