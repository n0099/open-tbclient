package com.baidu.searchbox.player.ubc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.model.VideoTask;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0013J/\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/player/ubc/DumediaStatExtPlugin;", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "createPageInfoMap", "()Ljava/util/HashMap;", "", "getExpectOrder", "()I", "", "getSubscribeEvent", "()[I", "Lcom/baidu/searchbox/player/event/VideoEvent;", "event", "", "onPlayerEventNotify", "(Lcom/baidu/searchbox/player/event/VideoEvent;)V", "setPageInfo", "()V", "setTraceInfo", "<init>", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public class DumediaStatExtPlugin extends AbsPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DumediaStatExtPlugin() {
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

    private final void setPageInfo() {
        HashMap<String, String> createPageInfoMap;
        BDVideoPlayer bindPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (createPageInfoMap = createPageInfoMap()) == null || (bindPlayer = getBindPlayer()) == null) {
            return;
        }
        bindPlayer.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, createPageInfoMap);
    }

    private final void setTraceInfo() {
        BDVideoPlayer bindPlayer;
        VideoTask videoTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (bindPlayer = getBindPlayer()) == null || (videoTask = bindPlayer.getVideoTask()) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf((int) DpStatConstants.SESSION_TYPE_PLAY_COMMON));
        String str = videoTask.sessionId;
        if (str == null) {
            str = "";
        }
        hashMap.put("plogid", str);
        String str2 = videoTask.traceId;
        hashMap.put("traceid", str2 != null ? str2 : "");
        BDVideoPlayer bindPlayer2 = getBindPlayer();
        if (bindPlayer2 != null) {
            bindPlayer2.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
        }
    }

    public HashMap<String, String> createPageInfoMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public int getExpectOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{4} : (int[]) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.onPlayerEventNotify(event);
            String action = event.getAction();
            if (action.hashCode() == -882902390 && action.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                setPageInfo();
                setTraceInfo();
            }
        }
    }
}
