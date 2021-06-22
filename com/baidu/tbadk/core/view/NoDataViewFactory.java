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
        public View.OnClickListener f12400a;

        /* renamed from: b  reason: collision with root package name */
        public String f12401b;

        public b(String str, View.OnClickListener onClickListener) {
            this.f12401b = str;
            this.f12400a = onClickListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f12402a;

        /* renamed from: b  reason: collision with root package name */
        public final b f12403b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12404c;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public b f12405a = null;

            /* renamed from: b  reason: collision with root package name */
            public b f12406b = null;

            /* renamed from: c  reason: collision with root package name */
            public int f12407c = -1;

            public a d(int i2) {
                this.f12407c = i2;
                return this;
            }

            public c e() {
                return new c(this);
            }

            public a f(b bVar) {
                this.f12405a = bVar;
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
            this.f12402a = aVar.f12405a;
            this.f12403b = aVar.f12406b;
            this.f12404c = aVar.f12407c;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ImgType f12408a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12409b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12410c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12411d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12412e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public ImgType f12413a = ImgType.NONE;

            /* renamed from: b  reason: collision with root package name */
            public int f12414b = -1;

            /* renamed from: c  reason: collision with root package name */
            public int f12415c = -1;

            /* renamed from: d  reason: collision with root package name */
            public int f12416d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f12417e = -1;

            public d f() {
                return new d(this);
            }

            public a g(int i2) {
                this.f12416d = i2;
                return this;
            }

            public a h(int i2) {
                this.f12415c = i2;
                return this;
            }

            public a i(ImgType imgType) {
                this.f12413a = imgType;
                return this;
            }

            public a j(int i2) {
                this.f12414b = i2;
                return this;
            }

            public a k(int i2) {
                this.f12417e = i2;
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
            this.f12408a = aVar.f12413a;
            this.f12409b = aVar.f12414b;
            this.f12410c = aVar.f12415c;
            this.f12411d = aVar.f12416d;
            this.f12412e = aVar.f12417e;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f12418a;

        /* renamed from: b  reason: collision with root package name */
        public final String f12419b;

        /* renamed from: c  reason: collision with root package name */
        public final String f12420c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12421d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12422e;

        /* loaded from: classes3.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f12423a = null;

            /* renamed from: b  reason: collision with root package name */
            public String f12424b = null;

            /* renamed from: c  reason: collision with root package name */
            public String f12425c = null;

            /* renamed from: d  reason: collision with root package name */
            public int f12426d = -1;

            /* renamed from: e  reason: collision with root package name */
            public int f12427e = 0;

            public e f() {
                return new e(this);
            }

            public a g(String str) {
                this.f12424b = str;
                return this;
            }

            public a h(String str) {
                this.f12423a = str;
                return this;
            }

            public a i(int i2) {
                this.f12426d = i2;
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
            this.f12418a = aVar.f12423a;
            this.f12419b = aVar.f12424b;
            this.f12420c = aVar.f12425c;
            this.f12421d = aVar.f12426d;
            this.f12422e = aVar.f12427e;
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
