package a.a.a.a.t.a.b;

import a.a.a.a.u.e;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.List;
/* loaded from: classes.dex */
public class r extends d {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.FeedAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1154a;

        public a(String str) {
            this.f1154a = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.a.a.a.x.d.b("CSJNative onError code: " + i2 + ", message: " + str, new Object[0]);
            r.this.f1013g.a(Integer.valueOf(i2));
            r.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            a.a.a.a.x.d.a();
            if (list != null && !list.isEmpty()) {
                r.this.f1013g.b();
                TTFeedAd tTFeedAd = list.get(0);
                r rVar = r.this;
                rVar.a((r) tTFeedAd);
                rVar.h();
                r.this.k.b(tTFeedAd, this.f1154a);
                return;
            }
            r.this.f1013g.a("NoFill");
            a.a.a.a.x.d.b("onFeedAdLoad error: adList is null or empty", new Object[0]);
            onError(0, "NoFill");
        }
    }

    public r(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.t.a.b.d
    public void a(String str) {
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f1014h.f1334c).setSupportDeepLink(true);
        e.a aVar = this.f1014h;
        this.m.loadFeedAd(supportDeepLink.setImageAcceptedSize(aVar.f1338g, aVar.f1339h).setAdCount(1).build(), new a(str));
    }
}
