package b.a.p0.a.f2.f.e0;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.o2.g.h;
import b.a.p0.a.u.e.c.c;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
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
    public String f4898c;

    /* renamed from: d  reason: collision with root package name */
    public CallbackHandler f4899d;

    /* renamed from: e  reason: collision with root package name */
    public long f4900e;

    /* renamed from: f  reason: collision with root package name */
    public long f4901f;

    /* renamed from: g  reason: collision with root package name */
    public long f4902g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4903e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f4904f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4905g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f4906h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f4907i;

        /* renamed from: b.a.p0.a.f2.f.e0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0174a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShowFavoriteGuideApi.GuideType f4908e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f4909f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f4910g;

            public RunnableC0174a(a aVar, ShowFavoriteGuideApi.GuideType guideType, String str) {
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
                this.f4910g = aVar;
                this.f4908e = guideType;
                this.f4909f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.u.e.c.c l = b.a.p0.a.u.e.c.c.l();
                    a aVar = this.f4910g;
                    b.a.p0.a.d2.e eVar = aVar.f4906h;
                    l.p(aVar.f4907i, (Activity) aVar.f4904f, eVar, this.f4908e, this.f4909f, eVar.V().Q(), this.f4910g.f4907i.f4900e);
                }
            }
        }

        public a(g gVar, String str, Context context, JSONObject jSONObject, b.a.p0.a.d2.e eVar) {
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
            this.f4907i = gVar;
            this.f4903e = str;
            this.f4904f = context;
            this.f4905g = jSONObject;
            this.f4906h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.o2.g.b a2 = h.a();
                ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(this.f4903e);
                String string = this.f4904f.getString(parse.defaultText);
                this.f4907i.f4898c = this.f4905g.optString("cb");
                String str = this.f4906h.f4474f;
                String str2 = "favorite_guide_count_" + str;
                if (b.a.p0.a.j0.b.a.n(str)) {
                    b.a.p0.a.e0.d.i("ShowFavoriteGuideAction", "favorite already");
                    h.a().putString(str2, "-1");
                    return;
                }
                String string2 = h.a().getString(str2, "");
                if (TextUtils.equals("-1", string2)) {
                    b.a.p0.a.e0.d.i("ShowFavoriteGuideAction", "favorite at one time");
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
                this.f4907i.f4900e = a2.getLong("swan_favorite_guide_duration", 3L);
                this.f4907i.f4901f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
                this.f4907i.f4902g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
                b.a.p0.a.e0.d.i("ShowFavoriteGuideAction", "duration=" + this.f4907i.f4900e + ", mIntervalDays=" + this.f4907i.f4901f + ", mMaxTimes=" + this.f4907i.f4902g + " ,storageValue=" + string2);
                if (i3 < this.f4907i.f4902g && currentTimeMillis - j > this.f4907i.f4901f * 86400000) {
                    h.a().putString(str2, (i3 + 1) + "#" + currentTimeMillis);
                    q0.e0(new RunnableC0174a(this, parse, string));
                    return;
                }
                b.a.p0.a.e0.d.i("ShowFavoriteGuideAction", "Not satisfying display conditions");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b.a.p0.a.f2.e eVar) {
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            b.a.p0.a.e0.d.i("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
            if (!q0.G()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
                b.a.p0.a.e0.d.i("ShowFavoriteGuideAction", "not support outside baiduboxapp");
                return false;
            }
            this.f4899d = callbackHandler;
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 != null && eVar != null && (context instanceof Activity)) {
                String optString = a2.optString("type");
                if (b.a.p0.a.u.e.c.c.l().n(optString)) {
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
            b.a.p0.a.e0.d.i("ShowFavoriteGuideAction", "params parse error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.p0.a.u.e.c.c.j
    @AnyThread
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f4898c == null || this.f4899d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f4899d.handleSchemeDispatchCallback(this.f4898c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
    }
}
