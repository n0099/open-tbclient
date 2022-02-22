package com.baidu.android.imsdk.request;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import c.a.u.a;
import c.a.v.a.b.d.b;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AckHandlerThread extends HandlerThread {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ACK_DELAY = 1000;
    public static final int RETRY_COUNT = 3;
    public static String TAG = "AckHandlerThread";
    public static final String THREAD_NAME = "AckHandlerThread";
    public static AckHandlerThread sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mAckHandler;
    public Context mContext;
    public AtomicInteger mRetryCount;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1349860201, "Lcom/baidu/android/imsdk/request/AckHandlerThread;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1349860201, "Lcom/baidu/android/imsdk/request/AckHandlerThread;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AckHandlerThread(Context context) {
        super(THREAD_NAME);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRetryCount = new AtomicInteger(0);
        this.mContext = context;
        start();
        this.mAckHandler = new Handler(this, getLooper()) { // from class: com.baidu.android.imsdk.request.AckHandlerThread.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AckHandlerThread this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull android.os.Message message) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 1) {
                    AckHandlerThread ackHandlerThread = this.this$0;
                    ackHandlerThread.retryAck(ackHandlerThread.mContext, (NewAckMessage) message.obj);
                }
            }
        };
    }

    public static AckHandlerThread getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (sInstance == null) {
                synchronized (AckHandlerThread.class) {
                    if (sInstance == null) {
                        sInstance = new AckHandlerThread(context);
                    }
                }
            }
            return sInstance;
        }
        return (AckHandlerThread) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryAck(Context context, NewAckMessage newAckMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, this, context, newAckMessage) == null) && a.f14716e && newAckMessage != null) {
            BLCPRequest bLCPRequest = new BLCPRequest();
            bLCPRequest.a = 2L;
            bLCPRequest.f34855b = 95L;
            bLCPRequest.f34856c = newAckMessage.getBody().getBytes();
            bLCPRequest.f34857d = System.nanoTime();
            String str = TAG;
            LogUtils.d(str, "ackRequest msgid:" + bLCPRequest.f34857d);
            c.a.v.a.b.a.c(bLCPRequest, new b(this, newAckMessage, context) { // from class: com.baidu.android.imsdk.request.AckHandlerThread.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AckHandlerThread this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ NewAckMessage val$msg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, newAckMessage, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$msg = newAckMessage;
                    this.val$context = context;
                }

                @Override // c.a.v.a.b.d.b
                public void onResponse(int i2, String str2, long j2, long j3, long j4, byte[] bArr) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), bArr}) == null) && i2 == 0) {
                        try {
                            JSONObject jSONObject = new JSONObject(new String(bArr));
                            int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE, -1);
                            String optString = jSONObject.optString("msg", "");
                            if (j3 == 95) {
                                String str3 = AckHandlerThread.TAG;
                                LogUtils.d(str3, "retry Ack Response err :" + optInt + ", methodId :" + j3 + ", data :" + bArr.length);
                                this.val$msg.handleMessageResult(this.val$context, new JSONObject(new String(bArr)), optInt, optString);
                                if (optInt != 0) {
                                    if (this.this$0.mRetryCount.get() < 3) {
                                        LogUtils.d(AckHandlerThread.TAG, "ack failed, retry~~");
                                        this.this$0.mAckHandler.sendMessageDelayed(AckMessage.getSendMessage(1, this.val$msg), 1000L);
                                    }
                                    this.this$0.mRetryCount.incrementAndGet();
                                }
                                this.this$0.mRetryCount.set(0);
                            }
                        } catch (JSONException e2) {
                            LogUtils.e(AckHandlerThread.TAG, "handle sendNewAckToServer response, e :", e2);
                        }
                    }
                }
            });
        }
    }

    public Handler getAckHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAckHandler : (Handler) invokeV.objValue;
    }
}
