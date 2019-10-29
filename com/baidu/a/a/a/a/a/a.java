package com.baidu.a.a.a.a.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a {
    protected List<String> KW;
    protected List<com.baidu.a.a.b.a.a> KX;
    protected String mChannelId;
    protected String mChannelName;

    public a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("DefaultDynamicCallback init, param channelId should not be null");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new RuntimeException("DefaultDynamicCallback init, param channelName should not be null");
        }
        this.mChannelId = str;
        this.mChannelName = str2;
        this.KW = new ArrayList();
        this.KW.add(str3);
        this.KX = new ArrayList();
    }

    public a(String str, String str2, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("DefaultDynamicCallback init, param channelId should not be null");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new RuntimeException("DefaultDynamicCallback init, param channelName should not be null");
        }
        this.mChannelId = str;
        this.mChannelName = str2;
        this.KW = list;
        this.KX = new ArrayList();
    }
}
