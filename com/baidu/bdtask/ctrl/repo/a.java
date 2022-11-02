package com.baidu.bdtask.ctrl.repo;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.tieba.bs;
import com.baidu.tieba.is;
import com.baidu.tieba.jr;
import com.baidu.tieba.kt;
import com.baidu.tieba.vq;
import com.baidu.tieba.wq;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Ref;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0018:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJI\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/baidu/bdtask/ctrl/repo/TaskRepo;", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", TaskStatus.key, "Lcom/baidu/bdtask/ctrl/repo/TaskRepoCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "finishReq", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;Lcom/baidu/bdtask/ctrl/repo/TaskRepoCallback;)V", "", "token", "taskId", "", TaskInfo.keyBehavior, TaskInfo.keyFingerprint, "Lorg/json/JSONObject;", "ext", LaunchStatsUtils.EXTERNAL_LAUNCH, "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lcom/baidu/bdtask/ctrl/repo/TaskRepoCallback;)V", "getTaskCompleteUrl", "(Ljava/lang/String;I)Ljava/lang/String;", "<init>", "()V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-474076531, "Lcom/baidu/bdtask/ctrl/repo/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-474076531, "Lcom/baidu/bdtask/ctrl/repo/a;");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"com/baidu/bdtask/ctrl/repo/TaskRepo$finishReq$5", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Ljava/lang/Exception;", "exception", "", "onFail", "(Ljava/lang/Exception;)V", "Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;", "response", "", "statusCode", "onSuccess", "(Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;I)V", "Lokhttp3/Response;", "parseResponse", "(Lokhttp3/Response;I)Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;", "<init>", "(Lcom/baidu/bdtask/ctrl/repo/TaskRepoCallback;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes.dex */
    public static final class b extends ResponseCallback<wq> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq a;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
        /* renamed from: com.baidu.bdtask.ctrl.repo.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class RunnableC0073a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;
            public final /* synthetic */ Exception b;

            public RunnableC0073a(b bVar, Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, exc};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
                this.b = exc;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DebugTrace.a.c(new TaskRepo$finishReq$5$onFail$1$1(this));
                    vq vqVar = this.a.a;
                    Exception exc = this.b;
                    vqVar.c((exc == null || (r1 = exc.getMessage()) == null) ? "task complete request failed" : "task complete request failed", 301);
                }
            }
        }

        /* renamed from: com.baidu.bdtask.ctrl.repo.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class RunnableC0074b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;
            public final /* synthetic */ wq b;

            public RunnableC0074b(b bVar, wq wqVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, wqVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
                this.b = wqVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TaskResponseData taskResponseData;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    wq wqVar = this.b;
                    if (wqVar != null) {
                        taskResponseData = wqVar.d();
                    } else {
                        taskResponseData = null;
                    }
                    if (taskResponseData == null) {
                        this.a.a.c("task complete request failed", 301);
                    } else if (!this.b.a()) {
                        vq vqVar = this.a.a;
                        vqVar.c("serverErrorNo:" + this.b.b() + " msg:" + this.b.c(), 301);
                    } else {
                        this.a.a.a(this.b.d());
                    }
                }
            }
        }

        public b(vq vqVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vqVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vqVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                kt.c(new RunnableC0073a(this, exc));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public wq parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            String str;
            ResponseBody body;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, response, i)) == null) {
                if (response != null && (body = response.body()) != null) {
                    str = body.string();
                } else {
                    str = null;
                }
                if (str == null || TextUtils.isEmpty(str)) {
                    return null;
                }
                wq a = wq.d.a(str).a();
                this.a.b(a);
                return a;
            }
            return (wq) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public void onSuccess(wq wqVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wqVar, i) == null) {
                kt.c(new RunnableC0074b(this, wqVar));
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            is env = jr.c.h().getEnv();
            return "" + env.b() + "/bdtls/ug_task/api/task/external/" + str + "/complete?behavior=" + i;
        }
        return (String) invokeLI.objValue;
    }

    public final void b(TaskInfo taskInfo, TaskStatus taskStatus, vq vqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo, taskStatus, vqVar) == null) {
            TaskProcess process = taskStatus.getProcess();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tags", process.getSerializeTags());
            } catch (Exception e) {
                e.printStackTrace();
            }
            c(taskInfo.getToken(), taskInfo.getId(), taskInfo.getBehavior(), taskInfo.getFingerprint(), jSONObject, null, vqVar);
        }
    }

    /* JADX WARN: Type inference failed for: r6v13, types: [T, java.lang.String] */
    public final void c(String str, String str2, int i, String str3, JSONObject jSONObject, JSONObject jSONObject2, vq vqVar) {
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), str3, jSONObject, jSONObject2, vqVar}) == null) {
            bs bsVar = new bs();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("reqId", UUID.randomUUID().toString());
                jSONObject3.put("token", str);
                jSONObject3.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 2);
                jSONObject3.put(CommandMessage.SDK_VERSION, jr.c.h().getSdkVersion());
                jSONObject3.put(TaskInfo.keyFingerprint, str3);
                if (jSONObject != null) {
                    jSONObject3.put("ext", jSONObject);
                }
                if (jSONObject2 != null) {
                    jSONObject3.put(LaunchStatsUtils.EXTERNAL_LAUNCH, jSONObject2);
                }
                Map<String, Object> a = jr.c.g().a();
                if (a != null) {
                    map = MapsKt__MapsKt.toMap(a);
                } else {
                    map = null;
                }
                JSONObject jSONObject4 = new JSONObject();
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject4.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject3.put("antiInfo", jSONObject4);
                objectRef.element = jSONObject3.toString();
                DebugTrace.a.c(new TaskRepo$finishReq$4(objectRef));
                bsVar.j(a(str2, i), (String) objectRef.element, new b(vqVar));
            } catch (Exception e) {
                vqVar.c("task request serialize failed  : " + e.getMessage(), 202);
            }
        }
    }
}
