package com.baidu.rtc.logreport;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.ReturnKeyType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.webrtc.StatsReport;
/* loaded from: classes10.dex */
public class HUDStatistics {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLAG_STATES_STREAMING_ALL = 31;
    public static final int FLAG_STATES_STREAMING_AV = 15;
    public static final int FLAG_STATES_STREAMING_CONNECTION = 16;
    public static final int FLAG_STATES_STREAMING_RECV_AUDIO = 1;
    public static final int FLAG_STATES_STREAMING_RECV_VIDEO = 2;
    public static final int FLAG_STATES_STREAMING_SEND_AUDIO = 4;
    public static final int FLAG_STATES_STREAMING_SEND_VIDEO = 8;
    public static int mLastCpuCoreCount = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Long> audioStuckList;
    public long firstFrameTime;
    public String mActualEncBitrate;
    public String mAudioCurrentDelay;
    public String mAudioExpandRate;
    public int mAudioJitterBufferMs;
    public String mAudioRecvBitrate;
    public RTCBitrateTracker mAudioRecvBitrateTracker;
    public String mAudioRecvCodec;
    public String mAudioSendBitrate;
    public RTCBitrateTracker mAudioSendBitrateTracker;
    public String mAudioSendCodec;
    public String mAvailableRevBW;
    public String mAvailableSendBW;
    public String mConnRecvBitrate;
    public RTCBitrateTracker mConnRecvBitrateTracker;
    public String mConnRtt;
    public String mConnSendBitrate;
    public RTCBitrateTracker mConnSendBitrateTradker;
    public String mEndToEndTime;
    public int mFrameEncoded;
    public boolean mHasAudio;
    public boolean mHasVideo;
    public String mLocalCandType;
    public int mOldFrameEncoded;
    public int mOldVideoQPSum;
    public String mRemoteCandType;
    public String mRemoteIp;
    public String mTargetEncBitrate;
    public String mTransPortType;
    public String mVideoDecodFps;
    public String mVideoDecodeMs;
    public String mVideoEncodeMs;
    public String mVideoInputFps;
    public String mVideoInputHeight;
    public String mVideoInputWidth;
    public String mVideoOutputFps;
    public String mVideoPacketRecv;
    public String mVideoPacketSend;
    public int mVideoQPSum;
    public String mVideoRecvBitrate;
    public RTCBitrateTracker mVideoRecvBitrateTracker;
    public String mVideoRecvFps;
    public String mVideoRecvHeight;
    public String mVideoRecvPacketLost;
    public int mVideoRecvPacketLostRatio;
    public String mVideoRecvWidth;
    public String mVideoSendBitrate;
    public RTCBitrateTracker mVideoSendBitrateTracker;
    public String mVideoSendCodec;
    public String mVideoSendFps;
    public String mVideoSendHeight;
    public String mVideoSendPacketLost;
    public String mVideoSendWidth;
    public long requestSubscribeTime;
    public ArrayList<Long> videoStuckList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1360756116, "Lcom/baidu/rtc/logreport/HUDStatistics;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1360756116, "Lcom/baidu/rtc/logreport/HUDStatistics;");
        }
    }

    public HUDStatistics() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mVideoRecvPacketLost = "0";
        this.audioStuckList = new ArrayList<>();
        this.videoStuckList = new ArrayList<>();
        this.mVideoQPSum = 0;
        this.mFrameEncoded = 0;
        this.mAudioRecvBitrateTracker = new RTCBitrateTracker();
        this.mAudioSendBitrateTracker = new RTCBitrateTracker();
        this.mConnSendBitrateTradker = new RTCBitrateTracker();
        this.mConnRecvBitrateTracker = new RTCBitrateTracker();
        this.mVideoRecvBitrateTracker = new RTCBitrateTracker();
        this.mVideoSendBitrateTracker = new RTCBitrateTracker();
        this.mHasVideo = false;
        this.mHasAudio = false;
    }

    private int calculateAvgQP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int i2 = this.mFrameEncoded - this.mOldFrameEncoded;
            int i3 = this.mVideoQPSum - this.mOldVideoQPSum;
            if (i2 != 0) {
                return i3 / i2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private Map<String, String> getReportMap(StatsReport statsReport) {
        InterceptResult invokeL;
        StatsReport.Value[] valueArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, statsReport)) == null) {
            HashMap hashMap = new HashMap();
            for (StatsReport.Value value : statsReport.values) {
                hashMap.put(value.name, value.value);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    private void parseAudioRecvStatsReport(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, map) == null) {
            try {
                this.mAudioRecvBitrateTracker.updataBitrateWidhCurrentByteCount(Integer.parseInt(map.get("bytesReceived")));
                this.mAudioRecvBitrate = this.mAudioRecvBitrateTracker.bitRateString();
                String str = map.get("googJitterBufferMs");
                if (!TextUtils.isEmpty(str)) {
                    this.mAudioJitterBufferMs = Integer.valueOf(str).intValue();
                }
            } catch (NumberFormatException e2) {
                String str2 = "parseAudioRecvStatsReport" + e2;
            }
            this.mAudioCurrentDelay = map.get("googCurrentDelayMs");
            this.mAudioRecvCodec = map.get("googCodecName");
            this.mAudioExpandRate = map.get("googSpeechExpandRate");
        }
    }

    private void parseAudioSendStatsReport(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, map) == null) {
            try {
                this.mAudioSendBitrateTracker.updataBitrateWidhCurrentByteCount(Long.parseLong(map.get("bytesSent")));
                this.mAudioSendBitrate = this.mAudioSendBitrateTracker.bitRateString();
            } catch (NumberFormatException unused) {
            }
            this.mAudioSendCodec = map.get("googCodecName");
        }
    }

    private void parseBweStatsReport(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, map) == null) {
            try {
                this.mTargetEncBitrate = RTCBitrateTracker.bitrateStringForBitrate(Double.parseDouble(map.get("googTargetEncBitrate")));
                this.mActualEncBitrate = RTCBitrateTracker.bitrateStringForBitrate(Double.parseDouble(map.get("googActualEncBitrate")));
                this.mAvailableSendBW = RTCBitrateTracker.bitrateStringForBitrate(Double.parseDouble(map.get("googAvailableSendBandwidth")));
                this.mAvailableRevBW = RTCBitrateTracker.bitrateStringForBitrate(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
            } catch (NumberFormatException e2) {
                String str = "parseBweStatsReport: " + e2;
            }
        }
    }

    private void parseConnectionStatsReport(Map<String, String> map) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, map) == null) && (str = map.get("googActiveConnection")) != null && str.equals("true")) {
            try {
                this.mConnRecvBitrateTracker.updataBitrateWidhCurrentByteCount(Long.parseLong(map.get("bytesReceived")));
                this.mConnRecvBitrate = this.mConnRecvBitrateTracker.bitRateString();
                this.mConnSendBitrateTradker.updataBitrateWidhCurrentByteCount(Long.parseLong(map.get("bytesSent")));
                this.mConnSendBitrate = this.mConnSendBitrateTradker.bitRateString();
            } catch (NumberFormatException e2) {
                String str3 = "parseConnectionStatsReport" + e2;
            }
            this.mConnRtt = map.get("googRtt");
            this.mLocalCandType = map.get("googLocalCandidateType");
            this.mRemoteCandType = map.get("googRemoteCandidateType");
            this.mTransPortType = map.get("googTransportType");
            if (map.containsKey("googLocalAddress") && (str2 = map.get("googLocalAddress").split(":")[0]) != null) {
                ErrorInfoReport.getInstance().setClientIp(str2);
            }
            if (map.containsKey("googRemoteAddress")) {
                String str4 = map.get("googRemoteAddress").split(":")[0];
                this.mRemoteIp = str4;
                if (str4 != null) {
                    ErrorInfoReport.getInstance().setRemoteIp(this.mRemoteIp);
                }
            }
        }
    }

    private void parseVideoRecvStatsReport(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, map) == null) {
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
            this.mVideoRecvPacketLost = map.get("packetsLost");
            this.mVideoPacketRecv = map.get("packetsReceived");
        }
    }

    private void parseVideoSendStatsReport(Map<String, String> map) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, map) == null) {
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
                if (map.get("bytesSent") != null) {
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
                String str4 = "parseVideoSendStatsReport: " + e2;
            }
        }
    }

    public void addAudioStuckData(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.audioStuckList.add(Long.valueOf(j3 - j2));
        }
    }

    public void addVideoStuckData(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.videoStuckList.add(Long.valueOf(j3 - j2));
        }
    }

    public void clearSLIStuckData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.audioStuckList.clear();
            this.videoStuckList.clear();
        }
    }

    public RTCBitrateTracker getAudioRecvBitrateTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAudioRecvBitrateTracker : (RTCBitrateTracker) invokeV.objValue;
    }

    public int getEndTOEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (this.mEndToEndTime != null && this.mEndToEndTime != "") {
                    return Integer.valueOf(this.mEndToEndTime).intValue();
                }
                return -1;
            } catch (NumberFormatException unused) {
                String str = "getEndTOEndTime error format :" + this.mEndToEndTime;
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public long getFirstFrameTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.firstFrameTime : invokeV.longValue;
    }

    public String getRecvResolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mVideoRecvWidth + "*" + this.mVideoRecvHeight;
        }
        return (String) invokeV.objValue;
    }

    public long getRequestSubscribeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.requestSubscribeTime : invokeV.longValue;
    }

    public String getSendResolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mVideoSendWidth + "*" + this.mVideoSendHeight;
        }
        return (String) invokeV.objValue;
    }

    public void getSlIStuckData(Map<String, ArrayList<Long>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
            map.put("aStuck", this.audioStuckList);
            map.put("vStuck", this.videoStuckList);
        }
    }

    public void getStatsRecvInfo(Map<String, Integer> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, map) == null) || this.mVideoRecvBitrate == null || this.mVideoRecvPacketLost == null || this.mVideoRecvFps == null || map == null) {
            return;
        }
        try {
            new Long(0L);
            if (Long.parseLong(this.mVideoPacketRecv) != 0) {
                this.mVideoRecvPacketLostRatio = Long.valueOf((Long.parseLong(this.mVideoRecvPacketLost) * 1000) / Long.parseLong(this.mVideoPacketRecv)).intValue();
            }
            map.put("bitrate_r", Integer.valueOf(RTCBitrateTracker.bitrateToString(this.mVideoRecvBitrate) / 1000));
            map.put("packetlost", Integer.valueOf(Integer.parseInt(this.mVideoRecvPacketLost)));
            map.put("packetloss_r", Integer.valueOf(this.mVideoRecvPacketLostRatio));
            map.put("fps_r", Integer.valueOf(this.mVideoRecvFps));
        } catch (NumberFormatException e2) {
            String str = "getStatsRecvInfo: " + e2;
        }
    }

    public void getStatsSendInfo(Map<String, Integer> map) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, map) == null) || (str = this.mVideoSendBitrate) == null || this.mVideoSendFps == null || this.mVideoInputFps == null || this.mVideoSendHeight == null || map == null) {
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
            String str2 = "getStatsSendInfo: " + e2;
        }
    }

    public RTCBitrateTracker getVideoRecvBitrateTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mVideoRecvBitrateTracker : (RTCBitrateTracker) invokeV.objValue;
    }

    public boolean hasAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mHasAudio : invokeV.booleanValue;
    }

    public boolean hasVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mHasVideo : invokeV.booleanValue;
    }

    public void setFirstFrameTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            this.firstFrameTime = j2;
        }
    }

    public void setRequestSubscribeTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
            this.requestSubscribeTime = j2;
        }
    }

    public String statsString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            if ((i2 & 16) != 0) {
                sb.append("Delay: ");
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
                sb.append(" | remote ->");
                sb.append(this.mRemoteIp);
                sb.append(StringUtils.LF);
            }
            if ((i2 & 8) != 0) {
                int calculateAvgQP = calculateAvgQP();
                sb.append("VideoCap:");
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
                sb.append("VideoEnc: ");
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
                sb.append(StringUtils.LF);
                sb.append("AvgQP (past ");
                sb.append(this.mFrameEncoded);
                sb.append(" encoded frames) = ");
                sb.append(calculateAvgQP);
                sb.append(StringUtils.LF);
            }
            if ((i2 & 2) != 0) {
                sb.append("VideoRecv: ");
                sb.append(this.mVideoRecvWidth);
                sb.append("X");
                sb.append(this.mVideoRecvHeight);
                sb.append("@");
                sb.append(this.mVideoRecvFps);
                sb.append("fps  |  (deocded)");
                sb.append(this.mVideoDecodFps);
                sb.append("  |  (loss)");
                sb.append(this.mVideoRecvPacketLost);
                sb.append("  |  (lossratio)");
                sb.append(this.mVideoRecvPacketLostRatio);
                sb.append("permil |  (output)");
                sb.append(this.mVideoOutputFps);
                sb.append("fps  |  ");
                sb.append(this.mVideoRecvBitrate);
                sb.append("/");
                sb.append(this.mAvailableRevBW);
                sb.append(ThreadCardUtils.TAB_NAME_SPLIT_STRING);
                sb.append(this.mVideoDecodeMs);
                sb.append("ms\n");
            }
            if ((i2 & 4) != 0) {
                sb.append("AudioOutput: ");
                sb.append(this.mAudioSendBitrate);
                sb.append(" | ");
                sb.append(this.mAudioSendCodec);
                sb.append(StringUtils.LF);
            }
            if ((i2 & 1) != 0) {
                sb.append("AudioRecv: ");
                sb.append(this.mAudioRecvBitrate);
                sb.append(" | ");
                sb.append(this.mAudioRecvCodec);
                sb.append(" | (delay)");
                sb.append(this.mAudioCurrentDelay);
                sb.append("ms | (expandrate)");
                sb.append(this.mAudioExpandRate);
                sb.append("| (buffer)");
                sb.append(this.mAudioJitterBufferMs);
                sb.append("ms");
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public void updateEncoderStatistics(StatsReport[] statsReportArr) {
        Map<String, String> reportMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, statsReportArr) == null) {
            for (StatsReport statsReport : statsReportArr) {
                if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains(ReturnKeyType.SEND)) {
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
                        this.mHasVideo = true;
                    }
                    if (reportMap3.get("audioOutputLevel") != null) {
                        parseAudioRecvStatsReport(reportMap3);
                        this.mHasAudio = true;
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
}
