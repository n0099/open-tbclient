package com.baidu.tbadk.BdToken;

import com.baidu.down.request.db.DownloadDataConstants;
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
    private int cCP;
    private int cCQ;
    private long cCR;
    private String cCS;
    private int cCT;
    private long cCU;
    private String cCV;
    private String cCW;
    private String cCX;
    private String cCY;
    private long cCZ;
    private int cDa;
    private long cDb;
    private int[] cDc;
    private long cDd;
    private volatile int cDe;
    private volatile int cDf;
    private boolean cDg;
    private int cDh;
    public boolean cDi;
    private final ArrayList<h> cDj;
    private int mCallType;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String cCl = "missionid";
    public static String cCm = "activitysource";
    public static String SOURCE = "source";
    public static String cCn = "tab";
    public static String cCo = "calltype";
    public static String cCp = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String cCq = "browsetimepage";
    public static String cCr = "browsetime";
    public static String cCs = "threadnum";
    public static String cCt = "forumnum";
    public static String cCu = "cleartype";
    public static String cCv = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String cCw = "threadtext";
    public static String cCx = "threadimg";
    public static String cCy = "threadforum";
    public static String cCz = "total_limit";
    public static int cCA = -1;
    public static int cCB = 1;
    public static int cCC = 2;
    public static int cCD = 3;
    public static int cCE = 4;
    public static int cCF = 5;
    public static int cCG = 6;
    public static int cCH = 7;
    public static int cCI = 8;
    public static int cCJ = 9;
    public static int cCK = -1;
    public static int cCL = 0;
    public static int cCM = 1;
    public static int cCN = 2;
    public static int cCO = 3;

    public void reset() {
        this.cDj.clear();
        this.cDe = 0;
        this.cDf = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.cDj.contains(hVar)) {
                this.cDj.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.cDj.contains(hVar)) {
                this.cDj.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.cDj.contains(hVar)) {
                this.cDj.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.cDj.contains(hVar)) {
                this.cDj.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.cDj.contains(hVar)) {
            this.cDj.add(hVar);
        }
    }

    public ArrayList<h> aup() {
        return this.cDj;
    }

    public int auq() {
        int i;
        int size = this.cDj.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cDj, i2);
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

    public void aur() {
        int size = this.cDj.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cDj, i);
            if (hVar != null) {
                hVar.eX(true);
            }
        }
    }

    public boolean bg(long j) {
        for (int i = 0; i < this.cDj.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cDj, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.aW()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void J(int i, String str) {
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
                        kVar.eX(optBoolean);
                        kVar.bl(optLong2);
                        kVar.iS(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.eX(optBoolean);
                        mVar.bl(optLong2);
                        mVar.iS(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.eX(optBoolean);
                        jVar.bl(optLong2);
                        jVar.iS(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.eX(optBoolean);
                    iVar.bl(optLong2);
                    iVar.iS(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.eX(optBoolean);
                    lVar.bl(optLong2);
                    lVar.iS(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String aus() {
        try {
            ArrayList<h> arrayList = this.cDj;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.avn());
                jSONObject.put("c", hVar.aW());
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
        this.cDa = cCK;
        this.cDe = 0;
        this.cDf = 0;
        this.cDg = false;
        this.cDh = 1;
        this.mTag = 0;
        this.cDi = false;
        this.cDj = new ArrayList<>();
    }

    public b(String str) {
        this.cDa = cCK;
        this.cDe = 0;
        this.cDf = 0;
        this.cDg = false;
        this.cDh = 1;
        this.mTag = 0;
        this.cDi = false;
        this.cDj = new ArrayList<>();
        rb(str);
    }

    public boolean rb(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.cCP = jSONObject.optInt(ACTIVITY_ID);
                this.cCQ = jSONObject.optInt(cCl);
                this.cCV = jSONObject.optString(cCm);
                this.mSource = jSONObject.optString(SOURCE);
                this.cCW = jSONObject.optString(cCn);
                this.mCallType = jSONObject.optInt(cCo);
                this.mTaskType = jSONObject.optInt(cCp);
                this.cCS = jSONObject.optString(cCq);
                this.cDc = rc(this.cCS);
                this.cCR = jSONObject.optLong(cCr);
                this.mThreadNum = jSONObject.optInt(cCs);
                this.cCT = jSONObject.optInt(cCt);
                this.cDa = jSONObject.optInt(cCu);
                this.cDb = jSONObject.optLong(cCv);
                this.cDd = auy();
                this.cCU = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.cCX = jSONObject.optString(cCw);
                this.cCY = jSONObject.optString(cCx);
                this.cCZ = jSONObject.optLong(cCy);
                int optInt = jSONObject.optInt(cCz);
                if (optInt > 0) {
                    this.cDh = optInt;
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
        this.cDa = cCK;
        this.cDe = 0;
        this.cDf = 0;
        this.cDg = false;
        this.cDh = 1;
        this.mTag = 0;
        this.cDi = false;
        this.cDj = new ArrayList<>();
        if (missionInfo != null) {
            this.cCP = missionInfo.activityid.intValue();
            this.cCQ = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.cDa = missionInfo.cleartype.intValue();
            this.cDb = missionInfo.cleartime.intValue();
            this.cDd = auy();
            this.cCS = missionInfo.browsetimepage;
            this.cDc = rc(this.cCS);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.cCR = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.cDh = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean aut() {
        return this.cCP > 0 && this.cCQ > 0 && this.mTaskType > 0 && this.cCR > 0;
    }

    public synchronized int auu() {
        int i;
        i = this.cDf + 1;
        this.cDf = i;
        return i;
    }

    public synchronized int auv() {
        int i;
        i = this.cDe + 1;
        this.cDe = i;
        return i;
    }

    public synchronized int auw() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] rc(String str) {
        if (this.mTaskType == 8) {
            return new int[]{cCA};
        }
        if (this.mTaskType == 7) {
            return new int[]{cCB, cCI, cCJ};
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

    public boolean aux() {
        return System.currentTimeMillis() > auK() * 1000;
    }

    public long auy() {
        if (this.cDa == cCK) {
            return 0L;
        }
        if (this.cDa == cCL) {
            return (System.currentTimeMillis() / 1000) + this.cDb;
        }
        if (this.cDa == cCM) {
            long auz = (auz() / 1000) + this.cDb;
            if (System.currentTimeMillis() > auz) {
                return auz + 86400;
            }
            return auz;
        } else if (this.cDa == cCN) {
            return l((int) this.cDb, iL(4)) / 1000;
        } else {
            if (this.cDa == cCO) {
                return this.cDb / 1000;
            }
            return 0L;
        }
    }

    private long auz() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long iL(int i) {
        long auz = auz();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - auz;
    }

    private long l(int i, long j) {
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
        return this.cCP;
    }

    public void setActivityId(int i) {
        this.cCP = i;
    }

    public int auA() {
        return this.cCQ;
    }

    public void iM(int i) {
        this.cCQ = i;
    }

    public String auB() {
        return this.cCV;
    }

    public void rd(String str) {
        this.cCV = str;
    }

    public String auC() {
        return this.cCW;
    }

    public String getSource() {
        return this.mSource;
    }

    public int auD() {
        return this.mCallType;
    }

    public void iN(int i) {
        this.mCallType = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void iO(int i) {
        this.mTaskType = i;
    }

    public String auE() {
        return this.cCS;
    }

    public void re(String str) {
        this.cCS = str;
        this.cDc = rc(str);
    }

    public int[] auF() {
        return this.cDc;
    }

    public long auG() {
        return this.cCR;
    }

    public void bh(long j) {
        this.cCR = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int auH() {
        return this.cCT;
    }

    public void iP(int i) {
        this.cCT = i;
    }

    public int auI() {
        return this.cDa;
    }

    public void iQ(int i) {
        this.cDa = i;
    }

    public long auJ() {
        return this.cDb;
    }

    public void bi(long j) {
        this.cDb = j;
    }

    public long auK() {
        return this.cDd;
    }

    public void bj(long j) {
        this.cDd = j;
    }

    public long getTid() {
        return this.cCU;
    }

    public void setTid(long j) {
        this.cCU = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String auL() {
        return this.cCX;
    }

    public void rf(String str) {
        this.cCX = str;
    }

    public String auM() {
        return this.cCY;
    }

    public void rg(String str) {
        this.cCY = str;
    }

    public long auN() {
        return this.cCZ;
    }

    public void bk(long j) {
        this.cCZ = j;
    }

    public int auO() {
        return this.cDh;
    }

    public void iR(int i) {
        this.cDh = i;
    }

    public void iS(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean auP() {
        return this.cDg;
    }

    public void eW(boolean z) {
        this.cDg = z;
    }
}
