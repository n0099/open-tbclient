package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class f implements c {
    private Movie a;
    private int b = 0;
    private int c;

    private f(Movie movie) {
        this.a = movie;
        this.c = this.a.duration() / 100;
    }

    public static c a(String str) {
        com.baidu.adp.lib.h.e.e("MovieGif", "create", "" + str);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("/sdcard/waves.gif")));
            bufferedInputStream.mark(6);
            Movie decodeStream = Movie.decodeStream(bufferedInputStream);
            if (decodeStream == null) {
                return null;
            }
            com.baidu.adp.lib.h.e.e("MovieGif", "create", "created");
            com.baidu.adp.lib.h.e.e("MovieGif", "create", "width: " + decodeStream.width() + " height: " + decodeStream.height());
            com.baidu.adp.lib.h.e.e("MovieGif", "create", "duration: " + decodeStream.duration());
            return new f(decodeStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.adp.gif.c
    public void a() {
        this.a = null;
    }

    @Override // com.baidu.adp.gif.c
    public int b() {
        return this.b;
    }

    @Override // com.baidu.adp.gif.c
    public boolean a(int i) {
        if (i < 0) {
            return false;
        }
        this.b = i;
        return true;
    }

    @Override // com.baidu.adp.gif.c
    public boolean a(Bitmap bitmap, Canvas canvas) {
        if (canvas == null) {
            return false;
        }
        com.baidu.adp.lib.h.e.e("MovieGif", "writeTo", "draw");
        this.a.setTime((this.b * 100) % this.a.duration());
        this.a.draw(canvas, 0.0f, 0.0f);
        return true;
    }

    @Override // com.baidu.adp.gif.c
    public int c() {
        return this.a.width();
    }

    @Override // com.baidu.adp.gif.c
    public int d() {
        return this.a.height();
    }

    @Override // com.baidu.adp.gif.c
    public int b(int i) {
        return 100;
    }

    @Override // com.baidu.adp.gif.c
    public int e() {
        return this.c;
    }
}
