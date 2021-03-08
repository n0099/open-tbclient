package a.a.a.a.r.a.c;

import a.a.a.a.a.e;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.List;
/* loaded from: classes4.dex */
public class p extends d {
    public p(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.r.a.c.d
    public void a(String str) {
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.zl.c).setSupportDeepLink(true);
        e.a aVar = this.zl;
        this.Ae.loadFeedAd(supportDeepLink.setImageAcceptedSize(aVar.g, aVar.h).setAdCount(1).build(), new a(str));
    }

    /* loaded from: classes4.dex */
    public class a implements TTAdNative.FeedAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f979a;

        public a(String str) {
            this.f979a = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            a.a.a.a.v.d.b("CSJNative onError code: " + i + ", message: " + str, new Object[0]);
            p.this.zk.a(Integer.valueOf(i));
            p.this.b(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            a.a.a.a.v.d.a();
            if (list != null && !list.isEmpty()) {
                p.this.zk.b();
                TTFeedAd tTFeedAd = list.get(0);
                p pVar = p.this;
                pVar.a((p) tTFeedAd);
                pVar.h();
                p.this.zm.b(tTFeedAd, this.f979a);
                return;
            }
            p.this.zk.a("NoFill");
            a.a.a.a.v.d.b("onFeedAdLoad error: adList is null or empty", new Object[0]);
            onError(0, "NoFill");
        }
    }
}
