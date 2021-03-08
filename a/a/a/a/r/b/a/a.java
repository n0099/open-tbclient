package a.a.a.a.r.b.a;

import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdLargeImgView;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    public final /* synthetic */ IBasicCPUData zT;

    public a(BaiduNativeCpuAdLargeImgView baiduNativeCpuAdLargeImgView, IBasicCPUData iBasicCPUData) {
        this.zT = iBasicCPUData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.zT.handleClick(view);
    }
}
