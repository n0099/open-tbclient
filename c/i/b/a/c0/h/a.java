package c.i.b.a.c0.h;

import c.i.b.a.c0.c;
import c.i.b.a.i0.k;
import c.i.b.a.i0.l;
import c.i.b.a.i0.s;
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
/* loaded from: classes9.dex */
public final class a implements c.i.b.a.c0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l a;

    /* renamed from: b  reason: collision with root package name */
    public final k f29849b;

    /* renamed from: c  reason: collision with root package name */
    public s f29850c;

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
        this.a = new l();
        this.f29849b = new k();
    }

    @Override // c.i.b.a.c0.a
    public Metadata a(c cVar) throws MetadataDecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            s sVar = this.f29850c;
            if (sVar == null || cVar.f29845j != sVar.e()) {
                s sVar2 = new s(cVar.f30849h);
                this.f29850c = sVar2;
                sVar2.a(cVar.f30849h - cVar.f29845j);
            }
            ByteBuffer byteBuffer = cVar.f30848g;
            byte[] array = byteBuffer.array();
            int limit = byteBuffer.limit();
            this.a.H(array, limit);
            this.f29849b.k(array, limit);
            this.f29849b.n(39);
            long g2 = (this.f29849b.g(1) << 32) | this.f29849b.g(32);
            this.f29849b.n(20);
            int g3 = this.f29849b.g(12);
            int g4 = this.f29849b.g(8);
            Metadata.Entry entry = null;
            this.a.K(14);
            if (g4 == 0) {
                entry = new SpliceNullCommand();
            } else if (g4 == 255) {
                entry = PrivateCommand.parseFromSection(this.a, g3, g2);
            } else if (g4 == 4) {
                entry = SpliceScheduleCommand.parseFromSection(this.a);
            } else if (g4 == 5) {
                entry = SpliceInsertCommand.parseFromSection(this.a, g2, this.f29850c);
            } else if (g4 == 6) {
                entry = TimeSignalCommand.parseFromSection(this.a, g2, this.f29850c);
            }
            return entry == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entry);
        }
        return (Metadata) invokeL.objValue;
    }
}
