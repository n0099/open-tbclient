package com.baidu.bdtask.ctrl.repo;

import android.text.TextUtils;
import c.a.j.f.g.c;
import c.a.j.h.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Ref;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0018:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJI\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/baidu/bdtask/ctrl/repo/TaskRepo;", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", TaskStatus.key, "Lcom/baidu/bdtask/ctrl/repo/TaskRepoCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "finishReq", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;Lcom/baidu/bdtask/ctrl/repo/TaskRepoCallback;)V", "", "token", RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID, "", "behavior", TaskInfo.keyFingerprint, "Lorg/json/JSONObject;", "ext", LaunchStatsUtils.EXTERNAL_LAUNCH, "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lcom/baidu/bdtask/ctrl/repo/TaskRepoCallback;)V", "getTaskCompleteUrl", "(Ljava/lang/String;I)Ljava/lang/String;", "<init>", "()V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"com/baidu/bdtask/ctrl/repo/TaskRepo$finishReq$5", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Ljava/lang/Exception;", "exception", "", "onFail", "(Ljava/lang/Exception;)V", "Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;", "response", "", EnterDxmPayServiceAction.SERVICE_STATUS_CODE, "onSuccess", "(Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;I)V", "Lokhttp3/Response;", "parseResponse", "(Lokhttp3/Response;I)Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;", "<init>", "(Lcom/baidu/bdtask/ctrl/repo/TaskRepoCallback;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class b extends ResponseCallback<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.j.f.g.b a;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
        /* renamed from: com.baidu.bdtask.ctrl.repo.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class RunnableC1770a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f31595e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Exception f31596f;

            public RunnableC1770a(b bVar, Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, exc};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31595e = bVar;
                this.f31596f = exc;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DebugTrace.a.c(new TaskRepo$finishReq$5$onFail$1$1(this));
                    c.a.j.f.g.b bVar = this.f31595e.a;
                    Exception exc = this.f31596f;
                    bVar.a((exc == null || (r1 = exc.getMessage()) == null) ? "task complete request failed" : "task complete request failed", 301);
                }
            }
        }

        /* renamed from: com.baidu.bdtask.ctrl.repo.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class RunnableC1771b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f31597e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f31598f;

            public RunnableC1771b(b bVar, c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31597e = bVar;
                this.f31598f = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f31598f;
                    if ((cVar != null ? cVar.d() : null) == null) {
                        this.f31597e.a.a("task complete request failed", 301);
                    } else if (!this.f31598f.a()) {
                        c.a.j.f.g.b bVar = this.f31597e.a;
                        bVar.a("serverErrorNo:" + this.f31598f.b() + " msg:" + this.f31598f.c(), 301);
                    } else {
                        this.f31597e.a.a(this.f31598f.d());
                    }
                }
            }
        }

        public b(c.a.j.f.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public c parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            ResponseBody body;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, response, i2)) == null) {
                String string = (response == null || (body = response.body()) == null) ? null : body.string();
                if (string == null || TextUtils.isEmpty(string)) {
                    return null;
                }
                c a = c.f3662d.a(string).a();
                this.a.b(a);
                return a;
            }
            return (c) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public void onSuccess(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, i2) == null) {
                e.c(new RunnableC1771b(this, cVar));
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                e.c(new RunnableC1770a(this, exc));
            }
        }
    }

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

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            c.a.j.h.b.d.b b2 = c.a.j.h.b.b.f3674c.h().b();
            return "" + b2.b() + "/bdtls/ug_task/api/task/external/" + str + "/complete?behavior=" + i2;
        }
        return (String) invokeLI.objValue;
    }

    public final void b(TaskInfo taskInfo, TaskStatus taskStatus, c.a.j.f.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo, taskStatus, bVar) == null) {
            TaskProcess process = taskStatus.getProcess();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tags", process.getSerializeTags());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c(taskInfo.getToken(), taskInfo.getId(), taskInfo.getBehavior(), taskInfo.getFingerprint(), jSONObject, null, bVar);
        }
    }

    /* JADX WARN: Type inference failed for: r6v13, types: [T, java.lang.String] */
    public final void c(String str, String str2, int i2, String str3, JSONObject jSONObject, JSONObject jSONObject2, c.a.j.f.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), str3, jSONObject, jSONObject2, bVar}) == null) {
            c.a.j.h.b.b$f.a aVar = new c.a.j.h.b.b$f.a();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("reqId", UUID.randomUUID().toString());
                jSONObject3.put("token", str);
                jSONObject3.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, 2);
                jSONObject3.put(CommandMessage.SDK_VERSION, c.a.j.h.b.b.f3674c.h().getSdkVersion());
                jSONObject3.put(TaskInfo.keyFingerprint, str3);
                if (jSONObject != null) {
                    jSONObject3.put("ext", jSONObject);
                }
                if (jSONObject2 != null) {
                    jSONObject3.put(LaunchStatsUtils.EXTERNAL_LAUNCH, jSONObject2);
                }
                Map<String, Object> a = c.a.j.h.b.b.f3674c.g().a();
                Map map = a != null ? MapsKt__MapsKt.toMap(a) : null;
                JSONObject jSONObject4 = new JSONObject();
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject4.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject3.put("antiInfo", jSONObject4);
                objectRef.element = jSONObject3.toString();
                DebugTrace.a.c(new TaskRepo$finishReq$4(objectRef));
                aVar.j(a(str2, i2), (String) objectRef.element, new b(bVar));
            } catch (Exception e2) {
                bVar.a("task request serialize failed  : " + e2.getMessage(), 202);
            }
        }
    }
}
