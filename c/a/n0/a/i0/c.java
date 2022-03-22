package c.a.n0.a.i0;

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
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.s1.b.b.h;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.tieba.R;
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
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f4832b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Resources f4833c;

        public a(List list, TextView textView, Resources resources) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, textView, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.f4832b = textView;
            this.f4833c = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.size() > 0) {
                    this.f4832b.setBackground(this.f4833c.getDrawable(R.drawable.obfuscated_res_0x7f081105));
                } else {
                    this.f4832b.setBackground(this.f4833c.getDrawable(R.drawable.obfuscated_res_0x7f081104));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f4834b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f4835c;

        public b(f fVar, List list, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f4834b = list;
            this.f4835c = hVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && this.a.a(dialogInterface, i, this.f4834b)) {
                this.f4835c.dismiss();
            }
        }
    }

    /* renamed from: c.a.n0.a.i0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0316c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f4836b;

        public View$OnClickListenerC0316c(h hVar, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
            this.f4836b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.e(-1);
                this.f4836b.onClick(this.a, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f4837b;

        public d(h hVar, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
            this.f4837b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.e(-2);
                this.f4837b.onClick(this.a, -2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f4838b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Drawable f4839c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Drawable f4840d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f4841e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f4842f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.i0.d f4843g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f4844h;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i, List list, c.a.n0.a.i0.d dVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, drawable, drawable2, Integer.valueOf(i), list, dVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4838b = textView;
            this.f4839c = drawable;
            this.f4840d = drawable2;
            this.f4841e = i;
            this.f4842f = list;
            this.f4843g = dVar;
            this.f4844h = onClickListener;
            this.a = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = !this.a;
                this.a = z;
                this.f4838b.setCompoundDrawablesWithIntrinsicBounds(z ? this.f4839c : this.f4840d, (Drawable) null, (Drawable) null, (Drawable) null);
                this.f4838b.setCompoundDrawablePadding(this.f4841e);
                if (this.a) {
                    this.f4842f.add(this.f4843g);
                } else {
                    this.f4842f.remove(this.f4843g);
                }
                this.f4844h.onClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i, List<c.a.n0.a.i0.d> list);
    }

    @UiThread
    public static h a(@NonNull Activity activity, @NonNull c.a.n0.a.t1.e eVar, @Nullable String str, @NonNull List<c.a.n0.a.i0.d> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{activity, eVar, str, list, fVar, onCancelListener})) == null) {
            View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d07ce, null);
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091dee);
            Resources resources = activity.getResources();
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, q0.i(eVar.V(), "SwanSubscribeMsgDialog", false)));
                swanAppRoundedImageView.setBorderColor(resources.getColor(R.color.obfuscated_res_0x7f060a20));
            }
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902d3);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902d4);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091df0)).setText(eVar.Y());
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092026)).setText(str);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091f0d);
            ArrayList arrayList = new ArrayList(list);
            if (list.size() > 0) {
                for (c.a.n0.a.i0.d dVar : list) {
                    linearLayout.addView(b(activity, dVar, arrayList, new a(arrayList, textView2, resources)));
                }
            }
            h.a aVar = new h.a(activity);
            aVar.f(true);
            aVar.W(inflate);
            aVar.n(new c.a.n0.a.q2.h.a());
            aVar.p(R.drawable.obfuscated_res_0x7f080125);
            aVar.k(false);
            aVar.j();
            aVar.t(false);
            h c2 = aVar.c();
            b bVar = new b(fVar, arrayList, c2);
            textView2.setOnClickListener(new View$OnClickListenerC0316c(c2, bVar));
            textView.setOnClickListener(new d(c2, bVar));
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(n0.s(activity), -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f100393);
            }
            return c2;
        }
        return (h) invokeCommon.objValue;
    }

    public static View b(@NonNull Activity activity, @NonNull c.a.n0.a.i0.d dVar, List<c.a.n0.a.i0.d> list, View.OnClickListener onClickListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, dVar, list, onClickListener)) == null) {
            Resources resources = activity.getResources();
            int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070608);
            TextView textView = new TextView(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 16, 0, 16);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(c.a.n0.r.a.b.a.b(activity, R.color.obfuscated_res_0x7f060a39));
            textView.setText(dVar.f4845b);
            Drawable drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c2);
            Drawable drawable2 = resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c1);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(dimension);
            textView.setTextSize(18.0f);
            textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, dVar, onClickListener));
            return textView;
        }
        return (View) invokeLLLL.objValue;
    }
}
