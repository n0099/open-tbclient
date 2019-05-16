package com.baidu.tbadk.BdToken;

import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class b {
    private volatile int bxA;
    private volatile int bxB;
    private boolean bxC;
    private int bxD;
    public boolean bxE;
    private final ArrayList<h> bxF;
    private int bxk;
    private int bxl;
    private long bxm;
    private String bxn;
    private int bxo;
    private long bxp;
    private String bxq;
    private String bxr;
    private String bxs;
    private String bxt;
    private long bxu;
    private int bxv;
    private long bxw;
    private int[] bxx;
    private long bxy;
    private int bxz;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String bwG = "missionid";
    public static String bwH = "activitysource";
    public static String SOURCE = "source";
    public static String bwI = "tab";
    public static String bwJ = "calltype";
    public static String bwK = "tasktype";
    public static String bwL = "browsetimepage";
    public static String bwM = "browsetime";
    public static String bwN = "threadnum";
    public static String bwO = "forumnum";
    public static String bwP = "cleartype";
    public static String bwQ = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String bwR = "threadtext";
    public static String bwS = "threadimg";
    public static String bwT = "threadforum";
    public static String bwU = "total_limit";
    public static int bwV = -1;
    public static int bwW = 1;
    public static int bwX = 2;
    public static int bwY = 3;
    public static int bwZ = 4;
    public static int bxa = 5;
    public static int bxb = 6;
    public static int bxc = 7;
    public static int bxd = 8;
    public static int bxe = 9;
    public static int bxf = -1;
    public static int bxg = 0;
    public static int bxh = 1;
    public static int bxi = 2;
    public static int bxj = 3;

    public void reset() {
        this.bxF.clear();
        this.bxA = 0;
        this.bxB = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.bxF.contains(hVar)) {
                this.bxF.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.bxF.contains(hVar)) {
                this.bxF.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.bxF.contains(hVar)) {
                this.bxF.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.bxF.contains(hVar)) {
                this.bxF.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.bxF.contains(hVar)) {
            this.bxF.add(hVar);
        }
    }

    public ArrayList<h> XJ() {
        return this.bxF;
    }

    public int XK() {
        int i;
        int size = this.bxF.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) v.c(this.bxF, i2);
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

    public void XL() {
        int size = this.bxF.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) v.c(this.bxF, i);
            if (hVar != null) {
                hVar.dp(true);
            }
        }
    }

    public boolean ai(long j) {
        for (int i = 0; i < this.bxF.size(); i++) {
            h hVar = (h) v.c(this.bxF, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.isCompleted()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void y(int i, String str) {
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
                        kVar.dp(optBoolean);
                        kVar.an(optLong2);
                        kVar.gi(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.dp(optBoolean);
                        mVar.an(optLong2);
                        mVar.gi(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.dp(optBoolean);
                        jVar.an(optLong2);
                        jVar.gi(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.dp(optBoolean);
                    iVar.an(optLong2);
                    iVar.gi(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.dp(optBoolean);
                    lVar.an(optLong2);
                    lVar.gi(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String XM() {
        try {
            ArrayList<h> arrayList = this.bxF;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) v.c(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.YH());
                jSONObject.put("c", hVar.isCompleted());
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
        this.bxv = bxf;
        this.bxA = 0;
        this.bxB = 0;
        this.bxC = false;
        this.bxD = 1;
        this.mTag = 0;
        this.bxE = false;
        this.bxF = new ArrayList<>();
    }

    public b(String str) {
        this.bxv = bxf;
        this.bxA = 0;
        this.bxB = 0;
        this.bxC = false;
        this.bxD = 1;
        this.mTag = 0;
        this.bxE = false;
        this.bxF = new ArrayList<>();
        lc(str);
    }

    public boolean lc(String str) {
        if (ap.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.bxk = jSONObject.optInt(ACTIVITY_ID);
                this.bxl = jSONObject.optInt(bwG);
                this.bxq = jSONObject.optString(bwH);
                this.mSource = jSONObject.optString(SOURCE);
                this.bxr = jSONObject.optString(bwI);
                this.bxz = jSONObject.optInt(bwJ);
                this.mTaskType = jSONObject.optInt(bwK);
                this.bxn = jSONObject.optString(bwL);
                this.bxx = ld(this.bxn);
                this.bxm = jSONObject.optLong(bwM);
                this.mThreadNum = jSONObject.optInt(bwN);
                this.bxo = jSONObject.optInt(bwO);
                this.bxv = jSONObject.optInt(bwP);
                this.bxw = jSONObject.optLong(bwQ);
                this.bxy = XS();
                this.bxp = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.bxs = jSONObject.optString(bwR);
                this.bxt = jSONObject.optString(bwS);
                this.bxu = jSONObject.optLong(bwT);
                int optInt = jSONObject.optInt(bwU);
                if (optInt > 0) {
                    this.bxD = optInt;
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
        this.bxv = bxf;
        this.bxA = 0;
        this.bxB = 0;
        this.bxC = false;
        this.bxD = 1;
        this.mTag = 0;
        this.bxE = false;
        this.bxF = new ArrayList<>();
        if (missionInfo != null) {
            this.bxk = missionInfo.activityid.intValue();
            this.bxl = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.bxv = missionInfo.cleartype.intValue();
            this.bxw = missionInfo.cleartime.intValue();
            this.bxy = XS();
            this.bxn = missionInfo.browsetimepage;
            this.bxx = ld(this.bxn);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.bxm = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.bxD = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean XN() {
        return this.bxk > 0 && this.bxl > 0 && this.mTaskType > 0 && this.bxm > 0;
    }

    public synchronized int XO() {
        int i;
        i = this.bxB + 1;
        this.bxB = i;
        return i;
    }

    public synchronized int XP() {
        int i;
        i = this.bxA + 1;
        this.bxA = i;
        return i;
    }

    public synchronized int XQ() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] ld(String str) {
        if (this.mTaskType == 8) {
            return new int[]{bwV};
        }
        if (this.mTaskType == 7) {
            return new int[]{bwW, bxd, bxe};
        }
        if (str == null) {
            return null;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            int f = com.baidu.adp.lib.g.b.f(split[i], 0);
            if (f > 0) {
                iArr[i] = f;
            }
        }
        return iArr;
    }

    public boolean XR() {
        return System.currentTimeMillis() > Ye() * 1000;
    }

    public long XS() {
        if (this.bxv == bxf) {
            return 0L;
        }
        if (this.bxv == bxg) {
            return (System.currentTimeMillis() / 1000) + this.bxw;
        }
        if (this.bxv == bxh) {
            long XT = (XT() / 1000) + this.bxw;
            if (System.currentTimeMillis() > XT) {
                return XT + 86400;
            }
            return XT;
        } else if (this.bxv == bxi) {
            return h((int) this.bxw, gb(4)) / 1000;
        } else {
            if (this.bxv == bxj) {
                return this.bxw / 1000;
            }
            return 0L;
        }
    }

    private long XT() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long gb(int i) {
        long XT = XT();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - XT;
    }

    private long h(int i, long j) {
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
        return this.bxk;
    }

    public void setActivityId(int i) {
        this.bxk = i;
    }

    public int XU() {
        return this.bxl;
    }

    public void gc(int i) {
        this.bxl = i;
    }

    public String XV() {
        return this.bxq;
    }

    public void le(String str) {
        this.bxq = str;
    }

    public String XW() {
        return this.bxr;
    }

    public String getSource() {
        return this.mSource;
    }

    public int XX() {
        return this.bxz;
    }

    public void gd(int i) {
        this.bxz = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void ge(int i) {
        this.mTaskType = i;
    }

    public String XY() {
        return this.bxn;
    }

    public void lf(String str) {
        this.bxn = str;
        this.bxx = ld(str);
    }

    public int[] XZ() {
        return this.bxx;
    }

    public long Ya() {
        return this.bxm;
    }

    public void aj(long j) {
        this.bxm = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int Yb() {
        return this.bxo;
    }

    public void gf(int i) {
        this.bxo = i;
    }

    public int Yc() {
        return this.bxv;
    }

    public void gg(int i) {
        this.bxv = i;
    }

    public long Yd() {
        return this.bxw;
    }

    public void ak(long j) {
        this.bxw = j;
    }

    public long Ye() {
        return this.bxy;
    }

    public void al(long j) {
        this.bxy = j;
    }

    public long getTid() {
        return this.bxp;
    }

    public void setTid(long j) {
        this.bxp = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String Yf() {
        return this.bxs;
    }

    public void lg(String str) {
        this.bxs = str;
    }

    public String Yg() {
        return this.bxt;
    }

    public void lh(String str) {
        this.bxt = str;
    }

    public long Yh() {
        return this.bxu;
    }

    public void am(long j) {
        this.bxu = j;
    }

    public int Yi() {
        return this.bxD;
    }

    public void gh(int i) {
        this.bxD = i;
    }

    public void gi(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean Yj() {
        return this.bxC;
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(boolean z) {
        this.bxC = z;
    }
}
