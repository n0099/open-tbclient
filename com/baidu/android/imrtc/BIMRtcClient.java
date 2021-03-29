package com.baidu.android.imrtc;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imrtc.msg.BIMRtcListener;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCancelRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.send.BIMKickRequestRtcInfo;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.android.imrtc.utils.RtcConstants;
/* loaded from: classes.dex */
public class BIMRtcClient {
    public static void answer(@NonNull Context context, @NonNull BIMAnswerRtcInfo bIMAnswerRtcInfo, IStatusListener iStatusListener) {
        BIMRtcManager.getInstance(context).answer(bIMAnswerRtcInfo, iStatusListener);
    }

    public static void cancelCall(@NonNull Context context, @NonNull BIMCancelRtcInfo bIMCancelRtcInfo, IStatusListener iStatusListener) {
        BIMRtcManager.getInstance(context).cancelCall(bIMCancelRtcInfo, iStatusListener);
    }

    public static void closeRoom(@NonNull Context context, @NonNull BIMCloseRoomRtcInfo bIMCloseRoomRtcInfo, IStatusListener iStatusListener) {
        BIMRtcManager.getInstance(context).closeRoom(bIMCloseRoomRtcInfo, iStatusListener);
    }

    public static void createRoom(@NonNull Context context, String str, @NonNull BIMRtcTokenListener bIMRtcTokenListener) {
        BIMRtcManager.getInstance(context).createRoom(str, bIMRtcTokenListener);
    }

    public static void generateToken(@NonNull Context context, String str, String str2, long j, @NonNull BIMRtcTokenListener bIMRtcTokenListener) {
        BIMRtcManager.getInstance(context).generateToken(str, str2, j, bIMRtcTokenListener);
    }

    public static void hangout(@NonNull Context context, @NonNull String str, IStatusListener iStatusListener) {
        BIMRtcManager.getInstance(context).hangout(str, iStatusListener);
    }

    public static void invite(@NonNull Context context, @NonNull BIMInviteRtcInfo bIMInviteRtcInfo, IStatusListener iStatusListener) {
        BIMRtcManager.getInstance(context).invite(bIMInviteRtcInfo, iStatusListener);
    }

    public static void join(@NonNull Context context, @NonNull String str, IStatusListener iStatusListener) {
        BIMRtcManager.getInstance(context).join(str, iStatusListener);
    }

    public static void kickoff(Context context, @NonNull BIMKickRequestRtcInfo bIMKickRequestRtcInfo, IStatusListener iStatusListener) {
        BIMRtcManager.getInstance(context).kickoff(bIMKickRequestRtcInfo, iStatusListener);
    }

    public static void registerRtcListener(@NonNull Context context, @NonNull BIMRtcListener bIMRtcListener) {
        BIMRtcManager.getInstance(context).registerRtcListener(bIMRtcListener);
    }

    public static String report(Context context) {
        return BIMRtcManager.getInstance(context).report();
    }

    public static void setRtcDebugAndLogEnable(@NonNull Context context, boolean z, boolean z2) {
        BIMRtcManager.getInstance(context).setRtcDebugEnv(context, z);
        RtcConstants.LOG_DEBUG = z2;
    }

    public static void unRegisterRtcListener(@NonNull Context context, @NonNull BIMRtcListener bIMRtcListener) {
        BIMRtcManager.getInstance(context).unRegisterRtcListener(bIMRtcListener);
    }

    public static void hangout(@NonNull Context context, @NonNull BIMRtcInfo bIMRtcInfo, IStatusListener iStatusListener) {
        BIMRtcManager.getInstance(context).hangout(bIMRtcInfo, iStatusListener);
    }
}
