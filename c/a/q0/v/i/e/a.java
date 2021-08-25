package c.a.q0.v.i.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import c.a.q0.a0.z;
import c.a.q0.i3.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.ala.view.ForbidParentSwipeBackRelativeLayout;
import com.baidu.ala.view.ParentDisallowInterceptHListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends c.a.q0.a0.b<g> implements z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView m;
    public TextView n;
    public TextView o;
    public RelativeLayout p;
    public LinearLayout q;
    public View r;
    public ForbidParentSwipeBackRelativeLayout s;
    public ParentDisallowInterceptHListView t;
    public c.a.q0.v.i.a.b u;
    public boolean v;
    public g w;
    public String x;
    public AdapterView.d y;

    /* renamed from: c.a.q0.v.i.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1194a implements SwipeBackLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25612e;

        public C1194a(a aVar) {
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
                    return;
                }
            }
            this.f25612e = aVar;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25612e.w == null || ListUtils.isEmpty(this.f25612e.w.f20234e) || this.f25612e.w.f20234e.size() <= 1) {
                return;
            }
            if (this.f25612e.f15232f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) this.f25612e.f15232f.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (this.f25612e.f15232f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f25612e.f15232f.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f25612e.f15232f.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.f25612e.f15232f.getOrignalPage()).setSwipeBackEnabled(this.f25612e.v);
                } else if (this.f25612e.f15232f.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.f25612e.f15232f.getOrignalPage()).setSwipeBackEnabled(this.f25612e.v);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25613a;

        public b(a aVar) {
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
                    return;
                }
            }
            this.f25613a = aVar;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                c2 item = this.f25613a.u.getItem(i2);
                this.f25613a.t(item);
                a aVar = this.f25613a;
                aVar.v(aVar.f15232f, item);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
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
        this.v = true;
        this.y = new b(this);
        this.s = (ForbidParentSwipeBackRelativeLayout) j().findViewById(R.id.layout_root);
        this.m = (ThreadSkinView) j().findViewById(R.id.frs_thread_skin);
        this.n = (TextView) j().findViewById(R.id.frs_insert_live_label);
        this.o = (TextView) j().findViewById(R.id.frs_insert_live_more);
        this.p = (RelativeLayout) j().findViewById(R.id.frs_insert_live_top);
        this.t = (ParentDisallowInterceptHListView) j().findViewById(R.id.frs_insert_live_listview);
        this.q = (LinearLayout) j().findViewById(R.id.frs_card_content_layout);
        this.r = j().findViewById(R.id.divider_line);
        this.t.setDividerWidth(this.f15233g.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.t.setBackgroundResource(R.drawable.transparent_bg);
        this.t.setOnItemClickListener(this.y);
        this.t.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        c.a.q0.v.i.a.b bVar = new c.a.q0.v.i.a.b(tbPageContext);
        this.u = bVar;
        this.t.setAdapter((ListAdapter) bVar);
        this.o.setOnClickListener(this);
        if (this.f15232f.getOrignalPage() instanceof BaseActivity) {
            this.v = ((BaseActivity) this.f15232f.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.f15232f.getOrignalPage() instanceof BaseFragmentActivity) {
            this.v = ((BaseFragmentActivity) this.f15232f.getOrignalPage()).isSwipeBackEnabled();
        }
        this.s.setSwipeControlInterface(new C1194a(this));
    }

    @Override // c.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.x = str;
        }
    }

    @Override // c.a.q0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.frs_ala_insert_rec_live_layout : invokeV.intValue;
    }

    @Override // c.a.q0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f15231e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.s, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        this.f15231e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == this.o) {
            TiebaStatic.log(new StatisticItem("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001627, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f15232f.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // c.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    public final void t(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, c2Var) == null) || c2Var == null) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921018);
        customMessage.setData(c2Var);
        MessageManager.getInstance().sendMessage(customMessage);
        TiebaStatic.log(new StatisticItem("c12638"));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.w.f20234e)) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        customMessage.setData(this.w.f20234e.get(0));
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void v(TbPageContext<?> tbPageContext, c2 c2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, c2Var) == null) || tbPageContext == null || c2Var == null || c2Var.J() == null || c2Var.j1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = c2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(c2Var.j1());
        if (c2Var.j1() != null && c2Var.j1().user_info != null) {
            alaLiveInfoCoreData.userName = c2Var.j1().user_info.user_name;
        }
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        g gVar = this.w;
        if (gVar != null && !ListUtils.isEmpty(gVar.f20234e)) {
            for (c2 c2Var2 : this.w.f20234e) {
                alaLiveInfoListCoreData.mLiveInfoList.add(x(c2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.x)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a0.b
    /* renamed from: w */
    public void k(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) || gVar == null) {
            return;
        }
        this.w = gVar;
        u();
        this.u.b(gVar.f20234e);
        l(i(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData x(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, c2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(c2Var.j1());
            alaLiveInfoCoreData.userName = c2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }
}
