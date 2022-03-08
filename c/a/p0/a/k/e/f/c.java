package c.a.p0.a.k.e.f;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.k.c.d;
import c.a.p0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.p0.a.k.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.p0.a.k.e.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0345a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.t1.e f5951e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f5952f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f5953g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f5954h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f5955i;

            /* renamed from: c.a.p0.a.k.e.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class DialogInterface$OnClickListenerC0346a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0345a f5956e;

                public DialogInterface$OnClickListenerC0346a(RunnableC0345a runnableC0345a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0345a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5956e = runnableC0345a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", QueryResponse.Options.CANCEL);
                            RunnableC0345a runnableC0345a = this.f5956e;
                            runnableC0345a.f5955i.a.d(runnableC0345a.f5953g, new c.a.p0.a.k.h.b(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0345a runnableC0345a2 = this.f5956e;
                            runnableC0345a2.f5955i.a.d(runnableC0345a2.f5953g, new c.a.p0.a.k.h.b(201));
                        }
                    }
                }
            }

            /* renamed from: c.a.p0.a.k.e.f.c$a$a$b */
            /* loaded from: classes.dex */
            public class b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0345a f5957e;

                public b(RunnableC0345a runnableC0345a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0345a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f5957e = runnableC0345a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0345a runnableC0345a = this.f5957e;
                            runnableC0345a.f5955i.a.d(runnableC0345a.f5953g, new c.a.p0.a.k.h.b(0, jSONObject));
                        } catch (JSONException unused) {
                            RunnableC0345a runnableC0345a2 = this.f5957e;
                            runnableC0345a2.f5955i.a.d(runnableC0345a2.f5953g, new c.a.p0.a.k.h.b(201));
                        }
                    }
                }
            }

            public RunnableC0345a(a aVar, c.a.p0.a.t1.e eVar, JSONObject jSONObject, String str, String str2) {
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
                this.f5955i = aVar;
                this.f5951e = eVar;
                this.f5952f = jSONObject;
                this.f5953g = str;
                this.f5954h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5951e.x() == null || this.f5951e.x().isFinishing() || this.f5951e.x().isDestroyed()) {
                    return;
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f5955i.a.getContext());
                aVar.V(this.f5952f.optString("title"));
                aVar.x(this.f5952f.optString("content"));
                aVar.n(new c.a.p0.a.q2.h.a());
                aVar.m(false);
                if (this.f5952f.optBoolean("showCancel", true)) {
                    aVar.E(this.f5952f.optString("cancelColor"), R.color.aiapps_modal_cancel_color);
                    String optString = this.f5952f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.f5955i.a.getContext().getString(R.string.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0346a(this));
                }
                aVar.R(this.f5952f.optString("confirmColor"), R.color.aiapps_modal_confirm_color);
                aVar.P(this.f5954h, new b(this));
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

        @Override // c.a.p0.a.k.c.d.a
        public c.a.p0.a.k.h.b a(c.a.p0.a.t1.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.a.getContext().getString(R.string.aiapps_confirm);
                }
                q0.e0(new RunnableC0345a(this, eVar, jSONObject, str, optString));
                return c.a.p0.a.k.h.b.f();
            }
            return (c.a.p0.a.k.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.p0.a.k.c.b bVar) {
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
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.p0.a.k.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#showModal", false);
            return l(str, true, new a(this));
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ModalApi" : (String) invokeV.objValue;
    }
}
