package com.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.asus.msa.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes4.dex */
public class SupplementaryDIDManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "SupplementaryDIDManager";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isBinded;
    public Context mContext;
    public com.asus.msa.a.a mDidService;
    public com.asus.msa.sdid.a mListener;
    public ServiceConnection mServiceConnection;

    /* loaded from: classes4.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SupplementaryDIDManager f36107e;

        public a(SupplementaryDIDManager supplementaryDIDManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {supplementaryDIDManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36107e = supplementaryDIDManager;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                boolean unused = SupplementaryDIDManager.DEBUG;
                this.f36107e.mDidService = a.AbstractBinderC1569a.a(iBinder);
                this.f36107e.notifyAllListeners(true);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f36107e.notifyAllListeners(false);
            }
        }
    }

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isBinded = false;
        this.mServiceConnection = new a(this);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAllListeners(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
            try {
                if (z) {
                    this.mListener.a(this.mDidService);
                } else {
                    this.mListener.a();
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    String str = "notify did bind status error :" + e2.getMessage();
                }
            }
        }
    }

    public void deInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (!this.isBinded || this.mServiceConnection == null || this.mContext == null) {
                    return;
                }
                boolean z = DEBUG;
                this.isBinded = false;
                this.mContext.unbindService(this.mServiceConnection);
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }

    public void init(com.asus.msa.sdid.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            try {
                this.mListener = aVar;
                Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
                ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                boolean z = DEBUG;
                this.isBinded = this.mContext.bindService(intent2, this.mServiceConnection, 1);
            } catch (Exception unused) {
                notifyAllListeners(false);
            }
        }
    }

    public void showLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            DEBUG = z;
        }
    }
}
