package c.a.p0.w0.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.w0.e.k;
import c.a.p0.w0.o.a;
import c.a.p0.w0.o.h;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public int f19404b;

    /* renamed from: c  reason: collision with root package name */
    public int f19405c;

    /* renamed from: d  reason: collision with root package name */
    public Context f19406d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.w0.o.a f19407e;

    /* renamed from: f  reason: collision with root package name */
    public d f19408f;

    /* renamed from: g  reason: collision with root package name */
    public h f19409g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19410h;
    public a.d i;
    public View.OnClickListener j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.w0.o.a.d
        public void onItemClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.f19405c = i;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i == 1 ? 2 : 1));
                this.a.s();
                if (this.a.f19408f != null) {
                    this.a.f19408f.a(this.a.f19405c);
                }
            }
        }
    }

    /* renamed from: c.a.p0.w0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1466b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC1466b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f19409g.r()) {
                return;
            }
            if (view == this.a.a) {
                if (this.a.f19407e == null) {
                    this.a.f19407e = new c.a.p0.w0.o.a(this.a.f19406d);
                    this.a.f19407e.setOnDismissListener(this.a.k);
                    this.a.f19407e.l(this.a.i);
                    this.a.f19407e.m(this.a.f19404b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new k(this.a.f19406d.getString(R.string.obfuscated_res_0x7f0f09d5), 2));
                arrayList.add(new k(this.a.f19406d.getString(R.string.obfuscated_res_0x7f0f148a), 1));
                this.a.f19407e.k(arrayList, this.a.f19405c);
                this.a.f19407e.o(this.a.a);
            }
            this.a.f19410h = true;
            b bVar = this.a;
            bVar.t(bVar.f19410h);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f19410h = false;
                b bVar = this.a;
                bVar.t(bVar.f19410h);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(int i);
    }

    public b(Context context, int i, int i2, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19410h = false;
        this.i = new a(this);
        this.j = new View$OnClickListenerC1466b(this);
        this.k = new c(this);
        this.f19406d = context;
        this.f19405c = i;
        this.f19404b = i2;
        this.f19409g = hVar;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.f19405c;
            return i == 2 || i == 1;
        }
        return invokeV.booleanValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19405c : invokeV.intValue;
    }

    public void q() {
        c.a.p0.w0.o.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f19407e) == null) {
            return;
        }
        aVar.i();
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (o()) {
                SkinManager.setViewTextColor(this.a, R.color.CAM_X0105, i);
                if (this.a != null) {
                    t(this.f19410h);
                }
            }
            c.a.p0.w0.o.a aVar = this.f19407e;
            if (aVar == null || !this.f19410h) {
                return;
            }
            aVar.j();
        }
    }

    public void s() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && o() && (textView = this.a) != null) {
            int i = this.f19405c;
            if (i == 1) {
                textView.setText(R.string.obfuscated_res_0x7f0f148a);
            } else if (i == 2) {
                textView.setText(R.string.obfuscated_res_0x7f0f09d5);
            }
            this.a.setOnClickListener(this.j);
            t(this.f19410h);
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            int i = z ? R.drawable.obfuscated_res_0x7f0808ff : R.drawable.icon_pure_unfold12_svg;
            h hVar = this.f19409g;
            c.a.p0.w0.e.e n = hVar != null ? hVar.n() : null;
            if (n != null && n.a) {
                h hVar2 = this.f19409g;
                if (hVar2 != null && hVar2.t()) {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                    this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
            this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && o()) {
            this.f19405c = i;
            s();
        }
    }

    public void v(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f19408f = dVar;
        }
    }

    public void w(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView) == null) {
            this.a = textView;
        }
    }
}
