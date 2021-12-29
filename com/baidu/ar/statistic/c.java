package com.baidu.ar.statistic;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class c extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b wx;
    public Map<String, String> wy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Looper looper, b bVar) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wx = bVar;
        this.wy = new HashMap();
    }

    public void a(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, obj) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (!TextUtils.isEmpty(ARConfig.getARKey())) {
                    aVar.b("ar_key", ARConfig.getARKey());
                }
                aVar.b("ar_id", ARConfig.getARId());
                aVar.b(ARConfigKey.AR_FROM, ARConfig.getArFrom());
                aVar.b("ar_type", String.valueOf(ARConfig.getARType()));
                if (!this.wy.isEmpty()) {
                    aVar.a(this.wy);
                }
            }
            Message obtainMessage = obtainMessage();
            obtainMessage.what = i2;
            obtainMessage.obj = obj;
            sendMessage(obtainMessage);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 20) {
                this.wx.j((a) message.obj);
            } else if (i2 == 21) {
                this.wx.h((List) message.obj);
            } else {
                switch (i2) {
                    case 1:
                        this.wx.init();
                        return;
                    case 2:
                        this.wx.c((a) message.obj);
                        return;
                    case 3:
                        this.wx.g((a) message.obj);
                        return;
                    case 4:
                        this.wx.h((a) message.obj);
                        return;
                    case 5:
                        this.wx.i((a) message.obj);
                        return;
                    case 6:
                        this.wx.e((a) message.obj);
                        return;
                    default:
                        switch (i2) {
                            case 97:
                                this.wx.z(((Long) message.obj).longValue());
                                return;
                            case 98:
                                this.wx.A(((Long) message.obj).longValue());
                                return;
                            case 99:
                                this.wx.gk();
                                StatisticApiImpl statisticApiImpl = (StatisticApiImpl) message.obj;
                                if (statisticApiImpl != null) {
                                    statisticApiImpl.doRelease();
                                }
                                message.obj = null;
                                return;
                            default:
                                return;
                        }
                }
            }
        }
    }

    public void setPubParam(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.wy.put(str, str2);
        }
    }

    public void setPubParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, map) == null) || map == null) {
            return;
        }
        this.wy.putAll(map);
    }
}
