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
        LOCAL
    }

    /* loaded from: classes.dex */
    public static class b {
        final a alW;
        final a alX;
        final int alY;

        private b(a aVar) {
            this.alW = aVar.alW;
            this.alX = aVar.alX;
            this.alY = aVar.alY;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a alW = null;
            private a alX = null;
            private int alY = -1;

            public a b(a aVar) {
                this.alW = aVar;
                return this;
            }

            public a dl(int i) {
                this.alY = i;
                return this;
            }

            public b wm() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.wm();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dl(i);
            return aVar2.wm();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String afc;
        View.OnClickListener alV;

        public a(String str, View.OnClickListener onClickListener) {
            this.afc = str;
            this.alV = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int alT;
        final ImgType alZ;
        final int ama;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.alZ = aVar.alZ;
            this.ama = aVar.ama;
            this.alT = aVar.alT;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType alZ = ImgType.NONE;
            private int ama = -1;
            private int alT = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.alZ = imgType;
                return this;
            }

            public a dm(int i) {
                this.ama = i;
                return this;
            }

            public a dn(int i) {
                this.alT = i;
                return this;
            }

            /* renamed from: do  reason: not valid java name */
            public a m10do(int i) {
                this.mHeight = i;
                return this;
            }

            public a dp(int i) {
                this.mWidth = i;
                return this;
            }

            public c wn() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dm(i);
            return aVar.wn();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dn(i);
            aVar.dm(i2);
            aVar.m10do(i3);
            aVar.dp(i4);
            return aVar.wn();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.wn();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String Wp;
        final String amc;
        final int amd;
        final int ame;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.Wp = aVar.Wp;
            this.amc = aVar.amc;
            this.amd = aVar.amf;
            this.ame = aVar.ame;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String Wp = null;
            private String amc = null;
            private int amf = -1;
            private int ame = 0;

            public a eu(String str) {
                this.mTitle = str;
                return this;
            }

            public a ev(String str) {
                this.Wp = str;
                return this;
            }

            public a dr(int i) {
                this.amf = i;
                return this;
            }

            public a ds(int i) {
                this.ame = i;
                return this;
            }

            public d wo() {
                return new d(this);
            }
        }

        public static d C(int i, int i2) {
            a aVar = new a();
            aVar.ev(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.dr(i2);
            return aVar.wo();
        }

        public static d dq(int i) {
            return et(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d D(int i, int i2) {
            return af(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d et(String str) {
            a aVar = new a();
            aVar.ev(str);
            return aVar.wo();
        }

        public static d af(String str, String str2) {
            a aVar = new a();
            aVar.ev(str);
            aVar.eu(str2);
            return aVar.wo();
        }

        public static d b(int i, String str, String str2) {
            a aVar = new a();
            aVar.ev(str);
            aVar.eu(str2);
            aVar.ds(i);
            return aVar.wo();
        }
    }

    public static g a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static g a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        g gVar = new g(context);
        gVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(gVar, 0);
                } else {
                    relativeLayout.addView(gVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                gVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(gVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.getLayoutParams();
                layoutParams2.gravity = 1;
                gVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(gVar, 0);
            }
        }
        gVar.setVisibility(8);
        return gVar;
    }
}
