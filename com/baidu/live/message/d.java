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
    private AlaLiveExceptionInfo blk;

    public d() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.blk = alaLiveExceptionInfo;
        if (this.blk != null) {
            addParam("appState", this.blk.appState);
            addParam("connect", this.blk.connect ? 1 : 0);
            addParam("dropFrame", this.blk.dropFrame);
            addParam("live_id", this.blk.liveID);
            addParam("lostRate", this.blk.lostRate);
            addParam("ls", this.blk.liveType);
            addParam("media_status", this.blk.mediaStatus);
            addParam("net_speed", this.blk.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.blk.networkType);
            addParam("node_ip", this.blk.nodeIP);
            addParam("phone", this.blk.phone ? 1 : 0);
            addParam("session_line", this.blk.sessionChannel);
            addParam("status", this.blk.status);
            addParam("stream_url", this.blk.streamUrl);
            addParam("video_level", this.blk.videoLevel);
            addParam("fps_min", this.blk.fpsMin);
            addParam("fps_max", this.blk.fpsMax);
            addParam("fps_avg", this.blk.fpsAvg);
            addParam("failure_audio", this.blk.failureAudio);
            addParam("failure_video", this.blk.failureVideo);
            addParam("play_fail", this.blk.playFail);
            addParam("lag_network_num", this.blk.lagNetworkNum);
            addParam("lag_sync_num", this.blk.lagSyncNum);
            addParam("lag_n_min", this.blk.lagnmin);
            addParam("lag_n_max", this.blk.lagnmax);
            addParam("lag_n_total", this.blk.lagntotal);
            addParam("lag_s_min", this.blk.lagsmin);
            addParam("lag_s_max", this.blk.lagsmax);
            addParam("lag_s_total", this.blk.lagstotal);
            addParam("connect_count", this.blk.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.blk.eventType);
            addParam("first_open", this.blk.firstOpenTime);
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
