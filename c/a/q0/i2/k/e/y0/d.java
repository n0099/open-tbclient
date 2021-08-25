package c.a.q0.i2.k.e.y0;

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
    public PbFragment f19699a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.i2.i.c f19700b;

    /* renamed from: c  reason: collision with root package name */
    public View f19701c;

    /* renamed from: d  reason: collision with root package name */
    public View f19702d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19703e;

    /* renamed from: f  reason: collision with root package name */
    public View f19704f;

    /* renamed from: g  reason: collision with root package name */
    public View f19705g;

    /* renamed from: h  reason: collision with root package name */
    public View f19706h;

    /* renamed from: i  reason: collision with root package name */
    public Button f19707i;

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

    public d(PbFragment pbFragment, c.a.q0.i2.i.c cVar) {
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
        this.f19701c = null;
        this.f19702d = null;
        this.f19703e = null;
        this.f19704f = null;
        this.f19705g = null;
        this.f19706h = null;
        this.f19707i = null;
        this.f19699a = pbFragment;
        this.f19700b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.f19701c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.f19707i;
            if (button != null && button.getVisibility() == 0) {
                View view = this.f19704f;
                if (view != null) {
                    view.setVisibility(0);
                }
                z2 = true;
            } else {
                View view2 = this.f19704f;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
            }
            View view3 = this.f19706h;
            if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
                this.f19705g.setVisibility(0);
            } else {
                this.f19705g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19701c : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f19699a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
            this.f19701c = inflate;
            inflate.setOnTouchListener(this.f19700b);
            View findViewById = this.f19701c.findViewById(R.id.pb_head_activity_join_number_container);
            this.f19702d = findViewById;
            findViewById.setVisibility(8);
            this.f19703e = (TextView) this.f19701c.findViewById(R.id.pb_head_activity_join_number);
            this.f19704f = this.f19701c.findViewById(R.id.new_pb_header_item_line_above_livepost);
            this.f19705g = this.f19701c.findViewById(R.id.new_pb_header_item_line_below_livepost);
            this.f19701c.setOnLongClickListener(new a(this));
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f19699a.getBaseFragmentActivity().getLayoutMode().j(this.f19701c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f19701c);
    }

    public void g(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            ArrayList<c.a.p0.s.q.b> q = eVar.O().q();
            if (q != null && q.size() > 0) {
                this.f19703e.setText(String.valueOf(q.get(0).f()));
                this.f19702d.setVisibility(0);
            } else {
                this.f19702d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.f19702d, R.drawable.activity_join_num_bg);
            SkinManager.setViewTextColor(this.f19703e, R.color.CAM_X0305, 1);
        }
    }

    public void h(c.a.q0.i2.h.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, eVar, z) == null) {
            boolean b2 = b(z);
            if (eVar == null || eVar.y() == null || eVar.y().c() != 0 || !z) {
                this.f19705g.setVisibility(8);
            } else if (b2) {
                this.f19705g.setVisibility(0);
            } else {
                this.f19705g.setVisibility(8);
            }
        }
    }
}
