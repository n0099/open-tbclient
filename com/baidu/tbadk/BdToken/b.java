package com.baidu.tbadk.BdToken;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int bqU;
    private int bqV;
    private String bqW;
    private int bqX;
    private String bqY;
    private long bqZ;
    private int bra;
    private long brc;
    private long brd;
    private String bre;
    private String brf;
    private long brg;
    private int[] brh;
    private long brk;
    private long mFid;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String bqp = "missionid";
    public static String bqq = "activitysource";
    public static String bqr = "calltype";
    public static String bqs = "tasktype";
    public static String bqt = "browsetimepage";
    public static String bqu = "browsetime";
    public static String bqv = "threadnum";
    public static String bqw = "forumnum";
    public static String bqx = "cleartype";
    public static String bqy = "cleartime";
    public static String TID = "tid";
    public static String bqz = ImageViewerConfig.FORUM_ID;
    public static String bqA = "threadtext";
    public static String bqB = "threadimg";
    public static String bqC = "threadforum";
    public static int bqD = 1;
    public static int bqE = 2;
    public static int bqF = 3;
    public static int bqG = 4;
    public static int bqH = 1;
    public static int bqI = 2;
    public static int bqJ = 3;
    public static int bqK = 4;
    public static int bqL = 5;
    public static int bqM = 6;
    public static int bqN = 7;
    public static int bqO = 8;
    public static int bqP = -1;
    public static int bqQ = 0;
    public static int bqR = 1;
    public static int bqS = 2;
    public static int bqT = 3;
    private int brb = bqP;
    private volatile int bri = 0;
    private volatile int brj = 0;

    public b() {
    }

    public b(String str) {
        kc(str);
    }

    public boolean kc(String str) {
        if (ap.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.bqU = jSONObject.optInt(ACTIVITY_ID);
                this.bqV = jSONObject.optInt(bqp);
                this.bqW = jSONObject.optString(bqq);
                this.bqX = jSONObject.optInt(bqr);
                this.mTaskType = jSONObject.optInt(bqs);
                this.bqY = jSONObject.optString(bqt);
                this.brh = kd(this.bqY);
                this.bqZ = jSONObject.optLong(bqu);
                this.mThreadNum = jSONObject.optInt(bqv);
                this.bra = jSONObject.optInt(bqw);
                this.brb = jSONObject.optInt(bqx);
                this.brc = jSONObject.optLong(bqy);
                this.brk = TI();
                this.brd = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(bqz);
                this.bre = jSONObject.optString(bqA);
                this.brf = jSONObject.optString(bqB);
                this.brg = jSONObject.optLong(bqC);
                return true;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public synchronized int TG() {
        int i;
        i = this.brj + 1;
        this.brj = i;
        return i;
    }

    public synchronized int TH() {
        int i;
        i = this.bri + 1;
        this.bri = i;
        return i;
    }

    private int[] kd(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = com.baidu.adp.lib.g.b.l(split[i], 0);
        }
        return iArr;
    }

    private long TI() {
        if (this.brb == bqP) {
            return 0L;
        }
        if (this.brb == bqQ) {
            return (System.currentTimeMillis() / 1000) + this.brc;
        }
        if (this.brb == bqR) {
            long TJ = (TJ() / 1000) + this.brc;
            if (System.currentTimeMillis() > TJ) {
                return TJ + 86400;
            }
            return TJ;
        } else if (this.brb == bqS) {
            return e((int) this.brc, fs(4)) / 1000;
        } else {
            if (this.brb == bqT) {
                return this.brc / 1000;
            }
            return 0L;
        }
    }

    private long TJ() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long fs(int i) {
        long TJ = TJ();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - TJ;
    }

    private long e(int i, long j) {
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
        return this.bqU;
    }

    public void setActivityId(int i) {
        this.bqU = i;
    }

    public int TK() {
        return this.bqV;
    }

    public void ft(int i) {
        this.bqV = i;
    }

    public String TL() {
        return this.bqW;
    }

    public void ke(String str) {
        this.bqW = str;
    }

    public int TM() {
        return this.bqX;
    }

    public void fu(int i) {
        this.bqX = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void fv(int i) {
        this.mTaskType = i;
    }

    public String TN() {
        return this.bqY;
    }

    public void kf(String str) {
        this.bqY = str;
        this.brh = kd(str);
    }

    public int[] TO() {
        return this.brh;
    }

    public long TP() {
        return this.bqZ;
    }

    public void Y(long j) {
        this.bqZ = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int TQ() {
        return this.bra;
    }

    public void fw(int i) {
        this.bra = i;
    }

    public int TR() {
        return this.brb;
    }

    public void fx(int i) {
        this.brb = i;
    }

    public long TS() {
        return this.brc;
    }

    public void Z(long j) {
        this.brc = j;
    }

    public long TT() {
        return this.brk;
    }

    public void aa(long j) {
        this.brk = j;
    }

    public long getTid() {
        return this.brd;
    }

    public void setTid(long j) {
        this.brd = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String TU() {
        return this.bre;
    }

    public void kg(String str) {
        this.bre = str;
    }

    public String TV() {
        return this.brf;
    }

    public void kh(String str) {
        this.brf = str;
    }

    public long TW() {
        return this.brg;
    }

    public void ab(long j) {
        this.brg = j;
    }
}
