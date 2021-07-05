package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi23;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
@RequiresApi(24)
/* loaded from: classes.dex */
public class MediaSessionCompatApi24 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaSessionCompatApi24";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface Callback extends MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String str, Bundle bundle);

        void onPrepareFromSearch(String str, Bundle bundle);

        void onPrepareFromUri(Uri uri, Bundle bundle);
    }

    /* loaded from: classes.dex */
    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi23.CallbackProxy<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallbackProxy(T t) {
            super(t);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((MediaSessionCompatApi23.Callback) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((Callback) this.mCallback).onPrepare();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                ((Callback) this.mCallback).onPrepareFromMediaId(str, bundle);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle) == null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                ((Callback) this.mCallback).onPrepareFromSearch(str, bundle);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, uri, bundle) == null) {
                MediaSessionCompat.ensureClassLoader(bundle);
                ((Callback) this.mCallback).onPrepareFromUri(uri, bundle);
            }
        }
    }

    public MediaSessionCompatApi24() {
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

    public static String getCallingPackage(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            MediaSession mediaSession = (MediaSession) obj;
            try {
                return (String) mediaSession.getClass().getMethod("getCallingPackage", new Class[0]).invoke(mediaSession, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                Log.e(TAG, "Cannot execute MediaSession.getCallingPackage()", e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
