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

        /* JADX DEBUG: Replace access to removed values field (Ii) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ImgType[] valuesCustom() {
            ImgType[] valuesCustom = values();
            int length = valuesCustom.length;
            ImgType[] imgTypeArr = new ImgType[length];
            System.arraycopy(valuesCustom, 0, imgTypeArr, 0, length);
            return imgTypeArr;
        }
    }

    public static o a(Context context, View view, r rVar, s sVar, q qVar) {
        return a(context, view, rVar, sVar, qVar, false);
    }

    public static o a(Context context, View view, r rVar, s sVar, q qVar, boolean z) {
        o oVar = new o(context);
        oVar.a(qVar, rVar, sVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(oVar, 0);
                } else {
                    relativeLayout.addView(oVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) oVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                oVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(oVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) oVar.getLayoutParams();
                layoutParams2.gravity = 1;
                oVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(oVar, 0);
            }
        }
        oVar.setVisibility(8);
        return oVar;
    }
}
