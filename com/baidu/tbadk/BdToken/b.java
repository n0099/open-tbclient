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
    private int cGZ;
    private int cHa;
    private long cHb;
    private String cHc;
    private int cHd;
    private long cHe;
    private String cHf;
    private String cHg;
    private String cHh;
    private String cHi;
    private long cHj;
    private int cHk;
    private long cHl;
    private int[] cHm;
    private long cHn;
    private volatile int cHo;
    private volatile int cHp;
    private boolean cHq;
    private int cHr;
    public boolean cHs;
    private final ArrayList<h> cHt;
    private int mCallType;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    public static String ACTIVITY_ID = "activityid";
    public static String cGv = "missionid";
    public static String cGw = "activitysource";
    public static String SOURCE = "source";
    public static String cGx = "tab";
    public static String cGy = "calltype";
    public static String cGz = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String cGA = "browsetimepage";
    public static String cGB = "browsetime";
    public static String cGC = "threadnum";
    public static String cGD = "forumnum";
    public static String cGE = "cleartype";
    public static String cGF = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String cGG = "threadtext";
    public static String cGH = "threadimg";
    public static String cGI = "threadforum";
    public static String cGJ = "total_limit";
    public static int cGK = -1;
    public static int cGL = 1;
    public static int cGM = 2;
    public static int cGN = 3;
    public static int cGO = 4;
    public static int cGP = 5;
    public static int cGQ = 6;
    public static int cGR = 7;
    public static int cGS = 8;
    public static int cGT = 9;
    public static int cGU = -1;
    public static int cGV = 0;
    public static int cGW = 1;
    public static int cGX = 2;
    public static int cGY = 3;

    public void reset() {
        this.cHt.clear();
        this.cHo = 0;
        this.cHp = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.cHt.contains(hVar)) {
                this.cHt.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.cHt.contains(hVar)) {
                this.cHt.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.cHt.contains(hVar)) {
                this.cHt.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.cHt.contains(hVar)) {
                this.cHt.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.cHt.contains(hVar)) {
            this.cHt.add(hVar);
        }
    }

    public ArrayList<h> awY() {
        return this.cHt;
    }

    public int awZ() {
        int i;
        int size = this.cHt.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHt, i2);
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
        int size = this.cHt.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHt, i);
            if (hVar != null) {
                hVar.fj(true);
            }
        }
    }

    public boolean bn(long j) {
        for (int i = 0; i < this.cHt.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHt, i);
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
            ArrayList<h> arrayList = this.cHt;
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
        this.cHk = cGU;
        this.cHo = 0;
        this.cHp = 0;
        this.cHq = false;
        this.cHr = 1;
        this.mTag = 0;
        this.cHs = false;
        this.cHt = new ArrayList<>();
    }

    public b(String str) {
        this.cHk = cGU;
        this.cHo = 0;
        this.cHp = 0;
        this.cHq = false;
        this.cHr = 1;
        this.mTag = 0;
        this.cHs = false;
        this.cHt = new ArrayList<>();
        rt(str);
    }

    public boolean rt(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.cGZ = jSONObject.optInt(ACTIVITY_ID);
                this.cHa = jSONObject.optInt(cGv);
                this.cHf = jSONObject.optString(cGw);
                this.mSource = jSONObject.optString(SOURCE);
                this.cHg = jSONObject.optString(cGx);
                this.mCallType = jSONObject.optInt(cGy);
                this.mTaskType = jSONObject.optInt(cGz);
                this.cHc = jSONObject.optString(cGA);
                this.cHm = ru(this.cHc);
                this.cHb = jSONObject.optLong(cGB);
                this.mThreadNum = jSONObject.optInt(cGC);
                this.cHd = jSONObject.optInt(cGD);
                this.cHk = jSONObject.optInt(cGE);
                this.cHl = jSONObject.optLong(cGF);
                this.cHn = axh();
                this.cHe = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.cHh = jSONObject.optString(cGG);
                this.cHi = jSONObject.optString(cGH);
                this.cHj = jSONObject.optLong(cGI);
                int optInt = jSONObject.optInt(cGJ);
                if (optInt > 0) {
                    this.cHr = optInt;
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
        this.cHk = cGU;
        this.cHo = 0;
        this.cHp = 0;
        this.cHq = false;
        this.cHr = 1;
        this.mTag = 0;
        this.cHs = false;
        this.cHt = new ArrayList<>();
        if (missionInfo != null) {
            this.cGZ = missionInfo.activityid.intValue();
            this.cHa = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.cHk = missionInfo.cleartype.intValue();
            this.cHl = missionInfo.cleartime.intValue();
            this.cHn = axh();
            this.cHc = missionInfo.browsetimepage;
            this.cHm = ru(this.cHc);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.cHb = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.cHr = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean axc() {
        return this.cGZ > 0 && this.cHa > 0 && this.mTaskType > 0 && this.cHb > 0;
    }

    public synchronized int axd() {
        int i;
        i = this.cHp + 1;
        this.cHp = i;
        return i;
    }

    public synchronized int axe() {
        int i;
        i = this.cHo + 1;
        this.cHo = i;
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
            return new int[]{cGK};
        }
        if (this.mTaskType == 7) {
            return new int[]{cGL, cGS, cGT};
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
        if (this.cHk == cGU) {
            return 0L;
        }
        if (this.cHk == cGV) {
            return (System.currentTimeMillis() / 1000) + this.cHl;
        }
        if (this.cHk == cGW) {
            long axi = (axi() / 1000) + this.cHl;
            if (System.currentTimeMillis() > axi) {
                return axi + 86400;
            }
            return axi;
        } else if (this.cHk == cGX) {
            return l((int) this.cHl, jc(4)) / 1000;
        } else {
            if (this.cHk == cGY) {
                return this.cHl / 1000;
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
        return this.cGZ;
    }

    public void setActivityId(int i) {
        this.cGZ = i;
    }

    public int axj() {
        return this.cHa;
    }

    public void jd(int i) {
        this.cHa = i;
    }

    public String axk() {
        return this.cHf;
    }

    public void rv(String str) {
        this.cHf = str;
    }

    public String axl() {
        return this.cHg;
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
        return this.cHc;
    }

    public void rw(String str) {
        this.cHc = str;
        this.cHm = ru(str);
    }

    public int[] axo() {
        return this.cHm;
    }

    public long axp() {
        return this.cHb;
    }

    public void bo(long j) {
        this.cHb = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int axq() {
        return this.cHd;
    }

    public void jg(int i) {
        this.cHd = i;
    }

    public int axr() {
        return this.cHk;
    }

    public void jh(int i) {
        this.cHk = i;
    }

    public long axs() {
        return this.cHl;
    }

    public void bp(long j) {
        this.cHl = j;
    }

    public long axt() {
        return this.cHn;
    }

    public void bq(long j) {
        this.cHn = j;
    }

    public long getTid() {
        return this.cHe;
    }

    public void setTid(long j) {
        this.cHe = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String axu() {
        return this.cHh;
    }

    public void rx(String str) {
        this.cHh = str;
    }

    public String axv() {
        return this.cHi;
    }

    public void ry(String str) {
        this.cHi = str;
    }

    public long axw() {
        return this.cHj;
    }

    public void br(long j) {
        this.cHj = j;
    }

    public int axx() {
        return this.cHr;
    }

    public void ji(int i) {
        this.cHr = i;
    }

    public void jj(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean axy() {
        return this.cHq;
    }

    public void fi(boolean z) {
        this.cHq = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
