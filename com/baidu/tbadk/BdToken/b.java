package com.baidu.tbadk.BdToken;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class b {
    private int ecb;
    private int ecc;
    private long ecd;
    private String ece;
    private int ecf;
    private long ecg;
    private String ech;
    private String eci;
    private String ecj;
    private String eck;
    private long ecl;
    private int ecm;
    private long ecn;
    private int[] eco;
    private long ecp;
    private volatile int ecq;
    private volatile int ecr;
    private boolean ecs;
    private int ect;
    public boolean ecu;
    private final ArrayList<h> ecv;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int zf;
    public static String ACTIVITY_ID = "activityid";
    public static String ebx = "missionid";
    public static String eby = "activitysource";
    public static String SOURCE = "source";
    public static String ebz = "tab";
    public static String ebA = "calltype";
    public static String ebB = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String ebC = "browsetimepage";
    public static String ebD = "browsetime";
    public static String ebE = "threadnum";
    public static String ebF = "forumnum";
    public static String ebG = "cleartype";
    public static String ebH = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String ebI = "threadtext";
    public static String ebJ = "threadimg";
    public static String ebK = "threadforum";
    public static String ebL = "total_limit";
    public static int ebM = -1;
    public static int ebN = 1;
    public static int ebO = 2;
    public static int ebP = 3;
    public static int ebQ = 4;
    public static int ebR = 5;
    public static int ebS = 6;
    public static int ebT = 7;
    public static int ebU = 8;
    public static int ebV = 9;
    public static int ebW = -1;
    public static int ebX = 0;
    public static int ebY = 1;
    public static int ebZ = 2;
    public static int eca = 3;

    public void reset() {
        this.ecv.clear();
        this.ecq = 0;
        this.ecr = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.ecv.contains(hVar)) {
                this.ecv.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.ecv.contains(hVar)) {
                this.ecv.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.ecv.contains(hVar)) {
                this.ecv.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.ecv.contains(hVar)) {
                this.ecv.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.ecv.contains(hVar)) {
            this.ecv.add(hVar);
        }
    }

    public ArrayList<h> bbl() {
        return this.ecv;
    }

    public int bbm() {
        int i;
        int size = this.ecv.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) y.getItem(this.ecv, i2);
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

    public void bbn() {
        int size = this.ecv.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) y.getItem(this.ecv, i);
            if (hVar != null) {
                hVar.hP(true);
            }
        }
    }

    public boolean cA(long j) {
        for (int i = 0; i < this.ecv.size(); i++) {
            h hVar = (h) y.getItem(this.ecv, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.ik()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void av(int i, String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                long optLong = jSONObject.optLong("i");
                long optLong2 = jSONObject.optLong("t");
                boolean optBoolean = jSONObject.optBoolean("c");
                int optInt = jSONObject.optInt("a");
                if (i == 7) {
                    if (optLong > 0) {
                        k kVar = new k(this, optLong);
                        kVar.hP(optBoolean);
                        kVar.cF(optLong2);
                        kVar.nk(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.hP(optBoolean);
                        mVar.cF(optLong2);
                        mVar.nk(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.hP(optBoolean);
                        jVar.cF(optLong2);
                        jVar.nk(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.hP(optBoolean);
                    iVar.cF(optLong2);
                    iVar.nk(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.hP(optBoolean);
                    lVar.cF(optLong2);
                    lVar.nk(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String bbo() {
        try {
            ArrayList<h> arrayList = this.ecv;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) y.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.bcm());
                jSONObject.put("c", hVar.ik());
                jSONObject.put("a", hVar.getTag());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    public b() {
        this.ecm = ebW;
        this.ecq = 0;
        this.ecr = 0;
        this.ecs = false;
        this.ect = 1;
        this.mTag = 0;
        this.ecu = false;
        this.ecv = new ArrayList<>();
    }

    public b(String str) {
        this.ecm = ebW;
        this.ecq = 0;
        this.ecr = 0;
        this.ecs = false;
        this.ect = 1;
        this.mTag = 0;
        this.ecu = false;
        this.ecv = new ArrayList<>();
        yM(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            ne(activeCenterMissionData.mission_id);
            nj(activeCenterMissionData.total_limit);
            ng(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            ni(activeCenterMissionData.cleartype);
            cC(activeCenterMissionData.cleartime);
        }
    }

    public boolean yM(String str) {
        if (at.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.ecb = jSONObject.optInt(ACTIVITY_ID);
                this.ecc = jSONObject.optInt(ebx);
                this.ech = jSONObject.optString(eby);
                this.mSource = jSONObject.optString(SOURCE);
                this.eci = jSONObject.optString(ebz);
                this.zf = jSONObject.optInt(ebA);
                this.mTaskType = jSONObject.optInt(ebB);
                this.ece = jSONObject.optString(ebC);
                this.eco = yN(this.ece);
                this.ecd = jSONObject.optLong(ebD);
                this.mThreadNum = jSONObject.optInt(ebE);
                this.ecf = jSONObject.optInt(ebF);
                this.ecm = jSONObject.optInt(ebG);
                this.ecn = jSONObject.optLong(ebH);
                this.ecp = bbu();
                this.ecg = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.ecj = jSONObject.optString(ebI);
                this.eck = jSONObject.optString(ebJ);
                this.ecl = jSONObject.optLong(ebK);
                int optInt = jSONObject.optInt(ebL);
                if (optInt > 0) {
                    this.ect = optInt;
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
        this.ecm = ebW;
        this.ecq = 0;
        this.ecr = 0;
        this.ecs = false;
        this.ect = 1;
        this.mTag = 0;
        this.ecu = false;
        this.ecv = new ArrayList<>();
        if (missionInfo != null) {
            this.ecb = missionInfo.activityid.intValue();
            this.ecc = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.ecm = missionInfo.cleartype.intValue();
            this.ecn = missionInfo.cleartime.intValue();
            this.ecp = bbu();
            this.ece = missionInfo.browsetimepage;
            this.eco = yN(this.ece);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.ecd = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.ect = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean bbp() {
        return this.ecb > 0 && this.ecc > 0 && this.mTaskType > 0 && this.ecd > 0;
    }

    public synchronized int bbq() {
        int i;
        i = this.ecr + 1;
        this.ecr = i;
        return i;
    }

    public synchronized int bbr() {
        int i;
        i = this.ecq + 1;
        this.ecq = i;
        return i;
    }

    public synchronized int bbs() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] yN(String str) {
        if (this.mTaskType == 8) {
            return new int[]{ebM};
        }
        if (this.mTaskType == 7) {
            return new int[]{ebN, ebU, ebV};
        }
        if (str == null) {
            return null;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            int i2 = com.baidu.adp.lib.f.b.toInt(split[i], 0);
            if (i2 > 0) {
                iArr[i] = i2;
            }
        }
        return iArr;
    }

    public boolean bbt() {
        return System.currentTimeMillis() > bbG() * 1000;
    }

    public long bbu() {
        if (this.ecm == ebW) {
            return 0L;
        }
        if (this.ecm == ebX) {
            return (System.currentTimeMillis() / 1000) + this.ecn;
        }
        if (this.ecm == ebY) {
            long bbv = (bbv() / 1000) + this.ecn;
            if (System.currentTimeMillis() > bbv) {
                return bbv + 86400;
            }
            return bbv;
        } else if (this.ecm == ebZ) {
            return n((int) this.ecn, nd(4)) / 1000;
        } else {
            if (this.ecm == eca) {
                return this.ecn / 1000;
            }
            return 0L;
        }
    }

    private long bbv() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long nd(int i) {
        long bbv = bbv();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - bbv;
    }

    private long n(int i, long j) {
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
        return this.ecb;
    }

    public void setActivityId(int i) {
        this.ecb = i;
    }

    public int bbw() {
        return this.ecc;
    }

    public void ne(int i) {
        this.ecc = i;
    }

    public String bbx() {
        return this.ech;
    }

    public void yO(String str) {
        this.ech = str;
    }

    public String bby() {
        return this.eci;
    }

    public String getSource() {
        return this.mSource;
    }

    public int bbz() {
        return this.zf;
    }

    public void nf(int i) {
        this.zf = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void ng(int i) {
        this.mTaskType = i;
    }

    public String bbA() {
        return this.ece;
    }

    public void yP(String str) {
        this.ece = str;
        this.eco = yN(str);
    }

    public int[] bbB() {
        return this.eco;
    }

    public long bbC() {
        return this.ecd;
    }

    public void cB(long j) {
        this.ecd = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int bbD() {
        return this.ecf;
    }

    public void nh(int i) {
        this.ecf = i;
    }

    public int bbE() {
        return this.ecm;
    }

    public void ni(int i) {
        this.ecm = i;
    }

    public long bbF() {
        return this.ecn;
    }

    public void cC(long j) {
        this.ecn = j;
    }

    public long bbG() {
        return this.ecp;
    }

    public void cD(long j) {
        this.ecp = j;
    }

    public long getTid() {
        return this.ecg;
    }

    public void setTid(long j) {
        this.ecg = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String bbH() {
        return this.ecj;
    }

    public void yQ(String str) {
        this.ecj = str;
    }

    public String bbI() {
        return this.eck;
    }

    public void yR(String str) {
        this.eck = str;
    }

    public long bbJ() {
        return this.ecl;
    }

    public void cE(long j) {
        this.ecl = j;
    }

    public int bbK() {
        return this.ect;
    }

    public void nj(int i) {
        this.ect = i;
    }

    public void nk(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean bbL() {
        return this.ecs;
    }

    public void hO(boolean z) {
        this.ecs = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
