package com.baidu.sapi2.callback.inner;

import com.baidu.sapi2.share.ShareStorage;
import java.util.List;
/* loaded from: classes7.dex */
public interface GetShareV3AppCallback {
    void onFailure();

    void onSuccess(List<ShareStorage.StorageModel> list);
}
