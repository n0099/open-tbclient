package com.baidu.ar.cloud;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.cloud.c;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.UrlUtils;
import com.baidu.ar.util.Utils;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class CloudRecognitionManager implements c.a {
    private static final String TAG = CloudRecognitionManager.class.getSimpleName();
    private static volatile CloudRecognitionManager sInstance;
    private a mCallback;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, String str, int i);

        void b(boolean z, String str, int i);
    }

    private CloudRecognitionManager() {
    }

    public static CloudRecognitionManager getInstance() {
        if (sInstance == null) {
            synchronized (CloudRecognitionManager.class) {
                if (sInstance == null) {
                    sInstance = new CloudRecognitionManager();
                }
            }
        }
        return sInstance;
    }

    public static void releaseInstance() {
        sInstance = null;
        c.a().b();
    }

    public void initCloudRecognition(Context context, a aVar) {
        this.mContext = context.getApplicationContext();
        this.mCallback = aVar;
        c.a().a(this);
    }

    @Override // com.baidu.ar.cloud.c.a
    public void onResourceRequest(b bVar, int i) {
        if (this.mCallback != null) {
            if (bVar == null) {
                this.mCallback.b(false, null, i);
                return;
            }
            this.mCallback.a(bVar.a(), bVar.b(), i);
            if (bVar.c() != null) {
                this.mCallback.b(bVar.a(), bVar.c().a(), i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setYUVFile(byte[] bArr, int i, int i2) {
        Throwable th;
        WeakReference weakReference;
        WeakReference weakReference2;
        WeakReference weakReference3;
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bArr == null) {
            return;
        }
        WeakReference weakReference4 = new WeakReference(bArr);
        try {
            int i3 = i / 2;
            int i4 = i2 / 2;
            byte[] cropYuv = Utils.cropYuv((byte[]) weakReference4.get(), i3, i4, bArr, i, i2);
            weakReference = new WeakReference(new int[i3 * i4]);
            try {
                Utils.decodeYUV420SP((int[]) weakReference.get(), cropYuv, i, i2);
                weakReference2 = new WeakReference(Bitmap.createBitmap((int[]) weakReference.get(), i3, i4, Bitmap.Config.RGB_565));
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        if (weakReference2.get() != null) {
                            ((Bitmap) weakReference2.get()).compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
                        }
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
                        hashMap.put(HttpConstants.IS_AIP, ARConfig.getIsAip());
                        hashMap.put("sign", ARConfig.getSignature());
                        hashMap.put(HttpConstants.TIMESTAMP, String.valueOf(ARConfig.getTimestamp()));
                        c.a().a(this.mContext, UrlUtils.getCloudRecgUrl(), hashMap, byteArrayOutputStream2.toByteArray());
                        if (weakReference2.get() != null) {
                            ((Bitmap) weakReference2.get()).recycle();
                            weakReference2.clear();
                        }
                        weakReference4.clear();
                        weakReference.clear();
                        IoUtils.closeQuietly(byteArrayOutputStream2);
                    } catch (Exception e) {
                        e = e;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        weakReference3 = weakReference;
                        try {
                            e.printStackTrace();
                            if (weakReference2.get() != null) {
                                ((Bitmap) weakReference2.get()).recycle();
                                weakReference2.clear();
                            }
                            weakReference4.clear();
                            weakReference3.clear();
                            IoUtils.closeQuietly(byteArrayOutputStream);
                        } catch (Throwable th2) {
                            weakReference = weakReference3;
                            th = th2;
                            if (weakReference2.get() != null) {
                                ((Bitmap) weakReference2.get()).recycle();
                                weakReference2.clear();
                            }
                            weakReference4.clear();
                            weakReference.clear();
                            IoUtils.closeQuietly(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        byteArrayOutputStream = byteArrayOutputStream2;
                        th = th3;
                        if (weakReference2.get() != null) {
                        }
                        weakReference4.clear();
                        weakReference.clear();
                        IoUtils.closeQuietly(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    weakReference3 = weakReference;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e3) {
                e = e3;
                weakReference3 = weakReference;
                weakReference2 = null;
            } catch (Throwable th5) {
                th = th5;
                weakReference2 = null;
            }
        } catch (Exception e4) {
            e = e4;
            weakReference3 = null;
            weakReference2 = null;
        } catch (Throwable th6) {
            th = th6;
            weakReference = null;
            weakReference2 = null;
        }
    }
}
