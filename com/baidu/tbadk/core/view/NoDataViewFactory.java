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
        public View.OnClickListener f12348a;

        /* renamed from: b  reason: collision with root package name */
        public String f12349b;

        public b(String str, View.OnClickListener onClickListener) {
            this.f12349b = str;
            this.f12348a = onClickListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f12350a;

        /* renamed from: b  reason: collision with root package name */
        public final b f12351b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12352c;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public b f12353a = null;

            /* renamed from: b  reason: collision with root package name */
            public b f12354b = null;

            /* renamed from: c  reason: collision with root package name */
            public int f12355c = -1;

            public a d(int i2) {
                this.f12355c = i2;
                return this;
            }

            public c e() {
                return new c(this);
            }

            public a f(b bVar) {
                this.f12353a = bVar;
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
            this.f12350a = aVar.f12353a;
            this.f12351b = aVar.f12354b;
            this.f12352c = aVar.f12355c;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ImgType f12356a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12357b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12358c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12359d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12360e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public ImgType f12361a = ImgType.NONE;

            /* renamed from: b  reason: collision with root package name */
            public int f12362b = -1;

            /* renamed from: c  reason: collision with root package name */
            public int f12363c = -1;

            /* renamed from: d  reason: collision with root package name */
            public int f12364d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f12365e = -1;

            public d f() {
                return new d(this);
            }

            public a g(int i2) {
                this.f12364d = i2;
                return this;
            }

            public a h(int i2) {
                this.f12363c = i2;
                return this;
            }

            public a i(ImgType imgType) {
                this.f12361a = imgType;
                return this;
            }

            public a j(int i2) {
                this.f12362b = i2;
                return this;
            }

            public a k(int i2) {
                this.f12365e = i2;
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
            this.f12356a = aVar.f12361a;
            this.f12357b = aVar.f12362b;
            this.f12358c = aVar.f12363c;
            this.f12359d = aVar.f12364d;
            this.f12360e = aVar.f12365e;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f12366a;

        /* renamed from: b  reason: collision with root package name */
        public final String f12367b;

        /* renamed from: c  reason: collision with root package name */
        public final String f12368c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12369d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12370e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f12371a = null;

            /* renamed from: b  reason: collision with root package name */
            public String f12372b = null;

            /* renamed from: c  reason: collision with root package name */
            public String f12373c = null;

            /* renamed from: d  reason: collision with root package name */
            public int f12374d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f12375e = 0;

            public e f() {
                return new e(this);
            }

            public a g(String str) {
                this.f12372b = str;
                return this;
            }

            public a h(String str) {
                this.f12371a = str;
                return this;
            }

            public a i(int i2) {
                this.f12374d = i2;
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
            this.f12366a = aVar.f12371a;
            this.f12367b = aVar.f12372b;
            this.f12368c = aVar.f12373c;
            this.f12369d = aVar.f12374d;
            this.f12370e = aVar.f12375e;
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
