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
        final a bYF;
        final a bYG;
        final int bYH;

        private b(a aVar) {
            this.bYF = aVar.bYF;
            this.bYG = aVar.bYG;
            this.bYH = aVar.bYH;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a bYF = null;
            private a bYG = null;
            private int bYH = -1;

            public a b(a aVar) {
                this.bYF = aVar;
                return this;
            }

            public a iC(int i) {
                this.bYH = i;
                return this;
            }

            public b ajq() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.ajq();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.iC(i);
            return aVar2.ajq();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String ama;
        View.OnClickListener bYE;

        public a(String str, View.OnClickListener onClickListener) {
            this.ama = str;
            this.bYE = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int aOC;
        final int bYC;
        final ImgType bYI;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.bYI = aVar.bYI;
            this.aOC = aVar.aOC;
            this.bYC = aVar.bYC;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType bYI = ImgType.NONE;
            private int aOC = -1;
            private int bYC = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.bYI = imgType;
                return this;
            }

            public a iD(int i) {
                this.aOC = i;
                return this;
            }

            public a iE(int i) {
                this.bYC = i;
                return this;
            }

            public a iF(int i) {
                this.mHeight = i;
                return this;
            }

            public a iG(int i) {
                this.mWidth = i;
                return this;
            }

            public c ajr() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iD(i);
            return aVar.ajr();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iE(i);
            aVar.iD(i2);
            aVar.iF(i3);
            aVar.iG(i4);
            return aVar.ajr();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.ajr();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String bFz;
        final String bYJ;
        final int bYK;
        final int bYL;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.bFz = aVar.bFz;
            this.bYJ = aVar.bYJ;
            this.bYK = aVar.bYM;
            this.bYL = aVar.bYL;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String bFz = null;
            private String bYJ = null;
            private int bYM = -1;
            private int bYL = 0;

            public a oA(String str) {
                this.mTitle = str;
                return this;
            }

            public a oB(String str) {
                this.bFz = str;
                return this;
            }

            public a iI(int i) {
                this.bYM = i;
                return this;
            }

            public d ajs() {
                return new d(this);
            }
        }

        public static d ac(int i, int i2) {
            a aVar = new a();
            aVar.oB(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.iI(i2);
            return aVar.ajs();
        }

        public static d iH(int i) {
            return oz(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d ad(int i, int i2) {
            return bW(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d oz(String str) {
            a aVar = new a();
            aVar.oB(str);
            return aVar.ajs();
        }

        public static d bW(String str, String str2) {
            a aVar = new a();
            aVar.oB(str);
            aVar.oA(str2);
            return aVar.ajs();
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
