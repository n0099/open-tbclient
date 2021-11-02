package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Ack;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Crash;
import com.baidu.android.imsdk.upload.action.track.Db;
import com.baidu.android.imsdk.upload.action.track.Msg;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.android.imsdk.upload.action.track.Ui;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class IMTrack {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.imsdk.upload.action.IMTrack$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1466091016, "Lcom/baidu/android/imsdk/upload/action/IMTrack$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1466091016, "Lcom/baidu/android/imsdk/upload/action/IMTrack$2;");
                    return;
                }
            }
            int[] iArr = new int[IMPushPb.ActionType.values().length];
            $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType = iArr;
            try {
                iArr[IMPushPb.ActionType.UI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.CRASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.DB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.CONNECTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.ACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[IMPushPb.ActionType.MSG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class AckBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String PROXY_TYPE = "proxy";
        public static final String PUSH_TYPE = "push";
        public transient /* synthetic */ FieldHolder $fh;
        public Ack ack;
        public Context context;

        public AckBuilder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Ack ack = new Ack();
            this.ack = ack;
            this.context = context;
            ack.type = "";
            ack.value = "";
            ack.timestamp = -1L;
            ack.ext = "";
            ack.aliasId = -1L;
        }

        public AckBuilder aliasId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.ack.aliasId = j;
                return this;
            }
            return (AckBuilder) invokeJ.objValue;
        }

        public void build() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                IMTrack.reportTracker(this.context, IMPushPb.ActionType.ACK, this.ack);
            }
        }

        public AckBuilder ext(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.ack.ext = str;
                return this;
            }
            return (AckBuilder) invokeL.objValue;
        }

        public AckBuilder timestamp(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.ack.timestamp = j;
                return this;
            }
            return (AckBuilder) invokeJ.objValue;
        }

        public AckBuilder type(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.ack.type = str;
                return this;
            }
            return (AckBuilder) invokeL.objValue;
        }

        public AckBuilder value(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.ack.value = str;
                return this;
            }
            return (AckBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class ConnectionBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CONN_TYPE_SOCKET_CONNECTION_ENV_FAIL = 401203;
        public static final int CONN_TYPE_SOCKET_CONNECTION_EXCEPTION = 401205;
        public static final int CONN_TYPE_SOCKET_CONNECTION_OK = 401201;
        public static final int CONN_TYPE_SOCKET_CONNECTION_STOP = 401202;
        public static final int CONN_TYPE_SOCKET_CONNECTION_TIMEOUT = 401204;
        public static final int CONN_TYPE_SOCKET_RETRY_5_FAIL = 401206;
        public transient /* synthetic */ FieldHolder $fh;
        public Connection connection;
        public Context context;

        public ConnectionBuilder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Connection connection = new Connection();
            this.connection = connection;
            this.context = context;
            connection.startTime = -1L;
            connection.stopTime = -1L;
            connection.reason = "";
            connection.retryTime = -1L;
            connection.retryCount = -1L;
            connection.ext = "";
            connection.aliasId = -1L;
        }

        public ConnectionBuilder aliasId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.connection.aliasId = j;
                return this;
            }
            return (ConnectionBuilder) invokeJ.objValue;
        }

        public void build() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                IMTrack.reportTracker(this.context, IMPushPb.ActionType.CONNECTION, this.connection);
            }
        }

        public ConnectionBuilder ext(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.connection.ext = str;
                return this;
            }
            return (ConnectionBuilder) invokeL.objValue;
        }

        public ConnectionBuilder reason(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.connection.reason = str;
                return this;
            }
            return (ConnectionBuilder) invokeL.objValue;
        }

        public ConnectionBuilder retryCount(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.connection.retryCount = j;
                return this;
            }
            return (ConnectionBuilder) invokeJ.objValue;
        }

        public ConnectionBuilder retryTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.connection.retryTime = j;
                return this;
            }
            return (ConnectionBuilder) invokeJ.objValue;
        }

        public ConnectionBuilder startTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.connection.startTime = j;
                return this;
            }
            return (ConnectionBuilder) invokeJ.objValue;
        }

        public ConnectionBuilder stopTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.connection.stopTime = j;
                return this;
            }
            return (ConnectionBuilder) invokeJ.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class CrashBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CRASH_TYPE_CATCH = 201001;
        public static final int CRASH_TYPE_DEFAULT = 201002;
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;
        public Crash crash;

        public CrashBuilder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Crash crash = new Crash();
            this.crash = crash;
            this.context = context;
            crash.exception = "";
            crash.timestamp = System.currentTimeMillis();
            Crash crash2 = this.crash;
            crash2.ext = "";
            crash2.aliasId = 201001L;
        }

        public CrashBuilder aliasId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.crash.aliasId = j;
                return this;
            }
            return (CrashBuilder) invokeJ.objValue;
        }

        public void build() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.crash.exception)) {
                return;
            }
            IMTrack.reportTracker(this.context, IMPushPb.ActionType.CRASH, this.crash);
        }

        public CrashBuilder exception(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.crash.exception = str;
                return this;
            }
            return (CrashBuilder) invokeL.objValue;
        }

        public CrashBuilder ext(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.crash.ext = str;
                return this;
            }
            return (CrashBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class DbBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ACTION_ADD = "add";
        public static final String ACTION_DELETE = "delete";
        public static final String ACTION_MIGRATE = "migrate";
        public static final String ACTION_QUERY = "query";
        public static final String ACTION_UPDATE = "update";
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;
        public Db db;

        public DbBuilder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Db db = new Db();
            this.db = db;
            this.context = context;
            db.table = "";
            db.className = "";
            db.method = "";
            db.action = "";
            db.startTime = -1L;
            db.endTime = -1L;
            db.duration = -1L;
            db.ext = "";
            db.aliasId = -1L;
        }

        public DbBuilder action(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.db.action = str;
                return this;
            }
            return (DbBuilder) invokeL.objValue;
        }

        public DbBuilder aliasId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.db.aliasId = j;
                return this;
            }
            return (DbBuilder) invokeJ.objValue;
        }

        public void build() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                IMTrack.reportTracker(this.context, IMPushPb.ActionType.DB, this.db);
            }
        }

        public DbBuilder className(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.db.className = str;
                return this;
            }
            return (DbBuilder) invokeL.objValue;
        }

        public DbBuilder duration(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.db.duration = j;
                return this;
            }
            return (DbBuilder) invokeJ.objValue;
        }

        public DbBuilder endTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.db.endTime = j;
                return this;
            }
            return (DbBuilder) invokeJ.objValue;
        }

        public DbBuilder ext(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.db.ext = str;
                return this;
            }
            return (DbBuilder) invokeL.objValue;
        }

        public DbBuilder method(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.db.method = str;
                return this;
            }
            return (DbBuilder) invokeL.objValue;
        }

        public DbBuilder startTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                this.db.startTime = j;
                return this;
            }
            return (DbBuilder) invokeJ.objValue;
        }

        public DbBuilder table(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.db.table = str;
                return this;
            }
            return (DbBuilder) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class MsgBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;
        public Msg msg;

        public MsgBuilder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Msg msg = new Msg();
            this.msg = msg;
            this.context = context;
            msg.msgCount = -1L;
            msg.roomId = "";
            msg.duration = -1L;
            msg.startMsgId = -1L;
            msg.endMsgId = -1L;
            msg.ext = "";
            msg.aliasId = -1L;
        }

        public MsgBuilder aliasId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.msg.aliasId = j;
                return this;
            }
            return (MsgBuilder) invokeJ.objValue;
        }

        public void build() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                IMTrack.reportTracker(this.context, IMPushPb.ActionType.MSG, this.msg);
            }
        }

        public MsgBuilder duration(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                this.msg.duration = j;
                return this;
            }
            return (MsgBuilder) invokeJ.objValue;
        }

        public MsgBuilder endMsgId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.msg.endMsgId = j;
                return this;
            }
            return (MsgBuilder) invokeJ.objValue;
        }

        public MsgBuilder ext(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.msg.ext = str;
                return this;
            }
            return (MsgBuilder) invokeL.objValue;
        }

        public MsgBuilder msgCount(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.msg.msgCount = j;
                return this;
            }
            return (MsgBuilder) invokeJ.objValue;
        }

        public MsgBuilder roomId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.msg.roomId = str;
                return this;
            }
            return (MsgBuilder) invokeL.objValue;
        }

        public MsgBuilder startMsgId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.msg.startMsgId = j;
                return this;
            }
            return (MsgBuilder) invokeJ.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class RequestBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int REQUEST_INIT = 501100;
        public static final int REQUEST_JOIN = 501112;
        public static final int REQUEST_JOIN_CALLBACK = 501113;
        public static final int REQUEST_LOGIN = 501101;
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;
        public Request request;

        public RequestBuilder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Request request = new Request();
            this.request = request;
            this.context = context;
            request.method = "";
            request.requestId = "";
            request.timestamp = -1L;
            request.responseTime = -1L;
            request.errorCode = -1L;
            request.ext = "";
            request.aliasId = -1L;
        }

        public RequestBuilder aliasId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.request.aliasId = j;
                return this;
            }
            return (RequestBuilder) invokeJ.objValue;
        }

        public void build() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                IMTrack.reportTracker(this.context, IMPushPb.ActionType.REQUEST, this.request);
            }
        }

        public RequestBuilder errorCode(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                this.request.errorCode = j;
                return this;
            }
            return (RequestBuilder) invokeJ.objValue;
        }

        public RequestBuilder ext(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.request.ext = str;
                return this;
            }
            return (RequestBuilder) invokeL.objValue;
        }

        public RequestBuilder method(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.request.method = str;
                return this;
            }
            return (RequestBuilder) invokeL.objValue;
        }

        public RequestBuilder requestId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.request.requestId = str;
                return this;
            }
            return (RequestBuilder) invokeL.objValue;
        }

        public RequestBuilder requestTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.request.timestamp = j;
                return this;
            }
            return (RequestBuilder) invokeJ.objValue;
        }

        public RequestBuilder responseTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.request.responseTime = j;
                return this;
            }
            return (RequestBuilder) invokeJ.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class UiBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String CATEGORY_CLICK = "category_click";
        public static final String CATEGORY_MI = "category_mi";
        public static final String CATEGORY_SHOW = "category_show";
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;
        public Ui ui;

        public UiBuilder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Ui ui = new Ui();
            this.ui = ui;
            this.context = context;
            ui.category = "";
            ui.page = "";
            ui.startTime = -1L;
            ui.endTime = -1L;
            ui.duration = -1L;
            ui.ext = "";
            ui.aliasId = -1L;
        }

        public UiBuilder aliasId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                this.ui.aliasId = j;
                return this;
            }
            return (UiBuilder) invokeJ.objValue;
        }

        public void build() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                IMTrack.reportTracker(this.context, IMPushPb.ActionType.UI, this.ui);
            }
        }

        public UiBuilder category(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.ui.category = str;
                return this;
            }
            return (UiBuilder) invokeL.objValue;
        }

        public UiBuilder duration(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                this.ui.duration = j;
                return this;
            }
            return (UiBuilder) invokeJ.objValue;
        }

        public UiBuilder endTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.ui.endTime = j;
                return this;
            }
            return (UiBuilder) invokeJ.objValue;
        }

        public UiBuilder ext(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.ui.ext = str;
                return this;
            }
            return (UiBuilder) invokeL.objValue;
        }

        public UiBuilder page(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.ui.page = str;
                return this;
            }
            return (UiBuilder) invokeL.objValue;
        }

        public UiBuilder startTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.ui.startTime = j;
                return this;
            }
            return (UiBuilder) invokeJ.objValue;
        }
    }

    public IMTrack() {
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

    public static void reportTracker(Context context, IMPushPb.ActionType actionType, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, actionType, obj) == null) {
            Context applicationContext = context.getApplicationContext();
            if (Utility.isUploadIMTrack(applicationContext)) {
                TaskManager.getInstance(applicationContext).submitForNetWork(new Runnable(actionType, applicationContext, obj) { // from class: com.baidu.android.imsdk.upload.action.IMTrack.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IMPushPb.ActionType val$actionType;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ Object val$tracker;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {actionType, applicationContext, obj};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$actionType = actionType;
                        this.val$context = applicationContext;
                        this.val$tracker = obj;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (IMTrackDatabase.myLock) {
                                switch (AnonymousClass2.$SwitchMap$com$baidu$android$imsdk$upload$action$pb$IMPushPb$ActionType[this.val$actionType.ordinal()]) {
                                    case 1:
                                        IMTrackDatabase.getInstance(this.val$context).insertUi((Ui) this.val$tracker);
                                        break;
                                    case 2:
                                        IMTrackDatabase.getInstance(this.val$context).insertCrash((Crash) this.val$tracker);
                                        break;
                                    case 3:
                                        IMTrackDatabase.getInstance(this.val$context).insertDb((Db) this.val$tracker);
                                        break;
                                    case 4:
                                        IMTrackDatabase.getInstance(this.val$context).insertConnection((Connection) this.val$tracker);
                                        break;
                                    case 5:
                                        IMTrackDatabase.getInstance(this.val$context).insertRequest((Request) this.val$tracker);
                                        break;
                                    case 6:
                                        IMTrackDatabase.getInstance(this.val$context).insertAck((Ack) this.val$tracker);
                                        break;
                                    case 7:
                                        IMTrackDatabase.getInstance(this.val$context).insertMsg((Msg) this.val$tracker);
                                        break;
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
