package android.support.v7.util;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ParallelExecutorCompat;
import android.support.v7.util.ThreadUtil;
import android.support.v7.util.TileList;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
class a<T> implements ThreadUtil<T> {

    /* renamed from: android.support.v7.util.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        final C0011a FY = new C0011a();
        private final Handler FZ = new Handler(Looper.getMainLooper());
        private Runnable Ga = new Runnable() { // from class: android.support.v7.util.a.1.1
            @Override // java.lang.Runnable
            public void run() {
                b eD = AnonymousClass1.this.FY.eD();
                while (eD != null) {
                    switch (eD.what) {
                        case 1:
                            AnonymousClass1.this.Gb.updateItemCount(eD.arg1, eD.arg2);
                            break;
                        case 2:
                            AnonymousClass1.this.Gb.addTile(eD.arg1, (TileList.Tile) eD.data);
                            break;
                        case 3:
                            AnonymousClass1.this.Gb.removeTile(eD.arg1, eD.arg2);
                            break;
                        default:
                            Log.e("ThreadUtil", "Unsupported message, what=" + eD.what);
                            break;
                    }
                    eD = AnonymousClass1.this.FY.eD();
                }
            }
        };
        final /* synthetic */ ThreadUtil.MainThreadCallback Gb;

        AnonymousClass1(ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.Gb = mainThreadCallback;
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            a(b.f(1, i, i2));
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            a(b.c(2, i, tile));
        }

        @Override // android.support.v7.util.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            a(b.f(3, i, i2));
        }

        private void a(b bVar) {
            this.FY.a(bVar);
            this.FZ.post(this.Ga);
        }
    }

    @Override // android.support.v7.util.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> a(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new AnonymousClass1(mainThreadCallback);
    }

    /* renamed from: android.support.v7.util.a$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        final /* synthetic */ ThreadUtil.BackgroundCallback Gg;
        final C0011a FY = new C0011a();
        private final Executor mExecutor = ParallelExecutorCompat.getParallelExecutor();
        AtomicBoolean Ge = new AtomicBoolean(false);
        private Runnable Gf = new Runnable() { // from class: android.support.v7.util.a.2.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    b eD = AnonymousClass2.this.FY.eD();
                    if (eD != null) {
                        switch (eD.what) {
                            case 1:
                                AnonymousClass2.this.FY.removeMessages(1);
                                AnonymousClass2.this.Gg.refresh(eD.arg1);
                                break;
                            case 2:
                                AnonymousClass2.this.FY.removeMessages(2);
                                AnonymousClass2.this.FY.removeMessages(3);
                                AnonymousClass2.this.Gg.updateRange(eD.arg1, eD.arg2, eD.Gm, eD.Gn, eD.Go);
                                break;
                            case 3:
                                AnonymousClass2.this.Gg.loadTile(eD.arg1, eD.arg2);
                                break;
                            case 4:
                                AnonymousClass2.this.Gg.recycleTile((TileList.Tile) eD.data);
                                break;
                            default:
                                Log.e("ThreadUtil", "Unsupported message, what=" + eD.what);
                                break;
                        }
                    } else {
                        AnonymousClass2.this.Ge.set(false);
                        return;
                    }
                }
            }
        };

        AnonymousClass2(ThreadUtil.BackgroundCallback backgroundCallback) {
            this.Gg = backgroundCallback;
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            b(b.c(1, i, null));
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            b(b.a(2, i, i2, i3, i4, i5, null));
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            a(b.f(3, i, i2));
        }

        @Override // android.support.v7.util.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            a(b.c(4, 0, tile));
        }

        private void a(b bVar) {
            this.FY.a(bVar);
            eC();
        }

        private void b(b bVar) {
            this.FY.b(bVar);
            eC();
        }

        private void eC() {
            if (this.Ge.compareAndSet(false, true)) {
                this.mExecutor.execute(this.Gf);
            }
        }
    }

    @Override // android.support.v7.util.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> a(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new AnonymousClass2(backgroundCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        private static b Gj;
        private static final Object Gk = new Object();
        private b Gl;
        public int Gm;
        public int Gn;
        public int Go;
        public int arg1;
        public int arg2;
        public Object data;
        public int what;

        b() {
        }

        void recycle() {
            this.Gl = null;
            this.Go = 0;
            this.Gn = 0;
            this.Gm = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (Gk) {
                if (Gj != null) {
                    this.Gl = Gj;
                }
                Gj = this;
            }
        }

        static b a(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            b bVar;
            synchronized (Gk) {
                if (Gj == null) {
                    bVar = new b();
                } else {
                    bVar = Gj;
                    Gj = Gj.Gl;
                    bVar.Gl = null;
                }
                bVar.what = i;
                bVar.arg1 = i2;
                bVar.arg2 = i3;
                bVar.Gm = i4;
                bVar.Gn = i5;
                bVar.Go = i6;
                bVar.data = obj;
            }
            return bVar;
        }

        static b f(int i, int i2, int i3) {
            return a(i, i2, i3, 0, 0, 0, null);
        }

        static b c(int i, int i2, Object obj) {
            return a(i, i2, 0, 0, 0, 0, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0011a {
        private b Gi;

        C0011a() {
        }

        synchronized b eD() {
            b bVar;
            if (this.Gi == null) {
                bVar = null;
            } else {
                bVar = this.Gi;
                this.Gi = this.Gi.Gl;
            }
            return bVar;
        }

        synchronized void b(b bVar) {
            bVar.Gl = this.Gi;
            this.Gi = bVar;
        }

        synchronized void a(b bVar) {
            if (this.Gi == null) {
                this.Gi = bVar;
            } else {
                b bVar2 = this.Gi;
                while (bVar2.Gl != null) {
                    bVar2 = bVar2.Gl;
                }
                bVar2.Gl = bVar;
            }
        }

        synchronized void removeMessages(int i) {
            while (this.Gi != null && this.Gi.what == i) {
                b bVar = this.Gi;
                this.Gi = this.Gi.Gl;
                bVar.recycle();
            }
            if (this.Gi != null) {
                b bVar2 = this.Gi;
                b bVar3 = bVar2.Gl;
                while (bVar3 != null) {
                    b bVar4 = bVar3.Gl;
                    if (bVar3.what == i) {
                        bVar2.Gl = bVar4;
                        bVar3.recycle();
                    } else {
                        bVar2 = bVar3;
                    }
                    bVar3 = bVar4;
                }
            }
        }
    }
}
