package com.baidu.rtc.b;

import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
/* loaded from: classes9.dex */
public class b {
    private String cwA;
    private String cwB;
    private String cwD;
    private String cwE;
    private String cwF;
    private String cwG;
    private String cwI;
    private String cwJ;
    private String cwM;
    private int cwN;
    private int cwO;
    private String cwP;
    private String cwQ;
    private String cwR;
    private String cwS;
    private String cwT;
    private String cwU;
    private String cwV;
    private String cwW;
    private String cwX;
    private String cwY;
    private String cwZ;
    private String cwv;
    private String cww;
    private String cwx;
    private String cwy;
    private String cxb;
    private String cxd;
    private String cxe;
    private String cxg;
    private String cxh;
    private String cxj;
    private String cxk;
    private String cxl;
    private String cxm;
    private String cxn;
    private String cxf = "0";
    private int cxa = 0;
    private int cwL = 0;
    c cwz = new c();
    c cwC = new c();
    c cwK = new c();
    c cwH = new c();
    c cxc = new c();
    c cxi = new c();

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
            this.cwz.bQ(Integer.parseInt(map.get("bytesReceived")));
            this.cwy = this.cwz.aeU();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseAudioRecvStatsReport" + e);
        }
        this.cww = map.get("googCurrentDelayMs");
        this.cwA = map.get("googCodecName");
        this.cwx = map.get("googSpeechExpandRate");
    }

    private void p(Map<String, String> map) {
        try {
            this.cwC.bQ(Long.parseLong(map.get("bytesSent")));
            this.cwB = this.cwC.aeU();
        } catch (NumberFormatException e) {
        }
        this.cwD = map.get("googCodecName");
    }

    private void q(Map<String, String> map) {
        try {
            this.cwQ = c.m(Double.parseDouble(map.get("googTargetEncBitrate")));
            this.cwv = c.m(Double.parseDouble(map.get("googActualEncBitrate")));
            this.cwF = c.m(Double.parseDouble(map.get("googAvailableSendBandwidth")));
            this.cwE = c.m(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
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
            this.cwH.bQ(Long.parseLong(map.get("bytesReceived")));
            this.cwG = this.cwH.aeU();
            this.cwK.bQ(Long.parseLong(map.get("bytesSent")));
            this.cwJ = this.cwK.aeU();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseConnectionStatsReport" + e);
        }
        this.cwI = map.get("googRtt");
        this.cwM = map.get("googLocalCandidateType");
        this.cwP = map.get("googRemoteCandidateType");
        this.cwR = map.get("googTransportType");
    }

    private void s(Map<String, String> map) {
        this.cwT = map.get("googDecodeMs");
        this.cwS = map.get("googFrameRateDecoded");
        this.cwY = map.get("googFrameRateOutput");
        this.cxd = map.get("googFrameRateReceived");
        this.cxc.bQ(Long.parseLong(map.get("bytesReceived")));
        this.cxb = this.cxc.aeU();
        this.cxe = map.get("googFrameHeightReceived");
        this.cxg = map.get("googFrameWidthReceived");
    }

    private void t(Map<String, String> map) {
        this.cwU = map.get("googAvgEncodeMs");
        this.cwV = map.get("googFrameRateInput");
        this.cwW = map.get("googFrameHeightInput");
        this.cwX = map.get("googFrameWidthInput");
        this.cxk = map.get("googFrameRateSent");
        this.cxj = map.get("googCodecName");
        this.cxn = map.get("googFrameWidthSent");
        this.cxl = map.get("googFrameHeightSent");
        this.cxm = map.get("packetsLost");
        this.cwZ = map.get("packetsSent");
        try {
            String str = map.get("bytesSent");
            if (str != null) {
                this.cxi.bQ(Integer.parseInt(str));
            }
            this.cxh = this.cxi.aeU();
            this.cwO = this.cxa;
            String str2 = map.get("qpSum");
            if (str2 != null) {
                this.cxa = Integer.parseInt(str2);
            }
            this.cwN = this.cwL;
            String str3 = map.get("framesEncoded");
            if (str3 != null) {
                this.cwL = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseVideoSendStatsReport: " + e);
        }
    }

    public String aeS() {
        return this.cxg + "*" + this.cxe;
    }

    public String aeT() {
        return this.cxn + "*" + this.cxl;
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
        if (this.cxb == null || this.cxf == null || this.cxd == null || map == null) {
            Log.e("HUDStatistics", "getStatsRecvInfo null");
            return;
        }
        map.put("bitrate_r", Integer.valueOf(c.jn(this.cxb) / 1000));
        map.put("packetloss_r", Integer.valueOf(this.cxf));
        map.put("fps_r", Integer.valueOf(this.cxd));
    }

    public void v(Map<String, Integer> map) {
        if (this.cxh == null || this.cxk == null || this.cwV == null || this.cxl == null || map == null) {
            Log.e("HUDStatistics", "getStatsSendInfo null");
            return;
        }
        map.put("bitrate_s", Integer.valueOf(c.jn(this.cxh) / 1000));
        try {
            Long l = new Long(0L);
            if (Long.parseLong(this.cwZ) != 0) {
                l = Long.valueOf((Long.parseLong(this.cxm) * 1000) / Long.parseLong(this.cwZ));
            }
            map.put("packetloss_s", Integer.valueOf(l.intValue()));
            map.put("fps_s", Integer.valueOf(this.cxk));
            map.put("fps_i", Integer.valueOf(this.cwV));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "getStatsSendInfo: " + e);
        }
    }
}
