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

        /* JADX DEBUG: Replace access to removed values field (agg) with 'values()' method */
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
        a aga;
        a agb;
        int agc = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.aga = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.aga = aVar;
            bVar.agc = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aad;
        View.OnClickListener afZ;

        public a(String str, View.OnClickListener onClickListener) {
            this.aad = str;
            this.afZ = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType agd = ImgType.NONE;
        int agf = -1;
        int afX = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.agd = imgType;
            cVar.agf = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.agd = imgType;
            cVar.afX = i;
            cVar.agf = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.agd = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        String SX;
        int XM;
        String agh;
        int agi = -1;
        String mTitle;

        private d() {
        }

        public static d u(int i, int i2) {
            d dVar = new d();
            dVar.SX = TbadkCoreApplication.m411getInst().getResources().getString(i);
            dVar.agi = i2;
            return dVar;
        }

        public static d dg(int i) {
            return dS(TbadkCoreApplication.m411getInst().getResources().getString(i));
        }

        public static d v(int i, int i2) {
            return ag(TbadkCoreApplication.m411getInst().getResources().getString(i), TbadkCoreApplication.m411getInst().getResources().getString(i2));
        }

        public static d dS(String str) {
            d dVar = new d();
            dVar.SX = str;
            return dVar;
        }

        public static d ag(String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.SX = str;
            return dVar;
        }

        public static d o(String str, String str2, String str3) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.SX = str;
            dVar.agh = str3;
            return dVar;
        }

        public static d b(int i, String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.SX = str;
            dVar.XM = i;
            return dVar;
        }
    }

    public static p a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static p a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        p pVar = new p(context);
        pVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(pVar, 0);
                } else {
                    relativeLayout.addView(pVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                pVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(pVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pVar.getLayoutParams();
                layoutParams2.gravity = 1;
                pVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(pVar, 0);
            }
        }
        pVar.setVisibility(8);
        return pVar;
    }
}
