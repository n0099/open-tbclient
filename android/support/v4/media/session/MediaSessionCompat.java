package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.TransportMediator;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompatApi23;
import android.support.v4.media.session.MediaSessionCompatApi24;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.c;
import android.support.v4.media.session.d;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class MediaSessionCompat {
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    static int zo;
    private final a zl;
    private final MediaControllerCompat zm;
    private final ArrayList<OnActiveChangeListener> zn;

    /* loaded from: classes2.dex */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface SessionFlags {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        String getCallingPackage();

        Object getMediaSession();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(Callback callback, Handler handler);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setSessionActivity(PendingIntent pendingIntent);
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, null, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this.zn = new ArrayList<>();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.zl = new b(context, str);
        } else {
            this.zl = new c(context, str, componentName, pendingIntent);
        }
        this.zm = new MediaControllerCompat(context, this);
        if (zo == 0) {
            zo = (int) TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics());
        }
    }

    private MediaSessionCompat(Context context, a aVar) {
        this.zn = new ArrayList<>();
        this.zl = aVar;
        this.zm = new MediaControllerCompat(context, this);
    }

    public void setCallback(Callback callback) {
        setCallback(callback, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        a aVar = this.zl;
        if (handler == null) {
            handler = new Handler();
        }
        aVar.setCallback(callback, handler);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.zl.setSessionActivity(pendingIntent);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.zl.setMediaButtonReceiver(pendingIntent);
    }

    public void setFlags(int i) {
        this.zl.setFlags(i);
    }

    public void setPlaybackToLocal(int i) {
        this.zl.setPlaybackToLocal(i);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.zl.setPlaybackToRemote(volumeProviderCompat);
    }

    public void setActive(boolean z) {
        this.zl.setActive(z);
        Iterator<OnActiveChangeListener> it = this.zn.iterator();
        while (it.hasNext()) {
            it.next().onActiveChanged();
        }
    }

    public boolean isActive() {
        return this.zl.isActive();
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.zl.sendSessionEvent(str, bundle);
    }

    public void release() {
        this.zl.release();
    }

    public Token getSessionToken() {
        return this.zl.getSessionToken();
    }

    public MediaControllerCompat getController() {
        return this.zm;
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.zl.setPlaybackState(playbackStateCompat);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.zl.setMetadata(mediaMetadataCompat);
    }

    public void setQueue(List<QueueItem> list) {
        this.zl.setQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.zl.setQueueTitle(charSequence);
    }

    public void setRatingType(int i) {
        this.zl.setRatingType(i);
    }

    public void setExtras(Bundle bundle) {
        this.zl.setExtras(bundle);
    }

    public Object getMediaSession() {
        return this.zl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.zl.getRemoteControlClient();
    }

    @RestrictTo
    public String getCallingPackage() {
        return this.zl.getCallingPackage();
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.zn.add(onActiveChangeListener);
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.zn.remove(onActiveChangeListener);
    }

    @Deprecated
    public static MediaSessionCompat obtain(Context context, Object obj) {
        return fromMediaSession(context, obj);
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        if (context == null || obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return new MediaSessionCompat(context, new b(obj));
    }

    /* loaded from: classes2.dex */
    public static abstract class Callback {
        final Object yZ;

        public Callback() {
            if (Build.VERSION.SDK_INT >= 24) {
                this.yZ = MediaSessionCompatApi24.a(new c());
            } else if (Build.VERSION.SDK_INT >= 23) {
                this.yZ = MediaSessionCompatApi23.a(new b());
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.yZ = d.a(new a());
            } else {
                this.yZ = null;
            }
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            return false;
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onPause() {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onFastForward() {
        }

        public void onRewind() {
        }

        public void onStop() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        /* loaded from: classes2.dex */
        private class a implements d.a {
            a() {
            }

            @Override // android.support.v4.media.session.d.a
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                Callback.this.onCommand(str, bundle, resultReceiver);
            }

            @Override // android.support.v4.media.session.d.a
            public boolean onMediaButtonEvent(Intent intent) {
                return Callback.this.onMediaButtonEvent(intent);
            }

            @Override // android.support.v4.media.session.d.a
            public void onPlay() {
                Callback.this.onPlay();
            }

            @Override // android.support.v4.media.session.d.a
            public void onPlayFromMediaId(String str, Bundle bundle) {
                Callback.this.onPlayFromMediaId(str, bundle);
            }

            @Override // android.support.v4.media.session.d.a
            public void onPlayFromSearch(String str, Bundle bundle) {
                Callback.this.onPlayFromSearch(str, bundle);
            }

            @Override // android.support.v4.media.session.d.a
            public void onSkipToQueueItem(long j) {
                Callback.this.onSkipToQueueItem(j);
            }

            @Override // android.support.v4.media.session.d.a
            public void onPause() {
                Callback.this.onPause();
            }

            @Override // android.support.v4.media.session.d.a
            public void onSkipToNext() {
                Callback.this.onSkipToNext();
            }

            @Override // android.support.v4.media.session.d.a
            public void onSkipToPrevious() {
                Callback.this.onSkipToPrevious();
            }

            @Override // android.support.v4.media.session.d.a
            public void onFastForward() {
                Callback.this.onFastForward();
            }

            @Override // android.support.v4.media.session.d.a
            public void onRewind() {
                Callback.this.onRewind();
            }

            @Override // android.support.v4.media.session.d.a
            public void onStop() {
                Callback.this.onStop();
            }

            @Override // android.support.v4.media.session.b.a
            public void onSeekTo(long j) {
                Callback.this.onSeekTo(j);
            }

            @Override // android.support.v4.media.session.c.a
            public void Q(Object obj) {
                Callback.this.onSetRating(RatingCompat.fromRating(obj));
            }

            @Override // android.support.v4.media.session.d.a
            public void onCustomAction(String str, Bundle bundle) {
                if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                    Callback.this.onPlayFromUri((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), (Bundle) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                    Callback.this.onPrepare();
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                    Callback.this.onPrepareFromMediaId(bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                    Callback.this.onPrepareFromSearch(bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY"), bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                    Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    Callback.this.onPrepareFromUri((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle2);
                } else {
                    Callback.this.onCustomAction(str, bundle);
                }
            }
        }

        /* loaded from: classes2.dex */
        private class b extends a implements MediaSessionCompatApi23.Callback {
            b() {
                super();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPlayFromUri(uri, bundle);
            }
        }

        /* loaded from: classes2.dex */
        private class c extends b implements MediaSessionCompatApi24.Callback {
            c() {
                super();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepare() {
                Callback.this.onPrepare();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                Callback.this.onPrepareFromMediaId(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromSearch(String str, Bundle bundle) {
                Callback.this.onPrepareFromSearch(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPrepareFromUri(uri, bundle);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() { // from class: android.support.v4.media.session.MediaSessionCompat.Token.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: k */
            public Token createFromParcel(Parcel parcel) {
                Object readStrongBinder;
                if (Build.VERSION.SDK_INT >= 21) {
                    readStrongBinder = parcel.readParcelable(null);
                } else {
                    readStrongBinder = parcel.readStrongBinder();
                }
                return new Token(readStrongBinder);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ao */
            public Token[] newArray(int i) {
                return new Token[i];
            }
        };
        private final Object zQ;

        Token(Object obj) {
            this.zQ = obj;
        }

        public static Token fromToken(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(d.S(obj));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.zQ, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.zQ);
            }
        }

        public int hashCode() {
            if (this.zQ == null) {
                return 0;
            }
            return this.zQ.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Token) {
                Token token = (Token) obj;
                if (this.zQ == null) {
                    return token.zQ == null;
                } else if (token.zQ == null) {
                    return false;
                } else {
                    return this.zQ.equals(token.zQ);
                }
            }
            return false;
        }

        public Object getToken() {
            return this.zQ;
        }
    }

    /* loaded from: classes2.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() { // from class: android.support.v4.media.session.MediaSessionCompat.QueueItem.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: i */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: am */
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };
        public static final int UNKNOWN_ID = -1;
        private final long mId;
        private final MediaDescriptionCompat xs;
        private Object zO;

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this(null, mediaDescriptionCompat, j);
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.xs = mediaDescriptionCompat;
            this.mId = j;
            this.zO = obj;
        }

        QueueItem(Parcel parcel) {
            this.xs = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        public MediaDescriptionCompat getDescription() {
            return this.xs;
        }

        public long getQueueId() {
            return this.mId;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.xs.writeToParcel(parcel, i);
            parcel.writeLong(this.mId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Object getQueueItem() {
            if (this.zO != null || Build.VERSION.SDK_INT < 21) {
                return this.zO;
            }
            this.zO = d.c.b(this.xs.getMediaDescription(), this.mId);
            return this.zO;
        }

        @Deprecated
        public static QueueItem obtain(Object obj) {
            return fromQueueItem(obj);
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(d.c.r(obj)), d.c.V(obj));
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromQueueItem(it.next()));
            }
            return arrayList;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.xs + ", Id=" + this.mId + " }";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() { // from class: android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: j */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: an */
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };
        private ResultReceiver zP;

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.zP = resultReceiver;
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.zP = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.zP.writeToParcel(parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c implements a {
        final AudioManager mAudioManager;
        private final Context mContext;
        Bundle mExtras;
        int mFlags;
        final String mPackageName;
        final String mTag;
        private final Token yY;
        volatile Callback zB;
        MediaMetadataCompat zC;
        PlaybackStateCompat zD;
        PendingIntent zE;
        List<QueueItem> zF;
        CharSequence zG;
        int zH;
        int zI;
        int zJ;
        VolumeProviderCompat zK;
        private final ComponentName zs;
        private final PendingIntent zt;
        private final Object zu;
        private final b zv;
        private HandlerC0005c zx;
        final Object mLock = new Object();
        final RemoteCallbackList<IMediaControllerCallback> zw = new RemoteCallbackList<>();
        boolean mDestroyed = false;
        private boolean zy = false;
        private boolean zz = false;
        private boolean zA = false;
        private VolumeProviderCompat.Callback zL = new VolumeProviderCompat.Callback() { // from class: android.support.v4.media.session.MediaSessionCompat.c.1
            @Override // android.support.v4.media.VolumeProviderCompat.Callback
            public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                if (c.this.zK == volumeProviderCompat) {
                    c.this.a(new ParcelableVolumeInfo(c.this.zI, c.this.zJ, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
                }
            }
        };

        public c(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            if (componentName == null && (componentName = MediaButtonReceiver.getMediaButtonReceiverComponent(context)) == null) {
                Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
            }
            if (componentName != null && pendingIntent == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            }
            if (componentName == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }
            this.mContext = context;
            this.mPackageName = context.getPackageName();
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
            this.mTag = str;
            this.zs = componentName;
            this.zt = pendingIntent;
            this.zv = new b();
            this.yY = new Token(this.zv);
            this.zH = 0;
            this.zI = 1;
            this.zJ = 3;
            if (Build.VERSION.SDK_INT >= 14) {
                this.zu = android.support.v4.media.session.a.b(pendingIntent);
            } else {
                this.zu = null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setCallback(Callback callback, Handler handler) {
            this.zB = callback;
            if (callback == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    android.support.v4.media.session.b.g(this.zu, null);
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    android.support.v4.media.session.c.h(this.zu, null);
                    return;
                }
                return;
            }
            if (handler == null) {
                handler = new Handler();
            }
            synchronized (this.mLock) {
                this.zx = new HandlerC0005c(handler.getLooper());
            }
            c.a aVar = new c.a() { // from class: android.support.v4.media.session.MediaSessionCompat.c.2
                @Override // android.support.v4.media.session.c.a
                public void Q(Object obj) {
                    c.this.b(19, RatingCompat.fromRating(obj));
                }

                @Override // android.support.v4.media.session.b.a
                public void onSeekTo(long j) {
                    c.this.b(18, Long.valueOf(j));
                }
            };
            if (Build.VERSION.SDK_INT >= 18) {
                android.support.v4.media.session.b.g(this.zu, android.support.v4.media.session.b.a(aVar));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                android.support.v4.media.session.c.h(this.zu, android.support.v4.media.session.c.a(aVar));
            }
        }

        void al(int i) {
            b(i, null);
        }

        void b(int i, Object obj) {
            b(i, obj, null);
        }

        void b(int i, Object obj, Bundle bundle) {
            synchronized (this.mLock) {
                if (this.zx != null) {
                    this.zx.a(i, obj, bundle);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setFlags(int i) {
            synchronized (this.mLock) {
                this.mFlags = i;
            }
            dB();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setPlaybackToLocal(int i) {
            if (this.zK != null) {
                this.zK.setCallback(null);
            }
            this.zI = 1;
            a(new ParcelableVolumeInfo(this.zI, this.zJ, 2, this.mAudioManager.getStreamMaxVolume(this.zJ), this.mAudioManager.getStreamVolume(this.zJ)));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            if (this.zK != null) {
                this.zK.setCallback(null);
            }
            this.zI = 2;
            this.zK = volumeProviderCompat;
            a(new ParcelableVolumeInfo(this.zI, this.zJ, this.zK.getVolumeControl(), this.zK.getMaxVolume(), this.zK.getCurrentVolume()));
            volumeProviderCompat.setCallback(this.zL);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setActive(boolean z) {
            if (z != this.zy) {
                this.zy = z;
                if (dB()) {
                    setMetadata(this.zC);
                    setPlaybackState(this.zD);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public boolean isActive() {
            return this.zy;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void sendSessionEvent(String str, Bundle bundle) {
            a(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void release() {
            this.zy = false;
            this.mDestroyed = true;
            dB();
            dD();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public Token getSessionToken() {
            return this.yY;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                this.zD = playbackStateCompat;
            }
            a(playbackStateCompat);
            if (this.zy) {
                if (playbackStateCompat == null) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        android.support.v4.media.session.a.d(this.zu, 0);
                        android.support.v4.media.session.a.a(this.zu, 0L);
                        return;
                    }
                    return;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    android.support.v4.media.session.b.a(this.zu, playbackStateCompat.getState(), playbackStateCompat.getPosition(), playbackStateCompat.getPlaybackSpeed(), playbackStateCompat.getLastPositionUpdateTime());
                } else if (Build.VERSION.SDK_INT >= 14) {
                    android.support.v4.media.session.a.d(this.zu, playbackStateCompat.getState());
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    android.support.v4.media.session.c.a(this.zu, playbackStateCompat.getActions());
                } else if (Build.VERSION.SDK_INT >= 18) {
                    android.support.v4.media.session.b.a(this.zu, playbackStateCompat.getActions());
                } else if (Build.VERSION.SDK_INT >= 14) {
                    android.support.v4.media.session.a.a(this.zu, playbackStateCompat.getActions());
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.Builder(mediaMetadataCompat, MediaSessionCompat.zo).build();
            }
            synchronized (this.mLock) {
                this.zC = mediaMetadataCompat;
            }
            a(mediaMetadataCompat);
            if (this.zy) {
                if (Build.VERSION.SDK_INT >= 19) {
                    android.support.v4.media.session.c.a(this.zu, mediaMetadataCompat != null ? mediaMetadataCompat.getBundle() : null, this.zD == null ? 0L : this.zD.getActions());
                } else if (Build.VERSION.SDK_INT >= 14) {
                    android.support.v4.media.session.a.b(this.zu, mediaMetadataCompat != null ? mediaMetadataCompat.getBundle() : null);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setSessionActivity(PendingIntent pendingIntent) {
            synchronized (this.mLock) {
                this.zE = pendingIntent;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setQueue(List<QueueItem> list) {
            this.zF = list;
            i(list);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setQueueTitle(CharSequence charSequence) {
            this.zG = charSequence;
            c(charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public Object getMediaSession() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public Object getRemoteControlClient() {
            return this.zu;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public String getCallingPackage() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setRatingType(int i) {
            this.zH = i;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
            h(bundle);
        }

        private boolean dB() {
            if (this.zy) {
                if (!this.zA && (this.mFlags & 1) != 0) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        android.support.v4.media.session.b.a(this.mContext, this.zt, this.zs);
                    } else {
                        ((AudioManager) this.mContext.getSystemService("audio")).registerMediaButtonEventReceiver(this.zs);
                    }
                    this.zA = true;
                } else if (this.zA && (this.mFlags & 1) == 0) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        android.support.v4.media.session.b.b(this.mContext, this.zt, this.zs);
                    } else {
                        ((AudioManager) this.mContext.getSystemService("audio")).unregisterMediaButtonEventReceiver(this.zs);
                    }
                    this.zA = false;
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    if (!this.zz && (this.mFlags & 2) != 0) {
                        android.support.v4.media.session.a.b(this.mContext, this.zu);
                        this.zz = true;
                        return true;
                    } else if (this.zz && (this.mFlags & 2) == 0) {
                        android.support.v4.media.session.a.d(this.zu, 0);
                        android.support.v4.media.session.a.c(this.mContext, this.zu);
                        this.zz = false;
                        return false;
                    }
                }
            } else {
                if (this.zA) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        android.support.v4.media.session.b.b(this.mContext, this.zt, this.zs);
                    } else {
                        ((AudioManager) this.mContext.getSystemService("audio")).unregisterMediaButtonEventReceiver(this.zs);
                    }
                    this.zA = false;
                }
                if (this.zz) {
                    android.support.v4.media.session.a.d(this.zu, 0);
                    android.support.v4.media.session.a.c(this.mContext, this.zu);
                    this.zz = false;
                }
            }
            return false;
        }

        void adjustVolume(int i, int i2) {
            if (this.zI == 2) {
                if (this.zK != null) {
                    this.zK.onAdjustVolume(i);
                    return;
                }
                return;
            }
            this.mAudioManager.adjustStreamVolume(this.zJ, i, i2);
        }

        void setVolumeTo(int i, int i2) {
            if (this.zI == 2) {
                if (this.zK != null) {
                    this.zK.onSetVolumeTo(i);
                    return;
                }
                return;
            }
            this.mAudioManager.setStreamVolume(this.zJ, i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        PlaybackStateCompat dC() {
            PlaybackStateCompat playbackStateCompat;
            PlaybackStateCompat playbackStateCompat2;
            long j = -1;
            synchronized (this.mLock) {
                playbackStateCompat = this.zD;
                if (this.zC != null && this.zC.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                    j = this.zC.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
                }
            }
            if (playbackStateCompat != null && (playbackStateCompat.getState() == 3 || playbackStateCompat.getState() == 4 || playbackStateCompat.getState() == 5)) {
                long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (lastPositionUpdateTime > 0) {
                    long playbackSpeed = (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - lastPositionUpdateTime))) + playbackStateCompat.getPosition();
                    if (j < 0 || playbackSpeed <= j) {
                        j = playbackSpeed < 0 ? 0L : playbackSpeed;
                    }
                    PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder(playbackStateCompat);
                    builder.setState(playbackStateCompat.getState(), j, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime);
                    playbackStateCompat2 = builder.build();
                    return playbackStateCompat2 != null ? playbackStateCompat : playbackStateCompat2;
                }
            }
            playbackStateCompat2 = null;
            if (playbackStateCompat2 != null) {
            }
        }

        void a(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int beginBroadcast = this.zw.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.zw.getBroadcastItem(beginBroadcast).onVolumeInfoChanged(parcelableVolumeInfo);
                } catch (RemoteException e) {
                }
            }
            this.zw.finishBroadcast();
        }

        private void dD() {
            for (int beginBroadcast = this.zw.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.zw.getBroadcastItem(beginBroadcast).onSessionDestroyed();
                } catch (RemoteException e) {
                }
            }
            this.zw.finishBroadcast();
            this.zw.kill();
        }

        private void a(String str, Bundle bundle) {
            for (int beginBroadcast = this.zw.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.zw.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                } catch (RemoteException e) {
                }
            }
            this.zw.finishBroadcast();
        }

        private void a(PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.zw.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.zw.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException e) {
                }
            }
            this.zw.finishBroadcast();
        }

        private void a(MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.zw.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.zw.getBroadcastItem(beginBroadcast).onMetadataChanged(mediaMetadataCompat);
                } catch (RemoteException e) {
                }
            }
            this.zw.finishBroadcast();
        }

        private void i(List<QueueItem> list) {
            for (int beginBroadcast = this.zw.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.zw.getBroadcastItem(beginBroadcast).onQueueChanged(list);
                } catch (RemoteException e) {
                }
            }
            this.zw.finishBroadcast();
        }

        private void c(CharSequence charSequence) {
            for (int beginBroadcast = this.zw.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.zw.getBroadcastItem(beginBroadcast).onQueueTitleChanged(charSequence);
                } catch (RemoteException e) {
                }
            }
            this.zw.finishBroadcast();
        }

        private void h(Bundle bundle) {
            for (int beginBroadcast = this.zw.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.zw.getBroadcastItem(beginBroadcast).onExtrasChanged(bundle);
                } catch (RemoteException e) {
                }
            }
            this.zw.finishBroadcast();
        }

        /* loaded from: classes2.dex */
        class b extends IMediaSession.Stub {
            b() {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                c.this.b(1, new a(str, bundle, resultReceiverWrapper.zP));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent) {
                boolean z = (c.this.mFlags & 1) != 0;
                if (z) {
                    c.this.b(21, keyEvent);
                }
                return z;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (c.this.mDestroyed) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                c.this.zw.register(iMediaControllerCallback);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                c.this.zw.unregister(iMediaControllerCallback);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                return c.this.mPackageName;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                return c.this.mTag;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                synchronized (c.this.mLock) {
                    pendingIntent = c.this.zE;
                }
                return pendingIntent;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                long j;
                synchronized (c.this.mLock) {
                    j = c.this.mFlags;
                }
                return j;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                int i;
                int i2;
                int streamMaxVolume;
                int streamVolume;
                int i3 = 2;
                synchronized (c.this.mLock) {
                    i = c.this.zI;
                    i2 = c.this.zJ;
                    VolumeProviderCompat volumeProviderCompat = c.this.zK;
                    if (i == 2) {
                        i3 = volumeProviderCompat.getVolumeControl();
                        streamMaxVolume = volumeProviderCompat.getMaxVolume();
                        streamVolume = volumeProviderCompat.getCurrentVolume();
                    } else {
                        streamMaxVolume = c.this.mAudioManager.getStreamMaxVolume(i2);
                        streamVolume = c.this.mAudioManager.getStreamVolume(i2);
                    }
                }
                return new ParcelableVolumeInfo(i, i2, i3, streamMaxVolume, streamVolume);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i, int i2, String str) {
                c.this.adjustVolume(i, i2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i, int i2, String str) {
                c.this.setVolumeTo(i, i2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                c.this.al(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                c.this.b(4, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                c.this.b(5, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                c.this.b(6, uri, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                c.this.al(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                c.this.b(8, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                c.this.b(9, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                c.this.b(10, uri, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j) {
                c.this.b(11, Long.valueOf(j));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                c.this.al(12);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                c.this.al(13);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                c.this.al(14);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                c.this.al(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                c.this.al(16);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                c.this.al(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j) throws RemoteException {
                c.this.b(18, Long.valueOf(j));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat) throws RemoteException {
                c.this.b(19, ratingCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                c.this.b(20, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                return c.this.zC;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                return c.this.dC();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                List<QueueItem> list;
                synchronized (c.this.mLock) {
                    list = c.this.zF;
                }
                return list;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                return c.this.zG;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Bundle bundle;
                synchronized (c.this.mLock) {
                    bundle = c.this.mExtras;
                }
                return bundle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return c.this.zH;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                return (c.this.mFlags & 2) != 0;
            }
        }

        /* loaded from: classes2.dex */
        private static final class a {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver zN;

            public a(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.command = str;
                this.extras = bundle;
                this.zN = resultReceiver;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: android.support.v4.media.session.MediaSessionCompat$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class HandlerC0005c extends Handler {
            public HandlerC0005c(Looper looper) {
                super(looper);
            }

            public void a(int i, Object obj, Bundle bundle) {
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Callback callback = c.this.zB;
                if (callback != null) {
                    switch (message.what) {
                        case 1:
                            a aVar = (a) message.obj;
                            callback.onCommand(aVar.command, aVar.extras, aVar.zN);
                            return;
                        case 2:
                            c.this.adjustVolume(((Integer) message.obj).intValue(), 0);
                            return;
                        case 3:
                            callback.onPrepare();
                            return;
                        case 4:
                            callback.onPrepareFromMediaId((String) message.obj, message.getData());
                            return;
                        case 5:
                            callback.onPrepareFromSearch((String) message.obj, message.getData());
                            return;
                        case 6:
                            callback.onPrepareFromUri((Uri) message.obj, message.getData());
                            return;
                        case 7:
                            callback.onPlay();
                            return;
                        case 8:
                            callback.onPlayFromMediaId((String) message.obj, message.getData());
                            return;
                        case 9:
                            callback.onPlayFromSearch((String) message.obj, message.getData());
                            return;
                        case 10:
                            callback.onPlayFromUri((Uri) message.obj, message.getData());
                            return;
                        case 11:
                            callback.onSkipToQueueItem(((Long) message.obj).longValue());
                            return;
                        case 12:
                            callback.onPause();
                            return;
                        case 13:
                            callback.onStop();
                            return;
                        case 14:
                            callback.onSkipToNext();
                            return;
                        case 15:
                            callback.onSkipToPrevious();
                            return;
                        case 16:
                            callback.onFastForward();
                            return;
                        case 17:
                            callback.onRewind();
                            return;
                        case 18:
                            callback.onSeekTo(((Long) message.obj).longValue());
                            return;
                        case 19:
                            callback.onSetRating((RatingCompat) message.obj);
                            return;
                        case 20:
                            callback.onCustomAction((String) message.obj, message.getData());
                            return;
                        case 21:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!callback.onMediaButtonEvent(intent)) {
                                a(keyEvent, callback);
                                return;
                            }
                            return;
                        case 22:
                            c.this.setVolumeTo(((Integer) message.obj).intValue(), 0);
                            return;
                        default:
                            return;
                    }
                }
            }

            private void a(KeyEvent keyEvent, Callback callback) {
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    long actions = c.this.zD == null ? 0L : c.this.zD.getActions();
                    switch (keyEvent.getKeyCode()) {
                        case 79:
                        case 85:
                            boolean z = c.this.zD != null && c.this.zD.getState() == 3;
                            boolean z2 = (516 & actions) != 0;
                            boolean z3 = (actions & 514) != 0;
                            if (z && z3) {
                                callback.onPause();
                                return;
                            } else if (!z && z2) {
                                callback.onPlay();
                                return;
                            } else {
                                return;
                            }
                        case 86:
                            if ((actions & 1) != 0) {
                                callback.onStop();
                                return;
                            }
                            return;
                        case 87:
                            if ((actions & 32) != 0) {
                                callback.onSkipToNext();
                                return;
                            }
                            return;
                        case 88:
                            if ((actions & 16) != 0) {
                                callback.onSkipToPrevious();
                                return;
                            }
                            return;
                        case 89:
                            if ((actions & 8) != 0) {
                                callback.onRewind();
                                return;
                            }
                            return;
                        case 90:
                            if ((actions & 64) != 0) {
                                callback.onFastForward();
                                return;
                            }
                            return;
                        case TransportMediator.KEYCODE_MEDIA_PLAY /* 126 */:
                            if ((actions & 4) != 0) {
                                callback.onPlay();
                                return;
                            }
                            return;
                        case TransportMediator.KEYCODE_MEDIA_PAUSE /* 127 */:
                            if ((actions & 2) != 0) {
                                callback.onPause();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b implements a {
        private final Token yY;
        private final Object zq;
        private PendingIntent zr;

        public b(Context context, String str) {
            this.zq = d.F(context, str);
            this.yY = new Token(d.U(this.zq));
        }

        public b(Object obj) {
            this.zq = d.R(obj);
            this.yY = new Token(d.U(this.zq));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setCallback(Callback callback, Handler handler) {
            d.b(this.zq, callback == null ? null : callback.yZ, handler);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setFlags(int i) {
            d.e(this.zq, i);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setPlaybackToLocal(int i) {
            d.f(this.zq, i);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            d.i(this.zq, volumeProviderCompat.getVolumeProvider());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setActive(boolean z) {
            d.a(this.zq, z);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public boolean isActive() {
            return d.isActive(this.zq);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void sendSessionEvent(String str, Bundle bundle) {
            d.b(this.zq, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void release() {
            d.T(this.zq);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public Token getSessionToken() {
            return this.yY;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            d.j(this.zq, playbackStateCompat == null ? null : playbackStateCompat.getPlaybackState());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            d.k(this.zq, mediaMetadataCompat == null ? null : mediaMetadataCompat.getMediaMetadata());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setSessionActivity(PendingIntent pendingIntent) {
            d.a(this.zq, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            this.zr = pendingIntent;
            d.b(this.zq, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setQueue(List<QueueItem> list) {
            ArrayList arrayList = null;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                for (QueueItem queueItem : list) {
                    arrayList2.add(queueItem.getQueueItem());
                }
                arrayList = arrayList2;
            }
            d.a(this.zq, arrayList);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setQueueTitle(CharSequence charSequence) {
            d.d(this.zq, charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setRatingType(int i) {
            if (Build.VERSION.SDK_INT >= 22) {
                e.g(this.zq, i);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public void setExtras(Bundle bundle) {
            d.a(this.zq, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public Object getMediaSession() {
            return this.zq;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.a
        public String getCallingPackage() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return MediaSessionCompatApi24.W(this.zq);
        }
    }
}
