package com.baidu.ar.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.util.Res;
/* loaded from: classes3.dex */
public class ToastCustom {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private Toast a;
    private RotateViewGroup b;
    private TextView c;

    public ToastCustom(Context context) {
        this.a = new Toast(context);
        View inflate = Res.inflate("bdar_toast_custom");
        if (inflate != null) {
            this.b = (RotateViewGroup) inflate.findViewById(Res.id("bdar_toast_frame"));
            this.c = (TextView) inflate.findViewById(Res.id("bdar_toast_text"));
            this.a.setView(inflate);
        }
    }

    public ToastCustom makeText(String str, int i) {
        setText(str);
        setDuration(i);
        return this;
    }

    public ToastCustom makeText(String str, int i, int i2) {
        setText(str);
        setDuration(i);
        setGravity(i2);
        return this;
    }

    public void requestOrientation(Orientation orientation) {
        RotateViewUtils.updateOrientation(this.b, orientation);
    }

    public void setDuration(int i) {
        if (this.a != null) {
            this.a.setDuration(i);
        }
    }

    public void setGravity(int i) {
        switch (i) {
            case 1:
                if (this.a != null) {
                    this.a.setGravity(48, 0, 0);
                    return;
                }
                return;
            case 2:
                if (this.a != null) {
                    this.a.setGravity(17, 0, 0);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setText(String str) {
        if (this.c != null) {
            this.c.setText(str);
        }
    }

    public void show() {
        if (this.c == null || this.a == null) {
            return;
        }
        this.a.show();
    }
}
