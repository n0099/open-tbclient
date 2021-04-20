package a.a.a.a.r.b.a;

import a.a.a.a.v.d;
import android.content.Context;
import android.widget.Button;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.fun.ad.sdk.R;
/* loaded from: classes.dex */
public class a implements TTAppDownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public Button f1260a;

    public a(Button button) {
        this.f1260a = button;
    }

    public final String a(Context context, long j, long j2) {
        return j != 0 ? context.getString(R.string.ad_interaction_type_downloading, String.format("%s/100", Long.valueOf((j2 * 100) / j))) : context.getString(R.string.ad_interaction_type_downloading_without_progress);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        d.a("CSJAppDownloadListener 下载中，点击图片暂停", new Object[0]);
        Button button = this.f1260a;
        if (button != null) {
            button.setText(a(button.getContext(), j, j2));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        d.b("CSJAppDownloadListener 下载失败，点击图片重新下载", new Object[0]);
        Button button = this.f1260a;
        if (button != null) {
            button.setText(R.string.ad_interaction_type_download);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        d.a("CSJAppDownloadListener 点击图片安装", new Object[0]);
        Button button = this.f1260a;
        if (button != null) {
            button.setText(R.string.ad_interaction_type_install);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        d.a("CSJAppDownloadListener 下载暂停，点击图片继续", new Object[0]);
        Button button = this.f1260a;
        if (button != null) {
            button.setText(a(button.getContext(), j, j2));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        d.b("CSJAppDownloadListener 点击图片开始下载", new Object[0]);
        Button button = this.f1260a;
        if (button != null) {
            button.setText(R.string.ad_interaction_type_download);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        d.a("CSJAppDownloadListener 安装完成，点击图片打开", new Object[0]);
        Button button = this.f1260a;
        if (button != null) {
            button.setText(R.string.ad_interaction_type_open);
        }
    }
}
