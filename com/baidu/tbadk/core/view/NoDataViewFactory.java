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
        final a faL;
        final a faM;
        final int faN;

        private b(a aVar) {
            this.faL = aVar.faL;
            this.faM = aVar.faM;
            this.faN = aVar.faN;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a faL = null;
            private a faM = null;
            private int faN = -1;

            public a b(a aVar) {
                this.faL = aVar;
                return this;
            }

            public a qK(int i) {
                this.faN = i;
                return this;
            }

            public b bvd() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.bvd();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.qK(i);
            return aVar2.bvd();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener faK;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.faK = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int faC;
        final ImgType faO;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.faO = aVar.faO;
            this.mMarginTop = aVar.mMarginTop;
            this.faC = aVar.faC;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType faO = ImgType.NONE;
            private int mMarginTop = -1;
            private int faC = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.faO = imgType;
                return this;
            }

            public a qL(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a qM(int i) {
                this.faC = i;
                return this;
            }

            public a qN(int i) {
                this.mHeight = i;
                return this;
            }

            public a qO(int i) {
                this.mWidth = i;
                return this;
            }

            public c bve() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.qL(i);
            return aVar.bve();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.qM(i);
            aVar.qL(i2);
            aVar.qN(i3);
            aVar.qO(i4);
            return aVar.bve();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.bve();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String faP;
        final int faQ;
        final int faR;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.faP = aVar.faP;
            this.faQ = aVar.faS;
            this.faR = aVar.faR;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String faP = null;
            private int faS = -1;
            private int faR = 0;

            public a Cz(String str) {
                this.mTitle = str;
                return this;
            }

            public a CA(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a qQ(int i) {
                this.faS = i;
                return this;
            }

            public d bvf() {
                return new d(this);
            }
        }

        public static d aZ(int i, int i2) {
            a aVar = new a();
            aVar.CA(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.qQ(i2);
            return aVar.bvf();
        }

        public static d qP(int i) {
            return Cy(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d ba(int i, int i2) {
            return dZ(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d Cy(String str) {
            a aVar = new a();
            aVar.CA(str);
            return aVar.bvf();
        }

        public static d dZ(String str, String str2) {
            a aVar = new a();
            aVar.CA(str);
            aVar.Cz(str2);
            return aVar.bvf();
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
