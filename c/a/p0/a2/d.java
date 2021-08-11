package c.a.p0.a2;

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
import c.a.o0.s.q.i1;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
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
public class d extends c.a.p0.a2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f15143h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15144i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f15145j;
    public boolean k;
    public int l;
    public String m;
    public HashSet<Long> n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public NewMyFansUserLikeButton.b r;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15146e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f15147f;

        public a(d dVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15147f = dVar;
            this.f15146e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f15146e.f15151c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f15146e.f15151c.setCompoundDrawablePadding(l.g(this.f15147f.f15143h, R.dimen.tbds10));
            } else {
                this.f15146e.f15151c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NewMyFansUserLikeButton.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15148a;

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
            this.f15148a = dVar;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton.b
        public void callback() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15148a.f15143h == null) {
                return;
            }
            this.f15148a.f15143h.hideFollowSwitchGuideTip();
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f15149a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15150b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f15151c;

        /* renamed from: d  reason: collision with root package name */
        public View f15152d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f15153e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f15154f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f15155g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f15156h;

        /* renamed from: i  reason: collision with root package name */
        public NewMyFansUserLikeButton f15157i;

        /* renamed from: j  reason: collision with root package name */
        public c.a.o0.s.f0.t.c f15158j;
        public ProgressBar k;
        public TextView l;
        public TextView m;
        public LinearLayout n;
        public EMTextView o;

        public c(d dVar) {
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

        public /* synthetic */ c(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personListActivity, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), onClickListener, onClickListener2, onClickListener3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15143h = null;
        this.f15144i = false;
        this.f15145j = false;
        this.k = true;
        this.l = 0;
        this.n = new HashSet<>();
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = new b(this);
        this.f15143h = personListActivity;
        this.f15145j = z;
        this.k = z2;
        this.l = i2;
        this.o = onClickListener2;
        this.p = onClickListener3;
        this.q = onClickListener;
        this.f15124e = new ArrayList<>();
    }

    @Override // c.a.p0.a2.b
    public void a(i1 i1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, i1Var) == null) || i1Var == null) {
            return;
        }
        this.m = i1Var.f13956i;
        ArrayList arrayList = new ArrayList();
        if (this.f15124e.isEmpty() && !ListUtils.isEmpty(i1Var.a())) {
            Iterator<UserData> it = i1Var.a().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.n.add(Long.valueOf(c.a.e.e.m.b.f(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(i1Var.a());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(i(i1Var.b()));
        this.f15124e.addAll(arrayList);
        if (this.f15124e.isEmpty() || this.f15124e.get(0).mAttentionType == 3) {
            return;
        }
        UserData userData2 = new UserData();
        userData2.mAttentionType = 3;
        this.f15124e.add(0, userData2);
    }

    @Override // c.a.p0.a2.b
    public boolean d(long j2) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            boolean z = false;
            if (j2 != 0 && (arrayList = this.f15124e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f15124e.iterator();
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
            if (this.f15144i) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f15124e;
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
            ArrayList<UserData> arrayList = this.f15124e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f15124e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f15124e;
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
            if (this.f15144i) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f15124e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            if (this.f15124e.get(i2).mAttentionType == 0) {
                return 2;
            }
            return this.f15124e.get(i2).mAttentionType == 3 ? 3 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f15124e == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                cVar = new c(this, null);
                if (getItemViewType(i2) == 0) {
                    view = LayoutInflater.from(this.f15143h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    cVar.f15149a = viewGroup2;
                    viewGroup2.setOnClickListener(this.q);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    cVar.f15150b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(l.g(this.f15143h.getPageContext().getPageActivity(), R.dimen.ds90));
                    cVar.f15150b.setAutoChangeStyle(true);
                    cVar.f15150b.setClickable(false);
                    cVar.f15155g = (LinearLayout) view.findViewById(R.id.info);
                    cVar.f15156h = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    cVar.f15151c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, cVar));
                    View a2 = c.a.o0.e.c.b().a(this.f15143h.getPageContext().getPageActivity(), 5);
                    cVar.f15152d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        cVar.f15156h.addView(cVar.f15152d, 1);
                    }
                    cVar.l = (TextView) view.findViewById(R.id.at_list_nodata);
                    cVar.f15153e = (EMTextView) view.findViewById(R.id.intro);
                    TextView textView = (TextView) view.findViewById(R.id.chat);
                    cVar.f15154f = textView;
                    textView.setOnClickListener(this.o);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    cVar.f15157i = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f15143h.getPageContext());
                    cVar.f15157i.setCallback(this.r);
                    cVar.f15158j = new c.a.o0.s.f0.t.c(this.f15143h.getPageContext(), cVar.f15157i);
                    cVar.k = null;
                    cVar.m = null;
                    cVar.n = null;
                } else if (getItemViewType(i2) == 2) {
                    view = LayoutInflater.from(this.f15143h.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                    cVar.m = (TextView) view.findViewById(R.id.person_list_title);
                    cVar.n = (LinearLayout) view.findViewById(R.id.newheader_root);
                } else if (getItemViewType(i2) == 3) {
                    view = LayoutInflater.from(this.f15143h.getPageContext().getPageActivity()).inflate(R.layout.attention_list_follow_from_title, (ViewGroup) null);
                    cVar.o = (EMTextView) view.findViewById(R.id.attention_follow_tip_text);
                } else {
                    view = LayoutInflater.from(this.f15143h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    cVar.f15151c = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.p);
                    cVar.k = (ProgressBar) view.findViewById(R.id.progress);
                    cVar.m = null;
                    cVar.n = null;
                }
                view.setTag(cVar);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = cVar.f15157i;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            if (getItemViewType(i2) == 0) {
                if (this.f15144i) {
                    cVar.f15155g.setVisibility(8);
                    cVar.f15154f.setVisibility(8);
                    cVar.l.setVisibility(0);
                    if (this.f15145j) {
                        if (this.k) {
                            cVar.l.setText(R.string.not_have_attention);
                        } else {
                            int i3 = this.l;
                            if (i3 == 2) {
                                cVar.l.setText(R.string.her_no_attention_other);
                            } else if (i3 == 1) {
                                cVar.l.setText(R.string.him_no_attention_other);
                            } else {
                                cVar.l.setText(R.string.no_attention_other);
                            }
                        }
                    } else if (this.k) {
                        cVar.l.setText(R.string.not_have_fans);
                    } else {
                        int i4 = this.l;
                        if (i4 == 2) {
                            cVar.l.setText(R.string.her_no_fan_other);
                        } else if (i4 == 1) {
                            cVar.l.setText(R.string.him_no_fan_other);
                        } else {
                            cVar.l.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    UserData userData = (UserData) ListUtils.getItem(this.f15124e, i2);
                    if (userData == null) {
                        return null;
                    }
                    cVar.f15149a.setTag(Integer.valueOf(i2));
                    cVar.f15154f.setVisibility(0);
                    cVar.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(cVar.f15150b, userData, 0);
                    cVar.f15151c.setText(UtilHelper.getUserName(userData));
                    cVar.f15150b.setPlaceHolder(1);
                    cVar.f15150b.startLoad(userData.getAvater(), 12, false);
                    if (cVar.f15152d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            cVar.f15152d.setVisibility(8);
                        } else {
                            cVar.f15152d.setVisibility(0);
                            c.a.o0.e.b bVar = new c.a.o0.e.b();
                            bVar.f13062a = userData.getAlaUserData();
                            bVar.f13063b = 5;
                            cVar.f15152d.setTag(bVar);
                        }
                    }
                    if (k.isEmpty(userData.getIntro())) {
                        cVar.f15153e.setVisibility(8);
                    } else {
                        cVar.f15153e.setVisibility(0);
                        EMTextView eMTextView2 = cVar.f15153e;
                        if (TextUtils.isEmpty(userData.getFollowFrom()) && this.k) {
                            str = userData.getIntro();
                        } else {
                            str = userData.getFollowFrom() + " " + userData.getIntro();
                        }
                        eMTextView2.setText(str);
                    }
                    cVar.f15154f.setTag(Integer.valueOf(i2));
                    String userId = userData.getUserId();
                    cVar.f15157i.setStatsParams(1, userId);
                    userData.setIsLike(userData.getHave_attention() > 0);
                    cVar.f15158j.n(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        cVar.f15157i.setVisibility(8);
                        cVar.f15154f.setVisibility(8);
                    } else {
                        cVar.f15154f.setVisibility(8);
                        cVar.f15157i.setVisibility(0);
                    }
                }
                cVar.k = null;
            } else if (getItemViewType(i2) == 3) {
                if (!this.k || TextUtils.isEmpty(this.m)) {
                    cVar.o.setVisibility(8);
                }
                cVar.o.setText(this.m);
            } else if (getItemViewType(i2) == 2) {
                cVar.m.setText(this.m);
            } else if (getItemViewType(i2) != 2 || getItemViewType(i2) != 3) {
                cVar.f15151c.setText(this.f15143h.getPageContext().getString(R.string.loading));
                cVar.k.setVisibility(0);
            }
            h(view, cVar);
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

    public final void h(View view, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, cVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f15143h.getLayoutMode().k(skinType == 1);
            this.f15143h.getLayoutMode().j(view);
            if (cVar != null) {
                TextView textView = cVar.f15154f;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                    SkinManager.setBackgroundResource(cVar.f15154f, R.drawable.btn_focus_border_bg);
                    cVar.f15154f.setEnabled(true);
                }
                LinearLayout linearLayout = cVar.n;
                if (linearLayout != null && cVar.m != null) {
                    SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(cVar.m, R.color.CAM_X0110);
                }
                EMTextView eMTextView = cVar.o;
                if (eMTextView != null) {
                    SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0105);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = cVar.f15157i;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.onChangeSkinType(skinType);
                }
            }
        }
    }

    public final ArrayList<UserData> i(ArrayList<UserData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, arrayList)) == null) {
            if (ListUtils.isEmpty(arrayList) || this.n.isEmpty()) {
                return arrayList;
            }
            ArrayList<UserData> arrayList2 = new ArrayList<>();
            Iterator<UserData> it = arrayList.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId()) && !this.n.contains(Long.valueOf(c.a.e.e.m.b.f(next.getUserId(), 0L)))) {
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
            if (this.f15144i) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
