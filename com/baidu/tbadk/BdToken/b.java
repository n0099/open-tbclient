package com.baidu.tbadk.BdToken;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.aq;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class b {
    private volatile int cHA;
    private volatile int cHB;
    private boolean cHC;
    private int cHD;
    public boolean cHE;
    private final ArrayList<h> cHF;
    private int cHl;
    private int cHm;
    private long cHn;
    private String cHo;
    private int cHp;
    private long cHq;
    private String cHr;
    private String cHs;
    private String cHt;
    private String cHu;
    private long cHv;
    private int cHw;
    private long cHx;
    private int[] cHy;
    private long cHz;
    private int mCallType;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    public static String ACTIVITY_ID = "activityid";
    public static String cGH = "missionid";
    public static String cGI = "activitysource";
    public static String SOURCE = "source";
    public static String cGJ = "tab";
    public static String cGK = "calltype";
    public static String cGL = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String cGM = "browsetimepage";
    public static String cGN = "browsetime";
    public static String cGO = "threadnum";
    public static String cGP = "forumnum";
    public static String cGQ = "cleartype";
    public static String cGR = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String cGS = "threadtext";
    public static String cGT = "threadimg";
    public static String cGU = "threadforum";
    public static String cGV = "total_limit";
    public static int cGW = -1;
    public static int cGX = 1;
    public static int cGY = 2;
    public static int cGZ = 3;
    public static int cHa = 4;
    public static int cHb = 5;
    public static int cHc = 6;
    public static int cHd = 7;
    public static int cHe = 8;
    public static int cHf = 9;
    public static int cHg = -1;
    public static int cHh = 0;
    public static int cHi = 1;
    public static int cHj = 2;
    public static int cHk = 3;

    public void reset() {
        this.cHF.clear();
        this.cHA = 0;
        this.cHB = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.cHF.contains(hVar)) {
                this.cHF.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.cHF.contains(hVar)) {
                this.cHF.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.cHF.contains(hVar)) {
                this.cHF.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.cHF.contains(hVar)) {
                this.cHF.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.cHF.contains(hVar)) {
            this.cHF.add(hVar);
        }
    }

    public ArrayList<h> axb() {
        return this.cHF;
    }

    public int axc() {
        int i;
        int size = this.cHF.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHF, i2);
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

    public void axd() {
        int size = this.cHF.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHF, i);
            if (hVar != null) {
                hVar.fk(true);
            }
        }
    }

    public boolean bn(long j) {
        for (int i = 0; i < this.cHF.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHF, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.aW()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void N(int i, String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                long optLong = jSONObject.optLong("i");
                long optLong2 = jSONObject.optLong("t");
                boolean optBoolean = jSONObject.optBoolean("c");
                int optInt = jSONObject.optInt(Config.APP_VERSION_CODE);
                if (i == 7) {
                    if (optLong > 0) {
                        k kVar = new k(this, optLong);
                        kVar.fk(optBoolean);
                        kVar.bs(optLong2);
                        kVar.jj(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.fk(optBoolean);
                        mVar.bs(optLong2);
                        mVar.jj(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.fk(optBoolean);
                        jVar.bs(optLong2);
                        jVar.jj(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.fk(optBoolean);
                    iVar.bs(optLong2);
                    iVar.jj(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.fk(optBoolean);
                    lVar.bs(optLong2);
                    lVar.jj(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String axe() {
        try {
            ArrayList<h> arrayList = this.cHF;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.axY());
                jSONObject.put("c", hVar.aW());
                jSONObject.put(Config.APP_VERSION_CODE, hVar.getTag());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    public b() {
        this.cHw = cHg;
        this.cHA = 0;
        this.cHB = 0;
        this.cHC = false;
        this.cHD = 1;
        this.mTag = 0;
        this.cHE = false;
        this.cHF = new ArrayList<>();
    }

    public b(String str) {
        this.cHw = cHg;
        this.cHA = 0;
        this.cHB = 0;
        this.cHC = false;
        this.cHD = 1;
        this.mTag = 0;
        this.cHE = false;
        this.cHF = new ArrayList<>();
        rs(str);
    }

    public boolean rs(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.cHl = jSONObject.optInt(ACTIVITY_ID);
                this.cHm = jSONObject.optInt(cGH);
                this.cHr = jSONObject.optString(cGI);
                this.mSource = jSONObject.optString(SOURCE);
                this.cHs = jSONObject.optString(cGJ);
                this.mCallType = jSONObject.optInt(cGK);
                this.mTaskType = jSONObject.optInt(cGL);
                this.cHo = jSONObject.optString(cGM);
                this.cHy = rt(this.cHo);
                this.cHn = jSONObject.optLong(cGN);
                this.mThreadNum = jSONObject.optInt(cGO);
                this.cHp = jSONObject.optInt(cGP);
                this.cHw = jSONObject.optInt(cGQ);
                this.cHx = jSONObject.optLong(cGR);
                this.cHz = axk();
                this.cHq = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.cHt = jSONObject.optString(cGS);
                this.cHu = jSONObject.optString(cGT);
                this.cHv = jSONObject.optLong(cGU);
                int optInt = jSONObject.optInt(cGV);
                if (optInt > 0) {
                    this.cHD = optInt;
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
        this.cHw = cHg;
        this.cHA = 0;
        this.cHB = 0;
        this.cHC = false;
        this.cHD = 1;
        this.mTag = 0;
        this.cHE = false;
        this.cHF = new ArrayList<>();
        if (missionInfo != null) {
            this.cHl = missionInfo.activityid.intValue();
            this.cHm = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.cHw = missionInfo.cleartype.intValue();
            this.cHx = missionInfo.cleartime.intValue();
            this.cHz = axk();
            this.cHo = missionInfo.browsetimepage;
            this.cHy = rt(this.cHo);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.cHn = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.cHD = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean axf() {
        return this.cHl > 0 && this.cHm > 0 && this.mTaskType > 0 && this.cHn > 0;
    }

    public synchronized int axg() {
        int i;
        i = this.cHB + 1;
        this.cHB = i;
        return i;
    }

    public synchronized int axh() {
        int i;
        i = this.cHA + 1;
        this.cHA = i;
        return i;
    }

    public synchronized int axi() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] rt(String str) {
        if (this.mTaskType == 8) {
            return new int[]{cGW};
        }
        if (this.mTaskType == 7) {
            return new int[]{cGX, cHe, cHf};
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

    public boolean axj() {
        return System.currentTimeMillis() > axw() * 1000;
    }

    public long axk() {
        if (this.cHw == cHg) {
            return 0L;
        }
        if (this.cHw == cHh) {
            return (System.currentTimeMillis() / 1000) + this.cHx;
        }
        if (this.cHw == cHi) {
            long axl = (axl() / 1000) + this.cHx;
            if (System.currentTimeMillis() > axl) {
                return axl + 86400;
            }
            return axl;
        } else if (this.cHw == cHj) {
            return l((int) this.cHx, jc(4)) / 1000;
        } else {
            if (this.cHw == cHk) {
                return this.cHx / 1000;
            }
            return 0L;
        }
    }

    private long axl() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long jc(int i) {
        long axl = axl();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - axl;
    }

    private long l(int i, long j) {
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
        return this.cHl;
    }

    public void setActivityId(int i) {
        this.cHl = i;
    }

    public int axm() {
        return this.cHm;
    }

    public void jd(int i) {
        this.cHm = i;
    }

    public String axn() {
        return this.cHr;
    }

    public void ru(String str) {
        this.cHr = str;
    }

    public String axo() {
        return this.cHs;
    }

    public String getSource() {
        return this.mSource;
    }

    public int axp() {
        return this.mCallType;
    }

    public void je(int i) {
        this.mCallType = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void jf(int i) {
        this.mTaskType = i;
    }

    public String axq() {
        return this.cHo;
    }

    public void rv(String str) {
        this.cHo = str;
        this.cHy = rt(str);
    }

    public int[] axr() {
        return this.cHy;
    }

    public long axs() {
        return this.cHn;
    }

    public void bo(long j) {
        this.cHn = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int axt() {
        return this.cHp;
    }

    public void jg(int i) {
        this.cHp = i;
    }

    public int axu() {
        return this.cHw;
    }

    public void jh(int i) {
        this.cHw = i;
    }

    public long axv() {
        return this.cHx;
    }

    public void bp(long j) {
        this.cHx = j;
    }

    public long axw() {
        return this.cHz;
    }

    public void bq(long j) {
        this.cHz = j;
    }

    public long getTid() {
        return this.cHq;
    }

    public void setTid(long j) {
        this.cHq = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String axx() {
        return this.cHt;
    }

    public void rw(String str) {
        this.cHt = str;
    }

    public String axy() {
        return this.cHu;
    }

    public void rx(String str) {
        this.cHu = str;
    }

    public long axz() {
        return this.cHv;
    }

    public void br(long j) {
        this.cHv = j;
    }

    public int axA() {
        return this.cHD;
    }

    public void ji(int i) {
        this.cHD = i;
    }

    public void jj(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean axB() {
        return this.cHC;
    }

    public void fj(boolean z) {
        this.cHC = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
