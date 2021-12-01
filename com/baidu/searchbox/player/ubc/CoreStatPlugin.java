package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.Slot;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class CoreStatPlugin extends AbsPlugin {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsShowFirstFrame;
    public PlayerLoadingFlow mLoadingFlow;
    public long mStartLoadingTime;
    public BDVideoPlayerUbcContent mUBCContent;
    public UBCManager mUBCService;

    public CoreStatPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUBCService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.mUBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
        this.mLoadingFlow = new PlayerLoadingFlow();
    }

    private void dispatchMonitorEvent(Flow flow, BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, flow, bDVideoPlayerUbcContent) == null) || flow == null || bDVideoPlayerUbcContent == null) {
            return;
        }
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_ADD_PLAY_SPEED_RECORD);
        obtainEvent.putExtra(5, Long.valueOf(flow.getStartTime()));
        obtainEvent.putExtra(6, bDVideoPlayerUbcContent.getFrom());
        obtainEvent.putExtra(7, bDVideoPlayerUbcContent.getPage());
        sendEvent(obtainEvent);
    }

    private String getPlayerKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? getBindPlayer() != null ? getBindPlayer().getVideoUniqueKey() : "" : (String) invokeV.objValue;
    }

    private void onBufferEnd() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || System.currentTimeMillis() - this.mStartLoadingTime < 300) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", this.mIsShowFirstFrame ? "hasPlay" : "prepare");
            this.mLoadingFlow.uploadFlow(this.mUBCContent, null, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void onBufferStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mStartLoadingTime = System.currentTimeMillis();
            this.mLoadingFlow.createFlow();
        }
    }

    private void onCarlton(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, this, bDVideoPlayerUbcContent, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        BdVideoLog.d("【Statistics】 onCarlton upload begin");
        try {
            JSONObject extStatisticsLogClone = bDVideoPlayerUbcContent.getExtStatisticsLogClone();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                extStatisticsLogClone.putOpt(next, jSONObject.optString(next));
            }
            this.mUBCService.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_CARLTON, BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void onError(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65542, this, bDVideoPlayerUbcContent, i2, str) == null) {
            BdVideoLog.d("【Statistics】 onError upload begin");
            try {
                JSONObject extStatisticsLogClone = bDVideoPlayerUbcContent.getExtStatisticsLogClone();
                extStatisticsLogClone.putOpt(ShareLoginStat.MakeShareLoginStat.KEY_ERRNO, Integer.valueOf(i2));
                extStatisticsLogClone.putOpt("sub_errorNo", Integer.valueOf(i2));
                extStatisticsLogClone.putOpt("errorInfo", str);
                this.mUBCService.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, bDVideoPlayerUbcContent, (JSONObject) null));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void setKernelExternalInfo(@Nullable Flow flow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, flow) == null) || flow == null) {
            return;
        }
        HashMap<String, Slot> slotMaps = flow.getSlotMaps();
        long startTime = flow.getStartTime();
        if (slotMaps == null || slotMaps.size() <= 0) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<String, Slot> entry : slotMaps.entrySet()) {
            String key = entry.getKey();
            Slot value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null) {
                hashMap.put(key, String.valueOf(value.getEnd() - value.getStart()));
            }
        }
        hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_FIRST_SCREEN));
        hashMap.put("click_time", String.valueOf(startTime));
        this.mUBCContent.getPlayerFetcher().setKernelExternalInfo(hashMap);
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new int[]{6} : (int[]) invokeV.objValue;
    }

    public void onFirstFrameDisPlay(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bDVideoPlayerUbcContent) == null) {
            BdVideoLog.d("【Statistics】 onFirstFrameDisPlay upload begin");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("type", "first_frame");
                this.mUBCService.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SUCCESS, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoEvent) == null) {
            super.onVideoEventNotify(videoEvent);
            String action = videoEvent.getAction();
            switch (action.hashCode()) {
                case -1771982113:
                    if (action.equals(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -545382619:
                    if (action.equals(StatisticsEvent.ACTION_BUFFER_START)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -192759714:
                    if (action.equals(StatisticsEvent.ACTION_BUFFER_END)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -168110661:
                    if (action.equals(StatisticsEvent.ACTION_PLAYER_COMPLETE)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1537938041:
                    if (action.equals("statistics_player_carlton")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2082163910:
                    if (action.equals(StatisticsEvent.ACTION_PLAYER_ERROR)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2095136544:
                    if (action.equals(StatisticsEvent.ACTION_PLAYER_START)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2145795460:
                    if (action.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    onCarlton(this.mUBCContent, videoEvent.getStringExtra(2));
                    return;
                case 1:
                    PlayerSpeedTracker.cancelTrack(getPlayerKey());
                    String stringExtra = videoEvent.getStringExtra(2);
                    onError(this.mUBCContent, videoEvent.getIntExtra(4), stringExtra);
                    return;
                case 2:
                    this.mIsShowFirstFrame = false;
                    this.mLoadingFlow.cancelFlow();
                    PlayerSpeedTracker.cancelTrack(getPlayerKey());
                    return;
                case 3:
                    this.mIsShowFirstFrame = false;
                    this.mLoadingFlow.cancelFlow();
                    return;
                case 4:
                    onBufferStart();
                    return;
                case 5:
                    onBufferEnd();
                    return;
                case 6:
                    this.mIsShowFirstFrame = false;
                    PlayerSpeedTracker.endAfterInitToPlayPart(getPlayerKey());
                    PlayerSpeedTracker.beginCallPlayerStart(getPlayerKey());
                    return;
                case 7:
                    PlayerSpeedTracker.endPlayCore(getPlayerKey());
                    this.mIsShowFirstFrame = true;
                    String stringExtra2 = videoEvent.getStringExtra(2);
                    onFirstFrameDisPlay(this.mUBCContent);
                    Flow flow = FlowInstanceManager.getFlow(getPlayerKey());
                    setKernelExternalInfo(flow);
                    dispatchMonitorEvent(flow, this.mUBCContent);
                    PlayerSpeedTracker.endTrack(getPlayerKey(), this.mUBCContent, stringExtra2);
                    return;
                default:
                    return;
            }
        }
    }
}
