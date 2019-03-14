package com.baidu.tbadk.BdToken;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int bqQ;
    private int bqR;
    private String bqS;
    private int bqT;
    private String bqU;
    private long bqV;
    private int bqW;
    private long bqY;
    private long bqZ;
    private String bra;
    private String brb;
    private long brc;
    private int[] brd;
    private long brg;
    private long mFid;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String bql = "missionid";
    public static String bqm = "activitysource";
    public static String bqn = "calltype";
    public static String bqo = "tasktype";
    public static String bqp = "browsetimepage";
    public static String bqq = "browsetime";
    public static String bqr = "threadnum";
    public static String bqs = "forumnum";
    public static String bqt = "cleartype";
    public static String bqu = "cleartime";
    public static String TID = "tid";
    public static String bqv = ImageViewerConfig.FORUM_ID;
    public static String bqw = "threadtext";
    public static String bqx = "threadimg";
    public static String bqy = "threadforum";
    public static int bqz = 1;
    public static int bqA = 2;
    public static int bqB = 3;
    public static int bqC = 4;
    public static int bqD = 1;
    public static int bqE = 2;
    public static int bqF = 3;
    public static int bqG = 4;
    public static int bqH = 5;
    public static int bqI = 6;
    public static int bqJ = 7;
    public static int bqK = 8;
    public static int bqL = -1;
    public static int bqM = 0;
    public static int bqN = 1;
    public static int bqO = 2;
    public static int bqP = 3;
    private int bqX = bqL;
    private volatile int bre = 0;
    private volatile int brf = 0;

    public b() {
    }

    public b(String str) {
        kb(str);
    }

    public boolean kb(String str) {
        if (ap.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.bqQ = jSONObject.optInt(ACTIVITY_ID);
                this.bqR = jSONObject.optInt(bql);
                this.bqS = jSONObject.optString(bqm);
                this.bqT = jSONObject.optInt(bqn);
                this.mTaskType = jSONObject.optInt(bqo);
                this.bqU = jSONObject.optString(bqp);
                this.brd = kc(this.bqU);
                this.bqV = jSONObject.optLong(bqq);
                this.mThreadNum = jSONObject.optInt(bqr);
                this.bqW = jSONObject.optInt(bqs);
                this.bqX = jSONObject.optInt(bqt);
                this.bqY = jSONObject.optLong(bqu);
                this.brg = TK();
                this.bqZ = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(bqv);
                this.bra = jSONObject.optString(bqw);
                this.brb = jSONObject.optString(bqx);
                this.brc = jSONObject.optLong(bqy);
                return true;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public synchronized int TI() {
        int i;
        i = this.brf + 1;
        this.brf = i;
        return i;
    }

    public synchronized int TJ() {
        int i;
        i = this.bre + 1;
        this.bre = i;
        return i;
    }

    private int[] kc(String str) {
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

    private long TK() {
        if (this.bqX == bqL) {
            return 0L;
        }
        if (this.bqX == bqM) {
            return (System.currentTimeMillis() / 1000) + this.bqY;
        }
        if (this.bqX == bqN) {
            long TL = (TL() / 1000) + this.bqY;
            if (System.currentTimeMillis() > TL) {
                return TL + 86400;
            }
            return TL;
        } else if (this.bqX == bqO) {
            return e((int) this.bqY, ft(4)) / 1000;
        } else {
            if (this.bqX == bqP) {
                return this.bqY / 1000;
            }
            return 0L;
        }
    }

    private long TL() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long ft(int i) {
        long TL = TL();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - TL;
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
        return this.bqQ;
    }

    public void setActivityId(int i) {
        this.bqQ = i;
    }

    public int TM() {
        return this.bqR;
    }

    public void fu(int i) {
        this.bqR = i;
    }

    public String TN() {
        return this.bqS;
    }

    public void kd(String str) {
        this.bqS = str;
    }

    public int TO() {
        return this.bqT;
    }

    public void fv(int i) {
        this.bqT = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void fw(int i) {
        this.mTaskType = i;
    }

    public String TP() {
        return this.bqU;
    }

    public void ke(String str) {
        this.bqU = str;
        this.brd = kc(str);
    }

    public int[] TQ() {
        return this.brd;
    }

    public long TR() {
        return this.bqV;
    }

    public void Y(long j) {
        this.bqV = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int TS() {
        return this.bqW;
    }

    public void fx(int i) {
        this.bqW = i;
    }

    public int TT() {
        return this.bqX;
    }

    public void fy(int i) {
        this.bqX = i;
    }

    public long TU() {
        return this.bqY;
    }

    public void Z(long j) {
        this.bqY = j;
    }

    public long TV() {
        return this.brg;
    }

    public void aa(long j) {
        this.brg = j;
    }

    public long getTid() {
        return this.bqZ;
    }

    public void setTid(long j) {
        this.bqZ = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String TW() {
        return this.bra;
    }

    public void kf(String str) {
        this.bra = str;
    }

    public String TX() {
        return this.brb;
    }

    public void kg(String str) {
        this.brb = str;
    }

    public long TY() {
        return this.brc;
    }

    public void ab(long j) {
        this.brc = j;
    }
}
