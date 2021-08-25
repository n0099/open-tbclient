package c.a.q0.m0.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.q0.m0.d.h;
import c.a.q0.m0.m.a;
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
    public TextView f21985a;

    /* renamed from: b  reason: collision with root package name */
    public int f21986b;

    /* renamed from: c  reason: collision with root package name */
    public int f21987c;

    /* renamed from: d  reason: collision with root package name */
    public Context f21988d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.m0.m.a f21989e;

    /* renamed from: f  reason: collision with root package name */
    public d f21990f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.m0.m.e f21991g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21992h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f21993i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f21994j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21995a;

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
            this.f21995a = bVar;
        }

        @Override // c.a.q0.m0.m.a.d
        public void onItemClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f21995a.f21987c = i2;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
                this.f21995a.r();
                if (this.f21995a.f21990f != null) {
                    this.f21995a.f21990f.a(this.f21995a.f21987c);
                }
            }
        }
    }

    /* renamed from: c.a.q0.m0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1021b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21996e;

        public View$OnClickListenerC1021b(b bVar) {
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
            this.f21996e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21996e.f21991g.r()) {
                return;
            }
            if (view == this.f21996e.f21985a) {
                if (this.f21996e.f21989e == null) {
                    this.f21996e.f21989e = new c.a.q0.m0.m.a(this.f21996e.f21988d);
                    this.f21996e.f21989e.setOnDismissListener(this.f21996e.k);
                    this.f21996e.f21989e.l(this.f21996e.f21993i);
                    this.f21996e.f21989e.m(this.f21996e.f21986b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(this.f21996e.f21988d.getString(R.string.level_sort), 1));
                arrayList.add(new h(this.f21996e.f21988d.getString(R.string.update_sort), 2));
                this.f21996e.f21989e.k(arrayList, this.f21996e.f21987c);
                this.f21996e.f21989e.o(this.f21996e.f21985a);
            }
            this.f21996e.f21992h = true;
            b bVar = this.f21996e;
            bVar.s(bVar.f21992h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21997e;

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
            this.f21997e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21997e.f21992h = false;
                b bVar = this.f21997e;
                bVar.s(bVar.f21992h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i2);
    }

    public b(Context context, int i2, int i3, c.a.q0.m0.m.e eVar) {
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
        this.f21992h = false;
        this.f21993i = new a(this);
        this.f21994j = new View$OnClickListenerC1021b(this);
        this.k = new c(this);
        this.f21988d = context;
        this.f21987c = i2;
        this.f21986b = i3;
        this.f21991g = eVar;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f21987c;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        c.a.q0.m0.m.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f21989e) == null) {
            return;
        }
        aVar.i();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (o()) {
                SkinManager.setViewTextColor(this.f21985a, R.color.CAM_X0105, i2);
                if (this.f21985a != null) {
                    s(this.f21992h);
                }
            }
            c.a.q0.m0.m.a aVar = this.f21989e;
            if (aVar == null || !this.f21992h) {
                return;
            }
            aVar.j();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && o() && (textView = this.f21985a) != null) {
            int i2 = this.f21987c;
            if (i2 == 1) {
                textView.setText(R.string.level_sort);
            } else if (i2 == 2) {
                textView.setText(R.string.update_sort);
            }
            this.f21985a.setOnClickListener(this.f21994j);
            s(this.f21992h);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
            c.a.q0.m0.m.e eVar = this.f21991g;
            c.a.q0.m0.d.c n = eVar != null ? eVar.n() : null;
            if (n != null && n.f21916a) {
                c.a.q0.m0.m.e eVar2 = this.f21991g;
                if (eVar2 != null && eVar2.t()) {
                    SkinManager.setViewTextColor(this.f21985a, R.color.CAM_X0107);
                    this.f21985a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.f21985a, R.color.CAM_X0107);
                this.f21985a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f21985a, R.color.CAM_X0107);
            this.f21985a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && o()) {
            this.f21987c = i2;
            r();
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f21990f = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
            this.f21985a = textView;
        }
    }
}
