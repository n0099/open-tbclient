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
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f29965b;

    /* renamed from: c  reason: collision with root package name */
    public int f29966c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f29967d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f29968e;

    /* renamed from: f  reason: collision with root package name */
    public int f29969f;

    /* renamed from: g  reason: collision with root package name */
    public int f29970g;

    /* renamed from: h  reason: collision with root package name */
    public int f29971h;

    /* renamed from: i  reason: collision with root package name */
    public final MediaCodec.CryptoInfo f29972i;

    /* renamed from: j  reason: collision with root package name */
    public final C1677b f29973j;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @TargetApi(24)
    /* renamed from: c.i.b.a.y.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1677b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaCodec.CryptoInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f29974b;

        public /* synthetic */ C1677b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this(cryptoInfo);
        }

        public final void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f29974b.set(i2, i3);
                this.a.setPattern(this.f29974b);
            }
        }

        public C1677b(MediaCodec.CryptoInfo cryptoInfo) {
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
            this.a = cryptoInfo;
            this.f29974b = new MediaCodec.CryptoInfo.Pattern(0, 0);
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
        MediaCodec.CryptoInfo b2 = v.a >= 16 ? b() : null;
        this.f29972i = b2;
        this.f29973j = v.a >= 24 ? new C1677b(b2, null) : null;
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29972i : (MediaCodec.CryptoInfo) invokeV.objValue;
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
            this.f29969f = i2;
            this.f29967d = iArr;
            this.f29968e = iArr2;
            this.f29965b = bArr;
            this.a = bArr2;
            this.f29966c = i3;
            this.f29970g = i4;
            this.f29971h = i5;
            if (v.a >= 16) {
                d();
            }
        }
    }

    @TargetApi(16)
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec.CryptoInfo cryptoInfo = this.f29972i;
            cryptoInfo.numSubSamples = this.f29969f;
            cryptoInfo.numBytesOfClearData = this.f29967d;
            cryptoInfo.numBytesOfEncryptedData = this.f29968e;
            cryptoInfo.key = this.f29965b;
            cryptoInfo.iv = this.a;
            cryptoInfo.mode = this.f29966c;
            if (v.a >= 24) {
                this.f29973j.b(this.f29970g, this.f29971h);
            }
        }
    }
}
