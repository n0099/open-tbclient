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
    private int cGY;
    private int cGZ;
    private long cHa;
    private String cHb;
    private int cHc;
    private long cHd;
    private String cHe;
    private String cHf;
    private String cHg;
    private String cHh;
    private long cHi;
    private int cHj;
    private long cHk;
    private int[] cHl;
    private long cHm;
    private volatile int cHn;
    private volatile int cHo;
    private boolean cHp;
    private int cHq;
    public boolean cHr;
    private final ArrayList<h> cHs;
    private int mCallType;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    public static String ACTIVITY_ID = "activityid";
    public static String cGu = "missionid";
    public static String cGv = "activitysource";
    public static String SOURCE = "source";
    public static String cGw = "tab";
    public static String cGx = "calltype";
    public static String cGy = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String cGz = "browsetimepage";
    public static String cGA = "browsetime";
    public static String cGB = "threadnum";
    public static String cGC = "forumnum";
    public static String cGD = "cleartype";
    public static String cGE = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String cGF = "threadtext";
    public static String cGG = "threadimg";
    public static String cGH = "threadforum";
    public static String cGI = "total_limit";
    public static int cGJ = -1;
    public static int cGK = 1;
    public static int cGL = 2;
    public static int cGM = 3;
    public static int cGN = 4;
    public static int cGO = 5;
    public static int cGP = 6;
    public static int cGQ = 7;
    public static int cGR = 8;
    public static int cGS = 9;
    public static int cGT = -1;
    public static int cGU = 0;
    public static int cGV = 1;
    public static int cGW = 2;
    public static int cGX = 3;

    public void reset() {
        this.cHs.clear();
        this.cHn = 0;
        this.cHo = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.cHs.contains(hVar)) {
                this.cHs.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.cHs.contains(hVar)) {
                this.cHs.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.cHs.contains(hVar)) {
                this.cHs.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.cHs.contains(hVar)) {
                this.cHs.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.cHs.contains(hVar)) {
            this.cHs.add(hVar);
        }
    }

    public ArrayList<h> awW() {
        return this.cHs;
    }

    public int awX() {
        int i;
        int size = this.cHs.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHs, i2);
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

    public void awY() {
        int size = this.cHs.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHs, i);
            if (hVar != null) {
                hVar.fj(true);
            }
        }
    }

    public boolean bn(long j) {
        for (int i = 0; i < this.cHs.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.cHs, i);
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

    public String awZ() {
        try {
            ArrayList<h> arrayList = this.cHs;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.axT());
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
        this.cHj = cGT;
        this.cHn = 0;
        this.cHo = 0;
        this.cHp = false;
        this.cHq = 1;
        this.mTag = 0;
        this.cHr = false;
        this.cHs = new ArrayList<>();
    }

    public b(String str) {
        this.cHj = cGT;
        this.cHn = 0;
        this.cHo = 0;
        this.cHp = false;
        this.cHq = 1;
        this.mTag = 0;
        this.cHr = false;
        this.cHs = new ArrayList<>();
        rt(str);
    }

    public boolean rt(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.cGY = jSONObject.optInt(ACTIVITY_ID);
                this.cGZ = jSONObject.optInt(cGu);
                this.cHe = jSONObject.optString(cGv);
                this.mSource = jSONObject.optString(SOURCE);
                this.cHf = jSONObject.optString(cGw);
                this.mCallType = jSONObject.optInt(cGx);
                this.mTaskType = jSONObject.optInt(cGy);
                this.cHb = jSONObject.optString(cGz);
                this.cHl = ru(this.cHb);
                this.cHa = jSONObject.optLong(cGA);
                this.mThreadNum = jSONObject.optInt(cGB);
                this.cHc = jSONObject.optInt(cGC);
                this.cHj = jSONObject.optInt(cGD);
                this.cHk = jSONObject.optLong(cGE);
                this.cHm = axf();
                this.cHd = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.cHg = jSONObject.optString(cGF);
                this.cHh = jSONObject.optString(cGG);
                this.cHi = jSONObject.optLong(cGH);
                int optInt = jSONObject.optInt(cGI);
                if (optInt > 0) {
                    this.cHq = optInt;
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
        this.cHj = cGT;
        this.cHn = 0;
        this.cHo = 0;
        this.cHp = false;
        this.cHq = 1;
        this.mTag = 0;
        this.cHr = false;
        this.cHs = new ArrayList<>();
        if (missionInfo != null) {
            this.cGY = missionInfo.activityid.intValue();
            this.cGZ = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.cHj = missionInfo.cleartype.intValue();
            this.cHk = missionInfo.cleartime.intValue();
            this.cHm = axf();
            this.cHb = missionInfo.browsetimepage;
            this.cHl = ru(this.cHb);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.cHa = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.cHq = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean axa() {
        return this.cGY > 0 && this.cGZ > 0 && this.mTaskType > 0 && this.cHa > 0;
    }

    public synchronized int axb() {
        int i;
        i = this.cHo + 1;
        this.cHo = i;
        return i;
    }

    public synchronized int axc() {
        int i;
        i = this.cHn + 1;
        this.cHn = i;
        return i;
    }

    public synchronized int axd() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] ru(String str) {
        if (this.mTaskType == 8) {
            return new int[]{cGJ};
        }
        if (this.mTaskType == 7) {
            return new int[]{cGK, cGR, cGS};
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

    public boolean axe() {
        return System.currentTimeMillis() > axr() * 1000;
    }

    public long axf() {
        if (this.cHj == cGT) {
            return 0L;
        }
        if (this.cHj == cGU) {
            return (System.currentTimeMillis() / 1000) + this.cHk;
        }
        if (this.cHj == cGV) {
            long axg = (axg() / 1000) + this.cHk;
            if (System.currentTimeMillis() > axg) {
                return axg + 86400;
            }
            return axg;
        } else if (this.cHj == cGW) {
            return l((int) this.cHk, jc(4)) / 1000;
        } else {
            if (this.cHj == cGX) {
                return this.cHk / 1000;
            }
            return 0L;
        }
    }

    private long axg() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long jc(int i) {
        long axg = axg();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - axg;
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
        return this.cGY;
    }

    public void setActivityId(int i) {
        this.cGY = i;
    }

    public int axh() {
        return this.cGZ;
    }

    public void jd(int i) {
        this.cGZ = i;
    }

    public String axi() {
        return this.cHe;
    }

    public void rv(String str) {
        this.cHe = str;
    }

    public String axj() {
        return this.cHf;
    }

    public String getSource() {
        return this.mSource;
    }

    public int axk() {
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

    public String axl() {
        return this.cHb;
    }

    public void rw(String str) {
        this.cHb = str;
        this.cHl = ru(str);
    }

    public int[] axm() {
        return this.cHl;
    }

    public long axn() {
        return this.cHa;
    }

    public void bo(long j) {
        this.cHa = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int axo() {
        return this.cHc;
    }

    public void jg(int i) {
        this.cHc = i;
    }

    public int axp() {
        return this.cHj;
    }

    public void jh(int i) {
        this.cHj = i;
    }

    public long axq() {
        return this.cHk;
    }

    public void bp(long j) {
        this.cHk = j;
    }

    public long axr() {
        return this.cHm;
    }

    public void bq(long j) {
        this.cHm = j;
    }

    public long getTid() {
        return this.cHd;
    }

    public void setTid(long j) {
        this.cHd = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String axs() {
        return this.cHg;
    }

    public void rx(String str) {
        this.cHg = str;
    }

    public String axt() {
        return this.cHh;
    }

    public void ry(String str) {
        this.cHh = str;
    }

    public long axu() {
        return this.cHi;
    }

    public void br(long j) {
        this.cHi = j;
    }

    public int axv() {
        return this.cHq;
    }

    public void ji(int i) {
        this.cHq = i;
    }

    public void jj(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean axw() {
        return this.cHp;
    }

    public void fi(boolean z) {
        this.cHp = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
