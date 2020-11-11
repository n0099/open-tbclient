package com.baidu.swan.apps.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.ap.ag;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.c.d;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.camera.b.b cBf;
    private Timer mTimer;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.camera.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0405a {
        private static final a cBi = new a();
    }

    public static a akp() {
        return C0405a.cBi;
    }

    public boolean a(byte[] bArr, String str, int i, int i2, boolean z) {
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                boolean delete = file.delete();
                if (DEBUG) {
                    Log.d("SwanAppCameraManager", "delete = " + delete);
                }
            }
            if (file.getParentFile() != null) {
                boolean mkdirs = file.getParentFile().mkdirs();
                if (DEBUG) {
                    Log.d("SwanAppCameraManager", "mkdirs = " + mkdirs);
                }
            }
            boolean createNewFile = file.createNewFile();
            if (DEBUG) {
                Log.d("SwanAppCameraManager", "createNewFile = " + createNewFile);
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (i2 != 0 || z) {
                Matrix matrix = new Matrix();
                matrix.reset();
                if (i2 != 0) {
                    matrix.postRotate(i2);
                }
                if (z) {
                    matrix.postScale(-1.0f, 1.0f);
                }
                decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            decodeByteArray.compress(Bitmap.CompressFormat.JPEG, i, bufferedOutputStream);
            bufferedOutputStream.flush();
            d.closeSafely(bufferedOutputStream);
            return true;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        } catch (OutOfMemoryError e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public void a(int i, final com.baidu.swan.apps.camera.b.b bVar) {
        this.cBf = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.camera.a.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.aks();
                }
                a.this.akq();
            }
        }, i);
    }

    public void akq() {
        this.cBf = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
    }

    public void cancelTimer() {
        if (this.cBf != null) {
            this.cBf.cancel();
        }
        akq();
    }

    public void et(boolean z) {
        if (z) {
            cancelTimer();
        }
    }

    public void j(String str, String str2, boolean z) {
        if (ag.us("1.13.0")) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", str);
            hashMap.put("cameraId", str2);
            hashMap.put("eType", z ? BdStatsConstant.StatsType.ERROR : "stop");
            f.azO().b(new com.baidu.swan.apps.event.a.b(PixelReadParams.DEFAULT_FILTER_ID, hashMap));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str);
            jSONObject.put("cameraId", str2);
            jSONObject.put("eType", z ? BdStatsConstant.StatsType.ERROR : "stop");
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.view.b.b.a.b(str, str2, PixelReadParams.DEFAULT_FILTER_ID, jSONObject.optString("eType"), jSONObject);
    }

    public boolean bI(Context context) {
        return Build.VERSION.SDK_INT < 23 || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0;
    }

    public boolean bJ(Context context) {
        return Build.VERSION.SDK_INT < 23 || ActivityCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0;
    }

    public void onRelease() {
        try {
            CameraPreview.releaseCamera();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
