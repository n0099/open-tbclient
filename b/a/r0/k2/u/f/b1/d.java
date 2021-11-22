package b.a.r0.k2.u.f.b1;

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
    public PbFragment f20576a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.s.c f20577b;

    /* renamed from: c  reason: collision with root package name */
    public View f20578c;

    /* renamed from: d  reason: collision with root package name */
    public View f20579d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20580e;

    /* renamed from: f  reason: collision with root package name */
    public View f20581f;

    /* renamed from: g  reason: collision with root package name */
    public View f20582g;

    /* renamed from: h  reason: collision with root package name */
    public View f20583h;

    /* renamed from: i  reason: collision with root package name */
    public Button f20584i;

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
        this.f20578c = null;
        this.f20579d = null;
        this.f20580e = null;
        this.f20581f = null;
        this.f20582g = null;
        this.f20583h = null;
        this.f20584i = null;
        this.f20576a = pbFragment;
        this.f20577b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.f20578c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.f20584i;
            if (button != null && button.getVisibility() == 0) {
                View view = this.f20581f;
                if (view != null) {
                    view.setVisibility(0);
                }
                z2 = true;
            } else {
                View view2 = this.f20581f;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
            }
            View view3 = this.f20583h;
            if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
                this.f20582g.setVisibility(0);
            } else {
                this.f20582g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20578c : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f20576a.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.new_pb_header_item, (ViewGroup) null);
            this.f20578c = inflate;
            inflate.setOnTouchListener(this.f20577b);
            View findViewById = this.f20578c.findViewById(b.a.r0.k2.i.pb_head_activity_join_number_container);
            this.f20579d = findViewById;
            findViewById.setVisibility(8);
            this.f20580e = (TextView) this.f20578c.findViewById(b.a.r0.k2.i.pb_head_activity_join_number);
            this.f20581f = this.f20578c.findViewById(b.a.r0.k2.i.new_pb_header_item_line_above_livepost);
            this.f20582g = this.f20578c.findViewById(b.a.r0.k2.i.new_pb_header_item_line_below_livepost);
            this.f20578c.setOnLongClickListener(new a(this));
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f20576a.getBaseFragmentActivity().getLayoutMode().j(this.f20578c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f20578c);
    }

    public void g(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            ArrayList<b.a.q0.s.q.b> q = fVar.O().q();
            if (q != null && q.size() > 0) {
                this.f20580e.setText(String.valueOf(q.get(0).f()));
                this.f20579d.setVisibility(0);
            } else {
                this.f20579d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.f20579d, b.a.r0.k2.h.activity_join_num_bg);
            SkinManager.setViewTextColor(this.f20580e, b.a.r0.k2.f.CAM_X0305, 1);
        }
    }

    public void h(b.a.r0.k2.r.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, fVar, z) == null) {
            boolean b2 = b(z);
            if (fVar == null || fVar.y() == null || fVar.y().c() != 0 || !z) {
                this.f20582g.setVisibility(8);
            } else if (b2) {
                this.f20582g.setVisibility(0);
            } else {
                this.f20582g.setVisibility(8);
            }
        }
    }
}
