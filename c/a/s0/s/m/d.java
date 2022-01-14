package c.a.s0.s.m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import c.a.s0.s.m.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
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
/* loaded from: classes6.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13239b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f13240c = 3;
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final int f13241d = 2;
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final int f13242e = 3;
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public static final int f13243f = 4;
    @JvmField

    /* renamed from: g  reason: collision with root package name */
    public static final int f13244g = 6;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void g(IntentConfig config) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, config) == null) {
                Intrinsics.checkNotNullParameter(config, "$config");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, config));
            }
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.f13239b : invokeV.intValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.f13240c : invokeV.intValue;
        }

        public final void c(int i2, Context mContext, String str, String str2, String str3, String str4, Integer num, boolean z, String str5, String str6, String str7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), mContext, str, str2, str3, str4, num, Boolean.valueOf(z), str5, str6, str7}) == null) {
                Intrinsics.checkNotNullParameter(mContext, "mContext");
                if (i2 == a()) {
                    WorkPublishActivityConfig workPublishActivityConfig = new WorkPublishActivityConfig(mContext, a());
                    if (!z && str3 != null && str4 != null) {
                        workPublishActivityConfig.setCanChangeBar(z);
                        workPublishActivityConfig.setBarId(str3);
                        workPublishActivityConfig.setBarName(str4);
                    }
                    workPublishActivityConfig.setTopic(str5);
                    workPublishActivityConfig.setTopicId(str6);
                    workPublishActivityConfig.setIsVideo(str7);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishActivityConfig));
                    return;
                }
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(mContext, "", true, true);
                albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
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
                albumFloatActivityConfig.setIsVideo(str7);
                if (f((Activity) mContext, albumFloatActivityConfig)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
            }
        }

        public final void d(WriteData writeData, Context mContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, writeData, mContext) == null) {
                Intrinsics.checkNotNullParameter(writeData, "writeData");
                Intrinsics.checkNotNullParameter(mContext, "mContext");
                WorkPublishActivityConfig workPublishActivityConfig = new WorkPublishActivityConfig(mContext, b());
                workPublishActivityConfig.setWriteData(writeData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishActivityConfig));
            }
        }

        public final boolean e(Intent intent, VideoInfo videoInfo, Activity mContext, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{intent, videoInfo, mContext, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
                Intrinsics.checkNotNullParameter(mContext, "mContext");
                WorkPublishActivityConfig workPublishActivityConfig = new WorkPublishActivityConfig(mContext);
                workPublishActivityConfig.setIntent(intent);
                workPublishActivityConfig.getIntent().setFlags(536870912);
                workPublishActivityConfig.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                workPublishActivityConfig.setVideoInfo(videoInfo);
                workPublishActivityConfig.setNeedClosePrePage(z);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishActivityConfig));
                if (z2) {
                    mContext.finish();
                    return true;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        public final boolean f(Activity activity, final IntentConfig intentConfig) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, activity, intentConfig)) == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                permissionJudgePolicy.clearRequestPermissionList();
                permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
                permissionJudgePolicy.setOnPermissionsGrantedListener(new PermissionJudgePolicy.OnPermissionsGrantedListener() { // from class: c.a.s0.s.m.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
                    public final void onPermissionsGranted() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            d.a.g(IntentConfig.this);
                        }
                    }
                });
                return permissionJudgePolicy.startRequestPermission(activity);
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1970975519, "Lc/a/s0/s/m/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1970975519, "Lc/a/s0/s/m/d;");
                return;
            }
        }
        a = new a(null);
    }
}
