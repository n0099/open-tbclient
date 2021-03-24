package a.a.a.a.r.b.a;

import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdLargeImgView;
/* loaded from: classes.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBasicCPUData f1268a;

    public a(BaiduNativeCpuAdLargeImgView baiduNativeCpuAdLargeImgView, IBasicCPUData iBasicCPUData) {
        this.f1268a = iBasicCPUData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1268a.handleClick(view);
    }
}
