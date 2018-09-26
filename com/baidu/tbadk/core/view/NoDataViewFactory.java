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
        final a ayQ;
        final a ayR;
        final int ayS;

        private b(a aVar) {
            this.ayQ = aVar.ayQ;
            this.ayR = aVar.ayR;
            this.ayS = aVar.ayS;
        }

        /* loaded from: classes.dex */
        public static class a {
            private a ayQ = null;
            private a ayR = null;
            private int ayS = -1;

            public a b(a aVar) {
                this.ayQ = aVar;
                return this;
            }

            public a dz(int i) {
                this.ayS = i;
                return this;
            }

            public b BA() {
                return new b(this);
            }
        }

        public static b a(a aVar) {
            a aVar2 = new a();
            aVar2.b(aVar);
            return aVar2.BA();
        }

        public static b a(a aVar, int i) {
            a aVar2 = new a();
            aVar2.b(aVar);
            aVar2.dz(i);
            return aVar2.BA();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        String aqV;
        View.OnClickListener ayP;

        public a(String str, View.OnClickListener onClickListener) {
            this.aqV = str;
            this.ayP = onClickListener;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        final int ayN;
        final ImgType ayT;
        final int ayU;
        final int mHeight;
        final int mWidth;

        private c(a aVar) {
            this.ayT = aVar.ayT;
            this.ayU = aVar.ayU;
            this.ayN = aVar.ayN;
            this.mHeight = aVar.mHeight;
            this.mWidth = aVar.mWidth;
        }

        /* loaded from: classes.dex */
        public static class a {
            private ImgType ayT = ImgType.NONE;
            private int ayU = -1;
            private int ayN = -1;
            private int mHeight = -1;
            private int mWidth = -1;

            public a b(ImgType imgType) {
                this.ayT = imgType;
                return this;
            }

            public a dA(int i) {
                this.ayU = i;
                return this;
            }

            public a dB(int i) {
                this.ayN = i;
                return this;
            }

            public a dC(int i) {
                this.mHeight = i;
                return this;
            }

            public a dD(int i) {
                this.mWidth = i;
                return this;
            }

            public c BB() {
                return new c(this);
            }
        }

        public static c a(ImgType imgType, int i) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dA(i);
            return aVar.BB();
        }

        public static c a(ImgType imgType, int i, int i2, int i3, int i4) {
            a aVar = new a();
            aVar.b(imgType);
            aVar.dB(i);
            aVar.dA(i2);
            aVar.dC(i3);
            aVar.dD(i4);
            return aVar.BB();
        }

        public static c a(ImgType imgType) {
            a aVar = new a();
            aVar.b(imgType);
            return aVar.BB();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        final String ahH;
        final String ayV;
        final int ayW;
        final int ayX;
        final String mTitle;

        private d(a aVar) {
            this.mTitle = aVar.mTitle;
            this.ahH = aVar.ahH;
            this.ayV = aVar.ayV;
            this.ayW = aVar.ayY;
            this.ayX = aVar.ayX;
        }

        /* loaded from: classes.dex */
        public static class a {
            private String mTitle = null;
            private String ahH = null;
            private String ayV = null;
            private int ayY = -1;
            private int ayX = 0;

            public a fH(String str) {
                this.mTitle = str;
                return this;
            }

            public a fI(String str) {
                this.ahH = str;
                return this;
            }

            public a dF(int i) {
                this.ayY = i;
                return this;
            }

            public d BC() {
                return new d(this);
            }
        }

        public static d F(int i, int i2) {
            a aVar = new a();
            aVar.fI(TbadkCoreApplication.getInst().getResources().getString(i));
            aVar.dF(i2);
            return aVar.BC();
        }

        public static d dE(int i) {
            return fG(TbadkCoreApplication.getInst().getResources().getString(i));
        }

        public static d G(int i, int i2) {
            return ao(TbadkCoreApplication.getInst().getResources().getString(i), TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static d fG(String str) {
            a aVar = new a();
            aVar.fI(str);
            return aVar.BC();
        }

        public static d ao(String str, String str2) {
            a aVar = new a();
            aVar.fI(str);
            aVar.fH(str2);
            return aVar.BC();
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
