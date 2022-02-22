package c.a.c0.b.a;

import android.content.Context;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public interface e {
    long a();

    void b(int i2, int i3);

    @Deprecated
    int c(int i2, int i3, Map<String, float[]> map);

    int d(MediaTrack mediaTrack, int i2, Map<String, float[]> map);

    void e(List<MediaTrack> list, Map<String, ShaderConfig> map);

    int f(MediaTrack mediaTrack, int i2, int i3, Map<String, float[]> map);

    void g(int i2, long j2);

    int h(MediaSegment mediaSegment, int i2, Map<String, float[]> map);

    int i(MediaTrack mediaTrack, int i2, Map<String, float[]> map);

    void j(Context context);

    int k(int i2, float[] fArr, float[] fArr2, int i3, int i4, float f2);

    List<MediaTrack> l();

    @Deprecated
    int m(int i2, float[] fArr, float[] fArr2, int i3, int i4, int i5, Map<String, float[]> map);

    void n(List<MediaTrack> list);

    void release();
}
