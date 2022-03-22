package c.a.p0.f1.s2;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import c.a.o0.r.r.v0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f14612b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f14613c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f14614d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f14615e;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, v0 v0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, v0Var) == null) || arrayList == null || v0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", v0Var.c()).param("tid", v0Var.f()).param("nid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", v0Var.l).param("weight", v0Var.k).param("ab_tag", v0Var.p).param("extra", v0Var.m).param("card_type", v0Var.o).param(TiebaStatic.Params.OBJ_FLOOR, v0Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(v0 v0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v0Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", v0Var.c()).param("tid", v0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14615e = new a(this);
        this.f14612b = tbPageContext;
        this.f14613c = viewGroup;
    }

    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || this.f14612b == null || this.f14613c == null) {
            return;
        }
        int i = 0;
        boolean z = (threadData.getAuthor() == null || threadData.getAuthor().getUserId() == null || !threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (threadData.isSmartFrsThread() && threadData.getFeedBackReasonMap() != null && !z) {
            if (this.a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f14612b);
                this.a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f14614d);
                this.a.setId(R.id.obfuscated_res_0x7f091537);
                this.a.setDefaultReasonArray(new String[]{this.f14612b.getString(R.string.obfuscated_res_0x7f0f02c0), "", ""});
                this.a.setEventCallback(this.f14615e);
                this.a.m(this.f14613c, c.a.d.f.p.n.f(this.f14612b.getPageActivity(), R.dimen.tbds120), 0);
                this.a.q();
            }
            if (this.a.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
            v0 v0Var = new v0();
            v0Var.o(threadData.getTid());
            v0Var.k(threadData.getFid());
            v0Var.n(threadData.getNid());
            v0Var.j(threadData.getFeedBackReasonMap());
            v0Var.f10967g = threadData.feedBackExtraMap;
            this.a.setData(v0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.a.setVisibility(8);
            }
            i = c.a.d.f.p.n.f(this.f14612b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
        }
        if (this.f14613c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14613c.getLayoutParams();
            layoutParams.rightMargin = i;
            this.f14613c.setLayoutParams(layoutParams);
        }
        if (this.f14613c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f14613c.getLayoutParams();
            layoutParams2.rightMargin = i;
            this.f14613c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NEGFeedBackView nEGFeedBackView = this.a;
            return nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nEGFeedBackView = this.a) == null) {
            return;
        }
        nEGFeedBackView.q();
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f14614d = bdUniqueId;
        }
    }
}
