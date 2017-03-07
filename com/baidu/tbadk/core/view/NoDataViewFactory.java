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

        /* JADX DEBUG: Replace access to removed values field (akw) with 'values()' method */
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
        a akr;
        a aks;
        int akt = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.akr = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.akr = aVar;
            bVar.akt = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String adX;
        View.OnClickListener akq;

        public a(String str, View.OnClickListener onClickListener) {
            this.adX = str;
            this.akq = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType aku = ImgType.NONE;
        int akv = -1;
        int ako = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.aku = imgType;
            cVar.akv = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.aku = imgType;
            cVar.ako = i;
            cVar.akv = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.aku = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        int aby;
        String akx;
        int aky = -1;
        String mSubTitle;
        String mTitle;

        private d() {
        }

        public static d D(int i, int i2) {
            d dVar = new d();
            dVar.mSubTitle = TbadkCoreApplication.m9getInst().getResources().getString(i);
            dVar.aky = i2;
            return dVar;
        }

        public static d de(int i) {
            return dP(TbadkCoreApplication.m9getInst().getResources().getString(i));
        }

        public static d E(int i, int i2) {
            return ad(TbadkCoreApplication.m9getInst().getResources().getString(i), TbadkCoreApplication.m9getInst().getResources().getString(i2));
        }

        public static d dP(String str) {
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
            dVar.aby = i;
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
