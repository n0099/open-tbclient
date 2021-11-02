package b.a.r0.x0.v2;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.r0.x0.b1;
import b.a.r0.x0.d1;
import b.a.r0.x0.o1;
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
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f26456a;

    /* renamed from: b  reason: collision with root package name */
    public o1 f26457b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f26458c;

    /* renamed from: d  reason: collision with root package name */
    public View f26459d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<b.a.r0.x0.v2.b> f26460e;

    /* renamed from: f  reason: collision with root package name */
    public Context f26461f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.x0.v2.b f26462g;

    /* renamed from: h  reason: collision with root package name */
    public e f26463h;

    /* renamed from: i  reason: collision with root package name */
    public d f26464i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26465e;

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
            this.f26465e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.e.e.m.g.c(this.f26465e.f26458c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f26466a;

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
            this.f26466a = fVar;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f26466a.f26458c == null) {
                return;
            }
            b.a.e.e.m.g.c(this.f26466a.f26458c);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f26467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f26468f;

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
            this.f26468f = fVar;
            this.f26467e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26468f.f26464i == null) {
                return;
            }
            this.f26468f.f26464i.a(this.f26467e);
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i2);
    }

    /* renamed from: b.a.r0.x0.v2.f$f  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1297f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f26469a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f26470b;

        /* renamed from: c  reason: collision with root package name */
        public View f26471c;

        /* renamed from: d  reason: collision with root package name */
        public View f26472d;

        public C1297f() {
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
        this.f26461f = context;
        this.f26463h = eVar;
        this.f26464i = dVar;
        this.f26460e = new SparseArray<>();
        LinearLayout linearLayout = new LinearLayout(context);
        this.f26456a = linearLayout;
        linearLayout.setOrientation(1);
        this.f26456a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f26459d = view;
        view.setOnClickListener(new a(this));
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.r0.x0.v2.b bVar = this.f26462g;
            if (bVar != null) {
                bVar.changeSkinType();
            }
            View view = this.f26459d;
            if (view != null) {
                SkinManager.setBackgroundResource(view, b1.common_color_10050);
            }
            MorePopupWindow morePopupWindow = this.f26458c;
            if (morePopupWindow != null) {
                morePopupWindow.setBackgroundDrawable(SkinManager.getDrawable(d1.transparent_bg));
            }
        }
    }

    public void d() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (morePopupWindow = this.f26458c) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26463h : (e) invokeV.objValue;
    }

    public final void f(Activity activity, View view, TabItemView tabItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, view, tabItemView) == null) {
            if (this.f26458c == null) {
                this.f26458c = new MorePopupWindow(activity, this.f26456a, view, SkinManager.getDrawable(d1.transparent_bg), new b(this));
            }
            this.f26458c.setOnDismissListener(new c(this, tabItemView));
        }
    }

    public void g(Activity activity, View view, TabItemView tabItemView, o1 o1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, activity, view, tabItemView, o1Var) == null) {
            this.f26457b = o1Var;
            b.a.r0.x0.v2.b bVar = this.f26460e.get(o1Var.f26025a);
            this.f26462g = bVar;
            if (bVar == null) {
                b.a.r0.x0.v2.b a2 = i.a(this.f26457b.f26025a);
                this.f26462g = a2;
                a2.a(this.f26461f, this);
                this.f26460e.put(this.f26457b.f26025a, this.f26462g);
            }
            this.f26462g.setData(o1Var.f26026b);
            if (view instanceof HorizontalTabView) {
                HorizontalTabView horizontalTabView = (HorizontalTabView) view;
                if (horizontalTabView.getmShowMenuCallBack() != null) {
                    int[] iArr = new int[2];
                    horizontalTabView.getLocationInWindow(iArr);
                    l.y(horizontalTabView.getContext());
                    int i2 = l.i(horizontalTabView.getContext());
                    int b2 = this.f26462g.b();
                    int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                    if (measuredHeight < b2) {
                        horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                    }
                }
            }
            this.f26456a.removeAllViews();
            this.f26456a.addView(this.f26462g.getView());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            SkinManager.setBackgroundResource(this.f26459d, b1.common_color_10050);
            this.f26456a.addView(this.f26459d, layoutParams);
            f(activity, view, tabItemView);
            MorePopupWindow morePopupWindow = this.f26458c;
            if (morePopupWindow != null) {
                morePopupWindow.refresh();
                this.f26458c.setWidthAsWidthOfDeviceScreen(activity);
                this.f26458c.setHeight(-1);
                this.f26458c.showWindowInCustomPosition(0, 0);
            }
        }
    }
}
