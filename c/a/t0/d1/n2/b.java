package c.a.t0.d1.n2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.t0.d1.b1;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.f1;
import c.a.t0.d1.i1;
import c.a.t0.d1.n2.g.a;
import c.a.t0.g0.v;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public CardItemInfoDownloadLayout f16298b;

    /* renamed from: c  reason: collision with root package name */
    public CardItemInfoAlbumLayout f16299c;

    /* renamed from: d  reason: collision with root package name */
    public CardItemInfoTagLayout f16300d;

    /* renamed from: e  reason: collision with root package name */
    public CardItemInfoBriefLayout f16301e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f16302f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.d1.n2.a f16303g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.d1.n2.d f16304h;

    /* renamed from: i  reason: collision with root package name */
    public View f16305i;

    /* renamed from: j  reason: collision with root package name */
    public ItemCardDownloadButton f16306j;
    public TextView k;
    public View l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public CustomMessageListener o;
    public View.OnClickListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public HttpMessageListener s;

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                v.b().e(true);
            }
        }
    }

    /* renamed from: c.a.t0.d1.n2.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1042b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1042b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.a.f16306j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.s0.s.j0.p.b bVar = new c.a.s0.s.j0.p.b(8);
                    bVar.o(objTypeByDownloadMode);
                    bVar.n(c.a.s0.s.j0.p.c.a(this.a.f16306j.getCurrentItem().buttonLinkType.intValue(), this.a.f16306j.getCurrentItem().apkDetail != null ? this.a.f16306j.getCurrentItem().apkDetail.pkg_source.intValue() : 0));
                    bVar.l(str);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                Object tag = view.getTag(f1.item_data);
                if (tag instanceof c.a.s0.s.j0.p.a) {
                    ItemData a = ((c.a.s0.s.j0.p.a) tag).a();
                    if (ItemCardHelper.a.equals(a.buttonName) || ItemCardHelper.f40628b.equals(a.buttonName) || ItemCardHelper.f40632f.equals(a.buttonName)) {
                        c.a.s0.s.j0.p.b bVar = new c.a.s0.s.j0.p.b(8);
                        bVar.o(c.a.s0.s.j0.p.c.b(a.buttonName));
                        int intValue = a.buttonLinkType.intValue();
                        ApkDetail apkDetail = a.apkDetail;
                        bVar.n(c.a.s0.s.j0.p.c.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int objTypeByDownloadMode = this.a.f16306j.getObjTypeByDownloadMode();
                int a = c.a.s0.s.j0.p.c.a(this.a.f16306j.getCurrentItem().buttonLinkType.intValue(), this.a.f16306j.getCurrentItem().apkDetail != null ? this.a.f16306j.getCurrentItem().apkDetail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a == 4) {
                    return;
                }
                c.a.s0.s.j0.p.b bVar = new c.a.s0.s.j0.p.b(8);
                bVar.o(objTypeByDownloadMode);
                bVar.n(a);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || (playVoiceBnt = (PlayVoiceBnt) view.findViewById(f1.abstract_voice)) == null) {
                return;
            }
            playVoiceBnt.reset();
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.m = (String) customResponsedMessage.getData();
                ItemCardHelper.y(this.a.k, this.a.m);
                this.a.f16306j.setCustomColorBtn(c.a.t0.w3.c.d(this.a.m));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && (customResponsedMessage.getData() instanceof c.a.t0.d1.x2.a)) {
                    return;
                }
                c.a.t0.d1.x2.a aVar = (c.a.t0.d1.x2.a) customResponsedMessage.getData();
                if (aVar.f16763b == this.a.a.tabId) {
                    int i2 = aVar.f16764c;
                    if (i2 == 0 || i2 == 2) {
                        aVar.a = this.a.f16305i;
                    } else if (i2 == 1) {
                        aVar.a = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003516 && this.a.f16304h.f16314g.get(0).getType() == c.a.t0.d1.n2.g.d.f16336g) {
                int error = httpResponsedMessage.getError();
                GameCodeGetResponseMsg gameCodeGetResponseMsg = (GameCodeGetResponseMsg) httpResponsedMessage;
                if (httpResponsedMessage.getStatusCode() == 200 && error == 0 && gameCodeGetResponseMsg.errCode == 0) {
                    this.a.s(true, TbadkCoreApplication.getInst().getResources().getString(i1.get_game_code_success));
                    c.a.t0.d1.n2.h.a aVar = new c.a.t0.d1.n2.h.a(((GameCodeGetMsg) httpResponsedMessage.getOrginalMessage()).getPosition(), gameCodeGetResponseMsg.getCodeValue());
                    this.a.t(aVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921640, aVar));
                    return;
                }
                this.a.s(false, TbadkCoreApplication.getInst().getResources().getString(i1.get_game_code_fail));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.n = new a(this);
        this.o = new C1042b(this, 2921609);
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
        this.f16305i = view.findViewById(f1.frs_btn_order_or_download_layout);
        ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) view.findViewById(f1.frs_btn_order_download_btn);
        this.f16306j = itemCardDownloadButton;
        itemCardDownloadButton.setShadow(b1.S_O_X003);
        this.f16306j.useLongText();
        this.f16306j.setClickCallback(new d(this));
        this.o.setSelfListener(true);
        this.o.setTag(this.f16306j.getTag());
        MessageManager.getInstance().registerListener(this.o);
        TextView textView = (TextView) view.findViewById(f1.frs_btn_order_or_download);
        this.k = textView;
        textView.setOnClickListener(this.p);
        c.a.s0.s.u.c.d(this.k).u(b1.S_O_X003);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(f1.frs_item_tab_recycler_view);
        this.f16302f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f16302f.setFadingEdgeLength(0);
        this.f16302f.setOverScrollMode(2);
        this.f16302f.addOnScrollListener(this.n);
        this.f16302f.setRecyclerListener(new e(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f16302f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f16302f.getPaddingBottom());
        this.f16298b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.f16299c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.f16300d = new CardItemInfoTagLayout(frsItemTabFragment.getContext());
        this.f16301e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.f16303g = new c.a.t0.d1.n2.a(frsItemTabFragment, this.f16302f);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16302f.removeHeaderView(this.f16298b);
            this.f16302f.removeHeaderView(this.f16299c);
            this.f16302f.removeHeaderView(this.f16300d);
            this.f16302f.removeHeaderView(this.f16301e);
            c.a.t0.d1.n2.d dVar = this.f16304h;
            if (dVar == null) {
                return;
            }
            if (dVar.f16312e != null) {
                this.f16302f.addHeaderView(this.f16298b);
                this.f16298b.setData(this.f16304h.f16312e);
            }
            if (!ListUtils.isEmpty(this.f16304h.f16313f)) {
                this.f16302f.addHeaderView(this.f16299c);
                this.f16299c.setData(this.f16304h.f16313f);
            }
            ItemInfo itemInfo = this.f16304h.f16312e;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f16302f.addHeaderView(this.f16300d);
                this.f16300d.setData(this.f16304h.f16312e);
            }
            if (this.f16304h.f16312e != null) {
                this.f16302f.addHeaderView(this.f16301e);
                this.f16301e.setData(this.f16304h.f16312e);
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View view = this.f16305i;
            view.setPadding(view.getPaddingLeft(), this.f16305i.getPaddingTop(), this.f16305i.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(d1.tbds200) : this.f16305i.getPaddingBottom());
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.t0.d1.n2.a aVar = this.f16303g;
            if (aVar != null) {
                aVar.d();
            }
            this.f16298b.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f16299c.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f16300d.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f16301e.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f16306j.onChangeSkinType();
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.k);
            if (!ItemCardHelper.f40630d.contentEquals(this.k.getText()) && !ItemCardHelper.f40632f.contentEquals(this.k.getText())) {
                this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), c1.CAM_X0101));
                d2.n(i1.J_X01);
                d2.k(c1.transparent);
                d2.g(c.a.t0.w3.c.d(this.m));
            } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.k.setTextColor(c.a.t0.w3.c.a(c.a.t0.w3.c.d(this.m), c.a.s0.s.u.a.a(i1.A_X01)));
                d2.l(d1.tbds1);
                d2.t(c.a.t0.w3.c.a(c.a.t0.w3.c.d(this.m), c.a.s0.s.u.a.a(i1.A_X07)));
                d2.n(i1.J_X01);
                d2.f(c1.CAM_X0208);
            } else {
                c.a.s0.s.u.c.d(this.k).v(c1.CAM_X0103);
                d2.l(d1.tbds1);
                d2.k(c1.CAM_X0209);
                d2.n(i1.J_X01);
                d2.f(c1.CAM_X0209);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.t0.d1.n2.a aVar = this.f16303g;
            if (aVar != null) {
                aVar.f();
            }
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            c.a.t0.d1.x2.a aVar = new c.a.t0.d1.x2.a();
            aVar.f16763b = z ? this.a.tabId : 0;
            aVar.f16764c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void m(c.a.t0.d1.n2.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f16304h = dVar;
        h();
        if (dVar.f16315h) {
            a.b bVar = new a.b();
            bVar.e(this.m);
            ItemInfo itemInfo = dVar.f16312e;
            bVar.d(itemInfo != null ? itemInfo.id.intValue() : 0L);
            this.f16304h.f16314g.add(0, bVar.c());
        }
        if (dVar.f16312e != null) {
            ItemData itemData = new ItemData();
            itemData.parseProto(dVar.f16312e);
            c.a.s0.s.j0.p.a aVar = new c.a.s0.s.j0.p.a(itemData, 0, "");
            if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
                this.f16305i.setVisibility(0);
                this.f16306j.setVisibility(0);
                this.f16306j.setCustomColorBtn(c.a.t0.w3.c.d(this.m));
                this.f16306j.useOpenSpecialView();
                this.f16306j.setData(itemData, -1, this.a.forumName);
                int objTypeByDownloadMode = this.f16306j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.s0.s.j0.p.b bVar2 = new c.a.s0.s.j0.p.b(7);
                    bVar2.o(objTypeByDownloadMode);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar2));
                }
                r();
            } else {
                ItemCardHelper.m(this.k, aVar, this.m);
                if (!ItemCardHelper.f40631e.equals(itemData.buttonName)) {
                    c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.k);
                    if (!ItemCardHelper.f40630d.equals(itemData.buttonName) && !ItemCardHelper.f40632f.equals(itemData.buttonName)) {
                        this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), c1.CAM_X0101));
                        d2.n(i1.J_X01);
                        d2.k(c1.transparent);
                        d2.g(c.a.t0.w3.c.d(this.m));
                    } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        this.k.setTextColor(c.a.t0.w3.c.a(c.a.t0.w3.c.d(this.m), c.a.s0.s.u.a.a(i1.A_X01)));
                        d2.l(d1.tbds1);
                        d2.t(c.a.t0.w3.c.a(c.a.t0.w3.c.d(this.m), c.a.s0.s.u.a.a(i1.A_X07)));
                        d2.n(i1.J_X01);
                        d2.f(c1.CAM_X0208);
                    } else {
                        c.a.s0.s.u.c.d(this.k).v(c1.CAM_X0103);
                        d2.l(d1.tbds1);
                        d2.k(c1.CAM_X0209);
                        d2.n(i1.J_X01);
                        d2.f(c1.CAM_X0209);
                    }
                    this.f16305i.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(itemData.buttonName);
                    if (ItemCardHelper.f40632f.equals(itemData.buttonName)) {
                        this.k.setEnabled(false);
                    }
                    r();
                    if (ItemCardHelper.a.equals(itemData.buttonName) || ItemCardHelper.f40628b.equals(itemData.buttonName) || ItemCardHelper.f40632f.equals(itemData.buttonName)) {
                        c.a.s0.s.j0.p.b bVar3 = new c.a.s0.s.j0.p.b(7);
                        bVar3.o(c.a.s0.s.j0.p.c.b(itemData.buttonName));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar3));
                    }
                }
            }
        }
        this.f16303g.g(dVar.f16314g);
        this.f16303g.d();
    }

    public void n(BdUniqueId bdUniqueId) {
        c.a.t0.d1.n2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || (aVar = this.f16303g) == null) {
            return;
        }
        aVar.h(bdUniqueId);
    }

    public void o(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (bdTypeRecyclerView = this.f16302f) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
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
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdTypeRecyclerView = this.f16302f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.l == null) {
                this.l = new View(this.a.getContext());
                this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(d1.tbds200)));
            }
            this.f16302f.setFooterView(this.l);
        }
    }

    public void s(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, str) == null) {
            new BdTopToast(this.a.getContext()).setIcon(z).setContent(str).show((ViewGroup) ((Activity) this.a.getContext()).findViewById(16908290));
        }
    }

    public void t(c.a.t0.d1.n2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            ((c.a.t0.d1.n2.g.d) this.f16304h.f16314g.get(0)).f16337e--;
            List<GameCodeList> list = ((c.a.t0.d1.n2.g.d) this.f16304h.f16314g.get(0)).f16338f;
            GameCodeList gameCodeList = list.get(aVar.a);
            list.remove(aVar.a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = aVar.f16347b;
            builder.type = gameCodeList.type;
            builder.label = gameCodeList.label;
            builder.begin_time = gameCodeList.begin_time;
            builder.end_time = gameCodeList.end_time;
            builder.item_id = gameCodeList.item_id;
            builder.list_id = gameCodeList.list_id;
            GameCodeList build = builder.build(false);
            int i2 = aVar.a;
            while (i2 < list.size() && list.get(i2).claimed_status.intValue() == 1) {
                i2++;
            }
            while (i2 < list.size() && list.get(i2).end_time.intValue() < build.end_time.intValue() && list.get(i2).claimed_status.intValue() == 2) {
                i2++;
            }
            list.add(i2, build);
            this.f16303g.e();
        }
    }
}
