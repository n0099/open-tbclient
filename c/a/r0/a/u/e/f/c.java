package c.a.r0.a.u.e.f;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.u.c.d;
import c.a.r0.a.z2.q0;
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
public class c extends c.a.r0.a.u.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.r0.a.u.e.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0577a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.d2.e f9123e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f9124f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f9125g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f9126h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f9127i;

            /* renamed from: c.a.r0.a.u.e.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class DialogInterface$OnClickListenerC0578a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0577a f9128e;

                public DialogInterface$OnClickListenerC0578a(RunnableC0577a runnableC0577a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0577a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9128e = runnableC0577a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", QueryResponse.Options.CANCEL);
                            RunnableC0577a runnableC0577a = this.f9128e;
                            runnableC0577a.f9127i.a.d(runnableC0577a.f9125g, new c.a.r0.a.u.h.b(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0577a runnableC0577a2 = this.f9128e;
                            runnableC0577a2.f9127i.a.d(runnableC0577a2.f9125g, new c.a.r0.a.u.h.b(201));
                        }
                    }
                }
            }

            /* renamed from: c.a.r0.a.u.e.f.c$a$a$b */
            /* loaded from: classes.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0577a f9129e;

                public b(RunnableC0577a runnableC0577a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0577a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9129e = runnableC0577a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0577a runnableC0577a = this.f9129e;
                            runnableC0577a.f9127i.a.d(runnableC0577a.f9125g, new c.a.r0.a.u.h.b(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0577a runnableC0577a2 = this.f9129e;
                            runnableC0577a2.f9127i.a.d(runnableC0577a2.f9125g, new c.a.r0.a.u.h.b(201));
                        }
                    }
                }
            }

            public RunnableC0577a(a aVar, c.a.r0.a.d2.e eVar, JSONObject jSONObject, String str, String str2) {
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
                this.f9127i = aVar;
                this.f9123e = eVar;
                this.f9124f = jSONObject;
                this.f9125g = str;
                this.f9126h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9123e.x() == null || this.f9123e.x().isFinishing() || this.f9123e.x().isDestroyed()) {
                    return;
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f9127i.a.getContext());
                aVar.V(this.f9124f.optString("title"));
                aVar.x(this.f9124f.optString("content"));
                aVar.n(new c.a.r0.a.a3.h.a());
                aVar.m(false);
                if (this.f9124f.optBoolean("showCancel", true)) {
                    aVar.E(this.f9124f.optString("cancelColor"), c.a.r0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f9124f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.f9127i.a.getContext().getString(c.a.r0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0578a(this));
                }
                aVar.R(this.f9124f.optString("confirmColor"), c.a.r0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f9126h, new b(this));
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

        @Override // c.a.r0.a.u.c.d.a
        public c.a.r0.a.u.h.b a(c.a.r0.a.d2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.getContext().getString(c.a.r0.a.h.aiapps_confirm);
                }
                q0.e0(new RunnableC0577a(this, eVar, jSONObject, str, optString));
                return c.a.r0.a.u.h.b.f();
            }
            return (c.a.r0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.r0.a.u.c.b bVar) {
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
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.r0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showModal", false);
            return l(str, true, new a(this));
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }
}
