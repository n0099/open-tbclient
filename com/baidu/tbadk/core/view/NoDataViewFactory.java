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
        final a erI;
        final a erJ;
        final int erK;

        private b(a aVar) {
            this.erI = aVar.erI;
            this.erJ = aVar.erJ;
            this.erK = aVar.erK;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a erI = null;
            private a erJ = null;
            private int erK = -1;

            public a b(a aVar) {
                this.erI = aVar;
                return this;
            }

            public a oF(int i) {
                this.erK = i;
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

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener erH;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.erH = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int erF;
        final ImgType erL;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.erL = aVar.erL;
            this.mMarginTop = aVar.mMarginTop;
            this.erF = aVar.erF;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType erL = ImgType.NONE;
            private int mMarginTop = -1;
            private int erF = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.erL = imgType;
                return this;
            }

            public a oG(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a oH(int i) {
                this.erF = i;
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

    /* loaded from: classes.dex */
    public static class d {
        final String erM;
        final int erN;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.erM = aVar.erM;
            this.erN = aVar.erO;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String erM = null;
            private int erO = -1;
            private int mDrawableId = 0;

            public a AD(String str) {
                this.mTitle = str;
                return this;
            }

            public a AE(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a oL(int i) {
                this.erO = i;
                return this;
            }

            public d bkt() {
                return new d(this);
            }
        }

        public static d aX(int i, int i2) {
            a aVar = new a();
            aVar.AE(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.oL(i2);
            return aVar.bkt();
        }

        public static d oK(int i) {
            return AC(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aY(int i, int i2) {
            return dE(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d AC(String str) {
            a aVar = new a();
            aVar.AE(str);
            return aVar.bkt();
        }

        public static d dE(String str, String str2) {
            a aVar = new a();
            aVar.AE(str);
            aVar.AD(str2);
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
