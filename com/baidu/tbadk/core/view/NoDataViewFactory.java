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
        final a dbI;
        final a dbJ;
        final int dbK;

        private b(a aVar) {
            this.dbI = aVar.dbI;
            this.dbJ = aVar.dbJ;
            this.dbK = aVar.dbK;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a dbI = null;
            private a dbJ = null;
            private int dbK = -1;

            public a b(a aVar) {
                this.dbI = aVar;
                return this;
            }

            public a kL(int i) {
                this.dbK = i;
                return this;
            }

            public b aEV() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.aEV();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.kL(i);
            return aVar2.aEV();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener dbH;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.dbH = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int dbF;
        final ImgType dbL;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.dbL = aVar.dbL;
            this.mMarginTop = aVar.mMarginTop;
            this.dbF = aVar.dbF;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType dbL = ImgType.NONE;
            private int mMarginTop = -1;
            private int dbF = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.dbL = imgType;
                return this;
            }

            public a kM(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a kN(int i) {
                this.dbF = i;
                return this;
            }

            public a kO(int i) {
                this.mHeight = i;
                return this;
            }

            public a kP(int i) {
                this.mWidth = i;
                return this;
            }

            public c aEW() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.kM(i);
            return aVar.aEW();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.kN(i);
            aVar.kM(i2);
            aVar.kO(i3);
            aVar.kP(i4);
            return aVar.aEW();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.aEW();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String dbM;
        final int dbN;
        final int dbO;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.dbM = aVar.dbM;
            this.dbN = aVar.dbP;
            this.dbO = aVar.dbO;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String dbM = null;
            private int dbP = -1;
            private int dbO = 0;

            public a tB(String str) {
                this.mTitle = str;
                return this;
            }

            public a tC(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a kR(int i) {
                this.dbP = i;
                return this;
            }

            public d aEX() {
                return new d(this);
            }
        }

        public static d aA(int i, int i2) {
            a aVar = new a();
            aVar.tC(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.kR(i2);
            return aVar.aEX();
        }

        public static d kQ(int i) {
            return tA(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aB(int i, int i2) {
            return cr(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d tA(String str) {
            a aVar = new a();
            aVar.tC(str);
            return aVar.aEX();
        }

        public static d cr(String str, String str2) {
            a aVar = new a();
            aVar.tC(str);
            aVar.tB(str2);
            return aVar.aEX();
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
