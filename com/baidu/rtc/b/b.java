package com.baidu.rtc.b;

import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
/* loaded from: classes10.dex */
public class b {
    private int cBA;
    private String cBB;
    private String cBC;
    private String cBD;
    private String cBE;
    private String cBF;
    private String cBG;
    private String cBH;
    private String cBI;
    private String cBJ;
    private String cBK;
    private String cBL;
    private String cBN;
    private String cBP;
    private String cBQ;
    private String cBS;
    private String cBT;
    private String cBV;
    private String cBW;
    private String cBX;
    private String cBY;
    private String cBZ;
    private String cBh;
    private String cBi;
    private String cBj;
    private String cBk;
    private String cBm;
    private String cBn;
    private String cBp;
    private String cBq;
    private String cBr;
    private String cBs;
    private String cBu;
    private String cBv;
    private String cBy;
    private int cBz;
    private String cBR = "0";
    private int cBM = 0;
    private int cBx = 0;
    c cBl = new c();
    c cBo = new c();
    c cBw = new c();
    c cBt = new c();
    c cBO = new c();
    c cBU = new c();

    private Map<String, String> a(StatsReport statsReport) {
        StatsReport.Value[] valueArr;
        HashMap hashMap = new HashMap();
        for (StatsReport.Value value : statsReport.values) {
            hashMap.put(value.name, value.value);
        }
        return hashMap;
    }

    private void o(Map<String, String> map) {
        try {
            this.cBl.bQ(Integer.parseInt(map.get("bytesReceived")));
            this.cBk = this.cBl.aiN();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseAudioRecvStatsReport" + e);
        }
        this.cBi = map.get("googCurrentDelayMs");
        this.cBm = map.get("googCodecName");
        this.cBj = map.get("googSpeechExpandRate");
    }

    private void p(Map<String, String> map) {
        try {
            this.cBo.bQ(Long.parseLong(map.get("bytesSent")));
            this.cBn = this.cBo.aiN();
        } catch (NumberFormatException e) {
        }
        this.cBp = map.get("googCodecName");
    }

    private void q(Map<String, String> map) {
        try {
            this.cBC = c.s(Double.parseDouble(map.get("googTargetEncBitrate")));
            this.cBh = c.s(Double.parseDouble(map.get("googActualEncBitrate")));
            this.cBr = c.s(Double.parseDouble(map.get("googAvailableSendBandwidth")));
            this.cBq = c.s(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseBweStatsReport: " + e);
        }
    }

    private void r(Map<String, String> map) {
        String str = map.get("googActiveConnection");
        if (str == null || !str.equals("true")) {
            return;
        }
        try {
            this.cBt.bQ(Long.parseLong(map.get("bytesReceived")));
            this.cBs = this.cBt.aiN();
            this.cBw.bQ(Long.parseLong(map.get("bytesSent")));
            this.cBv = this.cBw.aiN();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseConnectionStatsReport" + e);
        }
        this.cBu = map.get("googRtt");
        this.cBy = map.get("googLocalCandidateType");
        this.cBB = map.get("googRemoteCandidateType");
        this.cBD = map.get("googTransportType");
    }

    private void s(Map<String, String> map) {
        this.cBF = map.get("googDecodeMs");
        this.cBE = map.get("googFrameRateDecoded");
        this.cBK = map.get("googFrameRateOutput");
        this.cBP = map.get("googFrameRateReceived");
        this.cBO.bQ(Long.parseLong(map.get("bytesReceived")));
        this.cBN = this.cBO.aiN();
        this.cBQ = map.get("googFrameHeightReceived");
        this.cBS = map.get("googFrameWidthReceived");
    }

    private void t(Map<String, String> map) {
        this.cBG = map.get("googAvgEncodeMs");
        this.cBH = map.get("googFrameRateInput");
        this.cBI = map.get("googFrameHeightInput");
        this.cBJ = map.get("googFrameWidthInput");
        this.cBW = map.get("googFrameRateSent");
        this.cBV = map.get("googCodecName");
        this.cBZ = map.get("googFrameWidthSent");
        this.cBX = map.get("googFrameHeightSent");
        this.cBY = map.get("packetsLost");
        this.cBL = map.get("packetsSent");
        try {
            String str = map.get("bytesSent");
            if (str != null) {
                this.cBU.bQ(Integer.parseInt(str));
            }
            this.cBT = this.cBU.aiN();
            this.cBA = this.cBM;
            String str2 = map.get("qpSum");
            if (str2 != null) {
                this.cBM = Integer.parseInt(str2);
            }
            this.cBz = this.cBx;
            String str3 = map.get("framesEncoded");
            if (str3 != null) {
                this.cBx = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseVideoSendStatsReport: " + e);
        }
    }

    public String aiL() {
        return this.cBS + "*" + this.cBQ;
    }

    public String aiM() {
        return this.cBZ + "*" + this.cBX;
    }

    public void b(StatsReport[] statsReportArr) {
        Map<String, String> a2;
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains(UbcStatConstant.ContentType.UBC_TYPE_IM_SEND)) {
                Map<String, String> a3 = a(statsReport);
                String str = a3.get("googTrackId");
                if (str != null && str.contains("ARDAMSv0")) {
                    t(a3);
                } else if (str != null && str.contains("ARDAMSa0")) {
                    p(a3);
                }
            } else if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains("recv")) {
                Map<String, String> a4 = a(statsReport);
                if (a4.get("googFrameWidthReceived") != null) {
                    s(a4);
                }
                if (a4.get("audioOutputLevel") != null) {
                    o(a4);
                }
            } else if (statsReport.id.equals("bweforvideo")) {
                Map<String, String> a5 = a(statsReport);
                if (a5.size() > 3) {
                    q(a5);
                }
            } else if (statsReport.type.equals("googCandidatePair") && (a2 = a(statsReport)) != null) {
                r(a2);
            }
        }
    }

    public void u(Map<String, Integer> map) {
        if (this.cBN == null || this.cBR == null || this.cBP == null || map == null) {
            Log.e("HUDStatistics", "getStatsRecvInfo null");
            return;
        }
        map.put("bitrate_r", Integer.valueOf(c.ky(this.cBN) / 1000));
        map.put("packetloss_r", Integer.valueOf(this.cBR));
        map.put("fps_r", Integer.valueOf(this.cBP));
    }

    public void v(Map<String, Integer> map) {
        if (this.cBT == null || this.cBW == null || this.cBH == null || this.cBX == null || map == null) {
            Log.e("HUDStatistics", "getStatsSendInfo null");
            return;
        }
        map.put("bitrate_s", Integer.valueOf(c.ky(this.cBT) / 1000));
        try {
            Long l = new Long(0L);
            if (Long.parseLong(this.cBL) != 0) {
                l = Long.valueOf((Long.parseLong(this.cBY) * 1000) / Long.parseLong(this.cBL));
            }
            map.put("packetloss_s", Integer.valueOf(l.intValue()));
            map.put("fps_s", Integer.valueOf(this.cBW));
            map.put("fps_i", Integer.valueOf(this.cBH));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "getStatsSendInfo: " + e);
        }
    }
}
