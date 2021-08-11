package c.a.p0.v.i.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.x0;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f25267a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f25268b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f25269c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f25270d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f25271e;

    /* renamed from: c.a.p0.v.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1182a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1182a(a aVar) {
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
            if ("ala_frs_demo_hell_live_feed_back_type".equals(x0Var.i())) {
                TiebaStatic.log(new StatisticItem("c12803").param("tid", x0Var.f()));
            } else if ("ala_frs_stage_live_feed_back_type".equals(x0Var.i())) {
                TiebaStatic.log(new StatisticItem("c12807").param("tid", x0Var.f()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) || x0Var == null) {
                return;
            }
            if ("ala_frs_demo_hell_live_feed_back_type".equals(x0Var.i())) {
                TiebaStatic.log(new StatisticItem("c12802").param("tid", x0Var.f()));
            } else if ("ala_frs_stage_live_feed_back_type".equals(x0Var.i())) {
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
        this.f25271e = new C1182a(this);
        this.f25268b = tbPageContext;
        this.f25269c = viewGroup;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25267a : (View) invokeV.objValue;
    }

    public void b(c2 c2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var, str) == null) || c2Var == null || c2Var.j1() == null || this.f25268b == null || this.f25269c == null) {
            return;
        }
        int i2 = 0;
        boolean z = (c2Var.J() == null || c2Var.J().getUserId() == null || !c2Var.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (TbadkCoreApplication.isLogin() && c2Var.j1().dislikeInfo != null && !z && c2Var.j1().dislikeInfo.size() > 0) {
            if (this.f25267a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f25268b);
                this.f25267a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f25270d);
                this.f25267a.setId(R.id.negative_feedback_view);
                this.f25267a.setDefaultReasonArray(new String[]{this.f25268b.getString(R.string.bad_quality), "", ""});
                this.f25267a.setEventCallback(this.f25271e);
                this.f25267a.attachToViewUpperRightConnerFromFrsLive(this.f25269c, l.g(this.f25268b.getPageActivity(), R.dimen.tbds120), l.g(this.f25268b.getPageActivity(), R.dimen.tbds20));
                this.f25267a.onChangeSkinType();
            }
            if (this.f25267a.getVisibility() != 0) {
                this.f25267a.setVisibility(0);
            }
            x0 x0Var = new x0();
            x0Var.p(c2Var.q1());
            x0Var.l(c2Var.T());
            x0Var.o(c2Var.D0());
            x0Var.s(str);
            x0Var.k(c2Var.j1().dislikeInfo);
            this.f25267a.setData(x0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f25267a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f25267a.setVisibility(8);
            }
            i2 = l.g(this.f25268b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f25269c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25269c.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f25269c.setLayoutParams(layoutParams);
        }
        if (this.f25269c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f25269c.getLayoutParams();
            layoutParams2.rightMargin = i2;
            this.f25269c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f25267a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.dismissPopupWindow();
        }
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nEGFeedBackView = this.f25267a) == null) {
            return;
        }
        nEGFeedBackView.onChangeSkinType();
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f25270d = bdUniqueId;
        }
    }
}
