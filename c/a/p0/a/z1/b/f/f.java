package c.a.p0.a.z1.b.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.g;
import c.a.p0.a.z1.b.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.res.widget.toast.ToastRightAreaStyle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<View> f10072a;

    /* renamed from: b  reason: collision with root package name */
    public static Runnable f10073b;

    /* renamed from: c  reason: collision with root package name */
    public static e.b f10074c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static View f10075d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f10076e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f10077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f10078f;

        /* renamed from: c.a.p0.a.z1.b.f.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class animation.Animation$AnimationListenerC0487a implements Animation.AnimationListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f10079a;

            /* renamed from: c.a.p0.a.z1.b.f.f$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0488a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ animation.Animation$AnimationListenerC0487a f10080e;

                public RunnableC0488a(animation.Animation$AnimationListenerC0487a animation_animation_animationlistenerc0487a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {animation_animation_animationlistenerc0487a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f10080e = animation_animation_animationlistenerc0487a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10080e.f10079a.f10077e.getParent() == null) {
                        return;
                    }
                    ((ViewGroup) this.f10080e.f10079a.f10077e.getParent()).removeView(this.f10080e.f10079a.f10077e);
                }
            }

            /* renamed from: c.a.p0.a.z1.b.f.f$a$a$b */
            /* loaded from: classes.dex */
            public class b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ animation.Animation$AnimationListenerC0487a f10081e;

                public b(animation.Animation$AnimationListenerC0487a animation_animation_animationlistenerc0487a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {animation_animation_animationlistenerc0487a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f10081e = animation_animation_animationlistenerc0487a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    View view;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view = this.f10081e.f10079a.f10078f) == null || view.getParent() == null || !(this.f10081e.f10079a.f10078f.getParent() instanceof ViewGroup)) {
                        return;
                    }
                    ((ViewGroup) this.f10081e.f10079a.f10078f.getParent()).removeView(this.f10081e.f10079a.f10078f);
                }
            }

            public animation.Animation$AnimationListenerC0487a(a aVar) {
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
                this.f10079a = aVar;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    if (this.f10079a.f10077e.getParent() instanceof ViewGroup) {
                        this.f10079a.f10077e.post(new RunnableC0488a(this));
                    }
                    View view = this.f10079a.f10078f;
                    if (view != null) {
                        view.post(new b(this));
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                }
            }
        }

        public a(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10077e = view;
            this.f10078f = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WeakReference weakReference = new WeakReference(this.f10077e.getContext());
                if (weakReference.get() == null) {
                    return;
                }
                Animation loadAnimation = AnimationUtils.loadAnimation((Context) weakReference.get(), c.a.p0.a.a.aiapps_toast_exit);
                loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC0487a(this));
                this.f10077e.startAnimation(loadAnimation);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f10082e;

        public b(e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10082e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.c cVar = this.f10082e;
                if (cVar != null) {
                    cVar.a();
                }
                f.h();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f10083e;

        public c(e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10083e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.c cVar = this.f10083e;
                if (cVar != null) {
                    cVar.a();
                }
                f.h();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f10084e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f10085f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f10086g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f10087h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Animation f10088i;

        public d(View view, Context context, View view2, FrameLayout.LayoutParams layoutParams, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, context, view2, layoutParams, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10084e = view;
            this.f10085f = context;
            this.f10086g = view2;
            this.f10087h = layoutParams;
            this.f10088i = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f.f10076e && this.f10084e != null) {
                    if (f.f10075d != null && (f.f10075d.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) f.f10075d.getParent()).removeView(f.f10075d);
                    }
                    Context context = this.f10085f;
                    if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                        return;
                    }
                    FrameLayout frameLayout = new FrameLayout(this.f10085f);
                    frameLayout.setClickable(true);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.topMargin = c.a.p0.a.z1.b.f.e.c(this.f10085f);
                    View view2 = this.f10084e;
                    if (view2 instanceof ViewGroup) {
                        ((ViewGroup) view2).addView(frameLayout, layoutParams);
                        View unused = f.f10075d = frameLayout;
                    }
                }
                if (f.f10072a != null && (view = (View) f.f10072a.get()) != null && (view.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                Context context2 = this.f10085f;
                if ((context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                    return;
                }
                ((ViewGroup) this.f10084e).addView(this.f10086g, this.f10087h);
                this.f10086g.startAnimation(this.f10088i);
                WeakReference unused2 = f.f10072a = new WeakReference(this.f10086g);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-65876628, "Lc/a/p0/a/z1/b/f/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-65876628, "Lc/a/p0/a/z1/b/f/f;");
        }
    }

    public static void f(View view, View view2, int i2, FrameLayout.LayoutParams layoutParams, @AnimRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{view, view2, Integer.valueOf(i2), layoutParams, Integer.valueOf(i3)}) == null) || view == null || view2 == null) {
            return;
        }
        g(view, view2, i2, layoutParams, AnimationUtils.loadAnimation(view.getContext(), i3));
    }

    public static void g(View view, View view2, int i2, FrameLayout.LayoutParams layoutParams, Animation animation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{view, view2, Integer.valueOf(i2), layoutParams, animation}) == null) || view == null || view2 == null) {
            return;
        }
        Context context = view.getContext();
        if (view2.getParent() instanceof ViewGroup) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        view2.setClickable(true);
        if (view instanceof ViewGroup) {
            view.post(new d(view, context, view2, layoutParams, animation));
            if (f10073b == null) {
                f10073b = new e();
            }
            c.a.p0.a.a2.d.i().postDelayed(f10073b, i2 * 1000);
        }
    }

    public static synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            synchronized (f.class) {
                if (f10072a != null) {
                    View view = f10072a.get();
                    if (view != null) {
                        view.post(new a(view, f10075d));
                        if (f10073b != null) {
                            view.removeCallbacks(f10073b);
                        }
                    }
                    if (f10073b != null) {
                        c.a.p0.a.a2.d.i().removeCallbacks(f10073b);
                    }
                    f10073b = null;
                    f10072a = null;
                    f10075d = null;
                    if (f10074c != null) {
                        f10074c.onDismiss();
                        f10074c = null;
                    }
                }
            }
        }
    }

    public static View i(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, activity)) == null) {
            if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
                return null;
            }
            return activity.getWindow().getDecorView().findViewById(16908290);
        }
        return (View) invokeL.objValue;
    }

    public static View j(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) {
            if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
                return null;
            }
            return activity.getWindow().getDecorView();
        }
        return (View) invokeL.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            WeakReference<View> weakReference = f10072a;
            return (weakReference == null || (view = weakReference.get()) == null || view.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static void l(e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, bVar) == null) {
            f10074c = bVar;
        }
    }

    public static void m(Activity activity, CharSequence charSequence, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{activity, charSequence, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Resources resources = c.a.p0.a.c1.a.b().getResources();
            f10076e = z;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_toast_template_square_d20, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(c.a.p0.a.e.aiapps_toast_bg_d20));
            linearLayout.findViewById(c.a.p0.a.f.highlight_toast_imageView_d20).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(c.a.p0.a.f.highlight_toast_loading_d20);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(c.a.p0.a.e.aiapps_toast_loading_d20));
            TextView textView = (TextView) linearLayout.findViewById(c.a.p0.a.f.highlight_toast_text_d20);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setTextColor(resources.getColor(c.a.p0.a.c.GC6));
                textView.setText(charSequence);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            f(i(activity), linearLayout, i2, layoutParams, c.a.p0.a.a.aiapps_highlight_toast_show_d20);
        }
    }

    public static void n(@NonNull Activity activity, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{activity, charSequence, drawable, view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Resources resources = activity.getResources();
            f10076e = z;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_toast_template_square_d20, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(c.a.p0.a.e.aiapps_toast_bg_d20));
            TextView textView = (TextView) linearLayout.findViewById(c.a.p0.a.f.highlight_toast_text_d20);
            if (textView != null && !TextUtils.isEmpty(charSequence)) {
                textView.setTextColor(resources.getColor(c.a.p0.a.c.GC6));
                textView.setText(charSequence);
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(c.a.p0.a.f.highlight_toast_imageView_d20);
            if (imageView != null) {
                if (view != null) {
                    new c.a.p0.a.z1.b.f.g.b(activity).a(imageView, view);
                } else {
                    if (drawable == null) {
                        drawable = resources.getDrawable(c.a.p0.a.e.aiapps_highlight_toast_image_d20);
                    }
                    c.a.p0.a.z1.b.f.d.j(drawable);
                    imageView.setImageDrawable(drawable);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelSize(c.a.p0.a.d.aiapps_highlight_toast_view_width_new_d20), resources.getDimensionPixelSize(c.a.p0.a.d.aiapps_highlight_toast_view_height_new_d20));
            layoutParams.gravity = 17;
            f(i(activity), linearLayout, i2, layoutParams, c.a.p0.a.a.aiapps_highlight_toast_show_d20);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void o(@NonNull Activity activity, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, int i2, @NonNull ToastLocation toastLocation, @Nullable e.c cVar, boolean z) {
        ToastLocation toastLocation2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{activity, uri, drawable, view, charSequence, charSequence2, Integer.valueOf(i2), toastLocation, cVar, Boolean.valueOf(z)}) == null) || activity == null) {
            return;
        }
        Resources resources = c.a.p0.a.c1.a.b().getResources();
        View i3 = i(activity);
        if (i3 == null) {
            return;
        }
        f10076e = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_toast_template_a_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(c.a.p0.a.e.aiapps_toast_bg_d20));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(c.a.p0.a.f.left_icon_fresco);
        TextView textView = (TextView) linearLayout.findViewById(c.a.p0.a.f.left_toast_info_view);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(c.a.p0.a.f.right_toast_click_area);
        TextView textView2 = (TextView) linearLayout.findViewById(c.a.p0.a.f.right_toast_jump_text);
        View findViewById = linearLayout.findViewById(c.a.p0.a.f.right_toast_vertical_line);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(c.a.p0.a.z1.b.f.b.f10044a);
            if (uri == null && drawable == null && view == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(c.a.p0.a.z1.b.f.g.a.a(activity, 200.0f));
            } else {
                boolean z2 = true;
                if (view != null) {
                    simpleDraweeView.setVisibility(0);
                    new c.a.p0.a.z1.b.f.g.b(activity).a(simpleDraweeView, view);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(c.a.p0.a.z1.b.f.g.a.a(activity, !z2 ? 14.0f : 5.0f), c.a.p0.a.z1.b.f.g.a.a(activity, 9.0f), c.a.p0.a.z1.b.f.g.a.a(activity, 14.0f), c.a.p0.a.z1.b.f.g.a.a(activity, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        ((ImageView) linearLayout.findViewById(c.a.p0.a.f.right_jump_img)).setImageDrawable(resources.getDrawable(c.a.p0.a.e.aiapps_toast_right_jump_d20));
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        textView2.setText(charSequence2);
                        textView2.setTextColor(c.a.p0.a.z1.b.f.b.f10044a);
                        findViewById.setBackground(resources.getDrawable(c.a.p0.a.c.GC36));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new b(cVar));
                            c.a.p0.a.z1.b.f.d.i(linearLayout2);
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                        if (ToastLocation.BOTTOM != toastLocation2) {
                            layoutParams2.gravity = 81;
                            layoutParams2.bottomMargin = (int) resources.getDimension(c.a.p0.a.d.aiapps_clickable_toast_view_margin_bottom);
                        } else {
                            layoutParams2.gravity = 17;
                        }
                        f(i3, linearLayout, i2, layoutParams2, c.a.p0.a.a.aiapps_toast_enter);
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    if (drawable != null) {
                        c.a.p0.a.z1.b.f.d.j(drawable);
                        simpleDraweeView.setImageDrawable(drawable);
                    } else if (uri != null) {
                        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
                    }
                }
                z2 = false;
                textView.setSingleLine();
                textView.setText(charSequence);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(c.a.p0.a.z1.b.f.g.a.a(activity, !z2 ? 14.0f : 5.0f), c.a.p0.a.z1.b.f.g.a.a(activity, 9.0f), c.a.p0.a.z1.b.f.g.a.a(activity, 14.0f), c.a.p0.a.z1.b.f.g.a.a(activity, 10.0f));
                textView.setLayoutParams(layoutParams3);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            FrameLayout.LayoutParams layoutParams22 = new FrameLayout.LayoutParams(-2, -2);
            if (ToastLocation.BOTTOM != toastLocation2) {
            }
            f(i3, linearLayout, i2, layoutParams22, c.a.p0.a.a.aiapps_toast_enter);
            return;
        }
        c.a.p0.a.z1.b.f.d.h("has no main text");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: android.widget.LinearLayout */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void p(@NonNull Activity activity, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3, @Nullable ToastRightAreaStyle toastRightAreaStyle, int i2, boolean z, e.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{activity, uri, drawable, view, charSequence, charSequence2, charSequence3, toastRightAreaStyle, Integer.valueOf(i2), Boolean.valueOf(z), cVar}) == null) || activity == null) {
            return;
        }
        Resources resources = c.a.p0.a.c1.a.b().getResources();
        if ((z ? j(activity) : i(activity)) == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_toast_template_b_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(c.a.p0.a.e.aiapps_toast_bg_d20));
        boolean z2 = true;
        linearLayout.setClickable(true);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(c.a.p0.a.f.text_area);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(c.a.p0.a.f.left_icon);
        simpleDraweeView.setVisibility(0);
        if (view != null) {
            new c.a.p0.a.z1.b.f.g.b(activity).a(simpleDraweeView, view);
        } else if (drawable != null) {
            c.a.p0.a.z1.b.f.d.j(drawable);
            simpleDraweeView.setImageDrawable(drawable);
        } else if (uri != null) {
            simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
        } else {
            simpleDraweeView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(c.a.p0.a.z1.b.f.g.a.a(activity, 15.0f), 0, 0, 0);
            linearLayout2.setLayoutParams(layoutParams);
            TextView textView = (TextView) linearLayout.findViewById(c.a.p0.a.f.title);
            TextView textView2 = (TextView) linearLayout.findViewById(c.a.p0.a.f.sub_title);
            TextView textView3 = (TextView) linearLayout.findViewById(c.a.p0.a.f.one_line_text);
            if (TextUtils.isEmpty(charSequence)) {
                if (!TextUtils.isEmpty(charSequence2)) {
                    if (z2) {
                        textView.setMaxWidth(c.a.p0.a.z1.b.f.g.a.a(activity, 175.0f));
                        textView2.setMaxWidth(c.a.p0.a.z1.b.f.g.a.a(activity, 175.0f));
                    }
                    textView.setText(charSequence);
                    textView2.setText(charSequence2);
                    textView.setVisibility(0);
                    textView2.setVisibility(0);
                    textView.setTextColor(c.a.p0.a.z1.b.f.b.f10044a);
                    textView2.setTextColor(resources.getColor(c.a.p0.a.c.GC4));
                    textView3.setVisibility(8);
                } else {
                    if (z2) {
                        textView3.setMaxWidth(c.a.p0.a.z1.b.f.g.a.a(activity, 175.0f));
                    }
                    textView3.setText(charSequence);
                    textView.setVisibility(8);
                    textView2.setVisibility(8);
                    textView3.setVisibility(0);
                    textView3.setTextColor(c.a.p0.a.z1.b.f.b.f10044a);
                }
                FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(c.a.p0.a.f.btn_area);
                LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(c.a.p0.a.f.jump_area);
                TextView textView4 = (TextView) linearLayout.findViewById(c.a.p0.a.f.btn_text);
                textView4.setBackground(resources.getDrawable(c.a.p0.a.e.aiapps_template_2_btn_bg_d20));
                TextView textView5 = (TextView) linearLayout.findViewById(c.a.p0.a.f.jump_text);
                ImageView imageView = (ImageView) linearLayout.findViewById(c.a.p0.a.f.jump_view);
                View findViewById = linearLayout.findViewById(c.a.p0.a.f.right_toast_vertical_line);
                if (!TextUtils.isEmpty(charSequence3)) {
                    if (toastRightAreaStyle == ToastRightAreaStyle.BUTTON) {
                        frameLayout.setVisibility(0);
                        linearLayout3.setVisibility(8);
                        textView4.setText(charSequence3);
                        textView4.setTextColor(resources.getColor(c.a.p0.a.c.GC6));
                    } else {
                        linearLayout3.setVisibility(0);
                        frameLayout.setVisibility(8);
                        textView5.setText(charSequence3);
                        textView5.setTextColor(c.a.p0.a.z1.b.f.b.f10044a);
                        imageView.setImageDrawable(resources.getDrawable(c.a.p0.a.e.aiapps_toast_right_jump_d20));
                        findViewById.setBackground(resources.getDrawable(c.a.p0.a.c.GC36));
                        frameLayout = linearLayout3;
                    }
                    if (frameLayout != null) {
                        frameLayout.setOnClickListener(new c(cVar));
                        c.a.p0.a.z1.b.f.d.i(frameLayout);
                    }
                } else {
                    frameLayout.setVisibility(8);
                    linearLayout3.setVisibility(8);
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 81;
                layoutParams2.bottomMargin = (int) resources.getDimension(c.a.p0.a.d.aiapps_clickable_toast_view_margin_bottom);
                f(i(activity), linearLayout, i2, layoutParams2, c.a.p0.a.a.aiapps_toast_enter);
                return;
            }
            c.a.p0.a.z1.b.f.d.h("has no main text");
            return;
        }
        z2 = false;
        TextView textView6 = (TextView) linearLayout.findViewById(c.a.p0.a.f.title);
        TextView textView22 = (TextView) linearLayout.findViewById(c.a.p0.a.f.sub_title);
        TextView textView32 = (TextView) linearLayout.findViewById(c.a.p0.a.f.one_line_text);
        if (TextUtils.isEmpty(charSequence)) {
        }
    }
}
