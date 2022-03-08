package c.a.r0.a0.k.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import c.a.d.f.p.n;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f14700b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f14701c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f14702d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f14703e;

    /* renamed from: c.a.r0.a0.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0940a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0940a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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
            if ("ala_frs_demo_hell_live_feed_back_type".equals(x0Var.getType())) {
                TiebaStatic.log(new StatisticItem("c12803").param("tid", x0Var.f()));
            } else if ("ala_frs_stage_live_feed_back_type".equals(x0Var.getType())) {
                TiebaStatic.log(new StatisticItem("c12807").param("tid", x0Var.f()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) || x0Var == null) {
                return;
            }
            if ("ala_frs_demo_hell_live_feed_back_type".equals(x0Var.getType())) {
                TiebaStatic.log(new StatisticItem("c12802").param("tid", x0Var.f()));
            } else if ("ala_frs_stage_live_feed_back_type".equals(x0Var.getType())) {
                TiebaStatic.log(new StatisticItem("c12806").param("tid", x0Var.f()));
            }
        }
    }

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
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
        this.f14703e = new C0940a(this);
        this.f14700b = tbPageContext;
        this.f14701c = viewGroup;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void b(e2 e2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var, str) == null) || e2Var == null || e2Var.p1() == null || this.f14700b == null || this.f14701c == null) {
            return;
        }
        int i2 = 0;
        boolean z = (e2Var.J() == null || e2Var.J().getUserId() == null || !e2Var.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (TbadkCoreApplication.isLogin() && e2Var.p1().dislikeInfo != null && !z && e2Var.p1().dislikeInfo.size() > 0) {
            if (this.a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f14700b);
                this.a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f14702d);
                this.a.setId(R.id.negative_feedback_view);
                this.a.setDefaultReasonArray(new String[]{this.f14700b.getString(R.string.bad_quality), "", ""});
                this.a.setEventCallback(this.f14703e);
                this.a.attachToViewUpperRightConnerFromFrsLive(this.f14701c, n.f(this.f14700b.getPageActivity(), R.dimen.tbds120), n.f(this.f14700b.getPageActivity(), R.dimen.tbds20));
                this.a.onChangeSkinType();
            }
            if (this.a.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
            x0 x0Var = new x0();
            x0Var.o(e2Var.w1());
            x0Var.k(e2Var.U());
            x0Var.n(e2Var.H0());
            x0Var.r(str);
            x0Var.j(e2Var.p1().dislikeInfo);
            this.a.setData(x0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.a.setVisibility(8);
            }
            i2 = n.f(this.f14700b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f14701c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14701c.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f14701c.setLayoutParams(layoutParams);
        }
        if (this.f14701c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f14701c.getLayoutParams();
            layoutParams2.rightMargin = i2;
            this.f14701c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.dismissPopupWindow();
        }
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nEGFeedBackView = this.a) == null) {
            return;
        }
        nEGFeedBackView.onChangeSkinType();
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f14702d = bdUniqueId;
        }
    }
}
