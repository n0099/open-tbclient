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
    private int cDa;
    private int cDb;
    private long cDc;
    private String cDd;
    private int cDe;
    private long cDf;
    private String cDg;
    private String cDh;
    private String cDi;
    private String cDj;
    private long cDk;
    private int cDl;
    private long cDm;
    private int[] cDn;
    private long cDo;
    private volatile int cDp;
    private volatile int cDq;
    private boolean cDr;
    private int cDs;
    public boolean cDt;
    private final ArrayList<h> cDu;
    private int mCallType;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    public static String ACTIVITY_ID = "activityid";
    public static String cCw = "missionid";
    public static String cCx = "activitysource";
    public static String SOURCE = "source";
    public static String cCy = "tab";
    public static String cCz = "calltype";
    public static String cCA = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String cCB = "browsetimepage";
    public static String cCC = "browsetime";
    public static String cCD = "threadnum";
    public static String cCE = "forumnum";
    public static String cCF = "cleartype";
    public static String cCG = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String cCH = "threadtext";
    public static String cCI = "threadimg";
    public static String cCJ = "threadforum";
    public static String cCK = "total_limit";
    public static int cCL = -1;
    public static int cCM = 1;
    public static int cCN = 2;
    public static int cCO = 3;
    public static int cCP = 4;
    public static int cCQ = 5;
    public static int cCR = 6;
    public static int cCS = 7;
    public static int cCT = 8;
    public static int cCU = 9;
    public static int cCV = -1;
    public static int cCW = 0;
    public static int cCX = 1;
    public static int cCY = 2;
    public static int cCZ = 3;

    public void reset() {
        this.cDu.clear();
        this.cDp = 0;
        this.cDq = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.cDu.contains(hVar)) {
                this.cDu.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.cDu.contains(hVar)) {
                this.cDu.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.cDu.contains(hVar)) {
                this.cDu.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.cDu.contains(hVar)) {
                this.cDu.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.cDu.contains(hVar)) {
            this.cDu.add(hVar);
        }
    }

    public ArrayList<h> auI() {
        return this.cDu;
    }

    public int auJ() {
        int i;
        int size = this.cDu.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cDu, i2);
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

    public void auK() {
        int size = this.cDu.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cDu, i);
            if (hVar != null) {
                hVar.fc(true);
            }
        }
    }

    public boolean bj(long j) {
        for (int i = 0; i < this.cDu.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cDu, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.aW()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void L(int i, String str) {
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
                        kVar.fc(optBoolean);
                        kVar.bo(optLong2);
                        kVar.iS(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.fc(optBoolean);
                        mVar.bo(optLong2);
                        mVar.iS(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.fc(optBoolean);
                        jVar.bo(optLong2);
                        jVar.iS(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.fc(optBoolean);
                    iVar.bo(optLong2);
                    iVar.iS(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.fc(optBoolean);
                    lVar.bo(optLong2);
                    lVar.iS(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String auL() {
        try {
            ArrayList<h> arrayList = this.cDu;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.avG());
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
        this.cDl = cCV;
        this.cDp = 0;
        this.cDq = 0;
        this.cDr = false;
        this.cDs = 1;
        this.mTag = 0;
        this.cDt = false;
        this.cDu = new ArrayList<>();
    }

    public b(String str) {
        this.cDl = cCV;
        this.cDp = 0;
        this.cDq = 0;
        this.cDr = false;
        this.cDs = 1;
        this.mTag = 0;
        this.cDt = false;
        this.cDu = new ArrayList<>();
        re(str);
    }

    public boolean re(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.cDa = jSONObject.optInt(ACTIVITY_ID);
                this.cDb = jSONObject.optInt(cCw);
                this.cDg = jSONObject.optString(cCx);
                this.mSource = jSONObject.optString(SOURCE);
                this.cDh = jSONObject.optString(cCy);
                this.mCallType = jSONObject.optInt(cCz);
                this.mTaskType = jSONObject.optInt(cCA);
                this.cDd = jSONObject.optString(cCB);
                this.cDn = rf(this.cDd);
                this.cDc = jSONObject.optLong(cCC);
                this.mThreadNum = jSONObject.optInt(cCD);
                this.cDe = jSONObject.optInt(cCE);
                this.cDl = jSONObject.optInt(cCF);
                this.cDm = jSONObject.optLong(cCG);
                this.cDo = auR();
                this.cDf = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.cDi = jSONObject.optString(cCH);
                this.cDj = jSONObject.optString(cCI);
                this.cDk = jSONObject.optLong(cCJ);
                int optInt = jSONObject.optInt(cCK);
                if (optInt > 0) {
                    this.cDs = optInt;
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
        this.cDl = cCV;
        this.cDp = 0;
        this.cDq = 0;
        this.cDr = false;
        this.cDs = 1;
        this.mTag = 0;
        this.cDt = false;
        this.cDu = new ArrayList<>();
        if (missionInfo != null) {
            this.cDa = missionInfo.activityid.intValue();
            this.cDb = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.cDl = missionInfo.cleartype.intValue();
            this.cDm = missionInfo.cleartime.intValue();
            this.cDo = auR();
            this.cDd = missionInfo.browsetimepage;
            this.cDn = rf(this.cDd);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.cDc = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.cDs = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean auM() {
        return this.cDa > 0 && this.cDb > 0 && this.mTaskType > 0 && this.cDc > 0;
    }

    public synchronized int auN() {
        int i;
        i = this.cDq + 1;
        this.cDq = i;
        return i;
    }

    public synchronized int auO() {
        int i;
        i = this.cDp + 1;
        this.cDp = i;
        return i;
    }

    public synchronized int auP() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] rf(String str) {
        if (this.mTaskType == 8) {
            return new int[]{cCL};
        }
        if (this.mTaskType == 7) {
            return new int[]{cCM, cCT, cCU};
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

    public boolean auQ() {
        return System.currentTimeMillis() > avd() * 1000;
    }

    public long auR() {
        if (this.cDl == cCV) {
            return 0L;
        }
        if (this.cDl == cCW) {
            return (System.currentTimeMillis() / 1000) + this.cDm;
        }
        if (this.cDl == cCX) {
            long auS = (auS() / 1000) + this.cDm;
            if (System.currentTimeMillis() > auS) {
                return auS + 86400;
            }
            return auS;
        } else if (this.cDl == cCY) {
            return l((int) this.cDm, iL(4)) / 1000;
        } else {
            if (this.cDl == cCZ) {
                return this.cDm / 1000;
            }
            return 0L;
        }
    }

    private long auS() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long iL(int i) {
        long auS = auS();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - auS;
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
        return this.cDa;
    }

    public void setActivityId(int i) {
        this.cDa = i;
    }

    public int auT() {
        return this.cDb;
    }

    public void iM(int i) {
        this.cDb = i;
    }

    public String auU() {
        return this.cDg;
    }

    public void rg(String str) {
        this.cDg = str;
    }

    public String auV() {
        return this.cDh;
    }

    public String getSource() {
        return this.mSource;
    }

    public int auW() {
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

    public String auX() {
        return this.cDd;
    }

    public void rh(String str) {
        this.cDd = str;
        this.cDn = rf(str);
    }

    public int[] auY() {
        return this.cDn;
    }

    public long auZ() {
        return this.cDc;
    }

    public void bk(long j) {
        this.cDc = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int ava() {
        return this.cDe;
    }

    public void iP(int i) {
        this.cDe = i;
    }

    public int avb() {
        return this.cDl;
    }

    public void iQ(int i) {
        this.cDl = i;
    }

    public long avc() {
        return this.cDm;
    }

    public void bl(long j) {
        this.cDm = j;
    }

    public long avd() {
        return this.cDo;
    }

    public void bm(long j) {
        this.cDo = j;
    }

    public long getTid() {
        return this.cDf;
    }

    public void setTid(long j) {
        this.cDf = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String ave() {
        return this.cDi;
    }

    public void ri(String str) {
        this.cDi = str;
    }

    public String avf() {
        return this.cDj;
    }

    public void rj(String str) {
        this.cDj = str;
    }

    public long avg() {
        return this.cDk;
    }

    public void bn(long j) {
        this.cDk = j;
    }

    public int avh() {
        return this.cDs;
    }

    public void iR(int i) {
        this.cDs = i;
    }

    public void iS(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean avi() {
        return this.cDr;
    }

    public void fb(boolean z) {
        this.cDr = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
