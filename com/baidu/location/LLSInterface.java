package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes2.dex */
public interface LLSInterface {
    double getVersion();

    IBinder onBind(Intent intent);

    void onCreate(Context context);

    void onDestroy();

    int onStartCommand(Intent intent, int i2, int i3);

    void onTaskRemoved(Intent intent);

    boolean onUnBind(Intent intent);
}
