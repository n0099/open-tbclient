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
        final a ehN;
        final a ehO;
        final int ehP;

        private b(a aVar) {
            this.ehN = aVar.ehN;
            this.ehO = aVar.ehO;
            this.ehP = aVar.ehP;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a ehN = null;
            private a ehO = null;
            private int ehP = -1;

            public a b(a aVar) {
                this.ehN = aVar;
                return this;
            }

            public a mA(int i) {
                this.ehP = i;
                return this;
            }

            public b bbV() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.bbV();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.mA(i);
            return aVar2.bbV();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener ehM;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.ehM = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int ehK;
        final ImgType ehQ;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.ehQ = aVar.ehQ;
            this.mMarginTop = aVar.mMarginTop;
            this.ehK = aVar.ehK;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType ehQ = ImgType.NONE;
            private int mMarginTop = -1;
            private int ehK = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.ehQ = imgType;
                return this;
            }

            public a mB(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a mC(int i) {
                this.ehK = i;
                return this;
            }

            public a mD(int i) {
                this.mHeight = i;
                return this;
            }

            public a mE(int i) {
                this.mWidth = i;
                return this;
            }

            public c bbW() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.mB(i);
            return aVar.bbW();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.mC(i);
            aVar.mB(i2);
            aVar.mD(i3);
            aVar.mE(i4);
            return aVar.bbW();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.bbW();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String ehR;
        final int ehS;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.ehR = aVar.ehR;
            this.ehS = aVar.ehT;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String ehR = null;
            private int ehT = -1;
            private int mDrawableId = 0;

            public a yo(String str) {
                this.mTitle = str;
                return this;
            }

            public a yp(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a mG(int i) {
                this.ehT = i;
                return this;
            }

            public d bbX() {
                return new d(this);
            }
        }

        public static d aP(int i, int i2) {
            a aVar = new a();
            aVar.yp(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.mG(i2);
            return aVar.bbX();
        }

        public static d mF(int i) {
            return yn(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aQ(int i, int i2) {
            return m31do(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d yn(String str) {
            a aVar = new a();
            aVar.yp(str);
            return aVar.bbX();
        }

        /* renamed from: do  reason: not valid java name */
        public static d m31do(String str, String str2) {
            a aVar = new a();
            aVar.yp(str);
            aVar.yo(str2);
            return aVar.bbX();
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
