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
/* loaded from: classes2.dex */
public class ah {
    public static View a(ViewGroup viewGroup) {
        Object tag;
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

    public static void b(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("是否确认退出连接?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.mobstat.ah.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                al.a().c();
                bb.c().a("autotrace: connect close, app close");
                al.a().a(4);
                al.a().d();
            }
        });
        builder.setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new DialogInterface.OnClickListener() { // from class: com.baidu.mobstat.ah.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public static void a(Activity activity) {
        ViewGroup viewGroup;
        View a;
        try {
            viewGroup = (ViewGroup) bi.a(activity).findViewById(16908290);
        } catch (Exception unused) {
            viewGroup = null;
        }
        if (viewGroup != null && (a = a(viewGroup)) != null) {
            viewGroup.removeView(a);
        }
    }

    public static void a(final Activity activity, TextView textView) {
        final View view2 = (View) textView.getParent();
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.mobstat.ah.2
            public int a = 0;
            public int b = 0;
            public int c = 0;
            public int d = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            int i = rawX - this.c;
                            int i2 = rawY - this.d;
                            Rect rect = new Rect();
                            view2.getLocalVisibleRect(rect);
                            if (rect.contains(new Rect(i, i2, view3.getWidth() + i, view3.getHeight() + i2))) {
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                                marginLayoutParams.leftMargin = i;
                                marginLayoutParams.topMargin = i2;
                                view3.setLayoutParams(marginLayoutParams);
                            }
                        }
                    } else if (ah.b(this.a, (int) motionEvent.getRawX(), this.b, (int) motionEvent.getRawY())) {
                        ah.b((Context) activity);
                    }
                } else {
                    this.a = rawX;
                    this.b = rawY;
                    this.c = rawX - view3.getLeft();
                    this.d = rawY - view3.getTop();
                }
                return true;
            }
        });
    }

    public static void a(Activity activity, boolean z) {
        ViewGroup viewGroup;
        View a;
        int i;
        try {
            viewGroup = (ViewGroup) bi.a(activity).findViewById(16908290);
        } catch (Exception unused) {
            viewGroup = null;
        }
        if (viewGroup != null && (a = a(viewGroup)) != null) {
            if (z) {
                i = 0;
            } else {
                i = 4;
            }
            a.setVisibility(i);
        }
    }

    public static boolean b(float f, float f2, float f3, float f4) {
        float abs = Math.abs(f - f2);
        float abs2 = Math.abs(f3 - f4);
        if (abs <= 5.0f && abs2 <= 5.0f) {
            return true;
        }
        return false;
    }

    public static boolean a(View view2) {
        Object tag = view2.getTag(-5000);
        if (tag != null && (tag instanceof String) && ((String) tag).equals("baidu_mtj_edit_txtview")) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static void b(final Activity activity) {
        final ViewGroup viewGroup;
        try {
            viewGroup = (ViewGroup) bi.a(activity).findViewById(16908290);
        } catch (Exception unused) {
            viewGroup = null;
        }
        if (viewGroup == null || viewGroup == null || a(viewGroup) != null) {
            return;
        }
        final ae aeVar = new ae(activity);
        aeVar.setBackgroundColor(-16745729);
        aeVar.setGravity(17);
        aeVar.setText("连接中");
        aeVar.setTag(-5000, "baidu_mtj_edit_txtview");
        viewGroup.post(new Runnable() { // from class: com.baidu.mobstat.ah.1
            @Override // java.lang.Runnable
            public void run() {
                int width = viewGroup.getWidth();
                int height = viewGroup.getHeight();
                int c = ag.c(activity, 55.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c, c);
                layoutParams.leftMargin = (width - c) / 6;
                layoutParams.topMargin = ((height - c) * 5) / 6;
                aeVar.setLayoutParams(layoutParams);
            }
        });
        viewGroup.addView(aeVar);
        a(activity, aeVar);
    }
}
