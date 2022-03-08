package c.a.r0.u2.k.f;

import android.view.View;
import c.a.q0.r.r.e2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class r0 extends c.a.q0.r.l0.t.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;
    public boolean u;
    public int v;
    public TbPageContext w;
    public String x;
    public int y;
    public e2 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(TbPageContext tbPageContext, c.a.q0.r.l0.t.b bVar, int i2) {
        super(tbPageContext, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (c.a.q0.r.l0.t.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = false;
        this.u = false;
        this.v = 0;
        this.v = i2;
        this.w = tbPageContext;
        if (i2 == 1) {
            super.m("4");
        } else if (i2 == 3) {
            super.m("5");
        } else if (i2 != 4 && i2 != 5 && i2 != 6) {
            super.m("0");
        } else {
            super.m("4");
        }
    }

    @Override // c.a.q0.r.l0.t.c, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || view.getAlpha() < 0.4d) {
            return;
        }
        c.a.q0.r.l0.t.a aVar = this.f13052e;
        String userId = aVar != null ? aVar.getUserId() : "";
        TiebaStatic.log(new StatisticItem("c12408").param("obj_source", u()).param("obj_id", userId).param("tid", this.x));
        int i2 = this.v;
        int i3 = 8;
        int i4 = 0;
        if (i2 == 1) {
            i3 = 3;
        } else if (i2 == 3) {
            i3 = 2;
        } else if (i2 == 5) {
            i3 = 5;
        } else if (i2 == 7) {
            i3 = 7;
        } else if (i2 == 6) {
            i3 = 6;
        } else if (i2 == 4) {
            i3 = 4;
        } else if (i2 != 8) {
            i3 = 0;
        }
        StatisticItem statisticItem = new StatisticItem("c12507");
        statisticItem.param("obj_locate", i3);
        statisticItem.param("obj_id", userId);
        statisticItem.param("tid", this.x);
        statisticItem.param("obj_param1", this.y);
        if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(statisticItem);
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
        statisticItem2.param("obj_id", userId);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem2.param("tid", this.x);
        e2 e2Var = this.z;
        if (e2Var != null) {
            statisticItem2.param("nid", e2Var.H0());
            if (this.z.L() != null && !c.a.d.f.p.m.isEmpty(this.z.L().oriUgcVid)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.z.L().oriUgcVid);
            }
            statisticItem2.param("recom_source", this.z.Z0);
            statisticItem2.param("ab_tag", this.z.b1);
            statisticItem2.param("weight", this.z.a1);
            statisticItem2.param("extra", this.z.c1);
        }
        TbPageContext tbPageContext = this.w;
        if (tbPageContext != null) {
            c.a.q0.o0.c.e(tbPageContext.getPageActivity(), statisticItem2);
        }
        TiebaStatic.log(statisticItem2);
        super.onClick(view);
        if (this.t && this.f13052e != null) {
            TiebaStatic.log(new StatisticItem("c11924").param("obj_id", this.f13052e.getUserId()));
        }
        if (!this.u || this.f13052e == null) {
            return;
        }
        int i5 = this.v;
        if (i5 == 1) {
            i4 = 1;
        } else if (i5 == 2) {
            i4 = 2;
        }
        TiebaStatic.log(new StatisticItem("c12150").param("obj_locate", i4).param("obj_id", this.f13052e.getUserId()));
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String fromPageKey = UtilHelper.getFromPageKey(this.w);
            if (fromPageKey == null) {
                return 3;
            }
            if (fromPageKey.equals("a038")) {
                return 1;
            }
            if (fromPageKey.equals("a002")) {
                return 2;
            }
            if (fromPageKey.equals("a006")) {
                return 3;
            }
            if (fromPageKey.equals("a011")) {
                return 4;
            }
            if (fromPageKey.equals("a033")) {
                return 5;
            }
            return fromPageKey.equals("a010") ? 6 : 7;
        }
        return invokeV.intValue;
    }

    public void v(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var) == null) {
            this.z = e2Var;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.y = i2;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.x = str;
            p(str);
        }
    }
}
