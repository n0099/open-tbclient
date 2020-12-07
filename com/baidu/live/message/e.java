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
    private AlaLiveExceptionInfo brv;

    public e() {
        super(1021049);
    }

    public void a(AlaLiveExceptionInfo alaLiveExceptionInfo) {
        long j;
        this.brv = alaLiveExceptionInfo;
        if (this.brv != null) {
            addParam("appState", this.brv.appState);
            addParam("connect", this.brv.connect ? 1 : 0);
            addParam("dropFrame", this.brv.dropFrame);
            addParam("live_id", this.brv.liveID);
            addParam("lostRate", this.brv.lostRate);
            addParam("ls", this.brv.liveType);
            addParam("media_status", this.brv.mediaStatus);
            addParam("net_speed", this.brv.netSpped);
            addParam(HttpConstants.NETWORK_TYPE, this.brv.networkType);
            addParam("node_ip", this.brv.nodeIP);
            addParam("phone", this.brv.phone ? 1 : 0);
            addParam("session_line", this.brv.sessionChannel);
            addParam("status", this.brv.status);
            addParam("stream_url", this.brv.streamUrl);
            addParam("video_level", this.brv.videoLevel);
            addParam("fps_min", this.brv.fpsMin);
            addParam("fps_max", this.brv.fpsMax);
            addParam("fps_avg", this.brv.fpsAvg);
            addParam("failure_audio", this.brv.failureAudio);
            addParam("failure_video", this.brv.failureVideo);
            addParam("play_fail", this.brv.playFail);
            addParam("lag_network_num", this.brv.lagNetworkNum);
            addParam("lag_sync_num", this.brv.lagSyncNum);
            addParam("lag_n_min", this.brv.lagnmin);
            addParam("lag_n_max", this.brv.lagnmax);
            addParam("lag_n_total", this.brv.lagntotal);
            addParam("lag_s_min", this.brv.lagsmin);
            addParam("lag_s_max", this.brv.lagsmax);
            addParam("lag_s_total", this.brv.lagstotal);
            addParam("connect_count", this.brv.connectCount);
            addParam(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, this.brv.eventType);
            addParam("first_open", this.brv.firstOpenTime);
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
