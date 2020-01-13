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
        final a dbT;
        final a dbU;
        final int dbV;

        private b(a aVar) {
            this.dbT = aVar.dbT;
            this.dbU = aVar.dbU;
            this.dbV = aVar.dbV;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a dbT = null;
            private a dbU = null;
            private int dbV = -1;

            public a b(a aVar) {
                this.dbT = aVar;
                return this;
            }

            public a kL(int i) {
                this.dbV = i;
                return this;
            }

            public b aFo() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.aFo();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.kL(i);
            return aVar2.aFo();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener dbS;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.dbS = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int dbQ;
        final ImgType dbW;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.dbW = aVar.dbW;
            this.mMarginTop = aVar.mMarginTop;
            this.dbQ = aVar.dbQ;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType dbW = ImgType.NONE;
            private int mMarginTop = -1;
            private int dbQ = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.dbW = imgType;
                return this;
            }

            public a kM(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a kN(int i) {
                this.dbQ = i;
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

            public c aFp() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.kM(i);
            return aVar.aFp();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.kN(i);
            aVar.kM(i2);
            aVar.kO(i3);
            aVar.kP(i4);
            return aVar.aFp();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.aFp();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String dbX;
        final int dbY;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.dbX = aVar.dbX;
            this.dbY = aVar.dbZ;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String dbX = null;
            private int dbZ = -1;
            private int mDrawableId = 0;

            public a tF(String str) {
                this.mTitle = str;
                return this;
            }

            public a tG(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a kR(int i) {
                this.dbZ = i;
                return this;
            }

            public d aFq() {
                return new d(this);
            }
        }

        public static d aE(int i, int i2) {
            a aVar = new a();
            aVar.tG(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.kR(i2);
            return aVar.aFq();
        }

        public static d kQ(int i) {
            return tE(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aF(int i, int i2) {
            return cr(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d tE(String str) {
            a aVar = new a();
            aVar.tG(str);
            return aVar.aFq();
        }

        public static d cr(String str, String str2) {
            a aVar = new a();
            aVar.tG(str);
            aVar.tF(str2);
            return aVar.aFq();
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
