package c.a.r0.u0.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.r0.u0.d.h;
import c.a.r0.u0.m.a;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public int f24154b;

    /* renamed from: c  reason: collision with root package name */
    public int f24155c;

    /* renamed from: d  reason: collision with root package name */
    public Context f24156d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.u0.m.a f24157e;

    /* renamed from: f  reason: collision with root package name */
    public d f24158f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.u0.m.e f24159g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24160h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f24161i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f24162j;

    /* renamed from: k  reason: collision with root package name */
    public PopupWindow.OnDismissListener f24163k;

    /* loaded from: classes6.dex */
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

        @Override // c.a.r0.u0.m.a.d
        public void onItemClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.f24155c = i2;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
                this.a.r();
                if (this.a.f24158f != null) {
                    this.a.f24158f.a(this.a.f24155c);
                }
            }
        }
    }

    /* renamed from: c.a.r0.u0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1379b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24164e;

        public View$OnClickListenerC1379b(b bVar) {
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
            this.f24164e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24164e.f24159g.r()) {
                return;
            }
            if (view == this.f24164e.a) {
                if (this.f24164e.f24157e == null) {
                    this.f24164e.f24157e = new c.a.r0.u0.m.a(this.f24164e.f24156d);
                    this.f24164e.f24157e.setOnDismissListener(this.f24164e.f24163k);
                    this.f24164e.f24157e.l(this.f24164e.f24161i);
                    this.f24164e.f24157e.m(this.f24164e.f24154b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(this.f24164e.f24156d.getString(R.string.level_sort), 1));
                arrayList.add(new h(this.f24164e.f24156d.getString(R.string.update_sort), 2));
                this.f24164e.f24157e.k(arrayList, this.f24164e.f24155c);
                this.f24164e.f24157e.o(this.f24164e.a);
            }
            this.f24164e.f24160h = true;
            b bVar = this.f24164e;
            bVar.s(bVar.f24160h);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24165e;

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
            this.f24165e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24165e.f24160h = false;
                b bVar = this.f24165e;
                bVar.s(bVar.f24160h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(int i2);
    }

    public b(Context context, int i2, int i3, c.a.r0.u0.m.e eVar) {
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
        this.f24160h = false;
        this.f24161i = new a(this);
        this.f24162j = new View$OnClickListenerC1379b(this);
        this.f24163k = new c(this);
        this.f24156d = context;
        this.f24155c = i2;
        this.f24154b = i3;
        this.f24159g = eVar;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f24155c;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        c.a.r0.u0.m.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f24157e) == null) {
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
                    s(this.f24160h);
                }
            }
            c.a.r0.u0.m.a aVar = this.f24157e;
            if (aVar == null || !this.f24160h) {
                return;
            }
            aVar.j();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && o() && (textView = this.a) != null) {
            int i2 = this.f24155c;
            if (i2 == 1) {
                textView.setText(R.string.level_sort);
            } else if (i2 == 2) {
                textView.setText(R.string.update_sort);
            }
            this.a.setOnClickListener(this.f24162j);
            s(this.f24160h);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
            c.a.r0.u0.m.e eVar = this.f24159g;
            c.a.r0.u0.d.c n = eVar != null ? eVar.n() : null;
            if (n != null && n.a) {
                c.a.r0.u0.m.e eVar2 = this.f24159g;
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
            this.f24155c = i2;
            r();
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f24158f = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
            this.a = textView;
        }
    }
}
