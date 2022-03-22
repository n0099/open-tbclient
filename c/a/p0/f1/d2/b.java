package c.a.p0.f1.d2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.f1.d2.g.a;
import c.a.p0.h0.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoAlbumLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoBriefLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoDownloadLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoTagLayout;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetMsg;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ApkDetail;
import tbclient.GameCodeList;
import tbclient.ItemInfo;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public CardItemInfoDownloadLayout f13897b;

    /* renamed from: c  reason: collision with root package name */
    public CardItemInfoAlbumLayout f13898c;

    /* renamed from: d  reason: collision with root package name */
    public CardItemInfoTagLayout f13899d;

    /* renamed from: e  reason: collision with root package name */
    public CardItemInfoBriefLayout f13900e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f13901f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.f1.d2.a f13902g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.f1.d2.d f13903h;
    public View i;
    public ItemCardDownloadButton j;
    public TextView k;
    public View l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public CustomMessageListener o;
    public View.OnClickListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public HttpMessageListener s;

    /* loaded from: classes2.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                u.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB() && i2 > 0) {
                    c.a.p0.x3.b.r().A(3, 2);
                    c.a.p0.x3.b.r().G();
                }
            }
        }
    }

    /* renamed from: c.a.p0.f1.d2.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1054b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1054b(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.a.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.o0.r.l0.p.b bVar = new c.a.o0.r.l0.p.b(8);
                    bVar.o(objTypeByDownloadMode);
                    bVar.n(c.a.o0.r.l0.p.c.a(this.a.j.getCurrentItem().buttonLinkType.intValue(), this.a.j.getCurrentItem().apkDetail != null ? this.a.j.getCurrentItem().apkDetail.pkg_source.intValue() : 0));
                    bVar.l(str);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, view));
                Object tag = view.getTag(R.id.obfuscated_res_0x7f090f65);
                if (tag instanceof c.a.o0.r.l0.p.a) {
                    ItemData a = ((c.a.o0.r.l0.p.a) tag).a();
                    if (ItemCardHelper.a.equals(a.buttonName) || ItemCardHelper.f30252b.equals(a.buttonName) || ItemCardHelper.f30256f.equals(a.buttonName)) {
                        c.a.o0.r.l0.p.b bVar = new c.a.o0.r.l0.p.b(8);
                        bVar.o(c.a.o0.r.l0.p.c.b(a.buttonName));
                        int intValue = a.buttonLinkType.intValue();
                        ApkDetail apkDetail = a.apkDetail;
                        bVar.n(c.a.o0.r.l0.p.c.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int objTypeByDownloadMode = this.a.j.getObjTypeByDownloadMode();
                int a = c.a.o0.r.l0.p.c.a(this.a.j.getCurrentItem().buttonLinkType.intValue(), this.a.j.getCurrentItem().apkDetail != null ? this.a.j.getCurrentItem().apkDetail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a == 4) {
                    return;
                }
                c.a.o0.r.l0.p.b bVar = new c.a.o0.r.l0.p.b(8);
                bVar.o(objTypeByDownloadMode);
                bVar.n(a);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            PlayVoiceBnt playVoiceBnt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || (playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.obfuscated_res_0x7f090029)) == null) {
                return;
            }
            playVoiceBnt.k();
        }
    }

    /* loaded from: classes2.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.m = (String) customResponsedMessage.getData();
                ItemCardHelper.y(this.a.k, this.a.m);
                this.a.j.setCustomColorBtn(c.a.p0.a4.c.e(this.a.m));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.p0.f1.p2.a)) {
                c.a.p0.f1.p2.a aVar = (c.a.p0.f1.p2.a) customResponsedMessage.getData();
                if (aVar.f14380b == this.a.a.a) {
                    int i = aVar.f14381c;
                    if (i == 0 || i == 2) {
                        aVar.a = this.a.i;
                    } else if (i == 1) {
                        aVar.a = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003516 && this.a.f13903h.f13909c.get(0).getType() == c.a.p0.f1.d2.g.d.f13929c) {
                int error = httpResponsedMessage.getError();
                GameCodeGetResponseMsg gameCodeGetResponseMsg = (GameCodeGetResponseMsg) httpResponsedMessage;
                if (httpResponsedMessage.getStatusCode() == 200 && error == 0 && gameCodeGetResponseMsg.errCode == 0) {
                    this.a.s(true, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0789));
                    c.a.p0.f1.d2.h.a aVar = new c.a.p0.f1.d2.h.a(((GameCodeGetMsg) httpResponsedMessage.getOrginalMessage()).getPosition(), gameCodeGetResponseMsg.getCodeValue());
                    this.a.t(aVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921640, aVar));
                    return;
                }
                this.a.s(false, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0788));
            }
        }
    }

    public b(FrsItemTabFragment frsItemTabFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.n = new a(this);
        this.o = new C1054b(this, 2921609);
        this.p = new c(this);
        this.q = new f(this, 2921591);
        this.r = new g(this, 2921590);
        this.s = new h(this, CmdConfigHttp.CMD_GET_GAME_CODE);
        if (frsItemTabFragment == null || view == null) {
            return;
        }
        this.a = frsItemTabFragment;
        this.r.setSelfListener(true);
        frsItemTabFragment.getBaseFragmentActivity().registerListener(this.r);
        frsItemTabFragment.registerListener(this.q);
        frsItemTabFragment.registerListener(this.s);
        this.i = view.findViewById(R.id.obfuscated_res_0x7f090ad6);
        ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) view.findViewById(R.id.obfuscated_res_0x7f090ad4);
        this.j = itemCardDownloadButton;
        itemCardDownloadButton.setShadow(R.array.S_O_X003);
        this.j.A();
        this.j.setClickCallback(new d(this));
        this.o.setSelfListener(true);
        this.o.setTag(this.j.getTag());
        MessageManager.getInstance().registerListener(this.o);
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090ad5);
        this.k = textView;
        textView.setOnClickListener(this.p);
        c.a.o0.r.v.c.d(this.k).u(R.array.S_O_X003);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.obfuscated_res_0x7f090b54);
        this.f13901f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f13901f.setFadingEdgeLength(0);
        this.f13901f.setOverScrollMode(2);
        this.f13901f.addOnScrollListener(this.n);
        this.f13901f.setRecyclerListener(new e(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f13901f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f13901f.getPaddingBottom());
        this.f13897b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.f13898c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.f13899d = new CardItemInfoTagLayout(frsItemTabFragment.getContext());
        this.f13900e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.f13902g = new c.a.p0.f1.d2.a(frsItemTabFragment, this.f13901f);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13901f.removeHeaderView(this.f13897b);
            this.f13901f.removeHeaderView(this.f13898c);
            this.f13901f.removeHeaderView(this.f13899d);
            this.f13901f.removeHeaderView(this.f13900e);
            c.a.p0.f1.d2.d dVar = this.f13903h;
            if (dVar == null) {
                return;
            }
            if (dVar.a != null) {
                this.f13901f.s(this.f13897b);
                this.f13897b.setData(this.f13903h.a);
            }
            if (!ListUtils.isEmpty(this.f13903h.f13908b)) {
                this.f13901f.s(this.f13898c);
                this.f13898c.setData(this.f13903h.f13908b);
            }
            ItemInfo itemInfo = this.f13903h.a;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f13901f.s(this.f13899d);
                this.f13899d.setData(this.f13903h.a);
            }
            if (this.f13903h.a != null) {
                this.f13901f.s(this.f13900e);
                this.f13900e.setData(this.f13903h.a);
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View view = this.i;
            view.setPadding(view.getPaddingLeft(), this.i.getPaddingTop(), this.i.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(R.dimen.tbds200) : this.i.getPaddingBottom());
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.f1.d2.a aVar = this.f13902g;
            if (aVar != null) {
                aVar.d();
            }
            this.f13897b.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f13898c.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f13899d.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f13900e.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.j.v();
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.k);
            if (!ItemCardHelper.f30254d.contentEquals(this.k.getText()) && !ItemCardHelper.f30256f.contentEquals(this.k.getText())) {
                this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0101));
                d2.n(R.string.J_X01);
                d2.k(R.color.transparent);
                d2.g(c.a.p0.a4.c.e(this.m));
            } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.k.setTextColor(c.a.p0.a4.c.a(c.a.p0.a4.c.e(this.m), c.a.o0.r.v.a.a(R.string.A_X01)));
                d2.l(R.dimen.tbds1);
                d2.t(c.a.p0.a4.c.a(c.a.p0.a4.c.e(this.m), c.a.o0.r.v.a.a(R.string.A_X07)));
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0208);
            } else {
                c.a.o0.r.v.c.d(this.k).v(R.color.CAM_X0103);
                d2.l(R.dimen.tbds1);
                d2.k(R.color.CAM_X0209);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0209);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.f1.d2.a aVar = this.f13902g;
            if (aVar != null) {
                aVar.f();
            }
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            c.a.p0.f1.p2.a aVar = new c.a.p0.f1.p2.a();
            aVar.f14380b = z ? this.a.a : 0;
            aVar.f14381c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void m(c.a.p0.f1.d2.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f13903h = dVar;
        h();
        if (dVar.f13910d) {
            a.b bVar = new a.b();
            bVar.e(this.m);
            ItemInfo itemInfo = dVar.a;
            bVar.d(itemInfo != null ? itemInfo.id.intValue() : 0L);
            this.f13903h.f13909c.add(0, bVar.c());
        }
        if (dVar.a != null) {
            ItemData itemData = new ItemData();
            itemData.parseProto(dVar.a);
            c.a.o0.r.l0.p.a aVar = new c.a.o0.r.l0.p.a(itemData, 0, "");
            if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.j.setCustomColorBtn(c.a.p0.a4.c.e(this.m));
                this.j.B();
                this.j.setData(itemData, -1, this.a.f32676e);
                int objTypeByDownloadMode = this.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.o0.r.l0.p.b bVar2 = new c.a.o0.r.l0.p.b(7);
                    bVar2.o(objTypeByDownloadMode);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar2));
                }
                r();
            } else {
                ItemCardHelper.m(this.k, aVar, this.m);
                if (!ItemCardHelper.f30255e.equals(itemData.buttonName)) {
                    c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.k);
                    if (!ItemCardHelper.f30254d.equals(itemData.buttonName) && !ItemCardHelper.f30256f.equals(itemData.buttonName)) {
                        this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0101));
                        d2.n(R.string.J_X01);
                        d2.k(R.color.transparent);
                        d2.g(c.a.p0.a4.c.e(this.m));
                    } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        this.k.setTextColor(c.a.p0.a4.c.a(c.a.p0.a4.c.e(this.m), c.a.o0.r.v.a.a(R.string.A_X01)));
                        d2.l(R.dimen.tbds1);
                        d2.t(c.a.p0.a4.c.a(c.a.p0.a4.c.e(this.m), c.a.o0.r.v.a.a(R.string.A_X07)));
                        d2.n(R.string.J_X01);
                        d2.f(R.color.CAM_X0208);
                    } else {
                        c.a.o0.r.v.c.d(this.k).v(R.color.CAM_X0103);
                        d2.l(R.dimen.tbds1);
                        d2.k(R.color.CAM_X0209);
                        d2.n(R.string.J_X01);
                        d2.f(R.color.CAM_X0209);
                    }
                    this.i.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(itemData.buttonName);
                    if (ItemCardHelper.f30256f.equals(itemData.buttonName)) {
                        this.k.setEnabled(false);
                    }
                    r();
                    if (ItemCardHelper.a.equals(itemData.buttonName) || ItemCardHelper.f30252b.equals(itemData.buttonName) || ItemCardHelper.f30256f.equals(itemData.buttonName)) {
                        c.a.o0.r.l0.p.b bVar3 = new c.a.o0.r.l0.p.b(7);
                        bVar3.o(c.a.o0.r.l0.p.c.b(itemData.buttonName));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar3));
                    }
                }
            }
        }
        this.f13902g.g(dVar.f13909c);
        this.f13902g.d();
    }

    public void n(BdUniqueId bdUniqueId) {
        c.a.p0.f1.d2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || (aVar = this.f13902g) == null) {
            return;
        }
        aVar.h(bdUniqueId);
    }

    public void o(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (bdTypeRecyclerView = this.f13901f) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i);
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.m = str;
        }
    }

    public void q(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdTypeRecyclerView = this.f13901f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.l == null) {
                this.l = new View(this.a.getContext());
                this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds200)));
            }
            this.f13901f.setFooterView(this.l);
        }
    }

    public void s(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
            bdTopToast.i(z);
            bdTopToast.h(str);
            bdTopToast.j((ViewGroup) ((Activity) this.a.getContext()).findViewById(16908290));
        }
    }

    public void t(c.a.p0.f1.d2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            ((c.a.p0.f1.d2.g.d) this.f13903h.f13909c.get(0)).a--;
            List<GameCodeList> list = ((c.a.p0.f1.d2.g.d) this.f13903h.f13909c.get(0)).f13930b;
            GameCodeList gameCodeList = list.get(aVar.a);
            list.remove(aVar.a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = aVar.f13936b;
            builder.type = gameCodeList.type;
            builder.label = gameCodeList.label;
            builder.begin_time = gameCodeList.begin_time;
            builder.end_time = gameCodeList.end_time;
            builder.item_id = gameCodeList.item_id;
            builder.list_id = gameCodeList.list_id;
            GameCodeList build = builder.build(false);
            int i = aVar.a;
            while (i < list.size() && list.get(i).claimed_status.intValue() == 1) {
                i++;
            }
            while (i < list.size() && list.get(i).end_time.intValue() < build.end_time.intValue() && list.get(i).claimed_status.intValue() == 2) {
                i++;
            }
            list.add(i, build);
            this.f13902g.e();
        }
    }
}
