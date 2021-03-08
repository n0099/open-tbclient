package a.a.a.a.r.a.e;

import a.a.a.a.a.e;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdSlot;
import com.win.opensdk.PBError;
import com.win.opensdk.ay;
import com.win.opensdk.az;
/* loaded from: classes4.dex */
public class c extends a.a.a.a.c<ay> {

    /* loaded from: classes4.dex */
    public class a implements az {
        public final /* synthetic */ ay Bc;

        /* renamed from: a  reason: collision with root package name */
        public boolean f993a;
        public boolean b;

        public a(ay ayVar) {
            this.Bc = ayVar;
        }

        @Override // com.win.opensdk.az
        public void b(boolean z, long j) {
            d.a();
            c.this.zk.f();
            c.this.i();
        }

        @Override // com.win.opensdk.az
        public void bb(String str) {
            d.b("onRewardedShowFail: errorCode: 0, , errorMessage: " + str, new Object[0]);
            c.this.zk.b(str);
            c.this.a(0, str);
        }

        @Override // com.win.opensdk.az
        public void ht() {
            d.a();
            c.this.zk.d();
            c.this.f();
        }

        @Override // com.win.opensdk.az
        public void hu() {
            d.a();
            c.this.zk.b(this.f993a);
            this.f993a = true;
            c.this.a((c) null, (String) null);
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            d.a();
            c.this.zk.a(this.b);
            this.b = true;
            c.this.e();
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            d.b("onFail errorCode: " + pBError.getCode() + ", errorMessage: " + pBError.getMsg(), new Object[0]);
            c.this.zk.b(Integer.valueOf(pBError.getCode()));
            c.this.b(pBError.getCode(), pBError.getMsg());
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            d.a();
            c.this.zk.b();
            c cVar = c.this;
            cVar.a((c) this.Bc);
            cVar.h();
        }
    }

    public c(e.a aVar) {
        super(aVar);
    }

    @Override // a.a.a.a.c
    public void a(Context context, FunAdSlot funAdSlot) {
        ay ayVar = new ay(context.getApplicationContext(), this.zl.c);
        ayVar.a(new a(ayVar));
        this.zk.a(funAdSlot, this.zl);
        ayVar.load();
        g();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, ay ayVar) {
        ay ayVar2 = ayVar;
        this.zk.g();
        if (ayVar2.isReady()) {
            ayVar2.show();
            return true;
        }
        d.b("Ad isn't ready now", new Object[0]);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(ay ayVar) {
        ay ayVar2 = ayVar;
        if (ayVar2 != null) {
            ayVar2.destroy();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean c(ay ayVar) {
        ay ayVar2 = ayVar;
        return ayVar2 != null && ayVar2.isReady();
    }
}
