package com.baidu.tbadk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f796a = null;
    private Context b = null;
    private b c = null;

    public static a a() {
        if (f796a == null) {
            f796a = new a();
        }
        return f796a;
    }

    private a() {
    }

    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.b = context;
        this.c = bVar;
    }

    public com.baidu.adp.widget.a.b a(String str) {
        return a(b(str), str);
    }

    private com.baidu.adp.widget.a.b a(int i, String str) {
        Bitmap a2;
        com.baidu.adp.widget.a.b c = e.a().c(str);
        if (c == null && (a2 = com.baidu.adp.lib.e.a.a().a(this.b, i)) != null) {
            com.baidu.adp.widget.a.b bVar = new com.baidu.adp.widget.a.b(a2, false, str);
            e.a().b(str, bVar);
            return bVar;
        }
        return c;
    }

    public int b(String str) {
        return this.c.a(str);
    }

    public c c(String str) {
        com.baidu.adp.widget.a.b a2;
        c a3 = this.c.a(this.b, str);
        if (a3 == null && (a2 = a(str)) != null) {
            return new c(a2.a(), a2.b());
        }
        return a3;
    }

    public int b() {
        return this.c.a();
    }

    public String d(String str) {
        return this.c.c(str);
    }

    public int a(int i) {
        return this.c.a(i);
    }

    public com.baidu.adp.widget.a.b b(int i) {
        int a2 = a(i);
        return a(a2, String.valueOf(a2));
    }

    public String c(int i) {
        return this.c.b(i);
    }

    public SpannableString a(Context context, String str) {
        com.baidu.adp.widget.a.b a2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int b = this.c.b(group);
            if (b > 0 && (a2 = a(b, String.valueOf(b))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable h = a2.h();
                h.setBounds(0, 0, a2.a(), a2.b());
                spannableString.setSpan(new ImageSpan(h, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }
}
