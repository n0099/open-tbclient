package com.baidu.tbadk.BdToken;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class b {
    private int eoK;
    private int eoL;
    private long eoM;
    private String eoN;
    private int eoO;
    private long eoP;
    private String eoQ;
    private String eoR;
    private String eoS;
    private String eoT;
    private long eoU;
    private int eoV;
    private long eoW;
    private int[] eoX;
    private long eoY;
    private volatile int eoZ;
    private volatile int epa;
    private boolean epb;
    private int epc;
    public boolean epd;
    private final ArrayList<h> epe;
    private long mFid;
    private String mSource;
    private volatile int mTag;
    private int mTaskType;
    private int mThreadNum;
    private String mToken;
    private int zf;
    public static String ACTIVITY_ID = "activityid";
    public static String eog = "missionid";
    public static String eoh = "activitysource";
    public static String SOURCE = "source";
    public static String eoi = "tab";
    public static String eoj = "calltype";
    public static String eok = DownloadDataConstants.Columns.COLUMN_TASK_TYPE;
    public static String eol = "browsetimepage";
    public static String eom = "browsetime";
    public static String eon = "threadnum";
    public static String eoo = "forumnum";
    public static String eop = "cleartype";
    public static String eoq = "cleartime";
    public static String TID = "tid";
    public static String FID = "fid";
    public static String eor = "threadtext";
    public static String eos = "threadimg";
    public static String eot = "threadforum";
    public static String eou = "total_limit";
    public static int eov = -1;
    public static int eow = 1;
    public static int eox = 2;
    public static int eoy = 3;
    public static int eoz = 4;
    public static int eoA = 5;
    public static int eoB = 6;
    public static int eoC = 7;
    public static int eoD = 8;
    public static int eoE = 9;
    public static int eoF = -1;
    public static int eoG = 0;
    public static int eoH = 1;
    public static int eoI = 2;
    public static int eoJ = 3;

    public void reset() {
        this.epe.clear();
        this.eoZ = 0;
        this.epa = 0;
        this.mTag = 0;
    }

    public void a(h hVar) {
        if (this.mTaskType == 7 && (hVar instanceof k)) {
            if (!this.epe.contains(hVar)) {
                this.epe.add(hVar);
            }
        } else if (this.mTaskType == 1 && (hVar instanceof m)) {
            if (!this.epe.contains(hVar)) {
                this.epe.add(hVar);
            }
        } else if (this.mTaskType == 2 && (hVar instanceof j)) {
            if (!this.epe.contains(hVar)) {
                this.epe.add(hVar);
            }
        } else if (this.mTaskType == 4 && (hVar instanceof i)) {
            if (!this.epe.contains(hVar)) {
                this.epe.add(hVar);
            }
        } else if (this.mTaskType == 8 && (hVar instanceof l) && !this.epe.contains(hVar)) {
            this.epe.add(hVar);
        }
    }

    public ArrayList<h> beX() {
        return this.epe;
    }

    public int beY() {
        int i;
        int size = this.epe.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            h hVar = (h) y.getItem(this.epe, i2);
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

    public void beZ() {
        int size = this.epe.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) y.getItem(this.epe, i);
            if (hVar != null) {
                hVar.io(true);
            }
        }
    }

    public boolean cY(long j) {
        for (int i = 0; i < this.epe.size(); i++) {
            h hVar = (h) y.getItem(this.epe, i);
            if (hVar != null) {
                long b = b(hVar);
                if (b > 0 && b == j && hVar.ik()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void aB(int i, String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                long optLong = jSONObject.optLong("i");
                long optLong2 = jSONObject.optLong("t");
                boolean optBoolean = jSONObject.optBoolean("c");
                int optInt = jSONObject.optInt("a");
                if (i == 7) {
                    if (optLong > 0) {
                        k kVar = new k(this, optLong);
                        kVar.io(optBoolean);
                        kVar.dd(optLong2);
                        kVar.nB(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.io(optBoolean);
                        mVar.dd(optLong2);
                        mVar.nB(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.io(optBoolean);
                        jVar.dd(optLong2);
                        jVar.nB(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.io(optBoolean);
                    iVar.dd(optLong2);
                    iVar.nB(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.io(optBoolean);
                    lVar.dd(optLong2);
                    lVar.nB(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String bfa() {
        try {
            ArrayList<h> arrayList = this.epe;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) y.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", b(hVar));
                jSONObject.put("t", hVar.bfY());
                jSONObject.put("c", hVar.ik());
                jSONObject.put("a", hVar.getTag());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    public b() {
        this.eoV = eoF;
        this.eoZ = 0;
        this.epa = 0;
        this.epb = false;
        this.epc = 1;
        this.mTag = 0;
        this.epd = false;
        this.epe = new ArrayList<>();
    }

    public b(String str) {
        this.eoV = eoF;
        this.eoZ = 0;
        this.epa = 0;
        this.epb = false;
        this.epc = 1;
        this.mTag = 0;
        this.epd = false;
        this.epe = new ArrayList<>();
        zo(str);
    }

    public void a(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            nv(activeCenterMissionData.mission_id);
            nA(activeCenterMissionData.total_limit);
            nx(activeCenterMissionData.task_type);
            setActivityId(activeCenterMissionData.active_id);
            nz(activeCenterMissionData.cleartype);
            da(activeCenterMissionData.cleartime);
        }
    }

    public boolean zo(String str) {
        if (au.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                this.eoK = jSONObject.optInt(ACTIVITY_ID);
                this.eoL = jSONObject.optInt(eog);
                this.eoQ = jSONObject.optString(eoh);
                this.mSource = jSONObject.optString(SOURCE);
                this.eoR = jSONObject.optString(eoi);
                this.zf = jSONObject.optInt(eoj);
                this.mTaskType = jSONObject.optInt(eok);
                this.eoN = jSONObject.optString(eol);
                this.eoX = zp(this.eoN);
                this.eoM = jSONObject.optLong(eom);
                this.mThreadNum = jSONObject.optInt(eon);
                this.eoO = jSONObject.optInt(eoo);
                this.eoV = jSONObject.optInt(eop);
                this.eoW = jSONObject.optLong(eoq);
                this.eoY = bfg();
                this.eoP = jSONObject.optLong(TID);
                this.mFid = jSONObject.optLong(FID);
                this.eoS = jSONObject.optString(eor);
                this.eoT = jSONObject.optString(eos);
                this.eoU = jSONObject.optLong(eot);
                int optInt = jSONObject.optInt(eou);
                if (optInt > 0) {
                    this.epc = optInt;
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
        this.eoV = eoF;
        this.eoZ = 0;
        this.epa = 0;
        this.epb = false;
        this.epc = 1;
        this.mTag = 0;
        this.epd = false;
        this.epe = new ArrayList<>();
        if (missionInfo != null) {
            this.eoK = missionInfo.activityid.intValue();
            this.eoL = missionInfo.missionid.intValue();
            this.mTaskType = missionInfo.tasktype.intValue();
            this.eoV = missionInfo.cleartype.intValue();
            this.eoW = missionInfo.cleartime.intValue();
            this.eoY = bfg();
            this.eoN = missionInfo.browsetimepage;
            this.eoX = zp(this.eoN);
            if (missionInfo.threadnum.intValue() > 0) {
                this.mThreadNum = missionInfo.threadnum.intValue();
            }
            if (missionInfo.browsetime.intValue() > 0) {
                this.eoM = missionInfo.browsetime.intValue();
            }
            if (missionInfo.total_limit.intValue() > 0) {
                this.epc = missionInfo.total_limit.intValue();
            }
        }
    }

    public boolean bfb() {
        return this.eoK > 0 && this.eoL > 0 && this.mTaskType > 0 && this.eoM > 0;
    }

    public synchronized int bfc() {
        int i;
        i = this.epa + 1;
        this.epa = i;
        return i;
    }

    public synchronized int bfd() {
        int i;
        i = this.eoZ + 1;
        this.eoZ = i;
        return i;
    }

    public synchronized int bfe() {
        int i;
        i = this.mTag + 1;
        this.mTag = i;
        return i;
    }

    private int[] zp(String str) {
        if (this.mTaskType == 8) {
            return new int[]{eov};
        }
        if (this.mTaskType == 7) {
            return new int[]{eow, eoD, eoE};
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

    public boolean bff() {
        return System.currentTimeMillis() > bfs() * 1000;
    }

    public long bfg() {
        if (this.eoV == eoF) {
            return 0L;
        }
        if (this.eoV == eoG) {
            return (System.currentTimeMillis() / 1000) + this.eoW;
        }
        if (this.eoV == eoH) {
            long bfh = (bfh() / 1000) + this.eoW;
            if (System.currentTimeMillis() > bfh) {
                return bfh + 86400;
            }
            return bfh;
        } else if (this.eoV == eoI) {
            return m((int) this.eoW, nu(4)) / 1000;
        } else {
            if (this.eoV == eoJ) {
                return this.eoW / 1000;
            }
            return 0L;
        }
    }

    private long bfh() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private long nu(int i) {
        long bfh = bfh();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - bfh;
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
        return this.eoK;
    }

    public void setActivityId(int i) {
        this.eoK = i;
    }

    public int bfi() {
        return this.eoL;
    }

    public void nv(int i) {
        this.eoL = i;
    }

    public String bfj() {
        return this.eoQ;
    }

    public void zq(String str) {
        this.eoQ = str;
    }

    public String bfk() {
        return this.eoR;
    }

    public String getSource() {
        return this.mSource;
    }

    public int bfl() {
        return this.zf;
    }

    public void nw(int i) {
        this.zf = i;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void nx(int i) {
        this.mTaskType = i;
    }

    public String bfm() {
        return this.eoN;
    }

    public void zr(String str) {
        this.eoN = str;
        this.eoX = zp(str);
    }

    public int[] bfn() {
        return this.eoX;
    }

    public long bfo() {
        return this.eoM;
    }

    public void cZ(long j) {
        this.eoM = j;
    }

    public int getThreadNum() {
        return this.mThreadNum;
    }

    public void setThreadNum(int i) {
        this.mThreadNum = i;
    }

    public int bfp() {
        return this.eoO;
    }

    public void ny(int i) {
        this.eoO = i;
    }

    public int bfq() {
        return this.eoV;
    }

    public void nz(int i) {
        this.eoV = i;
    }

    public long bfr() {
        return this.eoW;
    }

    public void da(long j) {
        this.eoW = j;
    }

    public long bfs() {
        return this.eoY;
    }

    public void db(long j) {
        this.eoY = j;
    }

    public long getTid() {
        return this.eoP;
    }

    public void setTid(long j) {
        this.eoP = j;
    }

    public long getFid() {
        return this.mFid;
    }

    public void setFid(long j) {
        this.mFid = j;
    }

    public String bft() {
        return this.eoS;
    }

    public void zs(String str) {
        this.eoS = str;
    }

    public String bfu() {
        return this.eoT;
    }

    public void zt(String str) {
        this.eoT = str;
    }

    public long bfv() {
        return this.eoU;
    }

    public void dc(long j) {
        this.eoU = j;
    }

    public int bfw() {
        return this.epc;
    }

    public void nA(int i) {
        this.epc = i;
    }

    public void nB(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public boolean bfx() {
        return this.epb;
    }

    public void in(boolean z) {
        this.epb = z;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
