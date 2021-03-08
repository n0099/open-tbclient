package com.baidu.rtc.b;

import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
/* loaded from: classes9.dex */
public class b {
    private String cAA;
    private String cAC;
    private int cAD;
    private int cAE;
    private String cAF;
    private String cAG;
    private String cAH;
    private String cAI;
    private String cAJ;
    private String cAK;
    private String cAL;
    private String cAM;
    private String cAN;
    private String cAO;
    private String cAP;
    private String cAR;
    private String cAT;
    private String cAU;
    private String cAW;
    private String cAX;
    private String cAZ;
    private long cAj;
    private String cAk;
    private String cAl;
    private String cAm;
    private String cAn;
    private String cAp;
    private String cAq;
    private String cAs;
    private String cAt;
    private String cAu;
    private String cAv;
    private String cAx;
    private String cAy;
    private String cBa;
    private String cBb;
    private String cBc;
    private String cBd;
    private long cBe;
    private String cAV = "0";
    private ArrayList<Long> cAi = new ArrayList<>();
    private ArrayList<Long> cBf = new ArrayList<>();
    private int cAQ = 0;
    private int cAB = 0;
    c cAo = new c();
    c cAr = new c();
    c cAz = new c();
    c cAw = new c();
    c cAS = new c();
    c cAY = new c();

    private Map<String, String> a(StatsReport statsReport) {
        StatsReport.Value[] valueArr;
        HashMap hashMap = new HashMap();
        for (StatsReport.Value value : statsReport.values) {
            hashMap.put(value.name, value.value);
        }
        return hashMap;
    }

    private void p(Map<String, String> map) {
        try {
            this.cAo.bW(Integer.parseInt(map.get("bytesReceived")));
            this.cAn = this.cAo.afu();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseAudioRecvStatsReport" + e);
        }
        this.cAl = map.get("googCurrentDelayMs");
        this.cAp = map.get("googCodecName");
        this.cAm = map.get("googSpeechExpandRate");
    }

    private void q(Map<String, String> map) {
        try {
            this.cAr.bW(Long.parseLong(map.get("bytesSent")));
            this.cAq = this.cAr.afu();
        } catch (NumberFormatException e) {
        }
        this.cAs = map.get("googCodecName");
    }

