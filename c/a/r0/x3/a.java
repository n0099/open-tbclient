package c.a.r0.x3;

import android.view.View;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes7.dex */
public interface a {
    void ForumLike(int i2);

    void ForumUnLike(int i2);

    View getRootView();

    void hide();

    void setData(InterestFrsData.Tag tag);

    void setOnClickListener(View.OnClickListener onClickListener);

    void show();
}
