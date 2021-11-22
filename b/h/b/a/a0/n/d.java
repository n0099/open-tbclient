package b.h.b.a.a0.n;

import b.h.b.a.a0.m;
import b.h.b.a.i0.j;
import b.h.b.a.i0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
/* loaded from: classes6.dex */
public final class d extends TagPayloadReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final l f32251b;

    /* renamed from: c  reason: collision with root package name */
    public final l f32252c;

    /* renamed from: d  reason: collision with root package name */
    public int f32253d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32254e;

    /* renamed from: f  reason: collision with root package name */
    public int f32255f;

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
        this.f32251b = new l(j.f33473a);
        this.f32252c = new l(4);
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
                this.f32255f = i2;
                return i2 != 5;
            }
            throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i3);
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void c(l lVar, long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, j) == null) {
            int x = lVar.x();
            long j2 = j + (lVar.j() * 1000);
            if (x == 0 && !this.f32254e) {
                l lVar2 = new l(new byte[lVar.a()]);
                lVar.g(lVar2.f33493a, 0, lVar.a());
                b.h.b.a.j0.a b2 = b.h.b.a.j0.a.b(lVar2);
                this.f32253d = b2.f33549b;
                this.f63866a.b(Format.createVideoSampleFormat(null, "video/avc", null, -1, -1, b2.f33550c, b2.f33551d, -1.0f, b2.f33548a, -1, b2.f33552e, null));
                this.f32254e = true;
            } else if (x == 1 && this.f32254e) {
                byte[] bArr = this.f32252c.f33493a;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i2 = 4 - this.f32253d;
                int i3 = 0;
                while (lVar.a() > 0) {
                    lVar.g(this.f32252c.f33493a, i2, this.f32253d);
                    this.f32252c.J(0);
                    int B = this.f32252c.B();
                    this.f32251b.J(0);
                    this.f63866a.a(this.f32251b, 4);
                    this.f63866a.a(lVar, B);
                    i3 = i3 + 4 + B;
                }
                this.f63866a.c(j2, this.f32255f == 1 ? 1 : 0, i3, 0, null);
            }
        }
    }
}
