package c.a.r0.l2;

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
import c.a.q0.r.r.i1;
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
public class d extends c.a.r0.l2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f18929h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18930i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18931j;
    public boolean k;
    public int l;
    public String m;
    public HashSet<Integer> n;
    public HashSet<Long> o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public NewMyFansUserLikeButton.b t;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1186d f18932e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f18933f;

        public a(d dVar, C1186d c1186d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1186d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18933f = dVar;
            this.f18932e = c1186d;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f18932e.f18937d.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f18932e.f18937d.setCompoundDrawablePadding(n.f(this.f18933f.f18929h, R.dimen.tbds10));
            } else {
                this.f18932e.f18937d.setCompoundDrawablePadding(0);
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f18929h == null) {
                return;
            }
            this.a.f18929h.hideFollowSwitchGuideTip();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1186d f18934e;

        public c(d dVar, C1186d c1186d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c1186d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18934e = c1186d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18934e.f18935b.playAnimation();
            }
        }
    }

    /* renamed from: c.a.r0.l2.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1186d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public TBLottieAnimationView f18935b;

        /* renamed from: c  reason: collision with root package name */
        public ClickableHeaderImageView f18936c;

        /* renamed from: d  reason: collision with root package name */
        public EMTextView f18937d;

        /* renamed from: e  reason: collision with root package name */
        public View f18938e;

        /* renamed from: f  reason: collision with root package name */
        public EMTextView f18939f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18940g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f18941h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f18942i;

        /* renamed from: j  reason: collision with root package name */
        public NewMyFansUserLikeButton f18943j;
        public c.a.q0.r.l0.t.c k;
        public ProgressBar l;
        public TextView m;
        public TextView n;
        public LinearLayout o;
        public EMTextView p;

        public C1186d(d dVar) {
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

        public /* synthetic */ C1186d(d dVar, a aVar) {
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
        this.f18929h = null;
        this.f18930i = false;
        this.f18931j = false;
        this.k = true;
        this.l = 0;
        this.n = new HashSet<>();
        this.o = new HashSet<>();
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = new b(this);
        this.f18929h = personListActivity;
        this.f18931j = z;
        this.k = z2;
        this.l = i2;
        this.p = onClickListener2;
        this.q = onClickListener3;
        this.r = onClickListener;
        this.s = onClickListener4;
        this.f18912e = new ArrayList<>();
    }

    @Override // c.a.r0.l2.b
    public void a(i1 i1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, i1Var) == null) || i1Var == null) {
            return;
        }
        this.m = i1Var.f13304i;
        ArrayList arrayList = new ArrayList();
        if (this.f18912e.isEmpty() && !ListUtils.isEmpty(i1Var.a())) {
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
        this.f18912e.addAll(arrayList);
        if (this.f18912e.isEmpty() || this.f18912e.get(0).mAttentionType == 3) {
            return;
        }
        UserData userData2 = new UserData();
        userData2.mAttentionType = 3;
        this.f18912e.add(0, userData2);
    }

    @Override // c.a.r0.l2.b
    public boolean d(long j2) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            boolean z = false;
            if (j2 != 0 && (arrayList = this.f18912e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f18912e.iterator();
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
            if (this.f18930i) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f18912e;
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
            ArrayList<UserData> arrayList = this.f18912e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f18912e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f18912e;
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
            if (this.f18930i) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f18912e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            if (this.f18912e.get(i2).mAttentionType == 0) {
                return 2;
            }
            return this.f18912e.get(i2).mAttentionType == 3 ? 3 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1186d c1186d;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f18912e == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof C1186d)) {
                c1186d = (C1186d) view.getTag();
                j((UserData) ListUtils.getItem(this.f18912e, i2), c1186d, i2);
            } else {
                c1186d = new C1186d(this, null);
                if (getItemViewType(i2) == 0) {
                    view = LayoutInflater.from(this.f18929h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c1186d.a = viewGroup2;
                    viewGroup2.setOnClickListener(this.r);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c1186d.f18936c = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(n.f(this.f18929h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c1186d.f18936c.setAutoChangeStyle(true);
                    c1186d.f18936c.setGodIconWidth(R.dimen.tbds36);
                    c1186d.f18936c.setOnClickListener(this.s);
                    c1186d.f18936c.setTag(Integer.valueOf(i2));
                    TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
                    c1186d.f18935b = tBLottieAnimationView;
                    SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
                    j((UserData) ListUtils.getItem(this.f18912e, i2), c1186d, i2);
                    c1186d.f18941h = (LinearLayout) view.findViewById(R.id.info);
                    c1186d.f18942i = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c1186d.f18937d = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c1186d));
                    View a2 = c.a.q0.d.c.b().a(this.f18929h.getPageContext().getPageActivity(), 5);
                    c1186d.f18938e = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c1186d.f18942i.addView(c1186d.f18938e, 1);
                    }
                    c1186d.m = (TextView) view.findViewById(R.id.at_list_nodata);
                    c1186d.f18939f = (EMTextView) view.findViewById(R.id.intro);
                    TextView textView = (TextView) view.findViewById(R.id.chat);
                    c1186d.f18940g = textView;
                    textView.setOnClickListener(this.p);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c1186d.f18943j = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f18929h.getPageContext());
                    c1186d.f18943j.setCallback(this.t);
                    c1186d.k = new c.a.q0.r.l0.t.c(this.f18929h.getPageContext(), c1186d.f18943j);
                    c1186d.l = null;
                    c1186d.n = null;
                    c1186d.o = null;
                } else if (getItemViewType(i2) == 2) {
                    view = LayoutInflater.from(this.f18929h.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    c1186d.n = (TextView) view.findViewById(R.id.person_list_title);
                    c1186d.o = (LinearLayout) view.findViewById(R.id.newheader_root);
                } else if (getItemViewType(i2) == 3) {
                    view = LayoutInflater.from(this.f18929h.getPageContext().getPageActivity()).inflate(R.layout.attention_list_follow_from_title, (ViewGroup) null);
                    c1186d.p = (EMTextView) view.findViewById(R.id.attention_follow_tip_text);
                } else {
                    view = LayoutInflater.from(this.f18929h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c1186d.f18937d = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.q);
                    c1186d.l = (ProgressBar) view.findViewById(R.id.progress);
                    c1186d.n = null;
                    c1186d.o = null;
                }
                view.setTag(c1186d);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1186d.f18943j;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            ClickableHeaderImageView clickableHeaderImageView2 = c1186d.f18936c;
            if (clickableHeaderImageView2 != null) {
                clickableHeaderImageView2.setTag(Integer.valueOf(i2));
            }
            if (getItemViewType(i2) == 0) {
                if (this.f18930i) {
                    c1186d.f18941h.setVisibility(8);
                    c1186d.f18940g.setVisibility(8);
                    c1186d.m.setVisibility(0);
                    if (this.f18931j) {
                        if (this.k) {
                            c1186d.m.setText(R.string.not_have_attention);
                        } else {
                            int i3 = this.l;
                            if (i3 == 2) {
                                c1186d.m.setText(R.string.her_no_attention_other);
                            } else if (i3 == 1) {
                                c1186d.m.setText(R.string.him_no_attention_other);
                            } else {
                                c1186d.m.setText(R.string.no_attention_other);
                            }
                        }
                    } else if (this.k) {
                        c1186d.m.setText(R.string.not_have_fans);
                    } else {
                        int i4 = this.l;
                        if (i4 == 2) {
                            c1186d.m.setText(R.string.her_no_fan_other);
                        } else if (i4 == 1) {
                            c1186d.m.setText(R.string.him_no_fan_other);
                        } else {
                            c1186d.m.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    UserData userData = (UserData) ListUtils.getItem(this.f18912e, i2);
                    if (userData == null) {
                        return null;
                    }
                    c1186d.a.setTag(Integer.valueOf(i2));
                    c1186d.f18940g.setVisibility(0);
                    c1186d.m.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c1186d.f18936c, userData, 0);
                    c1186d.f18937d.setText(UtilHelper.getUserName(userData));
                    c1186d.f18936c.setPlaceHolder(1);
                    c1186d.f18936c.startLoad(userData.getAvater(), 12, false);
                    if (c1186d.f18938e != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c1186d.f18938e.setVisibility(8);
                        } else {
                            c1186d.f18938e.setVisibility(0);
                            c.a.q0.d.b bVar = new c.a.q0.d.b();
                            bVar.a = userData.getAlaUserData();
                            bVar.f12250b = 5;
                            c1186d.f18938e.setTag(bVar);
                        }
                    }
                    if (m.isEmpty(userData.getIntro())) {
                        c1186d.f18939f.setVisibility(8);
                    } else {
                        c1186d.f18939f.setVisibility(0);
                        EMTextView eMTextView2 = c1186d.f18939f;
                        if (TextUtils.isEmpty(userData.getFollowFrom()) && this.k) {
                            str = userData.getIntro();
                        } else {
                            str = userData.getFollowFrom() + " " + userData.getIntro();
                        }
                        eMTextView2.setText(str);
                    }
                    c1186d.f18940g.setTag(Integer.valueOf(i2));
                    String userId = userData.getUserId();
                    c1186d.f18943j.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c1186d.k.n(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        c1186d.f18943j.setVisibility(8);
                        c1186d.f18940g.setVisibility(8);
                    } else {
                        c1186d.f18940g.setVisibility(8);
                        c1186d.f18943j.setVisibility(0);
                    }
                }
                c1186d.l = null;
            } else if (getItemViewType(i2) == 3) {
                if (!this.k || TextUtils.isEmpty(this.m)) {
                    c1186d.p.setVisibility(8);
                }
                c1186d.p.setText(this.m);
            } else if (getItemViewType(i2) == 2) {
                c1186d.n.setText(this.m);
            } else if (getItemViewType(i2) != 2 || getItemViewType(i2) != 3) {
                c1186d.f18937d.setText(this.f18929h.getPageContext().getString(R.string.loading));
                c1186d.l.setVisibility(0);
            }
            h(view, c1186d);
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

    public final void h(View view, C1186d c1186d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c1186d) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f18929h.getLayoutMode().k(skinType == 1);
            this.f18929h.getLayoutMode().j(view);
            if (c1186d != null) {
                TextView textView = c1186d.f18940g;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                    SkinManager.setBackgroundResource(c1186d.f18940g, R.drawable.btn_focus_border_bg);
                    c1186d.f18940g.setEnabled(true);
                }
                LinearLayout linearLayout = c1186d.o;
                if (linearLayout != null && c1186d.n != null) {
                    SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(c1186d.n, (int) R.color.CAM_X0110);
                }
                EMTextView eMTextView = c1186d.p;
                if (eMTextView != null) {
                    SkinManager.setViewTextColor(eMTextView, (int) R.color.CAM_X0105);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c1186d.f18943j;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.onChangeSkinType(skinType);
                }
                TBLottieAnimationView tBLottieAnimationView = c1186d.f18935b;
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
            if (this.f18930i) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }

    public final void j(UserData userData, C1186d c1186d, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048587, this, userData, c1186d, i2) == null) || userData == null || c1186d == null) {
            return;
        }
        if (userData.getAlaUserData() != null && userData.getAlaUserData().live_status == 1) {
            c1186d.f18935b.setSpeed(0.8f);
            c1186d.f18935b.setVisibility(0);
            c1186d.f18935b.loop(true);
            c1186d.f18935b.post(new c(this, c1186d));
            if (this.n.contains(Integer.valueOf(i2))) {
                return;
            }
            e.a(!this.k ? "c14284" : "c14285", userData);
            this.n.add(Integer.valueOf(i2));
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = c1186d.f18935b;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setVisibility(4);
            c1186d.f18935b.cancelAnimation();
        }
    }
}
