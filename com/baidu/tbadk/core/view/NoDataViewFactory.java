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

        /* JADX DEBUG: Replace access to removed values field (afg) with 'values()' method */
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
        a afb;
        a afc;
        int afd = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.afb = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.afb = aVar;
            bVar.afd = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String ZR;
        View.OnClickListener afa;

        public a(String str, View.OnClickListener onClickListener) {
            this.ZR = str;
            this.afa = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType afe = ImgType.NONE;
        int aff = -1;
        int aeY = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.afe = imgType;
            cVar.aff = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.afe = imgType;
            cVar.aeY = i;
            cVar.aff = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.afe = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        String Vc;
        int Yt;
        String afh;
        int afi = -1;
        String mTitle;

        private d() {
        }

        public static d C(int i, int i2) {
            d dVar = new d();
            dVar.Vc = TbadkCoreApplication.m411getInst().getResources().getString(i);
            dVar.afi = i2;
            return dVar;
        }

        public static d cS(int i) {
            return dK(TbadkCoreApplication.m411getInst().getResources().getString(i));
        }

        public static d D(int i, int i2) {
            return ad(TbadkCoreApplication.m411getInst().getResources().getString(i), TbadkCoreApplication.m411getInst().getResources().getString(i2));
        }

        public static d dK(String str) {
            d dVar = new d();
            dVar.Vc = str;
            return dVar;
        }

        public static d ad(String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.Vc = str;
            return dVar;
        }

        public static d m(String str, String str2, String str3) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.Vc = str;
            dVar.afh = str3;
            return dVar;
        }

        public static d b(int i, String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.Vc = str;
            dVar.Yt = i;
            return dVar;
        }
    }

    public static n a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static n a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        n nVar = new n(context);
        nVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(nVar, 0);
                } else {
                    relativeLayout.addView(nVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) nVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                nVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(nVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nVar.getLayoutParams();
                layoutParams2.gravity = 1;
                nVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(nVar, 0);
            }
        }
        nVar.setVisibility(8);
        return nVar;
    }
}
