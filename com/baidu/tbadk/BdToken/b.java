package com.baidu.tbadk.BdToken;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int akb;
    private int akc;
    private String akd;
    private int ake;
    private String akf;
    private long akg;
    private int akh;
    private long akj;
    private long akk;
    private String akl;
    private String akm;
    private long akn;
    private int[] ako;
    private long akr;
    private long mFid;
    private int mTaskType;
    private int mThreadNum;
    public static String ACTIVITY_ID = "activityid";
    public static String ajw = "missionid";
    public static String ajx = "activitysource";
    public static String ajy = "calltype";
    public static String ajz = "tasktype";
    public static String ajA = "browsetimepage";
    public static String ajB = "browsetime";
    public static String ajC = "threadnum";
    public static String ajD = "forumnum";
    public static String ajE = "cleartype";
    public static String ajF = "cleartime";
    public static String TID = "tid";
    public static String ajG = ImageViewerConfig.FORUM_ID;
    public static String ajH = "threadtext";
    public static String ajI = "threadimg";
    public static String ajJ = "threadforum";
    public static int ajK = 1;
    public static int ajL = 2;
    public static int ajM = 3;
    public static int ajN = 4;
    public static int ajO = 1;
    public static int ajP = 2;
    public static int ajQ = 3;
    public static int ajR = 4;
    public static int ajS = 5;
    public static int ajT = 6;
    public static int ajU = 7;
    public static int ajV = 8;
    public static int ajW = -1;
    public static int ajX = 0;
    public static int ajY = 1;
    public static int ajZ = 2;
    public static int aka = 3;
    private int aki = ajW;
    private volatile int akp = 0;
    private volatile int akq = 0;

    public b() {
    }

    public b(String str) {
        du(str);
    }

    public boolean du(String str) {
        if (ao.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.akb = jSONObject.optInt(ACTIVITY_ID);
                this.akc = jSONObject.optInt(ajw);
                this.akd = jSONObject.optString(ajx);
                this.ake = jSONObject.optInt(ajy);
                this.mTaskType = jSONObject.optInt(ajz);
                this.akf = jSONObject.optString(ajA);
                this.ako = dv(this.akf);
                this.akg = jSONObject.optLong(ajB);
                this.mThreadNum = jSONObject.optInt(ajC);
                this.akh = jSONObject.optInt(ajD);
                this.aki = jSONObject.optInt(ajE);
                this.akj = jSONObject.optLong(ajF);
                this.akr = vf();
                this.akk = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(ajG);
                this.akl = jSONObject.optString(ajH);
                this.akm = jSONObject.optString(ajI);
                this.akn = jSONObject.optLong(ajJ);
                return true;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public synchronized int vd() {
        int i;
        i = this.akq + 1;
        this.akq = i;
        return i;
    }

    public synchronized int ve() {
        int i;
        i = this.akp + 1;
        this.akp = i;
        return i;
    }

    private int[] dv(String str) {
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

    private long vf() {
        if (this.aki == ajW) {
            return 0L;
        }
        if (this.aki == ajX) {
            return (System.currentTimeMillis() / 1000) + this.akj;
        }
        if (this.aki == ajY) {
            long vg = (vg() / 1000) + this.akj;
            if (System.currentTimeMillis() > vg) {
                return vg + 86400;
            }
            return vg;
        } else if (this.aki == ajZ) {
            return e((int) this.akj, bR(4)) / 1000;
        } else {
            if (this.aki == aka) {
                return this.akj / 1000;
            }
            return 0L;
        }
    }

    private long vg() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long bR(int i) {
        long vg = vg();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - vg;
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
        return this.akb;
    }

    public void setActivityId(int i) {
        this.akb = i;
    }

    public int vh() {
        return this.akc;
    }

    public void bS(int i) {
        this.akc = i;
    }

    public String vi() {
        return this.akd;
    }

    public void dw(String str) {
        this.akd = str;
    }

    public int vj() {
        return this.ake;
    }

    public void bT(int i) {
        this.ake = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void bU(int i) {
        this.mTaskType = i;
    }

    public String vk() {
        return this.akf;
    }

    public void dx(String str) {
        this.akf = str;
        this.ako = dv(str);
    }

    public int[] vl() {
        return this.ako;
    }

    public long vm() {
        return this.akg;
    }

    public void w(long j) {
        this.akg = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int vn() {
        return this.akh;
    }

    public void bV(int i) {
        this.akh = i;
    }

    public int vo() {
        return this.aki;
    }

    public void bW(int i) {
        this.aki = i;
    }

    public long vp() {
        return this.akj;
    }

    public void x(long j) {
        this.akj = j;
    }

    public long vq() {
        return this.akr;
    }

    public void y(long j) {
        this.akr = j;
    }

    public long getTid() {
        return this.akk;
    }

    public void setTid(long j) {
        this.akk = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String vr() {
        return this.akl;
    }

    public void dy(String str) {
        this.akl = str;
    }

    public String vs() {
        return this.akm;
    }

    public void dz(String str) {
        this.akm = str;
    }

    public long vt() {
        return this.akn;
    }

    public void z(long j) {
        this.akn = j;
    }
}
