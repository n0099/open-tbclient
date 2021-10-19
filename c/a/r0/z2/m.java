package c.a.r0.z2;

import android.graphics.drawable.Drawable;
import c.a.r0.z2.e0.c;
import com.baidu.tieba.video.VideoItemModel;
/* loaded from: classes4.dex */
public interface m {
    void onDestroy();

    void onPause();

    void onPrimary(boolean z);

    void onUserVisibleHint(boolean z);

    void onViewClick();

    void onViewDoubleClick();

    void onViewDragToRight();

    void setDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6);

    void setPageChangeHandler(c.a aVar, int i2);

    void updateTiebaData(int i2, VideoItemModel videoItemModel);
}
