package c.a.p0.a4;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f15331a;

    /* renamed from: b  reason: collision with root package name */
    public View f15332b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15333c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15334d;

    /* renamed from: e  reason: collision with root package name */
    public View f15335e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15336f;

    /* renamed from: g  reason: collision with root package name */
    public String f15337g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f15338h;

    /* renamed from: i  reason: collision with root package name */
    public e f15339i;

    /* renamed from: j  reason: collision with root package name */
    public c f15340j;
    public boolean k;

    /* renamed from: c.a.p0.a4.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0725a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15341e;

        public View$OnClickListenerC0725a(a aVar) {
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
            this.f15341e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15341e.f15340j.onClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f15342a;

        /* renamed from: b  reason: collision with root package name */
        public a f15343b;

        /* renamed from: c  reason: collision with root package name */
        public View f15344c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15345d;

        /* renamed from: e  reason: collision with root package name */
        public View f15346e;

        /* renamed from: f  reason: collision with root package name */
        public String f15347f;

        /* renamed from: g  reason: collision with root package name */
        public int f15348g;

        /* renamed from: h  reason: collision with root package name */
        public d f15349h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15350i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f15351j;
        public final View.OnClickListener k;

        /* renamed from: c.a.p0.a4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0726a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f15352e;

            public View$OnClickListenerC0726a(b bVar) {
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
                this.f15352e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f15352e.f15349h != null) {
                        this.f15352e.f15349h.onClick();
                    }
                    if (this.f15352e.f15343b == null || this.f15352e.f15343b.d() == null) {
                        return;
                    }
                    this.f15352e.f15343b.d().a(this.f15352e.f15342a, view);
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
            this.f15348g = 17;
            this.f15350i = true;
            this.k = new View$OnClickListenerC0726a(this);
            this.f15347f = str;
            this.f15343b = aVar;
            this.f15342a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15344c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f15345d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f15343b) == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f15343b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f15343b.e(), false);
            this.f15344c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f15345d = textView;
            textView.setText(this.f15347f);
            this.f15345d.setGravity(this.f15348g);
            View findViewById = this.f15344c.findViewById(R.id.divider_line);
            this.f15346e = findViewById;
            if (this.f15350i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f15345d;
                if (textView != null) {
                    if (this.f15351j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f15345d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f15346e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f15349h = dVar;
                e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes3.dex */
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
        this.f15331a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f15332b = inflate;
        this.f15333c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f15334d = (TextView) this.f15332b.findViewById(R.id.title);
        this.f15335e = this.f15332b.findViewById(R.id.title_divide_line);
        this.f15338h = new ArrayList();
        this.f15336f = (TextView) this.f15332b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f15337g)) {
                this.f15334d.setText(this.f15337g);
                this.f15335e.setVisibility(0);
            } else {
                this.f15334d.setVisibility(8);
                this.f15335e.setVisibility(8);
            }
            if (this.f15340j != null) {
                this.f15336f.setOnClickListener(new View$OnClickListenerC0725a(this));
            }
            f();
            return this.f15332b;
        }
        return (View) invokeV.objValue;
    }

    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15331a : (Context) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15339i : (e) invokeV.objValue;
    }

    public ViewGroup e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15333c : (ViewGroup) invokeV.objValue;
    }

    public void f() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f15332b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f15334d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f15334d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f15335e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f15336f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f15336f, R.color.CAM_X0107);
            List<b> list = this.f15338h;
            if (list != null) {
                for (b bVar : list) {
                    bVar.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f15337g) && (textView = this.f15334d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = c().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f15334d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                } else if (ListUtils.getCount(this.f15338h) > 0) {
                    b bVar2 = this.f15338h.get(0);
                    if (bVar2.f15351j) {
                        return;
                    }
                    bVar2.f15351j = true;
                    bVar2.g();
                }
            }
        }
    }

    public void g(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.f15338h = list;
        this.f15333c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f15333c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f15340j = cVar;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f15337g = str;
        }
    }
}
