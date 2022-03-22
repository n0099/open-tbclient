package c.a.n0.a.s1.b.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class i extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f6240b;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;

        /* renamed from: b  reason: collision with root package name */
        public final i f6241b;

        /* renamed from: c  reason: collision with root package name */
        public Context f6242c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6243d;

        /* renamed from: c.a.n0.a.s1.b.b.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0450a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f6244b;

            public View$OnClickListenerC0450a(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6244b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f6244b.f6241b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f6244b.f6241b, -1);
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f6245b;

            public b(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6245b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f6245b.f6241b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f6245b.f6241b, -2);
                    }
                }
            }
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6243d = false;
            i b2 = b(context);
            this.f6241b = b2;
            b2.d(this);
            this.a = new b((ViewGroup) this.f6241b.getWindow().getDecorView());
            this.f6242c = context;
        }

        public i a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f6241b.setOnCancelListener(this.a.f6250f);
                this.f6241b.setOnDismissListener(this.a.f6251g);
                this.f6241b.setOnShowListener(this.a.f6252h);
                this.f6241b.d(this);
                return this.f6241b;
            }
            return (i) invokeV.objValue;
        }

        public abstract i b(Context context);

        public a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f6241b.setCanceledOnTouchOutside(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a d(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, onClickListener)) == null) {
                e(this.f6242c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, charSequence, onClickListener)) == null) {
                this.a.f6246b.setText(charSequence);
                this.a.f6246b.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, onCancelListener)) == null) {
                this.a.f6250f = onCancelListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.a.f6247c.setText(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a h(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, onClickListener)) == null) {
                i(this.f6242c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, onClickListener)) == null) {
                this.a.a.setText(charSequence);
                this.a.a.setOnClickListener(new View$OnClickListenerC0450a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a j(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
                this.a.f6249e.removeAllViews();
                this.a.f6249e.addView(view);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public i k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                i a = a();
                if (this.f6243d) {
                    a.getWindow().setType(2003);
                }
                try {
                    a.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a;
            }
            return (i) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f6246b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f6247c;

        /* renamed from: d  reason: collision with root package name */
        public View f6248d;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f6249e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnCancelListener f6250f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnDismissListener f6251g;

        /* renamed from: h  reason: collision with root package name */
        public DialogInterface.OnShowListener f6252h;
        public FrameLayout i;
        public FrameLayout j;
        public View k;
        public ViewGroup l;
        public RelativeLayout m;
        public LinearLayout n;
        public View o;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = viewGroup;
            this.j = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907b3);
            this.f6247c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092051);
            this.a = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0918a9);
            this.f6246b = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091535);
            this.f6248d = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907a1);
            this.f6249e = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907a2);
            this.m = (RelativeLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091c52);
            this.n = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f090429);
            this.o = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907a1);
            this.i = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907b3);
            this.k = viewGroup.findViewById(R.id.obfuscated_res_0x7f09157c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6240b : (a) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d07dd);
            getWindow().setLayout(-1, -2);
            getWindow().setGravity(80);
            a(false);
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f6240b = aVar;
        }
    }
}
