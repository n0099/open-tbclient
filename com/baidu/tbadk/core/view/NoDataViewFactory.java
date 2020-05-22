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
        final a dUm;
        final a dUn;
        final int dUo;

        private b(a aVar) {
            this.dUm = aVar.dUm;
            this.dUn = aVar.dUn;
            this.dUo = aVar.dUo;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a dUm = null;
            private a dUn = null;
            private int dUo = -1;

            public a b(a aVar) {
                this.dUm = aVar;
                return this;
            }

            public a lO(int i) {
                this.dUo = i;
                return this;
            }

            public b aWa() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.aWa();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.lO(i);
            return aVar2.aWa();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener dUl;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.dUl = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int dUj;
        final ImgType dUp;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.dUp = aVar.dUp;
            this.mMarginTop = aVar.mMarginTop;
            this.dUj = aVar.dUj;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType dUp = ImgType.NONE;
            private int mMarginTop = -1;
            private int dUj = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.dUp = imgType;
                return this;
            }

            public a lP(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a lQ(int i) {
                this.dUj = i;
                return this;
            }

            public a lR(int i) {
                this.mHeight = i;
                return this;
            }

            public a lS(int i) {
                this.mWidth = i;
                return this;
            }

            public c aWb() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.lP(i);
            return aVar.aWb();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.lQ(i);
            aVar.lP(i2);
            aVar.lR(i3);
            aVar.lS(i4);
            return aVar.aWb();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.aWb();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String dUq;
        final int dUr;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.dUq = aVar.dUq;
            this.dUr = aVar.dUs;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String dUq = null;
            private int dUs = -1;
            private int mDrawableId = 0;

            public a wS(String str) {
                this.mTitle = str;
                return this;
            }

            public a wT(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a lU(int i) {
                this.dUs = i;
                return this;
            }

            public d aWc() {
                return new d(this);
            }
        }

        public static d aL(int i, int i2) {
            a aVar = new a();
            aVar.wT(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.lU(i2);
            return aVar.aWc();
        }

        public static d lT(int i) {
            return wR(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aM(int i, int i2) {
            return dj(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d wR(String str) {
            a aVar = new a();
            aVar.wT(str);
            return aVar.aWc();
        }

        public static d dj(String str, String str2) {
            a aVar = new a();
            aVar.wT(str);
            aVar.wS(str2);
            return aVar.aWc();
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
