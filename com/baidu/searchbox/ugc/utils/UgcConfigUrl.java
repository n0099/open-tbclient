package com.baidu.searchbox.ugc.utils;

import com.baidu.searchbox.config.HostConfig;
/* loaded from: classes8.dex */
public class UgcConfigUrl {
    public static String getSearchboxHost() {
        return HostConfig.getSearchboxHostForHttps();
    }

    public static String getQuestionEdit() {
        return String.format("%s/searchbox?action=boxconf&cmd=603", getSearchboxHost());
    }

    public static String getUgcTagUrl() {
        return String.format("%s/searchbox?action=boxconf&cmd=603", getSearchboxHost());
    }

    public static String getVideoUploadSTS() {
        return String.format("%s/searchbox?action=sprvideo&cmd=162", getSearchboxHost());
    }

    public static String getUGCCaptureFilter() {
        return String.format("%s/searchbox?action=boxconf&cmd=602", getSearchboxHost());
    }
}
