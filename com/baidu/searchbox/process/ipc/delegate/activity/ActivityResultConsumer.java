package com.baidu.searchbox.process.ipc.delegate.activity;

import android.content.Intent;
/* loaded from: classes3.dex */
public interface ActivityResultConsumer {
    boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent);
}
