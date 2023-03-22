package com.baidu.searchbox.track.ui;

import android.app.Activity;
/* loaded from: classes2.dex */
public interface ITraceFragmentCallback {
    boolean register(Activity activity);

    boolean unregister(Activity activity);
}
