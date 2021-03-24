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
import com.kwai.video.player.NativeErrorCode;
/* loaded from: classes2.dex */
public class ai {
    @SuppressLint({"NewApi"})
    public static void b(final Activity activity) {
        final ViewGroup viewGroup;
        try {
            viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
        } catch (Exception unused) {
            viewGroup = null;
        }
        if (viewGroup == null || viewGroup == null || a(viewGroup) != null) {
            return;
        }
        final ag agVar = new ag(activity);
        agVar.setBackgroundColor(-16745729);
        agVar.setGravity(17);
        agVar.setText("连接中");
        agVar.setTag(NativeErrorCode.EKS_FFMPEG_ERROR_BASE, "baidu_mtj_edit_txtview");
        viewGroup.post(new Runnable() { // from class: com.baidu.mobstat.ai.1
            @Override // java.lang.Runnable
            public void run() {
                int width = viewGroup.getWidth();
                int height = viewGroup.getHeight();
                int c2 = ah.c(activity, 55.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c2, c2);
                layoutParams.leftMargin = (width - c2) / 6;
                layoutParams.topMargin = ((height - c2) * 5) / 6;
                agVar.setLayoutParams(layoutParams);
            }
        });
        viewGroup.addView(agVar);
        a(activity, agVar);
    }

    public static boolean a(View view) {
        Object tag = view.getTag(NativeErrorCode.EKS_FFMPEG_ERROR_BASE);
        return tag != null && (tag instanceof String) && ((String) tag).equals("baidu_mtj_edit_txtview");
    }

    public static void a(Activity activity, boolean z) {
        ViewGroup viewGroup;
        View a2;
        try {
            viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
        } catch (Exception unused) {
            viewGroup = null;
        }
        if (viewGroup == null || (a2 = a(viewGroup)) == null) {
            return;
        }
        a2.setVisibility(z ? 0 : 4);
    }

    public static void a(Activity activity) {
        ViewGroup viewGroup;
        View a2;
        try {
            viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
        } catch (Exception unused) {
            viewGroup = null;
        }
        if (viewGroup == null || (a2 = a(viewGroup)) == null) {
            return;
        }
        viewGroup.removeView(a2);
    }

    public static boolean b(float f2, float f3, float f4, float f5) {
        return Math.abs(f2 - f3) <= 5.0f && Math.abs(f4 - f5) <= 5.0f;
    }

    public static void b(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("是否确认退出连接?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.mobstat.ai.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                am.a().c();
                bc.c().a("autotrace: connect close, app close");
                am.a().a(4);
                am.a().d();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.mobstat.ai.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public static void a(final Activity activity, TextView textView) {
        final View view = (View) textView.getParent();
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.mobstat.ai.2

            /* renamed from: a  reason: collision with root package name */
            public int f8894a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f8895b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f8896c = 0;

            /* renamed from: d  reason: collision with root package name */
            public int f8897d = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f8894a = rawX;
                    this.f8895b = rawY;
                    this.f8896c = rawX - view2.getLeft();
                    this.f8897d = rawY - view2.getTop();
                } else if (action != 1) {
                    if (action == 2) {
                        int i = rawX - this.f8896c;
                        int i2 = rawY - this.f8897d;
                        Rect rect = new Rect();
                        view.getLocalVisibleRect(rect);
                        if (rect.contains(new Rect(i, i2, view2.getWidth() + i, view2.getHeight() + i2))) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                            marginLayoutParams.leftMargin = i;
                            marginLayoutParams.topMargin = i2;
                            view2.setLayoutParams(marginLayoutParams);
                        }
                    }
                } else if (ai.b(this.f8894a, (int) motionEvent.getRawX(), this.f8895b, (int) motionEvent.getRawY())) {
                    ai.b((Context) activity);
                }
                return true;
            }
        });
    }

    public static View a(ViewGroup viewGroup) {
        Object tag;
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null && (tag = childAt.getTag(NativeErrorCode.EKS_FFMPEG_ERROR_BASE)) != null && (tag instanceof String) && ((String) tag).equals("baidu_mtj_edit_txtview")) {
                return childAt;
            }
        }
        return null;
    }
}
