package c.a.s0.j2;

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
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.s.r.i1;
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
/* loaded from: classes7.dex */
public class d extends c.a.s0.j2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f18229h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18230i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18231j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f18232k;
    public int l;
    public String m;
    public HashSet<Integer> n;
    public HashSet<Long> o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public NewMyFansUserLikeButton.b t;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1100d f18233e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f18234f;

        public a(d dVar, C1100d c1100d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1100d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18234f = dVar;
            this.f18233e = c1100d;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f18233e.f18238d.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f18233e.f18238d.setCompoundDrawablePadding(m.f(this.f18234f.f18229h, R.dimen.tbds10));
            } else {
                this.f18233e.f18238d.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton.b
        public void callback() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f18229h == null) {
                return;
            }
            this.a.f18229h.hideFollowSwitchGuideTip();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1100d f18235e;

        public c(d dVar, C1100d c1100d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1100d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18235e = c1100d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18235e.f18236b.playAnimation();
            }
        }
    }

    /* renamed from: c.a.s0.j2.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1100d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public TBLottieAnimationView f18236b;

        /* renamed from: c  reason: collision with root package name */
        public ClickableHeaderImageView f18237c;

        /* renamed from: d  reason: collision with root package name */
        public EMTextView f18238d;

        /* renamed from: e  reason: collision with root package name */
        public View f18239e;

        /* renamed from: f  reason: collision with root package name */
        public EMTextView f18240f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18241g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f18242h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f18243i;

        /* renamed from: j  reason: collision with root package name */
        public NewMyFansUserLikeButton f18244j;

        /* renamed from: k  reason: collision with root package name */
        public c.a.r0.s.i0.t.c f18245k;
        public ProgressBar l;
        public TextView m;
        public TextView n;
        public LinearLayout o;
        public EMTextView p;

        public C1100d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1100d(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personListActivity, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), onClickListener, onClickListener2, onClickListener3, onClickListener4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18229h = null;
        this.f18230i = false;
        this.f18231j = false;
        this.f18232k = true;
        this.l = 0;
        this.n = new HashSet<>();
        this.o = new HashSet<>();
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = new b(this);
        this.f18229h = personListActivity;
        this.f18231j = z;
        this.f18232k = z2;
        this.l = i2;
        this.p = onClickListener2;
        this.q = onClickListener3;
        this.r = onClickListener;
        this.s = onClickListener4;
        this.f18210e = new ArrayList<>();
    }

    @Override // c.a.s0.j2.b
    public void a(i1 i1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, i1Var) == null) || i1Var == null) {
            return;
        }
        this.m = i1Var.f13356i;
        ArrayList arrayList = new ArrayList();
        if (this.f18210e.isEmpty() && !ListUtils.isEmpty(i1Var.a())) {
            Iterator<UserData> it = i1Var.a().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.o.add(Long.valueOf(c.a.d.f.m.b.g(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(i1Var.a());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(i(i1Var.b()));
        this.f18210e.addAll(arrayList);
        if (this.f18210e.isEmpty() || this.f18210e.get(0).mAttentionType == 3) {
            return;
        }
        UserData userData2 = new UserData();
        userData2.mAttentionType = 3;
        this.f18210e.add(0, userData2);
    }

    @Override // c.a.s0.j2.b
    public boolean d(long j2) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            boolean z = false;
            if (j2 != 0 && (arrayList = this.f18210e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f18210e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j2) {
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
            if (this.f18230i) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f18210e;
            int size = arrayList != null ? arrayList.size() : 0;
            return c() ? size + 1 : size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f18210e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f18210e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f18210e;
            if (arrayList == null || i2 >= arrayList.size()) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.f18230i) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f18210e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            if (this.f18210e.get(i2).mAttentionType == 0) {
                return 2;
            }
            return this.f18210e.get(i2).mAttentionType == 3 ? 3 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1100d c1100d;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f18210e == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof C1100d)) {
                c1100d = (C1100d) view.getTag();
                j((UserData) ListUtils.getItem(this.f18210e, i2), c1100d, i2);
            } else {
                c1100d = new C1100d(this, null);
                if (getItemViewType(i2) == 0) {
                    view = LayoutInflater.from(this.f18229h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c1100d.a = viewGroup2;
                    viewGroup2.setOnClickListener(this.r);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c1100d.f18237c = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(m.f(this.f18229h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c1100d.f18237c.setAutoChangeStyle(true);
                    c1100d.f18237c.setGodIconWidth(R.dimen.tbds36);
                    c1100d.f18237c.setOnClickListener(this.s);
                    c1100d.f18237c.setTag(Integer.valueOf(i2));
                    TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
                    c1100d.f18236b = tBLottieAnimationView;
                    SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
                    j((UserData) ListUtils.getItem(this.f18210e, i2), c1100d, i2);
                    c1100d.f18242h = (LinearLayout) view.findViewById(R.id.info);
                    c1100d.f18243i = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c1100d.f18238d = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c1100d));
                    View a2 = c.a.r0.e.c.b().a(this.f18229h.getPageContext().getPageActivity(), 5);
                    c1100d.f18239e = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c1100d.f18243i.addView(c1100d.f18239e, 1);
                    }
                    c1100d.m = (TextView) view.findViewById(R.id.at_list_nodata);
                    c1100d.f18240f = (EMTextView) view.findViewById(R.id.intro);
                    TextView textView = (TextView) view.findViewById(R.id.chat);
                    c1100d.f18241g = textView;
                    textView.setOnClickListener(this.p);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c1100d.f18244j = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f18229h.getPageContext());
                    c1100d.f18244j.setCallback(this.t);
                    c1100d.f18245k = new c.a.r0.s.i0.t.c(this.f18229h.getPageContext(), c1100d.f18244j);
                    c1100d.l = null;
                    c1100d.n = null;
                    c1100d.o = null;
                } else if (getItemViewType(i2) == 2) {
                    view = LayoutInflater.from(this.f18229h.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    c1100d.n = (TextView) view.findViewById(R.id.person_list_title);
                    c1100d.o = (LinearLayout) view.findViewById(R.id.newheader_root);
                } else if (getItemViewType(i2) == 3) {
                    view = LayoutInflater.from(this.f18229h.getPageContext().getPageActivity()).inflate(R.layout.attention_list_follow_from_title, (ViewGroup) null);
                    c1100d.p = (EMTextView) view.findViewById(R.id.attention_follow_tip_text);
                } else {
                    view = LayoutInflater.from(this.f18229h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c1100d.f18238d = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.q);
                    c1100d.l = (ProgressBar) view.findViewById(R.id.progress);
                    c1100d.n = null;
                    c1100d.o = null;
                }
                view.setTag(c1100d);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1100d.f18244j;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            ClickableHeaderImageView clickableHeaderImageView2 = c1100d.f18237c;
            if (clickableHeaderImageView2 != null) {
                clickableHeaderImageView2.setTag(Integer.valueOf(i2));
            }
            if (getItemViewType(i2) == 0) {
                if (this.f18230i) {
                    c1100d.f18242h.setVisibility(8);
                    c1100d.f18241g.setVisibility(8);
                    c1100d.m.setVisibility(0);
                    if (this.f18231j) {
                        if (this.f18232k) {
                            c1100d.m.setText(R.string.not_have_attention);
                        } else {
                            int i3 = this.l;
                            if (i3 == 2) {
                                c1100d.m.setText(R.string.her_no_attention_other);
                            } else if (i3 == 1) {
                                c1100d.m.setText(R.string.him_no_attention_other);
                            } else {
                                c1100d.m.setText(R.string.no_attention_other);
                            }
                        }
                    } else if (this.f18232k) {
                        c1100d.m.setText(R.string.not_have_fans);
                    } else {
                        int i4 = this.l;
                        if (i4 == 2) {
                            c1100d.m.setText(R.string.her_no_fan_other);
                        } else if (i4 == 1) {
                            c1100d.m.setText(R.string.him_no_fan_other);
                        } else {
                            c1100d.m.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    UserData userData = (UserData) ListUtils.getItem(this.f18210e, i2);
                    if (userData == null) {
                        return null;
                    }
                    c1100d.a.setTag(Integer.valueOf(i2));
                    c1100d.f18241g.setVisibility(0);
                    c1100d.m.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c1100d.f18237c, userData, 0);
                    c1100d.f18238d.setText(UtilHelper.getUserName(userData));
                    c1100d.f18237c.setPlaceHolder(1);
                    c1100d.f18237c.startLoad(userData.getAvater(), 12, false);
                    if (c1100d.f18239e != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c1100d.f18239e.setVisibility(8);
                        } else {
                            c1100d.f18239e.setVisibility(0);
                            c.a.r0.e.b bVar = new c.a.r0.e.b();
                            bVar.a = userData.getAlaUserData();
                            bVar.f12284b = 5;
                            c1100d.f18239e.setTag(bVar);
                        }
                    }
                    if (l.isEmpty(userData.getIntro())) {
                        c1100d.f18240f.setVisibility(8);
                    } else {
                        c1100d.f18240f.setVisibility(0);
                        EMTextView eMTextView2 = c1100d.f18240f;
                        if (TextUtils.isEmpty(userData.getFollowFrom()) && this.f18232k) {
                            str = userData.getIntro();
                        } else {
                            str = userData.getFollowFrom() + " " + userData.getIntro();
                        }
                        eMTextView2.setText(str);
                    }
                    c1100d.f18241g.setTag(Integer.valueOf(i2));
                    String userId = userData.getUserId();
                    c1100d.f18244j.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c1100d.f18245k.n(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        c1100d.f18244j.setVisibility(8);
                        c1100d.f18241g.setVisibility(8);
                    } else {
                        c1100d.f18241g.setVisibility(8);
                        c1100d.f18244j.setVisibility(0);
                    }
                }
                c1100d.l = null;
            } else if (getItemViewType(i2) == 3) {
                if (!this.f18232k || TextUtils.isEmpty(this.m)) {
                    c1100d.p.setVisibility(8);
                }
                c1100d.p.setText(this.m);
            } else if (getItemViewType(i2) == 2) {
                c1100d.n.setText(this.m);
            } else if (getItemViewType(i2) != 2 || getItemViewType(i2) != 3) {
                c1100d.f18238d.setText(this.f18229h.getPageContext().getString(R.string.loading));
                c1100d.l.setVisibility(0);
            }
            h(view, c1100d);
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

    public final void h(View view, C1100d c1100d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c1100d) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f18229h.getLayoutMode().k(skinType == 1);
            this.f18229h.getLayoutMode().j(view);
            if (c1100d != null) {
                TextView textView = c1100d.f18241g;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                    SkinManager.setBackgroundResource(c1100d.f18241g, R.drawable.btn_focus_border_bg);
                    c1100d.f18241g.setEnabled(true);
                }
                LinearLayout linearLayout = c1100d.o;
                if (linearLayout != null && c1100d.n != null) {
                    SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(c1100d.n, R.color.CAM_X0110);
                }
                EMTextView eMTextView = c1100d.p;
                if (eMTextView != null) {
                    SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0105);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c1100d.f18244j;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.onChangeSkinType(skinType);
                }
                TBLottieAnimationView tBLottieAnimationView = c1100d.f18236b;
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
            if (ListUtils.isEmpty(arrayList) || this.o.isEmpty()) {
                return arrayList;
            }
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.o.contains(Long.valueOf(c.a.d.f.m.b.g(next.getUserId(), 0L)))) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (this.f18230i) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }

    public final void j(UserData userData, C1100d c1100d, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048587, this, userData, c1100d, i2) == null) || userData == null || c1100d == null) {
            return;
        }
        if (userData.getAlaUserData() != null && userData.getAlaUserData().live_status == 1) {
            c1100d.f18236b.setSpeed(0.8f);
            c1100d.f18236b.setVisibility(0);
            c1100d.f18236b.loop(true);
            c1100d.f18236b.post(new c(this, c1100d));
            if (this.n.contains(Integer.valueOf(i2))) {
                return;
            }
            e.a(!this.f18232k ? "c14284" : "c14285", userData);
            this.n.add(Integer.valueOf(i2));
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = c1100d.f18236b;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setVisibility(4);
            c1100d.f18236b.cancelAnimation();
        }
    }
}
