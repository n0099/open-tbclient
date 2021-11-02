package b.a.r0.x0.y2;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.h1;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f26902a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f26903b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f26904c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f26905d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f26906e;

    /* loaded from: classes5.dex */
    public class a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(x0 x0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, x0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, x0 x0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, x0Var) == null) || arrayList == null || x0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(arrayList.get(i2) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", x0Var.c()).param("tid", x0Var.f()).param("nid", x0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", x0Var.l).param("weight", x0Var.k).param("ab_tag", x0Var.p).param("extra", x0Var.m).param("card_type", x0Var.o).param(TiebaStatic.Params.OBJ_FLOOR, x0Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", x0Var.c()).param("tid", x0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26906e = new a(this);
        this.f26903b = tbPageContext;
        this.f26904c = viewGroup;
    }

    public void a(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || d2Var == null || this.f26903b == null || this.f26904c == null) {
            return;
        }
        int i2 = 0;
        boolean z = (d2Var.J() == null || d2Var.J().getUserId() == null || !d2Var.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (d2Var.x2() && d2Var.S() != null && !z) {
            if (this.f26902a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f26903b);
                this.f26902a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f26905d);
                this.f26902a.setId(e1.negative_feedback_view);
                this.f26902a.setDefaultReasonArray(new String[]{this.f26903b.getString(h1.bad_quality), "", ""});
                this.f26902a.setEventCallback(this.f26906e);
                this.f26902a.attachToViewUpperRightConner(this.f26904c, b.a.e.e.p.l.g(this.f26903b.getPageActivity(), c1.tbds120), 0);
                this.f26902a.onChangeSkinType();
            }
            if (this.f26902a.getVisibility() != 0) {
                this.f26902a.setVisibility(0);
            }
            x0 x0Var = new x0();
            x0Var.o(d2Var.s1());
            x0Var.k(d2Var.T());
            x0Var.n(d2Var.F0());
            x0Var.j(d2Var.S());
            x0Var.f13484g = d2Var.l1;
            this.f26902a.setData(x0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f26902a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f26902a.setVisibility(8);
            }
            i2 = b.a.e.e.p.l.g(this.f26903b.getPageActivity(), c1.ds32);
        }
        if (this.f26904c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26904c.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f26904c.setLayoutParams(layoutParams);
        }
        if (this.f26904c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f26904c.getLayoutParams();
            layoutParams2.rightMargin = i2;
            this.f26904c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f26902a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.dismissPopupWindow();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NEGFeedBackView nEGFeedBackView = this.f26902a;
            return nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nEGFeedBackView = this.f26902a) == null) {
            return;
        }
        nEGFeedBackView.onChangeSkinType();
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f26905d = bdUniqueId;
        }
    }
}
