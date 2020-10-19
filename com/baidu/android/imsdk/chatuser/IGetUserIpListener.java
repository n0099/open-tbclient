package com.baidu.android.imsdk.chatuser;

import com.baidu.android.imsdk.IMListener;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public interface IGetUserIpListener extends IMListener {
    void onGetUserIpResult(int i, String str, ArrayList<Long> arrayList, ArrayList<IpInfo> arrayList2);
}
