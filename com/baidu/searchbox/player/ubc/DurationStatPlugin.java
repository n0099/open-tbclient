package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.Slot;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DurationStatPlugin extends AbsPlugin {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DURATION_SLOT_DIFF_MIN = 500;
    public static final UBCManager UBC_MANAGER;
    public transient /* synthetic */ FieldHolder $fh;
    public int durationSlotIndex;
    public Flow mFlow;
    public BDVideoPlayerUbcContent mUBCContent;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597739091, "Lcom/baidu/searchbox/player/ubc/DurationStatPlugin;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597739091, "Lcom/baidu/searchbox/player/ubc/DurationStatPlugin;");
                return;
            }
        }
        UBC_MANAGER = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    public DurationStatPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
        this.durationSlotIndex = 1;
    }

    private boolean isNeedFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            BDVideoPlayer bindPlayer = getBindPlayer();
            return bindPlayer == null || bindPlayer.isStop() || bindPlayer.isComplete() || bindPlayer.isIdle();
        }
        return invokeV.booleanValue;
    }

    private void startDurationSlot() {
        Flow flow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (flow = this.mFlow) == null) {
            return;
        }
        UBCManager uBCManager = UBC_MANAGER;
        uBCManager.flowStartSlot(flow, "PlayerDurationPause_P" + this.durationSlotIndex, null);
    }

    private void uploadDurationFlow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            uploadDurationSlot();
            try {
                JSONObject extStatisticsLogClone = this.mUBCContent.getExtStatisticsLogClone();
                extStatisticsLogClone.putOpt("image", this.mUBCContent.getPoster());
                extStatisticsLogClone.putOpt("closeReason", Integer.valueOf(z ? 1 : 0));
                extStatisticsLogClone.putOpt("cycleCount", Integer.valueOf((getBindPlayer() != null ? getBindPlayer().getLoopCount() : 0) + 1));
                extStatisticsLogClone.putOpt("clarity", this.mUBCContent.getClarityKey());
                extStatisticsLogClone.putOpt("selectedType", Integer.valueOf(this.mUBCContent.getSelectType()));
                String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(extStatisticsLogClone, this.mUBCContent, (JSONObject) null);
                if (this.mFlow != null) {
                    UBC_MANAGER.flowSetValueWithDuration(this.mFlow, ubcContent);
                    UBC_MANAGER.flowEnd(this.mFlow);
                    this.mFlow = null;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.durationSlotIndex = 1;
        }
    }

    private void uploadDurationSlot() {
        Flow flow;
        HashMap<String, Slot> slotMaps;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (flow = this.mFlow) == null || (slotMaps = flow.getSlotMaps()) == null) {
            return;
        }
        Slot slot = slotMaps.get("PlayerDurationPause_P" + this.durationSlotIndex);
        if (slot == null || slot.getStart() <= 0 || System.currentTimeMillis() - slot.getStart() <= 500) {
            return;
        }
        UBCManager uBCManager = UBC_MANAGER;
        Flow flow2 = this.mFlow;
        uBCManager.flowEndSlot(flow2, "PlayerDurationPause_P" + this.durationSlotIndex);
        this.durationSlotIndex = this.durationSlotIndex + 1;
    }

    public void createFlow() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || isNeedFilter()) {
            return;
        }
        this.mFlow = UBC_MANAGER.beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_DURATION);
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new int[]{6} : (int[]) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoEvent) == null) {
            super.onVideoEventNotify(videoEvent);
            String action = videoEvent.getAction();
            switch (action.hashCode()) {
                case -2127352417:
                    if (action.equals(StatisticsEvent.ACTION_UPDATE_CONTENT)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1771982113:
                    if (action.equals(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1385549725:
                    if (action.equals(StatisticsEvent.ACTION_BACK_OR_FOREGROUND)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -168110661:
                    if (action.equals(StatisticsEvent.ACTION_PLAYER_COMPLETE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 482780463:
                    if (action.equals(StatisticsEvent.ACTION_PLAYER_RESUME)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 2091819188:
                    if (action.equals(StatisticsEvent.ACTION_PLAYER_PAUSE)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 2145795460:
                    if (action.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    this.mUBCContent = (BDVideoPlayerUbcContent) videoEvent.getExtra(13);
                    return;
                case 1:
                    createFlow();
                    return;
                case 2:
                    uploadDurationSlot();
                    return;
                case 3:
                    startDurationSlot();
                    return;
                case 4:
                    uploadDurationFlow(true);
                    return;
                case 5:
                    uploadDurationFlow(false);
                    return;
                case 6:
                    if (videoEvent.getBooleanExtra(8)) {
                        createFlow();
                        return;
                    } else {
                        uploadDurationFlow(false);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
