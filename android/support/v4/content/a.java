package android.support.v4.content;

import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends e implements Runnable {
    Object a;
    boolean b;
    final /* synthetic */ AsyncTaskLoader c;
    private CountDownLatch e = new CountDownLatch(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AsyncTaskLoader asyncTaskLoader) {
        this.c = asyncTaskLoader;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.content.e
    public Object a(Void... voidArr) {
        this.a = this.c.e();
        return this.a;
    }

    @Override // android.support.v4.content.e
    protected void a() {
        try {
            this.c.a(this, this.a);
        } finally {
            this.e.countDown();
        }
    }

    @Override // android.support.v4.content.e
    protected void a(Object obj) {
        try {
            this.c.b(this, obj);
        } finally {
            this.e.countDown();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b = false;
        this.c.c();
    }
}
