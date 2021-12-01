package android.support.v4.media.session;

import android.app.Activity;
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
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@RequiresApi(21)
/* loaded from: classes.dex */
public class MediaControllerCompatApi21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface Callback {
        void onAudioInfoChanged(int i2, int i3, int i4, int i5, int i6);

        void onExtrasChanged(Bundle bundle);

        void onMetadataChanged(Object obj);

        void onPlaybackStateChanged(Object obj);

        void onQueueChanged(List<?> list);

        void onQueueTitleChanged(CharSequence charSequence);

        void onSessionDestroyed();

        void onSessionEvent(String str, Bundle bundle);
    }

    /* loaded from: classes.dex */
    public static class CallbackProxy<T extends Callback> extends MediaController.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T mCallback;

        public CallbackProxy(T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallback = t;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, playbackInfo) == null) {
                this.mCallback.onAudioInfoChanged(playbackInfo.getPlaybackType(), PlaybackInfo.getLegacyAudioStream(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                this.mCallback.onExtrasChanged(bundle);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaMetadata) == null) {
                this.mCallback.onMetadataChanged(mediaMetadata);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, playbackState) == null) {
                this.mCallback.onPlaybackStateChanged(playbackState);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
                this.mCallback.onQueueChanged(list);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
                this.mCallback.onQueueTitleChanged(charSequence);
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.mCallback.onSessionDestroyed();
            }
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, bundle) == null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                this.mCallback.onSessionEvent(str, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PlaybackInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FLAG_SCO = 4;
        public static final int STREAM_BLUETOOTH_SCO = 6;
        public static final int STREAM_SYSTEM_ENFORCED = 7;
        public transient /* synthetic */ FieldHolder $fh;

        public PlaybackInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static AudioAttributes getAudioAttributes(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) ? ((MediaController.PlaybackInfo) obj).getAudioAttributes() : (AudioAttributes) invokeL.objValue;
        }

        public static int getCurrentVolume(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) ? ((MediaController.PlaybackInfo) obj).getCurrentVolume() : invokeL.intValue;
        }

        public static int getLegacyAudioStream(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) ? toLegacyStreamType(getAudioAttributes(obj)) : invokeL.intValue;
        }

        public static int getMaxVolume(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) ? ((MediaController.PlaybackInfo) obj).getMaxVolume() : invokeL.intValue;
        }

        public static int getPlaybackType(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? ((MediaController.PlaybackInfo) obj).getPlaybackType() : invokeL.intValue;
        }

        public static int getVolumeControl(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) ? ((MediaController.PlaybackInfo) obj).getVolumeControl() : invokeL.intValue;
        }

        public static int toLegacyStreamType(AudioAttributes audioAttributes) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, audioAttributes)) == null) {
                if ((audioAttributes.getFlags() & 1) == 1) {
                    return 7;
                }
                if ((audioAttributes.getFlags() & 4) == 4) {
                    return 6;
                }
                int usage = audioAttributes.getUsage();
                if (usage != 13) {
                    switch (usage) {
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
                        default:
                            return 3;
                    }
                }
                return 1;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class TransportControls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TransportControls() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void fastForward(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, obj) == null) {
                ((MediaController.TransportControls) obj).fastForward();
            }
        }

        public static void pause(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, obj) == null) {
                ((MediaController.TransportControls) obj).pause();
            }
        }

        public static void play(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, obj) == null) {
                ((MediaController.TransportControls) obj).play();
            }
        }

        public static void playFromMediaId(Object obj, String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, bundle) == null) {
                ((MediaController.TransportControls) obj).playFromMediaId(str, bundle);
            }
        }

        public static void playFromSearch(Object obj, String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65541, null, obj, str, bundle) == null) {
                ((MediaController.TransportControls) obj).playFromSearch(str, bundle);
            }
        }

        public static void rewind(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65542, null, obj) == null) {
                ((MediaController.TransportControls) obj).rewind();
            }
        }

        public static void seekTo(Object obj, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(65543, null, obj, j2) == null) {
                ((MediaController.TransportControls) obj).seekTo(j2);
            }
        }

        public static void sendCustomAction(Object obj, String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65544, null, obj, str, bundle) == null) {
                ((MediaController.TransportControls) obj).sendCustomAction(str, bundle);
            }
        }

        public static void setRating(Object obj, Object obj2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65545, null, obj, obj2) == null) {
                ((MediaController.TransportControls) obj).setRating((Rating) obj2);
            }
        }

        public static void skipToNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65546, null, obj) == null) {
                ((MediaController.TransportControls) obj).skipToNext();
            }
        }

        public static void skipToPrevious(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65547, null, obj) == null) {
                ((MediaController.TransportControls) obj).skipToPrevious();
            }
        }

        public static void skipToQueueItem(Object obj, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(65548, null, obj, j2) == null) {
                ((MediaController.TransportControls) obj).skipToQueueItem(j2);
            }
        }

        public static void stop(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65549, null, obj) == null) {
                ((MediaController.TransportControls) obj).stop();
            }
        }
    }

    public MediaControllerCompatApi21() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void adjustVolume(Object obj, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, obj, i2, i3) == null) {
            ((MediaController) obj).adjustVolume(i2, i3);
        }
    }

    public static Object createCallback(Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callback)) == null) ? new CallbackProxy(callback) : invokeL.objValue;
    }

    public static boolean dispatchMediaButtonEvent(Object obj, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, keyEvent)) == null) ? ((MediaController) obj).dispatchMediaButtonEvent(keyEvent) : invokeLL.booleanValue;
    }

    public static Object fromToken(Context context, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, obj)) == null) ? new MediaController(context, (MediaSession.Token) obj) : invokeLL.objValue;
    }

    public static Bundle getExtras(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? ((MediaController) obj).getExtras() : (Bundle) invokeL.objValue;
    }

    public static long getFlags(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) ? ((MediaController) obj).getFlags() : invokeL.longValue;
    }

    public static Object getMediaController(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, activity)) == null) ? activity.getMediaController() : invokeL.objValue;
    }

    public static Object getMetadata(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) ? ((MediaController) obj).getMetadata() : invokeL.objValue;
    }

    public static String getPackageName(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) ? ((MediaController) obj).getPackageName() : (String) invokeL.objValue;
    }

    public static Object getPlaybackInfo(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) ? ((MediaController) obj).getPlaybackInfo() : invokeL.objValue;
    }

    public static Object getPlaybackState(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, obj)) == null) ? ((MediaController) obj).getPlaybackState() : invokeL.objValue;
    }

    public static List<Object> getQueue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, obj)) == null) {
            List<MediaSession.QueueItem> queue = ((MediaController) obj).getQueue();
            if (queue == null) {
                return null;
            }
            return new ArrayList(queue);
        }
        return (List) invokeL.objValue;
    }

    public static CharSequence getQueueTitle(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, obj)) == null) ? ((MediaController) obj).getQueueTitle() : (CharSequence) invokeL.objValue;
    }

    public static int getRatingType(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, obj)) == null) ? ((MediaController) obj).getRatingType() : invokeL.intValue;
    }

    public static PendingIntent getSessionActivity(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, obj)) == null) ? ((MediaController) obj).getSessionActivity() : (PendingIntent) invokeL.objValue;
    }

    public static Object getSessionToken(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, obj)) == null) ? ((MediaController) obj).getSessionToken() : invokeL.objValue;
    }

    public static Object getTransportControls(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, obj)) == null) ? ((MediaController) obj).getTransportControls() : invokeL.objValue;
    }

    public static void registerCallback(Object obj, Object obj2, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, obj, obj2, handler) == null) {
            ((MediaController) obj).registerCallback((MediaController.Callback) obj2, handler);
        }
    }

    public static void sendCommand(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65555, null, obj, str, bundle, resultReceiver) == null) {
            ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
        }
    }

    public static void setMediaController(Activity activity, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, activity, obj) == null) {
            activity.setMediaController((MediaController) obj);
        }
    }

    public static void setVolumeTo(Object obj, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65557, null, obj, i2, i3) == null) {
            ((MediaController) obj).setVolumeTo(i2, i3);
        }
    }

    public static void unregisterCallback(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, obj, obj2) == null) {
            ((MediaController) obj).unregisterCallback((MediaController.Callback) obj2);
        }
    }
}
