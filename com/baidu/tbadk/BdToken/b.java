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
    private int dNX;
    private int dNY;
    private long dNZ;
    private String dOa;
    private int dOb;
    private long dOc;
    private String dOd;
    private String dOe;
    private String dOf;
    private String dOg;
    private long dOh;
    private int dOi;
    private long dOj;
    private int[] dOk;
    private long dOl;
    private volatile int dOm;
    private volatile int dOn;
    private boolean dOo;
    private int dOp;
    public boolean dOq;
    private final ArrayList<h> dOr;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int yO;
    public static String ACTIVITY_ID = "activityid";
    public static String dNt = "missionid";
    public static String dNu = "activitysource";
    public static String SOURCE = "source";
    public static String dNv = "tab";
    public static String dNw = "calltype";
    public static String dNx = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String dNy = "browsetimepage";
    public static String dNz = "browsetime";
    public static String dNA = "threadnum";
    public static String dNB = "forumnum";
    public static String dNC = "cleartype";
    public static String dND = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String dNE = "threadtext";
    public static String dNF = "threadimg";
    public static String dNG = "threadforum";
    public static String dNH = "total_limit";
    public static int dNI = -1;
    public static int dNJ = 1;
    public static int dNK = 2;
    public static int dNL = 3;
    public static int dNM = 4;
    public static int dNN = 5;
    public static int dNO = 6;
    public static int dNP = 7;
    public static int dNQ = 8;
    public static int dNR = 9;
    public static int dNS = -1;
    public static int dNT = 0;
    public static int dNU = 1;
    public static int dNV = 2;
    public static int dNW = 3;

    public void reset() {
        this.dOr.clear();
        this.dOm = 0;
        this.dOn = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.dOr.contains(hVar)) {
                this.dOr.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.dOr.contains(hVar)) {
                this.dOr.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.dOr.contains(hVar)) {
                this.dOr.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.dOr.contains(hVar)) {
                this.dOr.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.dOr.contains(hVar)) {
            this.dOr.add(hVar);
        }
    }

    public ArrayList<h> aXR() {
        return this.dOr;
    }

    public int aXS() {
        int i;
        int size = this.dOr.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) y.getItem(this.dOr, i2);
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
        int size = this.dOr.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) y.getItem(this.dOr, i);
            if (hVar != null) {
                hVar.hw(true);
            }
        }
    }

    public boolean cr(long j) {
        for (int i = 0; i < this.dOr.size(); i++) {
            h hVar = (h) y.getItem(this.dOr, i);
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
                        kVar.hw(optBoolean);
                        kVar.cw(optLong2);
                        kVar.mC(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.hw(optBoolean);
                        mVar.cw(optLong2);
                        mVar.mC(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.hw(optBoolean);
                        jVar.cw(optLong2);
                        jVar.mC(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.hw(optBoolean);
                    iVar.cw(optLong2);
                    iVar.mC(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.hw(optBoolean);
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
            ArrayList<h> arrayList = this.dOr;
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
        this.dOi = dNS;
        this.dOm = 0;
        this.dOn = 0;
        this.dOo = false;
        this.dOp = 1;
        this.mTag = 0;
        this.dOq = false;
        this.dOr = new ArrayList<>();
    }

    public b(String str) {
        this.dOi = dNS;
        this.dOm = 0;
        this.dOn = 0;
        this.dOo = false;
        this.dOp = 1;
        this.mTag = 0;
        this.dOq = false;
        this.dOr = new ArrayList<>();
        xH(str);
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

    public boolean xH(String str) {
        if (at.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.dNX = jSONObject.optInt(ACTIVITY_ID);
                this.dNY = jSONObject.optInt(dNt);
                this.dOd = jSONObject.optString(dNu);
                this.mSource = jSONObject.optString(SOURCE);
                this.dOe = jSONObject.optString(dNv);
                this.yO = jSONObject.optInt(dNw);
                this.mTaskType = jSONObject.optInt(dNx);
                this.dOa = jSONObject.optString(dNy);
                this.dOk = xI(this.dOa);
                this.dNZ = jSONObject.optLong(dNz);
                this.mThreadNum = jSONObject.optInt(dNA);
                this.dOb = jSONObject.optInt(dNB);
                this.dOi = jSONObject.optInt(dNC);
                this.dOj = jSONObject.optLong(dND);
                this.dOl = aYa();
                this.dOc = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.dOf = jSONObject.optString(dNE);
                this.dOg = jSONObject.optString(dNF);
                this.dOh = jSONObject.optLong(dNG);
                int optInt = jSONObject.optInt(dNH);
                if (optInt > 0) {
                    this.dOp = optInt;
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
        this.dOi = dNS;
        this.dOm = 0;
        this.dOn = 0;
        this.dOo = false;
        this.dOp = 1;
        this.mTag = 0;
        this.dOq = false;
        this.dOr = new ArrayList<>();
        if (missionInfo != null) {
            this.dNX = missionInfo.activityid.intValue();
            this.dNY = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.dOi = missionInfo.cleartype.intValue();
            this.dOj = missionInfo.cleartime.intValue();
            this.dOl = aYa();
            this.dOa = missionInfo.browsetimepage;
            this.dOk = xI(this.dOa);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.dNZ = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.dOp = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean aXV() {
        return this.dNX > 0 && this.dNY > 0 && this.mTaskType > 0 && this.dNZ > 0;
    }

    public synchronized int aXW() {
        int i;
        i = this.dOn + 1;
        this.dOn = i;
        return i;
    }

    public synchronized int aXX() {
        int i;
        i = this.dOm + 1;
        this.dOm = i;
        return i;
    }

    public synchronized int aXY() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] xI(String str) {
        if (this.mTaskType == 8) {
            return new int[]{dNI};
        }
        if (this.mTaskType == 7) {
            return new int[]{dNJ, dNQ, dNR};
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
        if (this.dOi == dNS) {
            return 0L;
        }
        if (this.dOi == dNT) {
            return (System.currentTimeMillis() / 1000) + this.dOj;
        }
        if (this.dOi == dNU) {
            long aYb = (aYb() / 1000) + this.dOj;
            if (System.currentTimeMillis() > aYb) {
                return aYb + 86400;
            }
            return aYb;
        } else if (this.dOi == dNV) {
            return m((int) this.dOj, mv(4)) / 1000;
        } else {
            if (this.dOi == dNW) {
                return this.dOj / 1000;
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
        return this.dNX;
    }

    public void setActivityId(int i) {
        this.dNX = i;
    }

    public int aYc() {
        return this.dNY;
    }

    public void mw(int i) {
        this.dNY = i;
    }

    public String aYd() {
        return this.dOd;
    }

    public void xJ(String str) {
        this.dOd = str;
    }

    public String aYe() {
        return this.dOe;
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
        return this.dOa;
    }

    public void xK(String str) {
        this.dOa = str;
        this.dOk = xI(str);
    }

    public int[] aYh() {
        return this.dOk;
    }

    public long aYi() {
        return this.dNZ;
    }

    public void cs(long j) {
        this.dNZ = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int aYj() {
        return this.dOb;
    }

    public void mz(int i) {
        this.dOb = i;
    }

    public int aYk() {
        return this.dOi;
    }

    public void mA(int i) {
        this.dOi = i;
    }

    public long aYl() {
        return this.dOj;
    }

    public void ct(long j) {
        this.dOj = j;
    }

    public long aYm() {
        return this.dOl;
    }

    public void cu(long j) {
        this.dOl = j;
    }

    public long getTid() {
        return this.dOc;
    }

    public void setTid(long j) {
        this.dOc = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String aYn() {
        return this.dOf;
    }

    public void xL(String str) {
        this.dOf = str;
    }

    public String aYo() {
        return this.dOg;
    }

    public void xM(String str) {
        this.dOg = str;
    }

    public long aYp() {
        return this.dOh;
    }

    public void cv(long j) {
        this.dOh = j;
    }

    public int aYq() {
        return this.dOp;
    }

    public void mB(int i) {
        this.dOp = i;
    }

    public void mC(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean aYr() {
        return this.dOo;
    }

    public void hv(boolean z) {
        this.dOo = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
