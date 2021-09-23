package c.i.b.a.h0;

import android.net.Uri;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public final class d implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f33716a;

    /* renamed from: b  reason: collision with root package name */
    public int f33717b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f33718c;

    public d() {
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

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            this.f33716a = gVar;
            Uri uri = gVar.f33725a;
            String scheme = uri.getScheme();
            if ("data".equals(scheme)) {
                String[] split = uri.getSchemeSpecificPart().split(",");
                if (split.length <= 2) {
                    String str = split[1];
                    if (split[0].contains(DataUrlLoader.BASE64_TAG)) {
                        try {
                            this.f33718c = Base64.decode(str, 0);
                        } catch (IllegalArgumentException e2) {
                            throw new ParserException("Error while parsing Base64 encoded string: " + str, e2);
                        }
                    } else {
                        this.f33718c = URLDecoder.decode(str, "US-ASCII").getBytes();
                    }
                    return this.f33718c.length;
                }
                throw new ParserException("Unexpected URI format: " + uri);
            }
            throw new ParserException("Unsupported scheme: " + scheme);
        }
        return invokeL.longValue;
    }

    @Override // c.i.b.a.h0.e
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f33716a = null;
            this.f33718c = null;
        }
    }

    @Override // c.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g gVar = this.f33716a;
            if (gVar != null) {
                return gVar.f33725a;
            }
            return null;
        }
        return (Uri) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return 0;
            }
            int length = this.f33718c.length - this.f33717b;
            if (length == 0) {
                return -1;
            }
            int min = Math.min(i3, length);
            System.arraycopy(this.f33718c, this.f33717b, bArr, i2, min);
            this.f33717b += min;
            return min;
        }
        return invokeLII.intValue;
    }
}
