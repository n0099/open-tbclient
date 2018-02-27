package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.SystemClock;
import android.util.Log;
/* loaded from: classes2.dex */
class b {
    private static boolean zR = true;

    /* loaded from: classes2.dex */
    interface a {
        void onSeekTo(long j);
    }

    public static Object a(a aVar) {
        return new C0006b(aVar);
    }

    public static void a(Context context, PendingIntent pendingIntent, ComponentName componentName) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (zR) {
            try {
                audioManager.registerMediaButtonEventReceiver(pendingIntent);
            } catch (NullPointerException e) {
                Log.w("MediaSessionCompatApi18", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                zR = false;
            }
        }
        if (!zR) {
            audioManager.registerMediaButtonEventReceiver(componentName);
        }
    }

    public static void b(Context context, PendingIntent pendingIntent, ComponentName componentName) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (zR) {
            audioManager.unregisterMediaButtonEventReceiver(pendingIntent);
        } else {
            audioManager.unregisterMediaButtonEventReceiver(componentName);
        }
    }

    public static void a(Object obj, int i, long j, float f, long j2) {
        long j3 = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i == 3 && j > 0) {
            if (j2 > 0) {
                j3 = elapsedRealtime - j2;
                if (f > 0.0f && f != 1.0f) {
                    j3 = ((float) j3) * f;
                }
            }
            j += j3;
        }
        ((RemoteControlClient) obj).setPlaybackState(android.support.v4.media.session.a.ap(i), j, f);
    }

    public static void a(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(m(j));
    }

    public static void g(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener) obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(long j) {
        int m = android.support.v4.media.session.a.m(j);
        if ((256 & j) != 0) {
            return m | 256;
        }
        return m;
    }

    /* renamed from: android.support.v4.media.session.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0006b<T extends a> implements RemoteControlClient.OnPlaybackPositionUpdateListener {
        protected final T zS;

        public C0006b(T t) {
            this.zS = t;
        }

        @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
        public void onPlaybackPositionUpdate(long j) {
            this.zS.onSeekTo(j);
        }
    }
}
