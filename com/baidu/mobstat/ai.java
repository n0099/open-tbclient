package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ai {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"NewApi"})
    public static void b(Activity activity) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, activity) == null) {
            try {
                viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
            } catch (Exception unused) {
                viewGroup = null;
            }
            if (viewGroup == null || viewGroup == null || a(viewGroup) != null) {
                return;
            }
            ag agVar = new ag(activity);
            agVar.setBackgroundColor(-16745729);
            agVar.setGravity(17);
            agVar.setText("连接中");
            agVar.setTag(-5000, "baidu_mtj_edit_txtview");
            viewGroup.post(new Runnable(viewGroup, activity, agVar) { // from class: com.baidu.mobstat.ai.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Activity f27167b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ TextView f27168c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {viewGroup, activity, agVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = viewGroup;
                    this.f27167b = activity;
                    this.f27168c = agVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int width = this.a.getWidth();
                        int height = this.a.getHeight();
                        int c2 = ah.c(this.f27167b, 55.0f);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c2, c2);
                        layoutParams.leftMargin = (width - c2) / 6;
                        layoutParams.topMargin = ((height - c2) * 5) / 6;
                        this.f27168c.setLayoutParams(layoutParams);
                    }
                }
            });
            viewGroup.addView(agVar);
            a(activity, agVar);
        }
    }

    public static boolean a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view)) == null) {
            Object tag = view.getTag(-5000);
            return tag != null && (tag instanceof String) && ((String) tag).equals("baidu_mtj_edit_txtview");
        }
        return invokeL.booleanValue;
    }

    public static void a(Activity activity, boolean z) {
        ViewGroup viewGroup;
        View a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, activity, z) == null) {
            try {
                viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
            } catch (Exception unused) {
                viewGroup = null;
            }
            if (viewGroup == null || (a = a(viewGroup)) == null) {
                return;
            }
            a.setVisibility(z ? 0 : 4);
        }
    }

    public static void a(Activity activity) {
        ViewGroup viewGroup;
        View a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            try {
                viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
            } catch (Exception unused) {
                viewGroup = null;
            }
            if (viewGroup == null || (a = a(viewGroup)) == null) {
                return;
            }
            viewGroup.removeView(a);
        }
    }

    public static boolean b(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            return Math.abs(f2 - f3) <= 5.0f && Math.abs(f4 - f5) <= 5.0f;
        }
        return invokeCommon.booleanValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("是否确认退出连接?");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.mobstat.ai.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) {
                        dialogInterface.dismiss();
                        am.a().c();
                        bc.c().a("autotrace: connect close, app close");
                        am.a().a(4);
                        am.a().d();
                    }
                }
            });
            builder.setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new DialogInterface.OnClickListener() { // from class: com.baidu.mobstat.ai.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) {
                        dialogInterface.dismiss();
                    }
                }
            });
            builder.create().show();
        }
    }

    public static void a(Activity activity, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, activity, textView) == null) {
            textView.setOnTouchListener(new View.OnTouchListener((View) textView.getParent(), activity) { // from class: com.baidu.mobstat.ai.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int a;

                /* renamed from: b  reason: collision with root package name */
                public int f27169b;

                /* renamed from: c  reason: collision with root package name */
                public int f27170c;

                /* renamed from: d  reason: collision with root package name */
                public int f27171d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ View f27172e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ Activity f27173f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6, activity};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27172e = r6;
                    this.f27173f = activity;
                    this.a = 0;
                    this.f27169b = 0;
                    this.f27170c = 0;
                    this.f27171d = 0;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            this.a = rawX;
                            this.f27169b = rawY;
                            this.f27170c = rawX - view.getLeft();
                            this.f27171d = rawY - view.getTop();
                        } else if (action != 1) {
                            if (action == 2) {
                                int i = rawX - this.f27170c;
                                int i2 = rawY - this.f27171d;
                                Rect rect = new Rect();
                                this.f27172e.getLocalVisibleRect(rect);
                                if (rect.contains(new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2))) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                                    marginLayoutParams.leftMargin = i;
                                    marginLayoutParams.topMargin = i2;
                                    view.setLayoutParams(marginLayoutParams);
                                }
                            }
                        } else if (ai.b(this.a, (int) motionEvent.getRawX(), this.f27169b, (int) motionEvent.getRawY())) {
                            ai.b((Context) this.f27173f);
                        }
                        return true;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    public static View a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return null;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null && (tag = childAt.getTag(-5000)) != null && (tag instanceof String) && ((String) tag).equals("baidu_mtj_edit_txtview")) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }
}
