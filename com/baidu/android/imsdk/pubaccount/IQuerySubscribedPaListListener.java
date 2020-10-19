package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMListener;
import java.util.List;
/* loaded from: classes5.dex */
public interface IQuerySubscribedPaListListener extends IMListener {
    void onQuerySubscribedPaResult(int i, String str, List<PaInfo> list);
}
