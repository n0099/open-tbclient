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
    public TextView f22553a;

    /* renamed from: b  reason: collision with root package name */
    public int f22554b;

    /* renamed from: c  reason: collision with root package name */
    public int f22555c;

    /* renamed from: d  reason: collision with root package name */
    public Context f22556d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.n0.m.a f22557e;

    /* renamed from: f  reason: collision with root package name */
    public d f22558f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.n0.m.e f22559g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22560h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f22561i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f22562j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes3.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f22563a;

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
            this.f22563a = bVar;
        }

        @Override // c.a.r0.n0.m.a.d
        public void onItemClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f22563a.f22555c = i2;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
                this.f22563a.r();
                if (this.f22563a.f22558f != null) {
                    this.f22563a.f22558f.a(this.f22563a.f22555c);
                }
            }
        }
    }

    /* renamed from: c.a.r0.n0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1054b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22564e;

        public View$OnClickListenerC1054b(b bVar) {
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
            this.f22564e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22564e.f22559g.r()) {
                return;
            }
            if (view == this.f22564e.f22553a) {
                if (this.f22564e.f22557e == null) {
                    this.f22564e.f22557e = new c.a.r0.n0.m.a(this.f22564e.f22556d);
                    this.f22564e.f22557e.setOnDismissListener(this.f22564e.k);
                    this.f22564e.f22557e.l(this.f22564e.f22561i);
                    this.f22564e.f22557e.m(this.f22564e.f22554b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(this.f22564e.f22556d.getString(R.string.level_sort), 1));
                arrayList.add(new h(this.f22564e.f22556d.getString(R.string.update_sort), 2));
                this.f22564e.f22557e.k(arrayList, this.f22564e.f22555c);
                this.f22564e.f22557e.o(this.f22564e.f22553a);
            }
            this.f22564e.f22560h = true;
            b bVar = this.f22564e;
            bVar.s(bVar.f22560h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22565e;

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
            this.f22565e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22565e.f22560h = false;
                b bVar = this.f22565e;
                bVar.s(bVar.f22560h);
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
        this.f22560h = false;
        this.f22561i = new a(this);
        this.f22562j = new View$OnClickListenerC1054b(this);
        this.k = new c(this);
        this.f22556d = context;
        this.f22555c = i2;
        this.f22554b = i3;
        this.f22559g = eVar;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f22555c;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        c.a.r0.n0.m.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f22557e) == null) {
            return;
        }
        aVar.i();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (o()) {
                SkinManager.setViewTextColor(this.f22553a, R.color.CAM_X0105, i2);
                if (this.f22553a != null) {
                    s(this.f22560h);
                }
            }
            c.a.r0.n0.m.a aVar = this.f22557e;
            if (aVar == null || !this.f22560h) {
                return;
            }
            aVar.j();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && o() && (textView = this.f22553a) != null) {
            int i2 = this.f22555c;
            if (i2 == 1) {
                textView.setText(R.string.level_sort);
            } else if (i2 == 2) {
                textView.setText(R.string.update_sort);
            }
            this.f22553a.setOnClickListener(this.f22562j);
            s(this.f22560h);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
            c.a.r0.n0.m.e eVar = this.f22559g;
            c.a.r0.n0.d.c n = eVar != null ? eVar.n() : null;
            if (n != null && n.f22484a) {
                c.a.r0.n0.m.e eVar2 = this.f22559g;
                if (eVar2 != null && eVar2.t()) {
                    SkinManager.setViewTextColor(this.f22553a, R.color.CAM_X0107);
                    this.f22553a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.f22553a, R.color.CAM_X0107);
                this.f22553a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f22553a, R.color.CAM_X0107);
            this.f22553a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && o()) {
            this.f22555c = i2;
            r();
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f22558f = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
            this.f22553a = textView;
        }
    }
}
