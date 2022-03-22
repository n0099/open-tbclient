package c.a.p0.n2;

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
import c.a.o0.r.l0.t.c;
import c.a.o0.r.r.g1;
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
/* loaded from: classes2.dex */
public class c extends c.a.p0.n2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public PersonListActivity f16535d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16536e;

    /* renamed from: f  reason: collision with root package name */
    public int f16537f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f16538g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f16539h;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ C1239c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f16540b;

        public a(c cVar, C1239c c1239c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1239c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16540b = cVar;
            this.a = c1239c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.a.f16542c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.a.f16542c.setCompoundDrawablePadding(n.f(this.f16540b.f16535d, R.dimen.tbds10));
            } else {
                this.a.f16542c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.o0.r.l0.t.c.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    n.M(this.a.f16535d, R.string.obfuscated_res_0x7f0f02ab);
                } else {
                    n.M(this.a.f16535d, R.string.obfuscated_res_0x7f0f1466);
                }
            }
        }
    }

    /* renamed from: c.a.p0.n2.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1239c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f16541b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f16542c;

        /* renamed from: d  reason: collision with root package name */
        public View f16543d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f16544e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f16545f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f16546g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f16547h;
        public c.a.o0.r.l0.t.c i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C1239c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1239c(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personListActivity, Boolean.valueOf(z), Integer.valueOf(i), onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16535d = null;
        this.f16536e = true;
        this.f16537f = 0;
        this.f16538g = null;
        this.f16539h = null;
        this.f16535d = personListActivity;
        this.f16536e = z;
        this.f16537f = i;
        this.f16538g = onClickListener2;
        this.f16539h = onClickListener;
        this.a = new ArrayList<>();
    }

    @Override // c.a.p0.n2.b
    public void a(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, g1Var) == null) || g1Var == null || g1Var.b() == null) {
            return;
        }
        Iterator<UserData> it = g1Var.b().iterator();
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
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        arrayList.addAll(g1Var.b());
        if (!ListUtils.isEmpty(this.a)) {
            ArrayList<UserData> arrayList2 = this.a;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.a;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.a;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.a) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.a.addAll(arrayList);
                }
            }
        }
        int i = 0;
        while (i < arrayList.size() - 1) {
            UserData userData2 = (UserData) arrayList.get(i);
            i++;
            UserData userData3 = (UserData) arrayList.get(i);
            if (userData2 != null && userData3 != null && userData2.isNewFan && !userData3.isNewFan) {
                userData2.isLastNewFan = true;
            }
        }
        if (ListUtils.isEmpty(this.a)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.a.addAll(arrayList);
    }

    @Override // c.a.p0.n2.b
    public boolean d(long j) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && (arrayList = this.a) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.a.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j) {
                        this.a.remove(next);
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
            if (this.f16533b) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.a;
            int size = arrayList != null ? arrayList.size() : 0;
            return c() ? size + 1 : size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return -1L;
            }
            return i;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (this.f16533b) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return 1;
            }
            return this.a.get(i).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1239c c1239c;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (this.a == null) {
                return view;
            }
            int itemViewType = getItemViewType(i);
            if (view != null && (view.getTag() instanceof C1239c)) {
                c1239c = (C1239c) view.getTag();
                inflate = view;
            } else {
                c1239c = new C1239c(this, null);
                if (itemViewType == 0) {
                    inflate = LayoutInflater.from(this.f16535d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06ca, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090fb2);
                    c1239c.a = viewGroup2;
                    viewGroup2.setOnClickListener(this.f16539h);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091827);
                    c1239c.f16541b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(n.f(this.f16535d.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070301));
                    c1239c.f16541b.setAutoChangeStyle(true);
                    c1239c.f16541b.setClickable(false);
                    ((ViewGroup.MarginLayoutParams) c1239c.f16541b.getLayoutParams()).setMargins(n.f(this.f16535d, R.dimen.obfuscated_res_0x7f07020f), 0, 0, 0);
                    c1239c.f16545f = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090ef3);
                    c1239c.f16546g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091ec3);
                    EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914e9);
                    c1239c.f16542c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c1239c));
                    View a2 = c.a.o0.d.c.b().a(this.f16535d.getPageContext().getPageActivity(), 5);
                    c1239c.f16543d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c1239c.f16546g.addView(c1239c.f16543d, 1);
                    }
                    c1239c.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902b2);
                    c1239c.f16544e = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f47);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) inflate.findViewById(R.id.obfuscated_res_0x7f0902bd);
                    c1239c.f16547h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f16535d.getPageContext());
                    ((LinearLayout.LayoutParams) c1239c.f16547h.getLayoutParams()).setMargins(0, 0, n.f(this.f16535d, R.dimen.obfuscated_res_0x7f07020f), 0);
                    c.a.o0.r.l0.t.c cVar = new c.a.o0.r.l0.t.c(this.f16535d.getPageContext(), c1239c.f16547h);
                    c1239c.i = cVar;
                    cVar.n((c.a.o0.r.l0.t.a) ListUtils.getItem(this.a, i));
                    c1239c.i.o(new b(this));
                    c1239c.k = null;
                    c1239c.m = null;
                    c1239c.j = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0907d6);
                } else if (itemViewType == 2) {
                    inflate = LayoutInflater.from(this.f16535d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0594, (ViewGroup) null);
                    c1239c.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091499);
                } else {
                    inflate = LayoutInflater.from(this.f16535d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
                    c1239c.f16542c = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0916ed);
                    inflate.setOnClickListener(this.f16538g);
                    c1239c.k = (ProgressBar) inflate.findViewById(R.id.obfuscated_res_0x7f091929);
                    c1239c.m = null;
                }
                inflate.setTag(c1239c);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1239c.f16547h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.f16533b) {
                    c1239c.f16545f.setVisibility(8);
                    c1239c.l.setVisibility(0);
                    if (this.f16536e) {
                        c1239c.l.setText(R.string.obfuscated_res_0x7f0f0c71);
                    } else {
                        int i2 = this.f16537f;
                        if (i2 == 2) {
                            c1239c.l.setText(R.string.obfuscated_res_0x7f0f0822);
                        } else if (i2 == 1) {
                            c1239c.l.setText(R.string.obfuscated_res_0x7f0f0825);
                        } else {
                            c1239c.l.setText(R.string.obfuscated_res_0x7f0f0c36);
                        }
                    }
                } else {
                    c1239c.a.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) ListUtils.getItem(this.a, i);
                    if (userData == null) {
                        return inflate;
                    }
                    c1239c.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c1239c.f16541b, userData, 0);
                    c1239c.f16542c.setText(UtilHelper.getUserName(userData));
                    c1239c.f16541b.setPlaceHolder(1);
                    c1239c.f16541b.J(userData.getAvater(), 12, false);
                    if (c1239c.f16543d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c1239c.f16543d.setVisibility(8);
                        } else {
                            c1239c.f16543d.setVisibility(0);
                            c.a.o0.d.b bVar = new c.a.o0.d.b();
                            bVar.a = userData.getAlaUserData();
                            bVar.f9997b = 5;
                            c1239c.f16543d.setTag(bVar);
                        }
                    }
                    if (m.isEmpty(userData.getIntro())) {
                        c1239c.f16544e.setVisibility(8);
                    } else {
                        c1239c.f16544e.setVisibility(0);
                        c1239c.f16544e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c1239c.i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        c1239c.f16547h.setVisibility(8);
                    } else {
                        c1239c.f16547h.setStatsParams(2, userId);
                        c1239c.i.m("9");
                        c1239c.f16547h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1239c.j.getLayoutParams();
                if (ListUtils.getItem(this.a, i) != null && ((UserData) ListUtils.getItem(this.a, i)).isLastNewFan) {
                    layoutParams.height = n.f(this.f16535d, R.dimen.obfuscated_res_0x7f070234);
                    layoutParams.setMargins(0, 0, 0, 0);
                    c1239c.j.setVisibility(0);
                } else {
                    c1239c.j.setVisibility(8);
                    layoutParams.height = n.f(this.f16535d, R.dimen.obfuscated_res_0x7f070198);
                    layoutParams.setMargins(n.f(this.f16535d, R.dimen.obfuscated_res_0x7f07020f), 0, n.f(this.f16535d, R.dimen.obfuscated_res_0x7f07020f), 0);
                }
                c1239c.j.setLayoutParams(layoutParams);
                c1239c.k = null;
            } else if (itemViewType == 2) {
                c1239c.m.setText(R.string.obfuscated_res_0x7f0f0c19);
                c1239c.m.setVisibility(0);
            } else {
                c1239c.f16542c.setText(this.f16535d.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a2e));
                c1239c.k.setVisibility(0);
            }
            h(inflate, c1239c);
            return inflate;
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

    public final void h(View view, C1239c c1239c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c1239c) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f16535d.getLayoutMode().k(skinType == 1);
            this.f16535d.getLayoutMode().j(view);
            if (c1239c != null) {
                TextView textView = c1239c.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(c1239c.m, R.color.CAM_X0205);
                }
                ImageView imageView = c1239c.j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c1239c.f16547h;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.r(skinType);
                }
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.f16533b) {
                return false;
            }
            return super.isEnabled(i);
        }
        return invokeI.booleanValue;
    }
}
