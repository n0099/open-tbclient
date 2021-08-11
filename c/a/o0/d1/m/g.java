package c.a.o0.d1.m;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
/* loaded from: classes3.dex */
public interface g {
    c.a.e.e.k.b<GifView> getGifViewPool();

    c.a.e.e.k.b<ImageView> getImageViewPool();

    ListView getListView();

    c.a.e.e.k.b<RelativeLayout> getRelativeLayoutPool();

    int getRichTextViewId();

    c.a.e.e.k.b<TextView> getTextViewPool();

    c.a.e.e.k.b<LinearLayout> getTextVoiceViewPool();

    c.a.e.e.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool();

    c.a.e.e.k.b<View> getVoiceViewPool();

    void onAtClicked(Context context, String str);

    void onLinkButtonClicked(Context context, String str);

    void onLinkClicked(Context context, String str, boolean z);

    void onPhoneClicked(Context context, String str, String str2);

    void onSongClicked(Context context, String str);

    void onVideoClicked(Context context, String str);

    void onVideoP2PClicked(Context context, String str);
}
