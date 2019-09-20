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
    private int byA;
    private long byB;
    private String byC;
    private int byD;
    private long byE;
    private String byF;
    private String byG;
    private String byH;
    private String byI;
    private long byJ;
    private int byK;
    private long byL;
    private int[] byM;
    private long byN;
    private int byO;
    private volatile int byP;
    private volatile int byQ;
    private boolean byR;
    private int byS;
    public boolean byT;
    private final ArrayList<h> byU;
    private int byz;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String bxV = "missionid";
    public static String bxW = "activitysource";
    public static String SOURCE = "source";
    public static String bxX = "tab";
    public static String bxY = "calltype";
    public static String bxZ = "tasktype";
    public static String bya = "browsetimepage";
    public static String byb = "browsetime";
    public static String byc = "threadnum";
    public static String byd = "forumnum";
    public static String bye = "cleartype";
    public static String byf = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String byg = "threadtext";
    public static String byh = "threadimg";
    public static String byi = "threadforum";
    public static String byj = "total_limit";
    public static int byk = -1;
    public static int byl = 1;
    public static int bym = 2;
    public static int byn = 3;
    public static int byo = 4;
    public static int byp = 5;
    public static int byq = 6;
    public static int byr = 7;
    public static int bys = 8;
    public static int byt = 9;
    public static int byu = -1;
    public static int byv = 0;
    public static int byw = 1;
    public static int byx = 2;
    public static int byy = 3;

    public void reset() {
        this.byU.clear();
        this.byP = 0;
        this.byQ = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.byU.contains(hVar)) {
                this.byU.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.byU.contains(hVar)) {
                this.byU.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.byU.contains(hVar)) {
                this.byU.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.byU.contains(hVar)) {
                this.byU.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.byU.contains(hVar)) {
            this.byU.add(hVar);
        }
    }

    public ArrayList<h> YJ() {
        return this.byU;
    }

    public int YK() {
        int i;
        int size = this.byU.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.v.c(this.byU, i2);
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

    public void YL() {
        int size = this.byU.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.c(this.byU, i);
            if (hVar != null) {
                hVar.du(true);
            }
        }
    }

    public boolean aj(long j) {
        for (int i = 0; i < this.byU.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.v.c(this.byU, i);
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
                        kVar.gn(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.du(optBoolean);
                        mVar.ao(optLong2);
                        mVar.gn(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.du(optBoolean);
                        jVar.ao(optLong2);
                        jVar.gn(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.du(optBoolean);
                    iVar.ao(optLong2);
                    iVar.gn(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.du(optBoolean);
                    lVar.ao(optLong2);
                    lVar.gn(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String YM() {
        try {
            ArrayList<h> arrayList = this.byU;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.v.c(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.ZH());
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
        this.byK = byu;
        this.byP = 0;
        this.byQ = 0;
        this.byR = false;
        this.byS = 1;
        this.mTag = 0;
        this.byT = false;
        this.byU = new ArrayList<>();
    }

    public b(String str) {
        this.byK = byu;
        this.byP = 0;
        this.byQ = 0;
        this.byR = false;
        this.byS = 1;
        this.mTag = 0;
        this.byT = false;
        this.byU = new ArrayList<>();
        ll(str);
    }

    public boolean ll(String str) {
        if (aq.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.byz = jSONObject.optInt(ACTIVITY_ID);
                this.byA = jSONObject.optInt(bxV);
                this.byF = jSONObject.optString(bxW);
                this.mSource = jSONObject.optString(SOURCE);
                this.byG = jSONObject.optString(bxX);
                this.byO = jSONObject.optInt(bxY);
                this.mTaskType = jSONObject.optInt(bxZ);
                this.byC = jSONObject.optString(bya);
                this.byM = lm(this.byC);
                this.byB = jSONObject.optLong(byb);
                this.mThreadNum = jSONObject.optInt(byc);
                this.byD = jSONObject.optInt(byd);
                this.byK = jSONObject.optInt(bye);
                this.byL = jSONObject.optLong(byf);
                this.byN = YS();
                this.byE = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.byH = jSONObject.optString(byg);
                this.byI = jSONObject.optString(byh);
                this.byJ = jSONObject.optLong(byi);
                int optInt = jSONObject.optInt(byj);
                if (optInt > 0) {
                    this.byS = optInt;
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
        this.byK = byu;
        this.byP = 0;
        this.byQ = 0;
        this.byR = false;
        this.byS = 1;
        this.mTag = 0;
        this.byT = false;
        this.byU = new ArrayList<>();
        if (missionInfo != null) {
            this.byz = missionInfo.activityid.intValue();
            this.byA = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.byK = missionInfo.cleartype.intValue();
            this.byL = missionInfo.cleartime.intValue();
            this.byN = YS();
            this.byC = missionInfo.browsetimepage;
            this.byM = lm(this.byC);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.byB = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.byS = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean YN() {
        return this.byz > 0 && this.byA > 0 && this.mTaskType > 0 && this.byB > 0;
    }

    public synchronized int YO() {
        int i;
        i = this.byQ + 1;
        this.byQ = i;
        return i;
    }

    public synchronized int YP() {
        int i;
        i = this.byP + 1;
        this.byP = i;
        return i;
    }

    public synchronized int YQ() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] lm(String str) {
        if (this.mTaskType == 8) {
            return new int[]{byk};
        }
        if (this.mTaskType == 7) {
            return new int[]{byl, bys, byt};
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

    public boolean YR() {
        return System.currentTimeMillis() > Ze() * 1000;
    }

    public long YS() {
        if (this.byK == byu) {
            return 0L;
        }
        if (this.byK == byv) {
            return (System.currentTimeMillis() / 1000) + this.byL;
        }
        if (this.byK == byw) {
            long YT = (YT() / 1000) + this.byL;
            if (System.currentTimeMillis() > YT) {
                return YT + 86400;
            }
            return YT;
        } else if (this.byK == byx) {
            return h((int) this.byL, gg(4)) / 1000;
        } else {
            if (this.byK == byy) {
                return this.byL / 1000;
            }
            return 0L;
        }
    }

    private long YT() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long gg(int i) {
        long YT = YT();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - YT;
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
        return this.byz;
    }

    public void setActivityId(int i) {
        this.byz = i;
    }

    public int YU() {
        return this.byA;
    }

    public void gh(int i) {
        this.byA = i;
    }

    public String YV() {
        return this.byF;
    }

    public void ln(String str) {
        this.byF = str;
    }

    public String YW() {
        return this.byG;
    }

    public String getSource() {
        return this.mSource;
    }

    public int YX() {
        return this.byO;
    }

    public void gi(int i) {
        this.byO = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void gj(int i) {
        this.mTaskType = i;
    }

    public String YY() {
        return this.byC;
    }

    public void lo(String str) {
        this.byC = str;
        this.byM = lm(str);
    }

    public int[] YZ() {
        return this.byM;
    }

    public long Za() {
        return this.byB;
    }

    public void ak(long j) {
        this.byB = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int Zb() {
        return this.byD;
    }

    public void gk(int i) {
        this.byD = i;
    }

    public int Zc() {
        return this.byK;
    }

    public void gl(int i) {
        this.byK = i;
    }

    public long Zd() {
        return this.byL;
    }

    public void al(long j) {
        this.byL = j;
    }

    public long Ze() {
        return this.byN;
    }

    public void am(long j) {
        this.byN = j;
    }

    public long getTid() {
        return this.byE;
    }

    public void setTid(long j) {
        this.byE = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String Zf() {
        return this.byH;
    }

    public void lp(String str) {
        this.byH = str;
    }

    public String Zg() {
        return this.byI;
    }

    public void lq(String str) {
        this.byI = str;
    }

    public long Zh() {
        return this.byJ;
    }

    public void an(long j) {
        this.byJ = j;
    }

    public int Zi() {
        return this.byS;
    }

    public void gm(int i) {
        this.byS = i;
    }

    public void gn(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean Zj() {
        return this.byR;
    }

    public void dt(boolean z) {
        this.byR = z;
    }
}
