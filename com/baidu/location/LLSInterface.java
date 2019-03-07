package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
/* loaded from: classes3.dex */
public interface LLSInterface {
    double getVersion();

    IBinder onBind(Intent intent);

    void onCreate(Context context);

    void onDestroy();

    int onStartCommand(Intent intent, int i, int i2);

    void onTaskRemoved(Intent intent);

    boolean onUnBind(Intent intent);
}
