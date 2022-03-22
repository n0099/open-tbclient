package c.a.n0.a.x.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.n0.a.p2.b0;
import c.a.n0.a.p2.n0;
import c.a.n0.a.s1.b.b.b;
import c.a.n0.a.s1.b.b.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.s1.b.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View k;
    public TextView l;
    public SelectorTextView m;
    public C0535c n;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.n.k == null) {
                return;
            }
            this.a.n.k.a(view);
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.n.j == null) {
                return;
            }
            this.a.n.j.a(view);
        }
    }

    /* renamed from: c.a.n0.a.x.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0535c extends b.C0447b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public int f7079g;

        /* renamed from: h  reason: collision with root package name */
        public int f7080h;
        public int i;
        public b.c j;
        public b.c k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0535c(Context context) {
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
        }

        @Override // c.a.n0.a.s1.b.b.h.a
        public /* bridge */ /* synthetic */ h.a U(int i) {
            g0(i);
            return this;
        }

        @Override // c.a.n0.a.s1.b.b.b.C0447b, c.a.n0.a.s1.b.b.h.a
        public h c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c cVar = (c) super.c();
                cVar.r(this);
                return cVar;
            }
            return (h) invokeV.objValue;
        }

        public C0535c e0(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.f7079g = i;
                return this;
            }
            return (C0535c) invokeI.objValue;
        }

        public C0535c f0(int i, b.c cVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, cVar)) == null) {
                this.f7079g = i;
                this.k = cVar;
                return this;
            }
            return (C0535c) invokeIL.objValue;
        }

        public C0535c g0(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                super.U(i);
                return this;
            }
            return (C0535c) invokeI.objValue;
        }

        @Override // c.a.n0.a.s1.b.b.h.a
        public h h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new c(context) : (h) invokeL.objValue;
        }

        @Override // c.a.n0.a.s1.b.b.h.a
        public /* bridge */ /* synthetic */ h.a v(int i) {
            e0(i);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
    }

    @Override // c.a.n0.a.s1.b.b.b
    public View k(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f6184g).inflate(R.layout.obfuscated_res_0x7f0d00d0, viewGroup, false);
            this.k = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091b0d);
            this.l = textView;
            textView.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603d5));
            SelectorTextView selectorTextView = (SelectorTextView) this.k.findViewById(R.id.obfuscated_res_0x7f091b0e);
            this.m = selectorTextView;
            selectorTextView.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603d4));
            q();
            return this.k;
        }
        return (View) invokeL.objValue;
    }

    public final void q() {
        C0535c c0535c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (c0535c = this.n) == null) {
            return;
        }
        this.l.setText(this.f6184g.getText(c0535c.f7079g));
        this.l.setOnClickListener(new a(this));
        if (this.n.f7080h > 0) {
            this.m.setVisibility(0);
            this.m.setText(this.f6184g.getText(this.n.f7080h));
            this.m.setOnClickListener(new b(this));
        } else {
            this.m.setVisibility(8);
        }
        if (this.n.i > 0) {
            Drawable drawable = this.f6184g.getResources().getDrawable(this.n.i);
            b0.b(getContext(), drawable);
            drawable.setBounds(0, 0, n0.f(this.f6184g, 12.0f), n0.f(this.f6184g, 12.0f));
            this.m.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void r(C0535c c0535c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0535c) == null) {
            this.n = c0535c;
        }
    }
}
