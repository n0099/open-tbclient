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
import b.a.p0.a.e2.c.j.b;
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
    public static final boolean G0;
    public static String H0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseAdapter C0;
    public final List<b.a.p0.a.e2.c.f> D0;
    public FrameLayout E0;
    public boolean F0;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5230e;

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
            this.f5230e = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f5230e.F0 = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5231e;

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
            this.f5231e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f5231e.F0 = false;
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0206c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.e2.c.f f5232e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5233f;

        public DialogInterface$OnClickListenerC0206c(c cVar, b.a.p0.a.e2.c.f fVar) {
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
            this.f5233f = cVar;
            this.f5232e = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f5233f.K2().S().z(c.H0, true);
                this.f5233f.O2(this.f5232e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.v2.e1.b<Map<String, b.a.p0.a.e2.c.f>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5234e;

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
            this.f5234e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Map<String, b.a.p0.a.e2.c.f> map) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || (activity = this.f5234e.getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            b.a.p0.a.z1.b.d.a.b(this.f5234e.E0);
            if (map == null) {
                return;
            }
            for (Map.Entry<String, b.a.p0.a.e2.c.f> entry : map.entrySet()) {
                b.a.p0.a.e2.c.f value = entry.getValue();
                if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.f4907d && value.b() && "2".equals(value.f4908e) && !"snsapi_base".equals(value.f4905b)) {
                    this.f5234e.D0.add(value);
                }
            }
            this.f5234e.Q2();
            this.f5234e.C0.notifyDataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5235e;

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
            this.f5235e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public b.a.p0.a.e2.c.f getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (b.a.p0.a.e2.c.f) this.f5235e.D0.get(i2) : (b.a.p0.a.e2.c.f) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5235e.D0.size() : invokeV.intValue;
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
                    view = View.inflate(this.f5235e.getContext(), b.a.p0.a.g.aiapps_setting_item, null);
                    g gVar = new g(this.f5235e);
                    gVar.f5239b = (CheckBox) view.findViewById(b.a.p0.a.f.checkbox);
                    gVar.f5238a = (TextView) view.findViewById(b.a.p0.a.f.title);
                    view.setTag(gVar);
                }
                g gVar2 = (g) view.getTag();
                b.a.p0.a.e2.c.f item = getItem(i2);
                String str = TextUtils.isEmpty(item.f4910g) ? item.f4909f : item.f4910g;
                TextView textView = gVar2.f5238a;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                gVar2.f5239b.setChecked(item.a());
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.e2.c.f f5236e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5237f;

        public f(c cVar, b.a.p0.a.e2.c.f fVar) {
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
            this.f5237f = cVar;
            this.f5236e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || (activity = this.f5237f.getActivity()) == null) {
                return;
            }
            b.a.p0.a.z1.b.d.a.b(this.f5237f.E0);
            if (iVar != null && iVar.c()) {
                this.f5237f.P2(this.f5236e, iVar.f4946a.f4961b);
            } else {
                b.a.p0.a.z1.b.f.e.f(activity, b.a.p0.a.h.aiapps_setting_scope_auth_failed).F();
            }
            this.f5237f.F0 = false;
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f5238a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f5239b;

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
        G0 = b.a.p0.a.k.f6397a;
        H0 = "pref_close_scope_alert_showed";
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
        this.D0 = new ArrayList();
        this.F0 = false;
    }

    public static c M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new c() : (c) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void I0(View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, bundle) == null) {
            super.I0(view, bundle);
            L2();
        }
    }

    public final void I2(b.a.p0.a.e2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, fVar, z) == null) {
            b.a.p0.a.a2.e K2 = K2();
            if (K2 == null) {
                this.F0 = false;
                return;
            }
            b.a.p0.a.z1.b.d.a.e(getActivity(), this.E0);
            K2.S().d(getActivity(), fVar.f4905b, false, z, true, new f(this, fVar));
        }
    }

    public final BaseAdapter J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new e(this) : (BaseAdapter) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void K1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            L1(view);
            f2(-1);
            n2(-16777216);
            h2(P(b.a.p0.a.h.common_menu_authority_management));
            j2(true);
            t2(false);
        }
    }

    @Nullable
    public b.a.p0.a.a2.e K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? b.a.p0.a.g1.f.T().D() : (b.a.p0.a.a2.e) invokeV.objValue;
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.p0.a.z1.b.d.a.e(getActivity(), this.E0);
            this.D0.clear();
            this.C0.notifyDataSetChanged();
            b.a.p0.a.n1.q.c.a.h(new d(this));
        }
    }

    public final void N2(b.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(getActivity());
            aVar.U(b.a.p0.a.h.aiapps_setting_scope_close_alert_title);
            aVar.v(b.a.p0.a.h.aiapps_setting_scope_close_alert_msg);
            aVar.n(new b.a.p0.a.w2.h.a());
            aVar.O(b.a.p0.a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface$OnClickListenerC0206c(this, fVar));
            aVar.B(b.a.p0.a.h.aiapps_cancel, new b(this));
            aVar.m(true);
            aVar.K(new a(this));
            aVar.X();
        }
    }

    public final void O2(b.a.p0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            I2(fVar, !fVar.a());
        }
    }

    public final void P2(b.a.p0.a.e2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, fVar, z) == null) {
            fVar.j = z ? 1 : -1;
            this.C0.notifyDataSetChanged();
        }
    }

    public final void Q2() {
        View c0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (c0 = c0()) == null) {
            return;
        }
        boolean isEmpty = this.D0.isEmpty();
        TextView textView = (TextView) c0.findViewById(b.a.p0.a.f.tips);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(R(b.a.p0.a.h.aiapps_setting_tips, K2().N()));
        }
        View findViewById = c0.findViewById(b.a.p0.a.f.id_empty_container);
        if (findViewById != null) {
            findViewById.setVisibility(isEmpty ? 0 : 8);
        }
        TextView textView2 = (TextView) c0.findViewById(b.a.p0.a.f.empty);
        if (isEmpty) {
            textView2.setText(R(b.a.p0.a.h.aiapps_setting_empty, K2().N()));
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            if (G0) {
                String str = "onCreate() obj: " + this;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            b.a.p0.a.a2.e K2 = K2();
            if (K2 != null) {
                K2.S().v();
            }
            if (G0) {
                String str = "onDestroy() obj: " + this;
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.F0) {
            return;
        }
        b.a.p0.a.e2.c.f fVar = this.D0.get(i2);
        this.F0 = true;
        if (fVar.a() && !K2().S().m(H0, false)) {
            N2(fVar);
            return;
        }
        b.a.p0.a.e2.c.d.j("onItemClick : " + fVar, Boolean.FALSE);
        O2(fVar);
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            boolean z = G0;
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            r2(1);
            boolean z = G0;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, activity) == null) {
            super.r0(activity);
            if (G0) {
                String str = "onAttach() obj: " + this;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_setting_fragment, viewGroup, false);
            K1(inflate);
            this.E0 = (FrameLayout) inflate.findViewById(b.a.p0.a.f.container);
            this.C0 = J2();
            ListView listView = (ListView) inflate.findViewById(b.a.p0.a.f.ai_apps_setting_list);
            listView.setAdapter((ListAdapter) this.C0);
            listView.setOnItemClickListener(this);
            if (J1()) {
                inflate = M1(inflate);
            }
            return u1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.k0 = null;
            super.z0();
        }
    }
}
