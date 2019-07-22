package com.baidu.tbadk.BdToken;

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
    private int byb;
    private int byc;
    private long byd;
    private String bye;
    private int byf;
    private long byg;
    private String byh;
    private String byi;
    private String byj;
    private String byk;
    private long byl;
    private int bym;
    private long byn;
    private int[] byo;
    private long byp;
    private int byq;
    private volatile int byr;
    private volatile int bys;
    private boolean byt;
    private int byu;
    public boolean byv;
    private final ArrayList<h> byw;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String bxx = "missionid";
    public static String bxy = "activitysource";
    public static String SOURCE = "source";
    public static String bxz = "tab";
    public static String bxA = "calltype";
    public static String bxB = "tasktype";
    public static String bxC = "browsetimepage";
    public static String bxD = "browsetime";
    public static String bxE = "threadnum";
    public static String bxF = "forumnum";
    public static String bxG = "cleartype";
    public static String bxH = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String bxI = "threadtext";
    public static String bxJ = "threadimg";
    public static String bxK = "threadforum";
    public static String bxL = "total_limit";
    public static int bxM = -1;
    public static int bxN = 1;
    public static int bxO = 2;
    public static int bxP = 3;
    public static int bxQ = 4;
    public static int bxR = 5;
    public static int bxS = 6;
    public static int bxT = 7;
    public static int bxU = 8;
    public static int bxV = 9;
    public static int bxW = -1;
    public static int bxX = 0;
    public static int bxY = 1;
    public static int bxZ = 2;
    public static int bya = 3;

    public void reset() {
        this.byw.clear();
        this.byr = 0;
        this.bys = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.byw.contains(hVar)) {
                this.byw.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.byw.contains(hVar)) {
                this.byw.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.byw.contains(hVar)) {
                this.byw.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.byw.contains(hVar)) {
                this.byw.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.byw.contains(hVar)) {
            this.byw.add(hVar);
        }
    }

    public ArrayList<h> YF() {
        return this.byw;
    }

    public int YG() {
        int i;
        int size = this.byw.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.c(this.byw, i2);
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

    public void YH() {
        int size = this.byw.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.c(this.byw, i);
            if (hVar != null) {
                hVar.du(true);
            }
        }
    }

    public boolean aj(long j) {
        for (int i = 0; i < this.byw.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.c(this.byw, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.bh()) {
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
                        kVar.du(optBoolean);
                        kVar.ao(optLong2);
                        kVar.gm(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.du(optBoolean);
                        mVar.ao(optLong2);
                        mVar.gm(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.du(optBoolean);
                        jVar.ao(optLong2);
                        jVar.gm(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.du(optBoolean);
                    iVar.ao(optLong2);
                    iVar.gm(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.du(optBoolean);
                    lVar.ao(optLong2);
                    lVar.gm(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String YI() {
        try {
            ArrayList<h> arrayList = this.byw;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.c(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.ZD());
                jSONObject.put("c", hVar.bh());
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
        this.bym = bxW;
        this.byr = 0;
        this.bys = 0;
        this.byt = false;
        this.byu = 1;
        this.mTag = 0;
        this.byv = false;
        this.byw = new ArrayList<>();
    }

    public b(String str) {
        this.bym = bxW;
        this.byr = 0;
        this.bys = 0;
        this.byt = false;
        this.byu = 1;
        this.mTag = 0;
        this.byv = false;
        this.byw = new ArrayList<>();
        lj(str);
    }

    public boolean lj(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.byb = jSONObject.optInt(ACTIVITY_ID);
                this.byc = jSONObject.optInt(bxx);
                this.byh = jSONObject.optString(bxy);
                this.mSource = jSONObject.optString(SOURCE);
                this.byi = jSONObject.optString(bxz);
                this.byq = jSONObject.optInt(bxA);
                this.mTaskType = jSONObject.optInt(bxB);
                this.bye = jSONObject.optString(bxC);
                this.byo = lk(this.bye);
                this.byd = jSONObject.optLong(bxD);
                this.mThreadNum = jSONObject.optInt(bxE);
                this.byf = jSONObject.optInt(bxF);
                this.bym = jSONObject.optInt(bxG);
                this.byn = jSONObject.optLong(bxH);
                this.byp = YO();
                this.byg = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.byj = jSONObject.optString(bxI);
                this.byk = jSONObject.optString(bxJ);
                this.byl = jSONObject.optLong(bxK);
                int optInt = jSONObject.optInt(bxL);
                if (optInt > 0) {
                    this.byu = optInt;
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
        this.bym = bxW;
        this.byr = 0;
        this.bys = 0;
        this.byt = false;
        this.byu = 1;
        this.mTag = 0;
        this.byv = false;
        this.byw = new ArrayList<>();
        if (missionInfo != null) {
            this.byb = missionInfo.activityid.intValue();
            this.byc = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.bym = missionInfo.cleartype.intValue();
            this.byn = missionInfo.cleartime.intValue();
            this.byp = YO();
            this.bye = missionInfo.browsetimepage;
            this.byo = lk(this.bye);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.byd = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.byu = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean YJ() {
        return this.byb > 0 && this.byc > 0 && this.mTaskType > 0 && this.byd > 0;
    }

    public synchronized int YK() {
        int i;
        i = this.bys + 1;
        this.bys = i;
        return i;
    }

    public synchronized int YL() {
        int i;
        i = this.byr + 1;
        this.byr = i;
        return i;
    }

    public synchronized int YM() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] lk(String str) {
        if (this.mTaskType == 8) {
            return new int[]{bxM};
        }
        if (this.mTaskType == 7) {
            return new int[]{bxN, bxU, bxV};
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

    public boolean YN() {
        return System.currentTimeMillis() > Za() * 1000;
    }

    public long YO() {
        if (this.bym == bxW) {
            return 0L;
        }
        if (this.bym == bxX) {
            return (System.currentTimeMillis() / 1000) + this.byn;
        }
        if (this.bym == bxY) {
            long YP = (YP() / 1000) + this.byn;
            if (System.currentTimeMillis() > YP) {
                return YP + 86400;
            }
            return YP;
        } else if (this.bym == bxZ) {
            return h((int) this.byn, gf(4)) / 1000;
        } else {
            if (this.bym == bya) {
                return this.byn / 1000;
            }
            return 0L;
        }
    }

    private long YP() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long gf(int i) {
        long YP = YP();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - YP;
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
        return this.byb;
    }

    public void setActivityId(int i) {
        this.byb = i;
    }

    public int YQ() {
        return this.byc;
    }

    public void gg(int i) {
        this.byc = i;
    }

    public String YR() {
        return this.byh;
    }

    public void ll(String str) {
        this.byh = str;
    }

    public String YS() {
        return this.byi;
    }

    public String getSource() {
        return this.mSource;
    }

    public int YT() {
        return this.byq;
    }

    public void gh(int i) {
        this.byq = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void gi(int i) {
        this.mTaskType = i;
    }

    public String YU() {
        return this.bye;
    }

    public void lm(String str) {
        this.bye = str;
        this.byo = lk(str);
    }

    public int[] YV() {
        return this.byo;
    }

    public long YW() {
        return this.byd;
    }

    public void ak(long j) {
        this.byd = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int YX() {
        return this.byf;
    }

    public void gj(int i) {
        this.byf = i;
    }

    public int YY() {
        return this.bym;
    }

    public void gk(int i) {
        this.bym = i;
    }

    public long YZ() {
        return this.byn;
    }

    public void al(long j) {
        this.byn = j;
    }

    public long Za() {
        return this.byp;
    }

    public void am(long j) {
        this.byp = j;
    }

    public long getTid() {
        return this.byg;
    }

    public void setTid(long j) {
        this.byg = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String Zb() {
        return this.byj;
    }

    public void ln(String str) {
        this.byj = str;
    }

    public String Zc() {
        return this.byk;
    }

    public void lo(String str) {
        this.byk = str;
    }

    public long Zd() {
        return this.byl;
    }

    public void an(long j) {
        this.byl = j;
    }

    public int Ze() {
        return this.byu;
    }

    public void gl(int i) {
        this.byu = i;
    }

    public void gm(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean Zf() {
        return this.byt;
    }

    public void dt(boolean z) {
        this.byt = z;
    }
}
