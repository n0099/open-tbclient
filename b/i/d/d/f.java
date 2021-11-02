package b.i.d.d;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public interface f extends j {
    @Override // b.i.d.d.j
    f a(int i2);

    @Override // b.i.d.d.j
    f b(long j);

    @Override // b.i.d.d.j
    f c(CharSequence charSequence);

    @Override // b.i.d.d.j
    f d(CharSequence charSequence, Charset charset);

    HashCode e();

    <T> f g(T t, Funnel<? super T> funnel);

    f h(byte[] bArr, int i2, int i3);

    f i(ByteBuffer byteBuffer);
}
