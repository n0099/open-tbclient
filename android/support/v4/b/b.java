package android.support.v4.b;

import android.util.Log;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.Writer;
/* loaded from: classes.dex */
public class b extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f304a;
    private StringBuilder b = new StringBuilder((int) DERTags.TAGGED);

    public b(String str) {
        this.f304a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.b.append(c);
            }
        }
    }

    private void a() {
        if (this.b.length() > 0) {
            Log.d(this.f304a, this.b.toString());
            this.b.delete(0, this.b.length());
        }
    }
}
