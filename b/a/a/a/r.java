package b.a.a.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.InputDeviceCompat;
import b.a.a.a.k;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.kwad.sdk.core.response.model.AdInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f1150a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Comparator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? -Integer.compare(((q) obj).b(), ((q) obj2).b()) : invokeLL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
    }

    public static int a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65536, null, f2)) == null) ? (int) ((f2 * FunAdSdk.getAppContext().getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    public static int b(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i2, i3, i4)) == null) ? i2 <= i3 ? i3 : Math.min(i2, i4) : invokeIII.intValue;
    }

    public static <T extends q> T c(Random random, Collection<T> collection, b<T> bVar) {
        InterceptResult invokeLLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, random, collection, bVar)) == null) {
            if (random == null || collection == null || collection.isEmpty()) {
                return null;
            }
            b.a.a.a.x.d.g("Start select for class:%s with size:%d", collection.iterator().next().getClass().getSimpleName(), Integer.valueOf(collection.size()));
            ArrayList arrayList = new ArrayList();
            long j2 = 0;
            long j3 = 0;
            for (T t : collection) {
                if (bVar != null) {
                    if (((k.d) bVar).a(t)) {
                        j3 += t.b();
                        arrayList.add(t);
                    }
                } else if (t.a()) {
                    j3 += t.b();
                    arrayList.add(t);
                }
            }
            b.a.a.a.x.d.g("%d of them isSelectable.", Integer.valueOf(arrayList.size()));
            if (arrayList.isEmpty()) {
                b.a.a.a.x.d.g("No one is selected", new Object[0]);
                return null;
            }
            if (arrayList.size() == 1) {
                b.a.a.a.x.d.g("Select the only one", new Object[0]);
                obj = arrayList.get(0);
            } else if (j3 != 0) {
                Collections.sort(arrayList, new a());
                long nextFloat = j3 > 2147483647L ? random.nextFloat() * ((float) j3) : random.nextInt((int) j3);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    T t2 = (T) it.next();
                    j2 += t2.b();
                    if (nextFloat <= j2) {
                        b.a.a.a.x.d.g("Select the weight:%d one with sample:%d weightOffset:%d totalWeight:%d", Integer.valueOf(t2.b()), Long.valueOf(nextFloat), Long.valueOf(j2), Long.valueOf(j3));
                        return t2;
                    }
                }
                throw new IllegalStateException();
            } else {
                b.a.a.a.x.d.g("Select the random one by totalWeight:0", new Object[0]);
                obj = arrayList.get(random.nextInt(arrayList.size()));
            }
            return (T) obj;
        }
        return (T) invokeLLL.objValue;
    }

    public static b.a.a.a.w.p d(AdInfo adInfo) {
        InterceptResult invokeL;
        String str;
        String str2;
        List<AdInfo.AdMaterialInfo.MaterialFeature> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adInfo)) == null) {
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
            return new b.a.a.a.w.p(str5, str6, str7, str11, str8, str9, str10, str3, str, str2, adBaseInfo.clickUrl, adConversionInfo.deeplinkUrl, adBaseInfo.convUrl);
        }
        return (b.a.a.a.w.p) invokeL.objValue;
    }

    public static b.a.a.a.w.p e(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
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
            return new b.a.a.a.w.p(jSONObject.optString("corporation_name"), jSONObject.optString(DocumentOpenUtil.TXT), jSONObject.optString("desc"), jSONObject.optString("img2"), str, str2, str3, jSONObject.optString("img"), null, jSONObject.optString("video"), jSONObject.optString("rl"), jSONObject.optString("customized_invoke_url"), null);
        }
        return (b.a.a.a.w.p) invokeL.objValue;
    }

    public static Object f(String str, Object obj) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, obj)) == null) {
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
        return invokeLL.objValue;
    }

    public static void g(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, view) == null) || view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            b.a.a.a.x.d.f(str, new Object[0]);
        }
    }
}
