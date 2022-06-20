package androidx.media2.session;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MediaConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ARGUMENT_CAPTIONING_ENABLED = "androidx.media2.argument.CAPTIONING_ENABLED";
    public static final String MEDIA_URI_AUTHORITY = "media2-session";
    public static final String MEDIA_URI_PATH_PLAY_FROM_MEDIA_ID = "playFromMediaId";
    public static final String MEDIA_URI_PATH_PLAY_FROM_SEARCH = "playFromSearch";
    public static final String MEDIA_URI_PATH_PREPARE_FROM_MEDIA_ID = "prepareFromMediaId";
    public static final String MEDIA_URI_PATH_PREPARE_FROM_SEARCH = "prepareFromSearch";
    public static final String MEDIA_URI_QUERY_ID = "id";
    public static final String MEDIA_URI_QUERY_QUERY = "query";
    public static final String MEDIA_URI_SCHEME = "androidx";
    public transient /* synthetic */ FieldHolder $fh;

    public MediaConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
