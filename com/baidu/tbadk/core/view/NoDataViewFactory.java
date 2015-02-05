package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class NoDataViewFactory {

    /* loaded from: classes.dex */
    public enum ImgType {
        NONE,
        CREATE,
        NODATA,
        FINDBAR,
        EMOTION,
        SINGALL,
        GIFT;

        /* JADX DEBUG: Replace access to removed values field (Nv) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ImgType[] valuesCustom() {
            ImgType[] valuesCustom = values();
            int length = valuesCustom.length;
            ImgType[] imgTypeArr = new ImgType[length];
            System.arraycopy(valuesCustom, 0, imgTypeArr, 0, length);
            return imgTypeArr;
        }
    }

    public static x a(Context context, View view, aa aaVar, ab abVar, z zVar) {
        return a(context, view, aaVar, abVar, zVar, false);
    }

    public static x a(Context context, View view, aa aaVar, ab abVar, z zVar, boolean z) {
        x xVar = new x(context);
        xVar.a(zVar, aaVar, abVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(xVar, 0);
                } else {
                    relativeLayout.addView(xVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) xVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                xVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(xVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) xVar.getLayoutParams();
                layoutParams2.gravity = 1;
                xVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(xVar, 0);
            }
        }
        xVar.setVisibility(8);
        return xVar;
    }
}
