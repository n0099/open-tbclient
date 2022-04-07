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
/* loaded from: classes2.dex */
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
                public final /* synthetic */ Activity b;
                public final /* synthetic */ TextView c;

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
                    this.b = activity;
                    this.c = agVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int width = this.a.getWidth();
                        int height = this.a.getHeight();
                        int c = ah.c(this.b, 55.0f);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c, c);
                        layoutParams.leftMargin = (width - c) / 6;
                        layoutParams.topMargin = ((height - c) * 5) / 6;
                        this.c.setLayoutParams(layoutParams);
                    }
                }
            });
            viewGroup.addView(agVar);
            a(activity, agVar);
        }
    }

    public static boolean a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view2)) == null) {
            Object tag = view2.getTag(-5000);
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

    public static boolean b(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            return Math.abs(f - f2) <= 5.0f && Math.abs(f3 - f4) <= 5.0f;
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
                public int b;
                public int c;
                public int d;
                public final /* synthetic */ View e;
                public final /* synthetic */ Activity f;

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
                    this.e = r6;
                    this.f = activity;
                    this.a = 0;
                    this.b = 0;
                    this.c = 0;
                    this.d = 0;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            this.a = rawX;
                            this.b = rawY;
                            this.c = rawX - view2.getLeft();
                            this.d = rawY - view2.getTop();
                        } else if (action != 1) {
                            if (action == 2) {
                                int i = rawX - this.c;
                                int i2 = rawY - this.d;
                                Rect rect = new Rect();
                                this.e.getLocalVisibleRect(rect);
                                if (rect.contains(new Rect(i, i2, view2.getWidth() + i, view2.getHeight() + i2))) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                                    marginLayoutParams.leftMargin = i;
                                    marginLayoutParams.topMargin = i2;
                                    view2.setLayoutParams(marginLayoutParams);
                                }
                            }
                        } else if (ai.b(this.a, (int) motionEvent.getRawX(), this.b, (int) motionEvent.getRawY())) {
                            ai.b((Context) this.f);
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
