package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class LegoListActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_ID = "ad_id";
    public static final String ANIMATION_INFO = "animation_info";
    public static final String DOWNLOAD_MIDDLE_KEY = "download_middle";
    public static final String HAS_ANIMATION = "has_animation";
    public static final String IS_FROM = "source";
    public static final String IS_IMMERSIVE = "is_immersive";
    public static final String IS_LANDINGPAGE = "is_landingpage";
    public static final String ITEM_ID = "item_id";
    public static final String JUMP_NEW_WEB = "1";
    public static final String NEXT_PAGE = "next_page";
    public static final String PAGE_ID = "page_id";
    public static final int PAGE_TAB = 1;
    public static final String PAGE_TYPE = "page_type";
    public static final String PARAMS = "params";
    public static final String PRE_LOAD = "pre_load";
    public static final String RN = "rn";
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoListActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.mContext = context;
    }

    public LegoListActivityConfig addLandingPageParams(String str, String str2, String str3, int i2, int i3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4})) == null) {
            Intent intent = getIntent();
            intent.putExtra(HAS_ANIMATION, i2);
            intent.putExtra(IS_LANDINGPAGE, i3);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(ANIMATION_INFO, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra(PRE_LOAD, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                intent.putExtra(NEXT_PAGE, str3);
            }
            intent.putExtra("source", str4);
            return this;
        }
        return (LegoListActivityConfig) invokeCommon.objValue;
    }

    public LegoListActivityConfig createNormalCfg(long j2, int i2, String str, int i3, int i4, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2})) == null) {
            Intent intent = getIntent();
            intent.putExtra("page_id", j2);
            intent.putExtra("page_type", i2);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("item_id", str);
            }
            intent.putExtra(IS_IMMERSIVE, i3);
            intent.putExtra("rn", i4);
            intent.putExtra("params", str2);
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            return this;
        }
        return (LegoListActivityConfig) invokeCommon.objValue;
    }
}
