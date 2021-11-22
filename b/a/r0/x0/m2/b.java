package b.a.r0.x0.m2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.r0.b0.v;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.i1;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsItemTabFragment f27530a;

    /* renamed from: b  reason: collision with root package name */
    public CardItemInfoDownloadLayout f27531b;

    /* renamed from: c  reason: collision with root package name */
    public CardItemInfoAlbumLayout f27532c;

    /* renamed from: d  reason: collision with root package name */
    public CardItemInfoTagLayout f27533d;

    /* renamed from: e  reason: collision with root package name */
    public CardItemInfoBriefLayout f27534e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f27535f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.x0.m2.a f27536g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.x0.m2.d f27537h;

    /* renamed from: i  reason: collision with root package name */
    public View f27538i;
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

    /* loaded from: classes6.dex */
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

    /* renamed from: b.a.r0.x0.m2.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1350b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27539a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1350b(b bVar, int i2) {
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
            this.f27539a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.f27539a.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    b.a.q0.s.g0.p.b bVar = new b.a.q0.s.g0.p.b(8);
                    bVar.n(objTypeByDownloadMode);
                    bVar.m(b.a.q0.s.g0.p.c.a(this.f27539a.j.getCurrentItem().buttonLinkType.intValue(), this.f27539a.j.getCurrentItem().apkDetail != null ? this.f27539a.j.getCurrentItem().apkDetail.pkg_source.intValue() : 0));
                    bVar.k(str);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (tag instanceof b.a.q0.s.g0.p.a) {
                    ItemData a2 = ((b.a.q0.s.g0.p.a) tag).a();
                    if (ItemCardHelper.f46389a.equals(a2.buttonName) || ItemCardHelper.f46390b.equals(a2.buttonName) || ItemCardHelper.f46394f.equals(a2.buttonName)) {
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

    /* loaded from: classes6.dex */
    public class d implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27540a;

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
            this.f27540a = bVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int objTypeByDownloadMode = this.f27540a.j.getObjTypeByDownloadMode();
                int a2 = b.a.q0.s.g0.p.c.a(this.f27540a.j.getCurrentItem().buttonLinkType.intValue(), this.f27540a.j.getCurrentItem().apkDetail != null ? this.f27540a.j.getCurrentItem().apkDetail.pkg_source.intValue() : 0);
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27541a;

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
            this.f27541a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f27541a.m = (String) customResponsedMessage.getData();
                ItemCardHelper.y(this.f27541a.k, this.f27541a.m);
                this.f27541a.j.setCustomColorBtn(b.a.r0.m3.c.c(this.f27541a.m));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27542a;

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
            this.f27542a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && (customResponsedMessage.getData() instanceof b.a.r0.x0.w2.a)) {
                    return;
                }
                b.a.r0.x0.w2.a aVar = (b.a.r0.x0.w2.a) customResponsedMessage.getData();
                if (aVar.f28049b == this.f27542a.f27530a.tabId) {
                    int i2 = aVar.f28050c;
                    if (i2 == 0 || i2 == 2) {
                        aVar.f28048a = this.f27542a.f27538i;
                    } else if (i2 == 1) {
                        aVar.f28048a = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f27543a;

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
            this.f27543a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003516 && this.f27543a.f27537h.f27551g.get(0).getType() == b.a.r0.x0.m2.g.c.f27566g) {
                int error = httpResponsedMessage.getError();
                GameCodeGetResponseMsg gameCodeGetResponseMsg = (GameCodeGetResponseMsg) httpResponsedMessage;
                if (httpResponsedMessage.getStatusCode() == 200 && error == 0 && gameCodeGetResponseMsg.errCode == 0) {
                    this.f27543a.r(true, TbadkCoreApplication.getInst().getResources().getString(i1.get_game_code_success));
                    b.a.r0.x0.m2.h.a aVar = new b.a.r0.x0.m2.h.a(((GameCodeGetMsg) httpResponsedMessage.getOrginalMessage()).getPosition(), gameCodeGetResponseMsg.getCodeValue());
                    this.f27543a.s(aVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921640, aVar));
                    return;
                }
                this.f27543a.r(false, TbadkCoreApplication.getInst().getResources().getString(i1.get_game_code_fail));
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
        this.o = new C1350b(this, 2921609);
        this.p = new c(this);
        this.q = new f(this, 2921591);
        this.r = new g(this, 2921590);
        this.s = new h(this, CmdConfigHttp.CMD_GET_GAME_CODE);
        if (frsItemTabFragment == null || view == null) {
            return;
        }
        this.f27530a = frsItemTabFragment;
        this.r.setSelfListener(true);
        frsItemTabFragment.getBaseFragmentActivity().registerListener(this.r);
        frsItemTabFragment.registerListener(this.q);
        frsItemTabFragment.registerListener(this.s);
        this.f27538i = view.findViewById(f1.frs_btn_order_or_download_layout);
        ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) view.findViewById(f1.frs_btn_order_download_btn);
        this.j = itemCardDownloadButton;
        itemCardDownloadButton.setShadow(b1.S_O_X003);
        this.j.useLongText();
        this.j.setClickCallback(new d(this));
        this.o.setSelfListener(true);
        this.o.setTag(this.j.getTag());
        MessageManager.getInstance().registerListener(this.o);
        TextView textView = (TextView) view.findViewById(f1.frs_btn_order_or_download);
        this.k = textView;
        textView.setOnClickListener(this.p);
        b.a.q0.s.u.c.d(this.k).u(b1.S_O_X003);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(f1.frs_item_tab_recycler_view);
        this.f27535f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f27535f.setFadingEdgeLength(0);
        this.f27535f.setOverScrollMode(2);
        this.f27535f.addOnScrollListener(this.n);
        this.f27535f.setRecyclerListener(new e(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f27535f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f27535f.getPaddingBottom());
        this.f27531b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.f27532c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.f27533d = new CardItemInfoTagLayout(frsItemTabFragment.getContext());
        this.f27534e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.f27536g = new b.a.r0.x0.m2.a(frsItemTabFragment, this.f27535f);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f27535f.removeHeaderView(this.f27531b);
            this.f27535f.removeHeaderView(this.f27532c);
            this.f27535f.removeHeaderView(this.f27533d);
            this.f27535f.removeHeaderView(this.f27534e);
            b.a.r0.x0.m2.d dVar = this.f27537h;
            if (dVar == null) {
                return;
            }
            if (dVar.f27549e != null) {
                this.f27535f.addHeaderView(this.f27531b);
                this.f27531b.setData(this.f27537h.f27549e);
            }
            if (!ListUtils.isEmpty(this.f27537h.f27550f)) {
                this.f27535f.addHeaderView(this.f27532c);
                this.f27532c.setData(this.f27537h.f27550f);
            }
            ItemInfo itemInfo = this.f27537h.f27549e;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f27535f.addHeaderView(this.f27533d);
                this.f27533d.setData(this.f27537h.f27549e);
            }
            if (this.f27537h.f27549e != null) {
                this.f27535f.addHeaderView(this.f27534e);
                this.f27534e.setData(this.f27537h.f27549e);
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View view = this.f27538i;
            view.setPadding(view.getPaddingLeft(), this.f27538i.getPaddingTop(), this.f27538i.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(d1.tbds200) : this.f27538i.getPaddingBottom());
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.r0.x0.m2.a aVar = this.f27536g;
            if (aVar != null) {
                aVar.d();
            }
            this.f27531b.onChangeSkinType(this.f27530a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f27532c.onChangeSkinType(this.f27530a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f27533d.onChangeSkinType(this.f27530a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f27534e.onChangeSkinType(this.f27530a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.j.onChangeSkinType();
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.k);
            if (!ItemCardHelper.f46392d.contentEquals(this.k.getText()) && !ItemCardHelper.f46394f.contentEquals(this.k.getText())) {
                this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), c1.CAM_X0101));
                d2.n(i1.J_X01);
                d2.k(c1.transparent);
                d2.g(b.a.r0.m3.c.c(this.m));
            } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.k.setTextColor(b.a.r0.m3.c.a(b.a.r0.m3.c.c(this.m), b.a.q0.s.u.a.a(i1.A_X01)));
                d2.l(d1.tbds1);
                d2.t(b.a.r0.m3.c.a(b.a.r0.m3.c.c(this.m), b.a.q0.s.u.a.a(i1.A_X07)));
                d2.n(i1.J_X01);
                d2.f(c1.CAM_X0208);
            } else {
                b.a.q0.s.u.c.d(this.k).v(c1.CAM_X0103);
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
            b.a.r0.x0.m2.a aVar = this.f27536g;
            if (aVar != null) {
                aVar.f();
            }
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            b.a.r0.x0.w2.a aVar = new b.a.r0.x0.w2.a();
            aVar.f28049b = z ? this.f27530a.tabId : 0;
            aVar.f28050c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.f27530a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, aVar);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void m(b.a.r0.x0.m2.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        this.f27537h = dVar;
        h();
        if (dVar.f27549e != null) {
            ItemData itemData = new ItemData();
            itemData.parseProto(dVar.f27549e);
            b.a.q0.s.g0.p.a aVar = new b.a.q0.s.g0.p.a(itemData, 0, "");
            if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
                this.f27538i.setVisibility(0);
                this.j.setVisibility(0);
                this.j.setCustomColorBtn(b.a.r0.m3.c.c(this.m));
                this.j.useOpenSpecialView();
                this.j.setData(itemData, -1, this.f27530a.forumName);
                int objTypeByDownloadMode = this.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    b.a.q0.s.g0.p.b bVar = new b.a.q0.s.g0.p.b(7);
                    bVar.n(objTypeByDownloadMode);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar));
                }
                q();
            } else {
                ItemCardHelper.m(this.k, aVar, this.m);
                if (!ItemCardHelper.f46393e.equals(itemData.buttonName)) {
                    b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.k);
                    if (!ItemCardHelper.f46392d.equals(itemData.buttonName) && !ItemCardHelper.f46394f.equals(itemData.buttonName)) {
                        this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), c1.CAM_X0101));
                        d2.n(i1.J_X01);
                        d2.k(c1.transparent);
                        d2.g(b.a.r0.m3.c.c(this.m));
                    } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        this.k.setTextColor(b.a.r0.m3.c.a(b.a.r0.m3.c.c(this.m), b.a.q0.s.u.a.a(i1.A_X01)));
                        d2.l(d1.tbds1);
                        d2.t(b.a.r0.m3.c.a(b.a.r0.m3.c.c(this.m), b.a.q0.s.u.a.a(i1.A_X07)));
                        d2.n(i1.J_X01);
                        d2.f(c1.CAM_X0208);
                    } else {
                        b.a.q0.s.u.c.d(this.k).v(c1.CAM_X0103);
                        d2.l(d1.tbds1);
                        d2.k(c1.CAM_X0209);
                        d2.n(i1.J_X01);
                        d2.f(c1.CAM_X0209);
                    }
                    this.f27538i.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(itemData.buttonName);
                    if (ItemCardHelper.f46394f.equals(itemData.buttonName)) {
                        this.k.setEnabled(false);
                    }
                    q();
                    if (ItemCardHelper.f46389a.equals(itemData.buttonName) || ItemCardHelper.f46390b.equals(itemData.buttonName) || ItemCardHelper.f46394f.equals(itemData.buttonName)) {
                        b.a.q0.s.g0.p.b bVar2 = new b.a.q0.s.g0.p.b(7);
                        bVar2.n(b.a.q0.s.g0.p.c.b(itemData.buttonName));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, bVar2));
                    }
                }
            }
        }
        this.f27536g.g(dVar.f27551g);
        this.f27536g.d();
    }

    public void n(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (bdTypeRecyclerView = this.f27535f) == null) {
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
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdTypeRecyclerView = this.f27535f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.l == null) {
                this.l = new View(this.f27530a.getContext());
                this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(d1.tbds200)));
            }
            this.f27535f.setFooterView(this.l);
        }
    }

    public void r(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048586, this, z, str) == null) {
            new BdTopToast(this.f27530a.getContext()).setIcon(z).setContent(str).show((ViewGroup) ((Activity) this.f27530a.getContext()).findViewById(16908290));
        }
    }

    public void s(b.a.r0.x0.m2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            ((b.a.r0.x0.m2.g.c) this.f27537h.f27551g.get(0)).f27567e--;
            List<GameCodeList> list = ((b.a.r0.x0.m2.g.c) this.f27537h.f27551g.get(0)).f27568f;
            GameCodeList gameCodeList = list.get(aVar.f27578a);
            list.remove(aVar.f27578a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = aVar.f27579b;
            builder.type = gameCodeList.type;
            builder.label = gameCodeList.label;
            builder.begin_time = gameCodeList.begin_time;
            builder.end_time = gameCodeList.end_time;
            builder.item_id = gameCodeList.item_id;
            builder.list_id = gameCodeList.list_id;
            GameCodeList build = builder.build(false);
            int i2 = aVar.f27578a;
            while (i2 < list.size() && list.get(i2).claimed_status.intValue() == 1) {
                i2++;
            }
            while (i2 < list.size() && list.get(i2).end_time.intValue() < build.end_time.intValue() && list.get(i2).claimed_status.intValue() == 2) {
                i2++;
            }
            list.add(i2, build);
            this.f27536g.e();
        }
    }
}
