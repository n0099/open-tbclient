package c.a.p0.a.u.e.f;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.u.c.d;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.p0.a.u.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.p0.a.u.e.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0475a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.d2.e f8137e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f8138f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f8139g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f8140h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f8141i;

            /* renamed from: c.a.p0.a.u.e.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class DialogInterface$OnClickListenerC0476a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0475a f8142e;

                public DialogInterface$OnClickListenerC0476a(RunnableC0475a runnableC0475a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0475a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f8142e = runnableC0475a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", QueryResponse.Options.CANCEL);
                            RunnableC0475a runnableC0475a = this.f8142e;
                            runnableC0475a.f8141i.a.d(runnableC0475a.f8139g, new c.a.p0.a.u.h.b(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0475a runnableC0475a2 = this.f8142e;
                            runnableC0475a2.f8141i.a.d(runnableC0475a2.f8139g, new c.a.p0.a.u.h.b(201));
                        }
                    }
                }
            }

            /* renamed from: c.a.p0.a.u.e.f.c$a$a$b */
            /* loaded from: classes.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0475a f8143e;

                public b(RunnableC0475a runnableC0475a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0475a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f8143e = runnableC0475a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0475a runnableC0475a = this.f8143e;
                            runnableC0475a.f8141i.a.d(runnableC0475a.f8139g, new c.a.p0.a.u.h.b(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0475a runnableC0475a2 = this.f8143e;
                            runnableC0475a2.f8141i.a.d(runnableC0475a2.f8139g, new c.a.p0.a.u.h.b(201));
                        }
                    }
                }
            }

            public RunnableC0475a(a aVar, c.a.p0.a.d2.e eVar, JSONObject jSONObject, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar, jSONObject, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8141i = aVar;
                this.f8137e = eVar;
                this.f8138f = jSONObject;
                this.f8139g = str;
                this.f8140h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8137e.x() == null || this.f8137e.x().isFinishing() || this.f8137e.x().isDestroyed()) {
                    return;
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f8141i.a.getContext());
                aVar.V(this.f8138f.optString("title"));
                aVar.x(this.f8138f.optString("content"));
                aVar.n(new c.a.p0.a.a3.h.a());
                aVar.m(false);
                if (this.f8138f.optBoolean("showCancel", true)) {
                    aVar.E(this.f8138f.optString("cancelColor"), c.a.p0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f8138f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.f8141i.a.getContext().getString(c.a.p0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0476a(this));
                }
                aVar.R(this.f8138f.optString("confirmColor"), c.a.p0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f8140h, new b(this));
                aVar.X();
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.a.u.c.d.a
        public c.a.p0.a.u.h.b a(c.a.p0.a.d2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.getContext().getString(c.a.p0.a.h.aiapps_confirm);
                }
                q0.e0(new RunnableC0475a(this, eVar, jSONObject, str, optString));
                return c.a.p0.a.u.h.b.f();
            }
            return (c.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.p0.a.u.c.b bVar) {
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
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showModal", false);
            return l(str, true, new a(this));
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }
}
