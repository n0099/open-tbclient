package c.a.u0.q4;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f21460b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f21461c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21462d;

    /* renamed from: e  reason: collision with root package name */
    public View f21463e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21464f;

    /* renamed from: g  reason: collision with root package name */
    public String f21465g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f21466h;

    /* renamed from: i  reason: collision with root package name */
    public e f21467i;

    /* renamed from: j  reason: collision with root package name */
    public c f21468j;
    public boolean k;

    /* renamed from: c.a.u0.q4.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1321a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21469e;

        public View$OnClickListenerC1321a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21469e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21469e.f21468j.onClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public a f21470b;

        /* renamed from: c  reason: collision with root package name */
        public View f21471c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f21472d;

        /* renamed from: e  reason: collision with root package name */
        public View f21473e;

        /* renamed from: f  reason: collision with root package name */
        public String f21474f;

        /* renamed from: g  reason: collision with root package name */
        public int f21475g;

        /* renamed from: h  reason: collision with root package name */
        public d f21476h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f21477i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f21478j;
        public final View.OnClickListener k;

        /* renamed from: c.a.u0.q4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1322a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21479e;

            public View$OnClickListenerC1322a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21479e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f21479e.f21476h != null) {
                        this.f21479e.f21476h.onClick();
                    }
                    if (this.f21479e.f21470b == null || this.f21479e.f21470b.c() == null) {
                        return;
                    }
                    this.f21479e.f21470b.c().a(this.f21479e.a, view);
                }
            }
        }

        public b(String str, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21475g = 17;
            this.f21477i = true;
            this.k = new View$OnClickListenerC1322a(this);
            this.f21474f = str;
            this.f21470b = aVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21471c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f21472d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f21470b) == null || aVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f21470b.getContext()).inflate(c.a.u0.a4.h.bottom_up_list_dialog_item, this.f21470b.d(), false);
            this.f21471c = inflate;
            TextView textView = (TextView) inflate.findViewById(c.a.u0.a4.g.item_view);
            this.f21472d = textView;
            textView.setText(this.f21474f);
            this.f21472d.setGravity(this.f21475g);
            View findViewById = this.f21471c.findViewById(c.a.u0.a4.g.divider_line);
            this.f21473e = findViewById;
            if (this.f21477i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f21472d;
                if (textView != null) {
                    if (this.f21478j) {
                        SkinManager.setBackgroundResource(textView, c.a.u0.a4.f.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(c.a.u0.a4.d.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f21472d, c.a.u0.a4.d.CAM_X0105);
                SkinManager.setBackgroundColor(this.f21473e, c.a.u0.a4.d.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f21476h = dVar;
                e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i2, View view);
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(c.a.u0.a4.h.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f21460b = inflate;
        this.f21461c = (LinearLayout) inflate.findViewById(c.a.u0.a4.g.content_view);
        this.f21462d = (TextView) this.f21460b.findViewById(c.a.u0.a4.g.title);
        this.f21463e = this.f21460b.findViewById(c.a.u0.a4.g.title_divide_line);
        this.f21466h = new ArrayList();
        this.f21464f = (TextView) this.f21460b.findViewById(c.a.u0.a4.g.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f21465g)) {
                this.f21462d.setText(this.f21465g);
                this.f21463e.setVisibility(0);
            } else {
                this.f21462d.setVisibility(8);
                this.f21463e.setVisibility(8);
            }
            if (this.f21468j != null) {
                this.f21464f.setOnClickListener(new View$OnClickListenerC1321a(this));
            }
            e();
            return this.f21460b;
        }
        return (View) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21467i : (e) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21461c : (ViewGroup) invokeV.objValue;
    }

    public void e() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f21460b, c.a.u0.a4.d.CAM_X0204);
            SkinManager.setBackgroundResource(this.f21462d, c.a.u0.a4.f.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f21462d, c.a.u0.a4.d.CAM_X0108);
            SkinManager.setBackgroundColor(this.f21463e, c.a.u0.a4.d.CAM_X0204);
            SkinManager.setBackgroundResource(this.f21464f, c.a.u0.a4.f.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f21464f, c.a.u0.a4.d.CAM_X0107);
            List<b> list = this.f21466h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f21465g) && (textView = this.f21462d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = getContext().getResources().getDimension(c.a.u0.a4.e.tbds32);
                    ((GradientDrawable) this.f21462d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.f21466h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.f21466h.get(0)) == null || bVar.f21478j) {
                    return;
                }
                bVar.f21478j = true;
                bVar.g();
            }
        }
    }

    public void f(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f21466h = list;
        this.f21461c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f21461c.addView(bVar.d());
            }
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f21468j = cVar;
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f21465g = str;
        }
    }
}
