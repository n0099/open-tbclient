package com.baidu.tbadk.BdToken;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class b {
    private int evJ;
    private int evK;
    private long evL;
    private String evM;
    private int evN;
    private long evO;
    private String evP;
    private String evQ;
    private String evR;
    private String evS;
    private long evT;
    private int evU;
    private long evV;
    private int[] evW;
    private long evX;
    private volatile int evY;
    private volatile int evZ;
    private boolean ewa;
    private int ewb;
    public boolean ewc;
    private final ArrayList<h> ewd;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int zV;
    public static String ACTIVITY_ID = "activityid";
    public static String evf = "missionid";
    public static String evg = "activitysource";
    public static String SOURCE = "source";
    public static String evh = "tab";
    public static String evi = "calltype";
    public static String evj = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String evk = "browsetimepage";
    public static String evl = "browsetime";
    public static String evm = "threadnum";
    public static String evn = "forumnum";
    public static String evo = "cleartype";
    public static String evp = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String evq = "threadtext";
    public static String evr = "threadimg";
    public static String evs = "threadforum";
    public static String evt = "total_limit";
    public static int evu = -1;
    public static int evv = 1;
    public static int evw = 2;
    public static int evx = 3;
    public static int evy = 4;
    public static int evz = 5;
    public static int evA = 6;
    public static int evB = 7;
    public static int evC = 8;
    public static int evD = 9;
    public static int evE = -1;
    public static int evF = 0;
    public static int evG = 1;
    public static int evH = 2;
    public static int evI = 3;

    public void reset() {
        this.ewd.clear();
        this.evY = 0;
        this.evZ = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.ewd.contains(hVar)) {
                this.ewd.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.ewd.contains(hVar)) {
                this.ewd.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.ewd.contains(hVar)) {
                this.ewd.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.ewd.contains(hVar)) {
                this.ewd.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.ewd.contains(hVar)) {
            this.ewd.add(hVar);
        }
    }

    public ArrayList<h> bic() {
        return this.ewd;
    }

    public int bid() {
        int i;
        int size = this.ewd.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) y.getItem(this.ewd, i2);
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

    public void bie() {
        int size = this.ewd.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) y.getItem(this.ewd, i);
            if (hVar != null) {
                hVar.iD(true);
            }
        }
    }

    public boolean dx(long j) {
        for (int i = 0; i < this.ewd.size(); i++) {
            h hVar = (h) y.getItem(this.ewd, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.ik()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void aB(int i, String str) {
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
                        kVar.iD(optBoolean);
                        kVar.dC(optLong2);
                        kVar.nZ(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.iD(optBoolean);
                        mVar.dC(optLong2);
                        mVar.nZ(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.iD(optBoolean);
                        jVar.dC(optLong2);
                        jVar.nZ(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.iD(optBoolean);
                    iVar.dC(optLong2);
                    iVar.nZ(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.iD(optBoolean);
                    lVar.dC(optLong2);
                    lVar.nZ(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String bif() {
        try {
            ArrayList<h> arrayList = this.ewd;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) y.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.bjd());
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
        this.evU = evE;
        this.evY = 0;
        this.evZ = 0;
        this.ewa = false;
        this.ewb = 1;
        this.mTag = 0;
        this.ewc = false;
        this.ewd = new ArrayList<>();
    }

    public b(String str) {
        this.evU = evE;
        this.evY = 0;
        this.evZ = 0;
        this.ewa = false;
        this.ewb = 1;
        this.mTag = 0;
        this.ewc = false;
        this.ewd = new ArrayList<>();
        zV(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            nT(activeCenterMissionData.mission_id);
            nY(activeCenterMissionData.total_limit);
            nV(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            nX(activeCenterMissionData.cleartype);
            dz(activeCenterMissionData.cleartime);
        }
    }

    public boolean zV(String str) {
        if (au.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.evJ = jSONObject.optInt(ACTIVITY_ID);
                this.evK = jSONObject.optInt(evf);
                this.evP = jSONObject.optString(evg);
                this.mSource = jSONObject.optString(SOURCE);
                this.evQ = jSONObject.optString(evh);
                this.zV = jSONObject.optInt(evi);
                this.mTaskType = jSONObject.optInt(evj);
                this.evM = jSONObject.optString(evk);
                this.evW = zW(this.evM);
                this.evL = jSONObject.optLong(evl);
                this.mThreadNum = jSONObject.optInt(evm);
                this.evN = jSONObject.optInt(evn);
                this.evU = jSONObject.optInt(evo);
                this.evV = jSONObject.optLong(evp);
                this.evX = bil();
                this.evO = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.evR = jSONObject.optString(evq);
                this.evS = jSONObject.optString(evr);
                this.evT = jSONObject.optLong(evs);
                int optInt = jSONObject.optInt(evt);
                if (optInt > 0) {
                    this.ewb = optInt;
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
        this.evU = evE;
        this.evY = 0;
        this.evZ = 0;
        this.ewa = false;
        this.ewb = 1;
        this.mTag = 0;
        this.ewc = false;
        this.ewd = new ArrayList<>();
        if (missionInfo != null) {
            this.evJ = missionInfo.activityid.intValue();
            this.evK = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.evU = missionInfo.cleartype.intValue();
            this.evV = missionInfo.cleartime.intValue();
            this.evX = bil();
            this.evM = missionInfo.browsetimepage;
            this.evW = zW(this.evM);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.evL = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.ewb = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean big() {
        return this.evJ > 0 && this.evK > 0 && this.mTaskType > 0 && this.evL > 0;
    }

    public synchronized int bih() {
        int i;
        i = this.evZ + 1;
        this.evZ = i;
        return i;
    }

    public synchronized int bii() {
        int i;
        i = this.evY + 1;
        this.evY = i;
        return i;
    }

    public synchronized int bij() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] zW(String str) {
        if (this.mTaskType == 8) {
            return new int[]{evu};
        }
        if (this.mTaskType == 7) {
            return new int[]{evv, evC, evD};
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

    public boolean bik() {
        return System.currentTimeMillis() > bix() * 1000;
    }

    public long bil() {
        if (this.evU == evE) {
            return 0L;
        }
        if (this.evU == evF) {
            return (System.currentTimeMillis() / 1000) + this.evV;
        }
        if (this.evU == evG) {
            long bim = (bim() / 1000) + this.evV;
            if (System.currentTimeMillis() > bim) {
                return bim + 86400;
            }
            return bim;
        } else if (this.evU == evH) {
            return m((int) this.evV, nS(4)) / 1000;
        } else {
            if (this.evU == evI) {
                return this.evV / 1000;
            }
            return 0L;
        }
    }

    private long bim() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long nS(int i) {
        long bim = bim();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - bim;
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
        return this.evJ;
    }

    public void setActivityId(int i) {
        this.evJ = i;
    }

    public int bin() {
        return this.evK;
    }

    public void nT(int i) {
        this.evK = i;
    }

    public String bio() {
        return this.evP;
    }

    public void zX(String str) {
        this.evP = str;
    }

    public String bip() {
        return this.evQ;
    }

    public String getSource() {
        return this.mSource;
    }

    public int biq() {
        return this.zV;
    }

    public void nU(int i) {
        this.zV = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void nV(int i) {
        this.mTaskType = i;
    }

    public String bir() {
        return this.evM;
    }

    public void zY(String str) {
        this.evM = str;
        this.evW = zW(str);
    }

    public int[] bis() {
        return this.evW;
    }

    public long bit() {
        return this.evL;
    }

    public void dy(long j) {
        this.evL = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int biu() {
        return this.evN;
    }

    public void nW(int i) {
        this.evN = i;
    }

    public int biv() {
        return this.evU;
    }

    public void nX(int i) {
        this.evU = i;
    }

    public long biw() {
        return this.evV;
    }

    public void dz(long j) {
        this.evV = j;
    }

    public long bix() {
        return this.evX;
    }

    public void dA(long j) {
        this.evX = j;
    }

    public long getTid() {
        return this.evO;
    }

    public void setTid(long j) {
        this.evO = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String biy() {
        return this.evR;
    }

    public void zZ(String str) {
        this.evR = str;
    }

    public String biz() {
        return this.evS;
    }

    public void Aa(String str) {
        this.evS = str;
    }

    public long biA() {
        return this.evT;
    }

    public void dB(long j) {
        this.evT = j;
    }

    public int biB() {
        return this.ewb;
    }

    public void nY(int i) {
        this.ewb = i;
    }

    public void nZ(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean biC() {
        return this.ewa;
    }

    public void iC(boolean z) {
        this.ewa = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
