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
/* loaded from: classes11.dex */
public class e extends HttpMessage {
    private AlaLiveExceptionInfo bwc;

    public e() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.bwc = alaLiveExceptionInfo;
        if (this.bwc != null) {
            addParam("appState", this.bwc.appState);
            addParam("connect", this.bwc.connect ? 1 : 0);
            addParam("dropFrame", this.bwc.dropFrame);
            addParam("live_id", this.bwc.liveID);
            addParam("lostRate", this.bwc.lostRate);
            addParam("ls", this.bwc.liveType);
            addParam("media_status", this.bwc.mediaStatus);
            addParam("net_speed", this.bwc.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.bwc.networkType);
            addParam("node_ip", this.bwc.nodeIP);
            addParam("phone", this.bwc.phone ? 1 : 0);
            addParam("session_line", this.bwc.sessionChannel);
            addParam("status", this.bwc.status);
            addParam("stream_url", this.bwc.streamUrl);
            addParam("video_level", this.bwc.videoLevel);
            addParam("fps_min", this.bwc.fpsMin);
            addParam("fps_max", this.bwc.fpsMax);
            addParam("fps_avg", this.bwc.fpsAvg);
            addParam("failure_audio", this.bwc.failureAudio);
            addParam("failure_video", this.bwc.failureVideo);
            addParam("play_fail", this.bwc.playFail);
            addParam("lag_network_num", this.bwc.lagNetworkNum);
            addParam("lag_sync_num", this.bwc.lagSyncNum);
            addParam("lag_n_min", this.bwc.lagnmin);
            addParam("lag_n_max", this.bwc.lagnmax);
            addParam("lag_n_total", this.bwc.lagntotal);
            addParam("lag_s_min", this.bwc.lagsmin);
            addParam("lag_s_max", this.bwc.lagsmax);
            addParam("lag_s_total", this.bwc.lagstotal);
            addParam("connect_count", this.bwc.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.bwc.eventType);
            addParam("first_open", this.bwc.firstOpenTime);
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
