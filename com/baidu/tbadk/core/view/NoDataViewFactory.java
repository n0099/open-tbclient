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
        final a bag;
        final a bah;
        final int bai;

        private b(a aVar) {
            this.bag = aVar.bag;
            this.bah = aVar.bah;
            this.bai = aVar.bai;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a bag = null;
            private a bah = null;
            private int bai = -1;

            public a b(a aVar) {
                this.bag = aVar;
                return this;
            }

            public a gi(int i) {
                this.bai = i;
                return this;
            }

            public b DD() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.DD();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.gi(i);
            return aVar2.DD();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aTs;
        View.OnClickListener baf;

        public a(String str, View.OnClickListener onClickListener) {
            this.aTs = str;
            this.baf = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int bad;
        final ImgType baj;
        final int bak;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.baj = aVar.baj;
            this.bak = aVar.bak;
            this.bad = aVar.bad;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType baj = ImgType.NONE;
            private int bak = -1;
            private int bad = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.baj = imgType;
                return this;
            }

            public a gj(int i) {
                this.bak = i;
                return this;
            }

            public a gk(int i) {
                this.bad = i;
                return this;
            }

            public a gl(int i) {
                this.mHeight = i;
                return this;
            }

            public a gm(int i) {
                this.mWidth = i;
                return this;
            }

            public c DE() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.gj(i);
            return aVar.DE();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.gk(i);
            aVar.gj(i2);
            aVar.gl(i3);
            aVar.gm(i4);
            return aVar.DE();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.DE();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String aKQ;
        final String bam;
        final int ban;
        final int bao;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.aKQ = aVar.aKQ;
            this.bam = aVar.bam;
            this.ban = aVar.bap;
            this.bao = aVar.bao;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String aKQ = null;
            private String bam = null;
            private int bap = -1;
            private int bao = 0;

            public a eJ(String str) {
                this.mTitle = str;
                return this;
            }

            public a eK(String str) {
                this.aKQ = str;
                return this;
            }

            public a go(int i) {
                this.bap = i;
                return this;
            }

            public d DF() {
                return new d(this);
            }
        }

        public static d aB(int i, int i2) {
            a aVar = new a();
            aVar.eK(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.go(i2);
            return aVar.DF();
        }

        public static d gn(int i) {
            return eI(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d aC(int i, int i2) {
            return ad(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d eI(String str) {
            a aVar = new a();
            aVar.eK(str);
            return aVar.DF();
        }

        public static d ad(String str, String str2) {
            a aVar = new a();
            aVar.eK(str);
            aVar.eJ(str2);
            return aVar.DF();
        }
    }

    public static h a(Context context, View view, c cVar, d dVar, b bVar) {
        return a(context, view, cVar, dVar, bVar, false);
    }

    public static h a(Context context, View view, c cVar, d dVar, b bVar, boolean z) {
        h hVar = new h(context);
        hVar.a(bVar, cVar, dVar);
        if (view != null) {
            if (view instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                if (z) {
                    relativeLayout.addView(hVar, 0);
                } else {
                    relativeLayout.addView(hVar);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(14);
                hVar.setLayoutParams(layoutParams);
            } else if (view instanceof LinearLayout) {
                ((LinearLayout) view).addView(hVar);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.getLayoutParams();
                layoutParams2.gravity = 1;
                hVar.setLayoutParams(layoutParams2);
            } else if (view instanceof FrameLayout) {
                ((FrameLayout) view).addView(hVar, 0);
            }
        }
        hVar.setVisibility(8);
        return hVar;
    }
}
