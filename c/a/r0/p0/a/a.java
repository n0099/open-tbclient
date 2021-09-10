package c.a.r0.p0.a;

import androidx.annotation.Nullable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import java.util.List;
/* loaded from: classes3.dex */
public interface a {
    void a();

    void b(b bVar);

    void c(VlogEditManager vlogEditManager, MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter);

    void d();

    void g(float f2);

    @Nullable
    List<MultiMediaData> h();

    void j();

    void k(String str);

    boolean m();

    float n();

    void o(@Nullable List<MultiMediaData> list);

    void onDestroy();

    void reset();
}
