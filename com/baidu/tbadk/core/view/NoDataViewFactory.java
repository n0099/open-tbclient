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
        final a bZO;
        final a bZP;
        final int bZQ;

        private b(a aVar) {
            this.bZO = aVar.bZO;
            this.bZP = aVar.bZP;
            this.bZQ = aVar.bZQ;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a bZO = null;
            private a bZP = null;
            private int bZQ = -1;

            public a b(a aVar) {
                this.bZO = aVar;
                return this;
            }

            public a iI(int i) {
                this.bZQ = i;
                return this;
            }

            public b akx() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.akx();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.iI(i);
            return aVar2.akx();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String amD;
        View.OnClickListener bZN;

        public a(String str, View.OnClickListener onClickListener) {
            this.amD = str;
            this.bZN = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int aPm;
        final int bZL;
        final ImgType bZR;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.bZR = aVar.bZR;
            this.aPm = aVar.aPm;
            this.bZL = aVar.bZL;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType bZR = ImgType.NONE;
            private int aPm = -1;
            private int bZL = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.bZR = imgType;
                return this;
            }

            public a iJ(int i) {
                this.aPm = i;
                return this;
            }

            public a iK(int i) {
                this.bZL = i;
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

            public c aky() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iJ(i);
            return aVar.aky();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iK(i);
            aVar.iJ(i2);
            aVar.iL(i3);
            aVar.iM(i4);
            return aVar.aky();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.aky();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String bGC;
        final String bZS;
        final int bZT;
        final int bZU;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.bGC = aVar.bGC;
            this.bZS = aVar.bZS;
            this.bZT = aVar.bZV;
            this.bZU = aVar.bZU;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String bGC = null;
            private String bZS = null;
            private int bZV = -1;
            private int bZU = 0;

            public a oQ(String str) {
                this.mTitle = str;
                return this;
            }

            public a oR(String str) {
                this.bGC = str;
                return this;
            }

            public a iO(int i) {
                this.bZV = i;
                return this;
            }

            public d akz() {
                return new d(this);
            }
        }

        public static d af(int i, int i2) {
            a aVar = new a();
            aVar.oR(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.iO(i2);
            return aVar.akz();
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
            return aVar.akz();
        }

        public static d bX(String str, String str2) {
            a aVar = new a();
            aVar.oR(str);
            aVar.oQ(str2);
            return aVar.akz();
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
