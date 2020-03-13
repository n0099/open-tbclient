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
    private int cHa;
    private int cHb;
    private long cHc;
    private String cHd;
    private int cHe;
    private long cHf;
    private String cHg;
    private String cHh;
    private String cHi;
    private String cHj;
    private long cHk;
    private int cHl;
    private long cHm;
    private int[] cHn;
    private long cHo;
    private volatile int cHp;
    private volatile int cHq;
    private boolean cHr;
    private int cHs;
    public boolean cHt;
    private final ArrayList<h> cHu;
    private int mCallType;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    public static String ACTIVITY_ID = "activityid";
    public static String cGw = "missionid";
    public static String cGx = "activitysource";
    public static String SOURCE = "source";
    public static String cGy = "tab";
    public static String cGz = "calltype";
    public static String cGA = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String cGB = "browsetimepage";
    public static String cGC = "browsetime";
    public static String cGD = "threadnum";
    public static String cGE = "forumnum";
    public static String cGF = "cleartype";
    public static String cGG = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String cGH = "threadtext";
    public static String cGI = "threadimg";
    public static String cGJ = "threadforum";
    public static String cGK = "total_limit";
    public static int cGL = -1;
    public static int cGM = 1;
    public static int cGN = 2;
    public static int cGO = 3;
    public static int cGP = 4;
    public static int cGQ = 5;
    public static int cGR = 6;
    public static int cGS = 7;
    public static int cGT = 8;
    public static int cGU = 9;
    public static int cGV = -1;
    public static int cGW = 0;
    public static int cGX = 1;
    public static int cGY = 2;
    public static int cGZ = 3;

    public void reset() {
        this.cHu.clear();
        this.cHp = 0;
        this.cHq = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.cHu.contains(hVar)) {
                this.cHu.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.cHu.contains(hVar)) {
                this.cHu.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.cHu.contains(hVar)) {
                this.cHu.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.cHu.contains(hVar)) {
                this.cHu.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.cHu.contains(hVar)) {
            this.cHu.add(hVar);
        }
    }

    public ArrayList<h> awY() {
        return this.cHu;
    }

    public int awZ() {
        int i;
        int size = this.cHu.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHu, i2);
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

    public void axa() {
        int size = this.cHu.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHu, i);
            if (hVar != null) {
                hVar.fj(true);
            }
        }
    }

    public boolean bn(long j) {
        for (int i = 0; i < this.cHu.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHu, i);
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
                        kVar.fj(optBoolean);
                        kVar.bs(optLong2);
                        kVar.jj(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.fj(optBoolean);
                        mVar.bs(optLong2);
                        mVar.jj(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.fj(optBoolean);
                        jVar.bs(optLong2);
                        jVar.jj(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.fj(optBoolean);
                    iVar.bs(optLong2);
                    iVar.jj(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.fj(optBoolean);
                    lVar.bs(optLong2);
                    lVar.jj(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String axb() {
        try {
            ArrayList<h> arrayList = this.cHu;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.axV());
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
        this.cHl = cGV;
        this.cHp = 0;
        this.cHq = 0;
        this.cHr = false;
        this.cHs = 1;
        this.mTag = 0;
        this.cHt = false;
        this.cHu = new ArrayList<>();
    }

    public b(String str) {
        this.cHl = cGV;
        this.cHp = 0;
        this.cHq = 0;
        this.cHr = false;
        this.cHs = 1;
        this.mTag = 0;
        this.cHt = false;
        this.cHu = new ArrayList<>();
        rt(str);
    }

    public boolean rt(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.cHa = jSONObject.optInt(ACTIVITY_ID);
                this.cHb = jSONObject.optInt(cGw);
                this.cHg = jSONObject.optString(cGx);
                this.mSource = jSONObject.optString(SOURCE);
                this.cHh = jSONObject.optString(cGy);
                this.mCallType = jSONObject.optInt(cGz);
                this.mTaskType = jSONObject.optInt(cGA);
                this.cHd = jSONObject.optString(cGB);
                this.cHn = ru(this.cHd);
                this.cHc = jSONObject.optLong(cGC);
                this.mThreadNum = jSONObject.optInt(cGD);
                this.cHe = jSONObject.optInt(cGE);
                this.cHl = jSONObject.optInt(cGF);
                this.cHm = jSONObject.optLong(cGG);
                this.cHo = axh();
                this.cHf = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.cHi = jSONObject.optString(cGH);
                this.cHj = jSONObject.optString(cGI);
                this.cHk = jSONObject.optLong(cGJ);
                int optInt = jSONObject.optInt(cGK);
                if (optInt > 0) {
                    this.cHs = optInt;
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
        this.cHl = cGV;
        this.cHp = 0;
        this.cHq = 0;
        this.cHr = false;
        this.cHs = 1;
        this.mTag = 0;
        this.cHt = false;
        this.cHu = new ArrayList<>();
        if (missionInfo != null) {
            this.cHa = missionInfo.activityid.intValue();
            this.cHb = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.cHl = missionInfo.cleartype.intValue();
            this.cHm = missionInfo.cleartime.intValue();
            this.cHo = axh();
            this.cHd = missionInfo.browsetimepage;
            this.cHn = ru(this.cHd);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.cHc = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.cHs = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean axc() {
        return this.cHa > 0 && this.cHb > 0 && this.mTaskType > 0 && this.cHc > 0;
    }

    public synchronized int axd() {
        int i;
        i = this.cHq + 1;
        this.cHq = i;
        return i;
    }

    public synchronized int axe() {
        int i;
        i = this.cHp + 1;
        this.cHp = i;
        return i;
    }

    public synchronized int axf() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] ru(String str) {
        if (this.mTaskType == 8) {
            return new int[]{cGL};
        }
        if (this.mTaskType == 7) {
            return new int[]{cGM, cGT, cGU};
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

    public boolean axg() {
        return System.currentTimeMillis() > axt() * 1000;
    }

    public long axh() {
        if (this.cHl == cGV) {
            return 0L;
        }
        if (this.cHl == cGW) {
            return (System.currentTimeMillis() / 1000) + this.cHm;
        }
        if (this.cHl == cGX) {
            long axi = (axi() / 1000) + this.cHm;
            if (System.currentTimeMillis() > axi) {
                return axi + 86400;
            }
            return axi;
        } else if (this.cHl == cGY) {
            return l((int) this.cHm, jc(4)) / 1000;
        } else {
            if (this.cHl == cGZ) {
                return this.cHm / 1000;
            }
            return 0L;
        }
    }

    private long axi() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long jc(int i) {
        long axi = axi();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - axi;
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
        return this.cHa;
    }

    public void setActivityId(int i) {
        this.cHa = i;
    }

    public int axj() {
        return this.cHb;
    }

    public void jd(int i) {
        this.cHb = i;
    }

    public String axk() {
        return this.cHg;
    }

    public void rv(String str) {
        this.cHg = str;
    }

    public String axl() {
        return this.cHh;
    }

    public String getSource() {
        return this.mSource;
    }

    public int axm() {
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

    public String axn() {
        return this.cHd;
    }

    public void rw(String str) {
        this.cHd = str;
        this.cHn = ru(str);
    }

    public int[] axo() {
        return this.cHn;
    }

    public long axp() {
        return this.cHc;
    }

    public void bo(long j) {
        this.cHc = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int axq() {
        return this.cHe;
    }

    public void jg(int i) {
        this.cHe = i;
    }

    public int axr() {
        return this.cHl;
    }

    public void jh(int i) {
        this.cHl = i;
    }

    public long axs() {
        return this.cHm;
    }

    public void bp(long j) {
        this.cHm = j;
    }

    public long axt() {
        return this.cHo;
    }

    public void bq(long j) {
        this.cHo = j;
    }

    public long getTid() {
        return this.cHf;
    }

    public void setTid(long j) {
        this.cHf = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String axu() {
        return this.cHi;
    }

    public void rx(String str) {
        this.cHi = str;
    }

    public String axv() {
        return this.cHj;
    }

    public void ry(String str) {
        this.cHj = str;
    }

    public long axw() {
        return this.cHk;
    }

    public void br(long j) {
        this.cHk = j;
    }

    public int axx() {
        return this.cHs;
    }

    public void ji(int i) {
        this.cHs = i;
    }

    public void jj(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean axy() {
        return this.cHr;
    }

    public void fi(boolean z) {
        this.cHr = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
