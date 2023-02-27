package com.baidu.mobstat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.mobstat.cd;
/* loaded from: classes2.dex */
public class by {
    public static void a(Context context, final cb cbVar) {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        context.bindService(intent, new ServiceConnection() { // from class: com.baidu.mobstat.by.1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    cd a = cd.a.a(iBinder);
                    if (!TextUtils.isEmpty(a.a()) && cb.this != null) {
                        cb.this.a(a.a());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1);
    }
}
