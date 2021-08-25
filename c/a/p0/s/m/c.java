package c.a.p0.s.m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f14069a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final int f14070b = 3;

    /* renamed from: c  reason: collision with root package name */
    public static final a f14071c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.a.p0.s.m.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0692a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ IntentConfig f14072a;

            public C0692a(IntentConfig intentConfig) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {intentConfig};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14072a = intentConfig;
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public final void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.f14072a));
                }
            }
        }

        public a() {
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

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.f14069a : invokeV.intValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.f14070b : invokeV.intValue;
        }

        public final void c(int i2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, context) == null) {
                if (i2 == a()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WorkPublishActivityConfig(context, a())));
                    return;
                }
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(context, "", true, true);
                albumFloatActivityConfig.setRequestCode(12002);
                albumFloatActivityConfig.setAlbumThread(0);
                albumFloatActivityConfig.setCanSelectVideo(true);
                albumFloatActivityConfig.setCanSelectOnlyVideo(true);
                albumFloatActivityConfig.setCanEditImage(false);
                albumFloatActivityConfig.setFromWrite(4);
                albumFloatActivityConfig.setCallFrom("2");
                albumFloatActivityConfig.setRedirectToWorkPublishPage(i2);
                if (f((Activity) context, albumFloatActivityConfig)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
            }
        }

        public final void d(WriteData writeData, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, writeData, context) == null) {
                WorkPublishActivityConfig workPublishActivityConfig = new WorkPublishActivityConfig(context, b());
                workPublishActivityConfig.setWriteData(writeData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishActivityConfig));
            }
        }

        public final boolean e(Intent intent, VideoInfo videoInfo, Activity activity, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{intent, videoInfo, activity, Boolean.valueOf(z)})) == null) {
                if (intent.getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false)) {
                    WorkPublishActivityConfig workPublishActivityConfig = new WorkPublishActivityConfig(activity);
                    workPublishActivityConfig.setIntent(intent);
                    Intent intent2 = workPublishActivityConfig.getIntent();
                    Intrinsics.checkExpressionValueIsNotNull(intent2, "config.intent");
                    intent2.setFlags(536870912);
                    Intent intent3 = workPublishActivityConfig.getIntent();
                    Intrinsics.checkExpressionValueIsNotNull(intent3, "config.intent");
                    intent3.setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    workPublishActivityConfig.setVideoInfo(videoInfo);
                    workPublishActivityConfig.setNeedClosePrePage(z);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishActivityConfig));
                    activity.finish();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public final boolean f(Activity activity, IntentConfig intentConfig) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, activity, intentConfig)) == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                permissionJudgePolicy.clearRequestPermissionList();
                permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
                permissionJudgePolicy.setOnPermissionsGrantedListener(new C0692a(intentConfig));
                return permissionJudgePolicy.startRequestPermission(activity);
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-843579457, "Lc/a/p0/s/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-843579457, "Lc/a/p0/s/m/c;");
                return;
            }
        }
        f14071c = new a(null);
    }
}
