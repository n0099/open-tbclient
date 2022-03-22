package c.a.p0.v3.c;

import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import c.a.o0.r.l0.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.square.flist.ForumListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar A;
    public boolean B;
    public int C;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public final View f19236b;

    /* renamed from: c  reason: collision with root package name */
    public final View f19237c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager f19238d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f19239e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f19240f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19241g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f19242h;
    public BdListView i;
    public BdListView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;
    public ImageView o;
    public LinearLayout p;
    public TextView q;
    public ImageView r;
    public g s;
    public g t;
    public PopupWindow u;
    public View v;
    public ForumListActivity w;
    public ListView x;
    public c.a.p0.v3.c.a y;
    public LinearLayout z;

    /* loaded from: classes2.dex */
    public class a implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
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

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i, keyEvent)) == null) {
                if (i == 4 && this.a.u.isShowing()) {
                    c cVar = this.a;
                    c.a.d.f.m.g.d(cVar.u, cVar.w.getPageContext().getPageActivity());
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.a.u.isShowing()) {
                    c cVar = this.a;
                    c.a.d.f.m.g.d(cVar.u, cVar.w.getPageContext().getPageActivity());
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: c.a.p0.v3.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1455c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C1455c(c cVar) {
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

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B = false;
            }
        }
    }

    public c(ForumListActivity forumListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = false;
        this.C = 0;
        this.a = (LinearLayout) forumListActivity.findViewById(R.id.obfuscated_res_0x7f090a5c);
        ViewPager viewPager = (ViewPager) forumListActivity.findViewById(R.id.obfuscated_res_0x7f0923d4);
        this.f19238d = viewPager;
        viewPager.setOnPageChangeListener(forumListActivity);
        this.f19239e = (LinearLayout) forumListActivity.findViewById(R.id.obfuscated_res_0x7f091e4c);
        NavigationBar navigationBar = (NavigationBar) forumListActivity.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.f19240f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        LinearLayout linearLayout = (LinearLayout) this.f19240f.setTitleView(R.layout.obfuscated_res_0x7f0d05e7, (View.OnClickListener) null);
        this.z = linearLayout;
        this.f19241g = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092059);
        this.f19242h = (ImageView) this.z.findViewById(R.id.obfuscated_res_0x7f090a5f);
        TextView textView = (TextView) forumListActivity.findViewById(R.id.obfuscated_res_0x7f091e4b);
        this.k = textView;
        textView.setOnClickListener(forumListActivity);
        TextView textView2 = (TextView) forumListActivity.findViewById(R.id.obfuscated_res_0x7f091e44);
        this.l = textView2;
        textView2.setOnClickListener(forumListActivity);
        this.s = new g(forumListActivity.getPageContext());
        this.t = new g(forumListActivity.getPageContext());
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02bb, (ViewGroup) null);
        this.m = linearLayout2;
        this.f19236b = linearLayout2.findViewById(R.id.obfuscated_res_0x7f090a08);
        this.n = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f090a0c);
        this.o = (ImageView) this.m.findViewById(R.id.obfuscated_res_0x7f090a0b);
        LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02bb, (ViewGroup) null);
        this.p = linearLayout3;
        this.f19237c = linearLayout3.findViewById(R.id.obfuscated_res_0x7f090a08);
        this.q = (TextView) this.p.findViewById(R.id.obfuscated_res_0x7f090a0c);
        this.r = (ImageView) this.p.findViewById(R.id.obfuscated_res_0x7f090a0b);
        this.A = (ProgressBar) forumListActivity.findViewById(R.id.obfuscated_res_0x7f091309);
        this.B = false;
        this.w = forumListActivity;
        this.y = new c.a.p0.v3.c.a(this.w.getPageContext().getContext());
    }

    public View b(int i, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, onItemClickListener)) == null) {
            View inflate = LayoutInflater.from(this.w.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02b7, (ViewGroup) null);
            ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f0907bd);
            this.x = listView;
            listView.setOnItemClickListener(onItemClickListener);
            inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
            this.C = this.y.getCount();
            this.x.setAdapter((ListAdapter) this.y);
            return inflate;
        }
        return (View) invokeIL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19239e.setVisibility(8);
        }
    }

    public void d() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ProgressBar progressBar = this.A;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            ViewPager viewPager = this.f19238d;
            if (viewPager == null) {
                return;
            }
            if (viewPager.getCurrentItem() == 0 && (bdListView = this.i) != null) {
                bdListView.A(0L);
                return;
            }
            BdListView bdListView2 = this.j;
            if (bdListView2 != null) {
                bdListView2.A(0L);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19242h.setVisibility(4);
            this.z.setClickable(false);
            this.z.setOnClickListener(null);
        }
    }

    public void f(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onItemClickListener) == null) {
            if (!this.B) {
                this.B = true;
                if (this.v == null) {
                    this.v = b(0, onItemClickListener);
                }
                int d2 = (n.d(this.w.getPageContext().getPageActivity(), 160.0f) - this.z.getWidth()) / 2;
                if (this.u == null) {
                    PopupWindow popupWindow = new PopupWindow(this.v, n.d(this.w.getPageContext().getPageActivity(), 160.0f), -2, true);
                    this.u = popupWindow;
                    popupWindow.setBackgroundDrawable(new ColorDrawable(17170445));
                    if (this.C > 6) {
                        this.u.setHeight(n.d(this.w.getPageContext().getPageActivity(), 272.0f));
                    }
                }
                this.u.setOutsideTouchable(true);
                this.u.setFocusable(true);
                this.v.setFocusable(true);
                this.v.setFocusableInTouchMode(true);
                c.a.d.f.m.g.l(this.u, this.z, 0 - d2, n.d(this.w.getPageContext().getPageActivity(), 0.0f));
                this.v.setOnKeyListener(new a(this));
                this.v.setOnTouchListener(new b(this));
                this.u.setOnDismissListener(new C1455c(this));
                return;
            }
            c.a.d.f.m.g.d(this.u, this.w.getPageContext().getPageActivity());
            this.B = false;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f19239e.setVisibility(0);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f19242h.setVisibility(0);
        }
    }
}
