package com.baidu.cyberplayer.sdk.context;

import com.baidu.cyberplayer.sdk.Keep;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public interface ICyberMediaAbTest {
    JSONObject getRawSwitch();

    String getSid();

    double getSwitch(String str, double d);

    int getSwitch(String str, int i);

    long getSwitch(String str, long j);

    String getSwitch(String str, String str2);

    boolean getSwitch(String str, boolean z);

    boolean has(String str);
}
