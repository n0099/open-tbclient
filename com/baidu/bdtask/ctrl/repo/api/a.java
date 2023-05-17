package com.baidu.bdtask.ctrl.repo.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.tieba.uq;
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
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/bdtask/ctrl/repo/api/BDPTaskRepo;", "", "token", "taskId", "", TaskInfo.keyBehavior, "Lorg/json/JSONObject;", LaunchStatsUtils.EXTERNAL_LAUNCH, "Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "taskCompletedRequest", "(Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;)V", "Lcom/baidu/bdtask/ctrl/repo/TaskRepo;", "repo", "Lcom/baidu/bdtask/ctrl/repo/TaskRepo;", "<init>", "()V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final com.baidu.bdtask.ctrl.repo.a a;
    public static final a b;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"com/baidu/bdtask/ctrl/repo/api/BDPTaskRepo$taskCompletedRequest$2", "Lcom/baidu/tieba/vq;", "", "errmsg", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "onFail", "(Ljava/lang/String;I)V", "Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;", "parser", "onResponseParsed", "(Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;)V", "Lcom/baidu/bdtask/model/response/TaskResponseData;", "data", "onSucceed", "(Lcom/baidu/bdtask/model/response/TaskResponseData;)V", "<init>", "(Lcom/baidu/bdtask/ctrl/repo/api/TaskResponseCallback;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* renamed from: com.baidu.bdtask.ctrl.repo.api.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0076a implements vq {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uq a;

        @Override // com.baidu.tieba.vq
        public void b(wq wqVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wqVar) == null) {
            }
        }

        public C0076a(uq uqVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uqVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uqVar;
        }

        @Override // com.baidu.tieba.vq
        public void a(final TaskResponseData taskResponseData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, taskResponseData) == null) {
                this.a.a(taskResponseData);
                DebugTrace.a.c(new Function0<String>(taskResponseData) { // from class: com.baidu.bdtask.ctrl.repo.api.BDPTaskRepo$taskCompletedRequest$2$onSucceed$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ TaskResponseData $data;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {taskResponseData};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$data = taskResponseData;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "get succeed data:" + this.$data.toJson();
                        }
                        return (String) invokeV.objValue;
                    }
                });
            }
        }

        @Override // com.baidu.tieba.vq
        public void c(final String str, final int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                this.a.onError(i, str);
                DebugTrace.a.c(new Function0<String>(i, str) { // from class: com.baidu.bdtask.ctrl.repo.api.BDPTaskRepo$taskCompletedRequest$2$onFail$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ String $errmsg;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int $statusCode;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Integer.valueOf(i), str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$statusCode = i;
                        this.$errmsg = str;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "get fail:" + this.$statusCode + WebvttCueParser.CHAR_SPACE + this.$errmsg;
                        }
                        return (String) invokeV.objValue;
                    }
                });
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(796356898, "Lcom/baidu/bdtask/ctrl/repo/api/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(796356898, "Lcom/baidu/bdtask/ctrl/repo/api/a;");
                return;
            }
        }
        b = new a();
        a = new com.baidu.bdtask.ctrl.repo.a();
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

    @JvmOverloads
    public final void a(final String str, final String str2, final int i, JSONObject jSONObject, uq uqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), jSONObject, uqVar}) == null) {
            DebugTrace.a.c(new Function0<String>(str, str2, i) { // from class: com.baidu.bdtask.ctrl.repo.api.BDPTaskRepo$taskCompletedRequest$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ int $behavior;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $taskId;
                public final /* synthetic */ String $token;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, str2, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$token = str;
                    this.$taskId = str2;
                    this.$behavior = i;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "taskCompletedRequest:token:" + this.$token + " taskId:" + this.$taskId + " isBehavior:" + this.$behavior;
                    }
                    return (String) invokeV.objValue;
                }
            });
            a.c(str, str2, i, "", null, jSONObject, new C0076a(uqVar));
        }
    }
}
