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
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@RequiresApi(21)
/* loaded from: classes.dex */
public class MediaSessionCompatApi21 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaSessionCompatApi21";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface Callback {
        void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void onCustomAction(String str, Bundle bundle);

        void onFastForward();

        boolean onMediaButtonEvent(Intent intent);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String str, Bundle bundle);

        void onPlayFromSearch(String str, Bundle bundle);

        void onRewind();

        void onSeekTo(long j);

        void onSetRating(Object obj);

        void onSetRating(Object obj, Bundle bundle);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long j);

        void onStop();
    }

    /* loaded from: classes.dex */
    public static class CallbackProxy<T extends Callback> extends MediaSession.Callback {
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

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, resultReceiver) == null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                this.mCallback.onCommand(str, bundle, resultReceiver);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                this.mCallback.onCustomAction(str, bundle);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mCallback.onFastForward();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, intent)) == null) ? this.mCallback.onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent) : invokeL.booleanValue;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.mCallback.onPause();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.mCallback.onPlay();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, str, bundle) == null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                this.mCallback.onPlayFromMediaId(str, bundle);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, bundle) == null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                this.mCallback.onPlayFromSearch(str, bundle);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.mCallback.onRewind();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                this.mCallback.onSeekTo(j);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating rating) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, rating) == null) {
                this.mCallback.onSetRating(rating);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.mCallback.onSkipToNext();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                this.mCallback.onSkipToPrevious();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
                this.mCallback.onSkipToQueueItem(j);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                this.mCallback.onStop();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class QueueItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public QueueItem() {
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

        public static Object createItem(Object obj, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, obj, j)) == null) ? new MediaSession.QueueItem((MediaDescription) obj, j) : invokeLJ.objValue;
        }

        public static Object getDescription(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) ? ((MediaSession.QueueItem) obj).getDescription() : invokeL.objValue;
        }

        public static long getQueueId(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) ? ((MediaSession.QueueItem) obj).getQueueId() : invokeL.longValue;
        }
    }

    public MediaSessionCompatApi21() {
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

    public static Object createCallback(Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, callback)) == null) ? new CallbackProxy(callback) : invokeL.objValue;
    }

    public static Object createSession(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? new MediaSession(context, str) : invokeLL.objValue;
    }

    public static Parcelable getSessionToken(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) ? ((MediaSession) obj).getSessionToken() : (Parcelable) invokeL.objValue;
    }

    public static boolean hasCallback(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("mCallback");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    return declaredField.get(obj) != null;
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                Log.w(TAG, "Failed to get mCallback object.");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isActive(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, obj)) == null) ? ((MediaSession) obj).isActive() : invokeL.booleanValue;
    }

    public static void release(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj) == null) {
            ((MediaSession) obj).release();
        }
    }

    public static void sendSessionEvent(Object obj, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, obj, str, bundle) == null) {
            ((MediaSession) obj).sendSessionEvent(str, bundle);
        }
    }

    public static void setActive(Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, obj, z) == null) {
            ((MediaSession) obj).setActive(z);
        }
    }

    public static void setCallback(Object obj, Object obj2, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, obj, obj2, handler) == null) {
            ((MediaSession) obj).setCallback((MediaSession.Callback) obj2, handler);
        }
    }

    public static void setExtras(Object obj, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, obj, bundle) == null) {
            ((MediaSession) obj).setExtras(bundle);
        }
    }

    public static void setFlags(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, obj, i2) == null) {
            ((MediaSession) obj).setFlags(i2);
        }
    }

    public static void setMediaButtonReceiver(Object obj, PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, obj, pendingIntent) == null) {
            ((MediaSession) obj).setMediaButtonReceiver(pendingIntent);
        }
    }

    public static void setMetadata(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, obj, obj2) == null) {
            ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
        }
    }

    public static void setPlaybackState(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, obj, obj2) == null) {
            ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
        }
    }

    public static void setPlaybackToLocal(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, obj, i2) == null) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setLegacyStreamType(i2);
            ((MediaSession) obj).setPlaybackToLocal(builder.build());
        }
    }

    public static void setPlaybackToRemote(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, obj, obj2) == null) {
            ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
        }
    }

    public static void setQueue(Object obj, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, obj, list) == null) {
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
    }

    public static void setQueueTitle(Object obj, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, obj, charSequence) == null) {
            ((MediaSession) obj).setQueueTitle(charSequence);
        }
    }

    public static void setSessionActivity(Object obj, PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, obj, pendingIntent) == null) {
            ((MediaSession) obj).setSessionActivity(pendingIntent);
        }
    }

    public static Object verifySession(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, obj)) == null) {
            if (obj instanceof MediaSession) {
                return obj;
            }
            throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        }
        return invokeL.objValue;
    }

    public static Object verifyToken(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, obj)) == null) {
            if (obj instanceof MediaSession.Token) {
                return obj;
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }
        return invokeL.objValue;
    }
}
