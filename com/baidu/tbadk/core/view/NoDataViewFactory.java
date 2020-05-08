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
        final a dGa;
        final a dGb;
        final int dGc;

        private b(a aVar) {
            this.dGa = aVar.dGa;
            this.dGb = aVar.dGb;
            this.dGc = aVar.dGc;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a dGa = null;
            private a dGb = null;
            private int dGc = -1;

            public a b(a aVar) {
                this.dGa = aVar;
                return this;
            }

            public a lm(int i) {
                this.dGc = i;
                return this;
            }

            public b aPW() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.aPW();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.lm(i);
            return aVar2.aPW();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener dFZ;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.dFZ = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int dFX;
        final ImgType dGd;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.dGd = aVar.dGd;
            this.mMarginTop = aVar.mMarginTop;
            this.dFX = aVar.dFX;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType dGd = ImgType.NONE;
            private int mMarginTop = -1;
            private int dFX = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.dGd = imgType;
                return this;
            }

            public a ln(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a lo(int i) {
                this.dFX = i;
                return this;
            }

            public a lp(int i) {
                this.mHeight = i;
                return this;
            }

            public a lq(int i) {
                this.mWidth = i;
                return this;
            }

            public c aPX() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.ln(i);
            return aVar.aPX();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.lo(i);
            aVar.ln(i2);
            aVar.lp(i3);
            aVar.lq(i4);
            return aVar.aPX();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.aPX();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String dGe;
        final int dGf;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.dGe = aVar.dGe;
            this.dGf = aVar.dGg;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String dGe = null;
            private int dGg = -1;
            private int mDrawableId = 0;

            public a vm(String str) {
                this.mTitle = str;
                return this;
            }

            public a vn(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a ls(int i) {
                this.dGg = i;
                return this;
            }

            public d aPY() {
                return new d(this);
            }
        }

        public static d aI(int i, int i2) {
            a aVar = new a();
            aVar.vn(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.ls(i2);
            return aVar.aPY();
        }

        public static d lr(int i) {
            return vl(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aJ(int i, int i2) {
            return cK(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d vl(String str) {
            a aVar = new a();
            aVar.vn(str);
            return aVar.aPY();
        }

        public static d cK(String str, String str2) {
            a aVar = new a();
            aVar.vn(str);
            aVar.vm(str2);
            return aVar.aPY();
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
