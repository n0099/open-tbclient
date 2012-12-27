package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    protected int[] j;
    protected int[] k;
    String[] l;
    private int m;
    private i n;
    private j o;

    private void a(String[] strArr) {
        if (this.c == null) {
            this.j = null;
            return;
        }
        int length = strArr.length;
        if (this.j == null || this.j.length != length) {
            this.j = new int[length];
        }
        for (int i = 0; i < length; i++) {
            this.j[i] = this.c.getColumnIndexOrThrow(strArr[i]);
        }
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void a(View view, Context context, Cursor cursor) {
        j jVar = this.o;
        int length = this.k.length;
        int[] iArr = this.j;
        int[] iArr2 = this.k;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr2[i]);
            if (findViewById != null) {
                if (jVar != null ? jVar.a(findViewById, cursor, iArr[i]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        a((TextView) findViewById, string);
                    } else if (!(findViewById instanceof ImageView)) {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                    } else {
                        a((ImageView) findViewById, string);
                    }
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void a(TextView textView, String str) {
        textView.setText(str);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public Cursor b(Cursor cursor) {
        Cursor b = super.b(cursor);
        a(this.l);
        return b;
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.c
    public CharSequence c(Cursor cursor) {
        return this.n != null ? this.n.a(cursor) : this.m > -1 ? cursor.getString(this.m) : super.c(cursor);
    }
}
