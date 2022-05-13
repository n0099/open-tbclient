package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.util.PageDialogHelper$PayForm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BuyTBeanActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GIFT_TBEAN = "gift_tbean";
    public static final String IS_FROM_ALA = "is_from_ala";
    public static final String IS_FROM_ALA_GIFT_PANEL = "is_from_ala_gift_panel";
    public static final String PAY_FORM = "pay_form";
    public static final String PAY_TYPE = "pay_type";
    public static final String SCENE_ID = "scene_id";
    public static final int SOURCE_ALA_BUY_HOST_GUARDIAN = 4;
    public static final int SOURCE_ALA_GIFT_LEFT_CORNER = 3;
    public static final int SOURCE_ALA_GIFT_PANEL = 1;
    public static final int SOURCE_ALA_LIVEROOM_OUTSIDE_SHOW = 2;
    public static final int SOURCE_ALA_ONE_THOUSAND_GIFT = 5;
    public static final int SOURCE_DEFAULT = 0;
    public static final String TBEAN_LEFT_TO_BUY_ALA_GIFT = "tbean_left_to_buy_ala_gift";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuyTBeanActivityConfig(Context context, float f) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra("gift_tbean", f);
    }

    public BuyTBeanActivityConfig setFromDecreaseGiftStepStrategy(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            getIntent().putExtra(IS_FROM_ALA_GIFT_PANEL, i);
            return this;
        }
        return (BuyTBeanActivityConfig) invokeI.objValue;
    }

    public BuyTBeanActivityConfig setIsFromALa(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            getIntent().putExtra(IS_FROM_ALA, z);
            return this;
        }
        return (BuyTBeanActivityConfig) invokeZ.objValue;
    }

    public void setReferPageAndClickZone(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            getIntent().putExtra(MemberPayStatistic.REFER_PAGE, str);
            getIntent().putExtra(MemberPayStatistic.CLICK_ZONE, str2);
        }
    }

    public BuyTBeanActivityConfig setTBeanLeftToBuyGift(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            getIntent().putExtra(TBEAN_LEFT_TO_BUY_ALA_GIFT, j);
            return this;
        }
        return (BuyTBeanActivityConfig) invokeJ.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuyTBeanActivityConfig(Context context, float f, int i, String str, PageDialogHelper$PayForm pageDialogHelper$PayForm) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Float.valueOf(f), Integer.valueOf(i), str, pageDialogHelper$PayForm};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("gift_tbean", f);
        getIntent().putExtra("scene_id", str);
        getIntent().putExtra("pay_type", i);
        getIntent().putExtra(PAY_FORM, pageDialogHelper$PayForm);
    }
}
