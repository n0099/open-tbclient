package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(24)
/* loaded from: classes.dex */
public class MediaControllerCompatApi24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

        public static void prepare(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, obj) == null) {
                ((MediaController.TransportControls) obj).prepare();
            }
        }

        public static void prepareFromMediaId(Object obj, String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, obj, str, bundle) == null) {
                ((MediaController.TransportControls) obj).prepareFromMediaId(str, bundle);
            }
        }

        public static void prepareFromSearch(Object obj, String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, null, obj, str, bundle) == null) {
                ((MediaController.TransportControls) obj).prepareFromSearch(str, bundle);
            }
        }

        public static void prepareFromUri(Object obj, Uri uri, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65540, null, obj, uri, bundle) == null) {
                ((MediaController.TransportControls) obj).prepareFromUri(uri, bundle);
            }
        }
    }

    public MediaControllerCompatApi24() {
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
}
