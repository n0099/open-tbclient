package com.baidu.live.mix;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \b\u0086\b\u0018\u0000 R:\u0001RB»\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0001\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0001\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010&\u001a\u00020\u0001\u0012\u0006\u0010'\u001a\u00020\u0001\u0012\u0006\u0010(\u001a\u00020\u0001\u0012\u0006\u0010)\u001a\u00020\u0001\u0012\u0006\u0010*\u001a\u00020\u0001\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010,\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bP\u0010QJ\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\t\u0010\u0003J\u0010\u0010\n\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\n\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0003J\u0010\u0010\f\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\f\u0010\u0003J\u0010\u0010\r\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\r\u0010\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0003J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0003Jè\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010&\u001a\u00020\u00012\b\b\u0002\u0010'\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020\u00012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00101\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0001H\u0016¢\u0006\u0004\b6\u0010\u0003R\u001b\u0010 \u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b \u00107\u001a\u0004\b8\u0010\u0003R\u0019\u0010&\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b&\u00107\u001a\u0004\b9\u0010\u0003R\u001b\u0010,\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010:\u001a\u0004\b;\u0010\u0011R\u001b\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010<\u001a\u0004\b=\u0010\u0007R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\b>\u0010\u0003R\"\u0010'\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u00107\u001a\u0004\b?\u0010\u0003\"\u0004\b@\u0010AR\u001b\u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010<\u001a\u0004\bB\u0010\u0007R\u0019\u0010)\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b)\u00107\u001a\u0004\bC\u0010\u0003R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\bD\u0010\u0003R\u0019\u0010\u001a\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00107\u001a\u0004\bE\u0010\u0003R\"\u0010(\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u00107\u001a\u0004\bF\u0010\u0003\"\u0004\bG\u0010AR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00107\u001a\u0004\bH\u0010\u0003R\u0019\u0010*\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b*\u00107\u001a\u0004\bI\u0010\u0003R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\bJ\u0010\u0003R\u001b\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010<\u001a\u0004\bK\u0010\u0007R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\bL\u0010\u0003R\u001b\u0010!\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\bM\u0010\u0003R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\bN\u0010\u0003R\u001b\u0010#\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\bO\u0010\u0003¨\u0006S"}, d2 = {"Lcom/baidu/live/mix/MixLiveItemModel;", "", "component1", "()Ljava/lang/String;", "component10", "Lorg/json/JSONObject;", "component11", "()Lorg/json/JSONObject;", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "", "component19", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ILiveNPSPlugin.PARAMS_ROOM_ID, "sid", YyLiveRoomConfig.KEY_SSID, "templateId", "token", "recommend", "anchorUid", "thumb", "from", "tpl", YyLiveRoomConfig.KEY_STREAMINFO, "extendInfo", AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "liveType", "scheme", "playUrl", "source", "otherParams", "extObj", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Object;)Lcom/baidu/live/mix/MixLiveItemModel;", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/lang/String;", "getAnchorUid", "getCover", "Ljava/lang/Object;", "getExtObj", "Lorg/json/JSONObject;", "getExtendInfo", "getFrom", "getLiveType", "setLiveType", "(Ljava/lang/String;)V", "getOtherParams", "getPlayUrl", "getRecommend", "getRoomId", "getScheme", "setScheme", "getSid", "getSource", "getSsid", "getStreamInfo", "getTemplateId", "getThumb", "getToken", "getTpl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Object;)V", "Companion", "lib-live-mix-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixLiveItemModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final String KEY = "LiveItemModel";
    public transient /* synthetic */ FieldHolder $fh;
    public final String anchorUid;
    public final String cover;
    public final Object extObj;
    public final JSONObject extendInfo;
    public final String from;
    public String liveType;
    public final JSONObject otherParams;
    public final String playUrl;
    public final String recommend;
    public final String roomId;
    public String scheme;
    public final String sid;
    public final String source;
    public final String ssid;
    public final JSONObject streamInfo;
    public final String templateId;
    public final String thumb;
    public final String token;
    public final String tpl;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2064129467, "Lcom/baidu/live/mix/MixLiveItemModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2064129467, "Lcom/baidu/live/mix/MixLiveItemModel;");
                return;
            }
        }
        Companion = new a(null);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.roomId : (String) invokeV.objValue;
    }

    public final String component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.tpl : (String) invokeV.objValue;
    }

    public final JSONObject component11() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.streamInfo : (JSONObject) invokeV.objValue;
    }

    public final JSONObject component12() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.extendInfo : (JSONObject) invokeV.objValue;
    }

    public final String component13() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cover : (String) invokeV.objValue;
    }

    public final String component14() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.liveType : (String) invokeV.objValue;
    }

    public final String component15() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.scheme : (String) invokeV.objValue;
    }

    public final String component16() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.playUrl : (String) invokeV.objValue;
    }

    public final String component17() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.source : (String) invokeV.objValue;
    }

    public final JSONObject component18() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.otherParams : (JSONObject) invokeV.objValue;
    }

    public final Object component19() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.extObj : invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.sid : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.ssid : (String) invokeV.objValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.templateId : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.token : (String) invokeV.objValue;
    }

    public final String component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.recommend : (String) invokeV.objValue;
    }

    public final String component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.anchorUid : (String) invokeV.objValue;
    }

    public final String component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.thumb : (String) invokeV.objValue;
    }

    public final String component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.from : (String) invokeV.objValue;
    }

    public final MixLiveItemModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, JSONObject jSONObject, JSONObject jSONObject2, String str11, String str12, String str13, String str14, String str15, JSONObject jSONObject3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, jSONObject, jSONObject2, str11, str12, str13, str14, str15, jSONObject3, obj})) == null) ? new MixLiveItemModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, jSONObject, jSONObject2, str11, str12, str13, str14, str15, jSONObject3, obj) : (MixLiveItemModel) invokeCommon.objValue;
    }

    /* loaded from: classes2.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MixLiveItemModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, JSONObject jSONObject, JSONObject jSONObject2, String str11, String str12, String str13, String str14, String str15, JSONObject jSONObject3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, str7, str8, str9, str10, jSONObject, jSONObject2, str11, str12, str13, str14, str15, jSONObject3, obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.roomId = str;
        this.sid = str2;
        this.ssid = str3;
        this.templateId = str4;
        this.token = str5;
        this.recommend = str6;
        this.anchorUid = str7;
        this.thumb = str8;
        this.from = str9;
        this.tpl = str10;
        this.streamInfo = jSONObject;
        this.extendInfo = jSONObject2;
        this.cover = str11;
        this.liveType = str12;
        this.scheme = str13;
        this.playUrl = str14;
        this.source = str15;
        this.otherParams = jSONObject3;
        this.extObj = obj;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MixLiveItemModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, JSONObject jSONObject, JSONObject jSONObject2, String str11, String str12, String str13, String str14, String str15, JSONObject jSONObject3, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, jSONObject, jSONObject2, str11, str12, str13, str14, str15, r19, obj);
        JSONObject jSONObject4;
        if ((i & 131072) != 0) {
            jSONObject4 = null;
        } else {
            jSONObject4 = jSONObject3;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(MixLiveItemModel.class, cls)) {
                return false;
            }
            if (obj != null) {
                if (!(!Intrinsics.areEqual(this.roomId, ((MixLiveItemModel) obj).roomId))) {
                    return true;
                }
                return false;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.mix.MixLiveItemModel");
        }
        return invokeL.booleanValue;
    }

    public final String getAnchorUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.anchorUid;
        }
        return (String) invokeV.objValue;
    }

    public final String getCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.cover;
        }
        return (String) invokeV.objValue;
    }

    public final Object getExtObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.extObj;
        }
        return invokeV.objValue;
    }

    public final JSONObject getExtendInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.extendInfo;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.from;
        }
        return (String) invokeV.objValue;
    }

    public final String getLiveType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.liveType;
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject getOtherParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.otherParams;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.playUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.recommend;
        }
        return (String) invokeV.objValue;
    }

    public final String getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.roomId;
        }
        return (String) invokeV.objValue;
    }

    public final String getScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.scheme;
        }
        return (String) invokeV.objValue;
    }

    public final String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.sid;
        }
        return (String) invokeV.objValue;
    }

    public final String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.source;
        }
        return (String) invokeV.objValue;
    }

    public final String getSsid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.ssid;
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject getStreamInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.streamInfo;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final String getTemplateId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.templateId;
        }
        return (String) invokeV.objValue;
    }

    public final String getThumb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.thumb;
        }
        return (String) invokeV.objValue;
    }

    public final String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.token;
        }
        return (String) invokeV.objValue;
    }

    public final String getTpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.tpl;
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.roomId.hashCode();
        }
        return invokeV.intValue;
    }

    public final void setLiveType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.liveType = str;
        }
    }

    public final void setScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.scheme = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", this.roomId);
            jSONObject.put("sid", this.sid);
            jSONObject.put(YyLiveRoomConfig.KEY_SSID, this.ssid);
            jSONObject.put("templateId", this.templateId);
            jSONObject.put("token", this.token);
            jSONObject.put("recommend", this.recommend);
            jSONObject.put("anchorUid", this.anchorUid);
            jSONObject.put("thumb", this.thumb);
            jSONObject.put("from", this.from);
            jSONObject.put("tpl", this.tpl);
            jSONObject.put(YyLiveRoomConfig.KEY_STREAMINFO, this.streamInfo);
            jSONObject.put("extendInfo", this.extendInfo);
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, this.cover);
            jSONObject.put("play_url", this.playUrl);
            jSONObject.put("live_type", this.liveType);
            jSONObject.put("scheme", this.scheme);
            jSONObject.put("source", this.source);
            JSONObject jSONObject2 = this.otherParams;
            if (jSONObject2 != null) {
                jSONObject.put("otherParams", jSONObject2);
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "json.toString()");
            return jSONObject3;
        }
        return (String) invokeV.objValue;
    }
}
