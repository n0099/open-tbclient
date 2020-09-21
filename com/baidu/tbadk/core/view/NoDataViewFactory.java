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
        final a etN;
        final a etO;
        final int etP;

        private b(a aVar) {
            this.etN = aVar.etN;
            this.etO = aVar.etO;
            this.etP = aVar.etP;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a etN = null;
            private a etO = null;
            private int etP = -1;

            public a b(a aVar) {
                this.etN = aVar;
                return this;
            }

            public a oR(int i) {
                this.etP = i;
                return this;
            }

            public b blm() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.blm();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.oR(i);
            return aVar2.blm();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        View.OnClickListener etM;
        String mText;

        public a(String str, View.OnClickListener onClickListener) {
            this.mText = str;
            this.etM = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int etK;
        final ImgType etQ;
        final int mHeight;
        final int mMarginTop;
        final int mWidth;

        private c(a aVar) {
            this.etQ = aVar.etQ;
            this.mMarginTop = aVar.mMarginTop;
            this.etK = aVar.etK;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType etQ = ImgType.NONE;
            private int mMarginTop = -1;
            private int etK = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.etQ = imgType;
                return this;
            }

            public a oS(int i) {
                this.mMarginTop = i;
                return this;
            }

            public a oT(int i) {
                this.etK = i;
                return this;
            }

            public a oU(int i) {
                this.mHeight = i;
                return this;
            }

            public a oV(int i) {
                this.mWidth = i;
                return this;
            }

            public c bln() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.oS(i);
            return aVar.bln();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.oT(i);
            aVar.oS(i2);
            aVar.oU(i3);
            aVar.oV(i4);
            return aVar.bln();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.bln();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String etR;
        final int etS;
        final int mDrawableId;
        final String mSubTitle;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.mSubTitle = aVar.mSubTitle;
            this.etR = aVar.etR;
            this.etS = aVar.etT;
            this.mDrawableId = aVar.mDrawableId;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String mSubTitle = null;
            private String etR = null;
            private int etT = -1;
            private int mDrawableId = 0;

            public a AZ(String str) {
                this.mTitle = str;
                return this;
            }

            public a Ba(String str) {
                this.mSubTitle = str;
                return this;
            }

            public a oX(int i) {
                this.etT = i;
                return this;
            }

            public d blo() {
                return new d(this);
            }
        }

        public static d aX(int i, int i2) {
            a aVar = new a();
            aVar.Ba(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.oX(i2);
            return aVar.blo();
        }

        public static d oW(int i) {
            return AY(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aY(int i, int i2) {
            return dG(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d AY(String str) {
            a aVar = new a();
            aVar.Ba(str);
            return aVar.blo();
        }

        public static d dG(String str, String str2) {
            a aVar = new a();
            aVar.Ba(str);
            aVar.AZ(str2);
            return aVar.blo();
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
