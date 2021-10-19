package c.a.r0.x0.b2;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.r0.b0.u;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
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
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ApkDetail;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsItemTabFragment f26675a;

    /* renamed from: b  reason: collision with root package name */
    public CardItemInfoDownloadLayout f26676b;

    /* renamed from: c  reason: collision with root package name */
    public CardItemInfoAlbumLayout f26677c;

    /* renamed from: d  reason: collision with root package name */
    public CardItemInfoTagLayout f26678d;

    /* renamed from: e  reason: collision with root package name */
    public CardItemInfoBriefLayout f26679e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f26680f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.x0.b2.a f26681g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.x0.b2.d f26682h;

    /* renamed from: i  reason: collision with root package name */
    public View f26683i;

    /* renamed from: j  reason: collision with root package name */
    public ItemCardDownloadButton f26684j;
    public TextView k;
    public View l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public CustomMessageListener o;
    public View.OnClickListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;

    /* loaded from: classes4.dex */
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
                u.b().e(true);
            }
        }
    }

    /* renamed from: c.a.r0.x0.b2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1254b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26685a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1254b(b bVar, int i2) {
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
            this.f26685a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.f26685a.f26684j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.q0.s.f0.p.b bVar = new c.a.q0.s.f0.p.b(8);
                    bVar.m(objTypeByDownloadMode);
                    bVar.l(c.a.q0.s.f0.p.c.a(this.f26685a.f26684j.getCurrentItem().buttonLinkType.intValue(), this.f26685a.f26684j.getCurrentItem().apkDetail != null ? this.f26685a.f26684j.getCurrentItem().apkDetail.pkg_source.intValue() : 0));
                    bVar.k(str);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                Object tag = view.getTag(R.id.item_data);
                if (tag instanceof c.a.q0.s.f0.p.a) {
                    ItemData a2 = ((c.a.q0.s.f0.p.a) tag).a();
                    if (ItemCardHelper.f47978a.equals(a2.buttonName) || ItemCardHelper.f47979b.equals(a2.buttonName) || ItemCardHelper.f47983f.equals(a2.buttonName)) {
                        c.a.q0.s.f0.p.b bVar = new c.a.q0.s.f0.p.b(8);
                        bVar.m(c.a.q0.s.f0.p.c.b(a2.buttonName));
                        int intValue = a2.buttonLinkType.intValue();
                        ApkDetail apkDetail = a2.apkDetail;
                        bVar.l(c.a.q0.s.f0.p.c.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26686a;

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
            this.f26686a = bVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int objTypeByDownloadMode = this.f26686a.f26684j.getObjTypeByDownloadMode();
                int a2 = c.a.q0.s.f0.p.c.a(this.f26686a.f26684j.getCurrentItem().buttonLinkType.intValue(), this.f26686a.f26684j.getCurrentItem().apkDetail != null ? this.f26686a.f26684j.getCurrentItem().apkDetail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a2 == 4) {
                    return;
                }
                c.a.q0.s.f0.p.b bVar = new c.a.q0.s.f0.p.b(8);
                bVar.m(objTypeByDownloadMode);
                bVar.l(a2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || (playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice)) == null) {
                return;
            }
            playVoiceBnt.reset();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26687a;

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
            this.f26687a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f26687a.m = (String) customResponsedMessage.getData();
                ItemCardHelper.y(this.f26687a.k, this.f26687a.m);
                this.f26687a.f26684j.setCustomColorBtn(c.a.r0.k3.c.c(this.f26687a.m));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26688a;

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
            this.f26688a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && (customResponsedMessage.getData() instanceof c.a.r0.x0.l2.a)) {
                    return;
                }
                c.a.r0.x0.l2.a aVar = (c.a.r0.x0.l2.a) customResponsedMessage.getData();
                if (aVar.f27193b == this.f26688a.f26675a.tabId) {
                    int i2 = aVar.f27194c;
                    if (i2 == 0 || i2 == 2) {
                        aVar.f27192a = this.f26688a.f26683i;
                    } else if (i2 == 1) {
                        aVar.f27192a = null;
                    }
                }
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
        this.o = new C1254b(this, 2921609);
        this.p = new c(this);
        this.q = new f(this, 2921591);
        g gVar = new g(this, 2921590);
        this.r = gVar;
        if (frsItemTabFragment == null || view == null) {
            return;
        }
        this.f26675a = frsItemTabFragment;
        gVar.setSelfListener(true);
        frsItemTabFragment.getBaseFragmentActivity().registerListener(this.r);
        frsItemTabFragment.registerListener(this.q);
        this.f26683i = view.findViewById(R.id.frs_btn_order_or_download_layout);
        ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) view.findViewById(R.id.frs_btn_order_download_btn);
        this.f26684j = itemCardDownloadButton;
        itemCardDownloadButton.setShadow(R.array.S_O_X003);
        this.f26684j.useLongText();
        this.f26684j.setClickCallback(new d(this));
        this.o.setSelfListener(true);
        this.o.setTag(this.f26684j.getTag());
        MessageManager.getInstance().registerListener(this.o);
        TextView textView = (TextView) view.findViewById(R.id.frs_btn_order_or_download);
        this.k = textView;
        textView.setOnClickListener(this.p);
        c.a.q0.s.u.c.d(this.k).u(R.array.S_O_X003);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_item_tab_recycler_view);
        this.f26680f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f26680f.setFadingEdgeLength(0);
        this.f26680f.setOverScrollMode(2);
        this.f26680f.addOnScrollListener(this.n);
        this.f26680f.setRecyclerListener(new e(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f26680f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f26680f.getPaddingBottom());
        this.f26676b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.f26677c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.f26678d = new CardItemInfoTagLayout(frsItemTabFragment.getContext());
        this.f26679e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.f26681g = new c.a.r0.x0.b2.a(frsItemTabFragment, this.f26680f);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26680f.removeHeaderView(this.f26676b);
            this.f26680f.removeHeaderView(this.f26677c);
            this.f26680f.removeHeaderView(this.f26678d);
            this.f26680f.removeHeaderView(this.f26679e);
            c.a.r0.x0.b2.d dVar = this.f26682h;
            if (dVar == null) {
                return;
            }
            if (dVar.f26694e != null) {
                this.f26680f.addHeaderView(this.f26676b);
                this.f26676b.setData(this.f26682h.f26694e);
            }
            if (!ListUtils.isEmpty(this.f26682h.f26695f)) {
                this.f26680f.addHeaderView(this.f26677c);
                this.f26677c.setData(this.f26682h.f26695f);
            }
            ItemInfo itemInfo = this.f26682h.f26694e;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f26680f.addHeaderView(this.f26678d);
                this.f26678d.setData(this.f26682h.f26694e);
            }
            if (this.f26682h.f26694e != null) {
                this.f26680f.addHeaderView(this.f26679e);
                this.f26679e.setData(this.f26682h.f26694e);
            }
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View view = this.f26683i;
            view.setPadding(view.getPaddingLeft(), this.f26683i.getPaddingTop(), this.f26683i.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(R.dimen.tbds200) : this.f26683i.getPaddingBottom());
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.x0.b2.a aVar = this.f26681g;
            if (aVar != null) {
                aVar.d();
            }
            this.f26676b.onChangeSkinType(this.f26675a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f26677c.onChangeSkinType(this.f26675a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f26678d.onChangeSkinType(this.f26675a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f26679e.onChangeSkinType(this.f26675a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f26684j.onChangeSkinType();
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.k);
            if (!ItemCardHelper.f47981d.contentEquals(this.k.getText()) && !ItemCardHelper.f47983f.contentEquals(this.k.getText())) {
                this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                d2.n(R.string.J_X01);
                d2.k(R.color.transparent);
                d2.g(c.a.r0.k3.c.c(this.m));
            } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.k.setTextColor(c.a.r0.k3.c.a(c.a.r0.k3.c.c(this.m), c.a.q0.s.u.a.a(R.string.A_X01)));
                d2.l(R.dimen.tbds1);
                d2.t(c.a.r0.k3.c.a(c.a.r0.k3.c.c(this.m), c.a.q0.s.u.a.a(R.string.A_X07)));
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0208);
            } else {
                c.a.q0.s.u.c.d(this.k).v(R.color.CAM_X0103);
                d2.l(R.dimen.tbds1);
                d2.k(R.color.CAM_X0209);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0209);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.x0.b2.a aVar = this.f26681g;
            if (aVar != null) {
                aVar.e();
            }
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            c.a.r0.x0.l2.a aVar = new c.a.r0.x0.l2.a();
            aVar.f27193b = z ? this.f26675a.tabId : 0;
            aVar.f27194c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.f26675a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void l(c.a.r0.x0.b2.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f26682h = dVar;
        g();
        if (dVar.f26694e != null) {
            ItemData itemData = new ItemData();
            itemData.parseProto(dVar.f26694e);
            c.a.q0.s.f0.p.a aVar = new c.a.q0.s.f0.p.a(itemData, 0, "");
            if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
                this.f26683i.setVisibility(0);
                this.f26684j.setVisibility(0);
                this.f26684j.setCustomColorBtn(c.a.r0.k3.c.c(this.m));
                this.f26684j.useOpenSpecialView();
                this.f26684j.setData(itemData, -1, this.f26675a.forumName);
                int objTypeByDownloadMode = this.f26684j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.q0.s.f0.p.b bVar = new c.a.q0.s.f0.p.b(7);
                    bVar.m(objTypeByDownloadMode);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
                p();
            } else {
                ItemCardHelper.m(this.k, aVar, this.m);
                if (!ItemCardHelper.f47982e.equals(itemData.buttonName)) {
                    c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.k);
                    if (!ItemCardHelper.f47981d.equals(itemData.buttonName) && !ItemCardHelper.f47983f.equals(itemData.buttonName)) {
                        this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                        d2.n(R.string.J_X01);
                        d2.k(R.color.transparent);
                        d2.g(c.a.r0.k3.c.c(this.m));
                    } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        this.k.setTextColor(c.a.r0.k3.c.a(c.a.r0.k3.c.c(this.m), c.a.q0.s.u.a.a(R.string.A_X01)));
                        d2.l(R.dimen.tbds1);
                        d2.t(c.a.r0.k3.c.a(c.a.r0.k3.c.c(this.m), c.a.q0.s.u.a.a(R.string.A_X07)));
                        d2.n(R.string.J_X01);
                        d2.f(R.color.CAM_X0208);
                    } else {
                        c.a.q0.s.u.c.d(this.k).v(R.color.CAM_X0103);
                        d2.l(R.dimen.tbds1);
                        d2.k(R.color.CAM_X0209);
                        d2.n(R.string.J_X01);
                        d2.f(R.color.CAM_X0209);
                    }
                    this.f26683i.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(itemData.buttonName);
                    if (ItemCardHelper.f47983f.equals(itemData.buttonName)) {
                        this.k.setEnabled(false);
                    }
                    p();
                    if (ItemCardHelper.f47978a.equals(itemData.buttonName) || ItemCardHelper.f47979b.equals(itemData.buttonName) || ItemCardHelper.f47983f.equals(itemData.buttonName)) {
                        c.a.q0.s.f0.p.b bVar2 = new c.a.q0.s.f0.p.b(7);
                        bVar2.m(c.a.q0.s.f0.p.c.b(itemData.buttonName));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar2));
                    }
                }
            }
        }
        this.f26681g.f(dVar.f26696g);
        this.f26681g.d();
    }

    public void m(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (bdTypeRecyclerView = this.f26680f) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.m = str;
        }
    }

    public void o(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdTypeRecyclerView = this.f26680f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.l == null) {
                this.l = new View(this.f26675a.getContext());
                this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds200)));
            }
            this.f26680f.setFooterView(this.l);
        }
    }
}
