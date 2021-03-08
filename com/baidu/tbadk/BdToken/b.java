package com.baidu.tbadk.BdToken;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.au;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class b {
    private int eDU;
    private int eDV;
    private long eDW;
    private String eDX;
    private int eDY;
    private long eDZ;
    private String eEa;
    private String eEb;
    private String eEc;
    private String eEd;
    private long eEe;
    private int eEf;
    private long eEg;
    private int[] eEh;
    private long eEi;
    private volatile int eEj;
    private volatile int eEk;
    private boolean eEl;
    private int eEm;
    public boolean eEn;
    private final ArrayList<h> eEo;
    private int mCallType;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    public static String ACTIVITY_ID = "activityid";
    public static String eDq = "missionid";
    public static String eDr = "activitysource";
    public static String SOURCE = "source";
    public static String eDs = "tab";
    public static String eDt = "calltype";
    public static String eDu = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String eDv = "browsetimepage";
    public static String eDw = "browsetime";
    public static String eDx = "threadnum";
    public static String eDy = "forumnum";
    public static String eDz = "cleartype";
    public static String eDA = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String eDB = "threadtext";
    public static String eDC = "threadimg";
    public static String eDD = "threadforum";
    public static String eDE = "total_limit";
    public static int eDF = -1;
    public static int eDG = 1;
    public static int eDH = 2;
    public static int eDI = 3;
    public static int eDJ = 4;
    public static int eDK = 5;
    public static int eDL = 6;
    public static int eDM = 7;
    public static int eDN = 8;
    public static int eDO = 9;
    public static int eDP = -1;
    public static int eDQ = 0;
    public static int eDR = 1;
    public static int eDS = 2;
    public static int eDT = 3;

    public void reset() {
        this.eEo.clear();
        this.eEj = 0;
        this.eEk = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.eEo.contains(hVar)) {
                this.eEo.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.eEo.contains(hVar)) {
                this.eEo.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.eEo.contains(hVar)) {
                this.eEo.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.eEo.contains(hVar)) {
                this.eEo.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.eEo.contains(hVar)) {
            this.eEo.add(hVar);
        }
    }

    public ArrayList<h> bgO() {
        return this.eEo;
    }

    public int bgP() {
        int i;
        int size = this.eEo.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.y.getItem(this.eEo, i2);
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

    public void bgQ() {
        int size = this.eEo.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.y.getItem(this.eEo, i);
            if (hVar != null) {
                hVar.iW(true);
            }
        }
    }

    public boolean dD(long j) {
        for (int i = 0; i < this.eEo.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.y.getItem(this.eEo, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.isCompleted()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void aI(int i, String str) {
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
                        kVar.iW(optBoolean);
                        kVar.dI(optLong2);
                        kVar.mG(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.iW(optBoolean);
                        mVar.dI(optLong2);
                        mVar.mG(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.iW(optBoolean);
                        jVar.dI(optLong2);
                        jVar.mG(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.iW(optBoolean);
                    iVar.dI(optLong2);
                    iVar.mG(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.iW(optBoolean);
                    lVar.dI(optLong2);
                    lVar.mG(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String bgR() {
        try {
            ArrayList<h> arrayList = this.eEo;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.bhP());
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
        this.eEf = eDP;
        this.eEj = 0;
        this.eEk = 0;
        this.eEl = false;
        this.eEm = 1;
        this.mTag = 0;
        this.eEn = false;
        this.eEo = new ArrayList<>();
    }

    public b(String str) {
        this.eEf = eDP;
        this.eEj = 0;
        this.eEk = 0;
        this.eEl = false;
        this.eEm = 1;
        this.mTag = 0;
        this.eEn = false;
        this.eEo = new ArrayList<>();
        ze(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            mA(activeCenterMissionData.mission_id);
            mF(activeCenterMissionData.total_limit);
            mC(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            mE(activeCenterMissionData.cleartype);
            dF(activeCenterMissionData.cleartime);
        }
    }

    public boolean ze(String str) {
        if (au.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.eDU = jSONObject.optInt(ACTIVITY_ID);
                this.eDV = jSONObject.optInt(eDq);
                this.eEa = jSONObject.optString(eDr);
                this.mSource = jSONObject.optString(SOURCE);
                this.eEb = jSONObject.optString(eDs);
                this.mCallType = jSONObject.optInt(eDt);
                this.mTaskType = jSONObject.optInt(eDu);
                this.eDX = jSONObject.optString(eDv);
                this.eEh = zf(this.eDX);
                this.eDW = jSONObject.optLong(eDw);
                this.mThreadNum = jSONObject.optInt(eDx);
                this.eDY = jSONObject.optInt(eDy);
                this.eEf = jSONObject.optInt(eDz);
                this.eEg = jSONObject.optLong(eDA);
                this.eEi = bgX();
                this.eDZ = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.eEc = jSONObject.optString(eDB);
                this.eEd = jSONObject.optString(eDC);
                this.eEe = jSONObject.optLong(eDD);
                int optInt = jSONObject.optInt(eDE);
                if (optInt > 0) {
                    this.eEm = optInt;
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
        this.eEf = eDP;
        this.eEj = 0;
        this.eEk = 0;
        this.eEl = false;
        this.eEm = 1;
        this.mTag = 0;
        this.eEn = false;
        this.eEo = new ArrayList<>();
        if (missionInfo != null) {
            this.eDU = missionInfo.activityid.intValue();
            this.eDV = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.eEf = missionInfo.cleartype.intValue();
            this.eEg = missionInfo.cleartime.intValue();
            this.eEi = bgX();
            this.eDX = missionInfo.browsetimepage;
            this.eEh = zf(this.eDX);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.eDW = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.eEm = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean bgS() {
        return this.eDU > 0 && this.eDV > 0 && this.mTaskType > 0 && this.eDW > 0;
    }

    public synchronized int bgT() {
        int i;
        i = this.eEk + 1;
        this.eEk = i;
        return i;
    }

    public synchronized int bgU() {
        int i;
        i = this.eEj + 1;
        this.eEj = i;
        return i;
    }

    public synchronized int bgV() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] zf(String str) {
        if (this.mTaskType == 8) {
            return new int[]{eDF};
        }
        if (this.mTaskType == 7) {
            return new int[]{eDG, eDN, eDO};
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

    public boolean bgW() {
        return System.currentTimeMillis() > bhj() * 1000;
    }

    public long bgX() {
        if (this.eEf == eDP) {
            return 0L;
        }
        if (this.eEf == eDQ) {
            return (System.currentTimeMillis() / 1000) + this.eEg;
        }
        if (this.eEf == eDR) {
            long bgY = (bgY() / 1000) + this.eEg;
            if (System.currentTimeMillis() > bgY) {
                return bgY + 86400;
            }
            return bgY;
        } else if (this.eEf == eDS) {
            return n((int) this.eEg, mz(4)) / 1000;
        } else {
            if (this.eEf == eDT) {
                return this.eEg / 1000;
            }
            return 0L;
        }
    }

    private long bgY() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long mz(int i) {
        long bgY = bgY();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - bgY;
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
        return this.eDU;
    }

    public void setActivityId(int i) {
        this.eDU = i;
    }

    public int bgZ() {
        return this.eDV;
    }

    public void mA(int i) {
        this.eDV = i;
    }

    public String bha() {
        return this.eEa;
    }

    public void zg(String str) {
        this.eEa = str;
    }

    public String bhb() {
        return this.eEb;
    }

    public String getSource() {
        return this.mSource;
    }

    public int bhc() {
        return this.mCallType;
    }

    public void mB(int i) {
        this.mCallType = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void mC(int i) {
        this.mTaskType = i;
    }

    public String bhd() {
        return this.eDX;
    }

    public void zh(String str) {
        this.eDX = str;
        this.eEh = zf(str);
    }

    public int[] bhe() {
        return this.eEh;
    }

    public long bhf() {
        return this.eDW;
    }

    public void dE(long j) {
        this.eDW = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int bhg() {
        return this.eDY;
    }

    public void mD(int i) {
        this.eDY = i;
    }

    public int bhh() {
        return this.eEf;
    }

    public void mE(int i) {
        this.eEf = i;
    }

    public long bhi() {
        return this.eEg;
    }

    public void dF(long j) {
        this.eEg = j;
    }

    public long bhj() {
        return this.eEi;
    }

    public void dG(long j) {
        this.eEi = j;
    }

    public long getTid() {
        return this.eDZ;
    }

    public void setTid(long j) {
        this.eDZ = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String bhk() {
        return this.eEc;
    }

    public void zi(String str) {
        this.eEc = str;
    }

    public String bhl() {
        return this.eEd;
    }

    public void zj(String str) {
        this.eEd = str;
    }

    public long bhm() {
        return this.eEe;
    }

    public void dH(long j) {
        this.eEe = j;
    }

    public int bhn() {
        return this.eEm;
    }

    public void mF(int i) {
        this.eEm = i;
    }

    public void mG(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean bho() {
        return this.eEl;
    }

    public void iV(boolean z) {
        this.eEl = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
