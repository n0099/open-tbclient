package cn.jiguang.a.a.b;

import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import cn.jiguang.g.k;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    private TelephonyManager f;
    private Context g;
    private b kB;
    private f kC;
    private int a = -1;
    private int b = -1;
    private String c = "";
    private String d = "";
    private String e = "";
    private int h = 0;
    private JSONArray k = null;

    public a(Context context, f fVar) {
        this.f = null;
        this.g = null;
        this.g = context;
        try {
            this.f = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.kC = fVar;
        } catch (Exception e) {
        }
    }

    private static int a(String str) {
        try {
            if (str.length() <= 6) {
                return Integer.parseInt(str.substring(3, str.length()));
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    private void a(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!jSONArray2.toString().contains(jSONObject.toString())) {
                    jSONArray2.put(jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        this.k = jSONArray2;
    }

    private JSONObject b(int i, int i2, int i3, int i4) {
        if (i2 >= 268435455 || !(i4 == 0 || i4 == 3)) {
            if (i2 >= 65535 || !(i4 == 1 || i4 == 2)) {
                return null;
            }
            return c(i, i2, i3);
        }
        return c(i, i2, i3);
    }

    private JSONObject c(int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mobile_network_code", this.b);
            jSONObject.put("cell_id", i2);
            jSONObject.put("radio_type", this.c);
            jSONObject.put("signal_strength", i);
            jSONObject.put("mobile_country_code", this.a);
            jSONObject.put("carrier", this.e);
            jSONObject.put("location_area_code", i3);
            jSONObject.put("generation", this.d);
            jSONObject.put("itime", cn.jiguang.d.a.a.bG());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.kC != null) {
            this.kC.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        CellLocation cellLocation;
        try {
            cellLocation = this.f.getCellLocation();
        } catch (Exception e) {
            e.printStackTrace();
            cellLocation = null;
        }
        if (cellLocation == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                jSONArray.put(c(this.h, gsmCellLocation.getCid(), gsmCellLocation.getLac()));
            } else if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                jSONArray.put(c(this.h, cdmaCellLocation.getBaseStationId(), cdmaCellLocation.getNetworkId()));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        List<NeighboringCellInfo> neighboringCellInfo = this.f.getNeighboringCellInfo();
        if (neighboringCellInfo != null) {
            for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                int rssi = (neighboringCellInfo2.getRssi() * 2) - 113;
                int cid = neighboringCellInfo2.getCid();
                int lac = neighboringCellInfo2.getLac();
                if (cid < 65535) {
                    jSONArray.put(c(rssi, cid, lac));
                }
            }
        }
        a(jSONArray);
        return true;
    }

    public final void a() {
        if (this.kC == null) {
            e();
            return;
        }
        this.a = -1;
        this.b = -1;
        this.c = "";
        this.d = "";
        this.e = "";
        this.e = this.f.getNetworkOperatorName();
        int networkType = this.f.getNetworkType();
        this.c = (networkType == 4 || networkType == 7 || networkType == 5 || networkType == 6 || networkType == 12 || networkType == 14) ? "cdma" : networkType == 13 ? "lte" : "gsm";
        this.d = k.a(this.g, this.f.getNetworkType());
        try {
            String networkOperator = this.f.getNetworkOperator();
            if (networkOperator.length() > 3) {
                this.a = Integer.parseInt(networkOperator.substring(0, 3));
                this.b = a(networkOperator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONArray jSONArray = new JSONArray();
        if (Build.VERSION.SDK_INT > 17) {
            List<CellInfo> list = null;
            try {
                list = this.f.getAllCellInfo();
            } catch (Exception e2) {
            }
            if (list != null && list.size() > 0) {
                for (CellInfo cellInfo : list) {
                    if (cellInfo != null) {
                        if (cellInfo instanceof CellInfoLte) {
                            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                            if (Build.VERSION.SDK_INT > 17) {
                                CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                                CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                                JSONObject b = b(cellSignalStrength.getDbm(), cellIdentity.getCi(), cellIdentity.getTac(), 0);
                                if (b != null) {
                                    jSONArray.put(b);
                                }
                            }
                        } else if (cellInfo instanceof CellInfoGsm) {
                            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                            if (Build.VERSION.SDK_INT > 17) {
                                CellSignalStrengthGsm cellSignalStrength2 = cellInfoGsm.getCellSignalStrength();
                                CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                                JSONObject b2 = b(cellSignalStrength2.getDbm(), cellIdentity2.getCid(), cellIdentity2.getLac(), 1);
                                if (b2 != null) {
                                    jSONArray.put(b2);
                                }
                            }
                        } else if (cellInfo instanceof CellInfoCdma) {
                            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                            if (Build.VERSION.SDK_INT > 17) {
                                CellSignalStrengthCdma cellSignalStrength3 = cellInfoCdma.getCellSignalStrength();
                                CellIdentityCdma cellIdentity3 = cellInfoCdma.getCellIdentity();
                                JSONObject b3 = b(cellSignalStrength3.getDbm(), cellIdentity3.getBasestationId(), cellIdentity3.getNetworkId(), 2);
                                if (b3 != null) {
                                    jSONArray.put(b3);
                                }
                            }
                        } else if (cellInfo instanceof CellInfoWcdma) {
                            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                            if (Build.VERSION.SDK_INT > 17) {
                                CellSignalStrengthWcdma cellSignalStrength4 = cellInfoWcdma.getCellSignalStrength();
                                CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                                JSONObject b4 = b(cellSignalStrength4.getDbm(), cellIdentity4.getCid(), cellIdentity4.getLac(), 3);
                                if (b4 != null) {
                                    jSONArray.put(b4);
                                }
                            }
                        }
                    }
                }
                a(jSONArray);
                e();
                return;
            }
        }
        if (f()) {
            e();
            return;
        }
        try {
            this.kB = new b(this);
            this.f.listen(this.kB, 256);
        } catch (Exception e3) {
            e();
        }
    }

    public final JSONArray bn() {
        return this.k;
    }

    public final void c() {
        this.k = null;
    }

    public final void d() {
        try {
            if (this.f == null || this.kB == null) {
                return;
            }
            this.f.listen(this.kB, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
