package c.a.q0.v0.a2;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.q0.a0.t;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import tbclient.Item;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsItemTabFragment f25808a;

    /* renamed from: b  reason: collision with root package name */
    public CardItemInfoDownloadLayout f25809b;

    /* renamed from: c  reason: collision with root package name */
    public CardItemInfoAlbumLayout f25810c;

    /* renamed from: d  reason: collision with root package name */
    public CardItemInfoTagLayout f25811d;

    /* renamed from: e  reason: collision with root package name */
    public CardItemInfoBriefLayout f25812e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f25813f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.v0.a2.a f25814g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.v0.a2.d f25815h;

    /* renamed from: i  reason: collision with root package name */
    public View f25816i;

    /* renamed from: j  reason: collision with root package name */
    public ItemCardDownloadButton f25817j;
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
                t.b().e(true);
            }
        }
    }

    /* renamed from: c.a.q0.v0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1208b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25818a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1208b(b bVar, int i2) {
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
            this.f25818a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.f25818a.f25817j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.p0.s.f0.p.b bVar = new c.a.p0.s.f0.p.b(8);
                    bVar.m(objTypeByDownloadMode);
                    bVar.l(c.a.p0.s.f0.p.c.a(this.f25818a.f25817j.getCurrentItem().button_link_type.intValue(), this.f25818a.f25817j.getCurrentItem().apk_detail != null ? this.f25818a.f25817j.getCurrentItem().apk_detail.pkg_source.intValue() : 0));
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
                if (tag instanceof c.a.p0.s.f0.p.a) {
                    Item a2 = ((c.a.p0.s.f0.p.a) tag).a();
                    if (ItemCardHelper.f47828a.equals(a2.button_name) || ItemCardHelper.f47829b.equals(a2.button_name) || ItemCardHelper.f47833f.equals(a2.button_name)) {
                        c.a.p0.s.f0.p.b bVar = new c.a.p0.s.f0.p.b(8);
                        bVar.m(c.a.p0.s.f0.p.c.b(a2.button_name));
                        int intValue = a2.button_link_type.intValue();
                        ApkDetail apkDetail = a2.apk_detail;
                        bVar.l(c.a.p0.s.f0.p.c.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0));
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
        public final /* synthetic */ b f25819a;

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
            this.f25819a = bVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int objTypeByDownloadMode = this.f25819a.f25817j.getObjTypeByDownloadMode();
                int a2 = c.a.p0.s.f0.p.c.a(this.f25819a.f25817j.getCurrentItem().button_link_type.intValue(), this.f25819a.f25817j.getCurrentItem().apk_detail != null ? this.f25819a.f25817j.getCurrentItem().apk_detail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a2 == 4) {
                    return;
                }
                c.a.p0.s.f0.p.b bVar = new c.a.p0.s.f0.p.b(8);
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
        public final /* synthetic */ b f25820a;

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
            this.f25820a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f25820a.m = (String) customResponsedMessage.getData();
                ItemCardHelper.v(this.f25820a.k, this.f25820a.m);
                this.f25820a.f25817j.setCustomColorBtn(c.a.q0.i3.c.c(this.f25820a.m));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25821a;

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
            this.f25821a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && (customResponsedMessage.getData() instanceof c.a.q0.v0.k2.a)) {
                    return;
                }
                c.a.q0.v0.k2.a aVar = (c.a.q0.v0.k2.a) customResponsedMessage.getData();
                if (aVar.f26331b == this.f25821a.f25808a.tabId) {
                    int i2 = aVar.f26332c;
                    if (i2 == 0 || i2 == 2) {
                        aVar.f26330a = this.f25821a.f25816i;
                    } else if (i2 == 1) {
                        aVar.f26330a = null;
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
        this.o = new C1208b(this, 2921609);
        this.p = new c(this);
        this.q = new f(this, 2921591);
        g gVar = new g(this, 2921590);
        this.r = gVar;
        if (frsItemTabFragment == null || view == null) {
            return;
        }
        this.f25808a = frsItemTabFragment;
        gVar.setSelfListener(true);
        frsItemTabFragment.getBaseFragmentActivity().registerListener(this.r);
        frsItemTabFragment.registerListener(this.q);
        this.f25816i = view.findViewById(R.id.frs_btn_order_or_download_layout);
        ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) view.findViewById(R.id.frs_btn_order_download_btn);
        this.f25817j = itemCardDownloadButton;
        itemCardDownloadButton.setShadow(R.array.S_O_X003);
        this.f25817j.setClickCallback(new d(this));
        this.o.setSelfListener(true);
        this.o.setTag(this.f25817j.getTag());
        MessageManager.getInstance().registerListener(this.o);
        TextView textView = (TextView) view.findViewById(R.id.frs_btn_order_or_download);
        this.k = textView;
        textView.setOnClickListener(this.p);
        c.a.p0.s.u.c.d(this.k).t(R.array.S_O_X003);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_item_tab_recycler_view);
        this.f25813f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f25813f.setFadingEdgeLength(0);
        this.f25813f.setOverScrollMode(2);
        this.f25813f.addOnScrollListener(this.n);
        this.f25813f.setRecyclerListener(new e(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f25813f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f25813f.getPaddingBottom());
        this.f25809b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.f25810c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.f25811d = new CardItemInfoTagLayout(frsItemTabFragment.getContext());
        this.f25812e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.f25814g = new c.a.q0.v0.a2.a(frsItemTabFragment, this.f25813f);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25813f.removeHeaderView(this.f25809b);
            this.f25813f.removeHeaderView(this.f25810c);
            this.f25813f.removeHeaderView(this.f25811d);
            this.f25813f.removeHeaderView(this.f25812e);
            c.a.q0.v0.a2.d dVar = this.f25815h;
            if (dVar == null) {
                return;
            }
            if (dVar.f25827e != null) {
                this.f25813f.addHeaderView(this.f25809b);
                this.f25809b.setData(this.f25815h.f25827e);
            }
            if (!ListUtils.isEmpty(this.f25815h.f25828f)) {
                this.f25813f.addHeaderView(this.f25810c);
                this.f25810c.setData(this.f25815h.f25828f);
            }
            ItemInfo itemInfo = this.f25815h.f25827e;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f25813f.addHeaderView(this.f25811d);
                this.f25811d.setData(this.f25815h.f25827e);
            }
            if (this.f25815h.f25827e != null) {
                this.f25813f.addHeaderView(this.f25812e);
                this.f25812e.setData(this.f25815h.f25827e);
            }
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View view = this.f25816i;
            view.setPadding(view.getPaddingLeft(), this.f25816i.getPaddingTop(), this.f25816i.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(R.dimen.tbds200) : this.f25816i.getPaddingBottom());
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.v0.a2.a aVar = this.f25814g;
            if (aVar != null) {
                aVar.d();
            }
            this.f25809b.onChangeSkinType(this.f25808a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f25810c.onChangeSkinType(this.f25808a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f25811d.onChangeSkinType(this.f25808a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f25812e.onChangeSkinType(this.f25808a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f25817j.onChangeSkinType();
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.k);
            if (!ItemCardHelper.f47831d.contentEquals(this.k.getText()) && !ItemCardHelper.f47833f.contentEquals(this.k.getText())) {
                this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                d2.n(R.string.J_X01);
                d2.k(R.color.transparent);
                d2.g(c.a.q0.i3.c.c(this.m));
            } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.k.setTextColor(c.a.q0.i3.c.a(c.a.q0.i3.c.c(this.m), c.a.p0.s.u.a.a(R.string.A_X01)));
                d2.l(R.dimen.tbds1);
                d2.s(c.a.q0.i3.c.a(c.a.q0.i3.c.c(this.m), c.a.p0.s.u.a.a(R.string.A_X07)));
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0208);
            } else {
                c.a.p0.s.u.c.d(this.k).u(R.color.CAM_X0103);
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
            c.a.q0.v0.a2.a aVar = this.f25814g;
            if (aVar != null) {
                aVar.e();
            }
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            c.a.q0.v0.k2.a aVar = new c.a.q0.v0.k2.a();
            aVar.f26331b = z ? this.f25808a.tabId : 0;
            aVar.f26332c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.f25808a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void l(c.a.q0.v0.a2.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f25815h = dVar;
        g();
        if (dVar.f25827e != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(c.a.e.e.m.b.f(String.valueOf(dVar.f25827e.id), 0L));
            ItemInfo itemInfo = dVar.f25827e;
            builder.forum_name = itemInfo.forum_name;
            builder.button_link = itemInfo.button_link;
            builder.button_link_type = itemInfo.button_link_type;
            builder.button_name = itemInfo.button_name;
            builder.item_name = itemInfo.name;
            builder.apk_name = itemInfo.apk_name;
            builder.apk_detail = itemInfo.apk_detail;
            c.a.p0.s.f0.p.a aVar = new c.a.p0.s.f0.p.a(builder.build(true), 0, "");
            Item a2 = aVar.a();
            if (ItemCardHelper.t(a2) && ItemCardHelper.m(a2)) {
                this.f25816i.setVisibility(0);
                this.f25817j.setVisibility(0);
                this.f25817j.setCustomColorBtn(c.a.q0.i3.c.c(this.m));
                this.f25817j.setData(a2, -1, this.f25808a.forumName);
                int objTypeByDownloadMode = this.f25817j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.p0.s.f0.p.b bVar = new c.a.p0.s.f0.p.b(7);
                    bVar.m(objTypeByDownloadMode);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
                p();
            } else {
                ItemCardHelper.k(this.k, aVar, this.m);
                Item a3 = aVar.a();
                if (!ItemCardHelper.f47832e.equals(a3.button_name)) {
                    c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.k);
                    if (!ItemCardHelper.f47831d.equals(a3.button_name) && !ItemCardHelper.f47833f.equals(a3.button_name)) {
                        this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                        d2.n(R.string.J_X01);
                        d2.k(R.color.transparent);
                        d2.g(c.a.q0.i3.c.c(this.m));
                    } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        this.k.setTextColor(c.a.q0.i3.c.a(c.a.q0.i3.c.c(this.m), c.a.p0.s.u.a.a(R.string.A_X01)));
                        d2.l(R.dimen.tbds1);
                        d2.s(c.a.q0.i3.c.a(c.a.q0.i3.c.c(this.m), c.a.p0.s.u.a.a(R.string.A_X07)));
                        d2.n(R.string.J_X01);
                        d2.f(R.color.CAM_X0208);
                    } else {
                        c.a.p0.s.u.c.d(this.k).u(R.color.CAM_X0103);
                        d2.l(R.dimen.tbds1);
                        d2.k(R.color.CAM_X0209);
                        d2.n(R.string.J_X01);
                        d2.f(R.color.CAM_X0209);
                    }
                    this.f25816i.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(a3.button_name);
                    if (ItemCardHelper.f47833f.equals(a3.button_name)) {
                        this.k.setEnabled(false);
                    }
                    p();
                    if (ItemCardHelper.f47828a.equals(a3.button_name) || ItemCardHelper.f47829b.equals(a3.button_name) || ItemCardHelper.f47833f.equals(a3.button_name)) {
                        c.a.p0.s.f0.p.b bVar2 = new c.a.p0.s.f0.p.b(7);
                        bVar2.m(c.a.p0.s.f0.p.c.b(a3.button_name));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar2));
                    }
                }
            }
        }
        this.f25814g.f(dVar.f25829g);
        this.f25814g.d();
    }

    public void m(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (bdTypeRecyclerView = this.f25813f) == null) {
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
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdTypeRecyclerView = this.f25813f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.l == null) {
                this.l = new View(this.f25808a.getContext());
                this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds200)));
            }
            this.f25813f.setFooterView(this.l);
        }
    }
}
