package c.a.p0.n2;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.r.g1;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton;
import com.baidu.tieba.myAttentionAndFans.PersonListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class d extends c.a.p0.n2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public PersonListActivity f16548d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16549e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16550f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16551g;

    /* renamed from: h  reason: collision with root package name */
    public int f16552h;
    public String i;
    public HashSet<Integer> j;
    public HashSet<Long> k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public NewMyFansUserLikeButton.b p;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ C1240d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f16553b;

        public a(d dVar, C1240d c1240d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1240d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16553b = dVar;
            this.a = c1240d;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.a.f16556d.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.a.f16556d.setCompoundDrawablePadding(n.f(this.f16553b.f16548d, R.dimen.tbds10));
            } else {
                this.a.f16556d.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements NewMyFansUserLikeButton.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f16548d == null) {
                return;
            }
            this.a.f16548d.hideFollowSwitchGuideTip();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ C1240d a;

        public c(d dVar, C1240d c1240d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1240d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c1240d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f16554b.playAnimation();
            }
        }
    }

    /* renamed from: c.a.p0.n2.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1240d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public TBLottieAnimationView f16554b;

        /* renamed from: c  reason: collision with root package name */
        public ClickableHeaderImageView f16555c;

        /* renamed from: d  reason: collision with root package name */
        public EMTextView f16556d;

        /* renamed from: e  reason: collision with root package name */
        public View f16557e;

        /* renamed from: f  reason: collision with root package name */
        public EMTextView f16558f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16559g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f16560h;
        public LinearLayout i;
        public NewMyFansUserLikeButton j;
        public c.a.o0.r.l0.t.c k;
        public ProgressBar l;
        public TextView m;
        public TextView n;
        public LinearLayout o;
        public EMTextView p;

        public C1240d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1240d(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personListActivity, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), onClickListener, onClickListener2, onClickListener3, onClickListener4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16548d = null;
        this.f16549e = false;
        this.f16550f = false;
        this.f16551g = true;
        this.f16552h = 0;
        this.j = new HashSet<>();
        this.k = new HashSet<>();
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = new b(this);
        this.f16548d = personListActivity;
        this.f16550f = z;
        this.f16551g = z2;
        this.f16552h = i;
        this.l = onClickListener2;
        this.m = onClickListener3;
        this.n = onClickListener;
        this.o = onClickListener4;
        this.a = new ArrayList<>();
    }

    @Override // c.a.p0.n2.b
    public void a(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, g1Var) == null) || g1Var == null) {
            return;
        }
        this.i = g1Var.i;
        ArrayList arrayList = new ArrayList();
        if (this.a.isEmpty() && !ListUtils.isEmpty(g1Var.a())) {
            Iterator<UserData> it = g1Var.a().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.k.add(Long.valueOf(c.a.d.f.m.b.g(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(g1Var.a());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(i(g1Var.b()));
        this.a.addAll(arrayList);
        if (this.a.isEmpty() || this.a.get(0).mAttentionType == 3) {
            return;
        }
        UserData userData2 = new UserData();
        userData2.mAttentionType = 3;
        this.a.add(0, userData2);
    }

    @Override // c.a.p0.n2.b
    public boolean d(long j) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            boolean z = false;
            if (j != 0 && (arrayList = this.a) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j) {
                        z = true;
                        if (next.getLikeStatus() == 2) {
                            next.setLikeStatus(1);
                        }
                    }
                }
            }
            return z;
        }
        return invokeJ.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f16549e) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.a;
            int size = arrayList != null ? arrayList.size() : 0;
            return c() ? size + 1 : size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (this.f16549e) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return 1;
            }
            if (this.a.get(i).mAttentionType == 0) {
                return 2;
            }
            return this.a.get(i).mAttentionType == 3 ? 3 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1240d c1240d;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (this.a == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof C1240d)) {
                c1240d = (C1240d) view.getTag();
                j((UserData) ListUtils.getItem(this.a, i), c1240d, i);
            } else {
                c1240d = new C1240d(this, null);
                if (getItemViewType(i) == 0) {
                    view = LayoutInflater.from(this.f16548d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06ca, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.obfuscated_res_0x7f090fb2);
                    c1240d.a = viewGroup2;
                    viewGroup2.setOnClickListener(this.n);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.obfuscated_res_0x7f091827);
                    c1240d.f16555c = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(n.f(this.f16548d.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070301));
                    c1240d.f16555c.setAutoChangeStyle(true);
                    c1240d.f16555c.setGodIconWidth(R.dimen.tbds36);
                    c1240d.f16555c.setOnClickListener(this.o);
                    c1240d.f16555c.setTag(Integer.valueOf(i));
                    TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.obfuscated_res_0x7f0922b9);
                    c1240d.f16554b = tBLottieAnimationView;
                    SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
                    j((UserData) ListUtils.getItem(this.a, i), c1240d, i);
                    c1240d.f16560h = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090ef3);
                    c1240d.i = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091ec3);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f0914e9);
                    c1240d.f16556d = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c1240d));
                    View a2 = c.a.o0.d.c.b().a(this.f16548d.getPageContext().getPageActivity(), 5);
                    c1240d.f16557e = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c1240d.i.addView(c1240d.f16557e, 1);
                    }
                    c1240d.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0902b2);
                    c1240d.f16558f = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f090f47);
                    TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0905f4);
                    c1240d.f16559g = textView;
                    textView.setOnClickListener(this.l);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.obfuscated_res_0x7f0902bd);
                    c1240d.j = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f16548d.getPageContext());
                    c1240d.j.setCallback(this.p);
                    c1240d.k = new c.a.o0.r.l0.t.c(this.f16548d.getPageContext(), c1240d.j);
                    c1240d.l = null;
                    c1240d.n = null;
                    c1240d.o = null;
                } else if (getItemViewType(i) == 2) {
                    view = LayoutInflater.from(this.f16548d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06cc, (ViewGroup) null);
                    c1240d.n = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0917ef);
                    c1240d.o = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f09156a);
                } else if (getItemViewType(i) == 3) {
                    view = LayoutInflater.from(this.f16548d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0126, (ViewGroup) null);
                    c1240d.p = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f0902bf);
                } else {
                    view = LayoutInflater.from(this.f16548d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
                    c1240d.f16556d = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f0916ed);
                    view.setOnClickListener(this.m);
                    c1240d.l = (ProgressBar) view.findViewById(R.id.obfuscated_res_0x7f091929);
                    c1240d.n = null;
                    c1240d.o = null;
                }
                view.setTag(c1240d);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1240d.j;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i));
            }
            ClickableHeaderImageView clickableHeaderImageView2 = c1240d.f16555c;
            if (clickableHeaderImageView2 != null) {
                clickableHeaderImageView2.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.f16549e) {
                    c1240d.f16560h.setVisibility(8);
                    c1240d.f16559g.setVisibility(8);
                    c1240d.m.setVisibility(0);
                    if (this.f16550f) {
                        if (this.f16551g) {
                            c1240d.m.setText(R.string.obfuscated_res_0x7f0f0c6e);
                        } else {
                            int i2 = this.f16552h;
                            if (i2 == 2) {
                                c1240d.m.setText(R.string.obfuscated_res_0x7f0f0820);
                            } else if (i2 == 1) {
                                c1240d.m.setText(R.string.obfuscated_res_0x7f0f0824);
                            } else {
                                c1240d.m.setText(R.string.obfuscated_res_0x7f0f0c26);
                            }
                        }
                    } else if (this.f16551g) {
                        c1240d.m.setText(R.string.obfuscated_res_0x7f0f0c71);
                    } else {
                        int i3 = this.f16552h;
                        if (i3 == 2) {
                            c1240d.m.setText(R.string.obfuscated_res_0x7f0f0822);
                        } else if (i3 == 1) {
                            c1240d.m.setText(R.string.obfuscated_res_0x7f0f0825);
                        } else {
                            c1240d.m.setText(R.string.obfuscated_res_0x7f0f0c36);
                        }
                    }
                } else {
                    UserData userData = (UserData) ListUtils.getItem(this.a, i);
                    if (userData == null) {
                        return null;
                    }
                    c1240d.a.setTag(Integer.valueOf(i));
                    c1240d.f16559g.setVisibility(0);
                    c1240d.m.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c1240d.f16555c, userData, 0);
                    c1240d.f16556d.setText(UtilHelper.getUserName(userData));
                    c1240d.f16555c.setPlaceHolder(1);
                    c1240d.f16555c.J(userData.getAvater(), 12, false);
                    if (c1240d.f16557e != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c1240d.f16557e.setVisibility(8);
                        } else {
                            c1240d.f16557e.setVisibility(0);
                            c.a.o0.d.b bVar = new c.a.o0.d.b();
                            bVar.a = userData.getAlaUserData();
                            bVar.f9997b = 5;
                            c1240d.f16557e.setTag(bVar);
                        }
                    }
                    if (m.isEmpty(userData.getIntro())) {
                        c1240d.f16558f.setVisibility(8);
                    } else {
                        c1240d.f16558f.setVisibility(0);
                        EMTextView eMTextView2 = c1240d.f16558f;
                        if (TextUtils.isEmpty(userData.getFollowFrom()) && this.f16551g) {
                            str = userData.getIntro();
                        } else {
                            str = userData.getFollowFrom() + " " + userData.getIntro();
                        }
                        eMTextView2.setText(str);
                    }
                    c1240d.f16559g.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    c1240d.j.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c1240d.k.n(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        c1240d.j.setVisibility(8);
                        c1240d.f16559g.setVisibility(8);
                    } else {
                        c1240d.f16559g.setVisibility(8);
                        c1240d.j.setVisibility(0);
                    }
                }
                c1240d.l = null;
            } else if (getItemViewType(i) == 3) {
                if (!this.f16551g || TextUtils.isEmpty(this.i)) {
                    c1240d.p.setVisibility(8);
                }
                c1240d.p.setText(this.i);
            } else if (getItemViewType(i) == 2) {
                c1240d.n.setText(this.i);
            } else if (getItemViewType(i) != 2 || getItemViewType(i) != 3) {
                c1240d.f16556d.setText(this.f16548d.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a2e));
                c1240d.l.setVisibility(0);
            }
            h(view, c1240d);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    public final void h(View view, C1240d c1240d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c1240d) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f16548d.getLayoutMode().k(skinType == 1);
            this.f16548d.getLayoutMode().j(view);
            if (c1240d != null) {
                TextView textView = c1240d.f16559g;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                    SkinManager.setBackgroundResource(c1240d.f16559g, R.drawable.btn_focus_border_bg);
                    c1240d.f16559g.setEnabled(true);
                }
                LinearLayout linearLayout = c1240d.o;
                if (linearLayout != null && c1240d.n != null) {
                    SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(c1240d.n, (int) R.color.CAM_X0110);
                }
                EMTextView eMTextView = c1240d.p;
                if (eMTextView != null) {
                    SkinManager.setViewTextColor(eMTextView, (int) R.color.CAM_X0105);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c1240d.j;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.r(skinType);
                }
                TBLottieAnimationView tBLottieAnimationView = c1240d.f16554b;
                if (tBLottieAnimationView != null) {
                    SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
                }
            }
        }
    }

    public final ArrayList<UserData> i(ArrayList<UserData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, arrayList)) == null) {
            if (ListUtils.isEmpty(arrayList) || this.k.isEmpty()) {
                return arrayList;
            }
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.k.contains(Long.valueOf(c.a.d.f.m.b.g(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.f16549e) {
                return false;
            }
            return super.isEnabled(i);
        }
        return invokeI.booleanValue;
    }

    public final void j(UserData userData, C1240d c1240d, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048587, this, userData, c1240d, i) == null) || userData == null || c1240d == null) {
            return;
        }
        if (userData.getAlaUserData() != null && userData.getAlaUserData().live_status == 1) {
            c1240d.f16554b.setSpeed(0.8f);
            c1240d.f16554b.setVisibility(0);
            c1240d.f16554b.loop(true);
            c1240d.f16554b.post(new c(this, c1240d));
            if (this.j.contains(Integer.valueOf(i))) {
                return;
            }
            e.a(!this.f16551g ? "c14284" : "c14285", userData);
            this.j.add(Integer.valueOf(i));
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = c1240d.f16554b;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setVisibility(4);
            c1240d.f16554b.cancelAnimation();
        }
    }
}
