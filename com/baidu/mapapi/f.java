package com.baidu.mapapi;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.util.Log;
import com.baidu.zeus.Headers;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f {
    private Context d;
    private GpsStatus g;
    private LocationManager b = null;
    private android.location.LocationListener c = null;
    Location a = null;
    private a e = null;
    private int f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements GpsStatus.Listener {
        private a() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            switch (i) {
                case 2:
                    Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                    return;
                case 3:
                default:
                    return;
                case 4:
                    if (f.this.b == null) {
                        f.this.b = (LocationManager) f.this.d.getSystemService(Headers.LOCATION);
                    }
                    if (f.this.b != null) {
                        if (f.this.g == null) {
                            f.this.g = f.this.b.getGpsStatus(null);
                        } else {
                            f.this.b.getGpsStatus(f.this.g);
                        }
                    }
                    int i2 = 0;
                    for (GpsSatellite gpsSatellite : f.this.g.getSatellites()) {
                        i2 = gpsSatellite.usedInFix() ? i2 + 1 : i2;
                    }
                    if (i2 < 3 && f.this.f >= 3) {
                        Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                    }
                    f.this.f = i2;
                    return;
            }
        }
    }

    public f(Context context) {
        this.d = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(int i, int i2, int i3, int i4, List list, String str) {
        return (i3 == 0 || i4 == 0) ? "" : str.concat(String.format("%d|%d|%d|%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    public String a(List list, String str) {
        String concat;
        String str2 = "";
        int size = list.size();
        if (list.size() > 10) {
            size = 10;
        }
        int i = 0;
        while (i < size) {
            if (i == 0) {
                concat = ((ScanResult) list.get(i)).level == 0 ? str2 : str2.concat(((ScanResult) list.get(i)).BSSID.replace(":", "")).concat(String.format(";%d;", Integer.valueOf(((ScanResult) list.get(i)).level))).concat(((ScanResult) list.get(i)).SSID);
            } else if (((ScanResult) list.get(i)).level == 0) {
                break;
            } else {
                concat = str2.concat("|").concat(((ScanResult) list.get(i)).BSSID.replace(":", "")).concat(String.format(";%d;", Integer.valueOf(((ScanResult) list.get(i)).level))).concat(((ScanResult) list.get(i)).SSID);
            }
            i++;
            str2 = concat;
        }
        return str2;
    }

    void a() {
        if (this.d == null) {
            return;
        }
        Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
        if (this.c == null) {
            this.c = new android.location.LocationListener() { // from class: com.baidu.mapapi.f.1
                @Override // android.location.LocationListener
                public void onLocationChanged(Location location) {
                    if (location != null) {
                        Bundle extras = location.getExtras();
                        Mj.UpdataGPS(location.getLongitude(), location.getLatitude(), (float) (location.getSpeed() * 3.6d), location.getBearing(), location.hasAccuracy() ? location.getAccuracy() : 0.0f, extras != null ? extras.getInt("NumSatellite", 0) : 0);
                        f.this.a = location;
                    }
                }

                @Override // android.location.LocationListener
                public void onProviderDisabled(String str) {
                    Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                    f.this.a = null;
                }

                @Override // android.location.LocationListener
                public void onProviderEnabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onStatusChanged(String str, int i, Bundle bundle) {
                    switch (i) {
                        case 0:
                        case 1:
                            Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                            f.this.a = null;
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        if (this.b == null) {
            this.b = (LocationManager) this.d.getSystemService(Headers.LOCATION);
        }
        if (this.b != null) {
            try {
                this.b.requestLocationUpdates("gps", 1000L, 0.0f, this.c);
                this.e = new a();
                this.b.addGpsStatusListener(this.e);
            } catch (Exception e) {
                Log.d("InitGPS", e.getMessage());
            }
        }
    }

    public void a(int i, int i2, long j) {
        switch (i) {
            case 5000:
                if (i2 == 1) {
                    a();
                    return;
                } else {
                    b();
                    return;
                }
            default:
                return;
        }
    }

    public void a(List list) {
        boolean z;
        boolean z2 = true;
        for (int size = list.size() - 1; size >= 1 && z2; size--) {
            int i = 0;
            z2 = false;
            while (i < size) {
                if (((ScanResult) list.get(i)).level < ((ScanResult) list.get(i + 1)).level) {
                    list.set(i + 1, list.get(i));
                    list.set(i, (ScanResult) list.get(i + 1));
                    z = true;
                } else {
                    z = z2;
                }
                i++;
                z2 = z;
            }
        }
    }

    public boolean a(List list, List list2) {
        int i;
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
        if (size == 0 || size2 == 0) {
            return false;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            String str = ((ScanResult) list.get(i2)).BSSID;
            if (str != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        i = i3;
                        break;
                    } else if (str.equals(((ScanResult) list2.get(i4)).BSSID)) {
                        i = i3 + 1;
                        break;
                    } else {
                        i4++;
                    }
                }
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        return i3 >= size / 2;
    }

    public String b(List list, String str) {
        String concat;
        String str2 = "";
        int size = list.size();
        if (list.size() > 10) {
            size = 10;
        }
        int i = 0;
        while (i < size) {
            if (i == 0) {
                concat = ((ScanResult) list.get(i)).level == 0 ? str2 : str2.concat(((ScanResult) list.get(i)).BSSID.replace(":", ""));
            } else if (((ScanResult) list.get(i)).level == 0) {
                break;
            } else {
                concat = str2.concat("|").concat(((ScanResult) list.get(i)).BSSID.replace(":", ""));
            }
            i++;
            str2 = concat;
        }
        return str2;
    }

    void b() {
        try {
            if (this.b != null) {
                this.b.removeUpdates(this.c);
            }
        } catch (Exception e) {
            Log.d("UnInitGPS", e.getMessage());
        }
        Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
    }
}
