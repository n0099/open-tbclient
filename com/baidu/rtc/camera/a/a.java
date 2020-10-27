package com.baidu.rtc.camera.a;

import android.content.Context;
import android.media.MediaFormat;
import android.util.Log;
import com.baidu.rtc.camera.a.d;
/* loaded from: classes11.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.rtc.camera.filter.a.a che;
    private Context mContext;
    private c chd = null;
    private volatile boolean chf = false;

    public a(Context context, com.baidu.rtc.camera.filter.a.a aVar) {
        this.mContext = context;
        this.che = aVar;
        abz();
    }

    public void aby() {
        abz();
    }

    private void abz() {
        this.chf = false;
        if (this.chd != null) {
            this.chd.release();
            this.chd = new c(this.mContext);
        }
        if (this.chd == null) {
            this.chd = new c(this.mContext);
        }
        this.chd.a(this.che.getEGLContext(), new d.a() { // from class: com.baidu.rtc.camera.a.a.1
            @Override // com.baidu.rtc.camera.a.d.a
            public void onFormatChanged(MediaFormat mediaFormat) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecConfig(byte[] bArr, int i, int i2) {
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecData(byte[] bArr, int i, int i2, int i3, long j) {
                if (b.abA().chi != null) {
                    b.abA().chi.a(bArr, i, i2, i3 == 2 ? 1 : 0, j);
                }
            }

            @Override // com.baidu.rtc.camera.a.d.a
            public void onCodecError(int i) {
                Log.e(a.TAG, "setupTextureEncoder onCodecError -- " + i);
                a.this.chf = true;
                if (b.abA().chi != null) {
                    b.abA().chi.onError(i);
                }
            }
        });
    }

    public void g(int i, long j) {
        if (this.chf) {
            abz();
        }
        if (this.chd != null) {
            this.chd.h(i, j);
        }
    }

    public void release() {
        if (this.chd != null) {
            this.chd.release();
        }
    }
}
