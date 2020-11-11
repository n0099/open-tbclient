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
    private String eqA;
    private long eqB;
    private int eqC;
    private long eqD;
    private int[] eqE;
    private long eqF;
    private volatile int eqG;
    private volatile int eqH;
    private boolean eqI;
    private int eqJ;
    public boolean eqK;
    private final ArrayList<h> eqL;
    private int eqr;
    private int eqs;
    private long eqt;
    private String equ;
    private int eqv;
    private long eqw;
    private String eqx;
    private String eqy;
    private String eqz;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int zf;
    public static String ACTIVITY_ID = "activityid";
    public static String epN = "missionid";
    public static String epO = "activitysource";
    public static String SOURCE = "source";
    public static String epP = "tab";
    public static String epQ = "calltype";
    public static String epR = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String epS = "browsetimepage";
    public static String epT = "browsetime";
    public static String epU = "threadnum";
    public static String epV = "forumnum";
    public static String epW = "cleartype";
    public static String epX = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String epY = "threadtext";
    public static String epZ = "threadimg";
    public static String eqa = "threadforum";
    public static String eqb = "total_limit";
    public static int eqc = -1;
    public static int eqd = 1;
    public static int eqe = 2;
    public static int eqf = 3;
    public static int eqg = 4;
    public static int eqh = 5;
    public static int eqi = 6;
    public static int eqj = 7;
    public static int eqk = 8;
    public static int eql = 9;
    public static int eqm = -1;
    public static int eqn = 0;
    public static int eqo = 1;
    public static int eqp = 2;
    public static int eqq = 3;

    public void reset() {
        this.eqL.clear();
        this.eqG = 0;
        this.eqH = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.eqL.contains(hVar)) {
                this.eqL.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.eqL.contains(hVar)) {
                this.eqL.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.eqL.contains(hVar)) {
                this.eqL.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.eqL.contains(hVar)) {
                this.eqL.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.eqL.contains(hVar)) {
            this.eqL.add(hVar);
        }
    }

    public ArrayList<h> bfE() {
        return this.eqL;
    }

    public int bfF() {
        int i;
        int size = this.eqL.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) y.getItem(this.eqL, i2);
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

    public void bfG() {
        int size = this.eqL.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) y.getItem(this.eqL, i);
            if (hVar != null) {
                hVar.il(true);
            }
        }
    }

    public boolean cY(long j) {
        for (int i = 0; i < this.eqL.size(); i++) {
            h hVar = (h) y.getItem(this.eqL, i);
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
                        kVar.il(optBoolean);
                        kVar.dd(optLong2);
                        kVar.nF(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.il(optBoolean);
                        mVar.dd(optLong2);
                        mVar.nF(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.il(optBoolean);
                        jVar.dd(optLong2);
                        jVar.nF(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.il(optBoolean);
                    iVar.dd(optLong2);
                    iVar.nF(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.il(optBoolean);
                    lVar.dd(optLong2);
                    lVar.nF(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String bfH() {
        try {
            ArrayList<h> arrayList = this.eqL;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) y.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.bgF());
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
        this.eqC = eqm;
        this.eqG = 0;
        this.eqH = 0;
        this.eqI = false;
        this.eqJ = 1;
        this.mTag = 0;
        this.eqK = false;
        this.eqL = new ArrayList<>();
    }

    public b(String str) {
        this.eqC = eqm;
        this.eqG = 0;
        this.eqH = 0;
        this.eqI = false;
        this.eqJ = 1;
        this.mTag = 0;
        this.eqK = false;
        this.eqL = new ArrayList<>();
        zt(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            nz(activeCenterMissionData.mission_id);
            nE(activeCenterMissionData.total_limit);
            nB(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            nD(activeCenterMissionData.cleartype);
            da(activeCenterMissionData.cleartime);
        }
    }

    public boolean zt(String str) {
        if (at.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.eqr = jSONObject.optInt(ACTIVITY_ID);
                this.eqs = jSONObject.optInt(epN);
                this.eqx = jSONObject.optString(epO);
                this.mSource = jSONObject.optString(SOURCE);
                this.eqy = jSONObject.optString(epP);
                this.zf = jSONObject.optInt(epQ);
                this.mTaskType = jSONObject.optInt(epR);
                this.equ = jSONObject.optString(epS);
                this.eqE = zu(this.equ);
                this.eqt = jSONObject.optLong(epT);
                this.mThreadNum = jSONObject.optInt(epU);
                this.eqv = jSONObject.optInt(epV);
                this.eqC = jSONObject.optInt(epW);
                this.eqD = jSONObject.optLong(epX);
                this.eqF = bfN();
                this.eqw = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.eqz = jSONObject.optString(epY);
                this.eqA = jSONObject.optString(epZ);
                this.eqB = jSONObject.optLong(eqa);
                int optInt = jSONObject.optInt(eqb);
                if (optInt > 0) {
                    this.eqJ = optInt;
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
        this.eqC = eqm;
        this.eqG = 0;
        this.eqH = 0;
        this.eqI = false;
        this.eqJ = 1;
        this.mTag = 0;
        this.eqK = false;
        this.eqL = new ArrayList<>();
        if (missionInfo != null) {
            this.eqr = missionInfo.activityid.intValue();
            this.eqs = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.eqC = missionInfo.cleartype.intValue();
            this.eqD = missionInfo.cleartime.intValue();
            this.eqF = bfN();
            this.equ = missionInfo.browsetimepage;
            this.eqE = zu(this.equ);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.eqt = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.eqJ = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean bfI() {
        return this.eqr > 0 && this.eqs > 0 && this.mTaskType > 0 && this.eqt > 0;
    }

    public synchronized int bfJ() {
        int i;
        i = this.eqH + 1;
        this.eqH = i;
        return i;
    }

    public synchronized int bfK() {
        int i;
        i = this.eqG + 1;
        this.eqG = i;
        return i;
    }

    public synchronized int bfL() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] zu(String str) {
        if (this.mTaskType == 8) {
            return new int[]{eqc};
        }
        if (this.mTaskType == 7) {
            return new int[]{eqd, eqk, eql};
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

    public boolean bfM() {
        return System.currentTimeMillis() > bfZ() * 1000;
    }

    public long bfN() {
        if (this.eqC == eqm) {
            return 0L;
        }
        if (this.eqC == eqn) {
            return (System.currentTimeMillis() / 1000) + this.eqD;
        }
        if (this.eqC == eqo) {
            long bfO = (bfO() / 1000) + this.eqD;
            if (System.currentTimeMillis() > bfO) {
                return bfO + 86400;
            }
            return bfO;
        } else if (this.eqC == eqp) {
            return m((int) this.eqD, ny(4)) / 1000;
        } else {
            if (this.eqC == eqq) {
                return this.eqD / 1000;
            }
            return 0L;
        }
    }

    private long bfO() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long ny(int i) {
        long bfO = bfO();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - bfO;
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
        return this.eqr;
    }

    public void setActivityId(int i) {
        this.eqr = i;
    }

    public int bfP() {
        return this.eqs;
    }

    public void nz(int i) {
        this.eqs = i;
    }

    public String bfQ() {
        return this.eqx;
    }

    public void zv(String str) {
        this.eqx = str;
    }

    public String bfR() {
        return this.eqy;
    }

    public String getSource() {
        return this.mSource;
    }

    public int bfS() {
        return this.zf;
    }

    public void nA(int i) {
        this.zf = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void nB(int i) {
        this.mTaskType = i;
    }

    public String bfT() {
        return this.equ;
    }

    public void zw(String str) {
        this.equ = str;
        this.eqE = zu(str);
    }

    public int[] bfU() {
        return this.eqE;
    }

    public long bfV() {
        return this.eqt;
    }

    public void cZ(long j) {
        this.eqt = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int bfW() {
        return this.eqv;
    }

    public void nC(int i) {
        this.eqv = i;
    }

    public int bfX() {
        return this.eqC;
    }

    public void nD(int i) {
        this.eqC = i;
    }

    public long bfY() {
        return this.eqD;
    }

    public void da(long j) {
        this.eqD = j;
    }

    public long bfZ() {
        return this.eqF;
    }

    public void db(long j) {
        this.eqF = j;
    }

    public long getTid() {
        return this.eqw;
    }

    public void setTid(long j) {
        this.eqw = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String bga() {
        return this.eqz;
    }

    public void zx(String str) {
        this.eqz = str;
    }

    public String bgb() {
        return this.eqA;
    }

    public void zy(String str) {
        this.eqA = str;
    }

    public long bgc() {
        return this.eqB;
    }

    public void dc(long j) {
        this.eqB = j;
    }

    public int bgd() {
        return this.eqJ;
    }

    public void nE(int i) {
        this.eqJ = i;
    }

    public void nF(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean bge() {
        return this.eqI;
    }

    public void ik(boolean z) {
        this.eqI = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
