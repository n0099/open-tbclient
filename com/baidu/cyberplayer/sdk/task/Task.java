package com.baidu.cyberplayer.sdk.task;

import com.baidu.cyberplayer.sdk.Keep;
import java.util.HashMap;
@Keep
/* loaded from: classes3.dex */
public abstract class Task {
    public final String a;
    public final HashMap<String, String> b;

    public abstract void run() throws Exception;

    public Task(String str, HashMap<String, String> hashMap) {
        this.a = str;
        this.b = hashMap;
    }

    public String getName() {
        return this.a;
    }
}
