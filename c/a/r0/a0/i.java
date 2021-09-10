package c.a.r0.a0;

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
/* loaded from: classes3.dex */
public class i extends c.a.r0.a0.c<c.a.r0.a0.d0.i> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View.OnClickListener B;
    public LikeModel C;
    public List<c.a.r0.h1.b.c> D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public CustomMessageListener J;
    public CustomMessageListener K;
    public HListView x;
    public c.a.r0.h1.b.b y;
    public CardExtendForumItemHolder z;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f15606a;

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
                    return;
                }
            }
            this.f15606a = iVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if ((obj instanceof c.a.r0.j3.w) && this.f15606a.C.getErrorCode() == 0) {
                    return;
                }
                if (AntiHelper.m(this.f15606a.C.getErrorCode(), this.f15606a.C.getErrorString())) {
                    AntiHelper.u(this.f15606a.d(), this.f15606a.C.getErrorString());
                } else {
                    this.f15606a.i().showToast(this.f15606a.C.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f15607a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15607a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f15607a.P(((Long) customResponsedMessage.getData()).longValue(), false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f15608a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15608a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                this.f15608a.P(((Long) customResponsedMessage.getData()).longValue(), true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f15609e;

        public d(i iVar) {
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
                    return;
                }
            }
            this.f15609e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view.getId() == R.id.forum_add_love) {
                if (ViewHelper.checkUpIsLogin(this.f15609e.j().getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    if (c.a.e.e.p.k.isForumName(str)) {
                        this.f15609e.C.L(str, valueOf);
                        TiebaStatic.log(new StatisticItem(this.f15609e.E).param("fid", valueOf).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    }
                }
            } else if (view.getTag(R.id.tag_forum_name) != null) {
                String str2 = (String) view.getTag(R.id.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (c.a.e.e.p.k.isForumName(str2)) {
                    if (view.getId() == R.id.m_forum_name_textview) {
                        TiebaStatic.log(new StatisticItem(this.f15609e.G).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    } else {
                        TiebaStatic.log(new StatisticItem(this.f15609e.F).param("fid", valueOf2).param(TiebaStatic.Params.OBJ_PARAM3, m.e()));
                    }
                    if (!StringUtils.isNull(this.f15609e.H) && !StringUtils.isNull(this.f15609e.I)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15609e.j().getContext()).createCfgForpersonalized(str2, this.f15609e.H, this.f15609e.I)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f15609e.j().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.J = new b(this, 2001336);
        this.K = new c(this, 2001335);
        HListView hListView = new HListView(d());
        this.x = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.x.setFooterDividersEnabled(false);
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().f14231b != null && TbadkCoreApplication.getInst().getPersonalizeViewData().f14231b.getParent() == null) {
            this.A = TbadkCoreApplication.getInst().getPersonalizeViewData().f14231b;
        } else {
            this.A = LayoutInflater.from(d()).inflate(R.layout.extend_forum_item, (ViewGroup) null);
        }
        this.z = new CardExtendForumItemHolder(this.A);
        this.u.addView(this.x);
        this.x.setSelector(R.drawable.list_selector_transparent);
        this.x.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        J();
        if (this.y == null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < 10; i4++) {
                arrayList.add(String.valueOf(i4));
            }
            c.a.r0.h1.b.b bVar = new c.a.r0.h1.b.b(d(), R.layout.extend_forum_item, this.z);
            this.y = bVar;
            bVar.d(this.B);
            this.x.setAdapter((ListAdapter) this.y);
        }
        this.m.setOnClickListener(this);
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.C = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        this.x.setOnItemClickListener(null);
    }

    public final c.a.r0.a0.d0.g D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (ListUtils.getCount(this.D) > 0) {
                for (c.a.r0.h1.b.c cVar : this.D) {
                    if (cVar != null && (cVar instanceof c.a.r0.a0.d0.g)) {
                        c.a.r0.a0.d0.g gVar = (c.a.r0.a0.d0.g) cVar;
                        if (String.valueOf(gVar.f15575d).equals(str)) {
                            return gVar;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (c.a.r0.a0.d0.g) invokeL.objValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.B = new d(this);
        }
    }

    public final boolean K(List<c.a.r0.h1.b.c> list, List<c.a.r0.h1.b.c> list2) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2)) == null) {
            if (ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0 || ListUtils.getCount(list) != ListUtils.getCount(list2)) {
                return false;
            }
            boolean z = true;
            while (i2 < ListUtils.getCount(list)) {
                c.a.r0.h1.b.c cVar = (c.a.r0.h1.b.c) ListUtils.getItem(list, i2);
                c.a.r0.h1.b.c cVar2 = (c.a.r0.h1.b.c) ListUtils.getItem(list2, i2);
                if (cVar != null && (cVar instanceof c.a.r0.a0.d0.g) && cVar2 != null && (cVar2 instanceof c.a.r0.a0.d0.g)) {
                    c.a.r0.a0.d0.g gVar = (c.a.r0.a0.d0.g) cVar;
                    c.a.r0.a0.d0.g gVar2 = (c.a.r0.a0.d0.g) cVar2;
                    if (gVar.f15575d != gVar2.f15575d) {
                        z = false;
                    }
                    if (!gVar.f15573b.equals(gVar2.f15573b)) {
                        z = false;
                    }
                    i2 = gVar.f15574c.equals(gVar2.f15574c) ? i2 + 1 : 0;
                }
                z = false;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: L */
    public void k(c.a.r0.a0.d0.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            super.s(iVar);
            if (iVar != null && ListUtils.getCount(iVar.getDataList()) > 0) {
                int count = ListUtils.getCount(iVar.getDataList());
                if (count > 10) {
                    ArrayList arrayList = new ArrayList(iVar.getDataList());
                    iVar.getDataList().clear();
                    iVar.getDataList().addAll(arrayList.subList(0, 10));
                }
                this.I = iVar.k();
                this.H = iVar.i();
                if (K(iVar.getDataList(), this.D)) {
                    return;
                }
                boolean z = ListUtils.getCount(iVar.getDataList()) != ListUtils.getCount(this.D);
                this.D = iVar.getDataList();
                if (count <= 0) {
                    j().setVisibility(8);
                    return;
                }
                j().setVisibility(0);
                c.a.r0.h1.b.b bVar = this.y;
                if (bVar != null) {
                    if (z) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < this.D.size(); i2++) {
                            arrayList2.add(String.valueOf(i2));
                        }
                        c.a.r0.h1.b.b bVar2 = new c.a.r0.h1.b.b(d(), R.layout.extend_forum_item, this.z);
                        this.y = bVar2;
                        bVar2.c(this.D);
                        this.y.d(this.B);
                        this.x.setAdapter((ListAdapter) this.y);
                        l(i(), TbadkCoreApplication.getInst().getSkinType());
                        return;
                    }
                    bVar.c(this.D);
                    this.y.notifyDataSetChanged();
                    return;
                }
                return;
            }
            j().setVisibility(8);
        }
    }

    public void N(BdUniqueId bdUniqueId) {
        CustomMessageListener customMessageListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || (customMessageListener = this.J) == null || this.K == null) {
            return;
        }
        customMessageListener.setTag(bdUniqueId);
        this.K.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.J);
        MessageManager.getInstance().registerListener(this.K);
    }

    public void O(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            this.E = str2;
            this.F = str3;
            this.G = str4;
        }
    }

    public final void P(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            c.a.r0.a0.d0.g D = D(String.valueOf(j2));
            if (D != null) {
                D.f15576e = z;
            }
            c.a.r0.h1.b.b bVar = this.y;
            if (bVar != null) {
                bVar.c(this.D);
                this.y.notifyDataSetChanged();
            }
        }
    }

    @Override // c.a.r0.a0.c, c.a.r0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        c.a.r0.h1.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i2) == null) {
            super.l(tbPageContext, i2);
            if (this.x == null || (bVar = this.y) == null) {
                return;
            }
            bVar.b(i2);
        }
    }

    @Override // c.a.r0.a0.b
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            super.setFrom(str);
        }
    }
}
