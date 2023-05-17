package com.baidu.searchbox.account;

import com.baidu.searchbox.account.result.BoxFaceRecogResult;
/* loaded from: classes3.dex */
public interface IAccountFaceRecogCallback {
    void onFailure(BoxFaceRecogResult boxFaceRecogResult);

    void onSuccess(BoxFaceRecogResult boxFaceRecogResult);
}
