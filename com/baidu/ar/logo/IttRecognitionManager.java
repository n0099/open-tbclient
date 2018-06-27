package com.baidu.ar.logo;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.ar.util.FileUtils;
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.UrlUtils;
import com.baidu.ar.util.Utils;
import com.baidu.tbadk.TbConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IttRecognitionManager {
    private static final String a = IttRecognitionManager.class.getSimpleName();
    private static volatile IttRecognitionManager d;
    private List<LogoModel> b = new ArrayList();
    private List<String> c = new ArrayList();

    private IttRecognitionManager() {
    }

    public static IttRecognitionManager getInstance() {
        if (d == null) {
            synchronized (IttRecognitionManager.class) {
                if (d == null) {
                    d = new IttRecognitionManager();
                }
            }
        }
        return d;
    }

    public void initCloudRecognition(Context context, IttRecognitionCallback ittRecognitionCallback) {
        d.a().a(ittRecognitionCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LogoModel matchLogoKey(List<RecognitionRes> list) {
        if (list.size() > 0 && this.b.size() > 0 && list.size() > 0) {
            for (RecognitionRes recognitionRes : list) {
                Iterator<LogoModel> it = this.b.iterator();
                while (it.hasNext()) {
                    LogoModel next = it.next();
                    String name = recognitionRes.getName();
                    if (name.startsWith(next.getMatchKeyName()) || name.contains(next.getMatchKeyName()) || name.endsWith(next.getMatchKeyName())) {
                        return next;
                    }
                    while (it.hasNext()) {
                    }
                }
            }
        }
        return null;
    }

    public void parseRecognition(String str) {
        this.c.clear();
        this.b.clear();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(FileUtils.readFileText(str));
            if (jSONObject.has("logo")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("logo");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        JSONArray jSONArray = new JSONArray(jSONObject2.getString(next));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            LogoModel logoModel = new LogoModel();
                            logoModel.setHeadName(next);
                            logoModel.setMatchKeyName(string);
                            this.b.add(logoModel);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void releaseInstance() {
        d = null;
        d.a().b();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setYUVFile(byte[] bArr, int i, int i2) {
        Throwable th;
        WeakReference weakReference;
        WeakReference weakReference2;
        WeakReference weakReference3;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
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
                weakReference2 = new WeakReference(Bitmap.createBitmap((int[]) weakReference.get(), i3, i4, Bitmap.Config.ARGB_8888));
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                    weakReference3 = weakReference;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
                weakReference3 = weakReference;
                weakReference2 = null;
            } catch (Throwable th3) {
                th = th3;
                weakReference2 = null;
            }
        } catch (Exception e3) {
            e = e3;
            weakReference3 = null;
            weakReference2 = null;
        } catch (Throwable th4) {
            th = th4;
            weakReference = null;
            weakReference2 = null;
        }
        try {
            if (weakReference2.get() != null) {
                ((Bitmap) weakReference2.get()).compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(TbConfig.TMP_PIC_DIR_NAME, Uri.encode(Base64.encodeToString(byteArray, 1)));
            d.a().a(UrlUtils.URL_LOGO_RECG, hashMap, byteArray);
            if (weakReference2.get() != null) {
                ((Bitmap) weakReference2.get()).recycle();
                weakReference2.clear();
            }
            weakReference4.clear();
            weakReference.clear();
            IoUtils.closeQuietly(byteArrayOutputStream);
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream2 = byteArrayOutputStream;
            weakReference3 = weakReference;
            try {
                e.printStackTrace();
                Log.d(a, e.getMessage());
                if (weakReference2.get() != null) {
                    ((Bitmap) weakReference2.get()).recycle();
                    weakReference2.clear();
                }
                weakReference4.clear();
                weakReference3.clear();
                IoUtils.closeQuietly(byteArrayOutputStream2);
            } catch (Throwable th5) {
                weakReference = weakReference3;
                th = th5;
                if (weakReference2.get() != null) {
                    ((Bitmap) weakReference2.get()).recycle();
                    weakReference2.clear();
                }
                weakReference4.clear();
                weakReference.clear();
                IoUtils.closeQuietly(byteArrayOutputStream2);
                throw th;
            }
        } catch (Throwable th6) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            th = th6;
            if (weakReference2.get() != null) {
            }
            weakReference4.clear();
            weakReference.clear();
            IoUtils.closeQuietly(byteArrayOutputStream2);
            throw th;
        }
    }
}
