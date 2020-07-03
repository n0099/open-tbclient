package com.baidu.tbadk.BdToken;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.ar;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class b {
    private int dyP;
    private int dyQ;
    private long dyR;
    private String dyS;
    private int dyT;
    private long dyU;
    private String dyV;
    private String dyW;
    private String dyX;
    private String dyY;
    private long dyZ;
    private int dza;
    private long dzb;
    private int[] dzc;
    private long dzd;
    private volatile int dze;
    private volatile int dzf;
    private boolean dzg;
    private int dzh;
    public boolean dzi;
    private final ArrayList<h> dzj;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int yp;
    public static String ACTIVITY_ID = "activityid";
    public static String dyl = "missionid";
    public static String dym = "activitysource";
    public static String SOURCE = "source";
    public static String dyn = "tab";
    public static String dyo = "calltype";
    public static String dyp = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String dyq = "browsetimepage";
    public static String dyr = "browsetime";
    public static String dys = "threadnum";
    public static String dyt = "forumnum";
    public static String dyu = "cleartype";
    public static String dyv = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String dyw = "threadtext";
    public static String dyx = "threadimg";
    public static String dyy = "threadforum";
    public static String dyz = "total_limit";
    public static int dyA = -1;
    public static int dyB = 1;
    public static int dyC = 2;
    public static int dyD = 3;
    public static int dyE = 4;
    public static int dyF = 5;
    public static int dyG = 6;
    public static int dyH = 7;
    public static int dyI = 8;
    public static int dyJ = 9;
    public static int dyK = -1;
    public static int dyL = 0;
    public static int dyM = 1;
    public static int dyN = 2;
    public static int dyO = 3;

    public void reset() {
        this.dzj.clear();
        this.dze = 0;
        this.dzf = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.dzj.contains(hVar)) {
                this.dzj.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.dzj.contains(hVar)) {
                this.dzj.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.dzj.contains(hVar)) {
                this.dzj.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.dzj.contains(hVar)) {
                this.dzj.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.dzj.contains(hVar)) {
            this.dzj.add(hVar);
        }
    }

    public ArrayList<h> aLN() {
        return this.dzj;
    }

    public int aLO() {
        int i;
        int size = this.dzj.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) com.baidu.tbadk.core.util.w.getItem(this.dzj, i2);
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

    public void aLP() {
        int size = this.dzj.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) com.baidu.tbadk.core.util.w.getItem(this.dzj, i);
            if (hVar != null) {
                hVar.gE(true);
            }
        }
    }

    public boolean bS(long j) {
        for (int i = 0; i < this.dzj.size(); i++) {
            h hVar = (h) com.baidu.tbadk.core.util.w.getItem(this.dzj, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.gJ()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ak(int i, String str) {
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
                        kVar.gE(optBoolean);
                        kVar.bX(optLong2);
                        kVar.kd(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.gE(optBoolean);
                        mVar.bX(optLong2);
                        mVar.kd(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.gE(optBoolean);
                        jVar.bX(optLong2);
                        jVar.kd(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.gE(optBoolean);
                    iVar.bX(optLong2);
                    iVar.kd(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.gE(optBoolean);
                    lVar.bX(optLong2);
                    lVar.kd(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String aLQ() {
        try {
            ArrayList<h> arrayList = this.dzj;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) com.baidu.tbadk.core.util.w.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.aMN());
                jSONObject.put("c", hVar.gJ());
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
        this.dza = dyK;
        this.dze = 0;
        this.dzf = 0;
        this.dzg = false;
        this.dzh = 1;
        this.mTag = 0;
        this.dzi = false;
        this.dzj = new ArrayList<>();
    }

    public b(String str) {
        this.dza = dyK;
        this.dze = 0;
        this.dzf = 0;
        this.dzg = false;
        this.dzh = 1;
        this.mTag = 0;
        this.dzi = false;
        this.dzj = new ArrayList<>();
        us(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            jX(activeCenterMissionData.mission_id);
            kc(activeCenterMissionData.total_limit);
            jZ(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            kb(activeCenterMissionData.cleartype);
            bU(activeCenterMissionData.cleartime);
        }
    }

    public boolean us(String str) {
        if (ar.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.dyP = jSONObject.optInt(ACTIVITY_ID);
                this.dyQ = jSONObject.optInt(dyl);
                this.dyV = jSONObject.optString(dym);
                this.mSource = jSONObject.optString(SOURCE);
                this.dyW = jSONObject.optString(dyn);
                this.yp = jSONObject.optInt(dyo);
                this.mTaskType = jSONObject.optInt(dyp);
                this.dyS = jSONObject.optString(dyq);
                this.dzc = ut(this.dyS);
                this.dyR = jSONObject.optLong(dyr);
                this.mThreadNum = jSONObject.optInt(dys);
                this.dyT = jSONObject.optInt(dyt);
                this.dza = jSONObject.optInt(dyu);
                this.dzb = jSONObject.optLong(dyv);
                this.dzd = aLW();
                this.dyU = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.dyX = jSONObject.optString(dyw);
                this.dyY = jSONObject.optString(dyx);
                this.dyZ = jSONObject.optLong(dyy);
                int optInt = jSONObject.optInt(dyz);
                if (optInt > 0) {
                    this.dzh = optInt;
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
        this.dza = dyK;
        this.dze = 0;
        this.dzf = 0;
        this.dzg = false;
        this.dzh = 1;
        this.mTag = 0;
        this.dzi = false;
        this.dzj = new ArrayList<>();
        if (missionInfo != null) {
            this.dyP = missionInfo.activityid.intValue();
            this.dyQ = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.dza = missionInfo.cleartype.intValue();
            this.dzb = missionInfo.cleartime.intValue();
            this.dzd = aLW();
            this.dyS = missionInfo.browsetimepage;
            this.dzc = ut(this.dyS);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.dyR = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.dzh = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean aLR() {
        return this.dyP > 0 && this.dyQ > 0 && this.mTaskType > 0 && this.dyR > 0;
    }

    public synchronized int aLS() {
        int i;
        i = this.dzf + 1;
        this.dzf = i;
        return i;
    }

    public synchronized int aLT() {
        int i;
        i = this.dze + 1;
        this.dze = i;
        return i;
    }

    public synchronized int aLU() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] ut(String str) {
        if (this.mTaskType == 8) {
            return new int[]{dyA};
        }
        if (this.mTaskType == 7) {
            return new int[]{dyB, dyI, dyJ};
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

    public boolean aLV() {
        return System.currentTimeMillis() > aMi() * 1000;
    }

    public long aLW() {
        if (this.dza == dyK) {
            return 0L;
        }
        if (this.dza == dyL) {
            return (System.currentTimeMillis() / 1000) + this.dzb;
        }
        if (this.dza == dyM) {
            long aLX = (aLX() / 1000) + this.dzb;
            if (System.currentTimeMillis() > aLX) {
                return aLX + 86400;
            }
            return aLX;
        } else if (this.dza == dyN) {
            return m((int) this.dzb, jW(4)) / 1000;
        } else {
            if (this.dza == dyO) {
                return this.dzb / 1000;
            }
            return 0L;
        }
    }

    private long aLX() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long jW(int i) {
        long aLX = aLX();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - aLX;
    }

    private long m(int i, long j) {
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
        return this.dyP;
    }

    public void setActivityId(int i) {
        this.dyP = i;
    }

    public int aLY() {
        return this.dyQ;
    }

    public void jX(int i) {
        this.dyQ = i;
    }

    public String aLZ() {
        return this.dyV;
    }

    public void uu(String str) {
        this.dyV = str;
    }

    public String aMa() {
        return this.dyW;
    }

    public String getSource() {
        return this.mSource;
    }

    public int aMb() {
        return this.yp;
    }

    public void jY(int i) {
        this.yp = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void jZ(int i) {
        this.mTaskType = i;
    }

    public String aMc() {
        return this.dyS;
    }

    public void uv(String str) {
        this.dyS = str;
        this.dzc = ut(str);
    }

    public int[] aMd() {
        return this.dzc;
    }

    public long aMe() {
        return this.dyR;
    }

    public void bT(long j) {
        this.dyR = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int aMf() {
        return this.dyT;
    }

    public void ka(int i) {
        this.dyT = i;
    }

    public int aMg() {
        return this.dza;
    }

    public void kb(int i) {
        this.dza = i;
    }

    public long aMh() {
        return this.dzb;
    }

    public void bU(long j) {
        this.dzb = j;
    }

    public long aMi() {
        return this.dzd;
    }

    public void bV(long j) {
        this.dzd = j;
    }

    public long getTid() {
        return this.dyU;
    }

    public void setTid(long j) {
        this.dyU = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String aMj() {
        return this.dyX;
    }

    public void uw(String str) {
        this.dyX = str;
    }

    public String aMk() {
        return this.dyY;
    }

    public void ux(String str) {
        this.dyY = str;
    }

    public long aMl() {
        return this.dyZ;
    }

    public void bW(long j) {
        this.dyZ = j;
    }

    public int aMm() {
        return this.dzh;
    }

    public void kc(int i) {
        this.dzh = i;
    }

    public void kd(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean aMn() {
        return this.dzg;
    }

    public void gD(boolean z) {
        this.dzg = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
