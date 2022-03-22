package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
@RequiresApi(21)
/* loaded from: classes.dex */
public class PlaybackStateCompatApi21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class CustomAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public CustomAction() {
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

        public static String getAction(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) ? ((PlaybackState.CustomAction) obj).getAction() : (String) invokeL.objValue;
        }

        public static Bundle getExtras(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) ? ((PlaybackState.CustomAction) obj).getExtras() : (Bundle) invokeL.objValue;
        }

        public static int getIcon(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) ? ((PlaybackState.CustomAction) obj).getIcon() : invokeL.intValue;
        }

        public static CharSequence getName(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) ? ((PlaybackState.CustomAction) obj).getName() : (CharSequence) invokeL.objValue;
        }

        public static Object newInstance(String str, CharSequence charSequence, int i, Bundle bundle) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65541, null, str, charSequence, i, bundle)) == null) {
                PlaybackState.CustomAction.Builder builder = new PlaybackState.CustomAction.Builder(str, charSequence, i);
                builder.setExtras(bundle);
                return builder.build();
            }
            return invokeLLIL.objValue;
        }
    }

    public PlaybackStateCompatApi21() {
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

    public static long getActions(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) ? ((PlaybackState) obj).getActions() : invokeL.longValue;
    }

    public static long getActiveQueueItemId(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) ? ((PlaybackState) obj).getActiveQueueItemId() : invokeL.longValue;
    }

    public static long getBufferedPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) ? ((PlaybackState) obj).getBufferedPosition() : invokeL.longValue;
    }

    public static List<Object> getCustomActions(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) ? ((PlaybackState) obj).getCustomActions() : (List) invokeL.objValue;
    }

    public static CharSequence getErrorMessage(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? ((PlaybackState) obj).getErrorMessage() : (CharSequence) invokeL.objValue;
    }

    public static long getLastPositionUpdateTime(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) ? ((PlaybackState) obj).getLastPositionUpdateTime() : invokeL.longValue;
    }

    public static float getPlaybackSpeed(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? ((PlaybackState) obj).getPlaybackSpeed() : invokeL.floatValue;
    }

    public static long getPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) ? ((PlaybackState) obj).getPosition() : invokeL.longValue;
    }

    public static int getState(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) ? ((PlaybackState) obj).getState() : invokeL.intValue;
    }

    public static Object newInstance(int i, long j, long j2, float f2, long j3, CharSequence charSequence, long j4, List<Object> list, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f2), Long.valueOf(j3), charSequence, Long.valueOf(j4), list, Long.valueOf(j5)})) == null) {
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
            return builder.build();
        }
        return invokeCommon.objValue;
    }
}
