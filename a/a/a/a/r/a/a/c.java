package a.a.a.a.r.a.a;

import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.fun.ad.sdk.FunAdInteractionListener;
/* loaded from: classes4.dex */
public class c implements View.OnClickListener {
    public final /* synthetic */ String c;
    public final /* synthetic */ IBasicCPUData zT;
    public final /* synthetic */ FunAdInteractionListener zU;
    public final /* synthetic */ a zV;

    public c(a aVar, IBasicCPUData iBasicCPUData, FunAdInteractionListener funAdInteractionListener, String str) {
        this.zV = aVar;
        this.zT = iBasicCPUData;
        this.zU = funAdInteractionListener;
        this.c = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.zT.handleClick(view);
        this.zV.e();
        this.zU.onAdClicked(this.c);
    }
}
