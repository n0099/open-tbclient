package com.baidu.android.pushservice.ach.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: com.baidu.android.pushservice.ach.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0025a implements b {
            public IBinder a;

            public C0025a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return (IBinder) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15937, this, null);
            }
        }

        public static b a(IBinder iBinder) {
            return (b) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15940, null, iBinder);
        }
    }
}
