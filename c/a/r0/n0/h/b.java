package c.a.r0.n0.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.r0.n0.d.h;
import c.a.r0.n0.m.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f22569a;

    /* renamed from: b  reason: collision with root package name */
    public int f22570b;

    /* renamed from: c  reason: collision with root package name */
    public int f22571c;

    /* renamed from: d  reason: collision with root package name */
    public Context f22572d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.n0.m.a f22573e;

    /* renamed from: f  reason: collision with root package name */
    public d f22574f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.n0.m.e f22575g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22576h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f22577i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f22578j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22579a;

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
            this.f22579a = bVar;
        }

        @Override // c.a.r0.n0.m.a.d
        public void onItemClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f22579a.f22571c = i2;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
                this.f22579a.r();
                if (this.f22579a.f22574f != null) {
                    this.f22579a.f22574f.a(this.f22579a.f22571c);
                }
            }
        }
    }

    /* renamed from: c.a.r0.n0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1052b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22580e;

        public View$OnClickListenerC1052b(b bVar) {
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
            this.f22580e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22580e.f22575g.r()) {
                return;
            }
            if (view == this.f22580e.f22569a) {
                if (this.f22580e.f22573e == null) {
                    this.f22580e.f22573e = new c.a.r0.n0.m.a(this.f22580e.f22572d);
                    this.f22580e.f22573e.setOnDismissListener(this.f22580e.k);
                    this.f22580e.f22573e.l(this.f22580e.f22577i);
                    this.f22580e.f22573e.m(this.f22580e.f22570b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(this.f22580e.f22572d.getString(R.string.level_sort), 1));
                arrayList.add(new h(this.f22580e.f22572d.getString(R.string.update_sort), 2));
                this.f22580e.f22573e.k(arrayList, this.f22580e.f22571c);
                this.f22580e.f22573e.o(this.f22580e.f22569a);
            }
            this.f22580e.f22576h = true;
            b bVar = this.f22580e;
            bVar.s(bVar.f22576h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22581e;

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
            this.f22581e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22581e.f22576h = false;
                b bVar = this.f22581e;
                bVar.s(bVar.f22576h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i2);
    }

    public b(Context context, int i2, int i3, c.a.r0.n0.m.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22576h = false;
        this.f22577i = new a(this);
        this.f22578j = new View$OnClickListenerC1052b(this);
        this.k = new c(this);
        this.f22572d = context;
        this.f22571c = i2;
        this.f22570b = i3;
        this.f22575g = eVar;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f22571c;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        c.a.r0.n0.m.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f22573e) == null) {
            return;
        }
        aVar.i();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (o()) {
                SkinManager.setViewTextColor(this.f22569a, R.color.CAM_X0105, i2);
                if (this.f22569a != null) {
                    s(this.f22576h);
                }
            }
            c.a.r0.n0.m.a aVar = this.f22573e;
            if (aVar == null || !this.f22576h) {
                return;
            }
            aVar.j();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && o() && (textView = this.f22569a) != null) {
            int i2 = this.f22571c;
            if (i2 == 1) {
                textView.setText(R.string.level_sort);
            } else if (i2 == 2) {
                textView.setText(R.string.update_sort);
            }
            this.f22569a.setOnClickListener(this.f22578j);
            s(this.f22576h);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
            c.a.r0.n0.m.e eVar = this.f22575g;
            c.a.r0.n0.d.c n = eVar != null ? eVar.n() : null;
            if (n != null && n.f22500a) {
                c.a.r0.n0.m.e eVar2 = this.f22575g;
                if (eVar2 != null && eVar2.t()) {
                    SkinManager.setViewTextColor(this.f22569a, R.color.CAM_X0107);
                    this.f22569a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.f22569a, R.color.CAM_X0107);
                this.f22569a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f22569a, R.color.CAM_X0107);
            this.f22569a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && o()) {
            this.f22571c = i2;
            r();
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f22574f = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
            this.f22569a = textView;
        }
    }
}
