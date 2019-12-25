package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes4.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a aQK;
    private Context mContext;
    private c aQJ = null;
    private volatile boolean mRequestEncoderReset = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.aQK = aVar;
        Cq();
    }

    public void Cp() {
        Cq();
    }

    private void Cq() {
        this.mRequestEncoderReset = false;
        if (this.aQJ != null) {
            this.aQJ.release();
            this.aQJ = new c(this.mContext);
        }
        if (this.aQJ == null) {
            this.aQJ = new c(this.mContext);
        }
        this.aQJ.a(this.aQK.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.Cr().aQN != null) {
                    b.Cr().aQN.onEncodeVideoFrameRecived(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.mRequestEncoderReset = true;
                if (b.Cr().aQN != null) {
                    b.Cr().aQN.onError(i);
                }
            }
        });
    }

    public void e(int i, long j) {
        if (this.mRequestEncoderReset) {
            Cq();
        }
        if (this.aQJ != null) {
            this.aQJ.f(i, j);
        }
    }

    public void release() {
        if (this.aQJ != null) {
            this.aQJ.release();
        }
    }
}
