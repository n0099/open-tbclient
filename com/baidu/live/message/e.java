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
public class e extends HttpMessage {
    private AlaLiveExceptionInfo bmo;

    public e() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.bmo = alaLiveExceptionInfo;
        if (this.bmo != null) {
            addParam("appState", this.bmo.appState);
            addParam("connect", this.bmo.connect ? 1 : 0);
            addParam("dropFrame", this.bmo.dropFrame);
            addParam("live_id", this.bmo.liveID);
            addParam("lostRate", this.bmo.lostRate);
            addParam("ls", this.bmo.liveType);
            addParam("media_status", this.bmo.mediaStatus);
            addParam("net_speed", this.bmo.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.bmo.networkType);
            addParam("node_ip", this.bmo.nodeIP);
            addParam("phone", this.bmo.phone ? 1 : 0);
            addParam("session_line", this.bmo.sessionChannel);
            addParam("status", this.bmo.status);
            addParam("stream_url", this.bmo.streamUrl);
            addParam("video_level", this.bmo.videoLevel);
            addParam("fps_min", this.bmo.fpsMin);
            addParam("fps_max", this.bmo.fpsMax);
            addParam("fps_avg", this.bmo.fpsAvg);
            addParam("failure_audio", this.bmo.failureAudio);
            addParam("failure_video", this.bmo.failureVideo);
            addParam("play_fail", this.bmo.playFail);
            addParam("lag_network_num", this.bmo.lagNetworkNum);
            addParam("lag_sync_num", this.bmo.lagSyncNum);
            addParam("lag_n_min", this.bmo.lagnmin);
            addParam("lag_n_max", this.bmo.lagnmax);
            addParam("lag_n_total", this.bmo.lagntotal);
            addParam("lag_s_min", this.bmo.lagsmin);
            addParam("lag_s_max", this.bmo.lagsmax);
            addParam("lag_s_total", this.bmo.lagstotal);
            addParam("connect_count", this.bmo.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.bmo.eventType);
            addParam("first_open", this.bmo.firstOpenTime);
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
