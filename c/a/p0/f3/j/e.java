package c.a.p0.f3.j;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.z1;
import c.a.p0.f3.j.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<Object> f17880e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f17881f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.f3.j.f f17882g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<z1> f17883h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<f.b> f17884i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<f.a> f17885j;
    public c.a.p0.f3.k.a k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f17886e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17886e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f17886e.f17880e.getPageActivity(), "square_bottom_find_more", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                this.f17886e.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f17887e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f17888f;

        public b(e eVar, f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17888f = eVar;
            this.f17887e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f17888f.f17881f, "square_category_more", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f17887e.m));
                UrlManager.getInstance().dealOneLink(this.f17888f.f17880e, new String[]{this.f17887e.l});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f17889e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f17890f;

        public c(e eVar, f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17890f = eVar;
            this.f17889e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f17890f.f17881f, "square_module_menu", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f17889e.n));
                UrlManager.getInstance().dealOneLink(this.f17890f.f17880e, new String[]{this.f17889e.l});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f17891e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f17892f;

        public d(e eVar, f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17892f = eVar;
            this.f17891e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f17892f.f17881f, "square_module_entry", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f17891e.m), "loc", Integer.valueOf(this.f17891e.n));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f17892f.f17880e.getPageActivity()).createNormalCfg(this.f17891e.f17922e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    /* renamed from: c.a.p0.f3.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0867e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f17893e;

        public View$OnClickListenerC0867e(e eVar, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17893e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17893e.m.performClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f17894e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f17895f;

        public f(e eVar, f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17895f = eVar;
            this.f17894e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f17895f.f17881f, "square_module_content", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f17894e.m), "loc", Integer.valueOf(this.f17894e.n));
                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.f17895f.f17880e.getPageActivity();
                    messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, this.f17894e.f17921d + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f17895f.f17880e.getPageActivity()).createNormalCfg(this.f17894e.f17922e, FrsActivityConfig.FRS_FROM_SQUARE)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.a f17896e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f17897f;

        public g(e eVar, f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17897f = eVar;
            this.f17896e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17896e.f17917d) {
                    this.f17897f.g();
                } else {
                    UrlManager.getInstance().dealOneLink(this.f17897f.f17880e, new String[]{this.f17896e.f17915b});
                }
                if (view.getTag() instanceof Integer) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    Activity activity = this.f17897f.f17881f;
                    TiebaStatic.eventStat(activity, "square_entry_content", PrefetchEvent.STATE_CLICK, 1, "loc", "" + intValue);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f17898a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17899b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17900c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17901d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17902e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17903f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17904g;

        /* renamed from: h  reason: collision with root package name */
        public View f17905h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f17906i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f17907j;
        public TextView k;
        public LinearLayout l;
        public TextView m;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    public e(TbPageContext<Object> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        if (tbPageContext == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f17880e = tbPageContext;
        this.f17881f = tbPageContext.getPageActivity();
        c.a.p0.f3.k.a aVar = new c.a.p0.f3.k.a(tbPageContext);
        this.k = aVar;
        CoverFlowView<c.a.p0.f3.j.g> d2 = aVar.d();
        if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
            d2.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
        }
        d2.setDisableParentEvent(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13 */
    public final View d(int i2, ViewGroup viewGroup, int i3) {
        InterceptResult invokeCommon;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), viewGroup, Integer.valueOf(i3)})) == null) {
            if (i3 == 1) {
                return LayoutInflater.from(this.f17880e.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
            }
            if (i3 == 2) {
                inflate = LayoutInflater.from(this.f17880e.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
                h hVar = new h(null);
                hVar.f17906i = (RelativeLayout) inflate.findViewById(R.id.title_layout);
                hVar.f17907j = (TextView) inflate.findViewById(R.id.title_text);
                hVar.k = (TextView) inflate.findViewById(R.id.more_text);
                inflate.setTag(hVar);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    View inflate2 = LayoutInflater.from(this.f17880e.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                    inflate2.setOnClickListener(new a(this));
                    return inflate2;
                }
                return null;
            } else {
                inflate = LayoutInflater.from(this.f17880e.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
                h hVar2 = new h(null);
                hVar2.f17899b = (TextView) inflate.findViewById(R.id.forum_name);
                hVar2.f17898a = (BarImageView) inflate.findViewById(R.id.forum_image);
                hVar2.f17900c = (TextView) inflate.findViewById(R.id.forum_rank);
                hVar2.f17901d = (TextView) inflate.findViewById(R.id.forum_intro);
                hVar2.f17902e = (TextView) inflate.findViewById(R.id.like_num_tv);
                hVar2.f17903f = (TextView) inflate.findViewById(R.id.thread_num_tv);
                hVar2.f17904g = (TextView) inflate.findViewById(R.id.category_name_tv);
                hVar2.f17905h = inflate.findViewById(R.id.vertical_line_view);
                hVar2.m = (TextView) inflate.findViewById(R.id.enter_forum);
                hVar2.l = (LinearLayout) inflate.findViewById(R.id.enter_forum_ll);
                inflate.setTag(hVar2);
            }
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public final void e(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        ArrayList<f.a> arrayList = this.f17885j;
        if (arrayList != null && arrayList.size() != 0) {
            view.setVisibility(0);
            int size = this.f17885j.size();
            if (size > 4) {
                size = 4;
            }
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < 4; i2++) {
                if (i2 < size) {
                    f.a aVar = this.f17885j.get(i2);
                    if (aVar == null) {
                        viewArr2[i2].setVisibility(8);
                    } else {
                        if (viewArr2[i2] instanceof LinearLayout) {
                            LinearLayout linearLayout = (LinearLayout) viewArr2[i2];
                            linearLayout.setTag(Integer.valueOf(i2));
                            View childAt = linearLayout.getChildAt(0);
                            if (childAt instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt;
                                tbImageView.setTag(Integer.valueOf(i2));
                                tbImageView.setDrawerType(1);
                                tbImageView.setIsRound(true);
                                tbImageView.startLoad(aVar.f17916c, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.f17914a, 5, false));
                            }
                            linearLayout.setOnClickListener(new g(this, aVar));
                        }
                        viewArr2[i2].setVisibility(0);
                        viewArr[i2].setVisibility(0);
                    }
                } else {
                    viewArr2[i2].setVisibility(8);
                    viewArr[i2].setVisibility(8);
                }
            }
            return;
        }
        view.setVisibility(8);
    }

    public final void f(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) || view == null) {
            return;
        }
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 1) {
            e(view);
        } else if (itemViewType == 2) {
            Object item = getItem(i2);
            if (item instanceof f.b) {
                f.b bVar = (f.b) item;
                h hVar = (h) view.getTag();
                if (bVar.m == 0) {
                    hVar.f17906i.setPadding(this.f17880e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f17880e.getResources().getDimensionPixelSize(R.dimen.ds26), this.f17880e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f17880e.getResources().getDimensionPixelSize(R.dimen.ds10));
                } else {
                    hVar.f17906i.setPadding(this.f17880e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f17880e.getResources().getDimensionPixelSize(R.dimen.ds6), this.f17880e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f17880e.getResources().getDimensionPixelSize(R.dimen.ds10));
                }
                hVar.f17907j.setText(bVar.f17919b);
                if (bVar.f17920c) {
                    hVar.k.setVisibility(8);
                    return;
                }
                hVar.k.setVisibility(0);
                hVar.k.setOnClickListener(new b(this, bVar));
            }
        } else if (itemViewType == 3) {
            Object item2 = getItem(i2);
            if (item2 instanceof f.b) {
                f.b bVar2 = (f.b) item2;
                h hVar2 = (h) view.getTag();
                if (hVar2 == null) {
                    return;
                }
                hVar2.f17898a.startLoad(bVar2.f17923f, 10, false);
                hVar2.f17899b.setText(bVar2.f17922e);
                hVar2.f17900c.setText(bVar2.f17925h);
                hVar2.f17901d.setText(bVar2.f17926i);
                long j2 = bVar2.f17927j;
                if (j2 < 0) {
                    j2 = 0;
                }
                long j3 = bVar2.k;
                long j4 = j3 >= 0 ? j3 : 0L;
                hVar2.f17902e.setText(this.f17880e.getString(R.string.attention) + StringHelper.numFormatOver10000wan(j2));
                hVar2.f17903f.setText(this.f17880e.getString(R.string.text_post) + StringHelper.numFormatOver10000wan(j4));
                if (bVar2.f17920c && !StringUtils.isNull(bVar2.f17924g)) {
                    hVar2.f17904g.setText(UtilHelper.getFixedText(bVar2.f17924g, 5));
                    hVar2.f17904g.setVisibility(0);
                    hVar2.f17905h.setVisibility(0);
                } else {
                    hVar2.f17904g.setVisibility(8);
                    hVar2.f17905h.setVisibility(8);
                }
                hVar2.f17904g.setOnClickListener(new c(this, bVar2));
                hVar2.m.setOnClickListener(new d(this, bVar2));
                hVar2.l.setOnClickListener(new View$OnClickListenerC0867e(this, hVar2));
                view.setOnClickListener(new f(this, bVar2));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.f17880e.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<f.b> arrayList = this.f17884i;
            int i2 = 0;
            if (arrayList != null && arrayList.size() != 0) {
                i2 = 0 + this.f17884i.size();
            }
            ArrayList<z1> arrayList2 = this.f17883h;
            if (arrayList2 != null && arrayList2.size() != 0) {
                i2++;
            }
            if (i2 != 0) {
                i2++;
            }
            ArrayList<f.a> arrayList3 = this.f17885j;
            return (arrayList3 == null || arrayList3.size() <= 0) ? i2 : i2 + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != -1 && itemViewType != 4) {
                if (itemViewType == 0) {
                    return this.f17883h;
                }
                int i3 = 1;
                if (itemViewType == 1) {
                    return this.f17885j;
                }
                if (itemViewType != 2 && itemViewType != 3) {
                    return null;
                }
                ArrayList<z1> arrayList = this.f17883h;
                i3 = (arrayList == null || arrayList.size() == 0) ? 0 : 0;
                ArrayList<f.a> arrayList2 = this.f17885j;
                if (arrayList2 != null && arrayList2.size() != 0) {
                    i3++;
                }
                int i4 = i2 - i3;
                if (i4 >= 0 && i4 < this.f17884i.size()) {
                    return this.f17884i.get(i4);
                }
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        f.b bVar;
        ArrayList<z1> arrayList;
        ArrayList<f.a> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int i3 = 0;
            if (i2 == 0) {
                ArrayList<z1> arrayList3 = this.f17883h;
                if (arrayList3 != null && arrayList3.size() != 0) {
                    return 0;
                }
                ArrayList<f.a> arrayList4 = this.f17885j;
                if (arrayList4 != null && arrayList4.size() != 0) {
                    return 1;
                }
            }
            if (i2 != 1 || (arrayList = this.f17883h) == null || arrayList.size() == 0 || (arrayList2 = this.f17885j) == null || arrayList2.size() == 0) {
                if (i2 == getCount() - 1) {
                    return 4;
                }
                ArrayList<z1> arrayList5 = this.f17883h;
                if (arrayList5 != null && arrayList5.size() != 0) {
                    i3 = 1;
                }
                ArrayList<f.a> arrayList6 = this.f17885j;
                if (arrayList6 != null && arrayList6.size() != 0) {
                    i3++;
                }
                int i4 = i2 - i3;
                if (i4 < 0 || i4 >= this.f17884i.size() || (bVar = this.f17884i.get(i4)) == null) {
                    return -1;
                }
                return bVar.f17918a ? 2 : 3;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                return this.k.getView(i2, view, viewGroup);
            }
            if (view == null) {
                view = d(i2, viewGroup, itemViewType);
            }
            f(view, i2);
            this.f17880e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f17880e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 5;
        }
        return invokeV.intValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            c.a.p0.f3.k.a aVar = this.k;
            if (aVar != null) {
                aVar.e(i2);
            }
            notifyDataSetChanged();
        }
    }

    public void i(c.a.p0.f3.j.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f17882g = fVar;
        this.f17883h = fVar.e();
        this.f17884i = this.f17882g.b();
        this.f17885j = this.f17882g.a();
        this.k.f(this.f17883h);
    }
}
