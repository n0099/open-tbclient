package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMListener;
import java.util.ArrayList;
/* loaded from: classes.dex */
public interface IGetPaInfosListener extends IMListener {
    void onResult(int i, String str, ArrayList<PaInfo> arrayList);
}
