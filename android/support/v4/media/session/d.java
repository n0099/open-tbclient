package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.session.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
class d {

    /* loaded from: classes2.dex */
    interface a extends c.a {
        void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void onCustomAction(String str, Bundle bundle);

        void onFastForward();

        boolean onMediaButtonEvent(Intent intent);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String str, Bundle bundle);

        void onPlayFromSearch(String str, Bundle bundle);

        void onRewind();

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long j);

        void onStop();
    }

    public static Object F(Context context, String str) {
        return new MediaSession(context, str);
    }

    public static Object R(Object obj) {
        if (obj instanceof MediaSession) {
            return obj;
        }
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static Object S(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }

    public static void b(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((MediaSession.Callback) obj2, handler);
    }

    public static void e(Object obj, int i) {
        ((MediaSession) obj).setFlags(i);
    }

    public static void f(Object obj, int i) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i);
        ((MediaSession) obj).setPlaybackToLocal(builder.build());
    }

    public static void i(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
    }

    public static void a(Object obj, boolean z) {
        ((MediaSession) obj).setActive(z);
    }

    public static boolean isActive(Object obj) {
        return ((MediaSession) obj).isActive();
    }

    public static void b(Object obj, String str, Bundle bundle) {
        ((MediaSession) obj).sendSessionEvent(str, bundle);
    }

    public static void T(Object obj) {
        ((MediaSession) obj).release();
    }

    public static Parcelable U(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }

    public static void j(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }

    public static void k(Object obj, Object obj2) {
        ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
    }

    public static void a(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setSessionActivity(pendingIntent);
    }

    public static void b(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setMediaButtonReceiver(pendingIntent);
    }

    public static void a(Object obj, List<Object> list) {
        if (list == null) {
            ((MediaSession) obj).setQueue(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((MediaSession.QueueItem) it.next());
        }
        ((MediaSession) obj).setQueue(arrayList);
    }

    public static void d(Object obj, CharSequence charSequence) {
        ((MediaSession) obj).setQueueTitle(charSequence);
    }

    public static void a(Object obj, Bundle bundle) {
        ((MediaSession) obj).setExtras(bundle);
    }

    /* loaded from: classes2.dex */
    static class b<T extends a> extends MediaSession.Callback {
        protected final T zZ;

        public b(T t) {
            this.zZ = t;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.zZ.onCommand(str, bundle, resultReceiver);
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent intent) {
            return this.zZ.onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            this.zZ.onPlay();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String str, Bundle bundle) {
            this.zZ.onPlayFromMediaId(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String str, Bundle bundle) {
            this.zZ.onPlayFromSearch(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long j) {
            this.zZ.onSkipToQueueItem(j);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            this.zZ.onPause();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            this.zZ.onSkipToNext();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            this.zZ.onSkipToPrevious();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            this.zZ.onFastForward();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            this.zZ.onRewind();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            this.zZ.onStop();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j) {
            this.zZ.onSeekTo(j);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating rating) {
            this.zZ.Q(rating);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String str, Bundle bundle) {
            this.zZ.onCustomAction(str, bundle);
        }
    }

    /* loaded from: classes2.dex */
    static class c {
        public static Object b(Object obj, long j) {
            return new MediaSession.QueueItem((MediaDescription) obj, j);
        }

        public static Object r(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        public static long V(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }
    }
}
