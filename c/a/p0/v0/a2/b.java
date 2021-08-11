package c.a.p0.v0.a2;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.p0.a0.t;
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
import com.baidu.tbadk.core.view.ItemCardDownloadButton;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoAlbumLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoBriefLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoDownloadLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Item;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsItemTabFragment f25475a;

    /* renamed from: b  reason: collision with root package name */
    public CardItemInfoDownloadLayout f25476b;

    /* renamed from: c  reason: collision with root package name */
    public CardItemInfoAlbumLayout f25477c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.v0.a2.f.b f25478d;

    /* renamed from: e  reason: collision with root package name */
    public CardItemInfoBriefLayout f25479e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f25480f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.v0.a2.a f25481g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.v0.a2.d f25482h;

    /* renamed from: i  reason: collision with root package name */
    public View f25483i;

    /* renamed from: j  reason: collision with root package name */
    public ItemCardDownloadButton f25484j;
    public Button k;
    public View l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public View.OnClickListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes3.dex */
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

    /* renamed from: c.a.p0.v0.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1197b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnClickListenerC1197b(b bVar) {
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
                if (tag instanceof c.a.o0.s.f0.p.a) {
                    Item a2 = ((c.a.o0.s.f0.p.a) tag).a();
                    if (ItemCardHelper.f47731a.equals(a2.button_name) || ItemCardHelper.f47732b.equals(a2.button_name)) {
                        c.a.o0.s.f0.p.b bVar = new c.a.o0.s.f0.p.b(8);
                        bVar.j(ItemCardHelper.f47731a.equals(a2.button_name) ? 1 : 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25485a;

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
                    return;
                }
            }
            this.f25485a = bVar;
        }

        @Override // com.baidu.tbadk.core.view.ItemCardDownloadButton.e
        public void onClick(int i2) {
            int objTypeByDownloadMode;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (objTypeByDownloadMode = this.f25485a.f25484j.getObjTypeByDownloadMode()) <= 0) {
                return;
            }
            c.a.o0.s.f0.p.b bVar = new c.a.o0.s.f0.p.b(8);
            bVar.j(objTypeByDownloadMode);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25486e;

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
                    return;
                }
            }
            this.f25486e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GradientDrawable gradientDrawable = (GradientDrawable) this.f25486e.k.getBackground();
                gradientDrawable.setCornerRadius(this.f25486e.k.getHeight() / 2);
                this.f25486e.k.setBackgroundDrawable(gradientDrawable);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25487a;

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
            this.f25487a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f25487a.m = (String) customResponsedMessage.getData();
                ItemCardHelper.v(this.f25487a.k, this.f25487a.m);
                this.f25487a.f25484j.setCustomColorBtn(c.a.p0.i3.c.c(this.f25487a.m));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25488a;

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
            this.f25488a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && (customResponsedMessage.getData() instanceof c.a.p0.v0.k2.a)) {
                    return;
                }
                c.a.p0.v0.k2.a aVar = (c.a.p0.v0.k2.a) customResponsedMessage.getData();
                if (aVar.f25995b == this.f25488a.f25475a.tabId) {
                    int i2 = aVar.f25996c;
                    if (i2 == 0 || i2 == 2) {
                        aVar.f25994a = this.f25488a.f25483i;
                    } else if (i2 == 1) {
                        aVar.f25994a = null;
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
        this.o = new View$OnClickListenerC1197b(this);
        this.p = new f(this, 2921591);
        g gVar = new g(this, 2921590);
        this.q = gVar;
        if (frsItemTabFragment == null || view == null) {
            return;
        }
        this.f25475a = frsItemTabFragment;
        gVar.setSelfListener(true);
        frsItemTabFragment.getBaseFragmentActivity().registerListener(this.q);
        frsItemTabFragment.registerListener(this.p);
        this.f25483i = view.findViewById(R.id.frs_btn_order_or_download_layout);
        ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) view.findViewById(R.id.frs_btn_order_download_btn);
        this.f25484j = itemCardDownloadButton;
        itemCardDownloadButton.setClickCallback(new c(this));
        Button button = (Button) view.findViewById(R.id.frs_btn_order_or_download);
        this.k = button;
        button.setOnClickListener(this.o);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_item_tab_recycler_view);
        this.f25480f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f25480f.setFadingEdgeLength(0);
        this.f25480f.setOverScrollMode(2);
        this.f25480f.addOnScrollListener(this.n);
        this.f25480f.setRecyclerListener(new d(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f25480f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f25480f.getPaddingBottom());
        this.f25476b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.f25477c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.f25478d = new c.a.p0.v0.a2.f.b(frsItemTabFragment.getContext());
        this.f25479e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.f25481g = new c.a.p0.v0.a2.a(frsItemTabFragment, this.f25480f);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25480f.removeHeaderView(this.f25476b);
            this.f25480f.removeHeaderView(this.f25477c);
            this.f25480f.removeHeaderView(this.f25478d.a());
            this.f25480f.removeHeaderView(this.f25479e);
            c.a.p0.v0.a2.d dVar = this.f25482h;
            if (dVar == null) {
                return;
            }
            if (dVar.f25494e != null) {
                this.f25480f.addHeaderView(this.f25476b);
                this.f25476b.setData(this.f25482h.f25494e);
            }
            if (!ListUtils.isEmpty(this.f25482h.f25495f)) {
                this.f25480f.addHeaderView(this.f25477c);
                this.f25477c.setData(this.f25482h.f25495f);
            }
            ItemInfo itemInfo = this.f25482h.f25494e;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f25480f.addHeaderView(this.f25478d.a());
                this.f25478d.d(this.f25482h.f25494e);
            }
            if (this.f25482h.f25494e != null) {
                this.f25480f.addHeaderView(this.f25479e);
                this.f25479e.setData(this.f25482h.f25494e);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.v0.a2.a aVar = this.f25481g;
            if (aVar != null) {
                aVar.d();
            }
            this.f25476b.onChangeSkinType(this.f25475a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f25477c.onChangeSkinType(this.f25475a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f25478d.c();
            this.f25479e.onChangeSkinType(this.f25475a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f25484j.onChangeSkinType();
        }
    }

    public void i() {
        c.a.p0.v0.a2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f25481g) == null) {
            return;
        }
        aVar.e();
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c.a.p0.v0.k2.a aVar = new c.a.p0.v0.k2.a();
            aVar.f25995b = z ? this.f25475a.tabId : 0;
            aVar.f25996c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.f25475a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void k(c.a.p0.v0.a2.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f25482h = dVar;
        g();
        if (dVar.f25494e != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(c.a.e.e.m.b.f(String.valueOf(dVar.f25494e.id), 0L));
            ItemInfo itemInfo = dVar.f25494e;
            builder.forum_name = itemInfo.forum_name;
            builder.button_link = itemInfo.button_link;
            builder.button_link_type = itemInfo.button_link_type;
            builder.button_name = itemInfo.button_name;
            builder.item_name = itemInfo.name;
            builder.apk_name = itemInfo.apk_name;
            builder.apk_detail = itemInfo.apk_detail;
            c.a.o0.s.f0.p.a aVar = new c.a.o0.s.f0.p.a(builder.build(true), 0, "");
            Item a2 = aVar.a();
            if (ItemCardHelper.t(a2) && ItemCardHelper.m(a2)) {
                this.f25483i.setVisibility(0);
                this.f25484j.setVisibility(0);
                this.f25484j.setCustomColorBtn(c.a.p0.i3.c.c(this.m));
                this.f25484j.setData(a2);
                int objTypeByDownloadMode = this.f25484j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    c.a.o0.s.f0.p.b bVar = new c.a.o0.s.f0.p.b(7);
                    bVar.j(objTypeByDownloadMode);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
                o();
            } else {
                ItemCardHelper.k(this.k, aVar, this.m);
                Item a3 = aVar.a();
                if (!ItemCardHelper.f47734d.equals(a3.button_name)) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    if (ItemCardHelper.f47733c.equals(a3.button_name)) {
                        this.k.setTextColor(c.a.p0.i3.c.a(c.a.p0.i3.c.c(this.m), c.a.o0.s.u.a.a(R.string.A_X09)));
                        gradientDrawable.setStroke(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), c.a.p0.i3.c.a(c.a.p0.i3.c.c(this.m), c.a.o0.s.u.a.a(R.string.A_X09)));
                        gradientDrawable.setShape(0);
                        gradientDrawable.setColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0201));
                        this.k.setBackgroundDrawable(gradientDrawable);
                    } else {
                        this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                        gradientDrawable.setShape(0);
                        gradientDrawable.setColor(c.a.p0.i3.c.c(this.m));
                        this.k.setBackgroundDrawable(gradientDrawable);
                    }
                    this.k.post(new e(this));
                    this.f25483i.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(a3.button_name);
                    o();
                    if (ItemCardHelper.f47731a.equals(a3.button_name) || ItemCardHelper.f47732b.equals(a3.button_name)) {
                        c.a.o0.s.f0.p.b bVar2 = new c.a.o0.s.f0.p.b(7);
                        bVar2.j(ItemCardHelper.f47731a.equals(a3.button_name) ? 1 : 2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar2));
                    }
                }
            }
        }
        this.f25481g.f(dVar.f25496g);
        this.f25481g.d();
    }

    public void l(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (bdTypeRecyclerView = this.f25480f) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i2);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }

    public void n(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (bdTypeRecyclerView = this.f25480f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.l == null) {
                this.l = new View(this.f25475a.getContext());
                this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds200)));
            }
            this.f25480f.setFooterView(this.l);
        }
    }
}
