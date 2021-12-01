package c.a.p0.a.h0.g;

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
import c.a.p0.a.h2.c.j.b;
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
public class c extends c.a.p0.a.h0.g.d implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean N0;
    public static String O0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseAdapter J0;
    public final List<c.a.p0.a.h2.c.f> K0;
    public FrameLayout L0;
    public boolean M0;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5437e;

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
            this.f5437e = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f5437e.M0 = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5438e;

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
            this.f5438e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f5438e.M0 = false;
            }
        }
    }

    /* renamed from: c.a.p0.a.h0.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0269c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h2.c.f f5439e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5440f;

        public DialogInterface$OnClickListenerC0269c(c cVar, c.a.p0.a.h2.c.f fVar) {
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
            this.f5440f = cVar;
            this.f5439e = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f5440f.e3().d0().z(c.O0, true);
                this.f5440f.i3(this.f5439e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.z2.g1.c<Map<String, c.a.p0.a.h2.c.f>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5441e;

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
            this.f5441e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Map<String, c.a.p0.a.h2.c.f> map) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || (activity = this.f5441e.getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            c.a.p0.a.c2.b.d.a.b(this.f5441e.L0);
            if (map == null) {
                return;
            }
            for (Map.Entry<String, c.a.p0.a.h2.c.f> entry : map.entrySet()) {
                c.a.p0.a.h2.c.f value = entry.getValue();
                if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.f6237d && value.b() && "2".equals(value.f6238e) && !"snsapi_base".equals(value.f6235b)) {
                    this.f5441e.K0.add(value);
                }
            }
            this.f5441e.k3();
            this.f5441e.J0.notifyDataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5442e;

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
            this.f5442e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public c.a.p0.a.h2.c.f getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (c.a.p0.a.h2.c.f) this.f5442e.K0.get(i2) : (c.a.p0.a.h2.c.f) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5442e.K0.size() : invokeV.intValue;
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
                    view = View.inflate(this.f5442e.getContext(), c.a.p0.a.g.aiapps_setting_item, null);
                    g gVar = new g(this.f5442e);
                    gVar.f5445b = (CheckBox) view.findViewById(c.a.p0.a.f.checkbox);
                    gVar.a = (TextView) view.findViewById(c.a.p0.a.f.title);
                    view.setTag(gVar);
                }
                g gVar2 = (g) view.getTag();
                c.a.p0.a.h2.c.f item = getItem(i2);
                String str = TextUtils.isEmpty(item.f6240g) ? item.f6239f : item.f6240g;
                TextView textView = gVar2.a;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                gVar2.f5445b.setChecked(item.a());
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h2.c.f f5443e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5444f;

        public f(c cVar, c.a.p0.a.h2.c.f fVar) {
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
            this.f5444f = cVar;
            this.f5443e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || (activity = this.f5444f.getActivity()) == null) {
                return;
            }
            c.a.p0.a.c2.b.d.a.b(this.f5444f.L0);
            if (iVar != null && iVar.c()) {
                this.f5444f.j3(this.f5443e, iVar.a.f6288b);
            } else {
                c.a.p0.a.c2.b.f.e.f(activity, c.a.p0.a.h.aiapps_setting_scope_auth_failed).G();
            }
            this.f5444f.M0 = false;
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f5445b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f5446c;

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
                    return;
                }
            }
            this.f5446c = cVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1086868720, "Lc/a/p0/a/h0/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1086868720, "Lc/a/p0/a/h0/g/c;");
                return;
            }
        }
        N0 = c.a.p0.a.k.a;
        O0 = "pref_close_scope_alert_showed";
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
        this.K0 = new ArrayList();
        this.M0 = false;
    }

    public static c g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new c() : (c) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View D0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.p0.a.g.aiapps_setting_fragment, viewGroup, false);
            V1(inflate);
            this.L0 = (FrameLayout) inflate.findViewById(c.a.p0.a.f.container);
            this.J0 = d3();
            ListView listView = (ListView) inflate.findViewById(c.a.p0.a.f.ai_apps_setting_list);
            listView.setAdapter((ListAdapter) this.J0);
            listView.setOnItemClickListener(this);
            if (U1()) {
                inflate = X1(inflate);
            }
            return E1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g0 = null;
            super.G0();
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void P0(View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, bundle) == null) {
            super.P0(view, bundle);
            f3();
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public void V1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            W1(view);
            u2(-1);
            D2(-16777216);
            w2(X(c.a.p0.a.h.common_menu_authority_management));
            y2(true);
            K2(false);
        }
    }

    public final void c3(c.a.p0.a.h2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, fVar, z) == null) {
            c.a.p0.a.d2.e e3 = e3();
            if (e3 == null) {
                this.M0 = false;
                return;
            }
            c.a.p0.a.c2.b.d.a.g(getActivity(), this.L0);
            e3.d0().d(getActivity(), fVar.f6235b, false, z, true, new f(this, fVar));
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final BaseAdapter d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new e(this) : (BaseAdapter) invokeV.objValue;
    }

    @Nullable
    public c.a.p0.a.d2.e e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c.a.p0.a.g1.f.U().D() : (c.a.p0.a.d2.e) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.p0.a.c2.b.d.a.g(getActivity(), this.L0);
            this.K0.clear();
            this.J0.notifyDataSetChanged();
            c.a.p0.a.p1.r.c.a.h(new d(this));
        }
    }

    public final void h3(c.a.p0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(getActivity());
            aVar.U(c.a.p0.a.h.aiapps_setting_scope_close_alert_title);
            aVar.v(c.a.p0.a.h.aiapps_setting_scope_close_alert_msg);
            aVar.n(new c.a.p0.a.a3.h.a());
            aVar.O(c.a.p0.a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface$OnClickListenerC0269c(this, fVar));
            aVar.B(c.a.p0.a.h.aiapps_cancel, new b(this));
            aVar.m(true);
            aVar.K(new a(this));
            aVar.X();
        }
    }

    public final void i3(c.a.p0.a.h2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            c3(fVar, !fVar.a());
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j3(c.a.p0.a.h2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, fVar, z) == null) {
            fVar.f6243j = z ? 1 : -1;
            this.J0.notifyDataSetChanged();
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public final void k3() {
        View m0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (m0 = m0()) == null) {
            return;
        }
        boolean isEmpty = this.K0.isEmpty();
        TextView textView = (TextView) m0.findViewById(c.a.p0.a.f.tips);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(c0(c.a.p0.a.h.aiapps_setting_tips, e3().Y()));
        }
        View findViewById = m0.findViewById(c.a.p0.a.f.id_empty_container);
        if (findViewById != null) {
            findViewById.setVisibility(isEmpty ? 0 : 8);
        }
        TextView textView2 = (TextView) m0.findViewById(c.a.p0.a.f.empty);
        if (isEmpty) {
            textView2.setText(c0(c.a.p0.a.h.aiapps_setting_empty, e3().Y()));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            if (N0) {
                String str = "onCreate() obj: " + this;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroy();
            c.a.p0.a.d2.e e3 = e3();
            if (e3 != null) {
                e3.d0().v();
            }
            if (N0) {
                String str = "onDestroy() obj: " + this;
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.M0) {
            return;
        }
        c.a.p0.a.h2.c.f fVar = this.K0.get(i2);
        this.M0 = true;
        if (fVar.a() && !e3().d0().m(O0, false)) {
            h3(fVar);
            return;
        }
        c.a.p0.a.h2.c.d.k("onItemClick : " + fVar, Boolean.FALSE);
        i3(fVar);
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPause();
            boolean z = N0;
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onResume();
            I2(1);
            boolean z = N0;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, activity) == null) {
            super.y0(activity);
            if (N0) {
                String str = "onAttach() obj: " + this;
            }
        }
    }
}
