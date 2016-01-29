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

        /* JADX DEBUG: Replace access to removed values field (agF) with 'values()' method */
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
        a agA;
        a agB;
        int agC = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.agA = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.agA = aVar;
            bVar.agC = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aaR;
        View.OnClickListener agz;

        public a(String str, View.OnClickListener onClickListener) {
            this.aaR = str;
            this.agz = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType agD = ImgType.NONE;
        int agE = -1;
        int agx = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.agD = imgType;
            cVar.agE = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.agD = imgType;
            cVar.agx = i;
            cVar.agE = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.agD = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        String Vn;
        int Zt;
        String agG;
        int agH = -1;
        String mTitle;

        private d() {
        }

        public static d x(int i, int i2) {
            d dVar = new d();
            dVar.Vn = TbadkCoreApplication.m411getInst().getResources().getString(i);
            dVar.agH = i2;
            return dVar;
        }

        public static d dd(int i) {
            return dM(TbadkCoreApplication.m411getInst().getResources().getString(i));
        }

        public static d y(int i, int i2) {
            return ac(TbadkCoreApplication.m411getInst().getResources().getString(i), TbadkCoreApplication.m411getInst().getResources().getString(i2));
        }

        public static d dM(String str) {
            d dVar = new d();
            dVar.Vn = str;
            return dVar;
        }

        public static d ac(String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.Vn = str;
            return dVar;
        }

        public static d m(String str, String str2, String str3) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.Vn = str;
            dVar.agG = str3;
            return dVar;
        }

        public static d b(int i, String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.Vn = str;
            dVar.Zt = i;
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
