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
        LOCAL
    }

    /* loaded from: classes.dex */
    public static class b {
        a amF;
        a amG;
        int amH = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.amF = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.amF = aVar;
            bVar.amH = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String afX;
        View.OnClickListener amE;

        public a(String str, View.OnClickListener onClickListener) {
            this.afX = str;
            this.amE = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType amI = ImgType.NONE;
        int amJ = -1;
        int amC = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.amI = imgType;
            cVar.amJ = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.amI = imgType;
            cVar.amC = i;
            cVar.amJ = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.amI = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        int adg;
        String amL;
        int amM = -1;
        String mSubTitle;
        String mTitle;

        private d() {
        }

        public static d B(int i, int i2) {
            d dVar = new d();
            dVar.mSubTitle = TbadkCoreApplication.getInst().getResources().getString(i);
            dVar.amM = i2;
            return dVar;
        }

        public static d dk(int i) {
            return ey(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d C(int i, int i2) {
            return ad(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d ey(String str) {
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
            dVar.adg = i;
            return dVar;
        }
    }

    public static j a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static j a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        j jVar = new j(context);
        jVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(jVar, 0);
                } else {
                    relativeLayout.addView(jVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                jVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(jVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) jVar.getLayoutParams();
                layoutParams2.gravity = 1;
                jVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(jVar, 0);
            }
        }
        jVar.setVisibility(8);
        return jVar;
    }
}
