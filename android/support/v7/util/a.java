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
        final C0011a FT = new C0011a();
        private final Handler FU = new Handler(Looper.getMainLooper());
        private Runnable FV = new Runnable() { // from class: android.support.v7.util.a.1.1
            @Override // java.lang.Runnable
            public void run() {
                b eD = AnonymousClass1.this.FT.eD();
                while (eD != null) {
                    switch (eD.what) {
                        case 1:
                            AnonymousClass1.this.FW.updateItemCount(eD.arg1, eD.arg2);
                            break;
                        case 2:
                            AnonymousClass1.this.FW.addTile(eD.arg1, (TileList.Tile) eD.data);
                            break;
                        case 3:
                            AnonymousClass1.this.FW.removeTile(eD.arg1, eD.arg2);
                            break;
                        default:
                            Log.e("ThreadUtil", "Unsupported message, what=" + eD.what);
                            break;
                    }
                    eD = AnonymousClass1.this.FT.eD();
                }
            }
        };
        final /* synthetic */ ThreadUtil.MainThreadCallback FW;

        AnonymousClass1(ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.FW = mainThreadCallback;
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
            this.FT.a(bVar);
            this.FU.post(this.FV);
        }
    }

    @Override // android.support.v7.util.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> a(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new AnonymousClass1(mainThreadCallback);
    }

    /* renamed from: android.support.v7.util.a$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        final /* synthetic */ ThreadUtil.BackgroundCallback Gb;
        final C0011a FT = new C0011a();
        private final Executor mExecutor = ParallelExecutorCompat.getParallelExecutor();
        AtomicBoolean FZ = new AtomicBoolean(false);
        private Runnable Ga = new Runnable() { // from class: android.support.v7.util.a.2.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    b eD = AnonymousClass2.this.FT.eD();
                    if (eD != null) {
                        switch (eD.what) {
                            case 1:
                                AnonymousClass2.this.FT.removeMessages(1);
                                AnonymousClass2.this.Gb.refresh(eD.arg1);
                                break;
                            case 2:
                                AnonymousClass2.this.FT.removeMessages(2);
                                AnonymousClass2.this.FT.removeMessages(3);
                                AnonymousClass2.this.Gb.updateRange(eD.arg1, eD.arg2, eD.Gh, eD.Gi, eD.Gj);
                                break;
                            case 3:
                                AnonymousClass2.this.Gb.loadTile(eD.arg1, eD.arg2);
                                break;
                            case 4:
                                AnonymousClass2.this.Gb.recycleTile((TileList.Tile) eD.data);
                                break;
                            default:
                                Log.e("ThreadUtil", "Unsupported message, what=" + eD.what);
                                break;
                        }
                    } else {
                        AnonymousClass2.this.FZ.set(false);
                        return;
                    }
                }
            }
        };

        AnonymousClass2(ThreadUtil.BackgroundCallback backgroundCallback) {
            this.Gb = backgroundCallback;
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
            this.FT.a(bVar);
            eC();
        }

        private void b(b bVar) {
            this.FT.b(bVar);
            eC();
        }

        private void eC() {
            if (this.FZ.compareAndSet(false, true)) {
                this.mExecutor.execute(this.Ga);
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
        private static b Ge;
        private static final Object Gf = new Object();
        private b Gg;
        public int Gh;
        public int Gi;
        public int Gj;
        public int arg1;
        public int arg2;
        public Object data;
        public int what;

        b() {
        }

        void recycle() {
            this.Gg = null;
            this.Gj = 0;
            this.Gi = 0;
            this.Gh = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (Gf) {
                if (Ge != null) {
                    this.Gg = Ge;
                }
                Ge = this;
            }
        }

        static b a(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            b bVar;
            synchronized (Gf) {
                if (Ge == null) {
                    bVar = new b();
                } else {
                    bVar = Ge;
                    Ge = Ge.Gg;
                    bVar.Gg = null;
                }
                bVar.what = i;
                bVar.arg1 = i2;
                bVar.arg2 = i3;
                bVar.Gh = i4;
                bVar.Gi = i5;
                bVar.Gj = i6;
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
        private b Gd;

        C0011a() {
        }

        synchronized b eD() {
            b bVar;
            if (this.Gd == null) {
                bVar = null;
            } else {
                bVar = this.Gd;
                this.Gd = this.Gd.Gg;
            }
            return bVar;
        }

        synchronized void b(b bVar) {
            bVar.Gg = this.Gd;
            this.Gd = bVar;
        }

        synchronized void a(b bVar) {
            if (this.Gd == null) {
                this.Gd = bVar;
            } else {
                b bVar2 = this.Gd;
                while (bVar2.Gg != null) {
                    bVar2 = bVar2.Gg;
                }
                bVar2.Gg = bVar;
            }
        }

        synchronized void removeMessages(int i) {
            while (this.Gd != null && this.Gd.what == i) {
                b bVar = this.Gd;
                this.Gd = this.Gd.Gg;
                bVar.recycle();
            }
            if (this.Gd != null) {
                b bVar2 = this.Gd;
                b bVar3 = bVar2.Gg;
                while (bVar3 != null) {
                    b bVar4 = bVar3.Gg;
                    if (bVar3.what == i) {
                        bVar2.Gg = bVar4;
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
