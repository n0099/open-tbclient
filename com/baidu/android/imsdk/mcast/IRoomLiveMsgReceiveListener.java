package com.baidu.android.imsdk.mcast;

import org.json.JSONArray;
/* loaded from: classes.dex */
public interface IRoomLiveMsgReceiveListener extends ILiveMsgReceiveListener {
    void onReceiveMessage(String str, int i, JSONArray jSONArray);
}
