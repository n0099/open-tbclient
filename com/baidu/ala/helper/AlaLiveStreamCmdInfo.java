package com.baidu.ala.helper;

import android.app.Activity;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ala.adp.lib.util.BdNetTypeUtil;
import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.ala.tbadk.core.TbadkCoreApplicationProxy;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
/* loaded from: classes6.dex */
public class AlaLiveStreamCmdInfo {
    private static final int ALA_LIVE_TYPE_CAMERA_LANDSCAPE = 2;
    private static final int ALA_LIVE_TYPE_CAMERA_PORTRAIT = 1;
    private static final int ALA_LIVE_TYPE_SCREEN_LANDSCAPE = 5;
    private static final int ALA_LIVE_TYPE_SCREEN_PORTRAIT = 4;
    public static final int SEND_CMD_HOST_STATUS = 2;
    public static final int SEND_CMD_TIMESTAMP = 1;

    /* loaded from: classes6.dex */
    public static class CmdData {
        public String ip;
        public int mCurStreamLevel;
        public AlaLiveDebugInfo mDebugInfo;
        public boolean mGameHardEncode;
        public boolean mHasAudio;
        public boolean mHasVideo;
        public boolean mIsBackground;
        public boolean mIsDeviceRun;
        public VideoRecorderType type;
    }

    /* loaded from: classes6.dex */
    public interface CmdParseCallback {
        Message getMessage();

        void onResult(CmdParseResult cmdParseResult);

        void sendMessage(Message message);
    }

    /* loaded from: classes6.dex */
    public static class CmdParseResult {
        public int appStatus;
        public boolean isCalling;
        public boolean isConnect;
        public int isDrop;
        public boolean isHardEncode;
        public int netType;
        public String phoneModel;
        public int platformType;
        public int recordType;
        public int sessionLine;
        public String streamIp;
        public int streamLevel;
        public String streamSpeed;
        public int streamStatus;
    }

    public static void parseStreamCmd(int i, String str, CmdParseCallback cmdParseCallback) {
        int i2 = 0;
        if (!TextUtils.isEmpty(str) && cmdParseCallback != null) {
            try {
                String[] split = str.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
                while (split != null) {
                    if (i2 < split.length) {
                        String[] split2 = split[i2].split("\\^");
                        if (split2.length > 2) {
                            int parseInt = Integer.parseInt(split2[0]);
                            if (parseInt == 1) {
                                long parseLong = Long.parseLong(split2[1]);
                                if (cmdParseCallback != null) {
                                    Message message = cmdParseCallback.getMessage();
                                    message.what = 3;
                                    message.obj = Integer.valueOf(i);
                                    message.arg1 = (int) (System.currentTimeMillis() - parseLong);
                                    message.arg2 = Integer.parseInt(split2[2]);
                                    cmdParseCallback.sendMessage(message);
                                }
                            } else if (parseInt == 2) {
                                if (split2.length >= 5) {
                                    CmdParseResult cmdParseResult = new CmdParseResult();
                                    fillByStatus(cmdParseResult, split2[1], split2[2], split2[4], split2[3]);
                                    if (cmdParseCallback != null) {
                                        cmdParseCallback.onResult(cmdParseResult);
                                    }
                                }
                            }
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static String genCmd(Activity activity, CmdData cmdData) {
        int i;
        String str = "1^" + System.currentTimeMillis() + "^2";
        int i2 = (((cmdData.mHasAudio ? 0 : 2) | (cmdData.mHasVideo ? 0 : 1)) << 28) | 0 | 33554432;
        if (cmdData.type == VideoRecorderType.SCREEN && cmdData.mGameHardEncode) {
            i2 |= 134217728;
        }
        int netType = i2 | (BdNetTypeUtil.netType() << 20) | 65536 | (cmdData.mCurStreamLevel << 12);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            netType |= 2048;
        }
        if (TbadkCoreApplicationProxy.getInst().getIsPhoneCalling()) {
            netType |= 1024;
        }
        if (cmdData.mIsBackground) {
            netType |= 512;
        } else if (!cmdData.mIsDeviceRun) {
            netType |= 256;
        }
        if (cmdData.type == VideoRecorderType.SCREEN) {
            if (activity != null && activity.getRequestedOrientation() == 0) {
                i = netType | 80;
            } else {
                i = netType | 64;
            }
        } else {
            i = netType | 16;
        }
        int i3 = i | ((cmdData.mDebugInfo.currentDropA > 0 ? 4 : 0) + (cmdData.mDebugInfo.currentDropI > 0 ? 2 : 0) + (cmdData.mDebugInfo.currentDropP > 0 ? 1 : 0));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(2);
        stringBuffer.append("^");
        stringBuffer.append(new String(new byte[]{(byte) (((-16777216) & i3) >> 24), (byte) ((16711680 & i3) >> 16), (byte) ((65280 & i3) >> 8), (byte) (i3 & 255)}));
        stringBuffer.append("^");
        stringBuffer.append(cmdData.ip);
        stringBuffer.append("^");
        long j = cmdData.mDebugInfo.currentBandWidth / 1024;
        if (cmdData.mDebugInfo.monitorInterval <= 0) {
            stringBuffer.append(0);
        } else {
            stringBuffer.append(j / cmdData.mDebugInfo.monitorInterval);
        }
        return str + "|" + stringBuffer.toString() + "^" + Build.MODEL;
    }

    private static void fillByStatus(CmdParseResult cmdParseResult, String str, String str2, String str3, String str4) {
        byte[] bytes;
        cmdParseResult.streamIp = str2;
        cmdParseResult.streamSpeed = str4;
        cmdParseResult.phoneModel = str3;
        if (!TextUtils.isEmpty(str) && (bytes = str.getBytes()) != null && bytes.length >= 4) {
            cmdParseResult.platformType = bytes[0] & 7;
            cmdParseResult.isHardEncode = (bytes[0] & 8) != 0;
            cmdParseResult.streamStatus = bytes[0] & 240;
            cmdParseResult.netType = (bytes[1] & 240) >> 4;
            cmdParseResult.sessionLine = bytes[1] & 15;
            cmdParseResult.streamLevel = (bytes[2] & 240) >> 4;
            cmdParseResult.isConnect = (bytes[2] & 8) != 0;
            cmdParseResult.isCalling = (bytes[2] & 4) != 0;
            cmdParseResult.appStatus = bytes[2] & 3;
            cmdParseResult.recordType = (bytes[3] & 240) >> 4;
            cmdParseResult.isDrop = bytes[3] & 15;
        }
    }
}
