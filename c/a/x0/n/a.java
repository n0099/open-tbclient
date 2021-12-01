package c.a.x0.n;

import android.media.MediaMetadataRetriever;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a extends MediaMetadataRetriever {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                return Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return invokeL.longValue;
    }
}
