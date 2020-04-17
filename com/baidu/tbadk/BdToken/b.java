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
    private long dgA;
    private volatile int dgB;
    private volatile int dgC;
    private boolean dgD;
    private int dgE;
    public boolean dgF;
    private final ArrayList<h> dgG;
    private int dgm;
    private int dgn;
    private long dgo;
    private String dgp;
    private int dgq;
    private long dgr;
    private String dgs;
    private String dgt;
    private String dgu;
    private String dgv;
    private long dgw;
    private int dgx;
    private long dgy;
    private int[] dgz;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int xP;
    public static String ACTIVITY_ID = "activityid";
    public static String dfI = "missionid";
    public static String dfJ = "activitysource";
    public static String SOURCE = "source";
    public static String dfK = "tab";
    public static String dfL = "calltype";
    public static String dfM = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String dfN = "browsetimepage";
    public static String dfO = "browsetime";
    public static String dfP = "threadnum";
    public static String dfQ = "forumnum";
    public static String dfR = "cleartype";
    public static String dfS = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String dfT = "threadtext";
    public static String dfU = "threadimg";
    public static String dfV = "threadforum";
    public static String dfW = "total_limit";
    public static int dfX = -1;
    public static int dfY = 1;
    public static int dfZ = 2;
    public static int dga = 3;
    public static int dgb = 4;
    public static int dgc = 5;
    public static int dgd = 6;
    public static int dge = 7;
    public static int dgf = 8;
    public static int dgg = 9;
    public static int dgh = -1;
    public static int dgi = 0;
    public static int dgj = 1;
    public static int dgk = 2;
    public static int dgl = 3;

    public void reset() {
        this.dgG.clear();
        this.dgB = 0;
        this.dgC = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.dgG.contains(hVar)) {
                this.dgG.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.dgG.contains(hVar)) {
                this.dgG.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.dgG.contains(hVar)) {
                this.dgG.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.dgG.contains(hVar)) {
                this.dgG.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.dgG.contains(hVar)) {
            this.dgG.add(hVar);
        }
    }

    public ArrayList<h> aFm() {
        return this.dgG;
    }

    public int aFn() {
        int i;
        int size = this.dgG.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.dgG, i2);
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

    public void aFo() {
        int size = this.dgG.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.dgG, i);
            if (hVar != null) {
                hVar.gh(true);
            }
        }
    }

    public boolean bS(long j) {
        for (int i = 0; i < this.dgG.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.dgG, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.gt()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ae(int i, String str) {
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
                        kVar.gh(optBoolean);
                        kVar.bX(optLong2);
                        kVar.jq(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.gh(optBoolean);
                        mVar.bX(optLong2);
                        mVar.jq(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.gh(optBoolean);
                        jVar.bX(optLong2);
                        jVar.jq(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.gh(optBoolean);
                    iVar.bX(optLong2);
                    iVar.jq(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.gh(optBoolean);
                    lVar.bX(optLong2);
                    lVar.jq(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String aFp() {
        try {
            ArrayList<h> arrayList = this.dgG;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.aGj());
                jSONObject.put("c", hVar.gt());
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
        this.dgx = dgh;
        this.dgB = 0;
        this.dgC = 0;
        this.dgD = false;
        this.dgE = 1;
        this.mTag = 0;
        this.dgF = false;
        this.dgG = new ArrayList<>();
    }

    public b(String str) {
        this.dgx = dgh;
        this.dgB = 0;
        this.dgC = 0;
        this.dgD = false;
        this.dgE = 1;
        this.mTag = 0;
        this.dgF = false;
        this.dgG = new ArrayList<>();
        sG(str);
    }

    public boolean sG(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.dgm = jSONObject.optInt(ACTIVITY_ID);
                this.dgn = jSONObject.optInt(dfI);
                this.dgs = jSONObject.optString(dfJ);
                this.mSource = jSONObject.optString(SOURCE);
                this.dgt = jSONObject.optString(dfK);
                this.xP = jSONObject.optInt(dfL);
                this.mTaskType = jSONObject.optInt(dfM);
                this.dgp = jSONObject.optString(dfN);
                this.dgz = sH(this.dgp);
                this.dgo = jSONObject.optLong(dfO);
                this.mThreadNum = jSONObject.optInt(dfP);
                this.dgq = jSONObject.optInt(dfQ);
                this.dgx = jSONObject.optInt(dfR);
                this.dgy = jSONObject.optLong(dfS);
                this.dgA = aFv();
                this.dgr = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.dgu = jSONObject.optString(dfT);
                this.dgv = jSONObject.optString(dfU);
                this.dgw = jSONObject.optLong(dfV);
                int optInt = jSONObject.optInt(dfW);
                if (optInt > 0) {
                    this.dgE = optInt;
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
        this.dgx = dgh;
        this.dgB = 0;
        this.dgC = 0;
        this.dgD = false;
        this.dgE = 1;
        this.mTag = 0;
        this.dgF = false;
        this.dgG = new ArrayList<>();
        if (missionInfo != null) {
            this.dgm = missionInfo.activityid.intValue();
            this.dgn = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.dgx = missionInfo.cleartype.intValue();
            this.dgy = missionInfo.cleartime.intValue();
            this.dgA = aFv();
            this.dgp = missionInfo.browsetimepage;
            this.dgz = sH(this.dgp);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.dgo = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.dgE = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean aFq() {
        return this.dgm > 0 && this.dgn > 0 && this.mTaskType > 0 && this.dgo > 0;
    }

    public synchronized int aFr() {
        int i;
        i = this.dgC + 1;
        this.dgC = i;
        return i;
    }

    public synchronized int aFs() {
        int i;
        i = this.dgB + 1;
        this.dgB = i;
        return i;
    }

    public synchronized int aFt() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] sH(String str) {
        if (this.mTaskType == 8) {
            return new int[]{dfX};
        }
        if (this.mTaskType == 7) {
            return new int[]{dfY, dgf, dgg};
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

    public boolean aFu() {
        return System.currentTimeMillis() > aFH() * 1000;
    }

    public long aFv() {
        if (this.dgx == dgh) {
            return 0L;
        }
        if (this.dgx == dgi) {
            return (System.currentTimeMillis() / 1000) + this.dgy;
        }
        if (this.dgx == dgj) {
            long aFw = (aFw() / 1000) + this.dgy;
            if (System.currentTimeMillis() > aFw) {
                return aFw + 86400;
            }
            return aFw;
        } else if (this.dgx == dgk) {
            return l((int) this.dgy, jj(4)) / 1000;
        } else {
            if (this.dgx == dgl) {
                return this.dgy / 1000;
            }
            return 0L;
        }
    }

    private long aFw() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long jj(int i) {
        long aFw = aFw();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - aFw;
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
        return this.dgm;
    }

    public void setActivityId(int i) {
        this.dgm = i;
    }

    public int aFx() {
        return this.dgn;
    }

    public void jk(int i) {
        this.dgn = i;
    }

    public String aFy() {
        return this.dgs;
    }

    public void sI(String str) {
        this.dgs = str;
    }

    public String aFz() {
        return this.dgt;
    }

    public String getSource() {
        return this.mSource;
    }

    public int aFA() {
        return this.xP;
    }

    public void jl(int i) {
        this.xP = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void jm(int i) {
        this.mTaskType = i;
    }

    public String aFB() {
        return this.dgp;
    }

    public void sJ(String str) {
        this.dgp = str;
        this.dgz = sH(str);
    }

    public int[] aFC() {
        return this.dgz;
    }

    public long aFD() {
        return this.dgo;
    }

    public void bT(long j) {
        this.dgo = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int aFE() {
        return this.dgq;
    }

    public void jn(int i) {
        this.dgq = i;
    }

    public int aFF() {
        return this.dgx;
    }

    public void jo(int i) {
        this.dgx = i;
    }

    public long aFG() {
        return this.dgy;
    }

    public void bU(long j) {
        this.dgy = j;
    }

    public long aFH() {
        return this.dgA;
    }

    public void bV(long j) {
        this.dgA = j;
    }

    public long getTid() {
        return this.dgr;
    }

    public void setTid(long j) {
        this.dgr = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String aFI() {
        return this.dgu;
    }

    public void sK(String str) {
        this.dgu = str;
    }

    public String aFJ() {
        return this.dgv;
    }

    public void sL(String str) {
        this.dgv = str;
    }

    public long aFK() {
        return this.dgw;
    }

    public void bW(long j) {
        this.dgw = j;
    }

    public int aFL() {
        return this.dgE;
    }

    public void jp(int i) {
        this.dgE = i;
    }

    public void jq(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean aFM() {
        return this.dgD;
    }

    public void gg(boolean z) {
        this.dgD = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
