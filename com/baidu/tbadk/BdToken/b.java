package com.baidu.tbadk.BdToken;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int bqT;
    private int bqU;
    private String bqV;
    private int bqW;
    private String bqX;
    private long bqY;
    private int bqZ;
    private long brb;
    private long brc;
    private String brd;
    private String bre;
    private long brf;
    private int[] brg;
    private long brj;
    private long mFid;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String bqo = "missionid";
    public static String bqp = "activitysource";
    public static String bqq = "calltype";
    public static String bqr = "tasktype";
    public static String bqs = "browsetimepage";
    public static String bqt = "browsetime";
    public static String bqu = "threadnum";
    public static String bqv = "forumnum";
    public static String bqw = "cleartype";
    public static String bqx = "cleartime";
    public static String TID = "tid";
    public static String bqy = ImageViewerConfig.FORUM_ID;
    public static String bqz = "threadtext";
    public static String bqA = "threadimg";
    public static String bqB = "threadforum";
    public static int bqC = 1;
    public static int bqD = 2;
    public static int bqE = 3;
    public static int bqF = 4;
    public static int bqG = 1;
    public static int bqH = 2;
    public static int bqI = 3;
    public static int bqJ = 4;
    public static int bqK = 5;
    public static int bqL = 6;
    public static int bqM = 7;
    public static int bqN = 8;
    public static int bqO = -1;
    public static int bqP = 0;
    public static int bqQ = 1;
    public static int bqR = 2;
    public static int bqS = 3;
    private int bra = bqO;
    private volatile int brh = 0;
    private volatile int bri = 0;

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
                this.bqT = jSONObject.optInt(ACTIVITY_ID);
                this.bqU = jSONObject.optInt(bqo);
                this.bqV = jSONObject.optString(bqp);
                this.bqW = jSONObject.optInt(bqq);
                this.mTaskType = jSONObject.optInt(bqr);
                this.bqX = jSONObject.optString(bqs);
                this.brg = kd(this.bqX);
                this.bqY = jSONObject.optLong(bqt);
                this.mThreadNum = jSONObject.optInt(bqu);
                this.bqZ = jSONObject.optInt(bqv);
                this.bra = jSONObject.optInt(bqw);
                this.brb = jSONObject.optLong(bqx);
                this.brj = TI();
                this.brc = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(bqy);
                this.brd = jSONObject.optString(bqz);
                this.bre = jSONObject.optString(bqA);
                this.brf = jSONObject.optLong(bqB);
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
        i = this.bri + 1;
        this.bri = i;
        return i;
    }

    public synchronized int TH() {
        int i;
        i = this.brh + 1;
        this.brh = i;
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
        if (this.bra == bqO) {
            return 0L;
        }
        if (this.bra == bqP) {
            return (System.currentTimeMillis() / 1000) + this.brb;
        }
        if (this.bra == bqQ) {
            long TJ = (TJ() / 1000) + this.brb;
            if (System.currentTimeMillis() > TJ) {
                return TJ + 86400;
            }
            return TJ;
        } else if (this.bra == bqR) {
            return e((int) this.brb, fs(4)) / 1000;
        } else {
            if (this.bra == bqS) {
                return this.brb / 1000;
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
        return this.bqT;
    }

    public void setActivityId(int i) {
        this.bqT = i;
    }

    public int TK() {
        return this.bqU;
    }

    public void ft(int i) {
        this.bqU = i;
    }

    public String TL() {
        return this.bqV;
    }

    public void ke(String str) {
        this.bqV = str;
    }

    public int TM() {
        return this.bqW;
    }

    public void fu(int i) {
        this.bqW = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void fv(int i) {
        this.mTaskType = i;
    }

    public String TN() {
        return this.bqX;
    }

    public void kf(String str) {
        this.bqX = str;
        this.brg = kd(str);
    }

    public int[] TO() {
        return this.brg;
    }

    public long TP() {
        return this.bqY;
    }

    public void Y(long j) {
        this.bqY = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int TQ() {
        return this.bqZ;
    }

    public void fw(int i) {
        this.bqZ = i;
    }

    public int TR() {
        return this.bra;
    }

    public void fx(int i) {
        this.bra = i;
    }

    public long TS() {
        return this.brb;
    }

    public void Z(long j) {
        this.brb = j;
    }

    public long TT() {
        return this.brj;
    }

    public void aa(long j) {
        this.brj = j;
    }

    public long getTid() {
        return this.brc;
    }

    public void setTid(long j) {
        this.brc = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String TU() {
        return this.brd;
    }

    public void kg(String str) {
        this.brd = str;
    }

    public String TV() {
        return this.bre;
    }

    public void kh(String str) {
        this.bre = str;
    }

    public long TW() {
        return this.brf;
    }

    public void ab(long j) {
        this.brf = j;
    }
}
