package com.baidu.searchbox.live.data.constant;

import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0003:\u0001\u0003B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/live/data/constant/MixConstants;", "<init>", "()V", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUSINESS_TYPE_AUDIO_ROOM = "4";
    public static final String BUSINESS_TYPE_MEDIA = "0";
    public static final String BUSINESS_TYPE_XIU_CHANG = "1";
    public static final String BUSINESS_TYPE_YY = "3";
    public static final Companion Companion;
    public static final String KEY_CLOSE_IM = "CloseIM";
    public static final String KEY_GET_AUDIO_ROOM_SCROLLABLE = "key_GetAudioRoomScrollAble";
    public static final String KEY_LIST_INFO = "ListInfo";
    public static final String KEY_MIX_NETWORK = "network";
    public static final String KEY_NETWORK_CHANGED = "onNetworkChanged";
    public static final String KEY_NEW_INTENT = "NewIntent";
    public static final String KEY_PLUGIN_LOAD_SOURCE = "plugin_load_source";
    public static final String KEY_ROOM_INFO_RES_SUCCESS = "RoomInfoResSuccess";
    public static final String KEY_YYGoBackPopUp = "YYGoBackPopUp";
    public static final String LIVE_AUDIO_COMPONENT = "live_audio_component";
    public static final String LIVE_COMPONENT_CONSULT = "live_component_consult";
    public static final String LIVE_COMPONENT_DATE = "live_component_date";
    public static final String LIVE_COMPONENT_NEW_MEDIA = "live_component_new_media";
    public static final String LIVE_COMPONENT_SHOPPING = "live_component_shopping";
    public static final String LIVE_MEDIA_COMPONENT = "live_media_component";
    public static final String LIVE_TEMPLATE_AUDIO = "5";
    public static final String LIVE_TEMPLATE_CONSULT = "3";
    public static final String LIVE_TEMPLATE_DATE = "7";
    public static final String LIVE_TEMPLATE_MEDIA = "0";
    public static final String LIVE_TEMPLATE_NEW_MEDIA = "1";
    public static final String LIVE_TEMPLATE_SHOPPING = "2";
    public static final int LIVE_TYPE_AUDIO = 7;
    public static final int LIVE_TYPE_CONSULT = 5;
    public static final int LIVE_TYPE_DATE = 8;
    public static final int LIVE_TYPE_MEDIA = 0;
    public static final int LIVE_TYPE_NEW_MEDIA = 3;
    public static final int LIVE_TYPE_SHOPPING = 4;
    public static final int LIVE_TYPE_SHOW = 1;
    public static final int LIVE_TYPE_YY = 6;
    public static final String LIVE_YY_COMPONENT = "live_yy_component";
    public static final String RES_GET_AUDIO_ROOM_SCROLLABLE = "res_GetAudioRoomScrollAble";
    public static final int SCREEN_LANDSCAPE = 1;
    public static final int SCREEN_PORTRAIT = 0;
    public static final int STATUS_LIVE_PREVIEW = 4;
    public static final int TEMPLATE_FULL = 1;
    public static final int TEMPLATE_HALF = 2;
    public static final int TRANSITION_STATUS_NORMAL = 0;
    public static final int TRANSITION_STATUS_SEAMLESS = 1;
    public static final int TRANSITION_STATUS_SEAMLESS_FINISH = 2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(139908441, "Lcom/baidu/searchbox/live/data/constant/MixConstants;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(139908441, "Lcom/baidu/searchbox/live/data/constant/MixConstants;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b6\u0010\u0016J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0016\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0005R\u0016\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0005R\u0016\u0010\u000f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u0016\u0010\u0010\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0005R\u0016\u0010\u0011\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u0016\u0010\u0012\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0005R\u0016\u0010\u0013\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0005R\u001c\u0010\u0014\u001a\u00020\u00018\u0006@\u0007X\u0087T¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u0012\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0005R\u0016\u0010\u0018\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0005R\u0016\u0010\u0019\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0005R\u0016\u0010\u001a\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0005R\u0016\u0010\u001b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0005R\u001c\u0010\u001c\u001a\u00020\u00018\u0006@\u0007X\u0087T¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u0012\u0004\b\u001d\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0005R\u0016\u0010\u001f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0005R\u0016\u0010 \u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0005R\u0016\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010#R\u001c\u0010%\u001a\u00020!8\u0006@\u0007X\u0087T¢\u0006\f\n\u0004\b%\u0010#\u0012\u0004\b&\u0010\u0016R\u0016\u0010'\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010(\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010#R\u0016\u0010)\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010*\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010#R\u0016\u0010+\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010#R\u0016\u0010,\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\u0005R\u0016\u0010-\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010\u0005R\u0016\u0010.\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010#R\u0016\u0010/\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010#R\u0016\u00100\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010#R\u0016\u00101\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010#R\u0016\u00102\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010#R\u0016\u00103\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010#R\u0016\u00104\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010#R\u0016\u00105\u001a\u00020!8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010#¨\u00067"}, d2 = {"Lcom/baidu/searchbox/live/data/constant/MixConstants$Companion;", "", "getAudioConnectorAppId", "()Ljava/lang/String;", "BUSINESS_TYPE_AUDIO_ROOM", "Ljava/lang/String;", "BUSINESS_TYPE_MEDIA", "BUSINESS_TYPE_XIU_CHANG", "BUSINESS_TYPE_YY", "KEY_CLOSE_IM", "KEY_GET_AUDIO_ROOM_SCROLLABLE", "KEY_LIST_INFO", "KEY_MIX_NETWORK", "KEY_NETWORK_CHANGED", "KEY_NEW_INTENT", "KEY_PLUGIN_LOAD_SOURCE", "KEY_ROOM_INFO_RES_SUCCESS", "KEY_YYGoBackPopUp", "LIVE_AUDIO_COMPONENT", "LIVE_COMPONENT_CONSULT", "LIVE_COMPONENT_DATE", "LIVE_COMPONENT_DATE$annotations", "()V", "LIVE_COMPONENT_NEW_MEDIA", "LIVE_COMPONENT_SHOPPING", "LIVE_MEDIA_COMPONENT", "LIVE_TEMPLATE_AUDIO", "LIVE_TEMPLATE_CONSULT", "LIVE_TEMPLATE_DATE", "LIVE_TEMPLATE_DATE$annotations", "LIVE_TEMPLATE_MEDIA", "LIVE_TEMPLATE_NEW_MEDIA", "LIVE_TEMPLATE_SHOPPING", "", "LIVE_TYPE_AUDIO", "I", "LIVE_TYPE_CONSULT", "LIVE_TYPE_DATE", "LIVE_TYPE_DATE$annotations", "LIVE_TYPE_MEDIA", "LIVE_TYPE_NEW_MEDIA", "LIVE_TYPE_SHOPPING", "LIVE_TYPE_SHOW", "LIVE_TYPE_YY", "LIVE_YY_COMPONENT", "RES_GET_AUDIO_ROOM_SCROLLABLE", "SCREEN_LANDSCAPE", "SCREEN_PORTRAIT", "STATUS_LIVE_PREVIEW", "TEMPLATE_FULL", "TEMPLATE_HALF", "TRANSITION_STATUS_NORMAL", "TRANSITION_STATUS_SEAMLESS", "TRANSITION_STATUS_SEAMLESS_FINISH", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Deprecated(message = "已废弃")
        public static /* synthetic */ void LIVE_COMPONENT_DATE$annotations() {
        }

        @Deprecated(message = "已废弃")
        public static /* synthetic */ void LIVE_TEMPLATE_DATE$annotations() {
        }

        @Deprecated(message = "已废弃")
        public static /* synthetic */ void LIVE_TYPE_DATE$annotations() {
        }

        public Companion() {
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

        public final String getAudioConnectorAppId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (MiniShellRuntime.INSTANCE.isTieba()) {
                    return "100003";
                }
                return "100001";
            }
            return (String) invokeV.objValue;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MixConstants() {
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
