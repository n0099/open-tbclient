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
        final a cpl;
        final a cpm;
        final int cpn;

        private b(a aVar) {
            this.cpl = aVar.cpl;
            this.cpm = aVar.cpm;
            this.cpn = aVar.cpn;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a cpl = null;
            private a cpm = null;
            private int cpn = -1;

            public a b(a aVar) {
                this.cpl = aVar;
                return this;
            }

            public a iG(int i) {
                this.cpn = i;
                return this;
            }

            public b anH() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.anH();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.iG(i);
            return aVar2.anH();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener cpk;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.cpk = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int biT;
        final int cpi;
        final ImgType cpo;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.cpo = aVar.cpo;
            this.biT = aVar.biT;
            this.cpi = aVar.cpi;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType cpo = ImgType.NONE;
            private int biT = -1;
            private int cpi = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.cpo = imgType;
                return this;
            }

            public a iH(int i) {
                this.biT = i;
                return this;
            }

            public a iI(int i) {
                this.cpi = i;
                return this;
            }

            public a iJ(int i) {
                this.mHeight = i;
                return this;
            }

            public a iK(int i) {
                this.mWidth = i;
                return this;
            }

            public c anI() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iH(i);
            return aVar.anI();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.iI(i);
            aVar.iH(i2);
            aVar.iJ(i3);
            aVar.iK(i4);
            return aVar.anI();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.anI();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String bYL;
        final String cpp;
        final int cpq;
        final int cpr;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.bYL = aVar.bYL;
            this.cpp = aVar.cpp;
            this.cpq = aVar.cps;
            this.cpr = aVar.cpr;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String bYL = null;
            private String cpp = null;
            private int cps = -1;
            private int cpr = 0;

            public a ox(String str) {
                this.mTitle = str;
                return this;
            }

            public a oy(String str) {
                this.bYL = str;
                return this;
            }

            public a iM(int i) {
                this.cps = i;
                return this;
            }

            public d anJ() {
                return new d(this);
            }
        }

        public static d aj(int i, int i2) {
            a aVar = new a();
            aVar.oy(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.iM(i2);
            return aVar.anJ();
        }

        public static d iL(int i) {
            return ow(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d ak(int i, int i2) {
            return bU(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d ow(String str) {
            a aVar = new a();
            aVar.oy(str);
            return aVar.anJ();
        }

        public static d bU(String str, String str2) {
            a aVar = new a();
            aVar.oy(str);
            aVar.ox(str2);
            return aVar.anJ();
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
