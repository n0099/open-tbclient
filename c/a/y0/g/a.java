package c.a.y0.g;
/* loaded from: classes9.dex */
public interface a {
    int availableBytes();

    void close();

    void flush();

    byte[] getOutPutBytes();

    void init(int i2, int i3);

    boolean putBytes(byte[] bArr, int i2);

    int receiveBytes(byte[] bArr, int i2);

    void setSpeed(float f2);
}
