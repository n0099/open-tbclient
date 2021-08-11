package c.a.p0.a2;

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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.o0.s.f0.t.c;
import c.a.o0.s.q.i1;
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
/* loaded from: classes3.dex */
public class c extends c.a.p0.a2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f15127h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15128i;

    /* renamed from: j  reason: collision with root package name */
    public int f15129j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0718c f15130e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f15131f;

        public a(c cVar, C0718c c0718c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0718c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15131f = cVar;
            this.f15130e = c0718c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f15130e.f15135c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f15130e.f15135c.setCompoundDrawablePadding(l.g(this.f15131f.f15127h, R.dimen.tbds10));
            } else {
                this.f15130e.f15135c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f15132a;

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
            this.f15132a = cVar;
        }

        @Override // c.a.o0.s.f0.t.c.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f15132a.f15127h, R.string.attention_success);
                } else {
                    l.L(this.f15132a.f15127h, R.string.unfollow_success);
                }
            }
        }
    }

    /* renamed from: c.a.p0.a2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0718c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f15133a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15134b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f15135c;

        /* renamed from: d  reason: collision with root package name */
        public View f15136d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f15137e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f15138f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f15139g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f15140h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.o0.s.f0.t.c f15141i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f15142j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C0718c(c cVar) {
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

        public /* synthetic */ C0718c(c cVar, a aVar) {
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
        this.f15127h = null;
        this.f15128i = true;
        this.f15129j = 0;
        this.k = null;
        this.l = null;
        this.f15127h = personListActivity;
        this.f15128i = z;
        this.f15129j = i2;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f15124e = new ArrayList<>();
    }

    @Override // c.a.p0.a2.b
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
        if (this.f15124e == null) {
            this.f15124e = new ArrayList<>();
        }
        arrayList.addAll(i1Var.b());
        if (!ListUtils.isEmpty(this.f15124e)) {
            ArrayList<UserData> arrayList2 = this.f15124e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f15124e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f15124e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f15124e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f15124e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f15124e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f15124e.addAll(arrayList);
    }

    @Override // c.a.p0.a2.b
    public boolean d(long j2) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 != 0 && (arrayList = this.f15124e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f15124e.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j2) {
                        this.f15124e.remove(next);
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
            if (this.f15125f) {
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
            if (this.f15125f) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f15124e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            return this.f15124e.get(i2).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0718c c0718c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f15124e == null) {
                return view;
            }
            int itemViewType = getItemViewType(i2);
            if (view != null && (view.getTag() instanceof C0718c)) {
                c0718c = (C0718c) view.getTag();
            } else {
                c0718c = new C0718c(this, null);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(this.f15127h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c0718c.f15133a = viewGroup2;
                    viewGroup2.setOnClickListener(this.l);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c0718c.f15134b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(l.g(this.f15127h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c0718c.f15134b.setAutoChangeStyle(true);
                    c0718c.f15134b.setClickable(false);
                    ((LinearLayout.LayoutParams) c0718c.f15134b.getLayoutParams()).setMargins(l.g(this.f15127h, R.dimen.ds34), 0, 0, 0);
                    c0718c.f15138f = (LinearLayout) view.findViewById(R.id.info);
                    c0718c.f15139g = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c0718c.f15135c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c0718c));
                    View a2 = c.a.o0.e.c.b().a(this.f15127h.getPageContext().getPageActivity(), 5);
                    c0718c.f15136d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c0718c.f15139g.addView(c0718c.f15136d, 1);
                    }
                    c0718c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                    c0718c.f15137e = (EMTextView) view.findViewById(R.id.intro);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c0718c.f15140h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f15127h.getPageContext());
                    ((LinearLayout.LayoutParams) c0718c.f15140h.getLayoutParams()).setMargins(0, 0, l.g(this.f15127h, R.dimen.ds34), 0);
                    c.a.o0.s.f0.t.c cVar = new c.a.o0.s.f0.t.c(this.f15127h.getPageContext(), c0718c.f15140h);
                    c0718c.f15141i = cVar;
                    cVar.n((c.a.o0.s.f0.t.a) ListUtils.getItem(this.f15124e, i2));
                    c0718c.f15141i.o(new b(this));
                    c0718c.k = null;
                    c0718c.m = null;
                    c0718c.f15142j = (ImageView) view.findViewById(R.id.diver_buttom_px);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(this.f15127h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    c0718c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
                } else {
                    view = LayoutInflater.from(this.f15127h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c0718c.f15135c = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.k);
                    c0718c.k = (ProgressBar) view.findViewById(R.id.progress);
                    c0718c.m = null;
                }
                view.setTag(c0718c);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c0718c.f15140h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            if (itemViewType == 0) {
                if (this.f15125f) {
                    c0718c.f15138f.setVisibility(8);
                    c0718c.l.setVisibility(0);
                    if (this.f15128i) {
                        c0718c.l.setText(R.string.not_have_fans);
                    } else {
                        int i3 = this.f15129j;
                        if (i3 == 2) {
                            c0718c.l.setText(R.string.her_no_fan_other);
                        } else if (i3 == 1) {
                            c0718c.l.setText(R.string.him_no_fan_other);
                        } else {
                            c0718c.l.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    c0718c.f15133a.setTag(Integer.valueOf(i2));
                    UserData userData = (UserData) ListUtils.getItem(this.f15124e, i2);
                    if (userData == null) {
                        return view;
                    }
                    c0718c.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c0718c.f15134b, userData, 0);
                    c0718c.f15135c.setText(UtilHelper.getUserName(userData));
                    c0718c.f15134b.setPlaceHolder(1);
                    c0718c.f15134b.startLoad(userData.getAvater(), 12, false);
                    if (c0718c.f15136d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c0718c.f15136d.setVisibility(8);
                        } else {
                            c0718c.f15136d.setVisibility(0);
                            c.a.o0.e.b bVar = new c.a.o0.e.b();
                            bVar.f13062a = userData.getAlaUserData();
                            bVar.f13063b = 5;
                            c0718c.f15136d.setTag(bVar);
                        }
                    }
                    if (k.isEmpty(userData.getIntro())) {
                        c0718c.f15137e.setVisibility(8);
                    } else {
                        c0718c.f15137e.setVisibility(0);
                        c0718c.f15137e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c0718c.f15141i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        c0718c.f15140h.setVisibility(8);
                    } else {
                        c0718c.f15140h.setStatsParams(2, userId);
                        c0718c.f15141i.m("9");
                        c0718c.f15140h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0718c.f15142j.getLayoutParams();
                if (ListUtils.getItem(this.f15124e, i2) != null && ((UserData) ListUtils.getItem(this.f15124e, i2)).isLastNewFan) {
                    layoutParams.height = l.g(this.f15127h, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    c0718c.f15142j.setVisibility(0);
                } else {
                    c0718c.f15142j.setVisibility(8);
                    layoutParams.height = l.g(this.f15127h, R.dimen.ds1);
                    layoutParams.setMargins(l.g(this.f15127h, R.dimen.ds34), 0, l.g(this.f15127h, R.dimen.ds34), 0);
                }
                c0718c.f15142j.setLayoutParams(layoutParams);
                c0718c.k = null;
            } else if (itemViewType == 2) {
                c0718c.m.setText(R.string.new_fans);
                c0718c.m.setVisibility(0);
            } else {
                c0718c.f15135c.setText(this.f15127h.getPageContext().getString(R.string.loading));
                c0718c.k.setVisibility(0);
            }
            h(view, c0718c);
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

    public final void h(View view, C0718c c0718c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c0718c) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f15127h.getLayoutMode().k(skinType == 1);
            this.f15127h.getLayoutMode().j(view);
            if (c0718c != null) {
                TextView textView = c0718c.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(c0718c.m, R.color.CAM_X0205);
                }
                ImageView imageView = c0718c.f15142j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c0718c.f15140h;
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
            if (this.f15125f) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
