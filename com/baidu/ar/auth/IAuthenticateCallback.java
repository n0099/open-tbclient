package com.baidu.ar.auth;

import java.util.List;
/* loaded from: classes.dex */
public interface IAuthenticateCallback {
    void onAvailFeaturesChanged(List list);

    void onFeatureRejected(int i);

    void onResult(boolean z, List list);
}
