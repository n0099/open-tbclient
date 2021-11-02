package b.a.r0.k2.u.f.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f18997a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.s.c f18998b;

    /* renamed from: c  reason: collision with root package name */
    public View f18999c;

    /* renamed from: d  reason: collision with root package name */
    public View f19000d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19001e;

    /* renamed from: f  reason: collision with root package name */
    public View f19002f;

    /* renamed from: g  reason: collision with root package name */
    public View f19003g;

    /* renamed from: h  reason: collision with root package name */
    public View f19004h;

    /* renamed from: i  reason: collision with root package name */
    public Button f19005i;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public d(PbFragment pbFragment, b.a.r0.k2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18999c = null;
        this.f19000d = null;
        this.f19001e = null;
        this.f19002f = null;
        this.f19003g = null;
        this.f19004h = null;
        this.f19005i = null;
        this.f18997a = pbFragment;
        this.f18998b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.f18999c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.f19005i;
            if (button != null && button.getVisibility() == 0) {
                View view = this.f19002f;
                if (view != null) {
                    view.setVisibility(0);
                }
                z2 = true;
            } else {
                View view2 = this.f19002f;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
            }
            View view3 = this.f19004h;
            if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
                this.f19003g.setVisibility(0);
            } else {
                this.f19003g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18999c : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f18997a.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.new_pb_header_item, (ViewGroup) null);
            this.f18999c = inflate;
            inflate.setOnTouchListener(this.f18998b);
            View findViewById = this.f18999c.findViewById(b.a.r0.k2.i.pb_head_activity_join_number_container);
            this.f19000d = findViewById;
            findViewById.setVisibility(8);
            this.f19001e = (TextView) this.f18999c.findViewById(b.a.r0.k2.i.pb_head_activity_join_number);
            this.f19002f = this.f18999c.findViewById(b.a.r0.k2.i.new_pb_header_item_line_above_livepost);
            this.f19003g = this.f18999c.findViewById(b.a.r0.k2.i.new_pb_header_item_line_below_livepost);
            this.f18999c.setOnLongClickListener(new a(this));
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f18997a.getBaseFragmentActivity().getLayoutMode().j(this.f18999c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f18999c);
    }

    public void g(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            ArrayList<b.a.q0.s.q.b> q = fVar.O().q();
            if (q != null && q.size() > 0) {
                this.f19001e.setText(String.valueOf(q.get(0).f()));
                this.f19000d.setVisibility(0);
            } else {
                this.f19000d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.f19000d, b.a.r0.k2.h.activity_join_num_bg);
            SkinManager.setViewTextColor(this.f19001e, b.a.r0.k2.f.CAM_X0305, 1);
        }
    }

    public void h(b.a.r0.k2.r.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, fVar, z) == null) {
            boolean b2 = b(z);
            if (fVar == null || fVar.y() == null || fVar.y().c() != 0 || !z) {
                this.f19003g.setVisibility(8);
            } else if (b2) {
                this.f19003g.setVisibility(0);
            } else {
                this.f19003g.setVisibility(8);
            }
        }
    }
}
