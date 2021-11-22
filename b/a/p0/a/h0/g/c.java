package b.a.p0.a.h0.g;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends b.a.p0.a.h0.g.d implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean M0;
    public static String N0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseAdapter I0;
    public final List<b.a.p0.a.h2.c.f> J0;
    public FrameLayout K0;
    public boolean L0;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5412e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5412e = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f5412e.L0 = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5413e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5413e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f5413e.L0 = false;
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0213c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h2.c.f f5414e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5415f;

        public DialogInterface$OnClickListenerC0213c(c cVar, b.a.p0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5415f = cVar;
            this.f5414e = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f5415f.a3().d0().z(c.N0, true);
                this.f5415f.e3(this.f5414e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.z2.g1.c<Map<String, b.a.p0.a.h2.c.f>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5416e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5416e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Map<String, b.a.p0.a.h2.c.f> map) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || (activity = this.f5416e.getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            b.a.p0.a.c2.b.d.a.b(this.f5416e.K0);
            if (map == null) {
                return;
            }
            for (Map.Entry<String, b.a.p0.a.h2.c.f> entry : map.entrySet()) {
                b.a.p0.a.h2.c.f value = entry.getValue();
                if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.f6385d && value.b() && "2".equals(value.f6386e) && !"snsapi_base".equals(value.f6383b)) {
                    this.f5416e.J0.add(value);
                }
            }
            this.f5416e.g3();
            this.f5416e.I0.notifyDataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5417e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5417e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public b.a.p0.a.h2.c.f getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (b.a.p0.a.h2.c.f) this.f5417e.J0.get(i2) : (b.a.p0.a.h2.c.f) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5417e.J0.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? getItem(i2).hashCode() : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null || !(view.getTag() instanceof g)) {
                    view = View.inflate(this.f5417e.getContext(), b.a.p0.a.g.aiapps_setting_item, null);
                    g gVar = new g(this.f5417e);
                    gVar.f5421b = (CheckBox) view.findViewById(b.a.p0.a.f.checkbox);
                    gVar.f5420a = (TextView) view.findViewById(b.a.p0.a.f.title);
                    view.setTag(gVar);
                }
                g gVar2 = (g) view.getTag();
                b.a.p0.a.h2.c.f item = getItem(i2);
                String str = TextUtils.isEmpty(item.f6388g) ? item.f6387f : item.f6388g;
                TextView textView = gVar2.f5420a;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                gVar2.f5421b.setChecked(item.a());
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h2.c.f f5418e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5419f;

        public f(c cVar, b.a.p0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5419f = cVar;
            this.f5418e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || (activity = this.f5419f.getActivity()) == null) {
                return;
            }
            b.a.p0.a.c2.b.d.a.b(this.f5419f.K0);
            if (iVar != null && iVar.c()) {
                this.f5419f.f3(this.f5418e, iVar.f6424a.f6439b);
            } else {
                b.a.p0.a.c2.b.f.e.f(activity, b.a.p0.a.h.aiapps_setting_scope_auth_failed).G();
            }
            this.f5419f.L0 = false;
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f5420a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f5421b;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597402897, "Lb/a/p0/a/h0/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597402897, "Lb/a/p0/a/h0/g/c;");
                return;
            }
        }
        M0 = b.a.p0.a.k.f6863a;
        N0 = "pref_close_scope_alert_showed";
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.J0 = new ArrayList();
        this.L0 = false;
    }

    public static c c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new c() : (c) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l0 = null;
            super.C0();
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void L0(View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, bundle) == null) {
            super.L0(view, bundle);
            b3();
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void R1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            S1(view);
            q2(-1);
            z2(-16777216);
            s2(P(b.a.p0.a.h.common_menu_authority_management));
            u2(true);
            G2(false);
        }
    }

    public final void Y2(b.a.p0.a.h2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, fVar, z) == null) {
            b.a.p0.a.d2.e a3 = a3();
            if (a3 == null) {
                this.L0 = false;
                return;
            }
            b.a.p0.a.c2.b.d.a.g(getActivity(), this.K0);
            a3.d0().d(getActivity(), fVar.f6383b, false, z, true, new f(this, fVar));
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final BaseAdapter Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new e(this) : (BaseAdapter) invokeV.objValue;
    }

    @Nullable
    public b.a.p0.a.d2.e a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? b.a.p0.a.g1.f.U().D() : (b.a.p0.a.d2.e) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b.a.p0.a.c2.b.d.a.g(getActivity(), this.K0);
            this.J0.clear();
            this.I0.notifyDataSetChanged();
            b.a.p0.a.p1.r.c.a.h(new d(this));
        }
    }

    public final void d3(b.a.p0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(getActivity());
            aVar.U(b.a.p0.a.h.aiapps_setting_scope_close_alert_title);
            aVar.v(b.a.p0.a.h.aiapps_setting_scope_close_alert_msg);
            aVar.n(new b.a.p0.a.a3.h.a());
            aVar.O(b.a.p0.a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface$OnClickListenerC0213c(this, fVar));
            aVar.B(b.a.p0.a.h.aiapps_cancel, new b(this));
            aVar.m(true);
            aVar.K(new a(this));
            aVar.X();
        }
    }

    public final void e3(b.a.p0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            Y2(fVar, !fVar.a());
        }
    }

    public final void f3(b.a.p0.a.h2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, fVar, z) == null) {
            fVar.j = z ? 1 : -1;
            this.I0.notifyDataSetChanged();
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public final void g3() {
        View d0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (d0 = d0()) == null) {
            return;
        }
        boolean isEmpty = this.J0.isEmpty();
        TextView textView = (TextView) d0.findViewById(b.a.p0.a.f.tips);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(R(b.a.p0.a.h.aiapps_setting_tips, a3().Y()));
        }
        View findViewById = d0.findViewById(b.a.p0.a.f.id_empty_container);
        if (findViewById != null) {
            findViewById.setVisibility(isEmpty ? 0 : 8);
        }
        TextView textView2 = (TextView) d0.findViewById(b.a.p0.a.f.empty);
        if (isEmpty) {
            textView2.setText(R(b.a.p0.a.h.aiapps_setting_empty, a3().Y()));
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            if (M0) {
                String str = "onCreate() obj: " + this;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            b.a.p0.a.d2.e a3 = a3();
            if (a3 != null) {
                a3.d0().v();
            }
            if (M0) {
                String str = "onDestroy() obj: " + this;
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.L0) {
            return;
        }
        b.a.p0.a.h2.c.f fVar = this.J0.get(i2);
        this.L0 = true;
        if (fVar.a() && !a3().d0().m(N0, false)) {
            d3(fVar);
            return;
        }
        b.a.p0.a.h2.c.d.k("onItemClick : " + fVar, Boolean.FALSE);
        e3(fVar);
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            boolean z = M0;
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            E2(1);
            boolean z = M0;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            super.u0(activity);
            if (M0) {
                String str = "onAttach() obj: " + this;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_setting_fragment, viewGroup, false);
            R1(inflate);
            this.K0 = (FrameLayout) inflate.findViewById(b.a.p0.a.f.container);
            this.I0 = Z2();
            ListView listView = (ListView) inflate.findViewById(b.a.p0.a.f.ai_apps_setting_list);
            listView.setAdapter((ListAdapter) this.I0);
            listView.setOnItemClickListener(this);
            if (Q1()) {
                inflate = T1(inflate);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
