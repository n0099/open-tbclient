package c.a.t0.t3.e;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.b2;
import c.a.t0.t3.e.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<Object> f23767e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f23768f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.t3.e.f f23769g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<b2> f23770h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<f.b> f23771i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<f.a> f23772j;
    public c.a.t0.t3.f.a k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23773e;

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
            this.f23773e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f23773e.f23767e.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                this.f23773e.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f23774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f23775f;

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
            this.f23775f = eVar;
            this.f23774e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f23775f.f23768f, "square_category_more", "click", 1, "loc", Integer.valueOf(this.f23774e.m));
                UrlManager.getInstance().dealOneLink(this.f23775f.f23767e, new String[]{this.f23774e.l});
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f23776e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f23777f;

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
            this.f23777f = eVar;
            this.f23776e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f23777f.f23768f, "square_module_menu", "click", 1, "loc", Integer.valueOf(this.f23776e.n));
                UrlManager.getInstance().dealOneLink(this.f23777f.f23767e, new String[]{this.f23776e.l});
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f23778e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f23779f;

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
            this.f23779f = eVar;
            this.f23778e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f23779f.f23768f, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(this.f23778e.m), "loc", Integer.valueOf(this.f23778e.n));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f23779f.f23767e.getPageActivity()).createNormalCfg(this.f23778e.f23805e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    /* renamed from: c.a.t0.t3.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1447e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f23780e;

        public View$OnClickListenerC1447e(e eVar, h hVar) {
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
            this.f23780e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23780e.m.performClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f23781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f23782f;

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
            this.f23782f = eVar;
            this.f23781e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f23782f.f23768f, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(this.f23781e.m), "loc", Integer.valueOf(this.f23781e.n));
                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.f23782f.f23767e.getPageActivity();
                    messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, this.f23781e.f23804d + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f23782f.f23767e.getPageActivity()).createNormalCfg(this.f23781e.f23805e, FrsActivityConfig.FRS_FROM_SQUARE)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.a f23783e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f23784f;

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
            this.f23784f = eVar;
            this.f23783e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23783e.f23801d) {
                    this.f23784f.g();
                } else {
                    UrlManager.getInstance().dealOneLink(this.f23784f.f23767e, new String[]{this.f23783e.f23799b});
                }
                if (view.getTag() instanceof Integer) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    Activity activity = this.f23784f.f23768f;
                    TiebaStatic.eventStat(activity, "square_entry_content", "click", 1, "loc", "" + intValue);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f23785b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f23786c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f23787d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f23788e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f23789f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f23790g;

        /* renamed from: h  reason: collision with root package name */
        public View f23791h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f23792i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f23793j;
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
        this.f23767e = tbPageContext;
        this.f23768f = tbPageContext.getPageActivity();
        c.a.t0.t3.f.a aVar = new c.a.t0.t3.f.a(tbPageContext);
        this.k = aVar;
        CoverFlowView<c.a.t0.t3.e.g> d2 = aVar.d();
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
                return LayoutInflater.from(this.f23767e.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
            }
            if (i3 == 2) {
                inflate = LayoutInflater.from(this.f23767e.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
                h hVar = new h(null);
                hVar.f23792i = (RelativeLayout) inflate.findViewById(R.id.title_layout);
                hVar.f23793j = (TextView) inflate.findViewById(R.id.title_text);
                hVar.k = (TextView) inflate.findViewById(R.id.more_text);
                inflate.setTag(hVar);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    View inflate2 = LayoutInflater.from(this.f23767e.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                    inflate2.setOnClickListener(new a(this));
                    return inflate2;
                }
                return null;
            } else {
                inflate = LayoutInflater.from(this.f23767e.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
                h hVar2 = new h(null);
                hVar2.f23785b = (TextView) inflate.findViewById(R.id.forum_name);
                hVar2.a = (BarImageView) inflate.findViewById(R.id.forum_image);
                hVar2.f23786c = (TextView) inflate.findViewById(R.id.forum_rank);
                hVar2.f23787d = (TextView) inflate.findViewById(R.id.forum_intro);
                hVar2.f23788e = (TextView) inflate.findViewById(R.id.like_num_tv);
                hVar2.f23789f = (TextView) inflate.findViewById(R.id.thread_num_tv);
                hVar2.f23790g = (TextView) inflate.findViewById(R.id.category_name_tv);
                hVar2.f23791h = inflate.findViewById(R.id.vertical_line_view);
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
        ArrayList<f.a> arrayList = this.f23772j;
        if (arrayList != null && arrayList.size() != 0) {
            view.setVisibility(0);
            int size = this.f23772j.size();
            if (size > 4) {
                size = 4;
            }
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < 4; i2++) {
                if (i2 < size) {
                    f.a aVar = this.f23772j.get(i2);
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
                                tbImageView.startLoad(aVar.f23800c, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.a, 5, false));
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
                    hVar.f23792i.setPadding(this.f23767e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f23767e.getResources().getDimensionPixelSize(R.dimen.ds26), this.f23767e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f23767e.getResources().getDimensionPixelSize(R.dimen.ds10));
                } else {
                    hVar.f23792i.setPadding(this.f23767e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f23767e.getResources().getDimensionPixelSize(R.dimen.ds6), this.f23767e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f23767e.getResources().getDimensionPixelSize(R.dimen.ds10));
                }
                hVar.f23793j.setText(bVar.f23802b);
                if (bVar.f23803c) {
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
                hVar2.a.startLoad(bVar2.f23806f, 10, false);
                hVar2.f23785b.setText(bVar2.f23805e);
                hVar2.f23786c.setText(bVar2.f23808h);
                hVar2.f23787d.setText(bVar2.f23809i);
                long j2 = bVar2.f23810j;
                if (j2 < 0) {
                    j2 = 0;
                }
                long j3 = bVar2.k;
                long j4 = j3 >= 0 ? j3 : 0L;
                hVar2.f23788e.setText(this.f23767e.getString(R.string.attention) + StringHelper.numFormatOver10000wan(j2));
                hVar2.f23789f.setText(this.f23767e.getString(R.string.text_post) + StringHelper.numFormatOver10000wan(j4));
                if (bVar2.f23803c && !StringUtils.isNull(bVar2.f23807g)) {
                    hVar2.f23790g.setText(UtilHelper.getFixedText(bVar2.f23807g, 5));
                    hVar2.f23790g.setVisibility(0);
                    hVar2.f23791h.setVisibility(0);
                } else {
                    hVar2.f23790g.setVisibility(8);
                    hVar2.f23791h.setVisibility(8);
                }
                hVar2.f23790g.setOnClickListener(new c(this, bVar2));
                hVar2.m.setOnClickListener(new d(this, bVar2));
                hVar2.l.setOnClickListener(new View$OnClickListenerC1447e(this, hVar2));
                view.setOnClickListener(new f(this, bVar2));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.f23767e.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<f.b> arrayList = this.f23771i;
            int i2 = 0;
            if (arrayList != null && arrayList.size() != 0) {
                i2 = 0 + this.f23771i.size();
            }
            ArrayList<b2> arrayList2 = this.f23770h;
            if (arrayList2 != null && arrayList2.size() != 0) {
                i2++;
            }
            if (i2 != 0) {
                i2++;
            }
            ArrayList<f.a> arrayList3 = this.f23772j;
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
                    return this.f23770h;
                }
                int i3 = 1;
                if (itemViewType == 1) {
                    return this.f23772j;
                }
                if (itemViewType != 2 && itemViewType != 3) {
                    return null;
                }
                ArrayList<b2> arrayList = this.f23770h;
                i3 = (arrayList == null || arrayList.size() == 0) ? 0 : 0;
                ArrayList<f.a> arrayList2 = this.f23772j;
                if (arrayList2 != null && arrayList2.size() != 0) {
                    i3++;
                }
                int i4 = i2 - i3;
                if (i4 >= 0 && i4 < this.f23771i.size()) {
                    return this.f23771i.get(i4);
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
        ArrayList<b2> arrayList;
        ArrayList<f.a> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int i3 = 0;
            if (i2 == 0) {
                ArrayList<b2> arrayList3 = this.f23770h;
                if (arrayList3 != null && arrayList3.size() != 0) {
                    return 0;
                }
                ArrayList<f.a> arrayList4 = this.f23772j;
                if (arrayList4 != null && arrayList4.size() != 0) {
                    return 1;
                }
            }
            if (i2 != 1 || (arrayList = this.f23770h) == null || arrayList.size() == 0 || (arrayList2 = this.f23772j) == null || arrayList2.size() == 0) {
                if (i2 == getCount() - 1) {
                    return 4;
                }
                ArrayList<b2> arrayList5 = this.f23770h;
                if (arrayList5 != null && arrayList5.size() != 0) {
                    i3 = 1;
                }
                ArrayList<f.a> arrayList6 = this.f23772j;
                if (arrayList6 != null && arrayList6.size() != 0) {
                    i3++;
                }
                int i4 = i2 - i3;
                if (i4 < 0 || i4 >= this.f23771i.size() || (bVar = this.f23771i.get(i4)) == null) {
                    return -1;
                }
                return bVar.a ? 2 : 3;
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
            this.f23767e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f23767e.getLayoutMode().j(view);
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
            c.a.t0.t3.f.a aVar = this.k;
            if (aVar != null) {
                aVar.e(i2);
            }
            notifyDataSetChanged();
        }
    }

    public void i(c.a.t0.t3.e.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f23769g = fVar;
        this.f23770h = fVar.e();
        this.f23771i = this.f23769g.b();
        this.f23772j = this.f23769g.a();
        this.k.f(this.f23770h);
    }
}
