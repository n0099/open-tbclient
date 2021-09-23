package c.a.p.b;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.perfframe.PerfFrame;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.track.ui.TraceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final long f4375g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MethodChannel f4376e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f4377f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185582612, "Lc/a/p/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1185582612, "Lc/a/p/b/a;");
                return;
            }
        }
        f4375g = System.currentTimeMillis();
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

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activityPluginBinding) == null) {
            this.f4377f = activityPluginBinding.getActivity();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterPluginBinding) == null) {
            MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "flutter_exception_perf_plugin");
            this.f4376e = methodChannel;
            methodChannel.setMethodCallHandler(this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f4377f = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f4377f = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, flutterPluginBinding) == null) {
            this.f4376e.setMethodCallHandler(null);
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, methodCall, result) == null) {
            if (methodCall.method.equals("reportException")) {
                String str = (String) methodCall.argument("page");
                String str2 = (String) methodCall.argument("message");
                long longValue = ((Long) methodCall.argument("excTime")).longValue();
                String str3 = (String) methodCall.argument(Constant.KEY_BUSINESS);
                PerfFrame create = new PerfFrame.Builder().setNeedStaticperf(true).setNeedPageTrace(true).setNeedMainStackTrace(true).setNeedDynamicperf(true).create();
                if (create != null) {
                    create.submitPerformanceData("2301", "flutter", longValue, f4375g, str2, str, str3);
                    result.success(Boolean.TRUE);
                    return;
                }
                result.success(Boolean.FALSE);
            } else if (methodCall.method.equals("reportPageTrace")) {
                String str4 = (String) methodCall.argument("page");
                String str5 = (String) methodCall.argument("event");
                ((Long) methodCall.argument(PmsConstant.Statistic.Key.REV_TIMESTAMP)).longValue();
                TraceManager.getInstance().saveTraceInfo(this.f4377f, null, str4, (String) methodCall.argument("tag"), "flutter", str5);
                result.success(Boolean.TRUE);
            } else {
                result.notImplemented();
            }
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activityPluginBinding) == null) {
            this.f4377f = activityPluginBinding.getActivity();
        }
    }
}
