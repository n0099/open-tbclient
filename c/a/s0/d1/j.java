package c.a.s0.d1;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f12531f;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<WeakReference<Activity>> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<WeakReference<Activity>> f12532b;

    /* renamed from: c  reason: collision with root package name */
    public int f12533c;

    /* renamed from: d  reason: collision with root package name */
    public final CustomMessageListener f12534d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.s0.n.g f12535e;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int skinType;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && this.a.f12533c != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
                this.a.f12533c = skinType;
                if (j.f12531f) {
                    this.a.s();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.s0.n.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f12536e;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12536e = jVar;
        }

        @Override // c.a.s0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
                this.f12536e.f12532b.add(new WeakReference(activity));
            }
        }

        @Override // c.a.s0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                Iterator it = this.f12536e.f12532b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != null && weakReference.get() == activity) {
                        this.f12536e.f12532b.remove(weakReference);
                        return;
                    }
                }
            }
        }

        @Override // c.a.s0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && j.f12531f) {
                j jVar = this.f12536e;
                if (jVar.j(jVar.l(activity))) {
                    this.f12536e.a.add(new WeakReference(activity));
                }
            }
        }

        @Override // c.a.s0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && j.f12531f) {
                j jVar = this.f12536e;
                if (jVar.u(jVar.l(activity))) {
                    Iterator it = this.f12536e.a.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (activity != null && activity == weakReference.get()) {
                            this.f12536e.a.remove(weakReference);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f12537e;

        public c(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12537e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12537e.r(view.getContext());
                this.f12537e.v(false);
                this.f12537e.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final j a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1396654777, "Lc/a/s0/d1/j$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1396654777, "Lc/a/s0/d1/j$d;");
                    return;
                }
            }
            a = new j(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-770167545, "Lc/a/s0/d1/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-770167545, "Lc/a/s0/d1/j;");
        }
    }

    public /* synthetic */ j(a aVar) {
        this();
    }

    public static final j m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? d.a : (j) invokeV.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    public final boolean j(FrameLayout frameLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, frameLayout)) == null) {
            if (frameLayout == null) {
                return false;
            }
            try {
                Object tag = frameLayout.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                ViewGroup viewGroup = 0;
                ViewGroup viewGroup2 = tag instanceof ViewGroup ? (ViewGroup) tag : null;
                if (viewGroup2 == null || viewGroup2.getParent() == null) {
                    viewGroup = viewGroup2;
                } else if (viewGroup2.getParent() == frameLayout) {
                    return false;
                } else {
                    frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, null);
                }
                if (viewGroup == null) {
                    viewGroup = o(frameLayout.getContext());
                }
                if (viewGroup == null) {
                    return false;
                }
                frameLayout.addView(viewGroup);
                frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, viewGroup);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds339), c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds89));
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds442) + UtilHelper.getNavigationBarHeight(frameLayout.getContext());
                viewGroup.setLayoutParams(layoutParams);
                c cVar = new c(this);
                viewGroup.setClickable(true);
                viewGroup.setOnClickListener(cVar);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BackBaiduBoxViewEvent backBaiduBoxViewEvent = new BackBaiduBoxViewEvent();
            backBaiduBoxViewEvent.isShow = f12531f;
            c.a.s0.k0.h.i(backBaiduBoxViewEvent);
        }
    }

    public final FrameLayout l(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity != null) {
                try {
                    if (!activity.isFinishing() && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView instanceof FrameLayout) {
                            return (FrameLayout) decorView;
                        }
                        return null;
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (FrameLayout) invokeL.objValue;
    }

    public void n(boolean z) {
        FrameLayout l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && f12531f && (l = l(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            try {
                Object tag = l.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                if (tag instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) tag;
                    if (z) {
                        viewGroup.bringToFront();
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds339), c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds89));
                        layoutParams.gravity = 83;
                        layoutParams.bottomMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds207);
                        viewGroup.setLayoutParams(layoutParams);
                    } else {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds339), c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds89));
                        layoutParams2.gravity = 83;
                        layoutParams2.bottomMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds442) + UtilHelper.getNavigationBarHeight(l.getContext());
                        viewGroup.setLayoutParams(layoutParams2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final ViewGroup o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_baiduboxapp_back_view, (ViewGroup) null);
            p(viewGroup, context);
            return viewGroup;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public final void p(ViewGroup viewGroup, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, viewGroup, context) == null) || viewGroup == null || context == null) {
            return;
        }
        SkinManager.setViewTextColor((TextView) viewGroup.findViewById(R.id.tv_back_shoubai_text), R.color.CAM_X0101);
        float f2 = c.a.d.f.p.n.f(context, R.dimen.tbds424);
        TBSelector.makeDrawableSelector().setShape(0).setType(1).trRadius(f2).brRadius(f2).defaultColor(R.color.topic_disagree_des_color).into(viewGroup);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) viewGroup.findViewById(R.id.shoubai_back_icon), R.drawable.ic_icon_pure_list_arrow16_left_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange((ImageView) viewGroup.findViewById(R.id.shoubai_logo_icon), R.drawable.ic_icon_mask_home_backbtn_logo_n_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final boolean q(View view) {
        InterceptResult invokeL;
        IBinder windowToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            if (view == null || (windowToken = view.getWindowToken()) == null) {
                return false;
            }
            try {
                if (windowToken.isBinderAlive()) {
                    return windowToken.pingBinder();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void r(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, context) == null) || context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://donothing"));
            if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                context.startActivity(intent);
            } else {
                w();
            }
        } catch (Exception unused) {
            w();
        }
    }

    public final void s() {
        FrameLayout l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<WeakReference<Activity>> it = this.a.iterator();
            while (it.hasNext()) {
                WeakReference<Activity> next = it.next();
                if (next != null && next.get() != null && !next.get().isFinishing() && (l = l(next.get())) != null) {
                    Object tag = l.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                    if (tag instanceof ViewGroup) {
                        p((ViewGroup) tag, l.getContext());
                    }
                }
            }
        }
    }

    public void t(Application application) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, application) == null) || application == null) {
            return;
        }
        try {
            application.registerActivityLifecycleCallbacks(this.f12535e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean u(FrameLayout frameLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, frameLayout)) == null) {
            if (frameLayout == null) {
                return false;
            }
            try {
                Object tag = frameLayout.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                ViewGroup viewGroup = tag instanceof ViewGroup ? (ViewGroup) tag : null;
                if (viewGroup != null && viewGroup.getParent() != null && viewGroup.getParent() == frameLayout && q(frameLayout) && q(viewGroup)) {
                    frameLayout.removeView(viewGroup);
                    frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, null);
                    return true;
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || f12531f == z) {
            return;
        }
        f12531f = z;
        if (z) {
            Iterator<WeakReference<Activity>> it = this.f12532b.iterator();
            while (it.hasNext()) {
                WeakReference<Activity> next = it.next();
                if (next.get() != null && !next.get().isFinishing()) {
                    Activity activity = next.get();
                    if (j(l(activity))) {
                        this.a.add(new WeakReference<>(activity));
                    }
                }
            }
            return;
        }
        Iterator<WeakReference<Activity>> it2 = this.f12532b.iterator();
        while (it2.hasNext()) {
            WeakReference<Activity> next2 = it2.next();
            if (next2.get() != null && !next2.get().isFinishing()) {
                u(l(next2.get()));
            }
        }
        this.a.clear();
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.d.f.p.n.M(TbadkCoreApplication.getInst(), R.string.not_install_baidu_box_app_tip);
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.f12532b = new ArrayList<>();
        this.f12533c = TbadkCoreApplication.getInst().getSkinType();
        this.f12534d = new a(this, 2001304);
        this.f12535e = new b(this);
        MessageManager.getInstance().registerListener(this.f12534d);
    }
}
