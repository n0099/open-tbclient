package com.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes.dex */
public class SupplementaryDIDManager {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static boolean DEBUG = false;
    @Keep
    public static final String TAG = "SupplementaryDIDManager";
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public boolean isBinded;
    @Keep
    public Context mContext;
    @Keep
    public IDidAidlInterface mDidService;
    @Keep
    public IDIDBinderStatusListener mListener;
    @Keep
    public ServiceConnection mServiceConnection;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(645146856, "Lcom/asus/msa/sdid/SupplementaryDIDManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(645146856, "Lcom/asus/msa/sdid/SupplementaryDIDManager;");
        }
    }

    public SupplementaryDIDManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isBinded = false;
        this.mServiceConnection = new ServiceConnection(this) { // from class: com.asus.msa.sdid.SupplementaryDIDManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @Keep
            public final /* synthetic */ SupplementaryDIDManager this$0;

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
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Keep
    public native void notifyAllListeners(boolean z);

    @Keep
    public native void deInit();

    @Keep
    public native void init(IDIDBinderStatusListener iDIDBinderStatusListener);

    @Keep
    public native void showLog(boolean z);
}
