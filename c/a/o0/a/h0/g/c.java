package c.a.o0.a.h0.g;

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
import c.a.o0.a.e2.c.j.b;
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
public class c extends c.a.o0.a.h0.g.d implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean G0;
    public static String H0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseAdapter C0;
    public final List<c.a.o0.a.e2.c.f> D0;
    public FrameLayout E0;
    public boolean F0;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5846e;

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
            this.f5846e = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f5846e.F0 = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5847e;

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
            this.f5847e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f5847e.F0 = false;
            }
        }
    }

    /* renamed from: c.a.o0.a.h0.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0209c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.e2.c.f f5848e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5849f;

        public DialogInterface$OnClickListenerC0209c(c cVar, c.a.o0.a.e2.c.f fVar) {
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
            this.f5849f = cVar;
            this.f5848e = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f5849f.O2().T().z(c.H0, true);
                this.f5849f.S2(this.f5848e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.o0.a.v2.e1.b<Map<String, c.a.o0.a.e2.c.f>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5850e;

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
            this.f5850e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Map<String, c.a.o0.a.e2.c.f> map) {
            FragmentActivity h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || (h2 = this.f5850e.h()) == null || h2.isFinishing() || h2.isDestroyed()) {
                return;
            }
            c.a.o0.a.z1.b.d.a.b(this.f5850e.E0);
            if (map == null) {
                return;
            }
            for (Map.Entry<String, c.a.o0.a.e2.c.f> entry : map.entrySet()) {
                c.a.o0.a.e2.c.f value = entry.getValue();
                if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.f5513d && value.b() && "2".equals(value.f5514e) && !"snsapi_base".equals(value.f5511b)) {
                    this.f5850e.D0.add(value);
                }
            }
            this.f5850e.U2();
            this.f5850e.C0.notifyDataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5851e;

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
            this.f5851e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public c.a.o0.a.e2.c.f getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (c.a.o0.a.e2.c.f) this.f5851e.D0.get(i2) : (c.a.o0.a.e2.c.f) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5851e.D0.size() : invokeV.intValue;
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
                    view = View.inflate(this.f5851e.q(), c.a.o0.a.g.aiapps_setting_item, null);
                    g gVar = new g(this.f5851e);
                    gVar.f5855b = (CheckBox) view.findViewById(c.a.o0.a.f.checkbox);
                    gVar.f5854a = (TextView) view.findViewById(c.a.o0.a.f.title);
                    view.setTag(gVar);
                }
                g gVar2 = (g) view.getTag();
                c.a.o0.a.e2.c.f item = getItem(i2);
                String str = TextUtils.isEmpty(item.f5516g) ? item.f5515f : item.f5516g;
                TextView textView = gVar2.f5854a;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                gVar2.f5855b.setChecked(item.a());
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.o0.a.v2.e1.b<c.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.e2.c.f f5852e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5853f;

        public f(c cVar, c.a.o0.a.e2.c.f fVar) {
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
            this.f5853f = cVar;
            this.f5852e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.o0.a.e2.c.i<b.e> iVar) {
            FragmentActivity h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) || (h2 = this.f5853f.h()) == null) {
                return;
            }
            c.a.o0.a.z1.b.d.a.b(this.f5853f.E0);
            if (iVar != null && iVar.c()) {
                this.f5853f.T2(this.f5852e, iVar.f5554a.f5569b);
            } else {
                c.a.o0.a.z1.b.f.e.f(h2, c.a.o0.a.h.aiapps_setting_scope_auth_failed).F();
            }
            this.f5853f.F0 = false;
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f5854a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f5855b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f5856c;

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
            this.f5856c = cVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957786001, "Lc/a/o0/a/h0/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957786001, "Lc/a/o0/a/h0/g/c;");
                return;
            }
        }
        G0 = c.a.o0.a.k.f7049a;
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

    public static c Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new c() : (c) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k0 = null;
            super.C0();
        }
    }

    @Override // c.a.o0.a.h0.g.d
    public boolean J() {
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
            P2();
        }
    }

    public final void M2(c.a.o0.a.e2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, fVar, z) == null) {
            c.a.o0.a.a2.e O2 = O2();
            if (O2 == null) {
                this.F0 = false;
                return;
            }
            c.a.o0.a.z1.b.d.a.e(h(), this.E0);
            O2.T().d(h(), fVar.f5511b, false, z, true, new f(this, fVar));
        }
    }

    public final BaseAdapter N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new e(this) : (BaseAdapter) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            P1(view);
            j2(-1);
            r2(-16777216);
            l2(U(c.a.o0.a.h.common_menu_authority_management));
            n2(true);
            x2(false);
        }
    }

    @Nullable
    public c.a.o0.a.a2.e O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c.a.o0.a.g1.f.V().F() : (c.a.o0.a.a2.e) invokeV.objValue;
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.a.z1.b.d.a.e(h(), this.E0);
            this.D0.clear();
            this.C0.notifyDataSetChanged();
            c.a.o0.a.n1.q.c.a.h(new d(this));
        }
    }

    public final void R2(c.a.o0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(h());
            aVar.U(c.a.o0.a.h.aiapps_setting_scope_close_alert_title);
            aVar.v(c.a.o0.a.h.aiapps_setting_scope_close_alert_msg);
            aVar.n(new c.a.o0.a.w2.h.a());
            aVar.O(c.a.o0.a.h.aiapps_setting_scope_close_alert_btn_pos, new DialogInterface$OnClickListenerC0209c(this, fVar));
            aVar.B(c.a.o0.a.h.aiapps_cancel, new b(this));
            aVar.m(true);
            aVar.K(new a(this));
            aVar.X();
        }
    }

    public final void S2(c.a.o0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            M2(fVar, !fVar.a());
        }
    }

    public final void T2(c.a.o0.a.e2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, fVar, z) == null) {
            fVar.f5519j = z ? 1 : -1;
            this.C0.notifyDataSetChanged();
        }
    }

    public final void U2() {
        View f0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (f0 = f0()) == null) {
            return;
        }
        boolean isEmpty = this.D0.isEmpty();
        TextView textView = (TextView) f0.findViewById(c.a.o0.a.f.tips);
        textView.setVisibility(isEmpty ? 8 : 0);
        if (!isEmpty) {
            textView.setText(V(c.a.o0.a.h.aiapps_setting_tips, O2().O()));
        }
        View findViewById = f0.findViewById(c.a.o0.a.f.id_empty_container);
        if (findViewById != null) {
            findViewById.setVisibility(isEmpty ? 0 : 8);
        }
        TextView textView2 = (TextView) f0.findViewById(c.a.o0.a.f.empty);
        if (isEmpty) {
            textView2.setText(V(c.a.o0.a.h.aiapps_setting_empty, O2().O()));
        }
    }

    @Override // c.a.o0.a.h0.g.d
    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.a.h0.g.d
    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // c.a.o0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
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
            if (G0) {
                String str = "onCreate() obj: " + this;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            c.a.o0.a.a2.e O2 = O2();
            if (O2 != null) {
                O2.T().v();
            }
            if (G0) {
                String str = "onDestroy() obj: " + this;
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.F0) {
            return;
        }
        c.a.o0.a.e2.c.f fVar = this.D0.get(i2);
        this.F0 = true;
        if (fVar.a() && !O2().T().m(H0, false)) {
            R2(fVar);
            return;
        }
        c.a.o0.a.e2.c.d.j("onItemClick : " + fVar, Boolean.FALSE);
        S2(fVar);
    }

    @Override // c.a.o0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            boolean z = G0;
        }
    }

    @Override // c.a.o0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            v2(1);
            boolean z = G0;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            super.u0(activity);
            if (G0) {
                String str = "onAttach() obj: " + this;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.o0.a.g.aiapps_setting_fragment, viewGroup, false);
            O1(inflate);
            this.E0 = (FrameLayout) inflate.findViewById(c.a.o0.a.f.container);
            this.C0 = N2();
            ListView listView = (ListView) inflate.findViewById(c.a.o0.a.f.ai_apps_setting_list);
            listView.setAdapter((ListAdapter) this.C0);
            listView.setOnItemClickListener(this);
            if (N1()) {
                inflate = Q1(inflate);
            }
            return y1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
