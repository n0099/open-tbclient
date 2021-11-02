package b.a.r0.x0.l2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.r0.b0.u;
import b.a.r0.x0.a1;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.h1;
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

    /* renamed from: a  reason: collision with root package name */
    public FrsItemTabFragment f25928a;

    /* renamed from: b  reason: collision with root package name */
    public CardItemInfoDownloadLayout f25929b;

    /* renamed from: c  reason: collision with root package name */
    public CardItemInfoAlbumLayout f25930c;

    /* renamed from: d  reason: collision with root package name */
    public CardItemInfoTagLayout f25931d;

    /* renamed from: e  reason: collision with root package name */
    public CardItemInfoBriefLayout f25932e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f25933f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.x0.l2.a f25934g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.x0.l2.d f25935h;

    /* renamed from: i  reason: collision with root package name */
    public View f25936i;
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
                u.b().e(true);
            }
        }
    }

    /* renamed from: b.a.r0.x0.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1277b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25937a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1277b(b bVar, int i2) {
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
            this.f25937a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.f25937a.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    b.a.q0.s.g0.p.b bVar = new b.a.q0.s.g0.p.b(8);
                    bVar.n(objTypeByDownloadMode);
                    bVar.m(b.a.q0.s.g0.p.c.a(this.f25937a.j.getCurrentItem().buttonLinkType.intValue(), this.f25937a.j.getCurrentItem().apkDetail != null ? this.f25937a.j.getCurrentItem().apkDetail.pkg_source.intValue() : 0));
                    bVar.k(str);
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
                Object tag = view.getTag(e1.item_data);
                if (tag instanceof b.a.q0.s.g0.p.a) {
                    ItemData a2 = ((b.a.q0.s.g0.p.a) tag).a();
                    if (ItemCardHelper.f45539a.equals(a2.buttonName) || ItemCardHelper.f45540b.equals(a2.buttonName) || ItemCardHelper.f45544f.equals(a2.buttonName)) {
                        b.a.q0.s.g0.p.b bVar = new b.a.q0.s.g0.p.b(8);
                        bVar.n(b.a.q0.s.g0.p.c.b(a2.buttonName));
                        int intValue = a2.buttonLinkType.intValue();
                        ApkDetail apkDetail = a2.apkDetail;
                        bVar.m(b.a.q0.s.g0.p.c.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0));
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25938a;

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
            this.f25938a = bVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int objTypeByDownloadMode = this.f25938a.j.getObjTypeByDownloadMode();
                int a2 = b.a.q0.s.g0.p.c.a(this.f25938a.j.getCurrentItem().buttonLinkType.intValue(), this.f25938a.j.getCurrentItem().apkDetail != null ? this.f25938a.j.getCurrentItem().apkDetail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a2 == 4) {
                    return;
                }
                b.a.q0.s.g0.p.b bVar = new b.a.q0.s.g0.p.b(8);
                bVar.n(objTypeByDownloadMode);
                bVar.m(a2);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || (playVoiceBnt = (PlayVoiceBnt) view.findViewById(e1.abstract_voice)) == null) {
                return;
            }
            playVoiceBnt.reset();
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25939a;

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
            this.f25939a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f25939a.m = (String) customResponsedMessage.getData();
                ItemCardHelper.y(this.f25939a.k, this.f25939a.m);
                this.f25939a.j.setCustomColorBtn(b.a.r0.l3.c.c(this.f25939a.m));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25940a;

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
            this.f25940a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && (customResponsedMessage.getData() instanceof b.a.r0.x0.v2.a)) {
                    return;
                }
                b.a.r0.x0.v2.a aVar = (b.a.r0.x0.v2.a) customResponsedMessage.getData();
                if (aVar.f26449b == this.f25940a.f25928a.tabId) {
                    int i2 = aVar.f26450c;
                    if (i2 == 0 || i2 == 2) {
                        aVar.f26448a = this.f25940a.f25936i;
                    } else if (i2 == 1) {
                        aVar.f26448a = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f25941a;

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
            this.f25941a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003516 && this.f25941a.f25935h.f25949g.get(0).getType() == b.a.r0.x0.l2.g.c.f25964g) {
                int error = httpResponsedMessage.getError();
                GameCodeGetResponseMsg gameCodeGetResponseMsg = (GameCodeGetResponseMsg) httpResponsedMessage;
                if (httpResponsedMessage.getStatusCode() == 200 && error == 0 && gameCodeGetResponseMsg.errCode == 0) {
                    this.f25941a.r(true, TbadkCoreApplication.getInst().getResources().getString(h1.get_game_code_success));
                    b.a.r0.x0.l2.h.a aVar = new b.a.r0.x0.l2.h.a(((GameCodeGetMsg) httpResponsedMessage.getOrginalMessage()).getPosition(), gameCodeGetResponseMsg.getCodeValue());
                    this.f25941a.s(aVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921640, aVar));
                    return;
                }
                this.f25941a.r(false, TbadkCoreApplication.getInst().getResources().getString(h1.get_game_code_fail));
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
        this.o = new C1277b(this, 2921609);
        this.p = new c(this);
        this.q = new f(this, 2921591);
        this.r = new g(this, 2921590);
        this.s = new h(this, CmdConfigHttp.CMD_GET_GAME_CODE);
        if (frsItemTabFragment == null || view == null) {
            return;
        }
        this.f25928a = frsItemTabFragment;
        this.r.setSelfListener(true);
        frsItemTabFragment.getBaseFragmentActivity().registerListener(this.r);
        frsItemTabFragment.registerListener(this.q);
        frsItemTabFragment.registerListener(this.s);
        this.f25936i = view.findViewById(e1.frs_btn_order_or_download_layout);
        ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) view.findViewById(e1.frs_btn_order_download_btn);
        this.j = itemCardDownloadButton;
        itemCardDownloadButton.setShadow(a1.S_O_X003);
        this.j.useLongText();
        this.j.setClickCallback(new d(this));
        this.o.setSelfListener(true);
        this.o.setTag(this.j.getTag());
        MessageManager.getInstance().registerListener(this.o);
        TextView textView = (TextView) view.findViewById(e1.frs_btn_order_or_download);
        this.k = textView;
        textView.setOnClickListener(this.p);
        b.a.q0.s.u.c.d(this.k).u(a1.S_O_X003);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(e1.frs_item_tab_recycler_view);
        this.f25933f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f25933f.setFadingEdgeLength(0);
        this.f25933f.setOverScrollMode(2);
        this.f25933f.addOnScrollListener(this.n);
        this.f25933f.setRecyclerListener(new e(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(c1.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f25933f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f25933f.getPaddingBottom());
        this.f25929b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.f25930c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.f25931d = new CardItemInfoTagLayout(frsItemTabFragment.getContext());
        this.f25932e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.f25934g = new b.a.r0.x0.l2.a(frsItemTabFragment, this.f25933f);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25933f.removeHeaderView(this.f25929b);
            this.f25933f.removeHeaderView(this.f25930c);
            this.f25933f.removeHeaderView(this.f25931d);
            this.f25933f.removeHeaderView(this.f25932e);
            b.a.r0.x0.l2.d dVar = this.f25935h;
            if (dVar == null) {
                return;
            }
            if (dVar.f25947e != null) {
                this.f25933f.addHeaderView(this.f25929b);
                this.f25929b.setData(this.f25935h.f25947e);
            }
            if (!ListUtils.isEmpty(this.f25935h.f25948f)) {
                this.f25933f.addHeaderView(this.f25930c);
                this.f25930c.setData(this.f25935h.f25948f);
            }
            ItemInfo itemInfo = this.f25935h.f25947e;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f25933f.addHeaderView(this.f25931d);
                this.f25931d.setData(this.f25935h.f25947e);
            }
            if (this.f25935h.f25947e != null) {
                this.f25933f.addHeaderView(this.f25932e);
                this.f25932e.setData(this.f25935h.f25947e);
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View view = this.f25936i;
            view.setPadding(view.getPaddingLeft(), this.f25936i.getPaddingTop(), this.f25936i.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(c1.tbds200) : this.f25936i.getPaddingBottom());
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.r0.x0.l2.a aVar = this.f25934g;
            if (aVar != null) {
                aVar.d();
            }
            this.f25929b.onChangeSkinType(this.f25928a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f25930c.onChangeSkinType(this.f25928a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f25931d.onChangeSkinType(this.f25928a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f25932e.onChangeSkinType(this.f25928a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.j.onChangeSkinType();
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.k);
            if (!ItemCardHelper.f45542d.contentEquals(this.k.getText()) && !ItemCardHelper.f45544f.contentEquals(this.k.getText())) {
                this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), b1.CAM_X0101));
                d2.n(h1.J_X01);
                d2.k(b1.transparent);
                d2.g(b.a.r0.l3.c.c(this.m));
            } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.k.setTextColor(b.a.r0.l3.c.a(b.a.r0.l3.c.c(this.m), b.a.q0.s.u.a.a(h1.A_X01)));
                d2.l(c1.tbds1);
                d2.t(b.a.r0.l3.c.a(b.a.r0.l3.c.c(this.m), b.a.q0.s.u.a.a(h1.A_X07)));
                d2.n(h1.J_X01);
                d2.f(b1.CAM_X0208);
            } else {
                b.a.q0.s.u.c.d(this.k).v(b1.CAM_X0103);
                d2.l(c1.tbds1);
                d2.k(b1.CAM_X0209);
                d2.n(h1.J_X01);
                d2.f(b1.CAM_X0209);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.r0.x0.l2.a aVar = this.f25934g;
            if (aVar != null) {
                aVar.f();
            }
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            b.a.r0.x0.v2.a aVar = new b.a.r0.x0.v2.a();
            aVar.f26449b = z ? this.f25928a.tabId : 0;
            aVar.f26450c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.f25928a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void m(b.a.r0.x0.l2.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f25935h = dVar;
        h();
        if (dVar.f25947e != null) {
            ItemData itemData = new ItemData();
            itemData.parseProto(dVar.f25947e);
            b.a.q0.s.g0.p.a aVar = new b.a.q0.s.g0.p.a(itemData, 0, "");
            if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
                this.f25936i.setVisibility(0);
                this.j.setVisibility(0);
                this.j.setCustomColorBtn(b.a.r0.l3.c.c(this.m));
                this.j.useOpenSpecialView();
                this.j.setData(itemData, -1, this.f25928a.forumName);
                int objTypeByDownloadMode = this.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    b.a.q0.s.g0.p.b bVar = new b.a.q0.s.g0.p.b(7);
                    bVar.n(objTypeByDownloadMode);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
                q();
            } else {
                ItemCardHelper.m(this.k, aVar, this.m);
                if (!ItemCardHelper.f45543e.equals(itemData.buttonName)) {
                    b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.k);
                    if (!ItemCardHelper.f45542d.equals(itemData.buttonName) && !ItemCardHelper.f45544f.equals(itemData.buttonName)) {
                        this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), b1.CAM_X0101));
                        d2.n(h1.J_X01);
                        d2.k(b1.transparent);
                        d2.g(b.a.r0.l3.c.c(this.m));
                    } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        this.k.setTextColor(b.a.r0.l3.c.a(b.a.r0.l3.c.c(this.m), b.a.q0.s.u.a.a(h1.A_X01)));
                        d2.l(c1.tbds1);
                        d2.t(b.a.r0.l3.c.a(b.a.r0.l3.c.c(this.m), b.a.q0.s.u.a.a(h1.A_X07)));
                        d2.n(h1.J_X01);
                        d2.f(b1.CAM_X0208);
                    } else {
                        b.a.q0.s.u.c.d(this.k).v(b1.CAM_X0103);
                        d2.l(c1.tbds1);
                        d2.k(b1.CAM_X0209);
                        d2.n(h1.J_X01);
                        d2.f(b1.CAM_X0209);
                    }
                    this.f25936i.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(itemData.buttonName);
                    if (ItemCardHelper.f45544f.equals(itemData.buttonName)) {
                        this.k.setEnabled(false);
                    }
                    q();
                    if (ItemCardHelper.f45539a.equals(itemData.buttonName) || ItemCardHelper.f45540b.equals(itemData.buttonName) || ItemCardHelper.f45544f.equals(itemData.buttonName)) {
                        b.a.q0.s.g0.p.b bVar2 = new b.a.q0.s.g0.p.b(7);
                        bVar2.n(b.a.q0.s.g0.p.c.b(itemData.buttonName));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar2));
                    }
                }
            }
        }
        this.f25934g.g(dVar.f25949g);
        this.f25934g.d();
    }

    public void n(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (bdTypeRecyclerView = this.f25933f) == null) {
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
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdTypeRecyclerView = this.f25933f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.l == null) {
                this.l = new View(this.f25928a.getContext());
                this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(c1.tbds200)));
            }
            this.f25933f.setFooterView(this.l);
        }
    }

    public void r(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048586, this, z, str) == null) {
            new BdTopToast(this.f25928a.getContext()).setIcon(z).setContent(str).show((ViewGroup) ((Activity) this.f25928a.getContext()).findViewById(16908290));
        }
    }

    public void s(b.a.r0.x0.l2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            ((b.a.r0.x0.l2.g.c) this.f25935h.f25949g.get(0)).f25965e--;
            List<GameCodeList> list = ((b.a.r0.x0.l2.g.c) this.f25935h.f25949g.get(0)).f25966f;
            GameCodeList gameCodeList = list.get(aVar.f25976a);
            list.remove(aVar.f25976a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = aVar.f25977b;
            builder.type = gameCodeList.type;
            builder.label = gameCodeList.label;
            builder.begin_time = gameCodeList.begin_time;
            builder.end_time = gameCodeList.end_time;
            builder.item_id = gameCodeList.item_id;
            builder.list_id = gameCodeList.list_id;
            GameCodeList build = builder.build(false);
            int i2 = aVar.f25976a;
            while (i2 < list.size() && list.get(i2).claimed_status.intValue() == 1) {
                i2++;
            }
            while (i2 < list.size() && list.get(i2).end_time.intValue() < build.end_time.intValue() && list.get(i2).claimed_status.intValue() == 2) {
                i2++;
            }
            list.add(i2, build);
            this.f25934g.e();
        }
    }
}
