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

        /* JADX DEBUG: Replace access to removed values field (abF) with 'values()' method */
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
        a abA;
        a abB;
        int abC = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.abA = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.abA = aVar;
            bVar.abC = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String VC;
        View.OnClickListener abz;

        public a(String str, View.OnClickListener onClickListener) {
            this.VC = str;
            this.abz = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType abD = ImgType.NONE;
        int abE = -1;
        int abx = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.abD = imgType;
            cVar.abE = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.abD = imgType;
            cVar.abx = i;
            cVar.abE = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.abD = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        String NJ;
        int Ta;
        String abG;
        int abH = -1;
        String mTitle;

        private d() {
        }

        public static d u(int i, int i2) {
            d dVar = new d();
            dVar.NJ = TbadkCoreApplication.m11getInst().getResources().getString(i);
            dVar.abH = i2;
            return dVar;
        }

        public static d cO(int i) {
            return dP(TbadkCoreApplication.m11getInst().getResources().getString(i));
        }

        public static d v(int i, int i2) {
            return ag(TbadkCoreApplication.m11getInst().getResources().getString(i), TbadkCoreApplication.m11getInst().getResources().getString(i2));
        }

        public static d dP(String str) {
            d dVar = new d();
            dVar.NJ = str;
            return dVar;
        }

        public static d ag(String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.NJ = str;
            return dVar;
        }

        public static d b(int i, String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.NJ = str;
            dVar.Ta = i;
            return dVar;
        }
    }

    public static q a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static q a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        q qVar = new q(context);
        qVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(qVar, 0);
                } else {
                    relativeLayout.addView(qVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) qVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                qVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(qVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) qVar.getLayoutParams();
                layoutParams2.gravity = 1;
                qVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(qVar, 0);
            }
        }
        qVar.setVisibility(8);
        return qVar;
    }
}
