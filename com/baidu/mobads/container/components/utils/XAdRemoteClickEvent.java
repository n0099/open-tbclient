package com.baidu.mobads.container.components.utils;

import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class XAdRemoteClickEvent extends XAdRemoteEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_CLICK_THRU = "AdClickThru";
    public static final String AD_DATA_LOADED = "AdLoadData";
    public static final String AD_DURATION_CHANGE = "AdDurationChange";
    public static final String AD_EMPTY_LIST = "AdEmptyList";
    public static final String AD_ERROR = "AdError";
    public static final String AD_EXPANDED_CHANGE = "AdExpandedChange";
    public static final String AD_FINISH_ACTIVITY = "AdFinishActivity";
    public static final String AD_IMPRESSION = "AdImpression";
    public static final String AD_INTERACTION = "AdInteraction";
    public static final String AD_LINEAR_CHANGE = "AdLinearChange";
    public static final String AD_LOADED = "AdLoaded";
    public static final String AD_LOG = "AdLog";
    public static final String AD_LP_CLOSED = "AdLpClosed";
    public static final String AD_PAUSED = "AdPaused";
    public static final String AD_PLAYING = "AdPlaying";
    public static final String AD_REMAINING_TIME_CHANGE = "AdRemainingTimeChange";
    public static final String AD_SIZE_CHANGE = "AdSizeChange";
    public static final String AD_SKIPPABLE_STATE_CHANGED = "AdSkippableStateChange";
    public static final String AD_SKIPPED = "AdSkipped";
    public static final String AD_STARTED = "AdStarted";
    public static final String AD_STATUS_CHANGE = "AdStatusChange";
    public static final String AD_STOPPED = "AdStopped";
    public static final String AD_USER_ACCEPT_INVITATION = "AdUserAcceptInvitation";
    public static final String AD_USER_CLICK = "AdUserClick";
    public static final String AD_USER_CLOSE = "AdUserClose";
    public static final String AD_USER_MINIMIZE = "AdUserMinimize";
    public static final String AD_VIDEO_COMPLETE = "AdVideoComplete";
    public static final String AD_VIDEO_FIRST_QUARTILE = "AdVideoFirstQuartile";
    public static final String AD_VIDEO_MIDPOINT = "AdVideoMidpoint";
    public static final String AD_VIDEO_START = "AdVideoStart";
    public static final String AD_VIDEO_THIRD_QUARTILE = "AdVideoThirdQuartile";
    public static final String AD_VOLUME_CHANGE = "AdVolumeChange";
    public static final String VIDEO_CACHE_FAILED = "vdieoCacheFailed";
    public static final String VIDEO_CACHE_SUCC = "vdieoCacheSucc";
    public static final String VIDEO_PLAY_COMPLETION = "playCompletion";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XAdRemoteClickEvent(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XAdRemoteClickEvent(String str, HashMap<String, Object> hashMap) {
        super(str, hashMap);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, hashMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (HashMap) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
