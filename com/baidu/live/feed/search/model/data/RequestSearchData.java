package com.baidu.live.feed.search.model.data;
/* loaded from: classes2.dex */
public class RequestSearchData {
    public String refreshIndex = "1";
    public String refreshType = "0";
    public String resource = "feed";
    public String channelId = "0";
    public String sessionId = "";
    public String uploadIds = "";
    public String requestType = "search";

    public void setData(String str, String str2, String str3, String str4, String str5) {
        this.refreshIndex = str;
        this.refreshType = str2;
        this.sessionId = str3;
        this.uploadIds = str4;
        this.requestType = str5;
    }
}
