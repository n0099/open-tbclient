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
        final a eOt;
        final a eOu;
        final int eOv;

        private b(a aVar) {
            this.eOt = aVar.eOt;
            this.eOu = aVar.eOu;
            this.eOv = aVar.eOv;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a eOt = null;
            private a eOu = null;
            private int eOv = -1;

            public a b(a aVar) {
                this.eOt = aVar;
                return this;
            }

            public a pB(int i) {
                this.eOv = i;
                return this;
            }

            public b bpP() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.bpP();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.pB(i);
            return aVar2.bpP();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener eOs;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.eOs = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int eOq;
        final ImgType eOw;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.eOw = aVar.eOw;
            this.mMarginTop = aVar.mMarginTop;
            this.eOq = aVar.eOq;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType eOw = ImgType.NONE;
            private int mMarginTop = -1;
            private int eOq = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.eOw = imgType;
                return this;
            }

            public a pC(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a pD(int i) {
                this.eOq = i;
                return this;
            }

            public a pE(int i) {
                this.mHeight = i;
                return this;
            }

            public a pF(int i) {
                this.mWidth = i;
                return this;
            }

            public c bpQ() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.pC(i);
            return aVar.bpQ();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.pD(i);
            aVar.pC(i2);
            aVar.pE(i3);
            aVar.pF(i4);
            return aVar.bpQ();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.bpQ();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String eOx;
        final int eOy;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.eOx = aVar.eOx;
            this.eOy = aVar.eOz;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String eOx = null;
            private int eOz = -1;
            private int mDrawableId = 0;

            public a Ce(String str) {
                this.mTitle = str;
                return this;
            }

            public a Cf(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a pH(int i) {
                this.eOz = i;
                return this;
            }

            public d bpR() {
                return new d(this);
            }
        }

        public static d aX(int i, int i2) {
            a aVar = new a();
            aVar.Cf(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.pH(i2);
            return aVar.bpR();
        }

        public static d pG(int i) {
            return Cd(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aY(int i, int i2) {
            return dS(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d Cd(String str) {
            a aVar = new a();
            aVar.Cf(str);
            return aVar.bpR();
        }

        public static d dS(String str, String str2) {
            a aVar = new a();
            aVar.Cf(str);
            aVar.Ce(str2);
            return aVar.bpR();
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
