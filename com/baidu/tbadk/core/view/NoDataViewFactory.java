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
        final a alZ;
        final a ama;
        final int amb;

        private b(a aVar) {
            this.alZ = aVar.alZ;
            this.ama = aVar.ama;
            this.amb = aVar.amb;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a alZ = null;
            private a ama = null;
            private int amb = -1;

            public a b(a aVar) {
                this.alZ = aVar;
                return this;
            }

            public a dl(int i) {
                this.amb = i;
                return this;
            }

            public b wo() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.wo();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dl(i);
            return aVar2.wo();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String afi;
        View.OnClickListener alY;

        public a(String str, View.OnClickListener onClickListener) {
            this.afi = str;
            this.alY = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int alW;
        final ImgType amc;
        final int amd;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.amc = aVar.amc;
            this.amd = aVar.amd;
            this.alW = aVar.alW;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType amc = ImgType.NONE;
            private int amd = -1;
            private int alW = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.amc = imgType;
                return this;
            }

            public a dm(int i) {
                this.amd = i;
                return this;
            }

            public a dn(int i) {
                this.alW = i;
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

            public c wp() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dm(i);
            return aVar.wp();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dn(i);
            aVar.dm(i2);
            aVar.m10do(i3);
            aVar.dp(i4);
            return aVar.wp();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.wp();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String Wv;
        final String amf;
        final int amg;
        final int amh;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.Wv = aVar.Wv;
            this.amf = aVar.amf;
            this.amg = aVar.ami;
            this.amh = aVar.amh;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String Wv = null;
            private String amf = null;
            private int ami = -1;
            private int amh = 0;

            public a eu(String str) {
                this.mTitle = str;
                return this;
            }

            public a ev(String str) {
                this.Wv = str;
                return this;
            }

            public a dr(int i) {
                this.ami = i;
                return this;
            }

            public a ds(int i) {
                this.amh = i;
                return this;
            }

            public d wq() {
                return new d(this);
            }
        }

        public static d B(int i, int i2) {
            a aVar = new a();
            aVar.ev(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.dr(i2);
            return aVar.wq();
        }

        public static d dq(int i) {
            return et(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d C(int i, int i2) {
            return af(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d et(String str) {
            a aVar = new a();
            aVar.ev(str);
            return aVar.wq();
        }

        public static d af(String str, String str2) {
            a aVar = new a();
            aVar.ev(str);
            aVar.eu(str2);
            return aVar.wq();
        }

        public static d b(int i, String str, String str2) {
            a aVar = new a();
            aVar.ev(str);
            aVar.eu(str2);
            aVar.ds(i);
            return aVar.wq();
        }
    }

    public static f a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static f a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        f fVar = new f(context);
        fVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(fVar, 0);
                } else {
                    relativeLayout.addView(fVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                fVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(fVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fVar.getLayoutParams();
                layoutParams2.gravity = 1;
                fVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(fVar, 0);
            }
        }
        fVar.setVisibility(8);
        return fVar;
    }
}
