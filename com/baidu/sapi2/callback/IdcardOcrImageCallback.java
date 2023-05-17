package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.IdcardOcrImageRusult;
/* loaded from: classes3.dex */
public abstract class IdcardOcrImageCallback {
    public abstract void onFailure(IdcardOcrImageRusult idcardOcrImageRusult);

    public abstract void onSuccess(IdcardOcrImageRusult idcardOcrImageRusult);
}
