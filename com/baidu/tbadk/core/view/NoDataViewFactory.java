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

        /* JADX DEBUG: Replace access to removed values field (ajY) with 'values()' method */
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
        a ajT;
        a ajU;
        int ajV = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.ajT = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.ajT = aVar;
            bVar.ajV = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String adw;
        View.OnClickListener ajS;

        public a(String str, View.OnClickListener onClickListener) {
            this.adw = str;
            this.ajS = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType ajW = ImgType.NONE;
        int ajX = -1;
        int ajQ = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.ajW = imgType;
            cVar.ajX = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.ajW = imgType;
            cVar.ajQ = i;
            cVar.ajX = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.ajW = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        int abh;
        String ajZ;
        int aka = -1;
        String mSubTitle;
        String mTitle;

        private d() {
        }

        public static d A(int i, int i2) {
            d dVar = new d();
            dVar.mSubTitle = TbadkCoreApplication.m9getInst().getResources().getString(i);
            dVar.aka = i2;
            return dVar;
        }

        public static d de(int i) {
            return dQ(TbadkCoreApplication.m9getInst().getResources().getString(i));
        }

        public static d B(int i, int i2) {
            return ad(TbadkCoreApplication.m9getInst().getResources().getString(i), TbadkCoreApplication.m9getInst().getResources().getString(i2));
        }

        public static d dQ(String str) {
            d dVar = new d();
            dVar.mSubTitle = str;
            return dVar;
        }

        public static d ad(String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.mSubTitle = str;
            return dVar;
        }

        public static d b(int i, String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.mSubTitle = str;
            dVar.abh = i;
            return dVar;
        }
    }

    public static y a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static y a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        y yVar = new y(context);
        yVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(yVar, 0);
                } else {
                    relativeLayout.addView(yVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) yVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                yVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(yVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) yVar.getLayoutParams();
                layoutParams2.gravity = 1;
                yVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(yVar, 0);
            }
        }
        yVar.setVisibility(8);
        return yVar;
    }
}
