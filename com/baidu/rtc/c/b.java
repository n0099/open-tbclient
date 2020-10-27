package com.baidu.rtc.c;

import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
/* loaded from: classes9.dex */
public class b {
    private String ckP;
    private String ckQ;
    private String ckR;
    private String ckS;
    private String ckU;
    private String ckV;
    private String ckX;
    private String ckY;
    private String ckZ;
    private String clA;
    private String clB;
    private String clD;
    private String clE;
    private String clF;
    private String clG;
    private String clH;
    private String cla;
    private String clc;
    private String cld;
    private String clg;
    private int clh;
    private int cli;
    private String clj;
    private String clk;
    private String cll;
    private String clm;
    private String cln;
    private String clo;
    private String clp;
    private String clq;
    private String clr;
    private String cls;
    private String clt;
    private String clv;
    private String clx;
    private String cly;
    private String clz = "0";
    private int clu = 0;
    private int clf = 0;
    c ckT = new c();
    c ckW = new c();
    c cle = new c();
    c clb = new c();
    c clw = new c();
    c clC = new c();

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
            this.ckT.aU(Integer.parseInt(map.get("bytesReceived")));
            this.ckS = this.ckT.acx();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseAudioRecvStatsReport" + e);
        }
        this.ckQ = map.get("googCurrentDelayMs");
        this.ckU = map.get("googCodecName");
        this.ckR = map.get("googSpeechExpandRate");
    }

    private void o(Map<String, String> map) {
        try {
            this.ckW.aU(Long.parseLong(map.get("bytesSent")));
            this.ckV = this.ckW.acx();
        } catch (NumberFormatException e) {
        }
        this.ckX = map.get("googCodecName");
    }

    private void p(Map<String, String> map) {
        try {
            this.clk = c.t(Double.parseDouble(map.get("googTargetEncBitrate")));
            this.ckP = c.t(Double.parseDouble(map.get("googActualEncBitrate")));
            this.ckZ = c.t(Double.parseDouble(map.get("googAvailableSendBandwidth")));
            this.ckY = c.t(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
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
            this.clb.aU(Long.parseLong(map.get("bytesReceived")));
            this.cla = this.clb.acx();
            this.cle.aU(Long.parseLong(map.get("bytesSent")));
            this.cld = this.cle.acx();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseConnectionStatsReport" + e);
        }
        this.clc = map.get("googRtt");
        this.clg = map.get("googLocalCandidateType");
        this.clj = map.get("googRemoteCandidateType");
        this.cll = map.get("googTransportType");
    }

    private void r(Map<String, String> map) {
        this.cln = map.get("googDecodeMs");
        this.clm = map.get("googFrameRateDecoded");
        this.cls = map.get("googFrameRateOutput");
        this.clx = map.get("googFrameRateReceived");
        this.clw.aU(Long.parseLong(map.get("bytesReceived")));
        this.clv = this.clw.acx();
        this.cly = map.get("googFrameHeightReceived");
        this.clA = map.get("googFrameWidthReceived");
    }

    private void s(Map<String, String> map) {
        this.clo = map.get("googAvgEncodeMs");
        this.clp = map.get("googFrameRateInput");
        this.clq = map.get("googFrameHeightInput");
        this.clr = map.get("googFrameWidthInput");
        this.clE = map.get("googFrameRateSent");
        this.clD = map.get("googCodecName");
        this.clH = map.get("googFrameWidthSent");
        this.clF = map.get("googFrameHeightSent");
        this.clG = map.get("packetsLost");
        this.clt = map.get("packetsSent");
        try {
            String str = map.get("bytesSent");
            if (str != null) {
                this.clC.aU(Integer.parseInt(str));
            }
            this.clB = this.clC.acx();
            this.cli = this.clu;
            String str2 = map.get("qpSum");
            if (str2 != null) {
                this.clu = Integer.parseInt(str2);
            }
            this.clh = this.clf;
            String str3 = map.get("framesEncoded");
            if (str3 != null) {
                this.clf = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseVideoSendStatsReport: " + e);
        }
    }

    public String acv() {
        return this.clA + "*" + this.cly;
    }

    public String acw() {
        return this.clH + "*" + this.clF;
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
        if (this.clv == null || this.clz == null || this.clx == null || map == null) {
            Log.e("HUDStatistics", "getStatsRecvInfo null");
            return;
        }
        map.put("bitrate_r", Integer.valueOf(c.jP(this.clv) / 1000));
        map.put("packetloss_r", Integer.valueOf(this.clz));
        map.put("fps_r", Integer.valueOf(this.clx));
    }

    public void u(Map<String, Integer> map) {
        if (this.clB == null || this.clE == null || this.clF == null || map == null) {
            Log.e("HUDStatistics", "getStatsSendInfo null");
            return;
        }
        map.put("bitrate_s", Integer.valueOf(c.jP(this.clB) / 1000));
        try {
            Long l = new Long(0L);
            if (Long.parseLong(this.clt) != 0) {
                l = Long.valueOf((Long.parseLong(this.clG) * 1000) / Long.parseLong(this.clt));
            }
            map.put("packetloss_s", Integer.valueOf(l.intValue()));
            map.put("fps_s", Integer.valueOf(this.clE));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "getStatsSendInfo: " + e);
        }
    }
}
