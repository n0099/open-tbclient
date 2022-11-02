package androidx.media2.session;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.media2.common.SessionPlayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public abstract class RemoteSessionPlayer extends SessionPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface VolumeControlType {
    }

    @NonNull
    public abstract Future<SessionPlayer.PlayerResult> adjustVolume(int i);

    public abstract int getMaxVolume();

    public abstract int getVolume();

    public abstract int getVolumeControlType();

    @NonNull
    public abstract Future<SessionPlayer.PlayerResult> setVolume(int i);

    /* loaded from: classes.dex */
    public static class Callback extends SessionPlayer.PlayerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void onVolumeChanged(@NonNull RemoteSessionPlayer remoteSessionPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, remoteSessionPlayer, i) == null) {
            }
        }

        public Callback() {
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

    public RemoteSessionPlayer() {
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
