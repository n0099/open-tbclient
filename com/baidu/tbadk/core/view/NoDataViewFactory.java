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

        /* JADX DEBUG: Replace access to removed values field (afY) with 'values()' method */
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
        a afT;
        a afU;
        int afV = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.afT = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.afT = aVar;
            bVar.afV = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String ZC;
        View.OnClickListener afS;

        public a(String str, View.OnClickListener onClickListener) {
            this.ZC = str;
            this.afS = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType afW = ImgType.NONE;
        int afX = -1;
        int afQ = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.afW = imgType;
            cVar.afX = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.afW = imgType;
            cVar.afQ = i;
            cVar.afX = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.afW = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        int Xc;
        String afZ;
        int aga = -1;
        String mSubTitle;
        String mTitle;

        private d() {
        }

        public static d w(int i, int i2) {
            d dVar = new d();
            dVar.mSubTitle = TbadkCoreApplication.m9getInst().getResources().getString(i);
            dVar.aga = i2;
            return dVar;
        }

        public static d de(int i) {
            return dY(TbadkCoreApplication.m9getInst().getResources().getString(i));
        }

        public static d x(int i, int i2) {
            return af(TbadkCoreApplication.m9getInst().getResources().getString(i), TbadkCoreApplication.m9getInst().getResources().getString(i2));
        }

        public static d dY(String str) {
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
            dVar.Xc = i;
            return dVar;
        }
    }

    public static v a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static v a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        v vVar = new v(context);
        vVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(vVar, 0);
                } else {
                    relativeLayout.addView(vVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) vVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                vVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(vVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) vVar.getLayoutParams();
                layoutParams2.gravity = 1;
                vVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(vVar, 0);
            }
        }
        vVar.setVisibility(8);
        return vVar;
    }
}
