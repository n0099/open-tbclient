package b.i.b.a.c0.h;

import b.i.b.a.c0.c;
import b.i.b.a.i0.k;
import b.i.b.a.i0.l;
import b.i.b.a.i0.s;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public final class a implements b.i.b.a.c0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final l f31867a;

    /* renamed from: b  reason: collision with root package name */
    public final k f31868b;

    /* renamed from: c  reason: collision with root package name */
    public s f31869c;

    public a() {
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
        this.f31867a = new l();
        this.f31868b = new k();
    }

    @Override // b.i.b.a.c0.a
    public Metadata a(c cVar) throws MetadataDecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            s sVar = this.f31869c;
            if (sVar == null || cVar.j != sVar.e()) {
                s sVar2 = new s(cVar.f32902h);
                this.f31869c = sVar2;
                sVar2.a(cVar.f32902h - cVar.j);
            }
            ByteBuffer byteBuffer = cVar.f32901g;
            byte[] array = byteBuffer.array();
            int limit = byteBuffer.limit();
            this.f31867a.H(array, limit);
            this.f31868b.k(array, limit);
            this.f31868b.n(39);
            long g2 = (this.f31868b.g(1) << 32) | this.f31868b.g(32);
            this.f31868b.n(20);
            int g3 = this.f31868b.g(12);
            int g4 = this.f31868b.g(8);
            Metadata.Entry entry = null;
            this.f31867a.K(14);
            if (g4 == 0) {
                entry = new SpliceNullCommand();
            } else if (g4 == 255) {
                entry = PrivateCommand.parseFromSection(this.f31867a, g3, g2);
            } else if (g4 == 4) {
                entry = SpliceScheduleCommand.parseFromSection(this.f31867a);
            } else if (g4 == 5) {
                entry = SpliceInsertCommand.parseFromSection(this.f31867a, g2, this.f31869c);
            } else if (g4 == 6) {
                entry = TimeSignalCommand.parseFromSection(this.f31867a, g2, this.f31869c);
            }
            return entry == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entry);
        }
        return (Metadata) invokeL.objValue;
    }
}
