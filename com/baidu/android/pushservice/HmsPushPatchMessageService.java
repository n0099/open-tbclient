package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class HmsPushPatchMessageService extends HmsMessageService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ HmsPushPatchMessageService d;

        /* renamed from: com.baidu.android.pushservice.HmsPushPatchMessageService$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0022a extends com.baidu.android.pushservice.z.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a c;

            public C0022a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
            }

            @Override // com.baidu.android.pushservice.z.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    com.baidu.android.pushservice.o.a.a(this.c.d.getApplicationContext()).b(this.c.c);
                }
            }
        }

        public a(HmsPushPatchMessageService hmsPushPatchMessageService, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hmsPushPatchMessageService, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hmsPushPatchMessageService;
            this.c = str;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!PushSettings.i(this.d.getApplicationContext()) || Build.VERSION.SDK_INT >= 29) {
                    try {
                        if (com.baidu.android.pushservice.l.d.m(this.d.getApplicationContext()) && !TextUtils.isEmpty(this.c)) {
                            e.a(this.d.getApplicationContext(), this.c, 5);
                        }
                        if (com.baidu.android.pushservice.l.d.l(this.d.getApplicationContext())) {
                            com.baidu.android.pushservice.z.e.a().a(new C0022a(this));
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public HmsPushPatchMessageService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a(Context context, RemoteMessage remoteMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, remoteMessage) == null) {
            try {
                String data = remoteMessage.getData();
                TextUtils.isEmpty(data);
                Map<String, String> dataOfMap = remoteMessage.getDataOfMap();
                if (TextUtils.isEmpty(data) && dataOfMap != null && !dataOfMap.isEmpty()) {
                    data = new JSONObject(dataOfMap).toString();
                }
                if (TextUtils.isEmpty(data)) {
                    return;
                }
                Intent intent = new Intent("com.huawei.android.push.intent.RECEIVE");
                intent.putExtra("IS_HMS_PASS_MSG_KEY", true);
                intent.putExtra("HMS_PASS_MSG_VALUE_KEY", data);
                Utility.a(intent, context.getApplicationContext());
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onDeletedMessages() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDeletedMessages();
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService, android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, remoteMessage) == null) {
            super.onMessageReceived(remoteMessage);
            if (!PushSettings.i(getApplicationContext()) || Build.VERSION.SDK_INT >= 29) {
                a(this, remoteMessage);
            }
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageSent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            super.onMessageSent(str);
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            super.onNewToken(str);
            com.baidu.android.pushservice.z.e.a().a(new a(this, str));
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onSendError(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, exc) == null) {
            super.onSendError(str, exc);
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onTokenError(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, exc) == null) {
            super.onTokenError(exc);
        }
    }
}
