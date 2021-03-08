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
/* loaded from: classes10.dex */
public class e extends HttpMessage {
    private AlaLiveExceptionInfo bwr;

    public e() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.bwr = alaLiveExceptionInfo;
        if (this.bwr != null) {
            addParam("appState", this.bwr.appState);
            addParam("connect", this.bwr.connect ? 1 : 0);
            addParam("dropFrame", this.bwr.dropFrame);
            addParam("live_id", this.bwr.liveID);
            addParam("lostRate", this.bwr.lostRate);
            addParam("ls", this.bwr.liveType);
            addParam("media_status", this.bwr.mediaStatus);
            addParam("net_speed", this.bwr.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.bwr.networkType);
            addParam("node_ip", this.bwr.nodeIP);
            addParam("phone", this.bwr.phone ? 1 : 0);
            addParam("session_line", this.bwr.sessionChannel);
            addParam("status", this.bwr.status);
            addParam("stream_url", this.bwr.streamUrl);
            addParam("video_level", this.bwr.videoLevel);
            addParam("fps_min", this.bwr.fpsMin);
            addParam("fps_max", this.bwr.fpsMax);
            addParam("fps_avg", this.bwr.fpsAvg);
            addParam("failure_audio", this.bwr.failureAudio);
            addParam("failure_video", this.bwr.failureVideo);
            addParam("play_fail", this.bwr.playFail);
            addParam("lag_network_num", this.bwr.lagNetworkNum);
            addParam("lag_sync_num", this.bwr.lagSyncNum);
            addParam("lag_n_min", this.bwr.lagnmin);
            addParam("lag_n_max", this.bwr.lagnmax);
            addParam("lag_n_total", this.bwr.lagntotal);
            addParam("lag_s_min", this.bwr.lagsmin);
            addParam("lag_s_max", this.bwr.lagsmax);
            addParam("lag_s_total", this.bwr.lagstotal);
            addParam("connect_count", this.bwr.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.bwr.eventType);
            addParam("first_open", this.bwr.firstOpenTime);
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
