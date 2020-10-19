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
        final a eFX;
        final a eFY;
        final int eFZ;

        private b(a aVar) {
            this.eFX = aVar.eFX;
            this.eFY = aVar.eFY;
            this.eFZ = aVar.eFZ;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a eFX = null;
            private a eFY = null;
            private int eFZ = -1;

            public a b(a aVar) {
                this.eFX = aVar;
                return this;
            }

            public a pq(int i) {
                this.eFZ = i;
                return this;
            }

            public b bnW() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.bnW();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.pq(i);
            return aVar2.bnW();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener eFW;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.eFW = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int eFU;
        final ImgType eGa;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.eGa = aVar.eGa;
            this.mMarginTop = aVar.mMarginTop;
            this.eFU = aVar.eFU;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType eGa = ImgType.NONE;
            private int mMarginTop = -1;
            private int eFU = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.eGa = imgType;
                return this;
            }

            public a pr(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a ps(int i) {
                this.eFU = i;
                return this;
            }

            public a pt(int i) {
                this.mHeight = i;
                return this;
            }

            public a pu(int i) {
                this.mWidth = i;
                return this;
            }

            public c bnX() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.pr(i);
            return aVar.bnX();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.ps(i);
            aVar.pr(i2);
            aVar.pt(i3);
            aVar.pu(i4);
            return aVar.bnX();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.bnX();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String eGb;
        final int eGc;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.eGb = aVar.eGb;
            this.eGc = aVar.eGd;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String eGb = null;
            private int eGd = -1;
            private int mDrawableId = 0;

            public a BL(String str) {
                this.mTitle = str;
                return this;
            }

            public a BM(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a pw(int i) {
                this.eGd = i;
                return this;
            }

            public d bnY() {
                return new d(this);
            }
        }

        public static d aW(int i, int i2) {
            a aVar = new a();
            aVar.BM(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.pw(i2);
            return aVar.bnY();
        }

        public static d pv(int i) {
            return BK(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aX(int i, int i2) {
            return dL(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d BK(String str) {
            a aVar = new a();
            aVar.BM(str);
            return aVar.bnY();
        }

        public static d dL(String str, String str2) {
            a aVar = new a();
            aVar.BM(str);
            aVar.BL(str2);
            return aVar.bnY();
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
