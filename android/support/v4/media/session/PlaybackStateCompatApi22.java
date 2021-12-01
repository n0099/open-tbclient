package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
@RequiresApi(22)
/* loaded from: classes.dex */
public class PlaybackStateCompatApi22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PlaybackStateCompatApi22() {
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

    public static Bundle getExtras(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) ? ((PlaybackState) obj).getExtras() : (Bundle) invokeL.objValue;
    }

    public static Object newInstance(int i2, long j2, long j3, float f2, long j4, CharSequence charSequence, long j5, List<Object> list, long j6, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Float.valueOf(f2), Long.valueOf(j4), charSequence, Long.valueOf(j5), list, Long.valueOf(j6), bundle})) == null) {
            PlaybackState.Builder builder = new PlaybackState.Builder();
            builder.setState(i2, j2, f2, j5);
            builder.setBufferedPosition(j3);
            builder.setActions(j4);
            builder.setErrorMessage(charSequence);
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                builder.addCustomAction((PlaybackState.CustomAction) it.next());
            }
            builder.setActiveQueueItemId(j6);
            builder.setExtras(bundle);
            return builder.build();
        }
        return invokeCommon.objValue;
    }
}
