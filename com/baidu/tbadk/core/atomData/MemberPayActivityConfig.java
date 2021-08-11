package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class MemberPayActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM = "from";
    public static final int FROM_AVATAR_PENDANT_LIST = 22;
    public static final int FROM_BACKGROUND_DETAIL_DIALOG = 14;
    public static final int FROM_BACKGROUND_ITEM_DIALOG = 13;
    public static final int FROM_BACKGROUND_LIST_PAGE = 12;
    public static final int FROM_BUBBLE = 7;
    public static final int FROM_BUBBLE_ITEM_CLICK = 18;
    public static final int FROM_BUBBLE_RECOMMEND_CLCK = 19;
    public static final int FROM_CLOSE_AD = 20;
    public static final int FROM_DRESSUP_CENTER = 8;
    public static final int FROM_DUIBA_H5_PAGE = 25;
    public static final int FROM_EXP_SPEED = 2;
    public static final int FROM_MARGA_VIP = 23;
    public static final int FROM_MEMBERCENTER_BOTTOM = 16;
    public static final int FROM_MEMBERCENTER_JOIN = 21;
    public static final int FROM_MEMBERCENTER_SPREAD = 15;
    public static final int FROM_MEMBER_CENTER = 3;
    public static final int FROM_MORE_LINK = 26;
    public static final int FROM_MY_INFORMATION = 24;
    public static final int FROM_PB_MUTE = 4;
    public static final int FROM_PERSON_INFO_MUTE = 5;
    public static final String FROM_SCENE = "from_scene";
    public static final int FROM_SEND_VIP_GIFT = 17;
    public static final int FROM_SIGNALL = 1;
    public static final int FROM_SKIN_DETAIL_DIALOG = 11;
    public static final int FROM_SKIN_ITEM_DIALOG = 10;
    public static final int FROM_TAIL = 6;
    public static final int FROM_THEME_LIST_PAGE = 9;
    public static final String IS_WRITE = "is_write";
    public static final String MEMBER_TYPE = "member_type";
    public static final String PAY_TYPE = "pay_type";
    public static final int SCENE_FROM_MEMBER_DEFAULT_COMMON = 0;
    public static final int SCENE_FROM_MEMBER_YEAR_COMMON = 9;
    public static final String SCENE_ID = "scene_id";
    public static final String ST_TYPE = "st_type";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra("member_type", i2);
    }

    public void setClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            getIntent().putExtra(IntentConfig.CLOSE, z);
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 <= 0) {
            return;
        }
        getIntent().putExtra("from", i2);
    }

    public void setFromScence(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            getIntent().putExtra(FROM_SCENE, i2);
        }
    }

    public void setReferPageClickZone(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            if (!StringUtils.isNull(str)) {
                getIntent().putExtra(MemberPayStatistic.REFER_PAGE, str);
            }
            if (StringUtils.isNull(str2)) {
                return;
            }
            getIntent().putExtra(MemberPayStatistic.CLICK_ZONE, str2);
        }
    }

    public void setSceneId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            getIntent().putExtra("scene_id", str);
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            getIntent().putExtra("st_type", str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i2, boolean z, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        getIntent().putExtra("member_type", i2);
        getIntent().putExtra(IntentConfig.CLOSE, z);
        getIntent().putExtra("from", i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i2, boolean z, int i3, int i4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        getIntent().putExtra("member_type", i2);
        getIntent().putExtra(IntentConfig.CLOSE, z);
        getIntent().putExtra("from", i3);
        getIntent().putExtra(FROM_SCENE, i4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i2, String str, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, Integer.valueOf(i3)};
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
        getIntent().putExtra("member_type", i2);
        getIntent().putExtra("st_type", str);
        getIntent().putExtra("from", i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i2, String str, int i3, int i4, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra("member_type", i2);
        getIntent().putExtra("st_type", str);
        getIntent().putExtra("from", i3);
        getIntent().putExtra("scene_id", str2);
        getIntent().putExtra("pay_type", i4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, boolean z, int i2, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2), str};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
        if (str != null) {
            getIntent().putExtra("st_type", str);
        }
        if (z) {
            setIntentAction(IntentAction.ActivityForResult);
            setRequestCode(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, boolean z, int i2, String str, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        if (str != null) {
            getIntent().putExtra("st_type", str);
        }
        if (z) {
            setIntentAction(IntentAction.ActivityForResult);
            setRequestCode(i2);
        }
        if (i3 > 0) {
            getIntent().putExtra("from", i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i2, int i3, int i4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("member_type", i2);
        getIntent().putExtra(IS_WRITE, i4);
        getIntent().putExtra("from", i3);
    }
}
