package a.a.a.a;

import a.a.a.a.j;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f1094a;
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? -Integer.compare(((p) obj).b(), ((p) obj2).b()) : invokeLL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
    }

    public static int a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65536, null, i2, i3, i4)) == null) ? i2 <= i3 ? i3 : Math.min(i2, i4) : invokeIII.intValue;
    }

    public static <T extends p> T a(Random random, Collection<T> collection, b<T> bVar) {
        InterceptResult invokeLLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, random, collection, bVar)) == null) {
            if (random == null || collection == null || collection.isEmpty()) {
                return null;
            }
            a.a.a.a.v.d.c("Start select for class:%s with size:%d", collection.iterator().next().getClass().getSimpleName(), Integer.valueOf(collection.size()));
            ArrayList arrayList = new ArrayList();
            long j = 0;
            long j2 = 0;
            for (T t : collection) {
                if (bVar != null) {
                    if (((j.b) bVar).a(t)) {
                        j2 += t.b();
                        arrayList.add(t);
                    }
                } else if (t.a()) {
                    j2 += t.b();
                    arrayList.add(t);
                }
            }
            a.a.a.a.v.d.c("%d of them isSelectable.", Integer.valueOf(arrayList.size()));
            if (arrayList.isEmpty()) {
                a.a.a.a.v.d.c("No one is selected", new Object[0]);
                return null;
            }
            if (arrayList.size() == 1) {
                a.a.a.a.v.d.c("Select the only one", new Object[0]);
                obj = arrayList.get(0);
            } else if (j2 != 0) {
                Collections.sort(arrayList, new a());
                long nextFloat = j2 > 2147483647L ? random.nextFloat() * ((float) j2) : random.nextInt((int) j2);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    T t2 = (T) it.next();
                    j += t2.b();
                    if (nextFloat <= j) {
                        a.a.a.a.v.d.c("Select the weight:%d one with sample:%d weightOffset:%d totalWeight:%d", Integer.valueOf(t2.b()), Long.valueOf(nextFloat), Long.valueOf(j), Long.valueOf(j2));
                        return t2;
                    }
                }
                throw new IllegalStateException();
            } else {
                a.a.a.a.v.d.c("Select the random one by totalWeight:0", new Object[0]);
                obj = arrayList.get(random.nextInt(arrayList.size()));
            }
            return (T) obj;
        }
        return (T) invokeLLL.objValue;
    }

    public static Object a(String str, Object obj) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, obj)) == null) {
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

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            a.a.a.a.v.d.b(str, new Object[0]);
        }
    }

    public static a.a.a.a.u.p a(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
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
            return new a.a.a.a.u.p(jSONObject.optString("corporation_name"), jSONObject.optString(DocumentOpenUtil.TXT), jSONObject.optString("desc"), jSONObject.optString("img2"), str, str2, str3, jSONObject.optString("img"), null, jSONObject.optString("video"), jSONObject.optString("rl"), jSONObject.optString("customized_invoke_url"), null);
        }
        return (a.a.a.a.u.p) invokeL.objValue;
    }

    public static a.a.a.a.u.p a(AdInfo adInfo) {
        InterceptResult invokeL;
        String str;
        String str2;
        List<AdInfo.AdMaterialInfo.MaterialFeature> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adInfo)) == null) {
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
            return new a.a.a.a.u.p(str5, str6, str7, str11, str8, str9, str10, str3, str, str2, adBaseInfo.clickUrl, adConversionInfo.deeplinkUrl, adBaseInfo.convUrl);
        }
        return (a.a.a.a.u.p) invokeL.objValue;
    }
}
