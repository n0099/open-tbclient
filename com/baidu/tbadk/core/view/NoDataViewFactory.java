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

        /* JADX DEBUG: Replace access to removed values field (aej) with 'values()' method */
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
        a aee;
        a aef;
        int aeg = -1;

        private b() {
        }

        public static b a(a aVar) {
            b bVar = new b();
            bVar.aee = aVar;
            return bVar;
        }

        public static b a(a aVar, int i) {
            b bVar = new b();
            bVar.aee = aVar;
            bVar.aeg = i;
            return bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String Zf;
        View.OnClickListener aed;

        public a(String str, View.OnClickListener onClickListener) {
            this.Zf = str;
            this.aed = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        ImgType aeh = ImgType.NONE;
        int aei = -1;
        int aeb = -1;
        int mHeight = -1;
        int mWidth = -1;

        private c() {
        }

        public static c a(ImgType imgType, int i) {
            c cVar = new c();
            cVar.aeh = imgType;
            cVar.aei = i;
            return cVar;
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            c cVar = new c();
            cVar.aeh = imgType;
            cVar.aeb = i;
            cVar.aei = i2;
            cVar.mHeight = i3;
            cVar.mWidth = i4;
            return cVar;
        }

        public static c a(ImgType imgType) {
            c cVar = new c();
            cVar.aeh = imgType;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        String UL;
        int XG;
        String aek;
        int ael = -1;
        String mTitle;

        private d() {
        }

        public static d B(int i, int i2) {
            d dVar = new d();
            dVar.UL = TbadkCoreApplication.m411getInst().getResources().getString(i);
            dVar.ael = i2;
            return dVar;
        }

        public static d cK(int i) {
            return dC(TbadkCoreApplication.m411getInst().getResources().getString(i));
        }

        public static d C(int i, int i2) {
            return ag(TbadkCoreApplication.m411getInst().getResources().getString(i), TbadkCoreApplication.m411getInst().getResources().getString(i2));
        }

        public static d dC(String str) {
            d dVar = new d();
            dVar.UL = str;
            return dVar;
        }

        public static d ag(String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.UL = str;
            return dVar;
        }

        public static d l(String str, String str2, String str3) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.UL = str;
            dVar.aek = str3;
            return dVar;
        }

        public static d b(int i, String str, String str2) {
            d dVar = new d();
            dVar.mTitle = str2;
            dVar.UL = str;
            dVar.XG = i;
            return dVar;
        }
    }

    public static m a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static m a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        m mVar = new m(context);
        mVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(mVar, 0);
                } else {
                    relativeLayout.addView(mVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                mVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(mVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) mVar.getLayoutParams();
                layoutParams2.gravity = 1;
                mVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(mVar, 0);
            }
        }
        mVar.setVisibility(8);
        return mVar;
    }
}
