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
        GIFT,
        WEBVIEW;

        /* JADX DEBUG: Replace access to removed values field (YG) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ImgType[] valuesCustom() {
            ImgType[] valuesCustom = values();
            int length = valuesCustom.length;
            ImgType[] imgTypeArr = new ImgType[length];
            System.arraycopy(valuesCustom, 0, imgTypeArr, 0, length);
            return imgTypeArr;
        }
    }

    public static s a(Context context, View view, v vVar, w wVar, u uVar) {
        return a(context, view, vVar, wVar, uVar, false);
    }

    public static s a(Context context, View view, v vVar, w wVar, u uVar, boolean z) {
        s sVar = new s(context);
        sVar.a(uVar, vVar, wVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(sVar, 0);
                } else {
                    relativeLayout.addView(sVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) sVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                sVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(sVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) sVar.getLayoutParams();
                layoutParams2.gravity = 1;
                sVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(sVar, 0);
            }
        }
        sVar.setVisibility(8);
        return sVar;
    }
}
