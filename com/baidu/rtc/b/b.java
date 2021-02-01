package com.baidu.rtc.b;

import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
/* loaded from: classes10.dex */
public class b {
    private long cyJ;
    private String cyK;
    private String cyL;
    private String cyM;
    private String cyN;
    private String cyP;
    private String cyQ;
    private String cyS;
    private String cyT;
    private String cyU;
    private String cyV;
    private String cyX;
    private String cyY;
    private String czA;
    private String czB;
    private String czC;
    private String czD;
    private long czE;
    private String cza;
    private String czc;
    private int czd;
    private int cze;
    private String czf;
    private String czg;
    private String czh;
    private String czi;
    private String czj;
    private String czk;
    private String czl;
    private String czm;
    private String czn;
    private String czo;
    private String czp;
    private String czr;
    private String czt;
    private String czu;
    private String czw;
    private String czx;
    private String czz;
    private String czv = "0";
    private ArrayList<Long> cyI = new ArrayList<>();
    private ArrayList<Long> czF = new ArrayList<>();
    private int czq = 0;
    private int czb = 0;
    c cyO = new c();
    c cyR = new c();
    c cyZ = new c();
    c cyW = new c();
    c czs = new c();
    c czy = new c();

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
            this.cyO.bW(Integer.parseInt(map.get("bytesReceived")));
            this.cyN = this.cyO.afr();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseAudioRecvStatsReport" + e);
        }
        this.cyL = map.get("googCurrentDelayMs");
        this.cyP = map.get("googCodecName");
        this.cyM = map.get("googSpeechExpandRate");
    }

    private void q(Map<String, String> map) {
        try {
            this.cyR.bW(Long.parseLong(map.get("bytesSent")));
            this.cyQ = this.cyR.afr();
        } catch (NumberFormatException e) {
        }
        this.cyS = map.get("googCodecName");
    }

    private void r(Map<String, String> map) {
        try {
            this.czg = c.m(Double.parseDouble(map.get("googTargetEncBitrate")));
            this.cyK = c.m(Double.parseDouble(map.get("googActualEncBitrate")));
            this.cyU = c.m(Double.parseDouble(map.get("googAvailableSendBandwidth")));
            this.cyT = c.m(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
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
            this.cyW.bW(Long.parseLong(map.get("bytesReceived")));
            this.cyV = this.cyW.afr();
            this.cyZ.bW(Long.parseLong(map.get("bytesSent")));
            this.cyY = this.cyZ.afr();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseConnectionStatsReport" + e);
        }
        this.cyX = map.get("googRtt");
        this.czc = map.get("googLocalCandidateType");
        this.czf = map.get("googRemoteCandidateType");
        this.czh = map.get("googTransportType");
    }

    private void t(Map<String, String> map) {
        this.czj = map.get("googDecodeMs");
        this.czi = map.get("googFrameRateDecoded");
        this.czo = map.get("googFrameRateOutput");
        this.czt = map.get("googFrameRateReceived");
        this.czs.bW(Long.parseLong(map.get("bytesReceived")));
        this.czr = this.czs.afr();
        this.czu = map.get("googFrameHeightReceived");
        this.czw = map.get("googFrameWidthReceived");
        if (map.containsKey("googEndToEndTime")) {
            this.cza = map.get("googEndToEndTime");
        }
    }

    private void u(Map<String, String> map) {
        this.czk = map.get("googAvgEncodeMs");
        this.czl = map.get("googFrameRateInput");
        this.czm = map.get("googFrameHeightInput");
        this.czn = map.get("googFrameWidthInput");
        this.czA = map.get("googFrameRateSent");
        this.czz = map.get("googCodecName");
        this.czD = map.get("googFrameWidthSent");
        this.czB = map.get("googFrameHeightSent");
        this.czC = map.get("packetsLost");
        this.czp = map.get("packetsSent");
        try {
            String str = map.get("bytesSent");
            if (str != null) {
                this.czy.bW(Integer.parseInt(str));
            }
            this.czx = this.czy.afr();
            this.cze = this.czq;
            String str2 = map.get("qpSum");
            if (str2 != null) {
                this.czq = Integer.parseInt(str2);
            }
            this.czd = this.czb;
            String str3 = map.get("framesEncoded");
            if (str3 != null) {
                this.czb = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseVideoSendStatsReport: " + e);
        }
    }

    public void afl() {
        this.cyI.clear();
        this.czF.clear();
    }

    public int afm() {
        if (this.cza == null || this.cza == "") {
            return -1;
        }
        return Integer.valueOf(this.cza).intValue();
    }

    public long afn() {
        return this.cyJ;
    }

    public String afo() {
        return this.czw + "*" + this.czu;
    }

    public long afp() {
        return this.czE;
    }

    public String afq() {
        return this.czD + "*" + this.czB;
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
        this.cyJ = j;
    }

    public void bV(long j) {
        this.czE = j;
    }

    public void n(long j, long j2) {
        this.cyI.add(Long.valueOf(j2 - j));
    }

    public void o(long j, long j2) {
        this.czF.add(Long.valueOf(j2 - j));
    }

    public void v(Map<String, ArrayList<Long>> map) {
        map.put("aStuck", this.cyI);
        map.put("vStuck", this.czF);
    }

    public void w(Map<String, Integer> map) {
        if (this.czr == null || this.czv == null || this.czt == null || map == null) {
            Log.e("HUDStatistics", "getStatsRecvInfo null");
            return;
        }
        map.put("bitrate_r", Integer.valueOf(c.jG(this.czr) / 1000));
        map.put("packetloss_r", Integer.valueOf(this.czv));
        map.put("fps_r", Integer.valueOf(this.czt));
    }

    public void x(Map<String, Integer> map) {
        if (this.czx == null || this.czA == null || this.czl == null || this.czB == null || map == null) {
            Log.e("HUDStatistics", "getStatsSendInfo null");
            return;
        }
        map.put("bitrate_s", Integer.valueOf(c.jG(this.czx) / 1000));
        try {
            Long l = new Long(0L);
            if (Long.parseLong(this.czp) != 0) {
                l = Long.valueOf((Long.parseLong(this.czC) * 1000) / Long.parseLong(this.czp));
            }
            map.put("packetlost", Integer.valueOf(Integer.parseInt(this.czC)));
            map.put("packesend", Integer.valueOf(Integer.parseInt(this.czp)));
            map.put("packetloss_s", Integer.valueOf(l.intValue()));
            map.put("fps_s", Integer.valueOf(this.czA));
            map.put("fps_i", Integer.valueOf(this.czl));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "getStatsSendInfo: " + e);
        }
    }
}
