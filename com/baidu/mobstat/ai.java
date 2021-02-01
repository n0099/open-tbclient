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
import com.baidu.live.tbadk.pay.PayHelper;
import com.kwai.video.player.NativeErrorCode;
/* loaded from: classes3.dex */
public class ai {
    public static boolean a(View view) {
        Object tag = view.getTag(NativeErrorCode.EKS_FFMPEG_ERROR_BASE);
        if (tag == null || !(tag instanceof String) || !((String) tag).equals("baidu_mtj_edit_txtview")) {
            return false;
        }
        return true;
    }

    public static void a(Activity activity, boolean z) {
        ViewGroup viewGroup;
        View a2;
        try {
            viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
        } catch (Exception e) {
            viewGroup = null;
        }
        if (viewGroup != null && (a2 = a(viewGroup)) != null) {
            a2.setVisibility(z ? 0 : 4);
        }
    }

    public static void a(Activity activity) {
        ViewGroup viewGroup;
        View a2;
        try {
            viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
        } catch (Exception e) {
            viewGroup = null;
        }
        if (viewGroup != null && (a2 = a(viewGroup)) != null) {
            viewGroup.removeView(a2);
        }
    }

    @SuppressLint({"NewApi"})
    public static void b(final Activity activity) {
        final ViewGroup viewGroup;
        try {
            viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
        } catch (Exception e) {
            viewGroup = null;
        }
        if (viewGroup != null && viewGroup != null && a(viewGroup) == null) {
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
                    int c = ah.c(activity, 55.0f);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c, c);
                    layoutParams.leftMargin = (width - c) / 6;
                    layoutParams.topMargin = ((height - c) * 5) / 6;
                    agVar.setLayoutParams(layoutParams);
                }
            });
            viewGroup.addView(agVar);
            a(activity, agVar);
        }
    }

    private static void a(final Activity activity, TextView textView) {
        final View view = (View) textView.getParent();
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.mobstat.ai.2

            /* renamed from: a  reason: collision with root package name */
            int f3656a = 0;

            /* renamed from: b  reason: collision with root package name */
            int f3657b = 0;
            int c = 0;
            int d = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                switch (motionEvent.getAction()) {
                    case 0:
                        this.f3656a = rawX;
                        this.f3657b = rawY;
                        this.c = rawX - view2.getLeft();
                        this.d = rawY - view2.getTop();
                        return true;
                    case 1:
                        if (ai.b(this.f3656a, (int) motionEvent.getRawX(), this.f3657b, (int) motionEvent.getRawY())) {
                            ai.b((Context) activity);
                            return true;
                        }
                        return true;
                    case 2:
                        int i = rawX - this.c;
                        int i2 = rawY - this.d;
                        Rect rect = new Rect();
                        view.getLocalVisibleRect(rect);
                        if (rect.contains(new Rect(i, i2, view2.getWidth() + i, view2.getHeight() + i2))) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                            marginLayoutParams.leftMargin = i;
                            marginLayoutParams.topMargin = i2;
                            view2.setLayoutParams(marginLayoutParams);
                            return true;
                        }
                        return true;
                    default:
                        return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(float f, float f2, float f3, float f4) {
        return Math.abs(f - f2) <= 5.0f && Math.abs(f3 - f4) <= 5.0f;
    }

    private static View a(ViewGroup viewGroup) {
        View view;
        Object tag;
        if (viewGroup == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                view = null;
                break;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null && (tag = childAt.getTag(NativeErrorCode.EKS_FFMPEG_ERROR_BASE)) != null && (tag instanceof String) && ((String) tag).equals("baidu_mtj_edit_txtview")) {
                view = childAt;
                break;
            }
            i = i2 + 1;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        builder.setNegativeButton(PayHelper.STATUS_CANCEL_DESC, new DialogInterface.OnClickListener() { // from class: com.baidu.mobstat.ai.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}
