package a.a.a.a.r.b.d;

import android.text.TextUtils;
import android.widget.Button;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
/* loaded from: classes.dex */
public class b implements KsAppDownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public Button f1288a;

    /* renamed from: b  reason: collision with root package name */
    public String f1289b;

    public b(String str, Button button) {
        this.f1289b = str;
        this.f1288a = button;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        if (TextUtils.isEmpty(this.f1289b)) {
            this.f1288a.setText(R.string.ad_interaction_type_download);
        } else {
            this.f1288a.setText(this.f1289b);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        this.f1288a.setText(R.string.ad_interaction_type_install);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        if (TextUtils.isEmpty(this.f1289b)) {
            this.f1288a.setText(R.string.ad_interaction_type_download);
        } else {
            this.f1288a.setText(this.f1289b);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        this.f1288a.setText(R.string.ad_interaction_type_open);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        Button button = this.f1288a;
        button.setText(button.getContext().getResources().getString(R.string.ad_interaction_type_downloading, String.format("%s/100", Integer.valueOf(i))));
    }
}
