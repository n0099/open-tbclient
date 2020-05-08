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
    private String dgA;
    private long dgB;
    private int dgC;
    private long dgD;
    private int[] dgE;
    private long dgF;
    private volatile int dgG;
    private volatile int dgH;
    private boolean dgI;
    private int dgJ;
    public boolean dgK;
    private final ArrayList<h> dgL;
    private int dgr;
    private int dgs;
    private long dgt;
    private String dgu;
    private int dgv;
    private long dgw;
    private String dgx;
    private String dgy;
    private String dgz;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int xP;
    public static String ACTIVITY_ID = "activityid";
    public static String dfN = "missionid";
    public static String dfO = "activitysource";
    public static String SOURCE = "source";
    public static String dfP = "tab";
    public static String dfQ = "calltype";
    public static String dfR = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String dfS = "browsetimepage";
    public static String dfT = "browsetime";
    public static String dfU = "threadnum";
    public static String dfV = "forumnum";
    public static String dfW = "cleartype";
    public static String dfX = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String dfY = "threadtext";
    public static String dfZ = "threadimg";
    public static String dga = "threadforum";
    public static String dgb = "total_limit";
    public static int dgc = -1;
    public static int dgd = 1;
    public static int dge = 2;
    public static int dgf = 3;
    public static int dgg = 4;
    public static int dgh = 5;
    public static int dgi = 6;
    public static int dgj = 7;
    public static int dgk = 8;
    public static int dgl = 9;
    public static int dgm = -1;
    public static int dgn = 0;
    public static int dgo = 1;
    public static int dgp = 2;
    public static int dgq = 3;

    public void reset() {
        this.dgL.clear();
        this.dgG = 0;
        this.dgH = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.dgL.contains(hVar)) {
                this.dgL.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.dgL.contains(hVar)) {
                this.dgL.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.dgL.contains(hVar)) {
                this.dgL.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.dgL.contains(hVar)) {
                this.dgL.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.dgL.contains(hVar)) {
            this.dgL.add(hVar);
        }
    }

    public ArrayList<h> aFm() {
        return this.dgL;
    }

    public int aFn() {
        int i;
        int size = this.dgL.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.dgL, i2);
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
        int size = this.dgL.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.dgL, i);
            if (hVar != null) {
                hVar.gh(true);
            }
        }
    }

    public boolean bS(long j) {
        for (int i = 0; i < this.dgL.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.dgL, i);
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
            ArrayList<h> arrayList = this.dgL;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.aGh());
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
        this.dgC = dgm;
        this.dgG = 0;
        this.dgH = 0;
        this.dgI = false;
        this.dgJ = 1;
        this.mTag = 0;
        this.dgK = false;
        this.dgL = new ArrayList<>();
    }

    public b(String str) {
        this.dgC = dgm;
        this.dgG = 0;
        this.dgH = 0;
        this.dgI = false;
        this.dgJ = 1;
        this.mTag = 0;
        this.dgK = false;
        this.dgL = new ArrayList<>();
        sG(str);
    }

    public boolean sG(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.dgr = jSONObject.optInt(ACTIVITY_ID);
                this.dgs = jSONObject.optInt(dfN);
                this.dgx = jSONObject.optString(dfO);
                this.mSource = jSONObject.optString(SOURCE);
                this.dgy = jSONObject.optString(dfP);
                this.xP = jSONObject.optInt(dfQ);
                this.mTaskType = jSONObject.optInt(dfR);
                this.dgu = jSONObject.optString(dfS);
                this.dgE = sH(this.dgu);
                this.dgt = jSONObject.optLong(dfT);
                this.mThreadNum = jSONObject.optInt(dfU);
                this.dgv = jSONObject.optInt(dfV);
                this.dgC = jSONObject.optInt(dfW);
                this.dgD = jSONObject.optLong(dfX);
                this.dgF = aFv();
                this.dgw = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.dgz = jSONObject.optString(dfY);
                this.dgA = jSONObject.optString(dfZ);
                this.dgB = jSONObject.optLong(dga);
                int optInt = jSONObject.optInt(dgb);
                if (optInt > 0) {
                    this.dgJ = optInt;
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
        this.dgC = dgm;
        this.dgG = 0;
        this.dgH = 0;
        this.dgI = false;
        this.dgJ = 1;
        this.mTag = 0;
        this.dgK = false;
        this.dgL = new ArrayList<>();
        if (missionInfo != null) {
            this.dgr = missionInfo.activityid.intValue();
            this.dgs = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.dgC = missionInfo.cleartype.intValue();
            this.dgD = missionInfo.cleartime.intValue();
            this.dgF = aFv();
            this.dgu = missionInfo.browsetimepage;
            this.dgE = sH(this.dgu);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.dgt = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.dgJ = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean aFq() {
        return this.dgr > 0 && this.dgs > 0 && this.mTaskType > 0 && this.dgt > 0;
    }

    public synchronized int aFr() {
        int i;
        i = this.dgH + 1;
        this.dgH = i;
        return i;
    }

    public synchronized int aFs() {
        int i;
        i = this.dgG + 1;
        this.dgG = i;
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
            return new int[]{dgc};
        }
        if (this.mTaskType == 7) {
            return new int[]{dgd, dgk, dgl};
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
        if (this.dgC == dgm) {
            return 0L;
        }
        if (this.dgC == dgn) {
            return (System.currentTimeMillis() / 1000) + this.dgD;
        }
        if (this.dgC == dgo) {
            long aFw = (aFw() / 1000) + this.dgD;
            if (System.currentTimeMillis() > aFw) {
                return aFw + 86400;
            }
            return aFw;
        } else if (this.dgC == dgp) {
            return l((int) this.dgD, jj(4)) / 1000;
        } else {
            if (this.dgC == dgq) {
                return this.dgD / 1000;
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
        return this.dgr;
    }

    public void setActivityId(int i) {
        this.dgr = i;
    }

    public int aFx() {
        return this.dgs;
    }

    public void jk(int i) {
        this.dgs = i;
    }

    public String aFy() {
        return this.dgx;
    }

    public void sI(String str) {
        this.dgx = str;
    }

    public String aFz() {
        return this.dgy;
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
        return this.dgu;
    }

    public void sJ(String str) {
        this.dgu = str;
        this.dgE = sH(str);
    }

    public int[] aFC() {
        return this.dgE;
    }

    public long aFD() {
        return this.dgt;
    }

    public void bT(long j) {
        this.dgt = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int aFE() {
        return this.dgv;
    }

    public void jn(int i) {
        this.dgv = i;
    }

    public int aFF() {
        return this.dgC;
    }

    public void jo(int i) {
        this.dgC = i;
    }

    public long aFG() {
        return this.dgD;
    }

    public void bU(long j) {
        this.dgD = j;
    }

    public long aFH() {
        return this.dgF;
    }

    public void bV(long j) {
        this.dgF = j;
    }

    public long getTid() {
        return this.dgw;
    }

    public void setTid(long j) {
        this.dgw = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String aFI() {
        return this.dgz;
    }

    public void sK(String str) {
        this.dgz = str;
    }

    public String aFJ() {
        return this.dgA;
    }

    public void sL(String str) {
        this.dgA = str;
    }

    public long aFK() {
        return this.dgB;
    }

    public void bW(long j) {
        this.dgB = j;
    }

    public int aFL() {
        return this.dgJ;
    }

    public void jp(int i) {
        this.dgJ = i;
    }

    public void jq(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean aFM() {
        return this.dgI;
    }

    public void gg(boolean z) {
        this.dgI = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
