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
import com.baidu.mobstat.Config;
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
    private final SparseArrayCompat<com.airbnb.lottie.model.g> nA;
    private final LongSparseArray<Layer> nB;
    private final List<Layer> nC;
    private final HashSet<String> nD;
    private final i nE;
    private final Rect nF;
    private final long nG;
    private final long nH;
    private final float nI;
    private final float nJ;
    private final int nK;
    private final int nL;
    private final int nM;
    private final Map<String, List<Layer>> nx;
    private final Map<String, g> ny;
    private final Map<String, com.airbnb.lottie.model.f> nz;

    private e(Rect rect, long j, long j2, float f, float f2, int i, int i2, int i3) {
        this.nx = new HashMap();
        this.ny = new HashMap();
        this.nz = new HashMap();
        this.nA = new SparseArrayCompat<>();
        this.nB = new LongSparseArray<>();
        this.nC = new ArrayList();
        this.nD = new HashSet<>();
        this.nE = new i();
        this.nF = rect;
        this.nG = j;
        this.nH = j2;
        this.nI = f;
        this.nJ = f2;
        this.nK = i;
        this.nL = i2;
        this.nM = i3;
        if (!com.airbnb.lottie.c.f.a(this, 4, 5, 0)) {
            V("Lottie only supports bodymovin >= 4.5.0");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void V(String str) {
        Log.w("LOTTIE", str);
        this.nD.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.nE.setEnabled(z);
    }

    public i getPerformanceTracker() {
        return this.nE;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer l(long j) {
        return this.nB.get(j);
    }

    public Rect getBounds() {
        return this.nF;
    }

    public long getDuration() {
        return (((float) (this.nH - this.nG)) / this.nI) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMajorVersion() {
        return this.nK;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMinorVersion() {
        return this.nL;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int cD() {
        return this.nM;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long cE() {
        return this.nG;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long cF() {
        return this.nH;
    }

    public List<Layer> cG() {
        return this.nC;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> W(String str) {
        return this.nx.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.model.g> cH() {
        return this.nA;
    }

    public Map<String, com.airbnb.lottie.model.f> cI() {
        return this.nz;
    }

    public Map<String, g> cJ() {
        return this.ny;
    }

    public float cK() {
        return (((float) getDuration()) * this.nI) / 1000.0f;
    }

    public float cL() {
        return this.nJ;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.nC) {
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
            int optInt = jSONObject.optInt(Config.DEVICE_WIDTH, -1);
            int optInt2 = jSONObject.optInt("h", -1);
            Rect rect = (optInt == -1 || optInt2 == -1) ? null : new Rect(0, 0, (int) (optInt * f), (int) (optInt2 * f));
            String[] split = jSONObject.optString("v").split("[.]");
            e eVar = new e(rect, jSONObject.optLong("ip", 0L), jSONObject.optLong("op", 0L), (float) jSONObject.optDouble("fr", 0.0d), f, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
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
                    if (C.eP() == Layer.LayerType.Image) {
                        i++;
                    }
                    a(eVar.nC, eVar.nB, C);
                }
                if (i > 4) {
                    eVar.V("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
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
                        eVar.nx.put(optJSONObject.optString("id"), arrayList);
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
                        g i2 = g.a.i(optJSONObject);
                        eVar.ny.put(i2.getId(), i2);
                    }
                }
            }
        }

        private static void b(@Nullable JSONObject jSONObject, e eVar) {
            JSONArray optJSONArray;
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("list")) != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    com.airbnb.lottie.model.f k = f.a.k(optJSONArray.optJSONObject(i));
                    eVar.nz.put(k.getName(), k);
                }
            }
        }

        private static void c(@Nullable JSONArray jSONArray, e eVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    com.airbnb.lottie.model.g c = g.a.c(jSONArray.optJSONObject(i), eVar);
                    eVar.nA.put(c.hashCode(), c);
                }
            }
        }

        private static void a(List<Layer> list, LongSparseArray<Layer> longSparseArray, Layer layer) {
            list.add(layer);
            longSparseArray.put(layer.getId(), layer);
        }
    }
}
