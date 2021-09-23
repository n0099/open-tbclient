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
    public byte[] f34090a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f34091b;

    /* renamed from: c  reason: collision with root package name */
    public int f34092c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f34093d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f34094e;

    /* renamed from: f  reason: collision with root package name */
    public int f34095f;

    /* renamed from: g  reason: collision with root package name */
    public int f34096g;

    /* renamed from: h  reason: collision with root package name */
    public int f34097h;

    /* renamed from: i  reason: collision with root package name */
    public final MediaCodec.CryptoInfo f34098i;

    /* renamed from: j  reason: collision with root package name */
    public final C1503b f34099j;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @TargetApi(24)
    /* renamed from: c.i.b.a.y.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1503b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f34100a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f34101b;

        public /* synthetic */ C1503b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this(cryptoInfo);
        }

        public final void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f34101b.set(i2, i3);
                this.f34100a.setPattern(this.f34101b);
            }
        }

        public C1503b(MediaCodec.CryptoInfo cryptoInfo) {
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
            this.f34100a = cryptoInfo;
            this.f34101b = new MediaCodec.CryptoInfo.Pattern(0, 0);
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
        MediaCodec.CryptoInfo b2 = v.f33861a >= 16 ? b() : null;
        this.f34098i = b2;
        this.f34099j = v.f33861a >= 24 ? new C1503b(b2, null) : null;
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34098i : (MediaCodec.CryptoInfo) invokeV.objValue;
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
            this.f34095f = i2;
            this.f34093d = iArr;
            this.f34094e = iArr2;
            this.f34091b = bArr;
            this.f34090a = bArr2;
            this.f34092c = i3;
            this.f34096g = i4;
            this.f34097h = i5;
            if (v.f33861a >= 16) {
                d();
            }
        }
    }

    @TargetApi(16)
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec.CryptoInfo cryptoInfo = this.f34098i;
            cryptoInfo.numSubSamples = this.f34095f;
            cryptoInfo.numBytesOfClearData = this.f34093d;
            cryptoInfo.numBytesOfEncryptedData = this.f34094e;
            cryptoInfo.key = this.f34091b;
            cryptoInfo.iv = this.f34090a;
            cryptoInfo.mode = this.f34092c;
            if (v.f33861a >= 24) {
                this.f34099j.b(this.f34096g, this.f34097h);
            }
        }
    }
}
