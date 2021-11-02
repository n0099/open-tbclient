package b.a.p0.a.u.e.g;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.v2.k;
import b.a.p0.a.v2.q0;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppPickerDialog f8132d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8133e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f8134f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f8135g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f8136h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f8137i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;

        /* renamed from: b.a.p0.a.u.e.g.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnCancelListenerC0394a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f8138e;

            public DialogInterface$OnCancelListenerC0394a(a aVar) {
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
                this.f8138e = aVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    a aVar = this.f8138e;
                    aVar.l.d(aVar.k, new b.a.p0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f8139e;

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
                this.f8139e = aVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    a aVar = this.f8139e;
                    aVar.l.d(aVar.k, new b.a.p0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f8140e;

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
                this.f8140e = aVar;
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
                        if (b.a.p0.a.u.c.d.f8000c) {
                            String str = "handleShowDatePicker params = " + jSONObject.toString();
                        }
                        this.f8140e.l.d(this.f8140e.k, new b.a.p0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (b.a.p0.a.u.c.d.f8000c) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }

        public a(e eVar, String str, Date date, Date date2, Date date3, boolean z, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, date, date2, date3, Boolean.valueOf(z), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = eVar;
            this.f8133e = str;
            this.f8134f = date;
            this.f8135g = date2;
            this.f8136h = date3;
            this.f8137i = z;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TimePickerDialog.a aVar = new TimePickerDialog.a(this.l.getContext());
                if (!TextUtils.isEmpty(this.f8133e)) {
                    aVar.n(this.f8133e);
                }
                aVar.p(this.f8134f);
                aVar.m(this.f8135g);
                aVar.o(this.f8136h);
                aVar.l(this.f8137i);
                aVar.c(true);
                aVar.g(this.j);
                aVar.h(b.a.p0.a.h.aiapps_confirm, new c(this));
                aVar.d(b.a.p0.a.h.aiapps_cancel, new b(this));
                aVar.f(new DialogInterface$OnCancelListenerC0394a(this));
                aVar.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8141e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f8142f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f8143g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f8144h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f8145i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;

        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8146e;

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
                this.f8146e = bVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    b bVar = this.f8146e;
                    bVar.l.d(bVar.k, new b.a.p0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* renamed from: b.a.p0.a.u.e.g.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0395b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8147e;

            public DialogInterface$OnClickListenerC0395b(b bVar) {
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
                this.f8147e = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    b bVar = this.f8147e;
                    bVar.l.d(bVar.k, new b.a.p0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8148e;

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
                this.f8148e = bVar;
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
                            if (b.a.p0.a.u.c.d.f8000c) {
                                String str = "handleShowDatePicker params = " + jSONObject.toString();
                            }
                            this.f8148e.l.d(this.f8148e.k, new b.a.p0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (b.a.p0.a.u.c.d.f8000c) {
                                e2.printStackTrace();
                            }
                            b bVar = this.f8148e;
                            bVar.l.d(bVar.k, new b.a.p0.a.u.h.b(202));
                        }
                    }
                }
            }
        }

        public b(e eVar, String str, Date date, Date date2, Date date3, boolean z, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, date, date2, date3, Boolean.valueOf(z), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = eVar;
            this.f8141e = str;
            this.f8142f = date;
            this.f8143g = date2;
            this.f8144h = date3;
            this.f8145i = z;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DatePickerDialog.a aVar = new DatePickerDialog.a(this.l.getContext());
                if (!TextUtils.isEmpty(this.f8141e)) {
                    aVar.n(this.f8141e);
                }
                aVar.p(this.f8142f);
                aVar.m(this.f8143g);
                aVar.o(this.f8144h);
                aVar.l(this.f8145i);
                aVar.c(true);
                aVar.g(this.j);
                aVar.h(b.a.p0.a.h.aiapps_confirm, new c(this));
                aVar.d(b.a.p0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0395b(this));
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
        public final /* synthetic */ int f8149e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8150f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8151g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f8152h;

        public c(e eVar, int i2, JSONArray jSONArray, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), jSONArray, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8152h = eVar;
            this.f8149e = i2;
            this.f8150f = jSONArray;
            this.f8151g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8152h.f8132d == null) {
                return;
            }
            ((MultiPickerDialog) this.f8152h.f8132d).updateWheel(this.f8149e, this.f8150f, this.f8151g);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8153e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8154f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8155g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8156h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8157i;
        public final /* synthetic */ String j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8158e;

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
                this.f8158e = dVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    d dVar = this.f8158e;
                    dVar.k.D(dialogInterface, dVar.f8155g, dVar.f8157i);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8159e;

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
                this.f8159e = dVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    d dVar = this.f8159e;
                    dVar.k.D(dialogInterface, dVar.f8155g, dVar.f8157i);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8160e;

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
                this.f8160e = dVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    dialogInterface.dismiss();
                    this.f8160e.k.f8132d = null;
                    try {
                        JSONArray currentIndex = ((MultiPickerDialog) dialogInterface).getCurrentIndex();
                        JSONObject jSONObject = new JSONObject();
                        if (currentIndex != null && currentIndex.length() > 0) {
                            if (this.f8160e.f8155g) {
                                jSONObject.put("value", currentIndex.optInt(0));
                            } else {
                                jSONObject.put("value", currentIndex);
                                jSONObject.put("type", "confirm");
                            }
                        }
                        this.f8160e.k.d(this.f8160e.f8157i, new b.a.p0.a.u.h.b(0, jSONObject));
                        if (b.a.p0.a.u.c.d.f8000c) {
                            String str = "handleOpenMultiPicker: output params = " + jSONObject.toString();
                        }
                    } catch (JSONException e2) {
                        if (b.a.p0.a.u.c.d.f8000c) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }

        /* renamed from: b.a.p0.a.u.e.g.e$d$d  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0396d implements BdMultiPicker.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f8161a;

            public C0396d(d dVar) {
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
                this.f8161a = dVar;
            }

            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, bdMultiPicker, jSONObject) == null) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        String str = "onMultiSelectedChanged: params=" + this.f8161a.f8156h;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                        jSONObject2.put("type", "columnChange");
                        this.f8161a.k.d(this.f8161a.f8157i, new b.a.p0.a.u.h.b(0, jSONObject2));
                    } catch (JSONException e2) {
                        if (b.a.p0.a.u.c.d.f8000c) {
                            e2.printStackTrace();
                        }
                        d dVar = this.f8161a;
                        dVar.k.d(dVar.f8157i, new b.a.p0.a.u.h.b(202));
                    }
                }
            }
        }

        public d(e eVar, JSONArray jSONArray, JSONArray jSONArray2, boolean z, JSONObject jSONObject, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONArray, jSONArray2, Boolean.valueOf(z), jSONObject, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f8153e = jSONArray;
            this.f8154f = jSONArray2;
            this.f8155g = z;
            this.f8156h = jSONObject;
            this.f8157i = str;
            this.j = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MultiPickerDialog.a aVar = new MultiPickerDialog.a(this.k.getContext());
                e eVar = this.k;
                aVar.l(this.f8153e);
                aVar.m(this.f8154f);
                aVar.o(this.f8155g);
                aVar.n(new C0396d(this));
                aVar.c(true);
                aVar.g(this.j);
                aVar.h(b.a.p0.a.h.aiapps_confirm, new c(this));
                aVar.d(b.a.p0.a.h.aiapps_cancel, new b(this));
                aVar.f(new a(this));
                eVar.f8132d = aVar.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public b.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new b.a.p0.a.u.h.b(202);
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("showDatePickerView", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                b.a.p0.a.e0.d.b("Api-Base", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                return new b.a.p0.a.u.h.b(202);
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
                    return x(jSONObject, true);
                } catch (JSONException unused) {
                    return new b.a.p0.a.u.h.b(1001);
                }
            }
            return new b.a.p0.a.u.h.b(202);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final Date B(String str, String[] strArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, strArr, str2)) == null) {
            Date d2 = !TextUtils.isEmpty(str) ? k.d(str, strArr) : null;
            return (d2 != null || TextUtils.isEmpty(str2)) ? d2 : k.d(str2, strArr);
        }
        return (Date) invokeLLL.objValue;
    }

    public final Date C(String str) {
        InterceptResult invokeL;
        String[] split;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Date();
            }
            Date date2 = null;
            if (str.contains(":") && (split = str.split(":")) != null && split.length == 2) {
                try {
                    date = new Date();
                } catch (NumberFormatException e2) {
                    e = e2;
                }
                try {
                    int parseInt = Integer.parseInt(split[0]);
                    if (parseInt >= 0 && parseInt < 24) {
                        date.setHours(parseInt);
                    }
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt2 >= 0 && parseInt2 < 60) {
                        date.setMinutes(parseInt2);
                    }
                    return date;
                } catch (NumberFormatException e3) {
                    e = e3;
                    date2 = date;
                    if (b.a.p0.a.u.c.d.f8000c) {
                        e.printStackTrace();
                        return date2;
                    }
                    return date2;
                }
            }
            return null;
        }
        return (Date) invokeL.objValue;
    }

    public final void D(DialogInterface dialogInterface, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{dialogInterface, Boolean.valueOf(z), str}) == null) {
            dialogInterface.dismiss();
            this.f8132d = null;
            if (z) {
                d(str, new b.a.p0.a.u.h.b(0));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", QueryResponse.Options.CANCEL);
                d(str, new b.a.p0.a.u.h.b(0, jSONObject));
            } catch (JSONException e2) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e2.printStackTrace();
                }
                d(str, new b.a.p0.a.u.h.b(202));
            }
        }
    }

    public b.a.p0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new b.a.p0.a.u.h.b(202);
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("showDatePickerView", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                b.a.p0.a.e0.d.b("Api-Base", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                b.a.p0.a.e0.d.b("Api-Base", "paramsJson is null");
                return new b.a.p0.a.u.h.b(1001);
            }
            String optString = jSONObject.optString("mode");
            if (TextUtils.isEmpty(optString)) {
                return new b.a.p0.a.u.h.b(202);
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
            if (c2 != 0) {
                if (c2 != 1) {
                    return new b.a.p0.a.u.h.b(202);
                }
                return w(jSONObject);
            }
            return y(jSONObject);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new b.a.p0.a.u.h.b(202);
            }
            if (this.f8132d == null) {
                return new b.a.p0.a.u.h.b(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("column");
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                int optInt2 = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.e0.d.b("Api-Base", "callback is null");
                    return new b.a.p0.a.u.h.b(1001, "callback is null");
                }
                if (optJSONArray != null) {
                    q0.b0(new c(this, optInt, optJSONArray, optInt2));
                    d(optString, new b.a.p0.a.u.h.b(0, jSONObject));
                }
                return new b.a.p0.a.u.h.b(0);
            } catch (JSONException e2) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e2.printStackTrace();
                }
                return new b.a.p0.a.u.h.b(202);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.u.h.b w(JSONObject jSONObject) {
        InterceptResult invokeL;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("title");
            String optString5 = jSONObject.optString("fields");
            String[] strArr = {"yyyy-MM-dd", "yyyy-MM", "yyyy"};
            Date B = B(optString, strArr, "1900-01-01");
            Date B2 = B(optString2, strArr, "2099-12-31");
            if (B != null && B2 != null && !B2.before(B)) {
                String optString6 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString6)) {
                    b.a.p0.a.e0.d.b("Api-Base", "callback is null");
                    return new b.a.p0.a.u.h.b(1001, "callback is null");
                }
                Date B3 = B(optString3, strArr, null);
                if (B3 == null) {
                    B3 = new Date();
                }
                if (B3.before(B)) {
                    date = B;
                } else {
                    date = B3.after(B2) ? B2 : B3;
                }
                q0.b0(new b(this, optString5, B, B2, date, optBoolean, optString4, optString6));
                return new b.a.p0.a.u.h.b(0);
            }
            return new b.a.p0.a.u.h.b(202);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.u.h.b x(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, jSONObject, z)) == null) {
            if (this.f8132d != null) {
                return new b.a.p0.a.u.h.b(1001);
            }
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "handleOpenMultiPicker: input params=" + jSONObject;
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            String str3 = null;
            if (jSONObject != null) {
                jSONArray = jSONObject.optJSONArray("array");
                jSONArray2 = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_CURRENT);
                str3 = jSONObject.optString("cb");
                str = jSONObject.optString("title");
            } else {
                str = "";
            }
            JSONArray jSONArray3 = jSONArray;
            JSONArray jSONArray4 = jSONArray2;
            String str4 = str3;
            String str5 = str;
            if (TextUtils.isEmpty(str4)) {
                b.a.p0.a.e0.d.b("Api-Base", "callback is null");
                return new b.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new d(this, jSONArray3, jSONArray4, z, jSONObject, str4, str5));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeLZ.objValue;
    }

    public final b.a.p0.a.u.h.b y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
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
            Date C = C(optString);
            Date C2 = C(optString2);
            Date C3 = C(optString3);
            if (C3 == null) {
                C3 = C(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
            }
            Date date = C3;
            if (C != null && C2 != null && !C2.before(C) && date != null) {
                String optString6 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString6)) {
                    b.a.p0.a.e0.d.b("Api-Base", "callback is null");
                    return new b.a.p0.a.u.h.b(1001, "callback is null");
                }
                q0.b0(new a(this, optString5, C, C2, date, optBoolean, optString4, optString6));
                return new b.a.p0.a.u.h.b(0);
            }
            return new b.a.p0.a.u.h.b(202);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new b.a.p0.a.u.h.b(202);
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("showDatePickerView", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                b.a.p0.a.e0.d.b("Api-Base", "parse fail");
                return bVar;
            }
            return x((JSONObject) b2.second, false);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
