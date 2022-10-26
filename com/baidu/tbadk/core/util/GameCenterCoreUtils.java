package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class GameCenterCoreUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GAME_NATIVE_PREFIX = "game:detail";
    public static final String GAME_WEB_PREFIX = "http";
    public static final int ILLEGAL_URL = 0;
    public static final int NATIVE_URL = 1;
    public static final int NET_URL = 2;
    public static final String REF_TYPE_CLASSIFY = "1000104";
    public static final String REF_TYPE_CLASSIFY_DETAIL = "3001401";
    public static final String REF_TYPE_CURRENT_BAR = "1000601";
    public static final String REF_TYPE_DETAIL = "3000301";
    public static final String REF_TYPE_DETAIL_ABOUT = "1000301";
    public static final String REF_TYPE_DETAIL_COMPANY = "1000302";
    public static final String REF_TYPE_FROM_FORUM = "605";
    public static final String REF_TYPE_FROM_FRS = "603";
    public static final String REF_TYPE_FROM_GAMECENTER = "606";
    public static final String REF_TYPE_FROM_NAVIGATION = "601";
    public static final String REF_TYPE_FROM_PB = "604";
    public static final String REF_TYPE_FRS_AD = "4000601";
    public static final String REF_TYPE_GAME_BANNER = "4000102";
    public static final String REF_TYPE_GAME_MANAGER = "3001301";
    public static final String REF_TYPE_GAME_RUNNING = "1001102";
    public static final String REF_TYPE_GAME_TESTING = "1001101";
    public static final String REF_TYPE_HOT = "1000103";
    public static final String REF_TYPE_HOT_RANK = "1001201";
    public static final String REF_TYPE_IM = "2000801";
    public static final String REF_TYPE_LIGHT_GALLERY = "4000201";
    public static final String REF_TYPE_LIGHT_GOOD = "1000202";
    public static final String REF_TYPE_LIGHT_HOT = "1000201";
    public static final String REF_TYPE_LIGHT_RECOMMEND = "1000201";
    public static final String REF_TYPE_MAINTAB_AD = "4000401";
    public static final String REF_TYPE_MY_GAME = "3000201";
    public static final String REF_TYPE_NEW = "1000102";
    public static final String REF_TYPE_NEW_GAME = "1001101";
    public static final String REF_TYPE_OTHER = "5000901";
    public static final String REF_TYPE_PB = "2000701";
    public static final String REF_TYPE_RECOMMEND = "1000101";
    public static final String REF_TYPE_RECOMMEND_GALLERY = "4000101";
    public static final String REF_TYPE_SEARCH = "3000901";
    public static final String REF_TYPE_SINGLE_GALLERY = "4001001";
    public static final String REF_TYPE_SINGLE_RECOMMEND = "1001001";
    public static final String REF_TYPE_USER_FAVOURITE = "1000303";
    public transient /* synthetic */ FieldHolder $fh;

    public GameCenterCoreUtils() {
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

    public static int getJumpTypeByUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith(GAME_NATIVE_PREFIX)) {
                    return 1;
                }
                if (str.startsWith("http")) {
                    return 2;
                }
                return 0;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
