package c.a.r0.u2.k.f.c1;

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
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.u2.i.c f23367b;

    /* renamed from: c  reason: collision with root package name */
    public View f23368c;

    /* renamed from: d  reason: collision with root package name */
    public View f23369d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23370e;

    /* renamed from: f  reason: collision with root package name */
    public View f23371f;

    /* renamed from: g  reason: collision with root package name */
    public View f23372g;

    /* renamed from: h  reason: collision with root package name */
    public View f23373h;

    /* renamed from: i  reason: collision with root package name */
    public Button f23374i;

    /* loaded from: classes2.dex */
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

    public d(PbFragment pbFragment, c.a.r0.u2.i.c cVar) {
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
        this.f23368c = null;
        this.f23369d = null;
        this.f23370e = null;
        this.f23371f = null;
        this.f23372g = null;
        this.f23373h = null;
        this.f23374i = null;
        this.a = pbFragment;
        this.f23367b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.f23368c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.f23374i;
            if (button != null && button.getVisibility() == 0) {
                View view = this.f23371f;
                if (view != null) {
                    view.setVisibility(0);
                }
                z2 = true;
            } else {
                View view2 = this.f23371f;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
            }
            View view3 = this.f23373h;
            if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
                this.f23372g.setVisibility(0);
            } else {
                this.f23372g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23368c : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
            this.f23368c = inflate;
            inflate.setOnTouchListener(this.f23367b);
            View findViewById = this.f23368c.findViewById(R.id.pb_head_activity_join_number_container);
            this.f23369d = findViewById;
            findViewById.setVisibility(8);
            this.f23370e = (TextView) this.f23368c.findViewById(R.id.pb_head_activity_join_number);
            this.f23371f = this.f23368c.findViewById(R.id.new_pb_header_item_line_above_livepost);
            this.f23372g = this.f23368c.findViewById(R.id.new_pb_header_item_line_below_livepost);
            this.f23368c.setOnLongClickListener(new a(this));
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.f23368c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f23368c);
    }

    public void g(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            ArrayList<c.a.q0.r.r.b> q = fVar.O().q();
            if (q != null && q.size() > 0) {
                this.f23370e.setText(String.valueOf(q.get(0).f()));
                this.f23369d.setVisibility(0);
            } else {
                this.f23369d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.f23369d, R.drawable.activity_join_num_bg);
            SkinManager.setViewTextColor(this.f23370e, R.color.CAM_X0305, 1);
        }
    }

    public void h(c.a.r0.u2.h.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, fVar, z) == null) {
            boolean b2 = b(z);
            if (fVar == null || fVar.y() == null || fVar.y().c() != 0 || !z) {
                this.f23372g.setVisibility(8);
            } else if (b2) {
                this.f23372g.setVisibility(0);
            } else {
                this.f23372g.setVisibility(8);
            }
        }
    }
}
