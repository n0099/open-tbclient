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
        COLLECTION,
        EMOTION,
        SINGALL,
        GIFT,
        WEBVIEW,
        LOCAL,
        ANTI,
        NETERROR
    }

    /* loaded from: classes.dex */
    public static class b {
        final a dgA;
        final int dgB;
        final a dgz;

        private b(a aVar) {
            this.dgz = aVar.dgz;
            this.dgA = aVar.dgA;
            this.dgB = aVar.dgB;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a dgz = null;
            private a dgA = null;
            private int dgB = -1;

            public a b(a aVar) {
                this.dgz = aVar;
                return this;
            }

            public a lc(int i) {
                this.dgB = i;
                return this;
            }

            public b aHH() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.aHH();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.lc(i);
            return aVar2.aHH();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener dgy;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.dgy = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final ImgType dgC;
        final int dgw;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.dgC = aVar.dgC;
            this.mMarginTop = aVar.mMarginTop;
            this.dgw = aVar.dgw;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType dgC = ImgType.NONE;
            private int mMarginTop = -1;
            private int dgw = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.dgC = imgType;
                return this;
            }

            public a ld(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a le(int i) {
                this.dgw = i;
                return this;
            }

            public a lf(int i) {
                this.mHeight = i;
                return this;
            }

            public a lg(int i) {
                this.mWidth = i;
                return this;
            }

            public c aHI() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.ld(i);
            return aVar.aHI();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.le(i);
            aVar.ld(i2);
            aVar.lf(i3);
            aVar.lg(i4);
            return aVar.aHI();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.aHI();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String dgD;
        final int dgE;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.dgD = aVar.dgD;
            this.dgE = aVar.dgF;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String dgD = null;
            private int dgF = -1;
            private int mDrawableId = 0;

            public a tW(String str) {
                this.mTitle = str;
                return this;
            }

            public a tX(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a li(int i) {
                this.dgF = i;
                return this;
            }

            public d aHJ() {
                return new d(this);
            }
        }

        public static d aE(int i, int i2) {
            a aVar = new a();
            aVar.tX(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.li(i2);
            return aVar.aHJ();
        }

        public static d lh(int i) {
            return tV(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aF(int i, int i2) {
            return cz(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d tV(String str) {
            a aVar = new a();
            aVar.tX(str);
            return aVar.aHJ();
        }

        public static d cz(String str, String str2) {
            a aVar = new a();
            aVar.tX(str);
            aVar.tW(str2);
            return aVar.aHJ();
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
