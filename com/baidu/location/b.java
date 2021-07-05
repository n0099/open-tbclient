package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationClient f6504a;

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
        this.f6504a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle c2;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            this.f6504a.f6491g = new Messenger(iBinder);
            if (this.f6504a.f6491g == null) {
                return;
            }
            this.f6504a.f6489e = true;
            Log.d("baidu_location_client", "baidu location connected ...");
            z = this.f6504a.x;
            if (z) {
                this.f6504a.f6492h.obtainMessage(2).sendToTarget();
                return;
            }
            try {
                Message obtain = Message.obtain((Handler) null, 11);
                obtain.replyTo = this.f6504a.f6493i;
                c2 = this.f6504a.c();
                obtain.setData(c2);
                this.f6504a.f6491g.send(obtain);
                this.f6504a.f6489e = true;
                if (this.f6504a.f6487c != null) {
                    bool = this.f6504a.A;
                    bool.booleanValue();
                    this.f6504a.f6492h.obtainMessage(4).sendToTarget();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            this.f6504a.f6491g = null;
            this.f6504a.f6489e = false;
        }
    }
}
