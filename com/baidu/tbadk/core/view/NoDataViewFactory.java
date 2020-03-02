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
        final a dfZ;
        final a dga;
        final int dgb;

        private b(a aVar) {
            this.dfZ = aVar.dfZ;
            this.dga = aVar.dga;
            this.dgb = aVar.dgb;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a dfZ = null;
            private a dga = null;
            private int dgb = -1;

            public a b(a aVar) {
                this.dfZ = aVar;
                return this;
            }

            public a lc(int i) {
                this.dgb = i;
                return this;
            }

            public b aHC() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.aHC();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.lc(i);
            return aVar2.aHC();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener dfY;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.dfY = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int dfW;
        final ImgType dgc;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.dgc = aVar.dgc;
            this.mMarginTop = aVar.mMarginTop;
            this.dfW = aVar.dfW;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType dgc = ImgType.NONE;
            private int mMarginTop = -1;
            private int dfW = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.dgc = imgType;
                return this;
            }

            public a ld(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a le(int i) {
                this.dfW = i;
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

            public c aHD() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.ld(i);
            return aVar.aHD();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.le(i);
            aVar.ld(i2);
            aVar.lf(i3);
            aVar.lg(i4);
            return aVar.aHD();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.aHD();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String dgd;
        final int dge;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.dgd = aVar.dgd;
            this.dge = aVar.dgf;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String dgd = null;
            private int dgf = -1;
            private int mDrawableId = 0;

            public a tV(String str) {
                this.mTitle = str;
                return this;
            }

            public a tW(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a li(int i) {
                this.dgf = i;
                return this;
            }

            public d aHE() {
                return new d(this);
            }
        }

        public static d aE(int i, int i2) {
            a aVar = new a();
            aVar.tW(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.li(i2);
            return aVar.aHE();
        }

        public static d lh(int i) {
            return tU(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aF(int i, int i2) {
            return cA(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d tU(String str) {
            a aVar = new a();
            aVar.tW(str);
            return aVar.aHE();
        }

        public static d cA(String str, String str2) {
            a aVar = new a();
            aVar.tW(str);
            aVar.tV(str2);
            return aVar.aHE();
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
