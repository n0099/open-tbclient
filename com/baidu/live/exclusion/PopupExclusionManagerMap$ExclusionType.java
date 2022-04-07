package com.baidu.live.exclusion;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class PopupExclusionManagerMap$ExclusionType {
    public static final /* synthetic */ PopupExclusionManagerMap$ExclusionType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_ASK_ANSWER_GUIDE;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_CHAT_AUDIO_GUIDE;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_CONSULT_ENDLIVE_REMIND;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_CONSULT_FOLLOW_GUIDE;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_CONSULT_NOVICE_GUIDE;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_FOLLOW_GUIDE;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_FREE_GIFT_GUID_BUBBLE;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_HEALTH_BAR_GUIDE_BUBBLE;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_MID_INSERT_POP;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_PANEL;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_PAY_CHAT_AUDIO_GUIDE;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_SEND_GIFT;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_SEND_GIFT_GUIDE_BUBBLE;
    public static final PopupExclusionManagerMap$ExclusionType LIVE_HOME_SWIPE_TO_VIEW_MORE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-565705616, "Lcom/baidu/live/exclusion/PopupExclusionManagerMap$ExclusionType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-565705616, "Lcom/baidu/live/exclusion/PopupExclusionManagerMap$ExclusionType;");
                return;
            }
        }
        LIVE_HOME_SWIPE_TO_VIEW_MORE = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_SWIPE_TO_VIEW_MORE", 0);
        LIVE_HOME_PANEL = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_PANEL", 1);
        LIVE_HOME_MID_INSERT_POP = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_MID_INSERT_POP", 2);
        LIVE_HOME_FREE_GIFT_GUID_BUBBLE = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_FREE_GIFT_GUID_BUBBLE", 3);
        LIVE_HOME_PAY_CHAT_AUDIO_GUIDE = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_PAY_CHAT_AUDIO_GUIDE", 4);
        LIVE_HOME_FOLLOW_GUIDE = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_FOLLOW_GUIDE", 5);
        LIVE_HOME_SEND_GIFT = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_SEND_GIFT", 6);
        LIVE_HOME_CHAT_AUDIO_GUIDE = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_CHAT_AUDIO_GUIDE", 7);
        LIVE_HOME_ASK_ANSWER_GUIDE = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_ASK_ANSWER_GUIDE", 8);
        LIVE_HOME_SEND_GIFT_GUIDE_BUBBLE = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_SEND_GIFT_GUIDE_BUBBLE", 9);
        LIVE_HOME_CONSULT_FOLLOW_GUIDE = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_CONSULT_FOLLOW_GUIDE", 10);
        LIVE_HOME_CONSULT_NOVICE_GUIDE = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_CONSULT_NOVICE_GUIDE", 11);
        LIVE_HOME_CONSULT_ENDLIVE_REMIND = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_CONSULT_ENDLIVE_REMIND", 12);
        PopupExclusionManagerMap$ExclusionType popupExclusionManagerMap$ExclusionType = new PopupExclusionManagerMap$ExclusionType("LIVE_HOME_HEALTH_BAR_GUIDE_BUBBLE", 13);
        LIVE_HOME_HEALTH_BAR_GUIDE_BUBBLE = popupExclusionManagerMap$ExclusionType;
        $VALUES = new PopupExclusionManagerMap$ExclusionType[]{LIVE_HOME_SWIPE_TO_VIEW_MORE, LIVE_HOME_PANEL, LIVE_HOME_MID_INSERT_POP, LIVE_HOME_FREE_GIFT_GUID_BUBBLE, LIVE_HOME_PAY_CHAT_AUDIO_GUIDE, LIVE_HOME_FOLLOW_GUIDE, LIVE_HOME_SEND_GIFT, LIVE_HOME_CHAT_AUDIO_GUIDE, LIVE_HOME_ASK_ANSWER_GUIDE, LIVE_HOME_SEND_GIFT_GUIDE_BUBBLE, LIVE_HOME_CONSULT_FOLLOW_GUIDE, LIVE_HOME_CONSULT_NOVICE_GUIDE, LIVE_HOME_CONSULT_ENDLIVE_REMIND, popupExclusionManagerMap$ExclusionType};
    }

    public PopupExclusionManagerMap$ExclusionType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PopupExclusionManagerMap$ExclusionType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PopupExclusionManagerMap$ExclusionType) Enum.valueOf(PopupExclusionManagerMap$ExclusionType.class, str) : (PopupExclusionManagerMap$ExclusionType) invokeL.objValue;
    }

    public static PopupExclusionManagerMap$ExclusionType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PopupExclusionManagerMap$ExclusionType[]) $VALUES.clone() : (PopupExclusionManagerMap$ExclusionType[]) invokeV.objValue;
    }
}
