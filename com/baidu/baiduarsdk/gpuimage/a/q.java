package com.baidu.baiduarsdk.gpuimage.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.support.v4.view.InputDeviceCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class q extends g {
    protected int[] a;
    private int k;
    private PointF[] l;
    private PointF[] m;
    private PointF[] n;
    private PointF[] o;
    private ArrayList<Float> p;
    private ArrayList<Float> q;
    private ArrayList<Float> r;
    private ArrayList<Float> s;
    private byte[] t;

    public q() {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D toneCurveTexture;\n\n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp float redCurveValue = texture2D(toneCurveTexture, vec2(textureColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(toneCurveTexture, vec2(textureColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(toneCurveTexture, vec2(textureColor.b, 0.0)).b;\n\n     gl_FragColor = vec4(redCurveValue, greenCurveValue, blueCurveValue, textureColor.a);\n }");
        this.a = new int[]{-1};
        PointF[] pointFArr = {new PointF(0.0f, 0.0f), new PointF(0.5f, 0.5f), new PointF(1.0f, 1.0f)};
        this.l = pointFArr;
        this.m = pointFArr;
        this.n = pointFArr;
        this.o = pointFArr;
    }

    private ArrayList<Point> a(Point[] pointArr) {
        ArrayList<Double> b = b(pointArr);
        int size = b != null ? b.size() : 0;
        if (size < 1) {
            return null;
        }
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = b.get(i).doubleValue();
        }
        ArrayList<Point> arrayList = new ArrayList<>(size + 1);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size - 1) {
                break;
            }
            Point point = pointArr[i3];
            Point point2 = pointArr[i3 + 1];
            for (int i4 = point.x; i4 < point2.x; i4++) {
                double d = (i4 - point.x) / (point2.x - point.x);
                double d2 = 1.0d - d;
                double d3 = point2.x - point.x;
                double d4 = ((((((d * d) * d) - d) * dArr[i3 + 1]) + ((((d2 * d2) * d2) - d2) * dArr[i3])) * ((d3 * d3) / 6.0d)) + (point.y * d2) + (point2.y * d);
                if (d4 > 255.0d) {
                    d4 = 255.0d;
                } else if (d4 < 0.0d) {
                    d4 = 0.0d;
                }
                arrayList.add(new Point(i4, (int) Math.round(d4)));
            }
            i2 = i3 + 1;
        }
        if (arrayList.size() == 255) {
            arrayList.add(pointArr[pointArr.length - 1]);
        }
        return arrayList;
    }

    private ArrayList<Double> b(Point[] pointArr) {
        int length = pointArr.length;
        if (length <= 1) {
            return null;
        }
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, length, 3);
        double[] dArr2 = new double[length];
        dArr[0][1] = 1.0d;
        dArr[0][0] = 0.0d;
        dArr[0][2] = 0.0d;
        for (int i = 1; i < length - 1; i++) {
            Point point = pointArr[i - 1];
            Point point2 = pointArr[i];
            Point point3 = pointArr[i + 1];
            dArr[i][0] = (point2.x - point.x) / 6.0d;
            dArr[i][1] = (point3.x - point.x) / 3.0d;
            dArr[i][2] = (point3.x - point2.x) / 6.0d;
            dArr2[i] = ((point3.y - point2.y) / (point3.x - point2.x)) - ((point2.y - point.y) / (point2.x - point.x));
        }
        dArr2[0] = 0.0d;
        dArr2[length - 1] = 0.0d;
        dArr[length - 1][1] = 1.0d;
        dArr[length - 1][0] = 0.0d;
        dArr[length - 1][2] = 0.0d;
        for (int i2 = 1; i2 < length; i2++) {
            double d = dArr[i2][0] / dArr[i2 - 1][1];
            double[] dArr3 = dArr[i2];
            dArr3[1] = dArr3[1] - (dArr[i2 - 1][2] * d);
            dArr[i2][0] = 0.0d;
            dArr2[i2] = dArr2[i2] - (d * dArr2[i2 - 1]);
        }
        for (int i3 = length - 2; i3 >= 0; i3--) {
            double d2 = dArr[i3][2] / dArr[i3 + 1][1];
            double[] dArr4 = dArr[i3];
            dArr4[1] = dArr4[1] - (dArr[i3 + 1][0] * d2);
            dArr[i3][2] = 0.0d;
            dArr2[i3] = dArr2[i3] - (d2 * dArr2[i3 + 1]);
        }
        ArrayList<Double> arrayList = new ArrayList<>(length);
        for (int i4 = 0; i4 < length; i4++) {
            arrayList.add(Double.valueOf(dArr2[i4] / dArr[i4][1]));
        }
        return arrayList;
    }

    private short d(InputStream inputStream) {
        return (short) ((inputStream.read() << 8) | inputStream.read());
    }

    private ArrayList<Float> e(PointF[] pointFArr) {
        if (pointFArr == null || pointFArr.length <= 0) {
            return null;
        }
        PointF[] pointFArr2 = (PointF[]) pointFArr.clone();
        Arrays.sort(pointFArr2, new Comparator<PointF>() { // from class: com.baidu.baiduarsdk.gpuimage.a.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(PointF pointF, PointF pointF2) {
                if (pointF.x < pointF2.x) {
                    return -1;
                }
                return pointF.x > pointF2.x ? 1 : 0;
            }
        });
        Point[] pointArr = new Point[pointFArr2.length];
        for (int i = 0; i < pointFArr.length; i++) {
            PointF pointF = pointFArr2[i];
            pointArr[i] = new Point((int) (pointF.x * 255.0f), (int) (pointF.y * 255.0f));
        }
        ArrayList<Point> a = a(pointArr);
        if (a == null) {
            return null;
        }
        Point point = a.get(0);
        if (point != null && point.x > 0) {
            for (int i2 = point.x; i2 >= 0; i2--) {
                a.add(0, new Point(i2, 0));
            }
        }
        Point point2 = a.get(a.size() - 1);
        if (point2 != null && point2.x < 255) {
            for (int i3 = point2.x + 1; i3 <= 255; i3++) {
                a.add(new Point(i3, 255));
            }
        }
        ArrayList<Float> arrayList = new ArrayList<>(a.size());
        Iterator<Point> it = a.iterator();
        while (it.hasNext()) {
            Point next = it.next();
            Point point3 = new Point(next.x, next.x);
            float sqrt = (float) Math.sqrt(Math.pow(point3.x - next.x, 2.0d) + Math.pow(point3.y - next.y, 2.0d));
            arrayList.add(Float.valueOf(point3.y > next.y ? -sqrt : sqrt));
        }
        return arrayList;
    }

    private void k() {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.q.1
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glActiveTexture(33987);
                GLES20.glBindTexture(3553, q.this.a[0]);
                if (q.this.q.size() < 256 || q.this.r.size() < 256 || q.this.s.size() < 256 || q.this.p.size() < 256) {
                    return;
                }
                q.this.t = new byte[1024];
                for (int i = 0; i < 256; i++) {
                    q.this.t[(i * 4) + 2] = (byte) (((int) Math.min(Math.max(((Float) q.this.p.get(i)).floatValue() + i + ((Float) q.this.s.get(i)).floatValue(), 0.0f), 255.0f)) & 255);
                    q.this.t[(i * 4) + 1] = (byte) (((int) Math.min(Math.max(((Float) q.this.p.get(i)).floatValue() + i + ((Float) q.this.r.get(i)).floatValue(), 0.0f), 255.0f)) & 255);
                    q.this.t[i * 4] = (byte) (((int) Math.min(Math.max(((Float) q.this.p.get(i)).floatValue() + i + ((Float) q.this.q.get(i)).floatValue(), 0.0f), 255.0f)) & 255);
                    q.this.t[(i * 4) + 3] = -1;
                }
                GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(q.this.t));
            }
        });
    }

    private void l() {
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.q.3
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glActiveTexture(33987);
                GLES20.glBindTexture(3553, q.this.a[0]);
                GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(q.this.t));
            }
        });
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        this.k = GLES20.glGetUniformLocation(h(), "toneCurveTexture");
        GLES20.glActiveTexture(33987);
        GLES20.glGenTextures(1, this.a, 0);
        GLES20.glBindTexture(3553, this.a[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        if (this.t == null || this.t.length != 1024) {
            return;
        }
        GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(this.t));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    public void a(InputStream inputStream) {
        try {
            d(inputStream);
            short d = d(inputStream);
            ArrayList arrayList = new ArrayList(d);
            for (short s = 0; s < d; s++) {
                int d2 = d(inputStream);
                PointF[] pointFArr = new PointF[d2];
                for (int i = 0; i < d2; i++) {
                    pointFArr[i] = new PointF(d(inputStream) * 0.003921569f, d(inputStream) * 0.003921569f);
                }
                arrayList.add(pointFArr);
            }
            inputStream.close();
            this.l = (PointF[]) arrayList.get(0);
            this.m = (PointF[]) arrayList.get(1);
            this.n = (PointF[]) arrayList.get(2);
            this.o = (PointF[]) arrayList.get(3);
            a(this.l);
            b(this.m);
            c(this.n);
            d(this.o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NegativeArraySizeException e2) {
            e2.printStackTrace();
        }
    }

    public void a(PointF[] pointFArr) {
        this.l = pointFArr;
        this.p = e(this.l);
        k();
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void b() {
        super.b();
    }

    public void b(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[100];
            while (true) {
                int read = inputStream.read(bArr, 0, 100);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.t = new byte[1024];
            int[] iArr = new int[256];
            int[] iArr2 = new int[256];
            int[] iArr3 = new int[256];
            int[] iArr4 = new int[256];
            for (int i = 0; i < 256; i++) {
                iArr4[i] = byteArray[i];
                if (iArr4[i] < 0) {
                    iArr4[i] = iArr4[i] + 256;
                }
            }
            for (int i2 = 256; i2 < 512; i2++) {
                iArr[i2 + InputDeviceCompat.SOURCE_ANY] = byteArray[i2];
                if (iArr[i2 + InputDeviceCompat.SOURCE_ANY] < 0) {
                    int i3 = i2 + InputDeviceCompat.SOURCE_ANY;
                    iArr[i3] = iArr[i3] + 256;
                }
            }
            for (int i4 = 512; i4 < 768; i4++) {
                iArr2[i4 - 512] = byteArray[i4];
                if (iArr2[i4 - 512] < 0) {
                    int i5 = i4 - 512;
                    iArr2[i5] = iArr2[i5] + 256;
                }
            }
            for (int i6 = 768; i6 < 1024; i6++) {
                iArr3[i6 - 768] = byteArray[i6];
                if (iArr3[i6 - 768] < 0) {
                    int i7 = i6 - 768;
                    iArr3[i7] = iArr3[i7] + 256;
                }
            }
            for (int i8 = 0; i8 < 256; i8++) {
                this.t[i8 * 4] = (byte) (iArr3[iArr4[i8]] & 255);
                this.t[(i8 * 4) + 1] = (byte) (iArr2[iArr4[i8]] & 255);
                this.t[(i8 * 4) + 2] = (byte) (iArr[iArr4[i8]] & 255);
                this.t[(i8 * 4) + 3] = -1;
            }
            l();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }
    }

    public void b(PointF[] pointFArr) {
        this.m = pointFArr;
        this.q = e(this.m);
        k();
    }

    public void c(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[100];
            while (true) {
                int read = inputStream.read(bArr, 0, 100);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.t = new byte[1024];
            int[] iArr = new int[256];
            int[] iArr2 = new int[256];
            int[] iArr3 = new int[256];
            int[] iArr4 = new int[256];
            for (int i = 0; i < 256; i++) {
                iArr4[i] = byteArray[i];
                if (iArr4[i] < 0) {
                    iArr4[i] = iArr4[i] + 256;
                }
            }
            for (int i2 = 256; i2 < 512; i2++) {
                iArr[i2 + InputDeviceCompat.SOURCE_ANY] = byteArray[i2];
                if (iArr[i2 + InputDeviceCompat.SOURCE_ANY] < 0) {
                    int i3 = i2 + InputDeviceCompat.SOURCE_ANY;
                    iArr[i3] = iArr[i3] + 256;
                }
            }
            for (int i4 = 512; i4 < 768; i4++) {
                iArr2[i4 - 512] = byteArray[i4];
                if (iArr2[i4 - 512] < 0) {
                    int i5 = i4 - 512;
                    iArr2[i5] = iArr2[i5] + 256;
                }
            }
            for (int i6 = 768; i6 < 1024; i6++) {
                iArr3[i6 - 768] = byteArray[i6];
                if (iArr3[i6 - 768] < 0) {
                    int i7 = i6 - 768;
                    iArr3[i7] = iArr3[i7] + 256;
                }
            }
            for (int i8 = 0; i8 < 256; i8++) {
                this.t[i8 * 4] = (byte) (iArr4[iArr3[i8]] & 255);
                this.t[(i8 * 4) + 1] = (byte) (iArr4[iArr2[i8]] & 255);
                this.t[(i8 * 4) + 2] = (byte) (iArr4[iArr[i8]] & 255);
                this.t[(i8 * 4) + 3] = -1;
            }
            l();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }
    }

    public void c(PointF[] pointFArr) {
        this.n = pointFArr;
        this.r = e(this.n);
        k();
    }

    public void d(PointF[] pointFArr) {
        this.o = pointFArr;
        this.s = e(this.o);
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void f() {
        if (this.a[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.a[0]);
            GLES20.glUniform1i(this.k, 3);
        }
    }
}
