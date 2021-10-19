package c.a.r0.x0.l2;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.r0.x0.e1;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f27200a;

    /* renamed from: b  reason: collision with root package name */
    public e1 f27201b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f27202c;

    /* renamed from: d  reason: collision with root package name */
    public View f27203d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<c.a.r0.x0.l2.b> f27204e;

    /* renamed from: f  reason: collision with root package name */
    public Context f27205f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.x0.l2.b f27206g;

    /* renamed from: h  reason: collision with root package name */
    public e f27207h;

    /* renamed from: i  reason: collision with root package name */
    public d f27208i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f27209e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27209e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.m.g.c(this.f27209e.f27202c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f27210a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27210a = fVar;
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f27210a.f27202c == null) {
                return;
            }
            c.a.e.e.m.g.c(this.f27210a.f27202c);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f27211e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f27212f;

        public c(f fVar, TabItemView tabItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, tabItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27212f = fVar;
            this.f27211e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27212f.f27208i == null) {
                return;
            }
            this.f27212f.f27208i.a(this.f27211e);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i2);
    }

    /* renamed from: c.a.r0.x0.l2.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1273f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f27213a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f27214b;

        /* renamed from: c  reason: collision with root package name */
        public View f27215c;

        /* renamed from: d  reason: collision with root package name */
        public View f27216d;

        public C1273f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public f(Context context, e eVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27205f = context;
        this.f27207h = eVar;
        this.f27208i = dVar;
        this.f27204e = new SparseArray<>();
        LinearLayout linearLayout = new LinearLayout(context);
        this.f27200a = linearLayout;
        linearLayout.setOrientation(1);
        this.f27200a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f27203d = view;
        view.setOnClickListener(new a(this));
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.r0.x0.l2.b bVar = this.f27206g;
            if (bVar != null) {
                bVar.changeSkinType();
            }
            View view = this.f27203d;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.common_color_10050);
            }
            MorePopupWindow morePopupWindow = this.f27202c;
            if (morePopupWindow != null) {
                morePopupWindow.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.transparent_bg));
            }
        }
    }

    public void d() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (morePopupWindow = this.f27202c) == null) {
            return;
        }
        try {
            morePopupWindow.dismiss();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27207h : (e) invokeV.objValue;
    }

    public final void f(Activity activity, View view, TabItemView tabItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, view, tabItemView) == null) {
            if (this.f27202c == null) {
                this.f27202c = new MorePopupWindow(activity, this.f27200a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b(this));
            }
            this.f27202c.setOnDismissListener(new c(this, tabItemView));
        }
    }

    public void g(Activity activity, View view, TabItemView tabItemView, e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, activity, view, tabItemView, e1Var) == null) {
            this.f27201b = e1Var;
            c.a.r0.x0.l2.b bVar = this.f27204e.get(e1Var.f26768a);
            this.f27206g = bVar;
            if (bVar == null) {
                c.a.r0.x0.l2.b a2 = i.a(this.f27201b.f26768a);
                this.f27206g = a2;
                a2.a(this.f27205f, this);
                this.f27204e.put(this.f27201b.f26768a, this.f27206g);
            }
            this.f27206g.setData(e1Var.f26769b);
            if (view instanceof HorizontalTabView) {
                HorizontalTabView horizontalTabView = (HorizontalTabView) view;
                if (horizontalTabView.getmShowMenuCallBack() != null) {
                    int[] iArr = new int[2];
                    horizontalTabView.getLocationInWindow(iArr);
                    l.y(horizontalTabView.getContext());
                    int i2 = l.i(horizontalTabView.getContext());
                    int b2 = this.f27206g.b();
                    int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                    if (measuredHeight < b2) {
                        horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                    }
                }
            }
            this.f27200a.removeAllViews();
            this.f27200a.addView(this.f27206g.getView());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            SkinManager.setBackgroundResource(this.f27203d, R.color.common_color_10050);
            this.f27200a.addView(this.f27203d, layoutParams);
            f(activity, view, tabItemView);
            MorePopupWindow morePopupWindow = this.f27202c;
            if (morePopupWindow != null) {
                morePopupWindow.refresh();
                this.f27202c.setWidthAsWidthOfDeviceScreen(activity);
                this.f27202c.setHeight(-1);
                this.f27202c.showWindowInCustomPosition(0, 0);
            }
        }
    }
}
