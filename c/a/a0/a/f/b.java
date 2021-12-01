package c.a.a0.a.f;

import android.graphics.Point;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static float f1119j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    public static float f1120k = 0.0f;
    public static float l = 1.0f;
    public static float m = 1.0f;
    public static float n;
    public static List<Point> o;
    public static List<Point> p;
    public static List<Point> q;
    public static List<Point> r;
    public static List<List<Point>> s;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f1121b;

    /* renamed from: c  reason: collision with root package name */
    public float f1122c;

    /* renamed from: d  reason: collision with root package name */
    public float f1123d;

    /* renamed from: e  reason: collision with root package name */
    public float f1124e;

    /* renamed from: f  reason: collision with root package name */
    public List<Point> f1125f;

    /* renamed from: g  reason: collision with root package name */
    public List<Point> f1126g;

    /* renamed from: h  reason: collision with root package name */
    public List<Point> f1127h;

    /* renamed from: i  reason: collision with root package name */
    public List<Point> f1128i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-17099574, "Lc/a/a0/a/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-17099574, "Lc/a/a0/a/f/b;");
                return;
            }
        }
        a();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = f1119j;
        this.f1121b = f1120k;
        this.f1122c = l;
        this.f1123d = m;
        this.f1124e = n;
        this.f1125f = o;
        this.f1126g = p;
        this.f1127h = q;
        this.f1128i = r;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            ArrayList arrayList = new ArrayList();
            o = arrayList;
            arrayList.add(new Point(0, 0));
            o.add(new Point(255, 255));
            ArrayList arrayList2 = new ArrayList();
            p = arrayList2;
            arrayList2.add(new Point(0, 0));
            p.add(new Point(255, 255));
            ArrayList arrayList3 = new ArrayList();
            q = arrayList3;
            arrayList3.add(new Point(0, 0));
            q.add(new Point(255, 255));
            ArrayList arrayList4 = new ArrayList();
            r = arrayList4;
            arrayList4.add(new Point(0, 0));
            r.add(new Point(255, 255));
            ArrayList arrayList5 = new ArrayList();
            s = arrayList5;
            arrayList5.add(o);
            s.add(p);
            s.add(q);
            s.add(r);
        }
    }

    public static b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return null;
            }
            b bVar = new b();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("female");
                if (jSONObject2 != null) {
                    jSONObject2.optDouble("intensity_smooth");
                    jSONObject2.optDouble("intensity_white");
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("male");
                if (jSONObject3 != null) {
                    jSONObject3.optDouble("intensity_smooth");
                    jSONObject3.optDouble("intensity_white");
                }
                bVar.a = (float) jSONObject.optDouble("intensity_sharpness");
                bVar.f1121b = (float) jSONObject.optDouble("intensity_brightness");
                bVar.f1122c = (float) jSONObject.optDouble("intensity_contrast");
                bVar.f1123d = (float) jSONObject.optDouble("intensity_saturation");
                JSONObject optJSONObject = jSONObject.optJSONObject("curves");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    bVar.f1124e = (float) optJSONObject.optDouble("intensity_curves");
                    JSONArray jSONArray = optJSONObject.getJSONArray(PayDataCache.PAY_TYPE_COMPOSITE);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        bVar.f1125f = new CopyOnWriteArrayList();
                        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                            JSONObject jSONObject4 = jSONArray.getJSONObject(i10);
                            if (jSONObject4 == null || jSONObject4.length() <= 0) {
                                i8 = 0;
                                i9 = 0;
                            } else {
                                i9 = jSONObject4.optInt("x");
                                i8 = jSONObject4.optInt("y");
                            }
                            bVar.f1125f.add(new Point(i9, i8));
                        }
                    }
                    JSONArray jSONArray2 = optJSONObject.getJSONArray("red");
                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                        bVar.f1126g = new CopyOnWriteArrayList();
                        for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                            JSONObject jSONObject5 = jSONArray2.getJSONObject(i11);
                            if (jSONObject5 == null || jSONObject5.length() <= 0) {
                                i6 = 0;
                                i7 = 0;
                            } else {
                                i7 = jSONObject5.optInt("x");
                                i6 = jSONObject5.optInt("y");
                            }
                            bVar.f1126g.add(new Point(i7, i6));
                        }
                    }
                    JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                    if (jSONArray3 != null && jSONArray3.length() > 0) {
                        bVar.f1127h = new CopyOnWriteArrayList();
                        for (int i12 = 0; i12 < jSONArray3.length(); i12++) {
                            JSONObject jSONObject6 = jSONArray3.getJSONObject(i12);
                            if (jSONObject6 == null || jSONObject6.length() <= 0) {
                                i4 = 0;
                                i5 = 0;
                            } else {
                                i5 = jSONObject6.optInt("x");
                                i4 = jSONObject6.optInt("y");
                            }
                            bVar.f1127h.add(new Point(i5, i4));
                        }
                    }
                    JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                    if (jSONArray4 != null && jSONArray4.length() > 0) {
                        bVar.f1128i = new CopyOnWriteArrayList();
                        for (int i13 = 0; i13 < jSONArray4.length(); i13++) {
                            JSONObject jSONObject7 = jSONArray4.getJSONObject(i13);
                            if (jSONObject7 == null || jSONObject7.length() <= 0) {
                                i2 = 0;
                                i3 = 0;
                            } else {
                                i3 = jSONObject7.optInt("x");
                                i2 = jSONObject7.optInt("y");
                            }
                            bVar.f1128i.add(new Point(i3, i2));
                        }
                    }
                }
                return bVar;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (b) invokeL.objValue;
    }
}
