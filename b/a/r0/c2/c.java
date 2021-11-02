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
import b.a.e.e.p.k;
import b.a.e.e.p.l;
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
    public PersonListActivity f15152h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15153i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0764c f15154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f15155f;

        public a(c cVar, C0764c c0764c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0764c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15155f = cVar;
            this.f15154e = c0764c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f15154e.f15159c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f15154e.f15159c.setCompoundDrawablePadding(l.g(this.f15155f.f15152h, R.dimen.tbds10));
            } else {
                this.f15154e.f15159c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f15156a;

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
            this.f15156a = cVar;
        }

        @Override // b.a.q0.s.g0.t.c.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f15156a.f15152h, R.string.attention_success);
                } else {
                    l.L(this.f15156a.f15152h, R.string.unfollow_success);
                }
            }
        }
    }

    /* renamed from: b.a.r0.c2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0764c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f15157a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f15158b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f15159c;

        /* renamed from: d  reason: collision with root package name */
        public View f15160d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f15161e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f15162f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f15163g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f15164h;

        /* renamed from: i  reason: collision with root package name */
        public b.a.q0.s.g0.t.c f15165i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C0764c(c cVar) {
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

        public /* synthetic */ C0764c(c cVar, a aVar) {
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
        this.f15152h = null;
        this.f15153i = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.f15152h = personListActivity;
        this.f15153i = z;
        this.j = i2;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f15149e = new ArrayList<>();
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
        if (this.f15149e == null) {
            this.f15149e = new ArrayList<>();
        }
        arrayList.addAll(i1Var.b());
        if (!ListUtils.isEmpty(this.f15149e)) {
            ArrayList<UserData> arrayList2 = this.f15149e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f15149e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f15149e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f15149e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f15149e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f15149e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f15149e.addAll(arrayList);
    }

    @Override // b.a.r0.c2.b
    public boolean d(long j) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && (arrayList = this.f15149e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f15149e.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j) {
                        this.f15149e.remove(next);
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
            if (this.f15150f) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f15149e;
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
            ArrayList<UserData> arrayList = this.f15149e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f15149e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f15149e;
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
            if (this.f15150f) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f15149e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            return this.f15149e.get(i2).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0764c c0764c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f15149e == null) {
                return view;
            }
            int itemViewType = getItemViewType(i2);
            if (view != null && (view.getTag() instanceof C0764c)) {
                c0764c = (C0764c) view.getTag();
            } else {
                c0764c = new C0764c(this, null);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(this.f15152h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c0764c.f15157a = viewGroup2;
                    viewGroup2.setOnClickListener(this.l);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c0764c.f15158b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(l.g(this.f15152h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c0764c.f15158b.setAutoChangeStyle(true);
                    c0764c.f15158b.setClickable(false);
                    ((LinearLayout.LayoutParams) c0764c.f15158b.getLayoutParams()).setMargins(l.g(this.f15152h, R.dimen.ds34), 0, 0, 0);
                    c0764c.f15162f = (LinearLayout) view.findViewById(R.id.info);
                    c0764c.f15163g = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c0764c.f15159c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c0764c));
                    View a2 = b.a.q0.e.c.b().a(this.f15152h.getPageContext().getPageActivity(), 5);
                    c0764c.f15160d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c0764c.f15163g.addView(c0764c.f15160d, 1);
                    }
                    c0764c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                    c0764c.f15161e = (EMTextView) view.findViewById(R.id.intro);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c0764c.f15164h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f15152h.getPageContext());
                    ((LinearLayout.LayoutParams) c0764c.f15164h.getLayoutParams()).setMargins(0, 0, l.g(this.f15152h, R.dimen.ds34), 0);
                    b.a.q0.s.g0.t.c cVar = new b.a.q0.s.g0.t.c(this.f15152h.getPageContext(), c0764c.f15164h);
                    c0764c.f15165i = cVar;
                    cVar.n((b.a.q0.s.g0.t.a) ListUtils.getItem(this.f15149e, i2));
                    c0764c.f15165i.o(new b(this));
                    c0764c.k = null;
                    c0764c.m = null;
                    c0764c.j = (ImageView) view.findViewById(R.id.diver_buttom_px);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(this.f15152h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    c0764c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
                } else {
                    view = LayoutInflater.from(this.f15152h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c0764c.f15159c = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.k);
                    c0764c.k = (ProgressBar) view.findViewById(R.id.progress);
                    c0764c.m = null;
                }
                view.setTag(c0764c);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c0764c.f15164h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            if (itemViewType == 0) {
                if (this.f15150f) {
                    c0764c.f15162f.setVisibility(8);
                    c0764c.l.setVisibility(0);
                    if (this.f15153i) {
                        c0764c.l.setText(R.string.not_have_fans);
                    } else {
                        int i3 = this.j;
                        if (i3 == 2) {
                            c0764c.l.setText(R.string.her_no_fan_other);
                        } else if (i3 == 1) {
                            c0764c.l.setText(R.string.him_no_fan_other);
                        } else {
                            c0764c.l.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    c0764c.f15157a.setTag(Integer.valueOf(i2));
                    UserData userData = (UserData) ListUtils.getItem(this.f15149e, i2);
                    if (userData == null) {
                        return view;
                    }
                    c0764c.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c0764c.f15158b, userData, 0);
                    c0764c.f15159c.setText(UtilHelper.getUserName(userData));
                    c0764c.f15158b.setPlaceHolder(1);
                    c0764c.f15158b.startLoad(userData.getAvater(), 12, false);
                    if (c0764c.f15160d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c0764c.f15160d.setVisibility(8);
                        } else {
                            c0764c.f15160d.setVisibility(0);
                            b.a.q0.e.b bVar = new b.a.q0.e.b();
                            bVar.f12206a = userData.getAlaUserData();
                            bVar.f12207b = 5;
                            c0764c.f15160d.setTag(bVar);
                        }
                    }
                    if (k.isEmpty(userData.getIntro())) {
                        c0764c.f15161e.setVisibility(8);
                    } else {
                        c0764c.f15161e.setVisibility(0);
                        c0764c.f15161e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c0764c.f15165i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        c0764c.f15164h.setVisibility(8);
                    } else {
                        c0764c.f15164h.setStatsParams(2, userId);
                        c0764c.f15165i.m("9");
                        c0764c.f15164h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0764c.j.getLayoutParams();
                if (ListUtils.getItem(this.f15149e, i2) != null && ((UserData) ListUtils.getItem(this.f15149e, i2)).isLastNewFan) {
                    layoutParams.height = l.g(this.f15152h, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    c0764c.j.setVisibility(0);
                } else {
                    c0764c.j.setVisibility(8);
                    layoutParams.height = l.g(this.f15152h, R.dimen.ds1);
                    layoutParams.setMargins(l.g(this.f15152h, R.dimen.ds34), 0, l.g(this.f15152h, R.dimen.ds34), 0);
                }
                c0764c.j.setLayoutParams(layoutParams);
                c0764c.k = null;
            } else if (itemViewType == 2) {
                c0764c.m.setText(R.string.new_fans);
                c0764c.m.setVisibility(0);
            } else {
                c0764c.f15159c.setText(this.f15152h.getPageContext().getString(R.string.loading));
                c0764c.k.setVisibility(0);
            }
            h(view, c0764c);
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

    public final void h(View view, C0764c c0764c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c0764c) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f15152h.getLayoutMode().k(skinType == 1);
            this.f15152h.getLayoutMode().j(view);
            if (c0764c != null) {
                TextView textView = c0764c.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(c0764c.m, R.color.CAM_X0205);
                }
                ImageView imageView = c0764c.j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c0764c.f15164h;
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
            if (this.f15150f) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
