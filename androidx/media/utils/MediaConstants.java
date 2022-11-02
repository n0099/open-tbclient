package androidx.media.utils;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class MediaConstants {
    public static /* synthetic */ Interceptable $ic = null;
    @SuppressLint({"IntentName"})
    public static final String SESSION_EXTRAS_KEY_ACCOUNT_NAME = "androidx.media.MediaSessionCompat.Extras.KEY_ACCOUNT_NAME";
    @SuppressLint({"IntentName"})
    public static final String SESSION_EXTRAS_KEY_ACCOUNT_TYPE = "androidx.media.MediaSessionCompat.Extras.KEY_ACCOUNT_TYPE";
    @SuppressLint({"IntentName"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String SESSION_EXTRAS_KEY_AUTHTOKEN = "androidx.media.MediaSessionCompat.Extras.KEY_AUTHTOKEN";
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
