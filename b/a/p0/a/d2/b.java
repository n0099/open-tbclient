package b.a.p0.a.d2;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f4530e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4531f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f4532g;

        public a(b bVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4532g = bVar;
            this.f4530e = z;
            this.f4531f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    b.a.p0.a.d2.a.e(this.f4530e);
                    this.f4532g.d(this.f4531f, new b.a.p0.a.u.h.b(0));
                    return;
                }
                this.f4532g.d(this.f4531f, new b.a.p0.a.u.h.b(10005, "system deny"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public b.a.p0.a.u.h.b q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "params: " + str;
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-hideShareDialog", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) b2.second;
                b.a.p0.a.d2.a.b(new a(this, jSONObject.optBoolean("hide"), jSONObject.optString("cb")));
                return new b.a.p0.a.u.h.b(0);
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
