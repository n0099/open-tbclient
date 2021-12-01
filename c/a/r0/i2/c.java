package c.a.r0.i2;

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
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.s.g0.t.c;
import c.a.q0.s.q.i1;
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
/* loaded from: classes6.dex */
public class c extends c.a.r0.i2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f18202h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18203i;

    /* renamed from: j  reason: collision with root package name */
    public int f18204j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f18205k;
    public View.OnClickListener l;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1075c f18206e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f18207f;

        public a(c cVar, C1075c c1075c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1075c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18207f = cVar;
            this.f18206e = c1075c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f18206e.f18209c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f18206e.f18209c.setCompoundDrawablePadding(l.f(this.f18207f.f18202h, R.dimen.tbds10));
            } else {
                this.f18206e.f18209c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.q0.s.g0.t.c.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.a.f18202h, R.string.attention_success);
                } else {
                    l.L(this.a.f18202h, R.string.unfollow_success);
                }
            }
        }
    }

    /* renamed from: c.a.r0.i2.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1075c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f18208b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f18209c;

        /* renamed from: d  reason: collision with root package name */
        public View f18210d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f18211e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f18212f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f18213g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f18214h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.q0.s.g0.t.c f18215i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f18216j;

        /* renamed from: k  reason: collision with root package name */
        public ProgressBar f18217k;
        public TextView l;
        public TextView m;

        public C1075c(c cVar) {
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

        public /* synthetic */ C1075c(c cVar, a aVar) {
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
        this.f18202h = null;
        this.f18203i = true;
        this.f18204j = 0;
        this.f18205k = null;
        this.l = null;
        this.f18202h = personListActivity;
        this.f18203i = z;
        this.f18204j = i2;
        this.f18205k = onClickListener2;
        this.l = onClickListener;
        this.f18199e = new ArrayList<>();
    }

    @Override // c.a.r0.i2.b
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
        if (this.f18199e == null) {
            this.f18199e = new ArrayList<>();
        }
        arrayList.addAll(i1Var.b());
        if (!ListUtils.isEmpty(this.f18199e)) {
            ArrayList<UserData> arrayList2 = this.f18199e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f18199e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f18199e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f18199e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f18199e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f18199e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f18199e.addAll(arrayList);
    }

    @Override // c.a.r0.i2.b
    public boolean d(long j2) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 != 0 && (arrayList = this.f18199e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f18199e.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j2) {
                        this.f18199e.remove(next);
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
            if (this.f18200f) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f18199e;
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
            ArrayList<UserData> arrayList = this.f18199e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f18199e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f18199e;
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
            if (this.f18200f) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f18199e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            return this.f18199e.get(i2).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1075c c1075c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f18199e == null) {
                return view;
            }
            int itemViewType = getItemViewType(i2);
            if (view != null && (view.getTag() instanceof C1075c)) {
                c1075c = (C1075c) view.getTag();
            } else {
                c1075c = new C1075c(this, null);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(this.f18202h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c1075c.a = viewGroup2;
                    viewGroup2.setOnClickListener(this.l);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c1075c.f18208b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(l.f(this.f18202h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c1075c.f18208b.setAutoChangeStyle(true);
                    c1075c.f18208b.setClickable(false);
                    ((LinearLayout.LayoutParams) c1075c.f18208b.getLayoutParams()).setMargins(l.f(this.f18202h, R.dimen.ds34), 0, 0, 0);
                    c1075c.f18212f = (LinearLayout) view.findViewById(R.id.info);
                    c1075c.f18213g = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c1075c.f18209c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c1075c));
                    View a2 = c.a.q0.e.c.b().a(this.f18202h.getPageContext().getPageActivity(), 5);
                    c1075c.f18210d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c1075c.f18213g.addView(c1075c.f18210d, 1);
                    }
                    c1075c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                    c1075c.f18211e = (EMTextView) view.findViewById(R.id.intro);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c1075c.f18214h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f18202h.getPageContext());
                    ((LinearLayout.LayoutParams) c1075c.f18214h.getLayoutParams()).setMargins(0, 0, l.f(this.f18202h, R.dimen.ds34), 0);
                    c.a.q0.s.g0.t.c cVar = new c.a.q0.s.g0.t.c(this.f18202h.getPageContext(), c1075c.f18214h);
                    c1075c.f18215i = cVar;
                    cVar.n((c.a.q0.s.g0.t.a) ListUtils.getItem(this.f18199e, i2));
                    c1075c.f18215i.o(new b(this));
                    c1075c.f18217k = null;
                    c1075c.m = null;
                    c1075c.f18216j = (ImageView) view.findViewById(R.id.diver_buttom_px);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(this.f18202h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    c1075c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
                } else {
                    view = LayoutInflater.from(this.f18202h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c1075c.f18209c = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.f18205k);
                    c1075c.f18217k = (ProgressBar) view.findViewById(R.id.progress);
                    c1075c.m = null;
                }
                view.setTag(c1075c);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1075c.f18214h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            if (itemViewType == 0) {
                if (this.f18200f) {
                    c1075c.f18212f.setVisibility(8);
                    c1075c.l.setVisibility(0);
                    if (this.f18203i) {
                        c1075c.l.setText(R.string.not_have_fans);
                    } else {
                        int i3 = this.f18204j;
                        if (i3 == 2) {
                            c1075c.l.setText(R.string.her_no_fan_other);
                        } else if (i3 == 1) {
                            c1075c.l.setText(R.string.him_no_fan_other);
                        } else {
                            c1075c.l.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    c1075c.a.setTag(Integer.valueOf(i2));
                    UserData userData = (UserData) ListUtils.getItem(this.f18199e, i2);
                    if (userData == null) {
                        return view;
                    }
                    c1075c.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c1075c.f18208b, userData, 0);
                    c1075c.f18209c.setText(UtilHelper.getUserName(userData));
                    c1075c.f18208b.setPlaceHolder(1);
                    c1075c.f18208b.startLoad(userData.getAvater(), 12, false);
                    if (c1075c.f18210d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c1075c.f18210d.setVisibility(8);
                        } else {
                            c1075c.f18210d.setVisibility(0);
                            c.a.q0.e.b bVar = new c.a.q0.e.b();
                            bVar.a = userData.getAlaUserData();
                            bVar.f11960b = 5;
                            c1075c.f18210d.setTag(bVar);
                        }
                    }
                    if (k.isEmpty(userData.getIntro())) {
                        c1075c.f18211e.setVisibility(8);
                    } else {
                        c1075c.f18211e.setVisibility(0);
                        c1075c.f18211e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c1075c.f18215i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        c1075c.f18214h.setVisibility(8);
                    } else {
                        c1075c.f18214h.setStatsParams(2, userId);
                        c1075c.f18215i.m("9");
                        c1075c.f18214h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1075c.f18216j.getLayoutParams();
                if (ListUtils.getItem(this.f18199e, i2) != null && ((UserData) ListUtils.getItem(this.f18199e, i2)).isLastNewFan) {
                    layoutParams.height = l.f(this.f18202h, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    c1075c.f18216j.setVisibility(0);
                } else {
                    c1075c.f18216j.setVisibility(8);
                    layoutParams.height = l.f(this.f18202h, R.dimen.ds1);
                    layoutParams.setMargins(l.f(this.f18202h, R.dimen.ds34), 0, l.f(this.f18202h, R.dimen.ds34), 0);
                }
                c1075c.f18216j.setLayoutParams(layoutParams);
                c1075c.f18217k = null;
            } else if (itemViewType == 2) {
                c1075c.m.setText(R.string.new_fans);
                c1075c.m.setVisibility(0);
            } else {
                c1075c.f18209c.setText(this.f18202h.getPageContext().getString(R.string.loading));
                c1075c.f18217k.setVisibility(0);
            }
            h(view, c1075c);
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

    public final void h(View view, C1075c c1075c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c1075c) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f18202h.getLayoutMode().k(skinType == 1);
            this.f18202h.getLayoutMode().j(view);
            if (c1075c != null) {
                TextView textView = c1075c.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(c1075c.m, R.color.CAM_X0205);
                }
                ImageView imageView = c1075c.f18216j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c1075c.f18214h;
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
            if (this.f18200f) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
