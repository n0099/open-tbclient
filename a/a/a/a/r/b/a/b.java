package a.a.a.a.r.b.a;

import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.fun.ad.sdk.channel.model.baidu.BaiduNativeCpuAdSmallImgView;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    public final /* synthetic */ IBasicCPUData zT;

    public b(BaiduNativeCpuAdSmallImgView baiduNativeCpuAdSmallImgView, IBasicCPUData iBasicCPUData) {
        this.zT = iBasicCPUData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.zT.handleClick(view);
    }
}
