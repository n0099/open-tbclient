package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ApplyJoinGroupActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALREADY_JOIN_COUNT = "alreadJoinCount";
    public static final String CAN_JOIN_COUNT = "canJoinCount";
    public static final String DEFAULT_USER_MSG = "defaultUserMsg";
    public static final String GROUP_ID = "groupID";
    public static final String INVITE_USER_ID = "inviteUserId";
    public static int JOINTYPE_DEFAULT = 0;
    public static int JOINTYPE_INVITE = 1;
    public static final String JOIN_TYPE = "joinType";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1834423812, "Lcom/baidu/tbadk/core/atomData/ApplyJoinGroupActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1834423812, "Lcom/baidu/tbadk/core/atomData/ApplyJoinGroupActivityConfig;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyJoinGroupActivityConfig(Context context, String str, int i2, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        getIntent().putExtra(GROUP_ID, str);
        getIntent().putExtra(ALREADY_JOIN_COUNT, i2);
        getIntent().putExtra(CAN_JOIN_COUNT, i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyJoinGroupActivityConfig(Context context, String str, int i2, int i3, long j, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        getIntent().putExtra(GROUP_ID, str);
        getIntent().putExtra(ALREADY_JOIN_COUNT, i2);
        getIntent().putExtra(CAN_JOIN_COUNT, i3);
        getIntent().putExtra(INVITE_USER_ID, j);
        getIntent().putExtra(DEFAULT_USER_MSG, str2);
        getIntent().putExtra(JOIN_TYPE, JOINTYPE_INVITE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyJoinGroupActivityConfig(Context context, String str, long j, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j), str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        getIntent().putExtra(GROUP_ID, str);
        getIntent().putExtra(INVITE_USER_ID, j);
        getIntent().putExtra(DEFAULT_USER_MSG, str2);
        getIntent().putExtra(JOIN_TYPE, JOINTYPE_INVITE);
    }
}
