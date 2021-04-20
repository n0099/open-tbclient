package a.a.a.a.r.a.b;

import a.a.a.a.s.e;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.List;
/* loaded from: classes.dex */
public class p extends d {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.FeedAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1137a;

        public a(String str) {
            this.f1137a = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("CSJNative onError code: " + i + ", message: " + str, new Object[0]);
            p.this.f1010g.a(Integer.valueOf(i));
            p.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                p.this.f1010g.b();
                TTFeedAd tTFeedAd = list.get(0);
                p pVar = p.this;
                pVar.a((p) tTFeedAd);
                pVar.h();
                p.this.k.b(tTFeedAd, this.f1137a);
                return;
            }
            p.this.f1010g.a("NoFill");
            a.a.a.a.v.d.b("onFeedAdLoad error: adList is null or empty", new Object[0]);
            onError(0, "NoFill");
        }
    }

    public p(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.r.a.b.d
    public void a(String str) {
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f1011h.f1320c).setSupportDeepLink(true);
        e.a aVar = this.f1011h;
        this.m.loadFeedAd(supportDeepLink.setImageAcceptedSize(aVar.f1324g, aVar.f1325h).setAdCount(1).build(), new a(str));
    }
}
