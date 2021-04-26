package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMListener;
import java.util.List;
/* loaded from: classes.dex */
public interface ISearchPaListListener extends IMListener {
    void onSearchPaListResult(int i2, String str, List<PaInfo> list);
}
