package c.a.p0.a.c2.f.f0;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.k2.g.h;
import c.a.p0.a.u.e.d.b;
import c.a.p0.a.v2.q;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends a0 implements b.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f4833c;

    /* renamed from: d  reason: collision with root package name */
    public CallbackHandler f4834d;

    /* renamed from: e  reason: collision with root package name */
    public long f4835e;

    /* renamed from: f  reason: collision with root package name */
    public long f4836f;

    /* renamed from: g  reason: collision with root package name */
    public long f4837g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4838e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f4839f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4840g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f4841h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f4842i;

        /* renamed from: c.a.p0.a.c2.f.f0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0133a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShowFavoriteGuideApi.GuideType f4843e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f4844f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f4845g;

            public RunnableC0133a(a aVar, ShowFavoriteGuideApi.GuideType guideType, String str) {
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
                this.f4845g = aVar;
                this.f4843e = guideType;
                this.f4844f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.u.e.d.b l = c.a.p0.a.u.e.d.b.l();
                    a aVar = this.f4845g;
                    c.a.p0.a.a2.e eVar = aVar.f4841h;
                    l.p(aVar.f4842i, (Activity) aVar.f4839f, eVar, this.f4843e, this.f4844f, eVar.L().Q(), this.f4845g.f4842i.f4835e);
                }
            }
        }

        public a(g gVar, String str, Context context, JSONObject jSONObject, c.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, context, jSONObject, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4842i = gVar;
            this.f4838e = str;
            this.f4839f = context;
            this.f4840g = jSONObject;
            this.f4841h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.k2.g.b a2 = h.a();
                ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(this.f4838e);
                String string = this.f4839f.getString(parse.defaultText);
                this.f4842i.f4833c = this.f4840g.optString("cb");
                String str = this.f4841h.f4566f;
                String str2 = "favorite_guide_count_" + str;
                if (c.a.p0.a.j0.b.a.n(str)) {
                    c.a.p0.a.e0.d.g("ShowFavoriteGuideAction", "favorite already");
                    h.a().putString(str2, "-1");
                    return;
                }
                String string2 = h.a().getString(str2, "");
                if (TextUtils.equals("-1", string2)) {
                    c.a.p0.a.e0.d.g("ShowFavoriteGuideAction", "favorite at one time");
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
                this.f4842i.f4835e = a2.getLong("swan_favorite_guide_duration", 3L);
                this.f4842i.f4836f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
                this.f4842i.f4837g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
                c.a.p0.a.e0.d.g("ShowFavoriteGuideAction", "duration=" + this.f4842i.f4835e + ", mIntervalDays=" + this.f4842i.f4836f + ", mMaxTimes=" + this.f4842i.f4837g + " ,storageValue=" + string2);
                if (i3 < this.f4842i.f4837g && currentTimeMillis - j2 > this.f4842i.f4836f * 86400000) {
                    h.a().putString(str2, (i3 + 1) + "#" + currentTimeMillis);
                    q0.b0(new RunnableC0133a(this, parse, string));
                    return;
                }
                c.a.p0.a.e0.d.g("ShowFavoriteGuideAction", "Not satisfying display conditions");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showFavoriteGuide");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.p0.a.e0.d.g("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
            if (!q0.G()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
                c.a.p0.a.e0.d.g("ShowFavoriteGuideAction", "not support outside baiduboxapp");
                return false;
            }
            this.f4834d = callbackHandler;
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && eVar != null && (context instanceof Activity)) {
                String optString = a2.optString("type");
                if (c.a.p0.a.u.e.d.b.l().n(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                q.f().execute(new a(this, optString, context, a2, eVar), "ShowFavoriteGuideAction");
                JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                unitedSchemeEntity.result = wrapCallbackParams;
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            c.a.p0.a.e0.d.g("ShowFavoriteGuideAction", "params parse error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.p0.a.u.e.d.b.j
    @AnyThread
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f4833c == null || this.f4834d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f4834d.handleSchemeDispatchCallback(this.f4833c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
    }
}
