package com.baidu.cloudsdk.common.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Handler;
import com.m;
import com.n;
/* loaded from: classes.dex */
public class PositionManager {
    private LocationManager a;
    private Location b;
    private a c;
    private boolean d;
    private Handler e = new Handler();

    /* loaded from: classes.dex */
    public interface IPositionManagerListener {
        void onComplete(Location location);

        void onFailed();
    }

    /* loaded from: classes.dex */
    public class a extends AsyncTask {
        private String b;
        private IPositionManagerListener c;
        private LocationListener d = new n(this);

        public a(String str, IPositionManagerListener iPositionManagerListener) {
            this.b = str;
            this.c = iPositionManagerListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            while (PositionManager.this.b == null && !isCancelled()) {
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            PositionManager.this.d = false;
            if (this.d != null) {
                PositionManager.this.a.removeUpdates(this.d);
            }
            if (this.c != null) {
                if (PositionManager.b(PositionManager.this.b)) {
                    this.c.onComplete(PositionManager.this.b);
                } else {
                    this.c.onFailed();
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            PositionManager.this.d = false;
            if (this.d != null) {
                PositionManager.this.a.removeUpdates(this.d);
            }
            if (this.c != null) {
                this.c.onFailed();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            PositionManager.this.d = true;
            PositionManager.this.a.requestLocationUpdates(this.b, 10000L, 0.0f, this.d);
        }
    }

    public PositionManager(Context context) {
        Validator.notNull(context, "context");
        this.a = (LocationManager) context.getApplicationContext().getSystemService("location");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Location location) {
        return location != null && System.currentTimeMillis() - location.getTime() < 60000;
    }

    public boolean isRunning() {
        return this.d;
    }

    public void requestLoation(IPositionManagerListener iPositionManagerListener) {
        Location location;
        boolean z;
        Location location2;
        boolean z2;
        Location location3 = this.b;
        if (b(location3) || !this.a.isProviderEnabled("network")) {
            location = location3;
            z = false;
        } else {
            location = this.a.getLastKnownLocation("network");
            z = true;
        }
        if (b(location) || !this.a.isProviderEnabled("gps")) {
            location2 = location;
            z2 = false;
        } else {
            location2 = this.a.getLastKnownLocation("gps");
            z2 = true;
        }
        if (b(location2)) {
            this.b = location2;
            if (iPositionManagerListener != null) {
                iPositionManagerListener.onComplete(location2);
            }
        } else if (!z && !z2) {
            if (iPositionManagerListener != null) {
                iPositionManagerListener.onFailed();
            }
        } else {
            String str = z ? "network" : "gps";
            if (this.c != null && this.c.getStatus() != AsyncTask.Status.FINISHED) {
                this.c.cancel(true);
            }
            this.c = new a(str, iPositionManagerListener);
            this.c.execute(new Void[0]);
            this.e.postDelayed(new m(this), 3000L);
        }
    }
}
