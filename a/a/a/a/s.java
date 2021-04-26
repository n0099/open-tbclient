package a.a.a.a;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public final c f1096a;

    /* loaded from: classes.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.a.a.a.u.d f1097a;

        public a(s sVar, a.a.a.a.u.d dVar) {
            this.f1097a = dVar;
        }

        @Override // a.a.a.a.s.c
        public f a(o oVar) {
            return new g(this.f1097a, oVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.a.a.a.u.c f1098a;

        public b(s sVar, a.a.a.a.u.c cVar) {
            this.f1098a = cVar;
        }

        @Override // a.a.a.a.s.c
        public f a(o oVar) {
            return new j(this.f1098a, oVar);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        f a(o oVar);
    }

    public s(a.a.a.a.u.c cVar) {
        this.f1096a = new b(this, cVar);
    }

    public s(a.a.a.a.u.d dVar) {
        this.f1096a = new a(this, dVar);
    }
}
