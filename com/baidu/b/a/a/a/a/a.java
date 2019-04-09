package com.baidu.b.a.a.a.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a {
    protected List<String> acG;
    protected List<com.baidu.b.a.b.a.a> acH;
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
        this.acG = new ArrayList();
        this.acG.add(str3);
        this.acH = new ArrayList();
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
        this.acG = list;
        this.acH = new ArrayList();
    }
}
