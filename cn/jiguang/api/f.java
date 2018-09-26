package cn.jiguang.api;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public abstract class f {
    public static final int DEFAULT_RESP_CODE = 0;
    public static final int DEFAULT_RID = 0;
    public static final int DEFAULT_SID = 0;
    public static final int NO_JUID = -1;
    public static final int NO_RESP_CODE = -1;
    public static final int NO_SID = -1;
    private static final int PACKET_SIZE = 7168;
    private static final String TAG = "JProtocol";
    protected ByteBuffer body;
    protected cn.jiguang.d.e.a.a.c head;
    private boolean isRequest;

    public f(boolean z, int i, int i2, long j) {
        this.isRequest = z;
        this.head = new cn.jiguang.d.e.a.a.c(z, i, i2, j);
        this.body = ByteBuffer.allocate(PACKET_SIZE);
    }

    public f(boolean z, int i, int i2, long j, int i3, long j2) {
        this.isRequest = z;
        this.head = new cn.jiguang.d.e.a.a.c(z, 0, i, i2, j, i3, j2);
        this.body = ByteBuffer.allocate(PACKET_SIZE);
    }

    public f(boolean z, Object obj, ByteBuffer byteBuffer) {
        this.isRequest = z;
        this.head = (cn.jiguang.d.e.a.a.c) obj;
        if (byteBuffer != null) {
            this.body = byteBuffer;
            parseBody();
        }
    }

    public f(boolean z, ByteBuffer byteBuffer, byte[] bArr) {
        this.isRequest = z;
        try {
            this.head = new cn.jiguang.d.e.a.a.c(z, bArr);
        } catch (Exception e) {
        }
        if (byteBuffer != null) {
            this.body = byteBuffer;
            parseBody();
        }
    }

    public static byte[] parseHead(Object obj) {
        if (obj != null && (obj instanceof cn.jiguang.d.e.a.a.c)) {
            return ((cn.jiguang.d.e.a.a.c) obj).f();
        }
        return null;
    }

    private final byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] h = cn.jiguang.api.a.c.h(this.body);
        if (h == null) {
            return null;
        }
        this.head.a((this.isRequest ? 24 : 20) + h.length);
        try {
            byteArrayOutputStream.write(this.head.f());
            byteArrayOutputStream.write(h);
        } catch (Exception e) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public ByteBuffer getBody() {
        return this.body;
    }

    public int getCommand() {
        return this.head.a();
    }

    public cn.jiguang.d.e.a.a.c getHead() {
        return this.head;
    }

    public long getJuid() {
        return this.head.c();
    }

    public abstract String getName();

    public Long getRid() {
        return this.head.bL();
    }

    public int getSid() {
        return this.head.d();
    }

    public int getVersion() {
        return this.head.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isNeedParseeErrorMsg();

    protected abstract void parseBody();

    public String toString() {
        return (this.isRequest ? "[Request]" : "[Response]") + " - " + this.head.toString();
    }

    protected abstract void writeBody();

    public final byte[] writeBodyAndToBytes() {
        this.body.clear();
        writeBody();
        this.body.flip();
        return toBytes();
    }

    protected void writeBytes(byte[] bArr) {
        this.body.put(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeInt1(int i) {
        this.body.put((byte) i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeInt2(int i) {
        this.body.putShort((short) i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeInt4(int i) {
        this.body.putInt(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeLong8(long j) {
        this.body.putLong(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeTlv2(String str) {
        this.body.put(cn.jiguang.api.a.c.G(str));
    }
}
