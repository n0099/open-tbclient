package b.a.r0.c2;

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
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.q0.s.q.i1;
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
/* loaded from: classes4.dex */
public class d extends b.a.r0.c2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f16604h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16605i;
    public boolean j;
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

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0829d f16606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f16607f;

        public a(d dVar, C0829d c0829d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c0829d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16607f = dVar;
            this.f16606e = c0829d;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f16606e.f16613d.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f16606e.f16613d.setCompoundDrawablePadding(l.g(this.f16607f.f16604h, R.dimen.tbds10));
            } else {
                this.f16606e.f16613d.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NewMyFansUserLikeButton.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f16608a;

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
            this.f16608a = dVar;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton.b
        public void callback() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16608a.f16604h == null) {
                return;
            }
            this.f16608a.f16604h.hideFollowSwitchGuideTip();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0829d f16609e;

        public c(d dVar, C0829d c0829d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c0829d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16609e = c0829d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16609e.f16611b.playAnimation();
            }
        }
    }

    /* renamed from: b.a.r0.c2.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0829d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f16610a;

        /* renamed from: b  reason: collision with root package name */
        public TBLottieAnimationView f16611b;

        /* renamed from: c  reason: collision with root package name */
        public ClickableHeaderImageView f16612c;

        /* renamed from: d  reason: collision with root package name */
        public EMTextView f16613d;

        /* renamed from: e  reason: collision with root package name */
        public View f16614e;

        /* renamed from: f  reason: collision with root package name */
        public EMTextView f16615f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16616g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f16617h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f16618i;
        public NewMyFansUserLikeButton j;
        public b.a.q0.s.g0.t.c k;
        public ProgressBar l;
        public TextView m;
        public TextView n;
        public LinearLayout o;
        public EMTextView p;

        public C0829d(d dVar) {
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

        public /* synthetic */ C0829d(d dVar, a aVar) {
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
        this.f16604h = null;
        this.f16605i = false;
        this.j = false;
        this.k = true;
        this.l = 0;
        this.n = new HashSet<>();
        this.o = new HashSet<>();
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = new b(this);
        this.f16604h = personListActivity;
        this.j = z;
        this.k = z2;
        this.l = i2;
        this.p = onClickListener2;
        this.q = onClickListener3;
        this.r = onClickListener;
        this.s = onClickListener4;
        this.f16587e = new ArrayList<>();
    }

    @Override // b.a.r0.c2.b
    public void a(i1 i1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, i1Var) == null) || i1Var == null) {
            return;
        }
        this.m = i1Var.f14137i;
        ArrayList arrayList = new ArrayList();
        if (this.f16587e.isEmpty() && !ListUtils.isEmpty(i1Var.a())) {
            Iterator<UserData> it = i1Var.a().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.o.add(Long.valueOf(b.a.e.f.m.b.g(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(i1Var.a());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(i(i1Var.b()));
        this.f16587e.addAll(arrayList);
        if (this.f16587e.isEmpty() || this.f16587e.get(0).mAttentionType == 3) {
            return;
        }
        UserData userData2 = new UserData();
        userData2.mAttentionType = 3;
        this.f16587e.add(0, userData2);
    }

    @Override // b.a.r0.c2.b
    public boolean d(long j) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            boolean z = false;
            if (j != 0 && (arrayList = this.f16587e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f16587e.iterator();
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
            if (this.f16605i) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f16587e;
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
            ArrayList<UserData> arrayList = this.f16587e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f16587e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f16587e;
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
            if (this.f16605i) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f16587e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            if (this.f16587e.get(i2).mAttentionType == 0) {
                return 2;
            }
            return this.f16587e.get(i2).mAttentionType == 3 ? 3 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0829d c0829d;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f16587e == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof C0829d)) {
                c0829d = (C0829d) view.getTag();
                j((UserData) ListUtils.getItem(this.f16587e, i2), c0829d, i2);
            } else {
                c0829d = new C0829d(this, null);
                if (getItemViewType(i2) == 0) {
                    view = LayoutInflater.from(this.f16604h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c0829d.f16610a = viewGroup2;
                    viewGroup2.setOnClickListener(this.r);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c0829d.f16612c = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(l.g(this.f16604h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c0829d.f16612c.setAutoChangeStyle(true);
                    c0829d.f16612c.setGodIconWidth(R.dimen.tbds36);
                    c0829d.f16612c.setOnClickListener(this.s);
                    c0829d.f16612c.setTag(Integer.valueOf(i2));
                    TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
                    c0829d.f16611b = tBLottieAnimationView;
                    SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
                    j((UserData) ListUtils.getItem(this.f16587e, i2), c0829d, i2);
                    c0829d.f16617h = (LinearLayout) view.findViewById(R.id.info);
                    c0829d.f16618i = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c0829d.f16613d = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c0829d));
                    View a2 = b.a.q0.e.c.b().a(this.f16604h.getPageContext().getPageActivity(), 5);
                    c0829d.f16614e = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c0829d.f16618i.addView(c0829d.f16614e, 1);
                    }
                    c0829d.m = (TextView) view.findViewById(R.id.at_list_nodata);
                    c0829d.f16615f = (EMTextView) view.findViewById(R.id.intro);
                    TextView textView = (TextView) view.findViewById(R.id.chat);
                    c0829d.f16616g = textView;
                    textView.setOnClickListener(this.p);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c0829d.j = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f16604h.getPageContext());
                    c0829d.j.setCallback(this.t);
                    c0829d.k = new b.a.q0.s.g0.t.c(this.f16604h.getPageContext(), c0829d.j);
                    c0829d.l = null;
                    c0829d.n = null;
                    c0829d.o = null;
                } else if (getItemViewType(i2) == 2) {
                    view = LayoutInflater.from(this.f16604h.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    c0829d.n = (TextView) view.findViewById(R.id.person_list_title);
                    c0829d.o = (LinearLayout) view.findViewById(R.id.newheader_root);
                } else if (getItemViewType(i2) == 3) {
                    view = LayoutInflater.from(this.f16604h.getPageContext().getPageActivity()).inflate(R.layout.attention_list_follow_from_title, (ViewGroup) null);
                    c0829d.p = (EMTextView) view.findViewById(R.id.attention_follow_tip_text);
                } else {
                    view = LayoutInflater.from(this.f16604h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c0829d.f16613d = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.q);
                    c0829d.l = (ProgressBar) view.findViewById(R.id.progress);
                    c0829d.n = null;
                    c0829d.o = null;
                }
                view.setTag(c0829d);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c0829d.j;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            ClickableHeaderImageView clickableHeaderImageView2 = c0829d.f16612c;
            if (clickableHeaderImageView2 != null) {
                clickableHeaderImageView2.setTag(Integer.valueOf(i2));
            }
            if (getItemViewType(i2) == 0) {
                if (this.f16605i) {
                    c0829d.f16617h.setVisibility(8);
                    c0829d.f16616g.setVisibility(8);
                    c0829d.m.setVisibility(0);
                    if (this.j) {
                        if (this.k) {
                            c0829d.m.setText(R.string.not_have_attention);
                        } else {
                            int i3 = this.l;
                            if (i3 == 2) {
                                c0829d.m.setText(R.string.her_no_attention_other);
                            } else if (i3 == 1) {
                                c0829d.m.setText(R.string.him_no_attention_other);
                            } else {
                                c0829d.m.setText(R.string.no_attention_other);
                            }
                        }
                    } else if (this.k) {
                        c0829d.m.setText(R.string.not_have_fans);
                    } else {
                        int i4 = this.l;
                        if (i4 == 2) {
                            c0829d.m.setText(R.string.her_no_fan_other);
                        } else if (i4 == 1) {
                            c0829d.m.setText(R.string.him_no_fan_other);
                        } else {
                            c0829d.m.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    UserData userData = (UserData) ListUtils.getItem(this.f16587e, i2);
                    if (userData == null) {
                        return null;
                    }
                    c0829d.f16610a.setTag(Integer.valueOf(i2));
                    c0829d.f16616g.setVisibility(0);
                    c0829d.m.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c0829d.f16612c, userData, 0);
                    c0829d.f16613d.setText(UtilHelper.getUserName(userData));
                    c0829d.f16612c.setPlaceHolder(1);
                    c0829d.f16612c.startLoad(userData.getAvater(), 12, false);
                    if (c0829d.f16614e != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c0829d.f16614e.setVisibility(8);
                        } else {
                            c0829d.f16614e.setVisibility(0);
                            b.a.q0.e.b bVar = new b.a.q0.e.b();
                            bVar.f12949a = userData.getAlaUserData();
                            bVar.f12950b = 5;
                            c0829d.f16614e.setTag(bVar);
                        }
                    }
                    if (k.isEmpty(userData.getIntro())) {
                        c0829d.f16615f.setVisibility(8);
                    } else {
                        c0829d.f16615f.setVisibility(0);
                        EMTextView eMTextView2 = c0829d.f16615f;
                        if (TextUtils.isEmpty(userData.getFollowFrom()) && this.k) {
                            str = userData.getIntro();
                        } else {
                            str = userData.getFollowFrom() + " " + userData.getIntro();
                        }
                        eMTextView2.setText(str);
                    }
                    c0829d.f16616g.setTag(Integer.valueOf(i2));
                    String userId = userData.getUserId();
                    c0829d.j.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c0829d.k.n(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        c0829d.j.setVisibility(8);
                        c0829d.f16616g.setVisibility(8);
                    } else {
                        c0829d.f16616g.setVisibility(8);
                        c0829d.j.setVisibility(0);
                    }
                }
                c0829d.l = null;
            } else if (getItemViewType(i2) == 3) {
                if (!this.k || TextUtils.isEmpty(this.m)) {
                    c0829d.p.setVisibility(8);
                }
                c0829d.p.setText(this.m);
            } else if (getItemViewType(i2) == 2) {
                c0829d.n.setText(this.m);
            } else if (getItemViewType(i2) != 2 || getItemViewType(i2) != 3) {
                c0829d.f16613d.setText(this.f16604h.getPageContext().getString(R.string.loading));
                c0829d.l.setVisibility(0);
            }
            h(view, c0829d);
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

    public final void h(View view, C0829d c0829d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c0829d) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f16604h.getLayoutMode().k(skinType == 1);
            this.f16604h.getLayoutMode().j(view);
            if (c0829d != null) {
                TextView textView = c0829d.f16616g;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                    SkinManager.setBackgroundResource(c0829d.f16616g, R.drawable.btn_focus_border_bg);
                    c0829d.f16616g.setEnabled(true);
                }
                LinearLayout linearLayout = c0829d.o;
                if (linearLayout != null && c0829d.n != null) {
                    SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(c0829d.n, R.color.CAM_X0110);
                }
                EMTextView eMTextView = c0829d.p;
                if (eMTextView != null) {
                    SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0105);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c0829d.j;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.onChangeSkinType(skinType);
                }
                TBLottieAnimationView tBLottieAnimationView = c0829d.f16611b;
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
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.o.contains(Long.valueOf(b.a.e.f.m.b.g(next.getUserId(), 0L)))) {
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
            if (this.f16605i) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }

    public final void j(UserData userData, C0829d c0829d, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048587, this, userData, c0829d, i2) == null) || userData == null || c0829d == null) {
            return;
        }
        if (userData.getAlaUserData() != null && userData.getAlaUserData().live_status == 1) {
            c0829d.f16611b.setSpeed(0.8f);
            c0829d.f16611b.setVisibility(0);
            c0829d.f16611b.loop(true);
            c0829d.f16611b.post(new c(this, c0829d));
            if (this.n.contains(Integer.valueOf(i2))) {
                return;
            }
            e.a(!this.k ? "c14284" : "c14285", userData);
            this.n.add(Integer.valueOf(i2));
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = c0829d.f16611b;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setVisibility(4);
            c0829d.f16611b.cancelAnimation();
        }
    }
}
