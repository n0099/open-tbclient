package com.baidu.ar.paddle;

import com.baidu.ar.algo.a.a.a;
import com.baidu.searchbox.ai.PaddleHelper;
import com.baidu.searchbox.ai.data.ByteMatrix;
import com.baidu.searchbox.ai.data.FloatMatrix;
/* loaded from: classes3.dex */
public class ARPaddleHelper implements a {
    a.b b;
    a.c d;
    PaddleHelper.InitCallback c = new PaddleHelper.InitCallback() { // from class: com.baidu.ar.paddle.ARPaddleHelper.1
        public void onFailure(int i, String str) {
            if (ARPaddleHelper.this.b != null) {
                ARPaddleHelper.this.b.a(i, str);
            }
        }

        public void onInited() {
            if (ARPaddleHelper.this.b != null) {
                ARPaddleHelper.this.b.a();
            }
        }
    };
    PaddleHelper.PredictCallback e = new PaddleHelper.PredictCallback() { // from class: com.baidu.ar.paddle.ARPaddleHelper.2
        public void onFailure(int i, String str) {
            if (ARPaddleHelper.this.d != null) {
                ARPaddleHelper.this.d.a(i, str);
            }
        }

        public void onResult(ByteMatrix byteMatrix) {
        }

        public void onResult(FloatMatrix floatMatrix) {
            if (ARPaddleHelper.this.d != null) {
                a.C0033a c0033a = new a.C0033a();
                if (floatMatrix != null) {
                    c0033a.a(floatMatrix.data, floatMatrix.width, floatMatrix.height);
                    ARPaddleHelper.this.d.a(c0033a);
                }
            }
        }
    };
    PaddleHelper a = new PaddleHelper();

    @Override // com.baidu.ar.algo.a.a.a
    public void close() {
        try {
            this.a.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.algo.a.a.a
    public int init(String str, String str2) {
        return this.a.init(str, str2);
    }

    public int init(byte[] bArr, String str) {
        return this.a.init(bArr, str);
    }

    public void initAsync(String str, String str2, a.b bVar) {
        this.b = bVar;
        this.a.initAsync(str, str2, this.c);
    }

    public void initAsync(byte[] bArr, String str, a.b bVar) {
        this.b = bVar;
        this.a.initAsync(bArr, str, this.c);
    }

    public void predictAsyncForFloatMatrix(float[] fArr, int i, int i2, int i3, a.c cVar) {
        this.d = cVar;
        this.a.predictAsyncForFloatMatrix(fArr, i, i2, i3, this.e);
    }

    @Override // com.baidu.ar.algo.a.a.a
    public a.C0033a predictForFloatMatrix(float[] fArr, int i, int i2, int i3) {
        FloatMatrix predictForFloatMatrix = this.a.predictForFloatMatrix(fArr, i, i2, i3);
        if (predictForFloatMatrix != null) {
            a.C0033a c0033a = new a.C0033a();
            c0033a.a(predictForFloatMatrix.data, predictForFloatMatrix.width, predictForFloatMatrix.height);
            return c0033a;
        }
        return null;
    }
}
