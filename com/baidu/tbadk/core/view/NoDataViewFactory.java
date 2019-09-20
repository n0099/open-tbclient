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
        final a caH;
        final a caI;
        final int caJ;

        private b(a aVar) {
            this.caH = aVar.caH;
            this.caI = aVar.caI;
            this.caJ = aVar.caJ;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a caH = null;
            private a caI = null;
            private int caJ = -1;

            public a b(a aVar) {
                this.caH = aVar;
                return this;
            }

            public a iL(int i) {
                this.caJ = i;
                return this;
            }

            public b akJ() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.akJ();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.iL(i);
            return aVar2.akJ();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String anb;
        View.OnClickListener caG;

        public a(String str, View.OnClickListener onClickListener) {
            this.anb = str;
            this.caG = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int aPK;
        final int caE;
        final ImgType caK;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.caK = aVar.caK;
            this.aPK = aVar.aPK;
            this.caE = aVar.caE;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType caK = ImgType.NONE;
            private int aPK = -1;
            private int caE = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.caK = imgType;
                return this;
            }

            public a iM(int i) {
                this.aPK = i;
                return this;
            }

            public a iN(int i) {
                this.caE = i;
                return this;
            }

            public a iO(int i) {
                this.mHeight = i;
                return this;
            }

            public a iP(int i) {
                this.mWidth = i;
                return this;
            }

            public c akK() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iM(i);
            return aVar.akK();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iN(i);
            aVar.iM(i2);
            aVar.iO(i3);
            aVar.iP(i4);
            return aVar.akK();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.akK();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String bHa;
        final String caL;
        final int caM;
        final int caN;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.bHa = aVar.bHa;
            this.caL = aVar.caL;
            this.caM = aVar.caO;
            this.caN = aVar.caN;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String bHa = null;
            private String caL = null;
            private int caO = -1;
            private int caN = 0;

            public a oY(String str) {
                this.mTitle = str;
                return this;
            }

            public a oZ(String str) {
                this.bHa = str;
                return this;
            }

            public a iR(int i) {
                this.caO = i;
                return this;
            }

            public d akL() {
                return new d(this);
            }
        }

        public static d af(int i, int i2) {
            a aVar = new a();
            aVar.oZ(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.iR(i2);
            return aVar.akL();
        }

        public static d iQ(int i) {
            return oX(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d ag(int i, int i2) {
            return bX(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d oX(String str) {
            a aVar = new a();
            aVar.oZ(str);
            return aVar.akL();
        }

        public static d bX(String str, String str2) {
            a aVar = new a();
            aVar.oZ(str);
            aVar.oY(str2);
            return aVar.akL();
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
