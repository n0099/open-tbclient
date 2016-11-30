package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
        WEBVIEW,
        LOCAL;

        /* JADX DEBUG: Replace access to removed values field (agz) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static ImgType[] valuesCustom() {
            ImgType[] valuesCustom = values();
            int length = valuesCustom.length;
            ImgType[] imgTypeArr = new ImgType[length];
            System.arraycopy(valuesCustom, 0, imgTypeArr, 0, length);
            return imgTypeArr;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        a agu;
        a agv;
        int agw = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.agu = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.agu = aVar;
            bVar.agw = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aaa;
        View.OnClickListener agt;

        public a(String str, View.OnClickListener onClickListener) {
            this.aaa = str;
            this.agt = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType agx = ImgType.NONE;
        int agy = -1;
        int agr = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.agx = imgType;
            cVar.agy = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.agx = imgType;
            cVar.agr = i;
            cVar.agy = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.agx = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        int XA;
        String agA;
        int agB = -1;
        String mSubTitle;
        String mTitle;

        private d() {
        }

        public static d w(int i, int i2) {
            d dVar = new d();
            dVar.mSubTitle = TbadkCoreApplication.m9getInst().getResources().getString(i);
            dVar.agB = i2;
            return dVar;
        }

        public static d df(int i) {
            return ea(TbadkCoreApplication.m9getInst().getResources().getString(i));
        }

        public static d x(int i, int i2) {
            return af(TbadkCoreApplication.m9getInst().getResources().getString(i), TbadkCoreApplication.m9getInst().getResources().getString(i2));
        }

        public static d ea(String str) {
            d dVar = new d();
            dVar.mSubTitle = str;
            return dVar;
        }

        public static d af(String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.mSubTitle = str;
            return dVar;
        }

        public static d b(int i, String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.mSubTitle = str;
            dVar.XA = i;
            return dVar;
        }
    }

    public static w a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static w a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        w wVar = new w(context);
        wVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(wVar, 0);
                } else {
                    relativeLayout.addView(wVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) wVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                wVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(wVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) wVar.getLayoutParams();
                layoutParams2.gravity = 1;
                wVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(wVar, 0);
            }
        }
        wVar.setVisibility(8);
        return wVar;
    }
}
