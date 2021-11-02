package com.baidu.tbadk.core.frameworkData;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RemoteActivityProxyService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PLUGIN_CHECK_RESULT = 0;
    public static final int PLUGIN_LOADED_FAILED = 2;
    public static final int PLUGIN_LOADED_SUCCEED = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Messenger mMessenger;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            boolean z;
            Bundle data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message == null) {
                return;
            }
            Messenger messenger = message.replyTo;
            try {
                data = message.getData();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            if (data != null) {
                String string = data.getString(DealIntentService.KEY_CLASS);
                if (!TextUtils.isEmpty(string)) {
                    Class.forName(string);
                    z = true;
                    if (messenger == null) {
                        try {
                            messenger.send(Message.obtain(null, 0, z ? 1 : 2, 0));
                            return;
                        } catch (RemoteException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
            }
            z = false;
            if (messenger == null) {
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public RemoteActivityProxyService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            if (this.mMessenger == null) {
                this.mMessenger = new Messenger(new b(null));
            }
            return this.mMessenger.getBinder();
        }
        return (IBinder) invokeL.objValue;
    }
}
