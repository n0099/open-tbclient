package c.a.t0.t2.u.f.c1;

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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.t2.s.c f22955b;

    /* renamed from: c  reason: collision with root package name */
    public View f22956c;

    /* renamed from: d  reason: collision with root package name */
    public View f22957d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22958e;

    /* renamed from: f  reason: collision with root package name */
    public View f22959f;

    /* renamed from: g  reason: collision with root package name */
    public View f22960g;

    /* renamed from: h  reason: collision with root package name */
    public View f22961h;

    /* renamed from: i  reason: collision with root package name */
    public Button f22962i;

    /* loaded from: classes8.dex */
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

    public d(PbFragment pbFragment, c.a.t0.t2.s.c cVar) {
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
        this.f22956c = null;
        this.f22957d = null;
        this.f22958e = null;
        this.f22959f = null;
        this.f22960g = null;
        this.f22961h = null;
        this.f22962i = null;
        this.a = pbFragment;
        this.f22955b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.f22956c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.f22962i;
            if (button != null && button.getVisibility() == 0) {
                View view = this.f22959f;
                if (view != null) {
                    view.setVisibility(0);
                }
                z2 = true;
            } else {
                View view2 = this.f22959f;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
            }
            View view3 = this.f22961h;
            if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
                this.f22960g.setVisibility(0);
            } else {
                this.f22960g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22956c : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(c.a.t0.t2.j.new_pb_header_item, (ViewGroup) null);
            this.f22956c = inflate;
            inflate.setOnTouchListener(this.f22955b);
            View findViewById = this.f22956c.findViewById(c.a.t0.t2.i.pb_head_activity_join_number_container);
            this.f22957d = findViewById;
            findViewById.setVisibility(8);
            this.f22958e = (TextView) this.f22956c.findViewById(c.a.t0.t2.i.pb_head_activity_join_number);
            this.f22959f = this.f22956c.findViewById(c.a.t0.t2.i.new_pb_header_item_line_above_livepost);
            this.f22960g = this.f22956c.findViewById(c.a.t0.t2.i.new_pb_header_item_line_below_livepost);
            this.f22956c.setOnLongClickListener(new a(this));
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.f22956c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f22956c);
    }

    public void g(c.a.t0.t2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            ArrayList<c.a.s0.s.q.b> q = fVar.O().q();
            if (q != null && q.size() > 0) {
                this.f22958e.setText(String.valueOf(q.get(0).f()));
                this.f22957d.setVisibility(0);
            } else {
                this.f22957d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.f22957d, c.a.t0.t2.h.activity_join_num_bg);
            SkinManager.setViewTextColor(this.f22958e, c.a.t0.t2.f.CAM_X0305, 1);
        }
    }

    public void h(c.a.t0.t2.r.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, fVar, z) == null) {
            boolean b2 = b(z);
            if (fVar == null || fVar.y() == null || fVar.y().c() != 0 || !z) {
                this.f22960g.setVisibility(8);
            } else if (b2) {
                this.f22960g.setVisibility(0);
            } else {
                this.f22960g.setVisibility(8);
            }
        }
    }
}
