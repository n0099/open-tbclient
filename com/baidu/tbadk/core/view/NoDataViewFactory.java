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
        public View.OnClickListener f12318a;

        /* renamed from: b  reason: collision with root package name */
        public String f12319b;

        public b(String str, View.OnClickListener onClickListener) {
            this.f12319b = str;
            this.f12318a = onClickListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f12320a;

        /* renamed from: b  reason: collision with root package name */
        public final b f12321b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12322c;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public b f12323a = null;

            /* renamed from: b  reason: collision with root package name */
            public b f12324b = null;

            /* renamed from: c  reason: collision with root package name */
            public int f12325c = -1;

            public a d(int i2) {
                this.f12325c = i2;
                return this;
            }

            public c e() {
                return new c(this);
            }

            public a f(b bVar) {
                this.f12323a = bVar;
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
            this.f12320a = aVar.f12323a;
            this.f12321b = aVar.f12324b;
            this.f12322c = aVar.f12325c;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ImgType f12326a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12327b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12328c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12329d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12330e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public ImgType f12331a = ImgType.NONE;

            /* renamed from: b  reason: collision with root package name */
            public int f12332b = -1;

            /* renamed from: c  reason: collision with root package name */
            public int f12333c = -1;

            /* renamed from: d  reason: collision with root package name */
            public int f12334d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f12335e = -1;

            public d f() {
                return new d(this);
            }

            public a g(int i2) {
                this.f12334d = i2;
                return this;
            }

            public a h(int i2) {
                this.f12333c = i2;
                return this;
            }

            public a i(ImgType imgType) {
                this.f12331a = imgType;
                return this;
            }

            public a j(int i2) {
                this.f12332b = i2;
                return this;
            }

            public a k(int i2) {
                this.f12335e = i2;
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
            this.f12326a = aVar.f12331a;
            this.f12327b = aVar.f12332b;
            this.f12328c = aVar.f12333c;
            this.f12329d = aVar.f12334d;
            this.f12330e = aVar.f12335e;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f12336a;

        /* renamed from: b  reason: collision with root package name */
        public final String f12337b;

        /* renamed from: c  reason: collision with root package name */
        public final String f12338c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12339d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12340e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f12341a = null;

            /* renamed from: b  reason: collision with root package name */
            public String f12342b = null;

            /* renamed from: c  reason: collision with root package name */
            public String f12343c = null;

            /* renamed from: d  reason: collision with root package name */
            public int f12344d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f12345e = 0;

            public e f() {
                return new e(this);
            }

            public a g(String str) {
                this.f12342b = str;
                return this;
            }

            public a h(String str) {
                this.f12341a = str;
                return this;
            }

            public a i(int i2) {
                this.f12344d = i2;
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
            this.f12336a = aVar.f12341a;
            this.f12337b = aVar.f12342b;
            this.f12338c = aVar.f12343c;
            this.f12339d = aVar.f12344d;
            this.f12340e = aVar.f12345e;
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
