package c.a.r0.j2.k.e.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f19810a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.j2.i.c f19811b;

    /* renamed from: c  reason: collision with root package name */
    public View f19812c;

    /* renamed from: d  reason: collision with root package name */
    public View f19813d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19814e;

    /* renamed from: f  reason: collision with root package name */
    public View f19815f;

    /* renamed from: g  reason: collision with root package name */
    public View f19816g;

    /* renamed from: h  reason: collision with root package name */
    public View f19817h;

    /* renamed from: i  reason: collision with root package name */
    public Button f19818i;

    /* loaded from: classes3.dex */
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

    public d(PbFragment pbFragment, c.a.r0.j2.i.c cVar) {
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
        this.f19812c = null;
        this.f19813d = null;
        this.f19814e = null;
        this.f19815f = null;
        this.f19816g = null;
        this.f19817h = null;
        this.f19818i = null;
        this.f19810a = pbFragment;
        this.f19811b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.f19812c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.f19818i;
            if (button != null && button.getVisibility() == 0) {
                View view = this.f19815f;
                if (view != null) {
                    view.setVisibility(0);
                }
                z2 = true;
            } else {
                View view2 = this.f19815f;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
            }
            View view3 = this.f19817h;
            if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
                this.f19816g.setVisibility(0);
            } else {
                this.f19816g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19812c : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f19810a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
            this.f19812c = inflate;
            inflate.setOnTouchListener(this.f19811b);
            View findViewById = this.f19812c.findViewById(R.id.pb_head_activity_join_number_container);
            this.f19813d = findViewById;
            findViewById.setVisibility(8);
            this.f19814e = (TextView) this.f19812c.findViewById(R.id.pb_head_activity_join_number);
            this.f19815f = this.f19812c.findViewById(R.id.new_pb_header_item_line_above_livepost);
            this.f19816g = this.f19812c.findViewById(R.id.new_pb_header_item_line_below_livepost);
            this.f19812c.setOnLongClickListener(new a(this));
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f19810a.getBaseFragmentActivity().getLayoutMode().j(this.f19812c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f19812c);
    }

    public void g(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            ArrayList<c.a.q0.s.q.b> q = eVar.O().q();
            if (q != null && q.size() > 0) {
                this.f19814e.setText(String.valueOf(q.get(0).f()));
                this.f19813d.setVisibility(0);
            } else {
                this.f19813d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.f19813d, R.drawable.activity_join_num_bg);
            SkinManager.setViewTextColor(this.f19814e, R.color.CAM_X0305, 1);
        }
    }

    public void h(c.a.r0.j2.h.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, eVar, z) == null) {
            boolean b2 = b(z);
            if (eVar == null || eVar.y() == null || eVar.y().c() != 0 || !z) {
                this.f19816g.setVisibility(8);
            } else if (b2) {
                this.f19816g.setVisibility(0);
            } else {
                this.f19816g.setVisibility(8);
            }
        }
    }
}
