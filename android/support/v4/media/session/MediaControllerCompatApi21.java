package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class MediaControllerCompatApi21 {

    /* loaded from: classes2.dex */
    public interface Callback {
        void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5);

        void onExtrasChanged(Bundle bundle);

        void onMetadataChanged(Object obj);

        void onPlaybackStateChanged(Object obj);

        void onQueueChanged(List<?> list);

        void onQueueTitleChanged(CharSequence charSequence);

        void onSessionDestroyed();

        void onSessionEvent(String str, Bundle bundle);
    }

    public static Object a(Context context, Object obj) {
        return new MediaController(context, (MediaSession.Token) obj);
    }

    public static Object a(Callback callback) {
        return new a(callback);
    }

    public static void a(Object obj, Object obj2, Handler handler) {
        ((MediaController) obj).registerCallback((MediaController.Callback) obj2, handler);
    }

    public static void f(Object obj, Object obj2) {
        ((MediaController) obj).unregisterCallback((MediaController.Callback) obj2);
    }

    public static Object G(Object obj) {
        return ((MediaController) obj).getTransportControls();
    }

    public static Object H(Object obj) {
        return ((MediaController) obj).getPlaybackState();
    }

    public static Object I(Object obj) {
        return ((MediaController) obj).getMetadata();
    }

    public static List<Object> J(Object obj) {
        List<MediaSession.QueueItem> queue = ((MediaController) obj).getQueue();
        if (queue == null) {
            return null;
        }
        return new ArrayList(queue);
    }

    public static CharSequence K(Object obj) {
        return ((MediaController) obj).getQueueTitle();
    }

    public static Bundle getExtras(Object obj) {
        return ((MediaController) obj).getExtras();
    }

    public static int L(Object obj) {
        return ((MediaController) obj).getRatingType();
    }

    public static long M(Object obj) {
        return ((MediaController) obj).getFlags();
    }

    public static Object N(Object obj) {
        return ((MediaController) obj).getPlaybackInfo();
    }

    public static PendingIntent O(Object obj) {
        return ((MediaController) obj).getSessionActivity();
    }

    public static boolean a(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    public static void a(Object obj, int i, int i2) {
        ((MediaController) obj).setVolumeTo(i, i2);
    }

    public static void b(Object obj, int i, int i2) {
        ((MediaController) obj).adjustVolume(i, i2);
    }

    public static void a(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    public static String P(Object obj) {
        return ((MediaController) obj).getPackageName();
    }

    /* loaded from: classes2.dex */
    public static class TransportControls {
        public static void play(Object obj) {
            ((MediaController.TransportControls) obj).play();
        }

        public static void pause(Object obj) {
            ((MediaController.TransportControls) obj).pause();
        }

        public static void stop(Object obj) {
            ((MediaController.TransportControls) obj).stop();
        }

        public static void seekTo(Object obj, long j) {
            ((MediaController.TransportControls) obj).seekTo(j);
        }

        public static void fastForward(Object obj) {
            ((MediaController.TransportControls) obj).fastForward();
        }

        public static void rewind(Object obj) {
            ((MediaController.TransportControls) obj).rewind();
        }

        public static void skipToNext(Object obj) {
            ((MediaController.TransportControls) obj).skipToNext();
        }

        public static void skipToPrevious(Object obj) {
            ((MediaController.TransportControls) obj).skipToPrevious();
        }

        public static void setRating(Object obj, Object obj2) {
            ((MediaController.TransportControls) obj).setRating((Rating) obj2);
        }

        public static void playFromMediaId(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromMediaId(str, bundle);
        }

        public static void playFromSearch(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromSearch(str, bundle);
        }

        public static void skipToQueueItem(Object obj, long j) {
            ((MediaController.TransportControls) obj).skipToQueueItem(j);
        }

        public static void sendCustomAction(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).sendCustomAction(str, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class PlaybackInfo {
        public static int getPlaybackType(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getPlaybackType();
        }

        public static AudioAttributes getAudioAttributes(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int getLegacyAudioStream(Object obj) {
            return a(getAudioAttributes(obj));
        }

        public static int getVolumeControl(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getVolumeControl();
        }

        public static int getMaxVolume(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getMaxVolume();
        }

        public static int getCurrentVolume(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getCurrentVolume();
        }

        private static int a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                default:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
            }
        }
    }

    /* loaded from: classes2.dex */
    static class a<T extends Callback> extends MediaController.Callback {
        protected final T zq;

        public a(T t) {
            this.zq = t;
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.zq.onSessionDestroyed();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            this.zq.onSessionEvent(str, bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.zq.onPlaybackStateChanged(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.zq.onMetadataChanged(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.zq.onQueueChanged(list);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.zq.onQueueTitleChanged(charSequence);
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            this.zq.onExtrasChanged(bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.zq.onAudioInfoChanged(playbackInfo.getPlaybackType(), PlaybackInfo.getLegacyAudioStream(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }
}
