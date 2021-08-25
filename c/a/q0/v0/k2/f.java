package c.a.q0.v0.k2;

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
import c.a.q0.v0.e1;
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
    public LinearLayout f26338a;

    /* renamed from: b  reason: collision with root package name */
    public e1 f26339b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f26340c;

    /* renamed from: d  reason: collision with root package name */
    public View f26341d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<c.a.q0.v0.k2.b> f26342e;

    /* renamed from: f  reason: collision with root package name */
    public Context f26343f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.v0.k2.b f26344g;

    /* renamed from: h  reason: collision with root package name */
    public e f26345h;

    /* renamed from: i  reason: collision with root package name */
    public d f26346i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26347e;

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
            this.f26347e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.m.g.c(this.f26347e.f26340c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f26348a;

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
            this.f26348a = fVar;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f26348a.f26340c == null) {
                return;
            }
            c.a.e.e.m.g.c(this.f26348a.f26340c);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f26349e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f26350f;

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
            this.f26350f = fVar;
            this.f26349e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26350f.f26346i == null) {
                return;
            }
            this.f26350f.f26346i.a(this.f26349e);
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

    /* renamed from: c.a.q0.v0.k2.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1227f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f26351a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f26352b;

        /* renamed from: c  reason: collision with root package name */
        public View f26353c;

        /* renamed from: d  reason: collision with root package name */
        public View f26354d;

        public C1227f() {
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
        this.f26343f = context;
        this.f26345h = eVar;
        this.f26346i = dVar;
        this.f26342e = new SparseArray<>();
        LinearLayout linearLayout = new LinearLayout(context);
        this.f26338a = linearLayout;
        linearLayout.setOrientation(1);
        this.f26338a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f26341d = view;
        view.setOnClickListener(new a(this));
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.q0.v0.k2.b bVar = this.f26344g;
            if (bVar != null) {
                bVar.changeSkinType();
            }
            View view = this.f26341d;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.color.common_color_10050);
            }
            MorePopupWindow morePopupWindow = this.f26340c;
            if (morePopupWindow != null) {
                morePopupWindow.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.transparent_bg));
            }
        }
    }

    public void d() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (morePopupWindow = this.f26340c) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26345h : (e) invokeV.objValue;
    }

    public final void f(Activity activity, View view, TabItemView tabItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, view, tabItemView) == null) {
            if (this.f26340c == null) {
                this.f26340c = new MorePopupWindow(activity, this.f26338a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b(this));
            }
            this.f26340c.setOnDismissListener(new c(this, tabItemView));
        }
    }

    public void g(Activity activity, View view, TabItemView tabItemView, e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, activity, view, tabItemView, e1Var) == null) {
            this.f26339b = e1Var;
            c.a.q0.v0.k2.b bVar = this.f26342e.get(e1Var.f25917a);
            this.f26344g = bVar;
            if (bVar == null) {
                c.a.q0.v0.k2.b a2 = i.a(this.f26339b.f25917a);
                this.f26344g = a2;
                a2.a(this.f26343f, this);
                this.f26342e.put(this.f26339b.f25917a, this.f26344g);
            }
            this.f26344g.setData(e1Var.f25918b);
            if (view instanceof HorizontalTabView) {
                HorizontalTabView horizontalTabView = (HorizontalTabView) view;
                if (horizontalTabView.getmShowMenuCallBack() != null) {
                    int[] iArr = new int[2];
                    horizontalTabView.getLocationInWindow(iArr);
                    l.y(horizontalTabView.getContext());
                    int i2 = l.i(horizontalTabView.getContext());
                    int b2 = this.f26344g.b();
                    int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                    if (measuredHeight < b2) {
                        horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                    }
                }
            }
            this.f26338a.removeAllViews();
            this.f26338a.addView(this.f26344g.getView());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            SkinManager.setBackgroundResource(this.f26341d, R.color.common_color_10050);
            this.f26338a.addView(this.f26341d, layoutParams);
            f(activity, view, tabItemView);
            MorePopupWindow morePopupWindow = this.f26340c;
            if (morePopupWindow != null) {
                morePopupWindow.refresh();
                this.f26340c.setWidthAsWidthOfDeviceScreen(activity);
                this.f26340c.setHeight(-1);
                this.f26340c.showWindowInCustomPosition(0, 0);
            }
        }
    }
}
