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
    private int eEZ;
    private int eFa;
    private long eFb;
    private String eFc;
    private int eFd;
    private long eFe;
    private String eFf;
    private String eFg;
    private String eFh;
    private String eFi;
    private long eFj;
    private int eFk;
    private long eFl;
    private int[] eFm;
    private long eFn;
    private volatile int eFo;
    private volatile int eFp;
    private boolean eFq;
    private int eFr;
    public boolean eFs;
    private final ArrayList<h> eFt;
    private int mCallType;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    public static String ACTIVITY_ID = "activityid";
    public static String eEv = "missionid";
    public static String eEw = "activitysource";
    public static String SOURCE = "source";
    public static String eEx = "tab";
    public static String eEy = "calltype";
    public static String eEz = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String eEA = "browsetimepage";
    public static String eEB = "browsetime";
    public static String eEC = "threadnum";
    public static String eED = "forumnum";
    public static String eEE = "cleartype";
    public static String eEF = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String eEG = "threadtext";
    public static String eEH = "threadimg";
    public static String eEI = "threadforum";
    public static String eEJ = "total_limit";
    public static int eEK = -1;
    public static int eEL = 1;
    public static int eEM = 2;
    public static int eEN = 3;
    public static int eEO = 4;
    public static int eEP = 5;
    public static int eEQ = 6;
    public static int eER = 7;
    public static int eES = 8;
    public static int eET = 9;
    public static int eEU = -1;
    public static int eEV = 0;
    public static int eEW = 1;
    public static int eEX = 2;
    public static int eEY = 3;

    public void reset() {
        this.eFt.clear();
        this.eFo = 0;
        this.eFp = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.eFt.contains(hVar)) {
                this.eFt.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.eFt.contains(hVar)) {
                this.eFt.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.eFt.contains(hVar)) {
                this.eFt.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.eFt.contains(hVar)) {
                this.eFt.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.eFt.contains(hVar)) {
            this.eFt.add(hVar);
        }
    }

    public ArrayList<h> bks() {
        return this.eFt;
    }

    public int bkt() {
        int i;
        int size = this.eFt.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.x.getItem(this.eFt, i2);
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

    public void bku() {
        int size = this.eFt.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.x.getItem(this.eFt, i);
            if (hVar != null) {
                hVar.iY(true);
            }
        }
    }

    public boolean dx(long j) {
        for (int i = 0; i < this.eFt.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.x.getItem(this.eFt, i);
            if (hVar != null) {
                long b2 = b(hVar);
                if (b2 > 0 && b2 == j && hVar.isCompleted()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void aD(int i, String str) {
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
                        kVar.iY(optBoolean);
                        kVar.dC(optLong2);
                        kVar.oi(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.iY(optBoolean);
                        mVar.dC(optLong2);
                        mVar.oi(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.iY(optBoolean);
                        jVar.dC(optLong2);
                        jVar.oi(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.iY(optBoolean);
                    iVar.dC(optLong2);
                    iVar.oi(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.iY(optBoolean);
                    lVar.dC(optLong2);
                    lVar.oi(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String bkv() {
        try {
            ArrayList<h> arrayList = this.eFt;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.x.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.blt());
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
        this.eFk = eEU;
        this.eFo = 0;
        this.eFp = 0;
        this.eFq = false;
        this.eFr = 1;
        this.mTag = 0;
        this.eFs = false;
        this.eFt = new ArrayList<>();
    }

    public b(String str) {
        this.eFk = eEU;
        this.eFo = 0;
        this.eFp = 0;
        this.eFq = false;
        this.eFr = 1;
        this.mTag = 0;
        this.eFs = false;
        this.eFt = new ArrayList<>();
        zQ(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            oc(activeCenterMissionData.mission_id);
            oh(activeCenterMissionData.total_limit);
            oe(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            og(activeCenterMissionData.cleartype);
            dz(activeCenterMissionData.cleartime);
        }
    }

    public boolean zQ(String str) {
        if (at.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.eEZ = jSONObject.optInt(ACTIVITY_ID);
                this.eFa = jSONObject.optInt(eEv);
                this.eFf = jSONObject.optString(eEw);
                this.mSource = jSONObject.optString(SOURCE);
                this.eFg = jSONObject.optString(eEx);
                this.mCallType = jSONObject.optInt(eEy);
                this.mTaskType = jSONObject.optInt(eEz);
                this.eFc = jSONObject.optString(eEA);
                this.eFm = zR(this.eFc);
                this.eFb = jSONObject.optLong(eEB);
                this.mThreadNum = jSONObject.optInt(eEC);
                this.eFd = jSONObject.optInt(eED);
                this.eFk = jSONObject.optInt(eEE);
                this.eFl = jSONObject.optLong(eEF);
                this.eFn = bkB();
                this.eFe = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.eFh = jSONObject.optString(eEG);
                this.eFi = jSONObject.optString(eEH);
                this.eFj = jSONObject.optLong(eEI);
                int optInt = jSONObject.optInt(eEJ);
                if (optInt > 0) {
                    this.eFr = optInt;
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
        this.eFk = eEU;
        this.eFo = 0;
        this.eFp = 0;
        this.eFq = false;
        this.eFr = 1;
        this.mTag = 0;
        this.eFs = false;
        this.eFt = new ArrayList<>();
        if (missionInfo != null) {
            this.eEZ = missionInfo.activityid.intValue();
            this.eFa = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.eFk = missionInfo.cleartype.intValue();
            this.eFl = missionInfo.cleartime.intValue();
            this.eFn = bkB();
            this.eFc = missionInfo.browsetimepage;
            this.eFm = zR(this.eFc);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.eFb = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.eFr = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean bkw() {
        return this.eEZ > 0 && this.eFa > 0 && this.mTaskType > 0 && this.eFb > 0;
    }

    public synchronized int bkx() {
        int i;
        i = this.eFp + 1;
        this.eFp = i;
        return i;
    }

    public synchronized int bky() {
        int i;
        i = this.eFo + 1;
        this.eFo = i;
        return i;
    }

    public synchronized int bkz() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] zR(String str) {
        if (this.mTaskType == 8) {
            return new int[]{eEK};
        }
        if (this.mTaskType == 7) {
            return new int[]{eEL, eES, eET};
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

    public boolean bkA() {
        return System.currentTimeMillis() > bkN() * 1000;
    }

    public long bkB() {
        if (this.eFk == eEU) {
            return 0L;
        }
        if (this.eFk == eEV) {
            return (System.currentTimeMillis() / 1000) + this.eFl;
        }
        if (this.eFk == eEW) {
            long bkC = (bkC() / 1000) + this.eFl;
            if (System.currentTimeMillis() > bkC) {
                return bkC + 86400;
            }
            return bkC;
        } else if (this.eFk == eEX) {
            return m((int) this.eFl, ob(4)) / 1000;
        } else {
            if (this.eFk == eEY) {
                return this.eFl / 1000;
            }
            return 0L;
        }
    }

    private long bkC() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long ob(int i) {
        long bkC = bkC();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - bkC;
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
        return this.eEZ;
    }

    public void setActivityId(int i) {
        this.eEZ = i;
    }

    public int bkD() {
        return this.eFa;
    }

    public void oc(int i) {
        this.eFa = i;
    }

    public String bkE() {
        return this.eFf;
    }

    public void zS(String str) {
        this.eFf = str;
    }

    public String bkF() {
        return this.eFg;
    }

    public String getSource() {
        return this.mSource;
    }

    public int bkG() {
        return this.mCallType;
    }

    public void od(int i) {
        this.mCallType = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void oe(int i) {
        this.mTaskType = i;
    }

    public String bkH() {
        return this.eFc;
    }

    public void zT(String str) {
        this.eFc = str;
        this.eFm = zR(str);
    }

    public int[] bkI() {
        return this.eFm;
    }

    public long bkJ() {
        return this.eFb;
    }

    public void dy(long j) {
        this.eFb = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int bkK() {
        return this.eFd;
    }

    public void of(int i) {
        this.eFd = i;
    }

    public int bkL() {
        return this.eFk;
    }

    public void og(int i) {
        this.eFk = i;
    }

    public long bkM() {
        return this.eFl;
    }

    public void dz(long j) {
        this.eFl = j;
    }

    public long bkN() {
        return this.eFn;
    }

    public void dA(long j) {
        this.eFn = j;
    }

    public long getTid() {
        return this.eFe;
    }

    public void setTid(long j) {
        this.eFe = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String bkO() {
        return this.eFh;
    }

    public void zU(String str) {
        this.eFh = str;
    }

    public String bkP() {
        return this.eFi;
    }

    public void zV(String str) {
        this.eFi = str;
    }

    public long bkQ() {
        return this.eFj;
    }

    public void dB(long j) {
        this.eFj = j;
    }

    public int bkR() {
        return this.eFr;
    }

    public void oh(int i) {
        this.eFr = i;
    }

    public void oi(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean bkS() {
        return this.eFq;
    }

    public void iX(boolean z) {
        this.eFq = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
