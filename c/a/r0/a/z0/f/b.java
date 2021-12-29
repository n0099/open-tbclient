package c.a.r0.a.z0.f;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import c.a.r0.a.f;
import c.a.r0.a.g;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f10058b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f10059c;

    /* renamed from: d  reason: collision with root package name */
    public int f10060d;

    /* renamed from: e  reason: collision with root package name */
    public d f10061e;

    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f10062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10063f;

        public a(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10063f = bVar;
            this.f10062e = i2;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                int selectionStart = this.f10063f.f10058b.getSelectionStart();
                Editable text = this.f10063f.f10058b.getText();
                if (i2 == 11) {
                    if (selectionStart <= 0 || text == null || text.length() <= 0) {
                        return;
                    }
                    int i3 = selectionStart - 1;
                    text.delete(i3, selectionStart);
                    this.f10063f.f10058b.setText(text);
                    this.f10063f.f10058b.setSelection(i3);
                    return;
                }
                int length = text.length();
                int i4 = this.f10062e;
                if (length < i4 || i4 < 0) {
                    text.insert(selectionStart, this.f10063f.f10059c[i2]);
                    this.f10063f.f10058b.setText(text);
                    this.f10063f.f10058b.setSelection(selectionStart + this.f10063f.f10059c[i2].length());
                }
            }
        }
    }

    /* renamed from: c.a.r0.a.z0.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0637b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f10064e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f10065f;

        /* renamed from: c.a.r0.a.z0.f.b$b$a */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC0637b f10066e;

            public a(RunnableC0637b runnableC0637b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0637b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10066e = runnableC0637b;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    RunnableC0637b runnableC0637b = this.f10066e;
                    runnableC0637b.f10065f.onItemClick(runnableC0637b.f10064e, view, intValue, intValue);
                }
            }
        }

        public RunnableC0637b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, gridView, onItemClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10064e = gridView;
            this.f10065f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int childCount = this.f10064e.getChildCount();
                if (childCount > 0) {
                    this.f10064e.setClickable(false);
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.f10064e.getChildAt(i2);
                        childAt.setTag(Integer.valueOf(i2));
                        childAt.setOnClickListener(new a(this));
                    }
                    return;
                }
                this.f10064e.setOnItemClickListener(this.f10065f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10067e;

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
            this.f10067e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f10067e.dismiss();
                this.f10067e.f10058b.clearFocus();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i2, int i3) {
        super(swanAppActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, editText, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10059c = new String[12];
        c(i2);
        d(swanAppActivity, editText, i3);
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i3 = 0;
            while (i3 < 9) {
                int i4 = i3 + 1;
                this.f10059c[i3] = String.valueOf(i4);
                i3 = i4;
            }
            if (i2 == 1) {
                this.f10059c[9] = "X";
            } else if (i2 == 0) {
                this.f10059c[9] = "";
            } else if (i2 == 2) {
                this.f10059c[9] = ".";
            }
            this.f10059c[10] = "0";
        }
    }

    public final void d(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity, editText, i2) == null) {
            this.a = swanAppActivity;
            this.f10058b = editText;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
            this.f10060d = swanAppActivity.getResources().getDimensionPixelOffset(c.a.r0.a.d.aiapps_keyboard_total_height);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
            gridView.setAdapter((ListAdapter) new c.a.r0.a.z0.f.a(swanAppActivity, this.f10059c));
            q0.a0(new RunnableC0637b(this, gridView, new a(this, i2)));
            ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
            imageView.setOnClickListener(new c(this));
            imageView.setClickable(true);
            setContentView(linearLayout);
            setWidth(-1);
            setHeight(this.f10060d);
            setBackgroundDrawable(new BitmapDrawable());
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            d dVar = this.f10061e;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public void e(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f10061e = dVar;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isShowing()) {
            return;
        }
        showAtLocation(this.a.getWindow().getDecorView(), 80, 0, 0);
        d dVar = this.f10061e;
        if (dVar != null) {
            dVar.b(this.f10060d);
        }
    }
}
