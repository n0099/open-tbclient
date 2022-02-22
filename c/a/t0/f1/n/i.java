package c.a.t0.f1.n;

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
/* loaded from: classes6.dex */
public interface i {
    c.a.d.f.k.b<GifView> getGifViewPool();

    c.a.d.f.k.b<ImageView> getImageViewPool();

    c.a.d.f.k.b<ItemCardView> getItemCardViewPool();

    ListView getListView();

    c.a.d.f.k.b<RelativeLayout> getRelativeLayoutPool();

    int getRichTextViewId();

    c.a.d.f.k.b<TextView> getTextViewPool();

    c.a.d.f.k.b<LinearLayout> getTextVoiceViewPool();

    c.a.d.f.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool();

    c.a.d.f.k.b<View> getVoiceViewPool();

    void onAtClicked(Context context, String str);

    void onLinkButtonClicked(Context context, String str);

    void onLinkClicked(Context context, String str, boolean z);

    void onPhoneClicked(Context context, String str, String str2);

    void onSongClicked(Context context, String str);

    void onVideoClicked(Context context, String str);

    void onVideoP2PClicked(Context context, String str);
}
