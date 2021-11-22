package b.h.b.a.y;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f33738a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f33739b;

    /* renamed from: c  reason: collision with root package name */
    public int f33740c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f33741d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f33742e;

    /* renamed from: f  reason: collision with root package name */
    public int f33743f;

    /* renamed from: g  reason: collision with root package name */
    public int f33744g;

    /* renamed from: h  reason: collision with root package name */
    public int f33745h;

    /* renamed from: i  reason: collision with root package name */
    public final MediaCodec.CryptoInfo f33746i;
    public final C1541b j;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @TargetApi(24)
    /* renamed from: b.h.b.a.y.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1541b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f33747a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f33748b;

        public /* synthetic */ C1541b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this(cryptoInfo);
        }

        public final void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f33748b.set(i2, i3);
                this.f33747a.setPattern(this.f33748b);
            }
        }

        public C1541b(MediaCodec.CryptoInfo cryptoInfo) {
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
            this.f33747a = cryptoInfo;
            this.f33748b = new MediaCodec.CryptoInfo.Pattern(0, 0);
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
        MediaCodec.CryptoInfo b2 = v.f33519a >= 16 ? b() : null;
        this.f33746i = b2;
        this.j = v.f33519a >= 24 ? new C1541b(b2, null) : null;
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33746i : (MediaCodec.CryptoInfo) invokeV.objValue;
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
            this.f33743f = i2;
            this.f33741d = iArr;
            this.f33742e = iArr2;
            this.f33739b = bArr;
            this.f33738a = bArr2;
            this.f33740c = i3;
            this.f33744g = i4;
            this.f33745h = i5;
            if (v.f33519a >= 16) {
                d();
            }
        }
    }

    @TargetApi(16)
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec.CryptoInfo cryptoInfo = this.f33746i;
            cryptoInfo.numSubSamples = this.f33743f;
            cryptoInfo.numBytesOfClearData = this.f33741d;
            cryptoInfo.numBytesOfEncryptedData = this.f33742e;
            cryptoInfo.key = this.f33739b;
            cryptoInfo.iv = this.f33738a;
            cryptoInfo.mode = this.f33740c;
            if (v.f33519a >= 24) {
                this.j.b(this.f33744g, this.f33745h);
            }
        }
    }
}
