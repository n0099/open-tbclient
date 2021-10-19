package c.i.b.a.y;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f34094a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f34095b;

    /* renamed from: c  reason: collision with root package name */
    public int f34096c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f34097d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f34098e;

    /* renamed from: f  reason: collision with root package name */
    public int f34099f;

    /* renamed from: g  reason: collision with root package name */
    public int f34100g;

    /* renamed from: h  reason: collision with root package name */
    public int f34101h;

    /* renamed from: i  reason: collision with root package name */
    public final MediaCodec.CryptoInfo f34102i;

    /* renamed from: j  reason: collision with root package name */
    public final C1505b f34103j;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @TargetApi(24)
    /* renamed from: c.i.b.a.y.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1505b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f34104a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f34105b;

        public /* synthetic */ C1505b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this(cryptoInfo);
        }

        public final void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f34105b.set(i2, i3);
                this.f34104a.setPattern(this.f34105b);
            }
        }

        public C1505b(MediaCodec.CryptoInfo cryptoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cryptoInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34104a = cryptoInfo;
            this.f34105b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        MediaCodec.CryptoInfo b2 = v.f33865a >= 16 ? b() : null;
        this.f34102i = b2;
        this.f34103j = v.f33865a >= 24 ? new C1505b(b2, null) : null;
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34102i : (MediaCodec.CryptoInfo) invokeV.objValue;
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new MediaCodec.CryptoInfo() : (MediaCodec.CryptoInfo) invokeV.objValue;
    }

    public void c(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), iArr, iArr2, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.f34099f = i2;
            this.f34097d = iArr;
            this.f34098e = iArr2;
            this.f34095b = bArr;
            this.f34094a = bArr2;
            this.f34096c = i3;
            this.f34100g = i4;
            this.f34101h = i5;
            if (v.f33865a >= 16) {
                d();
            }
        }
    }

    @TargetApi(16)
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec.CryptoInfo cryptoInfo = this.f34102i;
            cryptoInfo.numSubSamples = this.f34099f;
            cryptoInfo.numBytesOfClearData = this.f34097d;
            cryptoInfo.numBytesOfEncryptedData = this.f34098e;
            cryptoInfo.key = this.f34095b;
            cryptoInfo.iv = this.f34094a;
            cryptoInfo.mode = this.f34096c;
            if (v.f33865a >= 24) {
                this.f34103j.b(this.f34100g, this.f34101h);
            }
        }
    }
}
