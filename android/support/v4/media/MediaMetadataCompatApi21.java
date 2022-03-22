package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.Rating;
import android.os.Parcel;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
@RequiresApi(21)
/* loaded from: classes.dex */
public class MediaMetadataCompatApi21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Builder() {
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

        public static Object build(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) ? ((MediaMetadata.Builder) obj).build() : invokeL.objValue;
        }

        public static Object newInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new MediaMetadata.Builder() : invokeV.objValue;
        }

        public static void putBitmap(Object obj, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, null, obj, str, bitmap) == null) {
                ((MediaMetadata.Builder) obj).putBitmap(str, bitmap);
            }
        }

        public static void putLong(Object obj, String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{obj, str, Long.valueOf(j)}) == null) {
                ((MediaMetadata.Builder) obj).putLong(str, j);
            }
        }

        public static void putRating(Object obj, String str, Object obj2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65541, null, obj, str, obj2) == null) {
                ((MediaMetadata.Builder) obj).putRating(str, (Rating) obj2);
            }
        }

        public static void putString(Object obj, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65542, null, obj, str, str2) == null) {
                ((MediaMetadata.Builder) obj).putString(str, str2);
            }
        }

        public static void putText(Object obj, String str, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65543, null, obj, str, charSequence) == null) {
                ((MediaMetadata.Builder) obj).putText(str, charSequence);
            }
        }
    }

    public MediaMetadataCompatApi21() {
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

    public static Object createFromParcel(Parcel parcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, parcel)) == null) ? MediaMetadata.CREATOR.createFromParcel(parcel) : invokeL.objValue;
    }

    public static Bitmap getBitmap(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, str)) == null) ? ((MediaMetadata) obj).getBitmap(str) : (Bitmap) invokeLL.objValue;
    }

    public static long getLong(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, str)) == null) ? ((MediaMetadata) obj).getLong(str) : invokeLL.longValue;
    }

    public static Object getRating(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str)) == null) ? ((MediaMetadata) obj).getRating(str) : invokeLL.objValue;
    }

    public static CharSequence getText(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, obj, str)) == null) ? ((MediaMetadata) obj).getText(str) : (CharSequence) invokeLL.objValue;
    }

    public static Set<String> keySet(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) ? ((MediaMetadata) obj).keySet() : (Set) invokeL.objValue;
    }

    public static void writeToParcel(Object obj, Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, null, obj, parcel, i) == null) {
            ((MediaMetadata) obj).writeToParcel(parcel, i);
        }
    }
}
