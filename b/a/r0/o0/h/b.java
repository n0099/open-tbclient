package b.a.r0.o0.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.a.r0.o0.d.h;
import b.a.r0.o0.m.a;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f23126a;

    /* renamed from: b  reason: collision with root package name */
    public int f23127b;

    /* renamed from: c  reason: collision with root package name */
    public int f23128c;

    /* renamed from: d  reason: collision with root package name */
    public Context f23129d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.o0.m.a f23130e;

    /* renamed from: f  reason: collision with root package name */
    public d f23131f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.o0.m.e f23132g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23133h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f23134i;
    public View.OnClickListener j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes5.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f23135a;

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
            this.f23135a = bVar;
        }

        @Override // b.a.r0.o0.m.a.d
        public void onItemClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f23135a.f23128c = i2;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
                this.f23135a.r();
                if (this.f23135a.f23131f != null) {
                    this.f23135a.f23131f.a(this.f23135a.f23128c);
                }
            }
        }
    }

    /* renamed from: b.a.r0.o0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1127b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23136e;

        public View$OnClickListenerC1127b(b bVar) {
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
            this.f23136e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23136e.f23132g.r()) {
                return;
            }
            if (view == this.f23136e.f23126a) {
                if (this.f23136e.f23130e == null) {
                    this.f23136e.f23130e = new b.a.r0.o0.m.a(this.f23136e.f23129d);
                    this.f23136e.f23130e.setOnDismissListener(this.f23136e.k);
                    this.f23136e.f23130e.l(this.f23136e.f23134i);
                    this.f23136e.f23130e.m(this.f23136e.f23127b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(this.f23136e.f23129d.getString(R.string.level_sort), 1));
                arrayList.add(new h(this.f23136e.f23129d.getString(R.string.update_sort), 2));
                this.f23136e.f23130e.k(arrayList, this.f23136e.f23128c);
                this.f23136e.f23130e.o(this.f23136e.f23126a);
            }
            this.f23136e.f23133h = true;
            b bVar = this.f23136e;
            bVar.s(bVar.f23133h);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23137e;

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
            this.f23137e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23137e.f23133h = false;
                b bVar = this.f23137e;
                bVar.s(bVar.f23133h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(int i2);
    }

    public b(Context context, int i2, int i3, b.a.r0.o0.m.e eVar) {
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
        this.f23133h = false;
        this.f23134i = new a(this);
        this.j = new View$OnClickListenerC1127b(this);
        this.k = new c(this);
        this.f23129d = context;
        this.f23128c = i2;
        this.f23127b = i3;
        this.f23132g = eVar;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f23128c;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        b.a.r0.o0.m.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f23130e) == null) {
            return;
        }
        aVar.i();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (o()) {
                SkinManager.setViewTextColor(this.f23126a, R.color.CAM_X0105, i2);
                if (this.f23126a != null) {
                    s(this.f23133h);
                }
            }
            b.a.r0.o0.m.a aVar = this.f23130e;
            if (aVar == null || !this.f23133h) {
                return;
            }
            aVar.j();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && o() && (textView = this.f23126a) != null) {
            int i2 = this.f23128c;
            if (i2 == 1) {
                textView.setText(R.string.level_sort);
            } else if (i2 == 2) {
                textView.setText(R.string.update_sort);
            }
            this.f23126a.setOnClickListener(this.j);
            s(this.f23133h);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
            b.a.r0.o0.m.e eVar = this.f23132g;
            b.a.r0.o0.d.c n = eVar != null ? eVar.n() : null;
            if (n != null && n.f23060a) {
                b.a.r0.o0.m.e eVar2 = this.f23132g;
                if (eVar2 != null && eVar2.t()) {
                    SkinManager.setViewTextColor(this.f23126a, R.color.CAM_X0107);
                    this.f23126a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.f23126a, R.color.CAM_X0107);
                this.f23126a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f23126a, R.color.CAM_X0107);
            this.f23126a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && o()) {
            this.f23128c = i2;
            r();
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f23131f = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
            this.f23126a = textView;
        }
    }
}
