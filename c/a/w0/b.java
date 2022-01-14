package c.a.w0;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class b implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MethodChannel f26541e;

    /* renamed from: f  reason: collision with root package name */
    public Context f26542f;

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

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterPluginBinding) == null) {
            MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "ubcflutter");
            this.f26541e = methodChannel;
            methodChannel.setMethodCallHandler(this);
            this.f26542f = flutterPluginBinding.getApplicationContext();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterPluginBinding) == null) {
            this.f26541e.setMethodCallHandler(null);
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, methodCall, result) == null) {
            if (methodCall.method.equals("getPlatformVersion")) {
                result.success("Android " + Build.VERSION.RELEASE);
            } else if (methodCall.method.equals("registerConfig")) {
                a.l((HashMap) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("registerDefaultConfig")) {
                a.m((HashMap) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("onEvent")) {
                a.k(result, (HashMap) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("beginFlow")) {
                a.a((String) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("endFlow")) {
                a.c((String) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("flowCancel")) {
                a.b((String) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("flowSetValue")) {
                a.g((HashMap) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("flowSetValueWithDuration")) {
                a.h((HashMap) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("flowAddEventWithMap")) {
                a.d((HashMap) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("flowAddEventWithDate")) {
                a.e((HashMap) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("flowStartSlot")) {
                a.i((HashMap) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("flowEndSlot")) {
                a.f((HashMap) methodCall.arguments);
                result.success("");
            } else if (methodCall.method.equals("uploadFailedData")) {
                a.n();
                result.success("");
            } else {
                result.notImplemented();
            }
        }
    }
}
