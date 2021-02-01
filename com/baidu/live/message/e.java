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
    private AlaLiveExceptionInfo buR;

    public e() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.buR = alaLiveExceptionInfo;
        if (this.buR != null) {
            addParam("appState", this.buR.appState);
            addParam("connect", this.buR.connect ? 1 : 0);
            addParam("dropFrame", this.buR.dropFrame);
            addParam("live_id", this.buR.liveID);
            addParam("lostRate", this.buR.lostRate);
            addParam("ls", this.buR.liveType);
            addParam("media_status", this.buR.mediaStatus);
            addParam("net_speed", this.buR.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.buR.networkType);
            addParam("node_ip", this.buR.nodeIP);
            addParam("phone", this.buR.phone ? 1 : 0);
            addParam("session_line", this.buR.sessionChannel);
            addParam("status", this.buR.status);
            addParam("stream_url", this.buR.streamUrl);
            addParam("video_level", this.buR.videoLevel);
            addParam("fps_min", this.buR.fpsMin);
            addParam("fps_max", this.buR.fpsMax);
            addParam("fps_avg", this.buR.fpsAvg);
            addParam("failure_audio", this.buR.failureAudio);
            addParam("failure_video", this.buR.failureVideo);
            addParam("play_fail", this.buR.playFail);
            addParam("lag_network_num", this.buR.lagNetworkNum);
            addParam("lag_sync_num", this.buR.lagSyncNum);
            addParam("lag_n_min", this.buR.lagnmin);
            addParam("lag_n_max", this.buR.lagnmax);
            addParam("lag_n_total", this.buR.lagntotal);
            addParam("lag_s_min", this.buR.lagsmin);
            addParam("lag_s_max", this.buR.lagsmax);
            addParam("lag_s_total", this.buR.lagstotal);
            addParam("connect_count", this.buR.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.buR.eventType);
            addParam("first_open", this.buR.firstOpenTime);
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
