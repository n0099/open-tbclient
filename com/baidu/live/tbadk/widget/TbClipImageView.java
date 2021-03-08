package com.baidu.live.tbadk.widget;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class TbClipImageView extends TbImageView {
    private static Method setLayerTypeMethod;
    private boolean canClipPath;

    static {
        setLayerTypeMethod = null;
        try {
            setLayerTypeMethod = TbClipImageView.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException e) {
        }
    }

    public TbClipImageView(Context context) {
        this(context, null, 0);
    }

    public TbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.canClipPath = false;
        init(context, attributeSet, i);
    }

    public TbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        String trim = Build.MODEL.trim();
        if (trim != null) {
            String[] strArr = {"M040", "M045"};
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                } else if (strArr[i2].equalsIgnoreCase(trim)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            String[] strArr2 = {"HTC T329D"};
            int length2 = strArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    z = false;
                    break;
                } else if (strArr2[i3].equalsIgnoreCase(trim)) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            z = false;
            z2 = false;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            CompatibleUtile.getInstance().closeViewGpu(this);
            try {
                if (setLayerTypeMethod != null) {
                    setLayerTypeMethod.invoke(this, 1, null);
                }
            } catch (Exception e) {
            }
        }
        if (z2 || z) {
            this.canClipPath = false;
        } else {
            this.canClipPath = true;
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.BDImageView
    public void setDrawerType(int i) {
        if (i == 0) {
            super.setDrawerType(i);
        } else if (i == 1) {
            super.setDrawerType(this.canClipPath ? 4 : 5);
        } else {
            super.setDrawerType(i);
        }
    }
}
