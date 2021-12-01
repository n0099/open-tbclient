package c.a.p0.a.u.e.f;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.z2.k;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.dialog.DatePickerDialog;
import com.baidu.swan.apps.res.widget.dialog.MultiPickerDialog;
import com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog;
import com.baidu.swan.apps.res.widget.dialog.TimePickerDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.kwad.v8.debug.mirror.Frame;
import com.tachikoma.core.component.button.StyleHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c.a.p0.a.u.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public SwanAppPickerDialog f8162f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8163e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f8164f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f8165g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f8166h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f8167i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8168j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f8169k;
        public final /* synthetic */ f l;

        /* renamed from: c.a.p0.a.u.e.f.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnCancelListenerC0479a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f8170e;

            public DialogInterface$OnCancelListenerC0479a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8170e = aVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    a aVar = this.f8170e;
                    aVar.l.d(aVar.f8169k, new c.a.p0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f8171e;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8171e = aVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    a aVar = this.f8171e;
                    aVar.l.d(aVar.f8169k, new c.a.p0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f8172e;

            public c(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8172e = aVar;
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
                        this.f8172e.l.d(this.f8172e.f8169k, new c.a.p0.a.u.h.b(0, jSONObject));
                    } catch (JSONException unused) {
                    }
                }
            }
        }

        public a(f fVar, String str, Date date, Date date2, Date date3, boolean z, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, date, date2, date3, Boolean.valueOf(z), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = fVar;
            this.f8163e = str;
            this.f8164f = date;
            this.f8165g = date2;
            this.f8166h = date3;
            this.f8167i = z;
            this.f8168j = str2;
            this.f8169k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TimePickerDialog.a aVar = new TimePickerDialog.a(this.l.getContext());
                if (!TextUtils.isEmpty(this.f8163e)) {
                    aVar.n(this.f8163e);
                }
                aVar.p(this.f8164f);
                aVar.m(this.f8165g);
                aVar.o(this.f8166h);
                aVar.l(this.f8167i);
                aVar.c(true);
                aVar.g(this.f8168j);
                aVar.h(c.a.p0.a.h.aiapps_confirm, new c(this));
                aVar.d(c.a.p0.a.h.aiapps_cancel, new b(this));
                aVar.f(new DialogInterface$OnCancelListenerC0479a(this));
                aVar.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8173e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f8174f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f8175g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f8176h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f8177i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8178j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f8179k;
        public final /* synthetic */ f l;

        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8180e;

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
                this.f8180e = bVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    b bVar = this.f8180e;
                    bVar.l.d(bVar.f8179k, new c.a.p0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* renamed from: c.a.p0.a.u.e.f.f$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0480b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8181e;

            public DialogInterface$OnClickListenerC0480b(b bVar) {
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
                this.f8181e = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    b bVar = this.f8181e;
                    bVar.l.d(bVar.f8179k, new c.a.p0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8182e;

            public c(b bVar) {
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
                this.f8182e = bVar;
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
                            this.f8182e.l.d(this.f8182e.f8179k, new c.a.p0.a.u.h.b(0, jSONObject));
                        } catch (JSONException unused) {
                            b bVar = this.f8182e;
                            bVar.l.d(bVar.f8179k, new c.a.p0.a.u.h.b(202));
                        }
                    }
                }
            }
        }

        public b(f fVar, String str, Date date, Date date2, Date date3, boolean z, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, date, date2, date3, Boolean.valueOf(z), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = fVar;
            this.f8173e = str;
            this.f8174f = date;
            this.f8175g = date2;
            this.f8176h = date3;
            this.f8177i = z;
            this.f8178j = str2;
            this.f8179k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DatePickerDialog.a aVar = new DatePickerDialog.a(this.l.getContext());
                if (!TextUtils.isEmpty(this.f8173e)) {
                    aVar.n(this.f8173e);
                }
                aVar.p(this.f8174f);
                aVar.m(this.f8175g);
                aVar.o(this.f8176h);
                aVar.l(this.f8177i);
                aVar.c(true);
                aVar.g(this.f8178j);
                aVar.h(c.a.p0.a.h.aiapps_confirm, new c(this));
                aVar.d(c.a.p0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0480b(this));
                aVar.f(new a(this));
                aVar.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8183e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8184f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8185g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f8186h;

        public c(f fVar, int i2, JSONArray jSONArray, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2), jSONArray, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8186h = fVar;
            this.f8183e = i2;
            this.f8184f = jSONArray;
            this.f8185g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8186h.f8162f == null) {
                return;
            }
            ((MultiPickerDialog) this.f8186h.f8162f).updateWheel(this.f8183e, this.f8184f, this.f8185g);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8187e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8188f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8189g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8190h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8191i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ f f8192j;

        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8193e;

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
                this.f8193e = dVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    d dVar = this.f8193e;
                    dVar.f8192j.K(dialogInterface, dVar.f8189g, dVar.f8190h);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8194e;

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
                this.f8194e = dVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    d dVar = this.f8194e;
                    dVar.f8192j.K(dialogInterface, dVar.f8189g, dVar.f8190h);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8195e;

            public c(d dVar) {
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
                this.f8195e = dVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    dialogInterface.dismiss();
                    this.f8195e.f8192j.f8162f = null;
                    try {
                        JSONArray currentIndex = ((MultiPickerDialog) dialogInterface).getCurrentIndex();
                        JSONObject jSONObject = new JSONObject();
                        if (currentIndex != null && currentIndex.length() > 0) {
                            if (this.f8195e.f8189g) {
                                jSONObject.put("value", currentIndex.optInt(0));
                            } else {
                                jSONObject.put("value", currentIndex);
                                jSONObject.put("type", "confirm");
                            }
                        }
                        this.f8195e.f8192j.d(this.f8195e.f8190h, new c.a.p0.a.u.h.b(0, jSONObject));
                    } catch (JSONException unused) {
                    }
                }
            }
        }

        /* renamed from: c.a.p0.a.u.e.f.f$d$d  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0481d implements BdMultiPicker.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public C0481d(d dVar) {
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
                this.a = dVar;
            }

            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, bdMultiPicker, jSONObject) == null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                        jSONObject2.put("type", "columnChange");
                        this.a.f8192j.d(this.a.f8190h, new c.a.p0.a.u.h.b(0, jSONObject2));
                    } catch (JSONException unused) {
                        d dVar = this.a;
                        dVar.f8192j.d(dVar.f8190h, new c.a.p0.a.u.h.b(202));
                    }
                }
            }
        }

        public d(f fVar, JSONArray jSONArray, JSONArray jSONArray2, boolean z, JSONObject jSONObject, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, jSONArray, jSONArray2, Boolean.valueOf(z), jSONObject, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8192j = fVar;
            this.f8187e = jSONArray;
            this.f8188f = jSONArray2;
            this.f8189g = z;
            this.f8190h = str;
            this.f8191i = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MultiPickerDialog.a aVar = new MultiPickerDialog.a(this.f8192j.getContext());
                f fVar = this.f8192j;
                aVar.l(this.f8187e);
                aVar.m(this.f8188f);
                aVar.o(this.f8189g);
                aVar.n(new C0481d(this));
                aVar.c(true);
                aVar.g(this.f8191i);
                aVar.h(c.a.p0.a.h.aiapps_confirm, new c(this));
                aVar.d(c.a.p0.a.h.aiapps_cancel, new b(this));
                aVar.f(new a(this));
                fVar.f8162f = aVar.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull c.a.p0.a.u.c.b bVar) {
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

    public final c.a.p0.a.u.h.b D(JSONObject jSONObject) {
        InterceptResult invokeL;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean(StyleHelper.KEY_ONDISABLE, false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("title");
            String optString5 = jSONObject.optString("fields");
            String[] strArr = {"yyyy-MM-dd", "yyyy-MM", "yyyy"};
            Date I = I(optString, strArr, "1900-01-01");
            Date I2 = I(optString2, strArr, "2099-12-31");
            if (I != null && I2 != null && !I2.before(I)) {
                String optString6 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString6)) {
                    c.a.p0.a.e0.d.c("PickerApi", "callback is null");
                    return new c.a.p0.a.u.h.b(1001, "callback is null");
                }
                Date I3 = I(optString3, strArr, null);
                if (I3 == null) {
                    I3 = new Date();
                }
                if (I3.before(I)) {
                    date = I;
                } else {
                    date = I3.after(I2) ? I2 : I3;
                }
                q0.e0(new b(this, optString5, I, I2, date, optBoolean, optString4, optString6));
                return new c.a.p0.a.u.h.b(0);
            }
            return new c.a.p0.a.u.h.b(202);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.p0.a.u.h.b E(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, z)) == null) {
            if (this.f8162f != null) {
                return new c.a.p0.a.u.h.b(1001);
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            String str2 = null;
            if (jSONObject != null) {
                jSONArray = jSONObject.optJSONArray("array");
                jSONArray2 = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
                str2 = jSONObject.optString("cb");
                str = jSONObject.optString("title");
            } else {
                str = "";
            }
            JSONArray jSONArray3 = jSONArray;
            JSONArray jSONArray4 = jSONArray2;
            String str3 = str2;
            String str4 = str;
            if (TextUtils.isEmpty(str3)) {
                c.a.p0.a.e0.d.c("PickerApi", "callback is null");
                return new c.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.e0(new d(this, jSONArray3, jSONArray4, z, jSONObject, str3, str4));
            return new c.a.p0.a.u.h.b(0);
        }
        return (c.a.p0.a.u.h.b) invokeLZ.objValue;
    }

    public final c.a.p0.a.u.h.b F(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean(StyleHelper.KEY_ONDISABLE, false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("title");
            String optString5 = jSONObject.optString("fields");
            if (TextUtils.isEmpty(optString)) {
                optString = "00:00";
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "23:59";
            }
            Date J = J(optString);
            Date J2 = J(optString2);
            Date J3 = J(optString3);
            if (J3 == null) {
                J3 = J(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
            }
            Date date = J3;
            if (J != null && J2 != null && !J2.before(J) && date != null) {
                String optString6 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString6)) {
                    c.a.p0.a.e0.d.c("PickerApi", "callback is null");
                    return new c.a.p0.a.u.h.b(1001, "callback is null");
                }
                q0.e0(new a(this, optString5, J, J2, date, optBoolean, optString4, optString6));
                return new c.a.p0.a.u.h.b(0);
            }
            return new c.a.p0.a.u.h.b(202);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new c.a.p0.a.u.h.b(202);
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            if (!bVar.isSuccess()) {
                c.a.p0.a.e0.d.c("PickerApi", "parse fail");
                return bVar;
            }
            return E((JSONObject) s.second, false);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new c.a.p0.a.u.h.b(202);
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            if (!bVar.isSuccess()) {
                c.a.p0.a.e0.d.c("PickerApi", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return new c.a.p0.a.u.h.b(202);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(optJSONArray);
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(optInt);
                try {
                    jSONObject.put("array", jSONArray);
                    jSONObject.put(ProgressInfo.JSON_KEY_CURRENT, jSONArray2);
                    return E(jSONObject, true);
                } catch (JSONException unused) {
                    return new c.a.p0.a.u.h.b(1001);
                }
            }
            return new c.a.p0.a.u.h.b(202);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final Date I(String str, String[] strArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, strArr, str2)) == null) {
            Date d2 = !TextUtils.isEmpty(str) ? k.d(str, strArr) : null;
            return (d2 != null || TextUtils.isEmpty(str2)) ? d2 : k.d(str2, strArr);
        }
        return (Date) invokeLLL.objValue;
    }

    public final Date J(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Date();
            }
            if (str.contains(":") && (split = str.split(":")) != null && split.length == 2) {
                try {
                    Date date = new Date();
                    try {
                        int parseInt = Integer.parseInt(split[0]);
                        if (parseInt >= 0 && parseInt < 24) {
                            date.setHours(parseInt);
                        }
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt2 >= 0 && parseInt2 < 60) {
                            date.setMinutes(parseInt2);
                        }
                    } catch (NumberFormatException unused) {
                    }
                    return date;
                } catch (NumberFormatException unused2) {
                    return null;
                }
            }
            return null;
        }
        return (Date) invokeL.objValue;
    }

    public final void K(DialogInterface dialogInterface, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{dialogInterface, Boolean.valueOf(z), str}) == null) {
            dialogInterface.dismiss();
            this.f8162f = null;
            if (z) {
                d(str, new c.a.p0.a.u.h.b(0));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", QueryResponse.Options.CANCEL);
                d(str, new c.a.p0.a.u.h.b(0, jSONObject));
            } catch (JSONException unused) {
                d(str, new c.a.p0.a.u.h.b(202));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r0.equals("time") == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.a.p0.a.u.h.b L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            char c2 = 0;
            q("#showDatePickerView", false);
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                if (jSONObject == null) {
                    return new c.a.p0.a.u.h.b(1001);
                }
                String optString = jSONObject.optString("mode");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.u.h.b(202);
                }
                int hashCode = optString.hashCode();
                if (hashCode != 3076014) {
                    if (hashCode == 3560141) {
                    }
                    c2 = 65535;
                } else {
                    if (optString.equals("date")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        return new c.a.p0.a.u.h.b(202);
                    }
                    return D(jSONObject);
                }
                return F(jSONObject);
            }
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new c.a.p0.a.u.h.b(202);
            }
            if (this.f8162f == null) {
                return new c.a.p0.a.u.h.b(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(Frame.COLUMN);
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                int optInt2 = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.e0.d.c("PickerApi", "callback is null");
                    return new c.a.p0.a.u.h.b(1001, "callback is null");
                }
                if (optJSONArray != null) {
                    q0.e0(new c(this, optInt, optJSONArray, optInt2));
                    d(optString, new c.a.p0.a.u.h.b(0, jSONObject));
                }
                return new c.a.p0.a.u.h.b(0);
            } catch (JSONException unused) {
                return new c.a.p0.a.u.h.b(202);
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "PickerApi" : (String) invokeV.objValue;
    }
}
