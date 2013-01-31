package android.support.v4.content;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
/* loaded from: classes.dex */
public class CursorLoader extends AsyncTaskLoader {
    final c f;
    Uri g;
    String[] h;
    String i;
    String[] j;
    String k;
    Cursor l;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.content.AsyncTaskLoader
    /* renamed from: f */
    public Cursor d() {
        Cursor query = j().getContentResolver().query(this.g, this.h, this.i, this.j, this.k);
        if (query != null) {
            query.getCount();
            a(query, this.f);
        }
        return query;
    }

    void a(Cursor cursor, ContentObserver contentObserver) {
        cursor.registerContentObserver(this.f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.content.b
    /* renamed from: a */
    public void b(Cursor cursor) {
        if (m()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.l;
        this.l = cursor;
        if (k()) {
            super.b((Object) cursor);
        }
        if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
            cursor2.close();
        }
    }

    @Override // android.support.v4.content.b
    protected void g() {
        if (this.l != null) {
            b(this.l);
        }
        if (r() || this.l == null) {
            o();
        }
    }

    @Override // android.support.v4.content.b
    protected void h() {
        b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.content.AsyncTaskLoader
    /* renamed from: b */
    public void a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.content.b
    public void i() {
        super.i();
        h();
        if (this.l != null && !this.l.isClosed()) {
            this.l.close();
        }
        this.l = null;
    }

    @Override // android.support.v4.content.AsyncTaskLoader, android.support.v4.content.b
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.s);
    }
}
