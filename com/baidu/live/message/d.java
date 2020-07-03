package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.mcast.McastManagerImpl;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.AlaLiveExceptionInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes3.dex */
public class d extends HttpMessage {
    private AlaLiveExceptionInfo aZk;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.aZk = alaLiveExceptionInfo;
        if (this.aZk != null) {
            addParam("appState", this.aZk.appState);
            addParam("connect", this.aZk.connect ? 1 : 0);
            addParam("dropFrame", this.aZk.dropFrame);
            addParam("live_id", this.aZk.liveID);
            addParam("lostRate", this.aZk.lostRate);
            addParam("ls", this.aZk.liveType);
            addParam("media_status", this.aZk.mediaStatus);
            addParam("net_speed", this.aZk.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.aZk.networkType);
            addParam("node_ip", this.aZk.nodeIP);
            addParam("phone", this.aZk.phone ? 1 : 0);
            addParam("session_line", this.aZk.sessionChannel);
            addParam("status", this.aZk.status);
            addParam("stream_url", this.aZk.streamUrl);
            addParam("video_level", this.aZk.videoLevel);
            addParam("fps_min", this.aZk.fpsMin);
            addParam("fps_max", this.aZk.fpsMax);
            addParam("fps_avg", this.aZk.fpsAvg);
            addParam("failure_audio", this.aZk.failureAudio);
            addParam("failure_video", this.aZk.failureVideo);
            addParam("play_fail", this.aZk.playFail);
            addParam("lag_network_num", this.aZk.lagNetworkNum);
            addParam("lag_sync_num", this.aZk.lagSyncNum);
            addParam("lag_n_min", this.aZk.lagnmin);
            addParam("lag_n_max", this.aZk.lagnmax);
            addParam("lag_n_total", this.aZk.lagntotal);
            addParam("lag_s_min", this.aZk.lagsmin);
            addParam("lag_s_max", this.aZk.lagsmax);
            addParam("lag_s_total", this.aZk.lagstotal);
            addParam("connect_count", this.aZk.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.aZk.eventType);
            addParam("first_open", this.aZk.firstOpenTime);
            addParam("im_sdk_version", BIMManager.getVersion());
            addParam("im_sdk_connet", LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined() + "");
            if (IMConfigInternal.getInstance().getSDKVersionValue(TbadkCoreApplication.getInst().getContext()) >= 5850036) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID), String.class);
                if (runTask == null || TextUtils.isEmpty((CharSequence) runTask.getData())) {
                    j = 0;
                } else {
                    try {
                        j = Long.parseLong((String) runTask.getData());
                    } catch (NumberFormatException e) {
                        j = 0;
                    }
                }
                addParam("im_latest_gift_msgid", McastManagerImpl.getInstance(TbadkCoreApplication.getInst().getContext()).getMaxReliableMsgId(j) + "");
                addParam("im_gift_msg_num", McastManagerImpl.getInstance(TbadkCoreApplication.getInst().getContext()).getReliableMsgCount(j) + "");
            }
            try {
                addParam("im_join_castid", McastManagerImpl.getInstance(TbadkCoreApplication.getInst().getContext()).getAllCastIdList() + "");
            } catch (Throwable th) {
                addParam("im_join_castid", "0");
            }
        }
    }
}
