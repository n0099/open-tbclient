package com.baidu.searchbox.playerserver.ab;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface IPlayConfigABTest {
    JSONObject getRawSwitch();

    double getSwitch(String str, double d);

    int getSwitch(String str, int i);

    long getSwitch(String str, long j);

    String getSwitch(String str, String str2);

    boolean getSwitch(String str, boolean z);

    boolean has(String str);
}
