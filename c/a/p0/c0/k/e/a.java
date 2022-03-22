package c.a.p0.c0.k.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a4.g;
import c.a.p0.h0.z;
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
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class a extends c.a.p0.h0.b<g> implements z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView i;
    public TextView j;
    public TextView k;
    public RelativeLayout l;
    public LinearLayout m;
    public View n;
    public ForbidParentSwipeBackRelativeLayout o;
    public ParentDisallowInterceptHListView p;
    public c.a.p0.c0.k.a.b q;
    public boolean r;
    public g s;
    public String t;
    public AdapterView.d u;

    /* renamed from: c.a.p0.c0.k.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0998a implements SwipeBackLayout.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0998a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void disableSwipeBack() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.s == null || ListUtils.isEmpty(this.a.s.a) || this.a.s.a.size() <= 1) {
                return;
            }
            if (this.a.f15304b.getOrignalPage() instanceof BaseActivity) {
                ((BaseActivity) this.a.f15304b.getOrignalPage()).setSwipeBackEnabled(false);
            } else if (this.a.f15304b.getOrignalPage() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.a.f15304b.getOrignalPage()).setSwipeBackEnabled(false);
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.c
        public void enableSwipeBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.f15304b.getOrignalPage() instanceof BaseActivity) {
                    ((BaseActivity) this.a.f15304b.getOrignalPage()).setSwipeBackEnabled(this.a.r);
                } else if (this.a.f15304b.getOrignalPage() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.a.f15304b.getOrignalPage()).setSwipeBackEnabled(this.a.r);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                ThreadData item = this.a.q.getItem(i);
                this.a.u(item);
                a aVar = this.a;
                aVar.w(aVar.f15304b, item);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = true;
        this.u = new b(this);
        this.o = (ForbidParentSwipeBackRelativeLayout) k().findViewById(R.id.obfuscated_res_0x7f0911f5);
        this.i = (ThreadSkinView) k().findViewById(R.id.obfuscated_res_0x7f090be6);
        this.j = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090b3b);
        this.k = (TextView) k().findViewById(R.id.obfuscated_res_0x7f090b3d);
        this.l = (RelativeLayout) k().findViewById(R.id.obfuscated_res_0x7f090b3e);
        this.p = (ParentDisallowInterceptHListView) k().findViewById(R.id.obfuscated_res_0x7f090b3c);
        this.m = (LinearLayout) k().findViewById(R.id.obfuscated_res_0x7f090ad8);
        this.n = k().findViewById(R.id.obfuscated_res_0x7f0907f4);
        this.p.setDividerWidth(this.f15305c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234));
        this.p.setBackgroundResource(R.drawable.obfuscated_res_0x7f081200);
        this.p.setOnItemClickListener(this.u);
        this.p.setSelector(tbPageContext.getPageActivity().getResources().getDrawable(R.drawable.obfuscated_res_0x7f081200));
        c.a.p0.c0.k.a.b bVar = new c.a.p0.c0.k.a.b(tbPageContext);
        this.q = bVar;
        this.p.setAdapter((ListAdapter) bVar);
        this.k.setOnClickListener(this);
        if (this.f15304b.getOrignalPage() instanceof BaseActivity) {
            this.r = ((BaseActivity) this.f15304b.getOrignalPage()).isSwipeBackEnabled();
        } else if (this.f15304b.getOrignalPage() instanceof BaseFragmentActivity) {
            this.r = ((BaseFragmentActivity) this.f15304b.getOrignalPage()).isSwipeBackEnabled();
        }
        this.o.setSwipeControlInterface(new C0998a(this));
    }

    @Override // c.a.p0.h0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.t = str;
        }
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d02ff : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.o, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == this.k) {
            TiebaStatic.log(new StatisticItem("c12637"));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001627, 10001);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f15304b.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    public final void u(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) || threadData == null) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921018);
        customMessage.setData(threadData);
        MessageManager.getInstance().sendMessage(customMessage);
        TiebaStatic.log(new StatisticItem("c12638"));
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.s.a)) {
            return;
        }
        CustomMessage customMessage = new CustomMessage(2921017);
        customMessage.setData(this.s.a.get(0));
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void w(TbPageContext<?> tbPageContext, ThreadData threadData) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, threadData) == null) || tbPageContext == null || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = threadData.getAuthor().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
        if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null) {
            alaLiveInfoCoreData.userName = threadData.getThreadAlaInfo().user_info.user_name;
        }
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        g gVar = this.s;
        if (gVar != null && !ListUtils.isEmpty(gVar.a)) {
            for (ThreadData threadData2 : this.s.a) {
                alaLiveInfoListCoreData.mLiveInfoList.add(y(threadData2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_INSERT_LIVE, str, z, null, null, this.t)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: x */
    public void l(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) || gVar == null) {
            return;
        }
        this.s = gVar;
        v();
        this.q.b(gVar.a);
        m(j(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final AlaLiveInfoCoreData y(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, threadData)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            alaLiveInfoCoreData.userName = threadData.getAuthor().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }
}
