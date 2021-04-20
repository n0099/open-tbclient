package com.baidu.mobads.container.util;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class XAdRemoteURLLoaderEvent extends XAdRemoteEvent {
    public String mURL;

    public XAdRemoteURLLoaderEvent(String str, HashMap<String, Object> hashMap, String str2) {
        super(str, hashMap);
        this.mURL = str2;
    }

    public String getURL() {
        return this.mURL;
    }

    public XAdRemoteURLLoaderEvent(String str, String str2, String str3) {
        super(str, str2);
        this.mURL = str3;
    }
}
