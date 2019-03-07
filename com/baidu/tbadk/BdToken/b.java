package com.baidu.tbadk.BdToken;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int bqP;
    private int bqQ;
    private String bqR;
    private int bqS;
    private String bqT;
    private long bqU;
    private int bqV;
    private long bqX;
    private long bqY;
    private String bqZ;
    private String bra;
    private long brb;
    private int[] brc;
    private long brf;
    private long mFid;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String bqk = "missionid";
    public static String bql = "activitysource";
    public static String bqm = "calltype";
    public static String bqn = "tasktype";
    public static String bqo = "browsetimepage";
    public static String bqp = "browsetime";
    public static String bqq = "threadnum";
    public static String bqr = "forumnum";
    public static String bqs = "cleartype";
    public static String bqt = "cleartime";
    public static String TID = "tid";
    public static String bqu = ImageViewerConfig.FORUM_ID;
    public static String bqv = "threadtext";
    public static String bqw = "threadimg";
    public static String bqx = "threadforum";
    public static int bqy = 1;
    public static int bqz = 2;
    public static int bqA = 3;
    public static int bqB = 4;
    public static int bqC = 1;
    public static int bqD = 2;
    public static int bqE = 3;
    public static int bqF = 4;
    public static int bqG = 5;
    public static int bqH = 6;
    public static int bqI = 7;
    public static int bqJ = 8;
    public static int bqK = -1;
    public static int bqL = 0;
    public static int bqM = 1;
    public static int bqN = 2;
    public static int bqO = 3;
    private int bqW = bqK;
    private volatile int brd = 0;
    private volatile int bre = 0;

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
                this.bqP = jSONObject.optInt(ACTIVITY_ID);
                this.bqQ = jSONObject.optInt(bqk);
                this.bqR = jSONObject.optString(bql);
                this.bqS = jSONObject.optInt(bqm);
                this.mTaskType = jSONObject.optInt(bqn);
                this.bqT = jSONObject.optString(bqo);
                this.brc = kc(this.bqT);
                this.bqU = jSONObject.optLong(bqp);
                this.mThreadNum = jSONObject.optInt(bqq);
                this.bqV = jSONObject.optInt(bqr);
                this.bqW = jSONObject.optInt(bqs);
                this.bqX = jSONObject.optLong(bqt);
                this.brf = TK();
                this.bqY = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(bqu);
                this.bqZ = jSONObject.optString(bqv);
                this.bra = jSONObject.optString(bqw);
                this.brb = jSONObject.optLong(bqx);
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
        i = this.bre + 1;
        this.bre = i;
        return i;
    }

    public synchronized int TJ() {
        int i;
        i = this.brd + 1;
        this.brd = i;
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
        if (this.bqW == bqK) {
            return 0L;
        }
        if (this.bqW == bqL) {
            return (System.currentTimeMillis() / 1000) + this.bqX;
        }
        if (this.bqW == bqM) {
            long TL = (TL() / 1000) + this.bqX;
            if (System.currentTimeMillis() > TL) {
                return TL + 86400;
            }
            return TL;
        } else if (this.bqW == bqN) {
            return e((int) this.bqX, ft(4)) / 1000;
        } else {
            if (this.bqW == bqO) {
                return this.bqX / 1000;
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
        return this.bqP;
    }

    public void setActivityId(int i) {
        this.bqP = i;
    }

    public int TM() {
        return this.bqQ;
    }

    public void fu(int i) {
        this.bqQ = i;
    }

    public String TN() {
        return this.bqR;
    }

    public void kd(String str) {
        this.bqR = str;
    }

    public int TO() {
        return this.bqS;
    }

    public void fv(int i) {
        this.bqS = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void fw(int i) {
        this.mTaskType = i;
    }

    public String TP() {
        return this.bqT;
    }

    public void ke(String str) {
        this.bqT = str;
        this.brc = kc(str);
    }

    public int[] TQ() {
        return this.brc;
    }

    public long TR() {
        return this.bqU;
    }

    public void Y(long j) {
        this.bqU = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int TS() {
        return this.bqV;
    }

    public void fx(int i) {
        this.bqV = i;
    }

    public int TT() {
        return this.bqW;
    }

    public void fy(int i) {
        this.bqW = i;
    }

    public long TU() {
        return this.bqX;
    }

    public void Z(long j) {
        this.bqX = j;
    }

    public long TV() {
        return this.brf;
    }

    public void aa(long j) {
        this.brf = j;
    }

    public long getTid() {
        return this.bqY;
    }

    public void setTid(long j) {
        this.bqY = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String TW() {
        return this.bqZ;
    }

    public void kf(String str) {
        this.bqZ = str;
    }

    public String TX() {
        return this.bra;
    }

    public void kg(String str) {
        this.bra = str;
    }

    public long TY() {
        return this.brb;
    }

    public void ab(long j) {
        this.brb = j;
    }
}
