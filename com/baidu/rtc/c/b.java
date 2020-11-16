package com.baidu.rtc.c;

import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
/* loaded from: classes16.dex */
public class b {
    private String cpA;
    private String cpB;
    private String cpC;
    private String cpD;
    private String cpE;
    private String cpF;
    private String cpG;
    private String cpI;
    private String cpK;
    private String cpL;
    private String cpN;
    private String cpO;
    private String cpQ;
    private String cpR;
    private String cpS;
    private String cpT;
    private String cpU;
    private String cpb;
    private String cpc;
    private String cpd;
    private String cpe;
    private String cpg;
    private String cph;
    private String cpj;
    private String cpk;
    private String cpl;
    private String cpm;
    private String cpo;
    private String cpp;
    private String cps;
    private int cpt;
    private int cpv;
    private String cpw;
    private String cpx;
    private String cpy;
    private String cpz;
    private String cpM = "0";
    private int cpH = 0;
    private int cpr = 0;
    c cpf = new c();
    c cpi = new c();
    c cpq = new c();
    c cpn = new c();
    c cpJ = new c();
    c cpP = new c();

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
            this.cpf.bq(Integer.parseInt(map.get("bytesReceived")));
            this.cpe = this.cpf.aep();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseAudioRecvStatsReport" + e);
        }
        this.cpc = map.get("googCurrentDelayMs");
        this.cpg = map.get("googCodecName");
        this.cpd = map.get("googSpeechExpandRate");
    }

    private void o(Map<String, String> map) {
        try {
            this.cpi.bq(Long.parseLong(map.get("bytesSent")));
            this.cph = this.cpi.aep();
        } catch (NumberFormatException e) {
        }
        this.cpj = map.get("googCodecName");
    }

    private void p(Map<String, String> map) {
        try {
            this.cpx = c.s(Double.parseDouble(map.get("googTargetEncBitrate")));
            this.cpb = c.s(Double.parseDouble(map.get("googActualEncBitrate")));
            this.cpl = c.s(Double.parseDouble(map.get("googAvailableSendBandwidth")));
            this.cpk = c.s(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
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
            this.cpn.bq(Long.parseLong(map.get("bytesReceived")));
            this.cpm = this.cpn.aep();
            this.cpq.bq(Long.parseLong(map.get("bytesSent")));
            this.cpp = this.cpq.aep();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseConnectionStatsReport" + e);
        }
        this.cpo = map.get("googRtt");
        this.cps = map.get("googLocalCandidateType");
        this.cpw = map.get("googRemoteCandidateType");
        this.cpy = map.get("googTransportType");
    }

    private void r(Map<String, String> map) {
        this.cpA = map.get("googDecodeMs");
        this.cpz = map.get("googFrameRateDecoded");
        this.cpF = map.get("googFrameRateOutput");
        this.cpK = map.get("googFrameRateReceived");
        this.cpJ.bq(Long.parseLong(map.get("bytesReceived")));
        this.cpI = this.cpJ.aep();
        this.cpL = map.get("googFrameHeightReceived");
        this.cpN = map.get("googFrameWidthReceived");
    }

    private void s(Map<String, String> map) {
        this.cpB = map.get("googAvgEncodeMs");
        this.cpC = map.get("googFrameRateInput");
        this.cpD = map.get("googFrameHeightInput");
        this.cpE = map.get("googFrameWidthInput");
        this.cpR = map.get("googFrameRateSent");
        this.cpQ = map.get("googCodecName");
        this.cpU = map.get("googFrameWidthSent");
        this.cpS = map.get("googFrameHeightSent");
        this.cpT = map.get("packetsLost");
        this.cpG = map.get("packetsSent");
        try {
            String str = map.get("bytesSent");
            if (str != null) {
                this.cpP.bq(Integer.parseInt(str));
            }
            this.cpO = this.cpP.aep();
            this.cpv = this.cpH;
            String str2 = map.get("qpSum");
            if (str2 != null) {
                this.cpH = Integer.parseInt(str2);
            }
            this.cpt = this.cpr;
            String str3 = map.get("framesEncoded");
            if (str3 != null) {
                this.cpr = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseVideoSendStatsReport: " + e);
        }
    }

    public String aen() {
        return this.cpN + "*" + this.cpL;
    }

    public String aeo() {
        return this.cpU + "*" + this.cpS;
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
        if (this.cpI == null || this.cpM == null || this.cpK == null || map == null) {
            Log.e("HUDStatistics", "getStatsRecvInfo null");
            return;
        }
        map.put("bitrate_r", Integer.valueOf(c.jY(this.cpI) / 1000));
        map.put("packetloss_r", Integer.valueOf(this.cpM));
        map.put("fps_r", Integer.valueOf(this.cpK));
    }

    public void u(Map<String, Integer> map) {
        if (this.cpO == null || this.cpR == null || this.cpS == null || map == null) {
            Log.e("HUDStatistics", "getStatsSendInfo null");
            return;
        }
        map.put("bitrate_s", Integer.valueOf(c.jY(this.cpO) / 1000));
        try {
            Long l = new Long(0L);
            if (Long.parseLong(this.cpG) != 0) {
                l = Long.valueOf((Long.parseLong(this.cpT) * 1000) / Long.parseLong(this.cpG));
            }
            map.put("packetloss_s", Integer.valueOf(l.intValue()));
            map.put("fps_s", Integer.valueOf(this.cpR));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "getStatsSendInfo: " + e);
        }
    }
}
