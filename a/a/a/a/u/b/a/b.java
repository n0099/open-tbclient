package a.a.a.a.u.b.a;

import a.a.a.a.y.d;
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
/* loaded from: classes.dex */
public class b extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f1290a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f1291b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f1292c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f1293d;

    /* renamed from: e  reason: collision with root package name */
    public Button f1294e;

    public b(Context context) {
        super(context);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        Button button;
        int i2;
        this.f1290a.setText(tTNativeAd.getDescription());
        TTImage icon = tTNativeAd.getIcon();
        if (icon != null && icon.isValid()) {
            Context context = getContext();
            String imageUrl = icon.getImageUrl();
            ImageView imageView = this.f1291b;
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
        this.f1292c.setText(TextUtils.isEmpty(tTNativeAd.getSource()) ? tTNativeAd.getTitle() : tTNativeAd.getSource());
        this.f1293d.setImageBitmap(tTNativeAd.getAdLogo());
        int interactionType = tTNativeAd.getInteractionType();
        if (interactionType == 2 || interactionType == 3) {
            this.f1294e.setVisibility(0);
            button = this.f1294e;
            i2 = R.string.ad_interaction_type_browser;
        } else if (interactionType == 4) {
            tTNativeAd.setActivityForDownloadApp(activity);
            this.f1294e.setVisibility(0);
            button = this.f1294e;
            i2 = R.string.ad_interaction_type_download;
        } else if (interactionType != 5) {
            this.f1294e.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.f1294e);
            tTNativeAd.registerViewForInteraction(this, arrayList, arrayList2, adInteractionListener);
            tTNativeAd.setDownloadListener(new a(this.f1294e));
        } else {
            this.f1294e.setVisibility(0);
            button = this.f1294e;
            i2 = R.string.ad_interaction_type_dial;
        }
        button.setText(i2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(this);
        ArrayList arrayList22 = new ArrayList();
        arrayList22.add(this.f1294e);
        tTNativeAd.registerViewForInteraction(this, arrayList3, arrayList22, adInteractionListener);
        tTNativeAd.setDownloadListener(new a(this.f1294e));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1290a = (TextView) findViewById(R.id.ad_description);
        this.f1293d = (ImageView) findViewById(R.id.ad_logo);
        this.f1291b = (ImageView) findViewById(R.id.ad_icon);
        this.f1292c = (TextView) findViewById(R.id.ad_source);
        this.f1294e = (Button) findViewById(R.id.ad_creative);
    }
}
