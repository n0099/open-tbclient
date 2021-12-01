package com.baidu.android.imsdk.chatuser;

import com.baidu.android.imsdk.IMListener;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public interface IGetUserIpListener extends IMListener {
    void onGetUserIpResult(int i2, String str, ArrayList<Long> arrayList, ArrayList<IpInfo> arrayList2);
}
