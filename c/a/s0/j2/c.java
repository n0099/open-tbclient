package c.a.s0.j2;

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
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.s.i0.t.c;
import c.a.r0.s.r.i1;
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
/* loaded from: classes7.dex */
public class c extends c.a.s0.j2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f18213h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18214i;

    /* renamed from: j  reason: collision with root package name */
    public int f18215j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f18216k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1099c f18217e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f18218f;

        public a(c cVar, C1099c c1099c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1099c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18218f = cVar;
            this.f18217e = c1099c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f18217e.f18220c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f18217e.f18220c.setCompoundDrawablePadding(m.f(this.f18218f.f18213h, R.dimen.tbds10));
            } else {
                this.f18217e.f18220c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // c.a.r0.s.i0.t.c.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    m.L(this.a.f18213h, R.string.attention_success);
                } else {
                    m.L(this.a.f18213h, R.string.unfollow_success);
                }
            }
        }
    }

    /* renamed from: c.a.s0.j2.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1099c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f18219b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f18220c;

        /* renamed from: d  reason: collision with root package name */
        public View f18221d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f18222e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f18223f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f18224g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f18225h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.r0.s.i0.t.c f18226i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f18227j;

        /* renamed from: k  reason: collision with root package name */
        public ProgressBar f18228k;
        public TextView l;
        public TextView m;

        public C1099c(c cVar) {
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

        public /* synthetic */ C1099c(c cVar, a aVar) {
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
        this.f18213h = null;
        this.f18214i = true;
        this.f18215j = 0;
        this.f18216k = null;
        this.l = null;
        this.f18213h = personListActivity;
        this.f18214i = z;
        this.f18215j = i2;
        this.f18216k = onClickListener2;
        this.l = onClickListener;
        this.f18210e = new ArrayList<>();
    }

    @Override // c.a.s0.j2.b
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
        if (this.f18210e == null) {
            this.f18210e = new ArrayList<>();
        }
        arrayList.addAll(i1Var.b());
        if (!ListUtils.isEmpty(this.f18210e)) {
            ArrayList<UserData> arrayList2 = this.f18210e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f18210e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f18210e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f18210e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f18210e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f18210e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f18210e.addAll(arrayList);
    }

    @Override // c.a.s0.j2.b
    public boolean d(long j2) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 != 0 && (arrayList = this.f18210e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f18210e.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j2) {
                        this.f18210e.remove(next);
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
            if (this.f18211f) {
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
            if (this.f18211f) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f18210e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            return this.f18210e.get(i2).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1099c c1099c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f18210e == null) {
                return view;
            }
            int itemViewType = getItemViewType(i2);
            if (view != null && (view.getTag() instanceof C1099c)) {
                c1099c = (C1099c) view.getTag();
            } else {
                c1099c = new C1099c(this, null);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(this.f18213h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c1099c.a = viewGroup2;
                    viewGroup2.setOnClickListener(this.l);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c1099c.f18219b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(m.f(this.f18213h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c1099c.f18219b.setAutoChangeStyle(true);
                    c1099c.f18219b.setClickable(false);
                    ((LinearLayout.LayoutParams) c1099c.f18219b.getLayoutParams()).setMargins(m.f(this.f18213h, R.dimen.ds34), 0, 0, 0);
                    c1099c.f18223f = (LinearLayout) view.findViewById(R.id.info);
                    c1099c.f18224g = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c1099c.f18220c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c1099c));
                    View a2 = c.a.r0.e.c.b().a(this.f18213h.getPageContext().getPageActivity(), 5);
                    c1099c.f18221d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c1099c.f18224g.addView(c1099c.f18221d, 1);
                    }
                    c1099c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                    c1099c.f18222e = (EMTextView) view.findViewById(R.id.intro);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c1099c.f18225h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f18213h.getPageContext());
                    ((LinearLayout.LayoutParams) c1099c.f18225h.getLayoutParams()).setMargins(0, 0, m.f(this.f18213h, R.dimen.ds34), 0);
                    c.a.r0.s.i0.t.c cVar = new c.a.r0.s.i0.t.c(this.f18213h.getPageContext(), c1099c.f18225h);
                    c1099c.f18226i = cVar;
                    cVar.n((c.a.r0.s.i0.t.a) ListUtils.getItem(this.f18210e, i2));
                    c1099c.f18226i.o(new b(this));
                    c1099c.f18228k = null;
                    c1099c.m = null;
                    c1099c.f18227j = (ImageView) view.findViewById(R.id.diver_buttom_px);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(this.f18213h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    c1099c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
                } else {
                    view = LayoutInflater.from(this.f18213h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c1099c.f18220c = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.f18216k);
                    c1099c.f18228k = (ProgressBar) view.findViewById(R.id.progress);
                    c1099c.m = null;
                }
                view.setTag(c1099c);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1099c.f18225h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            if (itemViewType == 0) {
                if (this.f18211f) {
                    c1099c.f18223f.setVisibility(8);
                    c1099c.l.setVisibility(0);
                    if (this.f18214i) {
                        c1099c.l.setText(R.string.not_have_fans);
                    } else {
                        int i3 = this.f18215j;
                        if (i3 == 2) {
                            c1099c.l.setText(R.string.her_no_fan_other);
                        } else if (i3 == 1) {
                            c1099c.l.setText(R.string.him_no_fan_other);
                        } else {
                            c1099c.l.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    c1099c.a.setTag(Integer.valueOf(i2));
                    UserData userData = (UserData) ListUtils.getItem(this.f18210e, i2);
                    if (userData == null) {
                        return view;
                    }
                    c1099c.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c1099c.f18219b, userData, 0);
                    c1099c.f18220c.setText(UtilHelper.getUserName(userData));
                    c1099c.f18219b.setPlaceHolder(1);
                    c1099c.f18219b.startLoad(userData.getAvater(), 12, false);
                    if (c1099c.f18221d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c1099c.f18221d.setVisibility(8);
                        } else {
                            c1099c.f18221d.setVisibility(0);
                            c.a.r0.e.b bVar = new c.a.r0.e.b();
                            bVar.a = userData.getAlaUserData();
                            bVar.f12284b = 5;
                            c1099c.f18221d.setTag(bVar);
                        }
                    }
                    if (l.isEmpty(userData.getIntro())) {
                        c1099c.f18222e.setVisibility(8);
                    } else {
                        c1099c.f18222e.setVisibility(0);
                        c1099c.f18222e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c1099c.f18226i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        c1099c.f18225h.setVisibility(8);
                    } else {
                        c1099c.f18225h.setStatsParams(2, userId);
                        c1099c.f18226i.m("9");
                        c1099c.f18225h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1099c.f18227j.getLayoutParams();
                if (ListUtils.getItem(this.f18210e, i2) != null && ((UserData) ListUtils.getItem(this.f18210e, i2)).isLastNewFan) {
                    layoutParams.height = m.f(this.f18213h, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    c1099c.f18227j.setVisibility(0);
                } else {
                    c1099c.f18227j.setVisibility(8);
                    layoutParams.height = m.f(this.f18213h, R.dimen.ds1);
                    layoutParams.setMargins(m.f(this.f18213h, R.dimen.ds34), 0, m.f(this.f18213h, R.dimen.ds34), 0);
                }
                c1099c.f18227j.setLayoutParams(layoutParams);
                c1099c.f18228k = null;
            } else if (itemViewType == 2) {
                c1099c.m.setText(R.string.new_fans);
                c1099c.m.setVisibility(0);
            } else {
                c1099c.f18220c.setText(this.f18213h.getPageContext().getString(R.string.loading));
                c1099c.f18228k.setVisibility(0);
            }
            h(view, c1099c);
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

    public final void h(View view, C1099c c1099c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c1099c) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f18213h.getLayoutMode().k(skinType == 1);
            this.f18213h.getLayoutMode().j(view);
            if (c1099c != null) {
                TextView textView = c1099c.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(c1099c.m, R.color.CAM_X0205);
                }
                ImageView imageView = c1099c.f18227j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c1099c.f18225h;
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
            if (this.f18211f) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
