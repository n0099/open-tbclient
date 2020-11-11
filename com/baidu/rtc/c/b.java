package com.baidu.rtc.c;

import android.util.Log;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.StatsReport;
/* loaded from: classes9.dex */
public class b {
    private String cqM;
    private String cqN;
    private String cqO;
    private String cqP;
    private String cqR;
    private String cqS;
    private String cqU;
    private String cqV;
    private String cqW;
    private String cqX;
    private String cqZ;
    private String crB;
    private String crC;
    private String crD;
    private String crE;
    private String crF;
    private String cra;
    private String cre;
    private int crf;
    private int crg;
    private String crh;
    private String cri;
    private String crj;
    private String crk;
    private String crl;
    private String crm;
    private String crn;
    private String cro;
    private String crp;
    private String crq;
    private String crr;
    private String crt;
    private String crv;
    private String crw;
    private String cry;
    private String crz;
    private String crx = "0";
    private int crs = 0;
    private int crd = 0;
    c cqQ = new c();
    c cqT = new c();
    c crb = new c();
    c cqY = new c();
    c cru = new c();
    c crA = new c();

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
            this.cqQ.bq(Integer.parseInt(map.get("bytesReceived")));
            this.cqP = this.cqQ.aeX();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseAudioRecvStatsReport" + e);
        }
        this.cqN = map.get("googCurrentDelayMs");
        this.cqR = map.get("googCodecName");
        this.cqO = map.get("googSpeechExpandRate");
    }

    private void o(Map<String, String> map) {
        try {
            this.cqT.bq(Long.parseLong(map.get("bytesSent")));
            this.cqS = this.cqT.aeX();
        } catch (NumberFormatException e) {
        }
        this.cqU = map.get("googCodecName");
    }

    private void p(Map<String, String> map) {
        try {
            this.cri = c.t(Double.parseDouble(map.get("googTargetEncBitrate")));
            this.cqM = c.t(Double.parseDouble(map.get("googActualEncBitrate")));
            this.cqW = c.t(Double.parseDouble(map.get("googAvailableSendBandwidth")));
            this.cqV = c.t(Double.parseDouble(map.get("googAvailableReceiveBandwidth")));
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
            this.cqY.bq(Long.parseLong(map.get("bytesReceived")));
            this.cqX = this.cqY.aeX();
            this.crb.bq(Long.parseLong(map.get("bytesSent")));
            this.cra = this.crb.aeX();
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "parseConnectionStatsReport" + e);
        }
        this.cqZ = map.get("googRtt");
        this.cre = map.get("googLocalCandidateType");
        this.crh = map.get("googRemoteCandidateType");
        this.crj = map.get("googTransportType");
    }

    private void r(Map<String, String> map) {
        this.crl = map.get("googDecodeMs");
        this.crk = map.get("googFrameRateDecoded");
        this.crq = map.get("googFrameRateOutput");
        this.crv = map.get("googFrameRateReceived");
        this.cru.bq(Long.parseLong(map.get("bytesReceived")));
        this.crt = this.cru.aeX();
        this.crw = map.get("googFrameHeightReceived");
        this.cry = map.get("googFrameWidthReceived");
    }

    private void s(Map<String, String> map) {
        this.crm = map.get("googAvgEncodeMs");
        this.crn = map.get("googFrameRateInput");
        this.cro = map.get("googFrameHeightInput");
        this.crp = map.get("googFrameWidthInput");
        this.crC = map.get("googFrameRateSent");
        this.crB = map.get("googCodecName");
        this.crF = map.get("googFrameWidthSent");
        this.crD = map.get("googFrameHeightSent");
        this.crE = map.get("packetsLost");
        this.crr = map.get("packetsSent");
        try {
            String str = map.get("bytesSent");
            if (str != null) {
                this.crA.bq(Integer.parseInt(str));
            }
            this.crz = this.crA.aeX();
            this.crg = this.crs;
            String str2 = map.get("qpSum");
            if (str2 != null) {
                this.crs = Integer.parseInt(str2);
            }
            this.crf = this.crd;
            String str3 = map.get("framesEncoded");
            if (str3 != null) {
                this.crd = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e) {
            Log.e("HUDStatistic", "parseVideoSendStatsReport: " + e);
        }
    }

    public String aeV() {
        return this.cry + "*" + this.crw;
    }

    public String aeW() {
        return this.crF + "*" + this.crD;
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
        if (this.crt == null || this.crx == null || this.crv == null || map == null) {
            Log.e("HUDStatistics", "getStatsRecvInfo null");
            return;
        }
        map.put("bitrate_r", Integer.valueOf(c.ke(this.crt) / 1000));
        map.put("packetloss_r", Integer.valueOf(this.crx));
        map.put("fps_r", Integer.valueOf(this.crv));
    }

    public void u(Map<String, Integer> map) {
        if (this.crz == null || this.crC == null || this.crD == null || map == null) {
            Log.e("HUDStatistics", "getStatsSendInfo null");
            return;
        }
        map.put("bitrate_s", Integer.valueOf(c.ke(this.crz) / 1000));
        try {
            Long l = new Long(0L);
            if (Long.parseLong(this.crr) != 0) {
                l = Long.valueOf((Long.parseLong(this.crE) * 1000) / Long.parseLong(this.crr));
            }
            map.put("packetloss_s", Integer.valueOf(l.intValue()));
            map.put("fps_s", Integer.valueOf(this.crC));
        } catch (NumberFormatException e) {
            Log.e("HUDStatistics", "getStatsSendInfo: " + e);
        }
    }
}
