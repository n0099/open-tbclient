package c.a.p0.w2.m.f.i1;

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
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w2.j.c f20088b;

    /* renamed from: c  reason: collision with root package name */
    public View f20089c;

    /* renamed from: d  reason: collision with root package name */
    public View f20090d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20091e;

    /* renamed from: f  reason: collision with root package name */
    public View f20092f;

    /* renamed from: g  reason: collision with root package name */
    public View f20093g;

    /* renamed from: h  reason: collision with root package name */
    public View f20094h;
    public Button i;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    public d(PbFragment pbFragment, c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20089c = null;
        this.f20090d = null;
        this.f20091e = null;
        this.f20092f = null;
        this.f20093g = null;
        this.f20094h = null;
        this.i = null;
        this.a = pbFragment;
        this.f20088b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.f20089c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.i;
            if (button != null && button.getVisibility() == 0) {
                View view = this.f20092f;
                if (view != null) {
                    view.setVisibility(0);
                }
                z2 = true;
            } else {
                View view2 = this.f20092f;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
            }
            View view3 = this.f20094h;
            if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
                this.f20093g.setVisibility(0);
            } else {
                this.f20093g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20089c : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fb, (ViewGroup) null);
            this.f20089c = inflate;
            inflate.setOnTouchListener(this.f20088b);
            View findViewById = this.f20089c.findViewById(R.id.obfuscated_res_0x7f0916cd);
            this.f20090d = findViewById;
            findViewById.setVisibility(8);
            this.f20091e = (TextView) this.f20089c.findViewById(R.id.obfuscated_res_0x7f0916cc);
            this.f20092f = this.f20089c.findViewById(R.id.obfuscated_res_0x7f09154f);
            this.f20093g = this.f20089c.findViewById(R.id.obfuscated_res_0x7f091550);
            this.f20089c.setOnLongClickListener(new a(this));
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.f20089c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f20089c);
    }

    public void g(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            ArrayList<c.a.o0.r.r.b> actDatas = fVar.O().getActDatas();
            if (actDatas != null && actDatas.size() > 0) {
                this.f20091e.setText(String.valueOf(actDatas.get(0).f()));
                this.f20090d.setVisibility(0);
            } else {
                this.f20090d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.f20090d, R.drawable.activity_join_num_bg);
            SkinManager.setViewTextColor(this.f20091e, R.color.CAM_X0305, 1);
        }
    }

    public void h(c.a.p0.w2.i.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, fVar, z) == null) {
            boolean b2 = b(z);
            if (fVar == null || fVar.y() == null || fVar.y().c() != 0 || !z) {
                this.f20093g.setVisibility(8);
            } else if (b2) {
                this.f20093g.setVisibility(0);
            } else {
                this.f20093g.setVisibility(8);
            }
        }
    }
}
