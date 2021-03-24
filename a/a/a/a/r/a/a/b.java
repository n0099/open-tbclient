package a.a.a.a.r.a.a;

import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBasicCPUData f1086a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f1087b;

    public b(a aVar, IBasicCPUData iBasicCPUData) {
        this.f1087b = aVar;
        this.f1086a = iBasicCPUData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1086a.handleClick(view);
        this.f1087b.e();
    }
}
