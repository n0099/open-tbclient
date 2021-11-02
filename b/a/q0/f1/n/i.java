package b.a.q0.f1.n;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
/* loaded from: classes4.dex */
public interface i {
    b.a.e.e.k.b<GifView> getGifViewPool();

    b.a.e.e.k.b<ImageView> getImageViewPool();

    b.a.e.e.k.b<ItemCardView> getItemCardViewPool();

    ListView getListView();

    b.a.e.e.k.b<RelativeLayout> getRelativeLayoutPool();

    int getRichTextViewId();

    b.a.e.e.k.b<TextView> getTextViewPool();

    b.a.e.e.k.b<LinearLayout> getTextVoiceViewPool();

    b.a.e.e.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool();

    b.a.e.e.k.b<View> getVoiceViewPool();

    void onAtClicked(Context context, String str);

    void onLinkButtonClicked(Context context, String str);

    void onLinkClicked(Context context, String str, boolean z);

    void onPhoneClicked(Context context, String str, String str2);

    void onSongClicked(Context context, String str);

    void onVideoClicked(Context context, String str);

    void onVideoP2PClicked(Context context, String str);
}
