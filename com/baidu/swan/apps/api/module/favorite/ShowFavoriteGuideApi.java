package com.baidu.swan.apps.api.module.favorite;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.aa3;
import com.baidu.tieba.br1;
import com.baidu.tieba.fm2;
import com.baidu.tieba.gb3;
import com.baidu.tieba.lr1;
import com.baidu.tieba.mb3;
import com.baidu.tieba.r93;
import com.baidu.tieba.sf3;
import com.baidu.tieba.sg3;
import com.baidu.tieba.w92;
import com.baidu.tieba.y23;
import com.baidu.tieba.yu1;
import com.baidu.tieba.yz1;
import com.baidu.tieba.zq1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShowFavoriteGuideApi extends br1 implements lr1.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String f;
    public long g;
    public long h;
    public long i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            NORMAL = new GuideType("NORMAL", 0, "bar", -1, 992, R.string.obfuscated_res_0x7f0f015e);
            WEAK = new GuideType("WEAK", 1, "bar-autohide", -1, 865, R.string.obfuscated_res_0x7f0f015e);
            GuideType guideType = new GuideType("TIPS", 2, "tip", 18, -1, R.string.obfuscated_res_0x7f0f015f);
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

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ y23 c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ ShowFavoriteGuideApi e;

        /* renamed from: com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0174a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GuideType a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0174a(a aVar, GuideType guideType, String str) {
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
                this.c = aVar;
                this.a = guideType;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    lr1 l = lr1.l();
                    a aVar = this.c;
                    ShowFavoriteGuideApi showFavoriteGuideApi = aVar.e;
                    Activity activity = aVar.d;
                    y23 y23Var = aVar.c;
                    l.p(showFavoriteGuideApi, activity, y23Var, this.a, this.b, y23Var.W().Q(), this.c.e.g);
                }
            }
        }

        public a(ShowFavoriteGuideApi showFavoriteGuideApi, String str, JSONObject jSONObject, y23 y23Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {showFavoriteGuideApi, str, jSONObject, y23Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = showFavoriteGuideApi;
            this.a = str;
            this.b = jSONObject;
            this.c = y23Var;
            this.d = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || fm2.y0().d()) {
                return;
            }
            gb3 a = mb3.a();
            GuideType parse = GuideType.parse(this.a);
            String string = this.e.getContext().getString(parse.defaultText);
            this.e.f = this.b.optString("cb");
            String str = this.c.b;
            String str2 = "favorite_guide_count_" + str;
            if (w92.n(str)) {
                yz1.i("ShowFavoriteGuideApi", "favorite already");
                mb3.a().putString(str2, "-1");
                return;
            }
            String string2 = mb3.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                yz1.i("ShowFavoriteGuideApi", "favorite at one time");
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
            this.e.g = a.getLong("swan_favorite_guide_duration", 3L);
            this.e.h = a.getLong("swan_favorite_guide_intervalDays", 3L);
            this.e.i = a.getLong("swan_favorite_guide_maxTimes", 3L);
            yz1.i("ShowFavoriteGuideApi", "duration=" + this.e.g + ", mIntervalDays=" + this.e.h + ", mMaxTimes=" + this.e.i + " ,storageValue=" + string2);
            if (i2 < this.e.i && currentTimeMillis - j > this.e.h * 86400000) {
                mb3.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                sg3.e0(new RunnableC0174a(this, parse, string));
                return;
            }
            yz1.i("ShowFavoriteGuideApi", "Not satisfying display conditions");
        }
    }

    /* loaded from: classes2.dex */
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
    public ShowFavoriteGuideApi(@NonNull zq1 zq1Var) {
        super(zq1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zq1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zq1) newInitContext.callArgs[0]);
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
            String g0 = y23.g0();
            aa3 aa3Var = new aa3();
            if (guideType == null) {
                str3 = "window";
            } else {
                int i = b.a[guideType.ordinal()];
                str3 = i != 1 ? i != 2 ? "flow_close" : "flow" : "TIPS";
            }
            aa3Var.b = str3;
            aa3Var.c = str;
            aa3Var.e = str2;
            aa3Var.a("appkey", g0);
            r93.x("923", aa3Var);
        }
    }

    public yu1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showFavoriteGuide", false);
            y23 b0 = y23.b0();
            if (b0 == null) {
                return new yu1(1001, "SwanApp is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                yz1.c("ShowFavoriteGuideApi", "null activity");
                return new yu1(1001, "null activity");
            } else if (!sg3.G()) {
                yz1.i("ShowFavoriteGuideApi", "not support outside baiduboxapp");
                return new yu1(1001, "not support outside baiduboxapp");
            } else {
                Pair<yu1, JSONObject> s = s(str);
                yu1 yu1Var = (yu1) s.first;
                if (yu1Var.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("type");
                    if (lr1.l().n(optString)) {
                        return new yu1(202);
                    }
                    sf3.g().execute(new a(this, optString, jSONObject, b0, w), "ShowFavoriteGuideApi");
                    return yu1.f();
                }
                return yu1Var;
            }
        }
        return (yu1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lr1.j
    @AnyThread
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        d(this.f, new yu1(0, "success", jSONObject));
    }

    @Override // com.baidu.tieba.br1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "Favorite" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "ShowFavoriteGuideApi" : (String) invokeV.objValue;
    }
}
