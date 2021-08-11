package c.a.n0.a.s0;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import c.a.n0.a.g;
import c.a.n0.a.i;
import c.a.n0.a.v2.n0;
import c.a.n0.a.v2.q0;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f8286e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f8287f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Resources f8288g;

        public a(List list, TextView textView, Resources resources) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, textView, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8286e = list;
            this.f8287f = textView;
            this.f8288g = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f8286e.size() > 0) {
                    this.f8287f.setBackground(this.f8288g.getDrawable(c.a.n0.a.e.swan_app_auth_positive_bg_selector));
                } else {
                    this.f8287f.setBackground(this.f8288g.getDrawable(c.a.n0.a.e.swan_app_auth_pos_button_unable));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8289e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f8290f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f8291g;

        public b(f fVar, List list, SwanAppAlertDialog swanAppAlertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list, swanAppAlertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8289e = fVar;
            this.f8290f = list;
            this.f8291g = swanAppAlertDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) && this.f8289e.a(dialogInterface, i2, this.f8290f)) {
                this.f8291g.dismiss();
            }
        }
    }

    /* renamed from: c.a.n0.a.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0360c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f8292e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f8293f;

        public View$OnClickListenerC0360c(SwanAppAlertDialog swanAppAlertDialog, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlertDialog, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8292e = swanAppAlertDialog;
            this.f8293f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f8292e.onButtonClick(-1);
                this.f8293f.onClick(this.f8292e, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f8294e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f8295f;

        public d(SwanAppAlertDialog swanAppAlertDialog, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlertDialog, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8294e = swanAppAlertDialog;
            this.f8295f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f8294e.onButtonClick(-2);
                this.f8295f.onClick(this.f8294e, -2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f8297f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f8298g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Drawable f8299h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f8300i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ List f8301j;
        public final /* synthetic */ c.a.n0.a.s0.d k;
        public final /* synthetic */ View.OnClickListener l;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i2, List list, c.a.n0.a.s0.d dVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, drawable, drawable2, Integer.valueOf(i2), list, dVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8297f = textView;
            this.f8298g = drawable;
            this.f8299h = drawable2;
            this.f8300i = i2;
            this.f8301j = list;
            this.k = dVar;
            this.l = onClickListener;
            this.f8296e = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = !this.f8296e;
                this.f8296e = z;
                this.f8297f.setCompoundDrawablesWithIntrinsicBounds(z ? this.f8298g : this.f8299h, (Drawable) null, (Drawable) null, (Drawable) null);
                this.f8297f.setCompoundDrawablePadding(this.f8300i);
                if (this.f8296e) {
                    this.f8301j.add(this.k);
                } else {
                    this.f8301j.remove(this.k);
                }
                this.l.onClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i2, List<c.a.n0.a.s0.d> list);
    }

    @UiThread
    public static SwanAppAlertDialog a(@NonNull Activity activity, @NonNull c.a.n0.a.a2.e eVar, @Nullable String str, @NonNull List<c.a.n0.a.s0.d> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{activity, eVar, str, list, fVar, onCancelListener})) == null) {
            View inflate = View.inflate(activity, g.swan_app_subscribe_msg_dialog, null);
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(c.a.n0.a.f.swan_app_icon);
            Resources resources = activity.getResources();
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, q0.i(eVar.L(), "SwanSubscribeMsgDialog", false)));
                swanAppRoundedImageView.setBorderColor(resources.getColor(c.a.n0.a.c.swan_app_auth_icon_border));
            }
            TextView textView = (TextView) inflate.findViewById(c.a.n0.a.f.auth_negative_button);
            TextView textView2 = (TextView) inflate.findViewById(c.a.n0.a.f.auth_positive_button);
            ((TextView) inflate.findViewById(c.a.n0.a.f.swan_app_name)).setText(eVar.O());
            ((TextView) inflate.findViewById(c.a.n0.a.f.tips)).setText(str);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(c.a.n0.a.f.template_title_layout);
            ArrayList arrayList = new ArrayList(list);
            if (list.size() > 0) {
                for (c.a.n0.a.s0.d dVar : list) {
                    linearLayout.addView(b(activity, dVar, arrayList, new a(arrayList, textView2, resources)));
                }
            }
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(activity);
            aVar.f(true);
            aVar.W(inflate);
            aVar.n(new c.a.n0.a.w2.h.a());
            aVar.p(c.a.n0.a.e.aiapps_action_sheet_bg);
            aVar.k(false);
            aVar.j();
            aVar.t(false);
            SwanAppAlertDialog c2 = aVar.c();
            b bVar = new b(fVar, arrayList, c2);
            textView2.setOnClickListener(new View$OnClickListenerC0360c(c2, bVar));
            textView.setOnClickListener(new d(c2, bVar));
            c2.setEnableImmersion(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(n0.t(activity), -2);
                window.setWindowAnimations(i.action_sheet_animation);
            }
            return c2;
        }
        return (SwanAppAlertDialog) invokeCommon.objValue;
    }

    public static View b(@NonNull Activity activity, @NonNull c.a.n0.a.s0.d dVar, List<c.a.n0.a.s0.d> list, View.OnClickListener onClickListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, dVar, list, onClickListener)) == null) {
            Resources resources = activity.getResources();
            int dimension = (int) resources.getDimension(c.a.n0.a.d.swan_app_template_title_padding);
            TextView textView = new TextView(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 16, 0, 16);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(c.a.n0.o.a.b.a.b(activity, c.a.n0.a.c.swan_app_msg_dialog_title));
            textView.setText(dVar.f8303b);
            Drawable drawable = resources.getDrawable(c.a.n0.a.e.aiapps_subscribe_msg_unselected);
            Drawable drawable2 = resources.getDrawable(c.a.n0.a.e.aiapps_subscribe_msg_selected);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(dimension);
            textView.setTextSize(18.0f);
            textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, dVar, onClickListener));
            return textView;
        }
        return (View) invokeLLLL.objValue;
    }
}
