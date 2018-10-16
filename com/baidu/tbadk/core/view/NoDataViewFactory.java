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
        LOCAL,
        ANTI
    }

    /* loaded from: classes.dex */
    public static class b {
        final a aDA;
        final int aDB;
        final a aDz;

        private b(a aVar) {
            this.aDz = aVar.aDz;
            this.aDA = aVar.aDA;
            this.aDB = aVar.aDB;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a aDz = null;
            private a aDA = null;
            private int aDB = -1;

            public a b(a aVar) {
                this.aDz = aVar;
                return this;
            }

            public a dJ(int i) {
                this.aDB = i;
                return this;
            }

            public b DG() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.DG();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dJ(i);
            return aVar2.DG();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener aDy;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.aDy = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final ImgType aDC;
        final int aDw;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.aDC = aVar.aDC;
            this.mMarginTop = aVar.mMarginTop;
            this.aDw = aVar.aDw;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType aDC = ImgType.NONE;
            private int mMarginTop = -1;
            private int aDw = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.aDC = imgType;
                return this;
            }

            public a dK(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a dL(int i) {
                this.aDw = i;
                return this;
            }

            public a dM(int i) {
                this.mHeight = i;
                return this;
            }

            public a dN(int i) {
                this.mWidth = i;
                return this;
            }

            public c DH() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dK(i);
            return aVar.DH();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dL(i);
            aVar.dK(i2);
            aVar.dM(i3);
            aVar.dN(i4);
            return aVar.DH();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.DH();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String aDD;
        final int aDE;
        final int aDF;
        final String amD;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.amD = aVar.amD;
            this.aDD = aVar.aDD;
            this.aDE = aVar.aDG;
            this.aDF = aVar.aDF;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String amD = null;
            private String aDD = null;
            private int aDG = -1;
            private int aDF = 0;

            public a fV(String str) {
                this.mTitle = str;
                return this;
            }

            public a fW(String str) {
                this.amD = str;
                return this;
            }

            public a dP(int i) {
                this.aDG = i;
                return this;
            }

            public d DI() {
                return new d(this);
            }
        }

        public static d F(int i, int i2) {
            a aVar = new a();
            aVar.fW(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.dP(i2);
            return aVar.DI();
        }

        public static d dO(int i) {
            return fU(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d G(int i, int i2) {
            return aA(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d fU(String str) {
            a aVar = new a();
            aVar.fW(str);
            return aVar.DI();
        }

        public static d aA(String str, String str2) {
            a aVar = new a();
            aVar.fW(str);
            aVar.fV(str2);
            return aVar.DI();
        }
    }

    public static NoDataView a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static NoDataView a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        NoDataView noDataView = new NoDataView(context);
        noDataView.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(noDataView, 0);
                } else {
                    relativeLayout.addView(noDataView);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) noDataView.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                noDataView.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(noDataView);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) noDataView.getLayoutParams();
                layoutParams2.gravity = 1;
                noDataView.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(noDataView, 0);
            }
        }
        noDataView.setVisibility(8);
        return noDataView;
    }
}
