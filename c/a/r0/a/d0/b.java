package c.a.r0.a.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5652b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5653c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f5654d;

    public b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5654d = new HashMap();
        this.f5652b = TimeUnit.MILLISECONDS.toSeconds(j2);
        this.a = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j2);
        this.f5653c = Long.toHexString(a(this.a + "#" + this.f5652b));
        this.f5654d.put("timestamp", Long.toString(this.a));
        this.f5654d.put("delta", Long.toString(this.f5652b));
        this.f5654d.put("rasign", this.f5653c);
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new b(0L) : (b) invokeV.objValue;
    }

    public final long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            CRC32 crc32 = new CRC32();
            crc32.reset();
            crc32.update(str.getBytes());
            return crc32.getValue();
        }
        return invokeL.longValue;
    }

    public String c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            return Long.toHexString(a(j2 + "#smartapp_formid"));
        }
        return (String) invokeJ.objValue;
    }

    public String d(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            return Long.toHexString(a(j2 + "#payid"));
        }
        return (String) invokeJ.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return super.toString() + " serverTime:" + this.a + " delta:" + this.f5652b + " rasign:" + this.f5653c;
        }
        return (String) invokeV.objValue;
    }
}
