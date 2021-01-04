package com.baidu.platform.comapi.walknavi.g.d;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.util.Log;
import com.baidu.mapapi.bikenavi.model.a;
import com.baidu.mapapi.walknavi.model.a;
import com.baidu.platform.comapi.bikenavi.widget.h;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes15.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private a.c f4555a;

    /* renamed from: b  reason: collision with root package name */
    private a.b f4556b;
    private a.C0259a c;
    private a.c d;
    private a.b e;
    private a.C0258a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final d f4557a = new d();
    }

    public static d a() {
        return a.f4557a;
    }

    private d() {
        this.f4555a = null;
        this.f4556b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public boolean a(Activity activity, int i, int i2, com.baidu.platform.comapi.walknavi.g.c.b bVar) {
        a(i);
        if (activity == null) {
            Log.i("CustomWNaviView", "Current Activity is null");
            return false;
        }
        XmlResourceParser layout = activity.getResources().getLayout(i2);
        if (layout == null) {
            Log.i("CustomWNaviView", "Load parser layout resource failed.");
            return false;
        }
        try {
            for (int eventType = layout.getEventType(); eventType != 1; eventType = layout.next()) {
                switch (eventType) {
                    case 0:
                        Log.i("CustomWNaviView", "START_DOCUMENT - " + layout.getName());
                        break;
                    case 2:
                        Log.i("CustomWNaviView", "START_TAG -- " + layout.getName());
                        a(layout, layout.getAttributeCount(), i);
                        break;
                    case 3:
                        Log.i("CustomWNaviView", "END_TAG --" + layout.getName());
                        break;
                }
            }
            Log.i("CustomWNaviView", "END_DOCUMENT - " + layout.getName());
            a(i, bVar);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("CustomWNaviView", "layout parser failed.");
            return false;
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
            Log.i("CustomWNaviView", "layout parser failed.");
            return false;
        }
    }

    private void a(int i) {
        if (i > 0) {
            switch (i) {
                case 1:
                    this.f4555a = new a.c();
                    return;
                case 2:
                    this.f4556b = new a.b();
                    return;
                case 3:
                    this.c = new a.C0259a();
                    return;
                case 4:
                    this.d = new a.c();
                    return;
                case 5:
                    this.e = new a.b();
                    return;
                case 6:
                    this.f = new a.C0258a();
                    return;
                default:
                    return;
            }
        }
    }

    public void a(int i, com.baidu.platform.comapi.walknavi.g.c.b bVar) {
        if (i > 0 && bVar != null) {
            switch (i) {
                case 1:
                    ((com.baidu.platform.comapi.walknavi.widget.d) bVar).a(this.f4555a);
                    return;
                case 2:
                    ((com.baidu.platform.comapi.walknavi.g.c.c) bVar).a(this.f4556b);
                    return;
                case 3:
                    ((com.baidu.platform.comapi.walknavi.g.c.c) bVar).a(this.c);
                    return;
                case 4:
                    ((h) bVar).a(this.d);
                    return;
                case 5:
                    ((com.baidu.platform.comapi.bikenavi.widget.a) bVar).a(this.e);
                    return;
                case 6:
                    ((com.baidu.platform.comapi.bikenavi.widget.a) bVar).a(this.f);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(XmlPullParser xmlPullParser, int i, int i2) {
        if (xmlPullParser != null && i > 0) {
            for (int i3 = 0; i3 < i; i3++) {
                if ("tag".equals(xmlPullParser.getAttributeName(i3))) {
                    switch (i2) {
                        case 1:
                            g(xmlPullParser, i3, i2);
                            continue;
                        case 2:
                            f(xmlPullParser, i3, i2);
                            continue;
                        case 3:
                            e(xmlPullParser, i3, i2);
                            continue;
                        case 4:
                            d(xmlPullParser, i3, i2);
                            continue;
                        case 5:
                            c(xmlPullParser, i3, i2);
                            continue;
                        case 6:
                            b(xmlPullParser, i3, i2);
                            continue;
                    }
                }
            }
        }
    }

    private void b(XmlPullParser xmlPullParser, int i, int i2) {
        if (xmlPullParser != null && i >= 0 && i2 == 6 && this.f != null) {
            if ("BMSDK_IMAGE_QUIT_ICON".equals(xmlPullParser.getAttributeValue(i))) {
                this.f.a(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_LOOKOVER".equals(xmlPullParser.getAttributeValue(i))) {
                this.f.b(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_REMAIN".equals(xmlPullParser.getAttributeValue(i))) {
                this.f.c(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
        }
    }

    private void c(XmlPullParser xmlPullParser, int i, int i2) {
        if (xmlPullParser != null && i >= 0 && i2 == 5 && this.e != null) {
            if ("BMSDK_TEXT_SPEED".equals(xmlPullParser.getAttributeValue(i))) {
                this.e.a(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_SPEED_UNIT".equals(xmlPullParser.getAttributeValue(i))) {
                this.e.b(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
        }
    }

    private void d(XmlPullParser xmlPullParser, int i, int i2) {
        if (xmlPullParser != null && i >= 0 && i2 == 4 && this.d != null) {
            if ("BMSDK_LAYOUT_GPS".equals(xmlPullParser.getAttributeValue(i))) {
                this.d.b(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_IMAGE_BGUIDANCE_ICON".equals(xmlPullParser.getAttributeValue(i))) {
                this.d.a(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_BGUIDANCE_TV".equals(xmlPullParser.getAttributeValue(i))) {
                this.d.c(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_BGPS_WEAK".equals(xmlPullParser.getAttributeValue(i))) {
                this.d.d(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_BGPS_HINT".equals(xmlPullParser.getAttributeValue(i))) {
                this.d.e(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
        }
    }

    private void e(XmlPullParser xmlPullParser, int i, int i2) {
        if (xmlPullParser != null && i >= 0 && i2 == 3 && this.c != null) {
            if ("BMSDK_LAYOUT_BOTSET_QUIT".equals(xmlPullParser.getAttributeValue(i))) {
                this.c.a(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_IMAGE_QUIT_ICON".equals(xmlPullParser.getAttributeValue(i))) {
                this.c.b(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_QUIT_TV".equals(xmlPullParser.getAttributeValue(i))) {
                this.c.c(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_LOOKOVER".equals(xmlPullParser.getAttributeValue(i))) {
                this.c.d(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_REMAIN_CONTENT".equals(xmlPullParser.getAttributeValue(i))) {
                this.c.e(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
        }
    }

    private void f(XmlPullParser xmlPullParser, int i, int i2) {
        if (xmlPullParser != null && i >= 0 && i2 == 2 && this.f4556b != null) {
            if ("BMSDK_LAYOUT_CALORIE".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4556b.a(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_CALORIE_HINT".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4556b.b(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_IMAGE_CALORIE_ICON".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4556b.c(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_CONSUME_CALORIE_TIMES".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4556b.d(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_LAYOUT_CALORIE_BTN".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4556b.e(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_CALORIE_NUMBER".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4556b.f(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_CALORIE_UNIT".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4556b.g(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
        }
    }

    private void g(XmlPullParser xmlPullParser, int i, int i2) {
        if (xmlPullParser != null && i >= 0 && i2 == 1 && this.f4555a != null) {
            if ("BMSDK_LAYOUT_GUIDE".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4555a.a(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_LAYOUT_GUIDE".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4555a.b(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "background"));
            }
            if ("BMSDK_IMAGE_IVICON".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4555a.c(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_LAYOUT_GPS_WEAK".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4555a.d(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_GUIDE_REMAIN".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4555a.e(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_GUIDE".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4555a.f(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_GPS_WEAK".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4555a.g(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
            if ("BMSDK_TEXT_GPS_HINT".equals(xmlPullParser.getAttributeValue(i))) {
                this.f4555a.h(xmlPullParser.getAttributeValue(xmlPullParser.getAttributeNamespace(i), "id"));
            }
        }
    }
}
