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
    private AlaLiveExceptionInfo bmF;

    public e() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.bmF = alaLiveExceptionInfo;
        if (this.bmF != null) {
            addParam("appState", this.bmF.appState);
            addParam("connect", this.bmF.connect ? 1 : 0);
            addParam("dropFrame", this.bmF.dropFrame);
            addParam("live_id", this.bmF.liveID);
            addParam("lostRate", this.bmF.lostRate);
            addParam("ls", this.bmF.liveType);
            addParam("media_status", this.bmF.mediaStatus);
            addParam("net_speed", this.bmF.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.bmF.networkType);
            addParam("node_ip", this.bmF.nodeIP);
            addParam("phone", this.bmF.phone ? 1 : 0);
            addParam("session_line", this.bmF.sessionChannel);
            addParam("status", this.bmF.status);
            addParam("stream_url", this.bmF.streamUrl);
            addParam("video_level", this.bmF.videoLevel);
            addParam("fps_min", this.bmF.fpsMin);
            addParam("fps_max", this.bmF.fpsMax);
            addParam("fps_avg", this.bmF.fpsAvg);
            addParam("failure_audio", this.bmF.failureAudio);
            addParam("failure_video", this.bmF.failureVideo);
            addParam("play_fail", this.bmF.playFail);
            addParam("lag_network_num", this.bmF.lagNetworkNum);
            addParam("lag_sync_num", this.bmF.lagSyncNum);
            addParam("lag_n_min", this.bmF.lagnmin);
            addParam("lag_n_max", this.bmF.lagnmax);
            addParam("lag_n_total", this.bmF.lagntotal);
            addParam("lag_s_min", this.bmF.lagsmin);
            addParam("lag_s_max", this.bmF.lagsmax);
            addParam("lag_s_total", this.bmF.lagstotal);
            addParam("connect_count", this.bmF.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.bmF.eventType);
            addParam("first_open", this.bmF.firstOpenTime);
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
