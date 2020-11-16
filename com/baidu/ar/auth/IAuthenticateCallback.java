package com.baidu.ar.auth;

import java.util.List;
/* loaded from: classes12.dex */
public interface IAuthenticateCallback {
    void onAvailFeaturesChanged(List<Integer> list);

    void onFeatureRejected(int i);

    void onResult(boolean z, List<Integer> list);
}
