package c.a.r0.h3.j;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.a2;
import c.a.r0.h3.j.f;
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
    public TbPageContext<Object> f18927e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f18928f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.h3.j.f f18929g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<a2> f18930h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<f.b> f18931i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<f.a> f18932j;
    public c.a.r0.h3.k.a k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18933e;

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
            this.f18933e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f18933e.f18927e.getPageActivity(), "square_bottom_find_more", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                this.f18933e.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f18934e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18935f;

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
            this.f18935f = eVar;
            this.f18934e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f18935f.f18928f, "square_category_more", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f18934e.m));
                UrlManager.getInstance().dealOneLink(this.f18935f.f18927e, new String[]{this.f18934e.l});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f18936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18937f;

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
            this.f18937f = eVar;
            this.f18936e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f18937f.f18928f, "square_module_menu", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f18936e.n));
                UrlManager.getInstance().dealOneLink(this.f18937f.f18927e, new String[]{this.f18936e.l});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f18938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18939f;

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
            this.f18939f = eVar;
            this.f18938e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f18939f.f18928f, "square_module_entry", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f18938e.m), "loc", Integer.valueOf(this.f18938e.n));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18939f.f18927e.getPageActivity()).createNormalCfg(this.f18938e.f18969e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    /* renamed from: c.a.r0.h3.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0916e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f18940e;

        public View$OnClickListenerC0916e(e eVar, h hVar) {
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
            this.f18940e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18940e.m.performClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f18941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18942f;

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
            this.f18942f = eVar;
            this.f18941e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f18942f.f18928f, "square_module_content", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f18941e.m), "loc", Integer.valueOf(this.f18941e.n));
                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.f18942f.f18927e.getPageActivity();
                    messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, this.f18941e.f18968d + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f18942f.f18927e.getPageActivity()).createNormalCfg(this.f18941e.f18969e, FrsActivityConfig.FRS_FROM_SQUARE)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.a f18943e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18944f;

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
            this.f18944f = eVar;
            this.f18943e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18943e.f18964d) {
                    this.f18944f.g();
                } else {
                    UrlManager.getInstance().dealOneLink(this.f18944f.f18927e, new String[]{this.f18943e.f18962b});
                }
                if (view.getTag() instanceof Integer) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    Activity activity = this.f18944f.f18928f;
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
        public BarImageView f18945a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18946b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18947c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18948d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18949e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18950f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18951g;

        /* renamed from: h  reason: collision with root package name */
        public View f18952h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f18953i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f18954j;
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
        this.f18927e = tbPageContext;
        this.f18928f = tbPageContext.getPageActivity();
        c.a.r0.h3.k.a aVar = new c.a.r0.h3.k.a(tbPageContext);
        this.k = aVar;
        CoverFlowView<c.a.r0.h3.j.g> d2 = aVar.d();
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
                return LayoutInflater.from(this.f18927e.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
            }
            if (i3 == 2) {
                inflate = LayoutInflater.from(this.f18927e.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
                h hVar = new h(null);
                hVar.f18953i = (RelativeLayout) inflate.findViewById(R.id.title_layout);
                hVar.f18954j = (TextView) inflate.findViewById(R.id.title_text);
                hVar.k = (TextView) inflate.findViewById(R.id.more_text);
                inflate.setTag(hVar);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    View inflate2 = LayoutInflater.from(this.f18927e.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                    inflate2.setOnClickListener(new a(this));
                    return inflate2;
                }
                return null;
            } else {
                inflate = LayoutInflater.from(this.f18927e.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
                h hVar2 = new h(null);
                hVar2.f18946b = (TextView) inflate.findViewById(R.id.forum_name);
                hVar2.f18945a = (BarImageView) inflate.findViewById(R.id.forum_image);
                hVar2.f18947c = (TextView) inflate.findViewById(R.id.forum_rank);
                hVar2.f18948d = (TextView) inflate.findViewById(R.id.forum_intro);
                hVar2.f18949e = (TextView) inflate.findViewById(R.id.like_num_tv);
                hVar2.f18950f = (TextView) inflate.findViewById(R.id.thread_num_tv);
                hVar2.f18951g = (TextView) inflate.findViewById(R.id.category_name_tv);
                hVar2.f18952h = inflate.findViewById(R.id.vertical_line_view);
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
        ArrayList<f.a> arrayList = this.f18932j;
        if (arrayList != null && arrayList.size() != 0) {
            view.setVisibility(0);
            int size = this.f18932j.size();
            if (size > 4) {
                size = 4;
            }
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < 4; i2++) {
                if (i2 < size) {
                    f.a aVar = this.f18932j.get(i2);
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
                                tbImageView.startLoad(aVar.f18963c, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.f18961a, 5, false));
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
                    hVar.f18953i.setPadding(this.f18927e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f18927e.getResources().getDimensionPixelSize(R.dimen.ds26), this.f18927e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f18927e.getResources().getDimensionPixelSize(R.dimen.ds10));
                } else {
                    hVar.f18953i.setPadding(this.f18927e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f18927e.getResources().getDimensionPixelSize(R.dimen.ds6), this.f18927e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f18927e.getResources().getDimensionPixelSize(R.dimen.ds10));
                }
                hVar.f18954j.setText(bVar.f18966b);
                if (bVar.f18967c) {
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
                hVar2.f18945a.startLoad(bVar2.f18970f, 10, false);
                hVar2.f18946b.setText(bVar2.f18969e);
                hVar2.f18947c.setText(bVar2.f18972h);
                hVar2.f18948d.setText(bVar2.f18973i);
                long j2 = bVar2.f18974j;
                if (j2 < 0) {
                    j2 = 0;
                }
                long j3 = bVar2.k;
                long j4 = j3 >= 0 ? j3 : 0L;
                hVar2.f18949e.setText(this.f18927e.getString(R.string.attention) + StringHelper.numFormatOver10000wan(j2));
                hVar2.f18950f.setText(this.f18927e.getString(R.string.text_post) + StringHelper.numFormatOver10000wan(j4));
                if (bVar2.f18967c && !StringUtils.isNull(bVar2.f18971g)) {
                    hVar2.f18951g.setText(UtilHelper.getFixedText(bVar2.f18971g, 5));
                    hVar2.f18951g.setVisibility(0);
                    hVar2.f18952h.setVisibility(0);
                } else {
                    hVar2.f18951g.setVisibility(8);
                    hVar2.f18952h.setVisibility(8);
                }
                hVar2.f18951g.setOnClickListener(new c(this, bVar2));
                hVar2.m.setOnClickListener(new d(this, bVar2));
                hVar2.l.setOnClickListener(new View$OnClickListenerC0916e(this, hVar2));
                view.setOnClickListener(new f(this, bVar2));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.f18927e.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<f.b> arrayList = this.f18931i;
            int i2 = 0;
            if (arrayList != null && arrayList.size() != 0) {
                i2 = 0 + this.f18931i.size();
            }
            ArrayList<a2> arrayList2 = this.f18930h;
            if (arrayList2 != null && arrayList2.size() != 0) {
                i2++;
            }
            if (i2 != 0) {
                i2++;
            }
            ArrayList<f.a> arrayList3 = this.f18932j;
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
                    return this.f18930h;
                }
                int i3 = 1;
                if (itemViewType == 1) {
                    return this.f18932j;
                }
                if (itemViewType != 2 && itemViewType != 3) {
                    return null;
                }
                ArrayList<a2> arrayList = this.f18930h;
                i3 = (arrayList == null || arrayList.size() == 0) ? 0 : 0;
                ArrayList<f.a> arrayList2 = this.f18932j;
                if (arrayList2 != null && arrayList2.size() != 0) {
                    i3++;
                }
                int i4 = i2 - i3;
                if (i4 >= 0 && i4 < this.f18931i.size()) {
                    return this.f18931i.get(i4);
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
        ArrayList<a2> arrayList;
        ArrayList<f.a> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int i3 = 0;
            if (i2 == 0) {
                ArrayList<a2> arrayList3 = this.f18930h;
                if (arrayList3 != null && arrayList3.size() != 0) {
                    return 0;
                }
                ArrayList<f.a> arrayList4 = this.f18932j;
                if (arrayList4 != null && arrayList4.size() != 0) {
                    return 1;
                }
            }
            if (i2 != 1 || (arrayList = this.f18930h) == null || arrayList.size() == 0 || (arrayList2 = this.f18932j) == null || arrayList2.size() == 0) {
                if (i2 == getCount() - 1) {
                    return 4;
                }
                ArrayList<a2> arrayList5 = this.f18930h;
                if (arrayList5 != null && arrayList5.size() != 0) {
                    i3 = 1;
                }
                ArrayList<f.a> arrayList6 = this.f18932j;
                if (arrayList6 != null && arrayList6.size() != 0) {
                    i3++;
                }
                int i4 = i2 - i3;
                if (i4 < 0 || i4 >= this.f18931i.size() || (bVar = this.f18931i.get(i4)) == null) {
                    return -1;
                }
                return bVar.f18965a ? 2 : 3;
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
            this.f18927e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f18927e.getLayoutMode().j(view);
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
            c.a.r0.h3.k.a aVar = this.k;
            if (aVar != null) {
                aVar.e(i2);
            }
            notifyDataSetChanged();
        }
    }

    public void i(c.a.r0.h3.j.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f18929g = fVar;
        this.f18930h = fVar.e();
        this.f18931i = this.f18929g.b();
        this.f18932j = this.f18929g.a();
        this.k.f(this.f18930h);
    }
}
