package c.a.p0.a.p0.f;

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
import c.a.p0.a.p2.q0;
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
    public EditText f6805b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f6806c;

    /* renamed from: d  reason: collision with root package name */
    public int f6807d;

    /* renamed from: e  reason: collision with root package name */
    public d f6808e;

    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6809e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f6810f;

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
            this.f6810f = bVar;
            this.f6809e = i2;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                int selectionStart = this.f6810f.f6805b.getSelectionStart();
                Editable text = this.f6810f.f6805b.getText();
                if (i2 == 11) {
                    if (selectionStart <= 0 || text == null || text.length() <= 0) {
                        return;
                    }
                    int i3 = selectionStart - 1;
                    text.delete(i3, selectionStart);
                    this.f6810f.f6805b.setText(text);
                    this.f6810f.f6805b.setSelection(i3);
                    return;
                }
                int length = text.length();
                int i4 = this.f6809e;
                if (length < i4 || i4 < 0) {
                    text.insert(selectionStart, this.f6810f.f6806c[i2]);
                    this.f6810f.f6805b.setText(text);
                    this.f6810f.f6805b.setSelection(selectionStart + this.f6810f.f6806c[i2].length());
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.p0.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0423b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f6811e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f6812f;

        /* renamed from: c.a.p0.a.p0.f.b$b$a */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC0423b f6813e;

            public a(RunnableC0423b runnableC0423b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0423b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6813e = runnableC0423b;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    RunnableC0423b runnableC0423b = this.f6813e;
                    runnableC0423b.f6812f.onItemClick(runnableC0423b.f6811e, view, intValue, intValue);
                }
            }
        }

        public RunnableC0423b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
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
            this.f6811e = gridView;
            this.f6812f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int childCount = this.f6811e.getChildCount();
                if (childCount > 0) {
                    this.f6811e.setClickable(false);
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.f6811e.getChildAt(i2);
                        childAt.setTag(Integer.valueOf(i2));
                        childAt.setOnClickListener(new a(this));
                    }
                    return;
                }
                this.f6811e.setOnItemClickListener(this.f6812f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f6814e;

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
            this.f6814e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6814e.dismiss();
                this.f6814e.f6805b.clearFocus();
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
        this.f6806c = new String[12];
        c(i2);
        d(swanAppActivity, editText, i3);
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i3 = 0;
            while (i3 < 9) {
                int i4 = i3 + 1;
                this.f6806c[i3] = String.valueOf(i4);
                i3 = i4;
            }
            if (i2 == 1) {
                this.f6806c[9] = "X";
            } else if (i2 == 0) {
                this.f6806c[9] = "";
            } else if (i2 == 2) {
                this.f6806c[9] = ".";
            }
            this.f6806c[10] = "0";
        }
    }

    public final void d(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity, editText, i2) == null) {
            this.a = swanAppActivity;
            this.f6805b = editText;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(R.layout.aiapps_keyboard_layout, (ViewGroup) null);
            this.f6807d = swanAppActivity.getResources().getDimensionPixelOffset(R.dimen.aiapps_keyboard_total_height);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            GridView gridView = (GridView) linearLayout.findViewById(R.id.keyboard_grid_view);
            gridView.setAdapter((ListAdapter) new c.a.p0.a.p0.f.a(swanAppActivity, this.f6806c));
            q0.a0(new RunnableC0423b(this, gridView, new a(this, i2)));
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.close_btn);
            imageView.setOnClickListener(new c(this));
            imageView.setClickable(true);
            setContentView(linearLayout);
            setWidth(-1);
            setHeight(this.f6807d);
            setBackgroundDrawable(new BitmapDrawable());
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            d dVar = this.f6808e;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public void e(@NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f6808e = dVar;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isShowing()) {
            return;
        }
        showAtLocation(this.a.getWindow().getDecorView(), 80, 0, 0);
        d dVar = this.f6808e;
        if (dVar != null) {
            dVar.b(this.f6807d);
        }
    }
}
