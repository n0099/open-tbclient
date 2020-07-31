package com.baidu.tbadk.BdToken;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.as;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class b {
    private int dEL;
    private int dEM;
    private long dEN;
    private String dEO;
    private int dEP;
    private long dEQ;
    private String dER;
    private String dES;
    private String dET;
    private String dEU;
    private long dEV;
    private int dEW;
    private long dEX;
    private int[] dEY;
    private long dEZ;
    private volatile int dFa;
    private volatile int dFb;
    private boolean dFc;
    private int dFd;
    public boolean dFe;
    private final ArrayList<h> dFf;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int yp;
    public static String ACTIVITY_ID = "activityid";
    public static String dEh = "missionid";
    public static String dEi = "activitysource";
    public static String SOURCE = "source";
    public static String dEj = "tab";
    public static String dEk = "calltype";
    public static String dEl = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String dEm = "browsetimepage";
    public static String dEn = "browsetime";
    public static String dEo = "threadnum";
    public static String dEp = "forumnum";
    public static String dEq = "cleartype";
    public static String dEr = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String dEs = "threadtext";
    public static String dEt = "threadimg";
    public static String dEu = "threadforum";
    public static String dEv = "total_limit";
    public static int dEw = -1;
    public static int dEx = 1;
    public static int dEy = 2;
    public static int dEz = 3;
    public static int dEA = 4;
    public static int dEB = 5;
    public static int dEC = 6;
    public static int dED = 7;
    public static int dEE = 8;
    public static int dEF = 9;
    public static int dEG = -1;
    public static int dEH = 0;
    public static int dEI = 1;
    public static int dEJ = 2;
    public static int dEK = 3;

    public void reset() {
        this.dFf.clear();
        this.dFa = 0;
        this.dFb = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.dFf.contains(hVar)) {
                this.dFf.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.dFf.contains(hVar)) {
                this.dFf.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.dFf.contains(hVar)) {
                this.dFf.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.dFf.contains(hVar)) {
                this.dFf.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.dFf.contains(hVar)) {
            this.dFf.add(hVar);
        }
    }

    public ArrayList<h> aPB() {
        return this.dFf;
    }

    public int aPC() {
        int i;
        int size = this.dFf.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.x.getItem(this.dFf, i2);
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

    public void aPD() {
        int size = this.dFf.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.x.getItem(this.dFf, i);
            if (hVar != null) {
                hVar.gZ(true);
            }
        }
    }

    public boolean ch(long j) {
        for (int i = 0; i < this.dFf.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.x.getItem(this.dFf, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.gJ()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void al(int i, String str) {
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
                        kVar.gZ(optBoolean);
                        kVar.cm(optLong2);
                        kVar.kw(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.gZ(optBoolean);
                        mVar.cm(optLong2);
                        mVar.kw(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.gZ(optBoolean);
                        jVar.cm(optLong2);
                        jVar.kw(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.gZ(optBoolean);
                    iVar.cm(optLong2);
                    iVar.kw(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.gZ(optBoolean);
                    lVar.cm(optLong2);
                    lVar.kw(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String aPE() {
        try {
            ArrayList<h> arrayList = this.dFf;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.x.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.aQB());
                jSONObject.put("c", hVar.gJ());
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
        this.dEW = dEG;
        this.dFa = 0;
        this.dFb = 0;
        this.dFc = false;
        this.dFd = 1;
        this.mTag = 0;
        this.dFe = false;
        this.dFf = new ArrayList<>();
    }

    public b(String str) {
        this.dEW = dEG;
        this.dFa = 0;
        this.dFb = 0;
        this.dFc = false;
        this.dFd = 1;
        this.mTag = 0;
        this.dFe = false;
        this.dFf = new ArrayList<>();
        vv(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            kq(activeCenterMissionData.mission_id);
            kv(activeCenterMissionData.total_limit);
            ks(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            ku(activeCenterMissionData.cleartype);
            cj(activeCenterMissionData.cleartime);
        }
    }

    public boolean vv(String str) {
        if (as.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.dEL = jSONObject.optInt(ACTIVITY_ID);
                this.dEM = jSONObject.optInt(dEh);
                this.dER = jSONObject.optString(dEi);
                this.mSource = jSONObject.optString(SOURCE);
                this.dES = jSONObject.optString(dEj);
                this.yp = jSONObject.optInt(dEk);
                this.mTaskType = jSONObject.optInt(dEl);
                this.dEO = jSONObject.optString(dEm);
                this.dEY = vw(this.dEO);
                this.dEN = jSONObject.optLong(dEn);
                this.mThreadNum = jSONObject.optInt(dEo);
                this.dEP = jSONObject.optInt(dEp);
                this.dEW = jSONObject.optInt(dEq);
                this.dEX = jSONObject.optLong(dEr);
                this.dEZ = aPK();
                this.dEQ = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.dET = jSONObject.optString(dEs);
                this.dEU = jSONObject.optString(dEt);
                this.dEV = jSONObject.optLong(dEu);
                int optInt = jSONObject.optInt(dEv);
                if (optInt > 0) {
                    this.dFd = optInt;
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
        this.dEW = dEG;
        this.dFa = 0;
        this.dFb = 0;
        this.dFc = false;
        this.dFd = 1;
        this.mTag = 0;
        this.dFe = false;
        this.dFf = new ArrayList<>();
        if (missionInfo != null) {
            this.dEL = missionInfo.activityid.intValue();
            this.dEM = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.dEW = missionInfo.cleartype.intValue();
            this.dEX = missionInfo.cleartime.intValue();
            this.dEZ = aPK();
            this.dEO = missionInfo.browsetimepage;
            this.dEY = vw(this.dEO);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.dEN = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.dFd = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean aPF() {
        return this.dEL > 0 && this.dEM > 0 && this.mTaskType > 0 && this.dEN > 0;
    }

    public synchronized int aPG() {
        int i;
        i = this.dFb + 1;
        this.dFb = i;
        return i;
    }

    public synchronized int aPH() {
        int i;
        i = this.dFa + 1;
        this.dFa = i;
        return i;
    }

    public synchronized int aPI() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] vw(String str) {
        if (this.mTaskType == 8) {
            return new int[]{dEw};
        }
        if (this.mTaskType == 7) {
            return new int[]{dEx, dEE, dEF};
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

    public boolean aPJ() {
        return System.currentTimeMillis() > aPW() * 1000;
    }

    public long aPK() {
        if (this.dEW == dEG) {
            return 0L;
        }
        if (this.dEW == dEH) {
            return (System.currentTimeMillis() / 1000) + this.dEX;
        }
        if (this.dEW == dEI) {
            long aPL = (aPL() / 1000) + this.dEX;
            if (System.currentTimeMillis() > aPL) {
                return aPL + 86400;
            }
            return aPL;
        } else if (this.dEW == dEJ) {
            return m((int) this.dEX, kp(4)) / 1000;
        } else {
            if (this.dEW == dEK) {
                return this.dEX / 1000;
            }
            return 0L;
        }
    }

    private long aPL() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long kp(int i) {
        long aPL = aPL();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - aPL;
    }

    private long m(int i, long j) {
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
        return this.dEL;
    }

    public void setActivityId(int i) {
        this.dEL = i;
    }

    public int aPM() {
        return this.dEM;
    }

    public void kq(int i) {
        this.dEM = i;
    }

    public String aPN() {
        return this.dER;
    }

    public void vx(String str) {
        this.dER = str;
    }

    public String aPO() {
        return this.dES;
    }

    public String getSource() {
        return this.mSource;
    }

    public int aPP() {
        return this.yp;
    }

    public void kr(int i) {
        this.yp = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void ks(int i) {
        this.mTaskType = i;
    }

    public String aPQ() {
        return this.dEO;
    }

    public void vy(String str) {
        this.dEO = str;
        this.dEY = vw(str);
    }

    public int[] aPR() {
        return this.dEY;
    }

    public long aPS() {
        return this.dEN;
    }

    public void ci(long j) {
        this.dEN = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int aPT() {
        return this.dEP;
    }

    public void kt(int i) {
        this.dEP = i;
    }

    public int aPU() {
        return this.dEW;
    }

    public void ku(int i) {
        this.dEW = i;
    }

    public long aPV() {
        return this.dEX;
    }

    public void cj(long j) {
        this.dEX = j;
    }

    public long aPW() {
        return this.dEZ;
    }

    public void ck(long j) {
        this.dEZ = j;
    }

    public long getTid() {
        return this.dEQ;
    }

    public void setTid(long j) {
        this.dEQ = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String aPX() {
        return this.dET;
    }

    public void vz(String str) {
        this.dET = str;
    }

    public String aPY() {
        return this.dEU;
    }

    public void vA(String str) {
        this.dEU = str;
    }

    public long aPZ() {
        return this.dEV;
    }

    public void cl(long j) {
        this.dEV = j;
    }

    public int aQa() {
        return this.dFd;
    }

    public void kv(int i) {
        this.dFd = i;
    }

    public void kw(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean aQb() {
        return this.dFc;
    }

    public void gY(boolean z) {
        this.dFc = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
