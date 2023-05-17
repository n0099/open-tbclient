package com.baidu.pass.face.platform.a;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    public static final String a = "b";
    public Context b;
    public FaceStatusNewEnum c;
    public volatile long d = 0;
    public volatile long e = 0;
    public volatile boolean f = false;
    public volatile boolean g = true;
    public HashMap<Integer, Long> h = new HashMap<>();

    public b(Context context) {
        this.b = context;
    }

    private long a(int i) {
        long j;
        if (this.h.containsKey(Integer.valueOf(i))) {
            return this.h.get(Integer.valueOf(i)).longValue();
        }
        System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.b, Uri.parse("android.resource://" + this.b.getPackageName() + "/" + i));
            j = Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue() + 0;
            try {
                this.h.put(Integer.valueOf(i), Long.valueOf(j));
                return j;
            } catch (IllegalArgumentException e) {
                e = e;
                e.printStackTrace();
                return j;
            } catch (IllegalStateException e2) {
                e = e2;
                e.printStackTrace();
                return j;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return j;
            }
        } catch (IllegalArgumentException e4) {
            e = e4;
            j = 600;
        } catch (IllegalStateException e5) {
            e = e5;
            j = 600;
        } catch (Exception e6) {
            e = e6;
            j = 600;
        }
    }

    public void a() {
        com.baidu.pass.face.platform.utils.b.a();
        this.d = 0L;
        this.e = 0L;
        this.b = null;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean a(FaceStatusNewEnum faceStatusNewEnum) {
        if (!this.g) {
            com.baidu.pass.face.platform.utils.b.a();
        }
        this.f = System.currentTimeMillis() - com.baidu.pass.face.platform.utils.b.a < this.d;
        if (this.f || (this.c == faceStatusNewEnum && System.currentTimeMillis() - this.e < FaceEnvironment.TIME_TIPS_REPEAT)) {
            return false;
        }
        this.f = true;
        this.c = faceStatusNewEnum;
        this.d = 0L;
        this.e = System.currentTimeMillis();
        int soundId = FaceEnvironment.getSoundId(faceStatusNewEnum);
        if (soundId > 0) {
            this.d = a(soundId);
            com.baidu.pass.face.platform.utils.b.a = System.currentTimeMillis();
            if (this.g) {
                com.baidu.pass.face.platform.utils.b.a(this.b, soundId);
            }
        }
        return this.f;
    }
}
