package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.d2.e;
import b.a.p0.a.h;
import b.a.p0.a.n2.n;
import b.a.p0.a.u.c.d;
import b.a.p0.a.u.e.c.c;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ShowFavoriteGuideApi extends d implements c.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f44257f;

    /* renamed from: g  reason: collision with root package name */
    public long f44258g;

    /* renamed from: h  reason: collision with root package name */
    public long f44259h;

    /* renamed from: i  reason: collision with root package name */
    public long f44260i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class GuideType {
        public static final /* synthetic */ GuideType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final GuideType NORMAL;
        public static final GuideType TIPS;
        public static final GuideType WEAK;
        public transient /* synthetic */ FieldHolder $fh;
        @StringRes
        public int defaultText;
        public int limit;
        public int showWidth4px;
        public String typeName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(984952384, "Lcom/baidu/swan/apps/api/module/favorite/ShowFavoriteGuideApi$GuideType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(984952384, "Lcom/baidu/swan/apps/api/module/favorite/ShowFavoriteGuideApi$GuideType;");
                    return;
                }
            }
            NORMAL = new GuideType("NORMAL", 0, "bar", -1, 992, h.aiapps_favorite_guide_default_hint);
            WEAK = new GuideType("WEAK", 1, "bar-autohide", -1, 865, h.aiapps_favorite_guide_default_hint);
            GuideType guideType = new GuideType("TIPS", 2, "tip", 18, -1, h.aiapps_favorite_guide_default_tips);
            TIPS = guideType;
            $VALUES = new GuideType[]{NORMAL, WEAK, guideType};
        }

        public GuideType(String str, int i2, String str2, @StringRes int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.typeName = str2;
            this.limit = i3;
            this.showWidth4px = i4;
            this.defaultText = i5;
        }

        public static GuideType parse(String str) {
            InterceptResult invokeL;
            GuideType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    for (GuideType guideType : values()) {
                        if (TextUtils.equals(guideType.typeName, str)) {
                            return guideType;
                        }
                    }
                }
                return NORMAL;
            }
            return (GuideType) invokeL.objValue;
        }

        public static GuideType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (GuideType) Enum.valueOf(GuideType.class, str) : (GuideType) invokeL.objValue;
        }

        public static GuideType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (GuideType[]) $VALUES.clone() : (GuideType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44262f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f44263g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f44264h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi f44265i;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1724a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GuideType f44266e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f44267f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f44268g;

            public RunnableC1724a(a aVar, GuideType guideType, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, guideType, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44268g = aVar;
                this.f44266e = guideType;
                this.f44267f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c l = c.l();
                    a aVar = this.f44268g;
                    ShowFavoriteGuideApi showFavoriteGuideApi = aVar.f44265i;
                    Activity activity = aVar.f44264h;
                    e eVar = aVar.f44263g;
                    l.p(showFavoriteGuideApi, activity, eVar, this.f44266e, this.f44267f, eVar.V().Q(), this.f44268g.f44265i.f44258g);
                }
            }
        }

        public a(ShowFavoriteGuideApi showFavoriteGuideApi, String str, JSONObject jSONObject, e eVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {showFavoriteGuideApi, str, jSONObject, eVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44265i = showFavoriteGuideApi;
            this.f44261e = str;
            this.f44262f = jSONObject;
            this.f44263g = eVar;
            this.f44264h = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.a.p0.a.c1.a.y0().d()) {
                return;
            }
            b.a.p0.a.o2.g.b a2 = b.a.p0.a.o2.g.h.a();
            GuideType parse = GuideType.parse(this.f44261e);
            String string = this.f44265i.getContext().getString(parse.defaultText);
            this.f44265i.f44257f = this.f44262f.optString("cb");
            String str = this.f44263g.f4474f;
            String str2 = "favorite_guide_count_" + str;
            if (b.a.p0.a.j0.b.a.n(str)) {
                b.a.p0.a.e0.d.i("ShowFavoriteGuideApi", "favorite already");
                b.a.p0.a.o2.g.h.a().putString(str2, "-1");
                return;
            }
            String string2 = b.a.p0.a.o2.g.h.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                b.a.p0.a.e0.d.i("ShowFavoriteGuideApi", "favorite at one time");
                return;
            }
            String[] split = string2.split("#");
            long j = 0;
            int i2 = 0;
            if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                i2 = Integer.parseInt(split[0]);
                j = Long.parseLong(split[1]);
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = i2;
            this.f44265i.f44258g = a2.getLong("swan_favorite_guide_duration", 3L);
            this.f44265i.f44259h = a2.getLong("swan_favorite_guide_intervalDays", 3L);
            this.f44265i.f44260i = a2.getLong("swan_favorite_guide_maxTimes", 3L);
            b.a.p0.a.e0.d.i("ShowFavoriteGuideApi", "duration=" + this.f44265i.f44258g + ", mIntervalDays=" + this.f44265i.f44259h + ", mMaxTimes=" + this.f44265i.f44260i + " ,storageValue=" + string2);
            if (i3 < this.f44265i.f44260i && currentTimeMillis - j > this.f44265i.f44259h * 86400000) {
                b.a.p0.a.o2.g.h.a().putString(str2, (i3 + 1) + "#" + currentTimeMillis);
                q0.e0(new RunnableC1724a(this, parse, string));
                return;
            }
            b.a.p0.a.e0.d.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44269a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-64725356, "Lcom/baidu/swan/apps/api/module/favorite/ShowFavoriteGuideApi$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-64725356, "Lcom/baidu/swan/apps/api/module/favorite/ShowFavoriteGuideApi$b;");
                    return;
                }
            }
            int[] iArr = new int[GuideType.values().length];
            f44269a = iArr;
            try {
                iArr[GuideType.TIPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44269a[GuideType.WEAK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowFavoriteGuideApi(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void F(GuideType guideType, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, guideType, str, str2) == null) {
            String f0 = e.f0();
            b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
            if (guideType == null) {
                str3 = "window";
            } else {
                int i2 = b.f44269a[guideType.ordinal()];
                str3 = i2 != 1 ? i2 != 2 ? "flow_close" : "flow" : "TIPS";
            }
            eVar.f7380b = str3;
            eVar.f7381c = str;
            eVar.f7383e = str2;
            eVar.a("appkey", f0);
            n.x("923", eVar);
        }
    }

    public b.a.p0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showFavoriteGuide", false);
            e a0 = e.a0();
            if (a0 == null) {
                return new b.a.p0.a.u.h.b(1001, "SwanApp is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                b.a.p0.a.e0.d.c("ShowFavoriteGuideApi", "null activity");
                return new b.a.p0.a.u.h.b(1001, "null activity");
            } else if (!q0.G()) {
                b.a.p0.a.e0.d.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
                return new b.a.p0.a.u.h.b(1001, "not support outside baiduboxapp");
            } else {
                Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
                b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
                if (bVar.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("type");
                    if (c.l().n(optString)) {
                        return new b.a.p0.a.u.h.b(202);
                    }
                    q.g().execute(new a(this, optString, jSONObject, a0, x), "ShowFavoriteGuideApi");
                    return b.a.p0.a.u.h.b.f();
                }
                return bVar;
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.e.c.c.j
    @AnyThread
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f44257f == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d(this.f44257f, new b.a.p0.a.u.h.b(0, "success", jSONObject));
    }

    @Override // b.a.p0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "Favorite" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "ShowFavoriteGuideApi" : (String) invokeV.objValue;
    }
}
