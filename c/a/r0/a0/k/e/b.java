package c.a.r0.a0.k.e;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.s.q.d2;
import c.a.r0.g0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class b extends c.a.r0.g0.b<d2> implements b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public RelativeLayout n;
    public d2 o;
    public View p;
    public View q;
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public RelativeLayout v;
    public final View.OnClickListener w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14422e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14422e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14422e.o == null || this.f14422e.g() == null) {
                return;
            }
            this.f14422e.g().a(view, this.f14422e.o);
            TiebaStatic.log(new StatisticItem("c11844").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f14422e.o.U()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new a(this);
        this.m = tbPageContext;
        View j2 = j();
        this.p = j2.findViewById(R.id.divider);
        this.q = j2.findViewById(R.id.recommend_left_line);
        this.r = j2.findViewById(R.id.recommend_right_line);
        this.n = (RelativeLayout) j2.findViewById(R.id.ala_live_empty_layout_root);
        this.s = (TextView) j2.findViewById(R.id.ala_live_title);
        this.t = (TextView) j2.findViewById(R.id.start_live_btn);
        this.v = (RelativeLayout) j2.findViewById(R.id.ala_bottom_container);
        this.u = (TextView) j2.findViewById(R.id.ala_recommend_live);
    }

    @Override // c.a.r0.g0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // c.a.r0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.frs_ala_video_empty_layout : invokeV.intValue;
    }

    @Override // c.a.r0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f17232e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.t, R.drawable.ala_live_card_start_live_selector);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
        this.f17232e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.g0.b
    /* renamed from: q */
    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, d2Var) == null) {
            this.o = d2Var;
            s();
        }
    }

    @Override // c.a.r0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!this.o.k1) {
                this.u.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
                layoutParams.height = l.i(this.m.getPageActivity()) / 4;
                this.v.setLayoutParams(layoutParams);
            } else {
                this.u.setVisibility(0);
                this.q.setVisibility(0);
                this.r.setVisibility(0);
                ViewGroup.LayoutParams layoutParams2 = this.v.getLayoutParams();
                layoutParams2.height = this.m.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
                this.v.setLayoutParams(layoutParams2);
            }
            l(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.t.setOnClickListener(this.w);
        }
    }
}
