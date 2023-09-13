package com.baidu.cyberplayer.sdk.task;

import com.baidu.cyberplayer.sdk.Keep;
import java.util.HashMap;
@Keep
/* loaded from: classes3.dex */
public abstract class Task {
    public final String mName;
    public final HashMap<String, String> mParams;

    public abstract void run() throws Exception;

    public Task(String str, HashMap<String, String> hashMap) {
        this.mName = str;
        this.mParams = hashMap;
    }

    public String getName() {
        return this.mName;
    }
}
