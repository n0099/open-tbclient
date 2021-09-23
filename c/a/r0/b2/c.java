package c.a.r0.b2;

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
import c.a.q0.s.f0.t.c;
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
/* loaded from: classes3.dex */
public class c extends c.a.r0.b2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f15955h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15956i;

    /* renamed from: j  reason: collision with root package name */
    public int f15957j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0761c f15958e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f15959f;

        public a(c cVar, C0761c c0761c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0761c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15959f = cVar;
            this.f15958e = c0761c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f15958e.f15963c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f15958e.f15963c.setCompoundDrawablePadding(l.g(this.f15959f.f15955h, R.dimen.tbds10));
            } else {
                this.f15958e.f15963c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f15960a;

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
            this.f15960a = cVar;
        }

        @Override // c.a.q0.s.f0.t.c.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f15960a.f15955h, R.string.attention_success);
                } else {
                    l.L(this.f15960a.f15955h, R.string.unfollow_success);
                }
            }
        }
    }

    /* renamed from: c.a.r0.b2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0761c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f15961a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15962b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f15963c;

        /* renamed from: d  reason: collision with root package name */
        public View f15964d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f15965e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f15966f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f15967g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f15968h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.q0.s.f0.t.c f15969i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f15970j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C0761c(c cVar) {
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

        public /* synthetic */ C0761c(c cVar, a aVar) {
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
        this.f15955h = null;
        this.f15956i = true;
        this.f15957j = 0;
        this.k = null;
        this.l = null;
        this.f15955h = personListActivity;
        this.f15956i = z;
        this.f15957j = i2;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f15952e = new ArrayList<>();
    }

    @Override // c.a.r0.b2.b
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
        if (this.f15952e == null) {
            this.f15952e = new ArrayList<>();
        }
        arrayList.addAll(i1Var.b());
        if (!ListUtils.isEmpty(this.f15952e)) {
            ArrayList<UserData> arrayList2 = this.f15952e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f15952e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f15952e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f15952e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f15952e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f15952e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f15952e.addAll(arrayList);
    }

    @Override // c.a.r0.b2.b
    public boolean d(long j2) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 != 0 && (arrayList = this.f15952e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f15952e.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j2) {
                        this.f15952e.remove(next);
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
            if (this.f15953f) {
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
            if (this.f15953f) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f15952e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            return this.f15952e.get(i2).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0761c c0761c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f15952e == null) {
                return view;
            }
            int itemViewType = getItemViewType(i2);
            if (view != null && (view.getTag() instanceof C0761c)) {
                c0761c = (C0761c) view.getTag();
            } else {
                c0761c = new C0761c(this, null);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(this.f15955h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c0761c.f15961a = viewGroup2;
                    viewGroup2.setOnClickListener(this.l);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c0761c.f15962b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(l.g(this.f15955h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c0761c.f15962b.setAutoChangeStyle(true);
                    c0761c.f15962b.setClickable(false);
                    ((LinearLayout.LayoutParams) c0761c.f15962b.getLayoutParams()).setMargins(l.g(this.f15955h, R.dimen.ds34), 0, 0, 0);
                    c0761c.f15966f = (LinearLayout) view.findViewById(R.id.info);
                    c0761c.f15967g = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c0761c.f15963c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c0761c));
                    View a2 = c.a.q0.e.c.b().a(this.f15955h.getPageContext().getPageActivity(), 5);
                    c0761c.f15964d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c0761c.f15967g.addView(c0761c.f15964d, 1);
                    }
                    c0761c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                    c0761c.f15965e = (EMTextView) view.findViewById(R.id.intro);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c0761c.f15968h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f15955h.getPageContext());
                    ((LinearLayout.LayoutParams) c0761c.f15968h.getLayoutParams()).setMargins(0, 0, l.g(this.f15955h, R.dimen.ds34), 0);
                    c.a.q0.s.f0.t.c cVar = new c.a.q0.s.f0.t.c(this.f15955h.getPageContext(), c0761c.f15968h);
                    c0761c.f15969i = cVar;
                    cVar.n((c.a.q0.s.f0.t.a) ListUtils.getItem(this.f15952e, i2));
                    c0761c.f15969i.o(new b(this));
                    c0761c.k = null;
                    c0761c.m = null;
                    c0761c.f15970j = (ImageView) view.findViewById(R.id.diver_buttom_px);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(this.f15955h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    c0761c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
                } else {
                    view = LayoutInflater.from(this.f15955h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c0761c.f15963c = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.k);
                    c0761c.k = (ProgressBar) view.findViewById(R.id.progress);
                    c0761c.m = null;
                }
                view.setTag(c0761c);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c0761c.f15968h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            if (itemViewType == 0) {
                if (this.f15953f) {
                    c0761c.f15966f.setVisibility(8);
                    c0761c.l.setVisibility(0);
                    if (this.f15956i) {
                        c0761c.l.setText(R.string.not_have_fans);
                    } else {
                        int i3 = this.f15957j;
                        if (i3 == 2) {
                            c0761c.l.setText(R.string.her_no_fan_other);
                        } else if (i3 == 1) {
                            c0761c.l.setText(R.string.him_no_fan_other);
                        } else {
                            c0761c.l.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    c0761c.f15961a.setTag(Integer.valueOf(i2));
                    UserData userData = (UserData) ListUtils.getItem(this.f15952e, i2);
                    if (userData == null) {
                        return view;
                    }
                    c0761c.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c0761c.f15962b, userData, 0);
                    c0761c.f15963c.setText(UtilHelper.getUserName(userData));
                    c0761c.f15962b.setPlaceHolder(1);
                    c0761c.f15962b.startLoad(userData.getAvater(), 12, false);
                    if (c0761c.f15964d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c0761c.f15964d.setVisibility(8);
                        } else {
                            c0761c.f15964d.setVisibility(0);
                            c.a.q0.e.b bVar = new c.a.q0.e.b();
                            bVar.f13044a = userData.getAlaUserData();
                            bVar.f13045b = 5;
                            c0761c.f15964d.setTag(bVar);
                        }
                    }
                    if (k.isEmpty(userData.getIntro())) {
                        c0761c.f15965e.setVisibility(8);
                    } else {
                        c0761c.f15965e.setVisibility(0);
                        c0761c.f15965e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c0761c.f15969i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        c0761c.f15968h.setVisibility(8);
                    } else {
                        c0761c.f15968h.setStatsParams(2, userId);
                        c0761c.f15969i.m("9");
                        c0761c.f15968h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0761c.f15970j.getLayoutParams();
                if (ListUtils.getItem(this.f15952e, i2) != null && ((UserData) ListUtils.getItem(this.f15952e, i2)).isLastNewFan) {
                    layoutParams.height = l.g(this.f15955h, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    c0761c.f15970j.setVisibility(0);
                } else {
                    c0761c.f15970j.setVisibility(8);
                    layoutParams.height = l.g(this.f15955h, R.dimen.ds1);
                    layoutParams.setMargins(l.g(this.f15955h, R.dimen.ds34), 0, l.g(this.f15955h, R.dimen.ds34), 0);
                }
                c0761c.f15970j.setLayoutParams(layoutParams);
                c0761c.k = null;
            } else if (itemViewType == 2) {
                c0761c.m.setText(R.string.new_fans);
                c0761c.m.setVisibility(0);
            } else {
                c0761c.f15963c.setText(this.f15955h.getPageContext().getString(R.string.loading));
                c0761c.k.setVisibility(0);
            }
            h(view, c0761c);
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

    public final void h(View view, C0761c c0761c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c0761c) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f15955h.getLayoutMode().k(skinType == 1);
            this.f15955h.getLayoutMode().j(view);
            if (c0761c != null) {
                TextView textView = c0761c.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(c0761c.m, R.color.CAM_X0205);
                }
                ImageView imageView = c0761c.f15970j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c0761c.f15968h;
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
            if (this.f15953f) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
