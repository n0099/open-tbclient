package b.a.r0.d4;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f16974a;

    /* renamed from: b  reason: collision with root package name */
    public View f16975b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f16976c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16977d;

    /* renamed from: e  reason: collision with root package name */
    public View f16978e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16979f;

    /* renamed from: g  reason: collision with root package name */
    public String f16980g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f16981h;

    /* renamed from: i  reason: collision with root package name */
    public e f16982i;
    public c j;
    public boolean k;

    /* renamed from: b.a.r0.d4.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0849a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16983e;

        public View$OnClickListenerC0849a(a aVar) {
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
            this.f16983e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16983e.j.onClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16984a;

        /* renamed from: b  reason: collision with root package name */
        public a f16985b;

        /* renamed from: c  reason: collision with root package name */
        public View f16986c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16987d;

        /* renamed from: e  reason: collision with root package name */
        public View f16988e;

        /* renamed from: f  reason: collision with root package name */
        public String f16989f;

        /* renamed from: g  reason: collision with root package name */
        public int f16990g;

        /* renamed from: h  reason: collision with root package name */
        public d f16991h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f16992i;
        public boolean j;
        public final View.OnClickListener k;

        /* renamed from: b.a.r0.d4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0850a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f16993e;

            public View$OnClickListenerC0850a(b bVar) {
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
                this.f16993e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f16993e.f16991h != null) {
                        this.f16993e.f16991h.onClick();
                    }
                    if (this.f16993e.f16985b == null || this.f16993e.f16985b.c() == null) {
                        return;
                    }
                    this.f16993e.f16985b.c().a(this.f16993e.f16984a, view);
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
            this.f16990g = 17;
            this.f16992i = true;
            this.k = new View$OnClickListenerC0850a(this);
            this.f16989f = str;
            this.f16985b = aVar;
            this.f16984a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16986c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f16987d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f16985b) == null || aVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f16985b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f16985b.d(), false);
            this.f16986c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f16987d = textView;
            textView.setText(this.f16989f);
            this.f16987d.setGravity(this.f16990g);
            View findViewById = this.f16986c.findViewById(R.id.divider_line);
            this.f16988e = findViewById;
            if (this.f16992i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f16987d;
                if (textView != null) {
                    if (this.j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f16987d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f16988e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f16991h = dVar;
                e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes4.dex */
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
        this.f16974a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f16975b = inflate;
        this.f16976c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f16977d = (TextView) this.f16975b.findViewById(R.id.title);
        this.f16978e = this.f16975b.findViewById(R.id.title_divide_line);
        this.f16981h = new ArrayList();
        this.f16979f = (TextView) this.f16975b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f16980g)) {
                this.f16977d.setText(this.f16980g);
                this.f16978e.setVisibility(0);
            } else {
                this.f16977d.setVisibility(8);
                this.f16978e.setVisibility(8);
            }
            if (this.j != null) {
                this.f16979f.setOnClickListener(new View$OnClickListenerC0849a(this));
            }
            e();
            return this.f16975b;
        }
        return (View) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16982i : (e) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16976c : (ViewGroup) invokeV.objValue;
    }

    public void e() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f16975b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f16977d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f16977d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f16978e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f16979f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f16979f, R.color.CAM_X0107);
            List<b> list = this.f16981h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f16980g) && (textView = this.f16977d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f16977d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.f16981h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.f16981h.get(0)) == null || bVar.j) {
                    return;
                }
                bVar.j = true;
                bVar.g();
            }
        }
    }

    public void f(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f16981h = list;
        this.f16976c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f16976c.addView(bVar.d());
            }
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16974a : (Context) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f16980g = str;
        }
    }
}
