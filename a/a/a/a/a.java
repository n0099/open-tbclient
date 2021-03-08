package a.a.a.a;

import a.a.a.a.j;
import android.text.TextUtils;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.google.gson.Gson;
import com.kwad.sdk.core.response.model.AdInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f951a;

    public static <T extends o> T a(Random random, Collection<T> collection, q<T> qVar) {
        if (random == null || collection == null || collection.isEmpty()) {
            return null;
        }
        long j = 0;
        a.a.a.a.v.d.c("Start select for class:%s with size:%d", collection.iterator().next().getClass().getSimpleName(), Integer.valueOf(collection.size()));
        ArrayList arrayList = new ArrayList();
        for (T t : collection) {
            if (qVar != null) {
                if (((j.b) qVar).a(t)) {
                    j += t.b();
                    arrayList.add(t);
                }
            } else if (t.a()) {
                j += t.b();
                arrayList.add(t);
            }
        }
        a.a.a.a.v.d.c("%d of them isSelectable.", Integer.valueOf(arrayList.size()));
        if (arrayList.isEmpty()) {
            a.a.a.a.v.d.c("No one is selected", new Object[0]);
            return null;
        } else if (arrayList.size() == 1) {
            a.a.a.a.v.d.c("Select the only one", new Object[0]);
            return (T) arrayList.get(0);
        } else if (j == 0) {
            a.a.a.a.v.d.c("Select the random one by totalWeight:0", new Object[0]);
            return (T) arrayList.get(random.nextInt(arrayList.size()));
        } else {
            Collections.sort(arrayList, new p());
            long j2 = 0;
            long nextFloat = j > 2147483647L ? random.nextFloat() * ((float) j) : random.nextInt((int) j);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                T t2 = (T) it.next();
                j2 += t2.b();
                if (nextFloat <= j2) {
                    a.a.a.a.v.d.c("Select the weight:%d one with sample:%d weightOffset:%d totalWeight:%d", Integer.valueOf(t2.b()), Long.valueOf(nextFloat), Long.valueOf(j2), Long.valueOf(j));
                    return t2;
                }
            }
            throw new IllegalStateException();
        }
    }

    public static <T> String a(T t) {
        return new Gson().toJson(t);
    }

    public static void a(String str) {
        a.a.a.a.v.d.b(str, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        r5.setAccessible(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        r0 = r5.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        r1.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
        r1 = r2.getSuperclass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        if (r1 == java.lang.Object.class) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object c(String str, Object obj) {
        Class<? super Object> superclass;
        Object obj2 = null;
        if (obj != null) {
            try {
                Class<? super Object> cls = obj.getClass();
                loop0: while (true) {
                    if (cls != null) {
                        Field[] declaredFields = cls.getDeclaredFields();
                        int length = declaredFields.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            Field field = declaredFields[i];
                            if (TextUtils.equals(str, field.getType().getName())) {
                                break loop0;
                            }
                            i++;
                        }
                    }
                    cls = superclass;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj2;
        return obj2;
    }

    public static a.a.a.a.c.p r(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject != null) {
            str3 = optJSONObject.optString("appname");
            str2 = optJSONObject.optString("pkg_name");
            str = optJSONObject.optString("pkgurl");
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        return new a.a.a.a.c.p(jSONObject.optString("corporation_name"), jSONObject.optString(DocumentOpenUtil.TXT), jSONObject.optString("desc"), jSONObject.optString("img2"), str3, str2, str, jSONObject.optString("img"), null, jSONObject.optString("video"), jSONObject.optString("rl"), jSONObject.optString("customized_invoke_url"), null);
    }

    public static a.a.a.a.c.p ai(AdInfo adInfo) {
        String str;
        List<AdInfo.AdMaterialInfo.MaterialFeature> list;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str2 = null;
        String str3 = null;
        AdInfo.AdMaterialInfo adMaterialInfo = adInfo.adMaterialInfo;
        if (adMaterialInfo != null && (list = adMaterialInfo.materialFeatureList) != null && !list.isEmpty()) {
            AdInfo.AdMaterialInfo.MaterialFeature materialFeature = adMaterialInfo.materialFeatureList.get(0);
            str2 = materialFeature.materialUrl;
            str3 = materialFeature.coverUrl;
        }
        String str4 = adBaseInfo.corporationName;
        String str5 = adBaseInfo.productName;
        String str6 = adBaseInfo.adDescription;
        String str7 = adBaseInfo.appName;
        String str8 = adBaseInfo.appPackageName;
        String str9 = adConversionInfo.appDownloadUrl;
        String str10 = adBaseInfo.appIconUrl;
        List<String> list2 = adBaseInfo.appImageUrl;
        if (list2 == null || list2.isEmpty()) {
            str = null;
        } else {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str11 : list2) {
                if (!TextUtils.isEmpty(str11)) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append(str11);
                }
            }
            str = sb.toString();
        }
        return new a.a.a.a.c.p(str4, str5, str6, str10, str7, str8, str9, str, str3, str2, adBaseInfo.clickUrl, adConversionInfo.deeplinkUrl, adBaseInfo.convUrl);
    }
}
