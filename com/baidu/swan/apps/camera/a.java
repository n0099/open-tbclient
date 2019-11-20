package com.baidu.swan.apps.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.an.y;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.view.container.c.d;
import com.baidu.swan.apps.w.e;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.camera.c.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.camera.b.b aEG;
    private Timer mTimer;

    private a() {
    }

    /* renamed from: com.baidu.swan.apps.camera.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0164a {
        private static final a aEJ = new a();
    }

    public static a CE() {
        return C0164a.aEJ;
    }

    public boolean a(byte[] bArr, String str, int i, int i2) {
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
            if (i2 != 0) {
                Matrix matrix = new Matrix();
                matrix.reset();
                matrix.postRotate(i2);
                decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            decodeByteArray.compress(Bitmap.CompressFormat.JPEG, i, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
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

    public CameraPreview dT(String str) {
        if (TextUtils.isEmpty(str) || aEZ.isEmpty()) {
            return null;
        }
        for (CameraPreview cameraPreview : aEZ) {
            if (cameraPreview != null && TextUtils.equals(cameraPreview.getSlaveId(), str)) {
                return cameraPreview;
            }
        }
        return null;
    }

    public void a(CameraPreview cameraPreview) {
        aEZ.add(cameraPreview);
    }

    public void dU(String str) {
        CameraPreview cameraPreview;
        if (!TextUtils.isEmpty(str) && !aEZ.isEmpty()) {
            Iterator<CameraPreview> it = aEZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cameraPreview = null;
                    break;
                }
                cameraPreview = it.next();
                if (cameraPreview != null && TextUtils.equals(cameraPreview.getSlaveId(), str)) {
                    break;
                }
            }
            if (cameraPreview != null) {
                cameraPreview.CK();
                aEZ.remove(cameraPreview);
            }
        }
    }

    public void a(int i, final com.baidu.swan.apps.camera.b.b bVar) {
        this.aEG = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.camera.a.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.CI();
                }
                a.this.CF();
            }
        }, i);
    }

    public void CF() {
        this.aEG = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
    }

    public void CG() {
        if (this.aEG != null) {
            this.aEG.cancel();
        }
        CF();
    }

    public void bl(boolean z) {
        if (z) {
            CG();
        }
    }

    public void f(String str, String str2, boolean z) {
        if (y.iT("1.13.0")) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", str);
            hashMap.put("cameraId", str2);
            hashMap.put("eType", z ? BdStatsConstant.StatsType.ERROR : "stop");
            e.LE().a(new com.baidu.swan.apps.m.a.b("camera", hashMap));
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
        d.a(str, str2, "camera", jSONObject.optString("eType"), jSONObject);
    }

    public boolean aO(Context context) {
        return Build.VERSION.SDK_INT < 23 || ActivityCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0;
    }

    public boolean aP(Context context) {
        return Build.VERSION.SDK_INT < 23 || ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }
}
