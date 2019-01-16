package com.baidu.tbadk.BdToken;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private long akA;
    private int akk;
    private int akl;
    private String akm;
    private int akn;
    private String ako;
    private long akp;
    private int akq;
    private long aks;
    private long akt;
    private String aku;
    private String akv;
    private long akw;
    private int[] akx;
    private long mFid;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String ajF = "missionid";
    public static String ajG = "activitysource";
    public static String ajH = "calltype";
    public static String ajI = "tasktype";
    public static String ajJ = "browsetimepage";
    public static String ajK = "browsetime";
    public static String ajL = "threadnum";
    public static String ajM = "forumnum";
    public static String ajN = "cleartype";
    public static String ajO = "cleartime";
    public static String TID = "tid";
    public static String ajP = ImageViewerConfig.FORUM_ID;
    public static String ajQ = "threadtext";
    public static String ajR = "threadimg";
    public static String ajS = "threadforum";
    public static int ajT = 1;
    public static int ajU = 2;
    public static int ajV = 3;
    public static int ajW = 4;
    public static int ajX = 1;
    public static int ajY = 2;
    public static int ajZ = 3;
    public static int aka = 4;
    public static int akb = 5;
    public static int akc = 6;
    public static int akd = 7;
    public static int ake = 8;
    public static int akf = -1;
    public static int akg = 0;
    public static int akh = 1;
    public static int aki = 2;
    public static int akj = 3;
    private int akr = akf;
    private volatile int aky = 0;
    private volatile int akz = 0;

    public b() {
    }

    public b(String str) {
        dv(str);
    }

    public boolean dv(String str) {
        if (ao.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.akk = jSONObject.optInt(ACTIVITY_ID);
                this.akl = jSONObject.optInt(ajF);
                this.akm = jSONObject.optString(ajG);
                this.akn = jSONObject.optInt(ajH);
                this.mTaskType = jSONObject.optInt(ajI);
                this.ako = jSONObject.optString(ajJ);
                this.akx = dw(this.ako);
                this.akp = jSONObject.optLong(ajK);
                this.mThreadNum = jSONObject.optInt(ajL);
                this.akq = jSONObject.optInt(ajM);
                this.akr = jSONObject.optInt(ajN);
                this.aks = jSONObject.optLong(ajO);
                this.akA = vj();
                this.akt = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(ajP);
                this.aku = jSONObject.optString(ajQ);
                this.akv = jSONObject.optString(ajR);
                this.akw = jSONObject.optLong(ajS);
                return true;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public synchronized int vh() {
        int i;
        i = this.akz + 1;
        this.akz = i;
        return i;
    }

    public synchronized int vi() {
        int i;
        i = this.aky + 1;
        this.aky = i;
        return i;
    }

    private int[] dw(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = com.baidu.adp.lib.g.b.l(split[i], 0);
        }
        return iArr;
    }

    private long vj() {
        if (this.akr == akf) {
            return 0L;
        }
        if (this.akr == akg) {
            return (System.currentTimeMillis() / 1000) + this.aks;
        }
        if (this.akr == akh) {
            long vk = (vk() / 1000) + this.aks;
            if (System.currentTimeMillis() > vk) {
                return vk + 86400;
            }
            return vk;
        } else if (this.akr == aki) {
            return e((int) this.aks, bR(4)) / 1000;
        } else {
            if (this.akr == akj) {
                return this.aks / 1000;
            }
            return 0L;
        }
    }

    private long vk() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long bR(int i) {
        long vk = vk();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - vk;
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
        return this.akk;
    }

    public void setActivityId(int i) {
        this.akk = i;
    }

    public int vl() {
        return this.akl;
    }

    public void bS(int i) {
        this.akl = i;
    }

    public String vm() {
        return this.akm;
    }

    public void dx(String str) {
        this.akm = str;
    }

    public int vn() {
        return this.akn;
    }

    public void bT(int i) {
        this.akn = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void bU(int i) {
        this.mTaskType = i;
    }

    public String vo() {
        return this.ako;
    }

    public void dy(String str) {
        this.ako = str;
        this.akx = dw(str);
    }

    public int[] vp() {
        return this.akx;
    }

    public long vq() {
        return this.akp;
    }

    public void w(long j) {
        this.akp = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int vr() {
        return this.akq;
    }

    public void bV(int i) {
        this.akq = i;
    }

    public int vs() {
        return this.akr;
    }

    public void bW(int i) {
        this.akr = i;
    }

    public long vt() {
        return this.aks;
    }

    public void x(long j) {
        this.aks = j;
    }

    public long vu() {
        return this.akA;
    }

    public void y(long j) {
        this.akA = j;
    }

    public long getTid() {
        return this.akt;
    }

    public void setTid(long j) {
        this.akt = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String vv() {
        return this.aku;
    }

    public void dz(String str) {
        this.aku = str;
    }

    public String vw() {
        return this.akv;
    }

    public void dA(String str) {
        this.akv = str;
    }

    public long vx() {
        return this.akw;
    }

    public void z(long j) {
        this.akw = j;
    }
}
