package com.baidu.ar.auth;

import java.util.List;
/* loaded from: classes6.dex */
public interface IDuMixAuthCallback {
    void onAvailFeaturesUpdate(List<Integer> list);

    void onFeatureRejected(int i2);

    void onResult(boolean z);
}
