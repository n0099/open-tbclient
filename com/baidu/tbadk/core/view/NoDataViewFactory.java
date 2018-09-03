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
        final a avE;
        final a avF;
        final int avG;

        private b(a aVar) {
            this.avE = aVar.avE;
            this.avF = aVar.avF;
            this.avG = aVar.avG;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a avE = null;
            private a avF = null;
            private int avG = -1;

            public a b(a aVar) {
                this.avE = aVar;
                return this;
            }

            /* renamed from: do  reason: not valid java name */
            public a m14do(int i) {
                this.avG = i;
                return this;
            }

            public b Am() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.Am();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.m14do(i);
            return aVar2.Am();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aop;
        View.OnClickListener avD;

        public a(String str, View.OnClickListener onClickListener) {
            this.aop = str;
            this.avD = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int avB;
        final ImgType avH;
        final int avI;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.avH = aVar.avH;
            this.avI = aVar.avI;
            this.avB = aVar.avB;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType avH = ImgType.NONE;
            private int avI = -1;
            private int avB = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.avH = imgType;
                return this;
            }

            public a dp(int i) {
                this.avI = i;
                return this;
            }

            public a dq(int i) {
                this.avB = i;
                return this;
            }

            public a dr(int i) {
                this.mHeight = i;
                return this;
            }

            public a ds(int i) {
                this.mWidth = i;
                return this;
            }

            public c An() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dp(i);
            return aVar.An();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dq(i);
            aVar.dp(i2);
            aVar.dr(i3);
            aVar.ds(i4);
            return aVar.An();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.An();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String afg;
        final String avJ;
        final int avK;
        final int avL;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.afg = aVar.afg;
            this.avJ = aVar.avJ;
            this.avK = aVar.avM;
            this.avL = aVar.avL;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String afg = null;
            private String avJ = null;
            private int avM = -1;
            private int avL = 0;

            public a fn(String str) {
                this.mTitle = str;
                return this;
            }

            public a fo(String str) {
                this.afg = str;
                return this;
            }

            public a du(int i) {
                this.avM = i;
                return this;
            }

            public d Ao() {
                return new d(this);
            }
        }

        public static d D(int i, int i2) {
            a aVar = new a();
            aVar.fo(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.du(i2);
            return aVar.Ao();
        }

        public static d dt(int i) {
            return fm(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d E(int i, int i2) {
            return ag(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d fm(String str) {
            a aVar = new a();
            aVar.fo(str);
            return aVar.Ao();
        }

        public static d ag(String str, String str2) {
            a aVar = new a();
            aVar.fo(str);
            aVar.fn(str2);
            return aVar.Ao();
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
