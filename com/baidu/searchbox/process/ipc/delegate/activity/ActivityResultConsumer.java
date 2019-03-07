package com.baidu.searchbox.process.ipc.delegate.activity;

import android.content.Intent;
/* loaded from: classes.dex */
public interface ActivityResultConsumer {
    boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent);
}
