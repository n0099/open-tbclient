package b.a.e.j;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.contains(".so")) {
                String[] split = str.split("\\.");
                str2 = "so_cache" + File.separator + split[0];
            } else {
                str2 = str.contains(EmotionResourceProvider.EMOTION_SOUND_SUFFIX) ? "mp3_cache" : "res_cache";
            }
            return BdBaseApplication.getInst().getFilesDir() + File.separator + str2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            return a(str) + File.separator + str;
        }
        return (String) invokeL.objValue;
    }
}
