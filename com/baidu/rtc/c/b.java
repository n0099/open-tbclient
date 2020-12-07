package com.baidu.rtc.c;

import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
/* loaded from: classes12.dex */
public class b {
    private String cvY;
    private String cvZ;
    private String cwA;
    private String cwB;
    private String cwC;
    private String cwE;
    private String cwG;
    private String cwH;
    private String cwJ;
    private String cwK;
    private String cwM;
    private String cwN;
    private String cwO;
    private String cwP;
    private String cwQ;
    private String cwa;
    private String cwb;
    private String cwd;
    private String cwe;
    private String cwg;
    private String cwh;
    private String cwi;
    private String cwj;
    private String cwl;
    private String cwm;
    private String cwp;
    private int cwq;
    private int cwr;
    private String cws;
    private String cwt;
    private String cwu;
    private String cwv;
    private String cww;
    private String cwx;
    private String cwy;
    private String cwz;
    private String cwI = "0";
    private int cwD = 0;
    private int cwo = 0;
    c cwc = new c();
    c cwf = new c();
    c cwn = new c();
    c cwk = new c();
    c cwF = new c();
    c cwL = new c();

    private Map<String, String> a(StatsReport statsReport) {
        StatsReport.Value[] valueArr;
        HashMap hashMap = new HashMap();
        for (StatsReport.Value value : statsReport.values) {
            hashMap.put(value.name, value.value);
        }
        return hashMap;
    }

    private void n(Map<String, String> map) {
        try {
            this.cwc.bP(Integer.parseInt(map.get("bytesReceived")));
            this.cwb = this.cwc.ahx();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseAudioRecvStatsReport" + e);
        }
        this.cvZ = map.get("googCurrentDelayMs");
        this.cwd = map.get("googCodecName");
        this.cwa = map.get("googSpeechExpandRate");
    }

    private void o(Map<String, String> map) {
        try {
            this.cwf.bP(Long.parseLong(map.get("bytesSent")));
            this.cwe = this.cwf.ahx();
        } catch (NumberFormatException e) {
        }
        this.cwg = map.get("googCodecName");
    }

    private void p(Map<String, String> map) {
        try {
            this.cwt = c.s(Double.parseDouble(map.get("googTargetEncBitrate")));
            this.cvY = c.s(Double.parseDouble(map.get("googActualEncBitrate")));
            this.cwi = c.s(Double.parseDouble(map.get("googAvailableSendBandwidth")));
            this.cwh = c.s(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseBweStatsReport: " + e);
        }
    }

    private void q(Map<String, String> map) {
        String str = map.get("googActiveConnection");
        if (str == null || !str.equals("true")) {
            return;
        }
        try {
            this.cwk.bP(Long.parseLong(map.get("bytesReceived")));
            this.cwj = this.cwk.ahx();
            this.cwn.bP(Long.parseLong(map.get("bytesSent")));
            this.cwm = this.cwn.ahx();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseConnectionStatsReport" + e);
        }
        this.cwl = map.get("googRtt");
        this.cwp = map.get("googLocalCandidateType");
        this.cws = map.get("googRemoteCandidateType");
        this.cwu = map.get("googTransportType");
    }

    private void r(Map<String, String> map) {
        this.cww = map.get("googDecodeMs");
        this.cwv = map.get("googFrameRateDecoded");
        this.cwB = map.get("googFrameRateOutput");
        this.cwG = map.get("googFrameRateReceived");
        this.cwF.bP(Long.parseLong(map.get("bytesReceived")));
        this.cwE = this.cwF.ahx();
        this.cwH = map.get("googFrameHeightReceived");
        this.cwJ = map.get("googFrameWidthReceived");
    }

    private void s(Map<String, String> map) {
        this.cwx = map.get("googAvgEncodeMs");
        this.cwy = map.get("googFrameRateInput");
        this.cwz = map.get("googFrameHeightInput");
        this.cwA = map.get("googFrameWidthInput");
        this.cwN = map.get("googFrameRateSent");
        this.cwM = map.get("googCodecName");
        this.cwQ = map.get("googFrameWidthSent");
        this.cwO = map.get("googFrameHeightSent");
        this.cwP = map.get("packetsLost");
        this.cwC = map.get("packetsSent");
        try {
            String str = map.get("bytesSent");
            if (str != null) {
                this.cwL.bP(Integer.parseInt(str));
            }
            this.cwK = this.cwL.ahx();
            this.cwr = this.cwD;
            String str2 = map.get("qpSum");
            if (str2 != null) {
                this.cwD = Integer.parseInt(str2);
            }
            this.cwq = this.cwo;
            String str3 = map.get("framesEncoded");
            if (str3 != null) {
                this.cwo = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseVideoSendStatsReport: " + e);
        }
    }

    public String ahv() {
        return this.cwJ + "*" + this.cwH;
    }

    public String ahw() {
        return this.cwQ + "*" + this.cwO;
    }

    public void b(StatsReport[] statsReportArr) {
        Map<String, String> a2;
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains(UbcStatConstant.ContentType.UBC_TYPE_IM_SEND)) {
                Map<String, String> a3 = a(statsReport);
                String str = a3.get("googTrackId");
                if (str != null && str.contains("ARDAMSv0")) {
                    s(a3);
                } else if (str != null && str.contains("ARDAMSa0")) {
                    o(a3);
                }
            } else if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains("recv")) {
                Map<String, String> a4 = a(statsReport);
                if (a4.get("googFrameWidthReceived") != null) {
                    r(a4);
                }
                if (a4.get("audioOutputLevel") != null) {
                    n(a4);
                }
            } else if (statsReport.id.equals("bweforvideo")) {
                Map<String, String> a5 = a(statsReport);
                if (a5.size() > 3) {
                    p(a5);
                }
            } else if (statsReport.type.equals("googCandidatePair") && (a2 = a(statsReport)) != null) {
                q(a2);
            }
        }
    }

    public void t(Map<String, Integer> map) {
        if (this.cwE == null || this.cwI == null || this.cwG == null || map == null) {
            Log.e("HUDStatistics", "getStatsRecvInfo null");
            return;
        }
        map.put("bitrate_r", Integer.valueOf(c.kF(this.cwE) / 1000));
        map.put("packetloss_r", Integer.valueOf(this.cwI));
        map.put("fps_r", Integer.valueOf(this.cwG));
    }

    public void u(Map<String, Integer> map) {
        if (this.cwK == null || this.cwN == null || this.cwy == null || this.cwO == null || map == null) {
            Log.e("HUDStatistics", "getStatsSendInfo null");
            return;
        }
        map.put("bitrate_s", Integer.valueOf(c.kF(this.cwK) / 1000));
        try {
            Long l = new Long(0L);
            if (Long.parseLong(this.cwC) != 0) {
                l = Long.valueOf((Long.parseLong(this.cwP) * 1000) / Long.parseLong(this.cwC));
            }
            map.put("packetloss_s", Integer.valueOf(l.intValue()));
            map.put("fps_s", Integer.valueOf(this.cwN));
            map.put("fps_i", Integer.valueOf(this.cwy));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "getStatsSendInfo: " + e);
        }
    }
}
