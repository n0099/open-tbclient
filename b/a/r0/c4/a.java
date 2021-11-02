package b.a.r0.c4;

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
    public Context f15342a;

    /* renamed from: b  reason: collision with root package name */
    public View f15343b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15344c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15345d;

    /* renamed from: e  reason: collision with root package name */
    public View f15346e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15347f;

    /* renamed from: g  reason: collision with root package name */
    public String f15348g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f15349h;

    /* renamed from: i  reason: collision with root package name */
    public e f15350i;
    public c j;
    public boolean k;

    /* renamed from: b.a.r0.c4.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0772a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15351e;

        public View$OnClickListenerC0772a(a aVar) {
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
            this.f15351e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15351e.j.onClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f15352a;

        /* renamed from: b  reason: collision with root package name */
        public a f15353b;

        /* renamed from: c  reason: collision with root package name */
        public View f15354c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15355d;

        /* renamed from: e  reason: collision with root package name */
        public View f15356e;

        /* renamed from: f  reason: collision with root package name */
        public String f15357f;

        /* renamed from: g  reason: collision with root package name */
        public int f15358g;

        /* renamed from: h  reason: collision with root package name */
        public d f15359h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15360i;
        public boolean j;
        public final View.OnClickListener k;

        /* renamed from: b.a.r0.c4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0773a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f15361e;

            public View$OnClickListenerC0773a(b bVar) {
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
                this.f15361e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f15361e.f15359h != null) {
                        this.f15361e.f15359h.onClick();
                    }
                    if (this.f15361e.f15353b == null || this.f15361e.f15353b.c() == null) {
                        return;
                    }
                    this.f15361e.f15353b.c().a(this.f15361e.f15352a, view);
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
            this.f15358g = 17;
            this.f15360i = true;
            this.k = new View$OnClickListenerC0773a(this);
            this.f15357f = str;
            this.f15353b = aVar;
            this.f15352a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15354c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f15355d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f15353b) == null || aVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f15353b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f15353b.d(), false);
            this.f15354c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f15355d = textView;
            textView.setText(this.f15357f);
            this.f15355d.setGravity(this.f15358g);
            View findViewById = this.f15354c.findViewById(R.id.divider_line);
            this.f15356e = findViewById;
            if (this.f15360i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f15355d;
                if (textView != null) {
                    if (this.j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f15355d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f15356e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f15359h = dVar;
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
        this.f15342a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f15343b = inflate;
        this.f15344c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f15345d = (TextView) this.f15343b.findViewById(R.id.title);
        this.f15346e = this.f15343b.findViewById(R.id.title_divide_line);
        this.f15349h = new ArrayList();
        this.f15347f = (TextView) this.f15343b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f15348g)) {
                this.f15345d.setText(this.f15348g);
                this.f15346e.setVisibility(0);
            } else {
                this.f15345d.setVisibility(8);
                this.f15346e.setVisibility(8);
            }
            if (this.j != null) {
                this.f15347f.setOnClickListener(new View$OnClickListenerC0772a(this));
            }
            e();
            return this.f15343b;
        }
        return (View) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15350i : (e) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15344c : (ViewGroup) invokeV.objValue;
    }

    public void e() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f15343b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f15345d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f15345d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f15346e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f15347f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f15347f, R.color.CAM_X0107);
            List<b> list = this.f15349h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f15348g) && (textView = this.f15345d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f15345d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.f15349h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.f15349h.get(0)) == null || bVar.j) {
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
        this.f15349h = list;
        this.f15344c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f15344c.addView(bVar.d());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f15342a : (Context) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f15348g = str;
        }
    }
}
