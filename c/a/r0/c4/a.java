package c.a.r0.c4;

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
    public Context f16322a;

    /* renamed from: b  reason: collision with root package name */
    public View f16323b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f16324c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16325d;

    /* renamed from: e  reason: collision with root package name */
    public View f16326e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16327f;

    /* renamed from: g  reason: collision with root package name */
    public String f16328g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f16329h;

    /* renamed from: i  reason: collision with root package name */
    public e f16330i;

    /* renamed from: j  reason: collision with root package name */
    public c f16331j;
    public boolean k;

    /* renamed from: c.a.r0.c4.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0777a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16332e;

        public View$OnClickListenerC0777a(a aVar) {
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
            this.f16332e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16332e.f16331j.onClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16333a;

        /* renamed from: b  reason: collision with root package name */
        public a f16334b;

        /* renamed from: c  reason: collision with root package name */
        public View f16335c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16336d;

        /* renamed from: e  reason: collision with root package name */
        public View f16337e;

        /* renamed from: f  reason: collision with root package name */
        public String f16338f;

        /* renamed from: g  reason: collision with root package name */
        public int f16339g;

        /* renamed from: h  reason: collision with root package name */
        public d f16340h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f16341i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f16342j;
        public final View.OnClickListener k;

        /* renamed from: c.a.r0.c4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0778a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f16343e;

            public View$OnClickListenerC0778a(b bVar) {
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
                this.f16343e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f16343e.f16340h != null) {
                        this.f16343e.f16340h.onClick();
                    }
                    if (this.f16343e.f16334b == null || this.f16343e.f16334b.d() == null) {
                        return;
                    }
                    this.f16343e.f16334b.d().a(this.f16343e.f16333a, view);
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
            this.f16339g = 17;
            this.f16341i = true;
            this.k = new View$OnClickListenerC0778a(this);
            this.f16338f = str;
            this.f16334b = aVar;
            this.f16333a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16335c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f16336d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f16334b) == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f16334b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f16334b.e(), false);
            this.f16335c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f16336d = textView;
            textView.setText(this.f16338f);
            this.f16336d.setGravity(this.f16339g);
            View findViewById = this.f16335c.findViewById(R.id.divider_line);
            this.f16337e = findViewById;
            if (this.f16341i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f16336d;
                if (textView != null) {
                    if (this.f16342j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f16336d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f16337e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f16340h = dVar;
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
        this.f16322a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f16323b = inflate;
        this.f16324c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f16325d = (TextView) this.f16323b.findViewById(R.id.title);
        this.f16326e = this.f16323b.findViewById(R.id.title_divide_line);
        this.f16329h = new ArrayList();
        this.f16327f = (TextView) this.f16323b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f16328g)) {
                this.f16325d.setText(this.f16328g);
                this.f16326e.setVisibility(0);
            } else {
                this.f16325d.setVisibility(8);
                this.f16326e.setVisibility(8);
            }
            if (this.f16331j != null) {
                this.f16327f.setOnClickListener(new View$OnClickListenerC0777a(this));
            }
            f();
            return this.f16323b;
        }
        return (View) invokeV.objValue;
    }

    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16322a : (Context) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16330i : (e) invokeV.objValue;
    }

    public ViewGroup e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16324c : (ViewGroup) invokeV.objValue;
    }

    public void f() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f16323b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f16325d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f16325d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f16326e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f16327f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f16327f, R.color.CAM_X0107);
            List<b> list = this.f16329h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f16328g) && (textView = this.f16325d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = c().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f16325d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.f16329h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.f16329h.get(0)) == null || bVar.f16342j) {
                    return;
                }
                bVar.f16342j = true;
                bVar.g();
            }
        }
    }

    public void g(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.f16329h = list;
        this.f16324c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f16324c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f16331j = cVar;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f16328g = str;
        }
    }
}
