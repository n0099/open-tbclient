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

        /* JADX DEBUG: Replace access to removed values field (aeR) with 'values()' method */
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
        a aeM;
        a aeN;
        int aeO = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.aeM = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.aeM = aVar;
            bVar.aeO = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String Zf;
        View.OnClickListener aeL;

        public a(String str, View.OnClickListener onClickListener) {
            this.Zf = str;
            this.aeL = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType aeP = ImgType.NONE;
        int aeQ = -1;
        int aeJ = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.aeP = imgType;
            cVar.aeQ = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.aeP = imgType;
            cVar.aeJ = i;
            cVar.aeQ = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.aeP = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        String UU;
        int XJ;
        String aeS;
        int aeT = -1;
        String mTitle;

        private d() {
        }

        public static d B(int i, int i2) {
            d dVar = new d();
            dVar.UU = TbadkCoreApplication.m411getInst().getResources().getString(i);
            dVar.aeT = i2;
            return dVar;
        }

        public static d cJ(int i) {
            return dy(TbadkCoreApplication.m411getInst().getResources().getString(i));
        }

        public static d C(int i, int i2) {
            return ah(TbadkCoreApplication.m411getInst().getResources().getString(i), TbadkCoreApplication.m411getInst().getResources().getString(i2));
        }

        public static d dy(String str) {
            d dVar = new d();
            dVar.UU = str;
            return dVar;
        }

        public static d ah(String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.UU = str;
            return dVar;
        }

        public static d m(String str, String str2, String str3) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.UU = str;
            dVar.aeS = str3;
            return dVar;
        }

        public static d b(int i, String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.UU = str;
            dVar.XJ = i;
            return dVar;
        }
    }

    public static u a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static u a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        u uVar = new u(context);
        uVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(uVar, 0);
                } else {
                    relativeLayout.addView(uVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) uVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                uVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(uVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) uVar.getLayoutParams();
                layoutParams2.gravity = 1;
                uVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(uVar, 0);
            }
        }
        uVar.setVisibility(8);
        return uVar;
    }
}
