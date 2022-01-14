package com.baidu.ar.auth;

import java.util.List;
/* loaded from: classes10.dex */
public interface IAuthenticateCallback {
    void onAvailFeaturesChanged(List<Integer> list);

    void onFeatureRejected(int i2);

    void onResult(boolean z, List<Integer> list);
}
