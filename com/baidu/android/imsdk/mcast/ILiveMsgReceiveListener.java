package com.baidu.android.imsdk.mcast;

import com.baidu.android.imsdk.IMListener;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public interface ILiveMsgReceiveListener extends IMListener {
    void onReceiveMessage(int i, JSONArray jSONArray);
}
