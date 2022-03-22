package c.a.n0.a.p0.f;

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
import c.a.n0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
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
    public EditText f5723b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f5724c;

    /* renamed from: d  reason: collision with root package name */
    public int f5725d;

    /* renamed from: e  reason: collision with root package name */
    public d f5726e;

    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f5727b;

        public a(b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5727b = bVar;
            this.a = i;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                int selectionStart = this.f5727b.f5723b.getSelectionStart();
                Editable text = this.f5727b.f5723b.getText();
                if (i == 11) {
                    if (selectionStart <= 0 || text == null || text.length() <= 0) {
                        return;
                    }
                    int i2 = selectionStart - 1;
                    text.delete(i2, selectionStart);
                    this.f5727b.f5723b.setText(text);
                    this.f5727b.f5723b.setSelection(i2);
                    return;
                }
                int length = text.length();
                int i3 = this.a;
                if (length < i3 || i3 < 0) {
                    text.insert(selectionStart, this.f5727b.f5724c[i]);
                    this.f5727b.f5723b.setText(text);
                    this.f5727b.f5723b.setSelection(selectionStart + this.f5727b.f5724c[i].length());
                }
            }
        }
    }

    /* renamed from: c.a.n0.a.p0.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0411b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GridView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f5728b;

        /* renamed from: c.a.n0.a.p0.f.b$b$a */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RunnableC0411b a;

            public a(RunnableC0411b runnableC0411b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0411b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = runnableC0411b;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    RunnableC0411b runnableC0411b = this.a;
                    runnableC0411b.f5728b.onItemClick(runnableC0411b.a, view, intValue, intValue);
                }
            }
        }

        public RunnableC0411b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, gridView, onItemClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gridView;
            this.f5728b = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int childCount = this.a.getChildCount();
                if (childCount > 0) {
                    this.a.setClickable(false);
                    for (int i = 0; i < childCount; i++) {
                        View childAt = this.a.getChildAt(i);
                        childAt.setTag(Integer.valueOf(i));
                        childAt.setOnClickListener(new a(this));
                    }
                    return;
                }
                this.a.setOnItemClickListener(this.f5728b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.dismiss();
                this.a.f5723b.clearFocus();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i, int i2) {
        super(swanAppActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, editText, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5724c = new String[12];
        c(i);
        d(swanAppActivity, editText, i2);
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int i2 = 0;
            while (i2 < 9) {
                int i3 = i2 + 1;
                this.f5724c[i2] = String.valueOf(i3);
                i2 = i3;
            }
            if (i == 1) {
                this.f5724c[9] = "X";
            } else if (i == 0) {
                this.f5724c[9] = "";
            } else if (i == 2) {
                this.f5724c[9] = ".";
            }
            this.f5724c[10] = "0";
        }
    }

    public final void d(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity, editText, i) == null) {
            this.a = swanAppActivity;
            this.f5723b = editText;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(R.layout.obfuscated_res_0x7f0d00b9, (ViewGroup) null);
            this.f5725d = swanAppActivity.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070154);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            GridView gridView = (GridView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091008);
            gridView.setAdapter((ListAdapter) new c.a.n0.a.p0.f.a(swanAppActivity, this.f5724c));
            q0.a0(new RunnableC0411b(this, gridView, new a(this, i)));
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090668);
            imageView.setOnClickListener(new c(this));
            imageView.setClickable(true);
            setContentView(linearLayout);
            setWidth(-1);
            setHeight(this.f5725d);
            setBackgroundDrawable(new BitmapDrawable());
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            d dVar = this.f5726e;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public void e(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f5726e = dVar;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isShowing()) {
            return;
        }
        showAtLocation(this.a.getWindow().getDecorView(), 80, 0, 0);
        d dVar = this.f5726e;
        if (dVar != null) {
            dVar.b(this.f5725d);
        }
    }
}
