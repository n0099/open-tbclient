package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class NoDataViewFactory {

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View.OnClickListener f12256a;

        /* renamed from: b  reason: collision with root package name */
        public String f12257b;

        public b(String str, View.OnClickListener onClickListener) {
            this.f12257b = str;
            this.f12256a = onClickListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f12258a;

        /* renamed from: b  reason: collision with root package name */
        public final b f12259b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12260c;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public b f12261a = null;

            /* renamed from: b  reason: collision with root package name */
            public b f12262b = null;

            /* renamed from: c  reason: collision with root package name */
            public int f12263c = -1;

            public a d(int i2) {
                this.f12263c = i2;
                return this;
            }

            public c e() {
                return new c(this);
            }

            public a f(b bVar) {
                this.f12261a = bVar;
                return this;
            }
        }

        public static c a(b bVar) {
            a aVar = new a();
            aVar.f(bVar);
            return aVar.e();
        }

        public static c b(b bVar, int i2) {
            a aVar = new a();
            aVar.f(bVar);
            aVar.d(i2);
            return aVar.e();
        }

        public c(a aVar) {
            this.f12258a = aVar.f12261a;
            this.f12259b = aVar.f12262b;
            this.f12260c = aVar.f12263c;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ImgType f12264a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12265b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12266c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12267d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12268e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public ImgType f12269a = ImgType.NONE;

            /* renamed from: b  reason: collision with root package name */
            public int f12270b = -1;

            /* renamed from: c  reason: collision with root package name */
            public int f12271c = -1;

            /* renamed from: d  reason: collision with root package name */
            public int f12272d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f12273e = -1;

            public d f() {
                return new d(this);
            }

            public a g(int i2) {
                this.f12272d = i2;
                return this;
            }

            public a h(int i2) {
                this.f12271c = i2;
                return this;
            }

            public a i(ImgType imgType) {
                this.f12269a = imgType;
                return this;
            }

            public a j(int i2) {
                this.f12270b = i2;
                return this;
            }

            public a k(int i2) {
                this.f12273e = i2;
                return this;
            }
        }

        public static d a(ImgType imgType) {
            a aVar = new a();
            aVar.i(imgType);
            return aVar.f();
        }

        public static d b(ImgType imgType, int i2) {
            a aVar = new a();
            aVar.i(imgType);
            aVar.j(i2);
            return aVar.f();
        }

        public static d c(ImgType imgType, int i2, int i3, int i4, int i5) {
            a aVar = new a();
            aVar.i(imgType);
            aVar.h(i2);
            aVar.j(i3);
            aVar.g(i4);
            aVar.k(i5);
            return aVar.f();
        }

        public d(a aVar) {
            this.f12264a = aVar.f12269a;
            this.f12265b = aVar.f12270b;
            this.f12266c = aVar.f12271c;
            this.f12267d = aVar.f12272d;
            this.f12268e = aVar.f12273e;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f12274a;

        /* renamed from: b  reason: collision with root package name */
        public final String f12275b;

        /* renamed from: c  reason: collision with root package name */
        public final String f12276c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12277d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12278e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f12279a = null;

            /* renamed from: b  reason: collision with root package name */
            public String f12280b = null;

            /* renamed from: c  reason: collision with root package name */
            public String f12281c = null;

            /* renamed from: d  reason: collision with root package name */
            public int f12282d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f12283e = 0;

            public e f() {
                return new e(this);
            }

            public a g(String str) {
                this.f12280b = str;
                return this;
            }

            public a h(String str) {
                this.f12279a = str;
                return this;
            }

            public a i(int i2) {
                this.f12282d = i2;
                return this;
            }
        }

        public static e a(int i2) {
            return c(TbadkCoreApplication.getInst().getResources().getString(i2));
        }

        public static e b(int i2, int i3) {
            return d(TbadkCoreApplication.getInst().getResources().getString(i2), TbadkCoreApplication.getInst().getResources().getString(i3));
        }

        public static e c(String str) {
            a aVar = new a();
            aVar.g(str);
            return aVar.f();
        }

        public static e d(String str, String str2) {
            a aVar = new a();
            aVar.g(str);
            aVar.h(str2);
            return aVar.f();
        }

        public static e e(int i2, int i3) {
            a aVar = new a();
            aVar.g(TbadkCoreApplication.getInst().getResources().getString(i2));
            aVar.i(i3);
            return aVar.f();
        }

        public e(a aVar) {
            this.f12274a = aVar.f12279a;
            this.f12275b = aVar.f12280b;
            this.f12276c = aVar.f12281c;
            this.f12277d = aVar.f12282d;
            this.f12278e = aVar.f12283e;
        }
    }

    public static NoDataView a(Context context, View view, d dVar, e eVar, c cVar) {
        return b(context, view, dVar, eVar, cVar, false);
    }

    public static NoDataView b(Context context, View view, d dVar, e eVar, c cVar, boolean z) {
        NoDataView noDataView = new NoDataView(context);
        noDataView.c(cVar, dVar, eVar);
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
