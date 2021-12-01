package c.a.p0.a.z1.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.publisher.emoji.view.EmojiBagLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static a f9061d;

    /* renamed from: e  reason: collision with root package name */
    public static Context f9062e;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9063b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f9064c;

    /* renamed from: c.a.p0.a.z1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0556a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9065e;

        public RunnableC0556a(a aVar) {
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
            this.f9065e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9065e.a.dispatchKeyEvent(new KeyEvent(0, 67));
                this.f9065e.a.postDelayed(this.f9065e.f9064c, 60L);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9066e;

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
            this.f9066e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                Object adapter = adapterView.getAdapter();
                if (adapter instanceof EmojiBagLayout.b) {
                    EmojiBagLayout.b bVar = (EmojiBagLayout.b) adapter;
                    if (this.f9066e.a == null) {
                        return;
                    }
                    if (i2 == bVar.getCount() - 1) {
                        if (this.f9066e.f9063b) {
                            this.f9066e.a.removeCallbacks(this.f9066e.f9064c);
                            this.f9066e.f9063b = false;
                            return;
                        }
                        this.f9066e.a.dispatchKeyEvent(new KeyEvent(0, 67));
                        return;
                    }
                    String item = bVar.getItem(i2);
                    if (TextUtils.isEmpty(item)) {
                        return;
                    }
                    this.f9066e.a.getEditableText().insert(this.f9066e.a.getSelectionStart(), c.a.p0.a.z1.h.b.c().g(a.f9062e, item, this.f9066e.a));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9067e;

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
            this.f9067e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                Object adapter = adapterView.getAdapter();
                if ((adapter instanceof EmojiBagLayout.b) && i2 == ((EmojiBagLayout.b) adapter).getCount() - 1) {
                    this.f9067e.f9063b = true;
                    if (this.f9067e.a != null) {
                        this.f9067e.a.post(this.f9067e.f9064c);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9068e;

        public d(a aVar) {
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
            this.f9068e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f9068e.k();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9064c = new RunnableC0556a(this);
    }

    public static a g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            f9062e = context.getApplicationContext();
            if (f9061d == null) {
                synchronized (a.class) {
                    if (f9061d == null) {
                        f9061d = new a();
                    }
                }
            }
            return f9061d;
        }
        return (a) invokeL.objValue;
    }

    public void f(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editText) == null) {
            this.a = editText;
        }
    }

    public AdapterView.OnItemClickListener h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this) : (AdapterView.OnItemClickListener) invokeV.objValue;
    }

    public AdapterView.OnItemLongClickListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new c(this) : (AdapterView.OnItemLongClickListener) invokeV.objValue;
    }

    public View.OnTouchListener j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new d(this) : (View.OnTouchListener) invokeV.objValue;
    }

    public void k() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (editText = this.a) == null) {
            return;
        }
        editText.removeCallbacks(this.f9064c);
    }
}
