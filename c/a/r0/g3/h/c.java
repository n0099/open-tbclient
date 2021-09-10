package c.a.r0.g3.h;

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
import c.a.e.e.p.l;
import c.a.q0.s.f0.g;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressBar A;
    public boolean B;
    public int C;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f18705a;

    /* renamed from: b  reason: collision with root package name */
    public final View f18706b;

    /* renamed from: c  reason: collision with root package name */
    public final View f18707c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager f18708d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f18709e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f18710f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18711g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f18712h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f18713i;

    /* renamed from: j  reason: collision with root package name */
    public BdListView f18714j;
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
    public c.a.r0.g3.h.a y;
    public LinearLayout z;

    /* loaded from: classes3.dex */
    public class a implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18715e;

        public a(c cVar) {
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
            this.f18715e = cVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (i2 == 4 && this.f18715e.u.isShowing()) {
                    c cVar = this.f18715e;
                    c.a.e.e.m.g.d(cVar.u, cVar.w.getPageContext().getPageActivity());
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18716e;

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
            this.f18716e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f18716e.u.isShowing()) {
                    c cVar = this.f18716e;
                    c.a.e.e.m.g.d(cVar.u, cVar.w.getPageContext().getPageActivity());
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: c.a.r0.g3.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0906c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18717e;

        public C0906c(c cVar) {
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
            this.f18717e = cVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18717e.B = false;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = false;
        this.C = 0;
        this.f18705a = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        ViewPager viewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.f18708d = viewPager;
        viewPager.setOnPageChangeListener(forumListActivity);
        this.f18709e = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        NavigationBar navigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.f18710f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        LinearLayout linearLayout = (LinearLayout) this.f18710f.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.z = linearLayout;
        this.f18711g = (TextView) linearLayout.findViewById(R.id.title_text);
        this.f18712h = (ImageView) this.z.findViewById(R.id.forum_list_title_arrow);
        TextView textView = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.k = textView;
        textView.setOnClickListener(forumListActivity);
        TextView textView2 = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.l = textView2;
        textView2.setOnClickListener(forumListActivity);
        this.s = new g(forumListActivity.getPageContext());
        this.t = new g(forumListActivity.getPageContext());
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.m = linearLayout2;
        this.f18706b = linearLayout2.findViewById(R.id.footer_background);
        this.n = (TextView) this.m.findViewById(R.id.footer_text);
        this.o = (ImageView) this.m.findViewById(R.id.footer_icon);
        LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.p = linearLayout3;
        this.f18707c = linearLayout3.findViewById(R.id.footer_background);
        this.q = (TextView) this.p.findViewById(R.id.footer_text);
        this.r = (ImageView) this.p.findViewById(R.id.footer_icon);
        this.A = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.B = false;
        this.w = forumListActivity;
        this.y = new c.a.r0.g3.h.a(this.w.getPageContext().getContext());
    }

    public View b(int i2, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, onItemClickListener)) == null) {
            View inflate = LayoutInflater.from(this.w.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
            ListView listView = (ListView) inflate.findViewById(R.id.dir_menu_list);
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
            this.f18709e.setVisibility(8);
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
            ViewPager viewPager = this.f18708d;
            if (viewPager == null) {
                return;
            }
            if (viewPager.getCurrentItem() == 0 && (bdListView = this.f18713i) != null) {
                bdListView.completePullRefreshPostDelayed(0L);
                return;
            }
            BdListView bdListView2 = this.f18714j;
            if (bdListView2 != null) {
                bdListView2.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f18712h.setVisibility(4);
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
                int e2 = (l.e(this.w.getPageContext().getPageActivity(), 160.0f) - this.z.getWidth()) / 2;
                if (this.u == null) {
                    PopupWindow popupWindow = new PopupWindow(this.v, l.e(this.w.getPageContext().getPageActivity(), 160.0f), -2, true);
                    this.u = popupWindow;
                    popupWindow.setBackgroundDrawable(new ColorDrawable(17170445));
                    if (this.C > 6) {
                        this.u.setHeight(l.e(this.w.getPageContext().getPageActivity(), 272.0f));
                    }
                }
                this.u.setOutsideTouchable(true);
                this.u.setFocusable(true);
                this.v.setFocusable(true);
                this.v.setFocusableInTouchMode(true);
                c.a.e.e.m.g.l(this.u, this.z, 0 - e2, l.e(this.w.getPageContext().getPageActivity(), 0.0f));
                this.v.setOnKeyListener(new a(this));
                this.v.setOnTouchListener(new b(this));
                this.u.setOnDismissListener(new C0906c(this));
                return;
            }
            c.a.e.e.m.g.d(this.u, this.w.getPageContext().getPageActivity());
            this.B = false;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f18709e.setVisibility(0);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18712h.setVisibility(0);
        }
    }
}
