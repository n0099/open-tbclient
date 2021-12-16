package c.a.s0.z3;

import android.view.View;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes9.dex */
public interface a {
    void ForumLike(int i2);

    void ForumUnLike(int i2);

    View getRootView();

    void hide();

    void setData(InterestFrsData.Tag tag);

    void setOnClickListener(View.OnClickListener onClickListener);

    void show();
}
