package c.a.p0.h0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardExtendForumItemHolder;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends c.a.p0.h0.c<c.a.p0.h0.e0.i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public CustomMessageListener F;
    public CustomMessageListener G;
    public HListView t;
    public c.a.p0.r1.b.b u;
    public CardExtendForumItemHolder v;
    public View w;
    public View.OnClickListener x;
    public LikeModel y;
    public List<c.a.p0.r1.b.c> z;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if ((obj instanceof c.a.p0.a4.y) && this.a.y.getErrorCode() == 0) {
                    return;
                }
                if (AntiHelper.m(this.a.y.getErrorCode(), this.a.y.getErrorString())) {
                    AntiHelper.u(this.a.getContext(), this.a.y.getErrorString());
                } else {
                    this.a.j().showToast(this.a.y.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.H(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i iVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.a.H(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public d(i iVar) {
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
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() == R.id.obfuscated_res_0x7f090a19) {
                if (ViewHelper.checkUpIsLogin(this.a.k().getContext())) {
                    String str = (String) view.getTag(R.id.obfuscated_res_0x7f091e7b);
                    String valueOf = String.valueOf(view.getTag(R.id.obfuscated_res_0x7f091e7a));
                    if (c.a.d.f.p.m.isForumName(str)) {
                        this.a.y.P(str, valueOf);
                        TiebaStatic.log(new StatisticItem(this.a.A).param("fid", valueOf).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    }
                }
            } else if (view.getTag(R.id.obfuscated_res_0x7f091e7b) != null) {
                String str2 = (String) view.getTag(R.id.obfuscated_res_0x7f091e7b);
                String valueOf2 = String.valueOf(view.getTag(R.id.obfuscated_res_0x7f091e7a));
                if (c.a.d.f.p.m.isForumName(str2)) {
                    if (view.getId() == R.id.obfuscated_res_0x7f091366) {
                        TiebaStatic.log(new StatisticItem(this.a.C).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    } else {
                        TiebaStatic.log(new StatisticItem(this.a.B).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    }
                    if (!StringUtils.isNull(this.a.D) && !StringUtils.isNull(this.a.E)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.k().getContext()).createCfgForpersonalized(str2, this.a.D, this.a.E)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.k().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
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
        this.F = new b(this, 2001336);
        this.G = new c(this, 2001335);
        HListView hListView = new HListView(getContext());
        this.t = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.t.setFooterDividersEnabled(false);
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().a != null && TbadkCoreApplication.getInst().getPersonalizeViewData().a.getParent() == null) {
            this.w = TbadkCoreApplication.getInst().getPersonalizeViewData().a;
        } else {
            this.w = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0285, (ViewGroup) null);
        }
        this.v = new CardExtendForumItemHolder(this.w);
        this.q.addView(this.t);
        this.t.setSelector(R.drawable.obfuscated_res_0x7f080d04);
        this.t.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224), 0);
        C();
        if (this.u == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 10; i3++) {
                arrayList.add(String.valueOf(i3));
            }
            c.a.p0.r1.b.b bVar = new c.a.p0.r1.b.b(getContext(), R.layout.obfuscated_res_0x7f0d0285, this.v);
            this.u = bVar;
            bVar.d(this.x);
            this.t.setAdapter((ListAdapter) this.u);
        }
        this.i.setOnClickListener(this);
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.y = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        this.t.setOnItemClickListener(null);
    }

    public final c.a.p0.h0.e0.g B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (ListUtils.getCount(this.z) > 0) {
                for (c.a.p0.r1.b.c cVar : this.z) {
                    if (cVar != null && (cVar instanceof c.a.p0.h0.e0.g)) {
                        c.a.p0.h0.e0.g gVar = (c.a.p0.h0.e0.g) cVar;
                        if (String.valueOf(gVar.f15328d).equals(str)) {
                            return gVar;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (c.a.p0.h0.e0.g) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.x = new d(this);
        }
    }

    public final boolean D(List<c.a.p0.r1.b.c> list, List<c.a.p0.r1.b.c> list2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2)) == null) {
            if (ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0 || ListUtils.getCount(list) != ListUtils.getCount(list2)) {
                return false;
            }
            boolean z = true;
            while (i < ListUtils.getCount(list)) {
                c.a.p0.r1.b.c cVar = (c.a.p0.r1.b.c) ListUtils.getItem(list, i);
                c.a.p0.r1.b.c cVar2 = (c.a.p0.r1.b.c) ListUtils.getItem(list2, i);
                if (cVar != null && (cVar instanceof c.a.p0.h0.e0.g) && cVar2 != null && (cVar2 instanceof c.a.p0.h0.e0.g)) {
                    c.a.p0.h0.e0.g gVar = (c.a.p0.h0.e0.g) cVar;
                    c.a.p0.h0.e0.g gVar2 = (c.a.p0.h0.e0.g) cVar2;
                    if (gVar.f15328d != gVar2.f15328d) {
                        z = false;
                    }
                    if (!gVar.f15326b.equals(gVar2.f15326b)) {
                        z = false;
                    }
                    i = gVar.f15327c.equals(gVar2.f15327c) ? i + 1 : 0;
                }
                z = false;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.c
    /* renamed from: E */
    public void t(c.a.p0.h0.e0.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            super.l(iVar);
            if (iVar != null && ListUtils.getCount(iVar.getDataList()) > 0) {
                int count = ListUtils.getCount(iVar.getDataList());
                if (count > 10) {
                    ArrayList arrayList = new ArrayList(iVar.getDataList());
                    iVar.getDataList().clear();
                    iVar.getDataList().addAll(arrayList.subList(0, 10));
                }
                this.E = iVar.i();
                this.D = iVar.g();
                if (D(iVar.getDataList(), this.z)) {
                    return;
                }
                boolean z = ListUtils.getCount(iVar.getDataList()) != ListUtils.getCount(this.z);
                this.z = iVar.getDataList();
                if (count <= 0) {
                    k().setVisibility(8);
                    return;
                }
                k().setVisibility(0);
                c.a.p0.r1.b.b bVar = this.u;
                if (bVar != null) {
                    if (z) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i = 0; i < this.z.size(); i++) {
                            arrayList2.add(String.valueOf(i));
                        }
                        c.a.p0.r1.b.b bVar2 = new c.a.p0.r1.b.b(getContext(), R.layout.obfuscated_res_0x7f0d0285, this.v);
                        this.u = bVar2;
                        bVar2.c(this.z);
                        this.u.d(this.x);
                        this.t.setAdapter((ListAdapter) this.u);
                        m(j(), TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    bVar.c(this.z);
                    this.u.notifyDataSetChanged();
                    return;
                }
                return;
            }
            k().setVisibility(8);
        }
    }

    public void F(BdUniqueId bdUniqueId) {
        CustomMessageListener customMessageListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || (customMessageListener = this.F) == null || this.G == null) {
            return;
        }
        customMessageListener.setTag(bdUniqueId);
        this.G.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.F);
        MessageManager.getInstance().registerListener(this.G);
    }

    public void G(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            this.A = str2;
            this.B = str3;
            this.C = str4;
        }
    }

    public final void H(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            c.a.p0.h0.e0.g B = B(String.valueOf(j));
            if (B != null) {
                B.f15329e = z;
            }
            c.a.p0.r1.b.b bVar = this.u;
            if (bVar != null) {
                bVar.c(this.z);
                this.u.notifyDataSetChanged();
            }
        }
    }

    @Override // c.a.p0.h0.c, c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        c.a.p0.r1.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i) == null) {
            super.m(tbPageContext, i);
            if (this.t == null || (bVar = this.u) == null) {
                return;
            }
            bVar.b(i);
        }
    }

    @Override // c.a.p0.h0.b
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            super.setFrom(str);
        }
    }
}
