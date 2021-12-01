package c.a.r0.q2.u.f.b1;

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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.q2.s.c f21781b;

    /* renamed from: c  reason: collision with root package name */
    public View f21782c;

    /* renamed from: d  reason: collision with root package name */
    public View f21783d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21784e;

    /* renamed from: f  reason: collision with root package name */
    public View f21785f;

    /* renamed from: g  reason: collision with root package name */
    public View f21786g;

    /* renamed from: h  reason: collision with root package name */
    public View f21787h;

    /* renamed from: i  reason: collision with root package name */
    public Button f21788i;

    /* loaded from: classes6.dex */
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

    public d(PbFragment pbFragment, c.a.r0.q2.s.c cVar) {
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
        this.f21782c = null;
        this.f21783d = null;
        this.f21784e = null;
        this.f21785f = null;
        this.f21786g = null;
        this.f21787h = null;
        this.f21788i = null;
        this.a = pbFragment;
        this.f21781b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.f21782c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.f21788i;
            if (button != null && button.getVisibility() == 0) {
                View view = this.f21785f;
                if (view != null) {
                    view.setVisibility(0);
                }
                z2 = true;
            } else {
                View view2 = this.f21785f;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
            }
            View view3 = this.f21787h;
            if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
                this.f21786g.setVisibility(0);
            } else {
                this.f21786g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21782c : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(c.a.r0.q2.j.new_pb_header_item, (ViewGroup) null);
            this.f21782c = inflate;
            inflate.setOnTouchListener(this.f21781b);
            View findViewById = this.f21782c.findViewById(c.a.r0.q2.i.pb_head_activity_join_number_container);
            this.f21783d = findViewById;
            findViewById.setVisibility(8);
            this.f21784e = (TextView) this.f21782c.findViewById(c.a.r0.q2.i.pb_head_activity_join_number);
            this.f21785f = this.f21782c.findViewById(c.a.r0.q2.i.new_pb_header_item_line_above_livepost);
            this.f21786g = this.f21782c.findViewById(c.a.r0.q2.i.new_pb_header_item_line_below_livepost);
            this.f21782c.setOnLongClickListener(new a(this));
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.f21782c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f21782c);
    }

    public void g(c.a.r0.q2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            ArrayList<c.a.q0.s.q.b> q = fVar.O().q();
            if (q != null && q.size() > 0) {
                this.f21784e.setText(String.valueOf(q.get(0).f()));
                this.f21783d.setVisibility(0);
            } else {
                this.f21783d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.f21783d, c.a.r0.q2.h.activity_join_num_bg);
            SkinManager.setViewTextColor(this.f21784e, c.a.r0.q2.f.CAM_X0305, 1);
        }
    }

    public void h(c.a.r0.q2.r.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, fVar, z) == null) {
            boolean b2 = b(z);
            if (fVar == null || fVar.y() == null || fVar.y().c() != 0 || !z) {
                this.f21786g.setVisibility(8);
            } else if (b2) {
                this.f21786g.setVisibility(0);
            } else {
                this.f21786g.setVisibility(8);
            }
        }
    }
}
