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
    private final ArrayList<h> duA;
    private int dug;
    private int duh;
    private long dui;
    private String duj;
    private int duk;
    private long dul;
    private String dum;
    private String dun;
    private String duo;
    private String dup;
    private long duq;
    private int dur;
    private long dus;
    private int[] dut;
    private long duu;
    private volatile int duv;
    private volatile int duw;
    private boolean dux;
    private int duy;
    public boolean duz;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int xP;
    public static String ACTIVITY_ID = "activityid";
    public static String dtC = "missionid";
    public static String dtD = "activitysource";
    public static String SOURCE = "source";
    public static String dtE = "tab";
    public static String dtF = "calltype";
    public static String dtG = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String dtH = "browsetimepage";
    public static String dtI = "browsetime";
    public static String dtJ = "threadnum";
    public static String dtK = "forumnum";
    public static String dtL = "cleartype";
    public static String dtM = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String dtN = "threadtext";
    public static String dtO = "threadimg";
    public static String dtP = "threadforum";
    public static String dtQ = "total_limit";
    public static int dtR = -1;
    public static int dtS = 1;
    public static int dtT = 2;
    public static int dtU = 3;
    public static int dtV = 4;
    public static int dtW = 5;
    public static int dtX = 6;
    public static int dtY = 7;
    public static int dtZ = 8;
    public static int dua = 9;
    public static int dub = -1;
    public static int duc = 0;
    public static int dud = 1;
    public static int due = 2;
    public static int duf = 3;

    public void reset() {
        this.duA.clear();
        this.duv = 0;
        this.duw = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.duA.contains(hVar)) {
                this.duA.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.duA.contains(hVar)) {
                this.duA.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.duA.contains(hVar)) {
                this.duA.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.duA.contains(hVar)) {
                this.duA.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.duA.contains(hVar)) {
            this.duA.add(hVar);
        }
    }

    public ArrayList<h> aKH() {
        return this.duA;
    }

    public int aKI() {
        int i;
        int size = this.duA.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.duA, i2);
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

    public void aKJ() {
        int size = this.duA.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.duA, i);
            if (hVar != null) {
                hVar.gz(true);
            }
        }
    }

    public boolean bS(long j) {
        for (int i = 0; i < this.duA.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.getItem(this.duA, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.gt()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ai(int i, String str) {
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
                        kVar.gz(optBoolean);
                        kVar.bX(optLong2);
                        kVar.jQ(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.gz(optBoolean);
                        mVar.bX(optLong2);
                        mVar.jQ(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.gz(optBoolean);
                        jVar.bX(optLong2);
                        jVar.jQ(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.gz(optBoolean);
                    iVar.bX(optLong2);
                    iVar.jQ(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.gz(optBoolean);
                    lVar.bX(optLong2);
                    lVar.jQ(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String aKK() {
        try {
            ArrayList<h> arrayList = this.duA;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.aLC());
                jSONObject.put("c", hVar.gt());
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
        this.dur = dub;
        this.duv = 0;
        this.duw = 0;
        this.dux = false;
        this.duy = 1;
        this.mTag = 0;
        this.duz = false;
        this.duA = new ArrayList<>();
    }

    public b(String str) {
        this.dur = dub;
        this.duv = 0;
        this.duw = 0;
        this.dux = false;
        this.duy = 1;
        this.mTag = 0;
        this.duz = false;
        this.duA = new ArrayList<>();
        uk(str);
    }

    public boolean uk(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.dug = jSONObject.optInt(ACTIVITY_ID);
                this.duh = jSONObject.optInt(dtC);
                this.dum = jSONObject.optString(dtD);
                this.mSource = jSONObject.optString(SOURCE);
                this.dun = jSONObject.optString(dtE);
                this.xP = jSONObject.optInt(dtF);
                this.mTaskType = jSONObject.optInt(dtG);
                this.duj = jSONObject.optString(dtH);
                this.dut = ul(this.duj);
                this.dui = jSONObject.optLong(dtI);
                this.mThreadNum = jSONObject.optInt(dtJ);
                this.duk = jSONObject.optInt(dtK);
                this.dur = jSONObject.optInt(dtL);
                this.dus = jSONObject.optLong(dtM);
                this.duu = aKQ();
                this.dul = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.duo = jSONObject.optString(dtN);
                this.dup = jSONObject.optString(dtO);
                this.duq = jSONObject.optLong(dtP);
                int optInt = jSONObject.optInt(dtQ);
                if (optInt > 0) {
                    this.duy = optInt;
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
        this.dur = dub;
        this.duv = 0;
        this.duw = 0;
        this.dux = false;
        this.duy = 1;
        this.mTag = 0;
        this.duz = false;
        this.duA = new ArrayList<>();
        if (missionInfo != null) {
            this.dug = missionInfo.activityid.intValue();
            this.duh = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.dur = missionInfo.cleartype.intValue();
            this.dus = missionInfo.cleartime.intValue();
            this.duu = aKQ();
            this.duj = missionInfo.browsetimepage;
            this.dut = ul(this.duj);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.dui = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.duy = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean aKL() {
        return this.dug > 0 && this.duh > 0 && this.mTaskType > 0 && this.dui > 0;
    }

    public synchronized int aKM() {
        int i;
        i = this.duw + 1;
        this.duw = i;
        return i;
    }

    public synchronized int aKN() {
        int i;
        i = this.duv + 1;
        this.duv = i;
        return i;
    }

    public synchronized int aKO() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] ul(String str) {
        if (this.mTaskType == 8) {
            return new int[]{dtR};
        }
        if (this.mTaskType == 7) {
            return new int[]{dtS, dtZ, dua};
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

    public boolean aKP() {
        return System.currentTimeMillis() > aLc() * 1000;
    }

    public long aKQ() {
        if (this.dur == dub) {
            return 0L;
        }
        if (this.dur == duc) {
            return (System.currentTimeMillis() / 1000) + this.dus;
        }
        if (this.dur == dud) {
            long aKR = (aKR() / 1000) + this.dus;
            if (System.currentTimeMillis() > aKR) {
                return aKR + 86400;
            }
            return aKR;
        } else if (this.dur == due) {
            return l((int) this.dus, jJ(4)) / 1000;
        } else {
            if (this.dur == duf) {
                return this.dus / 1000;
            }
            return 0L;
        }
    }

    private long aKR() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long jJ(int i) {
        long aKR = aKR();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - aKR;
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
        return this.dug;
    }

    public void setActivityId(int i) {
        this.dug = i;
    }

    public int aKS() {
        return this.duh;
    }

    public void jK(int i) {
        this.duh = i;
    }

    public String aKT() {
        return this.dum;
    }

    public void um(String str) {
        this.dum = str;
    }

    public String aKU() {
        return this.dun;
    }

    public String getSource() {
        return this.mSource;
    }

    public int aKV() {
        return this.xP;
    }

    public void jL(int i) {
        this.xP = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void jM(int i) {
        this.mTaskType = i;
    }

    public String aKW() {
        return this.duj;
    }

    public void un(String str) {
        this.duj = str;
        this.dut = ul(str);
    }

    public int[] aKX() {
        return this.dut;
    }

    public long aKY() {
        return this.dui;
    }

    public void bT(long j) {
        this.dui = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int aKZ() {
        return this.duk;
    }

    public void jN(int i) {
        this.duk = i;
    }

    public int aLa() {
        return this.dur;
    }

    public void jO(int i) {
        this.dur = i;
    }

    public long aLb() {
        return this.dus;
    }

    public void bU(long j) {
        this.dus = j;
    }

    public long aLc() {
        return this.duu;
    }

    public void bV(long j) {
        this.duu = j;
    }

    public long getTid() {
        return this.dul;
    }

    public void setTid(long j) {
        this.dul = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String aLd() {
        return this.duo;
    }

    public void uo(String str) {
        this.duo = str;
    }

    public String aLe() {
        return this.dup;
    }

    public void up(String str) {
        this.dup = str;
    }

    public long aLf() {
        return this.duq;
    }

    public void bW(long j) {
        this.duq = j;
    }

    public int aLg() {
        return this.duy;
    }

    public void jP(int i) {
        this.duy = i;
    }

    public void jQ(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean aLh() {
        return this.dux;
    }

    public void gy(boolean z) {
        this.dux = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
