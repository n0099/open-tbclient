package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class NoDataViewFactory {

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static class b {
        final a erE;
        final a erF;
        final int erG;

        private b(a aVar) {
            this.erE = aVar.erE;
            this.erF = aVar.erF;
            this.erG = aVar.erG;
        }

        /* loaded from: classes2.dex */
        public static class a {
            private a erE = null;
            private a erF = null;
            private int erG = -1;

            public a b(a aVar) {
                this.erE = aVar;
                return this;
            }

            public a oF(int i) {
                this.erG = i;
                return this;
            }

            public b bkr() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.bkr();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.oF(i);
            return aVar2.bkr();
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        View.OnClickListener erD;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.erD = onClickListener;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        final int erB;
        final ImgType erH;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.erH = aVar.erH;
            this.mMarginTop = aVar.mMarginTop;
            this.erB = aVar.erB;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes2.dex */
        public static class a {
            private ImgType erH = ImgType.NONE;
            private int mMarginTop = -1;
            private int erB = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.erH = imgType;
                return this;
            }

            public a oG(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a oH(int i) {
                this.erB = i;
                return this;
            }

            public a oI(int i) {
                this.mHeight = i;
                return this;
            }

            public a oJ(int i) {
                this.mWidth = i;
                return this;
            }

            public c bks() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.oG(i);
            return aVar.bks();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.oH(i);
            aVar.oG(i2);
            aVar.oI(i3);
            aVar.oJ(i4);
            return aVar.bks();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.bks();
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        final String erI;
        final int erJ;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.erI = aVar.erI;
            this.erJ = aVar.erK;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes2.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String erI = null;
            private int erK = -1;
            private int mDrawableId = 0;

            public a AC(String str) {
                this.mTitle = str;
                return this;
            }

            public a AD(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a oL(int i) {
                this.erK = i;
                return this;
            }

            public d bkt() {
                return new d(this);
            }
        }

        public static d aX(int i, int i2) {
            a aVar = new a();
            aVar.AD(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.oL(i2);
            return aVar.bkt();
        }

        public static d oK(int i) {
            return AB(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aY(int i, int i2) {
            return dE(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d AB(String str) {
            a aVar = new a();
            aVar.AD(str);
            return aVar.bkt();
        }

        public static d dE(String str, String str2) {
            a aVar = new a();
            aVar.AD(str);
            aVar.AC(str2);
            return aVar.bkt();
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
