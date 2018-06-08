package com.baidu.ar.recg;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.recg.feares.b;
import com.baidu.ar.recg.feares.d;
import com.baidu.ar.recg.feares.e;
import com.baidu.ar.recg.feares.f;
import com.baidu.ar.util.ARFileUtils;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.UrlUtils;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ImageRecognitionManager implements IImageRecognition, e {
    private static final String TAG = ImageRecognitionManager.class.getSimpleName();
    private static volatile boolean sFeatureDBInited = false;
    private static volatile ImageRecognitionManager sInstance;
    private ImageRecognitionCallback mCallback;
    private Context mContext;
    private String mFeaDir;
    private String mFeaFileDir;
    private String mFeaJson;

    private ImageRecognitionManager() {
    }

    public static ImageRecognitionManager getInstance() {
        if (sInstance == null) {
            synchronized (ImageRecognitionManager.class) {
                if (sInstance == null) {
                    sInstance = new ImageRecognitionManager();
                }
            }
        }
        return sInstance;
    }

    private static void releaseInstance() {
        sInstance = null;
    }

    private static void setFeatureDBInitedFiled(boolean z) {
        sFeatureDBInited = z;
    }

    @Override // com.baidu.ar.recg.IImageRecognition
    public void initRecognition(Context context, ImageRecognitionCallback imageRecognitionCallback) {
        this.mContext = context;
        this.mCallback = imageRecognitionCallback;
        f.a().a(this);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
        hashMap.put(HttpConstants.IS_AIP, ARConfig.getIsAip());
        hashMap.put("sign", ARConfig.getSignature());
        hashMap.put(HttpConstants.TIMESTAMP, String.valueOf(ARConfig.getTimestamp()));
        f.a().a(UrlUtils.getDeviceRecgUrl(), hashMap);
        Log.d(TAG, "initRecognition !!!");
    }

    @Override // com.baidu.ar.recg.feares.e
    public void onFeatureFilesInit(boolean z) {
        Log.d(TAG, "onFeatureFilesInit result = " + z);
        setFeatureDBInitedFiled(z);
        if (this.mCallback != null) {
            this.mCallback.onFeatureDBInit(z);
        }
    }

    @Override // com.baidu.ar.recg.feares.e
    public void onFeatureFilesUnzip(boolean z) {
        if (z) {
            f.a().a(this.mFeaJson, this.mFeaFileDir);
        } else {
            ARLog.d("unzip failed");
        }
    }

    @Override // com.baidu.ar.recg.feares.e
    public void onFeatureJsonParse(boolean z) {
        Log.d(TAG, "onFeatureJsonParse result = " + z);
    }

    @Override // com.baidu.ar.recg.feares.e
    public void onFeaturesClear(boolean z) {
        Log.d(TAG, "onFeaturesClear result = " + z);
        setFeatureDBInitedFiled(!z);
    }

    @Override // com.baidu.ar.recg.feares.e
    public void onResourceDownload(boolean z, String str) {
        Log.d(TAG, "onResourceDownload result = " + z);
        if (z) {
            new b(this.mContext).a(str);
        }
        if (this.mCallback != null) {
            this.mCallback.onResourceDownload(z);
        }
    }

    @Override // com.baidu.ar.recg.feares.e
    public void onResourceRequest(d dVar) {
        if (dVar == null) {
            Log.e(TAG, "onResourceRequest error!!! response == null");
            return;
        }
        Log.d(TAG, "onResourceRequest response.isSuccess() = " + dVar.a());
        if (dVar.a()) {
            String a = new b(this.mContext).a();
            String b = dVar.d().b();
            String substring = dVar.d().a().substring(dVar.d().a().lastIndexOf("/"));
            this.mFeaDir = ARFileUtils.getARCachePath() + "/feature";
            this.mFeaJson = this.mFeaDir + "/fea.json";
            this.mFeaFileDir = this.mFeaDir + "/fea";
            File file = new File(this.mFeaDir + "/" + substring);
            if (!TextUtils.isEmpty(a) && a.equals(b) && file.exists()) {
                f.a().b(dVar.d(), this.mFeaDir);
            } else {
                f.a().a(dVar.d(), this.mFeaDir);
            }
        }
        if (this.mCallback != null) {
            this.mCallback.onResourceRequest(dVar.a(), dVar.b(), dVar.c());
        }
    }

    @Override // com.baidu.ar.recg.feares.e
    public void onThreadQuit() {
        Log.d(TAG, "onThreadQuit ");
    }

    @Override // com.baidu.ar.recg.feares.e
    public void onYuvImageSearch(boolean z, String str) {
        Log.d(TAG, "onYuvImageSearch result = " + z);
        if (this.mCallback != null) {
            this.mCallback.onRecognizeResult(z, str);
        }
    }

    @Override // com.baidu.ar.recg.IImageRecognition
    public void recognizeFrame(int i, int i2, byte[] bArr) {
        if (sFeatureDBInited) {
            f.a().a(i, i2, bArr);
        }
    }

    @Override // com.baidu.ar.recg.IImageRecognition
    public void release() {
        Log.d(TAG, "release !!!");
        this.mContext = null;
        this.mCallback = null;
        releaseInstance();
    }

    @Override // com.baidu.ar.recg.IImageRecognition
    public void startRecognition() {
        Log.d(TAG, "startRecognition !!!");
        if (TextUtils.isEmpty(this.mFeaJson) || TextUtils.isEmpty(this.mFeaFileDir)) {
            return;
        }
        f.a().a(this);
        f.a().a(this.mFeaJson, this.mFeaFileDir);
    }

    @Override // com.baidu.ar.recg.IImageRecognition
    public void stopRecognition() {
        Log.d(TAG, "stopRecognition !!!");
        f.a().c();
        f.a().d();
    }
}
