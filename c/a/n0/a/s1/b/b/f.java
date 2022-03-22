package c.a.n0.a.s1.b.b;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.n0.a.s1.b.b.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public TextView f6215f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f6216g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f6217h;
        public TextView i;
        public LinearLayout j;
        public LinearLayout k;
        public CheckBox l;

        /* renamed from: c.a.n0.a.s1.b.b.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnKeyListenerC0448a implements DialogInterface.OnKeyListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f6218b;

            public DialogInterface$OnKeyListenerC0448a(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f6218b = aVar;
                this.a = onClickListener;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                DialogInterface.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                    if (keyEvent.getAction() == 1 && i == 4 && keyEvent.getRepeatCount() == 0 && (onClickListener = this.a) != null) {
                        onClickListener.onClick(dialogInterface, this.f6218b.c0());
                        return true;
                    }
                    return false;
                }
                return invokeLIL.booleanValue;
            }
        }

        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f6219b;

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
                this.f6219b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.a) == null) {
                    return;
                }
                a aVar = this.f6219b;
                onClickListener.onClick(aVar.f6224b, aVar.c0());
            }
        }

        /* loaded from: classes.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f6220b;

            public c(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f6220b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.a) == null) {
                    return;
                }
                a aVar = this.f6220b;
                onClickListener.onClick(aVar.f6224b, aVar.c0());
            }
        }

        /* loaded from: classes.dex */
        public class d implements DialogInterface.OnShowListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnShowListener a;

            public d(a aVar, DialogInterface.OnShowListener onShowListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onShowListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = onShowListener;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                DialogInterface.OnShowListener onShowListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (onShowListener = this.a) == null) {
                    return;
                }
                onShowListener.onShow(dialogInterface);
            }
        }

        /* loaded from: classes.dex */
        public class e implements DialogInterface.OnDismissListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnDismissListener a;

            public e(a aVar, DialogInterface.OnDismissListener onDismissListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onDismissListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = onDismissListener;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                DialogInterface.OnDismissListener onDismissListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (onDismissListener = this.a) == null) {
                    return;
                }
                onDismissListener.onDismiss(dialogInterface);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n(new c.a.n0.a.q2.h.a());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d07ba, e(), false);
            W(viewGroup);
            this.j = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0902d2);
            this.f6217h = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0902d3);
            this.i = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0902d4);
            this.k = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091009);
            this.l = (CheckBox) viewGroup.findViewById(R.id.obfuscated_res_0x7f090df5);
            this.f6215f = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090df7);
            this.f6216g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090df6);
            this.l.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f081166), (Drawable) null, (Drawable) null, (Drawable) null);
            this.k.setVisibility(8);
            this.j.setVisibility(0);
            this.l.setVisibility(0);
            this.f6224b.setCancelable(false);
        }

        @Override // c.a.n0.a.s1.b.b.h.a
        public /* bridge */ /* synthetic */ h.a N(DialogInterface.OnShowListener onShowListener) {
            j0(onShowListener);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.s1.b.b.h.a
        /* renamed from: b0 */
        public f c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (f) super.c() : (f) invokeV.objValue;
        }

        public final int c0() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l.isChecked() ? 1 : 0 : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.s1.b.b.h.a
        /* renamed from: d0 */
        public f h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? new f(context) : (f) invokeL.objValue;
        }

        public a e0(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f6216g.setText(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f0(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f6215f.setText(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g0(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, onClickListener)) == null) {
                this.f6217h.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a h0(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, onClickListener)) == null) {
                super.M(new DialogInterface$OnKeyListenerC0448a(this, onClickListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a i0(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onDismissListener)) == null) {
                super.L(new e(this, onDismissListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a j0(DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, onShowListener)) == null) {
                super.N(new d(this, onShowListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a k0(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, onClickListener)) == null) {
                this.i.setOnClickListener(new c(this, onClickListener));
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context, R.style.obfuscated_res_0x7f1001a0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100393);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            h.a c2 = c();
            c2.p(R.drawable.obfuscated_res_0x7f080125);
            c2.f(true);
            c2.k(false);
            c2.j();
            c2.t(false);
        }
    }
}
