package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a2.e;
import c.a.n0.a.h;
import c.a.n0.a.j2.k;
import c.a.n0.a.u.c.d;
import c.a.n0.a.u.e.d.b;
import c.a.n0.a.v2.q;
import c.a.n0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class ShowFavoriteGuideApi extends d implements b.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f45586d;

    /* renamed from: e  reason: collision with root package name */
    public long f45587e;

    /* renamed from: f  reason: collision with root package name */
    public long f45588f;

    /* renamed from: g  reason: collision with root package name */
    public long f45589g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45591f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f45592g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f45593h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi f45594i;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1722a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ GuideType f45595e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f45596f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f45597g;

            public RunnableC1722a(a aVar, GuideType guideType, String str) {
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
                this.f45597g = aVar;
                this.f45595e = guideType;
                this.f45596f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.n0.a.u.e.d.b l = c.a.n0.a.u.e.d.b.l();
                    a aVar = this.f45597g;
                    ShowFavoriteGuideApi showFavoriteGuideApi = aVar.f45594i;
                    Activity activity = aVar.f45593h;
                    e eVar = aVar.f45592g;
                    l.p(showFavoriteGuideApi, activity, eVar, this.f45595e, this.f45596f, eVar.L().Q(), this.f45597g.f45594i.f45587e);
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
            this.f45594i = showFavoriteGuideApi;
            this.f45590e = str;
            this.f45591f = jSONObject;
            this.f45592g = eVar;
            this.f45593h = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.k2.g.b a2 = c.a.n0.a.k2.g.h.a();
                GuideType parse = GuideType.parse(this.f45590e);
                String string = this.f45594i.i().getString(parse.defaultText);
                this.f45594i.f45586d = this.f45591f.optString("cb");
                String str = this.f45592g.f4284f;
                String str2 = "favorite_guide_count_" + str;
                if (c.a.n0.a.j0.b.a.n(str)) {
                    c.a.n0.a.e0.d.g("Api-showFavoriteGuide", "favorite already");
                    c.a.n0.a.k2.g.h.a().putString(str2, "-1");
                    return;
                }
                String string2 = c.a.n0.a.k2.g.h.a().getString(str2, "");
                if (TextUtils.equals("-1", string2)) {
                    c.a.n0.a.e0.d.g("Api-showFavoriteGuide", "favorite at one time");
                    return;
                }
                String[] split = string2.split("#");
                long j2 = 0;
                int i2 = 0;
                if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                    i2 = Integer.parseInt(split[0]);
                    j2 = Long.parseLong(split[1]);
                }
                long currentTimeMillis = System.currentTimeMillis();
                int i3 = i2;
                this.f45594i.f45587e = a2.getLong("swan_favorite_guide_duration", 3L);
                this.f45594i.f45588f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
                this.f45594i.f45589g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
                c.a.n0.a.e0.d.g("Api-showFavoriteGuide", "duration=" + this.f45594i.f45587e + ", mIntervalDays=" + this.f45594i.f45588f + ", mMaxTimes=" + this.f45594i.f45589g + " ,storageValue=" + string2);
                if (i3 < this.f45594i.f45589g && currentTimeMillis - j2 > this.f45594i.f45588f * 86400000) {
                    c.a.n0.a.k2.g.h.a().putString(str2, (i3 + 1) + "#" + currentTimeMillis);
                    q0.b0(new RunnableC1722a(this, parse, string));
                    return;
                }
                c.a.n0.a.e0.d.g("Api-showFavoriteGuide", "Not satisfying display conditions");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45598a;
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
            f45598a = iArr;
            try {
                iArr[GuideType.TIPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45598a[GuideType.WEAK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowFavoriteGuideApi(@NonNull c.a.n0.a.u.c.b bVar) {
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
                super((c.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void z(GuideType guideType, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, guideType, str, str2) == null) {
            String V = e.V();
            c.a.n0.a.j2.p.e eVar = new c.a.n0.a.j2.p.e();
            if (guideType == null) {
                str3 = "window";
            } else {
                int i2 = b.f45598a[guideType.ordinal()];
                str3 = i2 != 1 ? i2 != 2 ? "flow_close" : "flow" : "TIPS";
            }
            eVar.f6790b = str3;
            eVar.f6791c = str;
            eVar.f6793e = str2;
            eVar.a("appkey", V);
            k.u("923", eVar);
        }
    }

    public c.a.n0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.f8453c) {
                String str2 = "handle: " + str;
            }
            e Q = e.Q();
            if (Q == null) {
                return new c.a.n0.a.u.h.b(1001, "SwanApp is null");
            }
            SwanAppActivity x = Q.x();
            if (x == null) {
                c.a.n0.a.e0.d.b("Api-showFavoriteGuide", "null activity");
                return new c.a.n0.a.u.h.b(1001, "null activity");
            } else if (!q0.G()) {
                c.a.n0.a.e0.d.g("Api-showFavoriteGuide", "not support outside baiduboxapp");
                return new c.a.n0.a.u.h.b(1001, "not support outside baiduboxapp");
            } else {
                Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("Api-showFavoriteGuide", str);
                c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
                if (!bVar.isSuccess()) {
                    if (d.f8453c) {
                        c.a.n0.a.e0.d.b("Api-showFavoriteGuide", "parse fail");
                    }
                    return bVar;
                }
                JSONObject jSONObject = (JSONObject) b2.second;
                String optString = jSONObject.optString("type");
                if (c.a.n0.a.u.e.d.b.l().n(optString)) {
                    return new c.a.n0.a.u.h.b(202);
                }
                q.f().execute(new a(this, optString, jSONObject, Q, x), "Api-showFavoriteGuide");
                return new c.a.n0.a.u.h.b(0);
            }
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.u.e.d.b.j
    @AnyThread
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f45586d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d(this.f45586d, new c.a.n0.a.u.h.b(0, "success", jSONObject));
    }
}
