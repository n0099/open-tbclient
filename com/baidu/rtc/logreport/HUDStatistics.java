package com.baidu.rtc.logreport;

import android.util.Log;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
/* loaded from: classes2.dex */
public class HUDStatistics {
    public static int mLastCpuCoreCount = -1;
    public long firstFrameTime;
    public String mActualEncBitrate;
    public String mAudioCurrentDelay;
    public String mAudioExpandRate;
    public String mAudioRecvBitrate;
    public String mAudioRecvCodec;
    public String mAudioSendBitrate;
    public String mAudioSendCodec;
    public String mAvailableRevBW;
    public String mAvailableSendBW;
    public String mConnRecvBitrate;
    public String mConnRtt;
    public String mConnSendBitrate;
    public String mEndToEndTime;
    public String mLocalCandType;
    public int mOldFrameEncoded;
    public int mOldVideoQPSum;
    public String mRemoteCandType;
    public String mTargetEncBitrate;
    public String mTransPortType;
    public String mVideoDecodFps;
    public String mVideoDecodeMs;
    public String mVideoEncodeMs;
    public String mVideoInputFps;
    public String mVideoInputHeight;
    public String mVideoInputWidth;
    public String mVideoOutputFps;
    public String mVideoPacketSend;
    public String mVideoRecvBitrate;
    public String mVideoRecvFps;
    public String mVideoRecvHeight;
    public String mVideoRecvWidth;
    public String mVideoSendBitrate;
    public String mVideoSendCodec;
    public String mVideoSendFps;
    public String mVideoSendHeight;
    public String mVideoSendPacketLost;
    public String mVideoSendWidth;
    public long requestSubscribeTime;
    public String mVideoRecvPacketLost = "0";
    public ArrayList<Long> audioStuckList = new ArrayList<>();
    public ArrayList<Long> videoStuckList = new ArrayList<>();
    public int mVideoQPSum = 0;
    public int mFrameEncoded = 0;
    public RTCBitrateTracker mAudioRecvBitrateTracker = new RTCBitrateTracker();
    public RTCBitrateTracker mAudioSendBitrateTracker = new RTCBitrateTracker();
    public RTCBitrateTracker mConnSendBitrateTradker = new RTCBitrateTracker();
    public RTCBitrateTracker mConnRecvBitrateTracker = new RTCBitrateTracker();
    public RTCBitrateTracker mVideoRecvBitrateTracker = new RTCBitrateTracker();
    public RTCBitrateTracker mVideoSendBitrateTracker = new RTCBitrateTracker();

    private int calculateAvgQP() {
        int i = this.mFrameEncoded - this.mOldFrameEncoded;
        int i2 = this.mVideoQPSum;
        int i3 = this.mOldVideoQPSum;
        if (i != 0) {
            return (i2 - i3) / i;
        }
        return 0;
    }

    private Map<String, String> getReportMap(StatsReport statsReport) {
        StatsReport.Value[] valueArr;
        HashMap hashMap = new HashMap();
        for (StatsReport.Value value : statsReport.values) {
            hashMap.put(value.name, value.value);
        }
        return hashMap;
    }

    private void parseAudioRecvStatsReport(Map<String, String> map) {
        try {
            this.mAudioRecvBitrateTracker.updataBitrateWidhCurrentByteCount(Integer.parseInt(map.get("bytesReceived")));
            this.mAudioRecvBitrate = this.mAudioRecvBitrateTracker.bitRateString();
        } catch (NumberFormatException e2) {
            Log.e("HUDStatistic", "parseAudioRecvStatsReport" + e2);
        }
        this.mAudioCurrentDelay = map.get("googCurrentDelayMs");
        this.mAudioRecvCodec = map.get("googCodecName");
        this.mAudioExpandRate = map.get("googSpeechExpandRate");
    }

    private void parseAudioSendStatsReport(Map<String, String> map) {
        try {
            this.mAudioSendBitrateTracker.updataBitrateWidhCurrentByteCount(Long.parseLong(map.get("bytesSent")));
            this.mAudioSendBitrate = this.mAudioSendBitrateTracker.bitRateString();
        } catch (NumberFormatException unused) {
        }
        this.mAudioSendCodec = map.get("googCodecName");
    }

