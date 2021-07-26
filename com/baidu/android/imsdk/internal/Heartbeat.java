package com.baidu.android.imsdk.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.u.a;
/* loaded from: classes.dex */
public class Heartbeat {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ALARM_TIMEOUT = 60000;
    public static final int HEARTBEAT_TYPE_NORMAL = 0;
    public static final int HEARTBEAT_TYPE_NO_ALAMRMANAGER = 1;
    public static Heartbeat mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Handler mHandler;
    public HeartbeatOpearation mOperator;

    /* loaded from: classes.dex */
    public class BoxHeartbeat implements HeartbeatOpearation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Runnable startIMServiceTask;
        public final /* synthetic */ Heartbeat this$0;

        public BoxHeartbeat(Heartbeat heartbeat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartbeat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = heartbeat;
            this.startIMServiceTask = new Runnable(this) { // from class: com.baidu.android.imsdk.internal.Heartbeat.BoxHeartbeat.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BoxHeartbeat this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            TaskManager.getInstance(this.this$1.this$0.mContext).submitForNetWork(new Runnable(this) { // from class: com.baidu.android.imsdk.internal.Heartbeat.BoxHeartbeat.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$2;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                                        newInitContext2.initArgs = r2;
                                        Object[] objArr2 = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext2);
                                        int i4 = newInitContext2.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext2.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext2);
                                            return;
                                        }
                                    }
                                    this.this$2 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Intent intent = new Intent(this.this$2.this$1.this$0.mContext, a.class);
                                        intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                                        intent.setPackage(this.this$2.this$1.this$0.mContext.getPackageName());
                                        a.g(this.this$2.this$1.this$0.mContext).f(this.this$2.this$1.this$0.mContext, intent);
                                        this.this$2.this$1.this$0.mHandler.postDelayed(this.this$2.this$1.startIMServiceTask, Heartbeat.ALARM_TIMEOUT);
                                    }
                                }
                            });
                        } catch (Exception e2) {
                            if (e2 instanceof SecurityException) {
                                LogUtils.e("BoxHeartbeat", "box SecurityException!!", e2);
                            }
                        }
                    }
                }
            };
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void cancelHearbeat() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.this$0.mHandler.removeCallbacks(this.startIMServiceTask);
                } catch (Exception e2) {
                    LogUtils.e("Heartbeat", e2.getMessage());
                }
            }
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void startHeartbeat() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.this$0.mHandler.removeCallbacks(this.startIMServiceTask);
                    this.this$0.mHandler.postDelayed(this.startIMServiceTask, Heartbeat.ALARM_TIMEOUT);
                } catch (Exception e2) {
                    LogUtils.e("Heartbeat", e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class NormalHeartbeat implements HeartbeatOpearation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Heartbeat this$0;

        public NormalHeartbeat(Heartbeat heartbeat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heartbeat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = heartbeat;
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void cancelHearbeat() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Intent intent = new Intent();
                intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                intent.setClass(this.this$0.mContext, a.class);
                intent.setAction(Constants.ACTION_SERVICE);
                ((AlarmManager) this.this$0.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getService(this.this$0.mContext, 0, intent, Label.FORWARD_REFERENCE_TYPE_SHORT));
            }
        }

        @Override // com.baidu.android.imsdk.internal.HeartbeatOpearation
        public void startHeartbeat() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                cancelHearbeat();
                Intent intent = new Intent();
                intent.putExtra(Constants.EXTRA_ALARM_ALERT, "OK");
                intent.setClass(this.this$0.mContext, a.class);
                intent.setAction(Constants.ACTION_SERVICE);
                PendingIntent service = PendingIntent.getService(this.this$0.mContext.getApplicationContext(), 0, intent, Label.FORWARD_REFERENCE_TYPE_SHORT);
                ((AlarmManager) this.this$0.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, System.currentTimeMillis() + Heartbeat.ALARM_TIMEOUT, Heartbeat.ALARM_TIMEOUT, service);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1329831542, "Lcom/baidu/android/imsdk/internal/Heartbeat;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1329831542, "Lcom/baidu/android/imsdk/internal/Heartbeat;");
        }
    }

    public Heartbeat(Context context, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ALARM_TIMEOUT = 60000;
        this.mHandler = handler;
        this.mContext = context;
        this.mOperator = new BoxHeartbeat(this);
    }

    public static Heartbeat getInstance(Context context, Handler handler) {
        InterceptResult invokeLL;
        Heartbeat heartbeat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, handler)) == null) {
            synchronized (Heartbeat.class) {
                if (mInstance == null) {
                    mInstance = new Heartbeat(context, handler);
                }
                heartbeat = mInstance;
            }
            return heartbeat;
        }
        return (Heartbeat) invokeLL.objValue;
    }

    public void cancelHearbeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mOperator.cancelHearbeat();
        }
    }

    public void startHeartbeat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mOperator.startHeartbeat();
        }
    }
}
