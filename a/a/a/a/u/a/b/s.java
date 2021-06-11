package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.fun.ad.sdk.FunAdSlot;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s extends d {

    /* loaded from: classes.dex */
    public class a implements TTAdNative.FeedAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1157a;

        public a(FunAdSlot funAdSlot) {
            this.f1157a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            a.a.a.a.y.d.b("CSJNative onError code: " + i2 + ", message: " + str, new Object[0]);
            s.this.f1014h.a(Integer.valueOf(i2));
            s.this.b(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            a.a.a.a.y.d.a();
            if (list != null && !list.isEmpty()) {
                s.this.f1014h.b();
                ArrayList arrayList = new ArrayList();
                for (TTFeedAd tTFeedAd : list) {
                    s.this.l.b(tTFeedAd, this.f1157a.getSid());
                    arrayList.add(tTFeedAd);
                }
                s.this.a((List) arrayList);
                return;
            }
            s.this.f1014h.a("NoFill");
            a.a.a.a.y.d.b("onFeedAdLoad error: adList is null or empty", new Object[0]);
            onError(0, "NoFill");
        }
    }

    public s(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.u.a.b.d
    public void a(FunAdSlot funAdSlot) {
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f1015i.f1342c).setSupportDeepLink(true);
        e.a aVar = this.f1015i;
        this.n.loadFeedAd(supportDeepLink.setImageAcceptedSize(aVar.f1346g, aVar.f1347h).setAdCount(a.a.a.a.a.a(funAdSlot.getAdCount(), 1, 3)).build(), new a(funAdSlot));
    }
}
