package a.a.a.a.r.b.b;

import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f1001a;
    public ImageView b;
    public TextView c;
    public ImageView d;
    public Button e;

    public b(Context context) {
        super(context);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        this.f1001a.setText(tTNativeAd.getDescription());
        TTImage icon = tTNativeAd.getIcon();
        if (icon != null && icon.isValid()) {
            Context context = getContext();
            String imageUrl = icon.getImageUrl();
            ImageView imageView = this.b;
            if (context == null) {
                d.b("GlideHelper: context is null when load: " + imageUrl, new Object[0]);
            } else if (context instanceof Activity) {
                Activity activity2 = (Activity) context;
                if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                    d.b("GlideHelper: activity is destroyed when load: " + imageUrl, new Object[0]);
                } else {
                    Glide.with(activity2).load(imageUrl).into(imageView);
                }
            } else {
                Glide.with(context).load(imageUrl).into(imageView);
            }
        }
        this.c.setText(TextUtils.isEmpty(tTNativeAd.getSource()) ? tTNativeAd.getTitle() : tTNativeAd.getSource());
        this.d.setImageBitmap(tTNativeAd.getAdLogo());
        switch (tTNativeAd.getInteractionType()) {
            case 2:
            case 3:
                this.e.setVisibility(0);
                this.e.setText(R.string.ad_interaction_type_browser);
                break;
            case 4:
                tTNativeAd.setActivityForDownloadApp(activity);
                this.e.setVisibility(0);
                this.e.setText(R.string.ad_interaction_type_download);
                break;
            case 5:
                this.e.setVisibility(0);
                this.e.setText(R.string.ad_interaction_type_dial);
                break;
            default:
                this.e.setVisibility(8);
                break;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.e);
        tTNativeAd.registerViewForInteraction(this, arrayList, arrayList2, adInteractionListener);
        tTNativeAd.setDownloadListener(new a(this.e));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1001a = (TextView) findViewById(R.id.ad_description);
        this.d = (ImageView) findViewById(R.id.ad_logo);
        this.b = (ImageView) findViewById(R.id.ad_icon);
        this.c = (TextView) findViewById(R.id.ad_source);
        this.e = (Button) findViewById(R.id.ad_creative);
    }
}
