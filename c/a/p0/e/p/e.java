package c.a.p0.e.p;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.v2.n0;
import c.a.p0.a.v2.q0;
import c.a.p0.a.v2.r0;
import c.a.p0.a.z1.b.c.a;
import c.a.p0.a.z1.b.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.DatePickerDialog;
import com.baidu.swan.apps.res.widget.dialog.MultiPickerDialog;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog;
import com.baidu.swan.apps.res.widget.dialog.TimePickerDialog;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes.dex */
public class e extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SwanAppPickerDialog f10450a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f10451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f10452f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f10453g;

        public a(e eVar, List list, Context context, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, list, context, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10451e = list;
            this.f10452f = context;
            this.f10453g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (String) this.f10451e.get(i2) : (String) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10451e.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = View.inflate(this.f10452f, c.a.p0.a.g.aiapps_scheme_utils_show_action_sheet_item, null);
                }
                TextView textView = (TextView) view.findViewById(c.a.p0.a.f.text);
                textView.setTextColor(this.f10453g);
                textView.setText(getItem(i2));
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10455f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f10456g;

        public b(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, SwanAppAlertDialog swanAppAlertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity, swanAppAlertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10454e = callbackHandler;
            this.f10455f = unitedSchemeEntity;
            this.f10456g = swanAppAlertDialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tapIndex", i2);
                    UnitedSchemeUtility.callCallback(this.f10454e, this.f10455f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    this.f10456g.dismiss();
                } catch (JSONException unused) {
                    UnitedSchemeUtility.callCallback(this.f10454e, this.f10455f, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.z1.b.f.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10457e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f10458f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10459g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f10460h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10461i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10462j;
        public final /* synthetic */ JSONObject k;
        public final /* synthetic */ String l;

        /* loaded from: classes.dex */
        public class a implements e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f10463a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10463a = dVar;
            }

            @Override // c.a.p0.a.z1.b.f.e.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f10463a;
                    dVar.f10461i.handleSchemeDispatchCallback(dVar.l, "");
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements e.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f10464a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10464a = dVar;
            }

            @Override // c.a.p0.a.z1.b.f.e.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f10464a;
                    dVar.f10461i.handleSchemeDispatchCallback(dVar.l, "");
                }
            }
        }

        public d(e eVar, String str, Context context, String str2, int i2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, context, str2, Integer.valueOf(i2), callbackHandler, unitedSchemeEntity, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10457e = str;
            this.f10458f = context;
            this.f10459g = str2;
            this.f10460h = i2;
            this.f10461i = callbackHandler;
            this.f10462j = unitedSchemeEntity;
            this.k = jSONObject;
            this.l = str3;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.f10457e;
                switch (str.hashCode()) {
                    case 49:
                        if (str.equals("1")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 50:
                        if (str.equals("2")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 51:
                        if (str.equals("3")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    c.a.p0.a.z1.b.f.e g2 = c.a.p0.a.z1.b.f.e.g(this.f10458f, this.f10459g);
                    g2.l(this.f10460h);
                    g2.F();
                    UnitedSchemeUtility.callCallback(this.f10461i, this.f10462j, UnitedSchemeUtility.wrapCallbackParams(0));
                    return;
                }
                Uri uri = null;
                if (c2 == 1) {
                    c.a.p0.a.z1.b.f.e g3 = c.a.p0.a.z1.b.f.e.g(this.f10458f, this.f10459g);
                    g3.n(null);
                    g3.l(this.f10460h);
                    g3.A();
                    UnitedSchemeUtility.callCallback(this.f10461i, this.f10462j, UnitedSchemeUtility.wrapCallbackParams(0));
                } else if (c2 != 2) {
                    this.f10462j.result = UnitedSchemeUtility.wrapCallbackParams(202);
                } else {
                    String optString = this.k.optString("icon");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            uri = Uri.parse(optString);
                        } catch (Exception unused) {
                        }
                    }
                    int i2 = TextUtils.equals(this.k.optString("bottomIconStyle"), "2") ? 2 : 1;
                    String optString2 = this.k.optString("title");
                    String optString3 = this.k.optString("buttonText");
                    String optString4 = this.k.optString("style");
                    int i3 = "2".equals(this.k.optString("bottomShowAnimationType")) ? 2 : 1;
                    if (TextUtils.isEmpty(this.l)) {
                        this.f10462j.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    } else if (!TextUtils.equals(optString4, "2") && !TextUtils.equals(optString4, "3")) {
                        c.a.p0.a.z1.b.f.e e2 = c.a.p0.a.z1.b.f.e.e(this.f10458f);
                        e2.o(uri);
                        e2.h(i2);
                        e2.s(optString2);
                        e2.q(this.f10459g);
                        e2.k(optString3);
                        e2.j(1);
                        e2.i(i3);
                        e2.l(this.f10460h);
                        e2.t(new b(this));
                        e2.C();
                        UnitedSchemeUtility.callCallback(this.f10461i, this.f10462j, UnitedSchemeUtility.wrapCallbackParams(0));
                    } else {
                        c.a.p0.a.z1.b.f.e e3 = c.a.p0.a.z1.b.f.e.e(this.f10458f);
                        e3.o(uri);
                        e3.h(i2);
                        e3.s(optString2);
                        e3.q(this.f10459g);
                        e3.k(optString3);
                        e3.j(2);
                        e3.i(i3);
                        e3.l(this.f10460h);
                        e3.t(new a(this));
                        e3.C();
                        UnitedSchemeUtility.callCallback(this.f10461i, this.f10462j, UnitedSchemeUtility.wrapCallbackParams(0));
                    }
                }
            }
        }
    }

    /* renamed from: c.a.p0.e.p.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0520e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10465e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10466f;

        public DialogInterface$OnClickListenerC0520e(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10465e = callbackHandler;
            this.f10466f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                dialogInterface.dismiss();
                SwanAppPickerDialog unused = e.f10450a = null;
                UnitedSchemeUtility.callCallback(this.f10465e, this.f10466f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f10467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10468f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10469g;

        public f(e eVar, boolean z, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z), callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10467e = z;
            this.f10468f = callbackHandler;
            this.f10469g = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                dialogInterface.dismiss();
                SwanAppPickerDialog unused = e.f10450a = null;
                try {
                    JSONArray currentIndex = ((MultiPickerDialog) dialogInterface).getCurrentIndex();
                    JSONObject jSONObject = new JSONObject();
                    if (currentIndex != null && currentIndex.length() > 0) {
                        if (this.f10467e) {
                            jSONObject.put("value", currentIndex.optInt(0));
                        } else {
                            jSONObject.put("value", currentIndex);
                        }
                    }
                    UnitedSchemeUtility.callCallback(this.f10468f, this.f10469g, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements BdMultiPicker.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10470a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10471b;

        public g(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10470a = unitedSchemeEntity;
            this.f10471b = callbackHandler;
        }

        @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
        public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdMultiPicker, jSONObject) == null) {
                String optString = UnitedSchemeUtility.optParamsAsJo(this.f10470a).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                this.f10471b.handleSchemeDispatchCallback(optString, jSONObject.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10472e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10473f;

        public h(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10472e = callbackHandler;
            this.f10473f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                UnitedSchemeUtility.callCallback(this.f10472e, this.f10473f, 0);
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10475f;

        public i(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10474e = callbackHandler;
            this.f10475f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                dialogInterface.dismiss();
                TimePickerDialog timePickerDialog = (TimePickerDialog) dialogInterface;
                String format = String.format("%02d:%02d", Integer.valueOf(timePickerDialog.getHour()), Integer.valueOf(timePickerDialog.getMinute()));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", format);
                    JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    if (c.a.p0.a.k.f7085a) {
                        String str = "handleShowDatePicker params = " + wrapCallbackParams.toString();
                    }
                    UnitedSchemeUtility.callCallback(this.f10474e, this.f10475f, wrapCallbackParams);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10477f;

        public j(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10476e = callbackHandler;
            this.f10477f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                UnitedSchemeUtility.callCallback(this.f10476e, this.f10477f, 0);
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10478e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10479f;

        public k(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10478e = callbackHandler;
            this.f10479f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                dialogInterface.dismiss();
                if (dialogInterface instanceof DatePickerDialog) {
                    String selectedDate = ((DatePickerDialog) dialogInterface).getSelectedDate();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("value", selectedDate);
                        JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                        if (c.a.p0.a.k.f7085a) {
                            String str = "handleShowDatePicker params = " + wrapCallbackParams.toString();
                        }
                        UnitedSchemeUtility.callCallback(this.f10478e, this.f10479f, wrapCallbackParams);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10480e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10481f;

        public l(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10480e = callbackHandler;
            this.f10481f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", QueryResponse.Options.CANCEL);
                    UnitedSchemeUtility.callCallback(this.f10480e, this.f10481f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException unused) {
                    UnitedSchemeUtility.callCallback(this.f10480e, this.f10481f, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10483f;

        public m(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10482e = callbackHandler;
            this.f10483f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", QueryResponse.Options.CANCEL);
                    UnitedSchemeUtility.callCallback(this.f10482e, this.f10483f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException unused) {
                    UnitedSchemeUtility.callCallback(this.f10482e, this.f10483f, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10484e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10485f;

        public n(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10484e = callbackHandler;
            this.f10485f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "confirm");
                    UnitedSchemeUtility.callCallback(this.f10484e, this.f10485f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException unused) {
                    UnitedSchemeUtility.callCallback(this.f10484e, this.f10485f, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10486e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10487f;

        public o(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10486e = callbackHandler;
            this.f10487f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                UnitedSchemeUtility.callCallback(this.f10486e, this.f10487f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10488e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10489f;

        public p(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10488e = callbackHandler;
            this.f10489f = unitedSchemeEntity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                UnitedSchemeUtility.callCallback(this.f10488e, this.f10489f, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String d(Configuration configuration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, configuration)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21) {
                return configuration.locale.toString();
            }
            if (i2 < 24) {
                return configuration.locale.toLanguageTag();
            }
            return configuration.getLocales().toLanguageTags();
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int frameType = context instanceof SwanAppActivity ? ((SwanAppActivity) context).getFrameType() : 0;
            if (frameType == 1) {
                return c.a.p0.a.m2.b.i(c.a.p0.a.c1.b.i().n(), frameType);
            }
            return c.a.p0.a.m2.b.i(c.a.p0.a.h0.u.g.N().V(), frameType);
        }
        return (String) invokeL.objValue;
    }

    public final boolean A(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("fields");
            if (TextUtils.isEmpty(optString)) {
                optString = "00:00";
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "23:59";
            }
            Date D = D(optString);
            Date D2 = D(optString2);
            Date D3 = D(optString3);
            if (D3 == null) {
                D3 = D(new SimpleDateFormat("HH:mm").format(new Date()));
            }
            if (D != null && D2 != null && !D2.before(D) && D3 != null && !D3.before(D) && !D3.after(D2)) {
                TimePickerDialog.a aVar = new TimePickerDialog.a(context);
                if (!TextUtils.isEmpty(optString4)) {
                    aVar.n(optString4);
                }
                aVar.p(D);
                aVar.m(D2);
                aVar.o(D3);
                aVar.l(optBoolean);
                aVar.h(c.a.p0.a.h.aiapps_confirm, new i(this, callbackHandler, unitedSchemeEntity));
                aVar.d(c.a.p0.a.h.aiapps_cancel, new h(this, callbackHandler, unitedSchemeEntity));
                aVar.k();
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean B(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "unknown action");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean C(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (f10450a == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(param);
                    int i2 = jSONObject.getInt("column");
                    JSONArray optJSONArray = jSONObject.optJSONArray("array");
                    int i3 = jSONObject.getInt(ProgressInfo.JSON_KEY_CURRENT);
                    if (optJSONArray != null) {
                        ((MultiPickerDialog) f10450a).updateWheel(i2, optJSONArray, i3);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    return true;
                } catch (JSONException e2) {
                    if (c.a.p0.a.k.f7085a) {
                        e2.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public final Date D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
            return (Date) invokeL.objValue;
        }
        Date date = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return new Date();
            }
            if (str.contains(":")) {
                String[] split = str.split(":");
                if (split.length == 2) {
                    Date date2 = new Date();
                    try {
                        int parseInt = Integer.parseInt(split[0]);
                        if (parseInt >= 0 && parseInt < 24) {
                            date2.setHours(parseInt);
                        }
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt2 >= 0 && parseInt2 < 60) {
                            date2.setMinutes(parseInt2);
                        }
                        return date2;
                    } catch (NumberFormatException e2) {
                        e = e2;
                        date = date2;
                        e.printStackTrace();
                        return date;
                    }
                }
                return null;
            }
            return null;
        } catch (NumberFormatException e3) {
            e = e3;
        }
    }

    public final int E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return (int) Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final int b(Context context, int i2) {
        InterceptResult invokeLI;
        int t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, context, i2)) == null) {
            Resources resources = context.getResources();
            int dimensionPixelSize = ((((i2 + 1) * resources.getDimensionPixelSize(c.a.p0.a.d.aiapps_action_sheet_list_item)) + resources.getDimensionPixelSize(c.a.p0.a.d.aiapps_action_sheet_bottom_divider)) + i2) - 1;
            return (!n0.G() || dimensionPixelSize <= (t = n0.t(context) - n0.u())) ? dimensionPixelSize : t;
        }
        return invokeLI.intValue;
    }

    public final int c(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jSONObject, jSONArray)) == null) {
            int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT, -1);
            if (optInt >= 0) {
                return optInt;
            }
            String optString = jSONObject.optString(ProgressInfo.JSON_KEY_CURRENT);
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (TextUtils.equals(optString, jSONArray.getString(i2))) {
                    return i2;
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public final JSONObject f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            windowManager.getDefaultDisplay().getSize(new Point());
            windowManager.getDefaultDisplay().getRectSize(new Rect());
            Configuration configuration = context.getResources().getConfiguration();
            Pair<Integer, Integer> y = c.a.p0.a.g1.f.V().y();
            Pair<Integer, Integer> r = c.a.p0.a.g1.f.V().r();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("brand", Build.BRAND);
                jSONObject.put("model", Build.MODEL);
                jSONObject.put("pixelRatio", displayMetrics.density);
                jSONObject.put("devicePixelRatio", displayMetrics.density);
                jSONObject.put("screenWidth", n0.L(((Integer) y.first).intValue()));
                jSONObject.put("screenHeight", n0.L(((Integer) y.second).intValue()));
                jSONObject.put("windowWidth", (int) (((Integer) r.first).intValue() / displayMetrics.density));
                jSONObject.put("windowHeight", (int) (((Integer) r.second).intValue() / displayMetrics.density));
                jSONObject.put("language", d(configuration));
                jSONObject.put("version", q0.D());
                jSONObject.put(ConstantHelper.LOG_OS, "Android " + Build.VERSION.RELEASE);
                jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
                jSONObject.put("fontSizeSetting", c.a.p0.a.c1.a.n().q());
                jSONObject.put("SDKVersion", e(context));
                jSONObject.put("swanNativeVersion", c.a.p0.a.l.a());
                jSONObject.put("host", c.a.p0.a.c1.a.m().a());
                jSONObject.put("statusBarHeight", n0.L(n0.u()));
                jSONObject.put("navigationBarHeight", n0.L(n0.j()));
                c.a.p0.a.u.e.p.f.s(jSONObject);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Date d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, unitedSchemeEntity, callbackHandler, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("fields");
            if (TextUtils.isEmpty(optString)) {
                optString = "1900-01-01";
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "2099-12-31";
            }
            Date c2 = c.a.p0.a.v2.k.c(optString, "yyyy-MM-dd");
            Date c3 = c.a.p0.a.v2.k.c(optString2, "yyyy-MM-dd");
            if (c2 != null && c3 != null && !c3.before(c2)) {
                Date date = new Date();
                if (!TextUtils.isEmpty(optString3) && (d2 = c.a.p0.a.v2.k.d(optString3, new String[]{"yyyy-MM-dd", "yyyy-MM", "yyyy"})) != null) {
                    date = d2;
                }
                if (date.before(c2)) {
                    date = c2;
                } else if (date.after(c3)) {
                    date = c3;
                }
                DatePickerDialog.a aVar = new DatePickerDialog.a(context);
                if (!TextUtils.isEmpty(optString4)) {
                    aVar.n(optString4);
                }
                aVar.p(c2);
                aVar.m(c3);
                aVar.o(date);
                aVar.l(optBoolean);
                aVar.h(c.a.p0.a.h.aiapps_confirm, new k(this, callbackHandler, unitedSchemeEntity));
                aVar.d(c.a.p0.a.h.aiapps_cancel, new j(this, callbackHandler, unitedSchemeEntity));
                aVar.k();
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "utils" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return null;
        }
        return (Class) invokeL.objValue;
    }

    public final boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            q0.b0(new c(this));
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", r0.b(context).a().toString());
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "JSONException");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
        if (r1.equals("getCommonSysInfoSync") != false) goto L19;
     */
    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            char c2 = 0;
            String path = unitedSchemeEntity.getPath(false);
            if (TextUtils.isEmpty(path)) {
                if (!unitedSchemeEntity.isOnlyVerify()) {
                    UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (unitedSchemeEntity.isOnlyVerify()) {
                return true;
            } else {
                switch (path.hashCode()) {
                    case -1920105040:
                        if (path.equals("showModal")) {
                            c2 = 11;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1913642710:
                        if (path.equals("showToast")) {
                            c2 = 14;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1641549650:
                        if (path.equals("getSystemInfoSync")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1496218978:
                        if (path.equals("updateMultiPicker")) {
                            c2 = 17;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1383206285:
                        if (path.equals("previewImage")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -886619478:
                        if (path.equals("getClipboardData")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -550543988:
                        if (path.equals("showActionSheet")) {
                            c2 = '\f';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -533453131:
                        break;
                    case 216239514:
                        if (path.equals("hideLoading")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 252099448:
                        if (path.equals("openPicker")) {
                            c2 = 15;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 344806259:
                        if (path.equals("getSystemInfo")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 422312381:
                        if (path.equals("dismissToast")) {
                            c2 = CharUtils.CR;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 724809599:
                        if (path.equals("showLoading")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1321118366:
                        if (path.equals("makePhoneCall")) {
                            c2 = '\t';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1576904990:
                        if (path.equals("setClipboardData")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1630368510:
                        if (path.equals("showDatePickerView")) {
                            c2 = '\n';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1714085202:
                        if (path.equals("getNetworkType")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2103167613:
                        if (path.equals("openMultiPicker")) {
                            c2 = 16;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        return j(context, unitedSchemeEntity, callbackHandler);
                    case 1:
                        return w(context, unitedSchemeEntity, callbackHandler);
                    case 2:
                        return n(context, unitedSchemeEntity, callbackHandler);
                    case 3:
                        return s(context, unitedSchemeEntity, callbackHandler);
                    case 4:
                        return t(context, unitedSchemeEntity, callbackHandler);
                    case 5:
                        return i(context, unitedSchemeEntity, callbackHandler);
                    case 6:
                        return k(context, unitedSchemeEntity, callbackHandler);
                    case 7:
                        return l(context, unitedSchemeEntity, callbackHandler);
                    case '\b':
                        return m(context, unitedSchemeEntity, callbackHandler);
                    case '\t':
                        return o(context, unitedSchemeEntity, callbackHandler);
                    case '\n':
                        return v(context, unitedSchemeEntity, callbackHandler);
                    case 11:
                        return x(context, unitedSchemeEntity, callbackHandler);
                    case '\f':
                        return u(context, unitedSchemeEntity, callbackHandler);
                    case '\r':
                        return h(context, unitedSchemeEntity, callbackHandler);
                    case 14:
                        return y(context, unitedSchemeEntity, callbackHandler);
                    case 15:
                        return r(context, unitedSchemeEntity, callbackHandler);
                    case 16:
                        return p(context, unitedSchemeEntity, callbackHandler);
                    case 17:
                        return C(context, unitedSchemeEntity, callbackHandler);
                    default:
                        return B(context, unitedSchemeEntity, callbackHandler);
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("imei", q0.r());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                return true;
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exec fail");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            String e2 = SwanAppNetworkUtils.e();
            if (TextUtils.isEmpty(e2)) {
                e2 = "unknown";
            } else if ("no".equals(e2)) {
                e2 = "none";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("networkType", e2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            JSONObject f2 = f(context);
            if (f2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(f2, 0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            JSONObject f2 = f(context);
            if (f2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(f2, 0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (!(context instanceof a.InterfaceC0483a)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support FloatLayer");
                return false;
            }
            c.a.p0.a.z1.b.c.a floatLayer = ((a.InterfaceC0483a) context).getFloatLayer();
            if (floatLayer.e() instanceof LoadingView) {
                floatLayer.g();
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.DIAL");
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null) {
                String optString = optParamsAsJo.optString("phoneNumber");
                if (!TextUtils.isEmpty(optString)) {
                    intent.setData(Uri.parse("tel:" + optString));
                }
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, c.a.p0.a.v2.f.g(context, intent) ? 0 : 1001);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, context, unitedSchemeEntity, callbackHandler)) == null) ? q(context, unitedSchemeEntity, callbackHandler, false) : invokeLLL.booleanValue;
    }

    public final boolean q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{context, unitedSchemeEntity, callbackHandler, Boolean.valueOf(z)})) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (f10450a != null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                String string = context.getString(c.a.p0.a.h.aiapps_picker_default_title);
                if (!TextUtils.isEmpty(param)) {
                    JSONObject jSONObject = new JSONObject(param);
                    JSONArray optJSONArray = jSONObject.optJSONArray("array");
                    jSONArray2 = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
                    jSONObject.optString("title", string);
                    jSONArray = optJSONArray;
                }
                MultiPickerDialog.a aVar = new MultiPickerDialog.a(context);
                aVar.l(jSONArray);
                aVar.m(jSONArray2);
                aVar.o(z);
                aVar.n(new g(this, unitedSchemeEntity, callbackHandler));
                aVar.h(c.a.p0.a.h.aiapps_confirm, new f(this, z, callbackHandler, unitedSchemeEntity));
                aVar.d(c.a.p0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0520e(this, callbackHandler, unitedSchemeEntity));
                f10450a = aVar.k();
                return false;
            } catch (JSONException e2) {
                if (c.a.p0.a.k.f7085a) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final boolean r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            JSONArray optJSONArray = optParamsAsJo.optJSONArray("array");
            int optInt = optParamsAsJo.optInt(ProgressInfo.JSON_KEY_CURRENT);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(optJSONArray);
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(optInt);
                try {
                    optParamsAsJo.put("array", jSONArray);
                    optParamsAsJo.put(ProgressInfo.JSON_KEY_CURRENT, jSONArray2);
                    params.put("params", optParamsAsJo.toString());
                    return q(context, unitedSchemeEntity, callbackHandler, true);
                } catch (JSONException unused) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean s(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(param);
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    z(optJSONArray);
                    int c2 = c(jSONObject, optJSONArray);
                    if (c2 >= 0 && c2 < optJSONArray.length()) {
                        String[] strArr = new String[optJSONArray.length()];
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            strArr[i2] = optJSONArray.getString(i2);
                        }
                        c.a.p0.a.c1.a.y().d(context, strArr, c2);
                        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } catch (JSONException e2) {
                if (c.a.p0.a.k.f7085a) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            if (unitedSchemeEntity == null) {
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            r0.b(context).c(optParamsAsJo.optString("data"));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        int i2;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048601, this, context, unitedSchemeEntity, callbackHandler)) != null) {
            return invokeLLL.booleanValue;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = optParamsAsJo.getJSONArray("itemList");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String string = jSONArray.getString(i3);
                if (TextUtils.isEmpty(string)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                arrayList.add(string);
            }
            optString = optParamsAsJo.optString("itemColor");
        } catch (IllegalArgumentException | JSONException unused) {
        }
        if (!TextUtils.isEmpty(optString)) {
            if (optString.length() == 4 && optString.charAt(0) == '#') {
                optString = SwanAppConfigData.d(optString);
            }
            i2 = Color.parseColor(optString);
            if (!arrayList.isEmpty()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            if (i2 == -1) {
                i2 = context.getResources().getColor(c.a.p0.a.c.aiapps_action_sheet_item_color);
            }
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(context);
            aVar.f(true);
            aVar.i(true);
            aVar.k(true);
            aVar.m(true);
            aVar.n(new c.a.p0.a.w2.h.a());
            aVar.s(context.getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_action_sheet_bottom_divider));
            aVar.p(c.a.p0.a.e.aiapps_action_sheet_bg);
            aVar.B(c.a.p0.a.h.aiapps_cancel, new p(this, callbackHandler, unitedSchemeEntity));
            aVar.K(new o(this, callbackHandler, unitedSchemeEntity));
            View inflate = View.inflate(context, c.a.p0.a.g.aiapps_scheme_utils_show_action_sheet, null);
            ListView listView = (ListView) inflate.findViewById(c.a.p0.a.f.list);
            listView.setAdapter((ListAdapter) new a(this, arrayList, context, i2));
            aVar.W(inflate);
            aVar.j();
            aVar.q(b(context, arrayList.size()));
            SwanAppAlertDialog c2 = aVar.c();
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(n0.t(context), -2);
                window.setWindowAnimations(c.a.p0.a.i.action_sheet_animation);
            }
            c2.setEnableImmersion(false);
            c2.setCanceledOnTouchOutside(true);
            listView.setOnItemClickListener(new b(this, callbackHandler, unitedSchemeEntity, c2));
            c2.show();
            return true;
        }
        i2 = -1;
        if (!arrayList.isEmpty()) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r4 == 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        r10.result = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(202);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
        return g(r9, r10, r11, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(param);
                String optString = jSONObject.optString("mode");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                char c2 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != 3076014) {
                    if (hashCode == 3560141 && optString.equals("time")) {
                        c2 = 0;
                    }
                } else if (optString.equals("date")) {
                    c2 = 1;
                }
                return A(context, unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean w(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("title");
            boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
            if (!(context instanceof a.InterfaceC0483a)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
                return false;
            }
            c.a.p0.a.z1.b.c.a floatLayer = ((a.InterfaceC0483a) context).getFloatLayer();
            View e2 = floatLayer.e();
            if (e2 instanceof LoadingView) {
                loadingView = (LoadingView) e2;
            } else {
                loadingView = new LoadingView(context);
                floatLayer.k(loadingView);
            }
            if (!TextUtils.isEmpty(optString)) {
                loadingView.setMsg(optString);
            }
            floatLayer.i(optBoolean);
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                optParamsAsJo = new JSONObject();
            }
            String optString = optParamsAsJo.optString("confirmText");
            if (TextUtils.isEmpty(optString)) {
                optString = context.getString(c.a.p0.a.h.aiapps_confirm);
            }
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(context);
            aVar.V(optParamsAsJo.optString("title"));
            aVar.x(optParamsAsJo.optString("content"));
            aVar.n(new c.a.p0.a.w2.h.a());
            if (optParamsAsJo.optBoolean("showCancel", true)) {
                aVar.E(optParamsAsJo.optString("cancelColor"), c.a.p0.a.c.aiapps_modal_cancel_color);
                String optString2 = optParamsAsJo.optString("cancelText");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = context.getString(c.a.p0.a.h.aiapps_cancel);
                }
                aVar.C(optString2, new l(this, callbackHandler, unitedSchemeEntity));
                aVar.K(new m(this, callbackHandler, unitedSchemeEntity));
            }
            aVar.R(optParamsAsJo.optString("confirmColor"), c.a.p0.a.c.aiapps_modal_confirm_color);
            aVar.P(optString, new n(this, callbackHandler, unitedSchemeEntity));
            aVar.X();
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean y(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048605, this, context, unitedSchemeEntity, callbackHandler)) != null) {
            return invokeLLL.booleanValue;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params != null && params.size() != 0 && params.containsKey("params") && !TextUtils.isEmpty(params.get("params"))) {
            try {
                JSONObject jSONObject = new JSONObject(params.get("params"));
                String string = jSONObject.getString("type");
                String string2 = jSONObject.getString("message");
                String optString = jSONObject.optString("time");
                String optString2 = jSONObject.optString("clickCallback");
                if (TextUtils.isEmpty(string2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                if (TextUtils.isEmpty(string)) {
                    string = "1";
                }
                String str = string;
                try {
                    int E = E(optString);
                    q0.b0(new d(this, str, context, string2, E <= 0 ? 2 : E, callbackHandler, unitedSchemeEntity, jSONObject, optString2));
                    return true;
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final JSONArray z(JSONArray jSONArray) {
        InterceptResult invokeL;
        c.a.p0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, jSONArray)) == null) {
            if (jSONArray != null && jSONArray.length() > 0 && (i2 = c.a.p0.a.a2.e.i()) != null && !TextUtils.isEmpty(i2.f4566f) && !TextUtils.isEmpty(i2.Z())) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    try {
                        String string = jSONArray.getString(i3);
                        PathType s = c.a.p0.a.k2.b.s(string);
                        if (s == PathType.BD_FILE) {
                            string = c.a.p0.a.k2.b.M(string, i2.f4566f);
                        } else if (s == PathType.RELATIVE) {
                            string = c.a.p0.a.k2.b.L(string, i2, i2.Z());
                        }
                        if (!TextUtils.isEmpty(string)) {
                            jSONArray.put(i3, string);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }
}
