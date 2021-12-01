package c.a.r0.d1.m2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.r0.d1.b1;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.f1;
import c.a.r0.d1.i1;
import c.a.r0.g0.v;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;

    /* renamed from: b  reason: collision with root package name */
    public CardItemInfoDownloadLayout f15679b;

    /* renamed from: c  reason: collision with root package name */
    public CardItemInfoAlbumLayout f15680c;

    /* renamed from: d  reason: collision with root package name */
    public CardItemInfoTagLayout f15681d;

    /* renamed from: e  reason: collision with root package name */
    public CardItemInfoBriefLayout f15682e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f15683f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.d1.m2.a f15684g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.d1.m2.d f15685h;

    /* renamed from: i  reason: collision with root package name */
    public View f15686i;

    /* renamed from: j  reason: collision with root package name */
    public ItemCardDownloadButton f15687j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f15688k;
    public View l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public CustomMessageListener o;
    public View.OnClickListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public HttpMessageListener s;

    /* loaded from: classes5.dex */
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

    /* renamed from: c.a.r0.d1.m2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0951b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0951b(b bVar, int i2) {
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
                int objTypeByDownloadMode = this.a.f15687j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.q0.s.g0.p.b bVar = new c.a.q0.s.g0.p.b(8);
                    bVar.o(objTypeByDownloadMode);
                    bVar.n(c.a.q0.s.g0.p.c.a(this.a.f15687j.getCurrentItem().buttonLinkType.intValue(), this.a.f15687j.getCurrentItem().apkDetail != null ? this.a.f15687j.getCurrentItem().apkDetail.pkg_source.intValue() : 0));
                    bVar.l(str);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (tag instanceof c.a.q0.s.g0.p.a) {
                    ItemData a = ((c.a.q0.s.g0.p.a) tag).a();
                    if (ItemCardHelper.a.equals(a.buttonName) || ItemCardHelper.f41436b.equals(a.buttonName) || ItemCardHelper.f41440f.equals(a.buttonName)) {
                        c.a.q0.s.g0.p.b bVar = new c.a.q0.s.g0.p.b(8);
                        bVar.o(c.a.q0.s.g0.p.c.b(a.buttonName));
                        int intValue = a.buttonLinkType.intValue();
                        ApkDetail apkDetail = a.apkDetail;
                        bVar.n(c.a.q0.s.g0.p.c.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int objTypeByDownloadMode = this.a.f15687j.getObjTypeByDownloadMode();
                int a = c.a.q0.s.g0.p.c.a(this.a.f15687j.getCurrentItem().buttonLinkType.intValue(), this.a.f15687j.getCurrentItem().apkDetail != null ? this.a.f15687j.getCurrentItem().apkDetail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a == 4) {
                    return;
                }
                c.a.q0.s.g0.p.b bVar = new c.a.q0.s.g0.p.b(8);
                bVar.o(objTypeByDownloadMode);
                bVar.n(a);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                ItemCardHelper.y(this.a.f15688k, this.a.m);
                this.a.f15687j.setCustomColorBtn(c.a.r0.t3.c.d(this.a.m));
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (customResponsedMessage == null && (customResponsedMessage.getData() instanceof c.a.r0.d1.w2.a)) {
                    return;
                }
                c.a.r0.d1.w2.a aVar = (c.a.r0.d1.w2.a) customResponsedMessage.getData();
                if (aVar.f16139b == this.a.a.tabId) {
                    int i2 = aVar.f16140c;
                    if (i2 == 0 || i2 == 2) {
                        aVar.a = this.a.f15686i;
                    } else if (i2 == 1) {
                        aVar.a = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003516 && this.a.f15685h.f15696g.get(0).getType() == c.a.r0.d1.m2.g.c.f15714g) {
                int error = httpResponsedMessage.getError();
                GameCodeGetResponseMsg gameCodeGetResponseMsg = (GameCodeGetResponseMsg) httpResponsedMessage;
                if (httpResponsedMessage.getStatusCode() == 200 && error == 0 && gameCodeGetResponseMsg.errCode == 0) {
                    this.a.r(true, TbadkCoreApplication.getInst().getResources().getString(i1.get_game_code_success));
                    c.a.r0.d1.m2.h.a aVar = new c.a.r0.d1.m2.h.a(((GameCodeGetMsg) httpResponsedMessage.getOrginalMessage()).getPosition(), gameCodeGetResponseMsg.getCodeValue());
                    this.a.s(aVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921640, aVar));
                    return;
                }
                this.a.r(false, TbadkCoreApplication.getInst().getResources().getString(i1.get_game_code_fail));
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
        this.o = new C0951b(this, 2921609);
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
        this.f15686i = view.findViewById(f1.frs_btn_order_or_download_layout);
        ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) view.findViewById(f1.frs_btn_order_download_btn);
        this.f15687j = itemCardDownloadButton;
        itemCardDownloadButton.setShadow(b1.S_O_X003);
        this.f15687j.useLongText();
        this.f15687j.setClickCallback(new d(this));
        this.o.setSelfListener(true);
        this.o.setTag(this.f15687j.getTag());
        MessageManager.getInstance().registerListener(this.o);
        TextView textView = (TextView) view.findViewById(f1.frs_btn_order_or_download);
        this.f15688k = textView;
        textView.setOnClickListener(this.p);
        c.a.q0.s.u.c.d(this.f15688k).u(b1.S_O_X003);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(f1.frs_item_tab_recycler_view);
        this.f15683f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f15683f.setFadingEdgeLength(0);
        this.f15683f.setOverScrollMode(2);
        this.f15683f.addOnScrollListener(this.n);
        this.f15683f.setRecyclerListener(new e(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f15683f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f15683f.getPaddingBottom());
        this.f15679b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.f15680c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.f15681d = new CardItemInfoTagLayout(frsItemTabFragment.getContext());
        this.f15682e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.f15684g = new c.a.r0.d1.m2.a(frsItemTabFragment, this.f15683f);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f15683f.removeHeaderView(this.f15679b);
            this.f15683f.removeHeaderView(this.f15680c);
            this.f15683f.removeHeaderView(this.f15681d);
            this.f15683f.removeHeaderView(this.f15682e);
            c.a.r0.d1.m2.d dVar = this.f15685h;
            if (dVar == null) {
                return;
            }
            if (dVar.f15694e != null) {
                this.f15683f.addHeaderView(this.f15679b);
                this.f15679b.setData(this.f15685h.f15694e);
            }
            if (!ListUtils.isEmpty(this.f15685h.f15695f)) {
                this.f15683f.addHeaderView(this.f15680c);
                this.f15680c.setData(this.f15685h.f15695f);
            }
            ItemInfo itemInfo = this.f15685h.f15694e;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f15683f.addHeaderView(this.f15681d);
                this.f15681d.setData(this.f15685h.f15694e);
            }
            if (this.f15685h.f15694e != null) {
                this.f15683f.addHeaderView(this.f15682e);
                this.f15682e.setData(this.f15685h.f15694e);
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View view = this.f15686i;
            view.setPadding(view.getPaddingLeft(), this.f15686i.getPaddingTop(), this.f15686i.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(d1.tbds200) : this.f15686i.getPaddingBottom());
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.d1.m2.a aVar = this.f15684g;
            if (aVar != null) {
                aVar.d();
            }
            this.f15679b.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f15680c.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f15681d.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f15682e.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f15687j.onChangeSkinType();
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f15688k);
            if (!ItemCardHelper.f41438d.contentEquals(this.f15688k.getText()) && !ItemCardHelper.f41440f.contentEquals(this.f15688k.getText())) {
                this.f15688k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), c1.CAM_X0101));
                d2.n(i1.J_X01);
                d2.k(c1.transparent);
                d2.g(c.a.r0.t3.c.d(this.m));
            } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.f15688k.setTextColor(c.a.r0.t3.c.a(c.a.r0.t3.c.d(this.m), c.a.q0.s.u.a.a(i1.A_X01)));
                d2.l(d1.tbds1);
                d2.t(c.a.r0.t3.c.a(c.a.r0.t3.c.d(this.m), c.a.q0.s.u.a.a(i1.A_X07)));
                d2.n(i1.J_X01);
                d2.f(c1.CAM_X0208);
            } else {
                c.a.q0.s.u.c.d(this.f15688k).v(c1.CAM_X0103);
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
            c.a.r0.d1.m2.a aVar = this.f15684g;
            if (aVar != null) {
                aVar.f();
            }
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            c.a.r0.d1.w2.a aVar = new c.a.r0.d1.w2.a();
            aVar.f16139b = z ? this.a.tabId : 0;
            aVar.f16140c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void m(c.a.r0.d1.m2.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f15685h = dVar;
        h();
        if (dVar.f15694e != null) {
            ItemData itemData = new ItemData();
            itemData.parseProto(dVar.f15694e);
            c.a.q0.s.g0.p.a aVar = new c.a.q0.s.g0.p.a(itemData, 0, "");
            if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
                this.f15686i.setVisibility(0);
                this.f15687j.setVisibility(0);
                this.f15687j.setCustomColorBtn(c.a.r0.t3.c.d(this.m));
                this.f15687j.useOpenSpecialView();
                this.f15687j.setData(itemData, -1, this.a.forumName);
                int objTypeByDownloadMode = this.f15687j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.q0.s.g0.p.b bVar = new c.a.q0.s.g0.p.b(7);
                    bVar.o(objTypeByDownloadMode);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
                q();
            } else {
                ItemCardHelper.m(this.f15688k, aVar, this.m);
                if (!ItemCardHelper.f41439e.equals(itemData.buttonName)) {
                    c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f15688k);
                    if (!ItemCardHelper.f41438d.equals(itemData.buttonName) && !ItemCardHelper.f41440f.equals(itemData.buttonName)) {
                        this.f15688k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), c1.CAM_X0101));
                        d2.n(i1.J_X01);
                        d2.k(c1.transparent);
                        d2.g(c.a.r0.t3.c.d(this.m));
                    } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        this.f15688k.setTextColor(c.a.r0.t3.c.a(c.a.r0.t3.c.d(this.m), c.a.q0.s.u.a.a(i1.A_X01)));
                        d2.l(d1.tbds1);
                        d2.t(c.a.r0.t3.c.a(c.a.r0.t3.c.d(this.m), c.a.q0.s.u.a.a(i1.A_X07)));
                        d2.n(i1.J_X01);
                        d2.f(c1.CAM_X0208);
                    } else {
                        c.a.q0.s.u.c.d(this.f15688k).v(c1.CAM_X0103);
                        d2.l(d1.tbds1);
                        d2.k(c1.CAM_X0209);
                        d2.n(i1.J_X01);
                        d2.f(c1.CAM_X0209);
                    }
                    this.f15686i.setVisibility(0);
                    this.f15688k.setVisibility(0);
                    this.f15688k.setText(itemData.buttonName);
                    if (ItemCardHelper.f41440f.equals(itemData.buttonName)) {
                        this.f15688k.setEnabled(false);
                    }
                    q();
                    if (ItemCardHelper.a.equals(itemData.buttonName) || ItemCardHelper.f41436b.equals(itemData.buttonName) || ItemCardHelper.f41440f.equals(itemData.buttonName)) {
                        c.a.q0.s.g0.p.b bVar2 = new c.a.q0.s.g0.p.b(7);
                        bVar2.o(c.a.q0.s.g0.p.c.b(itemData.buttonName));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar2));
                    }
                }
            }
        }
        this.f15684g.g(dVar.f15696g);
        this.f15684g.d();
    }

    public void n(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (bdTypeRecyclerView = this.f15683f) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.m = str;
        }
    }

    public void p(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdTypeRecyclerView = this.f15683f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.l == null) {
                this.l = new View(this.a.getContext());
                this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(d1.tbds200)));
            }
            this.f15683f.setFooterView(this.l);
        }
    }

    public void r(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048586, this, z, str) == null) {
            new BdTopToast(this.a.getContext()).setIcon(z).setContent(str).show((ViewGroup) ((Activity) this.a.getContext()).findViewById(16908290));
        }
    }

    public void s(c.a.r0.d1.m2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            ((c.a.r0.d1.m2.g.c) this.f15685h.f15696g.get(0)).f15715e--;
            List<GameCodeList> list = ((c.a.r0.d1.m2.g.c) this.f15685h.f15696g.get(0)).f15716f;
            GameCodeList gameCodeList = list.get(aVar.a);
            list.remove(aVar.a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = aVar.f15725b;
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
            this.f15684g.e();
        }
    }
}
