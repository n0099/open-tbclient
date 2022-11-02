package com.android.msasdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.android.creator.IdsSupplier;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes.dex */
public class FreemeIds implements FreemeIdsSupplier {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final String TAG = "FreemeIds";
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public Context context;
    @Keep
    public IConnect iConnect;
    @Keep
    public IdsSupplier idsSupplier;
    @Keep
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
            @Keep
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
            @Keep
            public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

            @Override // android.content.ServiceConnection
            @Keep
            public native void onServiceDisconnected(ComponentName componentName);
        };
        this.context = context;
    }

    @Override // com.android.msasdk.FreemeIdsSupplier
    @Keep
    public native void connect(IConnect iConnect);

    @Override // com.android.msasdk.FreemeIdsSupplier
    @Keep
    public native String getAAID(String str);

    @Override // com.android.msasdk.FreemeIdsSupplier
    @Keep
    public native String getOAID();

    @Override // com.android.msasdk.FreemeIdsSupplier
    @Keep
    public native String getUDID(String str);

    @Override // com.android.msasdk.FreemeIdsSupplier
    @Keep
    public native String getVAID(String str);

    @Override // com.android.msasdk.FreemeIdsSupplier
    @Keep
    public native boolean isSupported();

    @Override // com.android.msasdk.FreemeIdsSupplier
    @Keep
    public native void shutDown();
}
