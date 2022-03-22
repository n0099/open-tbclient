package c.a.p0.v3.e;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.y1;
import c.a.p0.v3.e.f;
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
/* loaded from: classes2.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<Object> a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f19264b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.v3.e.f f19265c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<y1> f19266d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<f.b> f19267e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<f.a> f19268f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.v3.f.a f19269g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.a.a.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                this.a.g();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f19270b;

        public b(e eVar, f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19270b = eVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f19270b.f19264b, "square_category_more", "click", 1, "loc", Integer.valueOf(this.a.m));
                UrlManager.getInstance().dealOneLink(this.f19270b.a, new String[]{this.a.l});
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f19271b;

        public c(e eVar, f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19271b = eVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f19271b.f19264b, "square_module_menu", "click", 1, "loc", Integer.valueOf(this.a.n));
                UrlManager.getInstance().dealOneLink(this.f19271b.a, new String[]{this.a.l});
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f19272b;

        public d(e eVar, f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19272b = eVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f19272b.f19264b, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(this.a.m), "loc", Integer.valueOf(this.a.n));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19272b.a.getPageActivity()).createNormalCfg(this.a.f19293e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    /* renamed from: c.a.p0.v3.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1458e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public View$OnClickListenerC1458e(e eVar, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.m.performClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f19273b;

        public f(e eVar, f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19273b = eVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.eventStat(this.f19273b.f19264b, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(this.a.m), "loc", Integer.valueOf(this.a.n));
                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.f19273b.a.getPageActivity();
                    messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, this.a.f19292d + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19273b.a.getPageActivity()).createNormalCfg(this.a.f19293e, FrsActivityConfig.FRS_FROM_SQUARE)));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f19274b;

        public g(e eVar, f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19274b = eVar;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f19289d) {
                    this.f19274b.g();
                } else {
                    UrlManager.getInstance().dealOneLink(this.f19274b.a, new String[]{this.a.f19287b});
                }
                if (view.getTag() instanceof Integer) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    Activity activity = this.f19274b.f19264b;
                    TiebaStatic.eventStat(activity, "square_entry_content", "click", 1, "loc", "" + intValue);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19275b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19276c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f19277d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19278e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f19279f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f19280g;

        /* renamed from: h  reason: collision with root package name */
        public View f19281h;
        public RelativeLayout i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19269g = null;
        if (tbPageContext == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.a = tbPageContext;
        this.f19264b = tbPageContext.getPageActivity();
        c.a.p0.v3.f.a aVar = new c.a.p0.v3.f.a(tbPageContext);
        this.f19269g = aVar;
        CoverFlowView<c.a.p0.v3.e.g> d2 = aVar.d();
        if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
            d2.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
        }
        d2.setDisableParentEvent(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13 */
    public final View d(int i, ViewGroup viewGroup, int i2) {
        InterceptResult invokeCommon;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), viewGroup, Integer.valueOf(i2)})) == null) {
            if (i2 == 1) {
                return LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07a3, (ViewGroup) null);
            }
            if (i2 == 2) {
                inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07a5, (ViewGroup) null);
                h hVar = new h(null);
                hVar.i = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092047);
                hVar.j = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092059);
                hVar.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09144d);
                inflate.setTag(hVar);
            } else if (i2 != 3) {
                if (i2 == 4) {
                    View inflate2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07a4, (ViewGroup) null);
                    inflate2.setOnClickListener(new a(this));
                    return inflate2;
                }
                return null;
            } else {
                inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d079c, (ViewGroup) null);
                h hVar2 = new h(null);
                hVar2.f19275b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090a67);
                hVar2.a = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090a4c);
                hVar2.f19276c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090a6c);
                hVar2.f19277d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090a54);
                hVar2.f19278e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091253);
                hVar2.f19279f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091fbd);
                hVar2.f19280g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0905a2);
                hVar2.f19281h = inflate.findViewById(R.id.obfuscated_res_0x7f0922f4);
                hVar2.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0908d9);
                hVar2.l = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0908dc);
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
        ArrayList<f.a> arrayList = this.f19268f;
        if (arrayList != null && arrayList.size() != 0) {
            view.setVisibility(0);
            int size = this.f19268f.size();
            if (size > 4) {
                size = 4;
            }
            View[] viewArr = {view.findViewById(R.id.obfuscated_res_0x7f0908c2), view.findViewById(R.id.obfuscated_res_0x7f0908c3), view.findViewById(R.id.obfuscated_res_0x7f0908c4), view.findViewById(R.id.obfuscated_res_0x7f0908c5), view.findViewById(R.id.obfuscated_res_0x7f0908c6)};
            View[] viewArr2 = {view.findViewById(R.id.obfuscated_res_0x7f0908fb), view.findViewById(R.id.obfuscated_res_0x7f0908fc), view.findViewById(R.id.obfuscated_res_0x7f0908fd), view.findViewById(R.id.obfuscated_res_0x7f0908fe)};
            for (int i = 0; i < 4; i++) {
                if (i < size) {
                    f.a aVar = this.f19268f.get(i);
                    if (aVar == null) {
                        viewArr2[i].setVisibility(8);
                    } else {
                        if (viewArr2[i] instanceof LinearLayout) {
                            LinearLayout linearLayout = (LinearLayout) viewArr2[i];
                            linearLayout.setTag(Integer.valueOf(i));
                            View childAt = linearLayout.getChildAt(0);
                            if (childAt instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt;
                                tbImageView.setTag(Integer.valueOf(i));
                                tbImageView.setDrawerType(1);
                                tbImageView.setIsRound(true);
                                tbImageView.J(aVar.f19288c, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.a, 5, false));
                            }
                            linearLayout.setOnClickListener(new g(this, aVar));
                        }
                        viewArr2[i].setVisibility(0);
                        viewArr[i].setVisibility(0);
                    }
                } else {
                    viewArr2[i].setVisibility(8);
                    viewArr[i].setVisibility(8);
                }
            }
            return;
        }
        view.setVisibility(8);
    }

    public final void f(View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i) == null) || view == null) {
            return;
        }
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            e(view);
        } else if (itemViewType == 2) {
            Object item = getItem(i);
            if (item instanceof f.b) {
                f.b bVar = (f.b) item;
                h hVar = (h) view.getTag();
                if (bVar.m == 0) {
                    hVar.i.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f0), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229));
                } else {
                    hVar.i.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702df), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229));
                }
                hVar.j.setText(bVar.f19290b);
                if (bVar.f19291c) {
                    hVar.k.setVisibility(8);
                    return;
                }
                hVar.k.setVisibility(0);
                hVar.k.setOnClickListener(new b(this, bVar));
            }
        } else if (itemViewType == 3) {
            Object item2 = getItem(i);
            if (item2 instanceof f.b) {
                f.b bVar2 = (f.b) item2;
                h hVar2 = (h) view.getTag();
                if (hVar2 == null) {
                    return;
                }
                hVar2.a.J(bVar2.f19294f, 10, false);
                hVar2.f19275b.setText(bVar2.f19293e);
                hVar2.f19276c.setText(bVar2.f19296h);
                hVar2.f19277d.setText(bVar2.i);
                long j = bVar2.j;
                if (j < 0) {
                    j = 0;
                }
                long j2 = bVar2.k;
                long j3 = j2 >= 0 ? j2 : 0L;
                hVar2.f19278e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f029b) + StringHelper.numFormatOver10000wan(j));
                hVar2.f19279f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1385) + StringHelper.numFormatOver10000wan(j3));
                if (bVar2.f19291c && !StringUtils.isNull(bVar2.f19295g)) {
                    hVar2.f19280g.setText(UtilHelper.getFixedText(bVar2.f19295g, 5));
                    hVar2.f19280g.setVisibility(0);
                    hVar2.f19281h.setVisibility(0);
                } else {
                    hVar2.f19280g.setVisibility(8);
                    hVar2.f19281h.setVisibility(8);
                }
                hVar2.f19280g.setOnClickListener(new c(this, bVar2));
                hVar2.m.setOnClickListener(new d(this, bVar2));
                hVar2.l.setOnClickListener(new View$OnClickListenerC1458e(this, hVar2));
                view.setOnClickListener(new f(this, bVar2));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.a.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<f.b> arrayList = this.f19267e;
            int i = 0;
            if (arrayList != null && arrayList.size() != 0) {
                i = 0 + this.f19267e.size();
            }
            ArrayList<y1> arrayList2 = this.f19266d;
            if (arrayList2 != null && arrayList2.size() != 0) {
                i++;
            }
            if (i != 0) {
                i++;
            }
            ArrayList<f.a> arrayList3 = this.f19268f;
            return (arrayList3 == null || arrayList3.size() <= 0) ? i : i + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != -1 && itemViewType != 4) {
                if (itemViewType == 0) {
                    return this.f19266d;
                }
                int i2 = 1;
                if (itemViewType == 1) {
                    return this.f19268f;
                }
                if (itemViewType != 2 && itemViewType != 3) {
                    return null;
                }
                ArrayList<y1> arrayList = this.f19266d;
                i2 = (arrayList == null || arrayList.size() == 0) ? 0 : 0;
                ArrayList<f.a> arrayList2 = this.f19268f;
                if (arrayList2 != null && arrayList2.size() != 0) {
                    i2++;
                }
                int i3 = i - i2;
                if (i3 >= 0 && i3 < this.f19267e.size()) {
                    return this.f19267e.get(i3);
                }
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        f.b bVar;
        ArrayList<y1> arrayList;
        ArrayList<f.a> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            int i2 = 0;
            if (i == 0) {
                ArrayList<y1> arrayList3 = this.f19266d;
                if (arrayList3 != null && arrayList3.size() != 0) {
                    return 0;
                }
                ArrayList<f.a> arrayList4 = this.f19268f;
                if (arrayList4 != null && arrayList4.size() != 0) {
                    return 1;
                }
            }
            if (i != 1 || (arrayList = this.f19266d) == null || arrayList.size() == 0 || (arrayList2 = this.f19268f) == null || arrayList2.size() == 0) {
                if (i == getCount() - 1) {
                    return 4;
                }
                ArrayList<y1> arrayList5 = this.f19266d;
                if (arrayList5 != null && arrayList5.size() != 0) {
                    i2 = 1;
                }
                ArrayList<f.a> arrayList6 = this.f19268f;
                if (arrayList6 != null && arrayList6.size() != 0) {
                    i2++;
                }
                int i3 = i - i2;
                if (i3 < 0 || i3 >= this.f19267e.size() || (bVar = this.f19267e.get(i3)) == null) {
                    return -1;
                }
                return bVar.a ? 2 : 3;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                return this.f19269g.getView(i, view, viewGroup);
            }
            if (view == null) {
                view = d(i, viewGroup, itemViewType);
            }
            f(view, i);
            this.a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().j(view);
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

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            c.a.p0.v3.f.a aVar = this.f19269g;
            if (aVar != null) {
                aVar.e(i);
            }
            notifyDataSetChanged();
        }
    }

    public void i(c.a.p0.v3.e.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f19265c = fVar;
        this.f19266d = fVar.e();
        this.f19267e = this.f19265c.b();
        this.f19268f = this.f19265c.a();
        this.f19269g.f(this.f19266d);
    }
}
