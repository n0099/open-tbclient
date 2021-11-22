package b.a.r0.x0.w2;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.p1;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f28056a;

    /* renamed from: b  reason: collision with root package name */
    public p1 f28057b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f28058c;

    /* renamed from: d  reason: collision with root package name */
    public View f28059d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<b.a.r0.x0.w2.b> f28060e;

    /* renamed from: f  reason: collision with root package name */
    public Context f28061f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.x0.w2.b f28062g;

    /* renamed from: h  reason: collision with root package name */
    public e f28063h;

    /* renamed from: i  reason: collision with root package name */
    public d f28064i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f28065e;

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
            this.f28065e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.e.f.m.g.c(this.f28065e.f28058c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f28066a;

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
            this.f28066a = fVar;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28066a.f28058c == null) {
                return;
            }
            b.a.e.f.m.g.c(this.f28066a.f28058c);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f28067e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f28068f;

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
            this.f28068f = fVar;
            this.f28067e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28068f.f28064i == null) {
                return;
            }
            this.f28068f.f28064i.a(this.f28067e);
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(int i2);
    }

    /* renamed from: b.a.r0.x0.w2.f$f  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1370f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f28069a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f28070b;

        /* renamed from: c  reason: collision with root package name */
        public View f28071c;

        /* renamed from: d  reason: collision with root package name */
        public View f28072d;

        public C1370f() {
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
        this.f28061f = context;
        this.f28063h = eVar;
        this.f28064i = dVar;
        this.f28060e = new SparseArray<>();
        LinearLayout linearLayout = new LinearLayout(context);
        this.f28056a = linearLayout;
        linearLayout.setOrientation(1);
        this.f28056a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f28059d = view;
        view.setOnClickListener(new a(this));
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.r0.x0.w2.b bVar = this.f28062g;
            if (bVar != null) {
                bVar.changeSkinType();
            }
            View view = this.f28059d;
            if (view != null) {
                SkinManager.setBackgroundResource(view, c1.common_color_10050);
            }
            MorePopupWindow morePopupWindow = this.f28058c;
            if (morePopupWindow != null) {
                morePopupWindow.setBackgroundDrawable(SkinManager.getDrawable(e1.transparent_bg));
            }
        }
    }

    public void d() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (morePopupWindow = this.f28058c) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28063h : (e) invokeV.objValue;
    }

    public final void f(Activity activity, View view, TabItemView tabItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, view, tabItemView) == null) {
            if (this.f28058c == null) {
                this.f28058c = new MorePopupWindow(activity, this.f28056a, view, SkinManager.getDrawable(e1.transparent_bg), new b(this));
            }
            this.f28058c.setOnDismissListener(new c(this, tabItemView));
        }
    }

    public void g(Activity activity, View view, TabItemView tabItemView, p1 p1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, activity, view, tabItemView, p1Var) == null) {
            this.f28057b = p1Var;
            b.a.r0.x0.w2.b bVar = this.f28060e.get(p1Var.f27621a);
            this.f28062g = bVar;
            if (bVar == null) {
                b.a.r0.x0.w2.b a2 = i.a(this.f28057b.f27621a);
                this.f28062g = a2;
                a2.a(this.f28061f, this);
                this.f28060e.put(this.f28057b.f27621a, this.f28062g);
            }
            this.f28062g.setData(p1Var.f27622b);
            if (view instanceof HorizontalTabView) {
                HorizontalTabView horizontalTabView = (HorizontalTabView) view;
                if (horizontalTabView.getmShowMenuCallBack() != null) {
                    int[] iArr = new int[2];
                    horizontalTabView.getLocationInWindow(iArr);
                    l.y(horizontalTabView.getContext());
                    int i2 = l.i(horizontalTabView.getContext());
                    int b2 = this.f28062g.b();
                    int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                    if (measuredHeight < b2) {
                        horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                    }
                }
            }
            this.f28056a.removeAllViews();
            this.f28056a.addView(this.f28062g.getView());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            SkinManager.setBackgroundResource(this.f28059d, c1.common_color_10050);
            this.f28056a.addView(this.f28059d, layoutParams);
            f(activity, view, tabItemView);
            MorePopupWindow morePopupWindow = this.f28058c;
            if (morePopupWindow != null) {
                morePopupWindow.refresh();
                this.f28058c.setWidthAsWidthOfDeviceScreen(activity);
                this.f28058c.setHeight(-1);
                this.f28058c.showWindowInCustomPosition(0, 0);
            }
        }
    }
}
