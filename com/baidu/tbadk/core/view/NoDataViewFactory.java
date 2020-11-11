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
        final a eUi;
        final a eUj;
        final int eUk;

        private b(a aVar) {
            this.eUi = aVar.eUi;
            this.eUj = aVar.eUj;
            this.eUk = aVar.eUk;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a eUi = null;
            private a eUj = null;
            private int eUk = -1;

            public a b(a aVar) {
                this.eUi = aVar;
                return this;
            }

            public a pL(int i) {
                this.eUk = i;
                return this;
            }

            public b bsp() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.bsp();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.pL(i);
            return aVar2.bsp();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener eUh;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.eUh = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int eUf;
        final ImgType eUl;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.eUl = aVar.eUl;
            this.mMarginTop = aVar.mMarginTop;
            this.eUf = aVar.eUf;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType eUl = ImgType.NONE;
            private int mMarginTop = -1;
            private int eUf = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.eUl = imgType;
                return this;
            }

            public a pM(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a pN(int i) {
                this.eUf = i;
                return this;
            }

            public a pO(int i) {
                this.mHeight = i;
                return this;
            }

            public a pP(int i) {
                this.mWidth = i;
                return this;
            }

            public c bsq() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.pM(i);
            return aVar.bsq();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.pN(i);
            aVar.pM(i2);
            aVar.pO(i3);
            aVar.pP(i4);
            return aVar.bsq();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.bsq();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String eUm;
        final int eUn;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.eUm = aVar.eUm;
            this.eUn = aVar.eUo;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String eUm = null;
            private int eUo = -1;
            private int mDrawableId = 0;

            public a Cs(String str) {
                this.mTitle = str;
                return this;
            }

            public a Ct(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a pR(int i) {
                this.eUo = i;
                return this;
            }

            public d bsr() {
                return new d(this);
            }
        }

        public static d aX(int i, int i2) {
            a aVar = new a();
            aVar.Ct(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.pR(i2);
            return aVar.bsr();
        }

        public static d pQ(int i) {
            return Cr(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aY(int i, int i2) {
            return dS(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d Cr(String str) {
            a aVar = new a();
            aVar.Ct(str);
            return aVar.bsr();
        }

        public static d dS(String str, String str2) {
            a aVar = new a();
            aVar.Ct(str);
            aVar.Cs(str2);
            return aVar.bsr();
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
