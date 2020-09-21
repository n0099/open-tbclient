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
    private AlaLiveExceptionInfo bhu;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.bhu = alaLiveExceptionInfo;
        if (this.bhu != null) {
            addParam("appState", this.bhu.appState);
            addParam("connect", this.bhu.connect ? 1 : 0);
            addParam("dropFrame", this.bhu.dropFrame);
            addParam("live_id", this.bhu.liveID);
            addParam("lostRate", this.bhu.lostRate);
            addParam("ls", this.bhu.liveType);
            addParam("media_status", this.bhu.mediaStatus);
            addParam("net_speed", this.bhu.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.bhu.networkType);
            addParam("node_ip", this.bhu.nodeIP);
            addParam("phone", this.bhu.phone ? 1 : 0);
            addParam("session_line", this.bhu.sessionChannel);
            addParam("status", this.bhu.status);
            addParam("stream_url", this.bhu.streamUrl);
            addParam("video_level", this.bhu.videoLevel);
            addParam("fps_min", this.bhu.fpsMin);
            addParam("fps_max", this.bhu.fpsMax);
            addParam("fps_avg", this.bhu.fpsAvg);
            addParam("failure_audio", this.bhu.failureAudio);
            addParam("failure_video", this.bhu.failureVideo);
            addParam("play_fail", this.bhu.playFail);
            addParam("lag_network_num", this.bhu.lagNetworkNum);
            addParam("lag_sync_num", this.bhu.lagSyncNum);
            addParam("lag_n_min", this.bhu.lagnmin);
            addParam("lag_n_max", this.bhu.lagnmax);
            addParam("lag_n_total", this.bhu.lagntotal);
            addParam("lag_s_min", this.bhu.lagsmin);
            addParam("lag_s_max", this.bhu.lagsmax);
            addParam("lag_s_total", this.bhu.lagstotal);
            addParam("connect_count", this.bhu.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.bhu.eventType);
            addParam("first_open", this.bhu.firstOpenTime);
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
