package b.a.r0.w.k.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import b.a.r0.b0.b0;
import b.a.r0.m3.g;
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
/* loaded from: classes5.dex */
public class a extends b.a.r0.b0.b<g> implements b0 {
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
    public b.a.r0.w.k.a.b u;
    public boolean v;
    public g w;
    public String x;
    public AdapterView.d y;

    /* renamed from: b.a.r0.w.k.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1294a implements SwipeBackLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26640e;

        public C1294a(a aVar) {
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
            this.f26640e = aVar;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26640e.w == null || ListUtils.isEmpty(this.f26640e.w.f22407e) || this.f26640e.w.f22407e.size() <= 1) {
                return;
            }
            if (this.f26640e.f16224f.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) this.f26640e.f16224f.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (this.f26640e.f16224f.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f26640e.f16224f.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f26640e.f16224f.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.f26640e.f16224f.getOrignalPage()).setSwipeBackEnabled(this.f26640e.v);
                } else if (this.f26640e.f16224f.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.f26640e.f16224f.getOrignalPage()).setSwipeBackEnabled(this.f26640e.v);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26641a;

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
            this.f26641a = aVar;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                d2 item = this.f26641a.u.getItem(i2);
                this.f26641a.s(item);
                a aVar = this.f26641a;
                aVar.u(aVar.f16224f, item);
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
        this.s = (ForbidParentSwipeBackRelativeLayout) i().findViewById(R.id.layout_root);
        this.m = (ThreadSkinView) i().findViewById(R.id.frs_thread_skin);
        this.n = (TextView) i().findViewById(R.id.frs_insert_live_label);
        this.o = (TextView) i().findViewById(R.id.frs_insert_live_more);
        this.p = (RelativeLayout) i().findViewById(R.id.frs_insert_live_top);
        this.t = (ParentDisallowInterceptHListView) i().findViewById(R.id.frs_insert_live_listview);
        this.q = (LinearLayout) i().findViewById(R.id.frs_card_content_layout);
        this.r = i().findViewById(R.id.divider_line);
        this.t.setDividerWidth(this.f16225g.getResources().getDimensionPixelSize(R.dimen.ds12));
        this.t.setBackgroundResource(R.drawable.transparent_bg);
        this.t.setOnItemClickListener(this.y);
        this.t.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
        b.a.r0.w.k.a.b bVar = new b.a.r0.w.k.a.b(tbPageContext);
        this.u = bVar;
        this.t.setAdapter((ListAdapter) bVar);
        this.o.setOnClickListener(this);
        if (this.f16224f.getOrignalPage() instanceof BaseActivity) {
            this.v = ((BaseActivity) this.f16224f.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.f16224f.getOrignalPage() instanceof BaseFragmentActivity) {
            this.v = ((BaseFragmentActivity) this.f16224f.getOrignalPage()).isSwipeBackEnabled();
        }
        this.s.setSwipeControlInterface(new C1294a(this));
    }

    @Override // b.a.r0.b0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.x = str;
        }
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.frs_ala_insert_rec_live_layout : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f16223e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.s, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        this.f16223e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == this.o) {
            TiebaStatic.log(new StatisticItem("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001627, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f16224f.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // b.a.r0.b0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    public final void s(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, d2Var) == null) || d2Var == null) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921018);
        customMessage.setData(d2Var);
        MessageManager.getInstance().sendMessage(customMessage);
        TiebaStatic.log(new StatisticItem("c12638"));
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.w.f22407e)) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        customMessage.setData(this.w.f22407e.get(0));
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void u(TbPageContext<?> tbPageContext, d2 d2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, d2Var) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.m1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = d2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(d2Var.m1());
        if (d2Var.m1() != null && d2Var.m1().user_info != null) {
            alaLiveInfoCoreData.userName = d2Var.m1().user_info.user_name;
        }
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        g gVar = this.w;
        if (gVar != null && !ListUtils.isEmpty(gVar.f22407e)) {
            for (d2 d2Var2 : this.w.f22407e) {
                alaLiveInfoListCoreData.mLiveInfoList.add(w(d2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.x)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: v */
    public void j(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) || gVar == null) {
            return;
        }
        this.w = gVar;
        t();
        this.u.b(gVar.f22407e);
        k(h(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData w(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, d2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(d2Var.m1());
            alaLiveInfoCoreData.userName = d2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }
}
