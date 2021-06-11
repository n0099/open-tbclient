package a.a.a.a;
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public final c f1099a;

    /* loaded from: classes.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.a.a.a.v.d f1100a;

        public a(t tVar, a.a.a.a.v.d dVar) {
            this.f1100a = dVar;
        }

        @Override // a.a.a.a.t.c
        public g a(p pVar) {
            return new h(this.f1100a, pVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.a.a.a.v.c f1101a;

        public b(t tVar, a.a.a.a.v.c cVar) {
            this.f1101a = cVar;
        }

        @Override // a.a.a.a.t.c
        public g a(p pVar) {
            return new k(this.f1101a, pVar);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        g a(p pVar);
    }

    public t(a.a.a.a.v.c cVar) {
        this.f1099a = new b(this, cVar);
    }

    public t(a.a.a.a.v.d dVar) {
        this.f1099a = new a(this, dVar);
    }
}
