package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes6.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a bCt;
    private Context mContext;
    private c bCs = null;
    private volatile boolean mRequestEncoderReset = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.bCt = aVar;
        Pn();
    }

    public void Pm() {
        Pn();
    }

    private void Pn() {
        this.mRequestEncoderReset = false;
        if (this.bCs != null) {
            this.bCs.release();
            this.bCs = new c(this.mContext);
        }
        if (this.bCs == null) {
            this.bCs = new c(this.mContext);
        }
        this.bCs.a(this.bCt.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.Po().bCw != null) {
                    b.Po().bCw.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.mRequestEncoderReset = true;
                if (b.Po().bCw != null) {
                    b.Po().bCw.onError(i);
                }
            }
        });
    }

    public void e(int i, long j) {
        if (this.mRequestEncoderReset) {
            Pn();
        }
        if (this.bCs != null) {
            this.bCs.f(i, j);
        }
    }

    public void release() {
        if (this.bCs != null) {
            this.bCs.release();
        }
    }
}
