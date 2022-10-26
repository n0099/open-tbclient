package com.baidu.ar.auth;

import java.util.List;
/* loaded from: classes.dex */
public interface IDuMixAuthCallback {
    void onAvailFeaturesUpdate(List list);

    void onFeatureRejected(int i);

    void onResult(boolean z);
}
