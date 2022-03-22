package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.e2.g.h;
import c.a.n0.a.k.c.d;
import c.a.n0.a.k.e.c.c;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import c.a.n0.a.t1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShowFavoriteGuideApi extends d implements c.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f28744f;

    /* renamed from: g  reason: collision with root package name */
    public long f28745g;

    /* renamed from: h  reason: collision with root package name */
    public long f28746h;
    public long i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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
            NORMAL = new GuideType("NORMAL", 0, "bar", -1, 992, R.string.obfuscated_res_0x7f0f0153);
            WEAK = new GuideType("WEAK", 1, "bar-autohide", -1, 865, R.string.obfuscated_res_0x7f0f0153);
            GuideType guideType = new GuideType("TIPS", 2, "tip", 18, -1, R.string.obfuscated_res_0x7f0f0154);
            TIPS = guideType;
            $VALUES = new GuideType[]{NORMAL, WEAK, guideType};
        }

        public GuideType(String str, int i, String str2, @StringRes int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.typeName = str2;
            this.limit = i2;
            this.showWidth4px = i3;
            this.defaultText = i4;
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

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f28747b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f28748c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Activity f28749d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShowFavoriteGuideApi f28750e;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1815a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GuideType a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f28751b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f28752c;

            public RunnableC1815a(a aVar, GuideType guideType, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, guideType, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28752c = aVar;
                this.a = guideType;
                this.f28751b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c l = c.l();
                    a aVar = this.f28752c;
                    ShowFavoriteGuideApi showFavoriteGuideApi = aVar.f28750e;
                    Activity activity = aVar.f28749d;
                    e eVar = aVar.f28748c;
                    l.p(showFavoriteGuideApi, activity, eVar, this.a, this.f28751b, eVar.V().Q(), this.f28752c.f28750e.f28745g);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28750e = showFavoriteGuideApi;
            this.a = str;
            this.f28747b = jSONObject;
            this.f28748c = eVar;
            this.f28749d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.a.n0.a.s0.a.y0().d()) {
                return;
            }
            c.a.n0.a.e2.g.b a = h.a();
            GuideType parse = GuideType.parse(this.a);
            String string = this.f28750e.getContext().getString(parse.defaultText);
            this.f28750e.f28744f = this.f28747b.optString("cb");
            String str = this.f28748c.f6344b;
            String str2 = "favorite_guide_count_" + str;
            if (c.a.n0.a.z.b.a.n(str)) {
                c.a.n0.a.u.d.i("ShowFavoriteGuideApi", "favorite already");
                h.a().putString(str2, "-1");
                return;
            }
            String string2 = h.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                c.a.n0.a.u.d.i("ShowFavoriteGuideApi", "favorite at one time");
                return;
            }
            String[] split = string2.split("#");
            long j = 0;
            int i = 0;
            if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                i = Integer.parseInt(split[0]);
                j = Long.parseLong(split[1]);
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = i;
            this.f28750e.f28745g = a.getLong("swan_favorite_guide_duration", 3L);
            this.f28750e.f28746h = a.getLong("swan_favorite_guide_intervalDays", 3L);
            this.f28750e.i = a.getLong("swan_favorite_guide_maxTimes", 3L);
            c.a.n0.a.u.d.i("ShowFavoriteGuideApi", "duration=" + this.f28750e.f28745g + ", mIntervalDays=" + this.f28750e.f28746h + ", mMaxTimes=" + this.f28750e.i + " ,storageValue=" + string2);
            if (i2 < this.f28750e.i && currentTimeMillis - j > this.f28750e.f28746h * 86400000) {
                h.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                q0.e0(new RunnableC1815a(this, parse, string));
                return;
            }
            c.a.n0.a.u.d.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
            a = iArr;
            try {
                iArr[GuideType.TIPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GuideType.WEAK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowFavoriteGuideApi(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void F(GuideType guideType, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, guideType, str, str2) == null) {
            String f0 = e.f0();
            c.a.n0.a.d2.s.e eVar = new c.a.n0.a.d2.s.e();
            if (guideType == null) {
                str3 = "window";
            } else {
                int i = b.a[guideType.ordinal()];
                str3 = i != 1 ? i != 2 ? "flow_close" : "flow" : "TIPS";
            }
            eVar.f4188b = str3;
            eVar.f4189c = str;
            eVar.f4191e = str2;
            eVar.a("appkey", f0);
            n.x("923", eVar);
        }
    }

    public c.a.n0.a.k.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showFavoriteGuide", false);
            e a0 = e.a0();
            if (a0 == null) {
                return new c.a.n0.a.k.h.b(1001, "SwanApp is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                c.a.n0.a.u.d.c("ShowFavoriteGuideApi", "null activity");
                return new c.a.n0.a.k.h.b(1001, "null activity");
            } else if (!q0.G()) {
                c.a.n0.a.u.d.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
                return new c.a.n0.a.k.h.b(1001, "not support outside baiduboxapp");
            } else {
                Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
                c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
                if (bVar.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("type");
                    if (c.l().n(optString)) {
                        return new c.a.n0.a.k.h.b(202);
                    }
                    q.g().execute(new a(this, optString, jSONObject, a0, x), "ShowFavoriteGuideApi");
                    return c.a.n0.a.k.h.b.f();
                }
                return bVar;
            }
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.e.c.c.j
    @AnyThread
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f28744f == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d(this.f28744f, new c.a.n0.a.k.h.b(0, "success", jSONObject));
    }

    @Override // c.a.n0.a.k.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "Favorite" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "ShowFavoriteGuideApi" : (String) invokeV.objValue;
    }
}
