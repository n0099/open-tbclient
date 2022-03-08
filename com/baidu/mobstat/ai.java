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
                public final /* synthetic */ Activity f35012b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ TextView f35013c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {viewGroup, activity, agVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = viewGroup;
                    this.f35012b = activity;
                    this.f35013c = agVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int width = this.a.getWidth();
                        int height = this.a.getHeight();
                        int c2 = ah.c(this.f35012b, 55.0f);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c2, c2);
                        layoutParams.leftMargin = (width - c2) / 6;
                        layoutParams.topMargin = ((height - c2) * 5) / 6;
                        this.f35013c.setLayoutParams(layoutParams);
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                        dialogInterface.dismiss();
                        am.a().c();
                        bc.c().a("autotrace: connect close, app close");
                        am.a().a(4);
                        am.a().d();
                    }
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.mobstat.ai.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
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
                public int f35014b;

                /* renamed from: c  reason: collision with root package name */
                public int f35015c;

                /* renamed from: d  reason: collision with root package name */
                public int f35016d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ View f35017e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ Activity f35018f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6, activity};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35017e = r6;
                    this.f35018f = activity;
                    this.a = 0;
                    this.f35014b = 0;
                    this.f35015c = 0;
                    this.f35016d = 0;
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
                            this.f35014b = rawY;
                            this.f35015c = rawX - view.getLeft();
                            this.f35016d = rawY - view.getTop();
                        } else if (action != 1) {
                            if (action == 2) {
                                int i2 = rawX - this.f35015c;
                                int i3 = rawY - this.f35016d;
                                Rect rect = new Rect();
                                this.f35017e.getLocalVisibleRect(rect);
                                if (rect.contains(new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3))) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                                    marginLayoutParams.leftMargin = i2;
                                    marginLayoutParams.topMargin = i3;
                                    view.setLayoutParams(marginLayoutParams);
                                }
                            }
                        } else if (ai.b(this.a, (int) motionEvent.getRawX(), this.f35014b, (int) motionEvent.getRawY())) {
                            ai.b((Context) this.f35018f);
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
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null && (tag = childAt.getTag(-5000)) != null && (tag instanceof String) && ((String) tag).equals("baidu_mtj_edit_txtview")) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }
}