    private void parseBweStatsReport(Map<String, String> map) {
        try {
            this.mTargetEncBitrate = RTCBitrateTracker.bitrateStringForBitrate(Double.parseDouble(map.get("googTargetEncBitrate")));
            this.mActualEncBitrate = RTCBitrateTracker.bitrateStringForBitrate(Double.parseDouble(map.get("googActualEncBitrate")));
            this.mAvailableSendBW = RTCBitrateTracker.bitrateStringForBitrate(Double.parseDouble(map.get("googAvailableSendBandwidth")));
            this.mAvailableRevBW = RTCBitrateTracker.bitrateStringForBitrate(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
        } catch (NumberFormatException e2) {
            Log.e("HUDStatistics", "parseBweStatsReport: " + e2);
        }
    }

    private void parseConnectionStatsReport(Map<String, String> map) {
        String str;
        String str2 = map.get("googActiveConnection");
        if (str2 == null || !str2.equals("true")) {
            return;
        }
        try {
            this.mConnRecvBitrateTracker.updataBitrateWidhCurrentByteCount(Long.parseLong(map.get("bytesReceived")));
            this.mConnRecvBitrate = this.mConnRecvBitrateTracker.bitRateString();
            this.mConnSendBitrateTradker.updataBitrateWidhCurrentByteCount(Long.parseLong(map.get("bytesSent")));
            this.mConnSendBitrate = this.mConnSendBitrateTradker.bitRateString();
        } catch (NumberFormatException e2) {
            Log.e("HUDStatistics", "parseConnectionStatsReport" + e2);
        }
        this.mConnRtt = map.get("googRtt");
        this.mLocalCandType = map.get("googLocalCandidateType");
        this.mRemoteCandType = map.get("googRemoteCandidateType");
        this.mTransPortType = map.get("googTransportType");
        if (!map.containsKey("googLocalAddress") || (str = map.get("googLocalAddress").split(":")[0]) == null) {
            return;
        }
        ErrorInfoReport.getInstance().setClientIp(str);
    }

    private void parseVideoRecvStatsReport(Map<String, String> map) {
        this.mVideoDecodeMs = map.get("googDecodeMs");
        this.mVideoDecodFps = map.get("googFrameRateDecoded");
        this.mVideoOutputFps = map.get("googFrameRateOutput");
        this.mVideoRecvFps = map.get("googFrameRateReceived");
        this.mVideoRecvBitrateTracker.updataBitrateWidhCurrentByteCount(Long.parseLong(map.get("bytesReceived")));
        this.mVideoRecvBitrate = this.mVideoRecvBitrateTracker.bitRateString();
        this.mVideoRecvHeight = map.get("googFrameHeightReceived");
        this.mVideoRecvWidth = map.get("googFrameWidthReceived");
        if (map.containsKey("googEndToEndTime")) {
            this.mEndToEndTime = map.get("googEndToEndTime");
        }
    }

    private void parseVideoSendStatsReport(Map<String, String> map) {
        this.mVideoEncodeMs = map.get("googAvgEncodeMs");
        this.mVideoInputFps = map.get("googFrameRateInput");
        this.mVideoInputHeight = map.get("googFrameHeightInput");
        this.mVideoInputWidth = map.get("googFrameWidthInput");
        this.mVideoSendFps = map.get("googFrameRateSent");
        this.mVideoSendCodec = map.get("googCodecName");
        this.mVideoSendWidth = map.get("googFrameWidthSent");
        this.mVideoSendHeight = map.get("googFrameHeightSent");
        this.mVideoSendPacketLost = map.get("packetsLost");
        this.mVideoPacketSend = map.get("packetsSent");
        try {
            String str = map.get("bytesSent");
            if (str != null) {
                this.mVideoSendBitrateTracker.updataBitrateWidhCurrentByteCount(Integer.parseInt(str));
            }
            this.mVideoSendBitrate = this.mVideoSendBitrateTracker.bitRateString();
            this.mOldVideoQPSum = this.mVideoQPSum;
            String str2 = map.get("qpSum");
            if (str2 != null) {
                this.mVideoQPSum = Integer.parseInt(str2);
            }
            this.mOldFrameEncoded = this.mFrameEncoded;
            String str3 = map.get("framesEncoded");
            if (str3 != null) {
                this.mFrameEncoded = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e2) {
            Log.e("HUDStatistic", "parseVideoSendStatsReport: " + e2);
        }
    }

    public void addAudioStuckData(long j, long j2) {
        this.audioStuckList.add(Long.valueOf(j2 - j));
    }

    public void addVideoStuckData(long j, long j2) {
        this.videoStuckList.add(Long.valueOf(j2 - j));
    }

    public void clearSLIStuckData() {
        this.audioStuckList.clear();
        this.videoStuckList.clear();
    }

    public int getEndTOEndTime() {
        try {
            if (this.mEndToEndTime != null && this.mEndToEndTime != "") {
                return Integer.valueOf(this.mEndToEndTime).intValue();
            }
            return -1;
        } catch (NumberFormatException unused) {
            Log.e("HUDStatistics", "getEndTOEndTime error format :" + this.mEndToEndTime);
            return -1;
        }
    }

    public long getFirstFrameTime() {
        return this.firstFrameTime;
    }

    public String getRecvResolution() {
        return this.mVideoRecvWidth + "*" + this.mVideoRecvHeight;
    }

    public long getRequestSubscribeTime() {
        return this.requestSubscribeTime;
    }

    public String getSendResolution() {
        return this.mVideoSendWidth + "*" + this.mVideoSendHeight;
    }

    public void getSlIStuckData(Map<String, ArrayList<Long>> map) {
        map.put("aStuck", this.audioStuckList);
        map.put("vStuck", this.videoStuckList);
    }

    public void getStatsRecvInfo(Map<String, Integer> map) {
        String str = this.mVideoRecvBitrate;
        if (str == null || this.mVideoRecvPacketLost == null || this.mVideoRecvFps == null || map == null) {
            Log.e("HUDStatistics", "getStatsRecvInfo null");
            return;
        }
        map.put("bitrate_r", Integer.valueOf(RTCBitrateTracker.bitrateToString(str) / 1000));
        map.put("packetloss_r", Integer.valueOf(this.mVideoRecvPacketLost));
        map.put("fps_r", Integer.valueOf(this.mVideoRecvFps));
    }

    public void getStatsSendInfo(Map<String, Integer> map) {
        String str = this.mVideoSendBitrate;
        if (str == null || this.mVideoSendFps == null || this.mVideoInputFps == null || this.mVideoSendHeight == null || map == null) {
            Log.e("HUDStatistics", "getStatsSendInfo null");
            return;
        }
        map.put("bitrate_s", Integer.valueOf(RTCBitrateTracker.bitrateToString(str) / 1000));
        try {
            Long l = new Long(0L);
            if (Long.parseLong(this.mVideoPacketSend) != 0) {
                l = Long.valueOf((Long.parseLong(this.mVideoSendPacketLost) * 1000) / Long.parseLong(this.mVideoPacketSend));
            }
            map.put("packetlost", Integer.valueOf(Integer.parseInt(this.mVideoSendPacketLost)));
            map.put("packesend", Integer.valueOf(Integer.parseInt(this.mVideoPacketSend)));
            map.put("packetloss_s", Integer.valueOf(l.intValue()));
            map.put("fps_s", Integer.valueOf(this.mVideoSendFps));
            map.put("fps_i", Integer.valueOf(this.mVideoInputFps));
        } catch (NumberFormatException e2) {
            Log.e("HUDStatistics", "getStatsSendInfo: " + e2);
        }
    }

    public void setFirstFrameTime(long j) {
        this.firstFrameTime = j;
    }

    public void setRequestSubscribeTime(long j) {
        this.requestSubscribeTime = j;
    }

    public String statsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("延迟:");
        sb.append(this.mConnRtt);
        sb.append("ms  |  ");
        sb.append(this.mLocalCandType);
        sb.append("->");
        sb.append(this.mRemoteCandType);
        sb.append("/");
        sb.append(this.mTransPortType);
        sb.append("  |  (s)");
        sb.append(this.mConnSendBitrate);
        sb.append("  |  (r)");
        sb.append(this.mConnRecvBitrate);
        sb.append("\n");
        int calculateAvgQP = calculateAvgQP();
        sb.append("视频采集:");
        sb.append(this.mVideoInputWidth);
        sb.append("x");
        sb.append(this.mVideoInputHeight);
        sb.append("@");
        sb.append(this.mVideoInputFps);
        sb.append("fps  |  (send) ");
        sb.append(this.mVideoSendWidth);
        sb.append("X");
        sb.append(this.mVideoSendHeight);
        sb.append("@");
        sb.append(this.mVideoSendFps);
        sb.append("fps\n");
        sb.append("视频编码: ");
        sb.append(this.mActualEncBitrate);
        sb.append("/");
        sb.append(this.mTargetEncBitrate);
        sb.append("  |  (send) ");
        sb.append(this.mVideoSendBitrate);
        sb.append("/");
        sb.append(this.mAvailableSendBW);
        sb.append(ThreadCardUtils.TAB_NAME_SPLIT_STRING);
        sb.append(this.mVideoEncodeMs);
        sb.append("ms  |  ");
        sb.append(this.mVideoSendCodec);
        sb.append("\n");
        sb.append("AvgQP (past ");
        sb.append(this.mFrameEncoded);
        sb.append(" encoded frames) = ");
        sb.append(calculateAvgQP);
        sb.append("\n");
        sb.append("视频接收：");
        sb.append(this.mVideoRecvWidth);
        sb.append("X");
        sb.append(this.mVideoRecvHeight);
        sb.append("@");
        sb.append(this.mVideoRecvFps);
        sb.append("fps  |  (deocded)");
        sb.append(this.mVideoDecodFps);
        sb.append("  |  (output)");
        sb.append(this.mVideoOutputFps);
        sb.append("fps  |  ");
        sb.append(this.mVideoRecvBitrate);
        sb.append("/");
        sb.append(this.mAvailableRevBW);
        sb.append(ThreadCardUtils.TAB_NAME_SPLIT_STRING);
        sb.append(this.mVideoDecodeMs);
        sb.append("ms\n");
        sb.append("音频输出：");
        sb.append(this.mAudioSendBitrate);
        sb.append(" | ");
        sb.append(this.mAudioSendCodec);
        sb.append("\n");
        sb.append("音频接收：");
        sb.append(this.mAudioRecvBitrate);
        sb.append(" | ");
        sb.append(this.mAudioRecvCodec);
        sb.append(" | ");
        sb.append(this.mAudioCurrentDelay);
        sb.append("ms | (expandrate)");
        sb.append(this.mAudioExpandRate);
        sb.append("\n");
        return sb.toString();
    }

    public void updateEncoderStatistics(StatsReport[] statsReportArr) {
        Map<String, String> reportMap;
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains("send")) {
                Map<String, String> reportMap2 = getReportMap(statsReport);
                String str = reportMap2.get("googTrackId");
                if (str != null && str.contains(PeerConnectionClient.VIDEO_TRACK_ID)) {
                    parseVideoSendStatsReport(reportMap2);
                } else if (str != null && str.contains(PeerConnectionClient.AUDIO_TRACK_ID)) {
                    parseAudioSendStatsReport(reportMap2);
                }
            } else if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains("recv")) {
                Map<String, String> reportMap3 = getReportMap(statsReport);
                if (reportMap3.get("googFrameWidthReceived") != null) {
                    parseVideoRecvStatsReport(reportMap3);
                }
                if (reportMap3.get("audioOutputLevel") != null) {
                    parseAudioRecvStatsReport(reportMap3);
                }
            } else if (statsReport.id.equals("bweforvideo")) {
                Map<String, String> reportMap4 = getReportMap(statsReport);
                if (reportMap4.size() > 3) {
                    parseBweStatsReport(reportMap4);
                }
            } else if (statsReport.type.equals("googCandidatePair") && (reportMap = getReportMap(statsReport)) != null) {
                parseConnectionStatsReport(reportMap);
            }
        }
    }
}
