package a.a.a.a;
/* loaded from: classes4.dex */
public class r {
    public final c zP;

    /* loaded from: classes4.dex */
    public class a implements c {
        public final /* synthetic */ a.a.a.a.a.d zQ;

        public a(r rVar, a.a.a.a.a.d dVar) {
            this.zQ = dVar;
        }

        @Override // a.a.a.a.r.c
        public f a(n nVar) {
            return new g(this.zQ, nVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c {
        public final /* synthetic */ a.a.a.a.a.c zG;

        public b(r rVar, a.a.a.a.a.c cVar) {
            this.zG = cVar;
        }

        @Override // a.a.a.a.r.c
        public f a(n nVar) {
            return new j(this.zG, nVar);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        f a(n nVar);
    }

    public r(a.a.a.a.a.c cVar) {
        this.zP = new b(this, cVar);
    }

    public r(a.a.a.a.a.d dVar) {
        this.zP = new a(this, dVar);
    }
}
