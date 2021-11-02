package b.a.p0.a.u.e.g;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.u.c.d;
import b.a.p0.a.v2.q0;
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
public class b extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8106a;

        /* renamed from: b.a.p0.a.u.e.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0388a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.a2.e f8107e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f8108f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f8109g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f8110h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f8111i;

            /* renamed from: b.a.p0.a.u.e.g.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class DialogInterface$OnClickListenerC0389a implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0388a f8112e;

                public DialogInterface$OnClickListenerC0389a(RunnableC0388a runnableC0388a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0388a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f8112e = runnableC0388a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", QueryResponse.Options.CANCEL);
                            RunnableC0388a runnableC0388a = this.f8112e;
                            runnableC0388a.f8111i.f8106a.d(runnableC0388a.f8109g, new b.a.p0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (b.a.p0.a.u.c.d.f8000c) {
                                e2.printStackTrace();
                            }
                            RunnableC0388a runnableC0388a2 = this.f8112e;
                            runnableC0388a2.f8111i.f8106a.d(runnableC0388a2.f8109g, new b.a.p0.a.u.h.b(201));
                        }
                    }
                }
            }

            /* renamed from: b.a.p0.a.u.e.g.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class DialogInterface$OnClickListenerC0390b implements DialogInterface.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0388a f8113e;

                public DialogInterface$OnClickListenerC0390b(RunnableC0388a runnableC0388a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0388a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f8113e = runnableC0388a;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "confirm");
                            RunnableC0388a runnableC0388a = this.f8113e;
                            runnableC0388a.f8111i.f8106a.d(runnableC0388a.f8109g, new b.a.p0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (b.a.p0.a.u.c.d.f8000c) {
                                e2.printStackTrace();
                            }
                            RunnableC0388a runnableC0388a2 = this.f8113e;
                            runnableC0388a2.f8111i.f8106a.d(runnableC0388a2.f8109g, new b.a.p0.a.u.h.b(201));
                        }
                    }
                }
            }

            public RunnableC0388a(a aVar, b.a.p0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
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
                this.f8111i = aVar;
                this.f8107e = eVar;
                this.f8108f = jSONObject;
                this.f8109g = str;
                this.f8110h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8107e.x() == null || this.f8107e.x().isFinishing() || this.f8107e.x().isDestroyed()) {
                    return;
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f8111i.f8106a.getContext());
                aVar.V(this.f8108f.optString("title"));
                aVar.x(this.f8108f.optString("content"));
                aVar.n(new b.a.p0.a.w2.h.a());
                aVar.m(false);
                if (this.f8108f.optBoolean("showCancel", true)) {
                    aVar.E(this.f8108f.optString("cancelColor"), b.a.p0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f8108f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.f8111i.f8106a.getContext().getString(b.a.p0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0389a(this));
                }
                aVar.R(this.f8108f.optString("confirmColor"), b.a.p0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f8110h, new DialogInterface$OnClickListenerC0390b(this));
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
            this.f8106a = bVar;
        }

        @Override // b.a.p0.a.u.c.d.b
        public b.a.p0.a.u.h.b a(b.a.p0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("confirmText");
                if (TextUtils.isEmpty(optString)) {
                    optString = this.f8106a.getContext().getString(b.a.p0.a.h.aiapps_confirm);
                }
                q0.b0(new RunnableC0388a(this, eVar, jSONObject, str, optString));
                return new b.a.p0.a.u.h.b(0);
            }
            return (b.a.p0.a.u.h.b) invokeLLL.objValue;
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

    public b.a.p0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            return i(str, true, new a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
