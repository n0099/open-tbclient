package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.RestrictTo;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.f;
import com.airbnb.lottie.model.g;
import com.airbnb.lottie.model.layer.Layer;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private final long kA;
    private final float kB;
    private final float kC;
    private final int kD;
    private final int kE;
    private final int kF;
    private final Map<String, List<Layer>> ko;
    private final Map<String, g> kp;
    private final Map<String, com.airbnb.lottie.model.f> kq;
    private final SparseArrayCompat<com.airbnb.lottie.model.g> kr;
    private final LongSparseArray<Layer> ks;
    private final List<Layer> kt;
    private final HashSet<String> ku;
    private final i kv;
    private final Rect kx;
    private final long ky;

    private e(Rect rect, long j, long j2, float f, float f2, int i, int i2, int i3) {
        this.ko = new HashMap();
        this.kp = new HashMap();
        this.kq = new HashMap();
        this.kr = new SparseArrayCompat<>();
        this.ks = new LongSparseArray<>();
        this.kt = new ArrayList();
        this.ku = new HashSet<>();
        this.kv = new i();
        this.kx = rect;
        this.ky = j;
        this.kA = j2;
        this.kB = f;
        this.kC = f2;
        this.kD = i;
        this.kE = i2;
        this.kF = i3;
        if (!com.airbnb.lottie.c.f.a(this, 4, 5, 0)) {
            E("Lottie only supports bodymovin >= 4.5.0");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void E(String str) {
        Log.w("LOTTIE", str);
        this.ku.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.kv.setEnabled(z);
    }

    public i getPerformanceTracker() {
        return this.kv;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer g(long j) {
        return this.ks.get(j);
    }

    public Rect getBounds() {
        return this.kx;
    }

    public long getDuration() {
        return (((float) (this.kA - this.ky)) / this.kB) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMajorVersion() {
        return this.kD;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMinorVersion() {
        return this.kE;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int bh() {
        return this.kF;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long bi() {
        return this.ky;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long bj() {
        return this.kA;
    }

    public List<Layer> bk() {
        return this.kt;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> F(String str) {
        return this.ko.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.g> bl() {
        return this.kr;
    }

    public Map<String, com.airbnb.lottie.model.f> bm() {
        return this.kq;
    }

    public Map<String, g> bn() {
        return this.kp;
    }

    public float bo() {
        return (((float) getDuration()) * this.kB) / 1000.0f;
    }

    public float bp() {
        return this.kC;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.kt) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static com.airbnb.lottie.a a(Context context, String str, h hVar) {
            try {
                return a(context, context.getAssets().open(str), hVar);
            } catch (IOException e) {
                throw new IllegalStateException("Unable to find file " + str, e);
            }
        }

        public static com.airbnb.lottie.a a(Context context, @RawRes int i, h hVar) {
            return a(context, context.getResources().openRawResource(i), hVar);
        }

        public static com.airbnb.lottie.a a(Context context, InputStream inputStream, h hVar) {
            com.airbnb.lottie.model.e eVar = new com.airbnb.lottie.model.e(context.getResources(), hVar);
            eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[]{inputStream});
            return eVar;
        }

        public static com.airbnb.lottie.a a(Resources resources, JSONObject jSONObject, h hVar) {
            com.airbnb.lottie.model.h hVar2 = new com.airbnb.lottie.model.h(resources, hVar);
            hVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[]{jSONObject});
            return hVar2;
        }

        @Nullable
        public static e a(Resources resources, InputStream inputStream) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        return a(resources, new JSONObject(sb.toString()));
                    }
                }
            } catch (IOException e) {
                Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to find file.", e));
                return null;
            } catch (JSONException e2) {
                Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to load JSON.", e2));
                return null;
            } finally {
                com.airbnb.lottie.c.f.closeQuietly(inputStream);
            }
        }

        public static e a(Resources resources, JSONObject jSONObject) {
            float f = resources.getDisplayMetrics().density;
            int optInt = jSONObject.optInt("w", -1);
            int optInt2 = jSONObject.optInt("h", -1);
            Rect rect = (optInt == -1 || optInt2 == -1) ? null : new Rect(0, 0, (int) (optInt * f), (int) (optInt2 * f));
            String[] split = jSONObject.optString(NotifyType.VIBRATE).split("[.]");
            e eVar = new e(rect, jSONObject.optLong("ip", 0L), jSONObject.optLong(com.baidu.fsg.base.statistics.j.d, 0L), (float) jSONObject.optDouble("fr", 0.0d), f, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            JSONArray optJSONArray = jSONObject.optJSONArray("assets");
            b(optJSONArray, eVar);
            a(optJSONArray, eVar);
            b(jSONObject.optJSONObject("fonts"), eVar);
            c(jSONObject.optJSONArray("chars"), eVar);
            a(jSONObject, eVar);
            return eVar;
        }

        private static void a(JSONObject jSONObject, e eVar) {
            int i = 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("layers");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Layer C = Layer.a.C(optJSONArray.optJSONObject(i2), eVar);
                    if (C.dt() == Layer.LayerType.Image) {
                        i++;
                    }
                    a(eVar.kt, eVar.ks, C);
                }
                if (i > 4) {
                    eVar.E("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                }
            }
        }

        private static void a(@Nullable JSONArray jSONArray, e eVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("layers");
                    if (optJSONArray != null) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        LongSparseArray longSparseArray = new LongSparseArray();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            Layer C = Layer.a.C(optJSONArray.optJSONObject(i2), eVar);
                            longSparseArray.put(C.getId(), C);
                            arrayList.add(C);
                        }
                        eVar.ko.put(optJSONObject.optString("id"), arrayList);
                    }
                }
            }
        }

        private static void b(@Nullable JSONArray jSONArray, e eVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject.has("p")) {
                        g c = g.a.c(optJSONObject);
                        eVar.kp.put(c.getId(), c);
                    }
                }
            }
        }

        private static void b(@Nullable JSONObject jSONObject, e eVar) {
            JSONArray optJSONArray;
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("list")) != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    com.airbnb.lottie.model.f e = f.a.e(optJSONArray.optJSONObject(i));
                    eVar.kq.put(e.getName(), e);
                }
            }
        }

        private static void c(@Nullable JSONArray jSONArray, e eVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    com.airbnb.lottie.model.g c = g.a.c(jSONArray.optJSONObject(i), eVar);
                    eVar.kr.put(c.hashCode(), c);
                }
            }
        }

        private static void a(List<Layer> list, LongSparseArray<Layer> longSparseArray, Layer layer) {
            list.add(layer);
            longSparseArray.put(layer.getId(), layer);
        }
    }
}
