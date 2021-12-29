package c.a.t0.k2;

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
import c.a.s0.s.k;
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
/* loaded from: classes7.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static final float q;
    public static final float r;
    public static final float s;
    public static final int t;
    public static final int u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f19205e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<MarkData> f19206f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19207g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f19208h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f19209i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f19210j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f19211k;
    public boolean l;
    public boolean m;
    public Runnable n;
    public final View.OnClickListener o;
    public View.OnClickListener p;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f19212e;

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
            this.f19212e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19212e.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f19213e;

        public c(e eVar) {
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
            this.f19213e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MarkData item = this.f19213e.getItem(((Integer) view.getTag()).intValue());
                StatisticItem statisticItem = new StatisticItem("c12529");
                if (view instanceof CommonUserLikeButton) {
                    statisticItem.param("obj_locate", 4);
                } else if (view instanceof ClickableHeaderImageView) {
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", item.getId());
                statisticItem.param("obj_id", item.getUesrId());
                TiebaStatic.log(statisticItem);
                c.a.t0.k2.c.b("c14064", item);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f19214e;

        public d(e eVar) {
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
            this.f19214e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.k2.c.b("c14065", this.f19214e.getItem(((Integer) view.getTag()).intValue()));
            }
        }
    }

    /* renamed from: c.a.t0.k2.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1151e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageButton a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f19215b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19216c;

        /* renamed from: d  reason: collision with root package name */
        public CommonUserLikeButton f19217d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19218e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f19219f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f19220g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f19221h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f19222i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f19223j;

        /* renamed from: k  reason: collision with root package name */
        public View f19224k;
        public c.a.s0.s.i0.t.c l;
        public final /* synthetic */ e m;

        public C1151e(e eVar) {
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
                    this.f19218e.setText(title);
                    this.f19218e.setTextSize(0, e.q);
                    SkinManager.setViewTextColor(this.f19218e, R.color.CAM_X0110);
                } else {
                    this.f19218e.setText(title);
                    this.f19218e.setTextSize(0, e.r);
                    SkinManager.setViewTextColor(this.f19218e, R.color.CAM_X0105);
                }
            } else {
                this.f19218e.setText("");
            }
            c(markData);
            this.f19215b.setData(markData.metaData);
            this.f19215b.setShowV(markData.metaData.isBigV());
            this.l.n(markData.metaData);
            this.f19217d.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.f19217d.setTextSize(0, e.s);
            if ((markData.metaData.getIsLike() || StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                this.f19217d.setVisibility(8);
            } else {
                this.f19217d.setVisibility(0);
            }
            if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                this.f19223j.setVisibility(0);
                if (markData.isRedTipShow() && !markData.is_deleted()) {
                    this.f19220g.setVisibility(0);
                } else {
                    this.f19220g.setVisibility(8);
                }
                if (markData.is_deleted()) {
                    this.f19219f.setText(this.m.f19205e.getString(R.string.mark_thread_deleted));
                } else {
                    this.f19219f.setText(markData.getmState());
                }
                SkinManager.setViewTextColor(this.f19219f, R.color.CAM_X0109);
            } else {
                this.f19223j.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.f19224k, R.color.CAM_X0204);
        }

        public void b(ClickableHeaderImageView clickableHeaderImageView) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickableHeaderImageView) == null) || clickableHeaderImageView == null) {
                return;
            }
            clickableHeaderImageView.setDefaultResource(17170445);
            clickableHeaderImageView.setPlaceHolder(1);
            clickableHeaderImageView.setIsRound(true);
            clickableHeaderImageView.setAfterClickListener(this.m.o);
        }

        public final void c(MarkData markData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, markData) == null) || markData == null) {
                return;
            }
            this.f19216c.setText(markData.getAuthorName());
            if (markData.metaData.isBigV()) {
                SkinManager.setViewTextColor(this.f19216c, R.color.CAM_X0301);
            } else {
                SkinManager.setViewTextColor(this.f19216c, R.color.CAM_X0106);
            }
        }

        public /* synthetic */ C1151e(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* loaded from: classes7.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f19225b;

        public f(e eVar) {
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
                }
            }
        }

        public /* synthetic */ f(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* loaded from: classes7.dex */
    public class g extends C1151e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((e) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19221h = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.a = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.f19215b = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.f19216c = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.f19217d = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.l = new c.a.s0.s.i0.t.c(eVar.f19205e, this.f19217d);
            this.f19222i = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.f19218e = (TextView) view.findViewById(R.id.share_thread_title);
            this.n = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.f19219f = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.f19220g = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.f19223j = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.f19224k = view.findViewById(R.id.share_text_divider);
            b(this.f19215b);
        }

        @Override // c.a.t0.k2.e.C1151e
        public void a(MarkData markData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, markData) == null) {
                super.a(markData);
                this.n.fillData(markData.getOriginalThreadInfo());
                this.n.onChangeSkinType();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                    layoutParams.bottomMargin = (int) e.q;
                } else {
                    layoutParams.bottomMargin = 0;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends C1151e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((e) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19221h = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.f19215b = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.f19216c = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.f19222i = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.o = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.f19217d = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.l = new c.a.s0.s.i0.t.c(eVar.f19205e, this.f19217d);
            this.n = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.f19218e = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.f19219f = (TextView) view.findViewById(R.id.markitem_state_text);
            this.a = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.f19220g = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.f19223j = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.f19224k = view.findViewById(R.id.text_divider);
            b(this.f19215b);
            this.n.setPlaceHolder(1);
        }

        @Override // c.a.t0.k2.e.C1151e
        public void a(MarkData markData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, markData) == null) {
                super.a(markData);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19222i.getLayoutParams();
                if (k.c().g() && !StringUtils.isNull(markData.getPic_url())) {
                    String pic_url = markData.getPic_url();
                    if (!StringUtils.isNull(pic_url)) {
                        this.n.setVisibility(0);
                        this.n.startLoad(pic_url, 10, false);
                    }
                    layoutParams.bottomMargin = e.t;
                } else {
                    this.n.setVisibility(8);
                    layoutParams.bottomMargin = e.u;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
                if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                    layoutParams2.bottomMargin = (int) e.q;
                } else {
                    layoutParams2.bottomMargin = 0;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(979137073, "Lc/a/t0/k2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(979137073, "Lc/a/t0/k2/e;");
                return;
            }
        }
        q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
        r = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
        s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
        t = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
        u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    }

    public e(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19206f = new ArrayList<>();
        this.f19207g = false;
        this.f19208h = null;
        this.f19209i = null;
        this.f19210j = null;
        this.f19211k = false;
        this.l = true;
        this.m = true;
        this.o = new c(this);
        this.p = new d(this);
        this.f19205e = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (ListUtils.isEmpty(this.f19206f)) {
                return 0;
            }
            return this.m ? ListUtils.getCount(this.f19206f) + 1 : ListUtils.getCount(this.f19206f);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (ListUtils.getCount(this.f19206f) <= i2) {
                return -1L;
            }
            return i2;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            MarkData item = getItem(i2);
            if (item == null) {
                return 1;
            }
            return item.isShareThread() ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1151e hVar;
        f fVar;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (view != null && (view.getTag() instanceof h)) {
                    hVar = (h) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f19205e.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    hVar = new h(this, view);
                    view.setTag(hVar);
                }
                MarkData item = getItem(i2);
                if (item == null) {
                    hVar.a.setVisibility(8);
                    return view;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.f19221h.getLayoutParams();
                if (this.f19207g) {
                    hVar.a.setVisibility(0);
                    layoutParams.leftMargin = 0;
                } else {
                    hVar.a.setVisibility(8);
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                }
                hVar.a(item);
                o(i2, hVar);
            } else if (itemViewType == 1) {
                if (view != null && (view.getTag() instanceof f)) {
                    fVar = (f) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f19205e.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    fVar = new f(this, null);
                    fVar.a = (TextView) view.findViewById(R.id.page_text);
                    fVar.f19225b = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(fVar);
                }
                fVar.a.setVisibility(0);
                if (this.f19211k) {
                    fVar.f19225b.setVisibility(0);
                    fVar.a.setText(this.f19205e.getString(R.string.loading));
                    SkinManager.setViewTextColor(fVar.a, R.color.common_color_10039, 1);
                } else if (!this.l) {
                    fVar.f19225b.setVisibility(8);
                    fVar.a.setText(this.f19205e.getString(R.string.no_more_mark));
                    SkinManager.setViewTextColor(fVar.a, R.color.common_color_10005, 1);
                } else {
                    fVar.f19225b.setVisibility(8);
                    fVar.a.setText(this.f19205e.getString(R.string.loading));
                    SkinManager.setViewTextColor(fVar.a, R.color.common_color_10039, 1);
                }
            } else if (itemViewType == 2) {
                if (view != null && (view.getTag() instanceof g)) {
                    gVar = (g) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f19205e.getPageActivity()).inflate(R.layout.cell_collect_share_view, (ViewGroup) null);
                    gVar = new g(this, view);
                    view.setTag(gVar);
                }
                MarkData item2 = getItem(i2);
                if (item2 == null) {
                    gVar.a.setVisibility(8);
                    return view;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f19221h.getLayoutParams();
                if (this.f19207g) {
                    gVar.a.setVisibility(0);
                    layoutParams2.leftMargin = 0;
                } else {
                    gVar.a.setVisibility(8);
                    layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                }
                gVar.a(item2);
                o(i2, gVar);
                gVar.n.setSubClickListener(new b(this));
            }
            this.f19205e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f19205e.getLayoutMode().j(view);
            c.a.t0.k2.c.b("c14062", getItem(i2));
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
    public MarkData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? (MarkData) ListUtils.getItem(this.f19206f, i2) : (MarkData) invokeI.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.n == null) {
            return;
        }
        c.a.d.f.m.e.a().removeCallbacks(this.n);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f19206f)) {
                return false;
            }
            if (this.l || getItemViewType(i2) != 1) {
                return super.isEnabled(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void j(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.f19206f.clear();
            if (arrayList != null) {
                this.f19206f.addAll(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f19208h = onClickListener;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f19207g = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.m = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.l = z;
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!n.B()) {
                if (this.n == null) {
                    this.n = new a(this);
                }
                c.a.d.f.m.e.a().post(this.n);
                return;
            }
            super.notifyDataSetChanged();
        }
    }

    public final void o(int i2, C1151e c1151e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, c1151e) == null) {
            Integer valueOf = Integer.valueOf(i2);
            c1151e.f19222i.setOnClickListener(this.f19209i);
            c1151e.f19222i.setTag(valueOf);
            c1151e.f19215b.setAfterClickListener(this.o);
            c1151e.f19215b.setTag(valueOf);
            c1151e.f19217d.setAfterOnClickListener(this.o);
            c1151e.f19217d.setAfterOnClickListener(this.p);
            c1151e.f19217d.setTag(valueOf);
            c1151e.f19223j.setOnClickListener(this.f19210j);
            c1151e.f19223j.setTag(valueOf);
            c1151e.a.setOnClickListener(this.f19208h);
            c1151e.a.setFocusable(false);
            c1151e.a.setTag(valueOf);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f19211k = z;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.f19210j = onClickListener;
        }
    }

    public void r(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.f19209i = onClickListener;
        }
    }
}
