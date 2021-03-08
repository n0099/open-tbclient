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
/* loaded from: classes4.dex */
public abstract class b extends NativeAdContainer {

    /* renamed from: a  reason: collision with root package name */
    public TextView f1003a;
    public TextView b;
    public Button c;

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
        arrayList.add(this.c);
        arrayList.add(this.b);
        arrayList.add(this.f1003a);
        return arrayList;
    }

    public void a(Activity activity, NativeUnifiedADData nativeUnifiedADData) {
        this.b.setText(nativeUnifiedADData.getTitle());
        this.f1003a.setText(nativeUnifiedADData.getDesc());
        nativeUnifiedADData.bindAdToView(getContext(), this, null, a());
        a(nativeUnifiedADData);
    }

    public void a(NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData.isAppAd()) {
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus == 0) {
                this.c.setText(R.string.ad_interaction_type_download);
                return;
            } else if (appStatus == 1) {
                this.c.setText(R.string.ad_interaction_type_start);
                return;
            } else if (appStatus == 2) {
                this.c.setText(R.string.ad_interaction_type_update);
                return;
            } else if (appStatus == 4) {
                this.c.setText(String.format("%s/100", Integer.valueOf(nativeUnifiedADData.getProgress())));
                return;
            } else if (appStatus == 8) {
                this.c.setText(R.string.ad_interaction_type_install);
                return;
            } else if (appStatus == 16) {
                this.c.setText(R.string.ad_interaction_type_redownload);
                return;
            }
        }
        this.c.setText(R.string.ad_interaction_type_view);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1003a = (TextView) findViewById(R.id.ad_description);
        this.b = (TextView) findViewById(R.id.ad_title);
        this.c = (Button) findViewById(R.id.ad_creative);
    }
}
