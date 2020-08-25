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
/* loaded from: classes2.dex */
public class b {
    private int dNT;
    private int dNU;
    private long dNV;
    private String dNW;
    private int dNX;
    private long dNY;
    private String dNZ;
    private String dOa;
    private String dOb;
    private String dOc;
    private long dOd;
    private int dOe;
    private long dOf;
    private int[] dOg;
    private long dOh;
    private volatile int dOi;
    private volatile int dOj;
    private boolean dOk;
    private int dOl;
    public boolean dOm;
    private final ArrayList<h> dOn;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int yO;
    public static String ACTIVITY_ID = "activityid";
    public static String dNp = "missionid";
    public static String dNq = "activitysource";
    public static String SOURCE = "source";
    public static String dNr = "tab";
    public static String dNs = "calltype";
    public static String dNt = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String dNu = "browsetimepage";
    public static String dNv = "browsetime";
    public static String dNw = "threadnum";
    public static String dNx = "forumnum";
    public static String dNy = "cleartype";
    public static String dNz = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String dNA = "threadtext";
    public static String dNB = "threadimg";
    public static String dNC = "threadforum";
    public static String dND = "total_limit";
    public static int dNE = -1;
    public static int dNF = 1;
    public static int dNG = 2;
    public static int dNH = 3;
    public static int dNI = 4;
    public static int dNJ = 5;
    public static int dNK = 6;
    public static int dNL = 7;
    public static int dNM = 8;
    public static int dNN = 9;
    public static int dNO = -1;
    public static int dNP = 0;
    public static int dNQ = 1;
    public static int dNR = 2;
    public static int dNS = 3;

