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
        final a bZI;
        final a bZJ;
        final int bZK;

        private b(a aVar) {
            this.bZI = aVar.bZI;
            this.bZJ = aVar.bZJ;
            this.bZK = aVar.bZK;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a bZI = null;
            private a bZJ = null;
            private int bZK = -1;

            public a b(a aVar) {
                this.bZI = aVar;
                return this;
            }

            public a iI(int i) {
                this.bZK = i;
                return this;
            }

            public b akv() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.akv();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.iI(i);
            return aVar2.akv();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String amD;
        View.OnClickListener bZH;

        public a(String str, View.OnClickListener onClickListener) {
            this.amD = str;
            this.bZH = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int aPm;
        final int bZF;
        final ImgType bZL;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.bZL = aVar.bZL;
            this.aPm = aVar.aPm;
            this.bZF = aVar.bZF;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType bZL = ImgType.NONE;
            private int aPm = -1;
            private int bZF = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.bZL = imgType;
                return this;
            }

            public a iJ(int i) {
                this.aPm = i;
                return this;
            }

            public a iK(int i) {
                this.bZF = i;
                return this;
            }

            public a iL(int i) {
                this.mHeight = i;
                return this;
            }

            public a iM(int i) {
                this.mWidth = i;
                return this;
            }

            public c akw() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iJ(i);
            return aVar.akw();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iK(i);
            aVar.iJ(i2);
            aVar.iL(i3);
            aVar.iM(i4);
            return aVar.akw();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.akw();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String bGB;
        final String bZM;
        final int bZN;
        final int bZO;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.bGB = aVar.bGB;
            this.bZM = aVar.bZM;
            this.bZN = aVar.bZP;
            this.bZO = aVar.bZO;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String bGB = null;
            private String bZM = null;
            private int bZP = -1;
            private int bZO = 0;

            public a oQ(String str) {
                this.mTitle = str;
                return this;
            }

            public a oR(String str) {
                this.bGB = str;
                return this;
            }

            public a iO(int i) {
                this.bZP = i;
                return this;
            }

            public d akx() {
                return new d(this);
            }
        }

        public static d af(int i, int i2) {
            a aVar = new a();
            aVar.oR(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.iO(i2);
            return aVar.akx();
        }

        public static d iN(int i) {
            return oP(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d ag(int i, int i2) {
            return bX(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d oP(String str) {
            a aVar = new a();
            aVar.oR(str);
            return aVar.akx();
        }

        public static d bX(String str, String str2) {
            a aVar = new a();
            aVar.oR(str);
            aVar.oQ(str2);
            return aVar.akx();
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
