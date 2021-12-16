package c.a.q0.a.u.e.f;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.q0.a.u.c.d;
import c.a.q0.a.z2.q0;
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
public class c extends c.a.q0.a.u.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.q0.a.u.e.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0509a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.d2.e f8446e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f8447f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f8448g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f8449h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f8450i;

            /* renamed from: c.a.q0.a.u.e.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class DialogInterface$OnClickListenerC0510a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0509a f8451e;

                public DialogInterface$OnClickListenerC0510a(RunnableC0509a runnableC0509a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0509a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f8451e = runnableC0509a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", QueryResponse.Options.CANCEL);
                            RunnableC0509a runnableC0509a = this.f8451e;
                            runnableC0509a.f8450i.a.d(runnableC0509a.f8448g, new c.a.q0.a.u.h.b(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0509a runnableC0509a2 = this.f8451e;
                            runnableC0509a2.f8450i.a.d(runnableC0509a2.f8448g, new c.a.q0.a.u.h.b(201));
                        }
                    }
                }
            }

            /* renamed from: c.a.q0.a.u.e.f.c$a$a$b */
            /* loaded from: classes.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0509a f8452e;

                public b(RunnableC0509a runnableC0509a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0509a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f8452e = runnableC0509a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0509a runnableC0509a = this.f8452e;
                            runnableC0509a.f8450i.a.d(runnableC0509a.f8448g, new c.a.q0.a.u.h.b(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0509a runnableC0509a2 = this.f8452e;
                            runnableC0509a2.f8450i.a.d(runnableC0509a2.f8448g, new c.a.q0.a.u.h.b(201));
                        }
                    }
                }
            }

            public RunnableC0509a(a aVar, c.a.q0.a.d2.e eVar, JSONObject jSONObject, String str, String str2) {
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
                this.f8450i = aVar;
                this.f8446e = eVar;
                this.f8447f = jSONObject;
                this.f8448g = str;
                this.f8449h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8446e.x() == null || this.f8446e.x().isFinishing() || this.f8446e.x().isDestroyed()) {
                    return;
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f8450i.a.getContext());
                aVar.V(this.f8447f.optString("title"));
                aVar.x(this.f8447f.optString("content"));
                aVar.n(new c.a.q0.a.a3.h.a());
                aVar.m(false);
                if (this.f8447f.optBoolean("showCancel", true)) {
                    aVar.E(this.f8447f.optString("cancelColor"), c.a.q0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f8447f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.f8450i.a.getContext().getString(c.a.q0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0510a(this));
                }
                aVar.R(this.f8447f.optString("confirmColor"), c.a.q0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f8449h, new b(this));
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

        @Override // c.a.q0.a.u.c.d.a
        public c.a.q0.a.u.h.b a(c.a.q0.a.d2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.getContext().getString(c.a.q0.a.h.aiapps_confirm);
                }
                q0.e0(new RunnableC0509a(this, eVar, jSONObject, str, optString));
                return c.a.q0.a.u.h.b.f();
            }
            return (c.a.q0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.q0.a.u.c.b bVar) {
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
                super((c.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.q0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showModal", false);
            return l(str, true, new a(this));
        }
        return (c.a.q0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.q0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }
}
