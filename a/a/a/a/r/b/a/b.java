package a.a.a.a.r.b.a;

import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdSmallImgView;
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBasicCPUData f1269a;

    public b(BaiduNativeCpuAdSmallImgView baiduNativeCpuAdSmallImgView, IBasicCPUData iBasicCPUData) {
        this.f1269a = iBasicCPUData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1269a.handleClick(view);
    }
}
