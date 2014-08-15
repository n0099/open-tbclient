package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
/* loaded from: classes.dex */
public class b extends Button {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private View.OnClickListener g;
    private WindowManager h;
    private WindowManager.LayoutParams i;

    public b(Context context) {
        super(context);
        this.h = (WindowManager) context.getSystemService("window");
        setWindowManagerParams(new WindowManager.LayoutParams());
        this.i.x = 0;
        this.i.y = 0;
        this.i.width = -2;
        this.i.height = -2;
        this.i.type = 2002;
        this.i.format = 1;
        this.i.flags = 40;
        this.i.gravity = 51;
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        this.c = motionEvent.getRawX();
        this.d = motionEvent.getRawY() - i;
        switch (motionEvent.getAction()) {
            case 0:
                this.a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.e = this.c;
                this.f = this.d;
                Log.i("tag", "startX" + this.e + "====startY" + this.f);
                return true;
            case 1:
                a();
                this.b = 0.0f;
                this.a = 0.0f;
                Log.i("tag", "x" + this.c + "====y" + this.d);
                if (Math.abs(this.c - this.e) < 2.0f && Math.abs(this.d - this.f) < 2.0f && this.g != null) {
                    this.g.onClick(this);
                    return true;
                }
                return true;
            case 2:
                a();
                return true;
            default:
                return true;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    private void a() {
        this.i.x = (int) (this.c - this.a);
        this.i.y = (int) (this.d - this.b);
        this.h.updateViewLayout(this, this.i);
    }

    public WindowManager.LayoutParams getWindowManagerParams() {
        return this.i;
    }

    public void setWindowManagerParams(WindowManager.LayoutParams layoutParams) {
        this.i = layoutParams;
    }
}
