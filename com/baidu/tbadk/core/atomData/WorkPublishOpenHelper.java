package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
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
import com.baidubce.auth.NTLMEngineImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/tbadk/core/atomData/WorkPublishOpenHelper;", "", "()V", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WorkPublishOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    @JvmField
    public static final int OPEN_WORK_PUBLISH_FROM_FRS_VIDEO = 4;
    @JvmField
    public static final int OPEN_WORK_PUBLISH_FROM_FRS_WRITE = 3;
    @JvmField
    public static final int OPEN_WORK_PUBLISH_FROM_HOME_VIDEO = 2;
    @JvmField
    public static final int OPEN_WORK_PUBLISH_FROM_HOME_WRITE = 1;
    @JvmField
    public static final int OPEN_WORK_PUBLISH_FROM_HOTLIST = 5;
    @JvmField
    public static final int OPEN_WORK_PUBLISH_FROM_PERSON = 6;
    public static final int draftTypeNodraft = 0;
    public static final int draftTypeNodraftCleandraft = 1;
    public static final int draftTypeUsedraft = 2;
    public static final int draftTypeWriteData = 3;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1484275116, "Lcom/baidu/tbadk/core/atomData/WorkPublishOpenHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1484275116, "Lcom/baidu/tbadk/core/atomData/WorkPublishOpenHelper;");
                return;
            }
        }
        Companion = new a(null);
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return WorkPublishOpenHelper.draftTypeUsedraft;
            }
            return invokeV.intValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return WorkPublishOpenHelper.draftTypeWriteData;
            }
            return invokeV.intValue;
        }

        public static final void g(IntentConfig config) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, config) == null) {
                Intrinsics.checkNotNullParameter(config, "$config");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, config));
            }
        }

        public final void c(int i, Context mContext, String str, String str2, String str3, String str4, Integer num, boolean z, String str5, String str6, String str7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), mContext, str, str2, str3, str4, num, Boolean.valueOf(z), str5, str6, str7}) == null) {
                Intrinsics.checkNotNullParameter(mContext, "mContext");
                if (i == a()) {
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
                albumFloatActivityConfig.setRedirectToWorkPublishPage(i);
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
                workPublishActivityConfig.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                workPublishActivityConfig.getIntent().setFlags(67108864);
                workPublishActivityConfig.setVideoInfo(videoInfo);
                workPublishActivityConfig.setNeedClosePrePage(z);
                String forumId = intent.getStringExtra("forum_id");
                if (StringUtils.isNotNull(forumId)) {
                    Intrinsics.checkNotNullExpressionValue(forumId, "forumId");
                    workPublishActivityConfig.setBarId(forumId);
                }
                String forumName = intent.getStringExtra("forum_name");
                if (!TextUtils.isEmpty(forumName)) {
                    Intrinsics.checkNotNullExpressionValue(forumName, "forumName");
                    workPublishActivityConfig.setBarName(forumName);
                }
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
                permissionJudgePolicy.setOnPermissionsGrantedListener(new PermissionJudgePolicy.OnPermissionsGrantedListener() { // from class: com.baidu.tieba.c15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
                    public final void onPermissionsGranted() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WorkPublishOpenHelper.a.g(IntentConfig.this);
                        }
                    }
                });
                return permissionJudgePolicy.startRequestPermission(activity);
            }
            return invokeLL.booleanValue;
        }
    }

    public WorkPublishOpenHelper() {
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
