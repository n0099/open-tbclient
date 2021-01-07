package b.a.a.a.a;

import android.net.wifi.ScanResult;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public final class af extends ac {
    public static final af Bl = new af(Collections.emptyList(), 0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final List f1054b;
    public final long c;
    private final int d;

    public af(List list, long j, int i) {
        this.c = j;
        this.d = i;
        this.f1054b = new ArrayList(list);
    }

    private static String a(List list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            ScanResult scanResult = (ScanResult) list.get(i2);
            String str = scanResult.BSSID + ETAG.ITEM_SEPARATOR + scanResult.level + ETAG.ITEM_SEPARATOR + scanResult.SSID.replaceAll("[& ,|]", "");
            if (i2 != 0) {
                sb.append('|');
            }
            sb.append(str);
            if (i2 == 2) {
                sb.append("|...");
                break;
            }
            i = i2 + 1;
        }
        return sb.toString();
    }

    public static boolean a(List list, List list2) {
        boolean z = false;
        if (list == null || list2 == null) {
            return true;
        }
        if (list != list2) {
            int size = list.size();
            int size2 = list2.size();
            if (size == 0 && size2 == 0) {
                return false;
            }
            if (size == 0 || size2 == 0) {
                return true;
            }
            List<ScanResult> list3 = list.size() > list2.size() ? list2 : list;
            if (list3 == list2) {
                list2 = list;
            }
            int i = 0;
            int i2 = 0;
            for (ScanResult scanResult : list3) {
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ScanResult scanResult2 = (ScanResult) it.next();
                    if (scanResult2.BSSID.equals(scanResult.BSSID)) {
                        i++;
                        if (scanResult2.level == scanResult.level) {
                            i2++;
                        }
                    }
                }
                i = i;
            }
            if (size == size2 && i2 == size) {
                return false;
            }
            int i3 = size + size2;
            z = ((i << 1) < i3 * 0.85d || i <= 5) ? true : true;
            new StringBuilder("isDiffrent:l1=").append(size).append(",f=").append(i3).append(",c_m=").append(i).append(",c_mr=").append(i2).append(",d=").append(z);
            return z;
        }
        return false;
    }

    public final String toString() {
        return "TxWifiInfo[time=" + this.c + ", wifiStatus=" + this.d + ", size=" + this.f1054b.size() + ", list=" + a(this.f1054b) + "]";
    }
}
