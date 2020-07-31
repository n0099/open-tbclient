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
/* loaded from: classes4.dex */
public class d extends HttpMessage {
    private AlaLiveExceptionInfo aZi;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.aZi = alaLiveExceptionInfo;
        if (this.aZi != null) {
            addParam("appState", this.aZi.appState);
            addParam("connect", this.aZi.connect ? 1 : 0);
            addParam("dropFrame", this.aZi.dropFrame);
            addParam("live_id", this.aZi.liveID);
            addParam("lostRate", this.aZi.lostRate);
            addParam("ls", this.aZi.liveType);
            addParam("media_status", this.aZi.mediaStatus);
            addParam("net_speed", this.aZi.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.aZi.networkType);
            addParam("node_ip", this.aZi.nodeIP);
            addParam("phone", this.aZi.phone ? 1 : 0);
            addParam("session_line", this.aZi.sessionChannel);
            addParam("status", this.aZi.status);
            addParam("stream_url", this.aZi.streamUrl);
            addParam("video_level", this.aZi.videoLevel);
            addParam("fps_min", this.aZi.fpsMin);
            addParam("fps_max", this.aZi.fpsMax);
            addParam("fps_avg", this.aZi.fpsAvg);
            addParam("failure_audio", this.aZi.failureAudio);
            addParam("failure_video", this.aZi.failureVideo);
            addParam("play_fail", this.aZi.playFail);
            addParam("lag_network_num", this.aZi.lagNetworkNum);
            addParam("lag_sync_num", this.aZi.lagSyncNum);
            addParam("lag_n_min", this.aZi.lagnmin);
            addParam("lag_n_max", this.aZi.lagnmax);
            addParam("lag_n_total", this.aZi.lagntotal);
            addParam("lag_s_min", this.aZi.lagsmin);
            addParam("lag_s_max", this.aZi.lagsmax);
            addParam("lag_s_total", this.aZi.lagstotal);
            addParam("connect_count", this.aZi.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.aZi.eventType);
            addParam("first_open", this.aZi.firstOpenTime);
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
