package c.a.t0.v0.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.t0.v0.d.h;
import c.a.t0.v0.m.a;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public int f24292b;

    /* renamed from: c  reason: collision with root package name */
    public int f24293c;

    /* renamed from: d  reason: collision with root package name */
    public Context f24294d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.v0.m.a f24295e;

    /* renamed from: f  reason: collision with root package name */
    public d f24296f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.v0.m.e f24297g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24298h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f24299i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f24300j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes8.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.t0.v0.m.a.d
        public void onItemClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.f24293c = i2;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
                this.a.r();
                if (this.a.f24296f != null) {
                    this.a.f24296f.a(this.a.f24293c);
                }
            }
        }
    }

    /* renamed from: c.a.t0.v0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1477b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24301e;

        public View$OnClickListenerC1477b(b bVar) {
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
            this.f24301e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24301e.f24297g.r()) {
                return;
            }
            if (view == this.f24301e.a) {
                if (this.f24301e.f24295e == null) {
                    this.f24301e.f24295e = new c.a.t0.v0.m.a(this.f24301e.f24294d);
                    this.f24301e.f24295e.setOnDismissListener(this.f24301e.k);
                    this.f24301e.f24295e.l(this.f24301e.f24299i);
                    this.f24301e.f24295e.m(this.f24301e.f24292b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(this.f24301e.f24294d.getString(R.string.level_sort), 1));
                arrayList.add(new h(this.f24301e.f24294d.getString(R.string.update_sort), 2));
                this.f24301e.f24295e.k(arrayList, this.f24301e.f24293c);
                this.f24301e.f24295e.o(this.f24301e.a);
            }
            this.f24301e.f24298h = true;
            b bVar = this.f24301e;
            bVar.s(bVar.f24298h);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24302e;

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
            this.f24302e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24302e.f24298h = false;
                b bVar = this.f24302e;
                bVar.s(bVar.f24298h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(int i2);
    }

    public b(Context context, int i2, int i3, c.a.t0.v0.m.e eVar) {
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
        this.f24298h = false;
        this.f24299i = new a(this);
        this.f24300j = new View$OnClickListenerC1477b(this);
        this.k = new c(this);
        this.f24294d = context;
        this.f24293c = i2;
        this.f24292b = i3;
        this.f24297g = eVar;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f24293c;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        c.a.t0.v0.m.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f24295e) == null) {
            return;
        }
        aVar.i();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (o()) {
                SkinManager.setViewTextColor(this.a, R.color.CAM_X0105, i2);
                if (this.a != null) {
                    s(this.f24298h);
                }
            }
            c.a.t0.v0.m.a aVar = this.f24295e;
            if (aVar == null || !this.f24298h) {
                return;
            }
            aVar.j();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && o() && (textView = this.a) != null) {
            int i2 = this.f24293c;
            if (i2 == 1) {
                textView.setText(R.string.level_sort);
            } else if (i2 == 2) {
                textView.setText(R.string.update_sort);
            }
            this.a.setOnClickListener(this.f24300j);
            s(this.f24298h);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
            c.a.t0.v0.m.e eVar = this.f24297g;
            c.a.t0.v0.d.c n = eVar != null ? eVar.n() : null;
            if (n != null && n.a) {
                c.a.t0.v0.m.e eVar2 = this.f24297g;
                if (eVar2 != null && eVar2.t()) {
                    SkinManager.setViewTextColor(this.a, R.color.CAM_X0107);
                    this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.a, R.color.CAM_X0107);
                this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.a, R.color.CAM_X0107);
            this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && o()) {
            this.f24293c = i2;
            r();
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f24296f = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
            this.a = textView;
        }
    }
}
