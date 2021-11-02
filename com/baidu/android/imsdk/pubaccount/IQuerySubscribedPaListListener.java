package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMListener;
import java.util.List;
/* loaded from: classes6.dex */
public interface IQuerySubscribedPaListListener extends IMListener {
    void onQuerySubscribedPaResult(int i2, String str, List<PaInfo> list);
}
