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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static Object newInstance(int i, long j, long j2, float f2, long j3, CharSequence charSequence, long j4, List<Object> list, long j5, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f2), Long.valueOf(j3), charSequence, Long.valueOf(j4), list, Long.valueOf(j5), bundle})) == null) {
            PlaybackState.Builder builder = new PlaybackState.Builder();
            builder.setState(i, j, f2, j4);
            builder.setBufferedPosition(j2);
            builder.setActions(j3);
            builder.setErrorMessage(charSequence);
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                builder.addCustomAction((PlaybackState.CustomAction) it.next());
            }
            builder.setActiveQueueItemId(j5);
            builder.setExtras(bundle);
            return builder.build();
        }
        return invokeCommon.objValue;
    }
}
