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
        ANTI
    }

    /* loaded from: classes.dex */
    public static class b {
        final a avG;
        final a avH;
        final int avI;

        private b(a aVar) {
            this.avG = aVar.avG;
            this.avH = aVar.avH;
            this.avI = aVar.avI;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a avG = null;
            private a avH = null;
            private int avI = -1;

            public a b(a aVar) {
                this.avG = aVar;
                return this;
            }

            public a dp(int i) {
                this.avI = i;
                return this;
            }

            public b Ao() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.Ao();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dp(i);
            return aVar2.Ao();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aoo;
        View.OnClickListener avF;

        public a(String str, View.OnClickListener onClickListener) {
            this.aoo = str;
            this.avF = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int avD;
        final ImgType avJ;
        final int avK;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.avJ = aVar.avJ;
            this.avK = aVar.avK;
            this.avD = aVar.avD;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType avJ = ImgType.NONE;
            private int avK = -1;
            private int avD = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.avJ = imgType;
                return this;
            }

            public a dq(int i) {
                this.avK = i;
                return this;
            }

            public a dr(int i) {
                this.avD = i;
                return this;
            }

            public a ds(int i) {
                this.mHeight = i;
                return this;
            }

            public a dt(int i) {
                this.mWidth = i;
                return this;
            }

            public c Ap() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dq(i);
            return aVar.Ap();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dr(i);
            aVar.dq(i2);
            aVar.ds(i3);
            aVar.dt(i4);
            return aVar.Ap();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.Ap();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String afg;
        final String avL;
        final int avM;
        final int avN;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.afg = aVar.afg;
            this.avL = aVar.avL;
            this.avM = aVar.avO;
            this.avN = aVar.avN;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String afg = null;
            private String avL = null;
            private int avO = -1;
            private int avN = 0;

            public a fn(String str) {
                this.mTitle = str;
                return this;
            }

            public a fo(String str) {
                this.afg = str;
                return this;
            }

            public a dv(int i) {
                this.avO = i;
                return this;
            }

            public d Aq() {
                return new d(this);
            }
        }

        public static d D(int i, int i2) {
            a aVar = new a();
            aVar.fo(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.dv(i2);
            return aVar.Aq();
        }

        public static d du(int i) {
            return fm(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d E(int i, int i2) {
            return ah(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d fm(String str) {
            a aVar = new a();
            aVar.fo(str);
            return aVar.Aq();
        }

        public static d ah(String str, String str2) {
            a aVar = new a();
            aVar.fo(str);
            aVar.fn(str2);
            return aVar.Aq();
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
