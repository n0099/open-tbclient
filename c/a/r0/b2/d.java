package c.a.r0.b2;

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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.q.i1;
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
/* loaded from: classes3.dex */
public class d extends c.a.r0.b2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f15971h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15972i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f15973j;
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

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0762d f15974e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f15975f;

        public a(d dVar, C0762d c0762d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c0762d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15975f = dVar;
            this.f15974e = c0762d;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f15974e.f15981d.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f15974e.f15981d.setCompoundDrawablePadding(l.g(this.f15975f.f15971h, R.dimen.tbds10));
            } else {
                this.f15974e.f15981d.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NewMyFansUserLikeButton.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15976a;

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
            this.f15976a = dVar;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton.b
        public void callback() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15976a.f15971h == null) {
                return;
            }
            this.f15976a.f15971h.hideFollowSwitchGuideTip();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0762d f15977e;

        public c(d dVar, C0762d c0762d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, c0762d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15977e = c0762d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15977e.f15979b.playAnimation();
            }
        }
    }

    /* renamed from: c.a.r0.b2.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0762d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f15978a;

        /* renamed from: b  reason: collision with root package name */
        public TBLottieAnimationView f15979b;

        /* renamed from: c  reason: collision with root package name */
        public ClickableHeaderImageView f15980c;

        /* renamed from: d  reason: collision with root package name */
        public EMTextView f15981d;

        /* renamed from: e  reason: collision with root package name */
        public View f15982e;

        /* renamed from: f  reason: collision with root package name */
        public EMTextView f15983f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15984g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f15985h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f15986i;

        /* renamed from: j  reason: collision with root package name */
        public NewMyFansUserLikeButton f15987j;
        public c.a.q0.s.f0.t.c k;
        public ProgressBar l;
        public TextView m;
        public TextView n;
        public LinearLayout o;
        public EMTextView p;

        public C0762d(d dVar) {
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

        public /* synthetic */ C0762d(d dVar, a aVar) {
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
        this.f15971h = null;
        this.f15972i = false;
        this.f15973j = false;
        this.k = true;
        this.l = 0;
        this.n = new HashSet<>();
        this.o = new HashSet<>();
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = new b(this);
        this.f15971h = personListActivity;
        this.f15973j = z;
        this.k = z2;
        this.l = i2;
        this.p = onClickListener2;
        this.q = onClickListener3;
        this.r = onClickListener;
        this.s = onClickListener4;
        this.f15952e = new ArrayList<>();
    }

    @Override // c.a.r0.b2.b
    public void a(i1 i1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, i1Var) == null) || i1Var == null) {
            return;
        }
        this.m = i1Var.f14218i;
        ArrayList arrayList = new ArrayList();
        if (this.f15952e.isEmpty() && !ListUtils.isEmpty(i1Var.a())) {
            Iterator<UserData> it = i1Var.a().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.o.add(Long.valueOf(c.a.e.e.m.b.g(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(i1Var.a());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(i(i1Var.b()));
        this.f15952e.addAll(arrayList);
        if (this.f15952e.isEmpty() || this.f15952e.get(0).mAttentionType == 3) {
            return;
        }
        UserData userData2 = new UserData();
        userData2.mAttentionType = 3;
        this.f15952e.add(0, userData2);
    }

    @Override // c.a.r0.b2.b
    public boolean d(long j2) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            boolean z = false;
            if (j2 != 0 && (arrayList = this.f15952e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f15952e.iterator();
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
            if (this.f15972i) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f15952e;
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
            ArrayList<UserData> arrayList = this.f15952e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f15952e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f15952e;
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
            if (this.f15972i) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f15952e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            if (this.f15952e.get(i2).mAttentionType == 0) {
                return 2;
            }
            return this.f15952e.get(i2).mAttentionType == 3 ? 3 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0762d c0762d;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f15952e == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof C0762d)) {
                c0762d = (C0762d) view.getTag();
                j((UserData) ListUtils.getItem(this.f15952e, i2), c0762d, i2);
            } else {
                c0762d = new C0762d(this, null);
                if (getItemViewType(i2) == 0) {
                    view = LayoutInflater.from(this.f15971h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c0762d.f15978a = viewGroup2;
                    viewGroup2.setOnClickListener(this.r);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c0762d.f15980c = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(l.g(this.f15971h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c0762d.f15980c.setAutoChangeStyle(true);
                    c0762d.f15980c.setGodIconWidth(R.dimen.tbds36);
                    c0762d.f15980c.setOnClickListener(this.s);
                    c0762d.f15980c.setTag(Integer.valueOf(i2));
                    TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
                    c0762d.f15979b = tBLottieAnimationView;
                    SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
                    j((UserData) ListUtils.getItem(this.f15952e, i2), c0762d, i2);
                    c0762d.f15985h = (LinearLayout) view.findViewById(R.id.info);
                    c0762d.f15986i = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c0762d.f15981d = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c0762d));
                    View a2 = c.a.q0.e.c.b().a(this.f15971h.getPageContext().getPageActivity(), 5);
                    c0762d.f15982e = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c0762d.f15986i.addView(c0762d.f15982e, 1);
                    }
                    c0762d.m = (TextView) view.findViewById(R.id.at_list_nodata);
                    c0762d.f15983f = (EMTextView) view.findViewById(R.id.intro);
                    TextView textView = (TextView) view.findViewById(R.id.chat);
                    c0762d.f15984g = textView;
                    textView.setOnClickListener(this.p);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c0762d.f15987j = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f15971h.getPageContext());
                    c0762d.f15987j.setCallback(this.t);
                    c0762d.k = new c.a.q0.s.f0.t.c(this.f15971h.getPageContext(), c0762d.f15987j);
                    c0762d.l = null;
                    c0762d.n = null;
                    c0762d.o = null;
                } else if (getItemViewType(i2) == 2) {
                    view = LayoutInflater.from(this.f15971h.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    c0762d.n = (TextView) view.findViewById(R.id.person_list_title);
                    c0762d.o = (LinearLayout) view.findViewById(R.id.newheader_root);
                } else if (getItemViewType(i2) == 3) {
                    view = LayoutInflater.from(this.f15971h.getPageContext().getPageActivity()).inflate(R.layout.attention_list_follow_from_title, (ViewGroup) null);
                    c0762d.p = (EMTextView) view.findViewById(R.id.attention_follow_tip_text);
                } else {
                    view = LayoutInflater.from(this.f15971h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c0762d.f15981d = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.q);
                    c0762d.l = (ProgressBar) view.findViewById(R.id.progress);
                    c0762d.n = null;
                    c0762d.o = null;
                }
                view.setTag(c0762d);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c0762d.f15987j;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            ClickableHeaderImageView clickableHeaderImageView2 = c0762d.f15980c;
            if (clickableHeaderImageView2 != null) {
                clickableHeaderImageView2.setTag(Integer.valueOf(i2));
            }
            if (getItemViewType(i2) == 0) {
                if (this.f15972i) {
                    c0762d.f15985h.setVisibility(8);
                    c0762d.f15984g.setVisibility(8);
                    c0762d.m.setVisibility(0);
                    if (this.f15973j) {
                        if (this.k) {
                            c0762d.m.setText(R.string.not_have_attention);
                        } else {
                            int i3 = this.l;
                            if (i3 == 2) {
                                c0762d.m.setText(R.string.her_no_attention_other);
                            } else if (i3 == 1) {
                                c0762d.m.setText(R.string.him_no_attention_other);
                            } else {
                                c0762d.m.setText(R.string.no_attention_other);
                            }
                        }
                    } else if (this.k) {
                        c0762d.m.setText(R.string.not_have_fans);
                    } else {
                        int i4 = this.l;
                        if (i4 == 2) {
                            c0762d.m.setText(R.string.her_no_fan_other);
                        } else if (i4 == 1) {
                            c0762d.m.setText(R.string.him_no_fan_other);
                        } else {
                            c0762d.m.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    UserData userData = (UserData) ListUtils.getItem(this.f15952e, i2);
                    if (userData == null) {
                        return null;
                    }
                    c0762d.f15978a.setTag(Integer.valueOf(i2));
                    c0762d.f15984g.setVisibility(0);
                    c0762d.m.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c0762d.f15980c, userData, 0);
                    c0762d.f15981d.setText(UtilHelper.getUserName(userData));
                    c0762d.f15980c.setPlaceHolder(1);
                    c0762d.f15980c.startLoad(userData.getAvater(), 12, false);
                    if (c0762d.f15982e != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c0762d.f15982e.setVisibility(8);
                        } else {
                            c0762d.f15982e.setVisibility(0);
                            c.a.q0.e.b bVar = new c.a.q0.e.b();
                            bVar.f13044a = userData.getAlaUserData();
                            bVar.f13045b = 5;
                            c0762d.f15982e.setTag(bVar);
                        }
                    }
                    if (k.isEmpty(userData.getIntro())) {
                        c0762d.f15983f.setVisibility(8);
                    } else {
                        c0762d.f15983f.setVisibility(0);
                        EMTextView eMTextView2 = c0762d.f15983f;
                        if (TextUtils.isEmpty(userData.getFollowFrom()) && this.k) {
                            str = userData.getIntro();
                        } else {
                            str = userData.getFollowFrom() + " " + userData.getIntro();
                        }
                        eMTextView2.setText(str);
                    }
                    c0762d.f15984g.setTag(Integer.valueOf(i2));
                    String userId = userData.getUserId();
                    c0762d.f15987j.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c0762d.k.n(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        c0762d.f15987j.setVisibility(8);
                        c0762d.f15984g.setVisibility(8);
                    } else {
                        c0762d.f15984g.setVisibility(8);
                        c0762d.f15987j.setVisibility(0);
                    }
                }
                c0762d.l = null;
            } else if (getItemViewType(i2) == 3) {
                if (!this.k || TextUtils.isEmpty(this.m)) {
                    c0762d.p.setVisibility(8);
                }
                c0762d.p.setText(this.m);
            } else if (getItemViewType(i2) == 2) {
                c0762d.n.setText(this.m);
            } else if (getItemViewType(i2) != 2 || getItemViewType(i2) != 3) {
                c0762d.f15981d.setText(this.f15971h.getPageContext().getString(R.string.loading));
                c0762d.l.setVisibility(0);
            }
            h(view, c0762d);
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

    public final void h(View view, C0762d c0762d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c0762d) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f15971h.getLayoutMode().k(skinType == 1);
            this.f15971h.getLayoutMode().j(view);
            if (c0762d != null) {
                TextView textView = c0762d.f15984g;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                    SkinManager.setBackgroundResource(c0762d.f15984g, R.drawable.btn_focus_border_bg);
                    c0762d.f15984g.setEnabled(true);
                }
                LinearLayout linearLayout = c0762d.o;
                if (linearLayout != null && c0762d.n != null) {
                    SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(c0762d.n, R.color.CAM_X0110);
                }
                EMTextView eMTextView = c0762d.p;
                if (eMTextView != null) {
                    SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0105);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c0762d.f15987j;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.onChangeSkinType(skinType);
                }
                TBLottieAnimationView tBLottieAnimationView = c0762d.f15979b;
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
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.o.contains(Long.valueOf(c.a.e.e.m.b.g(next.getUserId(), 0L)))) {
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
            if (this.f15972i) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }

    public final void j(UserData userData, C0762d c0762d, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048587, this, userData, c0762d, i2) == null) || userData == null || c0762d == null) {
            return;
        }
        if (userData.getAlaUserData() != null && userData.getAlaUserData().live_status == 1) {
            c0762d.f15979b.setSpeed(0.8f);
            c0762d.f15979b.setVisibility(0);
            c0762d.f15979b.loop(true);
            c0762d.f15979b.post(new c(this, c0762d));
            if (this.n.contains(Integer.valueOf(i2))) {
                return;
            }
            e.a(!this.k ? "c14284" : "c14285", userData);
            this.n.add(Integer.valueOf(i2));
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = c0762d.f15979b;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setVisibility(4);
            c0762d.f15979b.cancelAnimation();
        }
    }
}
