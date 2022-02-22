package c.i.b.a.a0.n;

import c.i.b.a.a0.m;
import c.i.b.a.i0.j;
import c.i.b.a.i0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
/* loaded from: classes9.dex */
public final class d extends TagPayloadReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final l f28824b;

    /* renamed from: c  reason: collision with root package name */
    public final l f28825c;

    /* renamed from: d  reason: collision with root package name */
    public int f28826d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28827e;

    /* renamed from: f  reason: collision with root package name */
    public int f28828f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(m mVar) {
        super(mVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((m) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28824b = new l(j.a);
        this.f28825c = new l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            int x = lVar.x();
            int i2 = (x >> 4) & 15;
            int i3 = x & 15;
            if (i3 == 7) {
                this.f28828f = i2;
                return i2 != 5;
            }
            throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i3);
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void c(l lVar, long j2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, j2) == null) {
            int x = lVar.x();
            long j3 = j2 + (lVar.j() * 1000);
            if (x == 0 && !this.f28827e) {
                l lVar2 = new l(new byte[lVar.a()]);
                lVar.g(lVar2.a, 0, lVar.a());
                c.i.b.a.j0.a b2 = c.i.b.a.j0.a.b(lVar2);
                this.f28826d = b2.f30000b;
                this.a.b(Format.createVideoSampleFormat(null, "video/avc", null, -1, -1, b2.f30001c, b2.f30002d, -1.0f, b2.a, -1, b2.f30003e, null));
                this.f28827e = true;
            } else if (x == 1 && this.f28827e) {
                byte[] bArr = this.f28825c.a;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i2 = 4 - this.f28826d;
                int i3 = 0;
                while (lVar.a() > 0) {
                    lVar.g(this.f28825c.a, i2, this.f28826d);
                    this.f28825c.J(0);
                    int B = this.f28825c.B();
                    this.f28824b.J(0);
                    this.a.a(this.f28824b, 4);
                    this.a.a(lVar, B);
                    i3 = i3 + 4 + B;
                }
                this.a.c(j3, this.f28828f == 1 ? 1 : 0, i3, 0, null);
            }
        }
    }
}
