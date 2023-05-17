package com.baidu.sapi2.callback;

import com.baidu.sapi2.share.ShareStorage;
import java.util.List;
/* loaded from: classes3.dex */
public interface ShareModelResultCallback {
    void onFailure(int i, String str);

    void onSuccess(List<ShareStorage.StorageModel> list);
}
