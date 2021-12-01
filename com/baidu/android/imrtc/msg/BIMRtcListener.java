package com.baidu.android.imrtc.msg;

import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickReqSyncRtcInfo;
import com.baidu.android.imrtc.notify.BIMKickResSyncRtcInfo;
import com.baidu.android.imrtc.utils.RtcConstants;
/* loaded from: classes8.dex */
public interface BIMRtcListener {
    void fetchRoomSignal(boolean z, BIMRtcInfo bIMRtcInfo);

    void fetchRoomState(boolean z, BIMRtcInfo bIMRtcInfo);

    void onRtcResult(int i2, BIMRtcInfo bIMRtcInfo);

    void roomCalleeAnswerByFromOtherCallee(int i2, BIMRtcInfo bIMRtcInfo);

    void roomCalleeAnswerTimeOutFromMyself(BIMRtcInfo bIMRtcInfo);

    void roomCalleeInviteCancelFromCaller(BIMRtcInfo bIMRtcInfo);

    void roomCalleeInviteFromCaller(BIMRtcInfo bIMRtcInfo);

    void roomCallerGetAnswerSyncByCallee(int i2, BIMRtcInfo bIMRtcInfo);

    void roomCallerInviteTimeoutByCallee(BIMRtcInfo bIMRtcInfo);

    void roomEventByMySelf(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo);

    void roomEventKickedStatusByKickedUser(BIMKickResSyncRtcInfo bIMKickResSyncRtcInfo);

    void roomEventSyncByOthers(RtcConstants.RoomEventType roomEventType, BIMRtcInfo bIMRtcInfo);

    int roomKickedUserFromKickerSync(BIMKickReqSyncRtcInfo bIMKickReqSyncRtcInfo);
}
