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
        final a eTq;
        final a eTr;
        final int eTs;

        private b(a aVar) {
            this.eTq = aVar.eTq;
            this.eTr = aVar.eTr;
            this.eTs = aVar.eTs;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a eTq = null;
            private a eTr = null;
            private int eTs = -1;

            public a b(a aVar) {
                this.eTq = aVar;
                return this;
            }

            public a qj(int i) {
                this.eTs = i;
                return this;
            }

            public b brE() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.brE();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.qj(i);
            return aVar2.brE();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener eTp;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.eTp = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int eTh;
        final ImgType eTt;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.eTt = aVar.eTt;
            this.mMarginTop = aVar.mMarginTop;
            this.eTh = aVar.eTh;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType eTt = ImgType.NONE;
            private int mMarginTop = -1;
            private int eTh = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.eTt = imgType;
                return this;
            }

            public a qk(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a ql(int i) {
                this.eTh = i;
                return this;
            }

            public a qm(int i) {
                this.mHeight = i;
                return this;
            }

            public a qn(int i) {
                this.mWidth = i;
                return this;
            }

            public c brF() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.qk(i);
            return aVar.brF();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.ql(i);
            aVar.qk(i2);
            aVar.qm(i3);
            aVar.qn(i4);
            return aVar.brF();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.brF();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String eTu;
        final int eTv;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.eTu = aVar.eTu;
            this.eTv = aVar.eTw;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String eTu = null;
            private int eTw = -1;
            private int mDrawableId = 0;

            public a BR(String str) {
                this.mTitle = str;
                return this;
            }

            public a BS(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a qp(int i) {
                this.eTw = i;
                return this;
            }

            public d brG() {
                return new d(this);
            }
        }

        public static d aX(int i, int i2) {
            a aVar = new a();
            aVar.BS(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.qp(i2);
            return aVar.brG();
        }

        public static d qo(int i) {
            return BQ(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aY(int i, int i2) {
            return dS(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d BQ(String str) {
            a aVar = new a();
            aVar.BS(str);
            return aVar.brG();
        }

        public static d dS(String str, String str2) {
            a aVar = new a();
            aVar.BS(str);
            aVar.BR(str2);
            return aVar.brG();
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
