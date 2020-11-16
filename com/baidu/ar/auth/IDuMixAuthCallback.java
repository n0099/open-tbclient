package com.baidu.ar.auth;

import java.util.List;
/* loaded from: classes12.dex */
public interface IDuMixAuthCallback {
    void onAvailFeaturesUpdate(List<Integer> list);

    void onFeatureRejected(int i);

    void onResult(boolean z);
}
