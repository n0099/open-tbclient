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
    public byte[] f33958a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f33959b;

    /* renamed from: c  reason: collision with root package name */
    public int f33960c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f33961d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f33962e;

    /* renamed from: f  reason: collision with root package name */
    public int f33963f;

    /* renamed from: g  reason: collision with root package name */
    public int f33964g;

    /* renamed from: h  reason: collision with root package name */
    public int f33965h;

    /* renamed from: i  reason: collision with root package name */
    public final MediaCodec.CryptoInfo f33966i;

    /* renamed from: j  reason: collision with root package name */
    public final C1504b f33967j;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @TargetApi(24)
    /* renamed from: c.i.b.a.y.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1504b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f33968a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f33969b;

        public /* synthetic */ C1504b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this(cryptoInfo);
        }

        public final void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f33969b.set(i2, i3);
                this.f33968a.setPattern(this.f33969b);
            }
        }

        public C1504b(MediaCodec.CryptoInfo cryptoInfo) {
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
            this.f33968a = cryptoInfo;
            this.f33969b = new MediaCodec.CryptoInfo.Pattern(0, 0);
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
        MediaCodec.CryptoInfo b2 = v.f33729a >= 16 ? b() : null;
        this.f33966i = b2;
        this.f33967j = v.f33729a >= 24 ? new C1504b(b2, null) : null;
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33966i : (MediaCodec.CryptoInfo) invokeV.objValue;
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
            this.f33963f = i2;
            this.f33961d = iArr;
            this.f33962e = iArr2;
            this.f33959b = bArr;
            this.f33958a = bArr2;
            this.f33960c = i3;
            this.f33964g = i4;
            this.f33965h = i5;
            if (v.f33729a >= 16) {
                d();
            }
        }
    }

    @TargetApi(16)
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec.CryptoInfo cryptoInfo = this.f33966i;
            cryptoInfo.numSubSamples = this.f33963f;
            cryptoInfo.numBytesOfClearData = this.f33961d;
            cryptoInfo.numBytesOfEncryptedData = this.f33962e;
            cryptoInfo.key = this.f33959b;
            cryptoInfo.iv = this.f33958a;
            cryptoInfo.mode = this.f33960c;
            if (v.f33729a >= 24) {
                this.f33967j.b(this.f33964g, this.f33965h);
            }
        }
    }
}
