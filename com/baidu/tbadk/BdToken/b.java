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
    private String ekA;
    private int ekB;
    private long ekC;
    private String ekD;
    private String ekE;
    private String ekF;
    private String ekG;
    private long ekH;
    private int ekI;
    private long ekJ;
    private int[] ekK;
    private long ekL;
    private volatile int ekM;
    private volatile int ekN;
    private boolean ekO;
    private int ekP;
    public boolean ekQ;
    private final ArrayList<h> ekR;
    private int ekx;
    private int eky;
    private long ekz;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int zf;
    public static String ACTIVITY_ID = "activityid";
    public static String ejT = "missionid";
    public static String ejU = "activitysource";
    public static String SOURCE = "source";
    public static String ejV = "tab";
    public static String ejW = "calltype";
    public static String ejX = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String ejY = "browsetimepage";
    public static String ejZ = "browsetime";
    public static String eka = "threadnum";
    public static String ekb = "forumnum";
    public static String ekc = "cleartype";
    public static String ekd = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String eke = "threadtext";
    public static String ekf = "threadimg";
    public static String ekg = "threadforum";
    public static String ekh = "total_limit";
    public static int eki = -1;
    public static int ekj = 1;
    public static int ekk = 2;
    public static int ekl = 3;
    public static int ekm = 4;
    public static int ekn = 5;
    public static int eko = 6;
    public static int ekp = 7;
    public static int ekq = 8;
    public static int ekr = 9;
    public static int eks = -1;
    public static int ekt = 0;
    public static int eku = 1;
    public static int ekv = 2;
    public static int ekw = 3;

    public void reset() {
        this.ekR.clear();
        this.ekM = 0;
        this.ekN = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.ekR.contains(hVar)) {
                this.ekR.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.ekR.contains(hVar)) {
                this.ekR.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.ekR.contains(hVar)) {
                this.ekR.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.ekR.contains(hVar)) {
                this.ekR.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.ekR.contains(hVar)) {
            this.ekR.add(hVar);
        }
    }

    public ArrayList<h> bde() {
        return this.ekR;
    }

    public int bdf() {
        int i;
        int size = this.ekR.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) y.getItem(this.ekR, i2);
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

    public void bdg() {
        int size = this.ekR.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) y.getItem(this.ekR, i);
            if (hVar != null) {
                hVar.ic(true);
            }
        }
    }

    public boolean cC(long j) {
        for (int i = 0; i < this.ekR.size(); i++) {
            h hVar = (h) y.getItem(this.ekR, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.ik()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ax(int i, String str) {
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
                        kVar.ic(optBoolean);
                        kVar.cH(optLong2);
                        kVar.nv(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.ic(optBoolean);
                        mVar.cH(optLong2);
                        mVar.nv(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.ic(optBoolean);
                        jVar.cH(optLong2);
                        jVar.nv(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.ic(optBoolean);
                    iVar.cH(optLong2);
                    iVar.nv(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.ic(optBoolean);
                    lVar.cH(optLong2);
                    lVar.nv(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String bdh() {
        try {
            ArrayList<h> arrayList = this.ekR;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) y.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.bef());
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
        this.ekI = eks;
        this.ekM = 0;
        this.ekN = 0;
        this.ekO = false;
        this.ekP = 1;
        this.mTag = 0;
        this.ekQ = false;
        this.ekR = new ArrayList<>();
    }

    public b(String str) {
        this.ekI = eks;
        this.ekM = 0;
        this.ekN = 0;
        this.ekO = false;
        this.ekP = 1;
        this.mTag = 0;
        this.ekQ = false;
        this.ekR = new ArrayList<>();
        zf(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            np(activeCenterMissionData.mission_id);
            nu(activeCenterMissionData.total_limit);
            nr(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            nt(activeCenterMissionData.cleartype);
            cE(activeCenterMissionData.cleartime);
        }
    }

    public boolean zf(String str) {
        if (at.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.ekx = jSONObject.optInt(ACTIVITY_ID);
                this.eky = jSONObject.optInt(ejT);
                this.ekD = jSONObject.optString(ejU);
                this.mSource = jSONObject.optString(SOURCE);
                this.ekE = jSONObject.optString(ejV);
                this.zf = jSONObject.optInt(ejW);
                this.mTaskType = jSONObject.optInt(ejX);
                this.ekA = jSONObject.optString(ejY);
                this.ekK = zg(this.ekA);
                this.ekz = jSONObject.optLong(ejZ);
                this.mThreadNum = jSONObject.optInt(eka);
                this.ekB = jSONObject.optInt(ekb);
                this.ekI = jSONObject.optInt(ekc);
                this.ekJ = jSONObject.optLong(ekd);
                this.ekL = bdn();
                this.ekC = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.ekF = jSONObject.optString(eke);
                this.ekG = jSONObject.optString(ekf);
                this.ekH = jSONObject.optLong(ekg);
                int optInt = jSONObject.optInt(ekh);
                if (optInt > 0) {
                    this.ekP = optInt;
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
        this.ekI = eks;
        this.ekM = 0;
        this.ekN = 0;
        this.ekO = false;
        this.ekP = 1;
        this.mTag = 0;
        this.ekQ = false;
        this.ekR = new ArrayList<>();
        if (missionInfo != null) {
            this.ekx = missionInfo.activityid.intValue();
            this.eky = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.ekI = missionInfo.cleartype.intValue();
            this.ekJ = missionInfo.cleartime.intValue();
            this.ekL = bdn();
            this.ekA = missionInfo.browsetimepage;
            this.ekK = zg(this.ekA);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.ekz = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.ekP = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean bdi() {
        return this.ekx > 0 && this.eky > 0 && this.mTaskType > 0 && this.ekz > 0;
    }

    public synchronized int bdj() {
        int i;
        i = this.ekN + 1;
        this.ekN = i;
        return i;
    }

    public synchronized int bdk() {
        int i;
        i = this.ekM + 1;
        this.ekM = i;
        return i;
    }

    public synchronized int bdl() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] zg(String str) {
        if (this.mTaskType == 8) {
            return new int[]{eki};
        }
        if (this.mTaskType == 7) {
            return new int[]{ekj, ekq, ekr};
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

    public boolean bdm() {
        return System.currentTimeMillis() > bdz() * 1000;
    }

    public long bdn() {
        if (this.ekI == eks) {
            return 0L;
        }
        if (this.ekI == ekt) {
            return (System.currentTimeMillis() / 1000) + this.ekJ;
        }
        if (this.ekI == eku) {
            long bdo = (bdo() / 1000) + this.ekJ;
            if (System.currentTimeMillis() > bdo) {
                return bdo + 86400;
            }
            return bdo;
        } else if (this.ekI == ekv) {
            return n((int) this.ekJ, no(4)) / 1000;
        } else {
            if (this.ekI == ekw) {
                return this.ekJ / 1000;
            }
            return 0L;
        }
    }

    private long bdo() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long no(int i) {
        long bdo = bdo();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - bdo;
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
        return this.ekx;
    }

    public void setActivityId(int i) {
        this.ekx = i;
    }

    public int bdp() {
        return this.eky;
    }

    public void np(int i) {
        this.eky = i;
    }

    public String bdq() {
        return this.ekD;
    }

    public void zh(String str) {
        this.ekD = str;
    }

    public String bdr() {
        return this.ekE;
    }

    public String getSource() {
        return this.mSource;
    }

    public int bds() {
        return this.zf;
    }

    public void nq(int i) {
        this.zf = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void nr(int i) {
        this.mTaskType = i;
    }

    public String bdt() {
        return this.ekA;
    }

    public void zi(String str) {
        this.ekA = str;
        this.ekK = zg(str);
    }

    public int[] bdu() {
        return this.ekK;
    }

    public long bdv() {
        return this.ekz;
    }

    public void cD(long j) {
        this.ekz = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int bdw() {
        return this.ekB;
    }

    public void ns(int i) {
        this.ekB = i;
    }

    public int bdx() {
        return this.ekI;
    }

    public void nt(int i) {
        this.ekI = i;
    }

    public long bdy() {
        return this.ekJ;
    }

    public void cE(long j) {
        this.ekJ = j;
    }

    public long bdz() {
        return this.ekL;
    }

    public void cF(long j) {
        this.ekL = j;
    }

    public long getTid() {
        return this.ekC;
    }

    public void setTid(long j) {
        this.ekC = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String bdA() {
        return this.ekF;
    }

    public void zj(String str) {
        this.ekF = str;
    }

    public String bdB() {
        return this.ekG;
    }

    public void zk(String str) {
        this.ekG = str;
    }

    public long bdC() {
        return this.ekH;
    }

    public void cG(long j) {
        this.ekH = j;
    }

    public int bdD() {
        return this.ekP;
    }

    public void nu(int i) {
        this.ekP = i;
    }

    public void nv(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean bdE() {
        return this.ekO;
    }

    public void ib(boolean z) {
        this.ekO = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
