package b.a.a.a.a;

import android.annotation.SuppressLint;
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
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class z extends ac {

    /* renamed from: a  reason: collision with root package name */
    public int f1085a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f1086b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    private int g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int h = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final long i = System.currentTimeMillis();
    private List j;

    private z() {
    }

    @SuppressLint({"NewApi"})
    public static z a(TelephonyManager telephonyManager, CellInfo cellInfo) {
        int i = -88;
        if (cellInfo == null) {
            return null;
        }
        z zVar = new z();
        try {
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                zVar.f1085a = 2;
                zVar.c(telephonyManager);
                zVar.c = cellIdentity.getSystemId();
                zVar.d = cellIdentity.getNetworkId();
                zVar.e = cellIdentity.getBasestationId();
                zVar.g = cellIdentity.getLatitude();
                zVar.h = cellIdentity.getLongitude();
                int dbm = cellInfoCdma.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i = dbm;
                }
                zVar.f = i;
            } else if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                zVar.f1085a = 1;
                CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                zVar.d = cellIdentity2.getLac();
                zVar.e = cellIdentity2.getCid();
                zVar.f1086b = cellIdentity2.getMcc();
                zVar.c = cellIdentity2.getMnc();
                int dbm2 = cellInfoGsm.getCellSignalStrength().getDbm();
                if (dbm2 > -110 && dbm2 < -40) {
                    i = dbm2;
                }
                zVar.f = i;
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                zVar.f1085a = 1;
                CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                zVar.d = cellIdentity3.getLac();
                zVar.e = cellIdentity3.getCid();
                zVar.f1086b = cellIdentity3.getMcc();
                zVar.c = cellIdentity3.getMnc();
                int dbm3 = cellInfoWcdma.getCellSignalStrength().getDbm();
                if (dbm3 > -110 && dbm3 < -40) {
                    i = dbm3;
                }
                zVar.f = i;
            } else if (cellInfo instanceof CellInfoLte) {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                zVar.f1085a = 1;
                CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                zVar.d = cellIdentity4.getTac();
                zVar.e = cellIdentity4.getCi();
                zVar.f1086b = cellIdentity4.getMcc();
                zVar.c = cellIdentity4.getMnc();
                int dbm4 = cellInfoLte.getCellSignalStrength().getDbm();
                if (dbm4 <= -110 || dbm4 >= -40) {
                    dbm4 = -88;
                }
                zVar.f = dbm4;
            }
            return zVar;
        } catch (Throwable th) {
            return zVar;
        }
    }

    public static z a(TelephonyManager telephonyManager, CellLocation cellLocation, SignalStrength signalStrength) {
        if (telephonyManager == null || cellLocation == null) {
            return null;
        }
        z zVar = new z();
        try {
            zVar.c(telephonyManager);
            if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                zVar.f1085a = 2;
                zVar.c = cdmaCellLocation.getSystemId();
                zVar.d = cdmaCellLocation.getNetworkId();
                zVar.e = cdmaCellLocation.getBaseStationId();
                zVar.g = cdmaCellLocation.getBaseStationLatitude();
                zVar.h = cdmaCellLocation.getBaseStationLongitude();
                if (signalStrength == null) {
                    zVar.f = -1;
                } else {
                    zVar.f = signalStrength.getCdmaDbm();
                }
            } else {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                zVar.f1085a = 1;
                zVar.d = gsmCellLocation.getLac();
                zVar.e = gsmCellLocation.getCid();
                if (signalStrength == null) {
                    zVar.f = -1;
                } else {
                    zVar.f = (signalStrength.getGsmSignalStrength() * 2) - 113;
                }
            }
            return zVar;
        } catch (Throwable th) {
            return zVar;
        }
    }

    private static String a(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"mcc\":");
        sb.append(i);
        sb.append(",\"mnc\":");
        sb.append(i2);
        sb.append(",\"lac\":");
        sb.append(i3);
        sb.append(",\"cellid\":");
        sb.append(i4);
        sb.append(",\"rss\":");
        sb.append(i5);
        if (z2) {
            sb.append(",\"seed\":");
            sb.append(z ? 1 : 0);
        }
        if (i6 != Integer.MAX_VALUE && i7 != Integer.MAX_VALUE) {
            sb.append(",\"stationLat\":");
            sb.append(String.format("%.6f", Float.valueOf(i6 / 14400.0f)));
            sb.append(",\"stationLng\":");
            sb.append(String.format("%.6f", Float.valueOf(i7 / 14400.0f)));
        }
        sb.append("}");
        return sb.toString();
    }

    private List b() {
        List list;
        synchronized (this) {
            if (this.j == null) {
                this.j = Collections.emptyList();
            }
            list = this.j;
        }
        return list;
    }

    private void c(TelephonyManager telephonyManager) {
        int[] iArr = new int[2];
        c.a(telephonyManager, iArr);
        if (iArr[0] <= 0 || iArr[1] < 0) {
            return;
        }
        this.f1086b = iArr[0];
        this.c = iArr[1];
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0005: IGET  (r1v0 int A[REMOVE]) = (r2v0 'this' b.a.a.a.a.z A[IMMUTABLE_TYPE, THIS]) b.a.a.a.a.z.b int), (wrap: int : 0x000b: IGET  (r1v1 int A[REMOVE]) = (r2v0 'this' b.a.a.a.a.z A[IMMUTABLE_TYPE, THIS]) b.a.a.a.a.z.c int), (wrap: int : 0x0011: IGET  (r1v2 int A[REMOVE]) = (r2v0 'this' b.a.a.a.a.z A[IMMUTABLE_TYPE, THIS]) b.a.a.a.a.z.d int), (wrap: int : 0x0017: IGET  (r1v3 int A[REMOVE]) = (r2v0 'this' b.a.a.a.a.z A[IMMUTABLE_TYPE, THIS]) b.a.a.a.a.z.e int)] */
    public final String a() {
        return new StringBuilder().append(this.f1086b).append(this.c).append(this.d).append(this.e).toString();
    }

    public final String a(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (c.a(this)) {
            arrayList.add(a(this.f1086b, this.c, this.d, this.e, this.f, this.g, this.h, z, true));
        }
        try {
            for (NeighboringCellInfo neighboringCellInfo : b()) {
                int lac = neighboringCellInfo.getLac();
                int cid = neighboringCellInfo.getCid();
                if (c.a(this.f1085a, this.f1086b, this.c, lac, cid)) {
                    arrayList.add(a(this.f1086b, this.c, lac, cid, (neighboringCellInfo.getRssi() << 1) - 113, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, false, false));
                }
            }
        } catch (Throwable th) {
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append((String) arrayList.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    public final void a(List list) {
        synchronized (this) {
            if (list != null) {
                this.j = Collections.unmodifiableList(list);
            } else {
                this.j = Collections.emptyList();
            }
        }
    }

    public final String toString() {
        return "TxCellInfo [PhoneType=" + this.f1085a + ", MCC=" + this.f1086b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
    }
}
