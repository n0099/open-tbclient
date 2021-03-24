package a.a.a.a.r.b.c;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.R;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b extends NativeAdContainer {

    /* renamed from: a  reason: collision with root package name */
    public TextView f1290a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f1291b;

    /* renamed from: c  reason: collision with root package name */
    public Button f1292c;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public List<View> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1292c);
        arrayList.add(this.f1291b);
        arrayList.add(this.f1290a);
        return arrayList;
    }

    public void a(Activity activity, NativeUnifiedADData nativeUnifiedADData) {
        this.f1291b.setText(nativeUnifiedADData.getTitle());
        this.f1290a.setText(nativeUnifiedADData.getDesc());
        nativeUnifiedADData.bindAdToView(getContext(), this, null, a());
        a(nativeUnifiedADData);
    }

    public void a(NativeUnifiedADData nativeUnifiedADData) {
        Button button;
        int i;
        if (nativeUnifiedADData.isAppAd()) {
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus == 0) {
                button = this.f1292c;
                i = R.string.ad_interaction_type_download;
            } else if (appStatus == 1) {
                button = this.f1292c;
                i = R.string.ad_interaction_type_start;
            } else if (appStatus == 2) {
                button = this.f1292c;
                i = R.string.ad_interaction_type_update;
            } else if (appStatus == 4) {
                this.f1292c.setText(String.format("%s/100", Integer.valueOf(nativeUnifiedADData.getProgress())));
                return;
            } else if (appStatus == 8) {
                button = this.f1292c;
                i = R.string.ad_interaction_type_install;
            } else if (appStatus == 16) {
                button = this.f1292c;
                i = R.string.ad_interaction_type_redownload;
            }
            button.setText(i);
        }
        button = this.f1292c;
        i = R.string.ad_interaction_type_view;
        button.setText(i);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1290a = (TextView) findViewById(R.id.ad_description);
        this.f1291b = (TextView) findViewById(R.id.ad_title);
        this.f1292c = (Button) findViewById(R.id.ad_creative);
    }
}
