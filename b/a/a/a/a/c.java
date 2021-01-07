package b.a.a.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class c extends ag {
    public static boolean c = false;
    private CellLocation Ah;
    private SignalStrength Ai;
    private ServiceState Aj;
    private PhoneStateListener Ak;
    private TelephonyManager d;
    private int e;
    private boolean i;
    private Handler j;
    private long k;

    public c(w wVar, y yVar) {
        super(wVar, yVar);
        this.d = null;
        this.e = 0;
        this.Ah = null;
        this.Ai = null;
        this.Aj = null;
        this.i = false;
        this.j = null;
        this.k = 0L;
        this.Ak = new d(this);
        this.d = this.Bm.e;
    }

    public static CellLocation F(Context context) {
        boolean z;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                boolean z2 = telephonyManager.getSimState() == 5;
                try {
                    z = !TextUtils.isEmpty(telephonyManager.getSubscriberId());
                } catch (Throwable th) {
                    z = true;
                }
                if (z2 && z) {
                    c = (cellLocation == null || d(cellLocation) || c(cellLocation) < 0) && !c(context);
                }
                return cellLocation;
            } catch (Throwable th2) {
                c = true;
            }
        }
        return CellLocation.getEmpty();
    }

    private void a(int i) {
        try {
            if (this.d != null) {
                this.d.listen(this.Ak, i);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(11:3|(1:5)(2:23|(1:25))|6|7|8|(6:10|11|(1:19)|(1:18)|15|16)|21|(0)|18|15|16)|26|6|7|8|(0)|21|(0)|18|15|16) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001b A[Catch: Throwable -> 0x003a, TRY_LEAVE, TryCatch #0 {Throwable -> 0x003a, blocks: (B:8:0x0015, B:10:0x001b), top: B:25:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(ServiceState serviceState, ag agVar) {
        int i;
        w hN;
        boolean c2;
        boolean z = true;
        if (serviceState != null) {
            if (serviceState.getState() == 0) {
                i = 1;
            } else if (serviceState.getState() == 1) {
                i = 0;
            }
            hN = agVar.hN();
            c2 = c(hN.f1082a);
            if (hN.a()) {
                if (hN.e.getSimState() != 5) {
                    z = false;
                }
                if (!c2 || !z) {
                    i = 0;
                }
                agVar.a(2, i);
            }
            z = false;
            if (!c2) {
            }
            i = 0;
            agVar.a(2, i);
        }
        i = -1;
        hN = agVar.hN();
        c2 = c(hN.f1082a);
        if (hN.a()) {
        }
        z = false;
        if (!c2) {
        }
        i = 0;
        agVar.a(2, i);
    }

    public static void a(TelephonyManager telephonyManager, int[] iArr) {
        String networkOperator = telephonyManager == null ? null : telephonyManager.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() >= 5) {
            try {
                iArr[0] = Integer.parseInt(networkOperator.substring(0, 3));
                iArr[1] = Integer.parseInt(networkOperator.substring(3, 5));
                return;
            } catch (Throwable th) {
            }
        }
        iArr[0] = 460;
        iArr[1] = 0;
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return i2 >= 0 && i3 >= 0 && i4 >= 0 && i4 <= 65535 && i5 > 0 && i5 <= 65535 && !(i3 == 0 && i4 == 0 && i5 == 0);
        } else if (i2 < 0 || i3 < 0 || i4 <= 0 || i4 >= 65535) {
            return false;
        } else {
            if (i5 == 268435455 || i5 == Integer.MAX_VALUE || i5 == 50594049 || i5 == 65535 || i5 <= 0) {
                return false;
            }
            return i5 != 65535 && i5 > 0;
        }
    }

    public static boolean a(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        if (signalStrength == null || signalStrength2 == null) {
            return true;
        }
        int abs = Math.abs(b(i, signalStrength, signalStrength2));
        return i == 1 ? abs > 3 : i == 2 && abs > 6;
    }

    public static boolean a(z zVar) {
        if (zVar == null) {
            return false;
        }
        return a(zVar.f1085a, zVar.f1086b, zVar.c, zVar.d, zVar.e);
    }

    private static int b(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        int cdmaDbm;
        if (i != 1) {
            if (i == 2) {
                cdmaDbm = signalStrength.getCdmaDbm() - signalStrength2.getCdmaDbm();
            }
            return 0;
        }
        cdmaDbm = signalStrength.getGsmSignalStrength() - signalStrength2.getGsmSignalStrength();
        return cdmaDbm;
    }

    public static List b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                return telephonyManager.getNeighboringCellInfo();
            } catch (Throwable th) {
            }
        }
        return Collections.emptyList();
    }

    @SuppressLint({"NewApi"})
    public static List b(TelephonyManager telephonyManager) {
        if (telephonyManager != null) {
            try {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    ArrayList arrayList = new ArrayList();
                    for (CellInfo cellInfo : allCellInfo) {
                        if (cellInfo.isRegistered()) {
                            arrayList.add(z.a(telephonyManager, cellInfo));
                        }
                    }
                    return arrayList;
                }
                return null;
            } catch (Throwable th) {
            }
        }
        return null;
    }

    private void b(int i) {
        if (this.j != null) {
            this.j.obtainMessage(i).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(c cVar) {
        if (cVar.f1055b) {
            cVar.i = true;
            a(cVar.Aj, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(CellLocation cellLocation) {
        boolean z;
        if (cellLocation == null) {
            return false;
        }
        try {
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                if (gsmCellLocation.getCid() <= 0) {
                    if (gsmCellLocation.getLac() <= 0) {
                        return false;
                    }
                }
            }
        } catch (Throwable th) {
        }
        if (c(cellLocation) <= 0) {
            return false;
        }
        CellLocation cellLocation2 = this.Ah;
        if (cellLocation2 == null || cellLocation == null) {
            z = false;
        } else {
            if (cellLocation2.getClass() == cellLocation.getClass()) {
                if (cellLocation2 instanceof GsmCellLocation) {
                    z = ((GsmCellLocation) cellLocation2).getCid() == ((GsmCellLocation) cellLocation).getCid();
                } else if (cellLocation2 instanceof CdmaCellLocation) {
                    z = ((CdmaCellLocation) cellLocation2).getBaseStationId() == ((CdmaCellLocation) cellLocation).getBaseStationId();
                }
            }
            z = false;
        }
        if (z) {
            return false;
        }
        z a2 = z.a(this.d, cellLocation, null);
        return a2 == null ? true : a(a2);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0017 -> B:5:0x000a). Please submit an issue!!! */
    private static int c(CellLocation cellLocation) {
        if (cellLocation instanceof CdmaCellLocation) {
            return ((CdmaCellLocation) cellLocation).getBaseStationId();
        }
        if (cellLocation instanceof GsmCellLocation) {
            return ((GsmCellLocation) cellLocation).getCid();
        }
        return -1;
    }

    @SuppressLint({"NewApi"})
    private static boolean c(Context context) {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT < 17 ? Settings.System.getInt(context.getContentResolver(), "airplane_mode_on") == 1 : Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on") == 1) {
                z = true;
            }
        } catch (Throwable th) {
        }
        return z;
    }

    private static boolean d(CellLocation cellLocation) {
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getCid() == 0) {
                if (gsmCellLocation.getLac() == 0) {
                    return true;
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(c cVar) {
        if (cVar.f1055b) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - cVar.k > 2000) {
                cVar.k = currentTimeMillis;
                cVar.b(2);
            }
        }
    }

    @Override // b.a.a.a.a.ah
    public final void b(Handler handler) {
        this.k = 0L;
        this.j = new e(this, handler.getLooper(), (byte) 0);
        b(1);
        this.i = false;
        a(273);
        try {
            this.e = this.d != null ? this.d.getPhoneType() : 0;
        } catch (Throwable th) {
        }
    }

    @Override // b.a.a.a.a.ah
    public final void c() {
        a(0);
        if (this.j != null) {
            this.j.removeCallbacksAndMessages(null);
            this.j = null;
        }
        this.Ah = null;
        this.Ai = null;
    }

    @Override // b.a.a.a.a.ah
    public final String d() {
        return "CellPro";
    }
}
