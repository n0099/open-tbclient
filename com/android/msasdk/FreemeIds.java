package com.android.msasdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.android.creator.IdsSupplier;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FreemeIds implements FreemeIdsSupplier {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FreemeIds";
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public IConnect iConnect;
    public IdsSupplier idsSupplier;
    public ServiceConnection mServiceConnection;

    public FreemeIds(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mServiceConnection = new ServiceConnection(this) { // from class: com.android.msasdk.FreemeIds.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FreemeIds this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    this.this$0.idsSupplier = IdsSupplier.Stub.asInterface(iBinder);
                    Log.d("MsaIds", "onServiceConnected");
                    this.this$0.iConnect.connectSuccess(true);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                    this.this$0.idsSupplier = null;
                    Log.d("MsaIds", "onServiceDisconnected");
                }
            }
        };
        this.context = context;
    }

    @Override // com.android.msasdk.FreemeIdsSupplier
    public void connect(IConnect iConnect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iConnect) == null) {
            Log.d("MsaIds", "connect");
            this.iConnect = iConnect;
            if (!AppUtil.isInstalled(this.context, "com.android.creator")) {
                iConnect.connectSuccess(false);
                return;
            }
            Intent intent = new Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            try {
                this.context.bindService(intent, this.mServiceConnection, 1);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.android.msasdk.FreemeIdsSupplier
    public String getAAID(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.idsSupplier != null) {
                try {
                    Log.d("MsaIds", "getAAID idsSupplier:" + this.idsSupplier);
                    Log.d("MsaIds", "getAAID pkgname:" + str);
                    return this.idsSupplier.getAAID(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.android.msasdk.FreemeIdsSupplier
    public String getOAID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            IdsSupplier idsSupplier = this.idsSupplier;
            if (idsSupplier != null) {
                try {
                    return idsSupplier.getOAID();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.android.msasdk.FreemeIdsSupplier
    public String getUDID(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            IdsSupplier idsSupplier = this.idsSupplier;
            if (idsSupplier != null) {
                try {
                    return idsSupplier.getUDID(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.android.msasdk.FreemeIdsSupplier
    public String getVAID(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            IdsSupplier idsSupplier = this.idsSupplier;
            if (idsSupplier != null) {
                try {
                    return idsSupplier.getVAID();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.android.msasdk.FreemeIdsSupplier
    public boolean isSupported() {
        InterceptResult invokeV;
        boolean isSupported;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            IdsSupplier idsSupplier = this.idsSupplier;
            if (idsSupplier != null) {
                try {
                    isSupported = idsSupplier.isSupported();
                } catch (RemoteException e) {
                    Log.d("MsaIds", "isSupported exception:" + e.getMessage());
                    e.printStackTrace();
                }
                Log.d("MsaIds", "isSupported:" + this.idsSupplier);
                Log.d("MsaIds", "isSupported ret:" + isSupported);
                return isSupported;
            }
            isSupported = false;
            Log.d("MsaIds", "isSupported:" + this.idsSupplier);
            Log.d("MsaIds", "isSupported ret:" + isSupported);
            return isSupported;
        }
        return invokeV.booleanValue;
    }

    @Override // com.android.msasdk.FreemeIdsSupplier
    public void shutDown() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.idsSupplier == null) {
            return;
        }
        this.context.unbindService(this.mServiceConnection);
    }
}
