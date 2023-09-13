package com.baidu.tbadk.core.util;

import android.app.Activity;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/tbadk/core/util/RequestImagePermissionHelper;", "", "()V", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RequestImagePermissionHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final Companion Companion;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1845310478, "Lcom/baidu/tbadk/core/util/RequestImagePermissionHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1845310478, "Lcom/baidu/tbadk/core/util/RequestImagePermissionHelper;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final void doRequest(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, activity) == null) {
            Companion.doRequest(activity);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/tbadk/core/util/RequestImagePermissionHelper$Companion;", "", "()V", "doRequest", "", "activity", "Landroid/app/Activity;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
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

        @JvmStatic
        public final void doRequest(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                permissionJudgePolicy.clearRequestPermissionList();
                permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (permissionJudgePolicy.startRequestPermission(activity)) {
                    if (PreferenceUtils.getBoolean("imagepicker_tost_show", false) && !PermissionUtil.shouldShowRequestPermissionRationale(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        BdToast.makeText(activity, "请到设置-隐私-照片开启照片权限").show();
                    }
                    PreferenceUtils.setBoolean("imagepicker_tost_show", true);
                }
            }
        }
    }

    public RequestImagePermissionHelper() {
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
}
