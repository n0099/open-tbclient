package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import java.util.List;
/* loaded from: classes.dex */
public interface IMGetBottomMenuListener extends IMListener {
    void onFetchBottomMenuResult(int i, List<CapsuleDataInfo> list);
}