    private void r(Map<String, String> map) {
        try {
            this.cAG = c.m(Double.parseDouble(map.get("googTargetEncBitrate")));
            this.cAk = c.m(Double.parseDouble(map.get("googActualEncBitrate")));
            this.cAu = c.m(Double.parseDouble(map.get("googAvailableSendBandwidth")));
            this.cAt = c.m(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseBweStatsReport: " + e);
        }
    }

    private void s(Map<String, String> map) {
        String str = map.get("googActiveConnection");
        if (str == null || !str.equals("true")) {
            return;
        }
        try {
            this.cAw.bW(Long.parseLong(map.get("bytesReceived")));
            this.cAv = this.cAw.afu();
            this.cAz.bW(Long.parseLong(map.get("bytesSent")));
            this.cAy = this.cAz.afu();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseConnectionStatsReport" + e);
        }
        this.cAx = map.get("googRtt");
        this.cAC = map.get("googLocalCandidateType");
        this.cAF = map.get("googRemoteCandidateType");
        this.cAH = map.get("googTransportType");
    }

    private void t(Map<String, String> map) {
        this.cAJ = map.get("googDecodeMs");
        this.cAI = map.get("googFrameRateDecoded");
        this.cAO = map.get("googFrameRateOutput");
        this.cAT = map.get("googFrameRateReceived");
        this.cAS.bW(Long.parseLong(map.get("bytesReceived")));
        this.cAR = this.cAS.afu();
        this.cAU = map.get("googFrameHeightReceived");
        this.cAW = map.get("googFrameWidthReceived");
        if (map.containsKey("googEndToEndTime")) {
            this.cAA = map.get("googEndToEndTime");
        }
    }

    private void u(Map<String, String> map) {
        this.cAK = map.get("googAvgEncodeMs");
        this.cAL = map.get("googFrameRateInput");
        this.cAM = map.get("googFrameHeightInput");
        this.cAN = map.get("googFrameWidthInput");
        this.cBa = map.get("googFrameRateSent");
        this.cAZ = map.get("googCodecName");
        this.cBd = map.get("googFrameWidthSent");
        this.cBb = map.get("googFrameHeightSent");
        this.cBc = map.get("packetsLost");
        this.cAP = map.get("packetsSent");
        try {
            String str = map.get("bytesSent");
            if (str != null) {
                this.cAY.bW(Integer.parseInt(str));
            }
            this.cAX = this.cAY.afu();
            this.cAE = this.cAQ;
            String str2 = map.get("qpSum");
            if (str2 != null) {
                this.cAQ = Integer.parseInt(str2);
            }
            this.cAD = this.cAB;
            String str3 = map.get("framesEncoded");
            if (str3 != null) {
                this.cAB = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseVideoSendStatsReport: " + e);
        }
    }

    public void afo() {
        this.cAi.clear();
        this.cBf.clear();
    }

    public int afp() {
        if (this.cAA == null || this.cAA == "") {
            return -1;
        }
        return Integer.valueOf(this.cAA).intValue();
    }

    public long afq() {
        return this.cAj;
    }

    public String afr() {
        return this.cAW + "*" + this.cAU;
    }

    public long afs() {
        return this.cBe;
    }

    public String aft() {
        return this.cBd + "*" + this.cBb;
    }

    public void b(StatsReport[] statsReportArr) {
        Map<String, String> a2;
        for (StatsReport statsReport : statsReportArr) {
            if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains(UbcStatConstant.ContentType.UBC_TYPE_IM_SEND)) {
                Map<String, String> a3 = a(statsReport);
                String str = a3.get("googTrackId");
                if (str != null && str.contains("ARDAMSv0")) {
                    u(a3);
                } else if (str != null && str.contains("ARDAMSa0")) {
                    q(a3);
                }
            } else if (statsReport.type.equals("ssrc") && statsReport.id.contains("ssrc") && statsReport.id.contains("recv")) {
                Map<String, String> a4 = a(statsReport);
                if (a4.get("googFrameWidthReceived") != null) {
                    t(a4);
                }
                if (a4.get("audioOutputLevel") != null) {
                    p(a4);
                }
            } else if (statsReport.id.equals("bweforvideo")) {
                Map<String, String> a5 = a(statsReport);
                if (a5.size() > 3) {
                    r(a5);
                }
            } else if (statsReport.type.equals("googCandidatePair") && (a2 = a(statsReport)) != null) {
                s(a2);
            }
        }
    }

    public void bU(long j) {
        this.cAj = j;
    }

    public void bV(long j) {
        this.cBe = j;
    }

    public void n(long j, long j2) {
        this.cAi.add(Long.valueOf(j2 - j));
    }

    public void o(long j, long j2) {
        this.cBf.add(Long.valueOf(j2 - j));
    }

    public void v(Map<String, ArrayList<Long>> map) {
        map.put("aStuck", this.cAi);
        map.put("vStuck", this.cBf);
    }

    public void w(Map<String, Integer> map) {
        if (this.cAR == null || this.cAV == null || this.cAT == null || map == null) {
            Log.e("HUDStatistics", "getStatsRecvInfo null");
            return;
        }
        map.put("bitrate_r", Integer.valueOf(c.jN(this.cAR) / 1000));
        map.put("packetloss_r", Integer.valueOf(this.cAV));
        map.put("fps_r", Integer.valueOf(this.cAT));
    }

    public void x(Map<String, Integer> map) {
        if (this.cAX == null || this.cBa == null || this.cAL == null || this.cBb == null || map == null) {
            Log.e("HUDStatistics", "getStatsSendInfo null");
            return;
        }
        map.put("bitrate_s", Integer.valueOf(c.jN(this.cAX) / 1000));
        try {
            Long l = new Long(0L);
            if (Long.parseLong(this.cAP) != 0) {
                l = Long.valueOf((Long.parseLong(this.cBc) * 1000) / Long.parseLong(this.cAP));
            }
            map.put("packetlost", Integer.valueOf(Integer.parseInt(this.cBc)));
            map.put("packesend", Integer.valueOf(Integer.parseInt(this.cAP)));
            map.put("packetloss_s", Integer.valueOf(l.intValue()));
            map.put("fps_s", Integer.valueOf(this.cBa));
            map.put("fps_i", Integer.valueOf(this.cAL));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "getStatsSendInfo: " + e);
        }
    }
}
