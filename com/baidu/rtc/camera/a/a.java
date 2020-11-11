package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes11.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a cmZ;
    private Context mContext;
    private c cmY = null;
    private volatile boolean cna = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.cmZ = aVar;
        adZ();
    }

    public void adY() {
        adZ();
    }

    private void adZ() {
        this.cna = false;
        if (this.cmY != null) {
            this.cmY.release();
            this.cmY = new c(this.mContext);
        }
        if (this.cmY == null) {
            this.cmY = new c(this.mContext);
        }
        this.cmY.a(this.cmZ.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.aea().cnd != null) {
                    b.aea().cnd.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.cna = true;
                if (b.aea().cnd != null) {
                    b.aea().cnd.onError(i);
                }
            }
        });
    }

    public void f(int i, long j) {
        if (this.cna) {
            adZ();
        }
        if (this.cmY != null) {
            this.cmY.g(i, j);
        }
    }

    public void release() {
        if (this.cmY != null) {
            this.cmY.release();
        }
    }
}
