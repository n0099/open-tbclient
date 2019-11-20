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
    private long bQA;
    private int[] bQB;
    private long bQC;
    private int bQD;
    private volatile int bQE;
    private volatile int bQF;
    private boolean bQG;
    private int bQH;
    public boolean bQI;
    private final ArrayList<h> bQJ;
    private int bQo;
    private int bQp;
    private long bQq;
    private String bQr;
    private int bQs;
    private long bQt;
    private String bQu;
    private String bQv;
    private String bQw;
    private String bQx;
    private long bQy;
    private int bQz;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String bPK = "missionid";
    public static String bPL = "activitysource";
    public static String SOURCE = "source";
    public static String bPM = "tab";
    public static String bPN = "calltype";
    public static String bPO = "tasktype";
    public static String bPP = "browsetimepage";
    public static String bPQ = "browsetime";
    public static String bPR = "threadnum";
    public static String bPS = "forumnum";
    public static String bPT = "cleartype";
    public static String bPU = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String bPV = "threadtext";
    public static String bPW = "threadimg";
    public static String bPX = "threadforum";
    public static String bPY = "total_limit";
    public static int bPZ = -1;
    public static int bQa = 1;
    public static int bQb = 2;
    public static int bQc = 3;
    public static int bQd = 4;
    public static int bQe = 5;
    public static int bQf = 6;
    public static int bQg = 7;
    public static int bQh = 8;
    public static int bQi = 9;
    public static int bQj = -1;
    public static int bQk = 0;
    public static int bQl = 1;
    public static int bQm = 2;
    public static int bQn = 3;

    public void reset() {
        this.bQJ.clear();
        this.bQE = 0;
        this.bQF = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.bQJ.contains(hVar)) {
                this.bQJ.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.bQJ.contains(hVar)) {
                this.bQJ.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.bQJ.contains(hVar)) {
                this.bQJ.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.bQJ.contains(hVar)) {
                this.bQJ.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.bQJ.contains(hVar)) {
            this.bQJ.add(hVar);
        }
    }

    public ArrayList<h> adw() {
        return this.bQJ;
    }

    public int adx() {
        int i;
        int size = this.bQJ.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.bQJ, i2);
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

    public void ady() {
        int size = this.bQJ.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.bQJ, i);
            if (hVar != null) {
                hVar.dL(true);
            }
        }
    }

    public boolean aB(long j) {
        for (int i = 0; i < this.bQJ.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.bQJ, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.aK()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void B(int i, String str) {
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
                        kVar.aG(optLong2);
                        kVar.hh(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.dL(optBoolean);
                        mVar.aG(optLong2);
                        mVar.hh(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.dL(optBoolean);
                        jVar.aG(optLong2);
                        jVar.hh(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.dL(optBoolean);
                    iVar.aG(optLong2);
                    iVar.hh(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.dL(optBoolean);
                    lVar.aG(optLong2);
                    lVar.hh(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String adz() {
        try {
            ArrayList<h> arrayList = this.bQJ;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.aeu());
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
        this.bQz = bQj;
        this.bQE = 0;
        this.bQF = 0;
        this.bQG = false;
        this.bQH = 1;
        this.mTag = 0;
        this.bQI = false;
        this.bQJ = new ArrayList<>();
    }

    public b(String str) {
        this.bQz = bQj;
        this.bQE = 0;
        this.bQF = 0;
        this.bQG = false;
        this.bQH = 1;
        this.mTag = 0;
        this.bQI = false;
        this.bQJ = new ArrayList<>();
        lO(str);
    }

    public boolean lO(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.bQo = jSONObject.optInt(ACTIVITY_ID);
                this.bQp = jSONObject.optInt(bPK);
                this.bQu = jSONObject.optString(bPL);
                this.mSource = jSONObject.optString(SOURCE);
                this.bQv = jSONObject.optString(bPM);
                this.bQD = jSONObject.optInt(bPN);
                this.mTaskType = jSONObject.optInt(bPO);
                this.bQr = jSONObject.optString(bPP);
                this.bQB = lP(this.bQr);
                this.bQq = jSONObject.optLong(bPQ);
                this.mThreadNum = jSONObject.optInt(bPR);
                this.bQs = jSONObject.optInt(bPS);
                this.bQz = jSONObject.optInt(bPT);
                this.bQA = jSONObject.optLong(bPU);
                this.bQC = adF();
                this.bQt = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.bQw = jSONObject.optString(bPV);
                this.bQx = jSONObject.optString(bPW);
                this.bQy = jSONObject.optLong(bPX);
                int optInt = jSONObject.optInt(bPY);
                if (optInt > 0) {
                    this.bQH = optInt;
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
        this.bQz = bQj;
        this.bQE = 0;
        this.bQF = 0;
        this.bQG = false;
        this.bQH = 1;
        this.mTag = 0;
        this.bQI = false;
        this.bQJ = new ArrayList<>();
        if (missionInfo != null) {
            this.bQo = missionInfo.activityid.intValue();
            this.bQp = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.bQz = missionInfo.cleartype.intValue();
            this.bQA = missionInfo.cleartime.intValue();
            this.bQC = adF();
            this.bQr = missionInfo.browsetimepage;
            this.bQB = lP(this.bQr);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.bQq = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.bQH = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean adA() {
        return this.bQo > 0 && this.bQp > 0 && this.mTaskType > 0 && this.bQq > 0;
    }

    public synchronized int adB() {
        int i;
        i = this.bQF + 1;
        this.bQF = i;
        return i;
    }

    public synchronized int adC() {
        int i;
        i = this.bQE + 1;
        this.bQE = i;
        return i;
    }

    public synchronized int adD() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] lP(String str) {
        if (this.mTaskType == 8) {
            return new int[]{bPZ};
        }
        if (this.mTaskType == 7) {
            return new int[]{bQa, bQh, bQi};
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

    public boolean adE() {
        return System.currentTimeMillis() > adR() * 1000;
    }

    public long adF() {
        if (this.bQz == bQj) {
            return 0L;
        }
        if (this.bQz == bQk) {
            return (System.currentTimeMillis() / 1000) + this.bQA;
        }
        if (this.bQz == bQl) {
            long adG = (adG() / 1000) + this.bQA;
            if (System.currentTimeMillis() > adG) {
                return adG + 86400;
            }
            return adG;
        } else if (this.bQz == bQm) {
            return f((int) this.bQA, ha(4)) / 1000;
        } else {
            if (this.bQz == bQn) {
                return this.bQA / 1000;
            }
            return 0L;
        }
    }

    private long adG() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long ha(int i) {
        long adG = adG();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - adG;
    }

    private long f(int i, long j) {
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
        return this.bQo;
    }

    public void setActivityId(int i) {
        this.bQo = i;
    }

    public int adH() {
        return this.bQp;
    }

    public void hb(int i) {
        this.bQp = i;
    }

    public String adI() {
        return this.bQu;
    }

    public void lQ(String str) {
        this.bQu = str;
    }

    public String adJ() {
        return this.bQv;
    }

    public String getSource() {
        return this.mSource;
    }

    public int adK() {
        return this.bQD;
    }

    public void hc(int i) {
        this.bQD = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void hd(int i) {
        this.mTaskType = i;
    }

    public String adL() {
        return this.bQr;
    }

    public void lR(String str) {
        this.bQr = str;
        this.bQB = lP(str);
    }

    public int[] adM() {
        return this.bQB;
    }

    public long adN() {
        return this.bQq;
    }

    public void aC(long j) {
        this.bQq = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int adO() {
        return this.bQs;
    }

    public void he(int i) {
        this.bQs = i;
    }

    public int adP() {
        return this.bQz;
    }

    public void hf(int i) {
        this.bQz = i;
    }

    public long adQ() {
        return this.bQA;
    }

    public void aD(long j) {
        this.bQA = j;
    }

    public long adR() {
        return this.bQC;
    }

    public void aE(long j) {
        this.bQC = j;
    }

    public long getTid() {
        return this.bQt;
    }

    public void setTid(long j) {
        this.bQt = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String adS() {
        return this.bQw;
    }

    public void lS(String str) {
        this.bQw = str;
    }

    public String adT() {
        return this.bQx;
    }

    public void lT(String str) {
        this.bQx = str;
    }

    public long adU() {
        return this.bQy;
    }

    public void aF(long j) {
        this.bQy = j;
    }

    public int adV() {
        return this.bQH;
    }

    public void hg(int i) {
        this.bQH = i;
    }

    public void hh(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean adW() {
        return this.bQG;
    }

    public void dK(boolean z) {
        this.bQG = z;
    }
}
