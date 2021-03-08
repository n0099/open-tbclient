package a.a.a.a.r.a.a;

import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    public final /* synthetic */ a zS;
    public final /* synthetic */ IBasicCPUData zT;

    public b(a aVar, IBasicCPUData iBasicCPUData) {
        this.zS = aVar;
        this.zT = iBasicCPUData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.zT.handleClick(view);
        this.zS.e();
    }
}
