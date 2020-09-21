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
    private int dQa;
    private int dQb;
    private long dQc;
    private String dQd;
    private int dQe;
    private long dQf;
    private String dQg;
    private String dQh;
    private String dQi;
    private String dQj;
    private long dQk;
    private int dQl;
    private long dQm;
    private int[] dQn;
    private long dQo;
    private volatile int dQp;
    private volatile int dQq;
    private boolean dQr;
    private int dQs;
    public boolean dQt;
    private final ArrayList<h> dQu;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int yO;
    public static String ACTIVITY_ID = "activityid";
    public static String dPw = "missionid";
    public static String dPx = "activitysource";
    public static String SOURCE = "source";
    public static String dPy = "tab";
    public static String dPz = "calltype";
    public static String dPA = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String dPB = "browsetimepage";
    public static String dPC = "browsetime";
    public static String dPD = "threadnum";
    public static String dPE = "forumnum";
    public static String dPF = "cleartype";
    public static String dPG = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String dPH = "threadtext";
    public static String dPI = "threadimg";
    public static String dPJ = "threadforum";
    public static String dPK = "total_limit";
    public static int dPL = -1;
    public static int dPM = 1;
    public static int dPN = 2;
    public static int dPO = 3;
    public static int dPP = 4;
    public static int dPQ = 5;
    public static int dPR = 6;
    public static int dPS = 7;
    public static int dPT = 8;
    public static int dPU = 9;
    public static int dPV = -1;
    public static int dPW = 0;
    public static int dPX = 1;
    public static int dPY = 2;
    public static int dPZ = 3;

    public void reset() {
        this.dQu.clear();
        this.dQp = 0;
        this.dQq = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.dQu.contains(hVar)) {
                this.dQu.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.dQu.contains(hVar)) {
                this.dQu.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.dQu.contains(hVar)) {
                this.dQu.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.dQu.contains(hVar)) {
                this.dQu.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.dQu.contains(hVar)) {
            this.dQu.add(hVar);
        }
    }

    public ArrayList<h> aYD() {
        return this.dQu;
    }

    public int aYE() {
        int i;
        int size = this.dQu.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) y.getItem(this.dQu, i2);
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

    public void aYF() {
        int size = this.dQu.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) y.getItem(this.dQu, i);
            if (hVar != null) {
                hVar.ht(true);
            }
        }
    }

    public boolean cs(long j) {
        for (int i = 0; i < this.dQu.size(); i++) {
            h hVar = (h) y.getItem(this.dQu, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.ij()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ak(int i, String str) {
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
                        kVar.ht(optBoolean);
                        kVar.cx(optLong2);
                        kVar.mN(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.ht(optBoolean);
                        mVar.cx(optLong2);
                        mVar.mN(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.ht(optBoolean);
                        jVar.cx(optLong2);
                        jVar.mN(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.ht(optBoolean);
                    iVar.cx(optLong2);
                    iVar.mN(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.ht(optBoolean);
                    lVar.cx(optLong2);
                    lVar.mN(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String aYG() {
        try {
            ArrayList<h> arrayList = this.dQu;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) y.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.aZE());
                jSONObject.put("c", hVar.ij());
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
        this.dQl = dPV;
        this.dQp = 0;
        this.dQq = 0;
        this.dQr = false;
        this.dQs = 1;
        this.mTag = 0;
        this.dQt = false;
        this.dQu = new ArrayList<>();
    }

    public b(String str) {
        this.dQl = dPV;
        this.dQp = 0;
        this.dQq = 0;
        this.dQr = false;
        this.dQs = 1;
        this.mTag = 0;
        this.dQt = false;
        this.dQu = new ArrayList<>();
        ya(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            mH(activeCenterMissionData.mission_id);
            mM(activeCenterMissionData.total_limit);
            mJ(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            mL(activeCenterMissionData.cleartype);
            cu(activeCenterMissionData.cleartime);
        }
    }

    public boolean ya(String str) {
        if (at.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.dQa = jSONObject.optInt(ACTIVITY_ID);
                this.dQb = jSONObject.optInt(dPw);
                this.dQg = jSONObject.optString(dPx);
                this.mSource = jSONObject.optString(SOURCE);
                this.dQh = jSONObject.optString(dPy);
                this.yO = jSONObject.optInt(dPz);
                this.mTaskType = jSONObject.optInt(dPA);
                this.dQd = jSONObject.optString(dPB);
                this.dQn = yb(this.dQd);
                this.dQc = jSONObject.optLong(dPC);
                this.mThreadNum = jSONObject.optInt(dPD);
                this.dQe = jSONObject.optInt(dPE);
                this.dQl = jSONObject.optInt(dPF);
                this.dQm = jSONObject.optLong(dPG);
                this.dQo = aYM();
                this.dQf = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.dQi = jSONObject.optString(dPH);
                this.dQj = jSONObject.optString(dPI);
                this.dQk = jSONObject.optLong(dPJ);
                int optInt = jSONObject.optInt(dPK);
                if (optInt > 0) {
                    this.dQs = optInt;
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
        this.dQl = dPV;
        this.dQp = 0;
        this.dQq = 0;
        this.dQr = false;
        this.dQs = 1;
        this.mTag = 0;
        this.dQt = false;
        this.dQu = new ArrayList<>();
        if (missionInfo != null) {
            this.dQa = missionInfo.activityid.intValue();
            this.dQb = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.dQl = missionInfo.cleartype.intValue();
            this.dQm = missionInfo.cleartime.intValue();
            this.dQo = aYM();
            this.dQd = missionInfo.browsetimepage;
            this.dQn = yb(this.dQd);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.dQc = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.dQs = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean aYH() {
        return this.dQa > 0 && this.dQb > 0 && this.mTaskType > 0 && this.dQc > 0;
    }

    public synchronized int aYI() {
        int i;
        i = this.dQq + 1;
        this.dQq = i;
        return i;
    }

    public synchronized int aYJ() {
        int i;
        i = this.dQp + 1;
        this.dQp = i;
        return i;
    }

    public synchronized int aYK() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] yb(String str) {
        if (this.mTaskType == 8) {
            return new int[]{dPL};
        }
        if (this.mTaskType == 7) {
            return new int[]{dPM, dPT, dPU};
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

    public boolean aYL() {
        return System.currentTimeMillis() > aYY() * 1000;
    }

    public long aYM() {
        if (this.dQl == dPV) {
            return 0L;
        }
        if (this.dQl == dPW) {
            return (System.currentTimeMillis() / 1000) + this.dQm;
        }
        if (this.dQl == dPX) {
            long aYN = (aYN() / 1000) + this.dQm;
            if (System.currentTimeMillis() > aYN) {
                return aYN + 86400;
            }
            return aYN;
        } else if (this.dQl == dPY) {
            return m((int) this.dQm, mG(4)) / 1000;
        } else {
            if (this.dQl == dPZ) {
                return this.dQm / 1000;
            }
            return 0L;
        }
    }

    private long aYN() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long mG(int i) {
        long aYN = aYN();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - aYN;
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
        return this.dQa;
    }

    public void setActivityId(int i) {
        this.dQa = i;
    }

    public int aYO() {
        return this.dQb;
    }

    public void mH(int i) {
        this.dQb = i;
    }

    public String aYP() {
        return this.dQg;
    }

    public void yc(String str) {
        this.dQg = str;
    }

    public String aYQ() {
        return this.dQh;
    }

    public String getSource() {
        return this.mSource;
    }

    public int aYR() {
        return this.yO;
    }

    public void mI(int i) {
        this.yO = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void mJ(int i) {
        this.mTaskType = i;
    }

    public String aYS() {
        return this.dQd;
    }

    public void yd(String str) {
        this.dQd = str;
        this.dQn = yb(str);
    }

    public int[] aYT() {
        return this.dQn;
    }

    public long aYU() {
        return this.dQc;
    }

    public void ct(long j) {
        this.dQc = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int aYV() {
        return this.dQe;
    }

    public void mK(int i) {
        this.dQe = i;
    }

    public int aYW() {
        return this.dQl;
    }

    public void mL(int i) {
        this.dQl = i;
    }

    public long aYX() {
        return this.dQm;
    }

    public void cu(long j) {
        this.dQm = j;
    }

    public long aYY() {
        return this.dQo;
    }

    public void cv(long j) {
        this.dQo = j;
    }

    public long getTid() {
        return this.dQf;
    }

    public void setTid(long j) {
        this.dQf = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String aYZ() {
        return this.dQi;
    }

    public void ye(String str) {
        this.dQi = str;
    }

    public String aZa() {
        return this.dQj;
    }

    public void yf(String str) {
        this.dQj = str;
    }

    public long aZb() {
        return this.dQk;
    }

    public void cw(long j) {
        this.dQk = j;
    }

    public int aZc() {
        return this.dQs;
    }

    public void mM(int i) {
        this.dQs = i;
    }

    public void mN(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean aZd() {
        return this.dQr;
    }

    public void hs(boolean z) {
        this.dQr = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
