package com.baidu.searchbox.live.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.frame.State;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.mix.BaseItemModel;
import com.baidu.searchbox.live.interfaces.mix.BasePlaySourceInfo;
import com.baidu.searchbox.live.interfaces.mix.BaseRuntimeStatus;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0004 !\"#B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\bJ%\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "model", "", "bindData", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "onAttachedToWindow", "()V", "", CriusAttrConstants.POSITION, "onDeselected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "onDetachedFromWindow", "", "isFromUser", "onSelected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;Z)V", "Lcom/baidu/searchbox/live/widget/LiveContainer$ViewAttachListener;", "attachListener", "Lcom/baidu/searchbox/live/widget/LiveContainer$ViewAttachListener;", "getAttachListener", "()Lcom/baidu/searchbox/live/widget/LiveContainer$ViewAttachListener;", "setAttachListener", "(Lcom/baidu/searchbox/live/widget/LiveContainer$ViewAttachListener;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LiveItemModel", "LiveRuntimeStatus", "PlaySourceInfo", "ViewAttachListener", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class LiveContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap _$_findViewCache;
    public ViewAttachListener attachListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0007¢\u0006\u0004\b#\u0010\fJ\u0017\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\nJ\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\nJ\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\nJ\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\nJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\nJ\r\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\nJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\nJ\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\nJ\r\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\nJ\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010\nJ\r\u0010!\u001a\u00020\b¢\u0006\u0004\b!\u0010\nJ\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0015¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "Lcom/baidu/live/arch/frame/State;", "Lcom/baidu/searchbox/live/interfaces/mix/BaseItemModel;", "", ILiveNPSPlugin.PARAMS_ROOM_ID, "", "bindJumpNewLiveRoomId", "(Ljava/lang/String;)V", "", MediaLivePlayLogger.KEY_CAN_PRE_PLAY, "()Z", "clearIntroduceTips", "()V", "", ImageViewerConfig.FROM_OTHER, "equals", "(Ljava/lang/Object;)Z", "", "getIntroduceTipsStatus", "()I", "getJumpNewLiveRoomId", "()Ljava/lang/String;", TTDownloadField.TT_HASHCODE, "isAudioLive", "isConsultLive", "isFullTemplate", "isHLReplay", "isInValid", "isMediaBusiness", "isMediaLive", "isNewMediaLive", "isStarVertical", "isVideoLand", "isYYLive", "toString", "<init>", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class LiveItemModel extends BaseItemModel implements State {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Companion Companion;
        public static final String KEY = "LiveItemModel";
        public transient /* synthetic */ FieldHolder $fh;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel$Companion;", "", "KEY", "Ljava/lang/String;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes2.dex */
        public static final class Companion {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-267650494, "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-267650494, "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;");
                    return;
                }
            }
            Companion = new Companion(null);
        }

        public LiveItemModel() {
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

        public final void bindJumpNewLiveRoomId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (str == null || str.length() == 0) {
                    return;
                }
                if (getHlReplay() == null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("jumpRoomId", str);
                    setHlReplay(jSONObject);
                    return;
                }
                JSONObject hlReplay = getHlReplay();
                if (hlReplay == null) {
                    Intrinsics.throwNpe();
                }
                hlReplay.put("jumpRoomId", str);
            }
        }

        public final boolean canPrePlay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Intrinsics.areEqual(getLiveType(), "0") : invokeV.booleanValue;
        }

        public final void clearIntroduceTips() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                setIntroduceTips(null);
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (!Intrinsics.areEqual(LiveItemModel.class, obj != null ? obj.getClass() : null)) {
                    return false;
                }
                if (obj != null) {
                    return !(Intrinsics.areEqual(getRoomId(), ((LiveItemModel) obj).getRoomId()) ^ true);
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.searchbox.live.widget.LiveContainer.LiveItemModel");
            }
            return invokeL.booleanValue;
        }

        public final int getIntroduceTipsStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject introduceTips = getIntroduceTips();
                if (introduceTips != null) {
                    return introduceTips.optInt("status", -1);
                }
                return -1;
            }
            return invokeV.intValue;
        }

        public final String getJumpNewLiveRoomId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (getHlReplay() == null) {
                    return "";
                }
                JSONObject hlReplay = getHlReplay();
                if (hlReplay == null) {
                    Intrinsics.throwNpe();
                }
                String optString = hlReplay.optString("jumpRoomId");
                Intrinsics.checkExpressionValueIsNotNull(optString, "hlReplay!!.optString(\"jumpRoomId\")");
                return optString;
            }
            return (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getRoomId().hashCode() : invokeV.intValue;
        }

        public final boolean isAudioLive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Intrinsics.areEqual(getLiveType(), "0") && Intrinsics.areEqual(getTemplateId(), "5") : invokeV.booleanValue;
        }

        public final boolean isConsultLive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Intrinsics.areEqual(getLiveType(), "0") && Intrinsics.areEqual(getTemplateId(), "3") : invokeV.booleanValue;
        }

        public final boolean isFullTemplate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Intrinsics.areEqual(String.valueOf(1), getTemplate()) : invokeV.booleanValue;
        }

        public final boolean isHLReplay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getHlReplay() != null : invokeV.booleanValue;
        }

        public final boolean isInValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (TextUtils.isEmpty(getScreen()) || TextUtils.isEmpty(getTemplate())) ? false : true : invokeV.booleanValue;
        }

        public final boolean isMediaBusiness() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Intrinsics.areEqual(getLiveType(), "0") : invokeV.booleanValue;
        }

        public final boolean isMediaLive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? Intrinsics.areEqual(getLiveType(), "0") && Intrinsics.areEqual(getTemplateId(), "0") : invokeV.booleanValue;
        }

        public final boolean isNewMediaLive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? Intrinsics.areEqual(getLiveType(), "0") && Intrinsics.areEqual(getTemplateId(), "1") : invokeV.booleanValue;
        }

        public final boolean isStarVertical() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? !isVideoLand() && isFullTemplate() : invokeV.booleanValue;
        }

        public final boolean isVideoLand() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? Intrinsics.areEqual(String.valueOf(1), getScreen()) : invokeV.booleanValue;
        }

        public final boolean isYYLive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? Intrinsics.areEqual(getLiveType(), "3") : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("room_id", getRoomId());
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, getCover());
                jSONObject.put("play_url", getPlayUrl());
                jSONObject.put("live_type", getLiveType());
                jSONObject.put("scheme", getScheme());
                jSONObject.put("bgCover", getBgCover());
                jSONObject.put("title", getTitle());
                jSONObject.put("cRoomId", getCRoomId());
                JSONObject otherParams = getOtherParams();
                if (otherParams != null) {
                    jSONObject.put("otherParams", otherParams);
                }
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "json.toString()");
                return jSONObject2;
            }
            return (String) invokeV.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer$LiveRuntimeStatus;", "Lcom/baidu/searchbox/live/interfaces/mix/BaseRuntimeStatus;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class LiveRuntimeStatus extends BaseRuntimeStatus {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public LiveRuntimeStatus() {
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
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer$PlaySourceInfo;", "Lcom/baidu/searchbox/live/interfaces/mix/BasePlaySourceInfo;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class PlaySourceInfo extends BasePlaySourceInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PlaySourceInfo() {
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
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J'\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/widget/LiveContainer$ViewAttachListener;", "Lkotlin/Any;", "", "onAttach", "()V", "Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;", "model", "onDataChanged", "(Lcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "", CriusAttrConstants.POSITION, "onDeselected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;)V", "onDetach", "", "isFromUser", "onSelected", "(ILcom/baidu/searchbox/live/widget/LiveContainer$LiveItemModel;Z)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface ViewAttachListener {
        void onAttach();

        void onDataChanged(LiveItemModel liveItemModel);

        void onDeselected(int i, LiveItemModel liveItemModel);

        void onDetach();

        void onSelected(int i, LiveItemModel liveItemModel, boolean z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveContainer(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this._$_findViewCache) == null) {
            return;
        }
        hashMap.clear();
    }

    public View _$_findCachedViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this._$_findViewCache == null) {
                this._$_findViewCache = new HashMap();
            }
            View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
            if (view2 == null) {
                View findViewById = findViewById(i);
                this._$_findViewCache.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public final void bindData(LiveItemModel liveItemModel) {
        ViewAttachListener viewAttachListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, liveItemModel) == null) || (viewAttachListener = this.attachListener) == null) {
            return;
        }
        viewAttachListener.onDataChanged(liveItemModel);
    }

    public final ViewAttachListener getAttachListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.attachListener : (ViewAttachListener) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            ViewAttachListener viewAttachListener = this.attachListener;
            if (viewAttachListener != null) {
                viewAttachListener.onAttach();
            }
        }
    }

    public final void onDeselected(int i, LiveItemModel liveItemModel) {
        ViewAttachListener viewAttachListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i, liveItemModel) == null) || (viewAttachListener = this.attachListener) == null) {
            return;
        }
        viewAttachListener.onDeselected(i, liveItemModel);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            ViewAttachListener viewAttachListener = this.attachListener;
            if (viewAttachListener != null) {
                viewAttachListener.onDetach();
            }
        }
    }

    public final void onSelected(int i, LiveItemModel liveItemModel, boolean z) {
        ViewAttachListener viewAttachListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), liveItemModel, Boolean.valueOf(z)}) == null) || (viewAttachListener = this.attachListener) == null) {
            return;
        }
        viewAttachListener.onSelected(i, liveItemModel, z);
    }

    public final void setAttachListener(ViewAttachListener viewAttachListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewAttachListener) == null) {
            this.attachListener = viewAttachListener;
        }
    }

    public /* synthetic */ LiveContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
