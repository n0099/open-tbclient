package com.baidu.cloudsdk.common.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import com.k;
import com.l;
/* loaded from: classes.dex */
public class CoordinateManager {
    private static final String a = CoordinateManager.class.getSimpleName();
    private LocationManager b;
    private Location c;
    private a d;
    private Handler e = new Handler();

    /* loaded from: classes.dex */
    public class a extends AsyncTask {
        private String b;
        private Location c;
        private LocationListener d = new l(this);

        public a(String str) {
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (this.c == null && !isCancelled()) {
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r3) {
            if (this.d != null) {
                CoordinateManager.this.b.removeUpdates(this.d);
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            if (this.d != null) {
                CoordinateManager.this.b.removeUpdates(this.d);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            CoordinateManager.this.b.requestLocationUpdates(this.b, 10000L, 0.0f, this.d);
        }
    }

    public CoordinateManager(Context context) {
        Validator.notNull(context, "context");
        this.b = (LocationManager) context.getApplicationContext().getSystemService("location");
    }

    private Location a() {
        if (!a(this.c)) {
            this.c = b();
        }
        return this.c;
    }

    private static boolean a(Location location) {
        return location != null && System.currentTimeMillis() - location.getTime() < 300000;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Location b() {
        IllegalArgumentException illegalArgumentException;
        boolean z;
        boolean z2;
        Location lastKnownLocation;
        boolean z3;
        Location location;
        boolean z4;
        Location location2 = null;
        try {
            if (this.b.isProviderEnabled("network")) {
                try {
                    lastKnownLocation = this.b.getLastKnownLocation("network");
                    z3 = true;
                } catch (IllegalArgumentException e) {
                    illegalArgumentException = e;
                    z = false;
                    z2 = true;
                    Log.e(a, illegalArgumentException.getMessage());
                    if (!a(location2)) {
                    }
                    return location2;
                }
            } else {
                lastKnownLocation = null;
                z3 = false;
            }
            try {
            } catch (IllegalArgumentException e2) {
                illegalArgumentException = e2;
                z = false;
                boolean z5 = z3;
                location2 = lastKnownLocation;
                z2 = z5;
            }
        } catch (IllegalArgumentException e3) {
            illegalArgumentException = e3;
            z = false;
            z2 = false;
        }
        if (!a(lastKnownLocation)) {
            if (this.b.isProviderEnabled("gps")) {
                try {
                    location = this.b.getLastKnownLocation("gps");
                    z4 = true;
                    boolean z6 = z3;
                    location2 = location;
                    z = z4;
                    z2 = z6;
                } catch (IllegalArgumentException e4) {
                    illegalArgumentException = e4;
                    z = true;
                    boolean z7 = z3;
                    location2 = lastKnownLocation;
                    z2 = z7;
                    Log.e(a, illegalArgumentException.getMessage());
                    if (!a(location2)) {
                    }
                    return location2;
                }
                if (!a(location2) && (z2 || z)) {
                    String str = !z2 ? "network" : "gps";
                    if (this.d != null && this.d.getStatus() != AsyncTask.Status.FINISHED) {
                        this.d.cancel(true);
                    }
                    this.d = new a(str);
                    this.d.execute(new Void[0]);
                    this.e.postDelayed(new k(this), 3000L);
                }
                return location2;
            }
        }
        location = lastKnownLocation;
        z4 = false;
        boolean z62 = z3;
        location2 = location;
        z = z4;
        z2 = z62;
        if (!a(location2)) {
            if (!z2) {
            }
            if (this.d != null) {
                this.d.cancel(true);
            }
            this.d = new a(str);
            this.d.execute(new Void[0]);
            this.e.postDelayed(new k(this), 3000L);
        }
        return location2;
    }

    public String getCrd() {
        StringBuilder sb = new StringBuilder();
        Location a2 = a();
        if (a2 != null) {
            sb.append(a2.getLongitude());
            sb.append("_");
            sb.append(a2.getLatitude());
            sb.append("_");
            sb.append(a2.getAccuracy());
            sb.append("_");
            sb.append(a2.getTime());
        }
        return sb.toString();
    }
}
