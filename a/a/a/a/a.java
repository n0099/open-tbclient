package a.a.a.a;

import a.a.a.a.j;
import android.text.TextUtils;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
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
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f998a;

    public static <T extends p> T a(Random random, Collection<T> collection, r<T> rVar) {
        Object obj;
        if (random == null || collection == null || collection.isEmpty()) {
            return null;
        }
        a.a.a.a.x.d.c("Start select for class:%s with size:%d", collection.iterator().next().getClass().getSimpleName(), Integer.valueOf(collection.size()));
        ArrayList arrayList = new ArrayList();
        long j = 0;
        long j2 = 0;
        for (T t : collection) {
            if (rVar != null) {
                if (((j.b) rVar).a(t)) {
                    j2 += t.b();
                    arrayList.add(t);
                }
            } else if (t.a()) {
                j2 += t.b();
                arrayList.add(t);
            }
        }
        a.a.a.a.x.d.c("%d of them isSelectable.", Integer.valueOf(arrayList.size()));
        if (arrayList.isEmpty()) {
            a.a.a.a.x.d.c("No one is selected", new Object[0]);
            return null;
        }
        if (arrayList.size() == 1) {
            a.a.a.a.x.d.c("Select the only one", new Object[0]);
            obj = arrayList.get(0);
        } else if (j2 != 0) {
            Collections.sort(arrayList, new q());
            long nextFloat = j2 > 2147483647L ? random.nextFloat() * ((float) j2) : random.nextInt((int) j2);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                T t2 = (T) it.next();
                j += t2.b();
                if (nextFloat <= j) {
                    a.a.a.a.x.d.c("Select the weight:%d one with sample:%d weightOffset:%d totalWeight:%d", Integer.valueOf(t2.b()), Long.valueOf(nextFloat), Long.valueOf(j), Long.valueOf(j2));
                    return t2;
                }
            }
            throw new IllegalStateException();
        } else {
            a.a.a.a.x.d.c("Select the random one by totalWeight:0", new Object[0]);
            obj = arrayList.get(random.nextInt(arrayList.size()));
        }
        return (T) obj;
    }

    public static Object a(String str, Object obj) {
        Field[] declaredFields;
        if (obj != null) {
            try {
                Class<?> cls = obj.getClass();
                while (cls != null) {
                    for (Field field : cls.getDeclaredFields()) {
                        if (TextUtils.equals(str, field.getType().getName())) {
                            field.setAccessible(true);
                            try {
                                return field.get(obj);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                                return null;
                            }
                        }
                    }
                    cls = cls.getSuperclass();
                    if (cls == Object.class) {
                        break;
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public static <T> String a(T t) {
        return new Gson().toJson(t);
    }

    public static void a(String str) {
        a.a.a.a.x.d.b(str, new Object[0]);
    }

    public static a.a.a.a.w.p a(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("appname");
            String optString2 = optJSONObject.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME);
            str3 = optJSONObject.optString("pkgurl");
            str = optString;
            str2 = optString2;
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        return new a.a.a.a.w.p(jSONObject.optString("corporation_name"), jSONObject.optString(DocumentOpenUtil.TXT), jSONObject.optString("desc"), jSONObject.optString("img2"), str, str2, str3, jSONObject.optString("img"), null, jSONObject.optString("video"), jSONObject.optString("rl"), jSONObject.optString("customized_invoke_url"), null);
    }

    public static a.a.a.a.w.p a(AdInfo adInfo) {
        String str;
        String str2;
        List<AdInfo.AdMaterialInfo.MaterialFeature> list;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        AdInfo.AdMaterialInfo adMaterialInfo = adInfo.adMaterialInfo;
        String str3 = null;
        if (adMaterialInfo == null || (list = adMaterialInfo.materialFeatureList) == null || list.isEmpty()) {
            str = null;
            str2 = null;
        } else {
            AdInfo.AdMaterialInfo.MaterialFeature materialFeature = adMaterialInfo.materialFeatureList.get(0);
            String str4 = materialFeature.materialUrl;
            str = materialFeature.coverUrl;
            str2 = str4;
        }
        String str5 = adBaseInfo.corporationName;
        String str6 = adBaseInfo.productName;
        String str7 = adBaseInfo.adDescription;
        String str8 = adBaseInfo.appName;
        String str9 = adBaseInfo.appPackageName;
        String str10 = adConversionInfo.appDownloadUrl;
        String str11 = adBaseInfo.appIconUrl;
        List<String> list2 = adBaseInfo.appImageUrl;
        if (list2 != null && !list2.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str12 : list2) {
                if (!TextUtils.isEmpty(str12)) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append(str12);
                }
            }
            str3 = sb.toString();
        }
        return new a.a.a.a.w.p(str5, str6, str7, str11, str8, str9, str10, str3, str, str2, adBaseInfo.clickUrl, adConversionInfo.deeplinkUrl, adBaseInfo.convUrl);
    }
}
