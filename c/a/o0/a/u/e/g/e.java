package c.a.o0.a.u.e.g;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.v2.k;
import c.a.o0.a.v2.q0;
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
public class e extends c.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppPickerDialog f8835d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f8837f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f8838g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f8839h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f8840i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8841j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;

        /* renamed from: c.a.o0.a.u.e.g.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnCancelListenerC0397a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f8842e;

            public DialogInterface$OnCancelListenerC0397a(a aVar) {
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
                this.f8842e = aVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    a aVar = this.f8842e;
                    aVar.l.d(aVar.k, new c.a.o0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f8843e;

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
                this.f8843e = aVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    a aVar = this.f8843e;
                    aVar.l.d(aVar.k, new c.a.o0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f8844e;

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
                this.f8844e = aVar;
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
                        if (c.a.o0.a.u.c.d.f8699c) {
                            String str = "handleShowDatePicker params = " + jSONObject.toString();
                        }
                        this.f8844e.l.d(this.f8844e.k, new c.a.o0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (c.a.o0.a.u.c.d.f8699c) {
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
            this.f8836e = str;
            this.f8837f = date;
            this.f8838g = date2;
            this.f8839h = date3;
            this.f8840i = z;
            this.f8841j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TimePickerDialog.a aVar = new TimePickerDialog.a(this.l.i());
                if (!TextUtils.isEmpty(this.f8836e)) {
                    aVar.n(this.f8836e);
                }
                aVar.p(this.f8837f);
                aVar.m(this.f8838g);
                aVar.o(this.f8839h);
                aVar.l(this.f8840i);
                aVar.c(true);
                aVar.g(this.f8841j);
                aVar.h(c.a.o0.a.h.aiapps_confirm, new c(this));
                aVar.d(c.a.o0.a.h.aiapps_cancel, new b(this));
                aVar.f(new DialogInterface$OnCancelListenerC0397a(this));
                aVar.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8845e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Date f8846f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Date f8847g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Date f8848h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f8849i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8850j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;

        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8851e;

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
                this.f8851e = bVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    b bVar = this.f8851e;
                    bVar.l.d(bVar.k, new c.a.o0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* renamed from: c.a.o0.a.u.e.g.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0398b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8852e;

            public DialogInterface$OnClickListenerC0398b(b bVar) {
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
                this.f8852e = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    b bVar = this.f8852e;
                    bVar.l.d(bVar.k, new c.a.o0.a.u.h.b(0));
                    dialogInterface.dismiss();
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8853e;

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
                this.f8853e = bVar;
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
                            if (c.a.o0.a.u.c.d.f8699c) {
                                String str = "handleShowDatePicker params = " + jSONObject.toString();
                            }
                            this.f8853e.l.d(this.f8853e.k, new c.a.o0.a.u.h.b(0, jSONObject));
                        } catch (JSONException e2) {
                            if (c.a.o0.a.u.c.d.f8699c) {
                                e2.printStackTrace();
                            }
                            b bVar = this.f8853e;
                            bVar.l.d(bVar.k, new c.a.o0.a.u.h.b(202));
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
            this.f8845e = str;
            this.f8846f = date;
            this.f8847g = date2;
            this.f8848h = date3;
            this.f8849i = z;
            this.f8850j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DatePickerDialog.a aVar = new DatePickerDialog.a(this.l.i());
                if (!TextUtils.isEmpty(this.f8845e)) {
                    aVar.n(this.f8845e);
                }
                aVar.p(this.f8846f);
                aVar.m(this.f8847g);
                aVar.o(this.f8848h);
                aVar.l(this.f8849i);
                aVar.c(true);
                aVar.g(this.f8850j);
                aVar.h(c.a.o0.a.h.aiapps_confirm, new c(this));
                aVar.d(c.a.o0.a.h.aiapps_cancel, new DialogInterface$OnClickListenerC0398b(this));
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
        public final /* synthetic */ int f8854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8855f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8856g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f8857h;

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
            this.f8857h = eVar;
            this.f8854e = i2;
            this.f8855f = jSONArray;
            this.f8856g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8857h.f8835d == null) {
                return;
            }
            ((MultiPickerDialog) this.f8857h.f8835d).updateWheel(this.f8854e, this.f8855f, this.f8856g);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8859f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8860g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8861h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8862i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8863j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8864e;

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
                this.f8864e = dVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    d dVar = this.f8864e;
                    dVar.k.E(dialogInterface, dVar.f8860g, dVar.f8862i);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8865e;

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
                this.f8865e = dVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    d dVar = this.f8865e;
                    dVar.k.E(dialogInterface, dVar.f8860g, dVar.f8862i);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8866e;

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
                this.f8866e = dVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    dialogInterface.dismiss();
                    this.f8866e.k.f8835d = null;
                    try {
                        JSONArray currentIndex = ((MultiPickerDialog) dialogInterface).getCurrentIndex();
                        JSONObject jSONObject = new JSONObject();
                        if (currentIndex != null && currentIndex.length() > 0) {
                            if (this.f8866e.f8860g) {
                                jSONObject.put("value", currentIndex.optInt(0));
                            } else {
                                jSONObject.put("value", currentIndex);
                                jSONObject.put("type", "confirm");
                            }
                        }
                        this.f8866e.k.d(this.f8866e.f8862i, new c.a.o0.a.u.h.b(0, jSONObject));
                        if (c.a.o0.a.u.c.d.f8699c) {
                            String str = "handleOpenMultiPicker: output params = " + jSONObject.toString();
                        }
                    } catch (JSONException e2) {
                        if (c.a.o0.a.u.c.d.f8699c) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }

        /* renamed from: c.a.o0.a.u.e.g.e$d$d  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0399d implements BdMultiPicker.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f8867a;

            public C0399d(d dVar) {
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
                this.f8867a = dVar;
            }

            @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
            public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, bdMultiPicker, jSONObject) == null) {
                    if (c.a.o0.a.u.c.d.f8699c) {
                        String str = "onMultiSelectedChanged: params=" + this.f8867a.f8861h;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                        jSONObject2.put("type", "columnChange");
                        this.f8867a.k.d(this.f8867a.f8862i, new c.a.o0.a.u.h.b(0, jSONObject2));
                    } catch (JSONException e2) {
                        if (c.a.o0.a.u.c.d.f8699c) {
                            e2.printStackTrace();
                        }
                        d dVar = this.f8867a;
                        dVar.k.d(dVar.f8862i, new c.a.o0.a.u.h.b(202));
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
            this.f8858e = jSONArray;
            this.f8859f = jSONArray2;
            this.f8860g = z;
            this.f8861h = jSONObject;
            this.f8862i = str;
            this.f8863j = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MultiPickerDialog.a aVar = new MultiPickerDialog.a(this.k.i());
                e eVar = this.k;
                aVar.l(this.f8858e);
                aVar.m(this.f8859f);
                aVar.o(this.f8860g);
                aVar.n(new C0399d(this));
                aVar.c(true);
                aVar.g(this.f8863j);
                aVar.h(c.a.o0.a.h.aiapps_confirm, new c(this));
                aVar.d(c.a.o0.a.h.aiapps_cancel, new b(this));
                aVar.f(new a(this));
                eVar.f8835d = aVar.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull c.a.o0.a.u.c.b bVar) {
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
                super((c.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.o0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new c.a.o0.a.u.h.b(202);
            }
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("showDatePickerView", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                c.a.o0.a.e0.d.b("Api-Base", "parse fail");
                return bVar;
            }
            return y((JSONObject) b2.second, false);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public c.a.o0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new c.a.o0.a.u.h.b(202);
            }
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("showDatePickerView", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                c.a.o0.a.e0.d.b("Api-Base", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                return new c.a.o0.a.u.h.b(202);
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
                    return y(jSONObject, true);
                } catch (JSONException unused) {
                    return new c.a.o0.a.u.h.b(1001);
                }
            }
            return new c.a.o0.a.u.h.b(202);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final Date C(String str, String[] strArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, strArr, str2)) == null) {
            Date d2 = !TextUtils.isEmpty(str) ? k.d(str, strArr) : null;
            return (d2 != null || TextUtils.isEmpty(str2)) ? d2 : k.d(str2, strArr);
        }
        return (Date) invokeLLL.objValue;
    }

    public final Date D(String str) {
        InterceptResult invokeL;
        String[] split;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
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
                    if (c.a.o0.a.u.c.d.f8699c) {
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

    public final void E(DialogInterface dialogInterface, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{dialogInterface, Boolean.valueOf(z), str}) == null) {
            dialogInterface.dismiss();
            this.f8835d = null;
            if (z) {
                d(str, new c.a.o0.a.u.h.b(0));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", QueryResponse.Options.CANCEL);
                d(str, new c.a.o0.a.u.h.b(0, jSONObject));
            } catch (JSONException e2) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    e2.printStackTrace();
                }
                d(str, new c.a.o0.a.u.h.b(202));
            }
        }
    }

    public c.a.o0.a.u.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new c.a.o0.a.u.h.b(202);
            }
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("showDatePickerView", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                c.a.o0.a.e0.d.b("Api-Base", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                c.a.o0.a.e0.d.b("Api-Base", "paramsJson is null");
                return new c.a.o0.a.u.h.b(1001);
            }
            String optString = jSONObject.optString("mode");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.o0.a.u.h.b(202);
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
                    return new c.a.o0.a.u.h.b(202);
                }
                return x(jSONObject);
            }
            return z(jSONObject);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public c.a.o0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new c.a.o0.a.u.h.b(202);
            }
            if (this.f8835d == null) {
                return new c.a.o0.a.u.h.b(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("column");
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                int optInt2 = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT);
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.o0.a.e0.d.b("Api-Base", "callback is null");
                    return new c.a.o0.a.u.h.b(1001, "callback is null");
                }
                if (optJSONArray != null) {
                    q0.b0(new c(this, optInt, optJSONArray, optInt2));
                    d(optString, new c.a.o0.a.u.h.b(0, jSONObject));
                }
                return new c.a.o0.a.u.h.b(0);
            } catch (JSONException e2) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    e2.printStackTrace();
                }
                return new c.a.o0.a.u.h.b(202);
            }
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.o0.a.u.h.b x(JSONObject jSONObject) {
        InterceptResult invokeL;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            boolean optBoolean = jSONObject.optBoolean("disabled", false);
            String optString = jSONObject.optString("start");
            String optString2 = jSONObject.optString("end");
            String optString3 = jSONObject.optString("value");
            String optString4 = jSONObject.optString("title");
            String optString5 = jSONObject.optString("fields");
            String[] strArr = {"yyyy-MM-dd", "yyyy-MM", "yyyy"};
            Date C = C(optString, strArr, "1900-01-01");
            Date C2 = C(optString2, strArr, "2099-12-31");
            if (C != null && C2 != null && !C2.before(C)) {
                String optString6 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString6)) {
                    c.a.o0.a.e0.d.b("Api-Base", "callback is null");
                    return new c.a.o0.a.u.h.b(1001, "callback is null");
                }
                Date C3 = C(optString3, strArr, null);
                if (C3 == null) {
                    C3 = new Date();
                }
                if (C3.before(C)) {
                    date = C;
                } else {
                    date = C3.after(C2) ? C2 : C3;
                }
                q0.b0(new b(this, optString5, C, C2, date, optBoolean, optString4, optString6));
                return new c.a.o0.a.u.h.b(0);
            }
            return new c.a.o0.a.u.h.b(202);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.o0.a.u.h.b y(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, z)) == null) {
            if (this.f8835d != null) {
                return new c.a.o0.a.u.h.b(1001);
            }
            if (c.a.o0.a.u.c.d.f8699c) {
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
                c.a.o0.a.e0.d.b("Api-Base", "callback is null");
                return new c.a.o0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new d(this, jSONArray3, jSONArray4, z, jSONObject, str4, str5));
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeLZ.objValue;
    }

    public final c.a.o0.a.u.h.b z(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
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
            Date D = D(optString);
            Date D2 = D(optString2);
            Date D3 = D(optString3);
            if (D3 == null) {
                D3 = D(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
            }
            Date date = D3;
            if (D != null && D2 != null && !D2.before(D) && date != null) {
                String optString6 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString6)) {
                    c.a.o0.a.e0.d.b("Api-Base", "callback is null");
                    return new c.a.o0.a.u.h.b(1001, "callback is null");
                }
                q0.b0(new a(this, optString5, D, D2, date, optBoolean, optString4, optString6));
                return new c.a.o0.a.u.h.b(0);
            }
            return new c.a.o0.a.u.h.b(202);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }
}
