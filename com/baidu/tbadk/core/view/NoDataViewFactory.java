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

        /* JADX DEBUG: Replace access to removed values field (afS) with 'values()' method */
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
        a afN;
        a afO;
        int afP = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.afN = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.afN = aVar;
            bVar.afP = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aav;
        View.OnClickListener afM;

        public a(String str, View.OnClickListener onClickListener) {
            this.aav = str;
            this.afM = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType afQ = ImgType.NONE;
        int afR = -1;
        int afK = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.afQ = imgType;
            cVar.afR = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.afQ = imgType;
            cVar.afK = i;
            cVar.afR = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.afQ = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        String VC;
        int YW;
        String afT;
        int afU = -1;
        String mTitle;

        private d() {
        }

        public static d B(int i, int i2) {
            d dVar = new d();
            dVar.VC = TbadkCoreApplication.m411getInst().getResources().getString(i);
            dVar.afU = i2;
            return dVar;
        }

        public static d cM(int i) {
            return dN(TbadkCoreApplication.m411getInst().getResources().getString(i));
        }

        public static d C(int i, int i2) {
            return ac(TbadkCoreApplication.m411getInst().getResources().getString(i), TbadkCoreApplication.m411getInst().getResources().getString(i2));
        }

        public static d dN(String str) {
            d dVar = new d();
            dVar.VC = str;
            return dVar;
        }

        public static d ac(String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.VC = str;
            return dVar;
        }

        public static d m(String str, String str2, String str3) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.VC = str;
            dVar.afT = str3;
            return dVar;
        }

        public static d b(int i, String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.VC = str;
            dVar.YW = i;
            return dVar;
        }
    }

    public static o a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static o a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        o oVar = new o(context);
        oVar.a(bVar, cVar, dVar);
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
