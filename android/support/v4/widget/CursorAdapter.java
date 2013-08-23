package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements c, Filterable {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f331a;
    protected boolean b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected a f;
    protected DataSetObserver g;
    protected b h;
    protected FilterQueryProvider i;

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void a(View view, Context context, Cursor cursor);

    @Override // android.support.v4.widget.c
    public Cursor a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.f331a || this.c == null) {
            return 0;
        }
        return this.c.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.f331a || this.c == null) {
            return null;
        }
        this.c.moveToPosition(i);
        return this.c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f331a && this.c != null && this.c.moveToPosition(i)) {
            return this.c.getLong(this.e);
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f331a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.c.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        if (view == null) {
            view = a(this.d, this.c, viewGroup);
        }
        a(view, this.d, this.c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f331a) {
            this.c.moveToPosition(i);
            if (view == null) {
                view = b(this.d, this.c, viewGroup);
            }
            a(view, this.d, this.c);
            return view;
        }
        return null;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    @Override // android.support.v4.widget.c
    public void a(Cursor cursor) {
        Cursor b = b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public Cursor b(Cursor cursor) {
        if (cursor == this.c) {
            return null;
        }
        Cursor cursor2 = this.c;
        if (cursor2 != null) {
            if (this.f != null) {
                cursor2.unregisterContentObserver(this.f);
            }
            if (this.g != null) {
                cursor2.unregisterDataSetObserver(this.g);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            if (this.f != null) {
                cursor.registerContentObserver(this.f);
            }
            if (this.g != null) {
                cursor.registerDataSetObserver(this.g);
            }
            this.e = cursor.getColumnIndexOrThrow("_id");
            this.f331a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.e = -1;
        this.f331a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    @Override // android.support.v4.widget.c
    public CharSequence c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.support.v4.widget.c
    public Cursor a(CharSequence charSequence) {
        return this.i != null ? this.i.runQuery(charSequence) : this.c;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.h == null) {
            this.h = new b(this);
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.b && this.c != null && !this.c.isClosed()) {
            this.f331a = this.c.requery();
        }
    }
}
