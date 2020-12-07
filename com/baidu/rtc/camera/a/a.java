package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes11.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a csm;
    private Context mContext;
    private c csl = null;
    private volatile boolean csn = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.csm = aVar;
        agz();
    }

    public void agy() {
        agz();
    }

    private void agz() {
        this.csn = false;
        if (this.csl != null) {
            this.csl.release();
            this.csl = new c(this.mContext);
        }
        if (this.csl == null) {
            this.csl = new c(this.mContext);
        }
        this.csl.a(this.csm.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.agA().csq != null) {
                    b.agA().csq.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.csn = true;
                if (b.agA().csq != null) {
                    b.agA().csq.onError(i);
                }
            }
        });
    }

    public void f(int i, long j) {
        if (this.csn) {
            agz();
        }
        if (this.csl != null) {
            this.csl.g(i, j);
        }
    }

    public void release() {
        if (this.csl != null) {
            this.csl.release();
        }
    }
}
