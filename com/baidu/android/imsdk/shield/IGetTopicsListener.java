package com.baidu.android.imsdk.shield;

import com.baidu.android.imsdk.IMListener;
import java.util.List;
/* loaded from: classes.dex */
public interface IGetTopicsListener extends IMListener {
    void onResult(int i, String str, List<Long> list);
}
