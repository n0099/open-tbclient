package c.a.n0.a.v1.f.e0;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import c.a.n0.a.e2.g.h;
import c.a.n0.a.k.e.c.c;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import c.a.n0.a.v1.f.z;
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
public class g extends z implements c.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f6655c;

    /* renamed from: d  reason: collision with root package name */
    public CallbackHandler f6656d;

    /* renamed from: e  reason: collision with root package name */
    public long f6657e;

    /* renamed from: f  reason: collision with root package name */
    public long f6658f;

    /* renamed from: g  reason: collision with root package name */
    public long f6659g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f6660b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f6661c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f6662d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f6663e;

        /* renamed from: c.a.n0.a.v1.f.e0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0489a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ShowFavoriteGuideApi.GuideType a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f6664b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f6665c;

            public RunnableC0489a(a aVar, ShowFavoriteGuideApi.GuideType guideType, String str) {
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
                this.f6665c = aVar;
                this.a = guideType;
                this.f6664b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.n0.a.k.e.c.c l = c.a.n0.a.k.e.c.c.l();
                    a aVar = this.f6665c;
                    c.a.n0.a.t1.e eVar = aVar.f6662d;
                    l.p(aVar.f6663e, (Activity) aVar.f6660b, eVar, this.a, this.f6664b, eVar.V().Q(), this.f6665c.f6663e.f6657e);
                }
            }
        }

        public a(g gVar, String str, Context context, JSONObject jSONObject, c.a.n0.a.t1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, context, jSONObject, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6663e = gVar;
            this.a = str;
            this.f6660b = context;
            this.f6661c = jSONObject;
            this.f6662d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.e2.g.b a = h.a();
                ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(this.a);
                String string = this.f6660b.getString(parse.defaultText);
                this.f6663e.f6655c = this.f6661c.optString("cb");
                String str = this.f6662d.f6344b;
                String str2 = "favorite_guide_count_" + str;
                if (c.a.n0.a.z.b.a.n(str)) {
                    c.a.n0.a.u.d.i("ShowFavoriteGuideAction", "favorite already");
                    h.a().putString(str2, "-1");
                    return;
                }
                String string2 = h.a().getString(str2, "");
                if (TextUtils.equals("-1", string2)) {
                    c.a.n0.a.u.d.i("ShowFavoriteGuideAction", "favorite at one time");
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
                this.f6663e.f6657e = a.getLong("swan_favorite_guide_duration", 3L);
                this.f6663e.f6658f = a.getLong("swan_favorite_guide_intervalDays", 3L);
                this.f6663e.f6659g = a.getLong("swan_favorite_guide_maxTimes", 3L);
                c.a.n0.a.u.d.i("ShowFavoriteGuideAction", "duration=" + this.f6663e.f6657e + ", mIntervalDays=" + this.f6663e.f6658f + ", mMaxTimes=" + this.f6663e.f6659g + " ,storageValue=" + string2);
                if (i2 < this.f6663e.f6659g && currentTimeMillis - j > this.f6663e.f6658f * 86400000) {
                    h.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                    q0.e0(new RunnableC0489a(this, parse, string));
                    return;
                }
                c.a.n0.a.u.d.i("ShowFavoriteGuideAction", "Not satisfying display conditions");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/showFavoriteGuide");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.n0.a.u.d.i("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
            if (!q0.G()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
                c.a.n0.a.u.d.i("ShowFavoriteGuideAction", "not support outside baiduboxapp");
                return false;
            }
            this.f6656d = callbackHandler;
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 != null && eVar != null && (context instanceof Activity)) {
                String optString = a2.optString("type");
                if (c.a.n0.a.k.e.c.c.l().n(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                q.g().execute(new a(this, optString, context, a2, eVar), "ShowFavoriteGuideAction");
                JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                unitedSchemeEntity.result = wrapCallbackParams;
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            c.a.n0.a.u.d.i("ShowFavoriteGuideAction", "params parse error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.n0.a.k.e.c.c.j
    @AnyThread
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f6655c == null || this.f6656d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f6656d.handleSchemeDispatchCallback(this.f6655c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
    }
}
