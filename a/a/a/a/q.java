package a.a.a.a;
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public final c f1081a;

    /* loaded from: classes.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.a.a.a.s.d f1082a;

        public a(q qVar, a.a.a.a.s.d dVar) {
            this.f1082a = dVar;
        }

        @Override // a.a.a.a.q.c
        public e a(m mVar) {
            return new f(this.f1082a, mVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.a.a.a.s.c f1083a;

        public b(q qVar, a.a.a.a.s.c cVar) {
            this.f1083a = cVar;
        }

        @Override // a.a.a.a.q.c
        public e a(m mVar) {
            return new i(this.f1083a, mVar);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        e a(m mVar);
    }

    public q(a.a.a.a.s.c cVar) {
        this.f1081a = new b(this, cVar);
    }

    public q(a.a.a.a.s.d dVar) {
        this.f1081a = new a(this, dVar);
    }
}
