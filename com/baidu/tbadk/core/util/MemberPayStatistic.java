package com.baidu.tbadk.core.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class MemberPayStatistic {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLICK_ZONE = "click_zone";
    public static final String CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON = "bottom_opende/renewalfee_button_V8.9";
    public static final String CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON = "bubble_pop_ups_opende/renewalfee_button_V8.9";
    public static final String CLICK_ZONE_OBTAIN_T = "obtain_T_V8.9";
    public static final String CLICK_ZONE_OPENDE_BUTTON = "opende_button_V8.9";
    public static final String CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON = "opende/renewalfee_button_V8.9";
    public static final String CLICK_ZONE_POP_UPS_OPENDE_BUTTON = "pop_ups_opende_button_V8.9";
    public static final String CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON = "pop_ups_opende/renewalfee_button_V8.9";
    public static final String CLICK_ZONE_TAILS_POP_UPS_OPENDE_RENEWALFEE_BUTTON = "tails_pop_ups_opende/renewalfee_button_V8.9";
    public static final String CLICK_ZONE_T_RECHARGE = "T_recharge_V8.9";
    public static final String REFER_PAGE = "refer_page";
    public static final String REFER_PAGE_ALL_BACKGROUND = "all_background_V8.9";
    public static final String REFER_PAGE_ALL_BACKGROUND_TRY = "all_background_try_V8.9";
    public static final String REFER_PAGE_ALL_BUBBLE = "all_bubble_V8.9";
    public static final String REFER_PAGE_AVANTAR_PENDANT = "avatar_pendant_V8.9";
    public static final String REFER_PAGE_A_KEY_TO_SIGN = "a_key_to_sign_V8.9";
    public static final String REFER_PAGE_CARDS_TRY = "cards_try_V8.9";
    public static final String REFER_PAGE_DRESS_UP_CENTER = "dress_up_center_V8.9";
    public static final String REFER_PAGE_FRS = "frs_V8.9";
    public static final String REFER_PAGE_GIFT_WALLS = "gift_walls_V8.9";
    public static final String REFER_PAGE_HE_HER_PERSONAL_CENTER = "he/her_personal_center_V8.9";
    public static final String REFER_PAGE_MISSION_CENTER_NATIVE = "mission_center_native_V8.9";
    public static final String REFER_PAGE_MY_DATA = "my_data_V8.9";
    public static final String REFER_PAGE_MY_GIFT = "my_gift_V8.9";
    public static final String REFER_PAGE_PERSONALITY_BACKGROUND = "personality_background_V8.9";
    public static final String REFER_PAGE_PERSONALITY_BACKGROUND_TRY = "personality_background_try_V8.9";
    public static final String REFER_PAGE_PERSONALITY_CARDS = "personality_cards_V8.9";
    public static final String REFER_PAGE_PERSONAL_CENTER = "personal_center_V8.9";
    public static final String REFER_PAGE_POSTING = "posting_V8.9";
    public static final String REFER_PAGE_POST_BUBBLE = "post_bubble_V8.9";
    public static final String REFER_PAGE_SITE = "site_V8.9";
    public transient /* synthetic */ FieldHolder $fh;

    public MemberPayStatistic() {
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
}
