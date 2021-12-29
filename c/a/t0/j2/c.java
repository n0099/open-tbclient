package c.a.t0.j2;

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
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.i0.t.c;
import c.a.s0.s.q.i1;
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
public class c extends c.a.t0.j2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f18687h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18688i;

    /* renamed from: j  reason: collision with root package name */
    public int f18689j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f18690k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1125c f18691e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f18692f;

        public a(c cVar, C1125c c1125c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1125c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18692f = cVar;
            this.f18691e = c1125c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f18691e.f18694c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f18691e.f18694c.setCompoundDrawablePadding(n.f(this.f18692f.f18687h, R.dimen.tbds10));
            } else {
                this.f18691e.f18694c.setCompoundDrawablePadding(0);
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

        @Override // c.a.s0.s.i0.t.c.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    n.L(this.a.f18687h, R.string.attention_success);
                } else {
                    n.L(this.a.f18687h, R.string.unfollow_success);
                }
            }
        }
    }

    /* renamed from: c.a.t0.j2.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1125c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f18693b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f18694c;

        /* renamed from: d  reason: collision with root package name */
        public View f18695d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f18696e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f18697f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f18698g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f18699h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.s0.s.i0.t.c f18700i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f18701j;

        /* renamed from: k  reason: collision with root package name */
        public ProgressBar f18702k;
        public TextView l;
        public TextView m;

        public C1125c(c cVar) {
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

        public /* synthetic */ C1125c(c cVar, a aVar) {
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
        this.f18687h = null;
        this.f18688i = true;
        this.f18689j = 0;
        this.f18690k = null;
        this.l = null;
        this.f18687h = personListActivity;
        this.f18688i = z;
        this.f18689j = i2;
        this.f18690k = onClickListener2;
        this.l = onClickListener;
        this.f18684e = new ArrayList<>();
    }

    @Override // c.a.t0.j2.b
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
        if (this.f18684e == null) {
            this.f18684e = new ArrayList<>();
        }
        arrayList.addAll(i1Var.b());
        if (!ListUtils.isEmpty(this.f18684e)) {
            ArrayList<UserData> arrayList2 = this.f18684e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f18684e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f18684e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f18684e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f18684e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f18684e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f18684e.addAll(arrayList);
    }

    @Override // c.a.t0.j2.b
    public boolean d(long j2) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 != 0 && (arrayList = this.f18684e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f18684e.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j2) {
                        this.f18684e.remove(next);
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
            if (this.f18685f) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f18684e;
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
            ArrayList<UserData> arrayList = this.f18684e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f18684e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f18684e;
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
            if (this.f18685f) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f18684e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            return this.f18684e.get(i2).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1125c c1125c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f18684e == null) {
                return view;
            }
            int itemViewType = getItemViewType(i2);
            if (view != null && (view.getTag() instanceof C1125c)) {
                c1125c = (C1125c) view.getTag();
            } else {
                c1125c = new C1125c(this, null);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(this.f18687h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c1125c.a = viewGroup2;
                    viewGroup2.setOnClickListener(this.l);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c1125c.f18693b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(n.f(this.f18687h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c1125c.f18693b.setAutoChangeStyle(true);
                    c1125c.f18693b.setClickable(false);
                    ((LinearLayout.LayoutParams) c1125c.f18693b.getLayoutParams()).setMargins(n.f(this.f18687h, R.dimen.ds34), 0, 0, 0);
                    c1125c.f18697f = (LinearLayout) view.findViewById(R.id.info);
                    c1125c.f18698g = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c1125c.f18694c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c1125c));
                    View a2 = c.a.s0.e.c.b().a(this.f18687h.getPageContext().getPageActivity(), 5);
                    c1125c.f18695d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c1125c.f18698g.addView(c1125c.f18695d, 1);
                    }
                    c1125c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                    c1125c.f18696e = (EMTextView) view.findViewById(R.id.intro);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c1125c.f18699h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f18687h.getPageContext());
                    ((LinearLayout.LayoutParams) c1125c.f18699h.getLayoutParams()).setMargins(0, 0, n.f(this.f18687h, R.dimen.ds34), 0);
                    c.a.s0.s.i0.t.c cVar = new c.a.s0.s.i0.t.c(this.f18687h.getPageContext(), c1125c.f18699h);
                    c1125c.f18700i = cVar;
                    cVar.n((c.a.s0.s.i0.t.a) ListUtils.getItem(this.f18684e, i2));
                    c1125c.f18700i.o(new b(this));
                    c1125c.f18702k = null;
                    c1125c.m = null;
                    c1125c.f18701j = (ImageView) view.findViewById(R.id.diver_buttom_px);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(this.f18687h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    c1125c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
                } else {
                    view = LayoutInflater.from(this.f18687h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c1125c.f18694c = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.f18690k);
                    c1125c.f18702k = (ProgressBar) view.findViewById(R.id.progress);
                    c1125c.m = null;
                }
                view.setTag(c1125c);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1125c.f18699h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            if (itemViewType == 0) {
                if (this.f18685f) {
                    c1125c.f18697f.setVisibility(8);
                    c1125c.l.setVisibility(0);
                    if (this.f18688i) {
                        c1125c.l.setText(R.string.not_have_fans);
                    } else {
                        int i3 = this.f18689j;
                        if (i3 == 2) {
                            c1125c.l.setText(R.string.her_no_fan_other);
                        } else if (i3 == 1) {
                            c1125c.l.setText(R.string.him_no_fan_other);
                        } else {
                            c1125c.l.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    c1125c.a.setTag(Integer.valueOf(i2));
                    UserData userData = (UserData) ListUtils.getItem(this.f18684e, i2);
                    if (userData == null) {
                        return view;
                    }
                    c1125c.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c1125c.f18693b, userData, 0);
                    c1125c.f18694c.setText(UtilHelper.getUserName(userData));
                    c1125c.f18693b.setPlaceHolder(1);
                    c1125c.f18693b.startLoad(userData.getAvater(), 12, false);
                    if (c1125c.f18695d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c1125c.f18695d.setVisibility(8);
                        } else {
                            c1125c.f18695d.setVisibility(0);
                            c.a.s0.e.b bVar = new c.a.s0.e.b();
                            bVar.a = userData.getAlaUserData();
                            bVar.f12637b = 5;
                            c1125c.f18695d.setTag(bVar);
                        }
                    }
                    if (m.isEmpty(userData.getIntro())) {
                        c1125c.f18696e.setVisibility(8);
                    } else {
                        c1125c.f18696e.setVisibility(0);
                        c1125c.f18696e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c1125c.f18700i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        c1125c.f18699h.setVisibility(8);
                    } else {
                        c1125c.f18699h.setStatsParams(2, userId);
                        c1125c.f18700i.m("9");
                        c1125c.f18699h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1125c.f18701j.getLayoutParams();
                if (ListUtils.getItem(this.f18684e, i2) != null && ((UserData) ListUtils.getItem(this.f18684e, i2)).isLastNewFan) {
                    layoutParams.height = n.f(this.f18687h, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    c1125c.f18701j.setVisibility(0);
                } else {
                    c1125c.f18701j.setVisibility(8);
                    layoutParams.height = n.f(this.f18687h, R.dimen.ds1);
                    layoutParams.setMargins(n.f(this.f18687h, R.dimen.ds34), 0, n.f(this.f18687h, R.dimen.ds34), 0);
                }
                c1125c.f18701j.setLayoutParams(layoutParams);
                c1125c.f18702k = null;
            } else if (itemViewType == 2) {
                c1125c.m.setText(R.string.new_fans);
                c1125c.m.setVisibility(0);
            } else {
                c1125c.f18694c.setText(this.f18687h.getPageContext().getString(R.string.loading));
                c1125c.f18702k.setVisibility(0);
            }
            h(view, c1125c);
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

    public final void h(View view, C1125c c1125c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c1125c) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f18687h.getLayoutMode().k(skinType == 1);
            this.f18687h.getLayoutMode().j(view);
            if (c1125c != null) {
                TextView textView = c1125c.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(c1125c.m, R.color.CAM_X0205);
                }
                ImageView imageView = c1125c.f18701j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c1125c.f18699h;
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
            if (this.f18685f) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
