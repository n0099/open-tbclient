package c.a.n0.a.u.e.g;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.u.c.d;
import c.a.n0.a.v2.q0;
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
public class b extends c.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8562a;

        /* renamed from: c.a.n0.a.u.e.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0383a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.a2.e f8563e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f8564f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f8565g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f8566h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f8567i;

            /* renamed from: c.a.n0.a.u.e.g.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class DialogInterface$OnClickListenerC0384a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0383a f8568e;

                public DialogInterface$OnClickListenerC0384a(RunnableC0383a runnableC0383a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0383a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f8568e = runnableC0383a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", QueryResponse.Options.CANCEL);
                            RunnableC0383a runnableC0383a = this.f8568e;
                            runnableC0383a.f8567i.f8562a.d(runnableC0383a.f8565g, new c.a.n0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (c.a.n0.a.u.c.d.f8453c) {
                                e2.printStackTrace();
                            }
                            RunnableC0383a runnableC0383a2 = this.f8568e;
                            runnableC0383a2.f8567i.f8562a.d(runnableC0383a2.f8565g, new c.a.n0.a.u.h.b(201));
                        }
                    }
                }
            }

            /* renamed from: c.a.n0.a.u.e.g.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class DialogInterface$OnClickListenerC0385b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0383a f8569e;

                public DialogInterface$OnClickListenerC0385b(RunnableC0383a runnableC0383a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0383a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f8569e = runnableC0383a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0383a runnableC0383a = this.f8569e;
                            runnableC0383a.f8567i.f8562a.d(runnableC0383a.f8565g, new c.a.n0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (c.a.n0.a.u.c.d.f8453c) {
                                e2.printStackTrace();
                            }
                            RunnableC0383a runnableC0383a2 = this.f8569e;
                            runnableC0383a2.f8567i.f8562a.d(runnableC0383a2.f8565g, new c.a.n0.a.u.h.b(201));
                        }
                    }
                }
            }

            public RunnableC0383a(a aVar, c.a.n0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
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
                this.f8567i = aVar;
                this.f8563e = eVar;
                this.f8564f = jSONObject;
                this.f8565g = str;
                this.f8566h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8563e.x() == null || this.f8563e.x().isFinishing() || this.f8563e.x().isDestroyed()) {
                    return;
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f8567i.f8562a.i());
                aVar.V(this.f8564f.optString("title"));
                aVar.x(this.f8564f.optString("content"));
                aVar.n(new c.a.n0.a.w2.h.a());
                aVar.m(false);
                if (this.f8564f.optBoolean("showCancel", true)) {
                    aVar.E(this.f8564f.optString("cancelColor"), c.a.n0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f8564f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.f8567i.f8562a.i().getString(c.a.n0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0384a(this));
                }
                aVar.R(this.f8564f.optString("confirmColor"), c.a.n0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f8566h, new DialogInterface$OnClickListenerC0385b(this));
                aVar.X();
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8562a = bVar;
        }

        @Override // c.a.n0.a.u.c.d.b
        public c.a.n0.a.u.h.b a(c.a.n0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.f8562a.i().getString(c.a.n0.a.h.aiapps_confirm);
                }
                q0.b0(new RunnableC0383a(this, eVar, jSONObject, str, optString));
                return new c.a.n0.a.u.h.b(0);
            }
            return (c.a.n0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.n0.a.u.c.b bVar) {
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

    public c.a.n0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            return j(str, true, new a(this));
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }
}
