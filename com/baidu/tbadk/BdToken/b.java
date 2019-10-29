package com.baidu.tbadk.BdToken;

import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.aq;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class b {
    private final ArrayList<h> bRA;
    private int bRf;
    private int bRg;
    private long bRh;
    private String bRi;
    private int bRj;
    private long bRk;
    private String bRl;
    private String bRm;
    private String bRn;
    private String bRo;
    private long bRp;
    private int bRq;
    private long bRr;
    private int[] bRs;
    private long bRt;
    private int bRu;
    private volatile int bRv;
    private volatile int bRw;
    private boolean bRx;
    private int bRy;
    public boolean bRz;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String bQB = "missionid";
    public static String bQC = "activitysource";
    public static String SOURCE = "source";
    public static String bQD = "tab";
    public static String bQE = "calltype";
    public static String bQF = "tasktype";
    public static String bQG = "browsetimepage";
    public static String bQH = "browsetime";
    public static String bQI = "threadnum";
    public static String bQJ = "forumnum";
    public static String bQK = "cleartype";
    public static String bQL = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String bQM = "threadtext";
    public static String bQN = "threadimg";
    public static String bQO = "threadforum";
    public static String bQP = "total_limit";
    public static int bQQ = -1;
    public static int bQR = 1;
    public static int bQS = 2;
    public static int bQT = 3;
    public static int bQU = 4;
    public static int bQV = 5;
    public static int bQW = 6;
    public static int bQX = 7;
    public static int bQY = 8;
    public static int bQZ = 9;
    public static int bRa = -1;
    public static int bRb = 0;
    public static int bRc = 1;
    public static int bRd = 2;
    public static int bRe = 3;

    public void reset() {
        this.bRA.clear();
        this.bRv = 0;
        this.bRw = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.bRA.contains(hVar)) {
                this.bRA.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.bRA.contains(hVar)) {
                this.bRA.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.bRA.contains(hVar)) {
                this.bRA.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.bRA.contains(hVar)) {
                this.bRA.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.bRA.contains(hVar)) {
            this.bRA.add(hVar);
        }
    }

    public ArrayList<h> ady() {
        return this.bRA;
    }

    public int adz() {
        int i;
        int size = this.bRA.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.bRA, i2);
            if (hVar instanceof k) {
                i = ((k) hVar).getTag() == getTag() ? i3 + 1 : i3;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        return i3;
    }

    public long b(h hVar) {
        if (hVar == null) {
            return 0L;
        }
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            return ((k) hVar).getTid();
        }
        if (this.mTaskType == 1 && (hVar instanceof m)) {
            return ((m) hVar).getTid();
        }
        if (this.mTaskType != 2 || !(hVar instanceof j)) {
            return 0L;
        }
        return ((j) hVar).getFid();
    }

    public void adA() {
        int size = this.bRA.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.bRA, i);
            if (hVar != null) {
                hVar.dL(true);
            }
        }
    }

    public boolean aC(long j) {
        for (int i = 0; i < this.bRA.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.bRA, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.aK()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void C(int i, String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                long optLong = jSONObject.optLong("i");
                long optLong2 = jSONObject.optLong("t");
                boolean optBoolean = jSONObject.optBoolean("c");
                int optInt = jSONObject.optInt(Config.APP_VERSION_CODE);
                if (i == 7) {
                    if (optLong > 0) {
                        k kVar = new k(this, optLong);
                        kVar.dL(optBoolean);
                        kVar.aH(optLong2);
                        kVar.hi(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.dL(optBoolean);
                        mVar.aH(optLong2);
                        mVar.hi(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.dL(optBoolean);
                        jVar.aH(optLong2);
                        jVar.hi(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.dL(optBoolean);
                    iVar.aH(optLong2);
                    iVar.hi(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.dL(optBoolean);
                    lVar.aH(optLong2);
                    lVar.hi(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String adB() {
        try {
            ArrayList<h> arrayList = this.bRA;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.aew());
                jSONObject.put("c", hVar.aK());
                jSONObject.put(Config.APP_VERSION_CODE, hVar.getTag());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    public b() {
        this.bRq = bRa;
        this.bRv = 0;
        this.bRw = 0;
        this.bRx = false;
        this.bRy = 1;
        this.mTag = 0;
        this.bRz = false;
        this.bRA = new ArrayList<>();
    }

    public b(String str) {
        this.bRq = bRa;
        this.bRv = 0;
        this.bRw = 0;
        this.bRx = false;
        this.bRy = 1;
        this.mTag = 0;
        this.bRz = false;
        this.bRA = new ArrayList<>();
        lO(str);
    }

    public boolean lO(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.bRf = jSONObject.optInt(ACTIVITY_ID);
                this.bRg = jSONObject.optInt(bQB);
                this.bRl = jSONObject.optString(bQC);
                this.mSource = jSONObject.optString(SOURCE);
                this.bRm = jSONObject.optString(bQD);
                this.bRu = jSONObject.optInt(bQE);
                this.mTaskType = jSONObject.optInt(bQF);
                this.bRi = jSONObject.optString(bQG);
                this.bRs = lP(this.bRi);
                this.bRh = jSONObject.optLong(bQH);
                this.mThreadNum = jSONObject.optInt(bQI);
                this.bRj = jSONObject.optInt(bQJ);
                this.bRq = jSONObject.optInt(bQK);
                this.bRr = jSONObject.optLong(bQL);
                this.bRt = adH();
                this.bRk = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.bRn = jSONObject.optString(bQM);
                this.bRo = jSONObject.optString(bQN);
                this.bRp = jSONObject.optLong(bQO);
                int optInt = jSONObject.optInt(bQP);
                if (optInt > 0) {
                    this.bRy = optInt;
                }
                return true;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public b(MissionInfo missionInfo) {
        this.bRq = bRa;
        this.bRv = 0;
        this.bRw = 0;
        this.bRx = false;
        this.bRy = 1;
        this.mTag = 0;
        this.bRz = false;
        this.bRA = new ArrayList<>();
        if (missionInfo != null) {
            this.bRf = missionInfo.activityid.intValue();
            this.bRg = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.bRq = missionInfo.cleartype.intValue();
            this.bRr = missionInfo.cleartime.intValue();
            this.bRt = adH();
            this.bRi = missionInfo.browsetimepage;
            this.bRs = lP(this.bRi);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.bRh = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.bRy = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean adC() {
        return this.bRf > 0 && this.bRg > 0 && this.mTaskType > 0 && this.bRh > 0;
    }

    public synchronized int adD() {
        int i;
        i = this.bRw + 1;
        this.bRw = i;
        return i;
    }

    public synchronized int adE() {
        int i;
        i = this.bRv + 1;
        this.bRv = i;
        return i;
    }

    public synchronized int adF() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] lP(String str) {
        if (this.mTaskType == 8) {
            return new int[]{bQQ};
        }
        if (this.mTaskType == 7) {
            return new int[]{bQR, bQY, bQZ};
        }
        if (str == null) {
            return null;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            int i2 = com.baidu.adp.lib.g.b.toInt(split[i], 0);
            if (i2 > 0) {
                iArr[i] = i2;
            }
        }
        return iArr;
    }

    public boolean adG() {
        return System.currentTimeMillis() > adT() * 1000;
    }

    public long adH() {
        if (this.bRq == bRa) {
            return 0L;
        }
        if (this.bRq == bRb) {
            return (System.currentTimeMillis() / 1000) + this.bRr;
        }
        if (this.bRq == bRc) {
            long adI = (adI() / 1000) + this.bRr;
            if (System.currentTimeMillis() > adI) {
                return adI + 86400;
            }
            return adI;
        } else if (this.bRq == bRd) {
            return h((int) this.bRr, hb(4)) / 1000;
        } else {
            if (this.bRq == bRe) {
                return this.bRr / 1000;
            }
            return 0L;
        }
    }

    private long adI() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long hb(int i) {
        long adI = adI();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - adI;
    }

    private long h(int i, long j) {
        switch (i) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 1;
                break;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        if (calendar.get(7) == i && System.currentTimeMillis() - timeInMillis < j) {
            return calendar.getTimeInMillis() + j;
        }
        do {
            calendar.add(5, 1);
        } while (calendar.get(7) != i);
        return calendar.getTimeInMillis() + j;
    }

    public int getActivityId() {
        return this.bRf;
    }

    public void setActivityId(int i) {
        this.bRf = i;
    }

    public int adJ() {
        return this.bRg;
    }

    public void hc(int i) {
        this.bRg = i;
    }

    public String adK() {
        return this.bRl;
    }

    public void lQ(String str) {
        this.bRl = str;
    }

    public String adL() {
        return this.bRm;
    }

    public String getSource() {
        return this.mSource;
    }

    public int adM() {
        return this.bRu;
    }

    public void hd(int i) {
        this.bRu = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void he(int i) {
        this.mTaskType = i;
    }

    public String adN() {
        return this.bRi;
    }

    public void lR(String str) {
        this.bRi = str;
        this.bRs = lP(str);
    }

    public int[] adO() {
        return this.bRs;
    }

    public long adP() {
        return this.bRh;
    }

    public void aD(long j) {
        this.bRh = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int adQ() {
        return this.bRj;
    }

    public void hf(int i) {
        this.bRj = i;
    }

    public int adR() {
        return this.bRq;
    }

    public void hg(int i) {
        this.bRq = i;
    }

    public long adS() {
        return this.bRr;
    }

    public void aE(long j) {
        this.bRr = j;
    }

    public long adT() {
        return this.bRt;
    }

    public void aF(long j) {
        this.bRt = j;
    }

    public long getTid() {
        return this.bRk;
    }

    public void setTid(long j) {
        this.bRk = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String adU() {
        return this.bRn;
    }

    public void lS(String str) {
        this.bRn = str;
    }

    public String adV() {
        return this.bRo;
    }

    public void lT(String str) {
        this.bRo = str;
    }

    public long adW() {
        return this.bRp;
    }

    public void aG(long j) {
        this.bRp = j;
    }

    public int adX() {
        return this.bRy;
    }

    public void hh(int i) {
        this.bRy = i;
    }

    public void hi(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean adY() {
        return this.bRx;
    }

    public void dK(boolean z) {
        this.bRx = z;
    }
}
