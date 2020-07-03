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
        final a ebB;
        final a ebC;
        final int ebD;

        private b(a aVar) {
            this.ebB = aVar.ebB;
            this.ebC = aVar.ebC;
            this.ebD = aVar.ebD;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a ebB = null;
            private a ebC = null;
            private int ebD = -1;

            public a b(a aVar) {
                this.ebB = aVar;
                return this;
            }

            public a mh(int i) {
                this.ebD = i;
                return this;
            }

            public b aXV() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.aXV();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.mh(i);
            return aVar2.aXV();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener ebA;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.ebA = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final ImgType ebE;
        final int eby;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.ebE = aVar.ebE;
            this.mMarginTop = aVar.mMarginTop;
            this.eby = aVar.eby;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType ebE = ImgType.NONE;
            private int mMarginTop = -1;
            private int eby = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.ebE = imgType;
                return this;
            }

            public a mi(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a mj(int i) {
                this.eby = i;
                return this;
            }

            public a mk(int i) {
                this.mHeight = i;
                return this;
            }

            public a ml(int i) {
                this.mWidth = i;
                return this;
            }

            public c aXW() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.mi(i);
            return aVar.aXW();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.mj(i);
            aVar.mi(i2);
            aVar.mk(i3);
            aVar.ml(i4);
            return aVar.aXW();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.aXW();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String ebF;
        final int ebG;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.ebF = aVar.ebF;
            this.ebG = aVar.ebH;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String ebF = null;
            private int ebH = -1;
            private int mDrawableId = 0;

            public a xj(String str) {
                this.mTitle = str;
                return this;
            }

            public a xk(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a mn(int i) {
                this.ebH = i;
                return this;
            }

            public d aXX() {
                return new d(this);
            }
        }

        public static d aO(int i, int i2) {
            a aVar = new a();
            aVar.xk(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.mn(i2);
            return aVar.aXX();
        }

        public static d mm(int i) {
            return xi(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aP(int i, int i2) {
            return dm(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d xi(String str) {
            a aVar = new a();
            aVar.xk(str);
            return aVar.aXX();
        }

        public static d dm(String str, String str2) {
            a aVar = new a();
            aVar.xk(str);
            aVar.xj(str2);
            return aVar.aXX();
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
