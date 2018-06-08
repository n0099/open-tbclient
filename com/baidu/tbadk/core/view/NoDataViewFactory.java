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
        final a avr;
        final a avs;
        final int avt;

        private b(a aVar) {
            this.avr = aVar.avr;
            this.avs = aVar.avs;
            this.avt = aVar.avt;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a avr = null;
            private a avs = null;
            private int avt = -1;

            public a b(a aVar) {
                this.avr = aVar;
                return this;
            }

            public a dm(int i) {
                this.avt = i;
                return this;
            }

            public b Ai() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.Ai();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dm(i);
            return aVar2.Ai();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aon;
        View.OnClickListener avq;

        public a(String str, View.OnClickListener onClickListener) {
            this.aon = str;
            this.avq = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int avo;
        final ImgType avu;
        final int avv;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.avu = aVar.avu;
            this.avv = aVar.avv;
            this.avo = aVar.avo;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType avu = ImgType.NONE;
            private int avv = -1;
            private int avo = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.avu = imgType;
                return this;
            }

            public a dn(int i) {
                this.avv = i;
                return this;
            }

            /* renamed from: do  reason: not valid java name */
            public a m14do(int i) {
                this.avo = i;
                return this;
            }

            public a dp(int i) {
                this.mHeight = i;
                return this;
            }

            public a dq(int i) {
                this.mWidth = i;
                return this;
            }

            public c Aj() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dn(i);
            return aVar.Aj();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.m14do(i);
            aVar.dn(i2);
            aVar.dp(i3);
            aVar.dq(i4);
            return aVar.Aj();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.Aj();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String afx;
        final String avw;
        final int avx;
        final int avy;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.afx = aVar.afx;
            this.avw = aVar.avw;
            this.avx = aVar.avz;
            this.avy = aVar.avy;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String afx = null;
            private String avw = null;
            private int avz = -1;
            private int avy = 0;

            public a fl(String str) {
                this.mTitle = str;
                return this;
            }

            public a fm(String str) {
                this.afx = str;
                return this;
            }

            public a ds(int i) {
                this.avz = i;
                return this;
            }

            public d Ak() {
                return new d(this);
            }
        }

        public static d C(int i, int i2) {
            a aVar = new a();
            aVar.fm(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.ds(i2);
            return aVar.Ak();
        }

        public static d dr(int i) {
            return fk(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d D(int i, int i2) {
            return aj(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d fk(String str) {
            a aVar = new a();
            aVar.fm(str);
            return aVar.Ak();
        }

        public static d aj(String str, String str2) {
            a aVar = new a();
            aVar.fm(str);
            aVar.fl(str2);
            return aVar.Ak();
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
