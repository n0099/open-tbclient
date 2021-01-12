package com.baidu.tbadk.BdToken;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.at;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class b {
    private int[] eAA;
    private long eAB;
    private volatile int eAC;
    private volatile int eAD;
    private boolean eAE;
    private int eAF;
    public boolean eAG;
    private final ArrayList<h> eAH;
    private int eAn;
    private int eAo;
    private long eAp;
    private String eAq;
    private int eAr;
    private long eAs;
    private String eAt;
    private String eAu;
    private String eAv;
    private String eAw;
    private long eAx;
    private int eAy;
    private long eAz;
    private int mCallType;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    public static String ACTIVITY_ID = "activityid";
    public static String ezJ = "missionid";
    public static String ezK = "activitysource";
    public static String SOURCE = "source";
    public static String ezL = "tab";
    public static String ezM = "calltype";
    public static String ezN = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String ezO = "browsetimepage";
    public static String ezP = "browsetime";
    public static String ezQ = "threadnum";
    public static String ezR = "forumnum";
    public static String ezS = "cleartype";
    public static String ezT = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String ezU = "threadtext";
    public static String ezV = "threadimg";
    public static String ezW = "threadforum";
    public static String ezX = "total_limit";
    public static int ezY = -1;
    public static int ezZ = 1;
    public static int eAa = 2;
    public static int eAb = 3;
    public static int eAc = 4;
    public static int eAd = 5;
    public static int eAe = 6;
    public static int eAf = 7;
    public static int eAg = 8;
    public static int eAh = 9;
    public static int eAi = -1;
    public static int eAj = 0;
    public static int eAk = 1;
    public static int eAl = 2;
    public static int eAm = 3;

    public void reset() {
        this.eAH.clear();
        this.eAC = 0;
        this.eAD = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.eAH.contains(hVar)) {
                this.eAH.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.eAH.contains(hVar)) {
                this.eAH.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.eAH.contains(hVar)) {
                this.eAH.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.eAH.contains(hVar)) {
                this.eAH.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.eAH.contains(hVar)) {
            this.eAH.add(hVar);
        }
    }

    public ArrayList<h> bgz() {
        return this.eAH;
    }

    public int bgA() {
        int i;
        int size = this.eAH.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.x.getItem(this.eAH, i2);
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

    public void bgB() {
        int size = this.eAH.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.x.getItem(this.eAH, i);
            if (hVar != null) {
                hVar.iU(true);
            }
        }
    }

    public boolean dx(long j) {
        for (int i = 0; i < this.eAH.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.x.getItem(this.eAH, i);
            if (hVar != null) {
                long b2 = b(hVar);
                if (b2 > 0 && b2 == j && hVar.isCompleted()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void aE(int i, String str) {
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
                        kVar.iU(optBoolean);
                        kVar.dC(optLong2);
                        kVar.mC(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.iU(optBoolean);
                        mVar.dC(optLong2);
                        mVar.mC(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.iU(optBoolean);
                        jVar.dC(optLong2);
                        jVar.mC(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.iU(optBoolean);
                    iVar.dC(optLong2);
                    iVar.mC(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.iU(optBoolean);
                    lVar.dC(optLong2);
                    lVar.mC(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String bgC() {
        try {
            ArrayList<h> arrayList = this.eAH;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.x.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.bhA());
                jSONObject.put("c", hVar.isCompleted());
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
        this.eAy = eAi;
        this.eAC = 0;
        this.eAD = 0;
        this.eAE = false;
        this.eAF = 1;
        this.mTag = 0;
        this.eAG = false;
        this.eAH = new ArrayList<>();
    }

    public b(String str) {
        this.eAy = eAi;
        this.eAC = 0;
        this.eAD = 0;
        this.eAE = false;
        this.eAF = 1;
        this.mTag = 0;
        this.eAG = false;
        this.eAH = new ArrayList<>();
        yF(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            mw(activeCenterMissionData.mission_id);
            mB(activeCenterMissionData.total_limit);
            my(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            mA(activeCenterMissionData.cleartype);
            dz(activeCenterMissionData.cleartime);
        }
    }

    public boolean yF(String str) {
        if (at.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.eAn = jSONObject.optInt(ACTIVITY_ID);
                this.eAo = jSONObject.optInt(ezJ);
                this.eAt = jSONObject.optString(ezK);
                this.mSource = jSONObject.optString(SOURCE);
                this.eAu = jSONObject.optString(ezL);
                this.mCallType = jSONObject.optInt(ezM);
                this.mTaskType = jSONObject.optInt(ezN);
                this.eAq = jSONObject.optString(ezO);
                this.eAA = yG(this.eAq);
                this.eAp = jSONObject.optLong(ezP);
                this.mThreadNum = jSONObject.optInt(ezQ);
                this.eAr = jSONObject.optInt(ezR);
                this.eAy = jSONObject.optInt(ezS);
                this.eAz = jSONObject.optLong(ezT);
                this.eAB = bgI();
                this.eAs = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.eAv = jSONObject.optString(ezU);
                this.eAw = jSONObject.optString(ezV);
                this.eAx = jSONObject.optLong(ezW);
                int optInt = jSONObject.optInt(ezX);
                if (optInt > 0) {
                    this.eAF = optInt;
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
        this.eAy = eAi;
        this.eAC = 0;
        this.eAD = 0;
        this.eAE = false;
        this.eAF = 1;
        this.mTag = 0;
        this.eAG = false;
        this.eAH = new ArrayList<>();
        if (missionInfo != null) {
            this.eAn = missionInfo.activityid.intValue();
            this.eAo = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.eAy = missionInfo.cleartype.intValue();
            this.eAz = missionInfo.cleartime.intValue();
            this.eAB = bgI();
            this.eAq = missionInfo.browsetimepage;
            this.eAA = yG(this.eAq);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.eAp = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.eAF = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean bgD() {
        return this.eAn > 0 && this.eAo > 0 && this.mTaskType > 0 && this.eAp > 0;
    }

    public synchronized int bgE() {
        int i;
        i = this.eAD + 1;
        this.eAD = i;
        return i;
    }

    public synchronized int bgF() {
        int i;
        i = this.eAC + 1;
        this.eAC = i;
        return i;
    }

    public synchronized int bgG() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] yG(String str) {
        if (this.mTaskType == 8) {
            return new int[]{ezY};
        }
        if (this.mTaskType == 7) {
            return new int[]{ezZ, eAg, eAh};
        }
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            int i2 = com.baidu.adp.lib.f.b.toInt(split[i], 0);
            if (i2 > 0) {
                iArr[i] = i2;
            }
        }
        return iArr;
    }

    public boolean bgH() {
        return System.currentTimeMillis() > bgU() * 1000;
    }

    public long bgI() {
        if (this.eAy == eAi) {
            return 0L;
        }
        if (this.eAy == eAj) {
            return (System.currentTimeMillis() / 1000) + this.eAz;
        }
        if (this.eAy == eAk) {
            long bgJ = (bgJ() / 1000) + this.eAz;
            if (System.currentTimeMillis() > bgJ) {
                return bgJ + 86400;
            }
            return bgJ;
        } else if (this.eAy == eAl) {
            return m((int) this.eAz, mv(4)) / 1000;
        } else {
            if (this.eAy == eAm) {
                return this.eAz / 1000;
            }
            return 0L;
        }
    }

    private long bgJ() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long mv(int i) {
        long bgJ = bgJ();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - bgJ;
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
        return this.eAn;
    }

    public void setActivityId(int i) {
        this.eAn = i;
    }

    public int bgK() {
        return this.eAo;
    }

    public void mw(int i) {
        this.eAo = i;
    }

    public String bgL() {
        return this.eAt;
    }

    public void yH(String str) {
        this.eAt = str;
    }

    public String bgM() {
        return this.eAu;
    }

    public String getSource() {
        return this.mSource;
    }

    public int bgN() {
        return this.mCallType;
    }

    public void mx(int i) {
        this.mCallType = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void my(int i) {
        this.mTaskType = i;
    }

    public String bgO() {
        return this.eAq;
    }

    public void yI(String str) {
        this.eAq = str;
        this.eAA = yG(str);
    }

    public int[] bgP() {
        return this.eAA;
    }

    public long bgQ() {
        return this.eAp;
    }

    public void dy(long j) {
        this.eAp = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int bgR() {
        return this.eAr;
    }

    public void mz(int i) {
        this.eAr = i;
    }

    public int bgS() {
        return this.eAy;
    }

    public void mA(int i) {
        this.eAy = i;
    }

    public long bgT() {
        return this.eAz;
    }

    public void dz(long j) {
        this.eAz = j;
    }

    public long bgU() {
        return this.eAB;
    }

    public void dA(long j) {
        this.eAB = j;
    }

    public long getTid() {
        return this.eAs;
    }

    public void setTid(long j) {
        this.eAs = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String bgV() {
        return this.eAv;
    }

    public void yJ(String str) {
        this.eAv = str;
    }

    public String bgW() {
        return this.eAw;
    }

    public void yK(String str) {
        this.eAw = str;
    }

    public long bgX() {
        return this.eAx;
    }

    public void dB(long j) {
        this.eAx = j;
    }

    public int bgY() {
        return this.eAF;
    }

    public void mB(int i) {
        this.eAF = i;
    }

    public void mC(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean bgZ() {
        return this.eAE;
    }

    public void iT(boolean z) {
        this.eAE = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
