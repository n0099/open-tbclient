package com.baidu.sapi2.callback;

import java.util.List;
/* loaded from: classes2.dex */
public interface ShareModelResultCallback {
    void onFailure(int i, String str);

    void onSuccess(List list);
}
