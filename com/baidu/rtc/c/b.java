package com.baidu.rtc.c;

import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
/* loaded from: classes9.dex */
public class b {
    private String ccA;
    private String ccB;
    private String ccC;
    private String ccE;
    private String ccF;
    private String ccI;
    private int ccJ;
    private int ccK;
    private String ccL;
    private String ccM;
    private String ccN;
    private String ccO;
    private String ccP;
    private String ccQ;
    private String ccR;
    private String ccS;
    private String ccT;
    private String ccU;
    private String ccV;
    private String ccX;
    private String ccZ;
    private String ccq;
    private String ccr;
    private String cct;
    private String ccu;
    private String ccw;
    private String ccx;
    private String ccz;
    private String cda;
    private String cdc;
    private String cdd;
    private String cdf;
    private String cdg;
    private String cdh;
    private String cdi;
    private String cdj;
    private String cdb = "0";
    private int ccW = 0;
    private int ccH = 0;
    c ccv = new c();
    c ccy = new c();
    c ccG = new c();
    c ccD = new c();
    c ccY = new c();
    c cde = new c();

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
            this.ccv.aS(Integer.parseInt(map.get("bytesReceived")));
            this.ccu = this.ccv.aaD();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseAudioRecvStatsReport" + e);
        }
        this.ccr = map.get("googCurrentDelayMs");
        this.ccw = map.get("googCodecName");
        this.cct = map.get("googSpeechExpandRate");
    }

    private void o(Map<String, String> map) {
        try {
            this.ccy.aS(Long.parseLong(map.get("bytesSent")));
            this.ccx = this.ccy.aaD();
        } catch (NumberFormatException e) {
        }
        this.ccz = map.get("googCodecName");
    }

    private void p(Map<String, String> map) {
        try {
            this.ccM = c.s(Double.parseDouble(map.get("googTargetEncBitrate")));
            this.ccq = c.s(Double.parseDouble(map.get("googActualEncBitrate")));
            this.ccB = c.s(Double.parseDouble(map.get("googAvailableSendBandwidth")));
            this.ccA = c.s(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
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
            this.ccD.aS(Long.parseLong(map.get("bytesReceived")));
            this.ccC = this.ccD.aaD();
            this.ccG.aS(Long.parseLong(map.get("bytesSent")));
            this.ccF = this.ccG.aaD();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseConnectionStatsReport" + e);
        }
        this.ccE = map.get("googRtt");
        this.ccI = map.get("googLocalCandidateType");
        this.ccL = map.get("googRemoteCandidateType");
        this.ccN = map.get("googTransportType");
    }

    private void r(Map<String, String> map) {
        this.ccP = map.get("googDecodeMs");
        this.ccO = map.get("googFrameRateDecoded");
        this.ccU = map.get("googFrameRateOutput");
        this.ccZ = map.get("googFrameRateReceived");
        this.ccY.aS(Long.parseLong(map.get("bytesReceived")));
        this.ccX = this.ccY.aaD();
        this.cda = map.get("googFrameHeightReceived");
        this.cdc = map.get("googFrameWidthReceived");
    }

    private void s(Map<String, String> map) {
        this.ccQ = map.get("googAvgEncodeMs");
        this.ccR = map.get("googFrameRateInput");
        this.ccS = map.get("googFrameHeightInput");
        this.ccT = map.get("googFrameWidthInput");
        this.cdg = map.get("googFrameRateSent");
        this.cdf = map.get("googCodecName");
        this.cdj = map.get("googFrameWidthSent");
        this.cdh = map.get("googFrameHeightSent");
        this.cdi = map.get("packetsLost");
        this.ccV = map.get("packetsSent");
        try {
            String str = map.get("bytesSent");
            if (str != null) {
                this.cde.aS(Integer.parseInt(str));
            }
            this.cdd = this.cde.aaD();
            this.ccK = this.ccW;
            String str2 = map.get("qpSum");
            if (str2 != null) {
                this.ccW = Integer.parseInt(str2);
            }
            this.ccJ = this.ccH;
            String str3 = map.get("framesEncoded");
            if (str3 != null) {
                this.ccH = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseVideoSendStatsReport: " + e);
        }
    }

    public String aaB() {
        return this.cdc + "*" + this.cda;
    }

    public String aaC() {
        return this.cdj + "*" + this.cdh;
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
        if (this.ccX == null || this.cdb == null || this.ccZ == null || map == null) {
            Log.e("HUDStatistics", "getStatsRecvInfo null");
            return;
        }
        map.put("bitrate_r", Integer.valueOf(c.jw(this.ccX) / 1000));
        map.put("packetloss_r", Integer.valueOf(this.cdb));
        map.put("fps_r", Integer.valueOf(this.ccZ));
    }

    public void u(Map<String, Integer> map) {
        if (this.cdd == null || this.cdg == null || this.cdh == null || map == null) {
            Log.e("HUDStatistics", "getStatsSendInfo null");
            return;
        }
        map.put("bitrate_s", Integer.valueOf(c.jw(this.cdd) / 1000));
        try {
            Long l = new Long(0L);
            if (Long.parseLong(this.ccV) != 0) {
                l = Long.valueOf((Long.parseLong(this.cdi) * 1000) / Long.parseLong(this.ccV));
            }
            map.put("packetloss_s", Integer.valueOf(l.intValue()));
            map.put("fps_s", Integer.valueOf(this.cdg));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "getStatsSendInfo: " + e);
        }
    }
}
