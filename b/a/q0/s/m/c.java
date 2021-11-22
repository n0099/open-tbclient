package b.a.q0.s.m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f13935a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13936b = 3;
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final int f13937c = 2;
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final int f13938d = 3;
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final int f13939e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final a f13940f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b.a.q0.s.m.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0722a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ IntentConfig f13941a;

            public C0722a(IntentConfig intentConfig) {
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
                this.f13941a = intentConfig;
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public final void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.f13941a));
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.f13935a : invokeV.intValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.f13936b : invokeV.intValue;
        }

        public final void c(int i2, Context context, String str, String str2, String str3, String str4, Integer num, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), context, str, str2, str3, str4, num, Boolean.valueOf(z)}) == null) {
                if (i2 == a()) {
                    WorkPublishActivityConfig workPublishActivityConfig = new WorkPublishActivityConfig(context, a());
                    if (!z && str3 != null && str4 != null) {
                        workPublishActivityConfig.setCanChangeBar(z);
                        workPublishActivityConfig.setBarId(str3);
                        workPublishActivityConfig.setBarName(str4);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishActivityConfig));
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
                albumFloatActivityConfig.setBarID(str3);
                albumFloatActivityConfig.setBarName(str4);
                albumFloatActivityConfig.setCanChangeBarName(z);
                albumFloatActivityConfig.setVideoAbstract(str2);
                albumFloatActivityConfig.setVideoTitle(str);
                if (g((Activity) context, albumFloatActivityConfig)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
            }
        }

        public final void d(int i2, Context context, String str, String str2, String str3, String str4, Integer num, boolean z, String str5, String str6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), context, str, str2, str3, str4, num, Boolean.valueOf(z), str5, str6}) == null) {
                if (i2 == a()) {
                    WorkPublishActivityConfig workPublishActivityConfig = new WorkPublishActivityConfig(context, a());
                    if (!z && str3 != null && str4 != null) {
                        workPublishActivityConfig.setCanChangeBar(z);
                        workPublishActivityConfig.setBarId(str3);
                        workPublishActivityConfig.setBarName(str4);
                    }
                    workPublishActivityConfig.setTopic(str5);
                    workPublishActivityConfig.setTopicId(str6);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishActivityConfig));
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
                albumFloatActivityConfig.setBarID(str3);
                albumFloatActivityConfig.setBarName(str4);
                albumFloatActivityConfig.setCanChangeBarName(z);
                albumFloatActivityConfig.setVideoAbstract(str2);
                albumFloatActivityConfig.setVideoTitle(str);
                albumFloatActivityConfig.setTopic(str5);
                albumFloatActivityConfig.setTopicId(str6);
                if (g((Activity) context, albumFloatActivityConfig)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
            }
        }

        public final void e(WriteData writeData, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, writeData, context) == null) {
                WorkPublishActivityConfig workPublishActivityConfig = new WorkPublishActivityConfig(context, b());
                workPublishActivityConfig.setWriteData(writeData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishActivityConfig));
            }
        }

        public final boolean f(Intent intent, VideoInfo videoInfo, Activity activity, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{intent, videoInfo, activity, Boolean.valueOf(z)})) == null) {
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
            return invokeCommon.booleanValue;
        }

        public final boolean g(Activity activity, IntentConfig intentConfig) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, activity, intentConfig)) == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                permissionJudgePolicy.clearRequestPermissionList();
                permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
                permissionJudgePolicy.setOnPermissionsGrantedListener(new C0722a(intentConfig));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1937336383, "Lb/a/q0/s/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1937336383, "Lb/a/q0/s/m/c;");
                return;
            }
        }
        f13940f = new a(null);
    }
}
