package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationClient f39759a;

    public b(LocationClient locationClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {locationClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39759a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle c2;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            this.f39759a.f39746g = new Messenger(iBinder);
            if (this.f39759a.f39746g == null) {
                return;
            }
            this.f39759a.f39744e = true;
            z = this.f39759a.x;
            if (z) {
                this.f39759a.f39747h.obtainMessage(2).sendToTarget();
                return;
            }
            try {
                Message obtain = Message.obtain((Handler) null, 11);
                obtain.replyTo = this.f39759a.f39748i;
                c2 = this.f39759a.c();
                obtain.setData(c2);
                this.f39759a.f39746g.send(obtain);
                this.f39759a.f39744e = true;
                if (this.f39759a.f39742c != null) {
                    bool = this.f39759a.A;
                    bool.booleanValue();
                    this.f39759a.f39747h.obtainMessage(4).sendToTarget();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            this.f39759a.f39746g = null;
            this.f39759a.f39744e = false;
        }
    }
}
