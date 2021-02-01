package com.baidu.platform.domain;

import com.baidu.mapapi.http.HttpClient;
/* loaded from: classes4.dex */
public class d {
    public static c a() {
        return HttpClient.isHttpsEnable ? new b() : new a();
    }
}
