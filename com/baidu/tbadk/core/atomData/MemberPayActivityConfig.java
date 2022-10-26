package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MemberPayActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTOPAY_FROM_LOW_INCOME_FEEDBACK = "autopay_from_low_income_feedback";
    public static final String AUTOPAY_FROM_LOW_INCOME_FRS = "autopay_from_low_income_frs";
    public static final String AUTOPAY_FROM_LOW_INCOME_HOME = "autopay_from_low_income_home";
    public static final String AUTOPAY_FROM_LOW_INCOME_PB = "autopay_from_low_income_pb";
    public static final String FID = "fid";
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
    public static final int FROM_VIP_AD_FREE_GUID_TIP = 27;
    public static final String IS_WRITE = "is_write";
    public static final String MEMBER_TYPE = "member_type";
    public static final String PAY_TYPE = "pay_type";
    public static final int SCENE_FROM_FEEDBACK = 100019;
    public static final int SCENE_FROM_FRS = 100015;
    public static final int SCENE_FROM_HOME = 100013;
    public static final int SCENE_FROM_MEMBER_DEFAULT_COMMON = 0;
    public static final int SCENE_FROM_MEMBER_YEAR_COMMON = 9;
    public static final int SCENE_FROM_PB = 100017;
    public static final String SCENE_ID = "scene_id";
    public static final String SHOW_PRICE = "show_price";
    public static final String SHOW_VIP_TIP = "show_vip_tip";
    public static final String ST_TYPE = "st_type";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(MEMBER_TYPE, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i, int i2, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
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
        getIntent().putExtra(MEMBER_TYPE, i);
        getIntent().putExtra(IS_WRITE, i3);
        getIntent().putExtra("from", i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i, String str, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra(MEMBER_TYPE, i);
        getIntent().putExtra("st_type", str);
        getIntent().putExtra("from", i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i, String str, int i2, int i3, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra(MEMBER_TYPE, i);
        getIntent().putExtra("st_type", str);
        getIntent().putExtra("from", i2);
        getIntent().putExtra(SCENE_ID, str2);
        getIntent().putExtra(PAY_TYPE, i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i, String str, int i2, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        getIntent().putExtra(MEMBER_TYPE, i);
        getIntent().putExtra("st_type", str);
        getIntent().putExtra("from", i2);
        getIntent().putExtra(SHOW_VIP_TIP, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i, boolean z, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        getIntent().putExtra(MEMBER_TYPE, i);
        getIntent().putExtra("close", z);
        getIntent().putExtra("from", i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, int i, boolean z, int i2, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        getIntent().putExtra(MEMBER_TYPE, i);
        getIntent().putExtra("close", z);
        getIntent().putExtra("from", i2);
        getIntent().putExtra(FROM_SCENE, i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, boolean z, int i, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), str};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            setRequestCode(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPayActivityConfig(Context context, boolean z, int i, String str, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65544, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
                return;
            }
        }
        if (str != null) {
            getIntent().putExtra("st_type", str);
        }
        if (z) {
            setIntentAction(IntentAction.ActivityForResult);
            setRequestCode(i);
        }
        if (i2 > 0) {
            getIntent().putExtra("from", i2);
        }
    }

    public void setClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            getIntent().putExtra("close", z);
        }
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !TextUtils.isEmpty(str)) {
            getIntent().putExtra("fid", str);
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && i > 0) {
            getIntent().putExtra("from", i);
        }
    }

    public void setFromScence(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            getIntent().putExtra(FROM_SCENE, i);
        }
    }

    public void setSceneId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            getIntent().putExtra(SCENE_ID, str);
        }
    }

    public void setShowPrice(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !StringUtils.isNull(str)) {
            getIntent().putExtra(SHOW_PRICE, str);
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            getIntent().putExtra("st_type", str);
        }
    }

    public void setReferPageClickZone(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            if (!StringUtils.isNull(str)) {
                getIntent().putExtra(MemberPayStatistic.REFER_PAGE, str);
            }
            if (!StringUtils.isNull(str2)) {
                getIntent().putExtra(MemberPayStatistic.CLICK_ZONE, str2);
            }
        }
    }
}