    public void reset() {
        this.dOn.clear();
        this.dOi = 0;
        this.dOj = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.dOn.contains(hVar)) {
                this.dOn.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.dOn.contains(hVar)) {
                this.dOn.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.dOn.contains(hVar)) {
                this.dOn.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.dOn.contains(hVar)) {
                this.dOn.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.dOn.contains(hVar)) {
            this.dOn.add(hVar);
        }
    }

    public ArrayList<h> aXR() {
        return this.dOn;
    }

    public int aXS() {
        int i;
        int size = this.dOn.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) y.getItem(this.dOn, i2);
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

    public void aXT() {
        int size = this.dOn.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) y.getItem(this.dOn, i);
            if (hVar != null) {
                hVar.hv(true);
            }
        }
    }

    public boolean cr(long j) {
        for (int i = 0; i < this.dOn.size(); i++) {
            h hVar = (h) y.getItem(this.dOn, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.ij()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void aj(int i, String str) {
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
                        kVar.hv(optBoolean);
                        kVar.cw(optLong2);
                        kVar.mC(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.hv(optBoolean);
                        mVar.cw(optLong2);
                        mVar.mC(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.hv(optBoolean);
                        jVar.cw(optLong2);
                        jVar.mC(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.hv(optBoolean);
                    iVar.cw(optLong2);
                    iVar.mC(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.hv(optBoolean);
                    lVar.cw(optLong2);
                    lVar.mC(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String aXU() {
        try {
            ArrayList<h> arrayList = this.dOn;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) y.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.aYR());
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
        this.dOe = dNO;
        this.dOi = 0;
        this.dOj = 0;
        this.dOk = false;
        this.dOl = 1;
        this.mTag = 0;
        this.dOm = false;
        this.dOn = new ArrayList<>();
    }

    public b(String str) {
        this.dOe = dNO;
        this.dOi = 0;
        this.dOj = 0;
        this.dOk = false;
        this.dOl = 1;
        this.mTag = 0;
        this.dOm = false;
        this.dOn = new ArrayList<>();
        xG(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            mw(activeCenterMissionData.mission_id);
            mB(activeCenterMissionData.total_limit);
            my(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            mA(activeCenterMissionData.cleartype);
            ct(activeCenterMissionData.cleartime);
        }
    }

    public boolean xG(String str) {
        if (at.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.dNT = jSONObject.optInt(ACTIVITY_ID);
                this.dNU = jSONObject.optInt(dNp);
                this.dNZ = jSONObject.optString(dNq);
                this.mSource = jSONObject.optString(SOURCE);
                this.dOa = jSONObject.optString(dNr);
                this.yO = jSONObject.optInt(dNs);
                this.mTaskType = jSONObject.optInt(dNt);
                this.dNW = jSONObject.optString(dNu);
                this.dOg = xH(this.dNW);
                this.dNV = jSONObject.optLong(dNv);
                this.mThreadNum = jSONObject.optInt(dNw);
                this.dNX = jSONObject.optInt(dNx);
                this.dOe = jSONObject.optInt(dNy);
                this.dOf = jSONObject.optLong(dNz);
                this.dOh = aYa();
                this.dNY = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.dOb = jSONObject.optString(dNA);
                this.dOc = jSONObject.optString(dNB);
                this.dOd = jSONObject.optLong(dNC);
                int optInt = jSONObject.optInt(dND);
                if (optInt > 0) {
                    this.dOl = optInt;
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
        this.dOe = dNO;
        this.dOi = 0;
        this.dOj = 0;
        this.dOk = false;
        this.dOl = 1;
        this.mTag = 0;
        this.dOm = false;
        this.dOn = new ArrayList<>();
        if (missionInfo != null) {
            this.dNT = missionInfo.activityid.intValue();
            this.dNU = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.dOe = missionInfo.cleartype.intValue();
            this.dOf = missionInfo.cleartime.intValue();
            this.dOh = aYa();
            this.dNW = missionInfo.browsetimepage;
            this.dOg = xH(this.dNW);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.dNV = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.dOl = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean aXV() {
        return this.dNT > 0 && this.dNU > 0 && this.mTaskType > 0 && this.dNV > 0;
    }

    public synchronized int aXW() {
        int i;
        i = this.dOj + 1;
        this.dOj = i;
        return i;
    }

    public synchronized int aXX() {
        int i;
        i = this.dOi + 1;
        this.dOi = i;
        return i;
    }

    public synchronized int aXY() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] xH(String str) {
        if (this.mTaskType == 8) {
            return new int[]{dNE};
        }
        if (this.mTaskType == 7) {
            return new int[]{dNF, dNM, dNN};
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

    public boolean aXZ() {
        return System.currentTimeMillis() > aYm() * 1000;
    }

    public long aYa() {
        if (this.dOe == dNO) {
            return 0L;
        }
        if (this.dOe == dNP) {
            return (System.currentTimeMillis() / 1000) + this.dOf;
        }
        if (this.dOe == dNQ) {
            long aYb = (aYb() / 1000) + this.dOf;
            if (System.currentTimeMillis() > aYb) {
                return aYb + 86400;
            }
            return aYb;
        } else if (this.dOe == dNR) {
            return m((int) this.dOf, mv(4)) / 1000;
        } else {
            if (this.dOe == dNS) {
                return this.dOf / 1000;
            }
            return 0L;
        }
    }

    private long aYb() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long mv(int i) {
        long aYb = aYb();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - aYb;
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
        return this.dNT;
    }

    public void setActivityId(int i) {
        this.dNT = i;
    }

    public int aYc() {
        return this.dNU;
    }

    public void mw(int i) {
        this.dNU = i;
    }

    public String aYd() {
        return this.dNZ;
    }

    public void xI(String str) {
        this.dNZ = str;
    }

    public String aYe() {
        return this.dOa;
    }

    public String getSource() {
        return this.mSource;
    }

    public int aYf() {
        return this.yO;
    }

    public void mx(int i) {
        this.yO = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void my(int i) {
        this.mTaskType = i;
    }

    public String aYg() {
        return this.dNW;
    }

    public void xJ(String str) {
        this.dNW = str;
        this.dOg = xH(str);
    }

    public int[] aYh() {
        return this.dOg;
    }

    public long aYi() {
        return this.dNV;
    }

    public void cs(long j) {
        this.dNV = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int aYj() {
        return this.dNX;
    }

    public void mz(int i) {
        this.dNX = i;
    }

    public int aYk() {
        return this.dOe;
    }

    public void mA(int i) {
        this.dOe = i;
    }

    public long aYl() {
        return this.dOf;
    }

    public void ct(long j) {
        this.dOf = j;
    }

    public long aYm() {
        return this.dOh;
    }

    public void cu(long j) {
        this.dOh = j;
    }

    public long getTid() {
        return this.dNY;
    }

    public void setTid(long j) {
        this.dNY = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String aYn() {
        return this.dOb;
    }

    public void xK(String str) {
        this.dOb = str;
    }

    public String aYo() {
        return this.dOc;
    }

    public void xL(String str) {
        this.dOc = str;
    }

    public long aYp() {
        return this.dOd;
    }

    public void cv(long j) {
        this.dOd = j;
    }

    public int aYq() {
        return this.dOl;
    }

    public void mB(int i) {
        this.dOl = i;
    }

    public void mC(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean aYr() {
        return this.dOk;
    }

    public void hu(boolean z) {
        this.dOk = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
