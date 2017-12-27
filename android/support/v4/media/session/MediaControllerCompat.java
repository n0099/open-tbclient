package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaControllerCompatApi23;
import android.support.v4.media.session.MediaControllerCompatApi24;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;
/* loaded from: classes2.dex */
public final class MediaControllerCompat {
    private final a zd;
    private final MediaSessionCompat.Token ze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void adjustVolume(int i, int i2);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        PendingIntent getSessionActivity();

        TransportControls getTransportControls();

        void registerCallback(Callback callback, Handler handler);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i, int i2);

        void unregisterCallback(Callback callback);
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        this.ze = mediaSessionCompat.getSessionToken();
        if (Build.VERSION.SDK_INT >= 24) {
            this.zd = new d(context, mediaSessionCompat);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.zd = new c(context, mediaSessionCompat);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.zd = new b(context, mediaSessionCompat);
        } else {
            this.zd = new e(this.ze);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) throws RemoteException {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.ze = token;
        if (Build.VERSION.SDK_INT >= 24) {
            this.zd = new d(context, token);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.zd = new c(context, token);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.zd = new b(context, token);
        } else {
            this.zd = new e(this.ze);
        }
    }

    public TransportControls getTransportControls() {
        return this.zd.getTransportControls();
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        return this.zd.dispatchMediaButtonEvent(keyEvent);
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.zd.getPlaybackState();
    }

    public MediaMetadataCompat getMetadata() {
        return this.zd.getMetadata();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.zd.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.zd.getQueueTitle();
    }

    public Bundle getExtras() {
        return this.zd.getExtras();
    }

    public int getRatingType() {
        return this.zd.getRatingType();
    }

    public long getFlags() {
        return this.zd.getFlags();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.zd.getPlaybackInfo();
    }

    public PendingIntent getSessionActivity() {
        return this.zd.getSessionActivity();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.ze;
    }

    public void setVolumeTo(int i2, int i3) {
        this.zd.setVolumeTo(i2, i3);
    }

    public void adjustVolume(int i2, int i3) {
        this.zd.adjustVolume(i2, i3);
    }

    public void registerCallback(Callback callback) {
        registerCallback(callback, null);
    }

    public void registerCallback(Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        if (handler == null) {
            handler = new Handler();
        }
        this.zd.registerCallback(callback, handler);
    }

    public void unregisterCallback(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.zd.unregisterCallback(callback);
    }

    public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command cannot be null or empty");
        }
        this.zd.sendCommand(str, bundle, resultReceiver);
    }

    public String getPackageName() {
        return this.zd.getPackageName();
    }

    public Object getMediaController() {
        return this.zd.getMediaController();
    }

    /* loaded from: classes2.dex */
    public static abstract class Callback implements IBinder.DeathRecipient {
        private final Object zf;
        a zg;
        boolean zh = false;

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.zf = MediaControllerCompatApi21.a(new b());
            } else {
                this.zf = new c();
            }
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            onSessionDestroyed();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHandler(Handler handler) {
            this.zg = new a(handler.getLooper());
        }

        /* loaded from: classes2.dex */
        private class b implements MediaControllerCompatApi21.Callback {
            b() {
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionDestroyed() {
                Callback.this.onSessionDestroyed();
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                Callback.this.onSessionEvent(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onPlaybackStateChanged(Object obj) {
                Callback.this.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onMetadataChanged(Object obj) {
                Callback.this.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueChanged(List<?> list) {
                Callback.this.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback.this.onQueueTitleChanged(charSequence);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onExtrasChanged(Bundle bundle) {
                Callback.this.onExtrasChanged(bundle);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5) {
                Callback.this.onAudioInfoChanged(new PlaybackInfo(i, i2, i3, i4, i5));
            }
        }

        /* loaded from: classes2.dex */
        private class c extends IMediaControllerCallback.Stub {
            c() {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback.this.zg.a(1, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Callback.this.zg.a(8, null, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback.this.zg.a(2, playbackStateCompat, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback.this.zg.a(3, mediaMetadataCompat, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Callback.this.zg.a(5, list, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Callback.this.zg.a(6, charSequence, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Callback.this.zg.a(7, bundle, null);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback.this.zg.a(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume) : null, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (Callback.this.zh) {
                    switch (message.what) {
                        case 1:
                            Callback.this.onSessionEvent((String) message.obj, message.getData());
                            return;
                        case 2:
                            Callback.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            Callback.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            Callback.this.onAudioInfoChanged((PlaybackInfo) message.obj);
                            return;
                        case 5:
                            Callback.this.onQueueChanged((List) message.obj);
                            return;
                        case 6:
                            Callback.this.onQueueTitleChanged((CharSequence) message.obj);
                            return;
                        case 7:
                            Callback.this.onExtrasChanged((Bundle) message.obj);
                            return;
                        case 8:
                            Callback.this.onSessionDestroyed();
                            return;
                        default:
                            return;
                    }
                }
            }

            public void a(int i, Object obj, Bundle bundle) {
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class TransportControls {
        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();

        TransportControls() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int yX;
        private final int yY;
        private final int zm;
        private final int zn;
        private final int zo;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.zm = i;
            this.zn = i2;
            this.zo = i3;
            this.yX = i4;
            this.yY = i5;
        }

        public int getPlaybackType() {
            return this.zm;
        }

        public int getAudioStream() {
            return this.zn;
        }

        public int getVolumeControl() {
            return this.zo;
        }

        public int getMaxVolume() {
            return this.yX;
        }

        public int getCurrentVolume() {
            return this.yY;
        }
    }

    /* loaded from: classes2.dex */
    static class e implements a {
        private MediaSessionCompat.Token ze;
        private IMediaSession zk;
        private TransportControls zl;

        public e(MediaSessionCompat.Token token) {
            this.ze = token;
            this.zk = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void registerCallback(Callback callback, Handler handler) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.zk.asBinder().linkToDeath(callback, 0);
                this.zk.registerCallbackListener((IMediaControllerCallback) callback.zf);
                callback.setHandler(handler);
                callback.zh = true;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback. " + e);
                callback.onSessionDestroyed();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void unregisterCallback(Callback callback) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.zk.unregisterCallbackListener((IMediaControllerCallback) callback.zf);
                this.zk.asBinder().unlinkToDeath(callback, 0);
                callback.zh = false;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in unregisterCallback. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.zk.sendMediaButton(keyEvent);
                return false;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent. " + e);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public TransportControls getTransportControls() {
            if (this.zl == null) {
                this.zl = new i(this.zk);
            }
            return this.zl;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.zk.getPlaybackState();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState. " + e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public MediaMetadataCompat getMetadata() {
            try {
                return this.zk.getMetadata();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata. " + e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public List<MediaSessionCompat.QueueItem> getQueue() {
            try {
                return this.zk.getQueue();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getQueue. " + e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public CharSequence getQueueTitle() {
            try {
                return this.zk.getQueueTitle();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getQueueTitle. " + e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public Bundle getExtras() {
            try {
                return this.zk.getExtras();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getExtras. " + e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public int getRatingType() {
            try {
                return this.zk.getRatingType();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getRatingType. " + e);
                return 0;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public long getFlags() {
            try {
                return this.zk.getFlags();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getFlags. " + e);
                return 0L;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public PlaybackInfo getPlaybackInfo() {
            try {
                ParcelableVolumeInfo volumeAttributes = this.zk.getVolumeAttributes();
                return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo. " + e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public PendingIntent getSessionActivity() {
            try {
                return this.zk.getLaunchPendingIntent();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity. " + e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void setVolumeTo(int i, int i2) {
            try {
                this.zk.setVolumeTo(i, i2, null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setVolumeTo. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void adjustVolume(int i, int i2) {
            try {
                this.zk.adjustVolume(i, i2, null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in adjustVolume. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.zk.sendCommand(str, bundle, new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in sendCommand. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public String getPackageName() {
            try {
                return this.zk.getPackageName();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPackageName. " + e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public Object getMediaController() {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    static class i extends TransportControls {
        private IMediaSession zk;

        public i(IMediaSession iMediaSession) {
            this.zk = iMediaSession;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            try {
                this.zk.prepare();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepare. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            try {
                this.zk.prepareFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromMediaId. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            try {
                this.zk.prepareFromSearch(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromSearch. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            try {
                this.zk.prepareFromUri(uri, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromUri. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            try {
                this.zk.play();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in play. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String str, Bundle bundle) {
            try {
                this.zk.playFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromMediaId. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String str, Bundle bundle) {
            try {
                this.zk.playFromSearch(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromSearch. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            try {
                this.zk.playFromUri(uri, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromUri. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j) {
            try {
                this.zk.skipToQueueItem(j);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToQueueItem. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            try {
                this.zk.pause();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in pause. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            try {
                this.zk.stop();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in stop. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j) {
            try {
                this.zk.seekTo(j);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in seekTo. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            try {
                this.zk.fastForward();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in fastForward. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            try {
                this.zk.next();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            try {
                this.zk.rewind();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in rewind. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            try {
                this.zk.previous();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToPrevious. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat) {
            try {
                this.zk.rate(ratingCompat);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setRating. " + e);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String str, Bundle bundle) {
            try {
                this.zk.sendCustomAction(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in sendCustomAction. " + e);
            }
        }
    }

    /* loaded from: classes2.dex */
    static class b implements a {
        protected final Object zj;

        public b(Context context, MediaSessionCompat mediaSessionCompat) {
            this.zj = MediaControllerCompatApi21.a(context, mediaSessionCompat.getSessionToken().getToken());
        }

        public b(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.zj = MediaControllerCompatApi21.a(context, token.getToken());
            if (this.zj == null) {
                throw new RemoteException();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void registerCallback(Callback callback, Handler handler) {
            MediaControllerCompatApi21.a(this.zj, callback.zf, handler);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void unregisterCallback(Callback callback) {
            MediaControllerCompatApi21.f(this.zj, callback.zf);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.a(this.zj, keyEvent);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public TransportControls getTransportControls() {
            Object G = MediaControllerCompatApi21.G(this.zj);
            if (G != null) {
                return new f(G);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public PlaybackStateCompat getPlaybackState() {
            Object H = MediaControllerCompatApi21.H(this.zj);
            if (H != null) {
                return PlaybackStateCompat.fromPlaybackState(H);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public MediaMetadataCompat getMetadata() {
            Object I = MediaControllerCompatApi21.I(this.zj);
            if (I != null) {
                return MediaMetadataCompat.fromMediaMetadata(I);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> J = MediaControllerCompatApi21.J(this.zj);
            if (J != null) {
                return MediaSessionCompat.QueueItem.fromQueueItemList(J);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.K(this.zj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.zj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public int getRatingType() {
            return MediaControllerCompatApi21.L(this.zj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public long getFlags() {
            return MediaControllerCompatApi21.M(this.zj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public PlaybackInfo getPlaybackInfo() {
            Object N = MediaControllerCompatApi21.N(this.zj);
            if (N != null) {
                return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(N), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(N), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(N), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(N), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(N));
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.O(this.zj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void setVolumeTo(int i, int i2) {
            MediaControllerCompatApi21.a(this.zj, i, i2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void adjustVolume(int i, int i2) {
            MediaControllerCompatApi21.b(this.zj, i, i2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.a(this.zj, str, bundle, resultReceiver);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public String getPackageName() {
            return MediaControllerCompatApi21.P(this.zj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public Object getMediaController() {
            return this.zj;
        }
    }

    /* loaded from: classes2.dex */
    static class f extends TransportControls {
        protected final Object zp;

        public f(Object obj) {
            this.zp = obj;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            sendCustomAction("android.support.v4.media.session.action.PREPARE", (Bundle) null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", str);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", str);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.zp);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.zp);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.zp);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.zp, j);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.zp);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.zp);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.zp);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.zp);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat) {
            MediaControllerCompatApi21.TransportControls.setRating(this.zp, ratingCompat != null ? ratingCompat.getRating() : null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.zp, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.zp, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            if (uri == null || Uri.EMPTY.equals(uri)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.zp, j);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.zp, customAction.getAction(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.zp, str, bundle);
        }
    }

    /* loaded from: classes2.dex */
    static class c extends b {
        public c(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        public c(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b, android.support.v4.media.session.MediaControllerCompat.a
        public TransportControls getTransportControls() {
            Object G = MediaControllerCompatApi21.G(this.zj);
            if (G != null) {
                return new g(G);
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    static class g extends f {
        public g(Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.f, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi23.TransportControls.playFromUri(this.zp, uri, bundle);
        }
    }

    /* loaded from: classes2.dex */
    static class d extends c {
        public d(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        public d(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c, android.support.v4.media.session.MediaControllerCompat.b, android.support.v4.media.session.MediaControllerCompat.a
        public TransportControls getTransportControls() {
            Object G = MediaControllerCompatApi21.G(this.zj);
            if (G != null) {
                return new h(G);
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    static class h extends g {
        public h(Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.f, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            MediaControllerCompatApi24.TransportControls.prepare(this.zp);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.f, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.zp, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.f, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.zp, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.f, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi24.TransportControls.prepareFromUri(this.zp, uri, bundle);
        }
    }
}
