package b.a.r0.c2;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.q0.s.g0.t.c;
import b.a.q0.s.q.i1;
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
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class c extends b.a.r0.c2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f16590h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16591i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0828c f16592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f16593f;

        public a(c cVar, C0828c c0828c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0828c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16593f = cVar;
            this.f16592e = c0828c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f16592e.f16597c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f16592e.f16597c.setCompoundDrawablePadding(l.g(this.f16593f.f16590h, R.dimen.tbds10));
            } else {
                this.f16592e.f16597c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f16594a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16594a = cVar;
        }

        @Override // b.a.q0.s.g0.t.c.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f16594a.f16590h, R.string.attention_success);
                } else {
                    l.L(this.f16594a.f16590h, R.string.unfollow_success);
                }
            }
        }
    }

    /* renamed from: b.a.r0.c2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0828c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f16595a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f16596b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f16597c;

        /* renamed from: d  reason: collision with root package name */
        public View f16598d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f16599e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f16600f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f16601g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f16602h;

        /* renamed from: i  reason: collision with root package name */
        public b.a.q0.s.g0.t.c f16603i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C0828c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C0828c(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonListActivity personListActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personListActivity, Boolean.valueOf(z), Integer.valueOf(i2), onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16590h = null;
        this.f16591i = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.f16590h = personListActivity;
        this.f16591i = z;
        this.j = i2;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f16587e = new ArrayList<>();
    }

    @Override // b.a.r0.c2.b
    public void a(i1 i1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, i1Var) == null) || i1Var == null || i1Var.b() == null) {
            return;
        }
        Iterator<UserData> it = i1Var.b().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UserData next = it.next();
            if (next != null) {
                next.setIsLike(next.getHave_attention() > 0);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.f16587e == null) {
            this.f16587e = new ArrayList<>();
        }
        arrayList.addAll(i1Var.b());
        if (!ListUtils.isEmpty(this.f16587e)) {
            ArrayList<UserData> arrayList2 = this.f16587e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f16587e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f16587e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f16587e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f16587e.addAll(arrayList);
                }
            }
        }
        int i2 = 0;
        while (i2 < arrayList.size() - 1) {
            UserData userData2 = (UserData) arrayList.get(i2);
            i2++;
            UserData userData3 = (UserData) arrayList.get(i2);
            if (userData2 != null && userData3 != null && userData2.isNewFan && !userData3.isNewFan) {
                userData2.isLastNewFan = true;
            }
        }
        if (ListUtils.isEmpty(this.f16587e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f16587e.addAll(arrayList);
    }

    @Override // b.a.r0.c2.b
    public boolean d(long j) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && (arrayList = this.f16587e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f16587e.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j) {
                        this.f16587e.remove(next);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f16588f) {
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
            if (this.f16588f) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f16587e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            return this.f16587e.get(i2).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0828c c0828c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f16587e == null) {
                return view;
            }
            int itemViewType = getItemViewType(i2);
            if (view != null && (view.getTag() instanceof C0828c)) {
                c0828c = (C0828c) view.getTag();
            } else {
                c0828c = new C0828c(this, null);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(this.f16590h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c0828c.f16595a = viewGroup2;
                    viewGroup2.setOnClickListener(this.l);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c0828c.f16596b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(l.g(this.f16590h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c0828c.f16596b.setAutoChangeStyle(true);
                    c0828c.f16596b.setClickable(false);
                    ((LinearLayout.LayoutParams) c0828c.f16596b.getLayoutParams()).setMargins(l.g(this.f16590h, R.dimen.ds34), 0, 0, 0);
                    c0828c.f16600f = (LinearLayout) view.findViewById(R.id.info);
                    c0828c.f16601g = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c0828c.f16597c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c0828c));
                    View a2 = b.a.q0.e.c.b().a(this.f16590h.getPageContext().getPageActivity(), 5);
                    c0828c.f16598d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c0828c.f16601g.addView(c0828c.f16598d, 1);
                    }
                    c0828c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                    c0828c.f16599e = (EMTextView) view.findViewById(R.id.intro);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c0828c.f16602h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f16590h.getPageContext());
                    ((LinearLayout.LayoutParams) c0828c.f16602h.getLayoutParams()).setMargins(0, 0, l.g(this.f16590h, R.dimen.ds34), 0);
                    b.a.q0.s.g0.t.c cVar = new b.a.q0.s.g0.t.c(this.f16590h.getPageContext(), c0828c.f16602h);
                    c0828c.f16603i = cVar;
                    cVar.n((b.a.q0.s.g0.t.a) ListUtils.getItem(this.f16587e, i2));
                    c0828c.f16603i.o(new b(this));
                    c0828c.k = null;
                    c0828c.m = null;
                    c0828c.j = (ImageView) view.findViewById(R.id.diver_buttom_px);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(this.f16590h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    c0828c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
                } else {
                    view = LayoutInflater.from(this.f16590h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c0828c.f16597c = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.k);
                    c0828c.k = (ProgressBar) view.findViewById(R.id.progress);
                    c0828c.m = null;
                }
                view.setTag(c0828c);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c0828c.f16602h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            if (itemViewType == 0) {
                if (this.f16588f) {
                    c0828c.f16600f.setVisibility(8);
                    c0828c.l.setVisibility(0);
                    if (this.f16591i) {
                        c0828c.l.setText(R.string.not_have_fans);
                    } else {
                        int i3 = this.j;
                        if (i3 == 2) {
                            c0828c.l.setText(R.string.her_no_fan_other);
                        } else if (i3 == 1) {
                            c0828c.l.setText(R.string.him_no_fan_other);
                        } else {
                            c0828c.l.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    c0828c.f16595a.setTag(Integer.valueOf(i2));
                    UserData userData = (UserData) ListUtils.getItem(this.f16587e, i2);
                    if (userData == null) {
                        return view;
                    }
                    c0828c.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c0828c.f16596b, userData, 0);
                    c0828c.f16597c.setText(UtilHelper.getUserName(userData));
                    c0828c.f16596b.setPlaceHolder(1);
                    c0828c.f16596b.startLoad(userData.getAvater(), 12, false);
                    if (c0828c.f16598d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c0828c.f16598d.setVisibility(8);
                        } else {
                            c0828c.f16598d.setVisibility(0);
                            b.a.q0.e.b bVar = new b.a.q0.e.b();
                            bVar.f12949a = userData.getAlaUserData();
                            bVar.f12950b = 5;
                            c0828c.f16598d.setTag(bVar);
                        }
                    }
                    if (k.isEmpty(userData.getIntro())) {
                        c0828c.f16599e.setVisibility(8);
                    } else {
                        c0828c.f16599e.setVisibility(0);
                        c0828c.f16599e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c0828c.f16603i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        c0828c.f16602h.setVisibility(8);
                    } else {
                        c0828c.f16602h.setStatsParams(2, userId);
                        c0828c.f16603i.m("9");
                        c0828c.f16602h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0828c.j.getLayoutParams();
                if (ListUtils.getItem(this.f16587e, i2) != null && ((UserData) ListUtils.getItem(this.f16587e, i2)).isLastNewFan) {
                    layoutParams.height = l.g(this.f16590h, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    c0828c.j.setVisibility(0);
                } else {
                    c0828c.j.setVisibility(8);
                    layoutParams.height = l.g(this.f16590h, R.dimen.ds1);
                    layoutParams.setMargins(l.g(this.f16590h, R.dimen.ds34), 0, l.g(this.f16590h, R.dimen.ds34), 0);
                }
                c0828c.j.setLayoutParams(layoutParams);
                c0828c.k = null;
            } else if (itemViewType == 2) {
                c0828c.m.setText(R.string.new_fans);
                c0828c.m.setVisibility(0);
            } else {
                c0828c.f16597c.setText(this.f16590h.getPageContext().getString(R.string.loading));
                c0828c.k.setVisibility(0);
            }
            h(view, c0828c);
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

    public final void h(View view, C0828c c0828c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c0828c) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f16590h.getLayoutMode().k(skinType == 1);
            this.f16590h.getLayoutMode().j(view);
            if (c0828c != null) {
                TextView textView = c0828c.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(c0828c.m, R.color.CAM_X0205);
                }
                ImageView imageView = c0828c.j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c0828c.f16602h;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.onChangeSkinType(skinType);
                }
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f16588f) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
