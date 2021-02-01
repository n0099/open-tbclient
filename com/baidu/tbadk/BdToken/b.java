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
    private String eCA;
    private String eCB;
    private String eCC;
    private long eCD;
    private int eCE;
    private long eCF;
    private int[] eCG;
    private long eCH;
    private volatile int eCI;
    private volatile int eCJ;
    private boolean eCK;
    private int eCL;
    public boolean eCM;
    private final ArrayList<h> eCN;
    private int eCt;
    private int eCu;
    private long eCv;
    private String eCw;
    private int eCx;
    private long eCy;
    private String eCz;
    private int mCallType;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    public static String ACTIVITY_ID = "activityid";
    public static String eBP = "missionid";
    public static String eBQ = "activitysource";
    public static String SOURCE = "source";
    public static String eBR = "tab";
    public static String eBS = "calltype";
    public static String eBT = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String eBU = "browsetimepage";
    public static String eBV = "browsetime";
    public static String eBW = "threadnum";
    public static String eBX = "forumnum";
    public static String eBY = "cleartype";
    public static String eBZ = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String eCa = "threadtext";
    public static String eCb = "threadimg";
    public static String eCc = "threadforum";
    public static String eCd = "total_limit";
    public static int eCe = -1;
    public static int eCf = 1;
    public static int eCg = 2;
    public static int eCh = 3;
    public static int eCi = 4;
    public static int eCj = 5;
    public static int eCk = 6;
    public static int eCl = 7;
    public static int eCm = 8;
    public static int eCn = 9;
    public static int eCo = -1;
    public static int eCp = 0;
    public static int eCq = 1;
    public static int eCr = 2;
    public static int eCs = 3;

    public void reset() {
        this.eCN.clear();
        this.eCI = 0;
        this.eCJ = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.eCN.contains(hVar)) {
                this.eCN.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.eCN.contains(hVar)) {
                this.eCN.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.eCN.contains(hVar)) {
                this.eCN.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.eCN.contains(hVar)) {
                this.eCN.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.eCN.contains(hVar)) {
            this.eCN.add(hVar);
        }
    }

    public ArrayList<h> bgM() {
        return this.eCN;
    }

    public int bgN() {
        int i;
        int size = this.eCN.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.y.getItem(this.eCN, i2);
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

    public void bgO() {
        int size = this.eCN.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.y.getItem(this.eCN, i);
            if (hVar != null) {
                hVar.iW(true);
            }
        }
    }

    public boolean dD(long j) {
        for (int i = 0; i < this.eCN.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.y.getItem(this.eCN, i);
            if (hVar != null) {
                long b2 = b(hVar);
                if (b2 > 0 && b2 == j && hVar.isCompleted()) {
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
                        kVar.mF(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.iW(optBoolean);
                        mVar.dI(optLong2);
                        mVar.mF(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.iW(optBoolean);
                        jVar.dI(optLong2);
                        jVar.mF(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.iW(optBoolean);
                    iVar.dI(optLong2);
                    iVar.mF(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.iW(optBoolean);
                    lVar.dI(optLong2);
                    lVar.mF(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String bgP() {
        try {
            ArrayList<h> arrayList = this.eCN;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.bhN());
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
        this.eCE = eCo;
        this.eCI = 0;
        this.eCJ = 0;
        this.eCK = false;
        this.eCL = 1;
        this.mTag = 0;
        this.eCM = false;
        this.eCN = new ArrayList<>();
    }

    public b(String str) {
        this.eCE = eCo;
        this.eCI = 0;
        this.eCJ = 0;
        this.eCK = false;
        this.eCL = 1;
        this.mTag = 0;
        this.eCM = false;
        this.eCN = new ArrayList<>();
        yX(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            mz(activeCenterMissionData.mission_id);
            mE(activeCenterMissionData.total_limit);
            mB(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            mD(activeCenterMissionData.cleartype);
            dF(activeCenterMissionData.cleartime);
        }
    }

    public boolean yX(String str) {
        if (au.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.eCt = jSONObject.optInt(ACTIVITY_ID);
                this.eCu = jSONObject.optInt(eBP);
                this.eCz = jSONObject.optString(eBQ);
                this.mSource = jSONObject.optString(SOURCE);
                this.eCA = jSONObject.optString(eBR);
                this.mCallType = jSONObject.optInt(eBS);
                this.mTaskType = jSONObject.optInt(eBT);
                this.eCw = jSONObject.optString(eBU);
                this.eCG = yY(this.eCw);
                this.eCv = jSONObject.optLong(eBV);
                this.mThreadNum = jSONObject.optInt(eBW);
                this.eCx = jSONObject.optInt(eBX);
                this.eCE = jSONObject.optInt(eBY);
                this.eCF = jSONObject.optLong(eBZ);
                this.eCH = bgV();
                this.eCy = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.eCB = jSONObject.optString(eCa);
                this.eCC = jSONObject.optString(eCb);
                this.eCD = jSONObject.optLong(eCc);
                int optInt = jSONObject.optInt(eCd);
                if (optInt > 0) {
                    this.eCL = optInt;
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
        this.eCE = eCo;
        this.eCI = 0;
        this.eCJ = 0;
        this.eCK = false;
        this.eCL = 1;
        this.mTag = 0;
        this.eCM = false;
        this.eCN = new ArrayList<>();
        if (missionInfo != null) {
            this.eCt = missionInfo.activityid.intValue();
            this.eCu = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.eCE = missionInfo.cleartype.intValue();
            this.eCF = missionInfo.cleartime.intValue();
            this.eCH = bgV();
            this.eCw = missionInfo.browsetimepage;
            this.eCG = yY(this.eCw);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.eCv = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.eCL = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean bgQ() {
        return this.eCt > 0 && this.eCu > 0 && this.mTaskType > 0 && this.eCv > 0;
    }

    public synchronized int bgR() {
        int i;
        i = this.eCJ + 1;
        this.eCJ = i;
        return i;
    }

    public synchronized int bgS() {
        int i;
        i = this.eCI + 1;
        this.eCI = i;
        return i;
    }

    public synchronized int bgT() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] yY(String str) {
        if (this.mTaskType == 8) {
            return new int[]{eCe};
        }
        if (this.mTaskType == 7) {
            return new int[]{eCf, eCm, eCn};
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

    public boolean bgU() {
        return System.currentTimeMillis() > bhh() * 1000;
    }

    public long bgV() {
        if (this.eCE == eCo) {
            return 0L;
        }
        if (this.eCE == eCp) {
            return (System.currentTimeMillis() / 1000) + this.eCF;
        }
        if (this.eCE == eCq) {
            long bgW = (bgW() / 1000) + this.eCF;
            if (System.currentTimeMillis() > bgW) {
                return bgW + 86400;
            }
            return bgW;
        } else if (this.eCE == eCr) {
            return n((int) this.eCF, my(4)) / 1000;
        } else {
            if (this.eCE == eCs) {
                return this.eCF / 1000;
            }
            return 0L;
        }
    }

    private long bgW() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long my(int i) {
        long bgW = bgW();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - bgW;
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
        return this.eCt;
    }

    public void setActivityId(int i) {
        this.eCt = i;
    }

    public int bgX() {
        return this.eCu;
    }

    public void mz(int i) {
        this.eCu = i;
    }

    public String bgY() {
        return this.eCz;
    }

    public void yZ(String str) {
        this.eCz = str;
    }

    public String bgZ() {
        return this.eCA;
    }

    public String getSource() {
        return this.mSource;
    }

    public int bha() {
        return this.mCallType;
    }

    public void mA(int i) {
        this.mCallType = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void mB(int i) {
        this.mTaskType = i;
    }

    public String bhb() {
        return this.eCw;
    }

    public void za(String str) {
        this.eCw = str;
        this.eCG = yY(str);
    }

    public int[] bhc() {
        return this.eCG;
    }

    public long bhd() {
        return this.eCv;
    }

    public void dE(long j) {
        this.eCv = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int bhe() {
        return this.eCx;
    }

    public void mC(int i) {
        this.eCx = i;
    }

    public int bhf() {
        return this.eCE;
    }

    public void mD(int i) {
        this.eCE = i;
    }

    public long bhg() {
        return this.eCF;
    }

    public void dF(long j) {
        this.eCF = j;
    }

    public long bhh() {
        return this.eCH;
    }

    public void dG(long j) {
        this.eCH = j;
    }

    public long getTid() {
        return this.eCy;
    }

    public void setTid(long j) {
        this.eCy = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String bhi() {
        return this.eCB;
    }

    public void zb(String str) {
        this.eCB = str;
    }

    public String bhj() {
        return this.eCC;
    }

    public void zc(String str) {
        this.eCC = str;
    }

    public long bhk() {
        return this.eCD;
    }

    public void dH(long j) {
        this.eCD = j;
    }

    public int bhl() {
        return this.eCL;
    }

    public void mE(int i) {
        this.eCL = i;
    }

    public void mF(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean bhm() {
        return this.eCK;
    }

    public void iV(boolean z) {
        this.eCK = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
