package c.a.p0.o2;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static final float m;
    public static final float n;
    public static final float o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<MarkData> f16817b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16818c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f16819d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f16820e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f16821f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16822g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16823h;
    public boolean i;
    public Runnable j;
    public final View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(e eVar) {
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
                }
            }
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                TiebaStatic.log(new StatisticItem("c12529").param("obj_locate", 5));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
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
                MarkData item = this.a.getItem(((Integer) view.getTag()).intValue());
                StatisticItem statisticItem = new StatisticItem("c12529");
                if (view instanceof CommonUserLikeButton) {
                    statisticItem.param("obj_locate", 4);
                } else if (view instanceof ClickableHeaderImageView) {
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", item.getId());
                statisticItem.param("obj_id", item.getUesrId());
                TiebaStatic.log(statisticItem);
                c.a.p0.o2.c.b("c14064", item);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public d(e eVar) {
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
                c.a.p0.o2.c.b("c14065", this.a.getItem(((Integer) view.getTag()).intValue()));
            }
        }
    }

    /* renamed from: c.a.p0.o2.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1260e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageButton a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f16824b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16825c;

        /* renamed from: d  reason: collision with root package name */
        public CommonUserLikeButton f16826d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f16827e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f16828f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f16829g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f16830h;
        public LinearLayout i;
        public LinearLayout j;
        public View k;
        public c.a.o0.r.l0.t.c l;
        public final /* synthetic */ e m;

        public C1260e(e eVar) {
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
            this.m = eVar;
        }

        public void a(MarkData markData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, markData) == null) || markData == null) {
                return;
            }
            String title = markData.getTitle();
            if (!TextUtils.isEmpty(title)) {
                if (markData.is_deleted()) {
                    this.f16827e.setText(title);
                    this.f16827e.setTextSize(0, e.m);
                    SkinManager.setViewTextColor(this.f16827e, (int) R.color.CAM_X0110);
                } else {
                    this.f16827e.setText(title);
                    this.f16827e.setTextSize(0, e.n);
                    SkinManager.setViewTextColor(this.f16827e, (int) R.color.CAM_X0105);
                }
            } else {
                this.f16827e.setText("");
            }
            c(markData);
            this.f16824b.setData(markData.metaData);
            this.f16824b.setShowV(markData.metaData.isBigV());
            this.l.n(markData.metaData);
            this.f16826d.g(TbadkCoreApplication.getInst().getSkinType());
            this.f16826d.setTextSize(0, e.o);
            if ((markData.metaData.getIsLike() || StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                this.f16826d.setVisibility(8);
            } else {
                this.f16826d.setVisibility(0);
            }
            if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                this.j.setVisibility(0);
                if (markData.isRedTipShow() && !markData.is_deleted()) {
                    this.f16829g.setVisibility(0);
                } else {
                    this.f16829g.setVisibility(8);
                }
                if (markData.is_deleted()) {
                    this.f16828f.setText(this.m.a.getString(R.string.obfuscated_res_0x7f0f0a8a));
                } else {
                    this.f16828f.setText(markData.getmState());
                }
                SkinManager.setViewTextColor(this.f16828f, (int) R.color.CAM_X0109);
            } else {
                this.j.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        }

        public void b(ClickableHeaderImageView clickableHeaderImageView) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickableHeaderImageView) == null) || clickableHeaderImageView == null) {
                return;
            }
            clickableHeaderImageView.setDefaultResource(17170445);
            clickableHeaderImageView.setPlaceHolder(1);
            clickableHeaderImageView.setIsRound(true);
            clickableHeaderImageView.setAfterClickListener(this.m.k);
        }

        public final void c(MarkData markData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, markData) == null) || markData == null) {
                return;
            }
            this.f16825c.setText(markData.getAuthorName());
            if (markData.metaData.isBigV()) {
                SkinManager.setViewTextColor(this.f16825c, (int) R.color.CAM_X0301);
            } else {
                SkinManager.setViewTextColor(this.f16825c, (int) R.color.CAM_X0106);
            }
        }

        public /* synthetic */ C1260e(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* loaded from: classes2.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f16831b;

        public f(e eVar) {
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
                }
            }
        }

        public /* synthetic */ f(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* loaded from: classes2.dex */
    public class g extends C1260e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OriginalThreadCardView n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(e eVar, View view) {
            super(eVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((e) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16830h = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091cc1);
            this.a = (ImageButton) view.findViewById(R.id.obfuscated_res_0x7f091cc2);
            this.f16824b = (ClickableHeaderImageView) view.findViewById(R.id.obfuscated_res_0x7f091cc7);
            this.f16825c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091cc8);
            this.f16826d = (CommonUserLikeButton) view.findViewById(R.id.obfuscated_res_0x7f091cc6);
            this.l = new c.a.o0.r.l0.t.c(eVar.a, this.f16826d);
            this.i = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091cc3);
            this.f16827e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091cdf);
            this.n = (OriginalThreadCardView) view.findViewById(R.id.obfuscated_res_0x7f091ccd);
            this.f16828f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091cc5);
            this.f16829g = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091cc9);
            this.j = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091cc4);
            this.k = view.findViewById(R.id.obfuscated_res_0x7f091cde);
            b(this.f16824b);
        }

        @Override // c.a.p0.o2.e.C1260e
        public void a(MarkData markData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, markData) == null) {
                super.a(markData);
                this.n.g(markData.getOriginalThreadInfo());
                this.n.p();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                    layoutParams.bottomMargin = (int) e.m;
                } else {
                    layoutParams.bottomMargin = 0;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends C1260e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView n;
        public LinearLayout o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(e eVar, View view) {
            super(eVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((e) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16830h = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090d79);
            this.f16824b = (ClickableHeaderImageView) view.findViewById(R.id.obfuscated_res_0x7f0913a9);
            this.f16825c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0913aa);
            this.i = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090d7c);
            this.o = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090d7b);
            this.f16826d = (CommonUserLikeButton) view.findViewById(R.id.obfuscated_res_0x7f0913af);
            this.l = new c.a.o0.r.l0.t.c(eVar.a, this.f16826d);
            this.n = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0913ad);
            this.f16827e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0913ae);
            this.f16828f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0913ac);
            this.a = (ImageButton) view.findViewById(R.id.obfuscated_res_0x7f090d7a);
            this.f16829g = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09154c);
            this.j = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0913ab);
            this.k = view.findViewById(R.id.obfuscated_res_0x7f091f35);
            b(this.f16824b);
            this.n.setPlaceHolder(1);
        }

        @Override // c.a.p0.o2.e.C1260e
        public void a(MarkData markData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, markData) == null) {
                super.a(markData);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                if (l.c().g() && !StringUtils.isNull(markData.getPic_url())) {
                    String pic_url = markData.getPic_url();
                    if (!StringUtils.isNull(pic_url)) {
                        this.n.setVisibility(0);
                        this.n.J(pic_url, 10, false);
                    }
                    layoutParams.bottomMargin = e.p;
                } else {
                    this.n.setVisibility(8);
                    layoutParams.bottomMargin = e.q;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
                if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                    layoutParams2.bottomMargin = (int) e.m;
                } else {
                    layoutParams2.bottomMargin = 0;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1693442887, "Lc/a/p0/o2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1693442887, "Lc/a/p0/o2/e;");
                return;
            }
        }
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f0);
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9);
        q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
    }

    public e(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16817b = new ArrayList<>();
        this.f16818c = false;
        this.f16819d = null;
        this.f16820e = null;
        this.f16821f = null;
        this.f16822g = false;
        this.f16823h = true;
        this.i = true;
        this.k = new c(this);
        this.l = new d(this);
        this.a = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (ListUtils.isEmpty(this.f16817b)) {
                return 0;
            }
            return this.i ? ListUtils.getCount(this.f16817b) + 1 : ListUtils.getCount(this.f16817b);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (ListUtils.getCount(this.f16817b) <= i) {
                return -1L;
            }
            return i;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            MarkData item = getItem(i);
            if (item == null) {
                return 1;
            }
            return item.isShareThread() ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1260e hVar;
        f fVar;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (view != null && (view.getTag() instanceof h)) {
                    hVar = (h) view.getTag();
                } else {
                    view = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d039d, (ViewGroup) null);
                    hVar = new h(this, view);
                    view.setTag(hVar);
                }
                MarkData item = getItem(i);
                if (item == null) {
                    hVar.a.setVisibility(8);
                    return view;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.f16830h.getLayoutParams();
                if (this.f16818c) {
                    hVar.a.setVisibility(0);
                    layoutParams.leftMargin = 0;
                } else {
                    hVar.a.setVisibility(8);
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07020f);
                }
                hVar.a(item);
                o(i, hVar);
            } else if (itemViewType == 1) {
                if (view != null && (view.getTag() instanceof f)) {
                    fVar = (f) view.getTag();
                } else {
                    view = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0657, (ViewGroup) null);
                    fVar = new f(this, null);
                    fVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091643);
                    fVar.f16831b = (ProgressBar) view.findViewById(R.id.obfuscated_res_0x7f091929);
                    view.setTag(fVar);
                }
                fVar.a.setVisibility(0);
                if (this.f16822g) {
                    fVar.f16831b.setVisibility(0);
                    fVar.a.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0a2e));
                    SkinManager.setViewTextColor(fVar.a, R.color.common_color_10039, 1);
                } else if (!this.f16823h) {
                    fVar.f16831b.setVisibility(8);
                    fVar.a.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0c45));
                    SkinManager.setViewTextColor(fVar.a, R.color.common_color_10005, 1);
                } else {
                    fVar.f16831b.setVisibility(8);
                    fVar.a.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0a2e));
                    SkinManager.setViewTextColor(fVar.a, R.color.common_color_10039, 1);
                }
            } else if (itemViewType == 2) {
                if (view != null && (view.getTag() instanceof g)) {
                    gVar = (g) view.getTag();
                } else {
                    view = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01cf, (ViewGroup) null);
                    gVar = new g(this, view);
                    view.setTag(gVar);
                }
                MarkData item2 = getItem(i);
                if (item2 == null) {
                    gVar.a.setVisibility(8);
                    return view;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f16830h.getLayoutParams();
                if (this.f16818c) {
                    gVar.a.setVisibility(0);
                    layoutParams2.leftMargin = 0;
                } else {
                    gVar.a.setVisibility(8);
                    layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07020f);
                }
                gVar.a(item2);
                o(i, gVar);
                gVar.n.setSubClickListener(new b(this));
            }
            this.a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().j(view);
            c.a.p0.o2.c.b("c14062", getItem(i));
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: h */
    public MarkData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? (MarkData) ListUtils.getItem(this.f16817b, i) : (MarkData) invokeI.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.j == null) {
            return;
        }
        c.a.d.f.m.e.a().removeCallbacks(this.j);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (ListUtils.isEmpty(this.f16817b)) {
                return false;
            }
            if (this.f16823h || getItemViewType(i) != 1) {
                return super.isEnabled(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void j(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.f16817b.clear();
            if (arrayList != null) {
                this.f16817b.addAll(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f16819d = onClickListener;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f16818c = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.i = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f16823h = z;
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!n.B()) {
                if (this.j == null) {
                    this.j = new a(this);
                }
                c.a.d.f.m.e.a().post(this.j);
                return;
            }
            super.notifyDataSetChanged();
        }
    }

    public final void o(int i, C1260e c1260e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, c1260e) == null) {
            Integer valueOf = Integer.valueOf(i);
            c1260e.i.setOnClickListener(this.f16820e);
            c1260e.i.setTag(valueOf);
            c1260e.f16824b.setAfterClickListener(this.k);
            c1260e.f16824b.setTag(valueOf);
            c1260e.f16826d.setAfterOnClickListener(this.k);
            c1260e.f16826d.setAfterOnClickListener(this.l);
            c1260e.f16826d.setTag(valueOf);
            c1260e.j.setOnClickListener(this.f16821f);
            c1260e.j.setTag(valueOf);
            c1260e.a.setOnClickListener(this.f16819d);
            c1260e.a.setFocusable(false);
            c1260e.a.setTag(valueOf);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f16822g = z;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.f16821f = onClickListener;
        }
    }

    public void r(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.f16820e = onClickListener;
        }
    }
}
