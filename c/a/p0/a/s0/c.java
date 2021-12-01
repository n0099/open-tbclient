package c.a.p0.a.s0;

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
import c.a.p0.a.g;
import c.a.p0.a.i;
import c.a.p0.a.z2.n0;
import c.a.p0.a.z2.q0;
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
        public final /* synthetic */ List f7901e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f7902f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Resources f7903g;

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
            this.f7901e = list;
            this.f7902f = textView;
            this.f7903g = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f7901e.size() > 0) {
                    this.f7902f.setBackground(this.f7903g.getDrawable(c.a.p0.a.e.swan_app_auth_positive_bg_selector));
                } else {
                    this.f7902f.setBackground(this.f7903g.getDrawable(c.a.p0.a.e.swan_app_auth_pos_button_unable));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7904e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f7905f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f7906g;

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
            this.f7904e = fVar;
            this.f7905f = list;
            this.f7906g = swanAppAlertDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) && this.f7904e.a(dialogInterface, i2, this.f7905f)) {
                this.f7906g.dismiss();
            }
        }
    }

    /* renamed from: c.a.p0.a.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0458c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f7907e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f7908f;

        public View$OnClickListenerC0458c(SwanAppAlertDialog swanAppAlertDialog, DialogInterface.OnClickListener onClickListener) {
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
            this.f7907e = swanAppAlertDialog;
            this.f7908f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7907e.onButtonClick(-1);
                this.f7908f.onClick(this.f7907e, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlertDialog f7909e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f7910f;

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
            this.f7909e = swanAppAlertDialog;
            this.f7910f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7909e.onButtonClick(-2);
                this.f7910f.onClick(this.f7909e, -2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f7912f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f7913g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Drawable f7914h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f7915i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ List f7916j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.s0.d f7917k;
        public final /* synthetic */ View.OnClickListener l;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i2, List list, c.a.p0.a.s0.d dVar, View.OnClickListener onClickListener) {
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
            this.f7912f = textView;
            this.f7913g = drawable;
            this.f7914h = drawable2;
            this.f7915i = i2;
            this.f7916j = list;
            this.f7917k = dVar;
            this.l = onClickListener;
            this.f7911e = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = !this.f7911e;
                this.f7911e = z;
                this.f7912f.setCompoundDrawablesWithIntrinsicBounds(z ? this.f7913g : this.f7914h, (Drawable) null, (Drawable) null, (Drawable) null);
                this.f7912f.setCompoundDrawablePadding(this.f7915i);
                if (this.f7911e) {
                    this.f7916j.add(this.f7917k);
                } else {
                    this.f7916j.remove(this.f7917k);
                }
                this.l.onClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i2, List<c.a.p0.a.s0.d> list);
    }

    @UiThread
    public static SwanAppAlertDialog a(@NonNull Activity activity, @NonNull c.a.p0.a.d2.e eVar, @Nullable String str, @NonNull List<c.a.p0.a.s0.d> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{activity, eVar, str, list, fVar, onCancelListener})) == null) {
            View inflate = View.inflate(activity, g.swan_app_subscribe_msg_dialog, null);
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(c.a.p0.a.f.swan_app_icon);
            Resources resources = activity.getResources();
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, q0.i(eVar.V(), "SwanSubscribeMsgDialog", false)));
                swanAppRoundedImageView.setBorderColor(resources.getColor(c.a.p0.a.c.swan_app_auth_icon_border));
            }
            TextView textView = (TextView) inflate.findViewById(c.a.p0.a.f.auth_negative_button);
            TextView textView2 = (TextView) inflate.findViewById(c.a.p0.a.f.auth_positive_button);
            ((TextView) inflate.findViewById(c.a.p0.a.f.swan_app_name)).setText(eVar.Y());
            ((TextView) inflate.findViewById(c.a.p0.a.f.tips)).setText(str);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(c.a.p0.a.f.template_title_layout);
            ArrayList arrayList = new ArrayList(list);
            if (list.size() > 0) {
                for (c.a.p0.a.s0.d dVar : list) {
                    linearLayout.addView(b(activity, dVar, arrayList, new a(arrayList, textView2, resources)));
                }
            }
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(activity);
            aVar.f(true);
            aVar.W(inflate);
            aVar.n(new c.a.p0.a.a3.h.a());
            aVar.p(c.a.p0.a.e.aiapps_action_sheet_bg);
            aVar.k(false);
            aVar.j();
            aVar.t(false);
            SwanAppAlertDialog c2 = aVar.c();
            b bVar = new b(fVar, arrayList, c2);
            textView2.setOnClickListener(new View$OnClickListenerC0458c(c2, bVar));
            textView.setOnClickListener(new d(c2, bVar));
            c2.setEnableImmersion(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(n0.s(activity), -2);
                window.setWindowAnimations(i.action_sheet_animation);
            }
            return c2;
        }
        return (SwanAppAlertDialog) invokeCommon.objValue;
    }

    public static View b(@NonNull Activity activity, @NonNull c.a.p0.a.s0.d dVar, List<c.a.p0.a.s0.d> list, View.OnClickListener onClickListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, dVar, list, onClickListener)) == null) {
            Resources resources = activity.getResources();
            int dimension = (int) resources.getDimension(c.a.p0.a.d.swan_app_template_title_padding);
            TextView textView = new TextView(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 16, 0, 16);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(c.a.p0.r.a.b.a.b(activity, c.a.p0.a.c.swan_app_msg_dialog_title));
            textView.setText(dVar.f7918b);
            Drawable drawable = resources.getDrawable(c.a.p0.a.e.aiapps_subscribe_msg_unselected);
            Drawable drawable2 = resources.getDrawable(c.a.p0.a.e.aiapps_subscribe_msg_selected);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(dimension);
            textView.setTextSize(18.0f);
            textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, dVar, onClickListener));
            return textView;
        }
        return (View) invokeLLLL.objValue;
    }
}
