package aegon.chrome.net;

import aegon.chrome.base.annotations.CalledByNative;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.text.Normalizer;
import java.util.Locale;
/* loaded from: classes.dex */
public class NetStringUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NetStringUtil() {
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

    @CalledByNative
    public static String convertToUnicode(ByteBuffer byteBuffer, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, byteBuffer, str)) == null) {
            try {
                return Charset.forName(str).newDecoder().decode(byteBuffer).toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    @CalledByNative
    public static String convertToUnicodeAndNormalize(ByteBuffer byteBuffer, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, byteBuffer, str)) == null) {
            String convertToUnicode = convertToUnicode(byteBuffer, str);
            if (convertToUnicode == null) {
                return null;
            }
            return Normalizer.normalize(convertToUnicode, Normalizer.Form.NFC);
        }
        return (String) invokeLL.objValue;
    }

    @CalledByNative
    public static String convertToUnicodeWithSubstitutions(ByteBuffer byteBuffer, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, byteBuffer, str)) == null) {
            try {
                CharsetDecoder newDecoder = Charset.forName(str).newDecoder();
                newDecoder.onMalformedInput(CodingErrorAction.REPLACE);
                newDecoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
                newDecoder.replaceWith("�");
                return newDecoder.decode(byteBuffer).toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    @CalledByNative
    public static String toUpperCase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            try {
                return str.toUpperCase(Locale.getDefault());
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
